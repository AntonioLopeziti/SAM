/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_ListadoOrdenesPP;
import Entidades.ListadoOrdenesPP;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionListadoOrdenesPP", urlPatterns = {"/PeticionListadoOrdenesPP"})
public class PeticionListadoOrdenesPP extends HttpServlet {

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
            String action = request.getParameter("action");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            
            switch(action){
                case "tablaListado":
                    int cc = 0;
                    ArrayList<ListadoOrdenesPP> lo = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPP();
                    out.println("<table id=\"TabBody\">\n" +
"                                <tbody>");
                    for(ListadoOrdenesPP ll : lo){
                        out.println("	    <tr>\n" +
                                    "	    <td><input type=\"radio\" name=\"gender\" value=\"male\"></td>\n" +
                                    "	    <td>" + ll.getClase_documento_ventas() + "</td>\n" +
                                    "	    <td>" + ll.getNum_orden() + "</td>\n" +
                                    "	    <td>" + ll.getNum_material() + "</td>\n" +
                                    "	    <td>" + ll.getTexto_material() + "</td>\n" +
                                    "	    <td>" + ll.getStatus() + "</td>\n" +
                                    "	    <td>" + ll.getCantidad_total() + "</td>\n" +
                                    "	    <td>" + ll.getFecha_inicio_extrema() + "</td>\n" +
                                    "	    <td>" + ll.getContador_notificacion() + "</td>\n" +
                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                "	    </tr>");
                        cc++;
                    }
                    for(int i = cc; i < 22; i++){
                        out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                    }
                    out.println("<tr class=\"ocultar\">\n" +
                        "        <td>00</td>\n" +
                        "        <td>0000000000</td>\n" +
                        "        <td>00000000000</td>\n" +
                        "        <td>000000000000000000</td>\n" +
                        "        <td>0000000000000000000000000000000000</td>\n" +
                        "        <td>0000000000000000000000000000000000</td>\n" +
                        "        <td>000000000000</td>\n" +
                        "        <td>00000000000</td>\n" +
                        "        <td>00000000</td>\n" +
                        "        <td>00000</td>\n" +
                        "    </tr>\n" +
                        "</tbody>\n" +
                        "</table>");
                    break;
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
