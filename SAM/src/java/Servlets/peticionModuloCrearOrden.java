package Servlets;

import AccesoDatos.ACC_BOMEquipos;
import AccesoDatos.ACC_Cabecera_ordenes_crea;
import AccesoDatos.ACC_CentroPlanificacion;
import AccesoDatos.ACC_ClaseOrden;
import AccesoDatos.ACC_ClaveMoneda;
import AccesoDatos.ACC_ControlOperacion;
import AccesoDatos.ACC_CuentaMayor;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_GrupoArticulos;
import AccesoDatos.ACC_GrupoCompras;
import AccesoDatos.ACC_HojasRuta;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_MaterialesOrdenesCrea;
import AccesoDatos.ACC_OperacionesOrdenesCrea;
import AccesoDatos.ACC_OrganizacionCompras;
import AccesoDatos.ACC_Proveedor;
import AccesoDatos.ACC_PuestoTrabajo;
import AccesoDatos.ACC_Servicios;
import AccesoDatos.ACC_ServiciosOrdenesCrea;
import AccesoDatos.ACC_TextoPosicionOrdenesCrea;
import AccesoDatos.ACC_UbicacionTecnica;
import AccesoDatos.ACC_UnidadesMedida;
import AccesoDatos.Consultas;
import Entidades.CeCos;
import Entidades.bom_equipo;
import Entidades.cabecera_ordenes_crea;
import Entidades.centroPlanificacion;
import Entidades.clase_orden;
import Entidades.clave_moneda;
import Entidades.control_operacion;
import Entidades.equipos;
import Entidades.grupo_articulos;
import Entidades.grupo_compras;
import Entidades.hojas_de_ruta;
import Entidades.materiales;
import Entidades.materiales_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import Entidades.organizacion_compras;
import Entidades.proveedor;
import Entidades.puesto_trabajo;
import Entidades.servicios;
import Entidades.servicios_ordenes_crea;
import Entidades.texto_posicion_ordenes_crea;
import Entidades.ubicacion_tecnica;
import Entidades.unidades_medida;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

@WebServlet(name = "peticionModuloCrearOrden", urlPatterns = {"/peticionModuloCrearOrden"})
public class peticionModuloCrearOrden extends HttpServlet {

    public String checkEmpty(String data) {
        String answer;
        if (data.length() < 1) {
            answer = "0";
        } else {
            answer = data;
        }
        return answer;
    }

    public int checkBoolean(boolean check) {
        int val = 0;
        if (check) {
            val = 1;
        } else {
            val = 0;
        }
        return val;
    }

    public String checkEmptyOpe(String data) {
        String answer;
        if (data == null) {
            answer = "";
        } else {
            answer = data;
        }
        return answer;
    }

    public String checkCtd(String ctd) {
        String queryStart;

        if (ctd.length() < 1) {
            queryStart = "SELECT * ";
        } else {
            queryStart = "SELECT TOP " + ctd + " * ";
        }
        return queryStart;
    }

