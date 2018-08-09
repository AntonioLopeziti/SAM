/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_DetallesDocMateriales;
import AccesoDatos.ACC_Pedidos;
import AccesoDatos.Conexion;
import AccesoDatos.Consultas;
import Entidades.detalles_doc_materiales;
import Entidades.movimientos_detalle;
import Entidades.pedido_detalle;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionTablasMovMateriales", urlPatterns = {"/PeticionTablasMovMateriales"})
public class PeticionTablasMovMateriales extends HttpServlet {

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
            pedido_detalle pp = new pedido_detalle();

            try {
                pp.setMaterial(Integer.parseInt(request.getParameter("v1")) + "");
            } catch (Exception e) {
                pp.setMaterial(request.getParameter("v1"));
            }
            pp.setCantidad(request.getParameter("v2"));
            pp.setUnidad_medida_base(request.getParameter("v3"));
            pp.setLote(request.getParameter("v4"));
            pp.setDescripcion(request.getParameter("v5"));
            pp.setCentro_coste(request.getParameter("v6"));
            pp.setCentro(request.getParameter("v7"));
            pp.setNum_posicion(request.getParameter("v8"));
            pp.setTipo_mov(request.getParameter("v9"));
            pp.setAlmacen(request.getParameter("almacen"));
            pp.setNum_orden(request.getParameter("Orden"));
            pp.setNum_doc_compras(request.getParameter("v10"));
            pp.setNum_cuenta_proveedor(request.getParameter("v11"));//Num posición 
            pp.setNum_posicion_solped(request.getParameter("v12"));

            String Doculot = request.getParameter("doclote");
            String Docposlot = request.getParameter("docposlote");

            String accion = request.getParameter("Action");
            String almacen = request.getParameter("almacen");
            String clase = request.getParameter("clase");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String CDestino = request.getParameter("CDestino");
            String NDocCom = request.getParameter("DocCom");
            String tipFol = request.getParameter("TipoFolio");
            String us = request.getParameter("ipFolio");
            String user = (String) session.getAttribute("Usuario");
            String Idioma = (String) session.getAttribute("Idioma");
            String IP = (String) session.getAttribute("IP");
            String perso = IP + user;
            Conexion cnx = new Conexion();
            accion += clase;

