package Servlets;

import AccesoDatos.ACC_Cabecera_ordenes_crea;
import Entidades.cabecera_ordenes_crea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "peticionModificarOrdenKey", urlPatterns = {"/peticionModificarOrdenKey"})
public class peticionModificarOrdenKey extends HttpServlet {

    String checkEmpty(String valor) {
        if (valor.length() < 1) {
            return "0";
        } else {
            return "1";
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Accion = request.getParameter("acc");
            String orden = request.getParameter("orden");
            switch (Accion) {
                case "cargarKeys":
                    cabecera_ordenes_crea coc;
                    coc = ACC_Cabecera_ordenes_crea.ObtenerInstancia().CargarDataCab(orden);
                    String recibido = checkEmpty(coc.getRecibido());
                    String procesado = checkEmpty(coc.getProcesado());
                    String error = checkEmpty(coc.getError());
                    String modificado = checkEmpty(coc.getModificado());
                    out.println(recibido + "" + procesado + "" + error + "" + modificado);
                    break;
                case "cargarError":
                    coc = ACC_Cabecera_ordenes_crea.ObtenerInstancia().CargarDataCab(orden);
                    error = coc.getError();
                    out.println(error);
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
