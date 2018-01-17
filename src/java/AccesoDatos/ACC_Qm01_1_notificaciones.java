/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.qm01_1_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Qm01_1_notificaciones {

private static ACC_Qm01_1_notificaciones Instance = null;

    public static ACC_Qm01_1_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Qm01_1_notificaciones();
        }
        return Instance;
    }
    
    public LinkedList<qm01_1_notificaciones> SHOWTabQ1(String ord){
      LinkedList<qm01_1_notificaciones> q1 = new LinkedList<>();
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      String query ="{call PM.qm01_1_notificaciones_SHOWTabQ1(?)}";
      ResultSet rs = null;
      
      try{
          
          pst = conn.prepareStatement(query);
          pst.setString(1, ord);
          rs = pst.executeQuery();
          while(rs.next()){
           qm01_1_notificaciones qs = new qm01_1_notificaciones();
           qs.setId_qm1(rs.getInt("id_qm1"));
           qs.setNum_orden(rs.getString("num_orden"));
           qs.setNum_caracteristica_inspeccion(rs.getString("num_caracteristica_inspeccion"));
           qs.setTexto_breve_caracteristicas_inspeccion(rs.getString("texto_breve_caracteristicas_inspeccion"));
           qs.setUn_medida_graban_dat_cuantitativo(rs.getString("un_medida_graban_dat_cuantitativo"));
           qs.setNum_unidades_muestreo_registrada(rs.getString("num_unidades_muestreo_registrada"));
           qs.setNum_muestreo_parciales_carac(rs.getString("num_muestreo_parciales_carac"));
           q1.add(qs);
          }     
      }
       catch(Exception e){
           System.err.println("Error: "+e);
       }
      finally{
          try{
             if(conn != null){con.CerrarConexion(conn);} 
             if(pst != null){pst.close();}
             if(rs != null){rs.close();}
          }
          catch(Exception e){
              System.err.println("Error: "+e);
          }
      }
      return q1;
    }
}
