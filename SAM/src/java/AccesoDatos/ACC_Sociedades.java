/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.sociedades;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Developer-Antonio
 */
public class ACC_Sociedades {

    private static ACC_Sociedades instance = null;

    public static ACC_Sociedades ObtenerIntancia() {
        if (instance == null) {
            instance = new ACC_Sociedades();
        }
        return instance;
    }

    public LinkedList<sociedades> MatchObtenerSociedadesClientes(String query, String desc) {
        LinkedList<sociedades> soc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
 
        try {
            st = con.createStatement();

            rs = st.executeQuery(query);
            while (rs.next()) {
                sociedades s = new sociedades();
                s.setSociedad(rs.getString("sociedad"));
                s.setDeninacion(rs.getString(desc));
                s.setPoblacion(rs.getString("poblacion"));
                s.setMoneda(rs.getString("clave_moneda"));
                soc.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo MatchObtenerSociedadesCliente(ACC_Sociedades) por: " + e);
        }
        cnx.CerrarConexion(con);
        return soc;
    }
}
