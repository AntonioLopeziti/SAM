/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Qm_Cabetodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Qm_cabecera {

    private static ACC_Qm_cabecera Instance = null;

    public static ACC_Qm_cabecera ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Qm_cabecera();
        }
        return Instance;
    }

    public Qm_Cabetodo SHOWTabQ1CAB(String ord) {
        Qm_Cabetodo qs = new Qm_Cabetodo();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PM.qm_cabecera_ObteCabQM1(?)}";
        ResultSet rs = null;

        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {

                qs.setId_qc(rs.getInt("id_qc"));
                qs.setNum_orden(rs.getString("num_orden"));
                qs.setNum_lote_inspeccion(rs.getString("num_lote_inspeccion"));
                qs.setTexto_breve(rs.getString("texto_breve"));
                qs.setFecha_creacion_lote(rs.getString("fecha_creacion_lote"));
                qs.setHora_creacion_lote(rs.getString("hora_creacion_lote"));
                qs.setFecha_modificacion_registro_datos(rs.getString("fecha_modificacion_registro_datos"));
                qs.setHora_modificacion_lote(rs.getString("hora_modificacion_lote"));
                qs.setCentro(rs.getString("centro"));
                qs.setCreado_registro_datos(rs.getString("creado_registro_datos"));
                qs.setUltimo_modificador_registro_datos(rs.getString("ultimo_modificador_registro_datos"));

            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return qs;
    }

    public boolean INSERTcabecera_QM_crea(String folsa, String lotins, String feh, String hoh, String ord, String ope, String txtbr, String cent, String creapor, String fecc, String horc, String ultmod, String fecm, String horm, String usu) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        String query = "{call PM.cabecera_lotes_inspeccion_notificaciones_creaINSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folsa);
            pst.setString(2, lotins);
            pst.setString(3, feh);
            pst.setString(4, hoh);
            pst.setString(5, ord);
            pst.setString(6, ope);
            pst.setString(7, txtbr);
            pst.setString(8, cent);
            pst.setString(9, creapor);
            pst.setString(10, fecc);
            pst.setString(11, horc);
            pst.setString(12, ultmod);
            pst.setString(13, fecm);
            pst.setString(14, horm);
            pst.setString(15, usu);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public boolean INSERTPOS_QM_crea(String folsa, String lotins, String nucain, String feh, String hoh, String texbre, String destex, String Entraca, String numdef1, String resu1, String valo1, String codi1, String unimed1, String note1, String cata1) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        String query = "{call PM.posiciones_lotes_inspeccion_notificaciones_creaINSERTAR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folsa);
            pst.setString(2, lotins);
            pst.setString(3, nucain);
            pst.setString(4, feh);
            pst.setString(5, hoh);
            pst.setString(6, texbre);
            pst.setString(7, destex);
            pst.setString(8, Entraca);
            pst.setString(9, numdef1);
            pst.setString(10, resu1);
            pst.setString(11, valo1);
            pst.setString(12, codi1);
            pst.setString(13, unimed1);
            pst.setString(14, note1);
            pst.setString(15, cata1);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public ArrayList<Qm_Cabetodo> CargarLotes() {
        ArrayList<Qm_Cabetodo> lis = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call QM.ListaLoteInpecion_CargarLotesInp}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Qm_Cabetodo q = new Qm_Cabetodo();
                q.setNum_lote_inspeccion(rs.getString("num_lote_inspeccion"));
                lis.add(q);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lis;
    }

    public ArrayList<Qm_Cabetodo> CargarUsuarios() {
        ArrayList<Qm_Cabetodo> lis = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call QM.ListaLoteInspeccion_CargarUsuarios}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Qm_Cabetodo q = new Qm_Cabetodo();
                q.setCreado_registro_datos(rs.getString("creado_registro_datos"));
                lis.add(q);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lis;
    }

    public int ValidarLote(String lote) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call QM.ListaLoteInspeccion_ValidarLote(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lote);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarUsuario(String usu) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call QM.ListaLoteInspeccion_ValidarUsuario(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usu);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<Qm_Cabetodo> ValidarQueryLoteInspeccion(String lote1, String lote2, String usuario) {
        ArrayList<Qm_Cabetodo> lis = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call QM.ListaLoteInspecion_ExecQueryLote(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lote1);
            ps.setString(2, lote2);
            ps.setString(3, usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                Qm_Cabetodo q = new Qm_Cabetodo();
                q.setNum_lote_inspeccion(rs.getString("num_lote_inspeccion"));
                q.setNum_orden(rs.getString("num_orden"));
                q.setCentro(rs.getString("centro"));
                q.setCreado_registro_datos(rs.getString("creado_registro_datos"));
                q.setHora_creacion_lote(rs.getString("hora_creacion_lote"));
                q.setFecha_creacion_lote(rs.getString("fecha_creacion_lote"));
                lis.add(q);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lis;
    }

    public String SemaforoLote(String Lote) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call QM.ListaLoteInspecion_SemaforoLote(?)}";
        String icon = "advertencia";
        String color = "";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Lote);
            rs = ps.executeQuery();
            while (rs.next()) {
                color = rs.getNString(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        if (color.equals("V")) {
            icon = "@08QStatus@";
        }
        if (color.equals("A")) {
            icon = "@09QStatus@";
        }
        if (color.equals("R")) {
            icon = "@0AQStatus@";
        }

        return icon;
    }
}
