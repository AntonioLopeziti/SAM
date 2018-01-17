/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Proveedor;
import Entidades.proveedor;
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
@WebServlet(name = "PeticionProvMatchSoPed", urlPatterns = {"/PeticionProvMatchSoPed"})
public class PeticionProvMatchSoPed extends HttpServlet {

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
           String cspcobu = request.getParameter("cspcobu");
           String csppai = request.getParameter("csppai");
           String cspcopo =request.getParameter("cspcopo");
           String csppbl =request.getParameter("csppbl");
           String cspnoee = request.getParameter("cspnoee");
           String cspacre = request.getParameter("cspacre");
           
           out.println("<table>");
            out.println("<tbody>");
           LinkedList <proveedor> pr = ACC_Proveedor.ObtenerInstancia().ObtenerAllProvCSP(cspcobu, csppai, cspcopo,csppbl , cspnoee, cspacre);
           
                for(int i = 0; i < pr.size(); i++){
                    out.println("<tr onclick=\"seleccionar('"+pr.get(i).getIdProveedor()+"','ProvDesea_SP','VenmatchProvDesea_SP')\">");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td>"+pr.get(i).getCodificacionPoblacion()+"</td>");
                    out.println("<td>"+pr.get(i).getPoblacion()+"</td>");
                    out.println("<td>"+pr.get(i).getNombre1()+"</td>");
                    out.println("<td>"+pr.get(i).getIdProveedor()+"</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
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
