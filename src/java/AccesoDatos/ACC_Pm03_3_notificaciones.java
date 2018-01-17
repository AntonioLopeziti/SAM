/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoDatos.Conexion;
import Entidades.pm03_3_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Pm03_3_notificaciones {
    private static ACC_Pm03_3_notificaciones Instance = null;

    public static ACC_Pm03_3_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Pm03_3_notificaciones();
        }
        return Instance;
    } 
    
    public LinkedList<pm03_3_notificaciones> TABGRNOTPM(String ord){
      LinkedList<pm03_3_notificaciones> tpn = new LinkedList<>();
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      ResultSet rs = null;
      PreparedStatement pst = null;
      String query="{call PM.pm03_3_notificaciones_TABGRNOTPM(?)}";
      try{

        pst = conn.prepareStatement(query);
        pst.setString(1, ord);
        rs = pst.executeQuery();
        while(rs.next()){
            pm03_3_notificaciones pmon = new pm03_3_notificaciones();
            pmon.setId_pm3(rs.getInt("id_pm3"));
            pmon.setNum_orden(rs.getString("num_orden"));
            pmon.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
            pmon.setNum_doc_compras(rs.getString("num_doc_compras"));
            pmon.setEjercicio_doc_material(rs.getString("ejercicio_doc_material"));
            pmon.setNum_doc_material(rs.getString("num_doc_material"));
            pmon.setPosicion_doc_material(rs.getString("posicion_doc_material"));
            pmon.setTipo_historial_pedido(rs.getString("tipo_historial_pedido"));
            pmon.setClase_movimiento_gestion_stock(rs.getString("clase_movimiento_gestion_stock"));
            pmon.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
            pmon.setCantidad(rs.getString("cantidad"));
            pmon.setImporte_moneda_doc(rs.getString("importe_moneda_doc"));
            pmon.setClave_moneda(rs.getString("clave_moneda"));
            pmon.setResponsable_anadio_objeto(rs.getString("responsable_anadio_objeto"));
            tpn.add(pmon);
        }
         }
       catch(Exception e){
           System.err.println("Error: "+e);
       }
      finally{
          try{
              if(conn != null){ con.CerrarConexion(conn);}
              if(pst != null){pst.close();}
              if(rs != null){rs.close();}
          }
          catch(Exception e){
              System.err.println("Error: "+e);
          }
      }
      return tpn;
    }
    
    
        public boolean PONActual(String ind ,String orden, String ope){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PM.pm_operaciones_notificaciones_ACTUAL(?,?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst.setString(1, ind);
           pst .setString(2, orden);
           pst.setString(3, ope);
           can = pst.executeUpdate();
           if(can > 0){
               return true;
           }
        }
        catch(Exception e){
            System.err.println("Error: "+e);
        }
        finally{
            try{
            if(conn != null){con.CerrarConexion(conn);}
            if(pst != null){pst.close();}
            }
            catch(Exception e){
                System.err.println("Error: "+e);
            }
        }
        return false;
    }
        public boolean PONACACNOT(String dutr ,String nuOrd){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PM.pm_operaciones_notificaciones_ACACNOT(?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst.setString(1, dutr);
           pst .setString(2, nuOrd);
           can = pst.executeUpdate();
           if(can > 0){
               return true;
           }
        }
        catch(Exception e){
            System.err.println("Error: "+e);
        }
        finally{
            try{
            if(conn != null){con.CerrarConexion(conn);}
            if(pst != null){pst.close();}
            }
            catch(Exception e){
                System.err.println("Error: "+e);
            }
        }
        return false;
    }
    
}
