/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import Entidades.centros;
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
@WebServlet(name = "peticionCentrosHRutaMod", urlPatterns = {"/peticionCentrosHRutaMod"})
public class peticionCentrosHRutaMod extends HttpServlet {

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
            String cen5 = request.getParameter("cen5");
            String cen51 = request.getParameter("cen51");
            String cen52 = request.getParameter("cen52");
            
            
            if((cen5 == null || "".equals(cen5)) && (cen51 == null || "".equals(cen51))){
                LinkedList <centros> ce = ACC_Centro.ObtenerInstancia().AllPlantTaskList(cen52);
                out.println("<table>");
                out.println("<tbody>");
                for(int i = 0; i < ce.size(); i++){
                    out.println("<tr onclick=\"seleccionaDos('"+ce.get(i).getCentro()+"','centr','VentanaModal5','"+ce.get(i).getCentro()+"','cen8')\">");
                    out.println("<td>"+ce.get(i).getCentro()+"</td>");
                    out.println("<td>"+ce.get(i).getDescripcion()+"</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
            }
            else{
                LinkedList <centros> cen = ACC_Centro.ObtenerInstancia().ShowPlaModHr(cen5, cen51);
                if(cen.size() < 1){
                out.println(0);     
                }else{
                   out.println("<table>");
                   out.println("<tbody>"); 
                   for(int i = 0; i < cen.size(); i++){
                    out.println("<tr onclick=\"seleccionaDos('"+cen.get(i).getCentro()+"', 'centr', 'VentanaModal5', '"+cen.get(i).getCentro()+"', 'cen8')\" >");
                    out.println("<td>"+cen.get(i).getCentro()+"</td>");
                    out.println("<td>"+cen.get(i).getDescripcion()+"</td>");
                    out.println("</tr>");
                }
                   out.println("</tbody>");
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
