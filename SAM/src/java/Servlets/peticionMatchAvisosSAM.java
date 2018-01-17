/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import AccesoDatos.ACC_Aviso;
import Entidades.aviso;
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
 * @author Developer-Antonio
 */
@WebServlet(name = "peticionMatchAvisosSAM", urlPatterns = {"/peticionMatchAvisosSAM"})
public class peticionMatchAvisosSAM extends HttpServlet {
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
            String id = request.getParameter("id");
            String fun = request.getParameter("fun");           
            int r = 11;

//            if (id == null && fun == null) {
//                LinkedList<aviso> a = ACC_Aviso.ObtenerInstancia().ConsultaMatchAvisos();
//                out.println("<table>");
//                out.println("<tr>");
//                out.println("<td align=\"center\" width=\"50%\">Descripción Notificación</td>");
//                out.println("<td align=\"center\" width=\"50%\">Clase Aviso</td>");
//                out.println("</tr>");
//                for (int i = 0; i < a.size(); i++) {
//
//                    out.println("<tr>");
//                    out.println("<td align=\"center\" width=\"50%\" ondblclick=\"Select('" + a.get(i).getNum_notificacion() + "');\" >" + a.get(i).getNum_notificacion() + "</td>");
//                    out.println("<td align=\"center\" width=\"50%\">" + a.get(i).getClase_aviso() + "</td>");
//                    out.println("</tr>");
//
//                }
//                out.println("</table>");
//
//            } else if (fun == null && id != null) {
//                LinkedList<aviso> a = ACC_Aviso.ObtenerInstancia().BuscarMatchAvisos(id);
//                if (a.size() > 0) {
//                    out.println("<table class=\"Tabla\">");
//                    out.println("<tr>");
//                    out.println("<td align=\"center\" width=\"50%\">Descripción Notificación</td>");
//                    out.println("<td align=\"center\" width=\"50%\">Clase Aviso</td>");
//                    out.println("</tr>");
//                    for (int i = 0; i < a.size(); i++) {
//                        out.println("<tr ondblclick=\"Select('" + a.get(i).getNum_notificacion() + "');\">");
//                        out.println("<td align=\"center\" width=\"50%\" >" + a.get(i).getNum_notificacion() + "</td>");
//                        out.println("<td align=\"center\" width=\"50%\">" + a.get(i).getClase_aviso() + "</td>");
//                        out.println("</tr>");
//
//                    }
//                    out.println("</table>");
//                } else {
//                    out.println("No encontramos un elemento con la filtracion '" + id + "'");
//                }

            

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
