/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CentroPlanificacion;
import java.io.IOException;
import java.io.PrintWriter;
import Entidades.materiales;
import Entidades.clase_orden;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_ClaseOrden;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_HojasRuta;
import AccesoDatos.ACC_PuestoTrabajo;
import Entidades.centroPlanificacion;
import Entidades.hojas_de_ruta;
import Entidades.puesto_trabajo;
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
@WebServlet(name = "PeticionModuloCrearOrdenPP", urlPatterns = {"/PeticionModuloCrearOrdenPP"})
public class PeticionModuloCrearOrdenPP extends HttpServlet {

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
            String Accion = request.getParameter("acc");
            String Idioma = request.getParameter("Idioma");
            String umd = request.getParameter("umd");
            /////////////Match Equipo
            String denMat = request.getParameter("denMat");
            String numMat = request.getParameter("numMat");
            String ctdMat = request.getParameter("ctdMat");
            //////////////Validar Datos
            String claseOrden = request.getParameter("clOr");
            String mater = request.getParameter("mater");
            String equipo = request.getParameter("equi");
            //////////////Match Puesto de Trabajo Responsable 
            String clPto = request.getParameter("clPtoTr");
            String centroPto = request.getParameter("centPto");
            String ptoTrM = request.getParameter("ptoTrM");
            String denPtoT = request.getParameter("desPto");
            String ctdPto = request.getParameter("ctdPto");
            String check;
            
            switch (Accion){
                case "ConsultaMatchClaseOr":
                    ArrayList<clase_orden> lstClaseOrd = ACC_ClaseOrden.ObtenerInstancia().ConsultaClaseOrdenOrdPP(Idioma);

                    for (int i = 0; i < lstClaseOrd.size(); i++) {
                        out.println("<option value=\"" + lstClaseOrd.get(i).getClase_orden() + "\">" + lstClaseOrd.get(i).getClase_orden() + "</option>");
                    }
                    break;
                case "ConsultaMatchMate":
                    String descIdMat = "descripcion_" + Idioma;
                    ArrayList<materiales> e = ACC_Material.ObtenerInstancia().ConsultarMaterialMatchOrdPP(denMat, numMat, descIdMat, ctdMat);
                    if (e.size() > 0) {
                        out.println("<table>");
                        out.println("<table>");
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < e.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + e.get(i).getMaterial() + "', 'Material');\" >");
                            out.println("<td>" + e.get(i).getDescripcion_material() + "</td>");
                            out.println("<td>" + e.get(i).getMaterial() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchPtoTr":
                    String desPtoTr = "denominacion_" + Idioma;
                    ArrayList<puesto_trabajo> lstPto = ACC_PuestoTrabajo.ObtenerInstancia().ConsultaMatchPuestoTrabajoOrdPP(clPto, centroPto, ptoTrM, denPtoT, desPtoTr, ctdPto);
                    if (lstPto.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstPto.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstPto.get(i).getPuesto_trabajo() + "', 'PtoTr');\">");
                            out.println("<td>" + lstPto.get(i).getCentro() + "</td>");
                            out.println("<td>" + lstPto.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + lstPto.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "cargarDataEquipo":
                    String[] ret = ACC_Equipos.ObtenerInstancia().DataMatchEquipoOrdenesPP(mater);
                    if (ret[0].equals("x")) {
                        JSONArray js = new JSONArray();
                        js.add(ret[0]);
                        out.println(js);
                    } else {
                        JSONArray js = new JSONArray();
                        js.add(ret[0]);
                        js.add(ret[1]);
                        js.add(ret[2]);
                        js.add(ret[3]);
                        js.add(ret[4]);
                        js.add(ret[5]);
                        js.add(ret[6]);
                        out.println(js);
                    }
                    break;
                    
                case "ConsultaMatchCentroP":
                    ArrayList<centroPlanificacion> centp = ACC_CentroPlanificacion.ObtenerInstancia().ConsultaMatchCentroPOrdPP();
                    if (centp.size() > 0) {
                        out.println("<select id=\"CentPl\">");

                        for (int i = 0; i < centp.size(); i++) {
                            out.println("<option value=\"" + centp.get(i).getCentro_planificacion_mantenimiento() + "\">" + centp.get(i).getCentro_planificacion_mantenimiento() + "</option>");
                        }
                        out.println("</select>");

                    }
                    break;
                case "ConsultaMatchContaHR":
                    ArrayList<hojas_de_ruta> lstHR = ACC_HojasRuta.ObtenerInstancia().ConsultaVisualizarHROrdenesO(equipo);
                    if (lstHR.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstHR.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstHR.get(i).getContador_grupo_hojaruta() + "', 'ContaHR');Select2('" + lstHR.get(i).getClave_grupo_hojaruta() + "', 'ContaHR');\">");
                            out.println("<td>" + lstHR.get(i).getContador_grupo_hojaruta() + "</td>");
                            out.println("<td>" + lstHR.get(i).getClave_grupo_hojaruta() + "</td>");
//                            out.println("<td>" + lstHR.get(i).getTexto_hojaruta() + "</td>");
                            out.println("<td>" + lstHR.get(i).getTexto_breve_operacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "validarNumMat":
                    check = ACC_Material.ObtenerInstancia().getExisNumMatePP(mater);
                    out.println(check);
                    break;
                case "consultarCentroAct":
                    check = ACC_CentroPlanificacion.ObtenerInstancia().ConsultarCentroActualPP();
                    out.print(check);
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
