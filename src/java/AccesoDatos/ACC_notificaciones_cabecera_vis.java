/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.notificaciones_cabecera_vis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author AREConsulting
 */
public class ACC_notificaciones_cabecera_vis {
    
    private static ACC_notificaciones_cabecera_vis Instance = null;
    
    public static ACC_notificaciones_cabecera_vis ObtenerInstancia(){
        if (Instance == null){
            Instance = new ACC_notificaciones_cabecera_vis();
        }
        return Instance;
    }
    
//    public static void main (String [] args){
//        String orden = "000400000000";
//        LinkedList<notificaciones_cabecera_vis> sc = ACC_notificaciones_cabecera_vis.ObtenerInstancia().GetResumenNotificaciones(orden);
//        for(int i = 0;  i < sc.size(); i++){
//            System.out.println("1.- " + sc.get(i).getNum_operacion() + ", ");
//        }
//    }
    
    public LinkedList<notificaciones_cabecera_vis> GetResumenNotificaciones(String orden, String opera){
        LinkedList<notificaciones_cabecera_vis> cabevis = new LinkedList<>();
        Conexion con = new Conexion();
        String query = "{call PM.noti_csb_vis_GetResumenNotificacionesCrea(?,?)}";
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            pst = conn.prepareStatement(query);
            pst.setString(1, orden);
            pst.setString(2, opera);
            rs = pst.executeQuery();
            while(rs.next()){
                notificaciones_cabecera_vis vis = new notificaciones_cabecera_vis();
                vis.setId_ncv(rs.getInt("id_ncv"));
                vis.setNum_orden(rs.getString("num_orden"));
                vis.setIndicador_cabecera(rs.getString("indicador_cabecera"));
                vis.setNum_operacion(rs.getString("num_operacion"));
                vis.setSuboperacion(rs.getString("suboperacion"));
                vis.setClase_capacidad(rs.getString("clase_capacidad"));
                vis.setContador_notificacion(rs.getString("contador_notificacion"));
                vis.setNotificacion_parcial_final(rs.getString("notificacion_parcial_final"));
                vis.setIndicador_doc_anulado(rs.getString("indicador_doc_anulado"));
                vis.setFecha_contabilizacion(rs.getString("fecha_contabilizacion"));
                vis.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                vis.setTrabajo_real(rs.getString("trabajo_real"));
                vis.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                vis.setClase_actividad_notificacion(rs.getString("clase_actividad_notificacion"));
                vis.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                vis.setCl_reg_notificacion(rs.getString("cl_reg_notificacion"));
                vis.setInicio_real_ejecucion_fecha(rs.getString("inicio_real_ejecucion_fecha"));
                vis.setFin_real_ejecucion_fecha(rs.getString("fin_real_ejecucion_fecha"));
                vis.setTrabajo_pronosticado_real_resto(rs.getString("trabajo_pronosticado_real_resto"));
                vis.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                vis.setInicio_mas_temprano_programado_ejecucion_fecha(rs.getString("inicio_mas_temprano_programado_ejecucion_fecha"));
                vis.setInicio_programado_mas_tardio_efectua_fecha(rs.getString("inicio_programado_mas_tardio_efectua_fecha"));
                vis.setFin_mas_temprano_programado_ejecucion_fecha(rs.getString("fin_mas_temprano_programado_ejecucion_fecha"));
                vis.setFin_mas_tardio_programado_ejecucion_fecha(rs.getString("fin_mas_tardio_programado_ejecucion_fecha"));
                vis.setId_objeto(rs.getString("id_objeto"));
                cabevis.add(vis);
            }
        }
        catch(Exception ex){
            System.err.println("Error de Resumen: " + ex);
        }
        finally{
                  try{
                    if(conn != null)con.CerrarConexion(conn);;
                    if(pst != null)pst.close();
                    if(rs != null)rs.close();
                  }catch(Exception a){
                      System.err.println("Error inesperado al cerrar conexiones");
                  }
        }
        return cabevis;
    }
      public notificaciones_cabecera_vis ObtenerDatos(String orden){
        notificaciones_cabecera_vis vis = new notificaciones_cabecera_vis();
        Conexion con = new Conexion();
        String query = "{call PM.notif_cab_vis_ObtenerDatos(?)}";
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            pst = conn.prepareStatement(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while(rs.next()){
                vis.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
            }
        }
        catch(Exception ex){
            System.err.println("Error de Resumen: " + ex);
        }
        finally{
                  try{
                    if(conn != null)con.CerrarConexion(conn);;
                    if(pst != null)pst.close();
                    if(rs != null)rs.close();
                  }catch(Exception a){
                      System.err.println("Error inesperado al cerrar conexiones");
                  }
        }
        return vis;
    }
    
    
    
}
