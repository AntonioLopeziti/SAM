/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.pm03_1_notificaciones;
import Entidades.pm03_2_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Pm03_2_notificaciones {
    private static ACC_Pm03_2_notificaciones Instance = null;

    public static ACC_Pm03_2_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Pm03_2_notificaciones();
        }
        return Instance;
    }   
    
     public LinkedList<pm03_2_notificaciones> TABGRNOTPM(String ord){
      LinkedList<pm03_2_notificaciones> tpn = new LinkedList<>();
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      String query="{call PM.pm03_2_notificaciones_TABGRNOTPM(?)}";
      ResultSet rs = null;
      PreparedStatement pst = null;
      try{
        
        pst = conn.prepareStatement(query);
        pst.setString(1, ord);
        rs = pst.executeQuery();
        while(rs.next()){
            pm03_2_notificaciones pmon = new pm03_2_notificaciones();
            pmon.setId_pm2(rs.getInt("id_pm2"));
            pmon.setNum_orden(rs.getString("num_orden"));
            pmon.setNum_solped(rs.getString("num_solped"));
            pmon.setNum_posicion_solped_orden(rs.getString("num_posicion_solped_orden"));
            pmon.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
            pmon.setNum_doc_compras(rs.getString("num_doc_compras"));
            pmon.setIndicador_borrado_doc_compras(rs.getString("indicador_borrado_doc_compras"));
            pmon.setTexto_breve(rs.getString("texto_breve"));
            pmon.setCentro(rs.getString("centro"));
            pmon.setAlmacen(rs.getString("almacen"));
            pmon.setNum_contrato_superior(rs.getString("num_contrato_superior"));
            pmon.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
            pmon.setCantidad_pedido(rs.getString("cantidad_pedido"));
            pmon.setUnidad_medida_pedido(rs.getString("unidad_medida_pedido"));
            pmon.setValor_neto_pedido_moneda_pedido(rs.getString("valor_neto_pedido_moneda_pedido"));
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
