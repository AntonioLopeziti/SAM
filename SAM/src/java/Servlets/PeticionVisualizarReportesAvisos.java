/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.ReporteAvisos;
import Entidades.centros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "PeticionVisualizarReportesAvisos", urlPatterns = {"/PeticionVisualizarReportesAvisos"})
public class PeticionVisualizarReportesAvisos extends HttpServlet {

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
            String sam = (String) session.getAttribute("SAM1");
            String sap = (String) session.getAttribute("SAP1");
            String fecha1 = (String) session.getAttribute("FECHA1");
            String sam2 = (String) session.getAttribute("SAM2");
            String sap2 = (String) session.getAttribute("SAP2");
            String fecha2 = (String) session.getAttribute("FECHA2");
            String centro = (String) session.getAttribute("CEN");
            String valor = (String) session.getAttribute("VAL");
            String errorr = (String) session.getAttribute("ERROR");
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
                    ArrayList<ReporteAvisos> av = ACC_Reportes.ObtenerInstancia().PM_Reporte_AvisosTodos(valo, centros, foliosam, foliosam2, foliosap, foliosap2, ff, fff);
                    if (av.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "Centro":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes repor = new ACC_Reportes();
                    for (ReporteAvisos i : repor.SP_RAVISOS(valor, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaVacia":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporVa = new ACC_Reportes();
                    for (ReporteAvisos i : reporVa.SP_RAVISOSVA(valor)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    for (ReporteAvisos i : reporSAMDER.SP_RAVISOSSAMDER(valor, sam2, sap, f1, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    for (ReporteAvisos i : reporSAMIZQ.SP_RAVISOSSAMIZQ(valor, sam, sap, f11, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    for (ReporteAvisos i : reporSAMDOS.SP_RAVISOSSAMDOS(valor, sam, sam2)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    for (ReporteAvisos i : reporSAPDER.SP_RAVISOSSAPDER(valor, sap2, sam, f111, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    for (ReporteAvisos i : reporSAPIZQ.SP_RAVISOSSAPIZQ(valor, sap, sam, f1111, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    for (ReporteAvisos i : reporSAPDOS.SP_RAVISOSSAPDOS(valor, sap, sap2, sam, f11111, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    for (ReporteAvisos i : reporFECIZQ.SP_RAVISOSFEIZQ(valor, f111111)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    for (ReporteAvisos i : reporFECDER.SP_RAVISOSFEDER(valor, f2)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
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
                    String f22 = cn.DateFormatGuion(fecha2);
                    for (ReporteAvisos i : reporFECDOS.SP_RAVISOSFEDOS(valor, f1111111, f22)) {
                        out.println("<tr>");
                        out.println("<td>" + i.getNum_notificacion() + "</td>");
                        out.println("<td>" + i.getFolio_sam() + "</td>");
                        out.println("<td>" + i.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(i.getFecha()) + "</td>");
                        out.println("<td>" + i.getRecibido() + "</td>");
                        out.println("<td>" + i.getProcesado() + "</td>");
                        out.println("<td>" + i.getError() + "</td>");
                        out.println("<td>" + i.getCentro() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CentroReserva":
                    ArrayList<centros> pt = ACC_Centro.ObtenerInstancia().CentroReservass();
                    if (pt.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pt.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pt.get(i).getCentro() + "','centro')\">");
                            out.println("<td>" + pt.get(i).getCentro() + "</td>");
                            out.println("<td>" + pt.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCentroo":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    if (ACC_Reportes.ObtenerInstancia().ValidarRAvSAM(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP":
                    if (ACC_Reportes.ObtenerInstancia().ValidarRAvSAP(foliosap)) {
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
