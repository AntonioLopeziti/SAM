/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.pp_operaciones_noti;
import AccesoDatos.ACC_Pp_operaciones_noti;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jhonatan
 */
@WebServlet(name = "PeticionCabPP01PP", urlPatterns = {"/PeticionCabPP01PP"})
public class PeticionCabPP01PP extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String ord = request.getParameter("orden");
            String oper = request.getParameter("opera");
            
            pp_operaciones_noti eq = ACC_Pp_operaciones_noti.ObtenerInstancia().INPGRNOTPMNOTPP(ord, oper);
            
            out.println("<input type'text' id='nspp12' value='"+ord+"' />");
            out.println("<input type'text' id='npspp12' value='"+oper+"' />");
            out.println("<input type'text' id='txbp12' value='"+eq.getTexto_breve_operacion()+"' />");
            out.println("<input type'text' id='canbap12' value='"+eq.getCantidad_base()+"' />");
            out.println("<input type'text' id='umpp12' value='"+eq.getUnidad_medida_operacion()+"' />");
            out.println("<input type'text' maxlength=\"1\" id='ivptp12' value='"+eq.getIndicador_valor_prede_traba_relevante()+"' />");
            out.println("<input type'text' id='donp12' value='"+eq.getDuracion_operacion_normal()+"' />");
            out.println("<input type'text' id='udnp12' value='"+eq.getUnidad_duracion_normal()+"' />");
            out.println("<input type'text' id='top12' value='"+eq.getTrabajo_operacion()+"' />");
            out.println("<input type'text' id='utp12' value='"+eq.getUnidad_trabajo()+"' />");
            out.println("<input type'text' id='aynp12' value='"+eq.getActividad_ya_notificada01()+"' />");
            out.println("<input type'text' id='ayn2p12' value='"+eq.getActividad_ya_notificada02()+"' />");
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
