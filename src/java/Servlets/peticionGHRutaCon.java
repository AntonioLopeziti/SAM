/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Hojarutatres;
import Entidades.hojarutatres;
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
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionGHRutaCon", urlPatterns = {"/peticionGHRutaCon"})
public class peticionGHRutaCon extends HttpServlet {

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
            
            String Idioma = (String)session.getAttribute("Idioma") ;
            String env1 = request.getParameter("env1");
            String env2 = request.getParameter("env2");
            String env3 = request.getParameter("env3");
            String env4 = request.getParameter("env4");
            String env5 = request.getParameter("env5");
           
            out.println("<table>");
             out.println("<tbody>");
            
            if((env4 == "" || env4 == null) && ("".equals(env2) || env2 == null) && ("".equals(env3) || env3 == null)){
           
            LinkedList <hojarutatres> hr = ACC_Hojarutatres.ObtenerInstancia().ConsultarHRutas();
             
            for(int i = 0; i < hr.size(); i++){
            
                out.println("<tr onclick=\"seleccionar('"+hr.get(i).getClave_gruphojaruta()+"','ghrin','VentanaModal2')\"> ");
                out.println("<td>"+hr.get(i).getClave_gruphojaruta()+"</td>");
                out.println("<td>"+hr.get(i).getContador_grupohojaruta()+"</td>");
                out.println("<td>"+hr.get(i).getDescripcion_contador()+"</td>");
            }
                
                
            }else{
               LinkedList <hojarutatres> rh = ACC_Hojarutatres.ObtenerInstancia().ConsultaXPCL(env1,env2,env3,env4,env5);
                 for(int i = 0; i<rh.size(); i++ ){
                out.println("<tr onclick=\"seleccionar('"+rh.get(i).getClave_gruphojaruta()+"','ghrin','VentanaModal2')\"> ");
                out.println("<td>"+rh.get(i).getClave_gruphojaruta()+"</td>");
                out.println("<td>"+rh.get(i).getContador_grupohojaruta()+"</td>");
                out.println("<td>"+rh.get(i).getDescripcion_contador()+"</td>"); 
               }
            }
            out.println("</table>");
             out.println("</tbody>");
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
