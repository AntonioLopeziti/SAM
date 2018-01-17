/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_ReporteReservas;
import AccesoDatos.ACC_SolpedReporte;
import AccesoDatos.ACC_Solped_cabecera2;
import Entidades.solped_cabecera2;
import AccesoDatos.ACC_Solped_posiciones2;
import AccesoDatos.Conexion;
import Entidades.Solped_posiciones;
import Entidades.ReporteSolPed;
import Entidades.reserva_cabecera_crea;
import Entidades.reserva_posiciones_crea;
import Entidades.reservas_materiales;
import Entidades.solped_cabecera;
import Entidades.Listareservas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PeticionVisualizarReportesReservas2", urlPatterns = {"/PeticionVisualizarReportesReservas2"})
public class PeticionVisualizarReportesReservas2 extends HttpServlet {

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
            String accion = request.getParameter("Action");

            String reserva = (String) session.getAttribute("reserva");
            String posicion = (String) session.getAttribute("posicion");
            String fecha1 = (String) session.getAttribute("fecha1");
            String reserva2 = (String) session.getAttribute("reserva2");
            String posicion2 = (String) session.getAttribute("posicion2");
            String fecha2 = (String) session.getAttribute("fecha2");
            String centro = (String) session.getAttribute("centro");
            String clase = (String) session.getAttribute("clase");
            String material = (String) session.getAttribute("material");
            String solicitante = (String) session.getAttribute("almacen");
            String usuario = (String) session.getAttribute("usuario");
            String texto = (String) session.getAttribute("orden");
            String coste = (String) session.getAttribute("coste");

