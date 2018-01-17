/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import Entidades.almacenes;
import Entidades.reporte_ivent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PeticionVisualizarReporteIvent", urlPatterns = {"/PeticionVisualizarReporteIvent"})
public class PeticionVisualizarReporteIvent extends HttpServlet {

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
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String almacenes = (String) session.getAttribute("ALMACEN");
            String materiales = (String) session.getAttribute("MATERIAL");
            String fecha1 = (String) session.getAttribute("FECHA1");
            String fecha2 = (String) session.getAttribute("FECHA2");
            String valor = (String) session.getAttribute("VALOR");

            String accion = request.getParameter("Action");
            String material = request.getParameter("mate");
            String almacen = request.getParameter("alma");
            String valo = request.getParameter("valo");
            String feh1 = request.getParameter("fe1");
            String feh2 = request.getParameter("fe2");
            String tipo = request.getParameter("tipo");

            switch (accion) {
                case "ReporteIvent":
                    if (almacenes.equals("")) {
                        almacenes = " ";
                    }
                    if (materiales.equals("")) {
                        materiales = " ";
                    }
                    if (fecha1.equals("")) {
                        fecha1 = " ";
                    }
                    if (fecha2.equals("")) {
                        fecha2 = " ";
                    }
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes sp_ivent = new ACC_Reportes();
                    for (reporte_ivent a : sp_ivent.MM_ReporteIvent(valor, materiales, almacenes, fecha1, fecha2)) {
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio() + "</td>");
                        out.println("<td>" + a.getPosicion() + "</td>");
                        out.println("<td>" + a.getCantidad() + "</td>");
                        out.println("<td>" + a.getMovimiento() + "</td>");
                        out.println("<td>" + a.getFecha() + "</td>");
                        out.println("<td>" + a.getAlmacen() + "</td>");
                        out.println("<td>" + a.getMaterial() + "</td>");
                        out.println("<td>" + a.getDescripcion() + "</td>");
                        out.println("<td>" + a.getMensaje() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>00000000000000000000000000</td><td>000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "MatchMaterial":
                    ArrayList<reporte_ivent> mat = ACC_Reportes.ObtenerInstancia().MM_MatchMaterial();
                    if (mat.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reporte_ivent u : mat) {
                            out.println("<tr ondblclick=\"Select('" + u.getMaterial() + "','" + tipo + "')\">");
                            out.println("<td>" + u.getMaterial() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "MatchAlmacen":
                    ArrayList<almacenes> alm = ACC_Reportes.ObtenerInstancia().MM_MatchAlmacen(idioma);

                    if (alm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (almacenes v : alm) {
                            out.println("<tr ondblclick=\"Select('" + v.getId_almacen() + "','Alm')\">");
                            out.println("<td>" + v.getId_almacen() + "</td>");
                            out.println("<td>" + v.getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarMaterial":
                    if (ACC_Reportes.ObtenerInstancia().ValidarMaterialReporteIvent(material)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarAlmacen":
                    if (ACC_Reportes.ObtenerInstancia().ValidarAlmacenReporteIvent(almacen)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarConsulta":
                    if (almacen.equals("")) {
                        almacen = " ";
                    }
                    if (material.equals("")) {
                        material = " ";
                    }
                    if (feh1.equals("")) {
                        feh1 = " ";
                    }
                    if (feh2.equals("")) {
                        feh2 = " ";
                    }
                    ArrayList<reporte_ivent> vali = ACC_Reportes.ObtenerInstancia().MM_ReporteIvent(valo, material, almacen, feh1, feh2);
                    if (vali.size() >= 1) {
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
