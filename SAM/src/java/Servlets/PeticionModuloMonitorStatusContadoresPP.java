/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_PuestoTrabajo;
import AccesoDatos.ACC_UbicacionTecnica;
import AccesoDatos.ACC_Material;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import Entidades.centros;
import Entidades.puesto_trabajo;
import Entidades.ubicacion_tecnica;
import Entidades.materiales;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Are-Consulting
 */
@WebServlet(name = "PeticionModuloMonitorStatusContadoresPP", urlPatterns = {"/PeticionModuloMonitorStatusContadoresPP"})
public class PeticionModuloMonitorStatusContadoresPP extends HttpServlet {

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
            String Cant = request.getParameter("ctd");
            String Idioma = (String) session.getAttribute("Idioma");
            String Accion = request.getParameter("Accion");
            String Cantid = request.getParameter("Ctd");
            String Centro = request.getParameter("Centro");
            String Ncentr = request.getParameter("CentroNom");
            String Ubicac = request.getParameter("Ubicacion");
            String DUbite = request.getParameter("DUbicacion");
            String Equipo = request.getParameter("Equipo");
            String DEquip = request.getParameter("DEquipo");
            String Puesto = request.getParameter("Puesto");
            String DPuesto = request.getParameter("DPuesto");
            String Mate = request.getParameter("mate");
            String DenMat = request.getParameter("denMat");
            String idEQ = request.getParameter("idEQ");
            String CaMat = request.getParameter("ctdMat");
            switch (Accion) {
                case "ConsultaMate":
                    String des = "descripcion_"+Idioma;
                    LinkedList<materiales> matt = AccesoDatos.ACC_Material.ObtenerInstancia().ConsultarMateMonEqPP(Mate, DenMat, CaMat, des);
                    if (matt.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < matt.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + matt.get(i).getMaterial() + "', '" + idEQ + "')\">");
                            out.println("<td>" + matt.get(i).getMaterial() + "</td>");
                            out.println("<td>" + matt.get(i).getDescripcion_material() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarCentro":
                    ArrayList<centros> ce = AccesoDatos.ACC_Centro.ObtenerInstancia().ConsultarCentrosCOEQPP(Centro, Ncentr, Cantid);
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + ce.get(i).getCentro() + "','Centro')\" >");
                            out.println("<td>" + ce.get(i).getCentro() + "</td>");
                            out.println("<td>" + ce.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchPuesto":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<puesto_trabajo> pu = ACC_PuestoTrabajo.ObtenerInstancia().SP_MatchPuestoListaordenPP(Cant, Idioma, Puesto, DPuesto);
                    if (pu.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pu.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pu.get(i).getPuesto_trabajo() + "', 'Puesto')\">");
                            out.println("<td>" + pu.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + pu.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarUbicacion":
                    String desUbi = "denominacion_" + Idioma;
                    LinkedList<ubicacion_tecnica> u = ACC_UbicacionTecnica.ObtenerInstancia().AvisoUbicacionMatchPP(Cantid, Ubicac, desUbi, DUbite, "");
                    if (u.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < u.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + u.get(i).getUbicacion_tecnica() + "','Ubicacion')\">");
                            out.println("<td>" + u.get(i).getUbicacion_tecnica() + "</td>");
                            out.println("<td>" + u.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
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
