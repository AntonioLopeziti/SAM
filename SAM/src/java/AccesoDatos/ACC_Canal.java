/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.canal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Jonathan Lopez
 */
public class ACC_Canal {

    Conexion cnx = new Conexion();
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_Canal Instance = null;

    public static ACC_Canal ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Canal();
        }
        return Instance;
    }

    public LinkedList<canal> ConsultaCanales() throws SQLException {
        LinkedList<canal> cana = new LinkedList<>();
        query = "SELECT * FROM canal_distribucion";
        st = cnx.ObtenerConexion().createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            canal ca = new canal();
            ca.setCanal(rs.getString("canal_distribucion"));
            ca.setDescripcion(rs.getString("denominacion_canal"));
            cana.add(ca);
        }
        cnx.CerrarConexion(cnx.ObtenerConexion());
        return cana;
    }

    public LinkedList<canal> ConsultarCanal(String id) throws SQLException {
        LinkedList<canal> can = new LinkedList<canal>();
        query = "SELECT * FROM canal_distribucion canal_distribucion LIKE '" + id + "%' limit 25 ";
        try {
            st = cnx.ObtenerConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                canal ca = new canal();
                ca.setCanal(rs.getString("canal_distribucion"));
                ca.setDescripcion(rs.getString("denominacion_canal"));
                can.add(ca);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        cnx.CerrarConexion(cnx.ObtenerConexion());
        return can;
    }

    public canal ConsultaCanal(String id) throws SQLException {
        canal ca = new canal();
        query = "SELECT * FROM canal_distribucion WHERE canal_distribucion'" + id + "'";
        try {
            st = cnx.ObtenerConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ca.setCanal(rs.getString("canal_distribucion"));
                ca.setDescripcion(rs.getString("denominacion_canal"));
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        cnx.CerrarConexion(cnx.ObtenerConexion());
        return ca;
    }

    public LinkedList<canal> ConsultaMatchCanalCliente(String querycanal, String denom) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement stc;
        ResultSet rsc;
        LinkedList<canal> can = new LinkedList<>();
          try {
            stc = con.createStatement();
            rsc = stc.executeQuery(querycanal);
            while (rsc.next()) {
                canal ca = new canal();
                ca.setCanal(rsc.getString("canal_distribucion"));
                ca.setDescripcion(rsc.getString(denom));
                can.add(ca);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchCanalCliente (ACC_Canal) por" + e);
        }
        cnx.CerrarConexion(con);
        return can;
    }
}
