/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Pedidos;
import AccesoDatos.Consultas;
import Entidades.pedido_detalle;
import Entidades.pedido_historial;
import Entidades.pedido_servicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 */
@WebServlet(name = "peticionModuloPedidos", urlPatterns = {"/peticionModuloPedidos"})
public class peticionModuloPedidos extends HttpServlet {

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
            String Accion = request.getParameter("Action");
            String CtdAci = request.getParameter("CtdAcc");
            String Pedido = request.getParameter("Pedidos");
            String Solped = request.getParameter("Solped");
            String Posici = request.getParameter("Posicion");
            String numsam = request.getParameter("SOLSAM");
            Consultas con = new Consultas();
            switch (Accion) {
                case "CargarMatchPedidos":
                    if (CtdAci.length() == 0) {
                        CtdAci = "0";
                    }
                    ArrayList<pedido_detalle> p = ACC_Pedidos.ObtenerInstancia().ConsultarMCPedidos(Pedido, Solped, numsam, Integer.parseInt(CtdAci));
                    if (p.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < p.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + p.get(i).getNum_doc_compras() + "')\">");
                            out.println("<td>" + p.get(i).getNum_doc_compras() + "</td>");
                            out.println("<td>" + p.get(i).getNum_solped() + "</td>");
                            out.println("<td>" + p.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarDatosCab":
                    ArrayList<pedido_detalle> a = ACC_Pedidos.ObtenerInstancia().CargarTablaPedidoStandar(Pedido);
                    JSONArray arr = new JSONArray();
                    arr.add(a.get(0).getDenominacion_clase_doc_compras());
                    arr.add(a.get(0).getNum_cuenta_proveedor());
                    arr.add(a.get(0).getNombre1());
                    arr.add(con.DateFormat(a.get(0).getFecha_doc_compras()));
                    arr.add(a.get(0).getNombre());
                    arr.add(a.get(0).getOrganizacion_compras());
                    arr.add(a.get(0).getDenominacion_orga_compras());
                    arr.add(a.get(0).getGrupo_compras());
                    arr.add(a.get(0).getDenominacion_grupo_compras());
                    arr.add(a.get(0).getSociedad());
                    arr.add(a.get(0).getDenominacion_sociedad());
                    arr.add(a.get(0).getGrupo_liberacion());
                    arr.add(a.get(0).getEstrategia_liberacion());
                    arr.add(a.get(0).getInd_liberacion_doc_compras());
                    arr.add(a.get(0).getSolicitante());
                    out.print(arr);
                    break;
                case "CargarDatosTablaPedidos":
                    int x;
                    ArrayList<pedido_detalle> n = ACC_Pedidos.ObtenerInstancia().CargarTablaPedidoStandar(Pedido);
                    if (n.size() > 0) {
                        out.println("<table id=\"TabBody\">");
                        out.println("<tbody>");
                        for (x = 0; x < n.size(); x++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td name=\"PosicionPedido\">" + n.get(x).getNum_posicion_doc_compras() + "</td>");
                            out.println("<td>" + n.get(x).getTipo_imputacion() + "</td>");
                            out.println("<td>" + n.get(x).getTipo_posicion_doc_compras() + "</td>");
                            out.println("<td>" + n.get(x).getNum_material() + "</td>");
                            out.println("<td>" + n.get(x).getTexto_breve() + "</td>");
                            out.println("<td>" + n.get(x).getCantidad_pedido() + "</td>");
                            out.println("<td>" + n.get(x).getUnidad_medida_base() + "</td>");
                            out.println("<td>" + con.DateFormat(n.get(x).getFecha_entrega_posicion()) + "</td>");
                            out.println("<td>" + n.get(x).getCentro() + "</td>");
                            out.println("<td>" + n.get(x).getAlmacen() + "</td>");
                            out.println("<td>" + n.get(x).getNum_lote() + "</td>");
                            out.println("<td>" + n.get(x).getSolicitante() + "</td>");
                            out.println("<td>" + n.get(x).getNum_registro_info() + "</td>");
                            out.println("<td>" + n.get(x).getFolio_sam() + "</td>");
                            out.println("<td>" + n.get(x).getNum_solped() + "</td>");
                            out.println("<td>" + n.get(x).getNum_posicion_solped() + "</td>");
                            out.println("<td>" + n.get(x).getNum_contrato_superior() + "</td>");
                            out.println("</tr>");
                        }
                        for (int j = x; j < 6; j++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\"><td>00</td><td>00</td><td>00000000000</td><td>0000000</td><td>0000000</td><td>000000000000</td><td>0000000000000000000000000000000000</td><td>0000000000000</td><td>000000000000</td><td>00000000000000</td><td>0000000000</td><td>0000000000000</td><td>0000000000</td><td>000000000000</td><td>00000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000000</td></tr>");
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(1);
                    }

                    break;
                case "CargarPosicionesPedidos":
                    ArrayList<pedido_detalle> po = ACC_Pedidos.ObtenerInstancia().CargarTablaPedidoStandar(Pedido);
                    if (po.size() > 0) {
                        out.println("<select id=\"pospedidos\" onchange=\"ObternerDatoPoi();\">"
                                + "<option></option>");
                        for (int c = 0; c < po.size(); c++) {
                            out.println("<option value=\"" + po.get(c).getNum_posicion_doc_compras() + "," + po.get(c).getNum_doc_compras() + "\">" + "[" + po.get(c).getNum_posicion_doc_compras() + "] " + po.get(c).getTexto_breve() + "</option>");
                        }
                        out.println("</select>");
                    } else {
                        out.println("<select id=\"pospedidos\" onchange=\"ObternerDatoPoi();\">"
                                + "<option></option>");
                        out.println("</select>");
                    }
                    break;
                case "CargarPosicionePedi":
                    pedido_detalle pos = ACC_Pedidos.ObtenerInstancia().GetDataPos(Pedido, Posici);
                    JSONArray arre = new JSONArray();
                    arre.add(pos.getGrupo_articulos());
                    arre.add(pos.getMaterial_utili_proveedor());
                    arre.add(pos.getNum_articulo_europeo());
                    arre.add(pos.getLote_proveedor());
                    arre.add(pos.getNombre_pos());
                    arre.add(pos.getTipo_imputacion());
                    arre.add(pos.getClase_coste());
                    arre.add(pos.getSociedad());
                    arre.add(pos.getNum_orden());
                    arre.add(pos.getCentro_coste());
                    out.println(arre);
                    break;
                case "VerificarExistPoServicio":
                    if (ACC_Pedidos.ObtenerInstancia().ExistPosServicio(Pedido)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarPosServicio":
                    int se;
                    ArrayList<pedido_servicios> ps = ACC_Pedidos.ObtenerInstancia().ObtenerServiciosPedido(Pedido, Posici);
                    if (ps.size() > 0) {
                        out.println("<table id=\"TabBody3\">");
                        out.println("<tbody>");
                        for (se = 0; se < ps.size(); se++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + cambiarint(ps.get(se).getNum_linea()) + "</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>" + ps.get(se).getNum_servicio() + "</td>");
                            out.println("<td>" + ps.get(se).getTexto_breve() + "</td>");
                            out.println("<td>" + ps.get(se).getCantidad_con_signo() + "</td>");
                            out.println("<td>" + ps.get(se).getUnidad_medida_base() + "</td>");
                            out.println("<td>" + ps.get(se).getPrecio_bruto() + "</td>");
                            out.println("<td>" + ps.get(se).getClave_moneda() + "</td>");
                            out.println("<td></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>" + ps.get(se).getNum_orden() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + ps.get(se).getValor_neto_posicion() + "</td>");
                            out.println("<td>" + ps.get(se).getPedido_cantidad_entrada() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        for (int k = se; k < 9; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "                                                    <td>00</td>\n"
                                + "                                                    <td>00000000000</td>\n"
                                + "                                                    <td>00000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>0000000000000000</td>\n"
                                + "                                                </tr>");
                        out.println("</tbody>");
                        out.println("</table>");

                    } else {
                        out.println("<table id=\"TabBody2\">");
                        out.println("<tbody>");
                        for (int k = 0; k < 9; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td><input class=\"chkcenter\" disabled type=\"checkbox\"/></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "                                                    <td>00</td>\n"
                                + "                                                    <td>00000000000</td>\n"
                                + "                                                    <td>00000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>0000000000000</td>\n"
                                + "                                                    <td>0000000000000000</td>\n"
                                + "                                                </tr>");
                        out.println("</tbody>");
                        out.println("</table>");

                    }
                    break;
                case "CargarHistorial":
                    int h;
                    ArrayList<pedido_historial> ph = ACC_Pedidos.ObtenerInstancia().CargarPedidoHistorial(Pedido, Posici);

                    if (ph.size() > 0) {
                        out.println("<table id=\"TabBody2\">");
                        out.println("<tbody>");
                        for (h = 0; h < ph.size(); h++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + ph.get(h).getTipo_historial_pedido() + "</td>");
                            out.println("<td>" + ph.get(h).getClase_movimiento() + "</td>");
                            out.println("<td>" + ph.get(h).getNum_doc_material() + "</td>");
                            out.println("<td>" + ph.get(h).getFolio_sam() + "</td>");
                            out.println("<td>" + ph.get(h).getNum_posicion_doc_compras() + "</td>");
                            out.println("<td>" + con.DateFormat(ph.get(h).getFecha_contabilizacion_doc()) + "</td>");
                            out.println("<td>" + ph.get(h).getCantidad() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + ph.get(h).getUnidad_medida_base() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + ph.get(h).getCantidad_pedido() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + ph.get(h).getUnidad_medida_base2() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        for (int z = h; z < 12; z++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "                                                    <td>00</td>\n"
                                + "                                                    <td>000000000000000000000000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000000000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000</td>\n"
                                + "                                                    <td>0000000000000000000</td>\n"
                                + "                                                    <td>000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000000000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000000</td>\n"
                                + "                                                </tr>");
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println("<table id=\"TabBody2\">");
                        out.println("<tbody>");
                        for (int z = 0; z < 12; z++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "                                                    <td>00</td>\n"
                                + "                                                    <td>000000000000000000000000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000000000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000</td>\n"
                                + "                                                    <td>0000000000000000000</td>\n"
                                + "                                                    <td>000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000000000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000000000</td>\n"
                                + "                                                    <td>00000000000000000000</td>\n"
                                + "                                                    <td>000000000000000000000</td>\n"
                                + "                                                    <td>0000000000000000</td>\n"
                                + "                                                </tr>");
                        out.println("</tbody>");
                        out.println("</table>");

                    }
                    break;
                case "VerificarExistLiberacion":
                    if (ACC_Pedidos.ObtenerInstancia().ValidarLibePed(Pedido)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "cleantablepedido":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (int j = 0; j < 6; j++) {
                        out.println(""
                                + "<tr>"
                                + "<td>&nbsp;</td>"
                                + "<td name=\"PosicionPedido\">&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>00</td><td>00</td><td>00000000000</td><td>0000000</td><td>0000000</td><td>000000000000</td><td>0000000000000000000000000000000000</td><td>0000000000000</td><td>000000000000</td><td>00000000000000</td><td>0000000000</td><td>0000000000000</td><td>0000000000</td><td>000000000000</td><td>00000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000000</td></tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
            }
        }
    }

    public int cambiarint(String dato) {
        int num = Integer.parseInt(dato);
        return num;
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
