/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Cabecera_ordenes_crea;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Ficheros;
import AccesoDatos.ACC_MaterialesOrdenesCrea;
import AccesoDatos.ACC_OperacionesOrdenesCrea;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_OrdenesControl;
import AccesoDatos.ACC_OrdenesEmplazamiento;
import AccesoDatos.ACC_OrdenesPlanificacion;
import AccesoDatos.ACC_PlanOrden;
import AccesoDatos.ACC_ServiciosOrdenesCrea;
import AccesoDatos.ACC_ServiciosPM;
import AccesoDatos.ACC_UbicacionTecnica;
import AccesoDatos.Consultas;
import Entidades.DmsDocs;
import Entidades.Ficheros;
import Entidades.cabecera_ordenes_crea;
import Entidades.componentes;
import Entidades.equipos;
import Entidades.materiales_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import Entidades.ordenes_control;
import Entidades.ordenes_emplazamiento;
import Entidades.ordenes_planificacion;
import Entidades.plan_orden;
import Entidades.planop;
import Entidades.servicios_ordenes_crea;
import Entidades.servicios_pm;
import Entidades.ubicacion_tecnica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionVisualizarOrden2PP", urlPatterns = {"/PeticionVisualizarOrden2PP"})
public class PeticionVisualizarOrden2PP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Accion = request.getParameter("acc");
            String orden = request.getParameter("ord");
            String ruta = request.getParameter("ruta");
            String ip = request.getRemoteAddr();
            String clave = request.getParameter("Clave");
            String or = request.getParameter("NumOr");
            String opera = request.getParameter("Ope");
            String equi = request.getParameter("equi");
            String centroo = request.getParameter("centroo");
            
            Consultas con =  new Consultas();
            cabecera_ordenes_crea coc;
            operaciones_ordenes_crea ooc;
            ordenes_emplazamiento oe;
            ordenes_planificacion op;
            ordenes_control oc;
            equipos eq;
            ubicacion_tecnica ub;
            int c = 0;
            switch (Accion) {

                case "CargarDatosCabeceraSAM":
                    coc = ACC_Cabecera_ordenes_crea.ObtenerInstancia().SP_CargarDatosCabecera(orden);
                    ooc = ACC_OperacionesOrdenesCrea.ObtenerInstancia().CargarFirstOpeSAM(orden);
                    JSONArray js = new JSONArray();
                    js.add(coc.getClase_orden());
                    js.add(coc.getTexto_breve());
                    js.add(coc.getPuesto_trabajo_responsable_medidas_mante());
                    js.add(coc.getCentro_planificacion_mantenimiento());
                    js.add(con.DateFormat(coc.getFecha_inicio_extrema()));
                    js.add(con.DateFormat(coc.getFecha_fin_extrema()));
                    js.add(coc.getUbicacion_tecnica());
                    js.add(coc.getNum_equipo());
                    js.add(ooc.getNum_operacion());
                    js.add(ooc.getNum_solped());
                    js.add(ooc.getCentro());
                    js.add(ooc.getClave_control());
                    js.add(ooc.getCantidad_base());
                    js.add(ooc.getDuracion_operacion());
                    js.add(ooc.getUnidad_duracion_normal());
                    String grup = ACC_Cabecera_ordenes_crea.ObtenerInstancia().GetGPPlanEquipo(coc.getNum_equipo());
                    js.add(grup);
                    js.add(ooc.getTexto_breve_operacion());
                    out.println(js);
                    break;
                case "CargarDatosCabeceraSAP":
                    plan_orden po = ACC_Orden.ObtenerInstancia().CargarCabeceraPP(orden);
                    planop plop = ACC_Orden.ObtenerInstancia().CargarFirstOpePP(orden);
                    if (po.getNum_orden() == "" || po.getNum_orden() == null) {
                        out.println(0);
                    } else {
                        js = new JSONArray();
                        js.add(po.getClase_doc_ventas());
                        js.add(po.getTexto_breve());
                        js.add(po.getStatus_sistema());
                        js.add(po.getPuesto_trabajo_responsables_medidas_mante());
                        js.add(po.getCentro_puesto_trabajo_responsable());
                        js.add(po.getNum_notificacion());
                        js.add(po.getGastos_general_estimado_orden());
                        js.add(po.getClase_actividad_mante());
                        js.add(po.getEstado_instalacion());
                        js.add(con.DateFormat(po.getFecha_inicio_extrema()));
                        js.add(con.DateFormat(po.getFecha_fin_extrema()));
                        js.add(po.getPrioridad());
                        js.add(po.getRevision_mante_servicio_cliente());
                        js.add(po.getUbicacion_tecnica());
                        js.add(po.getDenominacion_ubitec());
                        js.add(po.getNum_equipo());
                        js.add(po.getDenominacion_objeto_tecnico());
                        js.add(po.getConjunto());
                        js.add(plop.getNum_operacion());
                        js.add(plop.getClave_calculo());
                        js.add(plop.getPuesto_trabajo());
                        js.add(plop.getCentro());
                        js.add(plop.getClave_control());
                        js.add(plop.getClase_actividad());
                        js.add(plop.getIndicador_asignar_medio_auxiliar_fabricacion());
                        js.add(plop.getTrabajo_operacion());
                        js.add(plop.getUnidad_trabajo());
                        js.add(plop.getCantidad_capacidad_necesidad());
                        js.add(plop.getDuracion_operacion_normal());
                        js.add(plop.getUnidad_duracion_normal());
                        js.add(plop.getIndicador_asignar_componentes());
                        String grup2 = ACC_Cabecera_ordenes_crea.ObtenerInstancia().GetGPPlanEquipo(po.getNum_equipo());
                        js.add(grup2);
                        js.add(plop.getTexto_breve_operacion());
                        out.println(js);
                    }
                    break;
                case "CargarTablaOpSAM":
                    int x;
                    ArrayList<operaciones_ordenes_crea> modOpeLst = ACC_OperacionesOrdenesCrea.ObtenerInstancia().ConsultarOperacionesSAM(orden);
                    if (modOpeLst.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (x = 0; x < modOpeLst.size(); x++) {
                            out.println("<tr ondblclick=\"SelectServices('" + modOpeLst.get(x).getClave_control() + "|" + modOpeLst.get(x).getNum_operacion() + "')\">");
                            out.println("<td>" + modOpeLst.get(x).getNum_operacion() + "</td>");
                            out.println("<td>" + modOpeLst.get(x).getNum_solped() + "</td>");
                            out.println("<td>" + modOpeLst.get(x).getCentro() + "</td>");
                            out.println("<td>" + modOpeLst.get(x).getClave_control() + "</td>");
                            out.println("<td class=\"tddescr\">" + modOpeLst.get(x).getTexto_breve_operacion() + "</td>");
                            out.println("<td class=\"tdte\"><button class=\"BtnMatchIconDescri\" onclick=\"AbrirMatchDes('" + modOpeLst.get(x).getNum_operacion() + "','CargatTxtSAM')\"></button></td>");
                            out.println("<td>" + modOpeLst.get(x).getCantidad_base()+ "</td>");
                            out.println("<td>" + modOpeLst.get(x).getDuracion_operacion()+ "</td>");
                            out.println("<td>" + modOpeLst.get(x).getUnidad_duracion_normal() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        for (int j = x; j < 10; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"tddescr\">&nbsp;</td>"
                                    + "<td class=\"tdte\"></td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println("<tbody>");
                        for (int j = 0; j < 15; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"tddescr\">&nbsp;</td>"
                                    + "<td class=\"tdte\"></td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                    break;
                case "CargarTablaOpSAP":
                    ArrayList<planop> hr = ACC_Orden.ObtenerInstancia().CargarOperacionesPP(orden);
                    if (hr.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (x = 0; x < hr.size(); x++) {
                            out.println("<tr ondblclick=\"SelectServices('" + hr.get(x).getClave_control() + "|" + hr.get(x).getNum_operacion() + "')\">");
                            out.println("<td>" + hr.get(x).getNum_operacion() + "</td>");
                            out.println("<td>" + hr.get(x).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + hr.get(x).getCentro() + "</td>");
                            out.println("<td>" + hr.get(x).getClave_control() + "</td>");
                            out.println("<td class=\"tddescr\">" + hr.get(x).getTexto_breve_operacion() + "</td>");
                            out.println("<td class=\"tdte\"><button class=\"BtnMatchIconDescri\" onclick=\"AbrirMatchDes('" + hr.get(x).getNum_operacion() + "','CargatTxtSAP')\"></button></td>");
                            out.println("<td>" + hr.get(x).getCantidad_capacidad_necesidad() + "</td>");
                            out.println("<td>" + hr.get(x).getDuracion_operacion_normal() + "</td>");
                            out.println("<td>" + hr.get(x).getUnidad_duracion_normal() + "</td>");
                            out.println("<td>" + hr.get(x).getNum_equipo() + "</td>");//Número de Material
                            out.println("<td>" + hr.get(x).getNum_notificacion() + "</td>");
                            out.println("</tr>");
                        }
                        for (int j = x; j < 10; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"tddescr\">&nbsp;</td>"
                                    + "<td class=\"tdte\"></td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int j = 0; j < 15; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"tddescr\">&nbsp;</td>"
                                    + "<td class=\"tdte\"></td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                    break;
                case "CargarTablaCompSAM":
                    int w;
                    ArrayList<materiales_ordenes_crea> modLstM = ACC_MaterialesOrdenesCrea.ObtenerInstancia().ConsultaMaterialesSAM(orden);
                    if (modLstM.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (w = 0; w < modLstM.size(); w++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>" + modLstM.get(w).getNum_material() + "</td>");
                            out.println("<td class=\"tddescr\">" + modLstM.get(w).getTexto_breve_material() + "</td>");
                            out.println("<td>" + modLstM.get(w).getCantidad_base() + "</td>");
                            out.println("<td>" + modLstM.get(w).getUnidad_medida_base() + "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>" + modLstM.get(w).getAlmacen() + "</td>");
                            out.println("<td>" + modLstM.get(w).getCentro() + "</td>");
                            out.println("<td>" + modLstM.get(w).getNum_operacion() + "</td>");
                            out.println("<td>" + modLstM.get(w).getLote() + "</td>");
                            out.println("</tr>");
                        }
                        for (int n = w; n < 15; n++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"tddescr\">&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int j = 0; j < 15; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"tddescr\">&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    }

                    break;
                case "CargarTablaCompSAP":
                    ArrayList<componentes> com = ACC_Orden.ObtenerInstancia().CargarComponentesPP(orden);
                    if (com.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (w = 0; w < com.size(); w++) {
                            out.println("<tr>");
                            out.println("<td>" + com.get(w).getNum_posicion_lista_material() + "</td>");
                            out.println("<td>" + com.get(w).getNum_material() + "</td>");
                            out.println("<td class=\"tddescr\">" + com.get(w).getTexto_breve_material() + "</td>");
                            out.println("<td>" + com.get(w).getCantidad_necesaria_componente() + "</td>");
                            out.println("<td>" + com.get(w).getUnidad_medida_base() + "</td>");
                            out.println("<td>" + com.get(w).getTipo_posicion_lista_material() + "</td>");
                            out.println("<td>" + com.get(w).getAlmacen() + "</td>");
                            out.println("<td>" + com.get(w).getCentro() + "</td>");
                            out.println("<td>" + com.get(w).getNum_operacion() + "</td>");
                            out.println("<td>" + com.get(w).getNum_lote() + "</td>");
                            out.println("</tr>");
                        }
                        for (int n = w; n < 15; n++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"tddescr\">&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int j = 0; j < 15; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"tddescr\">&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                    break;
                case "GetDatosTabla":
                    String pm02 = "PM02";
                    String pm03 = "PM03";
                    if (clave.equals(pm02) || clave.equals(pm03)) {
                        ArrayList<servicios_ordenes_crea> sc = ACC_ServiciosOrdenesCrea.ObtenerInstancia().ObtieneServiciosOrdenesCrea(or, opera);
                        if (sc.size() > 0) {
                            out.println("<tbody>");
                            for (int i = 0; i < sc.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>" + sc.get(i).getNum_servicio() + "</td>");
                                out.println("<td>" + sc.get(i).getCantidad_con_signo() + "</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + sc.get(i).getUnidad_medida_base() + "</td>");
                                out.println("<td>" + sc.get(i).getGrupo_articulos() + "</td>");
                                out.println("<td>" + sc.get(i).getClase_coste() + "</td>");
                                out.println("</tr>");
                            }
                            for (int j = 0; j < 5; j++) {
                                out.println(""
                                        + "<tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.println("</tbody>");
                        } else {
                            for (int k = 0; k < 8; k++) {
                                out.println(""
                                        + "<tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.println("</tbody>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "GetDatosTablaSAP":
                    pm02 = "PM02";
                    if (clave.equals(pm02)) {
                        ArrayList<servicios_pm> sc = ACC_ServiciosPM.ObtenerInstancia().CargarServiciosPP(or, opera);
                        if (sc.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < sc.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>" + sc.get(i).getNum_servicio() + "</td>");
                                out.println("<td>" + sc.get(i).getCant_signo() + "</td>");
                                out.println("<td>" + "&nbsp;" + "</td>");
                                out.println("<td>" + sc.get(i).getUnidad_med_base() + "</td>");
                                out.println("<td>" + sc.get(i).getGrupo_articulos() + "</td>");
                                out.println("<td>" + sc.get(i).getClase_coste() + "</td>");
                                out.println("</tr>");
                            }
                            for (int j = 0; j < 5; j++) {
                                out.println(""
                                        + "<tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            for (int k = 0; k < 8; k++) {
                                out.println(""
                                        + "</tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarEmplzSAP":
                    oe = ACC_OrdenesEmplazamiento.ObtenerInstancia().CargarDataEmplazamientoPP(orden);
                    js = new JSONArray();
                    js.add(oe.getCentro_emplazamiento());
                    js.add(oe.getEmplazamiento_objeto_mantenimiento());
                    js.add(oe.getLocall());
                    js.add(oe.getArea_empresa());
                    js.add(oe.getPuesto_trabajo());
                    js.add(oe.getIndicador_abc());
                    js.add(oe.getCampo_clasificacion());
                    js.add(oe.getSociedad());
                    js.add(oe.getNum_principal_activo_fijo());
                    js.add(oe.getSubnumero_activo_fijo());
                    js.add(oe.getCentro_coste());
                    js.add(oe.getElemento_plan_estructura());
                    out.println(js);
                    break;
                case "CargarEmplzSAMequi":
                    eq = ACC_Equipos.ObtenerInstancia().CargarDataEmplazamientoSAM(clave);
                    js = new JSONArray();
                    js.add(eq.getCentro_emplazamiento());
                    js.add(eq.getEmplazamiento_activofijo());
                    js.add(eq.getArea_empresa());
                    js.add(eq.getPuesto_responsable_medmnte());
                    js.add(eq.getIndicador_abc());
                    js.add(eq.getCampo_clasificacion());
                    js.add(eq.getSociedad());
                    js.add(eq.getNum_activofijo_vehiculo());
                    js.add(eq.getCentro_coste());
                    out.println(js);
                    break;
                case "CargarEmplzSAMubi":
                    ub = ACC_UbicacionTecnica.ObtenerInstancia().CargarDataEmplazamientoSAMubi(clave);
                    js = new JSONArray();
                    js.add(ub.getCentro_emplazamiento());
                    js.add(ub.getEmplazamiento_activo_fijo());
                    js.add(ub.getArea_empresa());
                    js.add(ub.getPuesto_trabajo());
                    js.add(ub.getIndicador_abc());
                    js.add(ub.getCampo_clasificacion());
                    js.add(ub.getSociedad());
                    js.add(ub.getCentro_coste());
                    out.println(js);
                    break;
                case "CargarPlanifSAP":
                    op = ACC_OrdenesPlanificacion.ObtenerInstancia().CargarDataPlanificacionPP(orden);
                    js = new JSONArray();
                    js.add(op.getPlan_mantenimiento_preventivo());
                    js.add(op.getPosicion_mantenimiento());
                    js.add(op.getTipo_hoja_ruta());
                    js.add(op.getClave_grupo_hoja_ruta());
                    js.add(op.getContador_grupo_hoja_ruta());
                    out.println(js);
                    break;
                case "CargarCtrlSAP":
                    oc = ACC_OrdenesControl.ObtenerInstancia().CargarDataCtrlPP(orden);
                    js = new JSONArray();
                    js.add(oc.getNombre_autor());
                    js.add(con.DateFormat(oc.getFecha_entrada()));
                    js.add(oc.getModificado_por());
                    js.add(con.DateFormat(oc.getFecha_modificacion()));
                    out.println(js);
                    break;
                case "CargarCtrlSAM":
                    coc = ACC_Cabecera_ordenes_crea.ObtenerInstancia().CargarDataCtrlSAM(orden);
                    js = new JSONArray();
                    js.add(con.DateFormat(coc.getFecha()));
                    js.add(coc.getUsuario());
                    js.add(con.DateFormat(coc.getFecha_ultima_modificacion()));
                    out.println(js);
                    break;
                case "CargatTxtSAM":
                      ArrayList<plan_orden> tspt = ACC_PlanOrden.ObtenerInstancia().CargarTextoPosicion(orden, opera, "X");
                        String cat = "";
                        for (int j = 0; j < tspt.size(); j++) {
                            cat += tspt.get(j).getTexto();
                        }
                        out.println(cat);
                    break;
                case "CargatTxtSAP":
                    ArrayList<plan_orden> tspt2 = ACC_PlanOrden.ObtenerInstancia().CargarTextoPosicion(orden, opera, "");
                        String cat2 = "";
                        for (int j = 0; j < tspt2.size(); j++) {
                            cat2 += tspt2.get(j).getTexto();
                        }
                        out.println(cat2);
                    break;
                case "matchDocs":
                    ArrayList<DmsDocs> dcs = ACC_Ficheros.ObtenerInstancia().MostEqVisOrd(equi);
                    int cont = 0,
                     c2 = 0;
                    ArrayList<Ficheros> fii = new ArrayList<>();
                    if (dcs.size() > 0) {
                        out.println("<table id=\"TabBody4\">\n"
                                + "<tbody>");
                        for (cont = 0; cont < dcs.size(); cont++) {
                            String ruttap1 = "C:/OffLine/DMS/" + centroo + "/" + dcs.get(cont).getClase_documento();
                            fii = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
                            for (Ficheros nf : fii) {
                                String nomaj = nf.getName();
                                String sjk = dcs.get(cont).getCampo_texto_longitud();
                                if (sjk.equals(nomaj)) {
//                                    out.println("<tr ondblclick=\"SendPath('" + c2 + "')\">"
                                    out.println("<tr ondblclick=\"abrVen('" + c2 + "')\">"     
                                            + "<td>" + nf.getApl() + "</td>"
                                            + "<td>" + nf.getName() + "</td>"
                                            + "<td>" + nf.getAplicacion() + "</td>"
                                            + "<td name=\"tdFch\">" + nf.getFichero() + "</td>"
                                            + "</tr>");
                                    c2++;
                                }
                            }
                        }
                        for (int c1 = cont; c1 < 12; c1++) {
                            out.println("<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>0000000000000000</td>"
                                + "<td>00000000000000000000000000</td>"
                                + "<td>00000000000000000</td>"
                                + "<td>000000000000000000000000000000000000000000000000</td>"
                                + "</tr>"
                                + "</tbody>"
                                + "</table>");

                    } else {
                        out.println(0);
                    }
                    break;
                    case "EnviarSocket":
                    String[] cdd = ruta.split(",");
                    if (ACC_Ficheros.ObtenerInstancia().SendFile("C:\\OffLine\\DMS\\" +cdd[0] + "\\" + cdd[1] + "\\" + cdd[2], ip)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                case "EnviarMod":
                    String[] cdm = ruta.split(",");
                    if (ACC_Ficheros.ObtenerInstancia().SendMod("C:\\OffLine\\DMS\\" +cdm[0] + "\\" + cdm[1] + "\\" + cdm[2], ip)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
