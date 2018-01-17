/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.notificaciones_sam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Notificaciones_sam {
    
    private static ACC_Notificaciones_sam Instance = null;
    
     public static ACC_Notificaciones_sam ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Notificaciones_sam();
        }
        return Instance;
    } 
     
     
     public LinkedList<notificaciones_sam> ConNOSAM(String ord, String ope){
      LinkedList <notificaciones_sam> ns = new LinkedList<>();
      String query = "SELECT * FROM notificaciones_sam where num_orden='"+ord+"' and num_operacion='"+ope+"' ";
      Conexion con = new Conexion();
      try{
          Connection conn = con.ObtenerConexion();
          Statement st;
          ResultSet rs;
          st = conn.createStatement();
          rs = st.executeQuery(query);
          while(rs.next()){
              notificaciones_sam nos = new notificaciones_sam();
              nos.setNum_orden(rs.getString("num_orden"));
              nos.setNum_operacion(rs.getString("num_operacion"));
              ns.add(nos);
          }
          con.CerrarConexion(conn);
         
     }
      catch(Exception e){
           System.err.println("Error: "+e);
              }
      return ns;
     }
}
