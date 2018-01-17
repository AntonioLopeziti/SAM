/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Equipos;
import Entidades.centros;
import Entidades.equipos;
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
@WebServlet(name = "peticionModuloListaMateriales", urlPatterns = {"/peticionModuloListaMateriales"})
public class peticionModuloListaMateriales extends HttpServlet {

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
           String Accion = request.getParameter("Acc");
           String Equipo = request.getParameter("Equipo");
           String DenEquipo = request.getParameter("DenEquipo");
           String Cantidad = request.getParameter("CtdAcc");
           String Idioma = request.getParameter("idioma");
           
           String Centro = request.getParameter("Centro");
           String NCentro = request.getParameter("NCentro");
           switch(Accion){
               case "ConsultarEquipo":
                   int Limequipo = Integer.parseInt(Cantidad);
                    String query = "SELECT * FROM equipos WHERE num_equipo LIKE '" + Equipo + "%' AND descripcion_equipo LIKE '"+DenEquipo+"%'  LIMIT " + Limequipo + "";
                //    LinkedList<equipos> eq = ACC_Equipos.ObtenerInstancia().ConsultaEquipoLM(query);
//                    if (eq.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (int i = 0; i < eq.size(); i++) {
//                            out.println("<tr ondblclick=\"Select('" +eq.get(i).getNum_equipo() + "','Equipo')\" >");
//                            out.println("<td>" + eq.get(i).getNum_equipo() + "</td>");
//                            out.println("<td>" + eq.get(i).getDescripcion_equipo() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//
//                    } else {
//                        out.println(0);
//                    }
                   break;
               case "ConsultarCentro":
                   int LimCentro = Integer.parseInt(Cantidad);
                    String queryC = "SELECT * FROM centros WHERE centro LIKE '" + Centro + "%' AND descripcion LIKE '"+NCentro+"%'  LIMIT " + LimCentro + "";
                    LinkedList<centros> c = ACC_Centro.ObtenerInstancia().ConsultaMatchCentroSP(queryC);
                    if (c.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + c.get(i).getCentro() + "','Centro')\" >");
                            out.println("<td>" + c.get(i).getCentro() + "</td>");
                            out.println("<td>" + c.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");

                    } else {
                        out.println(0);
                    }
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
