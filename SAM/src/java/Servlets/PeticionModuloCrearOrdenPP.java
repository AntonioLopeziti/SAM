/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CentroPlanificacion;
import java.io.IOException;
import java.io.PrintWriter;
import Entidades.materiales;
import Entidades.clase_orden;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_ClaseOrden;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_HojasRuta;
import AccesoDatos.ACC_PuestoTrabajo;
import Entidades.centroPlanificacion;
import Entidades.hojas_de_ruta;
import Entidades.puesto_trabajo;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author Are-Consulting
 */
@WebServlet(name = "PeticionModuloCrearOrdenPP", urlPatterns = {"/PeticionModuloCrearOrdenPP"})
public class PeticionModuloCrearOrdenPP extends HttpServlet {

    public String checkEmptyOpe(String data) {
        String answer;
        if (data == null) {
            answer = "";
        } else {
            answer = data;
        }
        return answer;
    }

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
            String Accion = request.getParameter("acc");
            String Idioma = request.getParameter("Idioma");
            String umd = request.getParameter("umd");
            /////////////Match Equipo
            String denMat = request.getParameter("denMat");
            String numMat = request.getParameter("numMat");
            String ctdMat = request.getParameter("ctdMat");
            //////////////Validar Datos
            String claseOrden = request.getParameter("clOr");
            String mater = request.getParameter("mater");
            String equipo = request.getParameter("equi");
            //////////////Match Puesto de Trabajo Responsable 
            String clPto = request.getParameter("clPtoTr");
            String centroPto = request.getParameter("centPto");
            String ptoTrM = request.getParameter("ptoTrM");
            String denPtoT = request.getParameter("desPto");
            String ctdPto = request.getParameter("ctdPto");
            String check;

            String contHR = request.getParameter("contHR");
            String numHR = request.getParameter("numHR");
            String centP = request.getParameter("centP");

            switch (Accion) {
                case "ConsultaMatchClaseOr":
                    ArrayList<clase_orden> lstClaseOrd = ACC_ClaseOrden.ObtenerInstancia().ConsultaClaseOrdenOrdPP(Idioma);

                    for (int i = 0; i < lstClaseOrd.size(); i++) {
                        out.println("<option value=\"" + lstClaseOrd.get(i).getClase_orden() + "\">" + lstClaseOrd.get(i).getClase_orden() + "</option>");
                    }
                    break;
                case "ConsultaMatchMate":
                    String descIdMat = "descripcion_" + Idioma;
                    ArrayList<materiales> e = ACC_Material.ObtenerInstancia().ConsultarMaterialMatchOrdPP(denMat, numMat, descIdMat, ctdMat);
                    if (e.size() > 0) {
                        out.println("<table>");
                        out.println("<table>");
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < e.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + e.get(i).getMaterial() + "', 'Material');\" >");
                            out.println("<td>" + e.get(i).getDescripcion_material() + "</td>");
                            out.println("<td>" + e.get(i).getMaterial() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "cargarDataMaterial":
                    String[] mat = ACC_HojasRuta.ObtenerInstancia().DataMaterialHR(mater);
                    JSONArray jm = new JSONArray();
                    jm.add(mat[0]);
                    jm.add(mat[1]);
                    jm.add(mat[2]);
                    out.println(jm);
                    break;
                case "ConsultaMatchPtoTr":
                    String desPtoTr = "denominacion_" + Idioma;
                    ArrayList<puesto_trabajo> lstPto = ACC_PuestoTrabajo.ObtenerInstancia().ConsultaMatchPuestoTrabajoOrdPP(clPto, centroPto, ptoTrM, denPtoT, desPtoTr, ctdPto);
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
                case "cargarDataEquipo":
                    String[] ret = ACC_Equipos.ObtenerInstancia().DataMatchEquipoOrdenesPP(mater);
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

                case "ConsultaMatchCentroP":
                    ArrayList<centroPlanificacion> centp = ACC_CentroPlanificacion.ObtenerInstancia().ConsultaMatchCentroPOrdPP();
                    if (centp.size() > 0) {
                        out.println("<select id=\"CentPl\">");

                        for (int i = 0; i < centp.size(); i++) {
                            out.println("<option value=\"" + centp.get(i).getCentro_planificacion_mantenimiento() + "\">" + centp.get(i).getCentro_planificacion_mantenimiento() + "</option>");
                        }
                        out.println("</select>");

                    }
                    break;
                case "ConsultaMatchContaHR":
                    ArrayList<hojas_de_ruta> lstHR = ACC_HojasRuta.ObtenerInstancia().ConsultaVisualizarHROrdenesPP(mater);
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
                case "validarNumMat":
                    check = ACC_Material.ObtenerInstancia().getExisNumMatePP(mater);
                    out.println(check);
                    break;
                case "consultarCentroAct":
                    check = ACC_CentroPlanificacion.ObtenerInstancia().ConsultarCentroActualPP();
                    out.print(check);
                    break;
                case "cargarDataOpe":
                    String noOpe,
                     txtB,
                     cant,
                     dur,
                     uni,
                     pto;
                    ArrayList<hojas_de_ruta> lstHRope = ACC_HojasRuta.ObtenerInstancia().ConsultaOperacionesHR_PP(claseOrden, contHR, numHR);
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
