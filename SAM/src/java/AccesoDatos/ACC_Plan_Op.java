/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.planop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author AREConsulting
 */
public class ACC_Plan_Op {

    private static ACC_Plan_Op Instance = null;

    public static ACC_Plan_Op ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Plan_Op();
        }
        return Instance;
    }

    public planop CargaDatosPlan(String query) {
        Conexion cnx = new Conexion();
        planop op = new planop();
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                op.setId_planop(rs.getInt("id_planop"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setSuboperacion(rs.getString("suboperacion"));
                op.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                op.setCentro(rs.getString("centro"));
                op.setClave_control(rs.getString("clave_control"));
                op.setClave_modelo(rs.getString("clave_modelo"));
                op.setEstado_instalacion(rs.getString("estado_instalacion"));
                op.setTexto_breve_operacion(rs.getString("texto_breve"));
                op.setTrabajo_real(rs.getString("trabajo_real"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setCantidad_capacidad_necesidad(rs.getString("cantidad_capacidad_necesidad"));
                op.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setClave_calculo(rs.getString("clave_calculo"));
                op.setClase_actividad(rs.getString("clase_actividad"));
                op.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                op.setPuesto_descarga(rs.getString("puesto_descarga"));
                op.setFactor_ejecucion(rs.getString("factor_ejecucion"));
                op.setIndicador_asignar_componentes(rs.getString("indicador_asignar_componentes"));
                op.setIndicador_asignar_medio_auxiliar_fabricacion(rs.getString("indicador_asignar_medio_auxiliar_fabricacion"));
                op.setUbitec(rs.getString("ubitec"));
                op.setNum_equipo(rs.getString("num_equipo"));
                op.setNum_notificacion(rs.getString("num_notificacion"));
                op.setSiguiente_fecha_prevista(rs.getString("siguiente_fecha_previa"));
                op.setEfectividad_reserva_creacion_solped(rs.getString("efectividad_reserva_creacion_solped"));
                op.setInicio_temprano_programado_ejecucin_hora(rs.getString("inicio_temprano_programado_ejecucion_hora"));
                op.setInicio_temprano_programado_ejecucion_fecha(rs.getString("inicio_temprano_programado_ejecucion_fecha"));
                op.setFin_temprano_programado_ejecucion_fecha(rs.getString("fin_temprano_programado_ejecucion_fecha"));
                op.setFin_temprano_programado_ejecucion_hora(rs.getString("fin_temprano_programado_ejecucion_hora"));
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error de plan op: " + ex);
        }
        return op;
    }

}
