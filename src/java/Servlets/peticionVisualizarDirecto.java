/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CabeceraDocMateriales;
import AccesoDatos.ACC_DetallesDocMateriales;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Pedidos;
import AccesoDatos.ACC_Proveedor;
import AccesoDatos.ACC_Stock;
import AccesoDatos.CallWS;
import AccesoDatos.Consultas;
import Entidades.DatosMaterialLista;
import Entidades.cabecera_doc_materiales;
import Entidades.detalles_doc_materiales;
import Entidades.detalles_posiciones_doc_material;
import Entidades.folios;
import Entidades.movimientos_detalle_crea;
import Entidades.reporte_ivent;
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
@WebServlet(name = "peticionVisualizarDirecto", urlPatterns = {"/peticionVisualizarDirecto"})
public class peticionVisualizarDirecto extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String fol = request.getParameter("FOLIO");
            String tip = request.getParameter("Tipo");
            String Pos = request.getParameter("Pos");
            String pedido = request.getParameter("pedido");
            String material = request.getParameter("mat");
            String centro = request.getParameter("ctr");
            String almacen = request.getParameter("alm");
            HttpSession us = request.getSession();
            String idioma = (String) us.getAttribute("Idioma");
            String User = (String) us.getAttribute("Usuario");
            String des = "descripcion_" + idioma;
            String Clase = request.getParameter("CLAS");
            String Decum = request.getParameter("DOC");
            String Canti = request.getParameter("CANT");
            String Folio = request.getParameter("FOLIO");
            String FContable = Consultas.ObtenerInstancia().ObtenerFechaContableMov();
            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("MO");
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            String FecC = request.getParameter("v1");
            String Posi = request.getParameter("v2");
            String Cent = request.getParameter("v3");
            String Alma = request.getParameter("v4");
            String txtC = request.getParameter("v5");
            String nota = request.getParameter("v6");
            String cart = request.getParameter("v7");
            String Mate = request.getParameter("v8");
            String Desc = request.getParameter("v9");
            String Cant = request.getParameter("v10");
            String UM = request.getParameter("v11");
            String clas = request.getParameter("v12");
            String lote = request.getParameter("v13");
            String Rese = request.getParameter("v14");
            String PosR = request.getParameter("v15");
            String AlmD = request.getParameter("v16");
            String fl = "MO" + fo.getFolioActual();
            Consultas con = new Consultas();
            switch (Accion) {
                case "ConsultaDocumentos":
                    ArrayList<cabecera_doc_materiales> Arr = ACC_CabeceraDocMateriales.ObtenerInstancia().MCDocumentos(Clase, Decum);
                    if (Arr.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (Canti.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(Canti); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + Arr.get(i).getNum_doc_material() + "','" + Arr.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + Arr.get(i).getClase_movimiento() + "</td>");
                                out.println("<td>" + Arr.get(i).getNum_doc_material() + "</td>");
                                out.println("<td>" + Arr.get(i).getFolio_sam() + "</td>");
                            }
                        } else {
                            for (int j = 0; j < Arr.size(); j++) {
                                out.println("<tr ondblclick=\"seleccionar('" + Arr.get(j).getNum_doc_material() + "','" + Arr.get(j).getFolio_sam() + "')\">");
                                out.println("<td>" + Arr.get(j).getClase_movimiento() + "</td>");
                                out.println("<td>" + Arr.get(j).getNum_doc_material() + "</td>");
                                out.println("<td>" + Arr.get(j).getFolio_sam() + "</td>");
                            }
                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarDoc":
                    int SAP = ACC_CabeceraDocMateriales.ObtenerInstancia().ValidarDocMaterialesSAP(fol);
                    int SAM = ACC_CabeceraDocMateriales.ObtenerInstancia().ValidarDocMaterialesSAM(fol);
                    out.println(SAP + "," + SAM);
                    break;
                case "DatosCabeceraCrea":
                    JSONArray j = new JSONArray();
                    if (tip.equals("P")) {
                        cabecera_doc_materiales cd = ACC_CabeceraDocMateriales.ObtenerInstancia().CargarDatosCabeceraSAP(fol);
                        j.add(cd.getNum_doc_material());
                        j.add(cd.getFolio_sam());
                        j.add(cd.getEjercicio_doc_material());
                        j.add(con.DateFormat(cd.getFecha_doc_en_doc()));
                        j.add(con.DateFormat(cd.getFecha_contabilizacion_doc()));
                        j.add(cd.getNum_nota_entrega_externa());
                        j.add(cd.getNum_carta_porte_entrada_mercancias());
                        j.add(cd.getTexto_cabecera_doc());
                        j.add(cd.getNum_cuenta_proveedor_acreedor());
                        j.add(cd.getNombre());
                    } else if (tip.equals("M")) {
                        cabecera_doc_materiales cd1 = ACC_CabeceraDocMateriales.ObtenerInstancia().CargarDatosCabeceraSAM(fol);
                        j.add("");
                        j.add(cd1.getFolio_sam());
                        j.add("");
                        j.add(con.DateFormat(cd1.getFecha_doc_en_doc()));
                        j.add("");
                        j.add(cd1.getNum_nota_entrega_externa());
                        j.add(cd1.getNum_carta_porte_entrada_mercancias());
                        j.add(cd1.getTexto_cabecera_doc());
                        j.add(cd1.getNum_cuenta_proveedor_acreedor());
                        j.add(cd1.getNombre());
                    } else {
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                    }
                    out.println(j);
                    break;
                case "DatostablaDoc":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (tip.equals("P")) {
                        int i;
                        ArrayList<detalles_doc_materiales> d = ACC_DetallesDocMateriales.ObtenerInstancia().CargarTablaDocSAP(fol, des);
                        if (d.size() > 0) {
                            for (i = 0; i < d.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + d.get(i).getNum_doc_material() + "</td>");
                                out.println("<td name=\"tdPosicion\">" + d.get(i).getNum_posicion_doc_compras() + "</td>");
                                out.println("<td name=\"tdLote\">" + d.get(i).getNum_lote() + "</td>");
                                out.println("<td name=\"tdClase\">" + d.get(i).getClase_movimiento() + "</td>");
                                out.println("<td>" + d.get(i).getNum_pedido() + "</td>");
                                out.println("<td name=\"tdMaterial\">" + d.get(i).getNum_material() + "</td>");
                                out.println("<td name=\"tdDescripcion\">" + d.get(i).getDescripcion() + "</td>");
                                out.println("<td name=\"tdCantidad\">" + d.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                                out.println("<td name=\"tdUM\">" + d.get(i).getUnidad_medida_entrada() + "</td>");
                                out.println("<td>" + d.get(i).getCentro_coste() + "</td>");
                                out.println("<td>" + d.get(i).getNum_orden() + "</td>");
                                out.println("<td>" + d.get(i).getSociedad() + "</td>");
                                out.println("<td>" + d.get(i).getIndicador_stock_especial() + "</td>");
                                out.println("<td name=\"tdCentro\">" + d.get(i).getCentro() + "</td>");
                                out.println("<td name=\"tdAlmacen\">" + d.get(i).getAlmacen() + "</td>");
                                if (d.get(0).getClase_movimiento().equals("311") && d.get(0).getAlmacen_destino().equals("TR01")) {
                                    out.println("<td name=\"tdAlmacenD\">" + d.get(i).getDestinatario_mercancias() + "</td>");
                                } else {
                                    out.println("<td>" + d.get(i).getAlmacen_destino() + "</td>");
                                }
                                out.println("<td></td>");
                                out.println("<td class=\"ocultar\" name=\"tdReserva\"></td>");
                                out.println("<td class=\" ocultar\" name=\"tdPosReserva\"></td>");
                                out.println("</tr>");
                            }
                            for (int n = i; n < 6; n++) {
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
                                        + "</tr>");
                            }
                        } else {
                            for (int n = 0; n < 6; n++) {
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
                                        + "</tr>");
                            }
                        }
                    } else if (tip.equals("M")) {
                        int ii;
                        ArrayList<movimientos_detalle_crea> md = ACC_DetallesDocMateriales.ObtenerInstancia().CargarTablaDocSAM(fol);
                        if (md.size() > 0) {
                            for (ii = 0; ii < md.size(); ii++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + md.get(ii).getNum_doc_material() + "</td>");
                                out.println("<td name=\"tdPosicion\">" + md.get(ii).getPosicion() + "</td>");
                                out.println("<td name=\"tdLote\">" + md.get(ii).getNum_lote() + "</td>");
                                out.println("<td name=\"tdClase\">" + md.get(ii).getClase_movimiento() + "</td>");
                                out.println("<td>" + md.get(ii).getNum_doc_compras() + "</td>");
                                out.println("<td name=\"tdMaterial\">" + md.get(ii).getNum_material() + "</td>");
                                out.println("<td name=\"tdDescripcion\">" + md.get(ii).getTexto_breve_material() + "</td>");
                                out.println("<td name=\"tdCantidad\">" + md.get(ii).getCantidad_unidad_medida_entrada() + "</td>");
                                out.println("<td name=\"tdUM\">" + md.get(ii).getUnidad_medida_entrada() + "</td>");
                                out.println("<td>" + md.get(ii).getCentro_coste() + "</td>");
                                out.println("<td>" + md.get(ii).getNum_orden() + "</td>");
                                out.println("<td></td>");
                                out.println("<td>" + md.get(ii).getIndicador_stock_especial() + "</td>");
                                out.println("<td name=\"tdCentro\">" + md.get(ii).getCentro() + "</td>");
                                out.println("<td name=\"tdAlmacen\">" + md.get(ii).getAlmacen() + "</td>");
                                if (md.get(0).getClase_movimiento().equals("311") && md.get(0).getAlmacen_receptor().equals("TR01")) {
                                    out.println("<td name=\"tdAlmacenD\">" + md.get(ii).getNum_lote_proveedor() + "</td>");
                                } else {
                                    out.println("<td>" + md.get(ii).getAlmacen_receptor() + "</td>");
                                }
                                out.println("<td></td>");
                                out.println("<td class=\"ocultar\" name=\"tdReserva\"></td>");
                                out.println("<td class=\" ocultar\" name=\"tdPosReserva\"></td>");
                                out.println("</tr>");
                            }
                            for (int n = ii; n < 6; n++) {
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
                                        + "</tr>");
                            }
                        } else {
                            for (int n = 0; n < 6; n++) {
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
                                        + "</tr>");
                            }
                        }
                    } else {
                        for (int n = 0; n < 6; n++) {
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
                                    + "</tr>");
                        }
                    }
                    out.println("                <tr class=\"ocultar\">\n"
                            + "                                            <td>0000</td>\n"
                            + "                                            <td>0000000000000000000000</td>\n"
                            + "                                            <td>00000000000000</td>\n"
                            + "                                            <td>0000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000</td>\n"
                            + "                                            <td>0000000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000000000000000</td>\n"
                            + "                                            <td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                            + "                                            <td>0000000000000000</td>\n"
                            + "                                            <td>0000000000000</td>\n"
                            + "                                            <td>00000000000000000</td>\n"
                            + "                                            <td>00000000000000000</td>\n"
                            + "                                            <td>00000000000000000</td>\n"
                            + "                                            <td>00000000000000000</td>\n"
                            + "                                            <td>0000000000000000000</td>\n"
                            + "                                            <td>00000000000000000000</td>\n"
                            + "                                            <td>000000000000000000000</td>\n"
                            + "                                            <td>000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ListPos":
                    out.println("<select id=\"SelectPos\">");
                    out.println("<option></option>");
                    if (tip.equals("P")) {
                        ArrayList<detalles_doc_materiales> de = ACC_DetallesDocMateriales.ObtenerInstancia().CargarTablaDocSAP(fol, des);
                        for (int c = 0; c < de.size(); c++) {
                            out.println("<option>" + de.get(c).getNum_posicion_doc_compras() + "</option>");
                        }
                    } else if (tip.equals("M")) {
                        ArrayList<movimientos_detalle_crea> mde = ACC_DetallesDocMateriales.ObtenerInstancia().CargarTablaDocSAM(fol);
                        for (int c = 0; c < mde.size(); c++) {
                            out.println("<option>" + mde.get(c).getPosicion() + "</option>");
                        }
                    }
                    out.println("</select>");
                    break;
                case "CargarPos":
                    JSONArray ja = new JSONArray();
                    if (tip.equals("P")) {
                        detalles_doc_materiales d1 = ACC_DetallesDocMateriales.ObtenerInstancia().ObtenerPosicionDetalle(fol, Pos, des);
                        String nombrep = ACC_Proveedor.ObtenerInstancia().ObtenerNombreProvedor(d1.getNum_cuenta_proveedor());
                        String nombrep2 = ACC_Proveedor.ObtenerInstancia().ObtenerNombreProvedor(d1.getProveedor_recibe_entrega());
                        ja.add(d1.getNum_material());
                        ja.add(d1.getDescripcion());
                        ja.add(d1.getNum_material_utilizado_proveedor());
                        ja.add(d1.getGrupo_articulos());
                        ja.add(d1.getClase_movimiento());
                        ja.add(d1.getIndicador_stock_especial());
                        ja.add(d1.getIndicador_debe_haber());
                        ja.add(d1.getNum_cuenta_proveedor());
                        ja.add(d1.getCentro());
                        ja.add(d1.getNombre());
                        ja.add(d1.getAlmacen());
                        ja.add(d1.getDenominacion_almacen());
                        ja.add(d1.getAlmacen_destino());
                        ja.add(d1.getPuesto_descarga());
                        ja.add(d1.getNum_pedido());
                        ja.add(d1.getNum_lote());
                        ja.add(d1.getProveedor_recibe_entrega());
                        ja.add(d1.getNum_lote_proveedor());
                        ja.add(nombrep);
                        ja.add(nombrep2);
                    } else if (tip.equals("M")) {
                        detalles_doc_materiales d11 = ACC_DetallesDocMateriales.ObtenerInstancia().ObtenerPosicionDetalleSAM(fol, Pos);
                        String nombrem = ACC_Proveedor.ObtenerInstancia().ObtenerNombreProvedor(d11.getNum_cuenta_proveedor());
                        String nombrem2 = ACC_Proveedor.ObtenerInstancia().ObtenerNombreProvedor(d11.getProveedor_recibe_entrega());
                        ja.add(d11.getNum_material());
                        ja.add(d11.getDescripcion());
                        ja.add(d11.getNum_material_utilizado_proveedor());
                        ja.add(d11.getGrupo_articulos());
                        ja.add(d11.getClase_movimiento());
                        ja.add(d11.getIndicador_stock_especial());
                        ja.add(d11.getIndicador_debe_haber());
                        ja.add(d11.getNum_cuenta_proveedor());
                        ja.add(d11.getCentro());
                        ja.add(d11.getNombre());
                        ja.add(d11.getAlmacen());
                        ja.add(d11.getDenominacion_almacen());
                        ja.add(d11.getAlmacen_destino());
                        ja.add(d11.getPuesto_descarga());
                        ja.add(d11.getNum_pedido());
                        ja.add(d11.getNum_lote());
                        ja.add(d11.getProveedor_recibe_entrega());
                        ja.add(d11.getNum_lote_proveedor());
                        ja.add(nombrem);
                        ja.add(nombrem2);
                    } else {
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                        ja.add("");
                    }
                    out.println(ja);
                    break;
                case "getProv":
                    JSONArray pr = new JSONArray();
                    LinkedList<String> p = ACC_Pedidos.ObtenerInstancia().ObtenerProv(pedido);
                    pr.add(p.get(0));
                    pr.add(p.get(1));
                    out.println(pr);
                    break;
                case "getSAM":
                    JSONArray sam = new JSONArray();
                    LinkedList<String> s = ACC_Pedidos.ObtenerInstancia().ObtenerSAM(material, centro, almacen);
                    String ps = ACC_Pedidos.ObtenerInstancia().obtenerPos(fol, Pos);
                    sam.add(s.get(0));
                    sam.add(s.get(1));
                    sam.add(s.get(2));
                    sam.add(s.get(3));
                    sam.add(ps);
                    out.println(sam);
                    break;
                case "Verificar311":
                    int ok = ACC_CabeceraDocMateriales.ObtenerInstancia().Verfi311(Folio, User);
                    out.println(ok);
                    break;
                case "VerificarMov311":
                    int yes = ACC_CabeceraDocMateriales.ObtenerInstancia().ValidarMov311(Folio);
                    out.println(yes);
                    break;
                case "ValPosMov311":
                    int ye = ACC_CabeceraDocMateriales.ObtenerInstancia().ValidarPosMov(Folio);
                    out.println(ye);
                    break;
                case "GuardarCabecera312":
                    String f122 = "";
                    if (FecC.length() > 0) {
                        f122 = FecC;
                    } else {
                        f122 = FContable;
                    }
                    Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", Cent, "TR01", "", cart, txtC, "", "", "", "", nota, "", "", "", "", f122, User);
                    Consultas.ObtenerInstancia().ActualizarRpCancelacion(Folio, fl,  "Cancelado");
                    break;
                case "GuardarPosiciones312":
                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, horaActual, fechaActual, Posi, "", clas, "", "", lote, UM, "", "", "", "", "", Cant, "TR01", "", "", "", "", Desc, Mate, "", "", Rese, PosR, "", "", Alma, "", Cent, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                    String stc1 = ACC_Stock.ObtenerInstancia().getCantidad311(Mate, Alma, Cent, lote);
                    String stc2 = ACC_Stock.ObtenerInstancia().getCantidad311(Mate, "TR01", Cent, lote);
                    Double fstc1 = Double.parseDouble(stc1) + Double.parseDouble(Cant);
                    Double fstc2 = Double.parseDouble(stc2) - Double.parseDouble(Cant);
                    ACC_Stock.ObtenerInstancia().Actualizarstock311(Mate, Alma, Cent, lote, Num(String.valueOf(fstc1)));
                    ACC_Stock.ObtenerInstancia().Actualizarstock311(Mate, "TR01", Cent, lote, Num(String.valueOf(fstc2)));
                    break;
                case "GuardarCabecera311":
                    String f12 = "";
                    if (FecC.length() > 0) {
                        f12 = FecC;
                    } else if (FContable.length() > 0) {
                        f12 = FContable;
                    } else {
                        f12 = fechaActual;
                    }
                    Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", Cent, "TR01", "", cart, txtC, "", "", "", "", nota, "", "", "", "", f12, User);
                    Consultas.ObtenerInstancia().ActualizarIndReporteIvent(Folio, fl);
                    break;
                case "GuardarPosiciones311":
                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, horaActual, fechaActual, Posi, "", clas, "", "", lote, UM, "", "", "", "", "", Cant, "TR01", "", "", "", "", Desc, Mate, "", "", Rese, PosR, "", "", AlmD, "", Cent, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                    String stc = ACC_Stock.ObtenerInstancia().getCantidad311(Mate, AlmD, Cent, lote);
                    String tr0 = ACC_Stock.ObtenerInstancia().getCantidad311(Mate, "TR01", Cent, lote);
                    Double fstc = Double.parseDouble(stc) + Double.parseDouble(Cant);
                    Double fst2 = Double.parseDouble(tr0) - Double.parseDouble(Cant);
                    ACC_Stock.ObtenerInstancia().Actualizarstock311(Mate, AlmD, Cent, lote, Num(String.valueOf(fstc)));
                    ACC_Stock.ObtenerInstancia().Actualizarstock311(Mate, "TR01", Cent, lote, Num(String.valueOf(fst2)));
                    break;
                case "ConsumirWS311":
                    ArrayList<reporte_ivent> re = Consultas.ObtenerInstancia().CargarReportesIvent(Folio);
                    if (re.size() > 0) {
                        for (int i = 0; i < re.size(); i++) {
                            String msg = CallWS.ObtenerInstancia().ConsumirWS311(Folio, re.get(i).getMaterial(), re.get(i).getDescripcion(), re.get(i).getAlmacen(), Cent, re.get(i).getCantidad());
                            Consultas.ObtenerInstancia().ActualizarRpoIvent(Folio, re.get(i).getPosicion(), re.get(i).getMaterial(), re.get(i).getAlmacen(), msg);
                        }
                    }
                    break;
                case "ChecarPosiWS":
                    ArrayList<reporte_ivent> rew = Consultas.ObtenerInstancia().CargarReportesIvent(Folio);
                    if (rew.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int j1 = 0; j1 < rew.size(); j1++) {
                            out.println("<tr>");
                            out.println("<td>" + rew.get(j1).getMaterial() + "</td>");
                            out.println("<td>" + rew.get(j1).getDescripcion() + "</td>");
                            out.println("<td>" + rew.get(j1).getAlmacen() + "</td>");
                            out.println("<td>" + rew.get(j1).getCantidad() + "</td>");
                            out.println("<td>" + rew.get(j1).getMensaje() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ChecarEnvio":
                    ArrayList<reporte_ivent> rew2 = Consultas.ObtenerInstancia().CargarRep2(Folio);
                    out.println(rew2.size());
                    break;
                case "Verificarmensaj":
                    ArrayList<reporte_ivent> r2 = Consultas.ObtenerInstancia().VerificarMensaje311(Folio);
                    out.println(r2.size());
                    break;
                case "ValidarRechazo":
                    int as = ACC_CabeceraDocMateriales.ObtenerInstancia().VerRechazo(Folio);
                    out.println(as);
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
