/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Almacenes;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_DocumentoInventario;
import AccesoDatos.ACC_Folios;
import AccesoDatos.Consultas;
import Entidades.folios;
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
@WebServlet(name = "PeticionDocumentoInventario", urlPatterns = {"/PeticionDocumentoInventario"})
public class PeticionDocumentoInventario extends HttpServlet {

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
            String accion = request.getParameter("accion");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");

            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();

            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("DI");
            String fl, rr = "";

            switch (accion) {
                case "ValidaCampos":
                    //v1 -> Centro, v2 -> Almacen
                    JSONArray js = new JSONArray();
                    js.add(ACC_Centro.ObtenerInstancia().ValidarCentro(v1));
                    js.add(ACC_Almacenes.ObtenerInstancia().ValidarAlmacen(v2));
                    out.println(js);
                    break;
                case "GuardaDocumentoCabecera":
                    fl = "DI" + fo.getFolioActual();
                    ACC_DocumentoInventario.ObtenerInstancia().guarda_DocInventarioCreaCabecera(fl, horaActual, fechaActual, v1, v2, v3);
                    break;
                case "GuardaDocumentoPosiciones":
                    fl = "DI" + fo.getFolioActual();
                    for (int i = v5.length(); i < 3; i++) {
                        rr += "0";
                    }
                    ACC_DocumentoInventario.ObtenerInstancia().guarda_DocInventarioCreaPocisiones(fl, rr + v5, horaActual, fechaActual, v1, v2, v4, v3);
                    ACC_DocumentoInventario.ObtenerInstancia().actualizaStatusMaterial(v4, v1, v2);
                    break;
                case "ActualizarFolio":
                    out.println(fo.getFolioActual());
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("DI", fo.getFolioActual());
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
