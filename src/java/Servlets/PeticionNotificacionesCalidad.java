/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_MaterialesPlanesInspeccion;
import Entidades.qm_cabecera_n;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionNotificacionesCalidad", urlPatterns = {"/PeticionNotificacionesCalidad"})
public class PeticionNotificacionesCalidad extends HttpServlet {

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
            String orden = request.getParameter("orden");
            String accion = request.getParameter("accion");
            
            switch(accion)
            {
                case "CabeceraCalidad":
                    qm_cabecera_n cab = ACC_MaterialesPlanesInspeccion.ObtenerInstancia().CargarCabceraPM(orden);
                    JSONArray ja = new JSONArray();
                    ja.add(cab.getNum_lote_inspeccion());
                    ja.add(cab.getCreado_registro_datos());
                    ja.add(cab.getUltimo_modificador_registro_datos());
                    ja.add(cab.getTexto_breve());
                    ja.add(cab.getCentro());
                    ja.add(cab.getFecha_creacion_lote());
                    ja.add(cab.getFecha_modificacion_registro_datos());
                    ja.add(cab.getHora_creacion_lote());
                    ja.add(cab.getHora_modificacion_lote());
                    out.println(ja);
                    break;                    
                default:
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
