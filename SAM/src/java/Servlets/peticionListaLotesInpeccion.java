/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Qm_cabecera;
import AccesoDatos.Consultas;
import Entidades.Qm_Cabetodo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "peticionListaLotesInpeccion", urlPatterns = {"/peticionListaLotesInpeccion"})
public class peticionListaLotesInpeccion extends HttpServlet {

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
            String lote = request.getParameter("lote");
            String lote2 = request.getParameter("lote2");
            String usuario = request.getParameter("usuario");
            switch (Accion) {
                case "CargarLotes":
                    ArrayList<Qm_Cabetodo> ce = ACC_Qm_cabecera.ObtenerInstancia().CargarLotes();
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ce.get(i).getNum_lote_inspeccion() + "','lotes')\">");
                            out.println("<td>" + ce.get(i).getNum_lote_inspeccion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarLotes2":
                    ArrayList<Qm_Cabetodo> ce2 = ACC_Qm_cabecera.ObtenerInstancia().CargarLotes();
                    if (ce2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce2.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ce2.get(i).getNum_lote_inspeccion() + "','lotes2')\">");
                            out.println("<td>" + ce2.get(i).getNum_lote_inspeccion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarUsuarios":
                    ArrayList<Qm_Cabetodo> us = ACC_Qm_cabecera.ObtenerInstancia().CargarUsuarios();
                    if (us.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < us.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + us.get(i).getCreado_registro_datos() + "','usuarios')\">");
                            out.println("<td>" + us.get(i).getCreado_registro_datos() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarLote":
                    int lo = ACC_Qm_cabecera.ObtenerInstancia().ValidarLote(lote);
                    out.println(lo);
                    break;
                case "ValidarUsuario":
                    int usua = ACC_Qm_cabecera.ObtenerInstancia().ValidarUsuario(usuario);
                    out.println(usua);
                    break;
                case "ValidarQuery":
                    ArrayList<Qm_Cabetodo> lislot = ACC_Qm_cabecera.ObtenerInstancia().ValidarQueryLoteInspeccion(lote, lote2, usuario);
                    out.println(lislot);
                    break;
                case "CargarTabla":
                    Consultas c = new Consultas();
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ArrayList<Qm_Cabetodo> lislo = ACC_Qm_cabecera.ObtenerInstancia().ValidarQueryLoteInspeccion(lote, lote2, usuario);
                    Collections.sort(lislo, new Comparator<Qm_Cabetodo>() {
                        public int compare(Qm_Cabetodo o1, Qm_Cabetodo o2) {
                            return o1.getFecha_creacion_lote().compareTo(o2.getFecha_creacion_lote());
                        }
                    });
                    for (Qm_Cabetodo p1 : lislo) {
                        out.println("<tr ondblclick=\"seleccinarlote('" + ACC_Qm_cabecera.ObtenerInstancia().SemaforoLote(p1.getNum_lote_inspeccion()) + "','" + p1.getNum_orden() + "')\">");
                        out.println("<td><img src='images/" + ACC_Qm_cabecera.ObtenerInstancia().SemaforoLote(p1.getNum_lote_inspeccion()) + ".PNG' /></td>");
                        out.println("<td>" + p1.getNum_lote_inspeccion() + "</td>");
                        out.println("<td>" + p1.getNum_orden() + "</td>");
                        out.println("<td>" + p1.getCentro() + "</td>");
                        out.println("<td>" + p1.getCreado_registro_datos() + "</td>");
                        out.println("<td>" + p1.getHora_creacion_lote() + "</td>");
                        out.println("<td>" + c.DateFormat(p1.getFecha_creacion_lote()) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>0000000000</td>");
                    out.println("<td>0000000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("</tr");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
            }
        }
    }

    public int compare(Qm_Cabetodo o1, Qm_Cabetodo o2) {
        return o1.getFecha_creacion_lote().compareTo(o2.getFecha_creacion_lote());
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
