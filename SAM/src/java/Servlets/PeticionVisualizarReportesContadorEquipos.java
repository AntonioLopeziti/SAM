/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import Entidades.ReporteContadorEquipos;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.centros;

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

@WebServlet(name = "PeticionVisualizarReportesContadorEquipos", urlPatterns = {"/PeticionVisualizarReportesContadorEquipos"})
public class PeticionVisualizarReportesContadorEquipos extends HttpServlet {

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
            String valo = request.getParameter("valor");
            String accion = request.getParameter("Action");
            String tipo = request.getParameter("tipo");
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosam2 = request.getParameter("sam2");
            String foliosap = request.getParameter("sap");
            String foliosap2 = request.getParameter("sap2");
            String fe1 = request.getParameter("fecha1");
            String fe2 = request.getParameter("fecha2");
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
                    ArrayList<ReporteContadorEquipos> equipos = ACC_Reportes.ObtenerInstancia().PM_Reporte_ContadorEquiposTodos(valo, centros, foliosam, foliosam2, foliosap, foliosap2, ff, fff);
                    if (equipos.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ReporteContador":
                    if (centro.equals("")) {
                        centro = " ";
                    }
                    if (sam1.equals("")) {
                        sam1 = " ";
                    }
                    if (sam2.equals("")) {
                        sam2 = " ";
                    }
                    if (sap1.equals("")) {
                        sap1 = " ";
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
                    ACC_Reportes con = new ACC_Reportes();
                    String f1 = cn.DateFormatGuion(fecha1);
                    String f2 = cn.DateFormatGuion(fecha2);  
                    for (ReporteContadorEquipos j : con.PM_Reporte_ContadorEquiposTodos(valor, centro, sam1, sam2, sap1, sap2, f1, f2)) {
                        out.println("<tr>");
                        out.println("<td>" + j.getFolio_sam() + "</td>");
                        out.println("<td>" + j.getValor_contador() + "</td>");
                        out.println("<td>" + j.getFolio_sap() + "</td>");
                        out.println("<td>" + j.getFecha() + "</td>");
                        out.println("<td>" + j.getHora_dia() + "</td>");
                        out.println("<td>" + j.getNivel() + "</td>");
                        out.println("<td>" + j.getIcono() + "</td>");
                        out.println("<td>" + j.getEquipo() + "</td>");
                        out.println("<td>" + j.getDenominacion_equipo() + "</td>");
                        out.println("<td>" + j.getPunto_medida() + "</td>");
                        out.println("<td>" + j.getDoc_medicion() + "</td>");
                        out.println("<td>" + j.getCantidad1() + "</td>");
                        out.println("<td>" + j.getValor_contador() + "</td>");
                        out.println("<td>" + j.getUnidad_medida_entrada_doc() + "</td>");
                        out.println("<td></td>");
                        out.println("<td>" + j.getRecibido() + "</td>");
                        out.println("<td>" + j.getProcesado() + "</td>");
                        out.println("<td>" + j.getError() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>00000000000000000000000000</td>"
                            + "<td>00000000000000000000</td>"
                            + "<td>0000000000000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>000000000000000000000000000000000000000000000000</td>"
                            + "<td>0000000000000000000000000000000000000</td>"
                            + "<td>00000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>"
                            + "<td>00000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>"
                            + "<td>00000000000000000000</td>"
                            + "<td>00000000000000000000000</td>"
                            + "<td>00000000000000000000000000000000</td>"
                            + "<td>00000000000000000000000000000000</td>"
                            + "<td>000000000000000000000000000000000000000000000000000000</td>"
                            + "<td>000000000000000000000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CentroReserva":
                    ArrayList<centros> cen = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    if (cen.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (centros sc : cen) {
                            out.println("<tr>");
                            out.println("<tr ondblclick=\"Select('" + sc.getCentro() + "','centro')\">");
                            out.println("<td>" + sc.getCentro() + "</td>");
                            out.println("<td>" + sc.getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAMconsumos":
                    ArrayList<ReporteContadorEquipos> cont = ACC_Reportes.ObtenerInstancia().PM_MatchEquiposFolioSam();
                    if (cont.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteContadorEquipos k : cont) {
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
                    ArrayList<ReporteContadorEquipos> sp_sap = ACC_Reportes.ObtenerInstancia().PM_MatchEquiposFolioSap();
                    if (sp_sap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteContadorEquipos l : sp_sap) {
                            out.println("<tr ondblclick=\"Select('" + l.getFolio_sap() + "','" + tipo + "')\">");
                            out.println("<td>" + l.getFolio_sap() + "</td>");
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
                    if (ACC_Reportes.ObtenerInstancia().ValidarSamContador(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSapContador(foliosap)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;

                case "ValidacionC":
                    boolean val = ACC_Reportes.ObtenerInstancia().ValidarAviso(centros);
                    if (val == true) {
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
