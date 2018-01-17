/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.reportes_consumos;
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
@WebServlet(name = "peticionVisualizarReportesConsumos", urlPatterns = {"/peticionVisualizarReportesConsumos"})
public class peticionVisualizarReportesConsumos extends HttpServlet {

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

 /*Valores recibidos por session*/
            HttpSession session = request.getSession();
            String sam1 = (String) session.getAttribute("SAM1");
            String sam2 = (String) session.getAttribute("SAM2");
            String sap1 = (String) session.getAttribute("SAP1");
            String sap2 = (String) session.getAttribute("SAP2");
            String fecha1 = (String) session.getAttribute("FECHA1");
            String fecha2 = (String) session.getAttribute("FECHA2");
            String centro = (String) session.getAttribute("CENTRO");
            String valor = (String) session.getAttribute("ERROR");
            /*----------------------------*/
 /*Valores Accion Switch*/
            String accion = request.getParameter("Action");
            String tipo = request.getParameter("tipo");
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosam2 = request.getParameter("sam2");
            String foliosap = request.getParameter("sap");
            String foliosap2 = request.getParameter("sap2");
            String fe1 = request.getParameter("fecha1");
            String fe2 = request.getParameter("fecha2");
            String valo = request.getParameter("valor");
            Consultas cn = new Consultas();

