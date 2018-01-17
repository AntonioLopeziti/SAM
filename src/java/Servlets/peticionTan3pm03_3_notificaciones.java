/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Pm03_3_notificaciones;
import Entidades.pm03_3_notificaciones;
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
@WebServlet(name = "peticionTan3pm03_3_notificaciones", urlPatterns = {"/peticionTan3pm03_3_notificaciones"})
public class peticionTan3pm03_3_notificaciones extends HttpServlet {

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
           
           LinkedList<pm03_3_notificaciones> tn = ACC_Pm03_3_notificaciones.ObtenerInstancia().TABGRNOTPM(ord);
           
           for(int i = 0; i < tn.size(); i++){
                    out.println("<tr>");
                    out.println("<td>"+tn.get(i).getNum_doc_compras()+"</td>");
                    out.println("<td>"+tn.get(i).getNum_posicion_doc_compras()+"</td>");
                    out.println("<td>"+tn.get(i).getEjercicio_doc_material()+"</td>");
                    out.println("<td>"+tn.get(i).getNum_doc_material()+"</td>");
                    out.println("<td>"+tn.get(i).getPosicion_doc_material()+"</td>");
                    out.println("<td>"+tn.get(i).getTipo_historial_pedido()+"</td>");
                    out.println("<td>"+tn.get(i).getClase_movimiento_gestion_stock()+"</td>");
                    out.println("<td>"+tn.get(i).getFecha_contabilizacion_doc()+"</td>");
                    out.println("<td>"+tn.get(i).getCantidad()+"</td>");
                    out.println("<td>"+tn.get(i).getImporte_moneda_doc()+"</td>");
                    out.println("<td>"+tn.get(i).getClave_moneda()+"</td>");
                    out.println("<td>"+tn.get(i).getResponsable_anadio_objeto()+"</td>");
                    out.println("</tr>");
           }
           for(int i = 0; i < 10; i++){
                    out.println("<tr>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");
                    out.println("<td></td>");                    
                    out.println("</tr>");
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