    public String checkCtdDIS(String ctd) {
        String queryStart;

        if (ctd.length() < 1) {
            queryStart = "SELECT DISTINCT ";
        } else {
            queryStart = "SELECT DISTINCT TOP " + ctd + " ";
        }
        return queryStart;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Accion = request.getParameter("acc");
            String Idioma = request.getParameter("Idioma");
            String umd = request.getParameter("umd");
            /////////////Match Equipo
            String denomEqui = request.getParameter("denE");
            String numE = request.getParameter("numE");
            String ctdEqui = request.getParameter("ctdE");
            //////////////
            /////////////Match Ubicacion Tecnica
            String denomUbiT = request.getParameter("denUT");
            String ubiT = request.getParameter("ubiT");
            String ctdUbiT = request.getParameter("ctdUt");
            //////////////Match Puesto de Trabajo Responsable 
            String clPto = request.getParameter("clPtoTr");
            String centroPto = request.getParameter("centPto");
            String ptoTrM = request.getParameter("ptoTrM");
            String denPtoT = request.getParameter("desPto");
            String ctdPto = request.getParameter("ctdPto");
            //////////////Validar Datos
            String claseOrden = request.getParameter("clOr");
            String equipo = request.getParameter("equi");
            ///ubiT
            String centP = request.getParameter("centP");
            String PtoTr = request.getParameter("ptoT");

            ////////////Match Material
            String txtM = request.getParameter("txtmat");
            String nmat = request.getParameter("matNum");
            String cenM = request.getParameter("centmat");
            String cntM = request.getParameter("cntMmat");
            String pzFb = request.getParameter("numPz");

            ///////// Boton TOMAR
            String contHR = request.getParameter("contHR");
            String numHR = request.getParameter("numHR");
            String posicion = request.getParameter("pos");
            String nLst = request.getParameter("numLst");
            String nAlt = request.getParameter("altLst");

            ////////Insert Cabecera
            String cabClaseO = request.getParameter("cabClo");
            String cabDescri = request.getParameter("cabDes");
            String cabEquipo = request.getParameter("cabEqui");
            String cabUbiTec = request.getParameter("cabUbiT");
            String cabCentPl = request.getParameter("cabCentP");
            String cabPtoTr = request.getParameter("cabPtoR");
            String cabHora = request.getParameter("cabHor");
            String cabFecha = request.getParameter("cabFech");
            String cabFechaIni = request.getParameter("cabFechIni");
            String cabFechaFin = request.getParameter("cabFechFin");
            String user = request.getParameter("cabUs");

            String numMat = request.getParameter("numMat");

            String clsCM = request.getParameter("clCM");
            String txtCM = request.getParameter("txtCM");
            String numCM = request.getParameter("numCM");

            String txtS = request.getParameter("txtNS");
            String numS = request.getParameter("numNS");
            String ctdS = request.getParameter("ctdNS");

            String ROpto = request.getParameter("rowOPto");
            String ROcent = request.getParameter("rowOCent");
            String ROcls = request.getParameter("rowOCls");
            String ROumd = request.getParameter("rowOUmd");

            String COope = request.getParameter("cellOpe");
            String COpto = request.getParameter("cellPto");
            String COcen = request.getParameter("cellCen");
            String COsta = request.getParameter("cellSta");
            String COdes = request.getParameter("cellDes");
            String COcant = request.getParameter("cellCant");
            String COdur = request.getParameter("cellDur");
            String COumd = request.getParameter("cellUmd");

            String CompM = request.getParameter("compMat");
            String CompLot = request.getParameter("compLot");
            String CompTx = request.getParameter("compTxt");
            String CompCan = request.getParameter("compCant");
            String ComUm = request.getParameter("compUmc");
            String CompCen = request.getParameter("compCent");
            String CompAl = request.getParameter("compAlm");
            String CompOp = request.getParameter("compOpe");

            String serNoO = request.getParameter("serNoOpe");
            String serNoS = request.getParameter("serNoS");
            String serCant = request.getParameter("serCant");
            String serPreEs1 = request.getParameter("serPreEs1");

            String serGpoA2 = request.getParameter("serGpoA2");
            String serClsC = request.getParameter("serClsC");
            String serTxtS = request.getParameter("serTxtS");
            String serUmdS = request.getParameter("serUmdS");

            String folio = request.getParameter("folio");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String campoDescri;
            String check;

            String vSerCtd2 = request.getParameter("vSerCtd2");
            String vSerPre2 = request.getParameter("vSerPre2");
            String vSerGpoA = request.getParameter("vSerGpoA");
            String vSerGcom1 = request.getParameter("vSerGcom1");
            String vSerGcom2 = request.getParameter("vSerGcom2");
            String vSerClsC = request.getParameter("vSerClsC");

            String vNoSer = request.getParameter("vSer2noS");

            String rCmat = request.getParameter("rowCmat");
            String rCumc = request.getParameter("rowCumc");
            String rCcen = request.getParameter("rowCcent");
            String rCalm = request.getParameter("rowCalm");

            String matUniT = request.getParameter("fieldUndT");
            String matctdO = request.getParameter("fieldCtdO");
            String matorgC = request.getParameter("fieldOrgC");
            String matgpoC = request.getParameter("fieldGpoC");
            String matgpoA = request.getParameter("fieldGpoA");
            String matprec = request.getParameter("fieldprecio");
            String matclvM = request.getParameter("fieldClvM");
            String matclsC = request.getParameter("fieldClsC");
            String matsoli = request.getParameter("fieldSol");
            String matnumO = request.getParameter("fieldNumO");
            String matfolS = request.getParameter("fieldFolS");
            String folAct = request.getParameter("folAct");
            String matAcre = request.getParameter("fieldAcre");
            String validacion;
            String indice = request.getParameter("indice");
            Consultas cx = new Consultas();
            switch (Accion) {
                case "ConsultaMatchEquipo":
                    String desE = "denominacion_" + Idioma;
                    ArrayList<equipos> e = ACC_Equipos.ObtenerInstancia().ConsultarEquipoMatchOrd(numE, denomEqui, desE, ctdEqui);
                    if (e.size() > 0) {
                        out.println("<table>");
                        out.println("<table>");
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < e.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + e.get(i).getNum_equipo() + "', 'Equipo');\" >");
                            out.println("<td>" + e.get(i).getDenominacion_es() + "</td>");
                            out.println("<td>" + e.get(i).getNum_equipo() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchUbiT":
                    String desUb = "denominacion_" + Idioma;
                    ArrayList<ubicacion_tecnica> ub = ACC_UbicacionTecnica.ObtenerInstancia().ConsultarUbiTMatchOrd(ubiT, denomUbiT, desUb, ctdUbiT);
                    if (ub.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ub.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + ub.get(i).getUbicacion_tecnica() + "', 'UbiT');\">");
                            out.println("<td>" + ub.get(i).getUbicacion_tecnica() + "</td>");
                            out.println("<td>" + ub.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchPtoTr":
                    String desPtoTr = "denominacion_" + Idioma;
                    ArrayList<puesto_trabajo> lstPto = ACC_PuestoTrabajo.ObtenerInstancia().ConsultaMatchPuestoTrabajoOrd(clPto, centroPto, ptoTrM, denPtoT, desPtoTr, ctdPto);
                    if (lstPto.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstPto.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstPto.get(i).getPuesto_trabajo() + "', 'PtoTr');\">");
                            out.println("<td>" + lstPto.get(i).getCentro() + "</td>");
                            out.println("<td>" + lstPto.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + lstPto.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchCentroP":
                    ArrayList<centroPlanificacion> centp = ACC_CentroPlanificacion.ObtenerInstancia().ConsultaMatchCentroPOrd();
                    if (centp.size() > 0) {
                        out.println("<select id=\"CentPl\">");

                        for (int i = 0; i < centp.size(); i++) {
                            out.println("<option value=\"" + centp.get(i).getCentro_planificacion_mantenimiento() + "\">" + centp.get(i).getCentro_planificacion_mantenimiento() + "</option>");
                        }
                        out.println("</select>");

                    }
                    break;
                case "ConsultaMatchClaseOr":
                    ArrayList<clase_orden> lstClaseOrd = ACC_ClaseOrden.ObtenerInstancia().ConsultaClaseOrdenOrd(Idioma);

                    for (int i = 0; i < lstClaseOrd.size(); i++) {
                        out.println("<option value=\"" + lstClaseOrd.get(i).getClase_orden() + "\">" + lstClaseOrd.get(i).getClase_orden() + "</option>");
                    }

                    break;
                case "cargarDataEquipo":
                    String[] ret = ACC_Equipos.ObtenerInstancia().DataMatchEquipoOrdenes(equipo);
                    if (ret[0].equals("x")) {
                        JSONArray js = new JSONArray();
                        js.add(ret[0]);
                        out.println(js);
                    } else {
                        JSONArray js = new JSONArray();
                        js.add(ret[0]);
                        js.add(ret[1]);
                        js.add(ret[2]);
                        js.add(ret[3]);
                        js.add(ret[4]);
                        js.add(ret[5]);
                        js.add(ret[6]);
                        out.println(js);
                    }
                    break;
                case "cargarDataOpe":
                    String noOpe,
                     txtB,
                     cant,
                     dur,
                     uni,
                     pto;
                    ArrayList<hojas_de_ruta> lstHRope = ACC_HojasRuta.ObtenerInstancia().ConsultaOperacionesXhr(claseOrden, contHR, numHR);
                    check = lstHRope.get(0).getNum_operacion();
                    if (lstHRope.size() > 0) {
                        if (check.equals("0") || check.equals("1")) {
                            out.println(check);
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            int c = 0;
                            int rowEmpty = lstHRope.size() + 50;
                            for (c = 0; c <= rowEmpty; c++) {
                                if (c < lstHRope.size()) {
                                    noOpe = checkEmptyOpe(lstHRope.get(c).getNum_operacion());
                                    txtB = checkEmptyOpe(lstHRope.get(c).getTexto_breve_operacion());
                                    cant = checkEmptyOpe(lstHRope.get(c).getCantidad_base());
                                    dur = checkEmptyOpe(lstHRope.get(c).getDuracion_operacion_normal());
                                    uni = checkEmptyOpe(lstHRope.get(c).getUnidad_duracion_normal());
                                    pto = checkEmptyOpe(lstHRope.get(c).getPuesto_trabajo());
                                    centP = checkEmptyOpe(centP);
                                    out.println("<tr>\n"
                                            + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"TOpos\" value=" + c + "></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOope\" id=\"TOope" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 55px;\" value=\"" + noOpe + "\" readonly></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOptoTr\" id=\"TOptoTr" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOptoTr')\" value=\"" + pto + "\" style=\"width: 105px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">     <button id=\"match_TOptoTr" + c + "\" name=\"match_TOptoTr\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTOPtoTr('" + c + "')\"></button> </td>\n"
                                            + "                <td><input type=\"text\" name=\"TOcent\" id=\"TOcent" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOcent')\" value=\"" + centP + "\"  style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">       <button id=\"match_TOcent" + c + "\" name=\"match_TOcent\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOCent('" + c + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOclvOpe\" id=\"TOclvOpe" + c + "\" onfocus=\"BtnHideTO()\"style=\"width: 75px;\" disabled></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOsta\" id=\"TOsta" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOsta')\" value=\"PM01\" style=\"width: 120px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">         <button id=\"match_TOsta" + c + "\" name=\"match_TOsta\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOSta('" + c + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOdesOpe\" id=\"TOdesOpe" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOdesOpe')\" value=\"" + txtB + "\" style=\"width: 415px;\" maxlength=\"40\">                                                            <button id=\"match_TOdesOpe" + c + "\" name=\"match_TOdesOpe\" class='BtnMatchIconDescri'  style=\"display : none;\" onclick=\"mostrarVentanaModalib()\"></button>     </td>\n"
                                            + "                <td><input type=\"text\" name=\"TOcant\" id=\"TOcant" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 95px;\" value=\"" + cant + "\" maxlength=\"13\"></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOdura\" id=\"TOdura" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 65px;\" value = \"" + dur + "\" maxlength=\"5\" ></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOumd\" id=\"TOumd" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOumd')\" value = \"" + uni + "\" maxlength=\"3\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\"  >     <button id=\"match_TOumd" + c + "\" name=\"match_TOumd\" class='BtnMatchIcon'  style=\"display :none  ;\" onclick=\"matchTOUMD('" + c + "')\"></button></td>\n"
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
                                            + "                <td><input type=\"text\" name=\"TOdesOpe\" id=\"TOdesOpe" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOdesOpe')\" style=\"width: 415px;\" maxlength=\"40\">                                                            <button id=\"match_TOdesOpe" + c + "\" name=\"match_TOdesOpe\" class='BtnMatchIconDescri'  style=\"display : none;\" onclick=\"mostrarVentanaModalib()\"></button>     </td>\n"
                                            + "                <td><input type=\"text\" name=\"TOcant\" id=\"TOcant" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 95px;\" maxlength=\"13\"></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOdura\" id=\"TOdura" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 65px;\" maxlength=\"5\" ></td>\n"
                                            + "                <td><input type=\"text\" name=\"TOumd\" id=\"TOumd" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOumd')\" maxlength=\"3\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\"  >     <button id=\"match_TOumd" + c + "\" name=\"match_TOumd\" class='BtnMatchIcon'  style=\"display :none  ;\" onclick=\"matchTOUMD('" + c + "')\"></button></td>\n"
                                            + "                <td style=\"visibility: hidden;\"><input type=\"text\" name=\"TOcont\" id=\"TOcont" + c + "\">     </td>\n"
                                            + "           </tr>");

                                }
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    }
                    break;
                case "cargarDataComp":
                    campoDescri = "descripcion_" + Idioma;
                    ArrayList<materiales> mat = ACC_BOMEquipos.ObtenerInstancia().ConsultaComponentesByBoomE(equipo, nLst, nAlt, campoDescri);
                    check = mat.get(0).getMaterial();
                    if (mat.size() > 0) {
                        if (check.equals("0") || check.equals("1")) {
                            out.println(check);
                        } else {
                            int rowEmpty = mat.size() + 50;
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int d = 0; d <= rowEmpty; d++) {
                                if (d < mat.size()) {
                                    out.println("<tr>\n"
                                            + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"TCpos\" value=" + d + "></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCmat\" id=\"TCmat" + d + "\" value=\"" + mat.get(d).getMaterial() + "\" onfocus=\"BtnShowTC('" + d + "','match_TCmat')\" style=\"width: 225px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"18\">     <button id=\"match_TCmat" + d + "\" name=\"match_TCmat\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCmat('" + d + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TClot\" id=\"TClot" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TClot')\" style=\"width: 45px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">     <button id=\"match_TClot" + d + "\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTClot('" + d + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCtxtB\" id=\"TCtxtB" + d + "\" value=\"" + mat.get(d).getDescripcion() + "\" onfocus=\"BtnHideTC()\" style=\"width: 325px;\" maxlength=\"40\"></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCcant\" id=\"TCcant" + d + "\" value=\"1.000\" onfocus=\"BtnHideTC()\" style=\"width: 95px;\" onblur=\"this.value = checkDecCant1(this.value, 3, 'serCtdOp2')\"   onKeyUp=\"this.value = check99(this.value, '9999999', 7)\" maxlength=\"11\"></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCumc\" id=\"TCumc" + d + "\"  value=\"" + mat.get(d).getUnidad_medida() + "\" onfocus=\"BtnShowTC('" + d + "','match_TCumc')\" style=\"width: 55px;\" onblur=\"checkDecCant2('TCcant" + d + "', 'TCumc" + d + "');\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"3\">      <button id=\"match_TCumc" + d + "\" name=\"match_TCumc\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCUMC('" + d + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCcent\" id=\"TCcent" + d + "\" value=\"BAJA\" readonly onfocus=\"BtnHideTC()\" style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">   <button id=\"match_TCcent" + d + "\" name=\"match_TCcent\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCcent('" + d + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCalm\" id=\"TCalm" + d + "\" onfocus=\"BtnHideTC()\" value=\"M100\" readonly style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">      <button id=\"match_TCalm" + d + "\" name=\"match_TCalm\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCalm('" + d + "')\"></button></td>\n"
                                            + "                <td><input type=\"text\" name=\"TCope\" id=\"TCope" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 55px;\" maxlength=\"4\"></td>\n"
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

                            out.print("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchContaHR":
                    ArrayList<hojas_de_ruta> lstHR = ACC_HojasRuta.ObtenerInstancia().ConsultaVisualizarHROrdenesO(equipo);
                    if (lstHR.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstHR.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstHR.get(i).getContador_grupo_hojaruta() + "', 'ContaHR');Select2('" + lstHR.get(i).getClave_grupo_hojaruta() + "', 'ContaHR');\">");
                            out.println("<td>" + lstHR.get(i).getContador_grupo_hojaruta() + "</td>");
                            out.println("<td>" + lstHR.get(i).getClave_grupo_hojaruta() + "</td>");
//                            out.println("<td>" + lstHR.get(i).getTexto_hojaruta() + "</td>");
                            out.println("<td>" + lstHR.get(i).getTexto_breve_operacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;

                case "ConsultaMatchLstMat":
                    ArrayList<materiales> lstNumMat = ACC_BOMEquipos.ObtenerInstancia().ObtenerBomEquipoBOMOrdenes(equipo, Idioma);
                    if (lstNumMat.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstNumMat.size(); i++) {
                            out.println("<tr>");
                            out.println("<td style=\"width: 150px\"><input type=\"checkbox\" style=\"size: 100%;\" name=\"TLpos\" value=" + i + "></td>");
                            out.println("<td name=\"TLnumM\">" + lstNumMat.get(i).getMaterial() + "</td>");
                            out.println("<td name=\"TLnumPz\">" + lstNumMat.get(i).getMateria() + "</td>");
                            out.println("<td name=\"TLdes\">" + lstNumMat.get(i).getDescripcion() + "</td>");
                            out.println("<td name=\"TLumd\" hidden>" + lstNumMat.get(i).getUnidad_medida() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchTOPtoTr":
                    String desPtoTrM = "denominacion_" + Idioma;
                    ArrayList<puesto_trabajo> lstPtoTO = ACC_PuestoTrabajo.ObtenerInstancia().ConsultaMatchPuestoTrabajoOrd("", "", "", "", desPtoTrM, "");
                    if (lstPtoTO.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstPtoTO.size(); i++) {
                            out.println("<tr ondblclick=\"selectMatchTO('PtoTr', '" + posicion + "','" + lstPtoTO.get(i).getPuesto_trabajo() + "');\">");
                            out.println("<td>" + lstPtoTO.get(i).getCentro() + "</td>");
                            out.println("<td>" + lstPtoTO.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + lstPtoTO.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchTOCent":
                    ArrayList<centroPlanificacion> centpTO = ACC_CentroPlanificacion.ObtenerInstancia().ConsultaMatchCentroPOrd();
                    if (centpTO.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < centpTO.size(); i++) {
                            out.println("<tr ondblclick=\"selectMatchTO('CentroP','" + posicion + "','" + centpTO.get(i).getCentro_planificacion_mantenimiento() + "');\">");
                            out.println("<td>" + centpTO.get(i).getCentro_planificacion_mantenimiento() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchTOSta":
                    String descriClOr = "descripcion_" + Idioma;
                    ArrayList<control_operacion> lstClaseOrdTO = ACC_ControlOperacion.ObtenerInstancia().ConsultarClaveControlMatchTabOpe(descriClOr);
                    if (lstClaseOrdTO.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstClaseOrdTO.size(); i++) {
                            out.println("<tr ondblclick=\"selectMatchTO('ClaveCtrl','" + posicion + "','" + lstClaseOrdTO.get(i).getClave_control() + "');\">");
                            out.println("<td>" + lstClaseOrdTO.get(i).getClave_control() + "</td>");
                            out.println("<td>" + lstClaseOrdTO.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchTOUMD":
                    String descriUMD = "descripcion_" + Idioma;
                    ArrayList<unidades_medida> lstUMDTO = ACC_UnidadesMedida.ObtenerInstancia().ConsultarUMDMatchOrd(descriUMD);
                    if (lstUMDTO.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstUMDTO.size(); i++) {
                            out.println("<tr ondblclick=\"selectMatchTO('UMD','" + posicion + "','" + lstUMDTO.get(i).getUnidad_medida() + "');\">");
                            out.println("<td>" + lstUMDTO.get(i).getUnidad_medida() + "</td>");
                            out.println("<td>" + lstUMDTO.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;

                case "matchSctd":
                    campoDescri = "descripcion_" + Idioma;
                    lstUMDTO = ACC_UnidadesMedida.ObtenerInstancia().ConsultarUMDMatchOrd(campoDescri);
                    if (lstUMDTO.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstUMDTO.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstUMDTO.get(i).getUnidad_medida() + "','sUMC');\">");
                            out.println("<td>" + lstUMDTO.get(i).getUnidad_medida() + "</td>");
                            out.println("<td>" + lstUMDTO.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchSclvM":
                    String descriClvM = "descripcion_" + Idioma;
                    ArrayList<clave_moneda> lstClv = ACC_ClaveMoneda.ObtenerInstancia().ConsultarClvMonedaOrden(descriClvM);
                    if (lstClv.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstClv.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstClv.get(i).getClave_moneda() + "','sClvM');\">");
                            out.println("<td>" + lstClv.get(i).getClave_moneda() + "</td>");
                            out.println("<td>" + lstClv.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchSgpoA":
                    ArrayList<grupo_articulos> lstGpoA = ACC_GrupoArticulos.ObtenerInstancia().ConsultarGpoArticuloOrden(txtM, nmat, cenM, cntM, Idioma);
                    if (lstGpoA.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstGpoA.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstGpoA.get(i).getGrupo_articulo() + "','sGpoA');\">");
                            out.println("<td>" + lstGpoA.get(i).getGrupo_articulo() + "</td>");
                            out.println("<td>" + lstGpoA.get(i).getDenominacion() + "</td>");
                            out.println("<td>" + lstGpoA.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchSgpoC1":
                    ArrayList<grupo_compras> lstGpoC1 = ACC_GrupoCompras.ObtenerInstancia().ConsultarGpoComprasOrden();
                    if (lstGpoC1.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstGpoC1.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstGpoC1.get(i).getId_grupo_compras() + "','sGpoC1');\">");
                            out.println("<td>" + lstGpoC1.get(i).getId_grupo_compras() + "</td>");
                            out.println("<td>" + lstGpoC1.get(i).getDenominacion_grupocompras() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchSgpoC2":
                    ArrayList<organizacion_compras> lstOrgC = ACC_OrganizacionCompras.ObtenerInstancia().ConsultarOrganizacionCompraOrden(Idioma);
                    if (lstOrgC.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstOrgC.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstOrgC.get(i).getOrganizacion_compras() + "','sGpoC2');\">");
                            out.println("<td>" + lstOrgC.get(i).getOrganizacion_compras() + "</td>");
                            out.println("<td>" + lstOrgC.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchSacred":
                    ArrayList<proveedor> lstProv = ACC_Proveedor.ObtenerInstancia().MuestraMatchProveedor("", "", "", "");
                    if (lstProv.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstProv.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstProv.get(i).getIdProveedor() + "','sAcre');\">");
                            out.println("<td>" + lstProv.get(i).getIdProveedor() + "</td>");
                            out.println("<td>" + lstProv.get(i).getNombre1() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;

                case "matchSnumCM":
                    ArrayList<CeCos> lstNumCM = ACC_CuentaMayor.ObtenerInstancia().ConsultarOrganizacionCompraOrden(clsCM, txtCM, numCM);
                    if (lstNumCM.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstNumCM.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstNumCM.get(i).getClaseCoste() + "','sNumCM');\">");
                            out.println("<td>" + lstNumCM.get(i).getClaseCoste() + "</td>");
                            out.println("<td>" + lstNumCM.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;

                case "validarServi1":
                    validacion = ACC_ServiciosOrdenesCrea.ObtenerInstancia().ValidarMatchServi1(vSerCtd2, vSerPre2, vSerGpoA, vSerGcom1, vSerGcom2, vSerClsC);
                    out.println(validacion);
                    break;
                case "validarServi2":
                    validacion = ACC_ServiciosOrdenesCrea.ObtenerInstancia().ValidarMatchServi2(vNoSer);
                    out.println(validacion);
                    break;
                case "matchSnumS":
                    String desS = "descripcion_" + Idioma;
                    ArrayList<servicios> lstS = ACC_Servicios.ObtenerInstancia().ConsultaMatchServicioOrden(numS, txtS, desS, ctdS);
                    if (lstS.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstS.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lstS.get(i).getServicio() + "','sNumS');Select2('" + lstS.get(i).getDescripcion() + "','txtS');Select3('" + lstS.get(i).getUnidad_medida() + "','umdS');\">");
                            out.println("<td>" + lstS.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + lstS.get(i).getServicio() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchTCMat":
                    String desMat = "descripcion_" + Idioma;
                    ArrayList<materiales> lstMatTC = ACC_Material.ObtenerInstancia().ConsultaMatchMaterialOrden(txtM, nmat, cenM, desMat, cntM, pzFb);
                    if (lstMatTC.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstMatTC.size(); i++) {
                            out.println("<tr ondblclick=\"selectMatchTC('Mat','" + posicion + "','" + lstMatTC.get(i).getMaterial() + "');\">");
                            out.println("<td>" + lstMatTC.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + lstMatTC.get(i).getMaterial() + "</td>");
//                            out.println("<td>" + lstMatTC.get(i).getCentro() + "</td>");
                            out.println("<td>" + lstMatTC.get(i).getMateria() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchTCUMC":
                    String descriUMC = "descripcion_" + Idioma;
                    ArrayList<unidades_medida> lstUMDTC = ACC_UnidadesMedida.ObtenerInstancia().ConsultarUMDMatchOrd(descriUMC);
                    if (lstUMDTC.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lstUMDTC.size(); i++) {
                            out.println("<tr ondblclick=\"selectMatchTC('UMC','" + posicion + "','" + lstUMDTC.get(i).getUnidad_medida() + "');\">");
                            out.println("<td>" + lstUMDTC.get(i).getUnidad_medida() + "</td>");
                            out.println("<td>" + lstUMDTC.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "cargarMaterial":
                    String desM = "descripcion_" + Idioma;
                    materiales material;
                    material = ACC_Material.ObtenerInstancia().CargarMaterialOrden(numMat, desM);
                    if (material.getMaterial().equals("x")) {
                        out.println(material.getMaterial());
                    } else {
                        JSONArray js = new JSONArray();
                        js.add(material.getMaterial());
                        js.add(material.getDescripcion());
                        js.add(material.getUnidad_medida());
                        js.add(material.getCentro());
                        out.println(js);
                    }
                    break;
                case "validarDatosPri":
                    check = ACC_Cabecera_ordenes_crea.ObtenerInstancia().ValidarCabeceraOrden(claseOrden, equipo, ubiT, centP, PtoTr);
                    out.println(check);
                    break;
                case "checkRowOpe":
                    check = ACC_OperacionesOrdenesCrea.ObtenerInstancia().ValidarRowOperacionOrd(ROpto, ROcent, ROcls, ROumd);
                    out.println(check);
                    break;
                case "checkRowOpeSta":
                    check = ACC_OperacionesOrdenesCrea.ObtenerInstancia().ValidarRowOperacionStaOrd(ROpto, ROcent, ROcls);
                    out.println(check);
                    break;
                case "checkRowComp":
                    check = ACC_MaterialesOrdenesCrea.ObtenerInstancia().ValidarRowComponenteOrd(rCmat, rCumc, rCcen, rCalm);
                    out.println(check);
                    break;
                case "validarUMD":
                    check = ACC_UnidadesMedida.ObtenerInstancia().ValidarUMDOrd(umd);
                    out.println(check);
                    break;
                case "validarNumEqui":
                    check = ACC_Equipos.ObtenerInstancia().getExisNumEqui(equipo);
                    out.println(check);
                    break;
                case "validarAcre":
                    check = ACC_Proveedor.ObtenerInstancia().ValidarAcreOrd(matAcre);
                    out.println(check);
                    break;
                case "consultarCentroAct":
                    check = ACC_CentroPlanificacion.ObtenerInstancia().ConsultarCentroActual();
                    out.print(check);
                    break;
                case "insertCabecera":
                    cabecera_ordenes_crea coc = new cabecera_ordenes_crea();
                    coc.setFolio_sam(folio);
                    coc.setEstatus("ABIE");
                    coc.setUbicacion_tecnica(cabUbiTec);
                    coc.setHora_dia(cabHora);
                    coc.setFecha(cabFecha);
                    coc.setCentro_planificacion_mantenimiento(cabCentPl);
                    coc.setClase_orden(cabClaseO);
                    coc.setPuesto_trabajo_responsable_medidas_mante(cabPtoTr);
                    coc.setTexto_breve(cabDescri);
                    coc.setNum_equipo(cabEquipo);
                    coc.setFecha_inicio_extrema(cx.DateFormatGuion(cabFechaIni));
                    coc.setFecha_fin_extrema(cx.DateFormatGuion(cabFechaFin));
                    coc.setUsuario(user);
                    if (ACC_Cabecera_ordenes_crea.ObtenerInstancia().InsertCabeceraOrdenes(coc)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                case "insertTxtsD":
                    texto_posicion_ordenes_crea tpoc = new texto_posicion_ordenes_crea();
                    tpoc.setFolio_sam(folio);
                    tpoc.setNum_operacion(COope);
                    tpoc.setIndice(indice);
                    tpoc.setTexto(cabDescri);
                    if (ACC_TextoPosicionOrdenesCrea.ObtenerInstancia().InsertTxtsOrdenes(tpoc)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;

                case "insertarOperacion":
                    COcant = checkEmpty(COcant);
                    COdur = checkEmpty(COdur);
                    operaciones_ordenes_crea ooc = new operaciones_ordenes_crea();
                    ooc.setFolio_sam(folio);
                    ooc.setHora_dia(hora);
                    ooc.setFecha(fecha);
                    ooc.setNum_operacion(COope);
                    ooc.setClave_control(COsta);
                    ooc.setCentro(COcen);
                    ooc.setTexto_breve_operacion(COdes);
                    ooc.setCantidad_base(COcant);
                    ooc.setDuracion_operacion(COdur);
                    ooc.setUnidad_duracion_normal(COumd);
                    ooc.setNum_solped(COpto);
                    if (ACC_OperacionesOrdenesCrea.ObtenerInstancia().InsertOperacionOrdenes(ooc)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                case "insertarMaterial":
                    materiales_ordenes_crea moc = new materiales_ordenes_crea();

                    moc.setFolio_sam(folio);
                    moc.setHora_dia(hora);
                    moc.setFecha(fecha);
                    moc.setNum_material(CompM);
                    moc.setCentro(CompCen);
                    moc.setAlmacen(CompAl);
                    moc.setLote(CompLot);
                    moc.setCantidad_base(CompCan);
                    moc.setNum_operacion(CompOp);
                    moc.setTexto_breve_material(CompTx);
                    moc.setUnidad_medida_base(ComUm);

                    if (ACC_MaterialesOrdenesCrea.ObtenerInstancia().InsertMaterialOrdenes(moc)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;

                case "insertarServicio":
                    servicios_ordenes_crea soc = new servicios_ordenes_crea();
                    soc.setFolio_sam(folio);
                    soc.setNum_operacion(serNoO);
                    soc.setNum_servicio(serNoS);
                    soc.setCantidad_base(serCant);
                    soc.setUnidad_medida_base(serUmdS);
                    soc.setPrecio_bruto(serPreEs1);
                    soc.setTexto_breve(serTxtS);
                    soc.setGrupo_articulos(serGpoA2);
                    soc.setClase_coste(serClsC);

                    if (ACC_ServiciosOrdenesCrea.ObtenerInstancia().InsertServicioOrdenes(soc)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                    case "insertarOpe2":
                    ooc = new operaciones_ordenes_crea();
                    ooc.setUnidad_trabajo(matUniT);
                    ooc.setCantidad_operacion(matctdO);
                    ooc.setOrganizacion_compras(matorgC);
                    ooc.setGrupo_compras_actividad_trabajo_externa(matgpoC);
                    ooc.setGrupo_articulos(matgpoA);
                    ooc.setPrecio(matprec);
                    ooc.setClave_moneda(matclvM);
                    ooc.setClase_coste(matclsC);
                    ooc.setSolicitante(matsoli);
                    ooc.setNum_operacion(matnumO);
                    ooc.setFolio_sam(matfolS);
                    ooc.setNum_cuenta_proveedor(matAcre);
                    if (ACC_OperacionesOrdenesCrea.ObtenerInstancia().InsertOperacion2Ordenes(ooc)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "obtenerDecimalesUM":
                    check = ACC_UnidadesMedida.ObtenerInstancia().DecimalUnidadMedida(umd);
                    out.println(check);
                    break;
                case "ObtenerFolio":
                    check = ACC_Folios.ObtenerIstancia().ObtenerFolioOrden();
                    out.println(check);
                    break;
                case "updateFolio":
                    ACC_Folios.ObtenerIstancia().ActualizarFolioOrden("OR", folAct);
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
