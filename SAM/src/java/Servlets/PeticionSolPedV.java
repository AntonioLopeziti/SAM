/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Servicios;
import AccesoDatos.ACC_SolicitudPedidos;
import AccesoDatos.Conexion;
import AccesoDatos.Consultas;
import Entidades.folios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author
 */
@WebServlet(name = "PeticionSolPedV", urlPatterns = {"/PeticionSolPedV"})
public class PeticionSolPedV extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession ses = request.getSession();
            String us = (String) ses.getAttribute("Usuario");
            String Action = request.getParameter("Action");
            String Posici = request.getParameter("PosN");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");
            String v7 = request.getParameter("v7");
            String v8 = request.getParameter("v8");
            String v9 = request.getParameter("v9");
            String v10 = request.getParameter("v10");
            String posdel = request.getParameter("Pos");
            String ipsf = request.getParameter("ipsf");
            switch (Action) {
                case "GuardaServicio":
                    String FechaServidor = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String HoraServidor = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                    ACC_Servicios.ObtenerInstancia().InsertarServiciosTemp(Posici, v10, v1, FechaServidor, HoraServidor, v5, v2, v3, v4, v6, v7, v8, v9, us,ipsf);
                    break;
                case "DElTEXTSERV":
                    ACC_Servicios.ObtenerInstancia().EliminarPosSerTemporal(us, posdel,ipsf);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSolPedV.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSolPedV.class.getName()).log(Level.SEVERE, null, ex);
        }
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
