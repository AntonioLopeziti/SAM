package Servlets;

import AccesoDatos.ACC_Almacenes;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_CentroCosto;
import AccesoDatos.ACC_ClaseInforme;
import AccesoDatos.ACC_CodigosDefecto;
import AccesoDatos.ACC_DetallesDocMateriales;
import AccesoDatos.ACC_Ficheros;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_MaterialesPI;
import AccesoDatos.ACC_MaterialesPlanesInspeccion;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Pedidos;
import AccesoDatos.ACC_Proveedor;
import AccesoDatos.ACC_Reservas;
import AccesoDatos.ACC_Stock;
import AccesoDatos.ACC_TipoMovimientos;
import AccesoDatos.ACC_UnidadesMedida;
import AccesoDatos.Consultas;
import Entidades.CeCos;
import Entidades.CodigosDefecto;
import Entidades.DocumentosDMSenvio;
import Entidades.Stock_Traslado;
import Entidades.MaterialesPI;
import Entidades.almacenes;
import Entidades.centros;
import Entidades.clase_informe;
import Entidades.detalles_doc_materiales;
import Entidades.folios;
import Entidades.materiales;
import Entidades.materialesPlanesInspeccion;
import Entidades.pedido_detalle;
import Entidades.plan_orden;
import Entidades.proveedor;
import Entidades.reserva_posiciones_crea;
import Entidades.stock;
import Entidades.tabla305;
import Entidades.tipo_movimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import java.util.ArrayList;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

