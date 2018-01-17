/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import Entidades.ReporteSolPed;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PeticionVisualizarReportesSP", urlPatterns = {"/PeticionVisualizarReportesSP"})
public class PeticionVisualizarReportesSP extends HttpServlet {

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
            String sam = request.getParameter("SAMISP");
            String sap = request.getParameter("SAPISP");
            String fecha1 = request.getParameter("FECHAISP");
            String sam2 = request.getParameter("SAMFSP");
            String sap2 = request.getParameter("SAPFSP");
            String fecha2 = request.getParameter("FECHAFSP");
            String centro = request.getParameter("CENTRO");
            String valor = request.getParameter("VALOR");
            String vl = request.getParameter("VL");

            session.setAttribute("SAMSP", sam);
            session.setAttribute("SAPSP", sap);
            session.setAttribute("FECHASP", fecha1);
            session.setAttribute("SAMSPF", sam2);
            session.setAttribute("SAPFSP", sap2);
            session.setAttribute("FECHASPF", fecha2);
            session.setAttribute("CEN", centro);
            session.setAttribute("VAL", valor);
            session.setAttribute("VLSP", vl);

            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosam2 = request.getParameter("sam2");
            String foliosap = request.getParameter("sap");
            String foliosap2 = request.getParameter("sap2");
            String fe1 = request.getParameter("fecha1");
            String fe2 = request.getParameter("fecha2");
            String valo = request.getParameter("valor");
            switch (accion) {
                case "ValidarCentro":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    boolean flsam = ACC_Reportes.ObtenerInstancia().ValidarSamreporteSolped(foliosam);
                    boolean flrep = ACC_Reportes.ObtenerInstancia().ValidarSamsolpedcreaSolped(foliosam);
                    if (flsam) {
                        out.println(1);
                    } else if (flrep) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSapSolped(foliosap)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "validarQuery":
                    if (centros.equals("")) {
                        centros = " ";
                    }
                    if (foliosam.equals("")) {
                        foliosam = " ";
                    }
                    if (foliosam2.equals("")) {
                        foliosam2 = " ";
                    }
                    if (foliosap.equals("")) {
                        foliosap = " ";
                    }
                    if (foliosap2.equals("")) {
                        foliosap2 = " ";
                    }
                    if (fe1.equals("")) {
                        fe1 = " ";
                    }
                    if (fe2.equals("")) {
                        fe2 = " ";
                    }
                    ArrayList<ReporteSolPed> solped = ACC_Reportes.ObtenerInstancia().MM_ReporteSolpedValidarQuery(valo, centros, foliosam, foliosam2, foliosap, foliosap2, fe1, fe2);
                    if (solped.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
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
