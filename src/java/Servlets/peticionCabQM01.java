/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Qm_cabecera;
import Entidades.Qm_Cabetodo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionCabQM01", urlPatterns = {"/peticionCabQM01"})
public class peticionCabQM01 extends HttpServlet {

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
           
           Qm_Cabetodo qm = ACC_Qm_cabecera.ObtenerInstancia().SHOWTabQ1CAB(ord);
           
           out.println("<input type='text' id='nuoqm12' value='"+qm.getNum_orden()+"' /> ");
           out.println("<input type='text' id='nliqm12' value='"+qm.getNum_lote_inspeccion()+"' /> ");
           out.println("<input type='text' id='crdqm12' value='"+qm.getCreado_registro_datos()+"' /> ");
           out.println("<input type='text' id='umrqm12' value='"+qm.getUltimo_modificador_registro_datos()+"' /> ");
           out.println("<input type='text' id='txbqm12' value='"+qm.getTexto_breve()+"' /> ");
           out.println("<input type='text' id='cenqm12' value='"+qm.getCentro()+"' /> ");
           out.println("<input type='text' id='fclqm12' value='"+qm.getFecha_creacion_lote()+"' /> ");
           out.println("<input type='text' id='fmrqm12' value='"+qm.getFecha_modificacion_registro_datos()+"' /> ");
           out.println("<input type='text' id='hclqm12' value='"+qm.getHora_creacion_lote()+"' /> ");
           out.println("<input type='text' id='hmlqm12' value='"+qm.getHora_modificacion_lote()+"' /> ");
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
