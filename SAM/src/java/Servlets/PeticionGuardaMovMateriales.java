package Servlets;

import AccesoDatos.ACC_Almacenes;
import AccesoDatos.ACC_DetallesDocMateriales;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Pedidos;
import AccesoDatos.ACC_Stock;
//import AccesoDatos.CallWS;
import AccesoDatos.Conexion;
import AccesoDatos.Consultas;
//import AccesoDatos.CallWS;
import Entidades.folios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.pedido_detalle;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Properties;

@WebServlet(name = "PeticionGuardaMovMateriales", urlPatterns = {"/PeticionGuardaMovMateriales"})
public class PeticionGuardaMovMateriales extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            pedido_detalle pp = new pedido_detalle();
            HttpSession ses = request.getSession();
            String user = (String) ses.getAttribute("Usuario");
            String Idioma = (String) session.getAttribute("Idioma");

            pp.setNum_posicion(request.getParameter("pos"));
            pp.setPor_recibir(request.getParameter("v1"));
            pp.setLote(request.getParameter("v2"));
            pp.setNum_articulo_europeo(request.getParameter("v3"));
            pp.setUnidad_medida_base(request.getParameter("v5"));
            pp.setLote_proveedor(request.getParameter("v6"));
            pp.setPedido(request.getParameter("ped"));
            pp.setMaterial(request.getParameter("v7"));
            pp.setAlmacen(request.getParameter("v8"));
            pp.setTipo_doc_compras(request.getParameter("v9"));
            pp.setClase_pedido(request.getParameter("v10"));
            pp.setNum_cuenta_proveedor(request.getParameter("v11"));
            pp.setDescripcion(request.getParameter("v12"));
            pp.setCantidad(request.getParameter("v13"));
            pp.setCantidad_pedido(request.getParameter("v14"));
            pp.setUltima_cantidad(request.getParameter("v15"));
            pp.setTipo_mov(request.getParameter("v16"));
            pp.setCentro_coste(request.getParameter("v17"));
            pp.setClase_coste(request.getParameter("v18"));
            pp.setNum_orden(request.getParameter("v19"));
            pp.setTipo_imputacion(request.getParameter("v20"));
            pp.setFecha_entrega_posicion(request.getParameter("v21"));
            pp.setCentro(request.getParameter("v22"));
            String us = request.getParameter("ipFolio");

            String Action = request.getParameter("Action");
            String mov = request.getParameter("mov");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");//Material
            String v7 = request.getParameter("v7");
            String v8 = request.getParameter("v8");
            String v9 = request.getParameter("v9");
            String v10 = request.getParameter("v10");
            String v11 = request.getParameter("v11");
            String v12 = request.getParameter("v12");
            String v13 = request.getParameter("v13");
            String v14 = request.getParameter("v14");
            String v15 = request.getParameter("v15");
            String v16 = request.getParameter("v16");
            String v17 = request.getParameter("v17");
            String v18 = request.getParameter("v18");
            String v19 = request.getParameter("v19");
            String v20 = request.getParameter("v20");
            String v21 = request.getParameter("v21");
            String almp = request.getParameter("almp");
            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            String FContable = Consultas.ObtenerInstancia().ObtenerFechaContableMov();

            String Fch, n2, fl;
            String mouser = (String) session.getAttribute("Usuario");
            Fch = FContable.equals("") ? fechaActual : FContable;
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("MO");
            folios fp = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("QP");
            int fa = fo.getFolioActual();
            int c;
            Date fecha = new Date();
            DateFormat fFecha = new SimpleDateFormat("yyyy-MM-dd");
            String calendar = fFecha.format(fecha);
            String StockEspecial = request.getParameter("v22");
            Properties po = new Properties();
            try {
                po.load(getServletContext().getResourceAsStream("/WEB-INF/Language" + Idioma + ".properties"));
            } catch (Exception e) {
                System.err.println("Error por: " + e);
            }
            switch (Action) {
                case "VerificarRegistros":
                    int total = ACC_Pedidos.ObtenerInstancia().VerificarRagistros(us, v2);
                    if (total < Integer.parseInt(v1)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                case "GuardaTemporal":
                    ACC_Pedidos.ObtenerInstancia().GuardaTempt(pp.getPedido(), us);
                    break;
                case "VaciarTemporal":
                    ACC_Pedidos.ObtenerInstancia().VaciarTempt(us);
                    break;
                case "VaciarMovimientos":
                    ACC_Pedidos.ObtenerInstancia().MovimientoTempt(v1, us);
                    break;
                case "ActualizaTemporal":
                    LinkedList<pedido_detalle> pe = ACC_Pedidos.ObtenerInstancia().ActualizaTempt(pp, us);
                    out.println("<table class=\"TablaCont\" id=\"TablaMov\">\n"
                            + "                                    <tr id=\"CabeceraTabla\">\n"
                            + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TUM_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TstockEspecial_MOM") + "</td>\n"
                            + "                                        <td class=\"ajustar\">" + po.getProperty("etiqueta.Ttextobreve_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDeCostos_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosPed_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Treserva_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosRes_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TMaterialDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TAlmacenDestino_MOM") + "</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                    </tr> \n"
                            + "                                    <tbody>");
                    for (c = 0; c < pe.size(); c++) {
                        int nn = c + 1;
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" name=\"Pedidos\" value=\"" + pe.get(c).getNum_posicion() + "\"></td>"
                                + "<td name=\"mmmat\">" + pe.get(c).getMaterial() + "</td>"
                                + "<td name=\"mmprr\">" + pe.get(c).getPor_recibir() + "</td>"
                                + "<td name=\"mmumb\">" + pe.get(c).getUnidad_medida_base() + "</td>"
                                + "<td name=\"mmnlt\">" + pe.get(c).getNuevo_lote() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td class=\"ajustar\" name=\"mmdsc\">" + pe.get(c).getDescripcion() + "</td>"
                                + "<td name=\"mmnord\">" + pe.get(c).getNum_orden() + "</td>"
                                + "<td name=\"mmcec\">" + pe.get(c).getCentro_coste() + "</td>"
                                + "<td name=\"mmclco\">" + pe.get(c).getClase_coste() + "</td>"
                                + "<td name=\"mmped\">" + pe.get(c).getPedido() + "</td>"
                                + "<td name=\"mmnpe\">" + pe.get(c).getNum_posicion() + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"//proveedor
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td class=\"ocultar\" name=\"mmtimp\">" + pe.get(c).getTipo_imputacion() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmLoteProvd\">" + pe.get(c).getLote_proveedor() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmmovim\">" + pe.get(c).getNum_articulo_europeo() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmcnt\">" + pe.get(c).getCantidad() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmuct\">" + pe.get(c).getUltima_cantidad() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmalmped\">" + pe.get(c).getAlmacen() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmidx\">" + nn + "</td>"
                                + "</tr>");
                    }
                    for (int d = c; d <= 14; d++) {
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
                    break;
                case "EliminaTemporal":
                    LinkedList<pedido_detalle> p = ACC_Pedidos.ObtenerInstancia().EliminaTempt(pp.getPedido(), mov, us);
                    String ppos = "";
                    String pedd = "";
                    out.println("<table class=\"TablaCont\" id=\"TablaMov\">\n"
                            + "                                    <tr id=\"CabeceraTabla\">\n"
                            + "                                        <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tmaterial_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tcantidad_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TUM_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Tlote_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TstockEspecial_MOM") + "</td>\n"
                            + "                                        <td class=\"ajustar\">" + po.getProperty("etiqueta.Ttextobreve_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Torden_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDeCostos_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TclasCost_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPedido_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosPed_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.Treserva_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TPosRes_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TProveedor_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TMaterialDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TCentroDestino_MOM") + "</td>\n"
                            + "                                        <td>" + po.getProperty("etiqueta.TAlmacenDestino_MOM") + "</td>\n"
                            + "                                        <td class=\"ocultar\">&nbsp;</td>\n"
                            + "                                    </tr> \n"
                            + "                                    <tbody>");
                    for (c = 0; c < p.size(); c++) {

                        int nn = c + 1;
                        String StockE = "";
                        pedd = p.get(c).getPedido();
                        ppos = p.get(c).getNum_posicion();
                        if (mov.trim().equals("301") || mov.trim().equals("311") || mov.trim().equals("313") || mov.trim().equals("315")) {
                            pedd = p.get(c).getNum_solped();
                            ppos = p.get(c).getNum_posicion_solped();
                            if (!p.get(c).getNum_solped().isEmpty()) {
                                StockE = "E";
                            }
                        }

                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" name=\"Pedidos\" value=\"" + p.get(c).getNum_posicion() + "\"></td>"
                                + "<td name=\"mmmat\">" + p.get(c).getMaterial() + "</td>"
                                + "<td name=\"mmprr\">" + p.get(c).getPor_recibir() + "</td>"
                                + "<td name=\"mmumb\">" + p.get(c).getUnidad_medida_base() + "</td>"
                                + "<td name=\"mmnlt\">" + p.get(c).getNuevo_lote() + "</td>"
                                + "<td name=\"mmStEs\">" + StockE + "</td>"
                                + "<td class=\"ajustar\" name=\"mmdsc\">" + p.get(c).getDescripcion() + "</td>"
                                + "<td name=\"mmnord\">" + p.get(c).getNum_orden() + "</td>"
                                + "<td name=\"mmcec\">" + p.get(c).getCentro_coste() + "</td>"
                                + "<td name=\"mmclco\">" + p.get(c).getClase_coste() + "</td>"
                                + "<td name=\"mmped\">" + pedd + "</td>"
                                + "<td name=\"mmnpe\">" + ppos + "</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"//proveedor
                                + "<td>&nbsp;</td>"
                                + "<td name=\"mmCentro\">" + p.get(c).getCentro() + "</td>"
                                + "<td name=\"mmAlmace\">" + p.get(c).getAlmacen() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmcnt\">" + p.get(c).getCantidad() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmtimp\">" + p.get(c).getTipo_imputacion() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmLoteProvd\">" + p.get(c).getLote_proveedor() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmmovim\">" + p.get(c).getNum_articulo_europeo() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmuct\">" + p.get(c).getUltima_cantidad() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmidx\">" + (Integer.parseInt(c + "") + 1) + "</td>"
                                + "<td class=\"ocultar\" name=\"tdPos\">" + p.get(c).getNum_posicion() + "</td>"
                                + "<td class=\"ocultar\" name=\"tdPoss\">" + p.get(c).getNum_posicion() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmalmped\">" + p.get(c).getAlmacen() + "</td>"
                                + "<td class=\"ocultar\" name=\"mmPosR\">" + p.get(c).getNum_posicion_solped() + "</td>"
                                + "</tr>");
                    }
                    for (int d = c; d <= 14; d++) {
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
                    break;
                case "ActualizarFolioPM":
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("QP", fp.getFolioActual());
                    break;
                case "ActualizaConjunto":
                    Consultas.ObtenerInstancia().ActualizaConjunto(v1);
                    break;
                case "ActualizaConjunto2":
                    Consultas.ObtenerInstancia().ActualizaConjunto2(v1);
                    break;
                case "TextoDecisionEmpleo":
                    fl = "QP" + fp.getFolioActual();
                    Consultas.ObtenerInstancia().DecisionEmpleoTexto(fl, v1, v2);
                    break;
                case "TextoLibreResultados":
                    fl = "QP" + fp.getFolioActual();
                    Consultas.ObtenerInstancia().ResultadosTextoLibre(fl, v1, v2, v3, v4);
                    break;
                case "DecisionEmpleo":
                    fl = "QP" + fp.getFolioActual();
                    Consultas.ObtenerInstancia().DecisionEmpleo(fl, v1, v2, v3, fechaActual, horaActual, v4, v5, v6, v7);
                    break;
                case "DecisionEmpleoCap":
                    fl = "QP" + fp.getFolioActual();
                    Consultas.ObtenerInstancia().DecisionEmpleoCap(fl, v1, v2, v3, fechaActual, horaActual, v4, v5, v6, v7);
                    break;
                case "CabeceraCalidadPM":
                    fl = "QP" + fp.getFolioActual();
                    Consultas.ObtenerInstancia().CabCalidadPM(fl, v1, fechaActual, horaActual, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
                    break;
                case "PosicionesCalidadPM":
                    fl = "QP" + fp.getFolioActual();
                    Consultas.ObtenerInstancia().PosCalidadPM(fl, v1, v2, fechaActual, horaActual, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
                    break;
                case "DefectosCalidadCabecera":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().DefectosCalidad("QM" + v1, v2, fechaActual, v3, horaActual, v4, fl, v5, v6, v7, v8, v9);
                    break;
                case "DefectosCalidadPosiciones":
                    String pc = "";
                    for (int i = v10.length(); i < 4; i++) {
                        pc += "0";
                    }
                    pc += v10;
                    Consultas.ObtenerInstancia().PosDefCalidad("QM" + v11, pc, fechaActual, horaActual, v1, v2, v3, v4, v5, v6, v7, v8, v9);
                    break;
                case "DefectosCalidadTexto":
                    String tx = "";
                    for (int i = v2.length(); i < 4; i++) {
                        tx += "0";
                    }
                    tx += v2;
                    Consultas.ObtenerInstancia().TxtDefCalidad("QM" + v1, tx, v3, v4);
                    break;
                case "BorraCabPos":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().BorrarCabMM(fl);
                    Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
                    break;
                case "retrocesoMov101":
                    String nr = "";
                    for (int i = v8.length(); i < 5; i++) {
                        nr += "0";
                    }
                    nr += v8;
                    Double ncntr = Double.parseDouble(v1);
                    Consultas.ObtenerInstancia().ActualizarPedidosDetalle(v7, nr, Num(String.valueOf(ncntr)), v3);
                    break;
                case "retrocesoMov102":
                    Double ncntr1 = Double.parseDouble(v15);
                    String rn = "";
                    for (int i = v8.length(); i < 5; i++) {
                        rn += "0";
                    }
                    rn += v8;
                    Consultas.ObtenerInstancia().ActualizarDetallesDocMateriales(Num(String.valueOf(ncntr1)), v14, rn);
                    String ucr = ACC_Stock.ObtenerInstancia().GETULCAN(v7, rn);
                    Double pdcr = Double.parseDouble(ucr) + Double.parseDouble(v4);
                    Consultas.ObtenerInstancia().ActualizarPedidosDetalle(v7, rn, Num(String.valueOf(pdcr)), v3);

                    break;
                case "Guarda101Cabecera":
                    if (Consultas.ObtenerInstancia().posicionesMM(us, v19)) {
                        Consultas.ObtenerInstancia().CabeceraCreaMov(us, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, mouser);
                        out.println(1);
                    } else {
                        Consultas.ObtenerInstancia().BorrarRegistroMM(us);
                        Consultas.ObtenerInstancia().BorrarHistorialMM(us);
                        out.println(2);
                    }
                    break;
                case "Guarda102Cabecera":
                    fl = "MO" + fo.getFolioActual();

                    if (Consultas.ObtenerInstancia().posicionesMM(us, v19)) {
                        Consultas.ObtenerInstancia().CabeceraCreaMov(us, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, mouser);
                        out.println(1);
                    } else {
                        Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
                        Consultas.ObtenerInstancia().BorrarHistorialMM(fl);
                        out.println(2);
                    }
                    break;
                case "Guarda201Cabecera":
                    fl = "MO" + fo.getFolioActual();

                    if (Consultas.ObtenerInstancia().posicionesMM(fl, v19)) {
                        Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, us);
                        out.println(1);
                    } else {
                        Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
                        out.println(2);
                    }
                    break;
                case "Guarda202Cabecera":
                    fl = "MO" + fo.getFolioActual();

                    if (Consultas.ObtenerInstancia().posicionesMM(fl, v19)) {
                        Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, us);
                        out.println(1);
                    } else {
                        Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
                        out.println(2);
                    }
                    break;
                case "Guarda261Cabecera":
                    fl = "MO" + fo.getFolioActual();

                    if (Consultas.ObtenerInstancia().posicionesMM(fl, v19)) {
                        Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, us);
                        out.println(1);
                    } else {
                        Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
                        out.println(2);
                    }
                    break;
                case "Guarda262Cabecera":
                    fl = "MO" + fo.getFolioActual();

                    if (Consultas.ObtenerInstancia().posicionesMM(fl, v19)) {
                        Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, us);
                        out.println(1);
                    } else {
                        Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
                        out.println(2);
                    }
                    break;
                case "Guarda303Cabecera":
                    fl = "MO" + fo.getFolioActual();

                    if (Consultas.ObtenerInstancia().posicionesMM(fl, v19)) {
                        Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, us);
                        out.println(1);
                    } else {
                        Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
                        out.println(2);
                    }
                    break;
                case "Guarda305Cabecera":
                    fl = "MO" + fo.getFolioActual();

                    if (Consultas.ObtenerInstancia().posicionesMM(fl, v19)) {
                        Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, us);
                        out.println(1);
                    } else {
                        Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
                        out.println(2);
                    }
                    break;
                case "Guarda311Cabecera":
                    fl = "MO" + fo.getFolioActual();

