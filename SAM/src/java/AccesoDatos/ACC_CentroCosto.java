/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.CeCos;
import Entidades.centro_coste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ACC_CentroCosto {

    private static ACC_CentroCosto Instance = null;

    public static ACC_CentroCosto ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_CentroCosto();
        }
        return Instance;
    }


    //Muestra Match de Centro Coste
    public LinkedList<centro_coste> ConsultaMatchMMCenCoste(String lim, String cen, String soci, String des, String deno) {
        LinkedList<centro_coste> cencos = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.CentroCosto_MatchCC (?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cen);
            ps.setString(3, soci);
            ps.setString(4, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                centro_coste c = new centro_coste();
                c.setCentro_coste(rs.getString("centro_coste"));
                c.setSociedad_co(rs.getString("sociedad_co"));
                c.setDescripcion(rs.getString(deno));
                cencos.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error de match centro coste: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Eror al cerrar conexion: " + e);
            }
        }
        return cencos;
    }

    //Valida el Campo Centro Coste
    public boolean ValidaMMCentroCoste(String cc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.CentroCosto_ValidaCenCos(?)}");
            ps.setString(1, cc);
            rs = ps.executeQuery();
            while (rs.next()) {
                String cen = rs.getString("centro_coste");
                if (cc.equals(cen)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error al calidar centro coste: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return false;
    }


    public ArrayList<CeCos> ConsultaMCCentroCoste(String ce, String des, String soc, int ctd, String us) {
        ArrayList<CeCos> ceco = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarCentroCosto(?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ce);
            ps.setString(2, des);
            ps.setString(3, soc);
            ps.setInt(4, ctd);
            ps.setString(5, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                CeCos c = new CeCos();
                c.setCentroCos(rs.getString("centro_coste"));
                c.setDenominacion(rs.getString("denominacion_centro_coste"));
                c.setSociedad(rs.getString("sociedad"));
                ceco.add(c);
            }
        } catch (Exception e) {
            System.err.print("Erro en ConsultaMCCentroCoste por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ceco;
    }

    public boolean ValidarCCosto(String cc, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String sql = "{CALL MM.Solped_ValidarCentroCosto(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cc);
            ps.setString(2, us);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidaCCosto por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }


    public LinkedList<centro_coste> ConsultaCeCO(String ceco, String soc, String text, String Lang) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<centro_coste> cco = new LinkedList<>();
        String query = "select * from centrocosto ";
        if (!ceco.equals("")) {
            query += "where centro_coste='" + ceco + "' ";
        }
        if (!ceco.equals("") && !soc.equals("")) {
            query += "and sociedad_co='" + soc + "' ";
        }
        if (ceco.equals("") && !soc.equals("")) {
            query += "where sociedad_co='" + soc + "' ";
        }
        if ((!ceco.equals("") || !soc.equals("")) && !text.equals("")) {
            query += "and descripcion_" + Lang + "='" + text + "' ";
        }
        if (ceco.equals("") && soc.equals("") && !text.equals("")) {
            query += "where descripcion_" + Lang + "='" + text + "' ";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                centro_coste c = new centro_coste();
                c.setSociedad_co(rs.getString("sociedad_co"));
                c.setCentro_coste(rs.getString("centro_coste"));
                c.setDescripcion(rs.getString("descripcion_" + Lang));
                cco.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCentroCosto ACC_CentroCosto por: " + e);
        }
        cnx.CerrarConexion(con);
        return cco;
    }

    public ArrayList<CeCos> ConsultaCeCOS(String clc, String ceco, String text, String tex2) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<CeCos> cco = new ArrayList<>();
        String query = "{call MM.cecos_match_MOM(?,?,?,?)}";
       
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, clc);
            sp.setString(2, ceco);
            sp.setString(3, text);
            sp.setString(4, tex2);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                CeCos c = new CeCos();
                c.setCentroCos(rs.getString("centro_coste"));
                c.setDenominacion(rs.getString("denominacion_centro_coste"));
                c.setClaseCoste(rs.getString("clase_coste"));
                c.setDescripcion(rs.getString("descripcion_clase_coste"));
                cco.add(c);
            }  
        } catch (Exception e) {

            System.err.println("Error por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return cco;
    }

    public int ConsultaCeCos(String cecos) {
        int rt = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        
        String query = "{call MM.consultaCecos_MOM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cecos);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rt = 1;
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            rt = 0;
        }
        cnx.CerrarConexion(con);
        return rt;
    }

    public LinkedList<CeCos> ConsultaCentroCosto(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<CeCos> cco = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CeCos c = new CeCos();
                c.setSociedad(rs.getString("sociedad"));
                c.setCentroCos(rs.getString("centro_coste"));
                c.setDenominacion(rs.getString("denominacion_centro_coste"));
                cco.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCentroCosto ACC_CentroCosto por: " + e);
        }
        cnx.CerrarConexion(con);
        return cco;
    }

    public int AlmacenDestino(String almacen, String centro, String lote, String material) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
//        query = "select * from inventarios where almacen = '" + almacen + "' and centro='" + centro + "' and lote = '" + lote + "' and material='" + material + "'";
        String query = "{call MM.materiales_almacenValida_MOM(?,?,?)}";
        
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, almacen);
            sp.setString(2, centro);
            sp.setString(3, material);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                return 1;
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return 0;
    }

    public LinkedList<centro_coste> ConsultaCentroCosto(String query, String Des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<centro_coste> cco = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                centro_coste c = new centro_coste();
                c.setSociedad_co(rs.getString("sociedad_co"));
                c.setCentro_coste(rs.getString("centro_coste"));
                c.setDescripcion(rs.getString(Des));
                cco.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCentroCosto ACC_CentroCosto por: " + e);
        }
        cnx.CerrarConexion(con);
        return cco;
    }
}
