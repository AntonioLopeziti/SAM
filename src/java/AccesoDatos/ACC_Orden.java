package AccesoDatos;

import Entidades.cabecera_ordenes_crea;
import Entidades.clase_orden;
import Entidades.componentes;
import Entidades.materiales_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import Entidades.plan_orden;
import Entidades.planop;
import Entidades.servicios_ordenes_crea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_Orden {

    private static ACC_Orden Instance = null;

    public static ACC_Orden ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Orden();
        }

        return Instance;
    }

    public int ValidOrden(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PM.plan_ordenValida_MOM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString("status_sistema");
                if (s.substring(0, 4).equals("LIB.")) {
                    return 1;
                }
            }

        } catch (Exception E) {
            System.err.println("Error" + E);
        }
        cnx.CerrarConexion(con);
        return 0;
    }

    public static void main(String[] args) {
        ACC_Orden o = new ACC_Orden();
        String qu = "select status_sistema, clase_doc_ventas, num_orden, texto_breve   from plan_orden union\n"
                + "select estatus, clase_doc_ventas, num_orden, denominacion_general from ordenes_mm";
//        for (int i = 0; i < l.size(); i++) {
//            System.out.println(l.get(i).getStatus_sistema());
//        }
    }

    public ArrayList<plan_orden> ObtenerDatosMatchOrdeness(String limite, String NOrden, String texto) {
        ArrayList<plan_orden> pla = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PM.plan_ordenMatch_MOM(?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, limite);
            sp.setString(2, NOrden);
            sp.setString(3, texto);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                plan_orden p = new plan_orden();
                String s = rs.getString("status_sistema");
                p.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setFolio_sam(rs.getString("folio_sam"));
                p.setTexto_breve(rs.getString("texto_breve"));
                if (s.substring(0, 4).equals("LIB.")) {
//                if (s.substring(0, 4).equals("LIB.") || s.substring(0, 4).equals("ABIE")) {
                    pla.add(p);
                }
            }
        } catch (Exception e) {
            System.err.println("Error  por:  " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pla;
    }

    public ArrayList<plan_orden> ObtenerDatosMatchOrdenes(String clase, String orden, String txt) {
        ArrayList<plan_orden> pla = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.SolpedCargarOrdenes(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase);
            ps.setString(2, orden);
            ps.setString(3, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                plan_orden p = new plan_orden();
                String s = rs.getString("status_sistema");
                p.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setFolio_sam(rs.getString("folio_sam"));
                p.setTexto_breve(rs.getString("texto_breve"));
                if (s.substring(0, 4).equals("LIB.") || s.substring(0, 4).equals("ABIE")) {
                    pla.add(p);
                }
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en metodo ObtenerDatosMatchOrdenes(ACC_Orden) por:  " + e);
        }
        return pla;
    }

    public String[] ValidarOrden(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String[] dat = new String[2];
        String query = "{CALL MM.Solped_ValidarOrden(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String a = rs.getString("status_sistema");
                String us = rs.getString("num_orden");
                String f = rs.getString("folio_sam");
                if (a.substring(0, 4).equals("LIB.") || a.substring(0, 4).equals("ABIE")) {
                    if (id.equals(us) || id.equals(f)) {
                        dat[0] = us;
                        dat[1] = f;
                    }

                }
            }
        } catch (Exception E) {
            System.err.println("Error" + E);
        } finally {
            cnx.CerrarConexion(con);
        }
        return dat;

    }

    public plan_orden ObtenerDatosCab(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        plan_orden po = new plan_orden();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                po.setNum_orden(rs.getString("num_orden"));
                po.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                po.setStatus_sistema(rs.getString("status_sistema"));
                po.setTexto_breve(rs.getString("texto_breve"));
                po.setPuesto_trabajo_responsables_medidas_mante(rs.getString("puesto_trabajo_responsables_medidas_mante"));
                po.setCentro_puesto_trabajo_responsable(rs.getString("centro_puesto_trabajo_responsable"));
                po.setNum_notificacion(rs.getString("num_notificacion"));
                po.setGastos_general_estimado_orden(rs.getString("gastos_general_estimado_orden"));
                po.setClase_actividad_mante(rs.getString("clase_actividad_mante"));
                po.setEstado_instalacion(rs.getString("estado_instalacion"));
                po.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                po.setFecha_fin_extrema(rs.getString("fecha_fin_extrema"));
                po.setPrioridad(rs.getString("prioridad"));
                po.setRevision_mante_servicio_cliente(rs.getString("revision_mante_servicio_cliente"));
                po.setNum_hoja_mante_servicio_orden(rs.getString("num_hoja_mante_servicio_orden"));
                po.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                po.setDenominacion_ubitec(rs.getString("denominacion_ubitec"));
                po.setNum_equipo(rs.getString("num_equipo"));
                po.setDenominacion_objeto_tecnico(rs.getString("denominacion_objeto_tecnico"));
                po.setConjunto(rs.getString("conjunto"));
            }
        } catch (Exception e) {
            System.out.println("Error en ObtenerDatoscab(ACC_Orden) por " + e);
        }
        return po;
    }

    public plan_orden CargarCabeceraSAP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        plan_orden mat = new plan_orden();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ConsultarOrdenesSAP(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            rs.next();

            mat = new plan_orden();
            mat.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
            mat.setTexto_breve(rs.getString("texto_breve"));
            mat.setStatus_sistema(rs.getString("status_sistema"));
            mat.setPuesto_trabajo_responsables_medidas_mante(rs.getString("puesto_trabajo_responsables_medidas_mante"));
            mat.setCentro_puesto_trabajo_responsable(rs.getString("centro_puesto_trabajo_responsable"));
            mat.setNum_notificacion(rs.getString("num_notificacion"));
            mat.setGastos_general_estimado_orden(rs.getString("gastos_general_estimado_orden"));
            mat.setClase_actividad_mante(rs.getString("clase_actividad_mante"));
            mat.setEstado_instalacion(rs.getString("estado_instalacion"));
            mat.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
            mat.setFecha_fin_extrema(rs.getString("fecha_fin_extrema"));
            mat.setPrioridad(rs.getString("prioridad"));
            mat.setRevision_mante_servicio_cliente(rs.getString("revision_mante_servicio_cliente"));
            mat.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
            mat.setDenominacion_ubitec(rs.getString("denominacion_ubitec"));
            mat.setNum_equipo(rs.getString("num_equipo"));
            mat.setDenominacion_objeto_tecnico(rs.getString("denominacion_objeto_tecnico"));
            mat.setConjunto(rs.getString("conjunto"));
            mat.setNum_orden(rs.getString("num_orden"));
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarMaterialOrden(ACC_Equipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mat;
    }

    public planop CargarFirstOpeSAP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        planop ope = new planop();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ConsultarOperacionesSAP(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            rs.next();

            ope = new planop();
            ope.setNum_operacion(rs.getString("num_operacion"));
            ope.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
            ope.setClave_calculo(rs.getString("clave_calculo"));
            ope.setPuesto_trabajo(rs.getString("puesto_trabajo"));
            ope.setCentro(rs.getString("centro"));
            ope.setClave_control(rs.getString("clave_control"));
            ope.setClase_actividad(rs.getString("clase_actividad"));
            ope.setIndicador_asignar_medio_auxiliar_fabricacion(rs.getString("indicador_asiganar_medio_auxiliar_fabricacion"));
            ope.setTrabajo_operacion(rs.getString("trabajo_operacion"));
            ope.setUnidad_trabajo(rs.getString("unidad_trabajo"));
            ope.setCantidad_capacidad_necesidad(rs.getString("cantidad_capacidad_necesidad"));
            ope.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
            ope.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
            ope.setIndicador_asignar_componentes(rs.getString("indicador_asignar_componentes"));
            ope.setNum_orden(rs.getString("num_orden"));
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarMaterialOrden(ACC_Equipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ope;
    }

    public planop ObtenerPrimeraOper(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        planop pla = new planop();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pla.setNum_operacion(rs.getString("num_operacion"));
                pla.setClave_calculo(rs.getString("clave_calculo"));
                pla.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                pla.setCentro(rs.getString("centro"));
                pla.setClave_control(rs.getString("clave_control"));
                pla.setClase_actividad(rs.getString("clase_actividad"));
                pla.setIndicador_asignar_medio_auxiliar_fabricacion(rs.getString("indicador_asiganar_medio_auxiliar_fabricacion"));
                pla.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                pla.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                pla.setCantidad_capacidad_necesidad(rs.getString("cantidad_capacidad_necesidad"));
                pla.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                pla.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                pla.setIndicador_asignar_componentes(rs.getString("indicador_asignar_componentes"));
            }
        } catch (Exception e) {
            System.err.println("Error en metodo obtenerPrimeraOper (ACC_Orden) por: " + e);
        }
        return pla;
    }

    public LinkedList<planop> CargarTablaOperaciones(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<planop> pla = new LinkedList<planop>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                planop p = new planop();
                p.setNum_operacion(rs.getString("num_operacion"));
                p.setSuboperacion(rs.getString("suboperacion"));
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setCentro(rs.getString("centro"));
                p.setClave_control(rs.getString("clave_control"));
                p.setClave_modelo(rs.getString("clave_modelo"));
                p.setEstado_instalacion(rs.getString("estado_instalacion"));
                p.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                p.setTrabajo_real(rs.getString("trabajo_real"));
                p.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                p.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                p.setCantidad_capacidad_necesidad(rs.getString("cantidad_capacidad_necesidad"));
                p.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                p.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                p.setClave_calculo(rs.getString("clave_calculo"));
                p.setClase_actividad(rs.getString("clase_actividad"));
                p.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                p.setPuesto_descarga(rs.getString("puesto_descarga"));
                p.setFactor_ejecucion(rs.getString("factor_ejecucion"));
                p.setIndicador_asignar_componentes(rs.getString("indicador_asignar_componentes"));
                p.setIndicador_asignar_medio_auxiliar_fabricacion(rs.getString("indicador_asiganar_medio_auxiliar_fabricacion"));
                p.setUbitec(rs.getString("ubitec"));
                p.setNum_equipo(rs.getString("num_equipo"));
                p.setNum_notificacion(rs.getString("num_notificacion"));
                p.setSiguiente_fecha_prevista(rs.getString("siguiente_fecha_prevista"));
                p.setEfectividad_reserva_creacion_solped(rs.getString("efectividad_reserva_creacion_solped"));
                p.setInicio_temprano_programado_ejecucin_hora(rs.getString("inicio_temprano_programado_ejecucion_hora"));
                p.setInicio_temprano_programado_ejecucion_fecha(rs.getString("inicio_temprano_programado_ejecucion_fecha"));
                p.setFin_temprano_programado_ejecucion_fecha(rs.getString("fin_temprano_programado_ejecucion_fecha"));
                p.setFin_temprano_programado_ejecucion_hora(rs.getString("fin_temprano_programado_ejecucion_hora"));
                pla.add(p);

            }
        } catch (Exception e) {
            System.err.println("Error en CargarTablaOperacion ACC_Orden por " + e);
        }
        return pla;
    }

    public ArrayList CargarOperacionesSAP(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList pts = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        planop p;
        String SP = "{CALL PM.Ordenes_ConsultarOperacionesSAP(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new planop();
                p.setNum_operacion(rs.getString("num_operacion"));
                p.setSuboperacion(rs.getString("suboperacion"));
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setCentro(rs.getString("centro"));
                p.setClave_control(rs.getString("clave_control"));
                p.setClave_modelo(rs.getString("clave_modelo"));
                p.setEstado_instalacion(rs.getString("estado_instalacion"));
                p.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                p.setTrabajo_real(rs.getString("trabajo_real"));
                p.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                p.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                p.setCantidad_capacidad_necesidad(rs.getString("cantidad_capacidad_necesidad"));
                p.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                p.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                p.setClave_calculo(rs.getString("clave_calculo"));
                p.setClase_actividad(rs.getString("clase_actividad"));
                p.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                p.setPuesto_descarga(rs.getString("puesto_descarga"));
                p.setFactor_ejecucion(rs.getString("factor_ejecucion"));
                p.setIndicador_asignar_componentes(rs.getString("indicador_asignar_componentes"));
                p.setIndicador_asignar_medio_auxiliar_fabricacion(rs.getString("indicador_asiganar_medio_auxiliar_fabricacion"));
                p.setUbitec(rs.getString("ubitec"));
                p.setNum_equipo(rs.getString("num_equipo"));
                p.setNum_notificacion(rs.getString("num_notificacion"));
                p.setSiguiente_fecha_prevista(rs.getString("siguiente_fecha_prevista"));
                p.setEfectividad_reserva_creacion_solped(rs.getString("efectividad_reserva_creacion_solped"));
                p.setInicio_temprano_programado_ejecucin_hora(rs.getString("inicio_temprano_programado_ejecucion_hora"));
                p.setInicio_temprano_programado_ejecucion_fecha(rs.getString("inicio_temprano_programado_ejecucion_fecha"));
                p.setFin_temprano_programado_ejecucion_fecha(rs.getString("fin_temprano_programado_ejecucion_fecha"));
                p.setFin_temprano_programado_ejecucion_hora(rs.getString("fin_temprano_programado_ejecucion_hora"));
                pts.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchOrdenes(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pts;
    }

    public LinkedList<componentes> CargarComponentes(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<componentes> comp = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                componentes c = new componentes();
                c.setNum_orden(rs.getString("num_orden"));
                c.setNum_posicion_lista_material(rs.getString("num_posicion_lista_material"));
                c.setNum_material(rs.getString("num_material"));
                c.setTexto_breve_material(rs.getString("texto_breve_material"));
                c.setCantidad_necesaria_componente(rs.getString("cantidad_necesaria_componente"));
                c.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                c.setTipo_posicion_lista_material(rs.getString("tipo_posicion_lista_material"));
                c.setIndicador_stock_especial_visualizar_dialogo(rs.getString("indicador_stock_especial_visualizar_dialogo"));
                c.setAlmacen(rs.getString("almacen"));
                c.setCentro(rs.getString("centro"));
                c.setNum_operacion(rs.getString("num_operacion"));
                c.setNum_lote(rs.getString("num_lote"));
                c.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                c.setPuesto_descarga(rs.getString("puesto_descarga"));
                c.setPosicion_borrada(rs.getString("posicion_borrada"));
                c.setIndicador_material_granel(rs.getString("indicador_material_granel"));
                c.setIndicador_toma_retroactiva(rs.getString("indicador_toma_retroactiva"));
                c.setEfectividad_reserva_creacion_solped(rs.getString("efectividad_reserva_creacion_solped"));
                comp.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarCompoentes ACC_Orden por " + e);
        }
        return comp;
    }

    public ArrayList CargarComponentesSAP(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList comps = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        componentes c;
        String SP = "{CALL PM.Ordenes_ConsultarComponentesSAP(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new componentes();
                c.setNum_orden(rs.getString("num_orden"));
                c.setNum_posicion_lista_material(rs.getString("num_posicion_lista_material"));
                c.setNum_material(rs.getString("num_material"));
                c.setTexto_breve_material(rs.getString("texto_breve_material"));
                c.setCantidad_necesaria_componente(rs.getString("cantidad_necesaria_componente"));
                c.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                c.setTipo_posicion_lista_material(rs.getString("tipo_posicion_lista_material"));
                c.setIndicador_stock_especial_visualizar_dialogo(rs.getString("indicador_stock_especial_visualizar_dialogo"));
                c.setAlmacen(rs.getString("almacen"));
                c.setCentro(rs.getString("centro"));
                c.setNum_operacion(rs.getString("num_operacion"));
                c.setNum_lote(rs.getString("num_lote"));
                c.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                c.setPuesto_descarga(rs.getString("puesto_descarga"));
                c.setPosicion_borrada(rs.getString("posicion_borrada"));
                c.setIndicador_material_granel(rs.getString("indicador_material_granel"));
                c.setIndicador_toma_retroactiva(rs.getString("indicador_toma_retroactiva"));
                c.setEfectividad_reserva_creacion_solped(rs.getString("efectividad_reserva_creacion_solped"));
                comps.add(c);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarOperacionesSAM(ACC_OperacionesOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return comps;
    }

    public LinkedList<plan_orden> ObtenerDatosMatchOr(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<plan_orden> pla = new LinkedList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                plan_orden p = new plan_orden();
                p.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                p.setNum_orden(rs.getString("num_orden"));
                p.setTexto_breve(rs.getString("denominacion_general"));
                pla.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en metodo ObtenerDatosMatchOrdenes(ACC_Orden) por:  " + e);
        }
        return pla;
    }

    public boolean COMPFOLORden(String query, String ord) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String orden = rs.getString("folio_sam");
                if (ord.equals(orden)) {
                    con.CerrarConexion(conn);
                    return true;
                } else {
                    con.CerrarConexion(conn);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return false;
    }

    public operaciones_ordenes_crea cargartablaoperacionescreaP3(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        operaciones_ordenes_crea op = new operaciones_ordenes_crea();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));

            }
        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
        }
        cnx.CerrarConexion(con);
        return op;
    }

    public LinkedList<materiales_ordenes_crea> MostraTABPM01(String query) {
        LinkedList<materiales_ordenes_crea> mpm = new LinkedList<>();
        try {
            Conexion con = new Conexion();
            Connection conn = con.ObtenerConexion();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                materiales_ordenes_crea ma = new materiales_ordenes_crea();
                ma.setNum_reserva(rs.getString("num_reserva"));
                ma.setNum_posicion_reserva(rs.getString("num_posicion_reserva"));
                ma.setNum_material(rs.getString("num_material"));
                ma.setLote(rs.getString("lote"));
                ma.setUnidad_medida_componente_pieza_bruto(rs.getString("unidad_medida_componente_pieza_bruto"));
                ma.setCantidad_necesaria_componente2(rs.getString("cantidad_necesaria_componente2"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setCentro(rs.getString("centro"));
                ma.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                ma.setAlmacen(rs.getString("almacen"));
                ma.setTexto_posicion_lista_materiales(rs.getString("texto_posicion_lista_materiales"));
                mpm.add(ma);
            }

            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return mpm;
    }

    public LinkedList<servicios_ordenes_crea> COnsuTAMPM023(String query) {
        LinkedList<servicios_ordenes_crea> so = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                servicios_ordenes_crea sc = new servicios_ordenes_crea();
                sc.setFolio_sam(rs.getString("folio_sam"));
                sc.setNum_paquete(rs.getString("num_paquete"));
                sc.setNum_linea1(rs.getString("num_linea1"));
                sc.setNum_linea2(rs.getString("num_linea2"));
                sc.setIndicador_borrado(rs.getString("indicador_borrado"));
                sc.setNum_servicio(rs.getString("num_servicio"));
                sc.setNivel_jerarquico_grupo(rs.getString("nivel_jerarquico_grupo"));
                sc.setNivel_estructura(rs.getString("nivel_estructura"));
                sc.setAsignacion_servicio(rs.getString("asignacion_servicio"));
                sc.setNum_subpaquete(rs.getString("num_subpaquete"));
                sc.setDenominacion_ambito_servicio(rs.getString("denominacion_ambito_servicio"));
                sc.setEdicion_ambito_servicio(rs.getString("edicion_ambito_servicio"));
                sc.setPosicion_catalogo_prestaciones_estandar(rs.getString("posicion_catalogo_prestaciones_estandar"));
                sc.setNum_servicio_proveedor(rs.getString("num_servicio_proveedor"));
                sc.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                sc.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                sc.setTolerancia_sobrecumplimiento(rs.getString("tolerancia_sobrecumplimiento"));
                sc.setSobrecumplimiento_ilimitado(rs.getString("sobrecumplimiento_ilimitado"));
                sc.setBusqueda_limites(rs.getString("busqueda_limites"));
                sc.setActualizar_condiciones(rs.getString("actualizar_condiciones"));
                sc.setCantidad_base(rs.getString("cantidad_base"));
                sc.setPrecio_bruto(rs.getString("precio_bruto"));
                sc.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
                sc.setLimite_inferior(rs.getString("limite_inferior"));
                sc.setLimite_superior(rs.getString("limite_superior"));
                sc.setTexto_breve(rs.getString("texto_breve"));
                sc.setIndicador_distribucion_imputacion_multiple(rs.getString("indicador_distribucion_imputacion_multiple"));
                sc.setIndicador_factura_parcial(rs.getString("indicador_factura_parcial"));
                sc.setNum_personal(rs.getString("num_personal"));
                sc.setAgrupacion_paises(rs.getString("agrupacion_paises"));
                sc.setCc_nomina(rs.getString("cc_nomina"));
                sc.setTexto_explicativo_cc_nomina(rs.getString("texto_explicativo_cc_nomina"));
                sc.setFuncion(rs.getString("funcion"));
                sc.setNum_actual_tablas_interfaces(rs.getString("num_actual_tablas_interfaces"));
                sc.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
                sc.setFecha_activado_registro_tabla(rs.getString("fecha_activado_registro_tabla"));
                sc.setNum_paquete_original(rs.getString("num_paquete_original"));
                sc.setEntrada_linea_paquete_plan(rs.getString("entrada_linea_paquete_plan"));
                sc.setEntrada_no_planif_pedido(rs.getString("entrada_no_planif_pedido"));
                sc.setEntrada_no_planif_contr(rs.getString("entrada_no_planif_contr"));
                sc.setEntrada_servicio_no_planificado_modelo(rs.getString("entrada_servicio_no_planificado_modelo"));
                sc.setEntrada_servicio_no_planificado_cp_modelo(rs.getString("entrada_servicio_no_planificado_cp_modelo"));
                sc.setLinea_servicio_refiere_limites_cpe(rs.getString("linea_servicio_refiere_limites_cpe"));
                sc.setEntrada_no_plan_linea_limite(rs.getString("entrada_no_plan_linea_limite"));
                sc.setPedido_cantidad_entrada(rs.getString("pedido_cantidad_entrada"));
                sc.setValor_registrado(rs.getString("valor_registrado"));
                sc.setPedido_abierto_valor_ordenado(rs.getString("pedido_abierto_valor_ordenado"));
                sc.setPedido_abierto_cantidad_ordenada(rs.getString("pedido_abierto_cantidad_ordenada"));
                sc.setValor_previsto(rs.getString("valor_previsto"));
                sc.setPedido_abierto_valor_llamado_no_planif(rs.getString("pedido_abierto_valor_llamado_no_planif"));
                sc.setPedido_abierto_cantidad_ordenada_forma_no_plan(rs.getString("pedido_abierto_cantidad_ordenada_forma_no_plan"));
                sc.setAlternativa_nota_posicion_base(rs.getString("alternativa_nota_posicion_base"));
                sc.setLinea_base(rs.getString("linea_base"));
                sc.setLinea_alternativa(rs.getString("linea_alternativa"));
                sc.setLinea_licitante(rs.getString("linea_licitante"));
                sc.setLinea_suplementaria(rs.getString("linea_suplementaria"));
                sc.setLinea_cantidad_libre(rs.getString("linea_cantidad_libre"));
                sc.setLinea_informativa(rs.getString("linea_informativa"));
                sc.setLinea_global(rs.getString("linea_global"));
                sc.setLinea_reserva(rs.getString("linea_reserva"));
                sc.setIndicador_iva(rs.getString("indicador_iva"));
                sc.setDomicilio_fiscal(rs.getString("domicilio_fiscal"));
                sc.setModificacion_precio_hoja_entrada(rs.getString("modificacion_precio_hoja_entrada"));
                sc.setGrupo_articulos(rs.getString("grupo_articulos"));
                sc.setPrecio_bruto2(rs.getString("precio_bruto2"));
                sc.setIva_soportado_no_deducible(rs.getString("iva_soportado_no_deducible"));
                sc.setImporte_base_impuesto(rs.getString("importe_base_impuesto"));
                sc.setNum_condicion_doc(rs.getString("num_condicion_doc"));
                sc.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                sc.setTrabajo_interno(rs.getString("trabajo_interno"));
                sc.setClave_referencia_srm(rs.getString("clave_referencia_srm"));
                sc.setClase_coste(rs.getString("clase_coste"));
                sc.setTrabajo_interno2(rs.getString("trabajo_interno2"));
                sc.setCpo_asignacion(rs.getString("cpo_asignacion"));
                sc.setClave_posicion_mensaje_esoa(rs.getString("clave_posicion_mensaje_esoa"));
                sc.setTax_tariff_code(rs.getString("tax_tariff_code"));
                sc.setFecha(rs.getString("fecha"));
                sc.setHora_inicio(rs.getString("hora_inicio"));
                sc.setHora_final(rs.getString("hora_final"));
                sc.setNum_externo_personal(rs.getString("num_externo_personal"));
                sc.setContador_registro_entrada_tiempos(rs.getString("contador_registro_entrada_tiempos"));
                sc.setIndicador_doc_anulado(rs.getString("indicador_doc_anulado"));
                sc.setNum_doc(rs.getString("num_doc"));
                sc.setNum_formula(rs.getString("num_formula"));
                sc.setValor_formula1(rs.getString("valor_formula1"));
                sc.setValor_formula2(rs.getString("valor_formula2"));
                sc.setValor_formula3(rs.getString("valor_formula3"));
                sc.setValor_formula4(rs.getString("valor_formula4"));
                sc.setValor_formula5(rs.getString("valor_formula5"));
                sc.setCampo_personalizado1(rs.getString("campo_personalizado1"));
                sc.setCampo_personalizado2(rs.getString("campo_personalizado2"));
                sc.setCampo_personalizado3(rs.getString("campo_personalizado3"));
                sc.setCampo_personalizado4(rs.getString("campo_personalizado4"));
                sc.setNum_objeto_modulo_relaciones_asignado(rs.getString("num_objeto_modulo_relaciones_asignado"));
                sc.setModificacion_texto_breve_permitida(rs.getString("modificacion_texto_breve_permitida"));
                sc.setNum_calculo_coste(rs.getString("num_calculo_coste"));
                sc.setVariante_cal_coste(rs.getString("variante_cal_coste"));
                sc.setIdentificacion_lines(rs.getString("identificacion_lines"));
                sc.setLinea_interna(rs.getString("linea_interna"));
                sc.setGrupo_subcontratista(rs.getString("grupo_subcontratista"));
                sc.setLinea_riesgo(rs.getString("linea_riesgo"));
                sc.setCasilla_seleccion(rs.getString("casilla_seleccion"));
                sc.setModificacion_texto_explicativo(rs.getString("modificacion_texto_explicativo"));
                sc.setNum_grupo_numero_asignacion_ejecucion(rs.getString("num_grupo_numero_asignacion_ejecucion"));
                sc.setNum_actual_num_asignacion_ejecucion(rs.getString("num_actual_num_asignacion_ejecucion"));
                sc.setIndicador_immpresion(rs.getString("indicador_immpresion"));
                sc.setNum_suplementario(rs.getString("num_suplementario"));
                sc.setStatus_suplemento(rs.getString("status_suplemento"));
                sc.setTipo_objeto_linea_catalogo_servicios(rs.getString("tipo_objeto_linea_catalogo_servicios"));
                sc.setNum_subposicion(rs.getString("num_subposicion"));
                sc.setNum_linea(rs.getString("num_linea"));
                sc.setEntrada_servicio_permitida(rs.getString("entrada_servicio_permitida"));
                sc.setTamano_lote_calculo_costes(rs.getString("tamano_lote_calculo_costes"));
                sc.setPrecio_global_posicion_principal_definida(rs.getString("precio_global_posicion_principal_definida"));
                sc.setClave_referencia_externa_prestacion(rs.getString("clave_referencia_externa_prestacion"));
                sc.setPedido_cantidad_registrada_factura(rs.getString("pedido_cantidad_registrada_factura"));
                sc.setFecha_inicio_periodo_prestacion_servicios(rs.getString("fecha_inicio_periodo_prestacion_servicios"));
                sc.setFecha_fin_periodo_prestacion_servicios(rs.getString("fecha_fin_periodo_prestacion_servicios"));
                so.add(sc);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return so;
    }

    public LinkedList<operaciones_ordenes_crea> cargartablaoperacionescrea(String query) {
        LinkedList<operaciones_ordenes_crea> opc = new LinkedList<>();
        try {
            Conexion cnx = new Conexion();
            Connection con = cnx.ObtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                operaciones_ordenes_crea op = new operaciones_ordenes_crea();
                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));
                opc.add(op);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
        }

        return opc;
    }

    public LinkedList<cabecera_ordenes_crea> ALLparaMatchNotifi(String query) {
        LinkedList<cabecera_ordenes_crea> cao = new LinkedList<>();

        try {
            Conexion con = new Conexion();
            Connection conn = con.ObtenerConexion();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                cabecera_ordenes_crea co = new cabecera_ordenes_crea();
                co.setFolio_sam(rs.getString("folio_sam"));
                co.setTexto_breve(rs.getString("texto_breve"));
                cao.add(co);
            }

            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return cao;
    }

    public boolean ValidarOrdenPlanOrden(String id) {
        String query;
        boolean num = IsNumeric(id);
        if (num == true) {
            Long ide = Long.parseLong(id);
            query = "SELECT num_orden FROM plan_orden WHERE CAST(num_orden as bigint) = '" + ide + "'";
        } else {
            query = "SELECT folio_sam FROM plan_orden WHERE folio_sam='" + id + "'";
        }
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            }
        } catch (Exception E) {
            System.err.println("Error" + E);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public String ValidarOrdenType(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarOrdenVisualizar(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarMatchServi1(ACC_BOMEquipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public boolean ValidarOrdenCreadas(String id) {
        String query = "SELECT * FROM cabecera_ordenes_crea WHERE folio_sam = '" + id + "'";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                return true;
            }
            cnx.CerrarConexion(con);
        } catch (Exception E) {
            System.err.println("Error" + E);
        }
        return false;
    }

    public LinkedList<plan_orden> CargarOrdenesVisualizar(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<plan_orden> pla = new LinkedList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                plan_orden p = new plan_orden();
                p.setNum_orden(rs.getString("num_orden"));
                p.setFolio_sam(rs.getString("folio_sam"));
                p.setTexto_breve(rs.getString("texto_breve"));
                pla.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ObtenerDatosMatchOrdenes(ACC_Orden) por:  " + e);
        }
        cnx.CerrarConexion(con);
        return pla;
    }

    public ArrayList ConsultaMatchOrdenes(String ord, String txt, String ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList pts = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        plan_orden p;
        String SP = "{CALL PM.Ordenes_ConsultarOrdenes(?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            ps.setString(2, txt);
            ps.setString(3, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new plan_orden();
                p.setNum_orden(rs.getString("num_orden"));
                p.setFolio_sam(rs.getString("folio_sam"));
                p.setTexto_breve(rs.getString("texto_breve"));
                pts.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchOrdenes(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pts;
    }

    public boolean IsNumeric(String id) {
        try {
            Long.parseLong(id);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public cabecera_ordenes_crea CargarCabeceraCrea(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        cabecera_ordenes_crea c = new cabecera_ordenes_crea();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c.setFolio_sam(rs.getString("folio_sam"));
                c.setNum_orden(rs.getString("num_orden"));
                c.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                c.setHora_dia(rs.getString("hora_dia"));
                c.setFecha(rs.getString("fecha"));
                c.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                c.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                c.setClase_orden(rs.getString("clase_orden"));
                c.setPuesto_trabajo_responsable_medidas_mante(rs.getString("puesto_trabajo_responsable_medidas_mante"));
                c.setTexto_breve(rs.getString("texto_breve"));
                c.setNum_equipo(rs.getString("num_equipo"));
                c.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                c.setFecha_fin_extrema(rs.getString("fecha_fin_extrema"));
            }
        } catch (Exception e) {
            System.err.println("Error en metodo CargarCabeceraCreadas por " + e);
        }
        cnx.CerrarConexion(con);
        return c;
    }

    public LinkedList<materiales_ordenes_crea> CargarmaterialesordenesCrea(String query) {
        LinkedList<materiales_ordenes_crea> moc = new LinkedList<materiales_ordenes_crea>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                materiales_ordenes_crea mo = new materiales_ordenes_crea();
                mo.setFolio_sam(rs.getString("folio_sam"));
                mo.setHora_dia(rs.getString("hora_dia"));
                mo.setFecha(rs.getString("fecha"));
                mo.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                mo.setNum_reserva(rs.getString("num_reserva"));
                mo.setNum_posicion_reserva(rs.getString("num_posicion_reserva"));
                mo.setClase_registro(rs.getString("clase_registro"));
                mo.setMovimiento_mercancia_permitido_reserva(rs.getString("movimiento_mercancia_permitido_reserva"));
                mo.setSalida_final_reserva(rs.getString("salida_final_reserva"));
                mo.setNum_material_long(rs.getString("num_material"));
                mo.setCentro(rs.getString("centro"));
                mo.setAlmacen(rs.getString("almacen"));
                mo.setLote(rs.getString("lote"));
                mo.setCantidad_fija(rs.getString("cantidad_fija"));
                mo.setClave_moneda(rs.getString("clave_moneda"));
                mo.setCodigo_iso_moneda(rs.getString("codigo_iso_moneda"));
                mo.setNum_pedido_cliente(rs.getString("num_pedido_cliente"));
                mo.setNum_posicion_pedido_cliente(rs.getString("num_posicion_pedido_cliente"));
                mo.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                mo.setCantidad_emplear(rs.getString("cantidad_emplear"));
                mo.setTipo_posicion(rs.getString("tipo_posicion"));
                mo.setNum_posicion_lista_materiales(rs.getString("num_posicion_lista_materiales"));
                mo.setTexto_posicion_lista_materiales(rs.getString("texto_posicion_lista_materiales"));
                mo.setIndicador_relevancia_calculo_coste(rs.getString("indicador_relevancia_calculo_coste"));
                mo.setPosicion_alternativa_probabilidad_empleo(rs.getString("posicion_alternativa_probabilidad_empleo"));
                mo.setConcepto_clas(rs.getString("concepto_clas"));
                mo.setIndicador_material_granel(rs.getString("indicador_material_granel"));
                mo.setIndicador_pieza_facilitada(rs.getString("indicador_pieza_facilitada"));
                mo.setElemento_pep(rs.getString("elemento_pep"));
                mo.setNum_operacion(rs.getString("num_operacion"));
                mo.setPrecio_moneda_componente(rs.getString("precio_moneda_componente"));
                mo.setCantidad_base(rs.getString("cantidad_base"));
                mo.setIndicador_toma_retroactiva(rs.getString("indicador_toma_retroactiva"));
                mo.setGrupo_compras(rs.getString("grupo_compras"));
                mo.setPlazo_entrega_dias(rs.getString("plazo_entrega_dias"));
                mo.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                mo.setPuesto_descarga(rs.getString("puesto_descarga"));
                mo.setGrupo_articulos(rs.getString("grupo_articulos"));
                mo.setTimepo_tratamiento_entrada_mercancia_dias(rs.getString("timepo_tratamiento_entrada_mercancia_dias"));
                mo.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                mo.setNum_registro_info_compras(rs.getString("num_registro_info_compras"));
                mo.setDecalaje_operacion(rs.getString("decalaje_operacion"));
                mo.setUnidad_decalaje_operacion(rs.getString("unidad_decalaje_operacion"));
                mo.setCodigo_iso_unidad_medida(rs.getString("codigo_iso_unidad_medida"));
                mo.setSolicitante(rs.getString("solicitante"));
                mo.setNum_necesidad(rs.getString("num_necesidad"));
                mo.setOrganizacion_compras(rs.getString("organizacion_compras"));
                mo.setTexto_breve_material(rs.getString("texto_breve_material"));
                mo.setCantidad_necesaria_componente2(rs.getString("cantidad_necesaria_componente2"));
                mo.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                mo.setCodigo_iso_unidad_de_medida(rs.getString("codigo_iso_unidad_de_medida"));
                mo.setNum_contrato_superior(rs.getString("num_contrato_superior"));
                mo.setNum_posicion_contrato_superior(rs.getString("num_posicion_contrato_superior"));
                mo.setClase_relacion_ordenacion(rs.getString("clase_relacion_ordenacion"));
                mo.setUnidad_intervalo_relaciones_ordenacion(rs.getString("unidad_intervalo_relaciones_ordenacion"));
                mo.setCodigo_iso_unidad_medida2(rs.getString("codigo_iso_unidad_medida2"));
                mo.setIntervalo_relaciones_ordenacion(rs.getString("intervalo_relaciones_ordenacion"));
                mo.setEfectividad_reserva(rs.getString("efectividad_reserva"));
                mo.setIndicador_aprovisionamiento_directo(rs.getString("indicador_aprovisionamiento_directo"));
                mo.setIndicador_stock_especial_visualizacion_dialogo(rs.getString("indicador_stock_especial_visualizacion_dialogo"));
                mo.setDimension_bruta1(rs.getString("dimension_bruta1"));
                mo.setUnidad_dimension_brutas(rs.getString("unidad_dimension_brutas"));
                mo.setCodigo_unidad_medida(rs.getString("codigo_unidad_medida"));
                mo.setClave_formula(rs.getString("clave_formula"));
                mo.setDimension_bruta2(rs.getString("dimension_bruta2"));
                mo.setCantidad_piezas_bruto(rs.getString("cantidad_piezas_bruto"));
                mo.setDimension_bruta3(rs.getString("dimension_bruta3"));
                mo.setCtd_piezas_bruto(rs.getString("ctd_piezas_bruto"));
                mo.setUnidad_medida_componente_pieza_bruto(rs.getString("unidad_medida_componente_pieza_bruto"));
                mo.setCodigo_iso_p_unidad_medida(rs.getString("codigo_iso_p_unidad_medida"));
                mo.setNum_largo_material(rs.getString("num_largo_material"));
                mo.setUid_externo_campo_material(rs.getString("uid_externo_campo_material"));
                mo.setNum_version_campo_material(rs.getString("num_version_campo_material"));
                mo.setFecha_necesidad_componente(rs.getString("fecha_necesidad_componente"));
                mo.setFecha_necesidad_cantidad_reserva(rs.getString("fecha_necesidad_cantidad_reserva"));
                mo.setIn_actualizacion_manual_fecha_necesidad(rs.getString("in_actualizacion_manual_fecha_necesidad"));
                mo.setNum_material_long(rs.getString("num_material_long"));
                moc.add(mo);
            }
        } catch (Exception e) {
            System.out.println("Error en CargarmaterialesordenesCrea por " + e);
        }
        cnx.CerrarConexion(con);
        return moc;
    }

    public operaciones_ordenes_crea CargarDataCabSAP(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        operaciones_ordenes_crea coc = new operaciones_ordenes_crea();
        String SP = "{CALL PM.Ordenes_CargarCabeceraSAP(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            while (rs.next()) {
                coc.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));
                coc.setClase_coste(rs.getString("clase_coste"));
                coc.setNum_operacion(rs.getString("num_operacion"));
                coc.setCentro(rs.getString("centro"));
                coc.setClave_control(rs.getString("clave_control"));
                coc.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                coc.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                coc.setCantidad_operacion(rs.getString("cantidad_operacion"));
                coc.setDuracion_operacion(rs.getString("duracion_operacion"));
                coc.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                coc.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarDataCabSAP(ACC_Orden por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return coc;
    }

    public operaciones_ordenes_crea cargaroperacionescrea(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        operaciones_ordenes_crea op = new operaciones_ordenes_crea();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));
            }
        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
        }
        cnx.CerrarConexion(con);
        return op;
    }

    public boolean COMPFOLORdenNOT(String ord) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.op_ord_crea_COMPFOLORdenNOT(?)}";
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

    public LinkedList<operaciones_ordenes_crea> cargartablaoperacionescreaNOTI(String ord, String ope) {
        LinkedList<operaciones_ordenes_crea> opc = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.op_ord_crea(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {
                operaciones_ordenes_crea op = new operaciones_ordenes_crea();
                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));
                opc.add(op);
            }

        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
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
        return opc;
    }

    public operaciones_ordenes_crea OBTFOLORdenNOT(String ord) {
        operaciones_ordenes_crea op = new operaciones_ordenes_crea();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.op_ord_crea_COMPFOLORdenNOT(?)}";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                op.setCentro(rs.getString("centro"));
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
        return op;
    }

    public operaciones_ordenes_crea cargartablaNOoperacionescreaP3(String ord, String ope) {
        operaciones_ordenes_crea op = new operaciones_ordenes_crea();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.operaciones_ordenes_cargartablaNOoperacionescreaP3(?,?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {

                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));

            }
        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
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
        return op;
    }

    public LinkedList<materiales_ordenes_crea> MostraTABPM01NO(String ord, String ope) {
        LinkedList<materiales_ordenes_crea> mpm = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.materiales_ordenes_crea_MostraTABPM01NO(?,?)}";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales_ordenes_crea ma = new materiales_ordenes_crea();
                ma.setNum_reserva(rs.getString("num_reserva"));
                ma.setNum_posicion_reserva(rs.getString("num_posicion_reserva"));
                ma.setNum_material(rs.getString("num_material"));
                ma.setLote(rs.getString("lote"));
                ma.setUnidad_medida_componente_pieza_bruto(rs.getString("unidad_medida_componente_pieza_bruto"));
                ma.setCantidad_necesaria_componente2(rs.getString("cantidad_necesaria_componente2"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setCentro(rs.getString("centro"));
                ma.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                ma.setAlmacen(rs.getString("almacen"));
                ma.setTexto_posicion_lista_materiales(rs.getString("texto_posicion_lista_materiales"));
                mpm.add(ma);
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
        return mpm;
    }

    public operaciones_ordenes_crea cartabopecrP3(String ord, String ope) {
        operaciones_ordenes_crea op = new operaciones_ordenes_crea();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.operaciones_ordenes_crea_cartabopcreP3(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {

                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));

            }
        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
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
        return op;
    }

    public LinkedList<servicios_ordenes_crea> COnsuTAMNOPM023(String ord) {
        LinkedList<servicios_ordenes_crea> so = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.servicios_ordenes_crea_COnsuTAMPM023(?)}";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                servicios_ordenes_crea sc = new servicios_ordenes_crea();
                sc.setFolio_sam(rs.getString("folio_sam"));
                sc.setNum_paquete(rs.getString("num_paquete"));
                sc.setNum_linea1(rs.getString("num_linea1"));
                sc.setNum_linea2(rs.getString("num_linea2"));
                sc.setIndicador_borrado(rs.getString("indicador_borrado"));
                sc.setNum_servicio(rs.getString("num_servicio"));
                sc.setNivel_jerarquico_grupo(rs.getString("nivel_jerarquico_grupo"));
                sc.setNivel_estructura(rs.getString("nivel_estructura"));
                sc.setAsignacion_servicio(rs.getString("asignacion_servicio"));
                sc.setNum_subpaquete(rs.getString("num_subpaquete"));
                sc.setDenominacion_ambito_servicio(rs.getString("denominacion_ambito_servicio"));
                sc.setEdicion_ambito_servicio(rs.getString("edicion_ambito_servicio"));
                sc.setPosicion_catalogo_prestaciones_estandar(rs.getString("posicion_catalogo_prestaciones_estandar"));
                sc.setNum_servicio_proveedor(rs.getString("num_servicio_proveedor"));
                sc.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                sc.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                sc.setTolerancia_sobrecumplimiento(rs.getString("tolerancia_sobrecumplimiento"));
                sc.setSobrecumplimiento_ilimitado(rs.getString("sobrecumplimiento_ilimitado"));
                sc.setBusqueda_limites(rs.getString("busqueda_limites"));
                sc.setActualizar_condiciones(rs.getString("actualizar_condiciones"));
                sc.setCantidad_base(rs.getString("cantidad_base"));
                sc.setPrecio_bruto(rs.getString("precio_bruto"));
                sc.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
                sc.setLimite_inferior(rs.getString("limite_inferior"));
                sc.setLimite_superior(rs.getString("limite_superior"));
                sc.setTexto_breve(rs.getString("texto_breve"));
                sc.setIndicador_distribucion_imputacion_multiple(rs.getString("indicador_distribucion_imputacion_multiple"));
                sc.setIndicador_factura_parcial(rs.getString("indicador_factura_parcial"));
                sc.setNum_personal(rs.getString("num_personal"));
                sc.setAgrupacion_paises(rs.getString("agrupacion_paises"));
                sc.setCc_nomina(rs.getString("cc_nomina"));
                sc.setTexto_explicativo_cc_nomina(rs.getString("texto_explicativo_cc_nomina"));
                sc.setFuncion(rs.getString("funcion"));
                sc.setNum_actual_tablas_interfaces(rs.getString("num_actual_tablas_interfaces"));
                sc.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
                sc.setFecha_activado_registro_tabla(rs.getString("fecha_activado_registro_tabla"));
                sc.setNum_paquete_original(rs.getString("num_paquete_original"));
                sc.setEntrada_linea_paquete_plan(rs.getString("entrada_linea_paquete_plan"));
                sc.setEntrada_no_planif_pedido(rs.getString("entrada_no_planif_pedido"));
                sc.setEntrada_no_planif_contr(rs.getString("entrada_no_planif_contr"));
                sc.setEntrada_servicio_no_planificado_modelo(rs.getString("entrada_servicio_no_planificado_modelo"));
                sc.setEntrada_servicio_no_planificado_cp_modelo(rs.getString("entrada_servicio_no_planificado_cp_modelo"));
                sc.setLinea_servicio_refiere_limites_cpe(rs.getString("linea_servicio_refiere_limites_cpe"));
                sc.setEntrada_no_plan_linea_limite(rs.getString("entrada_no_plan_linea_limite"));
                sc.setPedido_cantidad_entrada(rs.getString("pedido_cantidad_entrada"));
                sc.setValor_registrado(rs.getString("valor_registrado"));
                sc.setPedido_abierto_valor_ordenado(rs.getString("pedido_abierto_valor_ordenado"));
                sc.setPedido_abierto_cantidad_ordenada(rs.getString("pedido_abierto_cantidad_ordenada"));
                sc.setValor_previsto(rs.getString("valor_previsto"));
                sc.setPedido_abierto_valor_llamado_no_planif(rs.getString("pedido_abierto_valor_llamado_no_planif"));
                sc.setPedido_abierto_cantidad_ordenada_forma_no_plan(rs.getString("pedido_abierto_cantidad_ordenada_forma_no_plan"));
                sc.setAlternativa_nota_posicion_base(rs.getString("alternativa_nota_posicion_base"));
                sc.setLinea_base(rs.getString("linea_base"));
                sc.setLinea_alternativa(rs.getString("linea_alternativa"));
                sc.setLinea_licitante(rs.getString("linea_licitante"));
                sc.setLinea_suplementaria(rs.getString("linea_suplementaria"));
                sc.setLinea_cantidad_libre(rs.getString("linea_cantidad_libre"));
                sc.setLinea_informativa(rs.getString("linea_informativa"));
                sc.setLinea_global(rs.getString("linea_global"));
                sc.setLinea_reserva(rs.getString("linea_reserva"));
                sc.setIndicador_iva(rs.getString("indicador_iva"));
                sc.setDomicilio_fiscal(rs.getString("domicilio_fiscal"));
                sc.setModificacion_precio_hoja_entrada(rs.getString("modificacion_precio_hoja_entrada"));
                sc.setGrupo_articulos(rs.getString("grupo_articulos"));
                sc.setPrecio_bruto2(rs.getString("precio_bruto2"));
                sc.setIva_soportado_no_deducible(rs.getString("iva_soportado_no_deducible"));
                sc.setImporte_base_impuesto(rs.getString("importe_base_impuesto"));
                sc.setNum_condicion_doc(rs.getString("num_condicion_doc"));
                sc.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                sc.setTrabajo_interno(rs.getString("trabajo_interno"));
                sc.setClave_referencia_srm(rs.getString("clave_referencia_srm"));
                sc.setClase_coste(rs.getString("clase_coste"));
                sc.setTrabajo_interno2(rs.getString("trabajo_interno2"));
                sc.setCpo_asignacion(rs.getString("cpo_asignacion"));
                sc.setClave_posicion_mensaje_esoa(rs.getString("clave_posicion_mensaje_esoa"));
                sc.setTax_tariff_code(rs.getString("tax_tariff_code"));
                sc.setFecha(rs.getString("fecha"));
                sc.setHora_inicio(rs.getString("hora_inicio"));
                sc.setHora_final(rs.getString("hora_final"));
                sc.setNum_externo_personal(rs.getString("num_externo_personal"));
                sc.setContador_registro_entrada_tiempos(rs.getString("contador_registro_entrada_tiempos"));
                sc.setIndicador_doc_anulado(rs.getString("indicador_doc_anulado"));
                sc.setNum_doc(rs.getString("num_doc"));
                sc.setNum_formula(rs.getString("num_formula"));
                sc.setValor_formula1(rs.getString("valor_formula1"));
                sc.setValor_formula2(rs.getString("valor_formula2"));
                sc.setValor_formula3(rs.getString("valor_formula3"));
                sc.setValor_formula4(rs.getString("valor_formula4"));
                sc.setValor_formula5(rs.getString("valor_formula5"));
                sc.setCampo_personalizado1(rs.getString("campo_personalizado1"));
                sc.setCampo_personalizado2(rs.getString("campo_personalizado2"));
                sc.setCampo_personalizado3(rs.getString("campo_personalizado3"));
                sc.setCampo_personalizado4(rs.getString("campo_personalizado4"));
                sc.setNum_objeto_modulo_relaciones_asignado(rs.getString("num_objeto_modulo_relaciones_asignado"));
                sc.setModificacion_texto_breve_permitida(rs.getString("modificacion_texto_breve_permitida"));
                sc.setNum_calculo_coste(rs.getString("num_calculo_coste"));
                sc.setVariante_cal_coste(rs.getString("variante_cal_coste"));
                sc.setIdentificacion_lines(rs.getString("identificacion_lines"));
                sc.setLinea_interna(rs.getString("linea_interna"));
                sc.setGrupo_subcontratista(rs.getString("grupo_subcontratista"));
                sc.setLinea_riesgo(rs.getString("linea_riesgo"));
                sc.setCasilla_seleccion(rs.getString("casilla_seleccion"));
                sc.setModificacion_texto_explicativo(rs.getString("modificacion_texto_explicativo"));
                sc.setNum_grupo_numero_asignacion_ejecucion(rs.getString("num_grupo_numero_asignacion_ejecucion"));
                sc.setNum_actual_num_asignacion_ejecucion(rs.getString("num_actual_num_asignacion_ejecucion"));
                sc.setIndicador_immpresion(rs.getString("indicador_immpresion"));
                sc.setNum_suplementario(rs.getString("num_suplementario"));
                sc.setStatus_suplemento(rs.getString("status_suplemento"));
                sc.setTipo_objeto_linea_catalogo_servicios(rs.getString("tipo_objeto_linea_catalogo_servicios"));
                sc.setNum_subposicion(rs.getString("num_subposicion"));
                sc.setNum_linea(rs.getString("num_linea"));
                sc.setEntrada_servicio_permitida(rs.getString("entrada_servicio_permitida"));
                sc.setTamano_lote_calculo_costes(rs.getString("tamano_lote_calculo_costes"));
                sc.setPrecio_global_posicion_principal_definida(rs.getString("precio_global_posicion_principal_definida"));
                sc.setClave_referencia_externa_prestacion(rs.getString("clave_referencia_externa_prestacion"));
                sc.setPedido_cantidad_registrada_factura(rs.getString("pedido_cantidad_registrada_factura"));
                sc.setFecha_inicio_periodo_prestacion_servicios(rs.getString("fecha_inicio_periodo_prestacion_servicios"));
                sc.setFecha_fin_periodo_prestacion_servicios(rs.getString("fecha_fin_periodo_prestacion_servicios"));
                so.add(sc);
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
        return so;
    }

    public operaciones_ordenes_crea cargartablaoperacionescreaP3NOT(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        operaciones_ordenes_crea op = new operaciones_ordenes_crea();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.operaciones_ordenes_creaCONSULTALL(?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {

                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));

            }
        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
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
        return op;
    }

    public ArrayList<plan_orden> SP_MatchOrdenListaorden(String limite, String orden, String texto) {
        ArrayList<plan_orden> sp_planorden = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.MatchOrdenListaorden(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, limite);
            pst.setString(2, orden);
            pst.setString(3, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_planorden.add(ord);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_planorden;
    }
    public ArrayList<plan_orden> SP_MatchOrdenListaordenSAM(String orden, String texto) {
        ArrayList<plan_orden> sp_planorden = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ListaOrdenes_CargarSAM(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setFolio_sam(rs.getString("folio_sam"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_planorden.add(ord);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_planorden;
    }

    public ArrayList<clase_orden> SP_MatchClaseOrdenListaorden(String limite, String Idioma, String orden, String texto) {
        ArrayList<clase_orden> sp_claseorden = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.MatchClaseOrdenListaorden(?,?,?,?)}";
        String descripcion = "descripcion_" + Idioma;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, limite);
            pst.setString(2, Idioma);
            pst.setString(3, orden);
            pst.setString(4, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                clase_orden ord = new clase_orden();
                ord.setClase_orden(rs.getString("clase_orden"));
                ord.setDescripcion(rs.getString(descripcion));
                sp_claseorden.add(ord);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_claseorden;
    }
    //Visualizar Ordenes PP
    public String ValidarTipoOrdenPP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PP.Ordenes_ValidarOrdenVisualizarPP(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo Visualizar Orden PP por: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }
    
}
