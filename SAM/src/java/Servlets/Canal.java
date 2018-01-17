/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Canal;
import Entidades.canal;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonathan Lopez
 */
@WebServlet(name = "Canal", urlPatterns = {"/Canal"})
public class Canal extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String idioma = (String)session.getAttribute("Idioma");
            String canal = request.getParameter("cana");
            if(canal == null || canal == "")
            {
                if(idioma.equals("ES"))
                {
                    LinkedList <canal> ca = ACC_Canal.ObtenerInstancia().ConsultaCanales();
                    out.println("<table style=\"text-align:center;\" class=\"Tabla\">");
                    out.println("<tr>");
                    out.println("<td>Canal</td>");
                    out.println("<td>Descripción</td>");
                    out.println();
                    out.println("</tr>");
                    for(int i = 0; i < ca.size(); i++)
                    {
                        out.println("<tr ondblclick=\"seleccionar4('" + ca.get(i).getCanal()+"')\" >");
                        out.println("<td>"+ca.get(i).getCanal()+"</td>");
                        out.println("<td>"+ca.get(i).getDescripcion()+"</td>");
                        out.println("<tr>");
                    }
                    out.println("</table>");
                }
                else
                {
                    LinkedList <canal> ca = ACC_Canal.ObtenerInstancia().ConsultaCanales();
                    out.println("<table style=\"text-align:center;\" class=\"Tabla\">");
                    out.println("<tr>");
                    out.println("<td>Channel</td>");
                    out.println("<td>Description</td>");
                    out.println();
                    out.println("</tr>");
                    for(int i = 0; i < ca.size(); i++)
                    {
                        out.println("<tr ondblclick=\"seleccionar4('" + ca.get(i).getCanal()+"')\" >");
                        out.println("<td>"+ca.get(i).getCanal()+"</td>");
                        out.println("<td>"+ca.get(i).getDescripcion()+"</td>");
                        out.println("<tr>");
                    }
                    out.println("</table>");
                }
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
            throws ServletException, IOException 
    {
        try
        {
        processRequest(request, response);
        }catch(SQLException ex)
        {
            Logger.getLogger(OrganizVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            throws ServletException, IOException 
    {
        try
        {
            processRequest(request, response);
        }catch (SQLException ex)
        {
            Logger.getLogger(OrganizVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
