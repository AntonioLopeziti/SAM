/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Cabecera_ordenes_crea;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Ordenes_pp_notificaciones;
import AccesoDatos.ACC_Pp_operaciones_noti;
import AccesoDatos.ACC_BOMEquipos;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Pm_operaciones_notificaciones;
import AccesoDatos.ACC_Zebra;
import AccesoDatos.Consultas;
import AccesoDatos.EnvioDatosEtiqueta;
import Entidades.ControlListaOrdenes;
import Entidades.cabecera_ordenes_crea;
import Entidades.ordenes_pp_notificaciones;
import Entidades.pp_operaciones_noti;
import Entidades.ListaMtrl;
import Entidades.folios;
import Entidades.materiales;
import Entidades.materiales_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import Entidades.PlanPP;
import Entidades.Zebra_noti_PT;
import Entidades.cab_MovNotificacion;
import Entidades.componentesPP;
import Entidades.pp01_notifi;
import Entidades.pm03_1_notificaciones;
import Entidades.pos_MovNotificacion;
import Entidades.pp03_1_notificaciones;
import Entidades.pp03_2_notificaciones;
import Entidades.pp_03_3_notificaciones;
import Entidades.servicios_ordenes_crea;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jhonatan
 */
@WebServlet(name = "PeticionNotificacionesOrdenesSAMPP", urlPatterns = {"/PeticionNotificacionesOrdenesSAMPP"})
public class PeticionNotificacionesOrdenesSAMPP extends HttpServlet {

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
            HttpSession session = request.getSession();
            String Idioma = (String) session.getAttribute("Idioma");
            String USUARIO = (String) session.getAttribute("Usuario");
            String ord = request.getParameter("ord");
            String acc = request.getParameter("acc");

            //PeticionOperacion
            //String ord = request.getParameter("ord");
            String oper = request.getParameter("oper");
            //LlenarTabMax
            String ope = request.getParameter("ope");
            //Lista de Materiales
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");
            String v7 = request.getParameter("v7");
            String v8 = request.getParameter("v8");
            String v9 = request.getParameter("v9");
            String v10 = request.getParameter("v10");
            String v11 = request.getParameter("v11");
            String v12 = request.getParameter("v12");
            String v13 = request.getParameter("v13");
            String v14 = request.getParameter("v14");
            //Liberar Ordenes
            String operacion = request.getParameter("ope");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String orden = request.getParameter("ord");
            String stats = request.getParameter("stat");
            String usu = request.getParameter("usu");
            String notlote22 = request.getParameter("notlote22");
            String matera = request.getParameter("matw");
            String centr = request.getParameter("centr");
            String mat = request.getParameter("mat");
            String lot = request.getParameter("lot");
            String eq = request.getParameter("eq");
            String ulm = request.getParameter("ulm");
            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            folios folioActual = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("PP");
            folios xx = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("XX");
            double ccnt = 0.00;
            String fol = "ES";

