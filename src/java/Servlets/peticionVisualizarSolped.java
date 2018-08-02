/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import AccesoDatos.ACC_SolicitudPedidos;
import AccesoDatos.ACC_Textos_cabecera_solped;
import AccesoDatos.ACC_Textos_posiciones_solped;
import AccesoDatos.Consultas;
import Entidades.Solped_Posiciones_vis;
import Entidades.Solped_Servicios_vis;
import Entidades.textos_cabecera_solped;
import Entidades.textos_posiciones_solped;
import java.util.ArrayList;
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "peticionVisualizarSolped", urlPatterns = {"/peticionVisualizarSolped"})
public class peticionVisualizarSolped extends HttpServlet {

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
            String NumSol = request.getParameter("NumSol");
            String FechaS = request.getParameter("FECHS");
            String usuaSP = request.getParameter("UsuarioSP");
            String ctd = request.getParameter("Ctd");
            String Tipo = request.getParameter("Tipo");
            String Pos = request.getParameter("Pos");
            Consultas con = new Consultas();

            switch (Accion) {
                case "ConsultaSolpeds":
                    ArrayList<Solped_Posiciones_vis> so = ACC_SolicitudPedidos.ObtenerInstancia().ConsultaMCSolped(NumSol, FechaS, usuaSP);
                    if (so.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (ctd.length() > 0) {
                            for (int n = 0; n < Integer.parseInt(ctd); n++) {
                                out.println("<tr ondblclick=\"seleccionar('" + so.get(n).getFolio_sap() + "', '" + so.get(n).getFolio_sam() + "')\">");
                                out.println("<td style=\"width: 20%;\">" + so.get(n).getFolio_sap() + "</td>");
                                out.println("<td style=\"width: 20%;\">" + so.get(n).getFolio_sam() + "</td>");
                                out.println("<td style=\"width: 15%;\">" + con.DateFormat(so.get(n).getFecha()) + "</td>");
                                out.println("<td style=\"width: 20%;\">" + so.get(n).getSolicitante() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int n = 0; n <= so.size(); n++) {
                                out.println("<tr ondblclick=\"seleccionar('" + so.get(n).getFolio_sap() + "', '" + so.get(n).getFolio_sam() + "')\">");
                                out.println("<td style=\"width: 20%;\">" + so.get(n).getFolio_sap() + "</td>");
                                out.println("<td style=\"width: 20%;\">" + so.get(n).getFolio_sam() + "</td>");
                                out.println("<td style=\"width: 15%;\">" + con.DateFormat(so.get(n).getFecha()) + "</td>");
                                out.println("<td style=\"width: 20%;\">" + so.get(n).getSolicitante() + "</td>");
                                out.println("</tr>");
                            }

                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSolped":
                    int SAP = ACC_SolicitudPedidos.ObtenerInstancia().ValidarSolpedSAP(NumSol);
                    int SAM = ACC_SolicitudPedidos.ObtenerInstancia().ValidarSolpedSAM(NumSol);
                    out.println(SAP + "," + SAM);
                    break;
                case "CargarCabecera":
                    JSONArray ja = new JSONArray();
                    if (Tipo.equals("P")) {
                        Solped_Posiciones_vis cv = ACC_SolicitudPedidos.ObtenerInstancia().CargarDatosCabeceraSAP(NumSol);
                        ja.add(cv.getClase_doc_solped());
                        ja.add("");
                        ja.add(cv.getFolio_sap());
                        ja.add(cv.getFolio_sam());
                        ja.add(cv.getOrganización_compras());
                        ja.add(cv.getGrupo_compras());
                        ja.add("");
                    } else if (Tipo.equals("M")) {
                        Solped_Posiciones_vis cv = ACC_SolicitudPedidos.ObtenerInstancia().CargarDatosCabeceraSAM(NumSol);
                        ja.add(cv.getClase_doc_solped());
                        ja.add("");
                        ja.add(cv.getFolio_sap());
                        ja.add(cv.getFolio_sam());
                        ja.add(cv.getOrganización_compras());
                        ja.add(cv.getGrupo_compras());
                        ja.add(cv.getError());
                    } else {
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
                case "CargarTxtCabecera":
                    if (Tipo.equals("P")) {
                        ArrayList<textos_cabecera_solped> tcss = ACC_Textos_cabecera_solped.ObtenerInstancia().ObtenerTextoSolCabSolpeSAP(NumSol);
                        String cad1 = "";
                        for (int l = 0; l < tcss.size(); l++) {
                            cad1 += tcss.get(l).getLinea_texto();
                        }
                        if (cad1.length() > 0) {
                            out.println(cad1);
                        }

                    } else if (Tipo.equals("M")) {
                        ArrayList<textos_cabecera_solped> tcs = ACC_Textos_cabecera_solped.ObtenerInstancia().ObtenerTextoSolCabSolped(NumSol);
                        String cad = "";
                        for (int l = 0; l < tcs.size(); l++) {
                            cad += tcs.get(l).getLinea_texto();
                        }
                        if (cad.length() > 0) {
                            out.println(cad);
                        }
                    } else {
                        out.println("");
                    }
                    break;
                case "CargarTabla":
                    out.println("<table>");
                    out.println("<tbody>");
                    if (Tipo.equals("P")) {
                        ArrayList<Solped_Posiciones_vis> s = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerTablaSolpedSAP(NumSol);
                        if (s.size() > 0) {
                            int i;
                            for (i = 0; i < s.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + s.get(i).getNum_posicion_solped() + "</td>");
                                out.println("<td>" + s.get(i).getTipo_imputacion() + "</td>");
                                out.println("<td>" + s.get(i).getTipo_posicion_doc_compras() + "</td>");
                                out.println("<td>" + s.get(i).getNum_material() + "</td>");
                                out.println("<td>" + s.get(i).getTexto_breve() + "</td>");
                                out.println("<td>" + s.get(i).getUnidad_medida_solped() + "</td>");
                                out.println("<td>" + s.get(i).getGrupo_articulos() + "</td>");
                                out.println("<td>" + s.get(i).getCantidad_solped() + "</td>");
                                out.println("<td>" + con.DateFormat(s.get(i).getFecha_entrega()) + "</td>");
                                out.println("<td>" + s.get(i).getCentro() + "</td>");
                                out.println("<td>" + s.get(i).getAlmacen() + "</td>");
                                out.println("<td>" + s.get(i).getSolicitante() + "</td>");
                                out.println("<td>" + s.get(i).getOrganización_compras() + "</td>");
                                out.println("<td>" + s.get(i).getGrupo_compras() + "</td>");
                                out.println("<td>" + s.get(i).getNum_cuenta_mayor() + "</td>");
                                out.println("<td>" + s.get(i).getCentro_coste() + "</td>");
                                out.println("<td>" + s.get(i).getNum_orden() + "</td>");
                                out.println("</tr>");
                            }
                            for (int j = i; j < 10; j++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int j = 0; j < 10; j++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                        }

                    } else if (Tipo.equals("M")) {
                        ArrayList<Solped_Posiciones_vis> as = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerTablaSolpedSAM(NumSol);
                        if (as.size() > 0) {
                            int e;
                            for (e = 0; e < as.size(); e++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + as.get(e).getNum_posicion_solped() + "</td>");
                                out.println("<td>" + as.get(e).getTipo_imputacion() + "</td>");
                                out.println("<td>" + as.get(e).getTipo_posicion_doc_compras() + "</td>");
                                out.println("<td>" + as.get(e).getNum_material() + "</td>");
                                out.println("<td>" + as.get(e).getTexto_breve() + "</td>");
                                out.println("<td>" + as.get(e).getUnidad_medida_solped() + "</td>");
                                out.println("<td>" + as.get(e).getGrupo_articulos() + "</td>");
                                out.println("<td>" + as.get(e).getCantidad_solped() + "</td>");
                                out.println("<td>" + con.DateFormat(as.get(e).getFecha_entrega()) + "</td>");
                                out.println("<td>" + as.get(e).getCentro() + "</td>");
                                out.println("<td>" + as.get(e).getAlmacen() + "</td>");
                                out.println("<td>" + as.get(e).getSolicitante() + "</td>");
                                out.println("<td>" + as.get(e).getOrganización_compras() + "</td>");
                                out.println("<td>" + as.get(e).getGrupo_compras() + "</td>");
                                out.println("<td>" + as.get(e).getNum_cuenta_mayor() + "</td>");
                                out.println("<td>" + as.get(e).getCentro_coste() + "</td>");
                                out.println("<td>" + as.get(e).getNum_orden() + "</td>");
                                out.println("</tr>");
                            }
                            for (int j = e; j < 10; j++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("</tr>");
                            }

                        } else {
                            for (int j = 0; j < 10; j++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                        }
                    } else {
                        for (int j = 0; j < 10; j++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CargarListaPosiciones":
                    out.println("<select id=\"Distribucion_SP\">");
                    out.println("<option></option>");
                    if (Tipo.equals("P")) {
                        ArrayList<Solped_Posiciones_vis> s = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerTablaSolpedSAP(NumSol);
                        for (int c = 0; c < s.size(); c++) {
                            out.println("<option>" + s.get(c).getNum_posicion_solped() + "</option>");
                        }
                    } else if (Tipo.equals("M")) {
                        String jkj;
                        ArrayList<Solped_Posiciones_vis> as = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerTablaSolpedSAM(NumSol);
                        for (int c = 0; c < as.size(); c++) {
                            out.println("<option>" + as.get(c).getNum_posicion_solped() + "</option>");
                        }
                    }
                    out.println("</select>");
                    break;
                case "CargarPosicion":
                    JSONArray po = new JSONArray();
                    if (Tipo.equals("P")) {
                        Solped_Posiciones_vis pv = ACC_SolicitudPedidos.ObtenerInstancia().CargarPosicionSAP(NumSol, Pos);
                        String libe[] = ACC_SolicitudPedidos.ObtenerInstancia().DatosLiberacionSAP(NumSol, Pos);
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
                        po.add(libe[0]);
                        po.add(libe[1]);
                        po.add(libe[2]);
                    } else if (Tipo.equals("M")) {
                        Solped_Posiciones_vis pc = ACC_SolicitudPedidos.ObtenerInstancia().CargarPosicionSAM(NumSol, Pos);
                        po.add(pc.getTipo_imputacion());
                        po.add(pc.getTipo_posicion_doc_compras());
                        po.add(pc.getNum_material());
                        po.add(pc.getCantidad_solped());
                        po.add(con.DateFormat(pc.getFecha_entrega()));
                        po.add(pc.getCentro());
                        po.add(pc.getAlmacen());
                        po.add(pc.getTexto_breve());
                        po.add(pc.getUnidad_medida_solped());
                        po.add(pc.getGrupo_articulos());
                        po.add(pc.getSolicitante());
                        po.add(pc.getNum_cuenta_mayor());
                        po.add(pc.getCentro_coste());
                        po.add(pc.getNum_orden());
                        po.add(pc.getTexto_posicion());
                        po.add("");
                        po.add("");
                        po.add("");
                    }
                    out.println(po);
                    break;
                case "CargarTxtPosiciones":
                    if (Tipo.equals("P")) {
                        ArrayList<textos_posiciones_solped> tspt = ACC_Textos_posiciones_solped.ObtenerInstancia().CargarTextoPosicionSAP(NumSol, Pos);
                        String cat = "";
                        for (int j = 0; j < tspt.size(); j++) {
                            cat += tspt.get(j).getLinea_texto();
                        }
                        out.println(cat);

                    } else if (Tipo.equals("M")) {
                        ArrayList<textos_posiciones_solped> tsp = ACC_Textos_posiciones_solped.ObtenerInstancia().CargarTextoPosicion(NumSol, Pos);
                        String ca = "";
                        for (int j = 0; j < tsp.size(); j++) {
                            ca += tsp.get(j).getLinea_texto();
                        }
                        out.println(ca);
                    } else {
                        out.println("");
                    }
                    break;
                case "CargarServicioPosicion":
                    out.println("<table>");
                    out.println("<tbody>");
                    if (Tipo.equals("P")) {
                        ArrayList<Solped_Servicios_vis> ser = ACC_SolicitudPedidos.ObtenerInstancia().CargarServiciosSAP(NumSol, Pos);
                        int h;
                        if (ser.size() > 0) {
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
                    } else if (Tipo.equals("M")) {
                        ArrayList<Solped_Servicios_vis> serm = ACC_SolicitudPedidos.ObtenerInstancia().CargarServiciosSAM(NumSol, Pos);
                        int h2;
                        if (serm.size() > 0) {
                            for (h2 = 0; h2 < serm.size(); h2++) {
                                out.println("<tr>");
                                out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
                                out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" value=\"" + serm.get(h2).getNum_posicion_solped() + "\" /></td>");
                                out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" value=\"" + serm.get(h2).getNum_linea() + "\" /></td>");
                                out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" value=\"" + serm.get(h2).getNum_servicio() + "\" /></td>");
                                out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" value=\"" + serm.get(h2).getCantidad() + "\"  /></td>");
                                out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" value=\"" + serm.get(h2).getUnidad_medida_base() + "\" /></td>");
                                out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" value=\"" + serm.get(h2).getTexto_breve() + "\" /></td>");
                                out.println("</tr>");
                            }
                            for (int j = h2; j < 10; j++) {
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
