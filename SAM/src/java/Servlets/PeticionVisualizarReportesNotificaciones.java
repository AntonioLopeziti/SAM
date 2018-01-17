/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.ReporteMovimientos;
import Entidades.ReporteNotificaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PeticionVisualizarReportesNotificaciones", urlPatterns = {"/PeticionVisualizarReportesNotificaciones"})
public class PeticionVisualizarReportesNotificaciones extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
 /*Variables Obtenidas por session*/
            HttpSession session = request.getSession();
            String sam = (String) session.getAttribute("SAM");
            String sam2 = (String) session.getAttribute("SAM1");
            String sap = (String) session.getAttribute("SAP");
            String ord = (String) session.getAttribute("ORD");
            String ord2 = (String) session.getAttribute("ORD2");
            String ope = (String) session.getAttribute("OPE");
            String ope2 = (String) session.getAttribute("OPE2");
            String centro = (String) session.getAttribute("CENTRO");
            String valor = (String) session.getAttribute("VALOR");

            /*Valores Accion Switch*/
            String accion = request.getParameter("Accion");
            String tipo = request.getParameter("tipo");
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosap = request.getParameter("sap");
            String operacion = request.getParameter("ope");
            String orden = request.getParameter("ord");
            String val = request.getParameter("valo");
            String foliosam2 = request.getParameter("sam2");
            String operacion2 = request.getParameter("ope2");
            String orden2 = request.getParameter("ord2");
            Consultas cn = new Consultas();
            /*---------------------*/

            switch (accion) {
                case "ConsultaVacia":
                    ACC_Reportes repor = new ACC_Reportes();
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (ReporteNotificaciones r : repor.SP_RNOTIFICACION(valor)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaCentro":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes not_centro = new ACC_Reportes();
                    for (ReporteNotificaciones r : not_centro.PM_SPNotificacionesCentro(valor, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSAM":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes not_sam = new ACC_Reportes();
                    for (ReporteNotificaciones r : not_sam.PM_NotificacionesFolioSam(valor, sam)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaRangosSAM":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes noti_rangosam = new ACC_Reportes();
                    for (ReporteNotificaciones r : noti_rangosam.PM_NotificacionesRangosSam(valor, sam, sam2)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaRangosORD":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes noti_rangoord = new ACC_Reportes();
                    for (ReporteNotificaciones r : noti_rangoord.PM_NotificacionesRangosOrdenes(valor, ord, ord2)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaORD":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes noti_orden = new ACC_Reportes();
                    for (ReporteNotificaciones r : noti_orden.PM_NotificacionesNumeroOrden(valor, ord)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaOPE":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes noti_Operacion = new ACC_Reportes();
                    for (ReporteNotificaciones r : noti_Operacion.PM_ReporteNotificacionesNumeroOperacion(valor, ope)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaOPERangos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes noti_RangoOperacion = new ACC_Reportes();
                    for (ReporteNotificaciones r : noti_RangoOperacion.PM_ReporteRangosNotificacionesOperacion(valor, ope, ope2)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "NotificacionesOrden":
                    ArrayList<ReporteNotificaciones> rn = ACC_Reportes.ObtenerInstancia().PM_MatchReportNotificaciones();
                    if (rn.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteNotificaciones l : rn) {
                            out.println("<tr ondblclick=\"Select('" + l.getNum_orden() + "','" + tipo + "')\">");
                            out.println("<td>" + l.getNum_orden() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "NotificacionesOperacion":
                    ArrayList<ReporteNotificaciones> op = ACC_Reportes.ObtenerInstancia().PM_MatchReportNotificaciones();
                    if (op.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteNotificaciones m : op) {
                            out.println("<tr ondblclick=\"Select('" + m.getNum_operacion() + "','" + tipo + "')\">");
                            out.println("<td>" + m.getNum_operacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaSAP":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes noti_Folio_Sap = new ACC_Reportes();
                    for (ReporteNotificaciones r : noti_Folio_Sap.PM_ReporteNotificacionesFolioSap(valor, sap)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getFolio_sap() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getNum_operacion() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "Todos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_todos = new ACC_Reportes();
                    for (ReporteNotificaciones o : sp_todos.PM_ReporteNotificacionesTodos(valor, sam, sam2, ord, ord2, ope, ope2, sap, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + o.getFolio_sam() + "</td>");
                        out.println("<td>" + o.getHora_dia() + "</td>");
                        out.println("<td>" + o.getFecha() + "</td>");
                        out.println("<td>" + o.getContador_notificacion() + "</td>");
                        out.println("<td>" + o.getCentro() + "</td>");
                        out.println("<td>" + o.getNotificacion_parcial_final() + "</td>");
                        out.println("<td>" + o.getNum_orden() + "</td>");
                        out.println("<td>" + o.getNum_operacion() + "</td>");
                        out.println("<td>" + o.getRecibido() + "</td>");
                        out.println("<td>" + o.getProcesado() + "</td>");
                        out.println("<td>" + o.getError() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>0000000000000</td><td>000000000000000</td><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000000000000000</td><td>00000000000</td><td>00000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ValidarCentro":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":

                    if (ACC_Reportes.ObtenerInstancia().ValidarSamNotificaciones(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSaPNotificaciones(foliosap)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarOPERACION":
                    if (ACC_Reportes.ObtenerInstancia().ValidarOperacionNotificaciones(operacion)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarORDEN":

                    if (ACC_Reportes.ObtenerInstancia().ValidarOrdenNotificaciones(orden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarQuery":
                    if (centros.equals("")) {
                        centros = " ";
                    }
                    if (foliosam.equals("")) {
                        foliosam = " ";
                    }
                    if (foliosam2.equals("")) {
                        foliosam2 = " ";
                    }
                    if (operacion.equals("")) {
                        operacion = " ";
                    }
                    if (operacion2.equals("")) {
                        operacion2 = " ";
                    }
                    if (orden.equals("")) {
                        orden = " ";
                    }
                    if (orden2.equals("")) {
                        orden2 = " ";
                    }
                    if (foliosap.equals("")) {
                        foliosap = " ";
                    }
                    ArrayList<ReporteNotificaciones> qu = ACC_Reportes.ObtenerInstancia().PM_ReporteNotificacionesValidarQuery(val, centros, foliosam, foliosam2, orden, orden2, operacion, operacion2, foliosap);
                    if (qu.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
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
