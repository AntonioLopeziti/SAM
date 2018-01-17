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
import Entidades.materiales_almacen;
import Entidades.organizacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 *
 */
@WebServlet(name = "peticionVisualizarMateriales", urlPatterns = {"/peticionVisualizarMateriales"})
public class peticionVisualizarMateriales extends HttpServlet {

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
                case "BusquedaCentro":
                    String qr = "Select centro from usuarios WHERE Usuario = '" + usua + "'";
                    LinkedList<materiales_almacen> cea = ACC_Material.ObtenerInstancia().Centro(qr);
                    if (cea.size() > 0) {
                        for (int a = 0; a < cea.size(); a++) {
                            out.print(cea.get(a).getCentro());
                        }
                    }
                    break;
                case "ConsultaMaterial":

                    String descrip = "descripcion_" + idioma;
                    int ctdaciertos;
                    if (ctdmax == "") {
                        ctdaciertos = 0;
                    } else {
                        ctdaciertos = Integer.parseInt(ctdmax);
                    }

                    LinkedList<materiales> m = ACC_Material.ObtenerInstancia().ConsultaMatchMaterial(ctdmax, mate, cetr, descrip, texto_mate, tpmat);
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
                    String que = "";
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
                    materiales ma = ACC_Material.ObtenerInstancia().CargarDatosVisualMa(materialca, centroca, organizacionca, canalca, idioma);
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
                case "ConsultaMaterialReservas":

                    int ctd = Integer.parseInt(ctdmax);
                    String de = "descripcion_" + idioma;

                    LinkedList<materiales> mt = ACC_Material.ObtenerInstancia().ConsultaMatchMaterial(ctdmax, mate, cetr, de, texto_mate, TImat);

                    if (mt.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mt.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + mt.get(i).getMaterial() + "', 'material', '" + valu + "')\">");
                            out.println("<td>" + mt.get(i).getMaterial() + "</td>");
                            out.println("<td>" + mt.get(i).getCentro() + "</td>");
                            out.println("<td>" + mt.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + mt.get(i).getTipo_material() + "</td>");

                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarMaterialReserva":
                    String deno = "descripcion_" + idioma;
                    materiales mart = ACC_Material.ObtenerInstancia().MMCargaDatosMatReserva(materialreserva, deno);
                    if (mart.getDescripcion() == null || mart.getDescripcion().equals("")) {
                        out.println(0);
                    } else {
                        JSONArray js = new JSONArray();
                        js.add(mart.getDescripcion());
                        js.add(mart.getUnidad_medida());
                        out.println(js);
                    }
                    break;
                case "MuestraMatchResMat":
                    String des = "descripcion_" + idioma;
                    LinkedList<materiales> mte = ACC_Material.ObtenerInstancia().MMConsultaMatchMateriales(ctdmax, mate, cetr, des, texto_mate, TImat);
                    if (mte.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mte.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + mte.get(i).getMaterial() + "', 'material', '" + valu + "')\">");
                            out.println("<td>" + mte.get(i).getMaterial() + "</td>");
                            out.println("<td>" + mte.get(i).getCentro() + "</td>");
                            out.println("<td>" + mte.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + mte.get(i).getTipo_material() + "</td>");

                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchCentricoRE":

                    ArrayList<centros> cd = ACC_Centro.ObtenerInstancia().MM_MatchCentro();

                    if (cd.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cd.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + cd.get(i).getCentro() + "', 'centro')\">");
                            out.println("<td>" + cd.get(i).getCentro() + "</td>");
                            out.println("<td>" + cd.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "ConsultaMatchMatReserva":
                    //int ctd = Integer.parseInt(ctdmax);
                    String descri = "descripcion_" + idioma;

                    //LinkedList<materiales> mts = ACC_Material.ObtenerInstancia().ConsultaMatchMaterial(ctdmax, mate, cetr, descri, texto_mate, TImat);
                    LinkedList<materiales> mts = ACC_Material.ObtenerInstancia().ConsultaMatchMaterialOfReservas(mate, texto_mate, cetr, TImat, ctdmax, descri);

                    if (mts.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mts.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + mts.get(i).getMaterial() + "', 'material', '" + valu + "')\">");
                            out.println("<td>" + mts.get(i).getMaterial() + "</td>");
                            out.println("<td>" + mts.get(i).getCentro() + "</td>");
                            out.println("<td>" + mts.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + mts.get(i).getTipo_material() + "</td>");

                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                default:
                    out.println(1);
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
