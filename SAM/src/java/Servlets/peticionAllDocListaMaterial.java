/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_DetallesDocMateriales;
import Entidades.detalles_doc_materiales;
import Entidades.movimientos_detalle_crea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "peticionAllDocListaMaterial", urlPatterns = {"/peticionAllDocListaMaterial"})
public class peticionAllDocListaMaterial extends HttpServlet {

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

            String accion = request.getParameter("Action");
            HttpSession session = request.getSession();
            String material = (String) session.getAttribute("MiMaterial");
            String material2 = (String) session.getAttribute("MiMaterial2");
            String centro = (String) session.getAttribute("MiCentro");
            String almacen = (String) session.getAttribute("MiAlmacen");
            String lote = (String) session.getAttribute("MiLote");
            String proveedor = (String) session.getAttribute("MiProveedor");
            String clasem = (String) session.getAttribute("MiClaseM");
            String cantidad = (String) session.getAttribute("MiCantidad");
            String fechacon = (String) session.getAttribute("MiFecha");

            String id = request.getParameter("ID");
            session.setAttribute("MiI", id);

            String mate11 = request.getParameter("MATER1");
            String mate2 = request.getParameter("MATER2");
            String centrt = request.getParameter("CENT");
            String almac = request.getParameter("ALMA");
            String loet = request.getParameter("LOET");
            String prove = request.getParameter("PROVE");
            String clase = request.getParameter("CLASS");
            String limite = request.getParameter("LIMITE");

            if (cantidad == "") {
                cantidad = "10000";
            } else {
                cantidad = cantidad;
            }

