package Servlets;

import AccesoDatos.ACC_Cabecera_ordenes_crea;
import AccesoDatos.ACC_MaterialesOrdenesCrea;
import AccesoDatos.ACC_OperacionesOrdenesCrea;
import AccesoDatos.ACC_ServiciosOrdenesCrea;
import AccesoDatos.ACC_TextoPosicionOrdenesCrea;
import AccesoDatos.Consultas;
import Entidades.cabecera_ordenes_crea;
import Entidades.materiales_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import Entidades.servicios_ordenes_crea;
import Entidades.texto_posicion_ordenes_crea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

@WebServlet(name = "peticionModuloModificarOrden2", urlPatterns = {"/peticionModuloModificarOrden2"})
public class peticionModuloModificarOrden2 extends HttpServlet {

    public String checkEmptyOpe(String data) {
        String answer;
        if (data == null) {
            answer = "";
        } else {
            answer = data;
        }
        return answer;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Accion = request.getParameter("acc");
            String orden = request.getParameter("orden");
            Consultas consul = new Consultas();
            String check;
            switch (Accion) {
                case "modCargarCab":
                    cabecera_ordenes_crea coc;
                    coc = ACC_Cabecera_ordenes_crea.ObtenerInstancia().CargarDataCab(orden);
                    JSONArray js = new JSONArray();
                    js.add(coc.getClase_orden());
                    js.add(coc.getTexto_breve());
                    js.add(coc.getNum_equipo());
//                    js.add(coc.getEstatus());
                    js.add(coc.getUbicacion_tecnica());
                    js.add(coc.getCentro_planificacion_mantenimiento());
                    js.add(coc.getPuesto_trabajo_responsable_medidas_mante());
                    js.add(consul.DateFormat(coc.getFecha_inicio_extrema()));
                    js.add(consul.DateFormat(coc.getFecha_fin_extrema()));
                    out.println(js);
                    break;
                case "modCargarOperaciones":
                    ArrayList<operaciones_ordenes_crea> modOpeLst = ACC_OperacionesOrdenesCrea.ObtenerInstancia().ConsultaOperacionesByOrd(orden);
                    int size = modOpeLst.size() + 50;
                    int c;
                    if (modOpeLst.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (c = 0; c < size; c++) {
                            if (c < modOpeLst.size()) {
                                out.println("<tr>\n"
                                        + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"TOpos\" value=" + c + "></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOope\" id=\"TOope" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 55px;\" value=\"" + modOpeLst.get(c).getNum_operacion() + "\" readonly></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOptoTr\" id=\"TOptoTr" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOptoTr')\" value=\"" + modOpeLst.get(c).getNum_solped() + "\" style=\"width: 105px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">     <button id=\"match_TOptoTr" + c + "\" name=\"match_TOptoTr\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTOPtoTr('" + c + "')\"></button> </td>\n"
                                        + "                <td><input type=\"text\" name=\"TOcent\" id=\"TOcent" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOcent')\" value=\"" + modOpeLst.get(c).getCentro() + "\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">       <button id=\"match_TOcent" + c + "\" name=\"match_TOcent\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOCent('" + c + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOclvOpe\" id=\"TOclvOpe" + c + "\" onfocus=\"BtnHideTO()\"style=\"width: 75px;\" disabled readonly></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOsta\" id=\"TOsta" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOsta')\" value=\"" + modOpeLst.get(c).getClave_control() + "\" style=\"width: 120px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">         <button id=\"match_TOsta" + c + "\" name=\"match_TOsta\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOSta('" + c + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOdesOpe\" id=\"TOdesOpe" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOdesOpe')\" value=\"" + modOpeLst.get(c).getTexto_breve_operacion() + "\" style=\"width: 415px;\" maxlength=\"40\">                                                            <button id=\"match_TOdesOpe" + c + "\" name=\"match_TOdesOpe\" class='BtnMatchIconDescri'  style=\"display : none;\" onclick=\"mostrarVentanaModalib()\"></button>     </td>\n"
                                        + "                <td><input type=\"text\" name=\"TOcant\" id=\"TOcant" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 95px;\" value=\"" + modOpeLst.get(c).getCantidad_base() + "\" maxlength=\"13\"></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOdura\" id=\"TOdura" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 65px;\" value = \"" + modOpeLst.get(c).getDuracion_operacion() + "\" maxlength=\"5\" ></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOumd\" id=\"TOumd" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOumd')\" value=\"" + modOpeLst.get(c).getUnidad_duracion_normal() + "\" maxlength=\"3\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\"  >     <button id=\"match_TOumd" + c + "\" name=\"match_TOumd\" class='BtnMatchIcon'  style=\"display :none  ;\" onclick=\"matchTOUMD('" + c + "')\"></button></td>\n"
                                        + "                <td style=\"visibility: hidden;\"><input type=\"text\" name=\"TOcont\" id=\"TOcont" + c + "\">     </td>\n"
                                        + "           </tr>");

                            } else {
                                out.println("<tr>\n"
                                        + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"TOpos\" value=" + c + "></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOope\" id=\"TOope" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 55px;\" readonly></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOptoTr\" id=\"TOptoTr" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOptoTr')\" style=\"width: 105px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">     <button id=\"match_TOptoTr" + c + "\" name=\"match_TOptoTr\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTOPtoTr('" + c + "')\"></button> </td>\n"
                                        + "                <td><input type=\"text\" name=\"TOcent\" id=\"TOcent" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOcent')\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">       <button id=\"match_TOcent" + c + "\" name=\"match_TOcent\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOCent('" + c + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOclvOpe\" id=\"TOclvOpe" + c + "\" onfocus=\"BtnHideTO()\"style=\"width: 75px;\" disabled></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOsta\" id=\"TOsta" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOsta')\" value=\"\" style=\"width: 120px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">         <button id=\"match_TOsta" + c + "\" name=\"match_TOsta\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOSta('" + c + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOdesOpe\" id=\"TOdesOpe" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOdesOpe')\" style=\"width: 415px;\" maxlength=\"40\">                                                    <button id=\"match_TOdesOpe" + c + "\" name=\"match_TOdesOpe\" class='BtnMatchIconDescri'  style=\"display : none;\" onclick=\"mostrarVentanaModalib()\"></button> </td>\n"
                                        + "                <td><input type=\"text\" name=\"TOcant\" id=\"TOcant" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 95px;\" maxlength=\"13\"></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOdura\" id=\"TOdura" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 65px;\" maxlength=\"5\" ></td>\n"
                                        + "                <td><input type=\"text\" name=\"TOumd\" id=\"TOumd" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOumd')\" maxlength=\"3\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\"  >     <button id=\"match_TOumd" + c + "\" name=\"match_TOumd\" class='BtnMatchIcon'  style=\"display :none  ;\" onclick=\"matchTOUMD('" + c + "')\"></button></td>\n"
                                        + "                <td style=\"visibility: hidden;\"><input type=\"text\" name=\"TOcont\" id=\"TOcont" + c + "\">     </td>\n"
                                        + "           </tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "modCargarMateriales":
                    ArrayList<materiales_ordenes_crea> modLstM = ACC_MaterialesOrdenesCrea.ObtenerInstancia().ConsultaMaterialesSAM(orden);
                    int sizex = modLstM.size() + 30;
                    int d = 0;
                    if (modLstM.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (d = 0; d < sizex; d++) {
                            if (d < modLstM.size()) {

                                out.println("<tr>\n"
                                        + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"TCpos\" value=" + d + "></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCmat\" id=\"TCmat" + d + "\" value=\"" + modLstM.get(d).getNum_material() + "\" onfocus=\"BtnShowTC('" + d + "','match_TCmat')\" style=\"width: 225px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"18\">     <button id=\"match_TCmat" + d + "\" name=\"match_TCmat\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCmat('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TClot\" id=\"TClot" + d + "\" value=\"" + modLstM.get(d).getLote() + "\" onfocus=\"BtnShowTC('" + d + "','match_TClot')\" style=\"width: 45px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">     <button id=\"match_TClot" + d + "\"  class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTClot('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCtxtB\" id=\"TCtxtB" + d + "\" value=\"" + modLstM.get(d).getTexto_breve_material() + "\" onfocus=\"BtnHideTC()\" style=\"width: 325px;\" maxlength=\"40\"></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCcant\" id=\"TCcant" + d + "\" value=\"" + modLstM.get(d).getCantidad_emplear() + "\" onfocus=\"BtnHideTC()\" style=\"width: 95px;\" onblur=\"this.value = checkDecCant1(this.value, 3, 'serCtdOp2')\"   onKeyUp=\"this.value = check99(this.value, '9999999', 7)\" maxlength=\"11\"></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCumc\" id=\"TCumc" + d + "\" value=\"" + modLstM.get(d).getUnidad_medida_base() + "\" onfocus=\"BtnShowTC('" + d + "','match_TCumc')\" style=\"width: 55px;\" onblur=\"checkDecCant2('TCcant" + d + "', 'TCumc" + d + "');\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"3\">      <button id=\"match_TCumc" + d + "\" name=\"match_TCumc\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCUMC('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCcent\" id=\"TCcent" + d + "\" value=\"" + modLstM.get(d).getCentro() + "\" onfocus=\"BtnShowTC('" + d + "','match_TCcent')\" style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">   <button id=\"match_TCcent" + d + "\" name=\"match_TCcent\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCcent('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCalm\" id=\"TCalm" + d + "\" value=\"" + modLstM.get(d).getAlmacen() + "\" onfocus=\"BtnShowTC('" + d + "','match_TCalm')\" style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">      <button id=\"match_TCalm" + d + "\" name=\"match_TCalm\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCalm('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCope\" id=\"TCope" + d + "\" value=\"" + modLstM.get(d).getNum_operacion() + "\" onfocus=\"BtnHideTC()\" style=\"width: 55px;\" maxlength=\"4\"></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCsolp\" id=\"TCsolp" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 75px;\" disabled></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCitsol\" id=\"TCitsol" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 65px;\" disabled></td>\n"
                                        + "           </tr>");
                            } else {
                                out.println("<tr>\n"
                                        + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"TCpos\" value=" + d + "></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCmat\" id=\"TCmat" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCmat')\" style=\"width: 225px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"18\">     <button id=\"match_TCmat" + d + "\" name=\"match_TCmat\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCmat('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TClot\" id=\"TClot" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TClot')\" style=\"width: 45px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">     <button id=\"match_TClot" + d + "\"  class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTClot('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCtxtB\" id=\"TCtxtB" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 325px;\" maxlength=\"40\"></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCcant\" id=\"TCcant" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 95px;\" onblur=\"this.value = checkDecCant1(this.value, 3, 'serCtdOp2')\"   onKeyUp=\"this.value = check99(this.value, '9999999', 7)\" maxlength=\"11\"></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCumc\" id=\"TCumc" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCumc')\" style=\"width: 55px;\" onblur=\"checkDecCant2('TCcant" + d + "', 'TCumc" + d + "');\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"3\">      <button id=\"match_TCumc" + d + "\" name=\"match_TCumc\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCUMC('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCcent\" id=\"TCcent" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCcent')\" style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">   <button id=\"match_TCcent" + d + "\" name=\"match_TCcent\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCcent('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCalm\" id=\"TCalm" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCalm')\" style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">      <button id=\"match_TCalm" + d + "\" name=\"match_TCalm\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCalm('" + d + "')\"></button></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCope\" id=\"TCope" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 55px;\" maxlength=\"4\"></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCsolp\" id=\"TCsolp" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 75px;\" disabled></td>\n"
                                        + "                <td><input type=\"text\" name=\"TCitsol\" id=\"TCitsol" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 65px;\" disabled></td>\n"
                                        + "           </tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "truncateOrden":
                    check = ACC_Cabecera_ordenes_crea.ObtenerInstancia().truncateOrden(orden);
                    out.println(check);
                    break;
                case "modCargarServicios":
                    ArrayList<servicios_ordenes_crea> modSer = ACC_ServiciosOrdenesCrea.ObtenerInstancia().ConsultaServiciosByOrd(orden);
                    size = modSer.size() + 30;
                    int x = 0;
                    if (modSer.size() > 0) {
                        out.println("<table >");
                        out.println("<tbody id=\"cargarServiM\">");
                        for (x = 0; x < size; x++) {
                            if (x < modSer.size()) {

                                out.println("<tr>\n"
                                        + "<td><input type=\"checkbox\" name=\"TSpos\" value=" + x + " style=\"width=50px;\"></td>\n"
                                        + "<td><input type=\"text\" value=\"" + modSer.get(x).getNum_operacion() + "\" name=\"TSnoOpe\" id=\"TSnoOpe" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" value=\"" + modSer.get(x).getNum_servicio() + "\" name=\"TSnoS\" id=\"TSnoS" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" value=\"" + modSer.get(x).getCantidad_con_signo() + "\" name=\"TScant\" id=\"TScant" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" value=\"" + modSer.get(x).getValor_neto_posicion() + "\" name=\"TSpreEs1\" id=\"TSpreEs1" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSpreEs2\" id=\"TSpreEs2" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" value=\"" + modSer.get(x).getGrupo_articulos() + "\" name=\"TSgpoA2\" id=\"TSgpoA2" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" value=\"" + modSer.get(x).getClase_coste() + "\" name=\"TSclsC\" id=\"TSclsC" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TStxtS\" id=\"TStxtS" + x + "\" value=\"" + modSer.get(x).getTexto_breve() + "\"  style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSumdS\" id=\"TSumdS" + x + "\" value=\"" + modSer.get(x).getUnidad_medida_base() + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TScont\" id=\"TScont" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "</tr>");
                            } else {
                                out.println("<tr>\n"
                                        + "<td><input type=\"checkbox\" name=\"TSpos\" value=" + x + " style=\"width=50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSnoOpe\" id=\"TSnoOpe" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSnoS\" id=\"TSnoS" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TScant\" id=\"TScant" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSpreEs1\" id=\"TSpreEs1" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSpreEs2\" id=\"TSpreEs2" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSgpoA2\" id=\"TSgpoA2" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSclsC\" id=\"TSclsC" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TStxtS\" id=\"TStxtS" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TSumdS\" id=\"TSumdS" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TScont\" id=\"TScont" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "modCargarTxtDes":
                    ArrayList<texto_posicion_ordenes_crea> modTxt = ACC_TextoPosicionOrdenesCrea.ObtenerInstancia().ConsultaTxtDes(orden);
                    size = modTxt.size() + 30;
                    x = 0;
                    String tx;
                    String opeAct = "";
                    String opeAnt = "";
                    if (modTxt.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody id=\"cargarTxtD\">");
                        for (x = 0; x < size; x++) {
                            if (x < modTxt.size()) {
                                opeAct = modTxt.get(x).getNum_operacion();
                                if (opeAct.equals(opeAnt)) {
                                    opeAnt = modTxt.get(x).getNum_operacion();
                                } else if (opeAct != opeAnt) {
                                    tx = ACC_TextoPosicionOrdenesCrea.ObtenerInstancia().TextoByNumOpe(modTxt, opeAct);
                                    modTxt.get(x).setTexto(tx);
                                    out.println("<tr>\n"
                                            + "<td><input type=\"checkbox\" name=\"TDpos\" value=" + x + " style=\"width=50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TDfolSam\" value=\"" + modTxt.get(x).getFolio_sam() + "\" id=\"TDfolSam" + x + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TDnumOpe\" value=\"" + modTxt.get(x).getNum_operacion() + "\" id=\"TDnumOpe" + x + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TDind\" value=\"" + modTxt.get(x).getIndice() + "\" id=\"TDind" + x + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><textarea name=\"TDtxtD\"  id=\"TDtxtD" + x + "\" style=\"width:50px;\">" + modTxt.get(x).getTexto() + "</textarea></td>\n"
                                            + "<td><input name=\"TDcont\" id=\"TDcont" + x + "\" style=\"width:50px;\"></td>\n"
                                            + "</tr>");
                                    opeAnt = modTxt.get(x).getNum_operacion();
                                }

                            } else {
                                out.println("<tr>\n"
                                        + "<td><input type=\"checkbox\" name=\"TDpos\" value=" + x + " style=\"width=50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TDfolSam\" id=\"TDfolSam" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TDnumOpe\" id=\"TDnumOpe" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TDind\" id=\"TDind" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><textarea name=\"TDtxtD\" id=\"TDtxtD" + x + "\" style=\"width:50px;\"></textarea></td>\n"
                                        + "<td><input name=\"TDcont\" id=\"TDcont" + x + "\" style=\"width:50px;\"></td>\n"
                                        + "</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "modCargarOperaciones2":
                    modOpeLst = ACC_OperacionesOrdenesCrea.ObtenerInstancia().ConsultaOperacionesConMat(orden);
                    size = modOpeLst.size() + 50;
                    c = 0;
                    if (modOpeLst.size() > 0) {
                        out.println("<table id=\"tablaMate\">");
                        out.println("<tbody id=\"cargarDatOpe2\">");
                        for (c = 0; c < size; c++) {
                            if (c < modOpeLst.size()) {
                                if (modOpeLst.get(c).getSolicitante().length() > 1) {
                                    out.println("<tr>\n"
                                            + "<td><input type=\"checkbox\" name=\"TMpos\" value=" + c + " style=\"width=50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getNum_operacion() + "\" name=\"TMnoOpe\" id=\"TMnoOpe" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getCantidad_base() + "\" name=\"TMctdO1\" id=\"TMctdO1" + c + "\"  style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getUnidad_trabajo() + "\" name=\"TMctdO2\" id=\"TMctdO2" + c + "\"  style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getPrecio() + "\" name=\"TMpre1\" id=\"TMpre1" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getClave_moneda() + "\" name=\"TMpre2\" id=\"TMpre2" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getGrupo_articulos() + "\" name=\"TMgpoA1\" id=\"TMgpoA1" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getOrganizacion_compras() + "\" name=\"TMgpoC1\" id=\"TMgpoC1" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getGrupo_compras_actividad_trabajo_externa() + "\" name=\"TMgpoC2\" id=\"TMgpoC2" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMcontr1\" id=\"TMcontr1" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMcontr2\" id=\"TMcontr2" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMdest\" id=\"TMdest" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getSolicitante() + "\" name=\"TMsoli\" id=\"TMsoli" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMplzE\" id=\"TMplzE" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMsubC\" id=\"TMsubC" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMclvCl\" id=\"TMclvCl" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMpor\" id=\"TMpor" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getClase_coste() + "\" name=\"TMclC\" id=\"TMclC" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" value=\"" + modOpeLst.get(c).getNum_cuenta_proveedor() + "\" name=\"TMacre\" id=\"TMacre" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMregI\" id=\"TMregI" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMptoD\" id=\"TMptoD" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMnoN\" id=\"TMnoN" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMpedM1\" id=\"TMpedM1" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMpedM2\" id=\"TMpedM2" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "<td><input type=\"text\" name=\"TMcont\" id=\"TMcont" + c + "\" style=\"width:50px;\"></td>\n"
                                            + "</tr>");
                                }

                            } else {
                                out.println("<tr>\n"
                                        + "<td><input type=\"checkbox\" name=\"TMpos\" value=" + c + " style=\"width=50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMnoOpe\" id=\"TMnoOpe" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMctdO1\" id=\"TMctdO1" + c + "\"  style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMctdO2\" id=\"TMctdO2" + c + "\"  style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMpre1\" id=\"TMpre1" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMpre2\" id=\"TMpre2" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMgpoA1\" id=\"TMgpoA1" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMgpoC1\" id=\"TMgpoC1" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMgpoC2\" id=\"TMgpoC2" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMcontr1\" id=\"TMcontr1" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMcontr2\" id=\"TMcontr2" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMdest\" id=\"TMdest" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMsoli\" id=\"TMsoli" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMplzE\" id=\"TMplzE" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMsubC\" id=\"TMsubC" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMclvCl\" id=\"TMclvCl" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMpor\" id=\"TMpor" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMclC\" id=\"TMclC" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMacre\" id=\"TMacre" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMregI\" id=\"TMregI" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMptoD\" id=\"TMptoD" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMnoN\" id=\"TMnoN" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMpedM1\" id=\"TMpedM1" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMpedM2\" id=\"TMpedM2" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "<td><input type=\"text\" name=\"TMcont\" id=\"TMcont" + c + "\" style=\"width:50px;\"></td>\n"
                                        + "</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "validarUser":
                    check = ACC_Cabecera_ordenes_crea.ObtenerInstancia().ValidarUserOrd(orden);
                    out.println(check);
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
