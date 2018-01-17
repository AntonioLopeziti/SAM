/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.pm01_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Pm01_notificaciones {
    private static ACC_Pm01_notificaciones Instance = null;

    public static ACC_Pm01_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Pm01_notificaciones();
        }
        return Instance;
    } 
    
    
    public LinkedList<pm01_notificaciones> ShowDatPM1(String ord,String ope){
    LinkedList<pm01_notificaciones> np1 = new LinkedList<>();
    Conexion con = new Conexion();
    Connection conn = con.ObtenerConexion();
    PreparedStatement pst = null;
    ResultSet rs = null;
    String query = "{call PM.pm01_notificaciones_ShowDatPM1NOT(?,?)}";  
    try{     
      pst = conn.prepareStatement(query);
      pst.setString(1, ord);
      pst.setString(2, ope);
      rs = pst.executeQuery();
      while(rs.next()){
         pm01_notificaciones np = new pm01_notificaciones();
         
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
    
}
