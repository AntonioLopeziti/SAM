/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_BOMEquipos;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Equipos;
import Entidades.bom_equipo;
import Entidades.centros;
import Entidades.equipos;
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

/**
 *
 */
@WebServlet(name = "peticionModuloVisualizarBoom", urlPatterns = {"/peticionModuloVisualizarBoom"})
public class peticionModuloVisualizarBoom extends HttpServlet {

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
            String Accion = request.getParameter("Action");
            String Ctd = request.getParameter("Ctd");
            String Equipo = request.getParameter("Equipo");
            String DenEquipo = request.getParameter("DEquipo");
            String Centros = request.getParameter("Centro");
            String NCentro = request.getParameter("NCentro");
            String Alterna = request.getParameter("Alter");
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String desEq = "denominacion_" + idioma;
            int l;
            switch (Accion) {
                case "ConsultaMatchEquipos":
                    ArrayList<equipos> e = ACC_Equipos.ObtenerInstancia().ConsultarEquipoMC(Equipo, DenEquipo, desEq, Ctd);
                    if (e.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < e.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + e.get(i).getNum_equipo() + "','EquBoom','VentanaModal','BuscarParam','ConsultaTabla')\">");
                            out.println("<td>" + e.get(i).getNum_equipo() + "</td>");
                            out.println("<td>" + e.get(i).getDescripcion_equipo() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchCentros":
                    if (Ctd.length() == 0) {
                        Ctd = "0";
                    }
                    ArrayList<centros> c = ACC_Centro.ObtenerInstancia().ConsultarCentros(Centros, NCentro, Integer.parseInt(Ctd));
                    if (c.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + c.get(i).getCentro() + "', 'centrotrab','VentanaModal2','BuscarParam2','ConsultaTabla2')\">");
                            out.println("<td>" + c.get(i).getCentro() + "</td>");
                            out.println("<td>" + c.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");

                    } else {
                        out.println(0);
                    }

                    break;
                case "CargarDatosBomEquipos":
                    ArrayList<bom_equipo> cen = ACC_BOMEquipos.ObtenerInstancia().ObtenerDatosBOOM(Equipo, Centros, Alterna);
                    if (cen.size() > 0) {
                        out.println("<table id=\"TabBody\">");
                        out.println("<tbody>");
                        for (l = 0; l < cen.size(); l++) {
                            out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td>" + cen.get(l).getUtilizacion_listamaterial() + "</td>");
                            out.println("<td>" + cen.get(l).getLista_materiales() + "</td>");
                            out.println("<td>" + cen.get(l).getCentro_suministrador() + "</td>");
                            out.println("<td name=\"Tcomp\">" + cen.get(l).getComponente_listamaterial() + "</td>");
                            out.println("<td name=\"Tdes\"></td>");
                            out.println("<td>" + cen.get(l).getCantidad_componente() + "</td>");
                            out.println("<td>" + cen.get(l).getUnidad_medida_componente() + "</td>");
                            out.println("</tr>");
                        }
                        for (int j = l; j < 13; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }

                        out.println(" <tr class=\"ocultar\">\n"
                                + "                                            <td>0000</td>\n"
                                + "                                            <td>00000000000</td>\n"
                                + "                                            <td>0000000000000000</td>\n"
                                + "                                            <td>0000000000000000</td>\n"
                                + "                                            <td>0000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000000</td>\n"
                                + "                                            <td>000000000000000</td>\n"
                                + "                                            <td>000000000000000</td></tr>");
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(1);
                    }
                    break;
                case "cleantable":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (int j = 0; j < 13; j++) {
                        out.println(""
                                + "<tr>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>");
                    }
                    out.println(" <tr class=\"ocultar\">\n"
                            + "                                            <td>0000</td>\n"
                            + "                                            <td>00000000000</td>\n"
                            + "                                            <td>0000000000000000</td>\n"
                            + "                                            <td>0000000000000000</td>\n"
                            + "                                            <td>0000000000000000</td>\n"
                            + "                                            <td>00000000000000000000000000000</td>\n"
                            + "                                            <td>000000000000000</td>\n"
                            + "                                            <td>000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ObtenerDescripcion":
                    String d = ACC_Equipos.ObtenerInstancia().ObtenerDes(Equipo, desEq);
                    out.println(d);
                    break;
                case "ObtenerDescripcionByMat":
                    String ds = ACC_Equipos.ObtenerInstancia().ObtenerDesByM(Equipo, idioma);
                    out.println(ds);
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
