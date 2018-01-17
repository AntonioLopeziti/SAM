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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "peticionModificarAvisos", urlPatterns = {"/peticionModificarAvisos"})
public class peticionModificarAvisos extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String Clase = request.getParameter("Clase");
            String Aviso = request.getParameter("Aviso");
            String Texto = request.getParameter("Texto");
            String Ctd = request.getParameter("Ctd");
            switch (Accion) {
                case "ConsultaMatchAvisos":
                    ArrayList<aviso> Cavi = ACC_Aviso.ObtenerInstancia().CargarAvisosMC(Clase, Aviso, Texto);
                    if (Cavi.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (Ctd.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(Ctd); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + Cavi.get(i).getNum_notificacion() + "', '" + Cavi.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + Cavi.get(i).getClase_aviso() + "</td>");
                                out.println("<td>" + Cavi.get(i).getNum_notificacion() + "</td>");
                                out.println("<td>" + Cavi.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + Cavi.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < Cavi.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + Cavi.get(i).getNum_notificacion() + "', '" + Cavi.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + Cavi.get(i).getClase_aviso() + "</td>");
                                out.println("<td>" + Cavi.get(i).getNum_notificacion() + "</td>");
                                out.println("<td>" + Cavi.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + Cavi.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarAviso":
                    int av = ACC_Aviso.ObtenerInstancia().Validaraviso(Aviso);
                    out.println(av);
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