            int c;
            Properties po = new Properties();
            try {
                po.load(getServletContext().getResourceAsStream("/WEB-INF/Language" + Idioma + ".properties"));
            } catch (Exception e) {
                System.err.println("Error por: " + e);
            }
            switch (accion) {
                case "VentanaModal101NBS101":
                case "VentanaModal101NBS102":
                    out.println("<table class=\"TablaCont\" id=\"TablaPedido\">\n"
                            + "        <thead>\n"
                            + "                <tr id=\"CabeceraTabla\">\n"
                            + "                    <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TAlmacen_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TPorRecibir_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TNAE_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TCEAN_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TUEAN_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TloteProv_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TcantidadR_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TUMB_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.Tcentro_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TfechaEntrega_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TTP_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TBSAR_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.Tposicion_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TCentCos_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                            + "                    <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                            + "\n"
                            + "                </tr>\n"
                            + "        </thead>\n"
                            + "        <tbody>");

                    for (c = 0; c <= 20; c++) {
                        out.println("<tr>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>" + almacen + "</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>0.000</td>\n"
                                + "                <td>0.000</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>0</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "                <td>&nbsp;</td>\n"
                                + "           </tr>");
                    }
                    out.print("</tbody>"
                            + "          </table>");
                    break;
                case "VentanaModal101101":
                    if (ACC_Pedidos.ObtenerInstancia().ConsultaPedidoExiste(v1, v3)) {
                        if (ACC_Pedidos.ObtenerInstancia().veriPediServ(v1)) {
                            if (ACC_Pedidos.ObtenerInstancia().CheckOrdenLibPedido(v1) == 1) {
                                if (ACC_Pedidos.ObtenerInstancia().checkLiberacion(v1, v2, v3, almacen)) {
                                    ArrayList<pedido_detalle> pe = ACC_Pedidos.ObtenerInstancia().ConsultaPedidos(v1, v2, v3);
                                    if (pe.size() > 0) {
                                        out.println("<table class=\"TablaCont\" id=\"TablaPedido\">\n"
                                                + "        <thead>\n"
                                                + "                <tr id=\"CabeceraTabla\">\n"
                                                + "                    <td>&nbsp;&nbsp;&nbsp;</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.Tdescripcion_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TAlmacen_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TPorRecibir_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                                                + "                    <td></td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TUEAN_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TloteProv_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TcantidadR_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TUMB_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.Tcentro_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TfechaEntrega_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TTP_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TBSAR_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.Tposicion_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TCentCos_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                                                + "                    <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                                                + "                    <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                    <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                    <td class=\"ocultar\">ADMON_PORTUARIA__INTEGRAL_DE_TOPO_S_Mas_Espacio</td>\n"
                                                + "\n"
                                                + "                </tr>\n"
                                                + "        </thead>\n"
                                                + "        <tbody>");

                                        for (c = 0; c < pe.size(); c++) {
                                            BigDecimal res = new BigDecimal(Double.parseDouble(pe.get(c).getCantidad_pedido()) - Double.parseDouble(pe.get(c).getCantidad()) - Double.parseDouble(pe.get(c).getUltima_cantidad())).setScale(12, BigDecimal.ROUND_HALF_DOWN);
                                            Double c1 = res.doubleValue();
                                            Double c2 = Double.parseDouble(pe.get(c).getCantidad()) + Double.parseDouble(pe.get(c).getUltima_cantidad());
                                            out.println("<tr>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td name=\"tdMaterial\">" + pe.get(c).getMaterial() + "</td>\n"
                                                    + "                <td name=\"tdtxt\">" + pe.get(c).getDescripcion() + "</td>\n"
                                                    + "                <td name=\"tdAlmacen\">" + pe.get(c).getAlmacen() + "</td>\n"
                                                    + "                <td><input maxlength=\"13\" type=\"text\"  value=\"" + Num(String.valueOf(c1)) + "\"name=\"bx101Prb\"  class=\"bx101N\" id=\"bxPrb" + c + "\" onblur=\"this.value = checkDec(this.value, 3)\"   onKeyPress=\"return soloNumeros(event)\" onfocus=\"loteBtnHide('" + pe.size() + "')\"></td>\n"
                                                    + "                <td><input type=\"text\" name=\"bx101Lote\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bx101NL\" id=\"bxLote" + c + "\" onfocus=\"loteBtnShow('" + c + "', '" + pe.size() + "')\"></td>\n"
                                                    + "                <td><button id=\"btnLote" + c + "\" class='BtnMatchIcon' style=\"display : none;\" onclick=\"MatchLote('" + c + "', '" + pe.get(c).getMaterial() + "')\"></button></td>\n"
                                                    + "                <td><input type=\"text\" style=\"text-transform: uppercase;\" disabled maxlength=\"3\" value=\"" + pe.get(c).getUnidad_medida_base() + "\" name=\"bx101UEAN\" class=\"bx101N\" id=\"bxUEAN" + c + "\" onfocus=\"loteBtnHide('" + pe.size() + "')\"></td>\n"
                                                    + "                <td><input type=\"text\" style=\"text-transform: uppercase;\" maxlength=\"15\" name=\"bx101Prov\" class=\"bx101N\" id=\"bxProv" + c + "\" onfocus=\"loteBtnHide('" + pe.size() + "')\"   ></td>\n"
                                                    + "                <td name=\"tdCR\">" + Num(String.valueOf(c2)) + "</td>\n"
                                                    + "                <td name=\"tdCP\">" + Num(pe.get(c).getCantidad_pedido()) + "</td>\n"
                                                    + "                <td name=\"tdUM\">" + pe.get(c).getUnidad_medida_base() + "</td>\n"
                                                    + "                <td name=\"tdCentro\">" + pe.get(c).getCentro() + "</td>\n"
                                                    + "                <td name=\"tdFechaE\">" + pe.get(c).getFecha_entrega_posicion() + "</td>\n"
                                                    + "                <td name=\"tdDocCom\">" + pe.get(c).getTipo_doc_compras() + "</td>\n"
                                                    + "                <td name=\"tdClase\">" + pe.get(c).getClase_pedido() + "</td>\n"
                                                    + "                <td name=\"tdProveedor\">" + pe.get(c).getNum_cuenta_proveedor() + "</td>\n"
                                                    + "                <td name=\"tdPedido\">" + pe.get(c).getPedido() + "</td>\n"
                                                    + "                <td name=\"tdPos\">" + pe.get(c).getNum_posicion() + "</td>\n"
                                                    + "                <td name=\"tdCeCo\">" + pe.get(c).getCentro_coste() + "</td>\n"
                                                    + "                <td name=\"tdOrder\">" + pe.get(c).getNum_orden() + "</td>\n"
                                                    + "                <td name=\"tdClCoste\">" + pe.get(c).getClase_coste() + "</td>\n"
                                                    + "                <td class=\"ocultar\" name=\"tdTPos\">" + pe.get(c).getTipo_posicion_doc_compras() + "</td>\n"
                                                    + "                <td class=\"ocultar\" name=\"tdTImp\">" + pe.get(c).getTipo_imputacion() + "</td>\n"
                                                    + "                <td class=\"ocultar\" name=\"tdulc\">" + pe.get(c).getUltima_cantidad() + "</td>\n"
                                                    + "           </tr>");
                                        }
                                        for (int d = c; d <= 19; d++) {
                                            out.println("<tr>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "                <td>&nbsp;</td>\n"
                                                    + "           </tr>");
                                        }
                                        out.println("<tr>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">ADMON_PORTUARIA__INTEGRAL_DE_TOPO_S_Mas_Espacio</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                                + "           </tr>");
                                        out.print("</tbody>"
                                                + "          </table>");
                                    }
                                } else {
                                    out.println(1);
                                }
                            } else {
                                out.println(3);
                            }
                        } else {
                            out.println(2);
                        }

                    } else {
                        out.println(0);
                    }
                    break;
                case "VentanaModal101102":
                    if (tipFol.equals("FSAP")) {
                        ArrayList<detalles_doc_materiales> msap = ACC_DetallesDocMateriales.ObtenerInstancia().ObetenerDocmov102Vis(NDocCom, Idioma);
                        if (msap.size() > 0) {
                            out.println("<table class=\"TablaCont\" id=\"TablaPedido\">\n"
                                    + "        <thead>\n"
                                    + "                <tr id=\"CabeceraTabla\">\n"
                                    + "                    <td>&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tdescripcion_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TAlmacen_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TPorDevolv_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TcantidadCan_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TUMB_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tcentro_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TfechaEntrega_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TTP_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TBSAR_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tposicion_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TCentCos_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                                    + "                </tr>\n"
                                    + "        </thead>\n"
                                    + "        <tbody>");
                            for (c = 0; c < msap.size(); c++) {
                                out.println("<tr>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td name=\"tdMaterial102\">" + msap.get(c).getNum_material() + "</td>\n"
                                        + "                <td name=\"tdtxt102\">" + msap.get(c).getDescripcion() + "</td>\n"
                                        + "                <td name=\"tdAlmacen102\">" + msap.get(c).getAlmacen() + "</td>\n"
                                        + "                <td><input type=\"text\" maxlength=\"13\" value=\"0.000\" name=\"bx102Prb\" class=\"bx101N\" id=\"bxPrb" + c + "\" onKeyPress=\"return soloNumeros(event)\"  onblur=\"this.value = checkDec(this.value, 3)\"   onKeyPress=\"return soloNumeros(event)\"></td>\n"
                                        + "                <td name=\"tdLote102\">" + msap.get(c).getNum_lote() + "</td>\n"
                                        + "                <td name=\"tdCantCa102\">" + msap.get(c).getCantidad_cancelada() + "</td>\n"
                                        + "                <td name=\"tdCanEnt102\">" + msap.get(c).getCantidad_unidad_medida_entrada() + "</td>\n"
                                        + "                <td name=\"tdUME102\">" + msap.get(c).getUnidad_medida_entrada() + "</td>\n"
                                        + "                <td name=\"tdCentro102\">" + msap.get(c).getCentro() + "</td>\n"
                                        + "                <td name=\"tdFecEnt102\"></td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td name=\"tdNumProv102\">" + msap.get(c).getNum_cuenta_proveedor() + "</td>\n"
                                        + "                <td name=\"tdNumDocCom102\">" + msap.get(c).getNum_pedido() + "</td>\n"
                                        + "                <td name=\"tdPosDoc102\">" + msap.get(c).getNum_posicion_doc_compras() + "</td>\n"
                                        + "                <td name=\"tdCeCo102\">" + msap.get(c).getCentro_coste() + "</td>\n"
                                        + "                <td name=\"tdOrd102\">" + msap.get(c).getNum_orden() + "</td>\n"
                                        + "                <td name=\"tdClaCos102\"></td>\n"
                                        + "                <td class=\"ocultar\" name=\"tdnumMov\">" + msap.get(c).getNum_doc_material() + "</td>\n"
                                        + "                <td class=\"ocultar\" name=\"tdPosMov\">" + msap.get(c).getPos_doc_compras() + "</td>\n"
                                        + "           </tr>");
                            }
                            for (int d = c; d <= 19; d++) {
                                out.println("<tr>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "           </tr>");
                            }
                            out.println("<tr>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">ADMON_PORTUARIA__INTEGRAL_DE_TOPO_S_Mas_Espacio</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "           </tr>");
                            out.print("</tbody>"
                                    + "          </table>");
                        } else {
                            out.println(1);
                        }
                    } else if (tipFol.equals("FSAM")) {
                        ArrayList<movimientos_detalle> md = ACC_DetallesDocMateriales.ObtenerInstancia().ObtenerMov102crea(NDocCom);
                        if (md.size() > 0) {
                            out.println("<table class=\"TablaCont\" id=\"TablaPedido\">\n"
                                    + "        <thead>\n"
                                    + "                <tr id=\"CabeceraTabla\">\n"
                                    + "                    <td>&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tdescripcion_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TAlmacen_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TPorDevolv_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TcantidadCan_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TUMB_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tcentro_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TfechaEntrega_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TTP_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TBSAR_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Tposicion_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TCentCos_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                                    + "                    <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                                    + "                </tr>\n"
                                    + "        </thead>\n"
                                    + "        <tbody>");
                            for (c = 0; c < md.size(); c++) {
                                out.println("<tr>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td name=\"tdMaterial102\">" + md.get(c).getNum_material() + "</td>\n"
                                        + "                <td name=\"tdtxt102\">" + md.get(c).getTexto_breve_material() + "</td>\n"
                                        + "                <td name=\"tdAlmacen102\">" + md.get(c).getAlmacen() + "</td>\n"
                                        + "                <td><input type=\"text\" maxlength=\"13\" value=\"0.000\" name=\"bx102Prb\" class=\"bx101N\" id=\"bxPrb" + c + "\" onKeyPress=\"return soloNumeros(event)\" onblur=\"this.value = checkDec(this.value, 3)\"  onKeyPress=\"return soloNumeros(event)\"></td>\n"
                                        + "                <td name=\"tdLote102\">" + md.get(c).getNum_lote() + "</td>\n"
                                        + "                <td name=\"tdCantCa102\">" + md.get(c).getCantidad_cancelada() + "</td>\n"
                                        + "                <td name=\"tdCanEnt102\">" + md.get(c).getCantidad1() + "</td>\n"
                                        + "                <td name=\"tdUME102\">" + md.get(c).getUnidad_medida_base() + "</td>\n"
                                        + "                <td name=\"tdCentro102\">" + md.get(c).getCentro() + "</td>\n"
                                        + "                <td name=\"tdFecEnt102\">" + md.get(c).getFecha() + "</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td name=\"tdNumProv102\">" + md.get(c).getNum_cuenta_proveedor() + "</td>\n"
                                        + "                <td name=\"tdNumDocCom102\">" + md.get(c).getNum_doc_compras() + "</td>\n"
                                        + "                <td name=\"tdPosDoc102\">" + md.get(c).getNum_posicion_doc_compras() + "</td>\n"
                                        + "                <td name=\"tdCeCo102\">" + md.get(c).getCentro_coste() + "</td>\n"
                                        + "                <td name=\"tdOrd102\">" + md.get(c).getNum_orden() + "</td>\n"
                                        + "                <td name=\"tdClaCos102\">" + md.get(c).getClase_coste() + "</td>\n"
                                        + "                <td class=\"ocultar\" name=\"tdnumMov\">" + md.get(c).getFolio_sam() + "</td>\n"
                                        + "                <td class=\"ocultar\" name=\"tdPosMov\">" + md.get(c).getIndice_registro_no_valido() + "</td>\n"
                                        + "           </tr>");
                            }
                            for (int d = c; d <= 19; d++) {
                                out.println("<tr>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "                <td>&nbsp;</td>\n"
                                        + "           </tr>");
                            }
                            out.println("<tr>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">ADMON_PORTUARIA__INTEGRAL_DE_TOPO_S_Mas_Espacio</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "           </tr>");
                            out.print("</tbody>"
                                    + "          </table>");

                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(1);
                    }

                    break;
                case "VentanaModal201202":
                case "VentanaModal201201":

                    LinkedList<pedido_detalle> p = ACC_Pedidos.ObtenerInstancia().Ingresa200(pp, us);
                    out.println("<table class=\"TablaCont\" id=\"TablaMov\">\n"
                            + "                                    <tr id=\"CabeceraTabla\">\n"
                            + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TUM_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TstockEspecial_MOM") + "</td>\n"
                            + "                                        <td class=\"ajustar\">" + po.getProperty("etiqueta.Ttextobreve_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDeCostos_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosPed_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Treserva_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosRes_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TMaterialDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.GralCentroAll") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.MovAlmac") + "</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                    </tr> \n"
                            + "                                    <tbody>");
                    for (c = 0; c < p.size(); c++) {
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" name=\"Pedidos\" value=\"" + p.get(c).getNum_posicion() + "\"></td>"
                                + "<td name=\"mmmat\">" + p.get(c).getMaterial() + "</td>"
                                + "<td name=\"mmprr\">" + p.get(c).getPor_recibir() + "</td>"
                                + "<td name=\"mmumb\">" + p.get(c).getUnidad_medida_base() + "</td>"
                                + "<td name=\"mmnlt\">" + p.get(c).getNuevo_lote() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td class=\"ajustar\" name=\"mmdsc\">" + p.get(c).getDescripcion() + "</td>"
                                + "<td>" + p.get(c).getNum_orden() + "</td>"
                                + "<td name=\"mmcec\">" + p.get(c).getCentro_coste() + "</td>"
                                + "<td>" + p.get(c).getClase_coste() + "</td>"
                                + "<td name=\"mmped\">" + p.get(c).getPedido() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"//proveedor
                                + "<td>&nbsp;</td>"
                                + "<td name=\"mmctr\">" + p.get(c).getCentro() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td class=\"ocultar\" name=\"tdPoss\">" + p.get(c).getNum_posicion() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmidx\">" + (Integer.parseInt(c + "") + 1) + "</td>"
                                + "<td class=\"ocultar\" name=\"mmPosR\">" + p.get(c).getNum_posicion_solped() + "</td>"
                                + "</tr>");
                    }
                    for (int d = c; d <= 14; d++) {
                        out.println("<tr>"
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
                    break;
                case "VentanaModal261261":
                case "VentanaModal261262":
                    LinkedList<pedido_detalle> o = ACC_Pedidos.ObtenerInstancia().Ingresa260(pp, us, Doculot, Docposlot);
                    out.println("<table class=\"TablaCont\" id=\"TablaMov\">\n"
                            + "                                    <tr id=\"CabeceraTabla\">\n"
                            + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TUM_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TstockEspecial_MOM") + "</td>\n"
                            + "                                        <td class=\"ajustar\">" + po.getProperty("etiqueta.Ttextobreve_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDeCostos_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosPed_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Treserva_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosRes_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TMaterialDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TAlmacenDestino_MOM") + "</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                    </tr> \n"
                            + "                                    <tbody>");
                    if (o.size() > 0) {
                        for (c = 0; c < o.size(); c++) {
                            String StockE = "";
                            if (!o.get(c).getNum_solped().isEmpty()) {
                                StockE = "E";
                            }
                            out.println("<tr>"
                                    + "<td><input type=\"checkbox\" name=\"Pedidos\" value=\"" + o.get(c).getNum_posicion() + "\"></td>"
                                    + "<td name=\"mmmat\">" + o.get(c).getMaterial() + "</td>"
                                    + "<td name=\"mmprr\">" + o.get(c).getPor_recibir() + "</td>"
                                    + "<td name=\"mmumb\">" + o.get(c).getUnidad_medida_base() + "</td>"
                                    + "<td name=\"mmnlt\">" + o.get(c).getNuevo_lote() + "</td>"
                                    + "<td name=\"mmStEs\">" + StockE + "</td>"
                                    + "<td class=\"ajustar\" name=\"mmdsc\">" + o.get(c).getDescripcion() + "</td>"
                                    + "<td name=\"mmnord\">" + o.get(c).getNum_orden() + "</td>"
                                    + "<td>" + o.get(c).getCentro_coste() + "</td>"
                                    + "<td>" + o.get(c).getClase_coste() + "</td>"
                                    + "<td name=\"mmped\">" + o.get(c).getPedido() + "</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"//proveedor
                                    + "<td>&nbsp;</td>"
                                    + "<td name=\"mmctr\">" + o.get(c).getCentro() + "</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td class=\"ocultar\" name=\"mmpedid\">" + o.get(c).getNum_solped() + "</td>"
                                    + "<td class=\"ocultar\" name=\"mmPosPed\">" + o.get(c).getNum_registro_info() + "</td>"
                                    + "<td class=\"ocultar\" name=\"tdPoss\">" + o.get(c).getNum_posicion() + "</td>"
                                    + "<td class=\"ocultar\" name=\"mmidx\">" + (Integer.parseInt(c + "") + 1) + "</td>"
                                    + "<td class=\"ocultar\" name=\"mmPosR\">" + o.get(c).getNum_posicion_solped() + "</td>"
                                    + "</tr>");
                        }
                        for (int d = c; d <= 14; d++) {
                            out.println("<tr>"
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

                    } else {
                        for (int d = 0; d <= 14; d++) {
                            out.println("<tr>"
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
                    }

                    break;
                case "VentanaModal303303":
                case "VentanaModal303305":

                    LinkedList<pedido_detalle> px = ACC_Pedidos.ObtenerInstancia().Ingresa300(pp, CDestino, us);
                    out.println("<table class=\"TablaCont\" id=\"TablaMov\">\n"
                            + "                                    <tr id=\"CabeceraTabla\">\n"
                            + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TUM_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TstockEspecial_MOM") + "</td>\n"
                            + "                                        <td class=\"ajustar\">" + po.getProperty("etiqueta.Ttextobreve_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDeCostos_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosPed_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Treserva_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosRes_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TMaterialDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TAlmacenDestino_MOM") + "</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                    </tr> \n"
                            + "                                    <tbody>");
                    for (c = 0; c < px.size(); c++) {
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" name=\"Pedidos\" value=\"" + px.get(c).getNum_posicion() + "\"></td>"
                                + "<td name=\"mmmat\">" + px.get(c).getMaterial() + "</td>"
                                + "<td name=\"mmprr\">" + px.get(c).getPor_recibir() + "</td>"
                                + "<td name=\"mmumb\">" + px.get(c).getUnidad_medida_base() + "</td>"
                                + "<td name=\"mmnlt\">" + px.get(c).getNuevo_lote() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td class=\"ajustar\" name=\"mmdsc\">" + px.get(c).getDescripcion() + "</td>"
                                + "<td>" + px.get(c).getNum_orden() + "</td>"
                                + "<td name=\"mmcec\">" + px.get(c).getCentro_coste() + "</td>"
                                + "<td>" + px.get(c).getClase_coste() + "</td>"
                                + "<td name=\"mmped\">" + px.get(c).getPedido() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"//proveedor
                                + "<td>&nbsp;</td>"
                                + "<td name=\"mmctr\">" + px.get(c).getCentro() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td class=\"ocultar\" name=\"tdPos\">" + px.get(c).getNum_posicion() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmidx\">" + (Integer.parseInt(c + "") + 1) + "</td>"
                                + "</tr>");
                    }
                    for (int d = c; d <= 14; d++) {
                        out.println("<tr>"
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
                    break;
                case "VentanaModal311312":
                case "VentanaModal311311":

                    LinkedList<pedido_detalle> p3 = ACC_Pedidos.ObtenerInstancia().Ingresa310(pp, us, Doculot, Docposlot);
                    out.println("<table class=\"TablaCont\" id=\"TablaMov\">\n"
                            + "                                    <tr id=\"CabeceraTabla\">\n"
                            + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TUM_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TstockEspecial_MOM") + "</td>\n"
                            + "                                        <td class=\"ajustar\">" + po.getProperty("etiqueta.Ttextobreve_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDeCostos_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosPed_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Treserva_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosRes_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TMaterialDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TAlmacenDestino_MOM") + "</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                    </tr> \n"
                            + "                                    <tbody>");
                    for (c = 0; c < p3.size(); c++) {
                        String StockE = "";
                        if (!p3.get(c).getNum_solped().isEmpty()) {
                            StockE = "E";
                        }
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" name=\"Pedidos\" value=\"" + p3.get(c).getNum_posicion() + "\"></td>" + "<td name=\"mmmat\">" + p3.get(c).getMaterial() + "</td>"
                                + "<td name=\"mmprr\">" + p3.get(c).getPor_recibir() + "</td>"
                                + "<td name=\"mmumb\">" + p3.get(c).getUnidad_medida_base() + "</td>"
                                + "<td name=\"mmnlt\">" + p3.get(c).getNuevo_lote() + "</td>"
                                + "<td name=\"mmStEs\">" + StockE + "</td>"
                                + "<td class=\"ajustar\" name=\"mmdsc\">" + p3.get(c).getDescripcion() + "</td>"
                                + "<td>" + p3.get(c).getNum_orden() + "</td>"
                                + "<td name=\"mmcec\">" + p3.get(c).getCentro_coste() + "</td>"
                                + "<td>" + p3.get(c).getClase_coste() + "</td>"
                                + "<td name=\"mmpedid\">" + p3.get(c).getNum_solped() + "</td>"
                                + "<td name=\"mmPosPed\">" + p3.get(c).getNum_posicion_solped() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"//proveedor
                                + "<td>&nbsp;</td>"
                                + "<td name=\"mmctr\">" + p3.get(c).getCentro() + "</td>"
                                + "<td name=\"mmalm\">" + p3.get(c).getAlmacen() + "</td>"
                                + "<td class=\"ocultar\" name=\"tdPoss\">" + p3.get(c).getNum_posicion() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmidx\">" + (Integer.parseInt(c + "") + 1) + "</td>"
                                + "<td class=\"ocultar\" name=\"mmPosR\">" + p3.get(c).getNum_posicion_solped() + "</td>"
                                + "</tr>");
                    }
                    for (int d = c; d <= 14; d++) {
                        out.println("<tr>"
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
                    break;
                case "LimpiarPpal":
                case "LimpiarPpal101":
                case "LimpiarPpal102":
                case "LimpiarPpal201":
                case "LimpiarPpal202":
                case "LimpiarPpal261":
                case "LimpiarPpal301":
                case "LimpiarPpal311":
                case "LimpiarPpal313":
                case "LimpiarPpal315":
                case "LimpiarPpal305":
                    out.println("<table class=\"TablaCont\" id=\"TablaMov\">\n"
                            + "                                    <tr id=\"CabeceraTabla\">\n"
                            + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TUM_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TstockEspecial_MOM") + "</td>\n"
                            + "                                        <td class=\"ajustar\">" + po.getProperty("etiqueta.Ttextobreve_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDeCostos_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosPed_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Treserva_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosRes_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TMaterialDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TAlmacenDestino_MOM") + "</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                    </tr> \n"
                            + "                                    <tbody>");
                    for (int d = 0; d <= 14; d++) {
                        out.println("<tr>"
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
                    String q = "DELETE FROM pedidos_detalle_temp WHERE Usuario='" + perso + "'";
                    Consultas.ObtenerInstancia().ExecuteQuery(q);
                    break;
                    
            }
        }
    }

    public String Num(String data) {
        String nf = "";
        if (data.indexOf(".") != -1) {
            String[] n = data.split("\\.");
            String n1 = n[0];
            String n2 = n[1];

            if (n2.length() == 1) {
                n2 = n2 + "00";
                nf = n1 + "." + n2;
            } else if (n2.length() == 2) {
                n2 = n2 + "0";
                nf = n1 + "." + n2;
            } else {
                return data;
            }
        } else {
            nf = data += ".000";
        }

        return nf;
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
