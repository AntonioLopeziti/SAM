/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.centros;
import Entidades.reporte_dms;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "peticionReporteDMS", urlPatterns = {"/peticionReporteDMS"})
public class peticionReporteDMS extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String var1 = request.getParameter("var1");
            String var2 = request.getParameter("var2");
            String CENT = request.getParameter("CENT");
            String SAM1 = request.getParameter("SAM1");
            String SAM2 = request.getParameter("SAM2");
            String DOC1 = request.getParameter("DOC1");
            String DOC2 = request.getParameter("DOC2");
            String FEC1 = request.getParameter("FEC1");
            String FEC2 = request.getParameter("FEC2");
            String CDOC = request.getParameter("CDOC");
            String RADI = request.getParameter("RADI");
            Consultas con = new Consultas();
            switch (Accion) {
                case "CargarCentros":
                    ArrayList<centros> cet = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    out.println("<select id=\"centro\">");
                    for (centros ce : cet) {
                        out.println("<option>" + ce.getCentro() + "</option>");
                    }
                    out.println("</select>");
                    break;
                case "CargarDMS":
                    ArrayList<reporte_dms> sa = ACC_Reportes.ObtenerInstancia().CargarFolioDMSReporteDMS();
                    if (sa.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_dms s : sa) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getFolio_dms() + "','dms')\">");
                            out.println("<td>" + s.getFolio_dms() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarDMS2":
                    ArrayList<reporte_dms> sa2 = ACC_Reportes.ObtenerInstancia().CargarFolioDMSReporteDMS();
                    if (sa2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_dms s : sa2) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getFolio_dms() + "','dms2')\">");
                            out.println("<td>" + s.getFolio_dms() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarDoc":
                    ArrayList<reporte_dms> doc = ACC_Reportes.ObtenerInstancia().CargarNumDocReporteDMS();
                    if (doc.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_dms s : doc) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getNumero_documento() + "','doc')\">");
                            out.println("<td>" + s.getNumero_documento() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarDoc2":
                    ArrayList<reporte_dms> doc2 = ACC_Reportes.ObtenerInstancia().CargarNumDocReporteDMS();
                    if (doc2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_dms s : doc2) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getNumero_documento() + "','doc2')\">");
                            out.println("<td>" + s.getNumero_documento() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarClase":
                    ArrayList<reporte_dms> cla = ACC_Reportes.ObtenerInstancia().CargarClaseDocReporteDMS();
                    if (cla.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_dms s : cla) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getClase_documento() + "','cla')\">");
                            out.println("<td>" + s.getClase_documento() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarDato":
                    int vali = ACC_Reportes.ObtenerInstancia().ValidarDatosDMS(var1, var2);
                    out.println(vali);
                    break;
                case "ValidarQuery":
                    String ff1 = con.DateFormatGuion(FEC1);
                    String ff2 = con.DateFormatGuion(FEC2);
                    String data[] = {CENT, SAM1, SAM2, DOC1, DOC2, ff1, ff2, CDOC, RADI};
                    ArrayList<reporte_dms> rep = ACC_Reportes.ObtenerInstancia().CargarTablaDMS(data);
                    out.println(rep.size());
                    break;
                case "CargarTabla":
                    String ff11 = con.DateFormatGuion(FEC1);
                    String ff12 = con.DateFormatGuion(FEC2);
                    String datas[] = {CENT, SAM1, SAM2, DOC1, DOC2, ff11, ff12, CDOC, RADI};
                    ArrayList<reporte_dms> rliP = ACC_Reportes.ObtenerInstancia().CargarTablaDMS(datas);
                    Collections.sort(rliP, new Comparator<reporte_dms>() {
                        public int compare(reporte_dms o1, reporte_dms o2) {
                            return o1.getFecha().compareTo(o2.getFecha());
                        }
                    });
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (reporte_dms r : rliP) {
                        out.println("<tr>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getFolio_dms() + "</td>");
                        out.println("<td>" + r.getNumero_documento() + "</td>");
                        out.println("<td>" + r.getClase_documento() + "</td>");
                        out.println("<td>" + r.getDescripcion_documento() + "</td>");
                        out.println("<td>" + con.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>00000000000000000000000</td>"
                            + "<td>00000000000000000000</td>"
                            + "<td>000000000000000000000000000000000000000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>000000000000000000000000000000000000000000000000000000000000000000000</td>"
                            + "</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
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
