
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_SolicitudPedidos;
import AccesoDatos.ACC_Textos_cabecera_solped;
import AccesoDatos.ACC_Textos_posiciones_solped;
import AccesoDatos.Consultas;
import Entidades.SolpedCrea;
import Entidades.SolpedServicios;
import Entidades.Solped_Posiciones_vis;
import Entidades.Solped_Servicios_vis;
import Entidades.textos_cabecera_solped;
import Entidades.textos_posiciones_solped;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "peticionModVisSolped", urlPatterns = {"/peticionModVisSolped"})
public class peticionModVisSolped extends HttpServlet {

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
            HttpSession se = request.getSession();
            String us = (String) se.getAttribute("Usuario");
            String Accion = request.getParameter("Accion");
            String NumSol = request.getParameter("NumSol");
            String Cantid = request.getParameter("Ctd");
            String fechas = request.getParameter("FECHS");
            String Posicion = request.getParameter("Posicion");
            String edi = request.getParameter("EDIT");
            String POS = request.getParameter("PO");
            //////VARIABES DE CANCELACION DE SOLPED
            String Solped = request.getParameter("solped");
            String PosSol = request.getParameter("pos");
            String FolSAM = request.getParameter("SAM");
            String Cancel = request.getParameter("Cancel");
            Consultas con = new Consultas();

