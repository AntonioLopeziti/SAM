/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Pm03_1_notificaciones;
import Entidades.pm03_1_notificaciones;
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
@WebServlet(name = "peticionTabpm03_1_notificaciones", urlPatterns = {"/peticionTabpm03_1_notificaciones"})
public class peticionTabpm03_1_notificaciones extends HttpServlet {

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
           String ord = request.getParameter("ord");
           
           LinkedList<pm03_1_notificaciones> tn = ACC_Pm03_1_notificaciones.ObtenerInstancia().TABGRNOTPM(ord);
           
           for(int i = 0; i < tn.size(); i++){
                    out.println("<tr>");
                    out.println("<td>"+tn.get(i).getNum_linea()+"</td>");
                    out.println("<td>"+tn.get(i).getNum_servicio()+"</td>");
                    out.println("<td>"+tn.get(i).getTexto_breve()+"</td>");
                    out.println("<td>"+tn.get(i).getCantidad_sign()+"</td>");
                    out.println("<td>"+tn.get(i).getUnidad_medida_base()+"</td>");
                    out.println("<td>"+tn.get(i).getValor_neto_posicion()+"</td>");
                    out.println("<td>"+tn.get(i).getCatidad_base()+"</td>");
                    out.println("<td>"+tn.get(i).getGrupo_articulos()+"</td>");
                    out.println("<td>"+tn.get(i).getClase_coste()+"</td>");
                    out.println("</tr>");
           }
          for(int i = 0; i < 10; i++){
                    out.println("<tr>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("</tr>");
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
