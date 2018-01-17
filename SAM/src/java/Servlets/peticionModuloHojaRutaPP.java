/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_HojasRuta;
import Entidades.centros;
import Entidades.equipos;
import Entidades.hojas_de_ruta;
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
 * @author Are-Consulting
 */
@WebServlet(name = "peticionModuloHojaRutaPP", urlPatterns = {"/peticionModuloHojaRutaPP"})
public class peticionModuloHojaRutaPP extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String Accion = request.getParameter("Action");
            String Ctd = request.getParameter("Ctd");
            String Equipo = request.getParameter("Equipo");
            String DenEquipo = request.getParameter("DEquipo");
            String Centros = request.getParameter("Centro");
            String NCentro = request.getParameter("NCentro");
            String Altern = request.getParameter("Alter");
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String desEq = "denominacion_" + idioma;
            int x;
            switch (Accion) {
                case "ConsultaMatchEquipos":
                    ArrayList<equipos> e = ACC_Equipos.ObtenerInstancia().ConsultarEquipoMCPP(Equipo, DenEquipo, desEq, Ctd);
                    if (e.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < e.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + e.get(i).getNum_equipo() + "','EquipoHR','VentanaModal','BuscarParam','ConsultaTabla')\">");
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
                            out.println("<tr ondblclick=\"seleccionar('" + c.get(i).getCentro() + "','CentroHR','VentanaModal2','BuscarParam2','ConsultaTabla2')\">");
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
                case "CargarDatosHojaRuta":
                    ArrayList<hojas_de_ruta> hr = ACC_HojasRuta.ObtenerInstancia().ConsultaVisualizarHRPP(Equipo, Centros, Altern);
                    if (hr.size() > 0) {
                        out.println("<table id=\"TabBody\">");
                        out.println("<tbody>");
                        for (x = 0; x < hr.size(); x++) {
                            out.println("<tr>");
                            out.println("<td>" + hr.get(x).getContador_grupo_hojaruta() + "</td>");
                            out.println("<td>" + hr.get(x).getTexto_hojaruta() + "</td>");
                            out.println("<td>" + hr.get(x).getNum_operacion() + "</td>");
                            out.println("<td>" + hr.get(x).getId_objeto() + "</td>");
                            out.println("<td>" + hr.get(x).getClave_control() + "</td>");
                            out.println("<td>" + hr.get(x).getCentro() + "</td>");
                            out.println("<td>" + hr.get(x).getAlternativa_lista_material() + "</td>");
                            out.println("<td>" + hr.get(x).getTexto_breve_operacion() + "</td>");
                            out.println("<td>" + hr.get(x).getCantidad_base() + "</td>");
                            out.println("<td>" + hr.get(x).getDuracion_operacion_normal() + "</td>");
                            out.println("<td>" + hr.get(x).getUnidad_duracion_normal() + "</td>");
                            out.println("<td>" + hr.get(x).getTrabajo_operacion() + "</td>");
                            out.println("<td>" + hr.get(x).getUnidad_trabajo() + "</td>");
                            out.println("<td>" + hr.get(x).getTipo_hojaruta() + "</td>");
                            out.println("<td>" + hr.get(x).getClave_grupo_hojaruta() + "</td>");
                            out.println("<td>" + hr.get(x).getSecuencia() + "</td>");
                            out.println("<td>" + hr.get(x).getNum_nodo_hojaruta() + "</td>");
                            out.println("<td>" + hr.get(x).getLista_material() + "</td>");
                            out.println("<td>" + hr.get(x).getStatus() + "</td>");
                            out.println("<td>" + hr.get(x).getDescripcion_operacion2() + "</td>");
                            out.println("<td>" + hr.get(x).getUnidad_medida_operacion() + "</td>");
                            out.println("<td>" + hr.get(x).getOrganización_compras() + "</td>");
                            out.println("<td>" + hr.get(x).getNum_cuenta_prove_acreedor() + "</td>");
                            out.println("<td>" + hr.get(x).getGrupo_articulos() + "</td>");
                            out.println("<td>" + hr.get(x).getNum_reg_info_compras() + "</td>");
                            out.println("<td>" + hr.get(x).getClase_coste() + "</td>");
                            out.println("<td>" + hr.get(x).getClave_moneda() + "</td>");
                            out.println("<td>" + hr.get(x).getGrupo_compras_activi_traba_extra() + "</td>");
                            out.println("<td>" + hr.get(x).getTipo_reginfo_compras() + "</td>");
                            out.println("<td>" + hr.get(x).getIndicador_borrado() + "</td>");
                            out.println("<td>" + hr.get(x).getNumServicio() + "</td>");
                            out.println("<td>" + hr.get(x).getDescServicio() + "</td>");
                            out.println("</tr>");
                        }
                        for (int j = x; j < 16; j++) {
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
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
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
                        out.println("  <tr class=\"ocultar\">\n"
                                + "                                            <td>00000000000</td><td>00000000000000000000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000</td>\n"
                                + "                                            <td>00000000000000000</td>\n"
                                + "                                            <td>00000000000000000</td>\n"
                                + "                                            <td>0000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000000000000000000000000000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000</td>\n"
                                + "                                            <td>0000000000000</td>\n"
                                + "                                            <td>0000000000000</td>\n"
                                + "                                            <td>0000000</td>\n"
                                + "                                            <td>0000000000</td>\n"
                                + "                                            <td>0000000000</td>\n"
                                + "                                            <td>0000000000000000000000000</td>\n"
                                + "                                            <td>000000000000000000000000000000000000000000000000000000000000000</td>"
                                + "                                        </tr>");
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
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
