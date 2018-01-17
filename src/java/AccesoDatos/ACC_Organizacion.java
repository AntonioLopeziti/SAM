/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.organizacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Jonathan Lopez
 */
public class ACC_Organizacion {
   
    private static ACC_Organizacion Instance = null;
    
    public static ACC_Organizacion ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Organizacion();
        }
        return Instance;
    }
    
    public LinkedList<organizacion> ConsultaOrganizaciones() throws SQLException {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        LinkedList<organizacion> orga = new LinkedList<>();
        String query = "SELECT * FROM organizacion_ventas";
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            organizacion or = new organizacion();
            or.setOrganizacion(rs.getString("orga_ventas"));
            or.setDescripcion(rs.getString("denominacion_orga"));
            orga.add(or);
        }
        cnx.CerrarConexion(con);
        return orga;
    }
    
    public LinkedList<organizacion> ConsultarOrganizacion(String id) throws SQLException {
        LinkedList<organizacion> org = new LinkedList<organizacion>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM organizacion_ventas orga_ventas LIKE '" + id + "%' limit 25 ";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                organizacion or = new organizacion();
                or.setOrganizacion(rs.getString("orga_ventas"));
                or.setDescripcion(rs.getString("denominacion_orga"));
                org.add(or);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return org;
    }
    
    public organizacion ConsultaOrganizacion(String id) throws SQLException {
        organizacion or = new organizacion();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM organizacion_ventas WHERE orga_ventas'" + id + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                or.setOrganizacion(rs.getString("orga_ventas"));
                or.setDescripcion(rs.getString("denominacion_orga"));
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return or;
    }
    
    public LinkedList<organizacion> ConsultaMatchOVVisualCliente(String query) {
        LinkedList<organizacion> org = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement stc;
        ResultSet rsc;
        try {
            stc = con.createStatement();
            rsc = stc.executeQuery(query);
            while (rsc.next()) {
                organizacion o = new organizacion();
                o.setOrganizacion(rsc.getString("organizacion_ventas"));
                o.setDescripcion(rsc.getString("denominacion"));
                org.add(o);
            }
             cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en el meotodo ConsultaMatchOVVisualCliente (ACC_Organizacion) por: " + e);
        }       
        return org;
    }
    
    public static void main(String[] args){
     ACC_Organizacion ao = new ACC_Organizacion();
     String queryOrg = "SELECT * FROM organizacion_ventas LIMIT 100";
     System.out.println(ao.ConsultaMatchOVVisualCliente(queryOrg));
    }
    
}
