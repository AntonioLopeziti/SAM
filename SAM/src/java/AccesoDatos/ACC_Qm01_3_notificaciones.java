/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.qm01_3_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Qm01_3_notificaciones {
    
    private static ACC_Qm01_3_notificaciones Instance = null;

    public static ACC_Qm01_3_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Qm01_3_notificaciones();
        }
        return Instance;
    } 
    
    
    public LinkedList<qm01_3_notificaciones> SHOWTabQ3(String ord){
      LinkedList<qm01_3_notificaciones> q3 = new LinkedList<>();
      String query ="{call PM.qm01_3_notificaciones_SHOWTabQ3(?)}";
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      ResultSet rs = null;
      try{
          pst = conn.prepareStatement(query);
          pst.setString(1, ord);
          rs = pst.executeQuery();
          while(rs.next()){
           qm01_3_notificaciones qs = new qm01_3_notificaciones();
           
           qs.setId_qm3(rs.getInt("id_qm3"));
           qs.setNum_orden(rs.getString("num_orden"));
           qs.setNum_caracteristicas_inspeccion(rs.getString("num_caracteristicas_inspeccion"));
           qs.setNum_resultado_detallado(rs.getString("num_resultado_detallado"));
           qs.setTexto_breve_caracteristicas_inspeccion(rs.getString("texto_breve_caracteristicas_inspeccion"));
           qs.setEntrada_catalogo_conjunto_seleccion(rs.getString("entrada_catalogo_conjunto_seleccion"));
           qs.setCreador_registro_datos(rs.getString("creador_registro_datos"));
           qs.setValor_original_anterior_tratamiento_entradas(rs.getString("valor_original_anterior_tratamiento_entradas"));
           qs.setTexto_breve(rs.getString("texto_breve"));
           qs.setEntrada_catalogo_conjunto_seleccion(rs.getString("entrada_catalogo_conjunto_seleccion"));
           qs.setCodigo(rs.getString("codigo"));
           qs.setNum_lote_inspeccion(rs.getString("num_lote_inspeccion"));
           qs.setNum_unidades_muestreo_registradas(rs.getString("num_unidades_muestreo_registradas"));
           qs.setIcono_valoracion_carac_muestre_parcial(rs.getString("icono_valoracion_carac_muestre_parcial"));
           qs.setDescripcion_breve_conjunto_seleccion(rs.getString("descripcion_breve_conjunto_seleccion"));
           q3.add(qs);
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
      return q3;
    }
}
