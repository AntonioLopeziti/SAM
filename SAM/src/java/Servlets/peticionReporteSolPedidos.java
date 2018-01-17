/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.Repo_solped;
import Entidades.Reportes;
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
@WebServlet(name = "peticionReporteSolPedidos", urlPatterns = {"/peticionReporteSolPedidos"})
public class peticionReporteSolPedidos extends HttpServlet {

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
            String Acc = request.getParameter("Accion");
            String sam = request.getParameter("sam");
            String sap = request.getParameter("sap");

            String cent = request.getParameter("CENT");
            String sam1 = request.getParameter("SAM1");
            String sam2 = request.getParameter("SAM2");
            String sap1 = request.getParameter("SAP1");
            String sap2 = request.getParameter("SAP2");
            String fec1 = request.getParameter("FEC1");
            String fec2 = request.getParameter("FEC2");
            String radi = request.getParameter("RADI");
            String chek = request.getParameter("CHEK");
            Consultas cn = new Consultas();
            switch (Acc) {
                case "CargarCentros":
                    ArrayList<centros> cet = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    out.println("<select id=\"centro\">");
                    for (centros ce : cet) {
                        out.println("<option>" + ce.getCentro() + "</option>");
                    }
                    out.println("</select>");
                    break;
                case "CargarSAM":
                    ArrayList<Reportes> rsam = ACC_Reportes.ObtenerInstancia().MCFolioSAMSolped();
                    if (rsam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < rsam.size(); i++) {
                            String sm = rsam.get(i).getFoliosam();
                            out.println("<tr ondblclick=\"Selecdata('" + sm + "','sami','VentanaModalSAM')\">");
                            out.println("<td>" + rsam.get(i).getFoliosam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAM2":
                    ArrayList<Reportes> rsam2 = ACC_Reportes.ObtenerInstancia().MCFolioSAMSolped();
                    if (rsam2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < rsam2.size(); i++) {
                            out.println("<tr ondblclick=\"Selecdata('" + rsam2.get(i).getFoliosam() + "','samf','VentanaModalSAM2')\">");
                            out.println("<td>" + rsam2.get(i).getFoliosam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAP":
                    ArrayList<Reportes> rsap = ACC_Reportes.ObtenerInstancia().MCFolioSAPSolped();
                    if (rsap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < rsap.size(); i++) {
                            out.println("<tr ondblclick=\"Selecdata('" + rsap.get(i).getFoliosap() + "','sapi','VentanaModalSAP')\">");
                            out.println("<td>" + rsap.get(i).getFoliosap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAP2":
                    ArrayList<Reportes> rsap2 = ACC_Reportes.ObtenerInstancia().MCFolioSAPSolped();
                    if (rsap2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < rsap2.size(); i++) {
                            out.println("<tr ondblclick=\"Selecdata('" + rsap2.get(i).getFoliosap() + "','sapf','VentanaModalSAP2')\">");
                            out.println("<td>" + rsap2.get(i).getFoliosap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    int fs = ACC_Reportes.ObtenerInstancia().ReporteSolpedValidarSAM(sam);
                    out.println(fs);
                    break;
                case "ValidarSAP":
                    int fp = ACC_Reportes.ObtenerInstancia().ReporteSolpedValidarSAP(sap);
                    out.println(fp);
                    break;
                case "ValidarQuery":
                    String fff1 = cn.DateFormatGuion(fec1);
                    String fff2 = cn.DateFormatGuion(fec2);
                    String data[] = {radi, cent, sam1, sam2, sap1, sap2, fff1, fff2};
                    if (chek.trim().equals("1")) {
                        int cons = ACC_Reportes.ObtenerInstancia().ReporteSolpedValidarQuerySAMCrea(data);
                        out.println(cons);
                    } else {
                        int v1 = ACC_Reportes.ObtenerInstancia().ReporteSolpedValidarTabla1(data);
                        int v2 = ACC_Reportes.ObtenerInstancia().ReporteSolpedValidarTabla2(data);
                        int v3 = v1 + v2;
                        out.println(v3);
                    }
                    break;
                case "CargarTabla":
                    String fff11 = cn.DateFormatGuion(fec1);
                    String fff22 = cn.DateFormatGuion(fec2);
                    String datas[] = {radi, cent, sam1, sam2, sap1, sap2, fff11, fff22};
                    if (chek.trim().equals("1")) {
                        ArrayList<Repo_solped> res = ACC_Reportes.ObtenerInstancia().ReporteSolpedCargarTablaSAMCrea(datas);
                        Collections.sort(res, new Comparator<Repo_solped>() {
                            public int compare(Repo_solped o1, Repo_solped o2) {
                                return o1.getFecha().compareTo(o2.getFecha());
                            }
                        });
                        out.println("<table id=\"TabBody\">");
                        out.println("<tbody>");
                        for (Repo_solped r : res) {
                            out.println("<tr>");
                            out.println("<td>" + r.getFolio_sap() + "</td>");
                            out.println("<td>" + r.getFolio_sam() + "</td>");
                            out.println("<td>" + cn.DateFormat(r.getFecha()) + "</td>");
                            out.println("<td>" + r.getCentro() + "</td>");
                            out.println("<td>" + r.getRecibido() + "</td>");
                            out.println("<td>" + r.getProcesado() + "</td>");
                            out.println("<td>" + r.getError() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>000000000000000000000</td>"
                                + "<td>000000000000000000000</td>"
                                + "<td>000000000000000000000</td>"
                                + "<td>00000000000000000</td>"
                                + "<td>000000000000000000</td>"
                                + "<td>000000000000000</td>"
                                + "<td>0000000000000000000000000000000000000000000000000000000000000</td>"
                                + "</tr>");
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        ArrayList<Repo_solped> rsol = ACC_Reportes.ObtenerInstancia().ReporteSolpedCargarTabla1(datas);
                        ArrayList<Repo_solped> rsol2 = ACC_Reportes.ObtenerInstancia().ReporteSolped_CargarTabla2(datas);
                        ArrayList<Repo_solped> rsf = new ArrayList<>();
                        rsol.addAll(rsol2);
                        rsf.addAll(rsol);
                        Collections.sort(rsf, new Comparator<Repo_solped>() {
                            public int compare(Repo_solped o1, Repo_solped o2) {
                                return o1.getFecha().compareTo(o2.getFecha());
                            }
                        });
                        out.println("<table id=\"TabBody\">");
                        out.println("<tbody>");
                        for (Repo_solped r1 : rsf) {
                            out.println("<tr>");
                            out.println("<td>" + r1.getFolio_sap() + "</td>");
                            out.println("<td>" + r1.getFolio_sam() + "</td>");
                            out.println("<td>" + cn.DateFormat(r1.getFecha()) + "</td>");
                            out.println("<td>" + r1.getCentro() + "</td>");
                            out.println("<td>" + r1.getRecibido() + "</td>");
                            out.println("<td>" + r1.getProcesado() + "</td>");
                            out.println("<td>" + r1.getError() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>000000000000000000000</td>"
                                + "<td>000000000000000000000</td>"
                                + "<td>000000000000000000000</td>"
                                + "<td>00000000000000000</td>"
                                + "<td>000000000000000000</td>"
                                + "<td>000000000000000</td>"
                                + "<td>0000000000000000000000000000000000000000000000000000000000000</td>"
                                + "</tr>");
                        out.println("</tbody>");
                        out.println("</table>");
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
