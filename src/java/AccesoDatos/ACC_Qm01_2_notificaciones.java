/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.qm01_2_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Qm01_2_notificaciones {
    
    private static ACC_Qm01_2_notificaciones Instance = null;

    public static ACC_Qm01_2_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Qm01_2_notificaciones();
        }
        return Instance;
    } 
    
 public LinkedList<qm01_2_notificaciones> SHOWTabQ2(String ord){
      LinkedList<qm01_2_notificaciones> q2 = new LinkedList<>();
      String query ="{call PM.qm01_2_notificaciones_SHOWTabQ2(?)}";
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      ResultSet rs = null;
      try{
          pst = conn.prepareStatement(query);
          pst.setString(1, ord);
          rs = pst.executeQuery();
          while(rs.next()){
           qm01_2_notificaciones qs = new qm01_2_notificaciones();
           qs.setId_qm2(rs.getInt("id_qm2"));
           qs.setNum_orden(rs.getString("num_orden"));
           qs.setNum_caracteristicas_inspeccion(rs.getString("num_caracteristicas_inspeccion"));
           qs.setNum_lote_inspeccion(rs.getString("num_lote_inspeccion"));
           qs.setTexto_breve_caracteristicas_inspeccion(rs.getString("texto_breve_caracteristicas_inspeccion"));
           qs.setDescripcion_breve_conjunto_seleccion(rs.getString("descripcion_breve_conjunto_seleccion"));
           qs.setEntrada_catalogo_conjunto_seleccion(rs.getString("entrada_catalogo_conjunto_seleccion"));
           qs.setNum_unidades_muestreo_defectuosas(rs.getString("num_unidades_muestreo_defectuosas"));
           qs.setValor_original_anterior_tratamiento_entradas(rs.getString("valor_original_anterior_tratamiento_entradas"));
           qs.setValor_resultado_inspeccion(rs.getString("valor_resultado_inspeccion"));
           qs.setCodigo(rs.getString("codigo"));  
           qs.setUn_medida_graba_cuantitativos(rs.getString("un_medida_graba_cuantitativos"));
           qs.setTexto_breve(rs.getString("texto_breve"));
           qs.setEntrada_catalogo_conjunto_seleccion(rs.getString("entrada_catalogo_conjunto_seleccion"));
           qs.setCatalogo(rs.getString("catalogo"));
           qs.setGrupo_codigos(rs.getString("grupo_codigos"));
           qs.setTipo_caracteristicas(rs.getString("tipo_caracteristicas"));
           q2.add(qs);
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
      return q2;
    }
}
