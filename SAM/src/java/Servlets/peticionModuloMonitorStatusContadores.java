/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_MonitorStatus;
import AccesoDatos.ACC_PuestoTrabajo;
import AccesoDatos.ACC_UbicacionTecnica;
import Entidades.centros;
import Entidades.equipos;
import Entidades.folios;
import Entidades.puesto_trabajo;
import Entidades.ubicacion_tecnica;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antonio
 */
@WebServlet(name = "peticionModuloMonitorStatusContadores", urlPatterns = {"/peticionModuloMonitorStatusContadores"})
public class peticionModuloMonitorStatusContadores extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            String idEQ = request.getParameter("idEQ");
            switch (Accion) {
                case "ConsultarCentro":

                    ArrayList<centros> ce = ACC_Centro.ObtenerInstancia().ConsultarCentrosCOEQ(Centro, Ncentr, Cantid);
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
                case "ConsultarUbicacion":
                    String desUbi = "denominacion_" + Idioma;

                    LinkedList<ubicacion_tecnica> u = ACC_UbicacionTecnica.ObtenerInstancia().AvisoUbicacionMatch(Cantid, Ubicac, desUbi, DUbite, "");
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
                case "ConsultarEquipo":
                    String desEq = "denominacion_" + Idioma;

                    LinkedList<equipos> e = ACC_Equipos.ObtenerInstancia().ConsultarEquipoMatchMOAV(Cantid, desEq, Equipo, DEquip, "");
                    if (e.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < e.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + e.get(i).getNum_equipo() + "', '" + idEQ + "')\">");
                            out.println("<td>" + e.get(i).getNum_equipo() + "</td>");
                            out.println("<td>" + e.get(i).getDescripcion_equipo() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "InsConta":
                    String jer = request.getParameter("jer");
                    int niv = Integer.parseInt(request.getParameter("niv"));
                    String sta = request.getParameter("sta");
                    String equ = request.getParameter("equ");
                    String den = request.getParameter("den");
                    String Punto_medida = request.getParameter("Punto_medida");
                    String Doc_me = request.getParameter("Doc_me");
                    String Ult_med = request.getParameter("Ult_med");
                    String us_con = request.getParameter("us_con");
                    String entradadoc = request.getParameter("entradadoc");
                    String Mate = request.getParameter("Mate");
                    String cntr = request.getParameter("cntr");
                    String Ser = request.getParameter("Ser");
                    String Alma = request.getParameter("Alma");
                    String lot = request.getParameter("lot");
                    String Fact = request.getParameter("Fact");
                    String Hact = request.getParameter("Hact");
                    String usu = request.getParameter("usu");
                    folios fo = new folios();
                    fo = ACC_Folios.ObtenerIstancia().CargarDatosFolios("CC");
                    int fac = fo.getFolioActual();
                    String folco = "CC" + fo.getFolioActual();

                    if (ACC_MonitorStatus.ObtenerInstancia().Insertcontadores_c(folco, Ult_med, Fact, Hact, niv, sta, equ, den, Punto_medida, Doc_me, us_con, entradadoc, Mate, cntr, Ser, Alma, lot, usu)) {
                        if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT("CC", fac)) {
                            out.println(1);
                        } else {
                            out.println(0);
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchPuesto":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<puesto_trabajo> pu = ACC_PuestoTrabajo.ObtenerInstancia().SP_MatchPuestoListaorden(Cant, Idioma, Puesto, DPuesto);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(peticionModuloMonitorStatusContadores.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(peticionModuloMonitorStatusContadores.class.getName()).log(Level.SEVERE, null, ex);
        }
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
