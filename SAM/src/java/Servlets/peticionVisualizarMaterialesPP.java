/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Material;
import Entidades.canal;
import Entidades.centros;
import Entidades.materiales;
import Entidades.organizacion;
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
 * @author Are-Consulting
 */
@WebServlet(name = "peticionVisualizarMaterialesPP", urlPatterns = {"/peticionVisualizarMaterialesPP"})
public class peticionVisualizarMaterialesPP extends HttpServlet {

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
            String accion = request.getParameter("Action");
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String mate = request.getParameter("MaterialMatch");
            String texto_mate = request.getParameter("DescripMatch");
            String cetr = request.getParameter("CentroMatch");
            String ctdmax = request.getParameter("CantidadMatch");
            String materialca = request.getParameter("MaterialCarga");
            String centroca = request.getParameter("CentroCarga");
            String organizacionca = request.getParameter("OrganizacionCarga");
            String canalca = request.getParameter("CanalCarga");
            String tpmat = request.getParameter("TPMAT");
            String usua = request.getParameter("USUARIO");
            String TImat = request.getParameter("TImat");

            String valu = (String) session.getAttribute("VALOR");

            String materialreserva = request.getParameter("MATERIALRESERVA");

            switch (accion) {
                case "ConsultaMaterial":
                    String descrip = "descripcion_" + idioma;
                    int ctdaciertos;
                    if (ctdmax == "") {
                        ctdaciertos = 0;
                    } else {
                        ctdaciertos = Integer.parseInt(ctdmax);
                    }
                    LinkedList<materiales> m = ACC_Material.ObtenerInstancia().ConsultaMatchMaterialPP(ctdmax, mate, cetr, descrip, texto_mate, tpmat);
                    if (m.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < m.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + m.get(i).getMaterial() + "', 'material')\">");
                            out.println("<td>" + m.get(i).getMaterial() + "</td>");
                            out.println("<td>" + m.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + m.get(i).getCentro() + "</td>");
                            out.println("<td>" + m.get(i).getTipo_material() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchCentro":
                    ArrayList<centros> c = ACC_Centro.ObtenerInstancia().ConsultaCentros();

                    if (c.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + c.get(i).getCentro() + "', 'centro')\">");
                            out.println("<td>" + c.get(i).getCentro() + "</td>");
                            out.println("<td>" + c.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchOrganizacion":
                    LinkedList<organizacion> o = ACC_Material.ObtenerInstancia().ConsultaMatchOrganizacion();
                    if (o.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < o.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + o.get(i).getOrganizacion() + "', 'organizacion')\">");
                            out.println("<td>" + o.get(i).getOrganizacion() + "</td>");
                            out.println("<td>" + o.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchCanal":
                    String qu = "SELECT * FROM MM.canal_distribucion";
                     LinkedList<canal> ca = ACC_Material.ObtenerInstancia().ConsultaMatchCanal(qu, idioma);
                    if (ca.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ca.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ca.get(i).getCanal() + "', 'canal')\">");
                            out.println("<td>" + ca.get(i).getCanal() + "</td>");
                            out.println("<td>" + ca.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarMaterial":
                    materiales ma = ACC_Material.ObtenerInstancia().CargarDatosVisualMaPP(materialca, centroca, organizacionca, canalca, idioma);
                    if (ma.getMaterial() == null || ma.getMaterial().equals("")) {
                        out.println(0);
                    } else {
                        JSONArray j = new JSONArray();
                        j.add(ma.getDescripcion());
                        j.add(ma.getCentro());
                        j.add(ma.getOrganizacion_ventas());
                        j.add(ma.getCanal_distribucion());
                        j.add(ma.getUnidad_medida());
                        j.add(ma.getNum_material_ant());
                        j.add(ma.getTipo_material());
                        j.add(ma.getGrupo_articulos());
                        j.add(ma.getSector());
                        j.add(ma.getUnidad_medida_venta());
                        j.add(ma.getGrupo_estadi_material());
                        j.add(ma.getGrupo_tipo_posi_gen());
                        j.add(ma.getJerarquia_produc());
                        j.add(ma.getGrupo_precios_mate());
                        j.add(ma.getGrupo_imputa_material());
                        j.add(ma.getGrupo_tipos_posi_ma_mate());
                        j.add(ma.getGrupo_veri_de_dispo());
                        j.add(ma.getGrupo_transporte());
                        j.add(ma.getCentro_beneficio());
                        j.add(ma.getSujeto_lote());
                        j.add(ma.getGrupo_compras());
                        j.add(ma.getCara_plan_nece());
                        j.add(ma.getPunto_pedido());
                        j.add(ma.getCiclo_plan_nece());
                        j.add(ma.getTam_lote_plan_nece());
                        j.add(ma.getTama_lote_min());
                        j.add(ma.getHoriz_plan_fijo());
                        j.add(ma.getPlanificador_necesi());
                        j.add(ma.getTama_lote_max());
                        j.add(ma.getStock_maximo());
                        j.add(ma.getClase_aprovisionamiento());
                        j.add(ma.getTiempo_trata_en_merca_dia());
                        j.add(ma.getTiempo_trata_en_merca_dia());
                        j.add(ma.getStock_seguridad());
                        j.add(ma.getStock_seguridad_minimo());
                        j.add(ma.getPlazo_entre_previ_dia());
                        j.add(ma.getExiste_para_insp_mate_cen());
                        j.add(ma.getQm_activo_apro());
                        j.add(ma.getIndicador_control_precios());
                        j.add(ma.getPrecio_medio_vari_inte_per());
                        j.add(ma.getPrecio_estandar());
                        j.add(ma.getCantidad_base());
                        j.add(ma.getClase_valoracion());
                        j.add(ma.getCategoria_valoracion());
                        out.println(j);
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
