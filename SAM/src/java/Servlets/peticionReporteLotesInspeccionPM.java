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
import Entidades.reporte_lotes_inspeccion_pm;
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
@WebServlet(name = "peticionReporteLotesInspeccionPM", urlPatterns = {"/peticionReporteLotesInspeccionPM"})
public class peticionReporteLotesInspeccionPM extends HttpServlet {

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
            String LOT1 = request.getParameter("LOT1");
            String LOT2 = request.getParameter("LOT2");
            String FEC1 = request.getParameter("FEC1");
            String FEC2 = request.getParameter("FEC2");
            String USUA = request.getParameter("USUA");
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
                case "CargarSAM":
                    ArrayList<reporte_lotes_inspeccion_pm> sa = ACC_Reportes.ObtenerInstancia().CargarMCSAMLotePM();
                    if (sa.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_lotes_inspeccion_pm s : sa) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getFolio_sam() + "','sam')\">");
                            out.println("<td>" + s.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAM2":
                    ArrayList<reporte_lotes_inspeccion_pm> sa2 = ACC_Reportes.ObtenerInstancia().CargarMCSAMLotePM();
                    if (sa2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_lotes_inspeccion_pm s : sa2) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getFolio_sam() + "','sam2')\">");
                            out.println("<td>" + s.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarLotePM":
                    ArrayList<reporte_lotes_inspeccion_pm> lot = ACC_Reportes.ObtenerInstancia().CargarMCLotesLotePM();
                    if (lot.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_lotes_inspeccion_pm s : lot) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getNum_lote_insp() + "','lote')\">");
                            out.println("<td>" + s.getNum_lote_insp() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarLotePM2":
                    ArrayList<reporte_lotes_inspeccion_pm> lot2 = ACC_Reportes.ObtenerInstancia().CargarMCLotesLotePM();
                    if (lot2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_lotes_inspeccion_pm s : lot2) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getNum_lote_insp() + "','lote2')\">");
                            out.println("<td>" + s.getNum_lote_insp() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarUsuarios":
                    ArrayList<reporte_lotes_inspeccion_pm> usu = ACC_Reportes.ObtenerInstancia().CargarMCUsuariosLotePM();
                    if (usu.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_lotes_inspeccion_pm s : usu) {
                            out.println("<tr ondblclick=\"seleccionar('" + s.getCreador_registro_datos() + "','usser')\">");
                            out.println("<td>" + s.getCreador_registro_datos() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidaDato":
                    int bandato = ACC_Reportes.ObtenerInstancia().ValidarDatosLotePM(var1, var2);
                    out.println(bandato);
                    break;
                case "ValidarQuery":
                    String ff1 = con.DateFormatGuion(FEC1);
                    String ff2 = con.DateFormatGuion(FEC2);
                    String data[] = {CENT, SAM1, SAM2, LOT1, LOT2, ff1, ff2, USUA, RADI};
                    ArrayList<reporte_lotes_inspeccion_pm> rli = ACC_Reportes.ObtenerInstancia().CargarTablaLotesInpeccionPM(data);
                    out.println(rli.size());
                    break;
                case "CargarTabla":
                    String ff11 = con.DateFormatGuion(FEC1);
                    String ff12 = con.DateFormatGuion(FEC2);
                    String datas[] = {CENT, SAM1, SAM2, LOT1, LOT2, ff11, ff12, USUA, RADI};
                    ArrayList<reporte_lotes_inspeccion_pm> rliP = ACC_Reportes.ObtenerInstancia().CargarTablaLotesInpeccionPM(datas);
                    Collections.sort(rliP, new Comparator<reporte_lotes_inspeccion_pm>() {
                        public int compare(reporte_lotes_inspeccion_pm o1, reporte_lotes_inspeccion_pm o2) {
                            return o1.getFecha().compareTo(o2.getFecha());
                        }
                    });
                      out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (reporte_lotes_inspeccion_pm r : rliP) {
                        out.println("<tr>");
                        out.println("<td>" + r.getCentro() + "</td>");
                        out.println("<td>" + r.getFolio_sam() + "</td>");
                        out.println("<td>" + r.getNum_lote_insp() + "</td>");
                        out.println("<td>" + r.getCreador_registro_datos() + "</td>");
                        out.println("<td>" + con.DateFormat(r.getFecha()) + "</td>");
                        out.println("<td>" + r.getHora_dia() + "</td>");
                        out.println("<td>" + r.getRecibido() + "</td>");
                        out.println("<td>" + r.getProcesado() + "</td>");
                        out.println("<td>" + r.getError() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>000000000</td>"
                            + "<td>00000000000000000</td>"
                            + "<td>00000000000000000000</td>"
                            + "<td>00000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000</td>"
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
