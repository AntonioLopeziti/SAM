/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import Entidades.ReporteSolPed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PeticionVisualizarReportesSolPed", urlPatterns = {"/PeticionVisualizarReportesSolPed"})
public class PeticionVisualizarReportesSolPed extends HttpServlet {

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
            String sam = (String) session.getAttribute("SAMSP");
            String sap = (String) session.getAttribute("SAPSP");
            String fecha1 = (String) session.getAttribute("FECHASP");
            String sam2 = (String) session.getAttribute("SAMSPF");
            String sap2 = (String) session.getAttribute("SAPFSP");
            String fecha2 = (String) session.getAttribute("FECHASPF");
            String centro = (String) session.getAttribute("CEN");
            String valor = (String) session.getAttribute("VAL");
            String vl = (String) session.getAttribute("VLSP");
            String mot;
            String valfosa;
            if (vl.equals("true")) {
                mot = "MM.solped_crea";
                valfosa = "num_solped";
            } else {
                mot = "MM.reportes_solped";
                valfosa = "folio_sap";
            }
            String like;
            String especial;
            if (valor.equals("0")) {
                like = "";
                especial = "";
            } else {
                like = "AND error  not like ''";
                especial = "WHERE error not like ''";
            }
            switch (accion) {
                case "ConsultaVacia":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (vl.equals("false")) {
                        ACC_Reportes sp_reportvacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportvacio.sp_ConsultaReporteSolpedVacio(valor)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getFolio_sap() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    } else {
                        ACC_Reportes sp_reportecreavacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportecreavacio.sp_ConsultaReporteSolpedCreaVacio(valor)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getNum_solped() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "Centro":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (vl.equals("false")) {
                        ACC_Reportes sp_reportvacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportvacio.sp_ConsultaReporteSolpedCentro(valor, centro)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getFolio_sap() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    } else {
                        ACC_Reportes sp_reportecreavacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportecreavacio.sp_ConsultaReporteSolpedCreaCentro(valor, centro)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getNum_solped() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSamDerecha":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (vl.equals("false")) {
                        ACC_Reportes sp_reportvacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportvacio.sp_ConsultaReporteSolpedRangosSAM(valor, sam, sam2)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getFolio_sap() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    } else {
                        ACC_Reportes sp_reportecreavacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportecreavacio.sp_ConsultaReporteSolpedCreaRangosSAM(valor, sam, sam2)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getNum_solped() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                    }
                    break;
                case "ConsultaSamIzquierda":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (vl.equals("false")) {
                        ACC_Reportes sp_reportvacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportvacio.sp_ConsultaReporteSolpedSAM(valor, sam)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getFolio_sap() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    } else {
                        ACC_Reportes sp_reportecreavacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportecreavacio.sp_ConsultaReporteSolpedCreaSAM(valor, sam)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getNum_solped() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                    }
                    out.println("<tr class=\"ocultar\"><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSapDerecho":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (vl.equals("false")) {
                        ACC_Reportes sp_reportvacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportvacio.sp_ConsultaReporteSolpedRangosSAP(valor, sap, sap2)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getFolio_sap() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    } else {
                        ACC_Reportes sp_reportecreavacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportecreavacio.sp_ConsultaReporteSolpedCreaRangosSAP(valor, sap, sap2)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getNum_solped() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSapIzquierdo":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (vl.equals("false")) {
                        ACC_Reportes sp_reportvacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportvacio.sp_ConsultaReporteSolpedSAP(valor, sap)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getFolio_sap() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    } else {
                        ACC_Reportes sp_reportecreavacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportecreavacio.sp_ConsultaReporteSolpedCreaSAP(valor, sap)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getNum_solped() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFechaIzquierda":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (vl.equals("false")) {
                        ACC_Reportes sp_reportvacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportvacio.sp_ConsultaReporteSolpedFecha(valor, fecha1)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getFolio_sap() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    } else {
                        ACC_Reportes sp_reportecreavacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportecreavacio.sp_ConsultaReporteSolpedCreaFecha(valor, fecha1)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getNum_solped() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFechaDerecha":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (vl.equals("false")) {
                        ACC_Reportes sp_reportvacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportvacio.sp_ConsultaReporteSolpedRangosFecha(valor, fecha1, fecha2)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getFolio_sap() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    } else {
                        ACC_Reportes sp_reportecreavacio = new ACC_Reportes();
                        for (ReporteSolPed a : sp_reportecreavacio.sp_ConsultaReporteSolpedCreaRangosFecha(valor, fecha1, fecha2)) {
                            out.println("<tr>");
                            out.println("<td>" + a.getNum_solped() + "</td>");
                            out.println("<td>" + a.getFolio_sam() + "</td>");
                            out.println("<td>" + a.getHora_dia() + "</td>");
                            out.println("<td>" + a.getFecha() + "</td>");
                            out.println("<td>" + a.getRecibido() + "</td>");
                            out.println("<td>" + a.getProcesado() + "</td>");
                            out.println("<td>" + a.getError() + "</td>");
                            out.println("<td>" + a.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00000000000000000000000000000000000000</td><td>00000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>000000000000000</td></tr>");
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
