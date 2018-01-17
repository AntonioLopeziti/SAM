/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Qm01_2_notificaciones;
import Entidades.qm01_2_notificaciones;
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
@WebServlet(name = "peticionTab2QM01", urlPatterns = {"/peticionTab2QM01"})
public class peticionTab2QM01 extends HttpServlet {

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
           
           LinkedList<qm01_2_notificaciones> tn = ACC_Qm01_2_notificaciones.ObtenerInstancia().SHOWTabQ2(ord);
           
           for(int i = 0; i < tn.size(); i++){
                    
                    out.println("<tr name='tab2qm' >");
                    out.println("<td>"+tn.get(i).getNum_caracteristicas_inspeccion()+"<input type='text' id='nuci1"+i+"' value='"+tn.get(i).getNum_caracteristicas_inspeccion()+"' hidden/></td>");
                    out.println("<td>"+tn.get(i).getTexto_breve_caracteristicas_inspeccion()+"<input type='text' id='tbci1"+i+"' value='"+tn.get(i).getTexto_breve_caracteristicas_inspeccion()+"' hidden/></td>");
                    out.println("<td>"+tn.get(i).getDescripcion_breve_conjunto_seleccion()+"<input type='text' id='dbcs"+i+"' value='"+tn.get(i).getDescripcion_breve_conjunto_seleccion()+"' hidden/></td>");
                    out.println("<td>"+tn.get(i).getEntrada_catalogo_conjunto_seleccion()+"<input type='text' id='eccs1"+i+"' value='"+tn.get(i).getEntrada_catalogo_conjunto_seleccion()+"' hidden /></td>");
                    
                    if(tn.get(i).getTipo_caracteristicas().equals("03") || tn.get(i).getTipo_caracteristicas().equals("02")){
                     out.println("<td><input type='text' id='numdef1"+i+"' value='' style='width: 40%;' maxlength ='5' name = 'numdef' onclick=\"nonum()\" /></td>");   
                    }else{
                     out.println("<td>"+tn.get(i).getNum_unidades_muestreo_defectuosas()+"<input type='text' id='numdef1"+i+"' value='' name = 'numdef' hidden/></td>");
                    }
                    if(tn.get(i).getTipo_caracteristicas().equals("02")){
                         out.println("<td><input type='text' id='resu1"+i+"' value='' name='resut' hidden/></td>"); 
                    }else{
                         out.println("<td><input type='text' id='resu1"+i+"' style='width: 75%;' maxlength ='7' value='' name='resut' onclick=\"nonum()\" /></td>"); 
                    }
                    if(tn.get(i).getTipo_caracteristicas().equals("02")){
                         out.println("<td><input type='text' id='valo1"+i+"' style='width: 35%;' value='' name = 'valo'  onclick=\"checarPosiMa('"+i+"')\" /><button value='"+i+"' name='btval1' id='btval1"+i+"'  class='BtnMatchIcon' style='margin-left:1px; display : none;' onclick=\"matchqmval('"+i+"')\" ></button></td>"); 
                    }else{
                         out.println("<td><input type='text' id='valo1"+i+"' value='' name = 'valo' hidden/></td>"); 
                    }
                    if(tn.get(i).getTipo_caracteristicas().equals("03")){
                          out.println("<td><input type='text' id='codi1"+i+"' maxlength ='4' value='' style='width: 60%;' name = 'codig' onclick=\"checarPosiMa2('"+i+"')\" /><button value='"+i+"' name='btcod1' id='btcod1"+i+"' class='BtnMatchIcon' style='margin-left:1px; display : none;' onclick=\"matchqmcod('"+i+"')\" ></button></td>"); 
                    }else{
                        out.println("<td><input type='text' id='codi1"+i+"' maxlength ='1' value='' name = 'codig' hidden/></td>"); 
                    }
                     out.println("<td>"+tn.get(i).getUn_medida_graba_cuantitativos()+"<input type='text' id='unimed1"+i+"' value='"+tn.get(i).getUn_medida_graba_cuantitativos()+"' hidden/></td>");
                     out.println("<td><input type='text' id='note1"+i+"' value='' name = 'notae'/></td>");
                     out.println("<td>"+tn.get(i).getCatalogo()+"<input type='text' id='cata1"+i+"' value='"+tn.get(i).getCatalogo()+"' hidden/></td>");
                     out.println("<td hidden><input type='text' id='cta1"+i+"' value='"+tn.get(i).getTipo_caracteristicas()+"' hidden/></td>");
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
