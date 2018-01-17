/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Qm01_3_notificaciones;
import Entidades.qm01_3_notificaciones;
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
@WebServlet(name = "peticionTab3QM01", urlPatterns = {"/peticionTab3QM01"})
public class peticionTab3QM01 extends HttpServlet {

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
           
           LinkedList<qm01_3_notificaciones> tn = ACC_Qm01_3_notificaciones.ObtenerInstancia().SHOWTabQ3(ord);
           
           for(int i = 0; i < tn.size(); i++){
               String cec = tn.get(i).getEntrada_catalogo_conjunto_seleccion();
               String cas= "";
               if("X".equals(cec)){
                  cas = "checked"; 
               }
                    out.println("<tr>");
                    out.println("<td>"+tn.get(i).getNum_caracteristicas_inspeccion()+"</td>");
                    out.println("<td>"+tn.get(i).getNum_resultado_detallado()+"</td>");
                    out.println("<td>"+tn.get(i).getTexto_breve_caracteristicas_inspeccion()+"</td>");
                    out.println("<td><input type='checkbox' "+cas+" disabled/></td>");
                    out.println("<td>"+tn.get(i).getNum_unidades_muestreo_registradas()+"</td>");
                    out.println("<td>"+tn.get(i).getValor_original_anterior_tratamiento_entradas()+"</td>");
                    out.println("<td>"+tn.get(i).getCodigo()+"</td>");
                    if(tn.get(i).getIcono_valoracion_carac_muestre_parcial().equals("")){
                         out.println("<td></td>");
                    }else{
                         out.println("<td> <input align ='center' type=\"image\" src='images/"+tn.get(i).getIcono_valoracion_carac_muestre_parcial()+".gif' /></td>");
                    }
                    out.println("<td>"+tn.get(i).getDescripcion_breve_conjunto_seleccion()+"</td>");
                    out.println("<td>"+tn.get(i).getTexto_breve()+"</td>");
                    out.println("<td>"+tn.get(i).getCreador_registro_datos()+"</td>");                   
                    out.println("</tr>");
           }
               out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n" +
"                           <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n" +
"                                         ");
        
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
