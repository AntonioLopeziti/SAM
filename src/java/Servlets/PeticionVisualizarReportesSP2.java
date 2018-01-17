/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_Solped_cabecera2;
import Entidades.solped_cabecera2;
import AccesoDatos.ACC_Solped_posiciones2;
import AccesoDatos.Conexion;
import Entidades.Solped_posiciones;
import Entidades.ReporteSolPed;
import Entidades.solped_cabecera;
import AccesoDatos.ACC_Reportes;
import Entidades.ReporteSolPed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "PeticionVisualizarReportesSP2", urlPatterns = {"/PeticionVisualizarReportesSP2"})
public class PeticionVisualizarReportesSP2 extends HttpServlet {

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
            HttpSession session = request.getSession();
            String accion = request.getParameter("Action");
            String sam = request.getParameter("SAMISP");
            String sap = request.getParameter("SAPISP");
            String fecha1 = request.getParameter("FECHAISP");
            String sam2 = request.getParameter("SAMFSP");
            String sap2 = request.getParameter("SAPFSP");
            String fecha2 = request.getParameter("FECHAFSP");
            String centro = request.getParameter("CENTRO");
            String valor = request.getParameter("VALOR");
            String vl = request.getParameter("VL");
            String solicitante = request.getParameter("solicitante");
            String almacen = request.getParameter("almacen");
            String material = request.getParameter("material");
            String posicion = request.getParameter("posicion");
            String imputacion = request.getParameter("imputacion");
            String coste = request.getParameter("coste");
            String orden = request.getParameter("orden");

            session.setAttribute("SAMSP", sam);
            session.setAttribute("SAPSP", sap);
            session.setAttribute("FECHASP", fecha1);
            session.setAttribute("SAMSPF", sam2);
            session.setAttribute("SAPFSP", sap2);
            session.setAttribute("FECHASPF", fecha2);
            session.setAttribute("CEN", centro);
            session.setAttribute("VAL", valor);
            session.setAttribute("VLSP", vl);
            
            session.setAttribute("solicitante", solicitante);
            session.setAttribute("almacen", almacen);
            session.setAttribute("material", material);
            session.setAttribute("posicion", posicion);
            session.setAttribute("imputacion", imputacion);
            session.setAttribute("coste", coste);
            session.setAttribute("orden", orden);
            
            
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosap = request.getParameter("sap");
          
           
            String tipo = request.getParameter("tipo");
            String query = "";
            
           out.println(1);
           
       
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
