/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.pm03_1_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Pm03_1_notificaciones {
   private static ACC_Pm03_1_notificaciones Instance = null;

    public static ACC_Pm03_1_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Pm03_1_notificaciones();
        }
        return Instance;
    }   
    
    public LinkedList<pm03_1_notificaciones> TABGRNOTPM(String ord){
      LinkedList<pm03_1_notificaciones> tpn = new LinkedList<>();
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      ResultSet rs = null;
      PreparedStatement pst = null;
      String query="{call PM.pm03_1_notificaciones_TABGRNOTPM(?)}";
      try{
        pst = conn.prepareStatement(query);
        pst.setString(1, ord);
        rs = pst.executeQuery();
        while(rs.next()){
            pm03_1_notificaciones pmon = new pm03_1_notificaciones();
            pmon.setId_pm1(rs.getInt("id_pm1"));
            pmon.setNum_orden(rs.getString("num_orden"));
            pmon.setNum_linea(rs.getString("num_linea"));
            pmon.setNum_servicio(rs.getString("num_servicio"));
            pmon.setTexto_breve(rs.getString("texto_breve"));
            pmon.setCantidad_sign(rs.getString("cantidad_signo"));
            pmon.setUnidad_medida_base(rs.getString("unidad_medida_base"));
            pmon.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
            pmon.setCatidad_base(rs.getString("catidad_base"));
            pmon.setGrupo_articulos(rs.getString("grupo_articulos"));
            pmon.setClase_coste(rs.getString("clase_coste"));
            tpn.add(pmon);
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
      return tpn;
    }
    
}