            ////// ParametrosEtiqueta
            String CLIENTE = request.getParameter("CLIENTE");
            String OPERACION = request.getParameter("OPERACION");
            String ORDEN = request.getParameter("ORDEN");
            String SAM = request.getParameter("SAM");
            String LOTE = request.getParameter("LOTE");
            String CENTRO = request.getParameter("CENTRO");
            String ANCHO = request.getParameter("ANCHO");
            String CANTIDAD = request.getParameter("CANTIDAD");
            String UM = request.getParameter("UM");
            String DESCRIPCION = request.getParameter("DESCRIPCION");
            String MATERIAL = request.getParameter("MATERIAL");
            String CLASE = request.getParameter("CLASE");
            switch (acc) {
                case "guardaCabecera":
                    String fl = "PP" + folioActual.getFolioActual();
                    AccesoDatos.ACC_Ordenes_pp_notificaciones.ObtenerInstancia().CabeceraInsertaMovNot(fl, v1, v2, horaActual, fechaActual, v3, v4, v5, v6, v7);
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("XX", xx.getFolioActual());
                    out.println(fl);
                    break;
                case "guardaPos":
                    String fll = "PP" + folioActual.getFolioActual();
                    DecimalFormat df = new DecimalFormat("#.000");
                    String fmt;

                    if (v8.equals("101") || v8.equals("531")) {
                        ccnt = ACC_Material.ObtenerInstancia().StockLibre(v3, v6, v7) + Double.parseDouble(v4);
                        fmt = (ccnt >= 1) ? df.format(ccnt) : "0" + df.format(ccnt);
                        ACC_Material.ObtenerInstancia().ActualizaInv101(v3, v6, v7, fmt);
                        System.out.println(ccnt);
                    }
                    if (v8.equals("261")) {
                        if (v10.equals("E")) {
                            ccnt = ACC_Material.ObtenerInstancia().StockLibreEE(v3, v6, v7, v11, v12) - Double.parseDouble(v4);
                            fmt = (ccnt >= 1) ? df.format(ccnt) : "0" + df.format(ccnt);
                            ACC_Material.ObtenerInstancia().ActualizaInv261EE(v3, v6, v7, fmt, v11, v12);
                            System.out.println(ccnt);
                        } else {
                            ccnt = ACC_Material.ObtenerInstancia().StockLibre(v3, v6, v7) - Double.parseDouble(v4);
                            fmt = (ccnt >= 1) ? df.format(ccnt) : "0" + df.format(ccnt);
                            ACC_Material.ObtenerInstancia().ActualizaInv261(v3, v6, v7, fmt);
                            System.out.println(ccnt);
                        }
                    }
                    AccesoDatos.ACC_Ordenes_pp_notificaciones.ObtenerInstancia().PosicionInsertaMovNot(fll, v1, horaActual, fechaActual, v2, v3, v4, v5, v6, v7, v8, v9, v10, v13, v14);
                    break;
                case "PonerCentro":
                    PlanPP cent = AccesoDatos.ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenerCntroOrden(ord);
                    String centro = cent.getCentro();
                    out.println(centro);
                    break;
                case "checarOrdenPP":
                    if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().COMPORdenNOTPP(ord) == true) {
                        //SAP                        
                        ArrayList<ControlListaOrdenes> lo = new ArrayList<>();
                        lo = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().FiltroOrdenesLib();
                        for (ControlListaOrdenes cnt : lo) {
                            String name = cnt.getNum_orden();
                            if (name.equals(ord)) {
                                out.println(1);
                            } else {
                                out.println(0);
                            }
                        }

                    } else {
                        out.println(1);
                    }
                    break;
                case "ChecarStatusOrdenOpe":
                    PlanPP paln = AccesoDatos.ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenerStatusOrdenSAPPP(ord);
//                    out.println("<input type='text' id ='nosta' value='" + paln.getStatus() + "' />");
                    out.println(paln.getStatus());

//                    ordenes_pp_notificaciones pl = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenStatusCNPMNOTPP(ord);
                    break;
                case "ChecarMaterialOp":
                    PlanPP pmate = AccesoDatos.ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenerStatusOrdenSAPPP(ord);
//                    out.println("<input type='text' id ='nosta' value='" + paln.getStatus() + "' />");
                    out.println(pmate.getTexto_material());

//                    ordenes_pp_notificaciones pl = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenStatusCNPMNOTPP(ord);
                    break;
                case "LlenarTabMax":
                    LinkedList<pp_operaciones_noti> tb = ACC_Pp_operaciones_noti.ObtenerInstancia().TABGRNOTPMNotPP(ord, ope);
                    String checa = "";
                    String checa1 = "";
                    for (int i = 0; i < tb.size(); i++) {
                        String val = tb.get(i).getIndicador_valor_prede_traba_relevante();
                        String val2 = tb.get(i).getId_objeto_recurso();
                        if ("X".equals(val)) {
                            checa = "checked";
                        } else {
                            checa = "";
                        }
                        if ("X".equals(val2)) {
                            checa1 = "checked";
                        } else {
                            checa1 = "";
                        }
                        out.println("<tr>");
                        out.println("<td> <input type=\"radio\" class=\"che\" value='" + tb.get(i).getClave_control() + "," + tb.get(i).getNum_operacion() + "," + tb.get(i).getCentro() + "'  name=\"checkbo\" /></td>");
                        out.println("<td><input type=\"checkbox\" id='nf" + i + "'  name=\"che\" " + checa + " disabled  /></td>");
                        out.println("<td>" + tb.get(i).getNum_operacion() + "</td>");
                        out.println("<td>" + tb.get(i).getClave_control() + "</td>");
                        out.println("<td>" + tb.get(i).getTrabajo_operacion() + "</td>");
                        out.println("<td name=\"cntx\">" + tb.get(i).getCentro() + "</td>");
                        out.println("<td>" + tb.get(i).getTexto_breve_operacion() + "</td>");
                        out.println("<td>1.00</td>");
                        out.println("<td>" + tb.get(i).getDuracion_operacion_normal() + "</td>");
                        out.println("<td>" + tb.get(i).getActividad_ya_notificada01() + "</td>");
                        out.println("<td>" + tb.get(i).getUnidad_duracion_normal() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr><td><input type=\"radio\" class=\"che\" id=\"checkbox3\" name=\"checkbo\" value=\"val4\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox4\" name=\"checkbo\" value=\"val5\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox5\" name=\"checkbo\" value=\"val6\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    ");
                    break;
                case "ListaMaterialNotificacionesC":
                    int v = 0;
                    ArrayList<ListaMtrl> lm = ACC_BOMEquipos.ObtenerInstancia().ObtenerLMNotificacionesCreaPP(v1, v2);
                    out.println("<table id=\"TabBody3\">\n"
                            + "<tbody>");
                    for (ListaMtrl p : lm) {
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" name=\"CKlmNotiC\" value=\"" + v + "\"></td>"
                                + "<td name=\"lm1\" id=\"ll1" + v + "\">" + p.getMaterial() + "</td>"
                                + "<td name=\"lm2\" id=\"ll2" + v + "\">" + p.getPiezaFabricante() + "</td>"
                                + "<td name=\"lm3\" id=\"ll3" + v + "\">" + p.getDescripcion() + "</td>"
                                + "<td name=\"lm4\" id=\"ll4" + v + "\">" + p.getLote() + "</td>"
                                + "<td name=\"lm5\" id=\"ll5" + v + "\">" + p.getStock() + "</td>"
                                + "<td name=\"lm7\" id=\"ll7" + v + "\" hidden>" + p.getCentro() + "</td>"
                                + "<td name=\"lm8\" id=\"ll8" + v + "\" hidden>" + p.getAlmacen() + "</td>"
                                + "<td name=\"lm6\" id=\"ll6" + v + "\">" + p.getUm() + "</td>");
                        v++;
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>00</td>"
                            + "<td>00000000000000000000</td>"
                            + "<td>00000000000000000000</td>"
                            + "<td>000000000000000000000000000</td>"
                            + "<td>000000</td>"
                            + "<td>00000000</td>"
                            + "<td>00000</td>"
                            + "<td>00000</td>"
                            + "<td>00</td>"
                            + "</tr>"
                            + "</tbody>\n"
                            + "</table>");
                    break;
                case "DatosCab":
                    ordenes_pp_notificaciones opm = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtStatusCNPP(ord);
                    folios folSAM = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios(fol);
                    int NEfol = folSAM.getFolioActual();
                    ///////////////////////////////
                    String fsam1 = "ES" + folSAM.getFolioActual();
                    String condi = "ES";
                    if (ACC_Pp_operaciones_noti.ObtenerInstancia().InsertStatus_notificacionessapPP(fsam1, fecha, hora, stats, orden, opm.getCentro(), usu) == true) {
                        if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ordpmnotiActualPP(operacion, orden) == true) {
                            if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT(condi, NEfol) == true) {
                                out.println(0);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(1);
                    }
                    break;
//                case "ValidaOrdenesQM01":
//                    if (ACC_Pm_operaciones_notificaciones.ObtenerInstancia().ValidaQM01(orden)) {
//                        out.println(1);
//                    } else {
//                        out.println(0);
//                    }
//                    break;
                case "DatosCabSAM":

