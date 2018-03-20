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
import Entidades.pp01_notifi;
import Entidades.pm03_1_notificaciones;
import Entidades.pp03_1_notificaciones;
import Entidades.pp03_2_notificaciones;
import Entidades.pp_03_3_notificaciones;
import Entidades.servicios_ordenes_crea;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String Idioma = (String) session.getAttribute("Idioma");
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
            String fol = "ES";
            switch (acc) {
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
                    out.println("<input type='text' id ='nosta' value='" + paln.getStatus() + "' />");

//                    ordenes_pp_notificaciones pl = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenStatusCNPMNOTPP(ord);
                    break;
                case "LlenarTabMax":
                    ArrayList<PlanPP> pl = AccesoDatos.ACC_Pp_operaciones_noti.ObtenerInstancia().TablaCargarNotPP(ord, ope);
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
                        out.println("<td>" + tb.get(i).getId_objeto_recurso() + "</td>");
                        out.println("<td name=\"cntx\">" + tb.get(i).getCentro() + "</td>");
                        out.println("<td>" + tb.get(i).getTexto_breve_operacion() + "</td>");
                        out.println("<td>" + tb.get(i).getCantidad_base() + "</td>");
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
                    LinkedList<materiales_ordenes_crea> tno = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().MostraTABPM01NOPP(ord, ope);
                    if (tno.size() == 0) {
                        for (int l = 0; l < 50; l++) {
                            out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><div style='width:195px;'><input type='text' name='arre' id=\"matab1" + l + "\" onclick=\"mosboton('" + l + "');\"/><button id=\"matmat1" + l + "\" onclick=\"VentModalmat('matab1" + l + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td><td><div style='width:195px;'><input type='text' id=\"lotabp1" + l + "\" onclick=\"mosbotLot('" + l + "');\" /><button id=\"matlot1" + l + "\" onclick=\"VentModalLote('" + l + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td><td><input type='number' min='0' id=\"cumtabp1" + l + "\" name=\"cumtabp1\" /></td><td>&nbsp;</td><td>&nbsp;</td><td id=\"cein" + l + "\">&nbsp;</td><td id=\"unmin" + l + "\">&nbsp;</td><td id=\"almin" + l + "\" >&nbsp;</td><td id=\"Texde" + l + "\">&nbsp;</td></tr>");
                        }
                    } else {
                        for (int i = 0; i < tno.size(); i++) {
                            out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td>" + tno.get(i).getNum_reserva() + "</td>");
                            out.println("<td>" + tno.get(i).getNum_posicion_reserva() + "</td>");
                            out.println("<td><div style='width:195px;'><input type = 'text' id=\"matab1" + i + "\" onclick=\"mosboton('" + i + "');\" value=\"" + tno.get(i).getNum_material() + "\" /><button id=\"matmat1" + i + "\" onclick=\"VentModalmat('matab1" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td>");
                            out.println("<td><div style='width:195px;'><input type = 'text' id=\"lotabp1" + i + "\"  value=\"" + tno.get(i).getLote() + "\"' onclick=\"mosbotLot('" + i + "');\" /><button id=\"matlot1" + i + "\" onclick=\"VentModalLote('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td>");
                            out.println("<td><input type = 'number' id=\"cumtabp1" + i + "\" min='0' value=\"" + tno.get(i).getUnidad_medida_componente_pieza_bruto() + "\" name=\"cumtabp1\" /></td>");
                            out.println("<td>" + tno.get(i).getCantidad_necesaria_componente2() + "</td>");
                            out.println("<td>" + tno.get(i).getCantidad_base() + "</td>");
                            out.println("<td id=\"cein" + i + "\">" + tno.get(i).getCentro() + "</td>");
                            out.println("<td id=\"unmin" + i + "\" >" + tno.get(i).getUnidad_medida_base() + "</td>");
                            out.println("<td id=\"almin" + i + "\">" + tno.get(i).getAlmacen() + "</td>");
                            out.println("<td id=\"Texde" + i + "\">" + tno.get(i).getTexto_posicion_lista_materiales() + "</td>");
                            out.println("</tr>");
                        }

                        for (int la = 49; la >= tno.size(); la--) {

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
