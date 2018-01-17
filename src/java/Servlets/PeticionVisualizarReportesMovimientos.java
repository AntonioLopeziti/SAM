/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import Entidades.ReporteAvisos;
import Entidades.ReporteMovimientos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PeticionVisualizarReportesMovimientos", urlPatterns = {"/PeticionVisualizarReportesMovimientos"})
public class PeticionVisualizarReportesMovimientos extends HttpServlet {

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
            HttpSession session = request.getSession();
            String accion = request.getParameter("Action");
            String sam = (String) session.getAttribute("SAMI");
            String sap = (String) session.getAttribute("SAPI");
            String fecha1 = (String) session.getAttribute("FECHAI");
            String sam2 = (String) session.getAttribute("SAMF");
            String sap2 = (String) session.getAttribute("SAPF");
            String fecha2 = (String) session.getAttribute("FECHAF");
            String centro = (String) session.getAttribute("CEN");
            String valor = (String) session.getAttribute("VAL");
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosam2 = request.getParameter("sam2");
            String foliosap = request.getParameter("sap");
            String foliosap2 = request.getParameter("sap2");
            String fe1 = request.getParameter("fecha1");
            String fe2 = request.getParameter("fecha2");
            String val = request.getParameter("valor");
            switch (accion) {
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
                    if (foliosap.equals("")) {
                        foliosap = " ";
                    }
                    if (foliosap2.equals("")) {
                        foliosap2 = " ";
                    }
                    if (fe1.equals("")) {
                        fe1 = " ";
                    }
                    if (fe2.equals("")) {
                        fe2 = " ";
                    }
                    ArrayList<ReporteMovimientos> mov = ACC_Reportes.ObtenerInstancia().SP_Reporte_MovimientosTodos(val, centros, foliosam, foliosam2, foliosap, foliosap2, fe1, fe2);
                    if (mov.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "Centro":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_centro = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_centro.SP_ReporteMovimientosCentro(valor, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaVacia":
                    if (sam.equals("")) {
                        sam = " ";
                    }
                    if (sam2.equals("")) {
                        sam2 = " ";
                    }
                    if (sap.equals("")) {
                        sap = " ";
                    }
                    if (sap2.equals("")) {
                        sap2 = " ";
                    }
                    if (fecha1.equals("")) {
                        fecha1 = " ";
                    }
                    if (fecha2.equals("")) {
                        fecha2 = " ";
                    }
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_vacio = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_vacio.SP_Reporte_MovimientosTodos(valor, centro, sam, sam2, sap, sap2, fecha1, fecha2)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSamDerecha":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_rangossam = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_rangossam.SP_ReporteMovimientosRangosSam(valor, sam, sam2)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSamIzquierda":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_movsam = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_movsam.SP_ReporteMovimientosSam(valor, sam)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSapDerecho":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_movrangossap = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_movrangossap.SP_ReporteMovimientosRangosSap(valor, sap, sap2)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSapIzquierdo":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_movsap = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_movsap.SP_ReporteMovimientosSap(valor, sap)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFechaIzquierda":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_movfecha = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_movfecha.SP_ReporteMovimientosFecha(valor, fecha1)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFechaDerecha":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_movrangosfecha = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_movrangosfecha.SP_ReporteMovimientosRangosFecha(valor, fecha1, fecha2)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFechaDos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
//                    LinkedList<ReporteMovimientos> rept = ACC_Reportes.ObtenerInstancia().ConsultasMovimientos(ker);
//                    for (int i = 0; i < rept.size(); i++) {
//                        out.println("<tr>");
//                        out.println("<td>" + rept.get(i).getNum_doc() + "</td>");
//                        out.println("<td>" + rept.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + rept.get(i).getHora_dia() + "</td>");
//                        out.println("<td>" + rept.get(i).getFecha() + "</td>");
//                        out.println("<td>" + rept.get(i).getRecibido() + "</td>");
//                        out.println("<td>" + rept.get(i).getProcesado() + "</td>");
//                        out.println("<td>" + rept.get(i).getError() + "</td>");
//                        out.println("<td>" + rept.get(i).getCentro() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("</table>");
                    break;
                case "Todos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_movtodos = new ACC_Reportes();
                    for (ReporteMovimientos r : sp_movtodos.PM_ReporteMovimientosTodos(valor, sam, sam2, sap, sap2, fecha1, fecha2, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getFecha() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
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
                    if (ACC_Reportes.ObtenerInstancia().ValidarSamMovimientos(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSapMovimientos(foliosap)) {
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
