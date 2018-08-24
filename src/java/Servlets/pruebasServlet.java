/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.Consultas;
import AccesoDatos.Pruebas_Test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author music
 */
@WebServlet(name = "pruebasServlet", urlPatterns = {"/pruebasServlet"})
public class pruebasServlet extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String Orden = request.getParameter("Orden");
            String Cliente = request.getParameter("Cliente");
            String Descripcion = request.getParameter("Descripcion");
            String Material = request.getParameter("Material");
            String Lote = request.getParameter("Lote");
            String Cantidad = request.getParameter("Cantidad");
            String Ancho = request.getParameter("Ancho");
            String Unidad = request.getParameter("Unidad");
            String PtoTrabajo = request.getParameter("PtoTrabajo");
            String Ruta = request.getParameter("Ruta");
            String Stock = request.getParameter("Stock");
            String Fecha = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String Hora = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            switch (Accion) {
                case "ImpimirEtiqueta":
                    String[] send =  {
                    Fecha.replace("-", "/"),
                    Hora,
                    Cliente,
                    Material,
                    Lote,
                    Cantidad,
                    Orden,
                    Ancho,
                    Ruta,
                    Stock,
                    PtoTrabajo,
                    Unidad,
                    Descripcion                    
                    };                    
                    String ip =  Pruebas_Test.ObtenerInstancia().getImp(PtoTrabajo);
                    String iplocal = "\\\\192.168.0.9\\Impresora YISUS";                    
                   int res =  Pruebas_Test.ObtenerInstancia().PrintDoc(send, iplocal);
                   out.println(res);
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
