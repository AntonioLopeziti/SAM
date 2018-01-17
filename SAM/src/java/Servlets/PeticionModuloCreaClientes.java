/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import AccesoDatos.ACC_Clientes;
import Entidades.clientes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Are-Consulting
 */
@WebServlet(name = "PeticionModuloCreaClientes", urlPatterns = {"/PeticionModuloCreaClientes"})
public class PeticionModuloCreaClientes extends HttpServlet {

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
            String accion = request.getParameter("Action");
            String nom = request.getParameter("nombre");
            String pob = request.getParameter("poblacion");
            String resid = request.getParameter("residencia");
            String calle = request.getParameter("calle");
            String distrito = request.getParameter("distrito");
            String edif = request.getParameter("edificio");
            String nif = request.getParameter("nif");
            String condpago = request.getParameter("condpago");
            String abc = request.getParameter("abc");
            String gpocuenta = request.getParameter("gpoCuenta");
            String ctaasoc = request.getParameter("ctaAsociada");
            String mon = request.getParameter("mon");
            String inco1 = request.getParameter("inco1");
            String inco2 = request.getParameter("inco2");
            String gpoComp = request.getParameter("gpoComp");
            String tipChek = request.getParameter("tipChek");
            switch (accion) {
                case "GuardarDatos":
                    clientes cli = new clientes();
                    cli.setNombre1(nom);
                    cli.setPoblacion(pob);
                    cli.setLugarResidencia(resid);
                    cli.setCalle(calle);
                    cli.setDistrito(distrito);
                    cli.setNumEdificio(edif);
                    cli.setNif(nif);
                    cli.setClaveCondicionPago(condpago);
//                    ABC
                    cli.setGrupoCuentaDeudor(gpocuenta);
                    cli.setCuentaAsoConta(ctaasoc);
                    cli.setMoneda(mon);
                    cli.setIncoParte1(inco1);
                    cli.setIncoParte2(inco2);
                    cli.setPeticionBorraRegistoMaestro(condpago);
                    cli.setBloqueoContaSociedad("");
//                    gpoComp
                    if (ACC_Clientes.ObtenerInstancia().InsertarClienteCrea(cli)) {
                        out.println(5); /// Consulta Exitosa
                    } else {
                        out.println(6); /// Error al ejecutar la consulta
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
