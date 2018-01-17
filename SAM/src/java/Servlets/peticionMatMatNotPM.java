/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Stock;
import Entidades.materiales;
import Entidades.materiales_almacen;
import Entidades.stock;
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
@WebServlet(name = "peticionMatMatNotPM", urlPatterns = {"/peticionMatMatNotPM"})
public class peticionMatMatNotPM extends HttpServlet {

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
            String mmmat= request.getParameter("mmmat");
            String mmid= request.getParameter("mmid");
            String mmtxtbr = request.getParameter("mmtxtbr");
            String env5vmat = request.getParameter("env5vmat");
            String mmtipM = request.getParameter("mmtipM");
            
           LinkedList<stock> mt = ACC_Stock.ObtenerInstancia().MatNPMMalmNOTstock(mmmat, mmtxtbr, env5vmat, mmtipM);
           
           for(int i = 0; i < mt.size(); i++){
               
               if(mt.size() == 0){
                 out.println(0);
               }
                else{
                 out.println("<table>");
                 out.println("<tbody>");   
                 out.println("<tr  onclick=\"seleccionar('"+mt.get(i).getMaterial()+"','"+mmid+"','VentModalmat')\">");
                 out.println("<td>"+mt.get(i).getMaterial()+"</td>");
                 out.println("<td>"+mt.get(i).getAlmacen()+"</td>");
                 if(Idioma.equals("ES")){
                    out.println("<td>"+mt.get(i).getDescripcion_ES()+"</td>"); 
                 }
                 else{
                    out.println("<td>"+mt.get(i).getDescripcion_EN()+"</td>"); 
                 }
                 out.println("<td>"+mt.get(i).getTipo_material()+"</td>");
                 out.println("</tr>");
                 out.println("</table>");
                 out.println("</tbody>");
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
