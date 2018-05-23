/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Almacen;
import Entidades.almacenes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_Almacenes {

    private static ACC_Almacenes Instance = null;

    public static ACC_Almacenes ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Almacenes();
        }
        return Instance;
    }

    public ArrayList<almacenes> ConsultaMCAlmacenSolped(String alm, String des, String cent, String descampo, String ctd) {
        ArrayList<almacenes> alma = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarAlmacenes(?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, alm);
            ps.setString(2, des);
            ps.setString(3, cent);
            ps.setString(4, descampo);
            ps.setString(5, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                almacenes al = new almacenes();
                al.setId_almacen(rs.getString("id_almacen"));
                al.setNombre_alamcen(rs.getString(descampo));
                al.setCentro(rs.getString("centro"));
                alma.add(al);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCAlmacenSolped, ACC_Almacenes por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return alma;
    }

    public boolean ValidarAlmaceSP(String alm) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_ValidarAlmacen(?)}";
        boolean ban = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alm);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarAlmaceSP, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarAlmacen(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.almacenes_validar(?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, id);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarAlmacen, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }

    public ArrayList<almacenes> ConsultaAlmacenen(String idioma) {
        ArrayList<almacenes> almacen = new ArrayList<>();
        String descripcion = "descripcion_" + idioma;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.almacenes_MOM}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                almacenes a = new almacenes();
                a.setId_almacen(rs.getString("id_almacen"));
                a.setNombre_alamcen(rs.getString(descripcion));
                a.setCentro(rs.getString("centro"));
                almacen.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaAlmacenen, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return almacen;
    }

    public String verificaAlmacenDes(String id, String ctr) {
        String almDes = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.almacenes_ivend_MOM(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, ctr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("almacen_ivend");
            }
        } catch (Exception e) {
            System.err.println("Error en verificaAlmacenDes, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return almDes;
    }
    public String verificaIventWH(String id, String ctr) {
        String almDes = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.almacenes_ivend_MOM(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, ctr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("almacen_general");
            }
        } catch (Exception e) {
            System.err.println("Error en verificaAlmacenDes, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return almDes;
    }

    public ArrayList<almacenes> ConsultaAlmacenenDestino(String idioma) {
        ArrayList<almacenes> almacen = new ArrayList<>();
        String descripcion = "descripcion_" + idioma;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.almacenesIvent_MOM}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                almacenes a = new almacenes();
                a.setId_almacen(rs.getString("id_almacen"));
                a.setNombre_alamcen(rs.getString(descripcion));
                a.setCentro(rs.getString("centro"));
                a.setAlmacen_ivend(rs.getString("almacen_ivend"));
                almacen.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaAlmacenenDestino, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return almacen;
    }
   

    public LinkedList<Almacen> MatchAlmacen(String deno) {
        LinkedList<Almacen> alm = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        try {
            pst = con.prepareCall("{CALL MM.almacenes_consultaalmacenes}");
            rs = pst.executeQuery();
            while (rs.next()) {
                Almacen a = new Almacen();
                a.setId_almacen(rs.getString("id_almacen"));
                a.setDescripcion(rs.getString(deno));
                a.setCentro(rs.getString("centro"));
                alm.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error en MatchAlmacen, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return alm;
    }

    public boolean ValidaCampoAlmacen(String alm) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Almacen m = new Almacen();
        try {
            ps = con.prepareCall("{CALL MM.Almacenes_ValidarAlmacen(?)}");
            ps.setString(1, alm);
            rs = ps.executeQuery();
            while (rs.next()) {
                String almacen = rs.getString("id_almacen");
                if (alm.equals(almacen)) {
                    return true;
                } else {
                    return false;
                }
            }
       } catch (Exception e) {
            System.err.println("Error en ValidaCampoAlmacen, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }
     public ArrayList<almacenes> ConsultaAllAlmacene(String Centro) {
        ArrayList<almacenes> almacen = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.MovimientosMateriales_ConsultaalanmcneNu(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,Centro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                almacenes a = new almacenes();
                a.setId_almacen(rs.getString("id_almacen"));
                a.setNombre_alamcen(rs.getString("descripcion_ES"));
                a.setCentro(rs.getString("centro"));
                almacen.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaAlmacenenDestino, ACC_Almacenes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return almacen;
    }
}