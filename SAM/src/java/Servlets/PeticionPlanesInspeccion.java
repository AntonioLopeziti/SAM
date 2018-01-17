/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_MaterialesPI;
import AccesoDatos.ACC_Reservas;
import Entidades.MaterialesPI;
import Entidades.centros;
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
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "PeticionPlanesInspeccion", urlPatterns = {"/PeticionPlanesInspeccion"})
public class PeticionPlanesInspeccion extends HttpServlet {

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
            String accion = request.getParameter("Action");
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String cen = request.getParameter("CEN");
            String mat = request.getParameter("MAT");
            String mate = request.getParameter("MaterialMatch");
            String texto_mate = request.getParameter("DescripMatch");
            String cetr = request.getParameter("CentroMatch");
            String ctdmax = request.getParameter("CantidadMatch");
            String matcar = request.getParameter("MaterialCarga");
            String centcar = request.getParameter("CentroCarga");
            String grupocarga = request.getParameter("GrupoHojaCarga");
            String materi = request.getParameter("MATER");
            String centroo = request.getParameter("CENTROO");
            String gpoo = request.getParameter("GPOHR");
            String materica = request.getParameter("MATERICA");
            String operacion = request.getParameter("OPERACIONN");
            String grupo = request.getParameter("GRP");
            String matgrp = request.getParameter("MaterialGrupo");

