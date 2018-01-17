/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.Consultas;
import AccesoDatos.ACC_Ordenes_pp_notificaciones;
import AccesoDatos.ACC_notificaciones_cabecera_vis;
import Entidades.notificaciones_cabecera_vis;
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
 * @author Jhonatan
 */
@WebServlet(name = "peticionModuloVisualNotificacionesPP", urlPatterns = {"/peticionModuloVisualNotificacionesPP"})
public class peticionModuloVisualNotificacionesPP extends HttpServlet {

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
                    if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ValidarOrdenesVisualNOPP(Orden)) {
                        out.println(1);
                    }
                    break;
                case "DescripcionOrden":
                    notificaciones_cabecera_vis cx = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenerDatosPP(Orden);
                    out.println(cx.getTexto_breve_operacion());
                    break;
                case "CargarTablaNot":
                    int i;
                    LinkedList<notificaciones_cabecera_vis> nct = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().GetResumenNotificacionesPP(Orden, opera);
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
