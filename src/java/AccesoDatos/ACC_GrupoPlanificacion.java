/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.grupo_planificacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author JaroMX
 */
public class ACC_GrupoPlanificacion {

    private static ACC_GrupoPlanificacion Instance = null;

    public static ACC_GrupoPlanificacion obtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_GrupoPlanificacion();
        }
        return Instance;
    }

    public grupo_planificacion CargarGrupo(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        grupo_planificacion g = new grupo_planificacion();
        String query = "SELECT grupo_planificador_p_servicio_cliente_mante, centro_planificacion_mantenimiento FROM `grupo_planificacion` WHERE id_gp = '" + id + "' ";
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                g.setId_gp(rs.getInt("id_gp"));
                g.setGrupo_planificador_p_servicio_cliente_mante(rs.getString("grupo_planificador_p_servicio_cliente_mante"));
                g.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
            }
        } catch (Exception ex) {
            System.err.println("Error en metodo CargarGrupo (ACC_GrupoPlanificacion)por:" + ex);
        }
        cnx.CerrarConexion(con);
        return g;
    }

    public LinkedList<grupo_planificacion> AvisoMatchGrpPlanif() {
        LinkedList<grupo_planificacion> planif = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM `grupo_planificacion`";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                grupo_planificacion g = new grupo_planificacion();
                g.setId_gp(rs.getInt("id_gp"));
                g.setGrupo_planificador_p_servicio_cliente_mante(rs.getString("grupo_planificador_p_servicio_cliente_mante"));
                g.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                planif.add(g);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en el  metodo AvisoMatchGrpPlanif (ACC_GrupoPlanificacion) por: " + e);
        }
        return planif;
    }

    public LinkedList<grupo_planificacion> AvisoMatchGrupoPlan(String grupop, String centrop, int limite) {
        LinkedList<grupo_planificacion> grupoplan = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = null;
        if (grupop.equals("") || grupop.equals(null)) {
            query = "SELECT * FROM grupo_planificacion LIMIT" + limite + "";
        } else if (centrop.equals("") || centrop.equals(null)) {
            query = "SELECT * FROM grupo_planificacion LIMIT" + limite + "";
        } else {
            query = "SELECT * FROM grupo_planificacion WHERE grupo_planificador_p_servicio_cliente_mante ='" + grupop + "' OR centro_planificacion_mantenimiento ='" + centrop + "' LIMIT" + limite + "";
        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                grupo_planificacion g = new grupo_planificacion();
                g.setGrupo_planificador_p_servicio_cliente_mante(rs.getString("grupo_planificador_p_servicio_cliente_mante"));
                g.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                grupoplan.add(g);
            }

        } catch (Exception e) {
            System.err.println("Error en el metodo AvisoMatchGrupoPlan (ACC_GrupoPlanificacion) por:" + e);
        }
        cnx.CerrarConexion(con);
        return grupoplan;
    }

    public int ValidarGRPP(String val,String grupop,String centrop) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.grupo_planificacion_ValidarGRPP(?,?)}";
        try {
             pst = conn.prepareCall(query);
            pst.setString(1, grupop);
            pst.setString(2, centrop);
             rs= pst.executeQuery();

            while (rs.next()) {
                String grp = rs.getString("grupo_planificador_p_servicio_cliente_mante");
                String cen = rs.getString("centro_planificacion_mantenimiento");
                if (grp.equals(val) || cen.equals(val)) {
                    con.CerrarConexion(conn);
                    return 1;
                } else {
                    con.CerrarConexion(conn);
                    return 0;
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try{
                if(conn != null)con.CerrarConexion(conn);
                if(pst != null)pst.close();
                if(rs != null)rs.close();
            }
            catch(Exception e){
                System.err.println("Error :"+e);
            }
        }
        return 0;
    }
    
    
    public LinkedList<grupo_planificacion> AvisoMatchGrupoPlanPA(String grupop, String centrop, String limite) {
        LinkedList<grupo_planificacion> grupoplan = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.grupo_planificacion_AvisoMatchGrupoPlanPA(?,?,?)}";
        
        try {
           pst = conn.prepareCall(query);
           pst.setString(1, grupop);
           pst.setString(2, centrop);
           pst.setString(3, limite);
            rs = pst.executeQuery();
            while (rs.next()) {
                grupo_planificacion g = new grupo_planificacion();
                g.setGrupo_planificador_p_servicio_cliente_mante(rs.getString("grupo_planificador_p_servicio_cliente_mante"));
                g.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                grupoplan.add(g);
            }

        } catch (Exception e) {
            System.err.println("Error en el metodo AvisoMatchGrupoPlan (ACC_GrupoPlanificacion) por:" + e);
        }
        finally{
            try{
                if(conn != null)con.CerrarConexion(conn);
                if(pst != null)pst.close();
                if(rs != null)rs.close();
            }
            catch(Exception e){
                System.err.println("Error :"+e);
            }
        }
        return grupoplan;
    }

    public static void main(String[] args) {
        System.out.println(ACC_GrupoPlanificacion.obtenerInstancia().ValidarGRPP("BAJA","","BAJA"));
    }
}
