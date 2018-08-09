/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.textos_posiciones_solped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ACC_Textos_posiciones_solped {

    private static ACC_Textos_posiciones_solped Instance = null;

    public static ACC_Textos_posiciones_solped ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Textos_posiciones_solped();
        }
        return Instance;
    }

    public ArrayList<textos_posiciones_solped> CargarTextoPosicionSAP(String solped, String pos) {
        ArrayList<textos_posiciones_solped> tes = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolpedCargarTextoPosicionSAP(?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, solped);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_posiciones_solped tsp = new textos_posiciones_solped();
                tsp.setLinea_texto(rs.getString("linea_texto"));
                tes.add(tsp);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextoPosicionSAP, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return tes;
    }
    public ArrayList<textos_posiciones_solped> CargarTextoPosicion(String solped, String pos) {
        ArrayList<textos_posiciones_solped> tes = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolped_CargarTextoPosicion(?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, solped);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_posiciones_solped tsp = new textos_posiciones_solped();
                tsp.setLinea_texto(rs.getString("linea_texto"));
                tes.add(tsp);
            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error en CargarTextoPosicion, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return tes;
    }

    public void EliminarTxtTemp(String user,String ipsf) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_EliminarTxtTemp(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2,ipsf);
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("Error en EliminarTxtTemp, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void EliminarModTexto(String pos, String user, String ipsf) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_EliminarModTxtPosicion(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pos);
            ps.setString(2, user);
            ps.setString(3, ipsf);
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("Error en EliminarModTexto, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void EliminarModModTexto(String pos, String user, String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_EliminarModTempTxtPosicion(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pos);
            ps.setString(2, user);
            ps.setString(3, folio);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en EliminarModModTexto, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void InsertartxtPosTemp(String pos, String fila, String user, String linea, String ipsf) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_InsertarTxtPosicionTemp(?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pos);
            ps.setString(2, fila);
            ps.setString(3, user);
            ps.setString(4, linea);
            ps.setString(5, ipsf);
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("Error en InsertartxtPosTemp, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public ArrayList<textos_posiciones_solped> CargarTxtPos(String user) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarTextosPos(?)}";
        ArrayList<textos_posiciones_solped> tp = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_posiciones_solped t = new textos_posiciones_solped();
                t.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                t.setIndice(rs.getString("indice"));
                t.setLinea_texto(rs.getString("linea_texto"));
                tp.add(t);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTxtPos, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return tp;
    }

    public ArrayList<textos_posiciones_solped> CargarTextoPosicionTemp(String user, String pos, String ipsf) {
        ArrayList<textos_posiciones_solped> tes = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarTextoPosicionTemp(?,?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pos);
            ps.setString(3, ipsf);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_posiciones_solped tsp = new textos_posiciones_solped();
                tsp.setLinea_texto(rs.getString("linea_texto"));
                tes.add(tsp);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextoPosicionTemp, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return tes;
    }

    public ArrayList<textos_posiciones_solped> CargarTextosPosi(String ns, String pos, String tab, String us) {
        ArrayList<textos_posiciones_solped> so = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarPosicionesTxt(?,?,?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ns);
            ps.setString(2, pos);
            ps.setString(3, tab);
            ps.setString(4, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_posiciones_solped tsp = new textos_posiciones_solped();
                tsp.setLinea_texto(rs.getString("linea_texto"));
                so.add(tsp);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextosPosi, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return so;
    }

    public ArrayList<textos_posiciones_solped> CargarTextosPosTemp(String ns, String us) {
        ArrayList<textos_posiciones_solped> so = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarPosTxtTemp(?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ns);
            ps.setString(2, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_posiciones_solped tsp = new textos_posiciones_solped();
                tsp.setFolio_sam(rs.getString("folio_sam"));
                tsp.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                tsp.setLinea_texto(rs.getString("linea_texto"));
                tsp.setIndice(rs.getString("indice"));
                tsp.setColumna_formato(rs.getString("columna_formato"));
                tsp.setLinea_texto(rs.getString("linea_texto"));
                tsp.setSolicitanteTemp(rs.getString("SolicitanteTemp"));
                so.add(tsp);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextosPosTemp, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return so;
    }

    public void InsertTxtPos(ArrayList<textos_posiciones_solped> te, String folio, String user) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_InsertarTxtPos(?,?,?,?,?)}";
        try {
            for (textos_posiciones_solped t : te) {
                ps = con.prepareStatement(sql);
                ps.setString(1, folio);
                ps.setString(2, t.getNum_posicion_solped());
                ps.setString(3, t.getIndice());
                ps.setString(4, t.getLinea_texto());
                ps.setString(5, user);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error en InsertTxtPos, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void InsertartxtTempMod(ArrayList<textos_posiciones_solped> te) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_InsertarTxtPosTempMod(?,?,?,?,?)}";
        try {
            for (textos_posiciones_solped t : te) {
                ps = con.prepareStatement(sql);
                ps.setString(1, t.getFolio_sam());
                ps.setString(2, t.getNum_posicion_solped());
                ps.setString(3, t.getIndice());
                ps.setString(4, t.getSolicitanteTemp());
                ps.setString(5, t.getLinea_texto());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error en InsertartxtTempMod, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void InsertartxtPosTempMod(String folio, String pos, String fila, String user, String linea) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_InsertarTxtPosTempMod(?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, pos);
            ps.setString(3, fila);
            ps.setString(4, user);
            ps.setString(5, linea);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en InsertartxtPosTempMod, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public ArrayList<textos_posiciones_solped> CargarTextosPos(String ns, String us) {
        ArrayList<textos_posiciones_solped> so = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.textos_posiciones_solped_modCONSULTAR(?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ns);
            ps.setString(2, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_posiciones_solped tsp = new textos_posiciones_solped();
                tsp.setFolio_sam(rs.getString("folio_sam"));
                tsp.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                tsp.setLinea_texto(rs.getString("linea_texto"));
                tsp.setIndice(rs.getString("indice"));
                tsp.setColumna_formato(rs.getString("columna_formato"));
                tsp.setLinea_texto(rs.getString("linea_texto"));
                tsp.setSolicitanteTemp(rs.getString("SolicitanteTemp"));
                so.add(tsp);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextosPos, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return so;
    }

    public boolean TextosPosDELETE(String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call  MM.textos_posiciones_solped_modDELETE(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextosPos, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public void Insertartxt(ArrayList<textos_posiciones_solped> te) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL  MM.Solped_InsertarTxtPosicionC(?,?,?,?,?)}";
        try {
            for (textos_posiciones_solped t : te) {
                ps = con.prepareStatement(sql);
                ps.setString(1, t.getFolio_sam());
                ps.setString(2, t.getNum_posicion_solped());
                ps.setString(3, t.getIndice());
                ps.setString(4, t.getSolicitanteTemp());
                ps.setString(5, t.getLinea_texto());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextosPos, ACC_Textos_posiciones_solped por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
}
