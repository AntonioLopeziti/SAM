/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_MonitorStatus;
import Entidades.MonitorStatus;
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
 * @author Eduardo Hernandez
 */
@WebServlet(name = "PeticionMonitorStatusCont", urlPatterns = {"/PeticionMonitorStatusCont"})
public class PeticionMonitorStatusCont extends HttpServlet {

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
            String Tabla = request.getParameter("val");
            String Language = request.getParameter("Idioma");
            String Modo = request.getParameter("modo");
            String Centro = request.getParameter("ct");
            String Ubitec = request.getParameter("ub");
            String Equipo = request.getParameter("eq");
            String Jerarq = request.getParameter("jr");
            String SFI = request.getParameter("sf");
            String eq2 = request.getParameter("eq2");
            String pue = request.getParameter("pue");
            int c;
            String input;
            LinkedList<MonitorStatus> Msc;
            if(eq2.equals("")){
                Msc = ACC_MonitorStatus.ObtenerInstancia().ConsultaRelacion(Modo, Centro, Ubitec, Equipo, Jerarq, SFI,eq2, pue);
            }else{
                Msc = ACC_MonitorStatus.ObtenerInstancia().ConsultaRelacionEq(Modo, Centro, Ubitec, Equipo, Jerarq, SFI,eq2, pue);
            }
            if(Tabla == null || Tabla == "")
            {
                if(Language.equals("ES"))
                {
                    out.println("<table class=\"TablaCont\">\n" +
"                            <thead>\n" +
"                                <tr id=\"CabeceraTabla\">\n" +
"                                    <td>&nbsp;</td>\n" +
"                                    <td>Nivel</td>\n" +
"                                    <td>Status</td>\n" +
"                                    <td>Equipo&nbsp;&nbsp;&nbsp;&nbsp;</td>\n" +
"                                    <td>Denominación&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;</td>\n" +
"                                    <td>Contador</td>\n" +
"                                    <td>ÚltimoDoc.Med</td>\n" +
"                                    <td>Últ.Med.Anexada</td>\n" +
"                                    <td>StatusContador</td>\n" +
"                                    <td>UMC</td>\n" +
"                                    <td>Ubicación&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;</td>\n" +
"                                    <td>Material</td>\n" +
"                                    <td>Centro</td>\n" +
"                                    <td>No.Serie&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;</td>\n" +
"                                    <td>Almacén</td>\n" +
"                                    <td>Lote&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n" +
"                                </tr>\n" +
"                            </thead>\n" +
"                            <tbody id=\"jaja\" >\n");
                    for(c = 0; c < Msc.size(); c++)
                    {
                        if (Msc.get(c).getDoc_medicion().equals("")){ input = "<input type=\"radio\" name=\"monitor\" "
                        + "value=\""+ Msc.get(c).getJerarquia() +"," + Msc.get(c).getNivel() + ","
                        + "" + Msc.get(c).getElem_ref_pmps() + "," + Msc.get(c).getEquipo() + ","
                        + "" + Msc.get(c).getDen_objtec()+ "," + Msc.get(c).getPunto_medida()+ ","
                        + "" + Msc.get(c).getDoc_medicion()+ " ," + Msc.get(c).getUlt_med_anexada()+ ","
                        + "" + Msc.get(c).getStatus_contador()+ "," + Msc.get(c).getUnidad_medida_entradadoc()+ ","
                        + "" + Msc.get(c).getMaterial()+ "," + Msc.get(c).getCentro()+ ","
                        + "" + Msc.get(c).getSerie()+ "," + Msc.get(c).getAlmacen()+ ","
                        + "" + Msc.get(c).getLote()+ " \"  onclick=\"NuevaTabla()\" />"; }
                        else{ input = "<input type=\"radio\" name=\"monitor\" "
                        + "value=\""+ Msc.get(c).getJerarquia() +"," + Msc.get(c).getNivel() + ","
                        + "" + Msc.get(c).getElem_ref_pmps() + "," + Msc.get(c).getEquipo() + ","
                        + "" + Msc.get(c).getDen_objtec()+ "," + Msc.get(c).getPunto_medida()+ ","
                        + "" + Msc.get(c).getDoc_medicion()+ " ," + Msc.get(c).getUlt_med_anexada()+ ","
                        + "" + Msc.get(c).getStatus_contador()+ "," + Msc.get(c).getUnidad_medida_entradadoc()+ ","
                        + "" + Msc.get(c).getMaterial()+ "," + Msc.get(c).getCentro()+ ","
                        + "" + Msc.get(c).getSerie()+ "," + Msc.get(c).getAlmacen()+ ","
                        + "" + Msc.get(c).getLote()+ " \"  onclick=\"NuevaTabla()\" />"; }
                        out.println("" +
"                               <tr id=\""+Msc.get(c).getEquipo()+"\" ondblclick=\"unselectSon(" + c + ")\">"
                                    + "<td hidden><input type=\"checkbox\" name=\"CKmonitor\" id=\"myCheck" + c + "\" value=\""+ c + "\"></td>"
                                    + "<td>" + input + "</td>"
                                    + "<td>" + Msc.get(c).getNivel() + "</td>"
                                    + "<td><img src='images/" + Msc.get(c).getElem_ref_pmps() + ".PNG' /></td>"
                                    + "<td>" + Msc.get(c).getEquipo() + "</td>"
                                    + "<td>" + Msc.get(c).getDen_objtec()+ "</td>"
                                    + "<td>" + Msc.get(c).getPunto_medida()+ "</td>"
                                    + "<td>" + Msc.get(c).getDoc_medicion()+ "</td>"
                                    + "<td>" + Msc.get(c).getUlt_med_anexada()+ "</td>"
                                    + "<td>" + Msc.get(c).getStatus_contador()+ "</td>"
                                    + "<td>" + Msc.get(c).getUnidad_medida_entradadoc()+ "</td>"
                                    + "<td>"+ Msc.get(c).getId_ubitec()+"</td>"
                                    + "<td>" + Msc.get(c).getMaterial()+ "</td>"
                                    + "<td>" + Msc.get(c).getCentro()+ "</td>"
                                    + "<td>" + Msc.get(c).getSerie()+ "</td>"
                                    + "<td>" + Msc.get(c).getAlmacen()+ "</td>"
                                    + "<td>" + Msc.get(c).getLote()+ "</td>"
                                    + "</tr>");
                    }
                    for(int i = c; i < 19; i++)
                    {
                        out.println("" +
"                               <tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>" 
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                    }
                    out.print("</tbody>" +
"                              </table>");
                }
                else
                {
                    out.println("<table class=\"TablaCont\">\n" +
"                            <thead>\n" +
"                                <tr id=\"CabeceraTabla\">\n" +
"                                    <td>&nbsp;</td>\n" +
"                                    <td>Level</td>\n" +
"                                    <td>Status</td>\n" +
"                                    <td>Equipment&nbsp;&nbsp;&nbsp;&nbsp;</td>\n" +
"                                    <td>Denomination&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                     + "&nbsp;&nbsp;&nbsp;</td>\n" +
"                                    <td>Counter</td>\n" +
"                                    <td>St.Counter</td>\n" +
"                                    <td>LastMea.Annexed</td>\n" +
"                                    <td>CounterStatus</td>\n" +
"                                    <td>BUN</td>\n" +
"                                    <td>Location</td>\n" +
"                                    <td>Material</td>\n" +
"                                    <td>Plant</td>\n" +
"                                    <td>Serial.N</td>\n" +
"                                    <td>Plant</td>\n" +
"                                    <td>Batch</td>\n" +
"                                </tr>\n" +
"                            </thead>\n" +
"                            <tbody id=\"jaja\">\n");
                    for(c = 0; c < Msc.size(); c++)
                    {
                        if (Msc.get(c).getDoc_medicion().equals("")){ input = "<input type=\"radio\" name=\"monitor\">"; }
                        else{ input = "<input type=\"radio\" name=\"monitor\">"; }
                        out.println("" +
"                               <tr id=\""+Msc.get(c).getEquipo()+"\" >"
                                    + "<td>" + input + "</td>"
                                    + "<td>" + Msc.get(c).getNivel() + "</td>"
                                    + "<td><img src='images/" + Msc.get(c).getElem_ref_pmps() + ".PNG' /></td>"
                                    + "<td>" + Msc.get(c).getEquipo() + "</td>"
                                    + "<td>" + Msc.get(c).getDen_objtec()+ "</td>"
                                    + "<td>" + Msc.get(c).getPunto_medida()+ "</td>"
                                    + "<td>" + Msc.get(c).getDoc_medicion()+ "</td>"
                                    + "<td>" + Msc.get(c).getUlt_med_anexada()+ "</td>"
                                    + "<td>" + Msc.get(c).getStatus_contador()+ "</td>"
                                    + "<td>" + Msc.get(c).getUnidad_medida_entradadoc()+ "</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>" + Msc.get(c).getMaterial()+ "</td>"
                                    + "<td>" + Msc.get(c).getCentro()+ "</td>"
                                    + "<td>" + Msc.get(c).getSerie()+ "</td>"
                                    + "<td>" + Msc.get(c).getAlmacen()+ "</td>"
                                    + "<td>" + Msc.get(c).getLote()+ "</td>"
                                    + "</tr>");
                    }
                    for(int i = c; i < 19; i++)
                    {
                        out.println("" +
"                               <tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>" 
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                    }
                    out.print("</tbody>" +
"                              </table>");
                }
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