                    operaciones_ordenes_crea orpm = ACC_Orden.ObtenerInstancia().ObtFolODenNotPP(orden);
                    folios folSAM1 = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios(fol);
                    int NEfol1 = folSAM1.getFolioActual();
                    String fsam = "ES" + folSAM1.getFolioActual();
                    String condil = "ES";

                    if (ACC_Pp_operaciones_noti.ObtenerInstancia().InsertStatus_notificacionesPP(fsam, fecha, hora, stats, orden, orpm.getCentro(), usu) == true) {
                        if (ACC_Pp_operaciones_noti.ObtenerInstancia().updatEStatus_notificacionesPP(orden, operacion)) {
                            if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT(condil, NEfol1) == true) {
                                out.println(0);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(1);
                    }
                    break;

                case "CarTAbUNPP":
                    String chec = "";
                    LinkedList<operaciones_ordenes_crea> ttb = ACC_Orden.ObtenerInstancia().cargartablaoperacionescreaNOTIPP(ord, ope);
                    for (int i = 0; i < ttb.size(); i++) {
                        String val = ttb.get(i).getIndicador_valor_predeterminado_trabajo_relevante();
                        if ("X".equals(val)) {
                            chec = "checked";
                        } else {
                            chec = "";
                        }
                        out.println("<tr>");
                        out.println("<td> <input type=\"radio\" class=\"che\" value='" + ttb.get(i).getClave_control() + "," + ttb.get(i).getNum_operacion() + "," + ttb.get(i).getCentro() + "'  name=\"checkbo\" /></td>");
                        out.println("<td><input type=\"checkbox\" id='nf" + i + "'  name=\"che\" " + chec + " disabled  /></td>");
                        out.println("<td>" + ttb.get(i).getNum_operacion() + "</td>");
                        out.println("<td>" + ttb.get(i).getClave_control() + "</td>");
                        out.println("<td>" + ttb.get(i).getId_objeto_recurso() + "</td>");
                        out.println("<td name=\"cntx\">" + ttb.get(i).getCentro() + "</td>");
                        out.println("<td>" + ttb.get(i).getTexto_breve_operacion() + "</td>");
                        out.println("<td>" + ttb.get(i).getCantidad_base() + "</td>");
//                    out.println("<td>"+ttb.get(i).getUnidad_medida_operacion()+"</td>");
                        out.println("<td>" + ttb.get(i).getDuracion_operacion() + "</td>");
                        out.println("<td>" + ttb.get(i).getActividad_ya_notificada1() + "</td>");
                        out.println("<td>" + ttb.get(i).getUnidad_duracion_normal() + "</td>");
//                    out.println("<td>"+ttb.get(i).getTrabajo_operacion()+"</td>");
//                    out.println("<td>"+ttb.get(i).getActividad_ya_notificada2()+"</td>");
//                    out.println("<td>"+ttb.get(i).getUnidad_trabajo()+"</td>");
//                    out.println("<td>"+ttb.get(i).getUnidad_medida_actividad_notificar1()+"</td>");
//                    out.println("<td>"+ttb.get(i).getUnidad_medida_actividad_notificar2()+"</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr><td><input type=\"radio\" class=\"che\" id=\"checkbox3\" name=\"checkbo\" value=\"val4\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox4\" name=\"checkbo\" value=\"val5\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox5\" name=\"checkbo\" value=\"val6\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    ");
                    break;
                case "CarEQORDPP":
                    cabecera_ordenes_crea eqi = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().CargarDataCabPP(ord);
                    String ewqq = eqi.getEstatus();
                    out.println("<input type'text' id='Statusor' value='" + ewqq + "' />");
                    break;
                case "CabePP1":
                    operaciones_ordenes_crea equi = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().cargarTablaNoOperacionesCreaP3PP(ord, ope);
                    out.println("<input type'text' id='nspp12' value='" + ord + "' />");
                    out.println("<input type'text' id='npspp12' value='" + ope + "' />");
                    out.println("<input type'text' id='txbp12' value='" + equi.getTexto_breve_operacion() + "' />");
                    out.println("<input type'text' id='canbap12' value='" + equi.getCantidad_base() + "' />");
                    out.println("<input type'text' id='umpp12' value='" + equi.getUnidad_medida_operacion() + "' />");
                    out.println("<input type'text' maxlength=\"1\" id='ivptp12' value='" + equi.getIndicador_valor_predeterminado_trabajo_relevante() + "' />");
                    out.println("<input type'text' id='donp12' value='" + equi.getDuracion_operacion() + "' />");
                    out.println("<input type'text' id='udnp12' value='" + equi.getUnidad_duracion_normal() + "' />");
                    out.println("<input type'text' id='top12' value='" + equi.getTrabajo_operacion() + "' />");
                    out.println("<input type'text' id='utp12' value='" + equi.getUnidad_trabajo() + "' />");
                    out.println("<input type'text' id='aynp12' value='" + equi.getActividad_ya_notificada1() + "' />");
                    out.println("<input type'text' id='ayn2p12' value='" + equi.getActividad_ya_notificada2() + "' />");
                    break;
                case "TablasPP01MAtPP":
                    int con;
                    ArrayList<componentesPP> tno = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().MostraTABPM01NOPP(ord, v1, xx.getFolioActual() + "");
                    out.println("<table id=\"TabBody\">\n"
                            + "<tbody>");
                    for (con = 0; con < tno.size(); con++) {
                        String can = tno.get(con).getCantidad_restante();
                        if (tno.get(con).getCl_mov().equals("101")) {
                            can = tno.get(con).getCantidad2();
                        }
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" name=\"ckMovMer\" value=\"" + con + "\"></td>"
                                + "<td hidden><label name=\"tdDescripcion\" id=\"tdDes" + con + "\">" + tno.get(con).getDescripcion() + "</label></td>"
                                + "<td><label name=\"tdoperacion\" id=\"tdOpr" + con + "\">" + tno.get(con).getNum_operacion() + "</label></td>"
                                + "<td><label name=\"tdMaterial\" id=\"tdMat" + con + "\">" + tno.get(con).getMaterial() + "</label></td>"
                                + "<td><label id=\"tddmt" + con + "\">" + tno.get(con).getTxt_material() + "</label></td>"
                                + "<td><input type=\"text\" class=\"bxMed\" id=\"bxcnt" + con + "\" name=\"bxcantidad\" maxlength=\"11\" onfocus=\"btnloteHide()\" onblur=\"this.value = checkDecc(this.value, 3);\" value=\"" + can + "\">"
                                + "<input hidden type=\"text\" id=\"bxcntT" + con + "\" name=\"bxcantidadT\" value=\"" + tno.get(con).getCantidad() + "\">"
                                + "<input hidden type=\"text\" id=\"bxposM" + con + "\" name=\"bxlistaM\" value=\"" + tno.get(con).getPosListaM() + "\">"
                                + "<input hidden type=\"text\" id=\"bxEE" + con + "\" name=\"bxinvEE\" value=\"" + tno.get(con).getStock_especial() + "\">"
                                + "<input hidden type=\"text\" id=\"bxNped" + con + "\" name=\"bxNped\" value=\"" + tno.get(con).getPedido() + "\">"
                                + "<input hidden type=\"text\" id=\"bxNpos" + con + "\" name=\"bxNpos\" value=\"" + tno.get(con).getPosicion() + "\"></td>"
                                + "<td><label name=\"tdUnM\" id=\"tdUM" + con + "\">" + tno.get(con).getUm() + "</label></td>"
                                + "<td><label name=\"tdCentro\" id=\"tdCtr" + con + "\">" + tno.get(con).getCentro() + "</label></td>"
                                + "<td>" + tno.get(con).getAlmacen() + "</td>"
                                + "<td><input " + tno.get(con).getHidden() + " type=\"text\" class=\"bxMed\" id=\"bxLote" + con + "\" name=\"bxlote\" style=\"text-transform: uppercase;\" maxlength=\"10\" value=\"" + tno.get(con).getLote() + "\" onfocus=\"btnloteShow(" + con + ")\"></td>"
                                + "<td><button id=\"btnLot" + con + "\" class='BtnMatchIcon' name=\"btnShowLot\" onclick=\"btnLoteMatch(" + con + ")\"  hidden></button></td>"
                                + "<td><input type=\"text\" class=\"bxMed\" id=\"bxanc" + con + "\" " + tno.get(con).getDisabled() + " name=\"bxancho\" maxlength=\"10\" onfocus=\"btnloteHide()\" value=\"" + tno.get(con).getAncho() + "\"></td>"
                                + "<td><label name=\"tdClaseM\" id=\"tdCmov" + con + "\">" + tno.get(con).getCl_mov() + "</label></td>"
                                + "</tr>");
                    }
//                    for (int c1 = con; c1 < 20; c1++) {
//                        out.println("<tr>"
//                                + "<td>&nbsp;</td>"
//                                + "<td hidden>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "<td>&nbsp;</td>"
//                                + "</tr>");
//                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>000</td>"
                            + "<td hidden>000</td>"
                            + "<td>000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>00000000000000000000000000000000000000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>000</td>"
                            + "<td>0000000</td>"
                            + "<td>0000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>00</td>"
                            + "<td>000000000000</td>"
                            + "<td>0000000</td>"
                            + "</tr>"
                            + "</tbody>"
                            + "</table>");
//                    ACC_Folios.ObtenerIstancia().ActualizarFolio("XX", xx.getFolioActual());
                    break;
                case "TabOperacionesPP":
                    int opp = 0;
                    String status = "";
                    ArrayList<operaciones_ordenes_crea> opeO = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().MostrarTabOperaciones(ord);
                    out.println("<table id=\"TabBodyOpe\">\n"
                            + "<tbody>");
                    for (opp = 0; opp < opeO.size(); opp++) {
                        if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().statusoperacionIn(ord, opeO.get(opp).getNum_operacion())) {
                            status = "INIC";
                        } else {
                            status = opeO.get(opp).getStatus_orden();
                        }
                        String input = "";
                        String color = "";
                        if (status.equals("NOTP")) {
                            input = "<td></td>";
                            color = "style=\"background-color:#ffff33;\"";
                        } else {
                            if (status.equals("INIC")) {
                                input = "<td></td>";
                                color = "style=\"background-color:#06DE17;\"";
                            }
                            input = "<td><input onclick=\"verificarContenidoUs();\" type=\"radio\" name=\"ckOperPP\" value=\"" + opp + "\"></td>";
                        }
                        out.println("<tr " + color + ">"
                                + input
                                + "<td id=\"opeNumOrd" + opp + "\">" + opeO.get(opp).getNum_orden() + ""
                                + "<input type=\"text\" class=\"clStOrd2\" name=\"bxStOrd2\" value=\"" + status + "\" hidden></td>"
                                + "<input type=\"text\" name=\"bxStOrd\" value=\"" + opeO.get(opp).getStatus_orden() + "\" hidden></td>"
                                + "<td id=\"opeTxtB" + opp + "\">" + opeO.get(opp).getTexto_breve_operacion() + "</td>"
                                + "<td id=\"opeNumOpe" + opp + "\">" + opeO.get(opp).getNum_operacion() + "</td>"
                                + "<td id=\"opeTrabOpe" + opp + "\">" + opeO.get(opp).getTrabajo_operacion() + "</td>"
                                + "<td id=\"opeClavCon" + opp + "\">" + opeO.get(opp).getClave_control() + "</td>"
                                + "<td id=\"opeCantrc" + opp + "\">" + opeO.get(opp).getCantidad_rc() + "</td>"
                                + "<td id=\"opeUMrc" + opp + "\">" + opeO.get(opp).getUnidad_medida_rc() + "</td>"
                                + "<td id=\"opeCtr" + opp + "\">" + opeO.get(opp).getCentro() + "</td>"
                                + "</tr>");
                    }
                    for (int m = opp; m < 7; m++) {
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
                                + "</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>000</td>"
                            + "<td>00000000000</td>"
                            + "<td>00000000000000000000000000000000000000</td>"
                            + "<td>000000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>0000</td>"
                            + "<td>00000000</td>"
                            + "</tr>"
                            + "</tbody>"
                            + "</table>");
                    break;
                case "SujetoLote":
                    if (ACC_Material.ObtenerInstancia().sujetoLote(v1, v2)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "obtenerLote":
                    out.println(ACC_Material.ObtenerInstancia().obtenerLote(v1, v2, v3));
                    break;
                case "obtenerLoteE":
                    out.println(ACC_Material.ObtenerInstancia().obtenerLoteE(v1, v2, v3, v4, v5));
                    break;
                case "validaDatos101":
                    int c = ACC_Material.ObtenerInstancia().validaCantidad101(v2, v1);
                    out.println(c);
                    break;
                case "validaDatos261":
                    if (v7.equals("261")) {
                        int t = ACC_Material.ObtenerInstancia().validaCantidad261(v3, v4, v1, v2);
                        int e = ACC_Material.ObtenerInstancia().validalote261(v3, v4, v1);

                        out.println(t + "," + e);
                    } else {
                        out.println("1,1");
                    }
                    break;
                case "validaDatos261E":
                    if (v7.equals("261")) {
                        int tnn = ACC_Material.ObtenerInstancia().validaCantidad261E(v3, v4, v1, v2, v5, v6);
                        int enn = ACC_Material.ObtenerInstancia().validalote261E(v3, v4, v1, v5, v6);

                        out.println(tnn + "," + enn);
                    } else {
                        out.println("1,1");
                    }
                    break;
                case "DatosOrdenCnt":
                    componentesPP pt = ACC_Material.ObtenerInstancia().Cantidades_PT(v1);
                    out.println(pt.getCantidad() + "," + pt.getCantidad2() + "," + pt.getMaterial());
                    break;
                case "ActualizarFolioPP":
                    out.println("PP" + folioActual.getFolioActual());
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("PP", folioActual.getFolioActual());
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("XX", xx.getFolioActual());
                    break;
                case "TextoLargo":
                    out.println(ACC_Ordenes_pp_notificaciones.ObtenerInstancia().TextoLargoP(v1));
                    break;
                case "TextoLargo2":
                    out.println(ACC_Ordenes_pp_notificaciones.ObtenerInstancia().TextoLargoP2(v1));
                    break;
                case "TextoLargo3":
                    out.println(ACC_Ordenes_pp_notificaciones.ObtenerInstancia().TextoLargoP3(v1));
                    break;
                case "getUMoper":
                    out.println(ACC_Ordenes_pp_notificaciones.ObtenerInstancia().GetUMoper(v1));
                    break;
                case "getCentroUsr":
                    out.println(ACC_Ordenes_pp_notificaciones.ObtenerInstancia().GetCentroUsr(v1));
                    break;
                case "getFechaI":
                    out.println(ACC_Ordenes_pp_notificaciones.ObtenerInstancia().GetFIoper(v1, v2));
                    break;
                case "imprimePT":
                    Zebra_noti_PT z1 = ACC_Zebra.ObtenerInstancia().DatosFaltantesCabecera(ORDEN);
                    String PUESTOT = ACC_Zebra.ObtenerInstancia().DatosFaltantesPosiciones(ORDEN, OPERACION);
                    Zebra_noti_PT zb = new Zebra_noti_PT();
                    zb.setOrden(ORDEN);
                    zb.setPuesto_trabajo(PUESTOT);
                    zb.setFol_sam(SAM);
                    zb.setLote(LOTE);
                    zb.setCentro(CENTRO);
                    zb.setAncho(ANCHO);
                    zb.setFecha(fechaActual);
                    zb.setHora(horaActual);
                    zb.setCantidad(CANTIDAD);
                    zb.setUm(UM);
                    zb.setCliente(CLIENTE);
                    zb.setDescripcion(DESCRIPCION);
                    zb.setNro_material(MATERIAL);
                    zb.setRuta(z1.getRuta());
                    zb.setStock(z1.getStock());
                    zb.setUsuario(USUARIO);
                    zb.setClmovi(CLASE);
                    ACC_Zebra.ObtenerInstancia().guardaEtiquetaDB(zb);
                    String[] prop = ACC_Zebra.ObtenerInstancia().getImp(PUESTOT);
                    String Dir = prop[0];
                    String tipo = prop[1];
                    String[] pa = Dir.split("-");
                    String Ip = pa[0];
                    String Imp = pa[1];
                    String CodigoEnviar = "";
                    if (tipo.trim().equals("1")) {
                        CodigoEnviar = ACC_Zebra.ObtenerInstancia().ConvertCodeZebraTLP(zb);
                    } else {
                        CodigoEnviar = ACC_Zebra.ObtenerInstancia().ConvertCodeZebra(zb);
                    }
                    String env = CodigoEnviar + "<>" + Imp;
                    EnvioDatosEtiqueta en = new EnvioDatosEtiqueta();
                    String rs = en.EnviarDatosSocket(env, Ip);
                    out.println(Integer.parseInt(rs));
//
//                    Date date = new Date();
//                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//                    zb.setPuesto_trabajo(z2.getPuesto_trabajo());
//                    zb.setDescripcion(v3);//Cambiar a nuevo Campo
//                    zb.setFecha(dateFormat.format(date));
//                    zb.setHora(horaActual);
//                    zb.setAncho(v10);
//                    zb.setOrden(v1);
//                    zb.setLote(v4);
//                    zb.setCantidad(Double.parseDouble(v5) + "0");
////                    zb.setCantidad("999999.999");
//                    zb.setCliente(z1.getCliente());
//                    zb.setNro_material(v2);
//                    zb.setFol_sam(v7);
//                    zb.setCentro(v8);
//                    zb.setUm(v9);
//                    ACC_Zebra.ObtenerInstancia().PrintTargetPT(zb);
                    break;
                case "pp1prt1PP":
                    pp_operaciones_noti eqs = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().INPGRNOTPMNOTPP(ord, oper);
                    out.println("<input type'text' id='nspp12' value='" + ord + "' />");
                    out.println("<input type'text' id='npspp12' value='" + oper + "' />");
                    out.println("<input type'text' id='txbp12' value='" + eqs.getTexto_breve_operacion() + "' />");
                    out.println("<input type'text' id='canbap12' value='" + eqs.getCantidad_base() + "' />");
                    out.println("<input type'text' id='umpp12' value='" + eqs.getUnidad_medida_operacion() + "' />");
                    out.println("<input type'text' maxlength=\"1\" id='ivptp12' value='" + eqs.getIndicador_valor_prede_traba_relevante() + "' />");
                    out.println("<input type'text' id='donp12' value='" + eqs.getDuracion_operacion_normal() + "' />");
                    out.println("<input type'text' id='udnp12' value='" + eqs.getUnidad_duracion_normal() + "' />");
                    out.println("<input type'text' id='top12' value='" + eqs.getTrabajo_operacion() + "' />");
                    out.println("<input type'text' id='utp12' value='" + eqs.getUnidad_trabajo() + "' />");
                    out.println("<input type'text' id='aynp12' value='" + eqs.getActividad_ya_notificada01() + "' />");
                    out.println("<input type'text' id='ayn2p12' value='" + eqs.getActividad_ya_notificada02() + "' />");
                    break;
                case "pp1prt3PP":
                    LinkedList<pp01_notifi> tn = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ShowDatPP1PP(ord, ope);
                    if (tn.size() == 0) {
                        for (int i = 0; i < 50; i++) {
                            out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><div style='width:195px;'><input type='text' name='arre' id=\"matab1" + i + "\" onclick=\"mosboton('" + i + "');\"/><button id=\"matmat1" + i + "\" onclick=\"VentModalmat('matab1" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td><td><div style='width:195px;'><input type='text' id=\"lotabp1" + i + "\" onclick=\"mosbotLot('" + i + "');\" /><button id=\"matlot1" + i + "\" onclick=\"VentModalLote('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td><td><input type='number' min='0' id=\"cumtabp1" + i + "\" name=\"cumtabp1\" /></td><td>&nbsp;</td><td>&nbsp;</td><td id=\"cein" + i + "\">&nbsp;</td><td id=\"unmin" + i + "\">&nbsp;</td><td id=\"almin" + i + "\" >&nbsp;</td><td id=\"Texde" + i + "\">&nbsp;</td></tr>");
                        }
                    } else {
                        for (int i = 0; i < tn.size(); i++) {
                            out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td>" + tn.get(i).getNum_reserva_nece_secundarias() + "</td>");
                            out.println("<td>" + tn.get(i).getNum_posicion_reserva_nece_secundaria() + "</td>");
                            out.println("<td><div style='width:195px;'><input type = 'text' id=\"matab1" + i + "\" onclick=\"mosboton('" + i + "');\" value=\"" + tn.get(i).getMaterial() + "\" /><button id=\"matmat1" + i + "\" onclick=\"VentModalmat('matab1" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td>");
                            out.println("<td><div style='width:195px;'><input type = 'text' id=\"lotabp1" + i + "\"  value=\"" + tn.get(i).getLote() + "\"' onclick=\"mosbotLot('" + i + "');\" /><button id=\"matlot1" + i + "\" onclick=\"VentModalLote('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td>");
                            out.println("<td><input type = 'number' id=\"cumtabp1" + i + "\" min='0' value=\"" + tn.get(i).getCantidad_unidad_medida_entrada() + "\" name=\"cumtabp1\" /></td>");
                            out.println("<td>" + tn.get(i).getCantidad_necesaria() + "</td>");
                            out.println("<td>" + tn.get(i).getCantidad_tomada() + "</td>");
                            out.println("<td id=\"cein" + i + "\">" + tn.get(i).getCentro() + "</td>");
                            out.println("<td id=\"unmin" + i + "\" >" + tn.get(i).getUnidad_medida_base() + "</td>");
                            out.println("<td id=\"almin" + i + "\">" + tn.get(i).getAlmacen() + "</td>");
                            out.println("<td id=\"Texde" + i + "\">" + tn.get(i).getTexto_posicion() + "</td>");
                            out.println("</tr>");
                        }

                        for (int la = 49; la >= tn.size(); la--) {

                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><div style='width:195px;'><input type = 'text' id=\"matab1" + la + "\" onclick=\"mosboton('" + la + "');\"  /><button id=\"matmat1" + la + "\" onclick=\"VentModalmat('matab1" + la + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td>");
                            out.println("<td><div style='width:195px;'><input type='text' id=\"lotabp1" + la + "\" onclick=\"mosbotLot('" + la + "');\" /><button id=\"matlot1" + la + "\" onclick=\"VentModalLote('" + la + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td>");
                            out.println("<td><input type = 'number' id=\"cumtabp1" + la + "\" min='0' name=\"cumtabp1\" /></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td id=\"cein" + la + "\">&nbsp;</td>");
                            out.println("<td id=\"unmin" + la + "\">&nbsp;</td>");
                            out.println("<td id=\"almin" + la + "\">&nbsp;</td>");
                            out.println("<td id=\"Texde" + la + "\">&nbsp;</td>");
                            out.println("</tr>");
                        }

                    }
                    break;
                case "POn1P3SAMPP":
                    operaciones_ordenes_crea eps = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().cartabopecrP3PP(ord, ope);

                    out.println("<input type'text' id='nspp32' value='' />");
                    out.println("<input type'text' id='npspp32' value='" + eps.getNum_posicion_solped__orden() + "' />");
                    out.println("<input type'text' id='prep32' value='" + eps.getPrecio() + "' />");
                    out.println("<input type'text' id='clmop32' value='" + eps.getClave_moneda() + "' />");
                    out.println("<input type'text' id='cabap32' value='" + eps.getCantidad_base2() + "' />");
                    out.println("<input type'text' id='grarp32' value='" + eps.getGrupo_articulos() + "' />");
                    out.println("<input type'text' id='gcate32' value='" + eps.getGrupo_compras_actividad_trabajo_externa() + "' />");
                    out.println("<input type'text' id='ocop32' value='" + eps.getOrganizacion_compras() + "' />");
                    out.println("<input type'text' id='provp32' value='" + eps.getNum_cuenta_proveedor() + "' />");
                    out.println("<input type'text' id='solp32' value='" + eps.getSolicitante() + "' />");
                    break;
                case "POn2P3SAMPP":
                    LinkedList<servicios_ordenes_crea> tsn = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().COnsuTAMNOPP023PP(ord);

                    for (int i = 0; i < tsn.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + tsn.get(i).getNum_linea() + "</td>");
                        out.println("<td>" + tsn.get(i).getNum_servicio() + "</td>");
                        out.println("<td>" + tsn.get(i).getTexto_breve() + "</td>");
                        out.println("<td>" + tsn.get(i).getCantidad_con_signo() + "</td>");
                        out.println("<td>" + tsn.get(i).getUnidad_medida_base() + "</td>");
                        out.println("<td>" + tsn.get(i).getValor_neto_posicion() + "</td>");
                        out.println("<td>" + tsn.get(i).getCantidad_base() + "</td>");
                        out.println("<td>" + tsn.get(i).getGrupo_articulos() + "</td>");
                        out.println("<td>" + tsn.get(i).getClase_coste() + "</td>");
                        out.println("</tr>");
                    }
                    break;
                case "POn3P3SAMPP":
                    LinkedList<servicios_ordenes_crea> ton = ACC_Orden.ObtenerInstancia().COnsuTAMNOPM023(ord);
                    out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                               ");
//           for(int i = 0; i < ton.size(); i++){
//                    out.println("<tr>");
//                    out.println("<td>"+ton.get(i).getNum_condicion_doc()+"</td>");
//                    out.println("<td>"+ton.get(i).getNum_doc()+"</td>");
//                    out.println("<td>"+ton.get(i).getIndicador_doc_anulado()+"</td>");
//                    out.println("<td>"+ton.get(i).getTexto_breve()+"</td>");
//                    out.println("<td>"+ton.get(i).getClase_coste()+"</td>");
//                    out.println("<td>"+ton.get(i).getFuncion()+"</td>");
//                    out.println("<td>"+ton.get(i).getCc_nomina()+"</td>");
//                    out.println("<td>"+ton.get(i).getModificacion_texto_explicativo()+"</td>");
//                    out.println("<td>"+ton.get(i).getCantidad_base()+"</td>");
//                    out.println("<td>"+ton.get(i).getUnidad_medida_base()+"</td>");
//                    out.println("<td>"+ton.get(i).getCasilla_seleccion()+"</td>");
//                    out.println("</tr>");
//           }
                    break;
                case "pp3prt1PP":
                    pp_operaciones_noti eqq = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().INPGRNOTPPNOTPP(ord, oper);
                    out.println("<input type'text' id='nspp32' value='" + eqq.getNum_solicitud_pedido() + "' />");
                    out.println("<input type'text' id='npspp32' value='" + eqq.getNum_posicion_socitud_pedido_orden() + "' />");
                    out.println("<input type'text' id='prep32' value='" + eqq.getPrecio() + "' />");
                    out.println("<input type'text' id='clmop32' value='" + eqq.getClave_moneda() + "' />");
                    out.println("<input type'text' id='cabap32' value='" + eqq.getCantidad_base2() + "' />");
                    out.println("<input type'text' id='grarp32' value='" + eqq.getGrupo_articulos() + "' />");
                    out.println("<input type'text' id='gcate32' value='" + eqq.getGrupo_compras_actividad_trabajo_externa() + "' />");
                    out.println("<input type'text' id='ocop32' value='" + eqq.getOrganizacion_compras() + "' />");
                    out.println("<input type'text' id='provp32' value='" + eqq.getProveedor() + "' />");
                    out.println("<input type'text' id='solp32' value='" + eqq.getSolicitante() + "' />");
                    break;
                case "pp3prt2PP":
                    LinkedList<pp03_1_notificaciones> ttn = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().TABGRNOTPP(ord);
                    for (int i = 0; i < ttn.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + ttn.get(i).getNum_linea() + "</td>");
                        out.println("<td>" + ttn.get(i).getNum_servicio() + "</td>");
                        out.println("<td>" + ttn.get(i).getTexto_breve() + "</td>");
                        out.println("<td>" + ttn.get(i).getCantidad_sign() + "</td>");
                        out.println("<td>" + ttn.get(i).getUnidad_medida_base() + "</td>");
                        out.println("<td>" + ttn.get(i).getValor_neto_posicion() + "</td>");
                        out.println("<td>" + ttn.get(i).getCatidad_base() + "</td>");
                        out.println("<td>" + ttn.get(i).getGrupo_articulos() + "</td>");
                        out.println("<td>" + ttn.get(i).getClase_coste() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < 10; i++) {
                        out.println("<tr>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("</tr>");
                    }
                    break;
                case "pp3prt3PP":
                    LinkedList<pp03_2_notificaciones> tnx = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().TABGRNOTPP_2(ord);

                    for (int i = 0; i < tnx.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + tnx.get(i).getNum_doc_compras() + "</td>");
                        out.println("<td>" + tnx.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + tnx.get(i).getIndicador_borrado_doc_compras() + "</td>");
                        out.println("<td>" + tnx.get(i).getTexto_breve() + "</td>");
                        out.println("<td>" + tnx.get(i).getCentro() + "</td>");
                        out.println("<td>" + tnx.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + tnx.get(i).getNum_contrato_superior() + "</td>");
                        out.println("<td>" + tnx.get(i).getNum_material_utilizado_proveedor() + "</td>");
                        out.println("<td>" + tnx.get(i).getCantidad_pedido() + "</td>");
                        out.println("<td>" + tnx.get(i).getUnidad_medida_pedido() + "</td>");
                        out.println("<td>" + tnx.get(i).getValor_neto_pedido_moneda_pedido() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < 10; i++) {
                        out.println("<tr>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("</tr>");
                    }
                    break;
                case "":
                    LinkedList<pp_03_3_notificaciones> tnno = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().TABGRNOTPM_3(ord);
                    for (int i = 0; i < tnno.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + tnno.get(i).getNum_doc_compras() + "</td>");
                        out.println("<td>" + tnno.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + tnno.get(i).getEjercicio_doc_material() + "</td>");
                        out.println("<td>" + tnno.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + tnno.get(i).getPosicion_doc_material() + "</td>");
                        out.println("<td>" + tnno.get(i).getTipo_historial_pedido() + "</td>");
                        out.println("<td>" + tnno.get(i).getClase_movimiento_gestion_stock() + "</td>");
                        out.println("<td>" + tnno.get(i).getFecha_contabilizacion_doc() + "</td>");
                        out.println("<td>" + tnno.get(i).getCantidad() + "</td>");
                        out.println("<td>" + tnno.get(i).getImporte_moneda_doc() + "</td>");
                        out.println("<td>" + tnno.get(i).getClave_moneda() + "</td>");
                        out.println("<td>" + tnno.get(i).getResponsable_anadio_objeto() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < 10; i++) {
                        out.println("<tr>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("</tr>");
                    }
                    break;
                case "ACtuadurTraPP":
                    String nuOrd = request.getParameter("nuOrd");
                    String dutr = request.getParameter("dhm");

                    if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().PONACACNOTPP(dutr, nuOrd)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "CarMatInvPP":
                    String descn = "descripcion_" + Idioma;
                    String mate = request.getParameter("mate");
                    LinkedList cari = ACC_Material.ObtenerInstancia().CargarTodoMaterialNotPP(mate, descn);
                    materiales car = ACC_Material.ObtenerInstancia().CargarMaterialNotPP(mate);
                    String matrai = car.getMaterial();
                    if (cari.size() > 0) {
                        out.println(1 + "," + car.getCentro() + "," + car.getUnidad_medida() + "," + car.getSujeto_lote() + "," + car.getDescripcion() + "");
                    } else {
                        out.println(0);
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