            switch (accion) {
                case "ValidarCentro":
                    if (ACC_Reservas.ObtenerInstancia().ValidarCEN(cen)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarGrupo":
                    if (ACC_MaterialesPI.ObtenerInstancia().ValidarGRP(grupo)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarMaterial":
                    if (ACC_MaterialesPI.ObtenerInstancia().ValidarMaterial(mat)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMaterial":
                    ArrayList<MaterialesPI> ma = ACC_MaterialesPI.ObtenerInstancia().ConsultaMatchPlaInsMaterial(mate, texto_mate, cetr, ctdmax);
                    if (ma.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ma.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ma.get(i).getNum_material() + "', 'material')\">");
                            out.println("<td>" + ma.get(i).getNum_material() + "</td>");
                            out.println("<td>" + ma.get(i).getTexto_breve_material() + "</td>");
                            out.println("<td>" + ma.get(i).getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchGrupoHoja":
                    ArrayList<MaterialesPI> hr = ACC_MaterialesPI.ObtenerInstancia().ConsultarMatchPlaInsHojaRuta(matgrp);
                    if (hr.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < hr.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + hr.get(i).getClave_grupo_hoja_ruta() + "', 'grupo')\">");
                            out.println("<td>" + hr.get(i).getNum_material() + "</td>");
                            out.println("<td>" + hr.get(i).getTexto_breve_material() + "</td>");
                            out.println("<td>" + hr.get(i).getClave_grupo_hoja_ruta() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarDatos":
                    MaterialesPI cd = ACC_MaterialesPI.ObtenerInstancia().CargarDatosVisualMa(matcar, centcar, grupocarga);
                    if (cd.getNum_material().length() == 0) {
                        out.println(0);
                    } else {
                        JSONArray ar = new JSONArray();
                        ar.add(cd.getTexto_breve_material());
                        ar.add(cd.getTipo_hoja_ruta());
                        ar.add(cd.getContador_grupo_hoja_ruta());
                        ar.add(cd.getContador_criterios_adicionales());
                        ar.add(cd.getContador_interno());
                        out.println(ar);
                    }
                    break;
                case "CargarTablaOperaciones":
                    ArrayList<MaterialesPI> op = ACC_MaterialesPI.ObtenerInstancia().ConsultaOperacioness(matcar, centcar, grupocarga);
                    int i;
                    if (op.size() > 0) {
                        for (i = 0; i < op.size(); i++) {
                            out.println("<tr>");
                            out.println("<td>  <input id=\"rbt\" onclick=\"cargardos()\" type=\"radio\" name=\"planes\" value=" + op.get(i).getNum_operacion() + ">    </td>");
                            out.println("<td>" + op.get(i).getNum_nodo_hoja_ruta() + "</td>");
                            out.println("<td>" + op.get(i).getNum_operacion() + "</td>");
                            out.println("<td>" + op.get(i).getClave_control() + "</td>");
                            out.println("<td>" + op.get(i).getTexto_breve_operacion() + "</td>");
                            out.println("<td>" + op.get(i).getVariante_proceso_cierre_punto_inspeccion() + "</td>");
                            out.println("</tr>");
                        }
                        for (int k = i; k < 9; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println("  <tr class=\"ocultar\">\n"
                                + "                                            <td>0000</td>\n"
                                + "                                            <td>00000000000</td>\n"
                                + "                                            <td>000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                + "                                            <td>00000000</td>\n"
                                + "                                        </tr>");
                    } else {
                        for (int k = 0; k < 9; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println("  <tr class=\"ocultar\">\n"
                                + "                                            <td>0000</td>\n"
                                + "                                            <td>00000000000</td>\n"
                                + "                                            <td>000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                + "                                            <td>00000000</td>\n"
                                + "                                        </tr>");
                    }
                    break;
                case "CargarTablaCaracteristicas":
                    ArrayList<MaterialesPI> ope = ACC_MaterialesPI.ObtenerInstancia().ConsultaCaracterisitcass(materica, centroo, gpoo, operacion);
                    int j = 0;
                    if (ope.size() > 0) {
                        for (j = 0; j < ope.size(); j++) {
                            out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td>" + ope.get(j).getVariante_proceso_cierra_punto_inspeccion() + "</td>");
                            out.println("<td>" + ope.get(j).getTexto_breve_caracteristicas_inspeccion() + "</td>");
                            out.println("<td>" + ope.get(j).getClave_idioma_caracteristicas() + "</td>");
                            out.println("<td>" + ope.get(j).getProcedimiento_muestro_carac_inspeccion() + "</td>");
                            out.println("<td>" + ope.get(j).getUnidad_medida_muestra() + "</td>");
                            out.println("<td>" + ope.get(j).getFactor_cantidad_muestra() + "</td>");
                            out.println("<td>" + ope.get(j).getEntrada_catalogo_conjunto_seleccion() + "</td>");
                            out.println("<td>" + ope.get(j).getCl_catalogo_grupo_codigo() + "</td>");
                            out.println("<td>" + ope.get(j).getGrupo_codigo_conjunto_seleccion() + "</td>");
                            out.println("<td>" + ope.get(j).getCentro_caracteristicas() + "</td>");
                            out.println("<td>" + ope.get(j).getBarra_ind_impuesto_caract_inspeccion() + "</td>");
                            out.println("</tr>");
                        }
                        for (int l = j; l < 9; l++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println(" <tr class=\"ocultar\">\n"
                                + "                                            <td>0000</td>\n"
                                + "                                            <td>000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                        </tr>");
                    } else {
                        for (int l = 0; l < 9; l++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println(" <tr class=\"ocultar\">\n"
                                + "                                            <td>0000</td>\n"
                                + "                                            <td>000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000</td>\n"
                                + "                                            <td>00000000000000000000000000</td>\n"
                                + "                                        </tr>");
                    }
                    break;
                case "ConsultaMatchCentroQM":
                    ArrayList<centros> cn = ACC_Centro.ObtenerInstancia().ConsultaCentrosQM();
                    if (cn.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int in = 0; in < cn.size(); in++) {
                            out.println("<tr ondblclick=\"seleccionar('" + cn.get(in).getCentro() + "', 'centro')\">");
                            out.println("<td>" + cn.get(in).getCentro() + "</td>");
                            out.println("<td>" + cn.get(in).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "LimpiarTablaCarac":
                    for (int l = 0; l < 9; l++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("<td>&nbsp;</td>");
                        out.println("</tr>");
                    }
                    out.println(" <tr class=\"ocultar\">\n"
                            + "                                            <td>0000</td>\n"
                            + "                                            <td>000000000000</td>\n"
                            + "                                            <td>00000000000000000000000000000000000</td>\n"
                            + "                                            <td>0000000000000000000000</td>\n"
                            + "                                            <td>0000000000000000000000000000000</td>\n"
                            + "                                            <td>0000000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000000000</td>\n"
                            + "                                        </tr>");
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
