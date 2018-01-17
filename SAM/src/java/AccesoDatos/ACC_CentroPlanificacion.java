package AccesoDatos;

import Entidades.centroPlanificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_CentroPlanificacion {

    private static ACC_CentroPlanificacion Instance = null;

    public static ACC_CentroPlanificacion ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_CentroPlanificacion();
        }
        return Instance;
    }

    public ArrayList ConsultaMatchCentroPOrd() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList cents = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProcOrg = "{call PM.Ordenes_ConsultarCentroPlanificacion}";
        try {
            ps = con.prepareStatement(ProcOrg);
            rs = ps.executeQuery();
            while (rs.next()) {
                centroPlanificacion c = new centroPlanificacion();
                c.setId_cp(rs.getInt("id_cp"));
                c.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                cents.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchCentroP por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cents;
    }

    public String ConsultarCentroActual() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ConsultarCentro}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            cnx.CerrarConexion(con);
            while (rs.next()) {
                check = rs.getString("centro");
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarCentroActual" + e);
        }
        return check;
    }

    public int ValidarCentroPlani(String centP) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT centro_planificacion_mantenimiento FROM centro_planificacion WHERE centro_planificacion_mantenimiento='" + centP + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String ub = rs.getString("centro_planificacion_mantenimiento");
                if (ub.equals(centP)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultarCentros (ACC_Centro) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
    //Centro Planificacion Ordenes PP
    public ArrayList ConsultaMatchCentroPOrdPP() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList cents = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProcOrg = "{call PP.Ordenes_ConsultarCentroPlanificacionPP}";
        try {
            ps = con.prepareStatement(ProcOrg);
            rs = ps.executeQuery();
            while (rs.next()) {
                centroPlanificacion c = new centroPlanificacion();
                c.setId_cp(rs.getInt("id_cp"));
                c.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                cents.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchCentroP por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cents;
    }
    public String ConsultarCentroActualPP() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PP.Ordenes_ConsultarCentroPP}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            cnx.CerrarConexion(con);
            while (rs.next()) {
                check = rs.getString("centro");
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarCentroActual" + e);
        }
        return check;
    }
}
