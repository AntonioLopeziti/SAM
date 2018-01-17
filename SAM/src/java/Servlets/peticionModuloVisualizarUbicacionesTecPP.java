/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_UbicacionTecnica;
import Entidades.ubicacion_tecnica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author Are-Consulting
 */
@WebServlet(name = "peticionModuloVisualizarUbicacionesTecPP", urlPatterns = {"/peticionModuloVisualizarUbicacionesTecPP"})
public class peticionModuloVisualizarUbicacionesTecPP extends HttpServlet {

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
            String Accion = request.getParameter("Acc");
            String Idioma = request.getParameter("Idioma");
            String Ctd = request.getParameter("Ctd");
            String Ubicac = request.getParameter("Ubi");
            String DUbi = request.getParameter("DUbi");
            String ubTec = request.getParameter("ubTec");
            String centroo = request.getParameter("centroo");
            
            switch(Accion){
                case "ConsultarMatchUbicacion":
                    ubicacion_tecnica dts = new ubicacion_tecnica();
                    dts.setUbicacion_tecnica(Ubicac);
                    dts.setDenominacion(DUbi);
                    String desUbi = "denominacion_" + Idioma;
                    if (Ctd.equals("")) {
                        ArrayList<ubicacion_tecnica> uts = ACC_UbicacionTecnica.ObtenerInstancia().MatchAllUbiTecPP(dts, desUbi);
                        if (uts.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < uts.size(); i++) {
                                out.println("<tr ondblclick=\"Select('" + uts.get(i).getUbicacion_tecnica() + "')\">");
                                out.println("<td>" + uts.get(i).getUbicacion_tecnica() + "</td>");
                                out.println("<td>" + uts.get(i).getDenominacion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(0);
                        }
                    } else {
                        
                        int limite = Integer.parseInt(Ctd);
                        ArrayList<ubicacion_tecnica> uts = ACC_UbicacionTecnica.ObtenerInstancia().MatchUbicacionesTecPP(dts, limite, desUbi);
                        if (uts.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < uts.size(); i++) {
                                out.println("<tr ondblclick=\"Select('" + uts.get(i).getUbicacion_tecnica() + "')\">");
                                out.println("<td>" + uts.get(i).getUbicacion_tecnica() + "</td>");
                                out.println("<td>" + uts.get(i).getDenominacion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(0);
                        }
                    }
                    break;
                case "CargarDatosUbicaciones":
                    String desUbi2 = "denominacion_" + Idioma;
                    ubicacion_tecnica ub = ACC_UbicacionTecnica.ObtenerInstancia().CargarDatosUbiTecPP(Ubicac, desUbi2);
                    if (ub.getUbicacion_tecnica() == "" || ub.getUbicacion_tecnica() == null) {
                        out.println(0);
                    } else {
                        JSONArray js = new JSONArray();
                        js.add(ub.getDenominacion());
                        js.add(ub.getGrupo_autorizacion());
                        js.add(ub.getCentro_planificacion_mante());
                        js.add(ub.getCentro_emplazamiento());
                        js.add(ub.getEmplazamiento_activo_fijo());
                        js.add(ub.getSociedad());
                        js.add(ub.getCentro_coste());
                        js.add(ub.getArea_empresa());
                        js.add(ub.getGrupo_planificador_servicio_cliente_mante());
                        js.add(ub.getUbicacion_tecnica());
                        js.add(ub.getSociedad());
                        js.add(ub.getPuesto_trabajo());
                        out.println(js);
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
