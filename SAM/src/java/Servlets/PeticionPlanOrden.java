/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_PlanOrden;
import Entidades.plan_orden;
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
 * @author AreConsulting
 */
@WebServlet(name = "PeticionPlanOrden", urlPatterns = {"/PeticionPlanOrden"})
public class PeticionPlanOrden extends HttpServlet {

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
            //String ub = request.getParameter("q");
            String accion = request.getParameter("Action");
            HttpSession session = request.getSession();
//            String material = (String) session.getAttribute("MiMaterial");
//            String material2 = (String) session.getAttribute("MiMaterial2");
//            String tipomaterial = (String) session.getAttribute("MiTipoMaterial");
//            String grupoarticulos = (String) session.getAttribute("MiGrupoArticulos");
//            String textomaterial = (String) session.getAttribute("MiTextoMaterial");
//            String almacen = (String) session.getAttribute("MiAlmacen");
//            String centro = (String) session.getAttribute("MiCentri");
//            String numerolote = (String) session.getAttribute("MiNumeroLote");
//            String limite = (String) session.getAttribute("MiCantidadMaxima");
//            String status1 = (String) session.getAttribute("MiStatus1");
//            String status2 = (String) session.getAttribute("MiStatus2");
//            String status3 = (String) session.getAttribute("MiStatus3");

            String status1 = request.getParameter("MiStatus1");
            String status2 = request.getParameter("MiStatus2");
            String status3 = request.getParameter("MiStatus3");

            String orden = request.getParameter("orden");
            String orden2 = request.getParameter("orden2");
            String clase = request.getParameter("clase");
            String ubicacion = request.getParameter("ubicacion");
            String equipo = request.getParameter("equipo");

