/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Ordenes_pm_notificaciones;
import Entidades.cabecera_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import Entidades.ordenes_pm_notificaciones;
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
@WebServlet(name = "peticionesOrdenesCrearNoti", urlPatterns = {"/peticionesOrdenesCrearNoti"})
public class peticionesOrdenesCrearNoti extends HttpServlet {

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

            String plao = request.getParameter("env1vm");
            String orde = request.getParameter("ordmatvm");
            String deso = request.getParameter("txtbrvm");
            String canm = request.getParameter("env5vm");
//            String query = "";
//            if (canm.length() > 0) {
//                query = "select top " + canm + " * from PM.cabecera_ordenes_crea where folio_sam like'" + orde + "%'"
//                        + " and texto_breve like'" + deso + "%'";
//            } else {
//                query = "select * from PM.cabecera_ordenes_crea where folio_sam like'" + orde + "%'"
//                        + " and texto_breve like'" + deso + "%'";
//            }

            //and grupo_compras_actividad_trabajo_externa like'"+plao+"%'
            LinkedList<ordenes_pm_notificaciones> pl = ACC_Ordenes_pm_notificaciones.ObtenerInstancia().ObtenOrdenNOTI(canm, orde, deso, plao);
//            LinkedList<cabecera_ordenes_crea> ooc = ACC_Orden.ObtenerInstancia().ALLparaMatchNotifi(query);
//            if (pl.size() <= 0 && ooc.size() <= 0) {
//                out.println(0);
//            } else {
                out.println("<table>");
                out.println("<tbody>");
                for (int i = 0; i < pl.size(); i++) {
                    out.println("<tr ondblclick=\"seleccionar('" + pl.get(i).getNum_orden() + "','notor','VentanaModal')\">");
                    out.println("<td>" + pl.get(i).getSociedad_co() + "</td>");
                    out.println("<td>" + pl.get(i).getNum_orden() + "</td>");
                    out.println("<td>" + pl.get(i).getTexto_breve() + "</td>");
                    out.println("</tr>");
                }
//                for (int p = 0; p < ooc.size(); p++) {
//                    out.println("<tr ondblclick=\"seleccionar('" + ooc.get(p).getFolio_sam() + "','notor','VentanaModal')\">");
//                    out.println("<td></td>");
//                    out.println("<td>" + ooc.get(p).getFolio_sam() + "</td>");
//                    out.println("<td>" + ooc.get(p).getTexto_breve() + "</td>");
//                    out.println("</tr>");
//                }

                out.println("</tbody>");
                out.println("</table>");
//            }
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
