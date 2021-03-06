/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Almacenes;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Pedidos;
import AccesoDatos.ACC_Reservas;
import AccesoDatos.ACC_Stock;
import Entidades.almacenes;
import Entidades.centros;
import Entidades.componentesPP;
import Entidades.materiales;
import Entidades.pedido_detalle;
import Entidades.reserva_posiciones_crea;
import Entidades.stock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

/**
 *
 * @author panda
 */
@WebServlet(name = "peticionMovMateriales2", urlPatterns = {"/peticionMovMateriales2"})
public class peticionMovMateriales2 extends HttpServlet {

    /**
     * Processes requests for b57oth HTTP <code>GET</code> and <code>POST</code>
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
            String Materi = request.getParameter("Material");
            String Descri = request.getParameter("Descripcion");
            String UnidME = request.getParameter("UnidadMedida");
            String Cantid = request.getParameter("Cantidad");
            String ClaseM = request.getParameter("ClaseMov");
            String Centro = request.getParameter("Centro");
            String Almace = request.getParameter("Almacen");
            String Lote = request.getParameter("Lote");
            String Docume = request.getParameter("Documento");
            String Posici = request.getParameter("Posicion");
            String IndPos = request.getParameter("Indice");
            String us = request.getParameter("IpData");
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("Usuario");
            Properties po = new Properties();
            po.load(getServletContext().getResourceAsStream("/WEB-INF/LanguageES.properties"));

            ////RESERVAS
            String NReservaR = request.getParameter("NReservaR");
            String PosicionR = request.getParameter("PosicionR");
            String MaterialR = request.getParameter("MaterialR");
            String DescripcionR = request.getParameter("DescripcionR");
            String CantidadR = request.getParameter("CantidadR");
            String CentroR = request.getParameter("CentroR");
            String AlmacenR = request.getParameter("AlmacenR");
            String ClaseMovR = request.getParameter("ClaMovR");
            switch (Accion) {
                case "ConsultaMaterial":
                    ArrayList<materiales> mat = ACC_Material.ObtenerInstancia().ConsultaMaterialesMov(Materi, Descri, Cantid, ClaseM, Centro, Almace);
                    if (mat.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mat.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionarMCNuevo('" + mat.get(i).getMaterial() + "','" + mat.get(i).getDescripcion() + "', '" + mat.get(i).getUnidad_medida() + "', '" + ClaseM + "');\">");
                            out.println("<td style=\"width:25%;\">" + mat.get(i).getMaterial() + "</td>");
                            out.println("<td style=\"width:65%; text-align: left\">" + mat.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaLotes":
                    ArrayList<stock> st = ACC_Stock.ObtenerInstancia().ConsultaLoteStockNuevo(Materi, Centro, Almace, ClaseM);
                    if (st.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < st.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionarMCLoteNuevo('" + st.get(i).getLote() + "','" + st.get(i).getNum_doc() + "', '" + st.get(i).getPos_doc() + "', '" + ClaseM + "','" + st.get(i).getStocklibre_utilizacion() + "');\">");
                            out.println("<td style=\"width: 25%;\">" + st.get(i).getMaterial() + "</td>");
                            out.println("<td style=\"width: 25%;\">" + st.get(i).getLote() + "</td>");
                            out.println("<td style=\"width: 20%;\">" + st.get(i).getStocklibre_utilizacion() + "</td>");
                            out.println("<td style=\"width: 20%;\">" + st.get(i).getNum_doc() + "</td>");
                            out.println("<td style=\"width: 10%;\">" + st.get(i).getPos_doc() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaAlmacen":
                    ArrayList<almacenes> alm = ACC_Almacenes.ObtenerInstancia().ConsultaAllAlmacene(Centro);
                    if (alm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < alm.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionarMCAlmNuevo('" + alm.get(i).getId_almacen() + "', '" + ClaseM + "');\">");
                            out.println("<td>" + alm.get(i).getCentro() + "</td>");
                            out.println("<td>" + alm.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + alm.get(i).getNombre_alamcen() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaCentro":
                    ArrayList<centros> equA = ACC_Centro.ObtenerInstancia().ConsultaCentros();
                    if (equA.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < equA.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionarMCCentroNuevo('" + equA.get(i).getCentro() + "', '" + ClaseM + "');\">");
                            out.println("<td>" + equA.get(i).getCentro() + "</td>");
                            out.println("<td>" + equA.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarTablaMovs":
                    String Ctro = "";
                    String Value = "";
                    String dis = "";
                    String dis2 = "";
                    String dis3 = "";
                    if (ClaseM.trim().equals("301")) {
                        Value = "1800";
                        dis = "disabled";
                    }
                    if (ClaseM.trim().equals("311")) {
                        dis2 = "disabled";
                        Ctro = Centro;
                    }
                    if (ClaseM.trim().equals("313")) {
                        Ctro = Centro;
                        dis2 = "disabled";
                    }
                    if (ClaseM.trim().equals("315")) {
                        dis = "disabled";
                        dis2 = "disabled";
                        dis3 = "";
                    }
                    out.println("<table id=\"TabBody301\">");
                    out.println("<tbody>");
                    for (int i = 0; i < 12; i++) {
                        out.println("<tr>");
                        out.println("<td><input type=\"checkbox\" name=\"" + ClaseM + "chkbox\" value=\"" + i + "\"/></td>");
                        out.println("<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdMater" + i + "\" name=\"" + ClaseM + "MaterTD\" onfocus=\"MostrarMatch('tdMater', 'MCMaterial', '" + i + "')\" maxlength=\"40\" style=\"text-transform: uppercase\"/><button id=\"" + ClaseM + "MCMaterial" + i + "\" onclick=\"AbrirMatchElemtnosGrid('VentanaModalMaterialNuevo', 'handleMatNuevo', 'BuscarParaMaterialNuevo', 'ConsultaTablaMaterialNuevo', '" + i + "', 'busMatNuevo', 'BusDesMatNuevo', 'numAciertosNuevo')\" name=\"" + ClaseM + "matchMaterial\" class='BtnMatchIconGrid'></button></td>");
                        out.println("<td><input type=\"text\" class=\"tdSMatch\" id=\"" + ClaseM + "tdDescr" + i + "\" name=\"" + ClaseM + "DesciTD\" onfocus=\"QuitarMatch()\" readOnly/></td>");
                        out.println("<td><input type=\"text\" class=\"tdSMatch\" id=\"" + ClaseM + "tdUmedi" + i + "\" name=\"" + ClaseM + "UMediTD\" onfocus=\"QuitarMatch()\" readOnly/></td>");
                        out.println("<td><input type=\"text\" class=\"tdSMatch\" id=\"" + ClaseM + "tdCanti" + i + "\" name=\"" + ClaseM + "CantiTD\" onblur=\"this.value = checkDec(this.value, 3)\" onKeyPress=\"return soloNumeros(event)\" onfocus=\"QuitarMatch()\"/></td>");
                        out.println("<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdLotes" + i + "\" name=\"" + ClaseM + "LotesTD\" onfocus=\"MostrarMatch('tdLotes', 'MCLote', '" + i + "')\" maxlength=\"10\" style=\"text-transform: uppercase\" " + dis3 + "/><input hidden type=\"text\" id=\"" + ClaseM + "tdDoc" + i + "\" name=\"" + ClaseM + "DocTD\"/><input hidden type=\"text\" id=\"" + ClaseM + "tdPos" + i + "\" name=\"" + ClaseM + "PosTD\"/><button id=\"" + ClaseM + "MCLote" + i + "\" onclick=\"ConsultaLotesNBuevo('" + i + "');\" name=\"" + ClaseM + "matchLote\" class='BtnMatchIconGrid'></button></td>");
                        out.println("<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdCentr" + i + "\" name=\"" + ClaseM + "CentrTD\" onfocus=\"MostrarMatch('tdCentr', 'MCCen', '" + i + "')\" maxlength=\"4\" style=\"text-transform: uppercase\" value=\"" + Ctro + "\" " + dis2 + "/><button id=\"" + ClaseM + "MCCen" + i + "\" onclick=\"ConsultaCentroNuevo('" + i + "')\" name=\"" + ClaseM + "matchCen\" class='BtnMatchIconGrid'></button></td>");
                        out.println("<td><input type=\"text\" class=\"tdCMatch\" id=\"" + ClaseM + "tdAlmac" + i + "\" name=\"" + ClaseM + "AlmacTD\" onfocus=\"MostrarMatch('tdAlmac', 'MCAlm', '" + i + "')\" maxlength=\"4\" style=\"text-transform: uppercase\" value=\"" + Value + "\" " + dis + "/><button id=\"" + ClaseM + "MCAlm" + i + "\" onclick=\"ConsultaAlmaNBuevo('" + i + "')\" name=\"" + ClaseM + "matchCen\" class='BtnMatchIconGrid'></button></td>");
                        out.println("</tr>");
                    }
                    out.println("<tr id=\"TempRod\" class=\"ocultar\"><td>0000</td><td>000000000000000</td><td>000000000000000000000000000000</td><td>0000000</td><td>00000000000000</td><td>000000000000000</td><td>00000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CargarInfoMaterial":
                    materiales min = ACC_Material.ObtenerInstancia().GetInfoMateriales(Materi, ClaseM);
                    if (min.getMaterial().trim().equals("")) {
                        out.println(0);
                    } else {
                        JSONArray j = new JSONArray();
                        j.add(min.getMateria());
                        j.add(min.getDescripcion());
                        j.add(min.getUnidad_medida());
                        out.println(j);
                    }
                    break;
                case "ValidarSujetoLote":
                    int xh = ACC_Material.ObtenerInstancia().ValidaSujetoLote(Materi);
                    out.println(xh);
                    break;
                case "ValidarExistencia":
                    stock sk = ACC_Stock.ObtenerInstancia().VerificarExistenciaMovis(Materi, Centro, Almace, Lote, Docume, Posici);
                    if (sk.getMaterial().trim().equals("")) {
                        out.println(0);
                    } else {
                        out.println(sk.getStocklibre_utilizacion());
                    }
                    break;
                case "ExistenciaDestino":
                    int exides = ACC_Centro.ObtenerInstancia().CentroDestinoT(Centro, Materi, Almace, "");
                    out.println(exides);
                    break;
                case "VentanaModalMovsnuevos":
                    pedido_detalle pd = new pedido_detalle();
                    pd.setNum_posicion(IndPos);
                    pd.setMaterial(Materi);
                    pd.setDescripcion(Descri);
                    pd.setUnidad_medida_base(UnidME);
                    pd.setCentro(Centro);
                    pd.setAlmacen(Almace);
                    pd.setLote(Lote);
                    pd.setCantidad(Cantid);
                    pd.setTipo_mov(ClaseM);
                    pd.setNum_solped(Docume);
                    pd.setNum_posicion_solped(Posici);
                    ArrayList<pedido_detalle> pmovs = ACC_Pedidos.ObtenerInstancia().Ingresa30131315(pd, us);
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
                    int c;
                    for (c = 0; c < pmovs.size(); c++) {
                        String StockE = "";
                        if (!pmovs.get(c).getNum_solped().isEmpty()) {
                            StockE = "E";
                        }
                        out.println("<tr>\n"
                                + "<td><input type=\"checkbox\" name=\"Pedidos\" value=\"" + pmovs.get(c).getNum_posicion() + "\"></td>"
                                + "<td name=\"mmmat\">" + pmovs.get(c).getMaterial() + "</td>"
                                + "<td name=\"mmprr\">" + pmovs.get(c).getPor_recibir() + "</td>"
                                + "<td name=\"mmumb\">" + pmovs.get(c).getUnidad_medida_base() + "</td>"
                                + "<td name=\"mmnlt\">" + pmovs.get(c).getNuevo_lote() + "</td>"
                                + "<td name=\"mmStEs\">" + StockE + "</td>"
                                + "<td class=\"ajustar\" name=\"mmdsc\">" + pmovs.get(c).getDescripcion() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td name=\"mmped\">" + pmovs.get(c).getNum_solped() + "</td>"
                                + "<td name=\"mmnpe\">" + pmovs.get(c).getNum_posicion_solped() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td name=\"mmCentro\">" + pmovs.get(c).getCentro() + "</td>"
                                + "<td name=\"mmAlmace\">" + pmovs.get(c).getAlmacen() + "</td>"
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
                case "CargarStockTransferencia":
                    stock st1 = ACC_Stock.ObtenerInstancia().CargarTransfereancia313(Materi, Centro, Almace);
                    JSONArray j3 = new JSONArray();
                    if (st1.getMaterial().equals("")) {
                        j3.add("");
                        j3.add("");
                        j3.add("");
                        j3.add("");
                        j3.add("");
                    } else {
                        j3.add(st1.getMaterial());
                        j3.add(st1.getDescripcion());
                        j3.add(st1.getUnidad_medida());
                        j3.add(st1.getLote());
                        j3.add(st1.getStock_traslado());
                    }
                    out.println(j3);
                    break;
                case "ValidarCantidMaterial315":
                    String stk = ACC_Stock.ObtenerInstancia().ValidarCantidadMaterial(Materi, Centro, Almace, Lote, Docume, Posici);
                    out.println(stk);
                    break;
                case "PedidoPos":
                    //Solo se va a usar porque tiene pedido(documento), posición
                    componentesPP cc = ACC_Stock.ObtenerInstancia().getPedPos(Lote);
                    JSONArray jc = new JSONArray();
                    jc.add(cc.getPedido());
                    jc.add(cc.getPosicion());
                    out.println(jc);
                    break;
                case "ConsultaReserva":
                    ArrayList<reserva_posiciones_crea> res = ACC_Reservas.ObtenerInstancia().CargarReservaMC(CentroR, AlmacenR, ClaseMovR, NReservaR, PosicionR, MaterialR, DescripcionR);
                    if (res.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < res.size(); i++) {
                            out.println("<tr ondblclick=\"SelectReserM('" + res.get(i).getFolio_sap() + "','" + res.get(i).getFolio_sam() + "', '" + res.get(i).getAlmacen() + "');\">");
                            out.println("<td style=\"width: 15%\">" + res.get(i).getFolio_sap() + "</td>");
                            out.println("<td style=\"width: 15%\">" + res.get(i).getFolio_sam() + "</td>");
                            out.println("<td style=\"width: 10%\">" + res.get(i).getPosicion_reserva() + "</td>");
                            out.println("<td style=\"width: 20%\">" + res.get(i).getNum_material() + "</td>");
                            out.println("<td style=\"width: 30%; text-align:left;\">" + res.get(i).getTexto_posicion() + "</td>");
                            out.println("<td style=\"width: 10%\">" + res.get(i).getAlmacen() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "VentanaModalReservasTratar":
                    pedido_detalle pdr = new pedido_detalle();
                    pdr.setNum_posicion(request.getParameter("indiceRes"));
                    pdr.setMaterial(request.getParameter("ReservaMaterial"));
                    pdr.setDescripcion(request.getParameter("ReservaDescripcion"));
                    pdr.setUnidad_medida_base(request.getParameter("ReservaUnidadM"));
                    pdr.setLote(request.getParameter("ReservaLote"));
                    pdr.setCantidad(request.getParameter("ReservaCantidad"));
                    pdr.setTipo_mov(request.getParameter("ReservaCMov"));
                    pdr.setNum_solped(request.getParameter("ReservaDoc"));
                    pdr.setNum_posicion_solped(request.getParameter("ReservaPosicion"));
                    pdr.setCentro_coste(request.getParameter("ReservaCCosto"));
                    pdr.setNum_orden(request.getParameter("ReservaNOrden"));
                    pdr.setAlmacen(request.getParameter("ReservaAlmDes"));
                    pdr.setLote_proveedor(request.getParameter("ReservaCanTomada"));
                    pdr.setDenominacion_clase_doc_compras(request.getParameter("ReservaCanTotal"));
                    ArrayList<pedido_detalle> pres = ACC_Pedidos.ObtenerInstancia().IngresaTratarReservas(pdr, us);
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
                    int c1;
                    for (c1 = 0; c1 < pres.size(); c1++) {
                        out.println("<tr>\n"
                                + "<td><input type=\"checkbox\" name=\"Pedidos\" value=\"" + pres.get(c1).getNum_posicion() + "\"></td>"
                                + "<td name=\"mmmat\">" + pres.get(c1).getMaterial() + "</td>"
                                + "<td name=\"mmprr\">" + pres.get(c1).getPor_recibir() + "</td>"
                                + "<td name=\"mmumb\">" + pres.get(c1).getUnidad_medida_base() + "</td>"
                                + "<td name=\"mmnlt\">" + pres.get(c1).getNuevo_lote() + "</td>"
                                + "<td></td>"
                                + "<td class=\"ajustar\" name=\"mmdsc\">" + pres.get(c1).getDescripcion() + "</td>"
                                + "<td name=\"mmNOrden\">" + pres.get(c1).getNum_orden() + "</td>"
                                + "<td name=\"mmcCosto\">" + pres.get(c1).getCentro_coste() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td name=\"mmped\">" + pres.get(c1).getNum_solped() + "</td>"
                                + "<td name=\"mmnpe\">" + pres.get(c1).getNum_posicion_solped() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td</td>"
                                + "<td name=\"mmAlmace\">" + pres.get(c1).getAlmacen() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmCantTomada\">" + pres.get(c1).getLote_proveedor() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmCantTotal\">" + pres.get(c1).getDenominacion_clase_doc_compras() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmidx\">" + (Integer.parseInt(c1 + "") + 1) + "</td>"
                                + "</tr>");
                    }
                    for (int d = c1; d <= 14; d++) {
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