//                    if(Consultas.ObtenerInstancia().posicionesMM(fl, v19)){
                    Consultas.ObtenerInstancia().CabeceraCreaMov(us, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", "", mouser);
                    out.println(1);
//                    }else{
//                        Consultas.ObtenerInstancia().BorrarRegistroMM(fl);
//                        out.println(2);
//                    }
                    break;
                case "Guarda312Cabecera":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaMov(fl, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", Fch, mouser);
                    break;
                case "Guarda301Cabecera":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaMov(us, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", "", mouser);
                    out.println(1);
                    break;
                case "Guarda313Cabecera":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaMov(us, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", "", mouser);
                    out.println(1);
                    break;
                case "Guarda315Cabecera":
                    Consultas.ObtenerInstancia().CabeceraCreaMov(us, horaActual, fechaActual, "", v1, v2, "", v7, v5, "", "", "", "", v6, "", "", "", "", "", mouser);
                    out.println(1);
                    break;
                case "Guarda101Posiciones":
                    String n = "";
                    for (int i = v8.length(); i < 5; i++) {
                        n += "0";
                    }
                    n += v8;
                    String cp = ACC_Pedidos.ObtenerInstancia().cantidad(v7, n);

                    //String query2 = "insert into movimientos_detalle_crea values ('MO" + fo.getFolioActual() + "','" + v9 + "','" + v1 + "','" + Chepos(Integer.parseInt(v10)) + "','','" + v2 + "','','" + v16 + "','" + v3 + "','" + v13 + "','','','','','','" + v4 + "','" + v17 + "','','','','','" + v5 + "','" + v6 + "','','','','','','','','','" + v12 + "','" + v7 + "','" + n + "','','','','" + v14 + "','','','','','','" + v18 + "','" + v15 + "','0.000','','','','','')";
//                    fl = "MO" + fo.getFolioActual();
//                    Consultas.ObtenerInstancia().InsertarMovDetallesCrea(fl, horaActual, fechaActual, Chepos(Integer.parseInt(v10)), "", v2, "", v16, v3, v13, "", "", "", "", "", v4, v17, "", "", "", "", v5, v6, "", "", "", "", "", "", "", "", v12, v7, n, "", "", "", v14, "", "", "", "", "", v18, v15, "0.000", "", "", "", "", "");
                    Consultas.ObtenerInstancia().PosicionesCreaDet(us, Chepos(Integer.parseInt(v10)), horaActual, fechaActual, "", v2, "", v16, v3, v13, "0.000", "0.000", "", "0.000", "", v4, v17, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", "", "0", v12, v7, n, "", "", "", v14, "", "", "", "", "", v18, v15, "", "", "", "", "", "", "", "", "", "", "");
                    //queryUT = "insert into pedidos_historial values ('" + v7 + "','" + n + "','" + v6 + "','" + v5 + "','" + cp + "','" + v13 + "','WE','" + v2 + "','','000','" + v4 + "','" + v13 + "','" + calendar + "','" + v1 + "','MO" + fo.getFolioActual() + "','X')";
                    Consultas.ObtenerInstancia().InsertarPedidosHistorial(v7, n, v6, v5, cp, v13, "WE", v2, "", "000", v4, v13, calendar, v1, "MO" + fo.getFolioActual(), "X");

                    Double ncnt = Double.parseDouble(v4) + Double.parseDouble(v11);
//                     Consultas.ObtenerInstancia().ActualizarMovDetallesCrea("pedidos_detalle", "ultima_cantidad = '" + Num(String.valueOf(ncnt)) + "', nuevo_lote = '" + v3 + "'", "num_doc_compras = '" + v7 + "' and num_posicion_doc_compras = '" + n + "'");
                    Consultas.ObtenerInstancia().ActualizarPedidosDetalle(v7, n, Num(String.valueOf(ncnt)), v3);
                    ///// Documento Mov, pos_mov,  pedido, pos_pedido, material, lote, cantidacan, centro, almacen
//                    Consultas.ObtenerInstancia().ActualizarPedidosDetalle(v7, n, Num(String.valueOf(ncnt)), v3);
                    break;
                case "Guarda102Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    String n1 = "";
                    for (int i = v8.length(); i < 5; i++) {
                        n1 += "0";
                    }
                    n1 += v8;
                    String cp1 = ACC_Pedidos.ObtenerInstancia().cantidad(v7, n1);
                    // String query4 = "insert into movimientos_detalle_crea values ('MO" + fo.getFolioActual() + "','" + v9 + "','" + v1 + "','" + Chepos(Integer.parseInt(v10)) + "','','" + v2 + "','','','" + v3 + "','" + v13 + "','','','','','','" + v4 + "','" + v16 + "','','','','','" + v5 + "','" + v6 + "','','','','','','','','','" + v12 + "','" + v7 + "','" + n1 + "','','','','','','','','','','','','" + v4 + "','" + v14 + "','" + v17 + "','','','')";
//                    Consultas.ObtenerInstancia().InsertarMovDetallesCrea(fl, horaActual, fechaActual, Chepos(Integer.parseInt(v10)), "", v2, "", "", v3, v13, "", "", "", "", "", v4, v16, "", "", "", "", v5, v6, "", "", "", "", "", "", "", "", v12, v7, n1, "", "", "", "", "", "", "", "", "", "", "", v4, v14, v17, "", "", "");
                    Consultas.ObtenerInstancia().PosicionesCreaDet(us, Chepos(Integer.parseInt(v10)), horaActual, fechaActual, "", v2, "", "", v3, v13, "0.000", "0.000", "", "0.000", "", v4, v16, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", "", "0", v12, v7, n1, "", "", "", "", "", "", "", "", "", "", "", "", "", "", v14, v17, "", "", "", "", "", "");
                    // queryUT = "insert into pedidos_historial values ('" + v7 + "','" + n1 + "','" + v6 + "','" + v5 + "','" + cp1 + "','" + v13 + "','WE','" + v2 + "','','000','-" + v4 + "','" + v13 + "','" + calendar + "','" + v1 + "','MO" + fo.getFolioActual() + "','X')";
                    Consultas.ObtenerInstancia().InsertarPedidosHistorial(v7, n1, v6, v5, cp1, v13, "WE", v2, "", "000", "-" + v4, v13, calendar, v1, "MO" + fo.getFolioActual(), "X");

                    Double ncnt1 = Double.parseDouble(v11) + Double.parseDouble(v15);
                    Double cant12 = Double.parseDouble(v4) + Double.parseDouble(v15);

                    String nf = "";
                    for (int i = v8.length(); i < 5; i++) {
                        nf += "0";
                    }
                    nf += v8;
                    //Consultas.ObtenerInstancia().Update("detalles_doc_materiales", "cantidad_cancelada = '" + Num(String.valueOf(ncnt1)) + "'", "num_doc_material='" + v14 + "' AND num_posicion_doc_compras = '" + nf + "'");
                    ACC_DetallesDocMateriales.ObtenerInstancia().ActualizrCantidadCancelMov101(v14, v17, v7, v8, v6, v3, v12, v16, Num(String.valueOf(cant12)));
                    Consultas.ObtenerInstancia().ActualizarDetallesDocMateriales(Num(String.valueOf(ncnt1)), v14, nf);
                    // Consultas.ObtenerInstancia().Update("movimientos_detalle_crea", "cantidad_cancelada = '" + Num(String.valueOf(ncnt1)) + "'", "folio_sam='" + v14 + "' AND num_posicion_doc_compras = '" + nf + "'");
                    //Consultas.ObtenerInstancia().ActualizarMovimientosDetalleCrea(Num(String.valueOf(ncnt1)), v14, nf); 
                    String uc = ACC_Stock.ObtenerInstancia().GETULCAN(v7, n1);
                    Double pdc = Double.parseDouble(uc) - Double.parseDouble(v4);
                    //Consultas.ObtenerInstancia().Update("pedidos_detalle", "ultima_cantidad = '" + Num(String.valueOf(pdc)) + "', nuevo_lote = '" + v3 + "'", "num_doc_compras = '" + v7 + "' and num_posicion_doc_compras = '" + n1 + "'");
                    Consultas.ObtenerInstancia().ActualizarPedidosDetalle(v7, n1, Num(String.valueOf(pdc)), v3);

                    break;
                case "Guarda201Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", "", v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", v13, v14, "", "0.000", "", "0", v9, "", "", "", "", "", v10, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                    break;
                case "Guarda202Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", "", v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", "", "0", v9, "", "", "", "", "", v10, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                    break;
                case "Guarda261Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", v10, v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", v13, v14, "", "0.000", "", "0", v9, "", "", StockEspecial, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", v20, v21);
                    break;
                case "Guarda262Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", v10, v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", "", "0", v9, "", "", StockEspecial, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", v20, v21);
                    break;
                case "Guarda303Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", "", v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", "", "0", v9, "", "", "", "", v10, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                    break;
                case "Guarda305Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", "", v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", "", "0", v9, "", "", "", "", v10, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                    break;
                case "Guarda311Posiciones":
                    //v10 -> almacen receptor
                    //v9 -> Centro
                    //v12 -> almacen origen
//                    String wh = ACC_Almacenes.ObtenerInstancia().verificaAlmacenDes(v10, v9);
                    fl = "MO" + fo.getFolioActual();
//                    if(!wh.trim().equals("")){
//                        Consultas.ObtenerInstancia().CabeceraCreaDet(fl, horaActual, fechaActual, Chepos(Integer.parseInt(v8)), "", v2, "", "", v3, v11, "", "", "", "", "", v4, v12, "", "", "", "", v5, v6, "", "", v13, v14, "", "", "TR01", "", v9, "", "", "", "", "", "", "", "", "", "", "", v10, "", "", "", "", "", "", "");
//                    }else{
//                        Consultas.ObtenerInstancia().CabeceraCreaDet(fl, horaActual, fechaActual, Chepos(Integer.parseInt(v8)), "", v2, "", "", v3, v11, "", "", "", "", "", v4, v12, "", "", "", "", v5, v6, "", "", v13, v14, "", "", v10, "", v9, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
//                    }
                    Consultas.ObtenerInstancia().PosicionesCreaDet(us, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", "", v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", v13, v14, "", "0.000", v10, "0", v9, "", "", StockEspecial, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", v20, v21, "");
                    break;
                case "Guarda312Posiciones":
                    fl = "MO" + fo.getFolioActual();
//                    Consultas.ObtenerInstancia().CabeceraCreaDet(fl, horaActual, fechaActual, Chepos(Integer.parseInt(v8)), "", v2, "", "", v3, v11, "", "", "", "", "", v4, "", "", "", "", "", v5, v6, "", "", "", "", "", "", v10, "", v9, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                    break;
                case "Guarda301Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().PosicionesCreaDet(us, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", "", v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", v10, "0", v9, "", "", StockEspecial, "", v15, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", v20, v21, "");
                    break;
                case "Guarda313Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().PosicionesCreaDet(us, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", "", v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", v10, "0", v9, "", "", StockEspecial, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", v20, v21, "");
                    break;
                case "Guarda315Posiciones":
                    fl = "MO" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().PosicionesCreaDet(us, Chepos(Integer.parseInt(v8)), horaActual, fechaActual, "", v2, "", "", v3, v11, "0.000", "0.000", "", "0.000", "", v4, v12, "", "0.000", "", "0.000", v5, v6, "0.000", "", "0", "0", "", "0.000", v12, "0", v9, "", "", StockEspecial, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", v20, v21, "");
                    break;
                case "Lote101Posiciones":
                    int cl1 = Integer.parseInt(v2);
                    int pr1 = 0;
                    String[][] M101 = new String[cl1][6];
                    String[] parts1 = v1.split(",");
                    try {
                        // llenado de datos
                        for (int f = 0; f < cl1; f++) {
                            for (c = 0; c < 6; c++) {
                                M101[f][c] = parts1[pr1];
                                pr1++;
                            }
                        }
                        for (int f = 0; f < cl1; f++) {
                            try {
                                int mm = Integer.parseInt(M101[f][2]);
                                n2 = "";
//                                for (int i = M101[f][2].length(); i < 18; i++) {
//                                    n2 += "0";
//                                }
                                n2 += mm;
                            } catch (Exception e) {
                                n2 = M101[f][2];
                            }

                            if (M101[f][5].equals("V")) {
                                ACC_Stock.ObtenerInstancia().ActualizaInventario(n2, M101[f][3], M101[f][1], M101[f][0], M101[f][4]);
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Lote202Posiciones":
                    int cl2 = Integer.parseInt(v2);
                    int pr2 = 0;
                    String[][] M202 = new String[cl2][5];
                    String[] parts202 = v1.split(",");
                    try {
                        for (int f = 0; f < cl2; f++) {
                            for (c = 0; c < 5; c++) {
                                M202[f][c] = parts202[pr2];
                                pr2++;
                            }
                        }
                        for (int f = 0; f < cl2; f++) {
                            try {
                                int mm = Integer.parseInt(M202[f][2]);
                                n2 = "";
//                                for (int i = M202[f][2].length(); i < 18; i++) {
//                                    n2 += "0";
//                                }
                                n2 += mm;
                            } catch (Exception e) {
                                n2 = M202[f][2];
                            }
                            ACC_Stock.ObtenerInstancia().ActualizaInventario(n2, M202[f][3], M202[f][1], M202[f][0], M202[f][4]);
                        }
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "ActualizarFolio":
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("MO", fo.getFolioActual());
                    out.println(fo.getFolioActual());
                    break;
                case "Movimiento102":
                    int cl = Integer.parseInt(v2);
                    int pr = 0;
                    String[][] M102 = new String[cl][12];
                    String[] parts = v1.split(",");
                    try {
                        for (int f = 0; f < cl; f++) {
                            for (c = 0; c < 12; c++) {
                                M102[f][c] = parts[pr];
                                pr++;
                            }
                        }
                        int rtn = ACC_Stock.ObtenerInstancia().VerificarExistentes(M102, cl);
                        if (rtn == 1) {
                            for (int f = 0; f < cl; f++) {
                                try {
                                    Double mm = Double.parseDouble(M102[f][3]);
                                    n2 = "";
//                                    for (int i = M102[f][5].length(); i < 18; i++) {
//                                        n2 += "0";
//                                    }
                                    n2 += mm;
                                } catch (Exception e) {
                                    n2 = M102[f][5];
                                }

                                Double ul = ACC_Stock.ObtenerInstancia().UltimoLU(n2, M102[f][10], M102[f][2], M102[f][11]);
                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201UltimoStock(Num(String.valueOf(ul)), n2, M102[f][10], M102[f][2], M102[f][11]);
                            }
                        }
                        if (rtn == 2) {
                            for (int f = 0; f < cl; f++) {
                                try {
                                    int mm = Integer.parseInt(M102[f][5]);
                                    n2 = "";
//                                    for (int i = M102[f][5].length(); i < 18; i++) {
//                                        n2 += "0";
//                                    }
                                    n2 += mm;
                                } catch (Exception e) {
                                    n2 = M102[f][5];
                                }

                                Double ul = ACC_Stock.ObtenerInstancia().LibreLU(n2, M102[f][10], M102[f][2], M102[f][11]);
                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201StockLibre(Num(String.valueOf(ul)), n2, M102[f][10], M102[f][2], M102[f][11]);
                            }
                        }
                        out.println(rtn);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Movimiento201":
                    int cc = Integer.parseInt(v2);
                    int ppr = 0;
                    String[][] M201 = new String[cc][5];
                    String[] parts2 = v1.split(",");
                    try {
                        for (int f = 0; f < cc; f++) {
                            for (c = 0; c < 5; c++) {
                                M201[f][c] = parts2[ppr];
                                ppr++;
                            }
                        }
                        int rtn = ACC_Stock.ObtenerInstancia().VerificarExistentesN(M201, cc);
                        if (rtn == 1) {
                            for (int f = 0; f < cc; f++) {
                                try {
                                    int mm = Integer.parseInt(M201[f][2]);
                                    n2 = "";
//                                    for (int i = M201[f][2].length(); i < 18; i++) {
//                                        n2 += "0";
//                                    }
                                    n2 += mm;
                                } catch (Exception e) {
                                    n2 = M201[f][2];
                                }
                                Double ul = ACC_Stock.ObtenerInstancia().UltimoLU(n2, M201[f][3], M201[f][0], M201[f][4]);
                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201UltimoStock(Num(String.valueOf(ul)), n2, M201[f][3], M201[f][0], M201[f][4]);
                            }
                        }
                        if (rtn == 2) {
                            for (int f = 0; f < cc; f++) {
                                try {
                                    int mm = Integer.parseInt(M201[f][2]);
                                    n2 = "";
//                                    for (int i = M201[f][2].length(); i < 18; i++) {
//                                        n2 += "0";
//                                    }
                                    n2 += mm;
                                } catch (Exception e) {
                                    n2 = M201[f][2];
                                }
                                Double ul = ACC_Stock.ObtenerInstancia().LibreLU(n2, M201[f][3], M201[f][0], M201[f][4]);
                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201StockLibre(Num(String.valueOf(ul)), n2, M201[f][3], M201[f][0], M201[f][4]);
                            }
                        }
                        out.println(rtn);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Movimiento303":
                    int cc3n = Integer.parseInt(v2);
                    int ppr3n = 0;
                    String[][] M303 = new String[cc3n][6];
                    String[] parts3n = v1.split(",");
                    try {
                        for (int f = 0; f < cc3n; f++) {
                            for (c = 0; c < 6; c++) {
                                M303[f][c] = parts3n[ppr3n];
                                ppr3n++;
                            }
                        }
                        int rtn = ACC_Stock.ObtenerInstancia().VerificarExistentes300N(M303, cc3n);
                        if (rtn == 1) {
                            for (int f = 0; f < cc3n; f++) {
                                try {
                                    int mm = Integer.parseInt(M303[f][2]);
                                    n2 = "";
//                                    for (int i = M303[f][2].length(); i < 18; i++) {
//                                        n2 += "0";
//                                    }
                                    n2 += mm;
                                } catch (Exception e) {
                                    n2 = M303[f][2];
                                }
                                Double ul = ACC_Stock.ObtenerInstancia().UltimoLU(n2, M303[f][3], M303[f][0], M303[f][4]);
                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201UltimoStock(Num(String.valueOf(ul)), n2, M303[f][3], M303[f][0], M303[f][4]);
//                                Double uld = ACC_Stock.ObtenerInstancia().UltimoLUC(n2, M303[f][5], M303[f][0], M303[f][4]);
//                                Consultas.ObtenerInstancia().Update("inventarios", "ultimo_transito = '" + Num(String.valueOf(uld)) + "'", "material='" + n2 + "' and centro = '" + M303[f][5] + "' and lote ='" + M303[f][0] + "' and almacen = '" + M303[f][4] + "'");

                            }
                        }
                        if (rtn == 2) {
                            for (int f = 0; f < cc3n; f++) {
                                try {
                                    int mm = Integer.parseInt(M303[f][2]);
                                    n2 = "";
//                                    for (int i = M303[f][2].length(); i < 18; i++) {
//                                        n2 += "0";
//                                    }
                                    n2 += mm;
                                } catch (Exception e) {
                                    n2 = M303[f][2];
                                }
                                Double ul = ACC_Stock.ObtenerInstancia().LibreLU(n2, M303[f][3], M303[f][0], M303[f][4]);
                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201StockLibre(Num(String.valueOf(ul)), n2, M303[f][3], M303[f][0], M303[f][4]);
//                                Double uld = ACC_Stock.ObtenerInstancia().LibreLUC(n2, M303[f][5], M303[f][0], M303[f][4]);
//                                Consultas.ObtenerInstancia().Update("inventarios", "stock_transito = '" + Num(String.valueOf(uld)) + "'", "material='" + n2 + "' and centro = '" + M303[f][5] + "' and lote ='" + M303[f][0] + "' and almacen = '" + M303[f][4] + "'");

                            }
                        }
                        out.println(rtn);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Movimiento305":
                    int cc3nn = Integer.parseInt(v2);
                    int ppr3nn = 0;
                    String[][] M305 = new String[cc3nn][6];
                    String[] parts3nn = v1.split(",");
                    try {
                        for (int f = 0; f < cc3nn; f++) {
                            for (c = 0; c < 6; c++) {
                                M305[f][c] = parts3nn[ppr3nn];
                                ppr3nn++;
                            }
                        }
                        int rtn = ACC_Stock.ObtenerInstancia().VerificarExistentesNT(M305, cc3nn);
                        if (rtn == 1) {
                            for (int f = 0; f < cc3nn; f++) {
                                Double rt = ACC_Stock.ObtenerInstancia().LbreST(M305[f][2], M305[f][3]);
                                ACC_Stock.ObtenerInstancia().UpdateMovimiento305UltimoStock(Num(String.valueOf(rt)), M305[f][2], M305[f][3]);
                            }
                        }
                        if (rtn == 2) {
                            for (int f = 0; f < cc3nn; f++) {
                                Double rt = ACC_Stock.ObtenerInstancia().UltimoST(M305[f][2], M305[f][3]);
                                ACC_Stock.ObtenerInstancia().UpdateMovimiento305StockTraslado(Num(String.valueOf(rt)), M305[f][2], M305[f][3]);
                                ACC_Stock.ObtenerInstancia().ActualizaInventario(M305[f][2], M305[f][5], M305[f][1], M305[f][0], M305[f][4]);
                            }
                        }
                        out.println(rtn);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Movimiento311":
                    DecimalFormatSymbols simbol311 = new DecimalFormatSymbols();
                    simbol311.setDecimalSeparator('.');
                    DecimalFormat df = new DecimalFormat("0.000", simbol311);
                    String ori,
                     des;
                    Double origen,
                     destino;
                    String rtnn = "";
                    int cc3 = Integer.parseInt(v2);
                    int ppr3 = 0;
                    String[][] M311 = new String[cc3][10];
                    String[] parts3 = v1.split(",");
                    try {
                        for (int f = 0; f < cc3; f++) {
                            for (c = 0; c < 10; c++) {
                                M311[f][c] = parts3[ppr3];
                                ppr3++;
                            }
                        }
                        for (int i = 0; i < cc3; i++) {
                            if (M311[i][8].equals("E")) {
                                origen = ACC_Stock.ObtenerInstancia().StockLibreE(M311[i][2], M311[i][0], M311[i][3], M311[i][4], M311[i][6], M311[i][7]) - Double.parseDouble(M311[i][1]);
                                destino = ACC_Stock.ObtenerInstancia().StockLibreE(M311[i][2], M311[i][0], M311[i][3], M311[i][5], M311[i][6], M311[i][7]) + Double.parseDouble(M311[i][1]);
                                ori = df.format(origen);
                                des = df.format(destino);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInvE(M311[i][2], M311[i][0], M311[i][3], ori, M311[i][4], M311[i][6], M311[i][7]);
                                //Destino
                                ACC_Stock.ObtenerInstancia().ActualizaInvE(M311[i][2], M311[i][0], M311[i][3], des, M311[i][5], M311[i][6], M311[i][7]);
                            } else {
                                origen = ACC_Stock.ObtenerInstancia().StockLibre(M311[i][2], M311[i][0], M311[i][3], M311[i][4]) - Double.parseDouble(M311[i][1]);
                                destino = ACC_Stock.ObtenerInstancia().StockLibre(M311[i][2], M311[i][0], M311[i][3], M311[i][5]) + Double.parseDouble(M311[i][1]);
                                ori = df.format(origen);
                                des = df.format(destino);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInv(M311[i][2], M311[i][0], M311[i][3], ori, M311[i][4]);
                                //Destino
                                ACC_Stock.ObtenerInstancia().ActualizaInv(M311[i][2], M311[i][0], M311[i][3], des, M311[i][5]);
                            }
                        }

                        out.println(2 + "," + rtnn);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Movimiento313":
                    DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
                    simbolos.setDecimalSeparator('.');
                    DecimalFormat dfk = new DecimalFormat("0.000", simbolos);
                    String orik,
                     desk;
                    Double origenk,
                     destinok;
                    String rtnnk = "";
                    int cc3k = Integer.parseInt(v2);
                    int ppr3k = 0;
                    String[][] M311k = new String[cc3k][11];
                    String[] parts3k = v1.split(",");
                    try {
                        for (int f = 0; f < cc3k; f++) {
                            for (c = 0; c < 11; c++) {
                                M311k[f][c] = parts3k[ppr3k];
                                ppr3k++;
                            }
                        }
                        for (int i = 0; i < cc3k; i++) {
                            if (M311k[i][9].equals("E")) {
                                origenk = ACC_Stock.ObtenerInstancia().StockLibreE(M311k[i][2], M311k[i][0], M311k[i][3], M311k[i][4], M311k[i][7], M311k[i][8]) - Double.parseDouble(M311k[i][1]);
                                destinok = ACC_Stock.ObtenerInstancia().GetStockTrasladoEspecial(M311k[i][2], M311k[i][0], M311k[i][3], M311k[i][5], M311k[i][7], M311k[i][8]) + Double.parseDouble(M311k[i][1]);
                                orik = dfk.format(origenk);
                                desk = dfk.format(destinok);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInvE(M311k[i][2], M311k[i][0], M311k[i][3], orik, M311k[i][4], M311k[i][7], M311k[i][8]);
                                //Destino
                                ACC_Stock.ObtenerInstancia().ActualizaInvStockEspecialTraslado(M311k[i][2], M311k[i][0], M311k[i][3], desk, M311k[i][5], M311k[i][7], M311k[i][8]);

                                //// Stock Transferencia 
                                String Stok0 = ACC_Stock.ObtenerInstancia().obtenersotcktras(M311k[i][3], M311k[i][5], M311k[i][4], M311k[i][0], M311k[i][2], M311k[i][7], M311k[i][8], "E");
                                float STE = Float.parseFloat(Stok0) + Float.parseFloat(M311k[i][1]);
                                String STEF = dfk.format(STE);
                                ACC_Stock.ObtenerInstancia().Guardar313StrockTrasladoE(M311k[i][3], M311k[i][5], M311k[i][4], M311k[i][0], M311k[i][2], STEF, M311k[i][7], M311k[i][8]);

                            } else {
                                origenk = ACC_Stock.ObtenerInstancia().StockLibre(M311k[i][2], M311k[i][0], M311k[i][3], M311k[i][4]) - Double.parseDouble(M311k[i][1]);
                                destinok = ACC_Stock.ObtenerInstancia().GetStockTraslado(M311k[i][2], M311k[i][0], M311k[i][3], M311k[i][5]) + Double.parseDouble(M311k[i][1]);
                                orik = dfk.format(origenk);
                                desk = dfk.format(destinok);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInv(M311k[i][2], M311k[i][0], M311k[i][3], orik, M311k[i][4]);
                                //Destino
                                ACC_Stock.ObtenerInstancia().ActualizaInvTraslado(M311k[i][2], M311k[i][0], M311k[i][3], desk, M311k[i][5]);

                                //// Stock Transferencia 
                                String Stok1 = ACC_Stock.ObtenerInstancia().obtenersotcktras(M311k[i][3], M311k[i][5], M311k[i][4], M311k[i][0], M311k[i][2], "", "", "");
                                float ST = Float.parseFloat(Stok1) + Float.parseFloat(M311k[i][1]);
                                String STF = dfk.format(ST);
                                ACC_Stock.ObtenerInstancia().Guardar313StrockTraslado(M311k[i][3], M311k[i][5], M311k[i][4], M311k[i][0], M311k[i][2], STF);
                            }
                        }

                        out.println(2 + "," + rtnnk);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Movimiento315":
                    DecimalFormatSymbols simbol315 = new DecimalFormatSymbols();
                    simbol315.setDecimalSeparator('.');
                    DecimalFormat dfkj = new DecimalFormat("0.000", simbol315);
                    String orikj,
                     deskj;
                    Double origenkj,
                     destinokj;
                    String rtnnkj = "";
                    int cc3kj = Integer.parseInt(v2);
                    int ppr3kj = 0;
                    String[][] M311kj = new String[cc3kj][11];
                    String[] parts3kj = v1.split(",");
                    try {
                        for (int f = 0; f < cc3kj; f++) {
                            for (c = 0; c < 11; c++) {
                                M311kj[f][c] = parts3kj[ppr3kj];
                                ppr3kj++;
                            }
                        }
                        for (int i = 0; i < cc3kj; i++) {
                            if (M311kj[i][9].equals("E")) {
                                origenkj = ACC_Stock.ObtenerInstancia().StockLibreE(M311kj[i][2], M311kj[i][0], M311kj[i][3], M311kj[i][4], M311kj[i][7], M311kj[i][8]) + Double.parseDouble(M311kj[i][1]);
                                destinokj = ACC_Stock.ObtenerInstancia().GetStockTrasladoEspecial(M311kj[i][2], M311kj[i][0], M311kj[i][3], M311kj[i][4], M311kj[i][7], M311kj[i][8]) - Double.parseDouble(M311kj[i][1]);
                                orikj = dfkj.format(origenkj);
                                deskj = dfkj.format(destinokj);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInvE(M311kj[i][2], M311kj[i][0], M311kj[i][3], orikj, M311kj[i][4], M311kj[i][7], M311kj[i][8]);
                                //Destino
                                ACC_Stock.ObtenerInstancia().ActualizaInvStockEspecialTraslado(M311kj[i][2], M311kj[i][0], M311kj[i][3], deskj, M311kj[i][4], M311kj[i][7], M311kj[i][8]);

                                /// Stock Tranferencia
                                String Stok0 = ACC_Stock.ObtenerInstancia().obtenersotcktras315(M311kj[i][3], M311kj[i][4], M311kj[i][0], M311kj[i][2], M311kj[i][7], M311kj[i][8], "E");
                                float STE = Float.parseFloat(Stok0) - Float.parseFloat(M311kj[i][1]);
                                String STEF = dfkj.format(STE);
                                ACC_Stock.ObtenerInstancia().ActualizarTras313(M311kj[i][3], M311kj[i][4], M311kj[i][0], M311kj[i][2], STEF, M311kj[i][7], M311kj[i][8], "E");
                            } else {
                                origenkj = ACC_Stock.ObtenerInstancia().StockLibre(M311kj[i][2], M311kj[i][0], M311kj[i][3], M311kj[i][4]) + Double.parseDouble(M311kj[i][1]);
                                destinokj = ACC_Stock.ObtenerInstancia().GetStockTraslado(M311kj[i][2], M311kj[i][0], M311kj[i][3], M311kj[i][4]) - Double.parseDouble(M311kj[i][1]);
                                orikj = dfkj.format(origenkj);
                                deskj = dfkj.format(destinokj);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInv(M311kj[i][2], M311kj[i][0], M311kj[i][3], orikj, M311kj[i][4]);
                                //Destino
                                ACC_Stock.ObtenerInstancia().ActualizaInvTraslado(M311kj[i][2], M311kj[i][0], M311kj[i][3], deskj, M311kj[i][4]);

                                //// Stock Transferencia 
                                String Stok1 = ACC_Stock.ObtenerInstancia().obtenersotcktras315(M311kj[i][3], M311kj[i][4], M311kj[i][0], M311kj[i][2], "", "", "");
                                float ST = Float.parseFloat(Stok1) - Float.parseFloat(M311kj[i][1]);
                                String STF = dfkj.format(ST);
                                ACC_Stock.ObtenerInstancia().ActualizarTras313(M311kj[i][3], M311kj[i][4], M311kj[i][0], M311kj[i][2], STF, "", "", "");
                            }
                        }

                        out.println(2 + "," + rtnnkj);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Movimiento301":
                    DecimalFormatSymbols simbol301 = new DecimalFormatSymbols();
                    simbol301.setDecimalSeparator('.');
                    DecimalFormat dft = new DecimalFormat("0.000", simbol301);
                    String orit,
                     dest;
                    Double origent,
                     destinot;
                    String rtnnt = "";
                    int cc3t = Integer.parseInt(v2);
                    int ppr3t = 0;
                    String[][] M311t = new String[cc3t][11];
                    String[] parts3t = v1.split(",");
                    try {
                        for (int f = 0; f < cc3t; f++) {
                            for (c = 0; c < 11; c++) {
                                M311t[f][c] = parts3t[ppr3t];
                                ppr3t++;
                            }
                        }
                        for (int i = 0; i < cc3t; i++) {
                            if (M311t[i][9].equals("E")) {
                                origent = ACC_Stock.ObtenerInstancia().StockLibreE(M311t[i][2], M311t[i][0], M311t[i][3], M311t[i][4], M311t[i][7], M311t[i][8]) - Double.parseDouble(M311t[i][1]);
                                destinot = ACC_Stock.ObtenerInstancia().StockLibreE(M311t[i][2], M311t[i][0], M311t[i][6], M311t[i][5], M311t[i][7], M311t[i][8]) + Double.parseDouble(M311t[i][1]);
                                orit = dft.format(origent);
                                dest = dft.format(destinot);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInvE(M311t[i][2], M311t[i][0], M311t[i][3], orit, M311t[i][4], M311t[i][7], M311t[i][8]);
                                //Destino
                                ACC_Stock.ObtenerInstancia().ActualizaInvE(M311t[i][2], M311t[i][0], M311t[i][6], dest, M311t[i][5], M311t[i][7], M311t[i][8]);
                            } else {
                                origent = ACC_Stock.ObtenerInstancia().StockLibre(M311t[i][2], M311t[i][0], M311t[i][3], M311t[i][4]) - Double.parseDouble(M311t[i][1]);
                                destinot = ACC_Stock.ObtenerInstancia().StockLibre(M311t[i][2], M311t[i][0], M311t[i][6], M311t[i][5]) + Double.parseDouble(M311t[i][1]);
                                orit = dft.format(origent);
                                dest = dft.format(destinot);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInv(M311t[i][2], M311t[i][0], M311t[i][3], orit, M311t[i][4]);
                                //Destino
                                ACC_Stock.ObtenerInstancia().ActualizaInv(M311t[i][2], M311t[i][0], M311t[i][6], dest, M311t[i][5]);
                            }
                        }

                        out.println(2 + "," + rtnnt);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
//                case "Movimiento311":
//                    String rtnn = "";
//                    int cc3 = Integer.parseInt(v2);
//                    int ppr3 = 0;
//                    String[][] M311 = new String[cc3][6];
//                    String[] parts3 = v1.split(",");
//                    try {
//                        for (int f = 0; f < cc3; f++) {
//                            for (c = 0; c < 6; c++) {
//                                M311[f][c] = parts3[ppr3];
//                                ppr3++;
//                            }
//                        }
//                        int rtn = ACC_Stock.ObtenerInstancia().VerificarExistentes300(M311, cc3);
//                        if (rtn == 1) {
//                            for (int f = 0; f < cc3; f++) {
//                                try {
//                                    int mm = Integer.parseInt(M311[f][2]);
//                                    n2 = "";
////                                    for (int i = M311[f][2].length(); i < 18; i++) {
////                                        n2 += "0";
////                                    }
//                                    n2 += mm;
//                                } catch (Exception e) {
//                                    n2 = M311[f][2];
//                                }
//                                String ck = ACC_Almacenes.ObtenerInstancia().verificaAlmacenDes(M311[f][5], M311[f][3]);
//                                String al;
//                                if(!ck.trim().equals("")){
//                                    al = "TR01";
//                                }else{
//                                    al = M311[f][5];
//                                }
//                                Double ul = ACC_Stock.ObtenerInstancia().UltimoLU(n2, M311[f][3], M311[f][0], M311[f][4]);
//                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201UltimoStock(Num(String.valueOf(ul)), n2, M311[f][3], M311[f][0], M311[f][4]);
//                                Double uld = ACC_Stock.ObtenerInstancia().UltimoLUD(n2, M311[f][3], M311[f][0], al);
//                                ACC_Stock.ObtenerInstancia().UpdateInventarioUltCentroD(Num(String.valueOf(uld)), n2, M311[f][3], M311[f][0], al);
//                                Double uln = ACC_Stock.ObtenerInstancia().UltimoLU(n2, M311[f][3], M311[f][0], al);
//                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201UltimoStock(Num(String.valueOf(uln)), n2, M311[f][3], M311[f][0], al);
//                            }
//                        }
//                        if (rtn == 2) {
////                            fl = "MO" + fo.getFolioActual();
////                            if (v3.equals("311")) {
////                                rtnn = CallWS.ObtenerInstancia().EnviaWS311(M311, fl, v4, v3, fechaActual, horaActual);
////                            }
////                            if (v3.equals("312")) {
////                                rtnn = CallWS.ObtenerInstancia().EnviaWS312(M311, fl, v4, v3, fechaActual, horaActual);
////                            }
//
//                            for (int f = 0; f < cc3; f++) {
//                                try {
//                                    int mm = Integer.parseInt(M311[f][2]);
//                                    n2 = "";
////                                    for (int i = M311[f][2].length(); i < 18; i++) {
////                                        n2 += "0";
////                                    }
//                                    n2 += mm;
//                                } catch (Exception e) {
//                                    n2 = M311[f][2];
//                                }
//                                String ck = ACC_Almacenes.ObtenerInstancia().verificaAlmacenDes(M311[f][5], M311[f][3]);
//                                String al;
//                                if(!ck.trim().equals("")){
//                                    al = "TR01";
//                                }else{
//                                    al = M311[f][5];
//                                }
//                                Double ul = ACC_Stock.ObtenerInstancia().LibreLU(n2, M311[f][3], M311[f][0], M311[f][4]);
//                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201StockLibre(Num(String.valueOf(ul)), n2, M311[f][3], M311[f][0], M311[f][4]);
//                                Double uld = ACC_Stock.ObtenerInstancia().LibreLUD(n2, M311[f][3], M311[f][0], al);
//                                ACC_Stock.ObtenerInstancia().UpdateInventarioCtdCentroD(Num(String.valueOf(uld)), n2, M311[f][3], M311[f][0], al);
//                                Double uln = ACC_Stock.ObtenerInstancia().LibreLU(n2, M311[f][3], M311[f][0], al);
//                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201StockLibre(Num(String.valueOf(uln)), n2, M311[f][3], M311[f][0], al);
//                            }
//                        }
//                        out.println(rtn + "," + rtnn);
//                    } catch (Exception e) {
//                        System.err.println("Error: " + e);
//                    }
//                    break;
                case "Movimiento261":
//                    int cc2 = Integer.parseInt(v2);
//                    int ppr2 = 0;
//                    String[][] M261 = new String[cc2][5];
//                    String[] parts22 = v1.split(",");
//                    try {
//                        for (int f = 0; f < cc2; f++) {
//                            for (c = 0; c < 5; c++) {
//                                M261[f][c] = parts22[ppr2];
//                                ppr2++;
//                            }
//                        }
//                        int rtn = ACC_Stock.ObtenerInstancia().VerificarExistentesN(M261, cc2);
//                        if (rtn == 1) {
//                            for (int f = 0; f < cc2; f++) {
//                                String nlu1 = "";
//                                nlu1 += M261[f][2];
//                                Double ul1 = ACC_Stock.ObtenerInstancia().UltimoLU(nlu1, M261[f][3], M261[f][0], M261[f][4]);
//                                ACC_Stock.ObtenerInstancia().UpdateMovimiento201UltimoStock(Num(String.valueOf(ul1)), nlu1, M261[f][3], M261[f][0], M261[f][4]);
//                            }
//                        }
//                        if (rtn == 2) {
//                            for (int f = 0; f < cc2; f++) {
//                                String nlu = "";
//                                nlu += M261[f][2];
//                                Double ul1 = ACC_Stock.ObtenerInstancia().LibreLU(nlu, M261[f][3], M261[f][0], M261[f][4]);
//                                ACC_Stock.ObtenerInstancia().UpdateMovimiento261Stock(Num(String.valueOf(ul1)), nlu, M261[f][3], M261[f][0], M261[f][4]);
//                            }
//                        }
//                        out.println(rtn);
//                    } catch (Exception e) {
//                        System.err.println("Error: " + e);
//                    }
                    DecimalFormat ddt = new DecimalFormat("#.000");
                    String orit6;
                    Double origent6;
                    String rtnnt6 = "";
                    int cc3t6 = Integer.parseInt(v2);
                    int ppr3t6 = 0;
                    String[][] M311t6 = new String[cc3t6][9];
                    String[] parts3t6 = v1.split(",");
                    try {
                        for (int f = 0; f < cc3t6; f++) {
                            for (c = 0; c < 9; c++) {
                                M311t6[f][c] = parts3t6[ppr3t6];
                                ppr3t6++;
                            }
                        }
                        for (int i = 0; i < cc3t6; i++) {
                            if (M311t6[i][7].equals("E")) {
                                origent6 = ACC_Stock.ObtenerInstancia().StockLibreE(M311t6[i][2], M311t6[i][0], M311t6[i][3], M311t6[i][4], M311t6[i][5], M311t6[i][6]) - Double.parseDouble(M311t6[i][1]);

                                orit6 = (origent6 >= 1) ? ddt.format(origent6) : "0" + ddt.format(origent6);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInvE(M311t6[i][2], M311t6[i][0], M311t6[i][3], orit6, M311t6[i][4], M311t6[i][5], M311t6[i][6]);
                            } else {
                                origent6 = ACC_Stock.ObtenerInstancia().StockLibre(M311t6[i][2], M311t6[i][0], M311t6[i][3], M311t6[i][4]) - Double.parseDouble(M311t6[i][1]);
                                orit6 = (origent6 >= 1) ? ddt.format(origent6) : "0" + ddt.format(origent6);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInv(M311t6[i][2], M311t6[i][0], M311t6[i][3], orit6, M311t6[i][4]);
                            }
                        }

                        out.println(2 + "," + rtnnt6);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "Lote262Posiciones":
//                    int cl3 = Integer.parseInt(v2);
//                    int pr3 = 0;
//                    String[][] M262 = new String[cl3][5];
//                    String[] parts262 = v1.split(",");
//                    try {
//                        for (int f = 0; f < cl3; f++) {
//                            for (c = 0; c < 5; c++) {
//                                M262[f][c] = parts262[pr3];
//                                pr3++;
//                            }
//                        }
//                        for (int f = 0; f < cl3; f++) {
//                            ACC_Stock.ObtenerInstancia().ActualizarrInventario(M262[f][2], M262[f][3], M262[f][1], M262[f][0], M262[f][4]);
//                        }
//                    } catch (Exception e) {
//                        System.err.println("Error: " + e);
//                    }
                    DecimalFormat dd62 = new DecimalFormat("#.000");
                    String orit62;
                    Double origent62;
                    String rtnnt62 = "";
                    int cc3t62 = Integer.parseInt(v2);
                    int ppr3t62 = 0;
                    String[][] M311t62 = new String[cc3t62][9];
                    String[] parts3t62 = v1.split(",");
                    try {
                        for (int f = 0; f < cc3t62; f++) {
                            for (c = 0; c < 9; c++) {
                                M311t62[f][c] = parts3t62[ppr3t62];
                                ppr3t62++;
                            }
                        }
                        for (int i = 0; i < cc3t62; i++) {
                            if (M311t62[i][7].equals("E")) {
                                origent62 = ACC_Stock.ObtenerInstancia().StockLibreE(M311t62[i][2], M311t62[i][0], M311t62[i][3], M311t62[i][4], M311t62[i][5], M311t62[i][6]) + Double.parseDouble(M311t62[i][1]);

                                orit62 = (origent62 >= 1) ? dd62.format(origent62) : "0" + dd62.format(origent62);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInvE(M311t62[i][2], M311t62[i][0], M311t62[i][3], orit62, M311t62[i][4], M311t62[i][5], M311t62[i][6]);
                            } else {
                                origent62 = ACC_Stock.ObtenerInstancia().StockLibre(M311t62[i][2], M311t62[i][0], M311t62[i][3], M311t62[i][4]) - Double.parseDouble(M311t62[i][1]);
                                orit62 = (origent62 >= 1) ? dd62.format(origent62) : "0" + dd62.format(origent62);
                                //Oriden
                                ACC_Stock.ObtenerInstancia().ActualizaInv(M311t62[i][2], M311t62[i][0], M311t62[i][3], orit62, M311t62[i][4]);
                            }
                        }

                        out.println(2 + "," + rtnnt62);
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    break;
                case "ActualizarFoliosMO":
                    String fwe = ACC_Pedidos.ObtenerInstancia().FolioPos(us);
                    out.println(fwe);
                    break;

                default:
                    break;
            }

        }
    }

    public String Num(String data) {
        String nf = "";
        if (data.indexOf(".") != -1) {
            String[] n = data.split("\\.");
            String n1 = n[0];
            String n2 = n[1];

            if (n2.length() == 1) {
                n2 = n2 + "00";
                nf = n1 + "." + n2;
            } else if (n2.length() == 2) {
                n2 = n2 + "0";
                nf = n1 + "." + n2;
            } else {
                return data;
            }
        } else {
            nf = data += ".000";
        }

        return nf;
    }

    public String Chepos(int data) {
        String i = String.valueOf(data);
        if (data < 10) {
            i = "000" + data;
        }
        if (data >= 10 && data < 100) {
            i = "00" + data;
        }
        if (data >= 100 && data < 1000) {
            i = "0" + data;
        }
        if (data >= 1000 && data < 10000) {
            i = String.valueOf(data);
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
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(PeticionGuardaMovMateriales.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InterruptedException ex) {
            Logger.getLogger(PeticionGuardaMovMateriales.class.getName()).log(Level.SEVERE, null, ex);
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