            switch (accion) {
                case "ConsultaVacia":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    LinkedList<detalles_doc_materiales> det = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaVaciaDocTable(cantidad);
                    LinkedList<detalles_doc_materiales> det1 = ACC_DetallesDocMateriales.ObtenerInstancia().SeleccionaMovDetalle();
                    for (int i = 0; i < det1.size(); i++) {
                        out.println("<tr ondblclick=\"Select('" + det1.get(i).getNum_doc_material() + "', '" + det1.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + det1.get(i).getNum_material() + "</td>");
                        out.println("<td>" + det1.get(i).getNum_material() + "</td>");
                        out.println("<td>" + det1.get(i).getDescripcion_ES() + "</td>");
                        out.println("<td>" + det1.get(i).getCentro() + "</td>");
                        out.println("<td>" + det1.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + det1.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + det1.get(i).getClase_movimiento() + "</td>");
                        out.println("<td>" + det1.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + det1.get(i).getIndicador_stock_especial() + "</td>");
                        out.println("<td>" + det1.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + det1.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + det1.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + det1.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + det1.get(i).getNombre1() + "</td>");
                        out.println("<td>" + det1.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + det1.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    for (int j = 0; j < det.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + det.get(j).getNum_doc_material() + "','" + det.get(j).getFolio_sam() + "');\" >");
                        out.println("<td>" + det.get(j).getNum_material() + "</td>");
                        out.println("<td>" + det.get(j).getDescripcion_ES() + "</td>");
                        out.println("<td>" + det.get(j).getCentro() + "</td>");
                        out.println("<td>" + det.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + det.get(j).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + det.get(j).getClase_movimiento() + "</td>");
                        out.println("<td>" + det.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + det.get(j).getIndicador_stock_especial() + "</td>");
                        out.println("<td>" + det.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + det.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + det.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + det.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + det.get(j).getNombre1() + "</td>");
                        out.println("<td>" + det.get(j).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + det.get(j).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>0000000000000000</td>"
                            + "<td>000000000000000000000000000000000000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>000000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000000</td>"
                            + "<td>000000</td>"
                            + "<td>0000000000000000000000000000</td>"
                            + "<td>00000000000000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>000000000000000000000000000000000000000000</td>"
                            + "<td>000000000000000000000000</td>"
                            + "<td>00000000</td>"
                            + "</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
//                case "ConsultaFiltrada":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    det = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaFiltradaDoc(cantidad, material, centro, almacen, fechacon, lote, proveedor, clasem);
//                    for (int i = 0; i < det.size(); i++) {
//                        out.println("<tr ondblclick=\"Select('" + det.get(i).getNum_doc_material() + "','" + det.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + det.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + det.get(i).getCentro() + "</td>");
//                        out.println("<td>" + det.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + det.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + det.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + det.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + det.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + det.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + det.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + det.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + det.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + det.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "Filtros":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    LinkedList<detalles_doc_materiales> ddm = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaFiltrosDocTable(cantidad);
//                    LinkedList<movimientos_detalle_crea> md = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleFiltros();
//                    for (int j = 0; j < md.size(); j++) {
//                        out.println("<tr ondblclick=\"Select('" + md.get(j).getNum_doc_material() + "', '" + md.get(j).getFolio_sam() + "');\">");
//                        out.println("<td>" + md.get(j).getNum_material() + "</td>");
//                        out.println("<td>" + md.get(j).getCentro() + "</td>");
//                        out.println("<td>" + md.get(j).getAlmacen() + "</td>");
//                        out.println("<td>" + md.get(j).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + md.get(j).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + md.get(j).getNum_doc_material() + "</td>");
//                        out.println("<td>" + md.get(j).getFolio_sam() + "</td>");
//                        out.println("<td>" + md.get(j).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + md.get(j).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + md.get(j).getFecha() + "</td>");
//                        out.println("<td>" + md.get(j).getCantidad1() + "</td>");
//                        out.println("<td>" + md.get(j).getUnidad_medidabase() + "</td>");
//                        out.println("</tr>");
//                    }
//                    for (int i = 0; i < ddm.size(); i++) {
//                        out.print("<tr ondblclick=\"Select('" + ddm.get(i).getNum_doc_material() + "','" + ddm.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + ddm.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + ddm.get(i).getCentro() + "</td>");
//                        out.println("<td>" + ddm.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + ddm.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + ddm.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + ddm.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + ddm.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + ddm.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + ddm.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + ddm.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + ddm.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + ddm.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "Material":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    String letra = material.substring(0,1);
//                    if(letra.equals(" ")){
//                    LinkedList<detalles_doc_materiales> mateva = ACC_DetallesDocMateriales.ObtenerInstancia().MM_ConsultaMaterialesEspacio(cantidad, material, centro, almacen, proveedor, clasem, fechacon);
////                    LinkedList<movimientos_detalle_crea> mateval = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleMaterial(cantidad, material, centro, almacen, proveedor, clasem, fechacon);
//                    for (int i = 0; i < mateva.size(); i++) {
//                        out.print("<tr ondblclick=\"Select('" + mateva.get(i).getNum_doc_material() + "','" + mateva.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + mateva.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + mateva.get(i).getCentro() + "</td>");
//                        out.println("<td>" + mateva.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + mateva.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + mateva.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + mateva.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + mateva.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + mateva.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + mateva.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + mateva.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + mateva.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + mateva.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    }else{
//                    LinkedList<detalles_doc_materiales> mat1 = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMaterialDocTable(cantidad, material, centro, almacen, proveedor, clasem, fechacon);
//                    LinkedList<movimientos_detalle_crea> mate1 = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleMaterial(cantidad, material, centro, almacen, proveedor, clasem, fechacon);
//                    for (int j = 0; j < mate1.size(); j++) {
//                        out.println("<tr ondblclick=\"Select('" + mate1.get(j).getNum_doc_material() + "', '" + mate1.get(j).getFolio_sam() + "');\">");
//                        out.println("<td>" + mate1.get(j).getNum_material() + "</td>");
//                        out.println("<td>" + mate1.get(j).getCentro() + "</td>");
//                        out.println("<td>" + mate1.get(j).getAlmacen() + "</td>");
//                        out.println("<td>" + mate1.get(j).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + mate1.get(j).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + mate1.get(j).getNum_doc_material() + "</td>");
//                        out.println("<td>" + mate1.get(j).getFolio_sam() + "</td>");
//                        out.println("<td>" + mate1.get(j).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + mate1.get(j).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + mate1.get(j).getFecha() + "</td>");
//                        out.println("<td>" + mate1.get(j).getCantidad1() + "</td>");
//                        out.println("<td>" + mate1.get(j).getUnidad_medidabase() + "</td>");
//                        out.println("</tr>");
//                    }
//                    for (int i = 0; i < mat1.size(); i++) {
//                        out.print("<tr ondblclick=\"Select('" + mat1.get(i).getNum_doc_material() + "','" + mat1.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + mat1.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + mat1.get(i).getCentro() + "</td>");
//                        out.println("<td>" + mat1.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + mat1.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + mat1.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + mat1.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + mat1.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + mat1.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + mat1.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + mat1.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + mat1.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + mat1.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "RangosMaterial":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    LinkedList<detalles_doc_materiales> rang = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaRangosMatDocTable(cantidad, material, material2, centro, almacen, proveedor, clasem, fechacon);
//                    LinkedList<movimientos_detalle_crea> rangos = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleRangosMaterial(cantidad, material, material2, centro, almacen, proveedor, clasem, fechacon);
//
//                    for (int j = 0; j < rangos.size(); j++) {
//                        out.println("<tr ondblclick=\"Select('" + rangos.get(j).getNum_doc_material() + "', '" + rangos.get(j).getFolio_sam() + "');\">");
//                        out.println("<td>" + rangos.get(j).getNum_material() + "</td>");
//                        out.println("<td>" + rangos.get(j).getCentro() + "</td>");
//                        out.println("<td>" + rangos.get(j).getAlmacen() + "</td>");
//                        out.println("<td>" + rangos.get(j).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + rangos.get(j).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + rangos.get(j).getNum_doc_material() + "</td>");
//                        out.println("<td>" + rangos.get(j).getFolio_sam() + "</td>");
//                        out.println("<td>" + rangos.get(j).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + rangos.get(j).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + rangos.get(j).getFecha() + "</td>");
//                        out.println("<td>" + rangos.get(j).getCantidad1() + "</td>");
//                        out.println("<td>" + rangos.get(j).getUnidad_medidabase() + "</td>");
//                        out.println("</tr>");
//                    }
//                    for (int i = 0; i < rang.size(); i++) {
//                        out.print("<tr ondblclick=\"Select('" + rang.get(i).getNum_doc_material() + "','" + rang.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + rang.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + rang.get(i).getCentro() + "</td>");
//                        out.println("<td>" + rang.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + rang.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + rang.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + rang.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + rang.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + rang.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + rang.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + rang.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + rang.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + rang.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "Centro":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    LinkedList<detalles_doc_materiales> cent = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaCentroDocTable(cantidad, centro, almacen, proveedor, clasem, fechacon);
//                    LinkedList<movimientos_detalle_crea> centr = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleCentros(cantidad, centro, almacen, proveedor, clasem, fechacon);
//                    for (int j = 0; j < centr.size(); j++) {
//                        out.println("<tr ondblclick=\"Select('" + centr.get(j).getNum_doc_material() + "', '" + centr.get(j).getFolio_sam() + "');\">");
//                        out.println("<td>" + centr.get(j).getNum_material() + "</td>");
//                        out.println("<td>" + centr.get(j).getCentro() + "</td>");
//                        out.println("<td>" + centr.get(j).getAlmacen() + "</td>");
//                        out.println("<td>" + centr.get(j).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + centr.get(j).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + centr.get(j).getNum_doc_material() + "</td>");
//                        out.println("<td>" + centr.get(j).getFolio_sam() + "</td>");
//                        out.println("<td>" + centr.get(j).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + centr.get(j).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + centr.get(j).getFecha() + "</td>");
//                        out.println("<td>" + centr.get(j).getCantidad1() + "</td>");
//                        out.println("<td>" + centr.get(j).getUnidad_medidabase() + "</td>");
//                        out.println("</tr>");
//                    }
//                    for (int i = 0; i < cent.size(); i++) {
//                        out.print("<tr ondblclick=\"Select('" + cent.get(i).getNum_doc_material() + "','" + cent.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + cent.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + cent.get(i).getCentro() + "</td>");
//                        out.println("<td>" + cent.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + cent.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + cent.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + cent.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + cent.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + cent.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + cent.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + cent.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + cent.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + cent.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "Almacen":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    LinkedList<detalles_doc_materiales> alma = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaAlmacenDocTable(cantidad, centro, almacen, proveedor, clasem, fechacon);
//                    LinkedList<movimientos_detalle_crea> cen = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleAlmacen(cantidad, centro, almacen, proveedor, clasem, fechacon);
//
//                    for (int j = 0; j < cen.size(); j++) {
//                        out.println("<tr ondblclick=\"Select('" + cen.get(j).getNum_doc_material() + "', '" + cen.get(j).getFolio_sam() + "');\">");
//                        out.println("<td>" + cen.get(j).getNum_material() + "</td>");
//                        out.println("<td>" + cen.get(j).getCentro() + "</td>");
//                        out.println("<td>" + cen.get(j).getAlmacen() + "</td>");
//                        out.println("<td>" + cen.get(j).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + cen.get(j).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + cen.get(j).getNum_doc_material() + "</td>");
//                        out.println("<td>" + cen.get(j).getFolio_sam() + "</td>");
//                        out.println("<td>" + cen.get(j).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + cen.get(j).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + cen.get(j).getFecha() + "</td>");
//                        out.println("<td>" + cen.get(j).getCantidad1() + "</td>");
//                        out.println("<td>" + cen.get(j).getUnidad_medidabase() + "</td>");
//                        out.println("</tr>");
//                    }
//                    for (int i = 0; i < alma.size(); i++) {
//                        out.print("<tr ondblclick=\"Select('" + alma.get(i).getNum_doc_material() + "','" + alma.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + alma.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + alma.get(i).getCentro() + "</td>");
//                        out.println("<td>" + alma.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + alma.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + alma.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + alma.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + alma.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + alma.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + alma.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + alma.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + alma.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + alma.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "proveedor":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    LinkedList<detalles_doc_materiales> prov = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaProveedorDocTable(cantidad, centro, almacen, proveedor, clasem, fechacon);
//                    LinkedList<movimientos_detalle_crea> dor = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleProveedor(cantidad, centro, almacen, proveedor, clasem, fechacon);
//                    for (int j = 0; j < dor.size(); j++) {
//                        out.println("<tr ondblclick=\"Select('" + dor.get(j).getNum_doc_material() + "', '" + dor.get(j).getFolio_sam() + "');\">");
//                        out.println("<td>" + dor.get(j).getNum_material() + "</td>");
//                        out.println("<td>" + dor.get(j).getCentro() + "</td>");
//                        out.println("<td>" + dor.get(j).getAlmacen() + "</td>");
//                        out.println("<td>" + dor.get(j).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + dor.get(j).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + dor.get(j).getNum_doc_material() + "</td>");
//                        out.println("<td>" + dor.get(j).getFolio_sam() + "</td>");
//                        out.println("<td>" + dor.get(j).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + dor.get(j).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + dor.get(j).getFecha() + "</td>");
//                        out.println("<td>" + dor.get(j).getCantidad1() + "</td>");
//                        out.println("<td>" + dor.get(j).getUnidad_medidabase() + "</td>");
//                        out.println("</tr>");
//                    }
//                    for (int i = 0; i < prov.size(); i++) {
//                        out.print("<tr ondblclick=\"Select('" + prov.get(i).getNum_doc_material() + "','" + prov.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + prov.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + prov.get(i).getCentro() + "</td>");
//                        out.println("<td>" + prov.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + prov.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + prov.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + prov.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + prov.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + prov.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + prov.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + prov.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + prov.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + prov.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "ClaseMovimiento":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    LinkedList<detalles_doc_materiales> mov = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaClMovimientoDocTable(cantidad, centro, almacen, proveedor, clasem, fechacon);
//                    LinkedList<movimientos_detalle_crea> ento = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleCMovimiento(cantidad, clasem, fechacon);
//
//                    for (int j = 0; j < ento.size(); j++) {
//                        out.println("<tr ondblclick=\"Select('" + ento.get(j).getNum_doc_material() + "','" + ento.get(j).getFolio_sam() + "');\">");
//                        out.println("<td>" + ento.get(j).getNum_material() + "</td>");
//                        out.println("<td>" + ento.get(j).getCentro() + "</td>");
//                        out.println("<td>" + ento.get(j).getAlmacen() + "</td>");
//                        out.println("<td>" + ento.get(j).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + ento.get(j).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + ento.get(j).getNum_doc_material() + "</td>");
//                        out.println("<td>" + ento.get(j).getFolio_sam() + "</td>");
//                        out.println("<td>" + ento.get(j).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + ento.get(j).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + ento.get(j).getFecha() + "</td>");
//                        out.println("<td>" + ento.get(j).getCantidad1() + "</td>");
//                        out.println("<td>" + ento.get(j).getUnidad_medidabase() + "</td>");
//                        out.println("</tr>");
//                    }
//                    for (int i = 0; i < mov.size(); i++) {
//                        out.print("<tr ondblclick=\"Select('" + mov.get(i).getNum_doc_material() + "','" + mov.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + mov.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + mov.get(i).getCentro() + "</td>");
//                        out.println("<td>" + mov.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + mov.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + mov.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + mov.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + mov.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + mov.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + mov.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + mov.get(i).getFecha_contabilizacion() + "</td>");
//                        out.println("<td>" + mov.get(i).getCantidad_unidad_medida_entrada() + "</td>");
//                        out.println("<td>" + mov.get(i).getUnidad_medida_entrada() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "FechaContable":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    LinkedList<detalles_doc_materiales> movs = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDocTabla(cantidad, clasem, centro, almacen, proveedor, fechacon);
//                    LinkedList<movimientos_detalle_crea> entos = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaTablaMovCrea(cantidad, clasem, fechacon);
//                    for (int i = 0; i < entos.size(); i++) {
//                        out.println("<tr> ondblclick=\"Select('" + entos.get(i).getNum_doc_material() + "', '" + entos.get(i).getFolio_sam() + "');\">");
//                        out.println("<td>" + entos.get(i).getNum_material() + "</td>");
//                        out.println("<td>" + entos.get(i).getCentro() + "</td>");
//                        out.println("<td>" + entos.get(i).getAlmacen() + "</td>");
//                        out.println("<td>" + entos.get(i).getAlmacen_destino() + "</td>");
//                        out.println("<td>" + entos.get(i).getClase_movimiento() + "</td>");
//                        out.println("<td> </td>");
//                        out.println("<td>" + entos.get(i).getNum_doc_material() + "</td>");
//                        out.println("<td>" + entos.get(i).getFolio_sam() + "</td>");
//                        out.println("<td>" + entos.get(i).getNum_posicion_doc_compras() + "</td>");
//                        out.println("<td>" + entos.get(i).getNum_cuenta_proveedor() + "</td>");
//                        out.println("<td>" + entos.get(i).getFecha() + "</td>");
//                        out.println("<td>" + entos.get(i).getCantidad1() + "</td>");
//                        out.println("<td>" + entos.get(i).getUnidad_medidabase() + "</td>");
//                        out.println("</tr>");
//                    }
//                    out.println("<tr class=\"ocultar\">"
//                            + "<td>000000000000000000000000000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>000000000000</td>"
//                            + "<td>0000000000000000</td>"
//                            + "<td>000000000000000</td>"
//                            + "<td>000000</td>"
//                            + "<td>000000000000000000000000000</td>"
//                            + "<td>000000000000000000000</td>"
//                            + "<td>000000000000 00</td>"
//                            + "<td>00000000000000000000000000 0</td>"
//                            + "<td>00000000000000000</td>"
//                            + "<td>000000000000000000000000</td>"
//                            + "<td>0000000000</td>"
//                            + "</tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
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
