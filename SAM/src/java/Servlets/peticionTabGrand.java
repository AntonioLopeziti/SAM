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
@WebServlet(name = "peticionTabGrand", urlPatterns = {"/peticionTabGrand"})
public class peticionTabGrand extends HttpServlet {

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
            String ope = request.getParameter("ope");
            
            LinkedList<pm_operaciones_notificaciones> tb = ACC_Pm_operaciones_notificaciones.ObtenerInstancia().TABGRNOTPMNot(ord, ope);
            String checa="";
            String checa1="";
           
            for(int i = 0; i < tb.size(); i++){
                   String val= tb.get(i).getIndicador_valor_prede_traba_relevante();
                   String val2 = tb.get(i).getId_objeto_recurso();
                    if("X".equals(val)){
                       checa="checked";
                    }else{
                      checa = "";  
                    }
                    if( "X".equals(val2)){
                       checa1="checked";
                    }else{
                      checa1 = "";  
                    }
                    out.println("<tr>");
                    out.println("<td> <input type=\"radio\" class=\"che\" value='"+tb.get(i).getClave_control()+","+tb.get(i).getNum_operacion()+","+tb.get(i).getCentro()+"'  name=\"checkbo\" /></td>");
                    out.println("<td><input type=\"checkbox\" id='nf"+i+"'  name=\"che\" "+checa+" disabled  /></td>");
                    out.println("<td>"+tb.get(i).getNum_operacion()+"</td>");
                    out.println("<td>"+tb.get(i).getClave_control()+"</td>");
                    out.println("<td>"+tb.get(i).getId_objeto_recurso()+"</td>");
                    out.println("<td name=\"cntx\">"+tb.get(i).getCentro()+"</td>");
                    out.println("<td>"+tb.get(i).getTexto_breve_operacion()+"</td>");
                    out.println("<td>"+tb.get(i).getCantidad_base()+"</td>");
//                    out.println("<td>"+tb.get(i).getUnidad_medida_operacion()+"</td>");
                    out.println("<td>"+tb.get(i).getDuracion_operacion_normal()+"</td>");
                    out.println("<td>"+tb.get(i).getActividad_ya_notificada01()+"</td>");
                    out.println("<td>"+tb.get(i).getUnidad_duracion_normal()+"</td>");
//                    out.println("<td>"+tb.get(i).getTrabajo_operacion()+"</td>");
//                    out.println("<td>"+tb.get(i).getActividad_ya_notificada02()+"</td>");
//                    out.println("<td>"+tb.get(i).getUnidad_trabajo()+"</td>");
//                    out.println("<td>"+tb.get(i).getUnidad_medida_actividad_notificar01()+"</td>");
//                    out.println("<td>"+tb.get(i).getUnidad_medida_actividad_notificar02()+"</td>");
                    out.println("</tr>");
            }
            out.println("<tr><td><input type=\"radio\" class=\"che\" id=\"checkbox3\" name=\"checkbo\" value=\"val4\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n" +
"                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox4\" name=\"checkbo\" value=\"val5\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n" +
"                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox5\" name=\"checkbo\" value=\"val6\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n" +
"                                                    ");
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
