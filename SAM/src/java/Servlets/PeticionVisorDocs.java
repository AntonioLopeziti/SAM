/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Ficheros;
import Entidades.Ficheros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionVisorDocs", urlPatterns = {"/PeticionVisorDocs"})
public class PeticionVisorDocs extends HttpServlet {

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
            int c = 0;
            String accion = request.getParameter("accion");
            String ruta = request.getParameter("ruta");
            String ip = request.getRemoteAddr();
            
            switch(accion)
            {
                case "CargaTabla":
                    List<Ficheros> ff = ACC_Ficheros.ObtenerInstancia().MostrarFicheros("C:/DMS/Equipos/CARITEST001");
                    out.println("<table id=\"TabBodyN\">\n" +
        "                                        <tbody>");
                    for(Ficheros nf : ff)
                    {
        //                out.println("<tr ondblclick=\"PathFile('" + nf.getExtencion() + "', '" + c + "', '" + nf.getName() + "')\">"
                        out.println("<tr ondblclick=\"SendPath('" + c + "')\">"
                                + "<td>" + nf.getApl() + "</td>"
                                + "<td>" + nf.getAplicacion() + "</td>"
                                + "<td>" + nf.getCategoria() + "</td>"
                                + "<td>" + nf.getArea() + "</td>"
                                + "<td>" + nf.getIndicador() + "</td>"
                                + "<td name=\"tdFch\">" + nf.getFichero() + "</td>"
                                + "<td>" + nf.getTamanio() + "</td>"
                                + "</tr>");
                        c++;
                    }
                    for(int i = c; i < 12; i++)
                    {
                        out.println("<tr>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>ADMON_POR</td>"
                            + "<td>ADMON_PORTUARIA__INTEGRAL_</td>"
                            + "<td>ADMON_PORTUAR</td>"
                            + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                            + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
                            + "<td>ADMON_PORTUARIA__INTEGRAL_ADMON_PORTUAN_PORTUA</td>"
                            + "<td>ADMON_P</td>"
                            + "</tr>"
                            + "</tbody>"
                            + "</table>");
                    break;
                case "EnviarSocket":
                    if(ACC_Ficheros.ObtenerInstancia().SendFile("C:\\DMS\\Equipos\\CARITEST001\\" + ruta, ip)) { out.println(0); }
                    else { out.println(1); }
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
