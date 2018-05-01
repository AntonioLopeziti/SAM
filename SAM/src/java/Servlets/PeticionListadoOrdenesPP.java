/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_ListadoOrdenesPP;
import AccesoDatos.Consultas;
import Entidades.ListadoOrdenesPP;
import Entidades.StatusOrdenes;
import Entidades.folios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionListadoOrdenesPP", urlPatterns = {"/PeticionListadoOrdenesPP"})
public class PeticionListadoOrdenesPP extends HttpServlet {

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
            String action = request.getParameter("action");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");
            String centro = request.getParameter("centro");
            String folio = request.getParameter("folio");
            String material = request.getParameter("material");

            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();

            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("LT");
            folios fn = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("NP");

            switch (action) {
                case "tablaListado":
                    int cc = 0;
                    String s = "";
                    ArrayList<ListadoOrdenesPP> lo = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPP();
                    out.println("<table id=\"TabBody\">\n"
                            + "                                <tbody>");
                    for (ListadoOrdenesPP ll : lo) {
                        out.println("	    <tr>\n"
                                + "	    <td><input id=\"ckhNum\" onclick=\"PintaFila("+cc+")\" type=\"radio\" name=\"gender\" value=\"" + cc + "\"></td>\n"
                                + "	    <td>" + ll.getHabilitado() + "</td>\n"
                                + "	    <td id=\"tdPP1" + cc + "\">" + ll.getClase_documento_ventas() + "</td>\n"
                                + "	    <td id=\"tdPP2" + cc + "\">" + ll.getNum_orden() + "</td>\n"
                                + "	    <td id=\"tdPC3" + cc + "\">" + ll.getCentro() + "</td>\n"
                                + //Centro
                                "	    <td id=\"tdPP4" + cc + "\">" + ll.getNum_material() + "</td>\n"
                                + "	    <td id=\"tdPP5" + cc + "\">" + ll.getTexto_material() + "</td>\n"
                                + "	    <td id=\"tdPP6" + cc + "\">" + ll.getStatus() + "</td>\n"
                                + "	    <td id=\"tdPP7" + cc + "\">" + ll.getCantidad_total() + "</td>\n"
                                + "	    <td id=\"tdPPP1" + cc + "\">" + ll.getMensaje() + "</td>\n"
                                + "	    <td id=\"tdPP8" + cc + "\">" + ll.getFecha_inicio_extrema() + "</td>\n"
                                + "	    <td id=\"tdPP9" + cc + "\">" + ll.getContador_notificacion() + "</td>\n"
                                + //                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                "	    </tr>");
                        cc++;
                    }
                    for (int i = cc; i < 19; i++) {
                        out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                    }
                    out.println("<tr class=\"ocultar\">\n"
                            + "        <td>00</td>\n"
                            + "        <td>0000000</td>\n"
                            + "        <td>000000</td>\n"
                            + "        <td>00000000</td>\n"
                            + "        <td>000000</td>\n"
                            + "        <td>000000000</td>\n"
                            + "        <td>0000000000000000000000000000000000000000000</td>\n"
                            + "        <td>0000000000000000000000000000000000000000000</td>\n"
                            + "        <td>00000000000</td>\n"
                            + "        <td>00000000000000000000000000000</td>\n"
                            + "        <td>00000000000</td>\n"
                            + "        <td>00000000</td>\n"
                            + "    </tr>\n"
                            + "</tbody>\n"
                            + "</table>");
                    break;
                case "tablaListadoCentro":
                    int ccc = 0;
                    ArrayList<ListadoOrdenesPP> llo = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPPCentro(centro);
                    if (llo.size() > 0) {
                        out.println("<table id=\"TabBody\">\n"
                                + "                                <tbody>");
                        for (ListadoOrdenesPP ll : llo) {
                            out.println("	    <tr>\n"
                                    + "	    <td><input id=\"ckhNum\" type=\"radio\" name=\"gender\" value=\"" + ccc + "\"></td>\n"
                                    + "	    <td>" + ll.getHabilitado() + "</td>\n"
                                    + "	    <td id=\"tdPP1" + ccc + "\">" + ll.getClase_documento_ventas() + "</td>\n"
                                    + "	    <td id=\"tdPP2" + ccc + "\">" + ll.getNum_orden() + "</td>\n"
                                    + "	    <td id=\"tdPC3" + ccc + "\">" + ll.getCentro() + "</td>\n"
                                    + //Centro
                                    "	    <td id=\"tdPP4" + ccc + "\">" + ll.getNum_material() + "</td>\n"
                                    + "	    <td id=\"tdPP5" + ccc + "\">" + ll.getTexto_material() + "</td>\n"
                                    + "	    <td id=\"tdPP6" + ccc + "\">" + ll.getStatus() + "</td>\n"
                                    + "	    <td id=\"tdPP7" + ccc + "\">" + ll.getCantidad_total() + "</td>\n"
                                    + "	    <td id=\"tdPPP1" + ccc + "\">" + ll.getMensaje() + "</td>\n"
                                    + "	    <td id=\"tdPP8" + ccc + "\">" + ll.getFecha_inicio_extrema() + "</td>\n"
                                    + "	    <td id=\"tdPP9" + ccc + "\">" + ll.getContador_notificacion() + "</td>\n"
                                    + //                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                    "	    </tr>");
                            ccc++;
                        }
                        for (int i = ccc; i < 19; i++) {
                            out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "        <td>00</td>\n"
                                + "        <td>0000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "    </tr>\n"
                                + "</tbody>\n"
                                + "</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "tablaListadoFolio":
                    int f = 0;
                    ArrayList<ListadoOrdenesPP> lloo = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPPFolio(folio);
                    if (lloo.size() > 0) {
                        out.println("<table id=\"TabBody\">\n"
                                + "                                <tbody>");
                        for (ListadoOrdenesPP ll : lloo) {
                            out.println("	    <tr>\n"
                                    + "	    <td><input id=\"ckhNum\" type=\"radio\" name=\"gender\" value=\"" + f + "\"></td>\n"
                                    + "	    <td>" + ll.getHabilitado() + "</td>\n"
                                    + "	    <td id=\"tdPP1" + f + "\">" + ll.getClase_documento_ventas() + "</td>\n"
                                    + "	    <td id=\"tdPP2" + f + "\">" + ll.getNum_orden() + "</td>\n"
                                    + "	    <td id=\"tdPC3" + f + "\">" + ll.getCentro() + "</td>\n"
                                    + //Centro
                                    "	    <td id=\"tdPP4" + f + "\">" + ll.getNum_material() + "</td>\n"
                                    + "	    <td id=\"tdPP5" + f + "\">" + ll.getTexto_material() + "</td>\n"
                                    + "	    <td id=\"tdPP6" + f + "\">" + ll.getStatus() + "</td>\n"
                                    + "	    <td id=\"tdPP7" + f + "\">" + ll.getCantidad_total() + "</td>\n"
                                    + "	    <td id=\"tdPPP1" + f + "\">" + ll.getMensaje() + "</td>\n"
                                    + "	    <td id=\"tdPP8" + f + "\">" + ll.getFecha_inicio_extrema() + "</td>\n"
                                    + "	    <td id=\"tdPP9" + f + "\">" + ll.getContador_notificacion() + "</td>\n"
                                    + //                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                    "	    </tr>");
                            f++;
                        }
                        for (int i = f; i < 19; i++) {
                            out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "        <td>00</td>\n"
                                + "        <td>0000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "    </tr>\n"
                                + "</tbody>\n"
                                + "</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "tablaListadoMaterial":
                    int m = 0;
                    ArrayList<ListadoOrdenesPP> lfoo = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPPMaterial(material);
                    if (lfoo.size() > 0) {
                        out.println("<table id=\"TabBody\">\n"
                                + "                                <tbody>");
                        for (ListadoOrdenesPP ll : lfoo) {
                            out.println("	    <tr>\n"
                                    + "	    <td><input id=\"ckhNum\" type=\"radio\" name=\"gender\" value=\"" + m + "\"></td>\n"
                                    + "	    <td>" + ll.getHabilitado() + "</td>\n"
                                    + "	    <td id=\"tdPP1" + m + "\">" + ll.getClase_documento_ventas() + "</td>\n"
                                    + "	    <td id=\"tdPP2" + m + "\">" + ll.getNum_orden() + "</td>\n"
                                    + "	    <td id=\"tdPC3" + m + "\">" + ll.getCentro() + "</td>\n"
                                    + //Centro
                                    "	    <td id=\"tdPP4" + m + "\">" + ll.getNum_material() + "</td>\n"
                                    + "	    <td id=\"tdPP5" + m + "\">" + ll.getTexto_material() + "</td>\n"
                                    + "	    <td id=\"tdPP6" + m + "\">" + ll.getStatus() + "</td>\n"
                                    + "	    <td id=\"tdPP7" + m + "\">" + ll.getCantidad_total() + "</td>\n"
                                    + "	    <td id=\"tdPPP1" + m + "\">" + ll.getMensaje() + "</td>\n"
                                    + "	    <td id=\"tdPP8" + m + "\">" + ll.getFecha_inicio_extrema() + "</td>\n"
                                    + "	    <td id=\"tdPP9" + m + "\">" + ll.getContador_notificacion() + "</td>\n"
                                    + //                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                    "	    </tr>");
                            m++;
                        }
                        for (int i = m; i < 19; i++) {
                            out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "        <td>00</td>\n"
                                + "        <td>0000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "    </tr>\n"
                                + "</tbody>\n"
                                + "</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "tablaListadoCenFol":
                    int cf = 0;
                    ArrayList<ListadoOrdenesPP> lcf = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPPCenFol(centro, folio);
                    if (lcf.size() > 0) {
                        out.println("<table id=\"TabBody\">\n"
                                + "                                <tbody>");
                        for (ListadoOrdenesPP ll : lcf) {
                            out.println("	    <tr>\n"
                                    + "	    <td><input id=\"ckhNum\" type=\"radio\" name=\"gender\" value=\"" + cf + "\"></td>\n"
                                    + "	    <td>" + ll.getHabilitado() + "</td>\n"
                                    + "	    <td id=\"tdPP1" + cf + "\">" + ll.getClase_documento_ventas() + "</td>\n"
                                    + "	    <td id=\"tdPP2" + cf + "\">" + ll.getNum_orden() + "</td>\n"
                                    + "	    <td id=\"tdPC3" + cf + "\">" + ll.getCentro() + "</td>\n"
                                    + //Centro
                                    "	    <td id=\"tdPP4" + cf + "\">" + ll.getNum_material() + "</td>\n"
                                    + "	    <td id=\"tdPP5" + cf + "\">" + ll.getTexto_material() + "</td>\n"
                                    + "	    <td id=\"tdPP6" + cf + "\">" + ll.getStatus() + "</td>\n"
                                    + "	    <td id=\"tdPP7" + cf + "\">" + ll.getCantidad_total() + "</td>\n"
                                    + "	    <td id=\"tdPPP1" + cf + "\">" + ll.getMensaje() + "</td>\n"
                                    + "	    <td id=\"tdPP8" + cf + "\">" + ll.getFecha_inicio_extrema() + "</td>\n"
                                    + "	    <td id=\"tdPP9" + cf + "\">" + ll.getContador_notificacion() + "</td>\n"
                                    + //                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                    "	    </tr>");
                            cf++;
                        }
                        for (int i = cf; i < 19; i++) {
                            out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "        <td>00</td>\n"
                                + "        <td>0000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "    </tr>\n"
                                + "</tbody>\n"
                                + "</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "tablaListadoCenMat":
                    int cm = 0;
                    ArrayList<ListadoOrdenesPP> lcm = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPPCenMat(centro, material);
                    if (lcm.size() > 0) {
                        out.println("<table id=\"TabBody\">\n"
                                + "                                <tbody>");
                        for (ListadoOrdenesPP ll : lcm) {
                            out.println("	    <tr>\n"
                                    + "	    <td><input id=\"ckhNum\" type=\"radio\" name=\"gender\" value=\"" + cm + "\"></td>\n"
                                    + "	    <td>" + ll.getHabilitado() + "</td>\n"
                                    + "	    <td id=\"tdPP1" + cm + "\">" + ll.getClase_documento_ventas() + "</td>\n"
                                    + "	    <td id=\"tdPP2" + cm + "\">" + ll.getNum_orden() + "</td>\n"
                                    + "	    <td id=\"tdPC3" + cm + "\">" + ll.getCentro() + "</td>\n"
                                    + //Centro
                                    "	    <td id=\"tdPP4" + cm + "\">" + ll.getNum_material() + "</td>\n"
                                    + "	    <td id=\"tdPP5" + cm + "\">" + ll.getTexto_material() + "</td>\n"
                                    + "	    <td id=\"tdPP6" + cm + "\">" + ll.getStatus() + "</td>\n"
                                    + "	    <td id=\"tdPP7" + cm + "\">" + ll.getCantidad_total() + "</td>\n"
                                    + "	    <td id=\"tdPPP1" + cm + "\">" + ll.getMensaje() + "</td>\n"
                                    + "	    <td id=\"tdPP8" + cm + "\">" + ll.getFecha_inicio_extrema() + "</td>\n"
                                    + "	    <td id=\"tdPP9" + cm + "\">" + ll.getContador_notificacion() + "</td>\n"
                                    + //                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                    "	    </tr>");
                            cm++;
                        }
                        for (int i = cm; i < 19; i++) {
                            out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "        <td>00</td>\n"
                                + "        <td>0000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "    </tr>\n"
                                + "</tbody>\n"
                                + "</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "tablaListadoFolMat":
                    int fm = 0;
                    ArrayList<ListadoOrdenesPP> lfm = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPPFolMat(folio, material);
                    if (lfm.size() > 0) {
                        out.println("<table id=\"TabBody\">\n"
                                + "                                <tbody>");
                        for (ListadoOrdenesPP ll : lfm) {
                            out.println("	    <tr>\n"
                                    + "	    <td><input id=\"ckhNum\" type=\"radio\" name=\"gender\" value=\"" + fm + "\"></td>\n"
                                    + "	    <td>" + ll.getHabilitado() + "</td>\n"
                                    + "	    <td id=\"tdPP1" + fm + "\">" + ll.getClase_documento_ventas() + "</td>\n"
                                    + "	    <td id=\"tdPP2" + fm + "\">" + ll.getNum_orden() + "</td>\n"
                                    + "	    <td id=\"tdPC3" + fm + "\">" + ll.getCentro() + "</td>\n"
                                    + //Centro
                                    "	    <td id=\"tdPP4" + fm + "\">" + ll.getNum_material() + "</td>\n"
                                    + "	    <td id=\"tdPP5" + fm + "\">" + ll.getTexto_material() + "</td>\n"
                                    + "	    <td id=\"tdPP6" + fm + "\">" + ll.getStatus() + "</td>\n"
                                    + "	    <td id=\"tdPP7" + fm + "\">" + ll.getCantidad_total() + "</td>\n"
                                    + "	    <td id=\"tdPPP1" + fm + "\">" + ll.getMensaje() + "</td>\n"
                                    + "	    <td id=\"tdPP8" + fm + "\">" + ll.getFecha_inicio_extrema() + "</td>\n"
                                    + "	    <td id=\"tdPP9" + fm + "\">" + ll.getContador_notificacion() + "</td>\n"
                                    + //                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                    "	    </tr>");
                            fm++;
                        }
                        for (int i = fm; i < 19; i++) {
                            out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "        <td>00</td>\n"
                                + "        <td>0000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "        <td>000000</td>\n"
                                + "        <td>000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>0000000000000000000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000000000000000000000000</td>\n"
                                + "        <td>00000000000</td>\n"
                                + "        <td>00000000</td>\n"
                                + "    </tr>\n"
                                + "</tbody>\n"
                                + "</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "guardaStatus":
                    StatusOrdenes so = new StatusOrdenes();
                    so.setFolio_sam("LT" + fo.getFolioActual());
                    so.setFolio_orden(v1);
                    so.setFecha_serv(fechaActual);
                    so.setHora_serv(horaActual);
                    so.setNum_orden(v2);
                    so.setCentro(v3);
                    so.setOperacion_sam(v4);
                    so.setUsuario(v5);
                    ACC_ListadoOrdenesPP.ObtenerInstancia().guardaStatusOrden(so);
                    ACC_ListadoOrdenesPP.ObtenerInstancia().CambiaStatusOrden(so, v6);
                    out.println("LT" + fo.getFolioActual());
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("LT", fo.getFolioActual());
                    break;
                case "guardaStatusNoti":
                    StatusOrdenes sn = new StatusOrdenes();
                    sn.setFolio_orden(v1);
                    sn.setFolio_sam("NP" + fn.getFolioActual());
                    sn.setFecha_serv(fechaActual);
                    sn.setHora_serv(horaActual);
                    sn.setNum_orden(v2);
                    sn.setCentro(v3);
                    sn.setOperacion_sam(v4);
                    sn.setUsuario(v5);
                    ACC_ListadoOrdenesPP.ObtenerInstancia().guardaStatusOrden(sn);
                    ACC_ListadoOrdenesPP.ObtenerInstancia().CambiaStatusOrden(sn, v6);
                    out.println("NP" + fn.getFolioActual());
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("NP", fn.getFolioActual());
                    break;
                case "guardaHabilitado":
                    StatusOrdenes ss = new StatusOrdenes();
                    ss.setNum_orden(v1);
                    ss.setFolio_sam(v2);
                    ss.setOperacion_sam(v3);
                    ss.setStatus(v4);
                    ss.setCentro(v5);
                    ss.setNum_lote(v6);//Número de Material
                    ACC_ListadoOrdenesPP.ObtenerInstancia().GuardaHabilitado(ss);
                    break;
                case "truncarControl":
                    ACC_ListadoOrdenesPP.ObtenerInstancia().truncateControl();
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
