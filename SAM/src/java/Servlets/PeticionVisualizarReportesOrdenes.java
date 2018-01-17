/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.ReporteNotificaciones;
import Entidades.ReporteOrdenes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "PeticionVisualizarReportesOrdenes", urlPatterns = {"/PeticionVisualizarReportesOrdenes"})
public class PeticionVisualizarReportesOrdenes extends HttpServlet {

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
            String Idioma = (String) session.getAttribute("Idioma");
            String accion = request.getParameter("Action");
            String sam = (String) session.getAttribute("SAMIO");
            String sap = (String) session.getAttribute("SAPIO");
            String fecha1 = (String) session.getAttribute("FECHAIO");
            String sam2 = (String) session.getAttribute("SAMFO");
            String sap2 = (String) session.getAttribute("SAPFO");
            String fecha2 = (String) session.getAttribute("FECHAFO");
            String centro = (String) session.getAttribute("CEN");
            String valor = (String) session.getAttribute("VAL");
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosam2 = request.getParameter("sam2");
            String foliosap = request.getParameter("sap");
            String foliosap2 = request.getParameter("sap2");
            String fe1 = request.getParameter("fecha1");
            String fe2 = request.getParameter("fecha2");
            String valo = request.getParameter("valor");
            Consultas cn = new Consultas();

            switch (accion) {
                case "Centro":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes repor = new ACC_Reportes();
                    for (ReporteOrdenes r : repor.SP_RORDENES(valor, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                case "ConsultaVacia":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporVa = new ACC_Reportes();
                    for (ReporteOrdenes r : reporVa.SP_RORDENESVA(valor)) {
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSamDerecha":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporSAMDER = new ACC_Reportes();
                    String f1 = cn.DateFormatGuion(fecha1);                                        
                    for (ReporteOrdenes r : reporSAMDER.SP_RORDENESSAMDER(valor, sam2, sap, f1, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSamIzquierda":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporSAMIZQ = new ACC_Reportes();
                    String f11 = cn.DateFormatGuion(fecha1);                                        
                    for (ReporteOrdenes r : reporSAMIZQ.SP_RORDENESSAMIZQ(valor, sam, sap, f11, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSamDos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporSAMDOS = new ACC_Reportes();
                    for (ReporteOrdenes r : reporSAMDOS.SP_RORDENESSAMDOS(valor, sam, sam2)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSapDerecho":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporSAPDER = new ACC_Reportes();
                    String f111 = cn.DateFormatGuion(fecha1);                                        
                    for (ReporteOrdenes r : reporSAPDER.SP_RORDENESSAPDER(valor, sap2, sam, f111, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSapIzquierdo":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporSAPIZQ = new ACC_Reportes();
                    String f1111 = cn.DateFormatGuion(fecha1);                                        
                    for (ReporteOrdenes r : reporSAPIZQ.SP_RORDENESSAPIZQ(valor, sap, sam, f1111, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSapDos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporSAPDOS = new ACC_Reportes();
                    String f11111 = cn.DateFormatGuion(fecha1);                                        
                    for (ReporteOrdenes r : reporSAPDOS.SP_RORDENESSAPDOS(valor, sap, sap2, sam, f11111, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFechaIzquierda":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporFECIZQ = new ACC_Reportes();
                    String f111111 = cn.DateFormatGuion(fecha1);  
                    for (ReporteOrdenes r : reporFECIZQ.SP_RORDENESFEIZQ(valor, f111111, sap, sam, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFechaDerecha":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporFECDER = new ACC_Reportes();
                    String f2 = cn.DateFormatGuion(fecha2);  
                    for (ReporteOrdenes r : reporFECDER.SP_RORDENESFEDER(valor, f2, sap, sam, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFechaDos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporFECDOS = new ACC_Reportes();
                    String f1111111 = cn.DateFormatGuion(fecha1);                    
                    String f222 = cn.DateFormatGuion(fecha2);                    
                    for (ReporteOrdenes r : reporFECDOS.SP_RORDENESFEDOS(valor, f1111111, f222, sap, sam, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_orden() + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("<td>" + r.getCentro_planificacion_mante() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ValidarCentroo":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    if (ACC_Reportes.ObtenerInstancia().ValidarROrSAM(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP":
                    if (ACC_Reportes.ObtenerInstancia().ValidarROrSAP(foliosap)) {
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
                    String ff = cn.DateFormatGuion(fe1);
                    String fff = cn.DateFormatGuion(fe2);
                    ArrayList<ReporteOrdenes> ord = ACC_Reportes.ObtenerInstancia().PM_Reporte_OrdenesTodos(valo, centros, foliosam, foliosam2, foliosap, foliosap2, ff, fff);
                    if (ord.size() >= 1) {
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
