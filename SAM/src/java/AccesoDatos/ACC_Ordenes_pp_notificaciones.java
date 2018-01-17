/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.notificaciones_cabecera_vis;
import Entidades.ordenes_pp_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Jhonatan
 */
public class ACC_Ordenes_pp_notificaciones {
    
    private static ACC_Ordenes_pp_notificaciones Instance = null;

    public static ACC_Ordenes_pp_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Ordenes_pp_notificaciones();
        }
        return Instance;
    }
    
    public LinkedList<ordenes_pp_notificaciones> ObtenOrdenNOTIPP(String cann, String orde, String deso, String plao) {
        LinkedList<ordenes_pp_notificaciones> orn = new LinkedList<>();
        String query = "{call PP.cab_ord_cr_TodosMatchNotiPP(?,?,?,?)}";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
            
            pst = conn.prepareStatement(query);
            pst.setString(1, cann);
            pst.setString(2, orde);
            pst.setString(3, deso);
            pst.setString(4, plao);
            rs = pst.executeQuery();
            while (rs.next()) {
                ordenes_pp_notificaciones or = new ordenes_pp_notificaciones();
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setTexto_breve(rs.getString("texto_breve"));
                orn.add(or);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try{
            if(conn != null){con.CerrarConexion(conn);}
            if(rs != null){rs.close();}
            if(pst != null){pst.close();}
            }
           catch(Exception e){
               System.err.println("Error: "+e);
           } 
        }
        return orn;
    }
    
    public boolean COMPORdenNOTPP(String ord) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;   
        String query = "{call PP.ord_pp_noti_COMPORdenNOTPP(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                String orden = rs.getString("num_orden");
                if (ord.equals(orden)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try{
            if(conn != null){con.CerrarConexion(conn);}
            if(rs != null){rs.close();}
            if(pst != null){pst.close();}
            }
           catch(Exception e){
               System.err.println("Error: "+e);
           } 
        }
        return false;
    }
    
    public boolean COMPFOLORdenNOTPP(String ord) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.op_ord_crea_COMPFOLORdenNOTPP(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                String orden = rs.getString("folio_sam");
                if (ord.equals(orden)) {
                    con.CerrarConexion(conn);
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
    
    public ordenes_pp_notificaciones ObtenStatusCNPMNOTPP(String orde) {
        ordenes_pp_notificaciones or = new ordenes_pp_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.ord_pp_noti_COMPORdenNOTPP(?)}";
        try {  
            pst = conn.prepareStatement(query);
            pst.setString(1, orde);
            rs = pst.executeQuery();
            while (rs.next()) {
                or.setId_opmn(rs.getInt("id_opmn"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setStatus(rs.getString("status"));
                or.setTexto_breve(rs.getString("texto_breve"));
                or.setClase_orden(rs.getString("clase_orden"));
                or.setTipo_orden(rs.getString("tipo_orden"));
                or.setCentro(rs.getString("centro"));

            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return or;
    }
    
    public boolean POSNOCRE_INSERTAPP(String folpnc,String ord,String ope,String honot,String fenot,String durp1,String trrep1,String nf,String nofip1, String durp2){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PP.posiciones_notificaciones_crea_INSERTAR_PP(?,?,?,?,?,?,?,?,?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst.setString(1, folpnc);
           pst.setString(2, ord);
           pst.setString(3, ope);
           pst.setString(4, honot);
           pst.setString(5, fenot);
           pst.setString(6, durp1);
           pst.setString(7, trrep1);
           pst.setString(8, nf);
           pst.setString(9, nofip1);
           pst.setString(10, durp2);
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
    
    public boolean CANOCRE_INSERTAPP(String folicn,String ord,String ope,String honot,String fenot,String fecco,String usu){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PP.cab_notificaciones_crea_insertar_PP(?,?,?,?,?,?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst.setString(1, folicn);
           pst.setString(2, ord);
           pst.setString(3, ope);
           pst.setString(4, honot);
           pst.setString(5, fenot);
           pst.setString(6, fecco);
           pst.setString(7, usu);
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
    public ordenes_pp_notificaciones ObtStatusCNPP(String orde) {
        ordenes_pp_notificaciones or = new ordenes_pp_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PP.ord_pp_not_ObtStatusCNPP(?)}";
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, orde);
            rs = pst.executeQuery();
            while (rs.next()) {

                or.setId_opmn(rs.getInt("id_opmn"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setStatus(rs.getString("status"));
                or.setTexto_breve(rs.getString("texto_breve"));
                or.setClase_orden(rs.getString("clase_orden"));
                or.setTipo_orden(rs.getString("tipo_orden"));
                or.setCentro(rs.getString("centro"));

            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
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
        return or;
    }
    
    public boolean InsertStatus_notificacionessapPP(String fsam, String fecha, String hora, String stats, String orden, String orpm, String usu) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        String query = "{call PM.status_notificaciones_InsertSt_notsap(?,?,?,?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fsam);
            pst.setString(2, fecha);
            pst.setString(3, hora);
            pst.setString(4, stats);
            pst.setString(5, orden);
            pst.setString(6, orpm);
            pst.setString(7, usu);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
    
    public boolean ordpmnotiActualPP(String operacion, String orden){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PM.ordenes_pm_notificaciones_Actualizar(?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst .setString(1, operacion);
           pst.setString(2, orden);
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
    public LinkedList<ordenes_pp_notificaciones> OrdenesMatchNOTPP(String CtdMax,String Orden,String TxtBrv) {
        LinkedList<ordenes_pp_notificaciones> pmorden = new LinkedList<>();       
        Conexion con = new Conexion();       
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ordenes_pp_noti_OrdenesMatchNOTPP(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, CtdMax);
            pst.setString(2, Orden);
            pst.setString(3, TxtBrv);
            rs = pst.executeQuery();
            while (rs.next()) {
            ordenes_pp_notificaciones opmn = new ordenes_pp_notificaciones();
            opmn.setNum_orden(rs.getString("num_orden"));
            pmorden.add(opmn);
            }
        } catch (Exception e) {
            System.err.println("Error en la consulta: " + e);
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
        return pmorden;
    }
    
    public ordenes_pp_notificaciones OrdenesMatchNOTextPP(String Orden) { 
       ordenes_pp_notificaciones opmn = new ordenes_pp_notificaciones();   
        Conexion con = new Conexion();       
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ordenes_pp_noti_OrdenesMatctexopPP(?)}";
           
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, Orden);
            rs = pst.executeQuery();
            while (rs.next()) {
            opmn.setTexto_breve(rs.getString("texto_breve_operacion"));
            }
        } catch (Exception e) {
            System.err.println("Error en la consulta: " + e);
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
        return opmn;
    }
    
    public boolean ValidarOrdenesVisualNOPP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ordenes_ppValidarOrdenesVisualPP(?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                String ord = rs.getString("num_orden");
                if (ord.equals(orden)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error de orden: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                };
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }
    public notificaciones_cabecera_vis ObtenerDatosPP(String orden){
        notificaciones_cabecera_vis vis = new notificaciones_cabecera_vis();
        Conexion con = new Conexion();
        String query = "{call PP.notif_cab_vis_ObtenerDatosPP(?)}";
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
    
    public LinkedList<notificaciones_cabecera_vis> GetResumenNotificacionesPP(String orden, String opera){
        LinkedList<notificaciones_cabecera_vis> cabevis = new LinkedList<>();
        Conexion con = new Conexion();
        String query = "{call PP.noti_csb_vis_GetResumenNotificacionesCreaPP(?,?)}";
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
    
}
