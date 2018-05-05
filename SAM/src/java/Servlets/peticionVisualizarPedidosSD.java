/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_VisualizarPedidosSD;
import AccesoDatos.Consultas;
import Entidades.SD_cabecera_pedidos_venta;
import Entidades.SD_posiciones_pedido_condiciones;
import Entidades.SD_posiciones_pedido_reparto;
import Entidades.SD_posiciones_pedido_venta;
import Entidades.SD_posiciones_pedidos_expedicion;
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
 */
@WebServlet(name = "peticionVisualizarPedidosSD", urlPatterns = {"/peticionVisualizarPedidosSD"})
public class peticionVisualizarPedidosSD extends HttpServlet {

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
            String Documento = request.getParameter("Documento");
            String FolioSAM = request.getParameter("FolioSAM");
            String Posicion = request.getParameter("Posicion");
            String Clase = request.getParameter("Clase");
            String Ctd = request.getParameter("Ctd");
            String TipoCon = request.getParameter("TipoConsulta");
            Consultas c = new Consultas();
            switch (Accion) {
                case "ConsultaMCPedido":
                    ArrayList<SD_cabecera_pedidos_venta> mc1 = ACC_VisualizarPedidosSD.ObtenerInstancia().ConsultaMCPedidosSD(Documento, Clase, Ctd, FolioSAM);
                    if (mc1.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mc1.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + mc1.get(i).getDocumento_ventas() + "')\">");
                            out.println("<td>" + mc1.get(i).getClase_documento_ventas() + "</td>");
                            out.println("<td>" + mc1.get(i).getDocumento_ventas() + "</td>");
                            out.println("<td>" + mc1.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaDocumentoTipo":
                    String var = "0";
                    SD_cabecera_pedidos_venta p = ACC_VisualizarPedidosSD.ObtenerInstancia().ObtenerCabeceraPed(Documento);
                    if (!(p.getDocumento_ventas().trim() == "" || p.getDocumento_ventas().trim() == null)) {
                        var = "1";
                    }
                    out.println(var);
                    break;
                case "ConsultaPedidoCab":
                    JSONArray j = new JSONArray();
                    switch (TipoCon) {
                        case "1":
                            SD_cabecera_pedidos_venta pe = ACC_VisualizarPedidosSD.ObtenerInstancia().ObtenerCabeceraPed(Documento);
                            j.add(pe.getDocumento_ventas().trim());
                            j.add(pe.getSolicitante().trim());
                            j.add(pe.getDestinatario_mercancias().trim());
                            j.add(pe.getNum_pedido_cliente().trim());
                            j.add(pe.getTexto_visual_interlocutor1().trim());
                            j.add(pe.getTexto_visual_interlocutor2().trim());
                            j.add(c.DateFormat(pe.getFecha_pedido_compra_cliente().trim()));
                            j.add(pe.getClase_documento_ventas().trim());
                            j.add(pe.getOrganizacion_ventas().trim());
                            j.add(pe.getCanal_distribucion().trim());
                            j.add(pe.getSector().trim());
                            j.add(pe.getOficina_ventas().trim());
                            j.add(pe.getDenominacion_oficina_ventas().trim());
                            j.add(pe.getGrupo_vendedores().trim());
                            j.add(pe.getDenominacion_grupo_vendedores().trim());
                            j.add(pe.getMotivo_pedido().trim());
                            j.add(c.DateFormat(pe.getFecha_documento().trim()));
                            j.add(pe.getArea_ventas().trim());
                            j.add(pe.getNombre_responsable().trim());
                            j.add(c.DateFormat(pe.getFecha_determinacion_precio_tipo_cam().trim()));
                            j.add(pe.getMoneda_documento().trim());
                            j.add(pe.getMoneda_documento().trim());
                            j.add(pe.getValor_neto().trim());
                            j.add(c.DateFormat(pe.getFecha_pref_entrega().trim()));
                            j.add(pe.getFolio_sam());
                            out.println(j);
                            break;
                        case "2":
                            break;
                        default:
                            break;
                    }

                    break;
                case "CargarPosicionesTabla":
                    out.println("<table id=\"TabBody2\">");
                    out.println("<tbody>");
                    if (TipoCon.equals("1")) {
                        ArrayList<SD_posiciones_pedido_venta> pos = ACC_VisualizarPedidosSD.ObtenerInstancia().GetItems(Documento);
                        if (pos.size() > 0) {
                            int n;
                            for (n = 0; n < pos.size(); n++) {
                                out.println("<tr ondblclick=\"GetItemP('" + pos.get(n).getNumero_documento_comercial() + "','" + pos.get(n).getPosicion_documento_ventas() + "', '1')\">");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + CerosIzqu(pos.get(n).getPosicion_documento_ventas()) + "</td>");
                                out.println("<td>" + pos.get(n).getNumero_material() + "</td>");
                                out.println("<td>" + pos.get(n).getCantidad_pedido() + "</td>");
                                out.println("<td>" + pos.get(n).getUnidad_medida_venta() + "</td>");
                                out.println("<td><input type=\"checkbox\" disabled " + CheckR(pos.get(n).getExisten_repartos()) + "/></td>");
                                out.println("<td>" + pos.get(n).getTexto_breve_posicion_pedido_cliente() + "</td>");
                                out.println("<td>" + pos.get(n).getNumero_material_cliente() + "</td>");
                                out.println("<td>" + pos.get(n).getTipo_pos_doc_com() + "</td>");
                                out.println("<td>" + pos.get(n).getPerfil_ind_merc_com() + "</td>");
                                out.println("<td>" + pos.get(n).getPosicion_sup_estra_lis_mat() + "</td>");
                                out.println("<td>" + pos.get(n).getTipo_fecha_pref_entrega() + "</td>");
                                out.println("<td>" + c.DateFormat(pos.get(n).getFecha_reparto()) + "</td>");
                                out.println("</tr>");
                            }
                            for (int a = n; a < 9; a++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int k = 0; k < 9; k++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                        }

                    }
                    if (TipoCon.equals("0")) {
                        for (int k = 0; k < 9; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00</td><td>000000</td><td>00000000000</td><td>00000000000000</td><td>0000</td><td>000</td><td>0000000000000000000000</td><td>0000000000000000000000</td><td>0000000</td><td>0000000000000</td><td>00000000</td><td>00000000000000000</td><td>00000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CargarPosExpedicion":
                    JSONArray je = new JSONArray();
                    switch (TipoCon) {
                        case "0":
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            je.add("");
                            out.println(je);
                            break;
                        case "1":
                            SD_posiciones_pedidos_expedicion exp = ACC_VisualizarPedidosSD.ObtenerInstancia().GetExpedicionPos(Documento, Posicion);
                            je.add(exp.getCentro().trim());
                            je.add(exp.getNombre_centro().trim());
                            je.add(exp.getPrioridad_entrega().trim());
                            je.add(exp.getDenominacion_prio_entre().trim());
                            je.add(exp.getAlmacen().trim());
                            je.add(exp.getDenominacion_almacen().trim());
                            je.add(exp.getPuesto_expedicion().trim());
                            je.add(exp.getDenominacion_pto_exp().trim());
                            je.add(exp.getRuta().trim());
                            je.add(exp.getDenominacion_ruta().trim());
                            je.add(exp.getPeso_neto_pos().trim());
                            je.add(exp.getUnidad_peso().trim());
                            je.add(exp.getPeso_bruto_pos().trim());
                            out.println(je);
                            break;
                        case "2":
                            break;

                    }
                    break;
                case "CargarPosCampos":
                    JSONArray jas = new JSONArray();
                    switch (TipoCon) {
                        case "0":
                            jas.add("");
                            jas.add("");
                            jas.add("");
                            jas.add("");
                            jas.add("");
                            jas.add("");
                            jas.add("");
                            jas.add("");
                            out.println(jas);
                            break;
                        case "1":
                            SD_posiciones_pedido_venta con = ACC_VisualizarPedidosSD.ObtenerInstancia().GetPosCampos(Documento, Posicion);
                            jas.add(con.getCantidad().trim());
                            jas.add(con.getUnidad_medida_venta().trim());
                            jas.add(con.getValor_neto().trim());
                            jas.add(con.getMoneda_documento_comercial().trim());
                            jas.add(con.getImporte_impuesto_moneda_doc().trim());
                            jas.add(con.getDenominacion_status_trat_global().trim());
                            jas.add(con.getMotivo_rechazo().trim() + " " + con.getDenominacion_sociedad_co());
                            jas.add(con.getDenominacion_status_entrega().trim());
                            out.println(jas);
                            break;
                    }
                    break;
                case "CargarTablaCondiciones":
                    out.println("<table id=\"TabBody3\">");
                    out.println("<tbody>");
                    if (TipoCon.equals("1")) {
                        ArrayList<SD_posiciones_pedido_condiciones> co = ACC_VisualizarPedidosSD.ObtenerInstancia().GetTableCondiciones(Documento, Posicion);
                        if (co.size() > 0) {
                            int x;
                            for (x = 0; x < co.size(); x++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td><img src='images/" + SemaforoInactive(co.get(x).getVisualizacion_cond_inactivas().trim()) + ".PNG' /></td>");
                                out.println("<td>" + co.get(x).getClase_condicion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getDenominacion_clase().trim() + "</td>");
                                out.println("<td>" + co.get(x).getImporte_porc_cond().trim() + "</td>");
                                out.println("<td>" + co.get(x).getClave_moneda().trim() + "</td>");
                                out.println("<td>" + co.get(x).getCantidad_base_cond().trim() + "</td>");
                                out.println("<td>" + co.get(x).getUnidad_med_cond_doc().trim() + "</td>");
                                out.println("<td>" + co.get(x).getValor_condicion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getClave_moneda().trim() + "</td>");
                                out.println("<td>" + co.get(x).getContador_conx_cond().trim() + "</td>");
                                out.println("<td>" + co.get(x).getUnidad_medida_base().trim() + "</td>");
                                out.println("<td>" + co.get(x).getDenominador_conv_cond().trim() + "</td>");
                                out.println("<td>" + co.get(x).getUnidad_med_cond().trim() + "</td>");
                                out.println("<td>" + co.get(x).getValor_cond().trim() + "</td>");
                                out.println("<td>" + co.get(x).getMoneda_condicion().trim() + "</td>");
                                out.println("<td><input type=\"checkbox\" disabled " + CheckR(co.get(x).getCondicion_estad().trim()) + "/></td>");
                                out.println("</tr>");
                            }
                            for (int d = x; d < 6; d++) {
                                out.println(" <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
                            }
                        } else {
                            for (int jq = 0; jq < 6; jq++) {
                                out.println(" <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
                            }
                        }
                    }
                    if (TipoCon.equals("0")) {
                        for (int jq = 0; jq < 6; jq++) {
                            out.println(" <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00</td><td>000000</td><td>000000</td><td>0000000000000</td><td>00000000</td><td>00000</td><td>00000</td><td>00000</td><td>00000000000000</td><td>0000000</td><td>000000000</td><td>00000000</td><td>00000000</td><td>000000</td><td>00000000000000</td><td>0000000</td><td>000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "GetRepartos":
                    out.println("<table id=\"TabBody4\">");
                    out.println("<tbody>");
                    if (TipoCon.equals("1")) {
                        ArrayList<SD_posiciones_pedido_reparto> rep = ACC_VisualizarPedidosSD.ObtenerInstancia().GetReparto(Documento, Posicion);
                        if (rep.size() > 0) {
                            int b;
                            for (b = 0; b < rep.size(); b++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + rep.get(b).getTipo_fehca().trim() + "</td>");
                                out.println("<td>" + c.DateFormat(rep.get(b).getFecha_reparto().trim()) + "</td>");
                                out.println("<td>" + rep.get(b).getCant_pedida_cliente_umv().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getCant_corregida().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getCant_confirmada().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getUnidad_med_venta().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getBloqueo_entrega_prop().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getCant_entreg_unid_venta().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getTipo_pos_reparto().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getNumero_solicitud_ped().trim() + "</td>");
                                out.println("<td>" + CerosIzqu(rep.get(b).getNum_pos_solc_ped().trim()) + "</td>");
                                out.println("</tr>");
                            }
                            for (int y = b; y < 6; y++) {
                                out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
                            }
                        } else {
                            for (int y = 0; y < 6; y++) {
                                out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
                            }
                        }
                    }
                    if (TipoCon.equals("0")) {
                        for (int y = 0; y < 6; y++) {
                            out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00</td><td>0000000000000</td><td>000000000000000</td><td>0000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CabRep":
                    ArrayList<SD_posiciones_pedido_reparto> r = ACC_VisualizarPedidosSD.ObtenerInstancia().GetReparto(Documento, Posicion);
                    JSONArray j1 = new JSONArray();
                    if (TipoCon.equals("0")) {
                        j1.add("");
                        j1.add("");
                        j1.add("");
                        j1.add("");
                        out.println(j1);
                    }
                    if (TipoCon.equals("1")) {
                        j1.add(r.get(0).getPlazo_entrega_acordado().trim());
                        j1.add(r.get(0).getCantidad_pedido_acom().trim());
                        j1.add(r.get(0).getUnidad_medida_venta().trim());
                        j1.add(r.get(0).getCant_entreg_unid_venta().trim());
                        out.println(j1);
                    }
                    break;
                case "CargarCabeceraTexto":
                    String txtcab = ACC_VisualizarPedidosSD.ObtenerInstancia().GetTextoCabecera(Documento);
                    out.println(txtcab);
                    break;
                case "CargarPosicionTexto":
                    String txtpos = ACC_VisualizarPedidosSD.ObtenerInstancia().GetTextoPosicion(Documento, Posicion);
                    out.println(txtpos);
                    break;
            }
        }
    }

    public String CheckR(String r) {
        String ban = "";
        if (r.equals("X")) {
            ban = "checked";
        }

        return ban;
    }

    public String CerosIzqu(String Pos) {
        int po = Integer.parseInt(Pos);
        return String.valueOf(po);
    }

    public String SemaforoInactive(String inactivo) {
        String icon = "advertencia";
        if (inactivo.equals("X")) {
            icon = "@0AQStatus@";
        } else if (inactivo.equals("")) {
            icon = "@08QStatus@";
        } else {
            icon = "@09QStatus@";
        }
        return icon;
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
