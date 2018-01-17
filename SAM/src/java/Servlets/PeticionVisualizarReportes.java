/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonathan Lopez
 */
@WebServlet(name = "PeticionVisualizarReportes", urlPatterns = {"/PeticionVisualizarReportes"})
public class PeticionVisualizarReportes extends HttpServlet {

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
            HttpSession session = request.getSession();
            String accion = request.getParameter("Action");
            String sam = request.getParameter("SAMINICIO");
            String sap = request.getParameter("SAPINICIO");
            String fecha1 = request.getParameter("FECHAINICIO");
            String sam2 = request.getParameter("SAMFIN");
            String sap2 = request.getParameter("SAPFIN");
            String fecha2 = request.getParameter("FECHAFIN");
            String valor = request.getParameter("VALORCITO");
            String valu = request.getParameter("VALOR");
            String centro = request.getParameter("CENTRO");

            session.setAttribute("SAM1", sam);
            session.setAttribute("SAP1", sap);
            session.setAttribute("FECHA1", fecha1);
            session.setAttribute("SAM2", sam2);
            session.setAttribute("SAP2", sap2);
            session.setAttribute("FECHA2", fecha2);
            session.setAttribute("VALOR", valor);
            session.setAttribute("VAL", valu);
            session.setAttribute("CEN", centro);
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