            switch (accion) {
                case "ConsultaUno":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ArrayList<plan_orden> stockma = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaUnoListaorden(status1);
                    for (int i = 0; i < stockma.size(); i++) {
                        out.println("<tr ondblclick=\"seleccionarOrden('" + stockma.get(i).getNum_orden() + "')\">");
                        out.println("<td>" + stockma.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + stockma.get(i).getClase_doc_ventas() + "</td>");
                        out.println("<td>" + stockma.get(i).getFecha_inicio_extrema() + "</td>");
                        out.println("<td>" + stockma.get(i).getTexto_breve() + "</td>");
                        out.println("</tr>");
                    }
                    if (stockma.size() < 15) {
                        out.println(""
                                + "<tr>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>"
                        );

                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>0000000000000000000000</td>");
                    out.println("<td>0000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("</tr");
                    out.println("</tbody>");
                    out.println("</table>");

                    break;
                case "ConsultaDos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ArrayList<plan_orden> stockma1 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaDosListaorden(status1, status2);
                    for (int i = 0; i < stockma1.size(); i++) {
                        out.println("<tr ondblclick=\"seleccionarOrden('" + stockma1.get(i).getNum_orden() + "')\">");
                        out.println("<td>" + stockma1.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + stockma1.get(i).getClase_doc_ventas() + "</td>");
                        out.println("<td>" + stockma1.get(i).getFecha_inicio_extrema() + "</td>");
                        out.println("<td>" + stockma1.get(i).getTexto_breve() + "</td>");

                    }
                    if (stockma1.size() < 15) {
                        out.println(""
                                + "<tr>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>"
                        );

                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>0000000000000000000000</td>");
                    out.println("<td>0000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("</tr");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaTres":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ArrayList<plan_orden> stockma2 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaTresListaorden(status1, status2, status3);
                    for (int i = 0; i < stockma2.size(); i++) {
                        out.println("<tr ondblclick=\"seleccionarOrden('" + stockma2.get(i).getNum_orden() + "')\">");
                        out.println("<td>" + stockma2.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + stockma2.get(i).getClase_doc_ventas() + "</td>");
                        out.println("<td>" + stockma2.get(i).getFecha_inicio_extrema() + "</td>");
                        out.println("<td>" + stockma2.get(i).getTexto_breve() + "</td>");

                    }
                    if (stockma2.size() < 15) {
                        out.println(""
                                + "<tr>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>"
                        );
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>0000000000000000000000</td>");
                    out.println("<td>0000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("</tr");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaValidar":
                    ArrayList<plan_orden> stockma3 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidarListaorden(orden, clase, ubicacion, equipo);
                    if (stockma3.size() > 0) {
                        out.println(1);
                    }
                    break;
                case "ConsultaValidar1":
                    ArrayList<plan_orden> stockma4 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidar1Listaorden(orden, clase, ubicacion);
                    if (stockma4.size() > 0) {
                        out.println(1);
                    }
                    break;
                case "ConsultaValidar11":
                    ArrayList<plan_orden> stockma44 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidar11Listaorden(orden, clase, equipo);
                    if (stockma44.size() > 0) {
                        out.println(1);
                    }
                    break;
                case "ConsultaValidar111":
                    ArrayList<plan_orden> stockma444 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidar111Listaorden(orden, ubicacion, equipo);
                    if (stockma444.size() > 0) {
                        out.println(1);
                    }
                    break;
                case "ConsultaValidar2":
                    ArrayList<plan_orden> stockma5 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidar2Listaorden(orden, clase);
                    if (stockma5.size() > 0) {
                        out.println(1);
                    }
                    break;
                case "ConsultaValidar22":
                    ArrayList<plan_orden> stockma55 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidar22Listaorden(orden, ubicacion);
                    if (stockma55.size() > 0) {
                        out.println(1);
                    }
                    break;
                case "ConsultaValidar222":
                    ArrayList<plan_orden> stockma555 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidar222Listaorden(orden, equipo);
                    if (stockma555.size() > 0) {
                        out.println(1);
                    }
                    break;
                case "ConsultaValidar3":
                    ArrayList<plan_orden> stockma6 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidar3Listaorden(orden);
                    if (stockma6.size() > 0) {
                        out.println(1);
                    }
                    break;
                case "ConsultaValidar4":
                    if (orden.equals("")) {
                        orden = " ";
                    }
                    if (clase.equals("")) {
                        clase = " ";
                    }
                    if (ubicacion.equals("")) {
                        ubicacion = " ";
                    }
                    if (equipo.equals("")) {
                        equipo = " ";
                    }
                    ArrayList<plan_orden> stockma7 = ACC_PlanOrden.ObtenerInstancia().SP_ConsultaValidar4Listaorden(orden, clase, ubicacion, equipo);
                    if (stockma7.size() > 0) {
                        out.println("<table id=\"TabBody\">");
                        out.println("<tbody>");
                        for (int i = 0; i < stockma7.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionarOrden('" + stockma7.get(i).getNum_orden() + "')\">");
                            out.println("<td>" + stockma7.get(i).getNum_orden() + "</td>");
                            out.println("<td>" + stockma7.get(i).getClase_doc_ventas() + "</td>");
                            out.println("<td>" + stockma7.get(i).getFecha_inicio_extrema() + "</td>");
                            out.println("<td>" + stockma7.get(i).getTexto_breve() + "</td>");

                        }
                        if (stockma7.size() < 15) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>"
                            );
                        }
                        out.println("<tr class=\"ocultar\">");
                        out.println("<td>0000000000000000000000</td>");
                        out.println("<td>0000000000000000000000</td>");
                        out.println("<td>00000000000000000000000000</td>");
                        out.println("<td>00000000000000000000000000000000000000000000000000000000000000000000</td>");
                        out.println("</tr");
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(1);
                    }

                    break;
                case "orden2":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ArrayList<plan_orden> stockma8 = ACC_PlanOrden.ObtenerInstancia().SP_Consultaorden2Listaorden(orden, orden2);
                    for (int i = 0; i < stockma8.size(); i++) {
                        out.println("<tr ondblclick=\"seleccionarOrden('" + stockma8.get(i).getNum_orden() + "')\">");
                        out.println("<td>" + stockma8.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + stockma8.get(i).getClase_doc_ventas() + "</td>");
                        out.println("<td>" + stockma8.get(i).getFecha_inicio_extrema() + "</td>");
                        out.println("<td>" + stockma8.get(i).getTexto_breve() + "</td>");

                    }
                    if (stockma8.size() < 15) {
                        out.println(""
                                + "<tr>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>"
                        );
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>0000000000000000000000</td>");
                    out.println("<td>0000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("</tr");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "Checksap":
                    if (ACC_PlanOrden.ObtenerInstancia().ValidarOrdenplan(orden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "Checksam":
                    if (ACC_PlanOrden.ObtenerInstancia().ValidarOrdenCreacab(orden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValOrden":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarOrden(orden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValClase":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarClase(clase)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValUbitec":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarUbitec(ubicacion)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValEquipo":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarEquipo(equipo)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ChecksapPP":
                    if (ACC_PlanOrden.ObtenerInstancia().ValidarOrdenPlanPP(orden)) {
                        out.println(1);
                    } else {
                        out.println(0);
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
