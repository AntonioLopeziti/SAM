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
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "peticionAllDocumentosLstMaterial", urlPatterns = {"/peticionAllDocumentosLstMaterial"})
public class peticionAllDocumentosLstMaterial extends HttpServlet {

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

            //String ub = request.getParameter("q");
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
            /*Datos nuevas consultas*/
            String query1;
            String query2;
            String query3;

            if (cantidad == "") {
                cantidad = "10000";
            } else {
                cantidad = cantidad;
            }
            /*----------------------*/

            switch (accion) {
                case "ConsultaVacia":
                    String query = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material order by fecha_contabilizacion_doc desc";
                    query1 = "SELECT * FROM movimientos_detalle_crea order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");
                    String col;
                    //LinkedList<String[]> docmat = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query);
                    LinkedList<detalles_doc_materiales> det = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query);
                    LinkedList<movimientos_detalle_crea> mdc = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query1);
                    for (int j = 0; j < mdc.size(); j++) {
                        //out.println("<tr ondblclick=\"Select(" + mdc.get(j).getNum_doc_material() + ");\">");
                        out.println("<tr ondblclick=\"Select('" + mdc.get(j).getNum_doc_material() + "', '" + mdc.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + mdc.get(j).getNum_material() + "</td>");
                        out.println("<td>" + mdc.get(j).getCentro() + "</td>");
                        out.println("<td>" + mdc.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + mdc.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + mdc.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + mdc.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + mdc.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + mdc.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + mdc.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + mdc.get(j).getFecha() + "</td>");
                        out.println("<td>" + mdc.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + mdc.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < det.size(); i++) {
                        //String[] d = det.get(i);
                        out.print("<tr ondblclick=\"Select('" + det.get(i).getNum_doc_material() + "','" + det.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + det.get(i).getNum_material() + "</td>");
                        out.println("<td>" + det.get(i).getCentro() + "</td>");
                        out.println("<td>" + det.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + det.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + det.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + det.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + det.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + det.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + det.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + det.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + det.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + det.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
//                      out.println("</tbody>");
                    }

                    out.println("</table>");
                    //un material
                    break;
                case "ConsultaFiltrada":
                    String queryF3 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material"
                            + "WHERE ddm.num_doc_material LIKE '" + material + "%' "
                            + "AND ddm.centro LIKE '" + centro + "%' "
                            + "AND ddm.almacen LIKE '" + almacen + "%' "
                            + "AND cdm.fecha_contabilizacion_doc LIKE '" + fechacon + "%' "
                            + "AND ddm.num_lote LIKE '" + lote + "%' "
                            + "AND ddm.num_cuenta_proveedor LIKE '" + proveedor + "%' "
                            + "AND ddm.clase_movimiento LIKE '" + clasem + "%' order by fecha_contabilizacion_doc desc";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    det = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(queryF3);

                    for (int i = 0; i < det.size(); i++) {
                        //String[] d = det.get(i);

                        out.print("<tr ondblclick=\"Select('" + det.get(i).getNum_doc_material() + "','" + det.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + det.get(i).getNum_material() + "</td>");
                        out.println("<td>" + det.get(i).getCentro() + "</td>");
                        out.println("<td>" + det.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + det.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + det.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + det.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + det.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + det.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + det.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + det.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + det.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + det.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
//                      out.println("</tbody>");
                    }

                    out.println("</table>");
                    //un material
                    break;
                case "Filtros":
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material CROSS JOIN movimientos_detalle_crea order by fecha_contabilizacion_doc desc";
                    query1 = "SELECT * FROM movimientos_detalle_crea order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");
                    LinkedList<detalles_doc_materiales> ddm = ACC_DetallesDocMateriales.ObtenerInstancia().SelectDetallesMateriales(query2);
                    LinkedList<movimientos_detalle_crea> md = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query1);
                    for (int j = 0; j < md.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + md.get(j).getNum_doc_material() + "', '" + md.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + md.get(j).getNum_material() + "</td>");
                        out.println("<td>" + md.get(j).getCentro() + "</td>");
                        out.println("<td>" + md.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + md.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + md.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + md.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + md.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + md.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + md.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + md.get(j).getFecha() + "</td>");
                        out.println("<td>" + md.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + md.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < ddm.size(); i++) {
                        out.print("<tr ondblclick=\"Select('" + ddm.get(i).getNum_doc_material() + "','" + ddm.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + ddm.get(i).getNum_material() + "</td>");
                        out.println("<td>" + ddm.get(i).getCentro() + "</td>");
                        out.println("<td>" + ddm.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + ddm.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + ddm.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + ddm.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + ddm.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + ddm.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + ddm.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + ddm.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + ddm.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + ddm.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");
                    //un material
                    break;
                case "Material":
                    query1 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material WHERE ddm.num_material LIKE '" + material + "%' AND almacen LIKE '" + almacen + "%' and centro LIKE '" + centro + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha_contabilizacion_doc LIKE '%" + fechacon + "%' order by fecha_contabilizacion_doc desc";
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM movimientos_detalle_crea WHERE num_material LIKE '" + material + "%' AND centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha LIKE '%" + fechacon + "%' order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    LinkedList<detalles_doc_materiales> mat1 = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query1);
                    LinkedList<movimientos_detalle_crea> mate1 = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query2);
                    for (int j = 0; j < mate1.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + mate1.get(j).getNum_doc_material() + "', '" + mate1.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + mate1.get(j).getNum_material() + "</td>");
                        out.println("<td>" + mate1.get(j).getCentro() + "</td>");
                        out.println("<td>" + mate1.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + mate1.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + mate1.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + mate1.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + mate1.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + mate1.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + mate1.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + mate1.get(j).getFecha() + "</td>");
                        out.println("<td>" + mate1.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + mate1.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < mat1.size(); i++) {
                        //String[] d = mat1.get(i);

                        out.print("<tr ondblclick=\"Select('" + mat1.get(i).getNum_doc_material() + "','" + mat1.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + mat1.get(i).getNum_material() + "</td>");
                        out.println("<td>" + mat1.get(i).getCentro() + "</td>");
                        out.println("<td>" + mat1.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + mat1.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + mat1.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + mat1.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + mat1.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + mat1.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + mat1.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + mat1.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + mat1.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + mat1.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    break;
                case "RangosMaterial":
                    query1 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material WHERE (ddm.num_material BETWEEN '" + material + "' AND '" + material2 + "') AND centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha_contabilizacion_doc LIKE '%" + fechacon + "%' order by fecha_contabilizacion_doc desc";
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM movimientos_detalle_crea WHERE (num_material BETWEEN '" + material + "' AND '" + material2 + "') AND centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha LIKE '%" + fechacon + "%' order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    LinkedList<detalles_doc_materiales> rang = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query1);
                    LinkedList<movimientos_detalle_crea> rangos = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query2);
                    for (int j = 0; j < rangos.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + rangos.get(j).getNum_doc_material() + "', '" + rangos.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + rangos.get(j).getNum_material() + "</td>");
                        out.println("<td>" + rangos.get(j).getCentro() + "</td>");
                        out.println("<td>" + rangos.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + rangos.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + rangos.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + rangos.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + rangos.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + rangos.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + rangos.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + rangos.get(j).getFecha() + "</td>");
                        out.println("<td>" + rangos.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + rangos.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < rang.size(); i++) {
                        //String[] d = rang.get(i);

                        out.print("<tr ondblclick=\"Select('" + rang.get(i).getNum_doc_material() + "','" + rang.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + rang.get(i).getNum_material() + "</td>");
                        out.println("<td>" + rang.get(i).getCentro() + "</td>");
                        out.println("<td>" + rang.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + rang.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + rang.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + rang.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + rang.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + rang.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + rang.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + rang.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + rang.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + rang.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    break;
                case "Centro":
                    query1 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material WHERE ddm.centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha_contabilizacion_doc LIKE '%" + fechacon + "%' order by fecha_contabilizacion_doc desc";
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM movimientos_detalle_crea WHERE centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND clase_movimiento LIKE '" + clasem + "%' and fecha LIKE '%" + fechacon + "%' order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    LinkedList<detalles_doc_materiales> cent = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query1);
                    LinkedList<movimientos_detalle_crea> centr = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query2);
                    for (int j = 0; j < centr.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + centr.get(j).getNum_doc_material() + "', '" + centr.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + centr.get(j).getNum_material() + "</td>");
                        out.println("<td>" + centr.get(j).getCentro() + "</td>");
                        out.println("<td>" + centr.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + centr.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + centr.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + centr.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + centr.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + centr.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + centr.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + centr.get(j).getFecha() + "</td>");
                        out.println("<td>" + centr.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + centr.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < cent.size(); i++) {
                        //String[] d = cent.get(i);

                        out.print("<tr ondblclick=\"Select('" + cent.get(i).getNum_doc_material() + "','" + cent.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + cent.get(i).getNum_material() + "</td>");
                        out.println("<td>" + cent.get(i).getCentro() + "</td>");
                        out.println("<td>" + cent.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + cent.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + cent.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + cent.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + cent.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + cent.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + cent.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + cent.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + cent.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + cent.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    break;
                case "Almacen":
                    query1 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material WHERE ddm.almacen LIKE '" + almacen + "%' AND centro LIKE '" + centro + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha_contabilizacion_doc LIKE '%" + fechacon + "%'order by fecha_contabilizacion_doc desc";
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM movimientos_detalle_crea WHERE almacen LIKE '" + almacen + "%' AND centro LIKE '" + centro + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha LIKE '%" + fechacon + "%' order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    LinkedList<detalles_doc_materiales> alma = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query1);
                    LinkedList<movimientos_detalle_crea> cen = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query2);
                    for (int j = 0; j < cen.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + cen.get(j).getNum_doc_material() + "', '" + cen.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + cen.get(j).getNum_material() + "</td>");
                        out.println("<td>" + cen.get(j).getCentro() + "</td>");
                        out.println("<td>" + cen.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + cen.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + cen.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + cen.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + cen.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + cen.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + cen.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + cen.get(j).getFecha() + "</td>");
                        out.println("<td>" + cen.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + cen.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < alma.size(); i++) {
                        //String[] d = alma.get(i);

                        out.print("<tr ondblclick=\"Select('" + alma.get(i).getNum_doc_material() + "','" + alma.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + alma.get(i).getNum_material() + "</td>");
                        out.println("<td>" + alma.get(i).getCentro() + "</td>");
                        out.println("<td>" + alma.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + alma.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + alma.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + alma.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + alma.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + alma.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + alma.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + alma.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + alma.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + alma.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    break;
                case "Lote":
                    query1 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material WHERE ddm.num_lote LIKE '" + lote + "%' AND fecha_contabilizacion_doc LIKE '%" + fechacon + "%' order by fecha_contabilizacion_doc desc";
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM movimientos_detalle_crea WHERE num_lote LIKE '" + lote + "%' AND fecha LIKE '%" + fechacon + "%' order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    LinkedList<detalles_doc_materiales> lo = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query1);
                    LinkedList<movimientos_detalle_crea> te = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query2);
                    for (int j = 0; j < te.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + te.get(j).getNum_doc_material() + "', '" + te.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + te.get(j).getNum_material() + "</td>");
                        out.println("<td>" + te.get(j).getCentro() + "</td>");
                        out.println("<td>" + te.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + te.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + te.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + te.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + te.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + te.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + te.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + te.get(j).getFecha() + "</td>");
                        out.println("<td>" + te.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + te.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < lo.size(); i++) {
                        //String[] d = lo.get(i);

                        out.print("<tr ondblclick=\"Select('" + lo.get(i).getNum_doc_material() + "','" + lo.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + lo.get(i).getNum_material() + "</td>");
                        out.println("<td>" + lo.get(i).getCentro() + "</td>");
                        out.println("<td>" + lo.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + lo.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + lo.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + lo.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + lo.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + lo.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + lo.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + lo.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + lo.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + lo.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    break;
                case "proveedor":
                    query1 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material WHERE ddm.num_cuenta_proveedor LIKE '" + proveedor + "%' AND centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha_contabilizacion_doc LIKE '%" + fechacon + "%' order by fecha_contabilizacion_doc desc";
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM movimientos_detalle_crea WHERE num_cuenta_proveedor LIKE '" + proveedor + "%' AND centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND clase_movimiento LIKE '" + clasem + "%' AND fecha LIKE '%" + fechacon + "%' order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    LinkedList<detalles_doc_materiales> prov = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query1);
                    LinkedList<movimientos_detalle_crea> dor = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query2);
                    for (int j = 0; j < dor.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + dor.get(j).getNum_doc_material() + "', '" + dor.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + dor.get(j).getNum_material() + "</td>");
                        out.println("<td>" + dor.get(j).getCentro() + "</td>");
                        out.println("<td>" + dor.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + dor.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + dor.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + dor.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + dor.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + dor.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + dor.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + dor.get(j).getFecha() + "</td>");
                        out.println("<td>" + dor.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + dor.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < prov.size(); i++) {
                        //String[] d = prov.get(i);

                        out.print("<tr ondblclick=\"Select('" + prov.get(i).getNum_doc_material() + "','" + prov.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + prov.get(i).getNum_material() + "</td>");
                        out.println("<td>" + prov.get(i).getCentro() + "</td>");
                        out.println("<td>" + prov.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + prov.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + prov.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + prov.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + prov.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + prov.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + prov.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + prov.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + prov.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + prov.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    break;
                case "ClaseMovimiento":
                    query1 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material WHERE ddm.clase_movimiento LIKE '" + clasem + "%' AND centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' fecha_contabilizacion_doc LIKE '%" + fechacon + "%' order by fecha_contabilizacion_doc desc";
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM movimientos_detalle_crea WHERE clase_movimiento LIKE '" + clasem + "%' AND fecha LIKE '%" + fechacon + "%' order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    LinkedList<detalles_doc_materiales> mov = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query1);
                    LinkedList<movimientos_detalle_crea> ento = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query2);
                    for (int j = 0; j < ento.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + ento.get(j).getNum_doc_material() + "', '" + ento.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + ento.get(j).getNum_material() + "</td>");
                        out.println("<td>" + ento.get(j).getCentro() + "</td>");
                        out.println("<td>" + ento.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + ento.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + ento.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + ento.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + ento.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + ento.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + ento.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + ento.get(j).getFecha() + "</td>");
                        out.println("<td>" + ento.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + ento.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < mov.size(); i++) {
                        //String[] d = mov.get(i);

                        out.print("<tr ondblclick=\"Select('" + mov.get(i).getNum_doc_material() + "','" + mov.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + mov.get(i).getNum_material() + "</td>");
                        out.println("<td>" + mov.get(i).getCentro() + "</td>");
                        out.println("<td>" + mov.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + mov.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + mov.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + mov.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + mov.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + mov.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + mov.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + mov.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + mov.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + mov.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    break;
                case "FechaContable":
                    query1 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM detalles_doc_materiales ddm INNER JOIN cabecera_doc_materiales cdm ON ddm.num_doc_material = cdm.num_doc_material WHERE ddm.clase_movimiento LIKE '" + clasem + "%' AND centro LIKE '" + centro + "%' AND almacen LIKE '" + almacen + "%' AND num_cuenta_proveedor LIKE '" + proveedor + "%' AND cdm.fecha_contabilizacion_doc LIKE '%" + fechacon + "%' order by fecha_contabilizacion_doc desc";
                    query2 = "SELECT DISTINCT TOP(" + cantidad + ") * FROM movimientos_detalle_crea WHERE clase_movimiento LIKE '" + clasem + "%' AND fecha LIKE '%" + fechacon + "%' order by fecha desc, indice_registro_no_valido";
                    out.println("<table style=\"padding: auto;margin: auto;\">");
                    out.println("<tr>");
                    out.println("<td><b> Numero Material</b></td>");
                    out.println("<td><b> Centro</b></td>");
                    out.println("<td><b> Almacen </b></td>");
                    out.println("<td><b> Almacen Destino </b></td>");
                    out.println("<td><b> CMv </b></td>");
                    out.println("<td><b> E </b></td>");
                    out.println("<td><b> DocMaterial </b></td>");
                    out.println("<td><b> Folio SAM </b></td>");
                    out.println("<td><b> Pos </b></td>");
                    out.println("<td><b> Proveedor </b></td>");
                    out.println("<td><b> Fe.contab. </b></td>");
                    out.println("<td><b> Ctd.en UM entrada </b></td>");
                    out.println("<td><b> UM </b></td>");
                    out.println("</tr>");

                    LinkedList<detalles_doc_materiales> movs = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocTable(query1);
                    LinkedList<movimientos_detalle_crea> entos = ACC_DetallesDocMateriales.ObtenerInstancia().SelectMovimientosDetalles(query2);
                    for (int j = 0; j < entos.size(); j++) {
                        out.println("<tr ondblclick=\"Select('" + entos.get(j).getNum_doc_material() + "', '" + entos.get(j).getFolio_sam() + "');\">");
                        out.println("<td>" + entos.get(j).getNum_material() + "</td>");
                        out.println("<td>" + entos.get(j).getCentro() + "</td>");
                        out.println("<td>" + entos.get(j).getAlmacen() + "</td>");
                        out.println("<td>" + entos.get(j).getAlmacen_destino() + "</td>");
                        out.println("<td>" + entos.get(j).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + entos.get(j).getNum_doc_material() + "</td>");
                        out.println("<td>" + entos.get(j).getFolio_sam() + "</td>");
                        out.println("<td>" + entos.get(j).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + entos.get(j).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + entos.get(j).getFecha() + "</td>");
                        out.println("<td>" + entos.get(j).getCantidad1() + "</td>");
                        out.println("<td>" + entos.get(j).getUnidad_medidabase() + "</td>");
                        out.println("</tr>");
                    }
                    for (int i = 0; i < movs.size(); i++) {
                        //String[] d = mov.get(i);

                        out.print("<tr ondblclick=\"Select('" + movs.get(i).getNum_doc_material() + "','" + movs.get(i).getFolio_sam() + "');\">");
                        out.println("<td>" + movs.get(i).getNum_material() + "</td>");
                        out.println("<td>" + movs.get(i).getCentro() + "</td>");
                        out.println("<td>" + movs.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + movs.get(i).getAlmacen_destino() + "</td>");
                        out.println("<td>" + movs.get(i).getClase_movimiento() + "</td>");
                        out.println("<td> </td>");
                        out.println("<td>" + movs.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + movs.get(i).getFolio_sam() + "</td>");
                        out.println("<td>" + movs.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + movs.get(i).getNum_cuenta_proveedor() + "</td>");
                        out.println("<td>" + movs.get(i).getFecha_contabilizacion() + "</td>");
                        out.println("<td>" + movs.get(i).getCantidad_unidad_medida_entrada() + "</td>");
                        out.println("<td>" + movs.get(i).getUnidad_medida_entrada() + "</td>");
                        out.println("</tr>");
                    }
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
