/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Planop;
import Entidades.planop;
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
@WebServlet(name = "peticionHRGruPla", urlPatterns = {"/peticionHRGruPla"})
public class peticionHRGruPla extends HttpServlet {

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
            String env1 = request.getParameter("env1");
            String env2 = request.getParameter("env2");
            String env3 = request.getParameter("env3");
            String env5 = request.getParameter("env5");
              
//            if((env1== null || "".equals(env1)) && (env2== null || "".equals(env2)) && (env3== null || "".equals(env3))){
//               LinkedList <planop> plo = ACC_Planop.ObtenerInstancia().ModHRGR_planific(env5);
//               out.println("<table>");
//               out.println("<tbody>");
//               for(int i = 0; i < plo.size(); i++){
//                   out.println("<tr onclick=\"seleccionaDos('"+plo.get(i).getNum_operacion()+"','grpl','VentanaModal8','"+plo.get(i).getCentro_planiorden()+"','centr')\"> ");
//                   out.println("<td>"+plo.get(i).getCentro_planiorden()+"</td>");
//                   out.println("<td>"+plo.get(i).getNum_operacion()+"</td>");
//                   out.println("<td>"+plo.get(i).getDescripcion_oper()+"</td>");
//                   out.println("</tr>");
//               }
//               out.println("</tbody>");
//               out.println("</table>");
//            }
//            else{
//               LinkedList <planop> pp = ACC_Planop.ObtenerInstancia().ShowSpecPlantByTasLis(env1, env2, env3, env5);
//               if(pp.size() < 1){
//                  out.println(0);
//               }
//               else{
//               out.println("<table>");
//               out.println("<tbody>");
//               for(int i = 0; i < pp.size(); i++){
//                   out.println("<tr onclick=\"seleccionaDos('"+pp.get(i).getNum_operacion()+"','grpl','VentanaModal8','"+pp.get(i).getCentro_planiorden()+"','centr')\"> ");
//                   out.println("<td>"+pp.get(i).getCentro_planiorden()+"</td>");
//                   out.println("<td>"+pp.get(i).getNum_operacion()+"</td>");
//                   out.println("<td>"+pp.get(i).getDescripcion_oper()+"</td>");
//                   out.println("</tr>"); 
//               }
//               out.println("</tbody>");
//               out.println("</table>");
//            }
//          }
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