@WebServlet(name = "PeticionMovMateriales", urlPatterns = {"/PeticionMovMateriales"})
public class PeticionMovMateriales extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String accion = request.getParameter("Action");
            String idioma = request.getParameter("lang");
            String centro102 = request.getParameter("centro102");
            String almacen102 = request.getParameter("almacen102");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");
            String v7 = request.getParameter("v7");
            String v8 = request.getParameter("v8");
            String v9 = request.getParameter("v9");
            String lote = request.getParameter("lote");
            String ctr = request.getParameter("ctr");
            String clas = request.getParameter("CLM");
            String queryrespos = request.getParameter("q");
            String matelote = request.getParameter("matelote");
            String us = (String) session.getAttribute("Usuario");
            String NDocCom = request.getParameter("DocCom");
            String MlIn = request.getParameter("MLI");
            String Idioma = (String) session.getAttribute("Idioma");
            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            String docEE = request.getParameter("DocEE");
            String docPEE = request.getParameter("DocPEE");

            switch (accion) {
                case "VentanaModalCentro":
                    ArrayList<centros> equ = ACC_Centro.ObtenerInstancia().ConsultaCentros();
                    if (equ.size() > 0) {
                        out.println("<table>"
                                + "<tbody>");
                        for (int i = 0; i < equ.size(); i++) {
                            out.println("<tr ondblclick=\"selecciona('" + equ.get(i).getCentro() + "', 'bxCentro', '" + accion + "')\">");
                            out.println("<td>" + equ.get(i).getCentro() + "</td>");
                            out.println("<td>" + equ.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>"
                                + "</table>");
                    } else {
                        out.println(0 + ",VentanaModalCentro,bxCentro,");
                    }
                    break;
                case "VentanaModalCentroA":
                    ArrayList<centros> equA = ACC_Centro.ObtenerInstancia().ConsultaCentrosAll();
                    if (equA.size() > 0) {
                        out.println("<table>"
                                + "<tbody>");
                        for (int i = 0; i < equA.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + equA.get(i).getCentro() + "', 'bxCentro', 'VentanaModalCentro')\">");
                            out.println("<td>" + equA.get(i).getCentro() + "</td>");
                            out.println("<td>" + equA.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>"
                                + "</table>");
                    } else {
                        out.println(0 + ",VentanaModalCentro,bxCentro,");
                    }
                    break;
                case "CambiaStatus305":
                    String nn = "";
                    for (int i = v2.length(); i < 5; i++) {
                        nn += "0";
                    }
                    nn += v2;
                    String tabla = "detalles_doc_materiales";
                    String campos = "status='" + v4 + "'";
                    String condicion = "num_doc_material = '" + v1 + "' and "
                            + "num_posicion_doc_compras = '" + nn + "' and "
                            + "centro = '" + v3 + "' and "
                            + "clase_movimiento = '303'";
                    Consultas.ObtenerInstancia().Update(tabla, campos, condicion);
                    break;
                case "Valida305":
                    String n = "";
                    for (int i = v2.length(); i < 5; i++) {
                        n += "0";
                    }
                    n += v2;
                    String queeery = "select * from detalles_doc_materiales"
                            + " where clase_movimiento='303' and status = ''"
                            + " and (num_doc_material='" + v1 + "' or folio_sam='" + v1 + "')"
                            + " and num_posicion_doc_compras = '" + n + "'";

                    String dees = "descripcion_" + idioma;
                    detalles_doc_materiales ddms = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetalles(queeery, dees);
                    String string = ddms.getNum_material() + ","
                            + ddms.getDescripcion() + ","
                            + ddms.getCantidad_unidad_medida_entrada() + ","
                            + ddms.getUnidad_medida_entrada() + ","
                            + ddms.getNum_lote();
                    if (!ddms.getNum_material().equals("")) {
                        out.println(string);
                    } else {
                        out.println(0);
                    }
                    break;
                case "VentanaModalDoc":
                    String queery = "select * from detalles_doc_materiales where clase_movimiento='303' and status = ''";
                    String des = "descripcion_" + idioma;
                    LinkedList<detalles_doc_materiales> ddm = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesDocById(queery, des);
                    out.println("<table>"
                            + "<tbody>");
                    for (int i = 0; i < ddm.size(); i++) {
                        String cadena = "";
                        cadena = ddm.get(i).getNum_doc_material() + ","
                                + ddm.get(i).getNum_posicion_doc_compras();

                        out.println("<tr ondblclick=\"seleccionaDoc('" + cadena + "', 'bxDocMat', '" + accion + "')\">");
                        out.println("<td>" + ddm.get(i).getNum_doc_material() + "</td>");
                        out.println("<td>" + ddm.get(i).getNum_posicion_doc_compras() + "</td>");
                        out.println("<td>" + ddm.get(i).getFolio_sam() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>"
                            + "</table>");
                    break;
                case "VentanaModalAlmacen":
                    ArrayList<almacenes> a = ACC_Almacenes.ObtenerInstancia().ConsultaAlmacenen(idioma);
                    if (a.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < a.size(); i++) {
                            out.println("<tr ondblclick=\"selecciona('" + a.get(i).getId_almacen() + "', 'bxAlmacen', '" + accion + "')\">");
                            out.println("<td>" + a.get(i).getCentro() + "</td>");
                            out.println("<td>" + a.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + a.get(i).getNombre_alamcen() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalAlmacen,bxAlmacen,");
                    }
                    break;
                case "VentanaModalAlmacenA"://Nuevo Lalo
                    ArrayList<almacenes> al = ACC_Almacenes.ObtenerInstancia().ConsultaAlmacenenDestino(idioma);
                    if (al.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < al.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionaADE('" + al.get(i).getId_almacen() + "', 'bxAlmacen311', 'VentanaModalAlmacen', '" + al.get(i).getAlmacen_ivend() + "')\">");
                            out.println("<td>" + al.get(i).getCentro() + "</td>");
                            out.println("<td>" + al.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + al.get(i).getNombre_alamcen() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalAlmacen,bxAlmacen311,");
                    }
                    break;
                case "VentanaModalClase":
                    ArrayList<tipo_movimiento> mo = ACC_TipoMovimientos.ObtenerInstancia().ConsultaMovimiento();
                    if (mo.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mo.size(); i++) {
                            out.println("<tr ondblclick=\"selecciona('" + mo.get(i).getid_tipo_mov() + "', 'bxClase', '" + accion + "')\">");
                            out.println("<td>" + mo.get(i).getid_tipo_mov() + "</td>");
                            out.println("<td>" + mo.get(i).getdescripcion_mov() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalClase,bxClase,");
                    }
                    break;
                case "VentanaModalPedido":
                    if (v4.length() == 0) {
                        v4 = "0";
                    }
                    ArrayList<pedido_detalle> pe = ACC_Pedidos.ObtenerInstancia().ConsultaPedido(v2, v1, v3, v3, Integer.parseInt(v4));
                    if (pe.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pe.size(); i++) {
                            out.println("<tr ondblclick=\"selecciona('" + pe.get(i).getPedido() + "', 'bxPedido', '" + accion + "')\">");
                            out.println("<td>" + pe.get(i).getFecha_doc_compras() + "</td>");
                            out.println("<td>" + pe.get(i).getPedido() + "</td>");
                            out.println("<td>" + pe.get(i).getNum_solped() + "</td>");
                            out.println("<td>" + pe.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalPedido,bxPedido,");
                    }
                    break;
                case "VentanaModalLote":
                    ArrayList<stock> so = ACC_Stock.ObtenerInstancia().ConsultaInventariosC2(ctr, v1, v2, v3);
                    if (so.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < so.size(); i++) {

                            out.println("<tr ondblclick=\"seleccionar('" + so.get(i).getLote() + "', 'bxLote" + lote + "', '" + accion + "')\">");
                            out.println("<td>" + so.get(i).getMaterial() + "</td>");
                            out.println("<td>" + so.get(i).getCentro() + "</td>");
                            out.println("<td>" + so.get(i).getAlmacen() + "</td>");
                            out.println("<td>" + so.get(i).getLote() + "</td>");
                            out.println("<td>" + so.get(i).getStocklibre_utilizacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalLote,bxLote" + lote + ",");
                    }
                    break;
                case "VentanaModalLoteE":
                    ArrayList<stock> se = ACC_Stock.ObtenerInstancia().ConsultaInventariosEE(ctr, v1, v2, v3, v4, v5);
                    if (se.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < se.size(); i++) {

                            out.println("<tr ondblclick=\"seleccionar('" + se.get(i).getLote() + "', 'bxLote" + lote + "', 'VentanaModalLote')\">");
                            out.println("<td>" + se.get(i).getMaterial() + "</td>");
                            out.println("<td>" + se.get(i).getCentro() + "</td>");
                            out.println("<td>" + se.get(i).getAlmacen() + "</td>");
                            out.println("<td>" + se.get(i).getLote() + "</td>");
                            out.println("<td>" + se.get(i).getStocklibre_utilizacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalLote,bxLote" + lote + ",");
                    }
                    break;
                case "VentanaModalMaterial":
                    ArrayList<materiales> mm = ACC_Material.ObtenerInstancia().ConsultaMaterial(v1, v2, v3, v4);
                    if (mm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mm.size(); i++) {

                            out.println("<tr ondblclick=\"seleccionarMat('" + mm.get(i).getMaterial() + "', 'bxMaterial201', '" + accion + "')\">");
                            out.println("<td>" + mm.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + mm.get(i).getMaterial() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalMaterial,bxMaterial,");
                    }
                    break;
                case "VentanaModalStockT":
                    LinkedList<Stock_Traslado> mmm = ACC_Stock.ObtenerInstancia().ConsultaStock_T(v1, v2, v3, v4);
                    if (mmm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mmm.size(); i++) {
                            if (Float.parseFloat(mmm.get(i).getStock_traslado()) > 0) {
                                out.println("<tr ondblclick=\"seleccionarMatT('" + mmm.get(i).getMaterial() + "', '" + lote + "', '" + accion + "', '" + mmm.get(i).getStock_traslado() + "', '" + mmm.get(i).getUnidad_medida() + "')\">");
                                out.println("<td>" + mmm.get(i).getDescripcion() + "</td>");
                                out.println("<td>" + mmm.get(i).getMaterial() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalStockT,bxMat" + lote + ",");
                    }
                    break;
                case "Obtener305":
                    Stock_Traslado st = ACC_Stock.ObtenerInstancia().mDatos305(v1, v2, idioma);
                    if (st.getDescripcion().equals("")) {
                        out.println(0);
                    } else {
                        out.println(st.getDescripcion() + "," + st.getStock_traslado() + "," + st.getUnidad_medida() + "," + st.getCentro());
                    }
                    break;
                case "VentanaModalCC":
                    ArrayList<CeCos> cc = ACC_CentroCosto.ObtenerInstancia().ConsultaCeCOS(v1, v2, v3, v4,v5);
                    if (cc.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cc.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + cc.get(i).getCentroCos() + "', 'bxccs', '" + accion + "')\">");
                            out.println("<td>" + cc.get(i).getClaseCoste() + "</td>");
                            out.println("<td>" + cc.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + cc.get(i).getCentroCos() + "</td>");
                            out.println("<td>" + cc.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalCC,bxccs201,");
                    }
                    break;
                case "ValidaOrden": /////// Antonio Orden
                    int ord = ACC_Orden.ObtenerInstancia().ValidOrden(v6);
                    out.println(ord + ",No existe la Orden " + v6 + ",1,1");
                    break;
                case "VentanaModalOrden":
                    ArrayList<plan_orden> or = ACC_Orden.ObtenerInstancia().ObtenerDatosMatchOrdeness(v3, v1, v2);
                    if (or.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        int limit;
                        if (v3.equals("")) {
                            limit = or.size();
                        } else {
                            limit = Integer.parseInt(v3);
                        }
                        for (int i = 0; i < limit; i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + or.get(i).getNum_orden() + "', 'bxord', '" + accion + "')\">");
                            out.println("<td>" + or.get(i).getNum_orden() + "</td>");
                            out.println("<td>" + or.get(i).getTexto_breve() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</tabla>");
                    } else {
                        out.println(0 + ",VentanaModalOrden,bxord261,");
                    }
                    break;
                case "VentanaModalClaseDefecto":
                    ArrayList<CodigosDefecto> cd = ACC_CodigosDefecto.ObtenerInstancia().ConsultaCodDefecto(v3, v1);
                    if (cd.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cd.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionaCld('" + cd.get(i).getGrupo_codigos() + "', '" + cd.get(i).getCodigo() + "', '" + cd.get(i).getTexto_breve_codigo() + "', '" + v2 + "', '" + accion + "')\">");
                            out.println("<td>" + cd.get(i).getCodigo() + "</td>");
                            out.println("<td>" + cd.get(i).getTexto_breve_codigo() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</tabla>");
                    } else {
                        out.println(0 + ",VentanaModalClaseDefecto,Cod1" + v2 + ",");
                    }
                    break;
                case "VentanaModalClaseDefectoE":
                    ArrayList<CodigosDefecto> cde = ACC_CodigosDefecto.ObtenerInstancia().ConsultaCodDefecto(v3, v1);
                    if (cde.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cde.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionaCldE('" + cde.get(i).getGrupo_codigos() + "', '" + cde.get(i).getCodigo() + "', '" + cde.get(i).getTexto_breve_codigo() + "', '" + v2 + "', '" + accion + "')\">");
                            out.println("<td>" + cde.get(i).getCodigo() + "</td>");
                            out.println("<td>" + cde.get(i).getTexto_breve_codigo() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</tabla>");
                    } else {
                        out.println(0 + ",VentanaModalClaseDefectoE,Cod4" + v2 + ",");
                    }
                    break;
                case "VentanaModalReserva":
                    int limi = Integer.parseInt(v6);
                    ArrayList<reserva_posiciones_crea> res = ACC_Reservas.ObtenerInstancia().CargarreservasMC(v2, clas, v4, v5, v3, v1, v8, v9);
                    if (res.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < limi; i++) {
                            out.println("<tr ondblclick=\"seleccionarReserva('" + res.get(i).getFolio_sap() + "', '" + res.get(i).getFolio_sam() + "', 'bxReserva', '" + accion + "')\">");
                            out.println("<td>" + res.get(i).getFolio_sap() + "</td>");
                            out.println("<td>" + res.get(i).getFolio_sam() + "</td>");
                            out.println("<td>" + res.get(i).getPosicion_reserva() + "</td>");
                            out.println("<td>" + res.get(i).getClase_movimiento() + "</td>");
                            out.println("<td>" + res.get(i).getNum_material() + "</td>");
                            out.println("<td>" + res.get(i).getTexto_posicion() + "</td>");
                            out.println("<td>" + res.get(i).getCentro() + "</td>");
                            out.println("<td>" + res.get(i).getAlmacen() + "</td>");
                            out.println("<td>" + res.get(i).getUsuario() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</tabla>");
                    } else {
                        out.println(0 + ",VentanaModalReserva,bxReserva,");
                    }
                    break;
                case "VentanaModalProv":
                    String query = "select * from proveedores ";
                    if (!v1.equals("")) {
                        query += "where nombre1='" + v1 + "' ";
                    }
                    if (!v1.equals("") && !v2.equals("")) {
                        query += "and IdProveedor like'%" + v2 + "%' ";
                    }
                    if (v1.equals("") && !v2.equals("")) {
                        query += "where IdProveedor like'%" + v2 + "%' ";
                    }

                    LinkedList<proveedor> pv = ACC_Proveedor.ObtenerInstancia().ConsultaMatchProveedor(query);
                    out.println("<table>");
                    out.println("<tbody>");
                    for (int i = 0; i < pv.size(); i++) {

                        out.println("<tr ondblclick=\"seleccionar('" + pv.get(i).getIdProveedor() + "', 'bxpov', '" + accion + "')\">");
                        out.println("<td>" + pv.get(i).getNombre1() + "</td>");
                        out.println("<td>" + pv.get(i).getIdProveedor() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ValidarCampos":
                    int e = ACC_Centro.ObtenerInstancia().ValidarCentro(v1);
                    int alm = ACC_Almacenes.ObtenerInstancia().ValidarAlmacen(v2);
                    int cl = ACC_TipoMovimientos.ObtenerInstancia().ValidarTipoMovi(v3);

                    out.println(e + "," + alm + "," + cl);
                    break;
                /*case "ValidaAlmDes":
                    int ald = ACC_CentroCosto.ObtenerInstancia().AlmacenDestino(v6, v4, lote);
                    out.println(ald + ",No existen valores para esta seleccion " + v6 + ",1,1");
                    break;*/
                case "ValidaAlmDes":
                    if (v7.equals("311")) {
                        int ald = ACC_CentroCosto.ObtenerInstancia().AlmacenDestino(v6, v4, lote, v1);
                        out.println(ald + ",El Lote o el Material no existe en el Almacén " + v6 + ",1,1");
                    }
                    if (v7.equals("312")) {
                        int ald = ACC_CentroCosto.ObtenerInstancia().AlmacenDestino(v5, v4, lote, v1);
                        out.println(ald + ",El Lote o el Material no existe en el Almacén " + v5 + ",1,1");
                    }
                    break;
                case "ValidaCeCos":
                    int ceco = ACC_CentroCosto.ObtenerInstancia().ConsultaCeCos(v6);
                    out.println(ceco + ",No existen valores para el Centro de Coste " + v6 + ",1,1");
                    break;
                case "ValidaUM":
                    int r = ACC_Stock.ObtenerInstancia().ConsultaUM(v1, v2);
                    out.println(r + ",Unidad de Medida deseada sin factores de conversión,0,0");
                    break;
                case "ValidaCntST":
                    int rst = ACC_Stock.ObtenerInstancia().ConsultaCntST(v1, v3, v4);
                    out.println(rst + ",Stock en Transito menor a Cantidad Solicitada,1,0");
                    break;
                case "ValidaLote":
//                    int xxx = ACC_Stock.ObtenerInstancia().sujetoLoteMate(v1);
//                    if (xxx == 1) {
                    if ((v7.equals("201") || v7.equals("311") || v7.equals("303") || v7.equals("261")) && !lote.equals("")) {
                        int rs = ACC_Stock.ObtenerInstancia().ConsultaLote(v1, v3, v4, v5, lote);
                        out.println(rs + ",Cantidad en Lote o Almacén no suficiente,1,0");
                    }
                    if ((v7.equals("201") || v7.equals("311") || v7.equals("303") || v7.equals("261")) && lote.equals("")) {
                        if (docEE.equals("")) {
                            int rs = ACC_Stock.ObtenerInstancia().ConsultaLote(v1, v3, v4, v5, lote);
                            out.println(rs + ",Cantidad en Almacén Stock Especial no suficiente,1,0");
                        } else {
                            int rs = ACC_Stock.ObtenerInstancia().ConsultaLote(v1, v3, v4, v5, lote);
                            out.println(rs + ",Cantidad en Almacén no suficiente,1,0");
                        }
                    }
                    if (v7.equals("312") && !lote.equals("")) {
                        int rs = ACC_Stock.ObtenerInstancia().ConsultaLote(v1, v3, v4, v6, lote);
                        out.println(rs + ",Cantidad en Lote o Almacén no suficiente,1,0");
                    }
                    if (v7.equals("312") && lote.equals("")) {
                        int rs = ACC_Stock.ObtenerInstancia().ConsultaLote(v1, v3, v4, v6, lote);
                        out.println(rs + ",Cantidad en Almacén no suficiente,1,0");
                    }
                    if (v7.equals("202") || v7.equals("262")) {
                        int rs = ACC_Stock.ObtenerInstancia().ConsultaLote2(v1, v4, v5);
                        out.println(rs + ",El material no esta ampliado en el almacén,1,0");
                    }
//                        if (v7.equals("202")) {
//                            out.println("1,Lote no,1,0");
//                        }
//                        if (v7.equals("262")) {
//                            out.println("1,Lote no,1,0");
//                        }
//                    } else {
//                        out.println("1" + ",Lote no Disponible para el Movimiento de Materiale,1,0");
//                    }
                    break;
                case "ValidaCenDes":
                    int cnt = ACC_Centro.ObtenerInstancia().CentroDestino(v6, v1, v5, lote);
                    out.println(cnt + ",No existen valores para centro " + v6 + ",1,1");
                    break;
                case "ValidaCenDesT":
                    int cntt = ACC_Centro.ObtenerInstancia().CentroDestinoT(v6, v1, v5, lote);
                    out.println(cntt + ",Material no existe en Centro Destino,1,1");
                    break;
                case "NombreMaterial":
                    String nombre = ACC_Material.ObtenerInstancia().ConsultaNombreMaterial(v1, idioma);
                    out.println(nombre);
                    break;
                case "LoteD":
                    int rsp = ACC_Material.ObtenerInstancia().ConsultaLoteMaterial(v1);
                    if (rsp == 1) {
                        out.println(1);
                    }
                    break;
                case "CantidadTransito":
                    int trans = ACC_Stock.ObtenerInstancia().ConsultaCantidad(v1, v4, v5, lote);
                    out.println(trans);
                    break;
                case "ValidarCamposReservas": ///// Antonio Reservas
                    int cen = ACC_Centro.ObtenerInstancia().ValidarCentro(v1);
                    int almA = ACC_Almacenes.ObtenerInstancia().ValidarAlmacen(v2);
                    int clm = ACC_TipoMovimientos.ObtenerInstancia().ValidarTipoMovi(v3);
                    int rev = ACC_Reservas.ObtenerInstancia().ValidarReservAmbas(v4);
                    int err = ACC_Reservas.ObtenerInstancia().ValidarErrorReserva(v4);
                    String valres = ACC_Reservas.ObtenerInstancia().ValidarDataRes(v3, v4);
                    out.println(cen + "|" + almA + "|" + clm + "|" + rev + "|" + err + "|" + valres);
                    break;
                case "CargarPosicionReserva":
                    ArrayList<reserva_posiciones_crea> rp = ACC_Reservas.ObtenerInstancia().cargarPosiResMov(queryrespos, v1, v2, v3);
                    int x;
                    switch (v3) {
                        case "201":
                            out.println("<table class=\"TablaCont\" id=\"TablaRG\">\n"
                                    + "                                    <tr id=\"CabeceraTabla\">\n"
                                    + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td>Material&nbsp;</td>\n"
                                    + "                                        <td>Descripción&nbsp;</td>\n"
                                    + "                                        <td>Cantidad&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td>UM&nbsp;</td>\n"
                                    + "                                        <td>Lote&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td></td>\n"
                                    + "                                        <td>CentroCostos&nbsp;</td>\n"
                                    + "                                        <td>Folio&nbsp;</td>\n"
                                    + "                                        <td>Pos&nbsp;</td>\n"
                                    + "                                    </tr> \n"
                                    + "                                    <tbody>");
                            for (x = 0; x < rp.size(); x++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;&nbsp;&nbsp;</td>");
                                out.println("<td name=\"reserv1\">" + rp.get(x).getNum_material() + " </td>");
                                out.println("<td name=\"reserv8\">" + ACC_Material.ObtenerInstancia().ConsultaNombreMaterial(rp.get(x).getNum_material(), idioma) + " </td>");
                                out.println("<td class=\"tdcRG\"><input maxlength=\"13\" type=\"text\"  value=\"" + rp.get(x).getCantidad_necesaria() + "\"name=\"reserv2\"  class=\"bxcRG\" id=\"cntRG" + x + "\" onblur=\"this.value = checkDec(this.value, 3)\" onfocus=\"loteBtnHide('" + rp.size() + "')\"></td>");
                                out.println("<td name=\"reserv3\">" + rp.get(x).getUnidad_medida_base() + " </td>");
                                if (ACC_Material.ObtenerInstancia().ConsultaLoteMaterial(rp.get(x).getNum_material()) == 1) {
                                    out.println("<td><input type=\"text\" name=\"reserv4\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxLote" + x + "\" onfocus=\"loteBtnShow('" + x + "', '" + rp.size() + "')\"></td>");
                                } else {
                                    out.println("<td><input type=\"text\" name=\"reserv4\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxLote" + x + "\" onfocus=\"loteBtnShow('" + x + "', '" + rp.size() + "')\" disabled></td>");
                                }
                                out.println("<td><button id=\"btnLote" + x + "\" class='BtnMatchIcon' style=\"display : none;\" onclick=\"MatchLote('" + x + "', '" + rp.get(x).getNum_material() + "')\"></button></td>");
                                out.println("<td name=\"reserv5\">" + rp.get(x).getCentro_coste() + " </td>");
                                if (rp.get(x).getFolio_sap().equals("")) {
                                    out.println("<td name=\"reserv6\">" + rp.get(x).getFolio_sam() + " </td>");
                                } else {
                                    out.println("<td name=\"reserv6\">" + rp.get(x).getFolio_sap() + " </td>");
                                }
                                out.println("<td name=\"reserv7\">" + rp.get(x).getNum_posicion() + " </td>");
                                out.println("</tr>");
                            }
                            out.println("<tr>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">ADMON_PORTUARIA__INTEGRAL_DE_TOPO_S_Mas_Esp</td>\n"
                                    + "                <td class=\"ocultar\"></td>\n"
                                    + "                <td class=\"ocultar\"></td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "           </tr>");
                            out.println("</table>");
                            break;
                        case "261":
                            out.println("<table class=\"TablaCont\" id=\"TablaRG\">\n"
                                    + "                                    <tr id=\"CabeceraTabla\">\n"
                                    + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td>Material&nbsp;</td>\n"
                                    + "                                        <td>Descripción&nbsp;</td>\n"
                                    + "                                        <td>Cantidad&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td>UM&nbsp;</td>\n"
                                    + "                                        <td>Lote&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td></td>\n"
                                    + "                                        <td>Orden&nbsp;</td>\n"
                                    + "                                        <td>Folio&nbsp;</td>\n"
                                    + "                                        <td>Pos&nbsp;</td>\n"
                                    + "                                    </tr> \n"
                                    + "                                    <tbody>");
                            for (x = 0; x < rp.size(); x++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;&nbsp;&nbsp;</td>");
                                out.println("<td name=\"reserv1\">" + rp.get(x).getNum_material() + " </td>");
                                out.println("<td name=\"reserv8\">" + ACC_Material.ObtenerInstancia().ConsultaNombreMaterial(rp.get(x).getNum_material(), idioma) + " </td>");
                                out.println("<td class=\"tdcRG\"><input maxlength=\"13\" type=\"text\"  value=\"" + rp.get(x).getCantidad_necesaria() + "\"name=\"reserv2\"  class=\"bxcRG\" id=\"cntRG" + x + "\" onblur=\"this.value = checkDec(this.value, 3)\" onfocus=\"loteBtnHide('" + rp.size() + "')\"></td>");
                                out.println("<td name=\"reserv3\">" + rp.get(x).getUnidad_medida_base() + " </td>");
                                if (ACC_Material.ObtenerInstancia().ConsultaLoteMaterial(rp.get(x).getNum_material()) == 1) {
                                    out.println("<td><input type=\"text\" name=\"reserv4\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxLote" + x + "\" onfocus=\"loteBtnShow('" + x + "', '" + rp.size() + "')\"></td>");
                                } else {
                                    out.println("<td><input type=\"text\" name=\"reserv4\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxLote" + x + "\" onfocus=\"loteBtnShow('" + x + "', '" + rp.size() + "')\" disabled></td>");
                                }
                                out.println("<td><button id=\"btnLote" + x + "\" class='BtnMatchIcon' style=\"display : none;\" onclick=\"MatchLote('" + x + "', '" + rp.get(x).getNum_material() + "')\"></button></td>");
                                out.println("<td name=\"reserv5\">" + rp.get(x).getNum_orden() + " </td>");
                                if (rp.get(x).getFolio_sap().equals("")) {
                                    out.println("<td name=\"reserv6\">" + rp.get(x).getFolio_sam() + " </td>");
                                } else {
                                    out.println("<td name=\"reserv6\">" + rp.get(x).getFolio_sap() + " </td>");
                                }
                                out.println("<td name=\"reserv7\">" + rp.get(x).getNum_posicion() + " </td>");
                                out.println("</tr>");
                            }
                            out.println("<tr>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">ADMON_PORTUARIA__INTEGRAL_DE_TOPO_S_Mas_Esp</td>\n"
                                    + "                <td class=\"ocultar\"></td>\n"
                                    + "                <td class=\"ocultar\"></td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "           </tr>");
                            out.println("</table>");
                            break;
                        case "311":
                            out.println("<table class=\"TablaCont\" id=\"TablaRG\">\n"
                                    + "                                    <tr id=\"CabeceraTabla\">\n"
                                    + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td>Material&nbsp;</td>\n"
                                    + "                                        <td>Descripción&nbsp;</td>\n"
                                    + "                                        <td>Cantidad&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td>UM&nbsp;</td>\n"
                                    + "                                        <td>Lote&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                        <td></td>\n"
                                    + "                                        <td>AlmacénDestino&nbsp;</td>\n"
                                    + "                                        <td>Folio&nbsp;</td>\n"
                                    + "                                        <td>Pos&nbsp;</td>\n"
                                    + "                                    </tr> \n"
                                    + "                                    <tbody>");
                            for (x = 0; x < rp.size(); x++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;&nbsp;&nbsp;</td>");
                                out.println("<td name=\"reserv1\">" + rp.get(x).getNum_material() + " </td>");
                                out.println("<td name=\"reserv8\">" + ACC_Material.ObtenerInstancia().ConsultaNombreMaterial(rp.get(x).getNum_material(), idioma) + " </td>");
                                out.println("<td class=\"tdcRG\"><input maxlength=\"13\" type=\"text\"  value=\"" + rp.get(x).getCantidad_necesaria() + "\"name=\"reserv2\"  class=\"bxcRG\" id=\"cntRG" + x + "\" onblur=\"this.value = checkDec(this.value, 3)\" onfocus=\"loteBtnHide('" + rp.size() + "')\"></td>");
                                out.println("<td name=\"reserv3\">" + rp.get(x).getUnidad_medida_base() + " </td>");
                                if (ACC_Material.ObtenerInstancia().ConsultaLoteMaterial(rp.get(x).getNum_material()) == 1) {
                                    out.println("<td><input type=\"text\" name=\"reserv4\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxLote" + x + "\" onfocus=\"loteBtnShow('" + x + "', '" + rp.size() + "')\"></td>");
                                } else {
                                    out.println("<td><input type=\"text\" name=\"reserv4\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxLote" + x + "\" onfocus=\"loteBtnShow('" + x + "', '" + rp.size() + "')\" disabled></td>");
                                }
                                out.println("<td><button id=\"btnLote" + x + "\" class='BtnMatchIcon' style=\"display : none;\" onclick=\"MatchLote('" + x + "', '" + rp.get(x).getNum_material() + "')\"></button></td>");
                                out.println("<td name=\"reserv5\">" + rp.get(x).getAlmacen_destino() + " </td>");
                                if (rp.get(x).getFolio_sap().equals("")) {
                                    out.println("<td name=\"reserv6\">" + rp.get(x).getFolio_sam() + " </td>");
                                } else {
                                    out.println("<td name=\"reserv6\">" + rp.get(x).getFolio_sap() + " </td>");
                                }
                                out.println("<td name=\"reserv7\">" + rp.get(x).getNum_posicion() + " </td>");
                                out.println("</tr>");
                            }
                            out.println("<tr>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">ADMON_PORTUARIA__INTEGRAL_DE_TOPO_S_Mas_Esp</td>\n"
                                    + "                <td class=\"ocultar\"></td>\n"
                                    + "                <td class=\"ocultar\"></td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "                <td class=\"ocultar\">&nbsp;</td>\n"
                                    + "           </tr>");
                            out.println("</table>");
                            break;
                    }
                    break;
                case "ValidarMaterialLote":
                    String m = ACC_Stock.ObtenerInstancia().VerificarMatLote(matelote);
                    out.println(m);
                    break;
                case "SujeroLoteMat":
                    int l = ACC_Stock.ObtenerInstancia().sujetoLoteMate(matelote);
                    out.println(l);
                    break;
                case "umD":
                    String um = ACC_Material.ObtenerInstancia().unidadM(v1);
                    out.println(um);
                    break;
                case "umDT":
                    String umt = ACC_Material.ObtenerInstancia().unidadMT(v1);
                    out.println(umt);
                    break;
                case "umed":
                    String resum = ACC_Material.ObtenerInstancia().GetDecUM(v1);
                    out.println(resum);
                    break;
                case "GetTolearanciaConf":
                    String pedt = request.getParameter("pedidotol");
                    String post = request.getParameter("postol");
                    String Tol = Consultas.ObtenerInstancia().GetTolerancia(pedt, post);
                    out.println(Tol);
                    break;
                case "DocMovimiento102":
                    ArrayList<detalles_doc_materiales> dd = ACC_DetallesDocMateriales.ObtenerInstancia().ObtenerMov101Doc(NDocCom, centro102, almacen102);
                    if (dd.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < dd.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionaMov101('" + dd.get(i).getNum_doc_material() + "', '" + dd.get(i).getFolio_sam() + "')\">");
                            out.println("<td>" + dd.get(i).getNum_doc_material() + "</td>");
                            out.println("<td>" + dd.get(i).getFolio_sam() + "</td>");
                            out.println("<td>" + dd.get(i).getNum_pedido() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(1);
                    }
                    break;
                case "CheckMateLoteInpecion":
                    String mli = ACC_Material.ObtenerInstancia().CheckLIMat(MlIn);
                    out.println(mli);
                    break;
                case "ObtenerCabeceraPI":
                    MaterialesPI m1 = ACC_MaterialesPI.ObtenerInstancia().ObtenerDatosMateLI(MlIn);
                    String txtbrv = URLDecoder.decode(m1.getTexto_breve_material(), "UTF-8");
                    out.println(m1.getNum_material() + "'" + txtbrv + "'" + m1.getCentro());
                    break;
                case "ObtenerUM":
                    String rrs = ACC_UnidadesMedida.ObtenerInstancia().DecimalUnidadMedida(v1);
                    out.println(rrs);
                    break;
                case "runimed":
                    String rum = ACC_Material.ObtenerInstancia().MMGetUniMed(v1);
                    out.println(rum);
                    break;
                case "TablaN300":
                    int ii = 0;
                    out.println("<table id=\"TabBody\">\n"
                            + "<tbody>");
                    int ni = ii + 1;
                    for (int i = ii; i < ni; i++) {
                        out.println(""
                                + "<tr>"
                                + "<td><input id=\"rbt\" type=\"checkbox\" name=\"305\" value=\"" + i + "\"></td>"
                                + "<td><input name=\"movsn1\" type=\"text\" class=\"bxcRG\" id=\"bxMat" + i + "\" maxlength=\"40\" style=\"text-transform: uppercase;\" onKeyPress=\"validar(event, '" + i + "')\" onblur=\"ObtenerAll305('" + i + "')\" onfocus=\"matBtnShow('" + i + "')\"></td>"
                                //                                + "<td><input name=\"movsn1\" type=\"text\" class=\"bxcRG\" id=\"bxMat" + i + "\" maxlength=\"40\" style=\"text-transform: uppercase;\" onKeyPress=\"return NadaFK(event)\" onfocus=\"matBtnShow('" + i + "')\"></td>"
                                + "<td><button id=\"btnMat" + i + "\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"matVen300('" + i + "')\"></button></td>"
                                + "<td><label name=\"movsn2\" id=\"txtMat" + i + "\"></label></td>"
                                + "<td><input maxlength=\"13\" type=\"text\"  name=\"movsn3\"  class=\"bxcRG\" id=\"bxCnt" + i + "\" onblur=\"this.value = checkDec(this.value, 3)\" onKeyPress=\"return soloNumeros(event)\" onfocus=\"matchTbl300('')\"></td>"
                                + "<td><label name=\"movsn4\" id=\"txtUM" + i + "\"></label></td>"
                                + "<td><input type=\"text\" name=\"movsn5\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxLote" + i + "\" onfocus=\"loteBtnShowN('" + i + "')\"></td>"
                                + "<td><button id=\"btnLote" + i + "\" class='BtnMatchIcon' style=\"display : none;\" onclick=\"MatchLote300('" + i + "')\"></button></td>"
                                + "<td><label name=\"movsn6\" id=\"txtAD" + i + "\"></label></td>"
                                + "</tr>\n");
                    }
                    for (int i = ni; i < 14; i++) {
                        out.println(""
                                + "                                      <tr>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>\n");
                    }
                    out.println("<tr class=\"ocultar\"><td>00</td><td>0000000000000</td><td>000</td><td>0000000000000000000000000000000000000000000000000</td><td>0000000000000000</td><td>000</td><td>00000000000000000000</td><td>000</td><td>0000000000000</td></tr>"
                            + "</tbody>\n"
                            + "</table>");
                    break;
                case "match303Mat":
                    ArrayList<materiales> lstMatTC = ACC_Material.ObtenerInstancia().ConsultaMaterial(v1, v2, v3, v4);
                    if (lstMatTC.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstMatTC.size(); i++) {
                            out.println("<tr ondblclick=\"selectMatch303('Mat303','" + v5 + "','" + lstMatTC.get(i).getMaterial() + "');\">");
                            out.println("<td>" + lstMatTC.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + lstMatTC.get(i).getMaterial() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "cargarMaterial":
                    String desM = "descripcion_" + v2;
                    materiales material;
                    material = ACC_Material.ObtenerInstancia().CargarMaterialOrden(v1, desM);
                    if (material.getMaterial().equals("x")) {
                        out.println(material.getMaterial());
                    } else {
                        JSONArray js = new JSONArray();
                        js.add(material.getDescripcion());
                        js.add(material.getUnidad_medida());
                        js.add(material.getCentro());
                        out.println(js);
                    }
                    break;
                case "validarMate":
                    String check = ACC_Material.ObtenerInstancia().ValidarMatExis(v1);
                    out.println(check);
                    break;
                case "validarMate303":
                    check = ACC_Material.ObtenerInstancia().ValidarMatExis303(v1);
                    out.println(check);
                    break;
                case "checkSujLotV":
                    check = ACC_Material.ObtenerInstancia().CheckLotVal303(v1);
                    out.println(check);
                    break;
                case "validarCent303":
                    check = ACC_Centro.ObtenerInstancia().ValidarCentro303Exis(v1);
                    out.println(check);
                    break;
                case "validarMtl303":
                    check = ACC_Material.ObtenerInstancia().ValidarMtl303(v1);
                    out.println(check);
                    break;
                case "MaterialHabilitado":
                    out.println(ACC_Material.ObtenerInstancia().ValidaMaterialHabilitado(v1, v2, v3));
                    break;
                case "validarSujLote":
                    check = ACC_Stock.ObtenerInstancia().ValidarSujLotByMat(v1, v2);
                    out.println(check);
                    break;
                case "validarStockLibre":
                    check = ACC_Stock.ObtenerInstancia().ValidarStockLibre(v1, v2, v3, v4);
                    out.println(check);
                    break;
                case "match303Lot":
                    so = ACC_Stock.ObtenerInstancia().ConsultaLoteByMat(v2);
                    out.println("<table>");
                    out.println("<tbody>");
                    for (int i = 0; i < so.size(); i++) {

                        out.println("<tr ondblclick=\"selectMatch303('Lote','" + v1 + "','" + so.get(i).getLote() + "')\">");
                        out.println("<td>" + so.get(i).getMaterial() + "</td>");
                        out.println("<td>" + so.get(i).getCentro() + "</td>");
                        out.println("<td>" + so.get(i).getAlmacen() + "</td>");
                        out.println("<td>" + so.get(i).getLote() + "</td>");
                        out.println("<td>" + so.get(i).getStocklibre_utilizacion() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "match303Cent":
                    equ = ACC_Centro.ObtenerInstancia().ConsultaCentros303();
                    out.println("<table>"
                            + "<tbody>");
                    for (int i = 0; i < equ.size(); i++) {
                        out.println("<tr ondblclick=\"selectMatch303('Centro','" + v1 + "','" + equ.get(i).getCentro() + "')\">");
                        out.println("<td>" + equ.get(i).getCentro() + "</td>");
                        out.println("<td>" + equ.get(i).getDescripcion() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>"
                            + "</table>");
                    break;
                case "cargarCabMate":
                    materialesPlanesInspeccion mat;
                    mat = ACC_MaterialesPlanesInspeccion.ObtenerInstancia().CargarMaterialOrden(v1);
                    folios fol = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("QM");
                    JSONArray js = new JSONArray();
                    js.add(mat.getNum_material());
                    js.add(mat.getTexto_breve_material());
                    js.add(fol.getFolioActual());
                    out.println(js);
                    break;
                case "consultarClsInf":
                    ArrayList<clase_informe> clsI = ACC_ClaseInforme.ObtenerInstancia().ConsultaClsInf(Idioma);
                    out.println("<table>"
                            + "<tbody>");
                    for (int i = 0; i < clsI.size(); i++) {
                        out.println("<tr ondblclick=\"selectMatch303('ClsInf','bxClsInf','" + clsI.get(i).getClase_informe() + "')\">");
                        out.println("<td>" + clsI.get(i).getClase_informe() + "</td>");
                        out.println("<td>" + clsI.get(i).getTexto_breve() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>"
                            + "</table>");
                    break;
                case "cargarDataClsInf":
                    clase_informe cls = ACC_ClaseInforme.ObtenerInstancia().DataClsInforme(v1, Idioma);
                    if (cls.getClase_informe().equals("x")) {
                        js = new JSONArray();
                        js.add(cls.getClase_informe());
                        out.println(js);
                    } else {
                        js = new JSONArray();
                        js.add(cls.getClase_informe());
                        js.add(cls.getTexto_breve());
                        js.add(cls.getTexto_esquema_informe());
                        js.add(cls.getPerfil_catalogo());
                        out.println(js);
                    }
                    break;
                case "insertarDataFile":
                    DocumentosDMSenvio doc = new DocumentosDMSenvio();
                    folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("MO");
                    int fa = fo.getFolioActual();
                    doc.setFolio_dms("MO" + fa);
                    doc.setTabix(v1);
                    doc.setFecha(fechaActual);
                    doc.setHora_dia(horaActual);
                    doc.setAplicacion(v2);
                    doc.setClase_documento(v3);
                    doc.setDescripcion_documento(v4);
                    doc.setPersona_responsable(v5);
                    doc.setOriginal_documento(v6);
                    if (ACC_Ficheros.ObtenerInstancia().InsertDataFiles(doc)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                case "ConsultaMaterial":
                    ArrayList<materiales> mate = ACC_Material.ObtenerInstancia().ConsultaMaterial(v1, v2, v3, v4);
                    if (mate.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mate.size(); i++) {

                            out.println("<tr ondblclick=\"seleccionarMatok('" + mate.get(i).getMaterial() + "', '" + mate.get(i).getDescripcion() + "', '" + mate.get(i).getUnidad_medida() + "', '" + v5 + "')\">");
                            out.println("<td style=\"width:25%;\">" + mate.get(i).getMaterial() + "</td>");
                            out.println("<td style=\"width:65%; text-align: left;\">" + mate.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaLote":
                    ArrayList<stock> so1 = ACC_Stock.ObtenerInstancia().ConsultaInventariosC2(v1, v2, v3, v4);
                    if (so1.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < so1.size(); i++) {

                            out.println("<tr ondblclick=\"SelecLoteM('" + so1.get(i).getLote() + "', '" + v3 + "')\">");
                            out.println("<td>" + so1.get(i).getMaterial() + "</td>");
                            out.println("<td>" + so1.get(i).getCentro() + "</td>");
                            out.println("<td>" + so1.get(i).getAlmacen() + "</td>");
                            out.println("<td>" + so1.get(i).getLote() + "</td>");
                            out.println("<td>" + so1.get(i).getStocklibre_utilizacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ObtenerDatosMateriales":
                    materiales m12 = ACC_Material.ObtenerInstancia().gtedataMovimientosInfo(v1);
                    if (m12.getMaterial().equals("")) {
                        out.println(0);
                    } else {
                        JSONArray ja = new JSONArray();
                        ja.add(m12.getMaterial());
                        ja.add(m12.getDescripcion());
                        ja.add(m12.getUnidad_medida());
                        ja.add(m12.getSujeto_lote());
                        out.println(ja);
                    }
                    break;
                case "ConsultaCeCos":
                    ArrayList<CeCos> cecos = ACC_CentroCosto.ObtenerInstancia().ConsultaCeCOS(v1, v2, v3, v4, v5);
                    if (cecos.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cecos.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionarCCosto('" + cecos.get(i).getCentroCos() + "','" + v6 + "')\">");
                            out.println("<td style=\"width: 20%;\">" + cecos.get(i).getClaseCoste() + "</td>");
                            out.println("<td style=\"width: 30%; text-align: left;\">" + cecos.get(i).getDescripcion() + "</td>");
                            out.println("<td style=\"width: 20%;\">" + cecos.get(i).getCentroCos() + "</td>");
                            out.println("<td style=\"width: 30%; text-align: left;\">" + cecos.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalCC,bxccs201,");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionMovMateriales.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionMovMateriales.class.getName()).log(Level.SEVERE, null, ex);
        }
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
