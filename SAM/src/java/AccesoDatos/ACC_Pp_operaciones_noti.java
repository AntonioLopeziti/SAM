/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.pp01_notifi;
import Entidades.pp_operaciones_noti;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Jhonatan
 */
public class ACC_Pp_operaciones_noti {
    
    private static ACC_Pp_operaciones_noti Instance = null;

    public static ACC_Pp_operaciones_noti ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Pp_operaciones_noti();
        }
        return Instance;
    }
    
    public LinkedList<pp_operaciones_noti> TABGRNOTPMNotPP(String ord, String ope) {
        LinkedList<pp_operaciones_noti> tpn = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PP.pp_operaciones_notificaciones_TABGRNOTPP(?,?)}";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {
                pp_operaciones_noti pmon = new pp_operaciones_noti();
                pmon.setActividad_ya_notificada01(rs.getString("actividad_ya_notificada01"));
                pmon.setActividad_ya_notificada02(rs.getString("Actividad_ya_notificada02"));
                pmon.setActividad_ya_notificada03(rs.getString("Actividad_ya_notificada03"));
                pmon.setActividad_ya_notificada04(rs.getString("Actividad_ya_notificada04"));
                pmon.setActividad_ya_notificada05(rs.getString("Actividad_ya_notificada05"));
                pmon.setActividad_ya_notificada06(rs.getString("Actividad_ya_notificada06"));
                pmon.setCantidad_base(rs.getString("cantidad_base"));
                pmon.setCantidad_base2(rs.getString("cantidad_base2"));
                pmon.setCantidad_operacion(rs.getString("Cantidad_operacion"));
                pmon.setClase_coste(rs.getString("clase_coste"));
                pmon.setClave_control(rs.getString("clave_control"));
                pmon.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                pmon.setClave_moneda(rs.getString("clave_moneda"));
                pmon.setContador_general_orden(rs.getString("contador_general_orden"));
                pmon.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                pmon.setContador_interno(rs.getString("contador_interno"));
                pmon.setCentro(rs.getString("centro"));
                pmon.setIndicador_valor_prede_traba_relevante(rs.getString("indicador_valor_prede_traba_relevante"));
                pmon.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                pmon.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                pmon.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                pmon.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                pmon.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                pmon.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                pmon.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                pmon.setUnidad_medida_actividad_notificar01(rs.getString("unidad_medida_actividad_notificar01"));
                pmon.setUnidad_medida_actividad_notificar02(rs.getString("unidad_medida_actividad_notificar02"));
                pmon.setNum_operacion(rs.getString("num_operacion"));
                tpn.add(pmon);
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
        return tpn;
    }
    
    public pp_operaciones_noti INPGRNOTPMNOTPP(String ord, String ope) {
        pp_operaciones_noti pmon = new pp_operaciones_noti();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.pp_operaciones_notificaciones_INPGRNOTPPNOTPP(?,?)}";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {

                pmon.setActividad_ya_notificada01(rs.getString("actividad_ya_notificada01"));
                pmon.setActividad_ya_notificada02(rs.getString("Actividad_ya_notificada02"));
                pmon.setActividad_ya_notificada03(rs.getString("Actividad_ya_notificada03"));
                pmon.setActividad_ya_notificada04(rs.getString("Actividad_ya_notificada04"));
                pmon.setActividad_ya_notificada05(rs.getString("Actividad_ya_notificada05"));
                pmon.setActividad_ya_notificada06(rs.getString("Actividad_ya_notificada06"));
                pmon.setCantidad_base(rs.getString("cantidad_base"));
                pmon.setCantidad_base2(rs.getString("cantidad_base2"));
                pmon.setCantidad_operacion(rs.getString("Cantidad_operacion"));
                pmon.setClase_coste(rs.getString("clase_coste"));
                pmon.setClave_control(rs.getString("clave_control"));
                pmon.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                pmon.setClave_moneda(rs.getString("clave_moneda"));
                pmon.setContador_general_orden(rs.getString("contador_general_orden"));
                pmon.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                pmon.setContador_interno(rs.getString("contador_interno"));
                pmon.setCentro(rs.getString("centro"));
                pmon.setIndicador_valor_prede_traba_relevante(rs.getString("indicador_valor_prede_traba_relevante"));
                pmon.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                pmon.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                pmon.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                pmon.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                pmon.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                pmon.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                pmon.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                pmon.setUnidad_medida_actividad_notificar01(rs.getString("unidad_medida_actividad_notificar01"));
                pmon.setUnidad_medida_actividad_notificar02(rs.getString("unidad_medida_actividad_notificar02"));
                pmon.setNum_operacion(rs.getString("num_operacion"));
                pmon.setNum_solicitud_pedido(rs.getString("num_solicitud_pedido"));
                pmon.setNum_posicion_socitud_pedido_orden(rs.getString("num_posicion_socitud_pedido_orden"));
                pmon.setPrecio(rs.getString("precio"));
                pmon.setGrupo_articulos(rs.getString("grupo_articulos"));
                pmon.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                pmon.setOrganizacion_compras(rs.getString("organizacion_compras"));
                pmon.setProveedor(rs.getString("proveedor"));
                pmon.setSolicitante(rs.getString("solicitante"));

            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return pmon;
    }
    public LinkedList<pp01_notifi> MostDatPP01(String ord,String ope){
        LinkedList<pp01_notifi> np1 = new LinkedList<>();
    Conexion con = new Conexion();
    Connection conn = con.ObtenerConexion();
    PreparedStatement pst = null;
    ResultSet rs = null;
    String query = "{call PP.pp01_noti_MostDatPP1NOTPP(?,?)}";  
    try{     
      pst = conn.prepareStatement(query);
      pst.setString(1, ord);
      pst.setString(2, ope);
      rs = pst.executeQuery();
      while(rs.next()){
         pp01_notifi np = new pp01_notifi();         
            np.setNum_reserva_nece_secundarias(rs.getString("num_reserva_nece_secundarias"));
            np.setNum_posicion_reserva_nece_secundaria(rs.getString("num_posicion_reserva_nece_secundaria"));
            np.setClase_registro(rs.getString("clase_registro"));
            np.setClase_necesidad(rs.getString("clase_necesidad"));
            np.setStatus_reserva(rs.getString("status_reserva"));
            np.setPosicion_borrada(rs.getString("posicion_borrada"));
            np.setMovimiento_mercancia_permitido_reserva(rs.getString("movimiento_mercancia_permitido_reserva"));
            np.setSalida_final_reserva(rs.getString("salida_final_reserva"));
            np.setFalta(rs.getString("falta"));
            np.setMaterial(rs.getString("material"));
            np.setCentro(rs.getString("centro"));
            np.setAlmacen(rs.getString("almacen"));
            np.setArea_suministro_produccion(rs.getString("area_suministro_produccion"));
            np.setLote(rs.getString("lote"));
            np.setDistribucion_diferencias(rs.getString("distribucion_diferencias"));
            np.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
            np.setFecha_necesidad_componente(rs.getString("fecha_necesidad_componente"));
            np.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
            np.setUnidad_medida_base(rs.getString("unidad_medida_base"));
            np.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
            np.setCantidad_fija(rs.getString("cantidad_fija"));
            np.setCantidad_tomada(rs.getString("cantidad_tomada"));
            np.setValor_toma(rs.getString("valor_toma"));
            np.setClave_moneda(rs.getString("clave_moneda"));
            np.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
            np.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
            np.setNum_orden_previsional(rs.getString("num_orden_previsional"));
            np.setNum_solped(rs.getString("num_solped"));
            np.setNum_posicion_solped(rs.getString("num_posicion_solped"));
            np.setNum_orden(rs.getString("num_orden"));
            np.setNum_material_conjunto_superior(rs.getString("num_material_conjunto_superior"));
            np.setSerie(rs.getString("serie"));
            np.setTexto_posicion(rs.getString("texto_posicion"));
            np1.add(np);
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
    return np1;
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
    
}
