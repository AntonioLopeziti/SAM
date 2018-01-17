/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_OperacionesOrdenesCrea;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_ServiciosOrdenesCrea;
import AccesoDatos.ACC_ServiciosPM;
import Entidades.cabecera_ordenes_crea;
import Entidades.componentes;
import Entidades.materiales_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import Entidades.plan_orden;
import Entidades.planop;
import Entidades.servicios_ordenes_crea;
import Entidades.servicios_pm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio
 */
@WebServlet(name = "peticionVisualizarCreaOrdenes", urlPatterns = {"/peticionVisualizarCreaOrdenes"})
public class peticionVisualizarCreaOrdenes extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Accion = request.getParameter("acc");
            String orden = request.getParameter("ord");
            /*pm02, orden, operacion*/
            String clave = request.getParameter("Clave");
            String or = request.getParameter("NumOr");
            String opera = request.getParameter("Ope");

            switch (Accion) {
                case "CargarDatosCabecera":
                    String querydat = "SELECT * FROM cabecera_ordenes_crea WHERE  folio_sam='" + orden + "'";
                    String queryope = "SELECT * FROM operaciones_ordenes_crea WHERE  folio_sam='" + orden + "'";
                    cabecera_ordenes_crea po = ACC_Orden.ObtenerInstancia().CargarCabeceraCrea(querydat);
                    operaciones_ordenes_crea plop = ACC_Orden.ObtenerInstancia().cargaroperacionescrea(queryope);
                    if (po.getNum_orden() == "" || po.getNum_orden() == null) {
                        out.println(0);
                    } else {
                        out.println("<input type=\"text\" id=\"claseOrden_orden2\" value=\"" + po.getClase_orden() + "\"/>");
                        out.println("<input type=\"text\" id=\"Des_orden2\" value=\"" + po.getTexto_breve() + "\"/>");
                        out.println("<input type=\"text\" id=\"statusSis_orden2\" value=\" Orden Creada SAM \"/>");
                        out.println("<input type=\"text\" id=\"rs_ord2\" value=\"" + po.getPuesto_trabajo_responsable_medidas_mante() + "\"/>");
                        out.println("<input type=\"text\" id=\"rs2_ord2\" value=\"" + po.getCentro_planificacion_mantenimiento() + "\"/>");
                        out.println("<input type=\"text\" id=\"not_ord2\" value=\"" + plop.getNum_notificacion_operacion() + "\"/>");
                        out.println("<input type=\"text\" id=\"cos_ord2\" value=\"" + plop.getClase_coste() + "\"/>");
                        out.println("<input type=\"text\" id=\"Cl_ord2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"Est_ord2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"inic_ord2\" value=\"" + po.getFecha_inicio_extrema() + "\"/>");
                        out.println("<input type=\"text\" id=\"fin_ord2\" value=\"" + po.getFecha_fin_extrema() + "\"/>");
                        out.println("<input type=\"text\" id=\"prior_ord2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"revi_ord2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"ubic_ord2\" value=\"" + po.getUbicacion_tecnica() + "\"/>");
                        out.println("<input type=\"text\" id=\"lbldescr_ord12\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"equ_ord2\" value=\"" + po.getNum_equipo() + "\"/>");
                        out.println("<input type=\"text\" id=\"desequipo2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"Conj_ord2\" value=\"\"\"/>");
                        out.println("<input type=\"text\" id=\"opera_ord2\" value=\"" + plop.getNum_operacion() + "\"/>");
                        out.println("<input type=\"text\" id=\"Clvca_ord2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"ptotr_ord2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"ptotr2_ord2\" value=\"" + plop.getCentro() + "\"/>");
                        out.println("<input type=\"text\" id=\"clvctrol_ord2\" value=\"" + plop.getClave_control() + "\"/>");
                        out.println("<input type=\"text\" id=\"clact_ord2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"indmaf2\" value=\"\"/>");
                        out.println("<input type=\"text\" id=\"trinv_ord2\" value=\"" + plop.getTrabajo_operacion() + "\"/>");
                        out.println("<input type=\"text\" id=\"trinv2_ord2\" value=\"" + plop.getUnidad_trabajo() + "\"/>");
                        out.println("<input type=\"text\" id=\"cant_ord2\" value=\"" + plop.getCantidad_operacion() + "\"/>");
                        out.println("<input type=\"text\" id=\"duraoper_ord2\" value=\"" + plop.getDuracion_operacion() + "\"/>");
                        out.println("<input type=\"text\" id=\"duraoper2_ord2\" value=\"" + plop.getUnidad_duracion_normal() + "\"/>");
                        out.println("<input type=\"text\" id=\"compo_ord2\" value=\"" + plop.getIndicador_valor_predeterminado_trabajo_relevante() + "\"/>");
                    }
                    break;
                case "CargarTablaOp":
                    int x;
                    String querytabla = "SELECT * FROM operaciones_ordenes_crea WHERE  folio_sam = '" + orden + "'";
                    LinkedList<operaciones_ordenes_crea> hr = ACC_Orden.ObtenerInstancia().cargartablaoperacionescrea(querytabla);
                    if (hr.size() > 0) {
                        out.println("<tbody>");
                        for (x = 0; x < hr.size(); x++) {
                            out.println("<tr ondblclick=\"SelectServices('" + hr.get(x).getClave_control() + "|" + hr.get(x).getNum_operacion() + "')\">");
                            out.println("<td>" + hr.get(x).getNum_operacion() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + hr.get(x).getCentro() + "</td>");
                            out.println("<td>" + hr.get(x).getClave_control() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + hr.get(x).getTexto_breve_operacion() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + hr.get(x).getTrabajo_operacion() + "</td>");
                            out.println("<td>" + hr.get(x).getUnidad_trabajo() + "</td>");
                            out.println("<td>" + hr.get(x).getCantidad_operacion() + "</td>");
                            out.println("<td>" + hr.get(x).getDuracion_operacion() + "</td>");
                            out.println("<td>" + hr.get(x).getUnidad_duracion_normal() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + hr.get(x).getSolicitante() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
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
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
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
                    } else {
                        out.println("<tbody>");
                        for (int j = 0; j < 15; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
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
                    }
                    break;
                case "CargarTablaComp":
                    int w;
                    String querytablac = "SELECT * FROM materiales_ordenes_crea WHERE  folio_sam='" + orden + "'";
                    LinkedList<materiales_ordenes_crea> com = ACC_Orden.ObtenerInstancia().CargarmaterialesordenesCrea(querytablac);
                    if (com.size() > 0) {
                        out.println("<tbody>");
                        for (w = 0; w < com.size(); w++) {
                            out.println("<tr>");
                            out.println("<td>" + com.get(w).getNum_posicion_lista_materiales() + "</td>");
                            out.println("<td>" + com.get(w).getNum_material() + "</td>");
                            out.println("<td>" + com.get(w).getTexto_breve_material() + "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>" + com.get(w).getCantidad_necesaria_componente2() + "</td>");
                            out.println("<td>" + com.get(w).getUnidad_medida_base() + "</td>");
                            out.println("<td>" + com.get(w).getTipo_posicion() + "</td>");
                            out.println("<td>" + com.get(w).getIndicador_stock_especial_visualizacion_dialogo() + "</td>");
                            out.println("<td>" + com.get(w).getAlmacen() + "</td>");
                            out.println("<td>" + com.get(w).getCentro() + "</td>");
                            out.println("<td>" + com.get(w).getNum_operacion() + "</td>");
                            out.println("<td>" + com.get(w).getLote() + "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>" + com.get(w).getDestinatario_mercancias() + "</td>");
                            out.println("<td>" + com.get(w).getPuesto_descarga() + "</td>");
                            out.println("<td></td>");
                            out.println("<td>" + com.get(w).getIndicador_material_granel() + "</td>");
                            out.println("<td>" + com.get(w).getIndicador_toma_retroactiva() + "</td>");
                            out.println("<td>" + com.get(w).getEfectividad_reserva() + "</td>");
                            out.println("</tr>");
                        }
                        for (int n = w; n < 15; n++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
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
                    } else {
                        out.println("<tbody>");
                        for (int j = 0; j < 15; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
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
                    }

                    break;
                case "GetDatosCabe":
                    String pm = "PM02";
                    String queryDat = "SELECT * FROM operaciones_ordenes_crea WHERE folio_sam = '" + or + "' AND num_operacion = '" + opera + "'";
                    operaciones_ordenes_crea ooc = ACC_OperacionesOrdenesCrea.ObtenerInstancia().ObtieneCampos(queryDat);
                    if (clave.equals(pm)) {
                        out.println("<input type=\"text\" id=\"CtdOpera_SER2\" value=\"" + ooc.getNum_operacion() + "\"/> ");
                        out.println("<input type=\"text\" id=\"Precio_SER2\" value=\"" + ooc.getPrecio() + "\"/> ");
                        out.println("<input type=\"text\" id=\"GrupoAti_SER2\" value=\"" + ooc.getGrupo_articulos() + "\"/> ");
                        out.println("<input type=\"text\" id=\"grcompra_SER2\" value=\"" + ooc.getGrupo_compras_actividad_trabajo_externa() + "\"/> ");
                        out.println("<input type=\"text\" id=\"contrato_SER2\" value=\"" + "\"/> ");
                        out.println("<input type=\"text\" id=\"Destinatario_SER2\" value=\"" + "\"/> ");
                        out.println("<input type=\"text\" id=\"solicitante_SER2\" value=\"" + ooc.getSolicitante() + "\"/> ");
                        out.println("<input type=\"text\" id=\"plaentprev_SER2\" value=\"" + "\"/> ");

                        out.println("<input type=\"text\" id=\"cl.clas_SER2\" value=\"" + "\"/> ");
                        out.println("<input type=\"text\" id=\"por_SER2\" value=\"" + ooc.getDuracion_operacion() + "\"/> ");
                        out.println("<input type=\"text\" id=\"clasecos_SER2\" value=\"" + ooc.getClase_coste() + "\"/> ");
                        out.println("<input type=\"text\" id=\"acree_SER2\" value=\"" + "\"/> ");
                        out.println("<input type=\"text\" id=\"reginfo_SER2\" value=\"" + "\"/> ");
                        out.println("<input type=\"text\" id=\"puestodes_SER2\" value=\"" + "\"/> ");
                        out.println("<input type=\"text\" id=\"Neces_SER2\" value=\"" + "\"/> ");
                        out.println("<input type=\"text\" id=\"pdmar_SER2\" value=\"" + "\"/> ");

                    } else {
                        out.println(0);
                    }
                    break;
//                case "GetDatosTabla":
//                    String pm02 = "PM02";
//                    if (clave.equals(pm02)) {
//                        String queryPM02 = "SELECT * FROM servicios_ordenes_crea WHERE folio_sam = '" + or + "' AND num_operacion = '" + opera + "'";
//                        LinkedList<servicios_ordenes_crea> sc = ACC_ServiciosOrdenesCrea.ObtenerInstancia().ObtieneServiciosOrdenesCrea(queryPM02);
//
//                        if (sc.size() > 0) {
//                            out.println("<tbody>");
//                            for (int i = 0; i < sc.size(); i++) {
//                                out.println("<tr>");
//                                out.println("<td>" + sc.get(i).getNum_servicio() + "</td>");
//                                out.println("<td>" + sc.get(i).getCantidad_con_signo() + "</td>");
//                                out.println("<td>&nbsp;</td>");
//                                out.println("<td>" + sc.get(i).getUnidad_medida_base() + "</td>");
//                                out.println("<td>" + sc.get(i).getGrupo_articulos() + "</td>");
//                                out.println("<td>" + sc.get(i).getClase_coste() + "</td>");
//                                out.println("</tr>");
//                            }
//                            for (int j = 0; j < 5; j++) {
//                                out.println(""
//                                        + "<tr>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "</tr>");
//                            }
//                            out.println("</tbody>");
//                        } else {
//                            for (int k = 0; k < 8; k++) {
//                                out.println(""
//                                        + "<tr>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "<td>&nbsp;</td>"
//                                        + "</tr>");
//                            }
//                            out.println("/tbody");
//                        }
//                    } else {
//                        out.println(0);
//                    }
//                    break;
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