            switch (Accion) {
                case "ConsultaSolpeds":
                    ArrayList<Solped_Posiciones_vis> soi = ACC_SolicitudPedidos.ObtenerInstancia().ConsultaMCSolped(NumSol, fechas, us);
                    if (soi.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (Cantid.length() > 0) {
                            for (int n = 0; n < Integer.parseInt(Cantid); n++) {
                                out.println("<tr ondblclick=\"seleccionar('" + soi.get(n).getFolio_sap() + "', '" + soi.get(n).getFolio_sam() + "')\">");
                                out.println("<td>" + soi.get(n).getFolio_sap() + "</td>");
                                out.println("<td>" + soi.get(n).getFolio_sam() + "</td>");
                                out.println("<td>" + con.DateFormat(soi.get(n).getFecha()) + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int n = 0; n <= soi.size(); n++) {
                                out.println("<tr ondblclick=\"seleccionar('" + soi.get(n).getFolio_sap() + "', '" + soi.get(n).getFolio_sam() + "')\">");
                                out.println("<td>" + soi.get(n).getFolio_sap() + "</td>");
                                out.println("<td>" + soi.get(n).getFolio_sam() + "</td>");
                                out.println("<td>" + con.DateFormat(soi.get(n).getFecha()) + "</td>");
                                out.println("</tr>");
                            }

                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidaSolped":
                    String Solp1 = ACC_SolicitudPedidos.ObtenerInstancia().ValidarSolpedCrea(NumSol);
                    out.println(Solp1);
                    break;
                case "CargarDatosCab":
                    SolpedCrea vc = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerDatosSolpedCab(NumSol);
                    JSONArray js = new JSONArray();
                    js.add(vc.getOrganizacion_compras());
                    js.add(vc.getGrupo_compras());
                    js.add(vc.getError());
                    js.add(vc.getClase_documento_solped());
                    out.println(js);
                    break;
                case "CargarTablaSolped":
                    ArrayList<SolpedCrea> so = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaSolped(NumSol, edi, us);
                    out.println("<table>");
                    out.println("<tbody>");
                    if (so.size() > 0) {
                        int a;
                        for (a = 0; a < so.size(); a++) {
                            out.println("<tr>");
                            out.println("<td><input class=\"che\" type=\"radio\" name=\"DelPos\"/><input type=\"text\" id=\"posValoSo" + a + "\"  value=\"" + so.get(a).getNum_posicion_solped() + "\" hidden/> </td>");
                            out.println("<td>" + so.get(a).getNum_posicion_solped() + "</td>");
                            out.println("<td>" + so.get(a).getTipo_imputacion() + "</td>");
                            out.println("<td>" + so.get(a).getTipo_posicion_doc_compras() + "</td>");
                            out.println("<td>" + so.get(a).getNum_material() + "</td>");
                            out.println("<td>" + so.get(a).getTexto_breve() + "</td>");
                            out.println("<td>" + so.get(a).getUnidad_medida_solped() + "</td>");
                            out.println("<td>" + so.get(a).getGrupo_articulos() + "</td>");
                            out.println("<td>" + so.get(a).getCantidad_solped() + "</td>");
                            out.println("<td>" + con.DateFormat(so.get(a).getFecha_entraga_posicion()) + "</td>");
                            out.println("<td class=\"tdCentro\">" + so.get(a).getCentro() + "</td>");
                            out.println("<td>" + so.get(a).getAlmacen() + "</td>");
                            out.println("<td class=\"tdsol\">" + so.get(a).getSolicitante() + "</td>");
                            out.println("<td>" + so.get(a).getOrganizacion_compras() + "</td>");
                            out.println("<td>" + so.get(a).getGrupo_compras() + "</td>");
                            out.println("<td>" + so.get(a).getNum_cuenta_mayor() + "</td>");
                            out.println("<td>" + so.get(a).getCentro_coste() + "</td>");
                            out.println("<td>" + so.get(a).getNum_orden() + "</td>");
                            out.println("</tr>");
                        }
                        for (int c = a; c < 10; c++) {
                            out.println("<tr>");
                            for (int l = 0; l < 18; l++) {
                                out.println("<td>&nbsp;</td>");
                            }
                            out.println("</tr>");
                        }
                    } else {
                        for (int c = 0; c < 10; c++) {
                            out.println("<tr>");
                            for (int l = 0; l < 18; l++) {
                                out.println("<td>&nbsp;</td>");
                            }
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");

                    break;
                case "CargarTxtCab":
                    ArrayList<textos_cabecera_solped> tx = ACC_Textos_cabecera_solped.ObtenerInstancia().ObtenerTextoSolCabSolped(NumSol);
                    String txt = "";
                    for (int i = 0; i < tx.size(); i++) {
                        txt += tx.get(i).getLinea_texto();
                    }
                    JSONArray jst = new JSONArray();
                    jst.add(txt);
                    out.println(jst);
                    break;
                case "CargarTxtCabSAP":
                    ArrayList<textos_cabecera_solped> txts = ACC_Textos_cabecera_solped.ObtenerInstancia().ObtenerTextoSolCabSolpeSAP(NumSol);
                    String txs = "";
                    for (int i = 0; i < txts.size(); i++) {
                        txs += txts.get(i).getLinea_texto();
                    }
                    JSONArray jst1 = new JSONArray();
                    jst1.add(txs);
                    out.println(jst1);
                    break;
                case "CargarListaSelect":
                    ArrayList<SolpedCrea> spl = ACC_SolicitudPedidos.ObtenerInstancia().CargarPosi(NumSol, edi, us);
                    out.println("<select id=\"Distribucion_SP\">"
                            + "<option></option>");
                    for (int c = 0; c < spl.size(); c++) {
                        out.println("<option>" + spl.get(c).getNum_posicion_solped() + "</option>");
                    }
                    out.println("</select>");
                    break;
                case "ObtenerPosicion":
                    SolpedCrea s1 = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerPosicion(NumSol, Posicion, edi, us);
                    JSONArray jp = new JSONArray();
                    jp.add(s1.getTipo_imputacion());
                    jp.add(s1.getTipo_posicion_doc_compras());
                    jp.add(s1.getNum_material());
                    jp.add(s1.getCantidad_solped());
                    jp.add(con.DateFormat(s1.getFecha_entraga_posicion()));
                    jp.add(s1.getCentro());
                    jp.add(s1.getAlmacen());
                    jp.add(s1.getTexto_breve());
                    jp.add(s1.getUnidad_medida_solped());
                    jp.add(s1.getGrupo_articulos());
                    jp.add(s1.getSolicitante());
                    jp.add(s1.getNum_cuenta_mayor());
                    jp.add(s1.getCentro_coste());
                    jp.add(s1.getNum_orden());
                    out.println(jp);
                    break;
                case "CargarTxtPos":
                    String tx1 = "";
                    ArrayList<textos_posiciones_solped> tp = ACC_Textos_posiciones_solped.ObtenerInstancia().CargarTextosPosi(NumSol, Posicion, edi, us);
                    for (int l = 0; l < tp.size(); l++) {
                        tx1 += tp.get(l).getLinea_texto();
                    }
                    JSONArray jtxx = new JSONArray();
                    jtxx.add(tx1);
                    out.println(jtxx);
                    break;
                case "CargarTxtPosSAP":
                    String tx11 = "";
                    ArrayList<textos_posiciones_solped> tp1 = ACC_Textos_posiciones_solped.ObtenerInstancia().CargarTextoPosicionSAP(NumSol, Posicion);
                    for (int l = 0; l < tp1.size(); l++) {
                        tx11 += tp1.get(l).getLinea_texto();
                    }
                    JSONArray jtxx1 = new JSONArray();
                    jtxx1.add(tx11);
                    out.println(jtxx1);
                    break;
                case "VerificarEdicionSolped":
                    if (ACC_SolicitudPedidos.ObtenerInstancia().VerificarEdicion(NumSol, us)) {
                        out.println(1);
                    }
                    break;
                case "CambiarStatusModSolped":
                    ArrayList<SolpedCrea> sol = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaSolped(NumSol, "C", us);
                    ACC_SolicitudPedidos.ObtenerInstancia().EstatusSolpedMod(sol, NumSol);
                    ArrayList<textos_posiciones_solped> tpo = ACC_Textos_posiciones_solped.ObtenerInstancia().CargarTextosPosTemp(NumSol, us);
                    ACC_Textos_posiciones_solped.ObtenerInstancia().InsertartxtTempMod(tpo);
                    ArrayList<SolpedServicios> sere = ACC_SolicitudPedidos.ObtenerInstancia().CargarServiciosModTemp1(NumSol, us);
                    ACC_SolicitudPedidos.ObtenerInstancia().InsertarServiciosMod(sere);
                    break;
                case "CambiarStatusSolped":
                    ArrayList<SolpedCrea> solmo = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaSolpedMod(NumSol, us);
                    ACC_SolicitudPedidos.ObtenerInstancia().solped_CREADELETE(NumSol);
                    ACC_SolicitudPedidos.ObtenerInstancia().EstatusSolped(solmo, NumSol);
                    ArrayList<textos_posiciones_solped> tpos = ACC_Textos_posiciones_solped.ObtenerInstancia().CargarTextosPos(NumSol, us);
                    ACC_Textos_posiciones_solped.ObtenerInstancia().TextosPosDELETE(NumSol);
                    ACC_Textos_posiciones_solped.ObtenerInstancia().Insertartxt(tpos);
                    ArrayList<SolpedServicios> serev = ACC_SolicitudPedidos.ObtenerInstancia().CargarServiciosNO(NumSol, us);
                    ACC_SolicitudPedidos.ObtenerInstancia().solped_ServiciosNODELETE(NumSol);
                    ACC_SolicitudPedidos.ObtenerInstancia().InsertarServicios(serev);
                    ACC_SolicitudPedidos.ObtenerInstancia().solped_txt_CABDELETE(NumSol);
                    break;

                case "CancelarSolped":
                    ACC_SolicitudPedidos.ObtenerInstancia().CancelStatus(us);
                    break;
                case "DElTEXTPos":
                    ACC_Textos_posiciones_solped.ObtenerInstancia().EliminarModModTexto(POS, us, NumSol);
                    break;
                case "CargarServicios":
                    ArrayList<Solped_Servicios_vis> ser = ACC_SolicitudPedidos.ObtenerInstancia().CargarServiciosSAM(NumSol, Posicion);
                    int h;
                    if (ser.size() > 0) {

                        out.println("<table>");
                        out.println("<tbody>");
                        for (h = 0; h < ser.size(); h++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" value=\"" + ser.get(h).getNum_posicion_solped() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" value=\"" + ser.get(h).getNum_linea() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" value=\"" + ser.get(h).getNum_servicio() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" value=\"" + ser.get(h).getCantidad() + "\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" value=\"" + ser.get(h).getUnidad_medida_base() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" value=\"" + ser.get(h).getTexto_breve() + "\" /></td>");
                            out.println("</tr>");
                        }
                        for (int j = h; j < 10; j++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" readOnly/></td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                    } else {
                        out.println("<tbody>");
                        for (int l = 0; l < 10; l++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" readOnly/></td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                    break;

                case "DeletePos":
                    if (ACC_SolicitudPedidos.ObtenerInstancia().solped_tempDeleteMod(us, POS, NumSol)) {
                        ACC_SolicitudPedidos.ObtenerInstancia().solped_serviciosDeleteMod(us, POS, NumSol);
                        ACC_SolicitudPedidos.ObtenerInstancia().tex_pos_solped_tempDeleteMod(us, POS, NumSol);
                        ArrayList<SolpedCrea> sope = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaSolped(NumSol, "E", us);
                        out.println("<table>");
                        out.println("<tbody>");
                        if (sope.size() > 0) {
                            int a;
                            for (a = 0; a < sope.size(); a++) {
                                out.println("<tr>");
                                out.println("<td><input class=\"che\" type=\"radio\" name=\"DelPos\"/><input type=\"text\" id=\"posValoSo" + a + "\"  value=\"" + sope.get(a).getNum_posicion_solped() + "\" hidden/> </td>");
                                out.println("<td>" + sope.get(a).getNum_posicion_solped() + "</td>");
                                out.println("<td>" + sope.get(a).getTipo_imputacion() + "</td>");
                                out.println("<td>" + sope.get(a).getTipo_posicion_doc_compras() + "</td>");
                                out.println("<td>" + sope.get(a).getNum_material() + "</td>");
                                out.println("<td>" + sope.get(a).getTexto_breve() + "</td>");
                                out.println("<td>" + sope.get(a).getUnidad_medida_solped() + "</td>");
                                out.println("<td>" + sope.get(a).getGrupo_articulos() + "</td>");
                                out.println("<td>" + sope.get(a).getCantidad_solped() + "</td>");
                                out.println("<td>" + con.DateFormat(sope.get(a).getFecha_entraga_posicion()) + "</td>");
                                out.println("<td class=\"tdCentro\">" + sope.get(a).getCentro() + "</td>");
                                out.println("<td>" + sope.get(a).getAlmacen() + "</td>");
                                out.println("<td class=\"tdsol\">" + sope.get(a).getSolicitante() + "</td>");
                                out.println("<td>" + sope.get(a).getOrganizacion_compras() + "</td>");
                                out.println("<td>" + sope.get(a).getGrupo_compras() + "</td>");
                                out.println("<td>" + sope.get(a).getNum_cuenta_mayor() + "</td>");
                                out.println("<td>" + sope.get(a).getCentro_coste() + "</td>");
                                out.println("<td>" + sope.get(a).getNum_orden() + "</td>");
                                out.println("</tr>");
                            }
                            for (int c = a; c < 10; c++) {
                                out.println("<tr>");
                                for (int l = 0; l < 18; l++) {
                                    out.println("<td>&nbsp;</td>");
                                }
                                out.println("</tr>");
                            }
                        } else {
                            for (int c = 0; c < 10; c++) {
                                out.println("<tr>");
                                for (int l = 0; l < 18; l++) {
                                    out.println("<td>&nbsp;</td>");
                                }
                                out.println("</tr>");
                            }
                        }
                        out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                    break;
                case "Reasic":
                    int Tamnua = Integer.parseInt(request.getParameter("NewPos"));
                    ArrayList<SolpedCrea> serv = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaSolped(NumSol, "E", us);
                    int hola = serv.size();
                    for (int i = 0; i < hola; i++) {
                        if (Tamnua == i) {
                            int valn = i + 1;
                            String lon = String.valueOf(valn);
                            if (ACC_SolicitudPedidos.ObtenerInstancia().solped_serviciosUpdateMod(us, serv.get(i).getNum_posicion_solped(), Chepos(lon), NumSol) == true) {
                                if (ACC_SolicitudPedidos.ObtenerInstancia().solped_ModUpdate(us, serv.get(i).getNum_posicion_solped(), Chepos(lon), NumSol) == true) {
                                    if (ACC_SolicitudPedidos.ObtenerInstancia().tex_pos_solped_ModUpdate(us, serv.get(i).getNum_posicion_solped(), Chepos(lon), NumSol) == true) {
                                        out.println(1);
                                    } else {
                                        out.println(0);
                                    }
                                } else {
                                    out.println(0);
                                }
                            } else if (ACC_SolicitudPedidos.ObtenerInstancia().solped_ModUpdate(us, serv.get(i).getNum_posicion_solped(), Chepos(lon), NumSol) == true) {
                                out.println(1);
                            } else {
                                out.println(0);
                            }
                        }
                    }
                    break;
                case "CargarNuevaPosi":
                    ArrayList<SolpedCrea> som = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaSolped(NumSol, "E", us);
                    out.println("<table>");
                    out.println("<tbody>");
                    if (som.size() > 0) {
                        int a;
                        for (a = 0; a < som.size(); a++) {
                            out.println("<tr>");
                            out.println("<td><input class=\"che\" type=\"radio\" name=\"DelPos\"/><input type=\"text\" id=\"posValoSo" + a + "\"  value=\"" + som.get(a).getNum_posicion_solped() + "\" hidden/> </td>");
                            out.println("<td>" + som.get(a).getNum_posicion_solped() + "</td>");
                            out.println("<td>" + som.get(a).getTipo_imputacion() + "</td>");
                            out.println("<td>" + som.get(a).getTipo_posicion_doc_compras() + "</td>");
                            out.println("<td>" + som.get(a).getNum_material() + "</td>");
                            out.println("<td>" + som.get(a).getTexto_breve() + "</td>");
                            out.println("<td>" + som.get(a).getUnidad_medida_solped() + "</td>");
                            out.println("<td>" + som.get(a).getGrupo_articulos() + "</td>");
                            out.println("<td>" + som.get(a).getCantidad_solped() + "</td>");
                            out.println("<td>" + con.DateFormat(som.get(a).getFecha_entraga_posicion()) + "</td>");
                            out.println("<td class=\"tdCentro\">" + som.get(a).getCentro() + "</td>");
                            out.println("<td>" + som.get(a).getAlmacen() + "</td>");
                            out.println("<td class=\"tdsol\">" + som.get(a).getSolicitante() + "</td>");
                            out.println("<td>" + som.get(a).getOrganizacion_compras() + "</td>");
                            out.println("<td>" + som.get(a).getGrupo_compras() + "</td>");
                            out.println("<td>" + som.get(a).getNum_cuenta_mayor() + "</td>");
                            out.println("<td>" + som.get(a).getCentro_coste() + "</td>");
                            out.println("<td>" + som.get(a).getNum_orden() + "</td>");
                            out.println("</tr>");
                        }
                        for (int c = a; c < 10; c++) {
                            out.println("<tr>");
                            for (int l = 0; l < 18; l++) {
                                out.println("<td>&nbsp;</td>");
                            }
                            out.println("</tr>");
                        }
                    } else {
                        for (int c = 0; c < 10; c++) {
                            out.println("<tr>");
                            for (int l = 0; l < 18; l++) {
                                out.println("<td>&nbsp;</td>");
                            }
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");

                    break;
                case "SAVETEXTCAB":
                    String texps = request.getParameter("texps");
                    String fila = request.getParameter("fila");
                    ACC_Textos_cabecera_solped.ObtenerInstancia().InsertTxtCabecera(NumSol, fila, us, texps);
                    break;
                case "CargarDatosCabSAP":
                    Solped_Posiciones_vis cv = ACC_SolicitudPedidos.ObtenerInstancia().CargarDatosCabeceraSAP(NumSol);
                    JSONArray ja = new JSONArray();
                    ja.add(cv.getClase_doc_solped());
                    ja.add("");
                    ja.add(cv.getFolio_sap());
                    ja.add(cv.getFolio_sam());
                    ja.add(cv.getOrganización_compras());
                    ja.add(cv.getGrupo_compras());
                    out.println(ja);
                    break;
                case "CargarTablaSAPMod":
                    ArrayList<Solped_Posiciones_vis> som1 = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaSolpedSAP(NumSol);
                    out.println("<table>");
                    out.println("<tbody>");
                    if (som1.size() > 0) {
                        int a;
                        for (a = 0; a < som1.size(); a++) {
                            String pe = "";
                            if (som1.get(a).getIndicador_borrado().equals("X")) {
                                pe = "checked";
                            }
                            out.println("<tr>");
                            out.println("<td><input class=\"borraSAP\" type=\"checkbox\" name=\"BorradoInd\" " + pe + "/><input type=\"text\" id=\"posValposmod" + a + "\"  value=\"" + som1.get(a).getNum_posicion_solped() + "\" hidden/></td>");
                            out.println("<td>" + som1.get(a).getNum_posicion_solped() + "</td>");
                            out.println("<td>" + som1.get(a).getTipo_imputacion() + "</td>");
                            out.println("<td>" + som1.get(a).getTipo_posicion_doc_compras() + "</td>");
                            out.println("<td>" + som1.get(a).getNum_material() + "</td>");
                            out.println("<td>" + som1.get(a).getTexto_breve() + "</td>");
                            out.println("<td>" + som1.get(a).getUnidad_medida_solped() + "</td>");
                            out.println("<td>" + som1.get(a).getGrupo_articulos() + "</td>");
                            out.println("<td>" + som1.get(a).getCantidad_solped() + "</td>");
                            out.println("<td>" + con.DateFormat(som1.get(a).getFecha_entrega()) + "</td>");
                            out.println("<td class=\"tdCentro\">" + som1.get(a).getCentro() + "</td>");
                            out.println("<td>" + som1.get(a).getAlmacen() + "</td>");
                            out.println("<td class=\"tdsol\">" + som1.get(a).getSolicitante() + "</td>");
                            out.println("<td>" + som1.get(a).getOrganización_compras() + "</td>");
                            out.println("<td>" + som1.get(a).getGrupo_compras() + "</td>");
                            out.println("<td>" + som1.get(a).getNum_cuenta_mayor() + "</td>");
                            out.println("<td>" + som1.get(a).getCentro_coste() + "</td>");
                            out.println("<td>" + som1.get(a).getNum_orden() + "</td>");
                            out.println("</tr>");
                        }
                        for (int c = a; c < 10; c++) {
                            out.println("<tr>");
                            for (int l = 0; l < 18; l++) {
                                out.println("<td>&nbsp;</td>");
                            }
                            out.println("</tr>");
                        }
                    } else {
                        for (int c = 0; c < 10; c++) {
                            out.println("<tr>");
                            for (int l = 0; l < 18; l++) {
                                out.println("<td>&nbsp;</td>");
                            }
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CargarListaSelectSAP":
                    ArrayList<Solped_Posiciones_vis> sapse = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerTablaSolpedSAP(NumSol);
                    out.println("<select id=\"Distribucion_SP\">"
                            + "<option></option>");
                    for (int c = 0; c < sapse.size(); c++) {
                        out.println("<option>" + sapse.get(c).getNum_posicion_solped() + "</option>");
                    }
                    out.println("</select>");
                    break;
                case "VerifSolped":
                    if (ACC_SolicitudPedidos.ObtenerInstancia().VerificarSAP(Solped)) {
                        out.println(1);
                    }
                    break;
                case "GuardarDatosCancelacion":
                    String Can = "";
                    String Con = "";
                    if (Cancel.trim().equals("X")) {
                        Can = "X";
                    } else {
                        Con = "X";
                    }
                    String fecha = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String hora = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                    ACC_SolicitudPedidos.ObtenerInstancia().Insertdata(Solped, PosSol, FolSAM, Can, Con, fecha, hora);
                    ACC_SolicitudPedidos.ObtenerInstancia().ActualizarIndicadorSolped(Solped, PosSol, Can);
                    break;
                case "CargarPosicionSAP":
                    JSONArray po = new JSONArray();
                    Solped_Posiciones_vis pv = ACC_SolicitudPedidos.ObtenerInstancia().CargarPosicionSAP(Solped, PosSol);
                    po.add(pv.getTipo_imputacion());
                    po.add(pv.getTipo_posicion_doc_compras());
                    po.add(pv.getNum_material());
                    po.add(pv.getCantidad_solped());
                    po.add(con.DateFormat(pv.getFecha_entrega()));
                    po.add(pv.getCentro());
                    po.add(pv.getAlmacen());
                    po.add(pv.getTexto_breve());
                    po.add(pv.getUnidad_medida_solped());
                    po.add(pv.getGrupo_articulos());
                    po.add(pv.getSolicitante());
                    po.add(pv.getNum_cuenta_mayor());
                    po.add(pv.getCentro_coste());
                    po.add(pv.getNum_orden());
                    po.add(pv.getTexto_posicion());
                    out.println(po);
                    break;
                case "CargarServicioPosicionSAP":
                    out.println("<table>");
                    out.println("<tbody>");
                    ArrayList<Solped_Servicios_vis> ser1 = ACC_SolicitudPedidos.ObtenerInstancia().CargarServiciosSAP(Solped, PosSol);
                    int h1;
                    if (ser1.size() > 0) {
                        for (h1 = 0; h1 < ser1.size(); h1++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" value=\"" + ser1.get(h1).getNum_posicion_solped() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" value=\"" + ser1.get(h1).getNum_linea() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" value=\"" + ser1.get(h1).getNum_servicio() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" value=\"" + ser1.get(h1).getCantidad() + "\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" value=\"" + ser1.get(h1).getUnidad_medida_base() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" value=\"" + ser1.get(h1).getTexto_breve() + "\" /></td>");
                            out.println("</tr>");
                        }
                        for (int j = h1; j < 10; j++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" readOnly/></td>");
                            out.println("</tr>");
                        }
                    } else {
                        for (int j = 0; j < 10; j++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" readOnly/></td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
            }
        }
    }

    public String Chepos(String data) {
        int valor = Integer.parseInt(data);
        String i = data;
        if (i.length() == 5) {
            return i;
        }
        if (valor < 10) {
            i = "000" + data + "0";
        }
        if (valor >= 10 && valor < 100) {
            i = "00" + data + "0";
        }
        if (valor >= 100 && valor < 1000) {
            i = "0" + data + "0";
        }
        if (valor >= 1000 && valor < 10000) {
            i = data + "0";
        }
        return i;
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
