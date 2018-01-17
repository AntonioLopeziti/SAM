package AccesoDatos;

import Entidades.control_operacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_ControlOperacion {

    private static ACC_ControlOperacion instance = null;

    public static ACC_ControlOperacion ObtenerInstancia() {
        if (instance == null) {
            instance = new ACC_ControlOperacion();
        }
        return instance;
    }

    public LinkedList<control_operacion> ConsultarClaveControl(String query, String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<control_operacion> clas = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                control_operacion cl = new control_operacion();
                cl.setClave_control(rs.getString("clave_control"));
                cl.setDescripcion(rs.getString(des));
                clas.add(cl);
            }
        } catch (Exception e) {
            System.err.println("Error en meotodo ConsultarClase Orden(ACC_ClaseOrden) por: " + e);
        }
        cnx.CerrarConexion(con);
        return clas;
    }
     public ArrayList ConsultarClaveControlMatchTabOpe(String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList ctrls = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        control_operacion cl;
        String SP = "{CALL PM.Ordenes_ControlOperacion(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl = new control_operacion();
                cl.setClave_control(rs.getString("clave_control"));
                cl.setDescripcion(rs.getString(des));
                ctrls.add(cl);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarClaveControlMatchTabOpe(ACC_PuestoTrabajo por: )" + ex);
        }finally {
            cnx.CerrarConexion(con);
        }
        return ctrls;
    }

    public int ValidarClaveControl(String clOr) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT clave_control FROM control_operacion WHERE clave_control='" + clOr + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String cl = rs.getString("clave_control");
                if (cl.equals(clOr)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarClaseOrden (ACC_ClaseOrden) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
}
