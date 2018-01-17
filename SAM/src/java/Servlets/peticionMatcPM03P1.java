/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Pm_operaciones_notificaciones;
import Entidades.pm_operaciones_notificaciones;
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
@WebServlet(name = "peticionMatcPM03P1", urlPatterns = {"/peticionMatcPM03P1"})
public class peticionMatcPM03P1 extends HttpServlet {

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
            String ord = request.getParameter("ord");
            String oper = request.getParameter("oper");
            
           pm_operaciones_notificaciones eq = ACC_Pm_operaciones_notificaciones.ObtenerInstancia().INPGRNOTPMNOT(ord, oper);
              
            out.println("<input type'text' id='nspp32' value='"+eq.getNum_solicitud_pedido()+"' />");
            out.println("<input type'text' id='npspp32' value='"+eq.getNum_posicion_socitud_pedido_orden()+"' />");
            out.println("<input type'text' id='prep32' value='"+eq.getPrecio()+"' />");
            out.println("<input type'text' id='clmop32' value='"+eq.getClave_moneda()+"' />");
            out.println("<input type'text' id='cabap32' value='"+eq.getCantidad_base2()+"' />");
            out.println("<input type'text' id='grarp32' value='"+eq.getGrupo_articulos()+"' />");
            out.println("<input type'text' id='gcate32' value='"+eq.getGrupo_compras_actividad_trabajo_externa()+"' />");
            out.println("<input type'text' id='ocop32' value='"+eq.getOrganizacion_compras()+"' />");
            out.println("<input type'text' id='provp32' value='"+eq.getProveedor()+"' />");
            out.println("<input type'text' id='solp32' value='"+eq.getSolicitante()+"' />");
          
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