            switch (accion) {
                case "ConsultaVacia":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> a = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterial();
                    ArrayList<reserva_posiciones_crea> b = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasposiciones();
                    ArrayList<reserva_cabecera_crea> c = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmateriales();
                    for (int i = 0; i < a.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + a.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + a.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + a.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + a.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + a.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + a.get(i).getCentro() + "</td>");
                        out.println("<td>" + a.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + a.get(i).getNum_material() + "</td>");
                        out.println("<td>" + a.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + a.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + a.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + a.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + a.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + a.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + a.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < b.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + b.get(i).getFolio_sam() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + b.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + b.get(i).getCentro() + "</td>");
                        out.println("<td>" + b.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + b.get(i).getNum_material() + "</td>");
                        out.println("<td>" + b.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + b.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + b.get(i).getUnidad_medida_base() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + b.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + b.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < c.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + c.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + c.get(i).getFecha() + "</td>");
                        out.println("<td>" + c.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + c.get(i).getCentro() + "</td>");
                        out.println("<td>" + c.get(i).getAlmacen() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + c.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + c.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + c.get(i).getUsuario() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "Centro":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> d = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterialCentro(centro);
                    ArrayList<reserva_posiciones_crea> e = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasposicionesCentro(centro);
                    ArrayList<reserva_cabecera_crea> f = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterialesCentro(centro);
                    for (int i = 0; i < d.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + d.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + d.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + d.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + d.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + d.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + d.get(i).getCentro() + "</td>");
                        out.println("<td>" + d.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + d.get(i).getNum_material() + "</td>");
                        out.println("<td>" + d.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + d.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + d.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + d.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + d.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + d.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + d.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < e.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + e.get(i).getFolio_sam() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + e.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + e.get(i).getCentro() + "</td>");
                        out.println("<td>" + e.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + e.get(i).getNum_material() + "</td>");
                        out.println("<td>" + e.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + e.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + e.get(i).getUnidad_medida_base() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + e.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + e.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < f.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + f.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + f.get(i).getFecha() + "</td>");
                        out.println("<td>" + f.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + f.get(i).getCentro() + "</td>");
                        out.println("<td>" + f.get(i).getAlmacen() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + f.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + f.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + f.get(i).getUsuario() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "Rangosreservas":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> g = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterialRangosReservas(reserva, reserva2);
                    for (int i = 0; i < g.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + g.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + g.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + g.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + g.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + g.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + g.get(i).getCentro() + "</td>");
                        out.println("<td>" + g.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + g.get(i).getNum_material() + "</td>");
                        out.println("<td>" + g.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + g.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + g.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + g.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + g.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + g.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + g.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }

                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "Reserva":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> h = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterialReservas(reserva);
                    for (int i = 0; i < h.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + h.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + h.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + h.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + h.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + h.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + h.get(i).getCentro() + "</td>");
                        out.println("<td>" + h.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + h.get(i).getNum_material() + "</td>");
                        out.println("<td>" + h.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + h.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + h.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + h.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + h.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + h.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + h.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "RangosFecha":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> j = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterialRangosFechas(fecha1, fecha2);
                    ArrayList<reserva_cabecera_crea> k = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterialesRangosFecha(fecha1, fecha2);
                    for (int i = 0; i < j.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + j.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + j.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + j.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + j.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + j.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + j.get(i).getCentro() + "</td>");
                        out.println("<td>" + j.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + j.get(i).getNum_material() + "</td>");
                        out.println("<td>" + j.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + j.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + j.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + j.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + j.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + j.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + j.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < k.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + k.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + k.get(i).getFecha() + "</td>");
                        out.println("<td>" + k.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + k.get(i).getCentro() + "</td>");
                        out.println("<td>" + k.get(i).getAlmacen() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + k.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + k.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + k.get(i).getUsuario() + "</td>");
                    }

                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "Fecha":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> l = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterialFechas(fecha1);
                    ArrayList<reserva_cabecera_crea> m = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ConsultaVaciaReservasmaterialesFecha(fecha1);
                    for (int i = 0; i < l.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + l.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + l.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + l.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + l.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + l.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + l.get(i).getCentro() + "</td>");
                        out.println("<td>" + l.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + l.get(i).getNum_material() + "</td>");
                        out.println("<td>" + l.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + l.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + l.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + l.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + l.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + l.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + l.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < m.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + m.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + m.get(i).getFecha() + "</td>");
                        out.println("<td>" + m.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + m.get(i).getCentro() + "</td>");
                        out.println("<td>" + m.get(i).getAlmacen() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + m.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + m.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + m.get(i).getUsuario() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "ClaseMovimiento":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> n = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ReservasmaterialClaseMovimiento(clase);
                    ArrayList<reserva_posiciones_crea> o = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ReservasposicionesClaseMovimiento(clase);
                    ArrayList<reserva_cabecera_crea> p = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ReservasmaterialesClaseMovimiento(clase);
                    for (int i = 0; i < n.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + n.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + n.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + n.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + n.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + n.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + n.get(i).getCentro() + "</td>");
                        out.println("<td>" + n.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + n.get(i).getNum_material() + "</td>");
                        out.println("<td>" + n.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + n.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + n.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + n.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + n.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + n.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + n.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < o.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + o.get(i).getFolio_sam() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + o.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + o.get(i).getCentro() + "</td>");
                        out.println("<td>" + o.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + o.get(i).getNum_material() + "</td>");
                        out.println("<td>" + o.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + o.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + o.get(i).getUnidad_medida_base() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + o.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + o.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < p.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + p.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + p.get(i).getFecha() + "</td>");
                        out.println("<td>" + p.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + p.get(i).getCentro() + "</td>");
                        out.println("<td>" + p.get(i).getAlmacen() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + p.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + p.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + p.get(i).getUsuario() + "</td>");
                    }

                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "Material":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> q = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ReservasmaterialMaterial(material);
                    ArrayList<reserva_posiciones_crea> r = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ReservasposicionesMaterial(material);
                    for (int i = 0; i < q.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + q.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + q.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + q.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + q.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + q.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + q.get(i).getCentro() + "</td>");
                        out.println("<td>" + q.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + q.get(i).getNum_material() + "</td>");
                        out.println("<td>" + q.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + q.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + q.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + q.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + q.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + q.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + q.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < r.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + r.get(i).getFolio_sam() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + r.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + r.get(i).getCentro() + "</td>");
                        out.println("<td>" + r.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + r.get(i).getNum_material() + "</td>");
                        out.println("<td>" + r.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + r.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + r.get(i).getUnidad_medida_base() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + r.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + r.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }

                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "solicitante":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reserva_cabecera_crea> s = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ReservasmaterialesSolicitante(solicitante);
                    for (int i = 0; i < s.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + s.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + s.get(i).getFecha() + "</td>");
                        out.println("<td>" + s.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + s.get(i).getCentro() + "</td>");
                        out.println("<td>" + s.get(i).getAlmacen() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + s.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + s.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + s.get(i).getUsuario() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                case "TextoBreve":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                    ArrayList<reservas_materiales> t = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ReservasmaterialTextoBreve(texto);
                    ArrayList<reserva_posiciones_crea> v = ACC_ReporteReservas.ObtenerInstancia().SP_MM_ReservasposicionesTextoBreve(texto);
                    for (int i = 0; i < t.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + t.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + t.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + t.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + t.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + t.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + t.get(i).getCentro() + "</td>");
                        out.println("<td>" + t.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + t.get(i).getNum_material() + "</td>");
                        out.println("<td>" + t.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + t.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + t.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + t.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + t.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + t.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + t.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < v.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + v.get(i).getFolio_sam() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + v.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + v.get(i).getCentro() + "</td>");
                        out.println("<td>" + v.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + v.get(i).getNum_material() + "</td>");
                        out.println("<td>" + v.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + v.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + v.get(i).getUnidad_medida_base() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + v.get(i).getNum_orden() + "</td>");
                        out.println("<td>&nbsp</td>");
                        out.println("<td>" + v.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
                    case "Todos":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    out.println("</tr>");
                     ArrayList<reservas_materiales> materiales = ACC_ReporteReservas.ObtenerInstancia().MM_Listareservas_Materiales(reserva,reserva2,centro,fecha1,fecha2,clase,solicitante,material,texto);
                    ArrayList<Listareservas> reservascrea = ACC_ReporteReservas.ObtenerInstancia().MM_Listareservas_Crea(centro,fecha1,fecha2,clase,solicitante,material,texto);
                    for (int i = 0; i < materiales.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + materiales.get(i).getNum_reservas() + "</td>");
                        out.println("<td>" + materiales.get(i).getNum_posicion() + "</td>");
                        out.println("<td>" + materiales.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + materiales.get(i).getFec_necesidad() + "</td>");
                        out.println("<td>" + materiales.get(i).getClase_movimientos() + "</td>");
                        out.println("<td>" + materiales.get(i).getCentro() + "</td>");
                        out.println("<td>" + materiales.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + materiales.get(i).getNum_material() + "</td>");
                        out.println("<td>" + materiales.get(i).getTexto_posicion() + "</td>");
                        out.println("<td>" + materiales.get(i).getCantidad_necesaria() + "</td>");
                        out.println("<td>" + materiales.get(i).getUnidad_medida() + "</td>");
                        out.println("<td>" + materiales.get(i).getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + materiales.get(i).getNum_orden() + "</td>");
                        out.println("<td>" + materiales.get(i).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + materiales.get(i).getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>&nbsp</td>");
                    }
                    for (int i = 0; i < reservascrea.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>"+reservascrea.get(i).getNum_reservas()+"</td>");
                        out.println("<td>"+reservascrea.get(i).getNum_posicion()+"</td>");
                        out.println("<td>" +reservascrea.get(i).getFolio_sam()+ "</td>");
                        out.println("<td>"+reservascrea.get(i).getFecha()+"</td>");
                        out.println("<td>"+reservascrea.get(i).getClase_movimiento()+ "</td>");
                        out.println("<td>" +reservascrea.get(i).getCentro()+ "</td>");
                        out.println("<td>" +reservascrea.get(i).getAlmacen()+"</td>");
                        out.println("<td>" +reservascrea.get(i).getNum_material()+ "</td>");
                        out.println("<td>" +reservascrea.get(i).getTexto_posicion()+ "</td>");
                        out.println("<td>" +reservascrea.get(i).getCantidad_necesaria()+ "</td>");
                        out.println("<td>" +reservascrea.get(i).getUnidad_medida_base()+ "</td>");
                        out.println("<td>"+reservascrea.get(i).getCant_unidad_entrada()+"</td>");
                        out.println("<td>" +reservascrea.get(i).getNum_orden()+ "</td>");
                        out.println("<td>"+reservascrea.get(i).getNum_cuenta_mayor()+"</td>");
                        out.println("<td>" +reservascrea.get(i).getAlmacen_destino()+ "</td>");
                        out.println("<td>"+reservascrea.get(i).getUsuario()+"</td>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>00000000000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");    
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
