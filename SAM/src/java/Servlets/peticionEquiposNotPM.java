/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Equipos_notificaciones;
import Entidades.equipos;
import Entidades.equipos_notificaciones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionEquiposNotPM", urlPatterns = {"/peticionEquiposNotPM"})
public class peticionEquiposNotPM extends HttpServlet {

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
            String ord = request.getParameter("ord");
            
            equipos_notificaciones eq = ACC_Equipos_notificaciones.ObtenerInstancia().equipoNOPM(ord);
            equipos equ = ACC_Equipos.ObtenerInstancia().GetObjtNOTPMnoti(eq.getNum_equipo(),Idioma);
            equipos sueq = ACC_Equipos.ObtenerInstancia().GetObjtNOTPMnoti(eq.getEquipo_superior(),Idioma);
            
            out.println("<input type'text' id='almno' value='"+eq.getAlmacen()+"' />");
            out.println("<input type'text' id='cenno' value='"+eq.getCentro()+"' />");
            out.println("<input type'text' id='eqsuno' value='"+eq.getEquipo_superior()+"' />");
            out.println("<input type'text' id='lotno' value='"+eq.getLote()+"' />");
            out.println("<input type'text' id='matno' value='"+eq.getMaterial()+"' />");
            out.println("<input type'text' id='nuono' value='"+eq.getNum_orden()+"' />");
            out.println("<input type'text' id='neqno' value='"+eq.getNum_equipo()+"' />");
            out.println("<input type'text' id='seno' value='"+eq.getSerie()+"' />");
            out.println("<input type'text' id='desne' value='"+equ.getDescripcion_equipo()+"' />");
            out.println("<input type'text' id='dessue' value='"+sueq.getDescripcion_equipo()+"' />");
            out.println("<input type'text' maxlength='1' id='eqmonodes' value='"+eq.getMontado()+"'/>");

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
