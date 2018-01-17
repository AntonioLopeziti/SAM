/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.MonitorStatusCont2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author Jhonatan
 */
public class ACC_MonitorStatusCont2 {
    
    private static ACC_MonitorStatusCont2 Instance = null;
    
    //*******Instancia*********
    public static ACC_MonitorStatusCont2 ObtenerInstancia()
         
    {
        if(Instance == null)
        {
            Instance = new ACC_MonitorStatusCont2();
        }
        return Instance;
    }
    
    //Metodo trae todo de relacion2
    public LinkedList<MonitorStatusCont2> ConsultaMonitorStatus2(String equipo) {
        
      LinkedList<MonitorStatusCont2> MonitorStatus2 = new LinkedList<>();
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      ResultSet rs = null;
      PreparedStatement pst = null;
      String query="{CALL PM.relacion2_ConMonSta2(?)}";
      try{
        pst = conn.prepareStatement(query);
        pst.setString(1, equipo);
        rs = pst.executeQuery();
        while(rs.next()){        
                MonitorStatusCont2 MStatus = new MonitorStatusCont2();                
                MStatus.setJerarquia(rs.getString("jerarquia"));
                MStatus.setNivel(rs.getString("nivel"));
                MStatus.setPosicion_mantenimiento(rs.getString("posicion_matenimiento"));
                MStatus.setNum_toma_plan_mante(rs.getString("num_toma_plan_mante"));
                MStatus.setNum_orden(rs.getString("num_orden"));
                //System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(myDate));
                MStatus.setFecha_cierre_toma_mante(rs.getString("fecha_cierre_toma_mante"));   
                MStatus.setPlan_mante_preventivo(rs.getString("plan_mante_preventivo"));
                MStatus.setEstrategia_mantenimiento(rs.getString("estrategia_mantenimiento"));
                MStatus.setPosicion_plan_mantenimiento(rs.getString("posicion_plan_mantenimiento"));
                MStatus.setDescricpion_posicion(rs.getString("descricpion_posicion"));
                MStatus.setNum_equipo(rs.getString("num_equipo"));
                MStatus.setNum_lista_objetos(rs.getString("num_lista_objetos"));
                MStatus.setIndicador_creacion(rs.getString("indicador_creacion"));
                MStatus.setIndicador_modificacion(rs.getString("indicador_modificacion"));
                MStatus.setResponsable_anadio_obj(rs.getString("responsable_anadio_obj"));
                MStatus.setFecha_creacion(rs.getString("fecha_creacion"));
                MStatus.setFecha_ultima_modificacion(rs.getString("fecha_ultima_modificacion"));
                MStatus.setResponssable_modifico_obj(rs.getString("responssable_modifico_obj"));
                MStatus.setTipo_hoja_ruta(rs.getString("tipo_hoja_ruta"));
                MStatus.setNum_orden2(rs.getString("num_orden2"));
                MStatus.setClave_grupo_hojaruta(rs.getString("clave_grupo_hojaruta"));
                MStatus.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                MStatus.setStatus_posicion_mantenimiento(rs.getString("status_posicion_mantenimiento"));
                MStatus.setIndicador_texto_explicativo(rs.getString("indicador_texto_explicativo"));
                MStatus.setGrupo_plani_servicio_cliente_mante(rs.getString("grupo_plani_servicio_cliente_mante"));
                MStatus.setCim_tipo_objeto_recurso(rs.getString("cim_tipo_objeto_recurso"));
                MStatus.setId_obj_puesto_trabajo(rs.getString("id_obj_puesto_trabajo"));
                MStatus.setCentro_planificacion_mante(rs.getString("centro_planificacion_mante"));
                MStatus.setClave_idioma_text_expli(rs.getString("clave_idioma_text_expli"));
                MStatus.setEmplazamiento_imputacion_objtec(rs.getString("emplazamiento_imputacion_objtec"));
                MStatus.setIloa_individual(rs.getString("iloa_individual"));
                MStatus.setSerielnr(rs.getString("serielnr"));
                MStatus.setNum_material(rs.getString("num_material"));
                MStatus.setMaterial(rs.getString("material"));
                MStatus.setLote(rs.getString("lote"));
                MStatus.setCentro(rs.getString("centro"));
                MStatus.setAlmacen(rs.getString("almacen"));
                MStatus.setSerie(rs.getString("serie"));
                MStatus.setPunto_medida(rs.getString("punto_medida"));
                MStatus.setDoc_medicion(rs.getString("doc_medicion"));
                MStatus.setValor_medido_unidad_entrada(rs.getString("valor_medido_unidad_entrada"));
                MStatus.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                MStatus.setDenominacion_obj_tecnico(rs.getString("denominacion_obj_tecnico"));
                MStatus.setElem_referencia_pm_ps(rs.getString("elem_referencia_pm_ps"));
                MStatus.setIndicador_posicion(rs.getString("indicador_posicion"));
                MStatus.setDenominacion_status_actualizacion(rs.getString("denominacion_status_actualizacion"));
                MStatus.setInicio_programado(rs.getString("inicio_programado"));
                MonitorStatus2.add(MStatus);
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        finally {
            try{
                if(conn != null)con.CerrarConexion(conn);
                if(pst != null)pst.close();
                if(rs != null)rs.close();
            }
            catch(Exception ex){
                System.err.println("Error: "+ex);
            }
        }
        return MonitorStatus2;
    }
    
}
