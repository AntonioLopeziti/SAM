/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CotizacionesSD;
import AccesoDatos.Consultas;
import Entidades.SD_cotizaciones_cabecera;
import Entidades.SD_posiciones_cotizaciones;
import Entidades.SD_posiciones_cotizaciones_condicion;
import Entidades.SD_posiciones_cotizaciones_expedicion;
import Entidades.SD_posiciones_cotizaciones_repartos;
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
@WebServlet(name = "peticionVisualizarCotizacionSD", urlPatterns = {"/peticionVisualizarCotizacionSD"})
public class peticionVisualizarCotizacionSD extends HttpServlet {

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
            String Clase = request.getParameter("Clase");
            String Can = request.getParameter("Ctd");
            String TipoC = request.getParameter("TipoConsulta");
            String Posicion = request.getParameter("Posicion");
            Consultas c = new Consultas();
            switch (Accion) {
                case "ConsultaMCOferta":
                    ArrayList<SD_cotizaciones_cabecera> mc = ACC_CotizacionesSD.ObtenerInstancia().MCDocumentos(Documento, Clase, Can);
                    if (mc.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mc.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + mc.get(i).getDocumento_ventas() + "')\">");
                            out.println("<td>" + mc.get(i).getClase_documento() + "</td>");
                            out.println("<td>" + mc.get(i).getDocumento_ventas() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "VerificarDocumento":
                    int docu = ACC_CotizacionesSD.ObtenerInstancia().VerificarDocumento(Documento);
                    out.println(docu);
                    break;
                case "CargarCabecera":
                    JSONArray j = new JSONArray();
                    if (TipoC.equals("1")) {
                        SD_cotizaciones_cabecera co = ACC_CotizacionesSD.ObtenerInstancia().GetCabecera(Documento);
                        j.add(co.getClase_documento().trim());
                        j.add(co.getDocumento_ventas().trim());
                        j.add(co.getSolicitante().trim());
                        j.add(co.getTexto_solicitante().trim());
                        j.add(co.getDestinatario_mercancias().trim());
                        j.add(co.getTexto_destinatario().trim());
                        j.add(co.getNum_pedido_cliente().trim());
                        j.add(c.DateFormat(co.getFecha_pedido_compras().trim()));
                        j.add(co.getOrganizacion_ventas().trim());
                        j.add(co.getCanal_distribucion().trim());
                        j.add(co.getSector().trim());
                        j.add(co.getArea_ventas().trim());
                        j.add(co.getOficina_ventas().trim());
                        j.add(co.getDenominacion_oficina().trim());
                        j.add(co.getGrupo_vendedores().trim());
                        j.add(co.getDenominacion_grupov().trim());
                        j.add(c.DateFormat(co.getFecha_documento().trim()));
                        j.add(co.getValor_neto().trim());
                        j.add(co.getMoneda_doc_comercial().trim());
                        j.add(co.getResponsable().trim());
                        j.add(co.getMotivo_pedido().trim());
                        j.add(c.DateFormat(co.getFecha_determinacion_precios()).trim());
                        j.add(c.DateFormat(co.getFecha().trim()));
                        j.add(co.getNum_condicion_documento().trim());
                        j.add(c.DateFormat(co.getFecha_valido_de().trim()));
                        j.add(c.DateFormat(co.getFecha_valido_a().trim()));
                        out.println(j);
                    }
                    if (TipoC.equals("0")) {
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
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        out.println(j);
                    }
                    break;
                case "CargarPosicion":
                    out.println("<table id=\"TabBody2\">");
                    out.println("<tbody>");
                    if (TipoC.equals("0")) {
                        for (int k = 0; k < 9; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    }
                    if (TipoC.equals("1")) {
                        ArrayList<SD_posiciones_cotizaciones> pos = ACC_CotizacionesSD.ObtenerInstancia().GetPosiciones(Documento);
                        if (pos.size() > 0) {
                            int n;
                            for (n = 0; n < pos.size(); n++) {
                                out.println("<tr ondblclick=\"GetItemP('" + pos.get(n).getNum_doc_comercial() + "','" + pos.get(n).getPosicion_doc_comercial() + "', '1')\">");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + CerosIzqu(pos.get(n).getPosicion_doc_comercial()) + "</td>");
                                out.println("<td>" + pos.get(n).getMaterial() + "</td>");
                                out.println("<td>" + pos.get(n).getCantidad_pedido() + "</td>");
                                out.println("<td>" + pos.get(n).getUnidad_medida_venta() + "</td>");
                                out.println("<td><input type=\"checkbox\" disabled " + CheckR(pos.get(n).getExisten_repartos()) + "/></td>");
                                out.println("<td>" + pos.get(n).getPosicion_superior() + "</td>");
                                out.println("<td>" + pos.get(n).getMaterial_cliente() + "</td>");
                                out.println("<td>" + pos.get(n).getTipo_posicion_doc_comercial() + "</td>");
                                out.println("<td>" + pos.get(n).getPerfil_indicador_merca_peli() + "</td>");
                                out.println("<td>" + pos.get(n).getPosicion_superior() + "</td>");
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
                    out.println("<tr class=\"ocultar\"><td>00</td><td>000000</td><td>00000000000</td><td>00000000000000</td><td>0000</td><td>000</td><td>0000000000000000000000</td><td>0000000000000000000000</td><td>0000000</td><td>0000000000000</td><td>00000000</td><td>00000000000000000</td><td>00000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CargarPosExpedicion":
                    JSONArray k = new JSONArray();
                    if (TipoC.equals("1")) {
                        SD_posiciones_cotizaciones_expedicion co = ACC_CotizacionesSD.ObtenerInstancia().GetExpedicion(Documento, Posicion);
                        k.add(co.getCentro().trim());
                        k.add(co.getDenominacion_centro().trim());
                        k.add(co.getPriotidad_entrega().trim());
                        k.add(co.getDenominacion_prioridad_entrega().trim());
                        k.add(co.getAlmacen().trim());
                        k.add(co.getDenominacion_almacen().trim());
                        k.add(co.getPuesto_expedcion().trim());
                        k.add(co.getDenominacion_puesto_expedicion().trim());
                        k.add(co.getRuta().trim());
                        k.add(co.getDenominacion_ruta().trim());
                        k.add(co.getPeso_neto().trim());
                        k.add(co.getUnidad_medida_peso().trim());
                        k.add(co.getPeso_bruto().trim());
                        out.println(k);
                    }
                    if (TipoC.equals("0")) {
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        k.add("");
                        out.println(k);
                    }
                    break;
                case "CargarPosCampos":
                    JSONArray l = new JSONArray();
                    if (TipoC.equals("0")) {
                        l.add("");
                        l.add("");
                        l.add("");
                        l.add("");
                        l.add("");
                        l.add("");
                        l.add("");
                        l.add("");
                        out.println(l);
                    }
                    if (TipoC.equals("1")) {
                        SD_posiciones_cotizaciones ca = ACC_CotizacionesSD.ObtenerInstancia().CargarCampos(Documento, Posicion);
                        l.add(ca.getCantidad().trim());
                        l.add(ca.getUnidad_medida_venta().trim());
                        l.add(ca.getValor_neta().trim());
                        l.add(ca.getMoneda_doc_comercial().trim());
                        l.add(ca.getImporte_impuesto().trim());
                        l.add(ca.getDenominacion_status_tratamiento_global().trim());
                        l.add(ca.getMotivo_rechazo().trim() + " " + ca.getDenominacion_sociedad_co().trim());
                        l.add(ca.getDenominacion_status_entrega().trim());
                        out.println(l);
                    }
                    break;
                case "CargarTablaCondiciones":
                    out.println("<table id=\"TabBody3\">");
                    out.println("<tbody>");
                    if (TipoC.equals("1")) {
                        ArrayList<SD_posiciones_cotizaciones_condicion> co = ACC_CotizacionesSD.ObtenerInstancia().GetTableCondicion(Documento, Posicion);
                        if (co.size() > 0) {
                            int x;
                            for (x = 0; x < co.size(); x++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td><img src='images/" + SemaforoInactive(co.get(x).getVisualizacion_condiciones_inactivas().trim()) + ".PNG' /></td>");
                                out.println("<td>" + co.get(x).getClase_condicion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getDenominacion_clase_condicion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getImporte().trim() + "</td>");
                                out.println("<td>" + co.get(x).getClave_moneda().trim() + "</td>");
                                out.println("<td>" + co.get(x).getCantidad_base_condicion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getUnidad_medida_condicion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getValor_condicion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getClave_moneda().trim() + "</td>");
                                out.println("<td>" + co.get(x).getContador_conversion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getUnidad_medida_base().trim() + "</td>");
                                out.println("<td>" + co.get(x).getDenominacor_cov_condicion().trim() + "</td>");
                                out.println("<td>" + co.get(x).getUnidad_medida_condicion2().trim() + "</td>");
                                out.println("<td>" + co.get(x).getValor_condicion2().trim() + "</td>");
                                out.println("<td>" + co.get(x).getMoneda_condicion().trim() + "</td>");
                                out.println("<td><input type=\"checkbox\" disabled " + CheckR(co.get(x).getCondicion_estadistica().trim()) + "/></td>");
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
                    if (TipoC.equals("0")) {
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
                    if (TipoC.equals("1")) {
                        ArrayList<SD_posiciones_cotizaciones_repartos> rep = ACC_CotizacionesSD.ObtenerInstancia().GetReparto(Documento, Posicion);
                        if (rep.size() > 0) {
                            int b;
                            for (b = 0; b < rep.size(); b++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>" + rep.get(b).getTipo_fecha().trim() + "</td>");
                                out.println("<td>" + c.DateFormat(rep.get(b).getFecha_reparto().trim()) + "</td>");
                                out.println("<td>" + rep.get(b).getCantidad_pedido().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getCantidad_corregida().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getCantidad_confirmada().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getUnidad_medida_venta().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getBloqueo_entrega().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getUnidad_medida_b().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getTipo_posicion_reparto().trim() + "</td>");
                                out.println("<td>" + rep.get(b).getNum_solped_pedido().trim() + "</td>");
                                out.println("<td>" + CerosIzqu(rep.get(b).getNum_posicion_solped_pedido().trim()) + "</td>");
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
                    if (TipoC.equals("0")) {
                        for (int y = 0; y < 6; y++) {
                            out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\"><td>00</td><td>0000000000000</td><td>000000000000000</td><td>0000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td><td>0000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CabRep":
                    ArrayList<SD_posiciones_cotizaciones_repartos> r = ACC_CotizacionesSD.ObtenerInstancia().GetReparto(Documento, Posicion);
                    JSONArray j1 = new JSONArray();
                    if (TipoC.equals("0")) {
                        j1.add("");
                        j1.add("");
                        j1.add("");
                        j1.add("");
                        out.println(j1);
                    }
                    if (TipoC.equals("1")) {
                        j1.add(r.get(0).getPlazo_entrega().trim());
                        j1.add(r.get(0).getCantidad_pedido().trim());
                        j1.add(r.get(0).getUnidad_medida_venta().trim());
                        j1.add(r.get(0).getCantidad_requerida().trim());
                        out.println(j1);
                    }
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
