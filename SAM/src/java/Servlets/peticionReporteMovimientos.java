/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.ReporteMovimientos;
import Entidades.centros;
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
 */
@WebServlet(name = "peticionReporteMovimientos", urlPatterns = {"/peticionReporteMovimientos"})
public class peticionReporteMovimientos extends HttpServlet {

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
            String sam = request.getParameter("sam");
            String sap = request.getParameter("sap");

            String CENT = request.getParameter("CENT");
            String SAM1 = request.getParameter("SAM1");
            String SAM2 = request.getParameter("SAM2");
            String SAP1 = request.getParameter("SAP1");
            String SAP2 = request.getParameter("SAP2");
            String FEC1 = request.getParameter("FEC1");
            String FEC2 = request.getParameter("FEC2");
            String RADI = request.getParameter("RADI");
            Consultas cn = new Consultas();
            switch (Accion) {
                case "CargarCentros":
                    ArrayList<centros> cet = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    out.println("<select id=\"centro\">");
                    for (centros ce : cet) {
                        out.println("<option>" + ce.getCentro() + "</option>");
                    }
                    out.println("</select>");
                    break;
                case "CargarSAM":
                    ArrayList<ReporteMovimientos> rsam = ACC_Reportes.ObtenerInstancia().MCFolioSAMMovimientos();
                    if (rsam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < rsam.size(); i++) {
                            String sm = rsam.get(i).getFolio_sam();
                            out.println("<tr ondblclick=\"Selecdata('" + sm + "','sami','VentanaModalSAM')\">");
                            out.println("<td>" + rsam.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAM2":
                    ArrayList<ReporteMovimientos> rsam2 = ACC_Reportes.ObtenerInstancia().MCFolioSAMMovimientos();
                    if (rsam2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < rsam2.size(); i++) {
                            String sm = rsam2.get(i).getFolio_sam();
                            out.println("<tr ondblclick=\"Selecdata('" + sm + "','samf','VentanaModalSAM2')\">");
                            out.println("<td>" + rsam2.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAP":
                    ArrayList<ReporteMovimientos> rsap = ACC_Reportes.ObtenerInstancia().MCFolioSAPMovimientos();
                    if (rsap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < rsap.size(); i++) {
                            String sm = rsap.get(i).getNum_doc_materila();
                            out.println("<tr ondblclick=\"Selecdata('" + sm + "','sapi','VentanaModalSAP')\">");
                            out.println("<td>" + rsap.get(i).getNum_doc_materila() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAP2":
                    ArrayList<ReporteMovimientos> rsap2 = ACC_Reportes.ObtenerInstancia().MCFolioSAPMovimientos();
                    if (rsap2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < rsap2.size(); i++) {
                            String sm = rsap2.get(i).getNum_doc_materila();
                            out.println("<tr ondblclick=\"Selecdata('" + sm + "','sapf','VentanaModalSAP2')\">");
                            out.println("<td>" + rsap2.get(i).getNum_doc_materila() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    int m = ACC_Reportes.ObtenerInstancia().ReporteMovimientosValidarSAM(sam);
                    out.println(m);
                    break;
                case "ValidarSAP":
                    int p = ACC_Reportes.ObtenerInstancia().ReporteMovimientosValidarSAP(sap);
                    out.println(p);
                    break;
                case "ValidarQuery":
                    String ff1 = cn.DateFormatGuion(FEC1);
                    String ff2 = cn.DateFormatGuion(FEC2);
                    String data[] = {RADI, CENT, SAM1, SAM2, SAP1, SAP2, ff1, ff2};
                    ArrayList<ReporteMovimientos> arr = ACC_Reportes.ObtenerInstancia().ValidaCargaQueryMovimientos(data);
                    out.println(arr.size());
                    break;
                case "CargarTabla":
                    String ff11 = cn.DateFormatGuion(FEC1);
                    String ff22 = cn.DateFormatGuion(FEC2);
                    String datas[] = {RADI, CENT, SAM1, SAM2, SAP1, SAP2, ff11, ff22};
                    ArrayList<ReporteMovimientos> rmov = ACC_Reportes.ObtenerInstancia().ValidaCargaQueryMovimientos(datas);
                    Collections.sort(rmov, new Comparator<ReporteMovimientos>() {
                            public int compare(ReporteMovimientos o1, ReporteMovimientos o2) {
                                return o1.getFecha().compareTo(o2.getFecha());
                            }
                        });
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (ReporteMovimientos r : rmov) {
                        out.println("<tr>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getNum_doc_materila() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>000000000</td>"
                            + "<td>000000000000000000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>000000000</td>"
                            + "<td>000000000</td>"
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
