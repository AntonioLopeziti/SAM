/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Qm01_1_notificaciones;
import Entidades.qm01_1_notificaciones;
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
@WebServlet(name = "peticionTab1QM01", urlPatterns = {"/peticionTab1QM01"})
public class peticionTab1QM01 extends HttpServlet {

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
            String oper = request.getParameter("oper");
           
           LinkedList<qm01_1_notificaciones> tn = ACC_Qm01_1_notificaciones.ObtenerInstancia().SHOWTabQ1(ord);
           
           for(int i = 0; i < tn.size(); i++){
                    out.println("<tr>");
                    out.println("<td>"+tn.get(i).getNum_caracteristica_inspeccion()+"</td>");
                    out.println("<td>"+tn.get(i).getTexto_breve_caracteristicas_inspeccion()+"</td>");
                    out.println("<td>"+tn.get(i).getUn_medida_graban_dat_cuantitativo()+"</td>");
                    out.println("<td>"+tn.get(i).getNum_unidades_muestreo_registrada()+"</td>");
                    out.println("<td>"+tn.get(i).getNum_muestreo_parciales_carac()+"</td>");
                    out.println("</tr>");
           }
               out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n" +
"                                         <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
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
