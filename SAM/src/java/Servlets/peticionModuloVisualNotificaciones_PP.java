/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_OrdenesPMNotificaciones;
import AccesoDatos.ACC_UbicacionTecnica;
import AccesoDatos.ACC_notificaciones_cabecera_vis;
import AccesoDatos.ACC_Ordenes_pp_notificaciones;
import AccesoDatos.Consultas;
import Entidades.equipos;
import Entidades.notificaciones_cabecera_vis;
import Entidades.ordenes_pm_notificaciones;
import Entidades.ordenes_pp_notificaciones;
import Entidades.ubicacion_tecnica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AREConsulting
 */
@WebServlet(name = "peticionModuloVisualNotificaciones_PP", urlPatterns = {"/peticionModuloVisualNotificaciones_PP"})
public class peticionModuloVisualNotificaciones_PP extends HttpServlet {

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
            String Idioma = (String) session.getAttribute("Idioma");
            String Accion = request.getParameter("Accion");
            String CtdMax = request.getParameter("Cantidad");
            String Orden = request.getParameter("Orden");
            String opera = request.getParameter("operacion");
            String TxtBrv = request.getParameter("DOrden");
            String Ubicacion = request.getParameter("Ubicacion");
            String DUbicacion = request.getParameter("DUbicacion");
            String Equipo = request.getParameter("Equipo");
            String DEquipo = request.getParameter("DEquipo");
            Consultas con = new Consultas();

            switch (Accion) {
                case "ValidaOrden":
                    if (ACC_OrdenesPMNotificaciones.ObtenerInstancia().ValidarOrdenesVisualNO(Orden)) {
                        out.println(1);
                    }
                    break;
                case "ConsultaOrden":

                    LinkedList<ordenes_pp_notificaciones> or = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().OrdenesMatchNOTPP(CtdMax, Orden, TxtBrv);
                    if (or.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < or.size(); i++) {
                            ordenes_pp_notificaciones tec = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().OrdenesMatchNOTextPP(or.get(i).getNum_orden());
                            out.println("<tr ondblclick=\"seleccionar('" + or.get(i).getNum_orden() + "', 'Orden')\">");
                            out.println("<td>" + or.get(i).getNum_orden() + "</td>");
                            out.println("<td>" + tec.getTexto_breve() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }
                    break;
                default:
                    break;
                case "ConsultaUbicacion":
                    String desUbi = "denominacion_" + Idioma;

                    LinkedList<ubicacion_tecnica> u = ACC_UbicacionTecnica.ObtenerInstancia().ConsultaUbicacionesTecAM(CtdMax, Ubicacion, desUbi, DUbicacion, "");
                    if (u.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < u.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + u.get(i).getUbicacion_tecnica() + "','Ubicacion')\">");
                            out.println("<td>" + u.get(i).getUbicacion_tecnica() + "</td>");
                            out.println("<td>" + u.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaEquipo":
                    String desEq = "denominacion_" + Idioma;

                    LinkedList<equipos> e = ACC_Equipos.ObtenerInstancia().AvisoEquiposMatch(CtdMax, Equipo, desEq, DEquipo);
                    if (e.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < e.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + e.get(i).getNum_equipo() + "', 'Equipo')\">");
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
                case "CargarTablaNot":
                    int i;
                    LinkedList<notificaciones_cabecera_vis> nct = ACC_notificaciones_cabecera_vis.ObtenerInstancia().GetResumenNotificaciones(Orden, opera);
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (nct.size() > 0) {
                        for (i = 0; i < nct.size(); i++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + nct.get(i).getIndicador_cabecera() + "</td>");
                            out.println("<td>" + nct.get(i).getNum_operacion() + "</td>");
                            out.println("<td>" + nct.get(i).getSuboperacion() + "</td>");
                            out.println("<td>" + nct.get(i).getClase_capacidad() + "</td>");
                            out.println("<td>" + "" + "</td>");
                            out.println("<td>" + nct.get(i).getContador_notificacion() + "</td>");
                            out.println("<td>" + nct.get(i).getNotificacion_parcial_final() + "</td>");
                            out.println("<td>" + nct.get(i).getIndicador_doc_anulado() + "</td>");
                            out.println("<td>" + con.DateFormat(nct.get(i).getFecha_contabilizacion()) + "</td>");
                            out.println("<td>" + nct.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + nct.get(i).getTrabajo_real() + "</td>");
                            out.println("<td>" + nct.get(i).getUnidad_trabajo() + "</td>");
                            out.println("<td>" + nct.get(i).getClase_actividad_notificacion() + "</td>");
                            out.println("<td>" + nct.get(i).getTexto_breve_operacion() + "</td>");
                            out.println("<td>" + nct.get(i).getCl_reg_notificacion() + "</td>");
                            out.println("<td>" + con.DateFormat(nct.get(i).getInicio_real_ejecucion_fecha()) + "</td>");
                            out.println("<td>" + con.DateFormat(nct.get(i).getFin_real_ejecucion_fecha()) + "</td>");
                            out.println("<td>" + nct.get(i).getTrabajo_pronosticado_real_resto() + "</td>");
                            out.println("<td>" + nct.get(i).getTrabajo_operacion() + "</td>");
                            out.println("<td>" + con.DateFormat(nct.get(i).getInicio_mas_temprano_programado_ejecucion_fecha()) + "</td>");
                            out.println("<td>" + con.DateFormat(nct.get(i).getInicio_programado_mas_tardio_efectua_fecha()) + "</td>");
                            out.println("<td>" + con.DateFormat(nct.get(i).getFin_mas_temprano_programado_ejecucion_fecha()) + "</td>");
                            out.println("<td>" + con.DateFormat(nct.get(i).getFin_mas_tardio_programado_ejecucion_fecha()) + "</td>");
                            out.println("</tr");
                        }
                        for (int k = i; k < 16; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    } else {
                        for (int k = 0; k < 16; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println(" <tr class=\"ocultar\">\n"
                            + "                                                <td>000</td>\n"
                            + "                                                <td>0000000000</td>\n"
                            + "                                                <td>00000000000</td>\n"
                            + "                                                <td>00000000000</td>\n"
                            + "                                                <td>00000000000000000</td>\n"
                            + "                                                <td>00000000000000000</td>\n"
                            + "                                                <td>00000000000000000000000</td>\n"
                            + "                                                <td>00000000000</td>\n"
                            + "                                                <td>00000000000</td>\n"
                            + "                                                <td>00000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>00000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                                <td>0000000000000000000000000</td>\n"
                            + "                                            </tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "DescripcionOrden":
                    notificaciones_cabecera_vis cx = ACC_notificaciones_cabecera_vis.ObtenerInstancia().ObtenerDatos(Orden);
                    out.println(cx.getTexto_breve_operacion());
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
