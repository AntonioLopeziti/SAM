/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import AccesoDatos.ACC_Ordenes_pp_notificaciones;
import Entidades.ControlListaOrdenes;
import Entidades.ordenes_pp_notificaciones;
import Entidades.PlanPP;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jhonatan
 */
@WebServlet(name = "PeticionesOrdenesCrearNotiPP", urlPatterns = {"/PeticionesOrdenesCrearNotiPP"})
public class PeticionesOrdenesCrearNotiPP extends HttpServlet {

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
            //String plao = request.getParameter("env1vm");
            String orde = request.getParameter("ordmatvm");
            String deso = request.getParameter("txtbrvm");
            String canm = request.getParameter("env5vm");
            LinkedList<PlanPP> pl = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenerNotificPP(canm, orde, deso);
            int conta = 0;
            ArrayList<ControlListaOrdenes> lo = new ArrayList<>();
            if (pl.size() > 0) {
                out.println("<table>");
                out.println("<tbody>");
                for (conta = 0; conta < pl.size(); conta++) {
                    lo = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().FiltroOrdenesLib();
                    for (ControlListaOrdenes cnt : lo) {
                        String name = cnt.getNum_orden();
                        String nameRe = pl.get(conta).getNum_orden();
                        if (nameRe.equals(name)) {

                        } else {
                            out.println("<tr ondblclick=\"seleccionar('" + pl.get(conta).getNum_orden() + "','notor','VentanaModal')\">");
//                    out.println("<td>" + pl.get(i).getSociedad_co() + "</td>");
                            out.println("<td>" + pl.get(conta).getNum_orden() + "</td>");
                            out.println("<td>" + pl.get(conta).getTexto_breve() + "</td>");
                            out.println("</tr>");
                        }
                    }
                }
                out.println("</tbody>");
                out.println("</table>");
            } else {
                out.println(0);
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
