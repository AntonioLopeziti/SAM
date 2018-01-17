/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import  java.util.Properties;
import  java.io.InputStream;
import  java.net.URL;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Equipos;
import Entidades.centros;
import Entidades.equipos;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo Hernandez
 */
@WebServlet(name = "CentroPlanificacion", urlPatterns = {"/CentroPlanificacion"})
public class CentroPlanificacion extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Centros = request.getParameter("val");
            
            if(Centros == null || Centros == "")
            {
                
                ArrayList<centros> equ = ACC_Centro.ObtenerInstancia().ConsultaCentros();
                out.println("<table>"
                        +   "<tbody>");              
                for(int i = 0; i < equ.size(); i++)
                {
                    out.println("<tr ondblclick=\"Selecionar('" + equ.get(i).getCentro() +"', 'Ctro', 'VtnCentro')\">");
                    out.println("<td>" + equ.get(i).getCentro() + "</td>");
                    out.println("<td>" + equ.get(i).getDescripcion() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>"
                        +   "</table>");
                                
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CentroPlanificacion.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CentroPlanificacion.class.getName()).log(Level.SEVERE, null, ex);
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
