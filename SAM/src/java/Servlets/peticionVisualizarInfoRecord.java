/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_OrganizacionCompras;
import AccesoDatos.ACC_Proveedor;
import AccesoDatos.ACC_RegistroInfo;
import AccesoDatos.ACC_TipoInfoRecords;
import Entidades.centros;
import Entidades.materiales;
import Entidades.organizacion_compras;
import Entidades.proveedor;
import Entidades.registroinfo;
import Entidades.tipo_info;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Developer-Antonio
 */
@WebServlet(name = "peticionVisualizarInfoRecord", urlPatterns = {"/peticionVisualizarInfoRecord"})
public class peticionVisualizarInfoRecord extends HttpServlet {

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
            String Accion = request.getParameter("acc");
            String Info = request.getParameter("info");
            String Prov = request.getParameter("prov");
            String NProv = request.getParameter("nprov");
            String Mate = request.getParameter("mate");
            String texto = request.getParameter("texto");
            String Tipo = request.getParameter("tipo");
            String DTipo = request.getParameter("Dtipo");
            String org = request.getParameter("comp");
            String den = request.getParameter("den");
            String cen = request.getParameter("cent");
            String ncen = request.getParameter("ncen");
            String cant = request.getParameter("cant");
            String Idioma = request.getParameter("idioma");
            switch (Accion) {
                case "ConsultaMatchInfo":
                    String query = "";
                    try {
                        int limite = Integer.parseInt(cant);
                        query = "SELECT DISTINCT TOP " + limite + " * FROM MM.registroinfo WHERE IdRegistroinfo LIKE '%" + Info + "%' AND proveedor LIKE '%" + Prov + "%' AND num_material LIKE '%" + Mate + "%' AND tipo_reginfo_compras LIKE '%" + Tipo + "%' AND organizacion_compras LIKE '%" + org + "%' AND centro LIKE '%" + cen + "%' ORDER BY IdRegistroinfo ";
                    } catch (Exception e) {
                        query = "SELECT DISTINCT  * FROM MM.registroinfo WHERE IdRegistroinfo LIKE '%" + Info + "%' AND proveedor LIKE '%" + Prov + "%' AND num_material LIKE '%" + Mate + "%' AND tipo_reginfo_compras LIKE '%" + Tipo + "%' AND organizacion_compras LIKE '%" + org + "%' AND centro LIKE '%" + cen + "%' ORDER BY IdRegistroinfo ";
                    }

                    LinkedList<registroinfo> r = ACC_RegistroInfo.ObtenerInstancia().ObtenerMatchRegInfo(query);
                    if (r.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < r.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('registro','" + r.get(i).getIdRegistroinfo() + "')\">");
                            out.println("<td>" + r.get(i).getIdRegistroinfo() + "</td>");
                            out.println("<td>" + r.get(i).getNum_material() + "</td>");
                            out.println("<td>" + r.get(i).getProveedor() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
//                case "ConsultaMatchMaterial":
//                    String DesMat = "Descripcion_" + Idioma;
//                    String querymat = "";
//                    try {
//                        int limit = Integer.parseInt(cant);
//                        querymat = "SELECT DISTINCT TOP " + limit + " * FROM MM.materiales m INNER JOIN MM.registroinfo ri ON m.material = ri.num_material  WHERE m.material LIKE '%" + Mate + "%' AND m." + DesMat + " LIKE '%" + texto + "%' ORDER BY m.material";
//                    } catch (Exception e) {
//                        querymat = "SELECT DISTINCT * FROM MM.materiales m INNER JOIN MM.registroinfo ri ON m.material = ri.num_material  WHERE m.material LIKE '%" + Mate + "%' AND m." + DesMat + " LIKE '%" + texto + "%' ORDER BY m.material";
//                    }
//                    LinkedList<materiales> ma = ACC_Material.ObtenerInstancia().CargarTodoMaterial(querymat, DesMat);
//                    if (ma.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (int i = 0; i < ma.size(); i++) {
//                            out.println("<tr ondblclick=\"seleccionar('Material','" + ma.get(i).getMaterial() + "')\">");
//                            out.println("<td>" + ma.get(i).getMaterial() + "</td>");
//                            out.println("<td>" + ma.get(i).getDescripcion() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//                    } else {
//                        out.println(0);
//                    }
//
//                    break;
                case "ConsultaMatchProveedor":
                    String querypro = "";
                    try {
                        int limi = Integer.parseInt(cant);
                        querypro = "SELECT DISTINCT TOP " + limi + " p.IdProveedor, p.nombre1, p.poblacion FROM MM.proveedores p INNER JOIN MM.registroinfo ri ON p.IdProveedor = ri.proveedor WHERE p.IdProveedor LIKE '%" + Prov + "%'  AND p.nombre1 LIKE'" + NProv + "%' ORDER BY p.IdProveedor";
                    } catch (Exception e) {
                        querypro = "SELECT DISTINCT p.IdProveedor, p.nombre1, p.poblacion FROM MM.proveedores p INNER JOIN MM.registroinfo ri ON p.IdProveedor = ri.proveedor WHERE p.IdProveedor LIKE '" + Prov + "%'  AND p.nombre1 LIKE'" + NProv + "%' ORDER BY p.IdProveedor";
                    }

                    LinkedList<proveedor> pr = ACC_Proveedor.ObtenerInstancia().ConsultaMatchProveedor(querypro);
                    if (pr.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pr.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('proveedor','" + pr.get(i).getIdProveedor() + "')\">");
                            out.println("<td>" + pr.get(i).getIdProveedor() + "</td>");
                            out.println("<td>" + pr.get(i).getNombre1() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
//                case "ConsultaMatchOrganizacion":
//                    String deno = "descripcion_" + Idioma;
//                    String queryorg = "";
//                    try {
//                        int lim = Integer.parseInt(cant);
//                        queryorg = "SELECT  DISTINCT TOP " + lim + " o.organizacion_compras, o." + deno + " FROM organizacion_compras o INNER JOIN registroinfo ri ON  o.organizacion_compras=ri.organizacion_compras WHERE o.organizacion_compras LIKE '%" + org + "%' AND o." + deno + " LIKE '%" + den + "%' ORDER BY o.organizacion_compras";
//                    } catch (Exception e) {
//                        queryorg = "SELECT  DISTINCT o.organizacion_compras, o." + deno + " FROM organizacion_compras o INNER JOIN registroinfo ri ON  o.organizacion_compras=ri.organizacion_compras WHERE o.organizacion_compras LIKE '%" + org + "%' AND o." + deno + " LIKE '%" + den + "%' ORDER BY o.organizacion_compras";
//                    }
//                    LinkedList<organizacion_compras> o = ACC_OrganizacionCompras.ObtenerInstancia().ConsultaMatchOCProveedor(queryorg, deno);
//
//                    if (o.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (int i = 0; i < o.size(); i++) {
//                            out.println("<tr ondblclick=\"seleccionar('compras','" + o.get(i).getOrganizacion_compras() + "')\">");
//                            out.println("<td>" + o.get(i).getOrganizacion_compras() + "</td>");
//                            out.println("<td>" + o.get(i).getDescripcion() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//                    } else {
//                        out.println(0);
//                    }
//                    break;
                case "ConsultaMatchInfoTipo":
                    String desctipo = "descripcion_" + Idioma;
                    String queryinfotipo = "";
                    try {
                        int limTipo = Integer.parseInt(cant);
                        queryinfotipo = "SELECT DISTINCT TOP " + limTipo + " it.valor, it." + desctipo + " FROM info_tipo it INNER JOIN registroinfo ri ON it.valor=ri.tipo_reginfo_compras WHERE it.valor LIKE '%" + Tipo + "%' AND it." + desctipo + " LIKE '%" + DTipo + "%' ORDER BY it.valor";
                    } catch (Exception e) {
                        queryinfotipo = "SELECT DISTINCT  it.valor, it." + desctipo + " FROM info_tipo it INNER JOIN registroinfo ri ON it.valor=ri.tipo_reginfo_compras WHERE it.valor LIKE '%" + Tipo + "%' AND it." + desctipo + " LIKE '%" + DTipo + "%' ORDER BY it.valor";

                    }
                    LinkedList<tipo_info> it = ACC_TipoInfoRecords.ObtenerInstancia().ConsultaTipoInfoMacth(queryinfotipo, desctipo);
                    if (it.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < it.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('infotipo','" + it.get(i).getValor() + "')\" >");
                            out.println("<td>" + it.get(i).getValor() + "</td>");
                            out.println("<td>" + it.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchCentro":
                    String queryCen = "";
                    try {
                        int limCen = Integer.parseInt(cant);
                        queryCen = "SELECT DISTINCT TOP " + limCen + " c.centro, c.descripcion FROM centros c INNER JOIN registroinfo ri ON c.centro=ri.centro WHERE c.centro LIKE '%" + cen + "%' AND c.descripcion LIKE '%" + ncen + "%' ORDER BY c.centro";
                    } catch (Exception e) {
                        queryCen = "SELECT DISTINCT  c.centro, c.descripcion FROM centros c INNER JOIN registroinfo ri ON c.centro=ri.centro WHERE c.centro LIKE '%" + cen + "%' AND c.descripcion LIKE '%" + ncen + "%' ORDER BY c.centro";
                    }
                    LinkedList<centros> ce = ACC_Centro.ObtenerInstancia().ConsultaMatchCentroSP(queryCen);
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('centro','" + ce.get(i).getCentro() + "')\" >");
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
                case "ValidarRegistro":
                    String queryinfo = "SELECT * FROM registroinfo WHERE IdRegistroinfo='" + Info + "'";
                    registroinfo re = ACC_RegistroInfo.ObtenerInstancia().ObtenerDatosRegistroInfo(queryinfo);
                    if (re.getIdRegistroinfo() == null || re.getIdRegistroinfo().equals("")) {
                        out.println(0);
                    } else {
                        String caden = "" + re.getIdRegistroinfo() + ","
                                + "" + re.getNum_material() + ","
                                + "" + re.getProveedor() + ","
                                + "" + re.getNombre1() + ","
                                + "" + re.getOrganizacion_compras() + ","
                                + "" + re.getTipo_reginfo_compras() + ","
                                + "" + re.getCentro() + ","
                                + "" + re.getGrupo_articulos() + ","
                                + "" + re.getGrupo_compras() + ","
                                + "" + re.getPlazo_entrega_dias() + ","
                                + "" + re.getMaterial_utilizado_proveedor() + ","
                                + "" + re.getCatiddad_pedido_estandar() + ","
                                + "" + re.getCantidad_pedido_maxima() + ","
                                + "" + re.getTexto_pedido_material_norelevante() + ","
                                + "" + re.getIndicador_obli_confir_pedido() + ","
                                + "" + re.getLimite_tolerancia_entrega_incompleta() + ","
                                + "" + re.getLimite_tolerancia_exceso_suministro() + ","
                                + "" + re.getDenominador_conver_um() + ","
                                + "" + re.getUnidad_medida_pedido() + ","
                                + "" + re.getNumerador_conversion_um() + ","
                                + "" + re.getUnidad_medida() + ","
                                + "" + re.getPrecio_neto_info_compras() + ","
                                + "" + re.getClave_moneda() + ","
                                + "" + re.getCantidad_base() + ","
                                + "" + re.getUnidad_medida_precio_pedido() + ","
                                + "" + re.getIndicador_iva() + "";
                        out.println(caden);
                    }
                    break;
                case "ValidarRegistroDM":
                    String querydm = "SELECT * FROM registroinfo WHERE num_material='" + Mate + "' AND organizacion_compras='" + org + "' AND tipo_reginfo_compras='" + Tipo + "' AND centro='" + cen + "' AND proveedor='" + Prov + "'";
                    registroinfo reg = ACC_RegistroInfo.ObtenerInstancia().ObtenerDatosRegistroInfo(querydm);
                    if (reg.getIdRegistroinfo() == null || reg.getIdRegistroinfo().equals("")) {
                        out.println(0);
                    } else {
                        String cadena = "" + reg.getIdRegistroinfo() + ","
                                + "" + reg.getNum_material() + ","
                                + "" + reg.getProveedor() + ","
                                + "" + reg.getNombre1() + ","
                                + "" + reg.getOrganizacion_compras() + ","
                                + "" + reg.getTipo_reginfo_compras() + ","
                                + "" + reg.getCentro() + ","
                                + "" + reg.getGrupo_articulos() + ","
                                + "" + reg.getGrupo_compras() + ","
                                + "" + reg.getPlazo_entrega_dias() + ","
                                + "" + reg.getMaterial_utilizado_proveedor() + ","
                                + "" + reg.getCatiddad_pedido_estandar() + ","
                                + "" + reg.getCantidad_pedido_maxima() + ","
                                + "" + reg.getTexto_pedido_material_norelevante() + ","
                                + "" + reg.getIndicador_obli_confir_pedido() + ","
                                + "" + reg.getLimite_tolerancia_entrega_incompleta() + ","
                                + "" + reg.getLimite_tolerancia_exceso_suministro() + ","
                                + "" + reg.getDenominador_conver_um() + ","
                                + "" + reg.getUnidad_medida_pedido() + ","
                                + "" + reg.getNumerador_conversion_um() + ","
                                + "" + reg.getUnidad_medida() + ","
                                + "" + reg.getPrecio_neto_info_compras() + ","
                                + "" + reg.getClave_moneda() + ","
                                + "" + reg.getCantidad_base() + ","
                                + "" + reg.getUnidad_medida_precio_pedido() + ","
                                + "" + reg.getIndicador_iva() + "";
                        out.println(cadena);
                    }
                    break;
                default:
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
