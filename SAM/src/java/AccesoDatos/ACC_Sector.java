/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.util.LinkedList;
import Entidades.Sector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Developer-Antonio
 */
public class ACC_Sector {
    
    private static ACC_Sector Instance = null;
    
    public static ACC_Sector ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Sector();
        }
        return Instance;
    }
    
    public LinkedList<Sector> MatchObtenerSectorCliente(String query, String Des) {
        LinkedList<Sector> sec = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
         try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Sector s = new Sector();
                s.setSector(rs.getString("sector"));
                s.setDescripcion(rs.getString(Des));
                sec.add(s);
            }            
        } catch (Exception e) {
            System.err.println("Error en metodo MatchObtenerSectorCliente(ACC_Sector) por: " + e);
        }
        cnx.CerrarConexion(con);
        return sec;
    }
    
}
