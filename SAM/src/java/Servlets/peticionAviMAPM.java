/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Aviso;
import AccesoDatos.ACC_Avisossap_modificados;
import Entidades.aviso;
import Entidades.avisossap_modificados;
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
 */
@WebServlet(name = "peticionAviMAPM", urlPatterns = {"/peticionAviMAPM"})
public class peticionAviMAPM extends HttpServlet {

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
            String meeq = request.getParameter("meeq");
            String meeq2 = request.getParameter("meeq2");
            String ub2 = request.getParameter("ub2");
            String ub1 = request.getParameter("ub1");
            String or1 = request.getParameter("or1");
            String or2 = request.getParameter("or2");
            String fec1 = request.getParameter("fec1");
            String fec2 = request.getParameter("fec2");
            
            String noti = request.getParameter("noti");
            String noti2 = request.getParameter("noti2");
            String pend = request.getParameter("pend");
            String posp = request.getParameter("posp");
            String entram = request.getParameter("entram");
            String conclu = request.getParameter("conclu");
            if(noti == null || noti==""){
              noti = "0";  
            }
            if(noti2 == null || noti2==""){
              noti2 = "0";  
            }
            if(ub1 == null || ub1==""){
              ub1 = "0";  
            }
            if(ub2 == null || ub2==""){
              ub2 = "0";  
            }
            if(meeq == null || meeq==""){
              meeq = "0";  
            }
            if(meeq2 == null || meeq2==""){
              meeq2 = "0";  
            }   
                 LinkedList<aviso> av = ACC_Aviso.ObtenerInstancia().ConsultaLAvisoAvisos2(noti,noti2,ub1,ub2,meeq,meeq2,fec1,fec2);
                 out.println("<table id=\"TabBody\">");
            out.println("<tbody>");
            for (int i = 0; i < av.size(); i++) {
                out.println("<tr ondblclick=\"MandarDatoVisual('"+av.get(i).getNum_notificacion()+"', '"+av.get(i).getFolio_sam()+"');\">");
                out.println("<td>" + av.get(i).getNum_notificacion() + "</td>");
                out.println("<td>" + av.get(i).getFolio_sam() + "</td>");
                out.println("<td>" + av.get(i).getFecha_aviso() + "</td>");
                out.println("<td>" + av.get(i).getDescripcion() + "</td>");
                out.println("</tr>");
            }
            out.println("<tr class=\"ocultar\">"
                    + "<td>000000000000000000000000</td>"
                    + "<td>000000000000000000000000</td>"
                    + "<td>0000000000000000000</td>"
                    + "<td>000000000000000000000000000000000000000000000000000000000000000000000000</td>"
                    + "</tr>");
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
