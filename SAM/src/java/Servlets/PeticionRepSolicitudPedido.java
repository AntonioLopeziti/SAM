/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_RepSolicitudPedido;
import AccesoDatos.ACC_Reportes;
import Entidades.Repo_solped;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "PeticionRepSolicitudPedido", urlPatterns = {"/PeticionRepSolicitudPedido"})
public class PeticionRepSolicitudPedido extends HttpServlet {

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
            String sam1 = (String) session.getAttribute("sam1");
            String sap1 = (String) session.getAttribute("sap1");
            String fecha1 = (String) session.getAttribute("fecha1");
            String sam2 = (String) session.getAttribute("sam2");
            String sap2 = (String) session.getAttribute("sap2");
            String fecha2 = (String) session.getAttribute("fecha2");
            String centro = (String) session.getAttribute("centro");
            String solicitante = (String) session.getAttribute("solicitante");
            String almacen = (String) session.getAttribute("almacen");
            String material = (String) session.getAttribute("material");
            String posicion = (String) session.getAttribute("posicion");
            String imputacion = (String) session.getAttribute("imputacion");
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosam2 = request.getParameter("sam2");
            String foliosap = request.getParameter("sap");
            String foliosap2 = request.getParameter("sap2");
            String fe1 = request.getParameter("fecha1");
            String fe2 = request.getParameter("fecha2");
            String usuario = request.getParameter("solicitante");
            String alma = request.getParameter("almacen");
            String mate = request.getParameter("material");
            String pos = request.getParameter("posicion");
            String inpu = request.getParameter("inputacion");

            LinkedList<String[]> datosRepoSolped = new LinkedList<String[]>();
            String[] ArraySolped = new String[21];
            switch (accion) {
                case "ValidarQuery":
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
                    if (usuario.equals("")) {
                        usuario = " ";
                    }
                    if (alma.equals("")) {
                        alma = " ";
                    }
                    if (mate.equals("")) {
                        mate = " ";
                    }
                    if (pos.equals("")) {
                        pos = " ";
                    }
                    if (inpu.equals("")) {
                        inpu = " ";
                    }
                    ArrayList<Repo_solped> sol = ACC_Reportes.ObtenerInstancia().MM_RepoSolpedTodos(centros, foliosam, foliosam2, foliosap, foliosap2, fe1, fe2, usuario, alma, mate, pos, inpu);
                    if (sol.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ReportSolped":
                    if (centro.equals("")) {
                        centro = " ";
                    }
                    if (sam1.equals("")) {
                        sam1 = " ";
                    }
                    if (sam2.equals("")) {
                        sam2 = " ";
                    }
                    if (sap1.equals("")) {
                        sap1 = " ";
                    }
                    if (sap2.equals("")) {
                        sap2 = " ";
                    }
                    if (fecha1.equals("")) {
                        fecha1 = " ";
                    }
                    if (fecha2.equals("")) {
                        fecha2 = " ";
                    }
                    if (solicitante.equals("")) {
                        solicitante = " ";
                    }
                    if (almacen.equals("")) {
                        almacen = " ";
                    }
                    if (posicion.equals("")) {
                        posicion = " ";
                    }
                    if (material.equals("")) {
                        material = " ";
                    }
                    if (imputacion.equals("")) {
                        imputacion = " ";
                    }
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes report = new ACC_Reportes();
                    for (Repo_solped a : report.MM_RepoSolpedTodos(centro, sam1, sam2, sap1, sap2, fecha1, fecha2, solicitante, almacen, material, posicion, imputacion)) {
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getNum_posicion_solped() + "</td>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFecha_liberacion_solped() + "</td>");
                        out.println("<td>" + a.getTipo_posicion_doc_compras() + "</td>");
                        out.println("<td>" + a.getTipo_imputacion() + "</td>");
                        out.println("<td>" + a.getNum_material() + "</td>");
                        out.println("<td>" + a.getTexto_breve_material() + "</td>");
                        out.println("<td>" + a.getCantidad_solped() + "</td>");
                        out.println("<td>" + a.getUnidad_medida_solped() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                        out.println("<td>" + a.getAlmacen() + "</td>");
                        out.println("<td>" + a.getNombre_solicitante() + "</td>");
                        out.println("<td>" + a.getFecha_liberacion_solped() + "</td>");
                        out.println("<td>" + a.getIndicador_liberacion() + "</td>");
                        out.println("<td>" + a.getDenominacion_codigo_liberacion() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getNum_pedido() + "</td>");
                        out.println("<td>" + a.getFecha_creacion_doc_mod() + "</td>");
                        out.println("<td>" + a.getIndicador_liberacion_doc_compras() + "</td>");
                        out.println("<tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>0000000000000</td>"
                            + "<td>000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>000000</td>"
                            + "<td>000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>0000000000000000000000000000000000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>00000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>0000000</td>"
                            + "<td>000000000000000000000</td>"
                            + "<td>0000000</td>"
                            + "<td>0000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>0000000</td>"
                            + "</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
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
