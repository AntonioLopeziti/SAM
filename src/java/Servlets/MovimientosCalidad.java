package Servlets;

import AccesoDatos.ACC_BOMEquipos;
import AccesoDatos.ACC_CaracteristicasPlanInspeccion;
import AccesoDatos.ACC_CodigosDefecto;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_InspeccionCodigos;
import AccesoDatos.ACC_Usuarios;
import AccesoDatos.ACC_Material;
import AccesoDatos.Consultas;
import Entidades.ListaMtrl;
import Entidades.PlanInspeccionC;
import Entidades.cabecera_lotes_inspeccion_movimientos_crea;
import Entidades.folios;
import Entidades.inspeccion_codigos;
import Entidades.materiales_almacen;
import Entidades.posiciones_lotes_inspeccion_movimientos_crea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MovimientosCalidad", urlPatterns = {"/MovimientosCalidad"})
public class MovimientosCalidad extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String conjSel = request.getParameter("conjS");
            String idioma = request.getParameter("idi");
            String pos = request.getParameter("pos");
            String cod = request.getParameter("cod");
            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();

            String folio = request.getParameter("fol");
            String material = request.getParameter("mat");
            String txtB = request.getParameter("txtb");
            String nuDoc = request.getParameter("nDoc");
            String cent = request.getParameter("cent");
            String user = request.getParameter("us");

            String numC = request.getParameter("numC");
            String txtBCarInsp = request.getParameter("txtCt");
            String desBConj = request.getParameter("desB");
            String entCat = request.getParameter("entC");
            String tamMues = request.getParameter("tamMs");
            String numUn = request.getParameter("numU");
            String valOrg = request.getParameter("valOg");
            String undMe = request.getParameter("undM");
            String catal = request.getParameter("catl");
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("MO");
            switch (action) {
                case "obtenerCL":
                    out.println(ACC_CaracteristicasPlanInspeccion.ObtenerInstancia().obtenerCL(v1));
                    break;
                case "ValidaMat":
                    if (ACC_CaracteristicasPlanInspeccion.ObtenerInstancia().validaMatCld(v1)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ListaMaterialNotificacionesC":
                    int v = 0;
                    ArrayList<ListaMtrl> lm = ACC_BOMEquipos.ObtenerInstancia().ObtenerLMNotificacionesCrea(v1, v2);
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
                case "Notificaciones":
                    int i = 0;
                    ArrayList<PlanInspeccionC> pi = ACC_CaracteristicasPlanInspeccion.ObtenerInstancia().QMCaracteristicasPM(v1);
                    out.println("<table id=\"TabBody2\">\n"
                            + "<tbody>");
                    for (PlanInspeccionC p : pi) {
                        out.println("<tr>"
                                + "<td name=\"cld1\" id=\"ccld1" + i + "\">" + p.getNum_caracteristica_inspeccion() + "</td>"
                                + "<td name=\"cld2\" id=\"cld2" + i + "\">" + p.getTexto_breve_caracteristicas_inspeccion() + "</td>"
                                + "<td name=\"cld3\" id=\"cld3" + i + "\">" + p.getDescripcion_breve_conjunto_seleccion() + "</td>"
                                + "<td name=\"cldrg1\" id=\"cldrg1" + i + "\" hidden>" + p.getLimite_inferior() + "</td>"
                                + "<td name=\"cldrg2\" id=\"cldrg2" + i + "\" hidden>" + p.getLimite_superior() + "</td>"
                                + "<td name=\"cldrg3\" id=\"cldrg3" + i + "\" hidden>" + p.getIndicador_limite_inferior() + "</td>"
                                + "<td name=\"cldrg4\" id=\"cldrg4" + i + "\" hidden>" + p.getIndicador_limite_superior() + "</td>"
                                + "<td name=\"cldrg5\" id=\"cldrg5" + i + "\" hidden></td>"
                                + "<td name=\"cld4\" id=\"cld4" + i + "\" hidden>" + p.getEntrada_catalogo_conjunto_seleccion() + "</td>"
                                + "<td name=\"cldn\" id=\"cldn" + i + "\" hidden>" + p.getRenglon() + "</td>"
                                //                                + "<td name=\"cld5\" id=\"cld5" + i + "\">" + v2.substring(0, v2.length()-1) + "</td>");
                                + "<td name=\"cld5\" id=\"cld5" + i + "\">" + p.getFactor_cantidad_muestra() + "</td>");

                        if (p.getRenglon().equals("01")) {
                            out.println("<td class=\"tdRGN\"><input type=\"text\" class=\"bxcRGN\" maxlength=\"11\"  name=\"cld6\" id=\"bxcld6" + i + "\" value=\"" + p.getTamano_muestra_inspeccion_caracteristicas() + "\" readonly></td>"
                                    + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + i + "\" onkeyup=\"FlechasDir('cld7','" + i + "', event)\">"
                                    + "<input type=\"text\" id=\"bxcld70" + i + "\" hidden></td>"
                                    + "<td name=\"cld11\"  id=\"cld6" + i + "\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + i + "\" onfocus=\"CodBtnShow('" + i + "')\" disabled></td>"
                                    + "<td></td>"
                                    + "<td></td>"
                                    + "<td name=\"cld8\"></td>"
                                    + "<td hidden><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + i + "\" onkeyup=\"FlechasDir('cld12','" + i + "', event)\" onfocus=\"CodBtnShowNota('" + i + "')\"></td>"
                                    + "<td><button name=\"cld14\" id=\"btCodNota" + i + "\" class='BtnMatchIconDescriv' width=\"100%\" onclick=\"MatchTextoV2('" + i + "')\"></button>"
                                    + "<textarea style=\"resize:none;\" id=\"TextlibNota" + i + "\" hidden></textarea></td>"
                                    + "<td name=\"cld13\"  id=\"cld13n" + i + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            i++;
                        }
                        if (p.getRenglon().equals("02")) {

                            out.println("<td class=\"tdRGN\"><input type=\"text\" class=\"bxcRGN\" maxlength=\"11\"  name=\"cld6\" id=\"bxcld6" + i + "\" value=\"" + p.getTamano_muestra_inspeccion_caracteristicas() + "\" readonly></td>"
                                    + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + i + "\" value=\"0\" hidden>"
                                    + "<input type=\"text\" id=\"bxcld70" + i + "\" hidden></td>"
                                    + "<td name=\"cld11\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + i + "\" onfocus=\"CodBtnShow('" + i + "')\" onkeyup=\"FlechasDir('cld9','" + i + "', event)\">"
                                    + "<input type=\"text\" name=\"cldn9\" class=\"bxcRG\" id=\"bxCodn" + i + "\" value=\"" + p.getGrupo_codigo_conjunto_seleccion() + "\" hidden></td>"
                                    + "<td><button name=\"cld10\" id=\"btnCod" + i + "\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"matchInspCod('" + i + "', '" + p.getGrupo_codigo_conjunto_seleccion() + "', '" + p.getCl_catalogo_grupo_codigo() + "')\"></button></td>"
                                    + "<td id=\"bxTxtCod" + i + "\"></td>"
                                    + "<td name=\"cld8\"></td>"
                                    + "<td hidden><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + i + "\" onkeyup=\"FlechasDir('cld12','" + i + "', event)\" onfocus=\"CodBtnShowNota('" + i + "')\"></td>"
                                    + "<td><button name=\"cld14\" id=\"btCodNota" + i + "\" class='BtnMatchIconDescriv' width=\"100%\" onclick=\"MatchTextoV2('" + i + "')\"></button>"
                                    + "<textarea style=\"resize:none;\" id=\"TextlibNota" + i + "\" hidden></textarea></td>"
                                    + "<td name=\"cld13\" id=\"cld13n" + i + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            i++;
                        }
                        if (p.getRenglon().equals("03")) {

                            out.println("<td class=\"tdRGN\"><input type=\"text\" class=\"bxcRGN\" maxlength=\"11\" name=\"cld6\" id=\"bxcld6" + i + "\" onkeyup=\"FlechasDir('cld6','" + i + "', event)\"></td>"
                                    + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + i + "\" onkeyup=\"FlechasDir('cld7','" + i + "', event)\">"
                                    + "<input type=\"text\" id=\"bxcld70" + i + "\" hidden></td></td>"
                                    + "<td name=\"cld11\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + i + "\" onfocus=\"CodBtnShow('" + i + "')\" disabled></td>"
                                    + "<td></td>"
                                    + "<td></td>"
                                    + "<td name=\"cld8\"></td>"
                                    + "<td hidden><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + i + "\" onkeyup=\"FlechasDir('cld12','" + i + "', event)\" onfocus=\"CodBtnShowNota('" + i + "')\"></td>"
                                    + "<td><button name=\"cld14\" id=\"btCodNota" + i + "\" class='BtnMatchIconDescriv' width=\"100%\" onclick=\"MatchTextoV2('" + i + "')\"></button>"
                                    + "<textarea style=\"resize:none;\" id=\"TextlibNota" + i + "\" hidden></textarea></td>"
                                    + "<td name=\"cld13\" id=\"cld13n" + i + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            i++;
                        }
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>00000000</td>"
                            + "<td>000000000000000000000000000000000000000</td>"
                            + "<td>0000000000000000000000000000</td>"
                            + "<td hidden>000000000000</td>"
                            + "<td hidden>000000000000</td>"
                            + "<td hidden>000000000000</td>"
                            + "<td hidden>000000000000</td>"
                            + "<td hidden>000000000000</td>"
                            + "<td hidden>000000000</td>"
                            + "<td hidden>000000000</td>"
                            + "<td>00000000</td>"
                            + "<td>000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>0000</td>"
                            + "<td>00000000</td>"
                            + "<td>000</td>"
                            + "<td>0000000000000000000000000</td>"
                            + "<td>000000000</td>"
                            + "<td hidden>0000000000000000000000000000000000000000000000</td>"
                            + "<td>0000</td>"
                            + "<td>00000</td>"
                            + "</tr>"
                            + "</tbody>\n"
                            + "</table>");

                    break;
                case "Notificaciones2":
                    int in = 0;
                    ArrayList<PlanInspeccionC> pin = ACC_CaracteristicasPlanInspeccion.ObtenerInstancia().QMCaracteristicasPMConjunto(v1, v2);
                    out.println("<table id=\"TabBody2\">\n"
                            + "<tbody>");
                    for (PlanInspeccionC p : pin) {
                        String txt = ACC_CaracteristicasPlanInspeccion.ObtenerInstancia().GetDesIC(v2, p.getNum_caracteristica_inspeccion(), p.getCodigo());
                        String img = "";
                        if (p.getValoracion_resultado_inspeccion().equals("R")) {
                            img = "<img src=\"images/@02@.gif\" style=\"margin-left:33%; \"/>";
                        }
                        if (p.getValoracion_resultado_inspeccion().equals("A")) {
                            img = "<img src=\"images/@01@.gif\" style=\"margin-left:30%; \"/>";
                        }
                        out.println("<tr>"
                                + "<td name=\"cld1\" id=\"ccld1" + in + "\">" + p.getNum_caracteristica_inspeccion() + "</td>"
                                + "<td name=\"cld2\" id=\"cld2" + in + "\">" + p.getTexto_breve_caracteristicas_inspeccion() + "</td>"
                                + "<td name=\"cld3\" id=\"cld3" + in + "\">" + p.getDescripcion_breve_conjunto_seleccion() + "</td>"
                                + "<td name=\"cldrg1\" id=\"cldrg1" + in + "\" hidden>" + p.getLimite_inferior() + "</td>"
                                + "<td name=\"cldrg2\" id=\"cldrg2" + in + "\" hidden>" + p.getLimite_superior() + "</td>"
                                + "<td name=\"cldrg3\" id=\"cldrg3" + in + "\" hidden>" + p.getIndicador_limite_inferior() + "</td>"
                                + "<td name=\"cldrg4\" id=\"cldrg4" + in + "\" hidden>" + p.getIndicador_limite_superior() + "</td>"
                                + "<td name=\"cldrg5\" id=\"cldrg5" + in + "\" hidden></td>"
                                + "<td name=\"cld4\" id=\"cld4" + in + "\" hidden>" + p.getEntrada_catalogo_conjunto_seleccion() + "</td>"
                                + "<td name=\"cldn\" id=\"cldn" + in + "\" hidden>" + p.getRenglon() + "</td>"
                                //                                + "<td name=\"cld5\" id=\"cld5" + i + "\">" + v2.substring(0, v2.length()-1) + "</td>");
                                + "<td name=\"cld5\" id=\"cld5" + in + "\">" + p.getFactor_cantidad_muestra() + "</td>");

                        if (p.getRenglon().equals("01")) {
                            out.println("<td class=\"tdRGN\"><input type=\"text\" class=\"bxcRGN\" maxlength=\"11\"  name=\"cld6\" id=\"bxcld6" + in + "\" value=\"" + p.getTamano_muestra_inspeccion_caracteristicas() + "\" readonly></td>"
                                    + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + in + "\" value=\"" + p.getValor_original_anterior_tratamiento_entradas() + "\" readonly>"
                                    + "<input type=\"text\" id=\"bxcld70" + in + "\" hidden></td>"
                                    + "<td name=\"cld11\"  id=\"cld6" + in + "\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + in + "\" onfocus=\"CodBtnShow('" + in + "')\" disabled value=\"" + p.getCodigo() + "\"></td>"
                                    + "<td></td>"
                                    + "<td></td>"
                                    + "<td name=\"cld8\">" + img + "</td>"
                                    + "<td><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + in + "\" value=\"" + p.getTexto_breve() + "\" hidden></td>"
                                    + "<td name=\"cld13\"  id=\"cld13" + in + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            in++;
                        }
                        if (p.getRenglon().equals("02")) {

                            out.println("<td class=\"tdRGN\"><input type=\"text\" class=\"bxcRGN\" maxlength=\"11\"  name=\"cld6\" id=\"bxcld6" + in + "\" value=\"" + p.getTamano_muestra_inspeccion_caracteristicas() + "\" readonly></td>"
                                    + "<td>" + p.getValor_original_anterior_tratamiento_entradas() + "<input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + in + "\" value=\"0\" hidden>"
                                    + "<input type=\"text\" id=\"bxcld70" + in + "\" hidden></td>"
                                    + "<td name=\"cld11\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + in + "\" onfocus=\"CodBtnShow('" + in + "')\" value=\"" + p.getCodigo() + "\">"
                                    + "<input type=\"text\" name=\"cldn9\" class=\"bxcRG\" id=\"bxCodn" + in + "\" value=\"" + p.getGrupo_codigo_conjunto_seleccion() + "\" hidden></td>"
                                    + "<td><button name=\"cld10\" id=\"btnCod" + in + "\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"matchInspCod('" + in + "', '" + p.getGrupo_codigo_conjunto_seleccion() + "', '" + p.getCl_catalogo_grupo_codigo() + "')\"></button></td>"
                                    + "<td>" + txt + "</td>"
                                    + "<td name=\"cld8\">" + img + "</td>"
                                    + "<td><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + in + "\" value=\"" + p.getTexto_breve() + "\" hidden></td>"
                                    + "<td name=\"cld13\" id=\"cld13" + in + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            in++;
                        }
                        if (p.getRenglon().equals("03")) {

                            out.println("<td class=\"tdRGN\"><input type=\"text\" class=\"bxcRGN\" maxlength=\"11\" name=\"cld6\" id=\"bxcld6" + in + "\" value=\"" + p.getTamano_muestra_inspeccion_caracteristicas() + "\" readonly></td>"
                                    + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + in + "\" value=\"" + p.getValor_original_anterior_tratamiento_entradas() + "\" readonly>"
                                    + "<input type=\"text\" id=\"bxcld70" + in + "\" hidden></td></td>"
                                    + "<td name=\"cld11\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + in + "\" onfocus=\"CodBtnShow('" + in + "')\" disabled value=\"" + p.getCodigo() + "\"></td>"
                                    + "<td></td>"
                                    + "<td></td>"
                                    + "<td name=\"cld8\">" + img + "</td>"
                                    + "<td><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + in + "\" value=\"" + p.getTexto_breve() + "\" hidden></td>"
                                    + "<td name=\"cld13\" id=\"cld13" + in + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            in++;
                        }
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>00000000</td>"
                            + "<td>000000000000000000000000000000000000000</td>"
                            + "<td>000000000000000000000000000000000</td>"
                            + "<td hidden>000000000000000000000000000000000</td>"
                            + "<td hidden>000000000000000000000000000000000</td>"
                            + "<td hidden>000000000000000000000000000000000</td>"
                            + "<td hidden>000000000000000000000000000000000</td>"
                            + "<td hidden>000000000000000000000000000000000</td>"
                            + "<td hidden>000000000</td>"
                            + "<td hidden>000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>0000</td>"
                            + "<td>00000000</td>"
                            + "<td>000</td>"
                            + "<td>0000000000000000000000000</td>"
                            + "<td>000000000</td>"
                            + "<td hidden>0000000000000000000000000000000000000000000000</td>"
                            + "<td>0000</td>"
                            + "</tr>"
                            + "</tbody>\n"
                            + "</table>");
                    break;
                case "Cld101":
                    int ii = 0;
                    ArrayList<PlanInspeccionC> pii = ACC_CaracteristicasPlanInspeccion.ObtenerInstancia().PlanInspecC(v1);
                    out.println("<table id=\"TabBody2\">\n"
                            + "<tbody>");
                    for (PlanInspeccionC p : pii) {
                        out.println("<tr>"
                                + "<td name=\"cld1\" id=\"cld1" + ii + "\">" + p.getNum_caracteristica_inspeccion() + "</td>"
                                + "<td name=\"cld2\" id=\"cld2" + ii + "\">" + p.getTexto_breve_caracteristicas_inspeccion() + "</td>"
                                + "<td name=\"cld3\" id=\"cld3" + ii + "\">" + p.getDescripcion_breve_conjunto_seleccion() + "</td>"
                                + "<td name=\"cld4\" id=\"cld4" + ii + "\" hidden>" + p.getEntrada_catalogo_conjunto_seleccion() + "</td>"
                                + "<td name=\"cldn\" id=\"cldn" + ii + "\" hidden>" + p.getRenglon() + "</td>"
                                //                                + "<td name=\"cld5\" id=\"cld5" + i + "\">" + v2.substring(0, v2.length()-1) + "</td>");
                                + "<td name=\"cld5\" id=\"cld5" + ii + "\">" + p.getFactor_cantidad_muestra() + "</td>");

                        if (p.getRenglon().equals("1")) {
                            out.println("<td><input type=\"text\" class=\"bxcRG\" maxlength=\"11\"  name=\"cld6\" id=\"bxcld6" + ii + "\" value=\"" + p.getTamano_muestra_inspeccion_caracteristicas() + "\" readonly></td>"
                                    + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + ii + "\"></td>"
                                    + "<td name=\"cld11\"  id=\"cld6" + ii + "\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + ii + "\" onfocus=\"CodBtnShow('" + ii + "')\" disabled></td>"
                                    + "<td></td>"
                                    + "<td name=\"cld8\"></td>"
                                    + "<td><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + ii + "\"></td>"
                                    + "<td name=\"cld13\"  id=\"cld13" + ii + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            ii++;
                        }
                        if (p.getRenglon().equals("2")) {

                            out.println("<td><input type=\"text\" class=\"bxcRG\" maxlength=\"11\"  name=\"cld6\" id=\"bxcld6" + ii + "\" value=\"" + p.getTamano_muestra_inspeccion_caracteristicas() + "\" readonly></td>"
                                    + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + ii + "\" value=\"0\" hidden></td>"
                                    + "<td name=\"cld11\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + ii + "\" onfocus=\"CodBtnShow('" + ii + "')\">"
                                    + "<input type=\"text\" name=\"cldn9\" class=\"bxcRG\" id=\"bxCodn" + ii + "\" value=\"" + p.getGrupo_codigo_conjunto_seleccion() + "\" hidden></td>"
                                    + "<td><button name=\"cld10\" id=\"btnCod" + ii + "\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"matchInspCod('" + ii + "', '" + p.getGrupo_codigo_conjunto_seleccion() + "', '" + p.getCl_catalogo_grupo_codigo() + "')\"></button></td>"
                                    + "<td name=\"cld8\"></td>"
                                    + "<td><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + ii + "\"></td>"
                                    + "<td name=\"cld13\" id=\"cld13" + ii + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            ii++;
                        }
                        if (p.getRenglon().equals("3")) {

                            out.println("<td><input type=\"text\" class=\"bxcRG\" maxlength=\"11\" name=\"cld6\" id=\"bxcld6" + ii + "\"></td>"
                                    + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"cld7\" id=\"bxcld7" + ii + "\"></td>"
                                    + "<td name=\"cld11\">" + p.getUnidad_medida_graban_cuantitativos() + "</td>"
                                    + "<td><input type=\"text\" name=\"cld9\" style=\"text-transform: uppercase;\" maxlength=\"10\" class=\"bxcRG\" id=\"bxCod" + ii + "\" onfocus=\"CodBtnShow('" + ii + "')\" disabled></td>"
                                    + "<td></td>"
                                    + "<td name=\"cld8\"></td>"
                                    + "<td><input type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"cld12\" id=\"cld12" + ii + "\"></td>"
                                    + "<td name=\"cld13\" id=\"cld13" + ii + "\" class=\"ocultar\">" + p.getCl_catalogo_grupo_codigo() + "</td>"
                                    + "</tr>");
                            ii++;
                        }
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>00000000</td>"
                            + "<td>00000000000000000000000000000</td>"
                            + "<td>0000000000000000000000000</td>"
                            + "<td hidden>000000000</td>"
                            + "<td hidden>000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>0000</td>"
                            + "<td>00000000</td>"
                            + "<td>000</td>"
                            + "<td>000000000</td>"
                            + "<td>0000000000000000000000000000000000000000000000</td>"
                            + "<td>00000</td>"
                            + "</tr>"
                            + "</tbody>\n"
                            + "</table>");

                    break;
                case "consultarGpoCod":
                    String gpoCod = ACC_InspeccionCodigos.ObtenerInstancia().ConsultarGpoCod(conjSel);
                    out.println(gpoCod);
                    break;
                case "consultaCodigos":
                    ArrayList<inspeccion_codigos> lstCods = ACC_InspeccionCodigos.ObtenerInstancia().ConsultaCodigos(idioma, conjSel);
                    if (lstCods.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (i = 0; i < lstCods.size(); i++) {
                            out.println("<tr ondblclick=\"selectMatchCod('codInsp','" + pos + "','" + lstCods.get(i).getCodigo() + "','" + lstCods.get(i).getValoracion_codigo() + "', '" + lstCods.get(i).getDescripcion() + "');\">");
                            out.println("<td>" + lstCods.get(i).getCodigo() + "</td>");
                            out.println("<td>" + lstCods.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0 + ",VentanaModalInspCod,bxCod" + pos + ",");
                    }
                    break;
                case "validarCodigo":
                    String check = ACC_InspeccionCodigos.ObtenerInstancia().ValidarCodigoInsp(cod, v3);
                    out.println(check);
                    break;
                case "insertarCabCalidad":
                    cabecera_lotes_inspeccion_movimientos_crea cli = new cabecera_lotes_inspeccion_movimientos_crea();
                    String fl = "MO" + fo.getFolioActual();
                    cli.setFolio_sam("QM" + folio);
                    cli.setFecha(fechaActual);
                    cli.setHora_dia(horaActual);
                    cli.setMaterial(material);
                    cli.setTexto_breve_material(txtB);
                    cli.setNum_doc_compras(nuDoc);
                    cli.setFolio_sam_mov(fl);
                    cli.setCentro(cent);
                    cli.setCreador_registro_datos(user);
                    cli.setUsuario(user);
                    if (ACC_InspeccionCodigos.ObtenerInstancia().InsertCabeceraLotInsp(cli)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }

                    break;
                case "getCurrentQM":
                    folios fol = ACC_Folios.ObtenerIstancia().CargarAllDatos("QM");
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("QM", fol.getFolioActual());
                    out.println(fol.getFolioActual());
                    break;
                case "ActualizarFolioQM":
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("QM", Integer.parseInt(folio));
                    out.println(fo.getFolioActual());
                    break;
                case "validaUsuarioVis":
                    out.println(ACC_Usuarios.ObtenerInstancia().UsuarioVis(v1));
                    break;
                case "insertarPosMatCalidad":
                    posiciones_lotes_inspeccion_movimientos_crea ps = new posiciones_lotes_inspeccion_movimientos_crea();
                    ps.setFolio_sam("QM" + folio);
                    ps.setNum_caracteristica_inspeccion(numC);
                    ps.setFecha(fechaActual);
                    ps.setHora_dia(horaActual);
                    ps.setTexto_breve_caracteristica_inspeccion(txtBCarInsp);
                    ps.setDescripcion_breve_conjunto_seleccion(desBConj);
                    ps.setEntrada_catalogo_conjunto_seleccion(entCat);
                    ps.setTamano_muestra_inspeccionar_carac(tamMues);
                    ps.setNum_unidades_muestreo_defectuoso(numUn);
                    ps.setValor_original_anterior_tratamiento_entradas(valOrg);
                    ps.setCodigo(cod);
                    ps.setUnidad_medida_graban_cuantitativos(undMe);
                    ps.setTexto_breve(txtB);
                    ps.setCatalogo(catal);
                    ps.setCreador_registro_datos(user);
                    if (ACC_InspeccionCodigos.ObtenerInstancia().InsertPosLotInspCalidad(ps)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "Defectos":
                    out.println("<table id=\"TabBody3\">\n"
                            + "<tbody>");
                    out.println("<tr>"
                            + "<td><input type=\"checkbox\" name=\"defectos\" value=\"0\" onfocus=\"hideBtnsCld()\"></td>"
                            + "<td><input id=\"Cod10\" type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df1\" onkeypress=\"valMt9(event, '0', this.value)\" onfocus=\"CodBtGr1Show('0')\"></td>"
                            + "<td><button name=\"df2\" id=\"btCod10\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"MatchCod9('0')\"></button></td>"
                            + "<td><input id=\"Cod20\" type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df3\" readonly></td>"
                            + "<td><input id=\"Cod30\" type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"df4\" readonly></td>"
                            + "<td><input type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df5\" onfocus=\"hideBtnsCld()\" onkeypress=\"return numCld(event)\"></td>"
                            + "<td><select class=\"bxcRG\" name=\"df6\" onfocus=\"hideBtnsCld()\">\n"
                            + "  <option value=\"01\">Defecto crítico</option>\n"
                            + "  <option value=\"02\">Defecto grave</option>\n"
                            + "  <option value=\"03\">Defecto leve</option>\n"
                            + "</select>"
                            + "</td>"
                            + "<td><input id=\"Cod40\" type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df7\" onfocus=\"CodBtGr2Show('0')\"></td>"
                            + "<td><button name=\"df8\" id=\"btCod20\" class='BtnMatchIcon' style=\"display : none;\" width=\"100%\" onclick=\"MatchCodE('0')\"></button></td>"
                            + "<td><input id=\"Cod50\" type=\"text\" class=\"bxcRG\" maxlength=\"40\" name=\"df9\" readonly></td>"
                            + "<td><input id=\"Cod60\" type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"df10\" readonly></td>"
                            + "<td><input id=\"Cod70\" type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"df11\" onfocus=\"CodBtGr3Show('0')\">"
                            //                            + "<td><input id=\"Cod70\" type=\"text\" class=\"bxcLRG\" maxlength=\"40\" name=\"df11\" >"
                            + "<textarea style=\"resize:none;\" name=\"df13\" id=\"Textlib0\" hidden></textarea></td>"
                            + "<td><button name=\"df12\" id=\"btCod30\" class='BtnMatchIconDescri' style=\"display : none;\" width=\"100%\" onclick=\"MatchTexto('0')\"></button></td>"
                            + "</tr>");
                    out.println("<tr class=\"ocultar\">"
                            + "<td></td>"
                            + "<td>00000000000</td>"
                            + "<td>000</td>"
                            + "<td>00000</td>"
                            + "<td>000000000000000000000000000000000000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>000</td>"
                            + "<td>00000</td>"
                            + "<td>000000000000000000000000000000</td>"
                            + "<td>0000000000000000000000000000000000000000000000</td>"
                            + "<td>000</td>"
                            + "</tr>"
                            + "</tbody>\n"
                            + "</table>");
                    break;
                case "validaGrCod9":
                    int n,
                     e;
                    if (v1.equals("")) {
                        n = 1;
                    } else {
                        n = ACC_CodigosDefecto.ObtenerInstancia().validaGrupoCod(v1);
                    }
                    if (v2.equals("")) {
                        e = 1;
                    } else {
                        e = ACC_CodigosDefecto.ObtenerInstancia().validaGrupoCod(v2);
                    }
                    out.println(n + "|" + e);
                    break;
                case "CreaDocInventario":
                    ArrayList<materiales_almacen> ml = ACC_Material.ObtenerInstancia().listadoMaterialesHabilitado(v1, v2);
                    out.println("<table id=\"TabBody\">\n"
                            + "<tbody>");
                    for (int d = 0; d < ml.size(); d++) {
                        int x = d + 1;
                        out.println("<tr>");
                        out.println("<td><input type=\"checkbox\" name=\"ckCreaDoc\" value=\"" + ml.get(d).getMaterial() + "\"></td>"
                                + "<td id=\"bxpos" + d + "\">" + x + "</td>"
                                + "<td id=\"bxmat" + d + "\">" + ml.get(d).getMaterial() + "</td>"
                                + "<td id=\"bxTmt" + d + "\">" + ml.get(d).getTexto_material() + "</td>"
                                + "<td id=\"bxCtr" + d + "\">" + ml.get(d).getCentro() + "</td>"
                                + "<td id=\"bxAlm" + d + "\">" + ml.get(d).getAlmacen() + "</td>"
                                + "</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>000</td>"
                            + "<td>00000</td>"
                            + "<td>000000000000000</td>"
                            + "<td>0000000000000000000000000000000000000000000000000000</td>"
                            + "<td>000000</td>"
                            + "<td>000000</td>"
                            + "</tr>"
                            + "</tbody>\n"
                            + "</table>");
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
