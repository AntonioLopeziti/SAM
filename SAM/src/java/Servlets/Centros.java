/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import Entidades.centros;
import java.sql.SQLException;
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
 * @author Jonathan Lopez
 */
@WebServlet(name = "Centros", urlPatterns = {"/Centros"})
public class Centros extends HttpServlet {

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
            String accion = request.getParameter("Action");
            HttpSession session = request.getSession();
            String idioma = (String)session.getAttribute("Idioma");
            String centro = request.getParameter("Parametro1");
            String ctdmax = request.getParameter("Parametro2");
            switch(accion)
            {
                case "ValidaCentro":
                    if(ACC_Centro.ObtenerInstancia().ValidarCentroModVisual(centro))
                    {
                        out.println(1);
                    }
                    break;
                case "ConsultaCentro":
                    int ctdaciertos = Integer.parseInt(ctdmax);
                    LinkedList<centros> centr = ACC_Centro.ObtenerInstancia().ConsultaMatchCentro(centro, ctdaciertos);
                    out.println("<table>");
                    out.println("<tbody>");
                    for(int i = 0; i < centr.size(); i++)
                    {
                        out.println("<tr ondblclick=\"seleccionar2('" + centr.get(i).getCentro() + "')\">");
                        out.println("<td>" + centr.get(i).getCentro() + "</td>");
                        out.println("<td>" + centr.get(i).getDescripcion() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody");
                    out.println("</table");
                    break;
                default:
                out.println(1);
                break;
            }
            /*if(centro == null || centro == "")
            {
                if(idioma.equals("ES"))
                {
                   LinkedList <centro> ce = ACC_Centro.ObtenerInstancia().ConsultaCentros();
                   out.println("<table style=\"text-align:center;\" class=\"Tabla\">");
                   out.println("<tr>");
                   out.println("<td>Centro</td>");
                   out.println("<td>Descripción</td>");
                   out.println();
                   out.println("</tr>");
                   for(int i = 0; i < ce.size(); i++)
                   {
                       out.println("<tr ondblclick=\"seleccionar2('" + ce.get(i).getCentro()+"')\" >");
                       out.println("<td>"+ce.get(i).getCentro()+"</td>");
                       out.println("<td>"+ce.get(i).getDescripcion()+"</td>");
                       out.println("<tr>");
                   }
                   out.println("</table>"); 
                }
                else
                {
                    LinkedList <centro> ce = ACC_Centro.ObtenerInstancia().ConsultaCentros();
                   out.println("<table style=\"text-align:center;\" class=\"Tabla\">");
                   out.println("<tr>");
                   out.println("<td>Center</td>");
                   out.println("<td>Description</td>");
                   out.println();
                   out.println("</tr>");
                   for(int i = 0; i < ce.size(); i++)
                   {
                       out.println("<tr ondblclick=\"seleccionar2('" + ce.get(i).getCentro()+"')\" >");
                       out.println("<td>"+ce.get(i).getCentro()+"</td>");
                       out.println("<td>"+ce.get(i).getDescripcion()+"</td>");
                       out.println("<tr>");
                   }
                   out.println("</table>"); 
                }
            }*/
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