            String like;
            String query;
            /*--------------------*/

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
                    ArrayList<reportes_consumos> co = ACC_Reportes.ObtenerInstancia().SP_ReporteConsumosTodos(valo, centros, foliosam, foliosam2, foliosap, foliosap2, ff, fff);
                    if (co.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaVacia":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_vacio = new ACC_Reportes();
                    for (reportes_consumos a : sp_vacio.SP_ReporteConsumosVacia(valor)) {
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_orden() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_dia()) + "</td>");
                        out.println("<td>" + a.getNum_orden() + "</td>");
                        out.println("<td>" + a.getIndi_posicion1() + "</td>");
                        out.println("<td>" + a.getIndi_posicion2() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaCentro":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_centro = new ACC_Reportes();
                    for (reportes_consumos b : sp_centro.SP_ReporteConsumosCentro(valor, centro)) {
                        out.println("<tr>");
                        out.println("<td>" + b.getFolio_orden() + "</td>");
                        out.println("<td>" + b.getFolio_sam() + "</td>");
                        out.println("<td>" + b.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(b.getFecha_dia()) + "</td>");
                        out.println("<td>" + b.getNum_orden() + "</td>");
                        out.println("<td>" + b.getIndi_posicion1() + "</td>");
                        out.println("<td>" + b.getIndi_posicion2() + "</td>");
                        out.println("<td>" + b.getError() + "</td>");
                        out.println("<td>" + b.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "RangoSAM":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_rangosam = new ACC_Reportes();
                    for (reportes_consumos c : sp_rangosam.SP_ReporteConsumosRangosSam(valor, sam1, sam2)) {
                        out.println("<tr>");
                        out.println("<td>" + c.getFolio_orden() + "</td>");
                        out.println("<td>" + c.getFolio_sam() + "</td>");
                        out.println("<td>" + c.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(c.getFecha_dia()) + "</td>");
                        out.println("<td>" + c.getNum_orden() + "</td>");
                        out.println("<td>" + c.getIndi_posicion1() + "</td>");
                        out.println("<td>" + c.getIndi_posicion2() + "</td>");
                        out.println("<td>" + c.getError() + "</td>");
                        out.println("<td>" + c.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSAM":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_consam = new ACC_Reportes();
                    for (reportes_consumos d : sp_consam.SP_ReporteConsumosSam(valor, sam1)) {
                        out.println("<tr>");
                        out.println("<td>" + d.getFolio_orden() + "</td>");
                        out.println("<td>" + d.getFolio_sam() + "</td>");
                        out.println("<td>" + d.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(d.getFecha_dia()) + "</td>");
                        out.println("<td>" + d.getNum_orden() + "</td>");
                        out.println("<td>" + d.getIndi_posicion1() + "</td>");
                        out.println("<td>" + d.getIndi_posicion2() + "</td>");
                        out.println("<td>" + d.getError() + "</td>");
                        out.println("<td>" + d.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "rangoSAP":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_rangossap = new ACC_Reportes();
                    for (reportes_consumos e : sp_rangossap.SP_ReporteConsumosRangosSap(valor, sap1, sap2)) {
                        out.println("<tr>");
                        out.println("<td>" + e.getFolio_orden() + "</td>");
                        out.println("<td>" + e.getFolio_sam() + "</td>");
                        out.println("<td>" + e.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(e.getFecha_dia()) + "</td>");
                        out.println("<td>" + e.getNum_orden() + "</td>");
                        out.println("<td>" + e.getIndi_posicion1() + "</td>");
                        out.println("<td>" + e.getIndi_posicion2() + "</td>");
                        out.println("<td>" + e.getError() + "</td>");
                        out.println("<td>" + e.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSAP":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_sap = new ACC_Reportes();
                    for (reportes_consumos f : sp_sap.SP_ReporteConsumosSap(valor, sap1)) {
                        out.println("<tr>");
                        out.println("<td>" + f.getFolio_orden() + "</td>");
                        out.println("<td>" + f.getFolio_sam() + "</td>");
                        out.println("<td>" + f.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(f.getFecha_dia()) + "</td>");
                        out.println("<td>" + f.getNum_orden() + "</td>");
                        out.println("<td>" + f.getIndi_posicion1() + "</td>");
                        out.println("<td>" + f.getIndi_posicion2() + "</td>");
                        out.println("<td>" + f.getError() + "</td>");
                        out.println("<td>" + f.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "rangosFECHAS":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_rangosfecha = new ACC_Reportes();
                    String f1 = cn.DateFormatGuion(fecha1);
                    String f2 = cn.DateFormatGuion(fecha2);
                    for (reportes_consumos g : sp_rangosfecha.SP_ReporteConsumosRangosFecha(valor, f1, f2)) {
                        out.println("<tr>");
                        out.println("<td>" + g.getFolio_orden() + "</td>");
                        out.println("<td>" + g.getFolio_sam() + "</td>");
                        out.println("<td>" + g.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(g.getFecha_dia()) + "</td>");
                        out.println("<td>" + g.getNum_orden() + "</td>");
                        out.println("<td>" + g.getIndi_posicion1() + "</td>");
                        out.println("<td>" + g.getIndi_posicion2() + "</td>");
                        out.println("<td>" + g.getError() + "</td>");
                        out.println("<td>" + g.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "consultaFECHA":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_fecha = new ACC_Reportes();
                    String f11 = cn.DateFormatGuion(fecha1);
                    for (reportes_consumos h : sp_fecha.SP_ReporteConsumosFecha(valor, f11)) {
                        out.println("<tr>");
                        out.println("<td>" + h.getFolio_orden() + "</td>");
                        out.println("<td>" + h.getFolio_sam() + "</td>");
                        out.println("<td>" + h.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(h.getFecha_dia()) + "</td>");
                        out.println("<td>" + h.getNum_orden() + "</td>");
                        out.println("<td>" + h.getIndi_posicion1() + "</td>");
                        out.println("<td>" + h.getIndi_posicion2() + "</td>");
                        out.println("<td>" + h.getError() + "</td>");
                        out.println("<td>" + h.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "SAMconsumos":
                    ArrayList<reportes_consumos> rc = ACC_Reportes.ObtenerInstancia().MM_MatchConFolioSam();
                    if (rc.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reportes_consumos k : rc) {
                            out.println("<tr ondblclick=\"Select('" + k.getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + k.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAPconsumos":
                    ArrayList<reportes_consumos> r = ACC_Reportes.ObtenerInstancia().MM_MatchConFolioSap();
                    if (r.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reportes_consumos l : r) {
                            out.println("<tr ondblclick=\"Select('" + l.getFolio_orden() + "','" + tipo + "')\">");
                            out.println("<td>" + l.getFolio_orden() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCentro":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSamConsumos(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSapConsumos(foliosap)) {
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
