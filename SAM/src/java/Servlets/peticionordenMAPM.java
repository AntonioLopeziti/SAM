/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Planop;
import Entidades.plan_orden;
import Entidades.planop;
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
@WebServlet(name = "peticionordenMAPM", urlPatterns = {"/peticionordenMAPM"})
public class peticionordenMAPM extends HttpServlet {

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
            String meeq = request.getParameter("meeq");
            String meubte = request.getParameter("meubte");
            String metxt = request.getParameter("metxt");
            String ven = request.getParameter("ven");
            String cam = request.getParameter("cam");
            
            
            
            LinkedList <plan_orden> pl = ACC_Planop.ObtenerInstancia().PlanorMAPM(Idioma, meeq, meubte,metxt);
            if(pl.size() <= 0 ){
              out.println(0);
            }
            else{
            out.println("<table>");
            out.println("<tbody>");
              for(int i = 0; i < pl.size(); i++){
                  out.println("<tr ondblclick=\"seleccionar('"+pl.get(i).getNum_orden()+"','"+cam+"','"+ven+"')\">");
                    out.println("<td>"+pl.get(i).getCentro_puesto_trabajo_responsable()+"</td>");
                    out.println("<td>"+pl.get(i).getNum_orden()+"</td>");
                    out.println("<td>"+pl.get(i).getTexto_breve()+"</td>");
                    out.println("</tr>");
              }
            
            out.println("</tbody>");
            out.println("</table>");
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
