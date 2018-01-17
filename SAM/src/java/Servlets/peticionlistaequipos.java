/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_UbicacionTecnica;
import Entidades.ubicacion_tecnica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionlistaequipos", urlPatterns = {"/peticionlistaequipos"})
public class peticionlistaequipos extends HttpServlet {

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
            String ub = request.getParameter("q");

            if (ub == null || ub == "") {
                out.println("<table>");
                out.println("<tr>");
                out.println("<td><b>Id Ubicacion Tecnica</b></td>");
                out.println("<td><b>Descripcion</b></td>");
                out.println("</tr>");

//                LinkedList<ubicacion_tecnica> ubt = ACC_UbicacionTecnica.ObtenerInstancia().ConsultaUbicaciones_tec();
//                for (int i = 0; i < ubt.size(); i++) {
////                    out.println("<tr ondblclick=\"seleccion1('" + ubt.get(i).getId_ubitec() + "')\">");
////                    out.println("<td>" + ubt.get(i).getId_ubitec() + "</td>");
////                    out.println("<td>" + ubt.get(i).getDescripcion_ubitec() + "</td>");
//                    out.println("</tr>");
//                }
//                out.println("</table>");

            } else {
//                LinkedList<ubicacion_tecnica> ubt = ACC_UbicacionTecnica.ObtenerInstancia().BuscarUbicaciones_tec(ub);
//                out.println("<table>");
//                out.println("<tr>");
//                out.println("<td><b>Id Ubicacion Tecnica</b></td>");
//                out.println("<td><b>Descripcion</b></td>");
//                out.println("</tr>");

//                for (int i = 0; i < ubt.size(); i++) {
////                    out.println("<tr ondblclick=\"seleccion1('" + ubt.get(i).getId_ubitec() + "')\">");
////                    out.println("<td>" + ubt.get(i).getId_ubitec() + "</td>");
////                    out.println("<td>" + ubt.get(i).getDescripcion_ubitec() + "</td>");
////                    out.println("</tr>");
                
                out.println("</table>");
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
