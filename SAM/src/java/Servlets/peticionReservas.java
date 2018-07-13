/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CentroCosto;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Reservas;
import AccesoDatos.ACC_SolicitudPedidos;
import AccesoDatos.ACC_TipoMovimientos;
import Entidades.almacenes;
import Entidades.centro_coste;
import Entidades.folios;
import Entidades.materiales;
import Entidades.plan_orden;
import Entidades.tipo_movimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "peticionReservas", urlPatterns = {"/peticionReservas"})
public class peticionReservas extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String accion = request.getParameter("Action");
            String centroco = request.getParameter("CentroCO");
            String sociedadco = request.getParameter("SociedadCO");
            String descripco = request.getParameter("DescripcionCO");
            String ctdmax = request.getParameter("CantidadMatch");
            String numord = request.getParameter("NumOrd");

            String mate = request.getParameter("mater");
            String cen = request.getParameter("cen");
            String al = request.getParameter("al");
            String alre = request.getParameter("alre");
            
            String id = request.getParameter("id");
            String materiallan = "";
            String cantinece = "";
            String umedid = "";
            String desc = "";

            if (idioma.equals("ES")) {
                Properties props = new Properties();
                props.load(getServletContext().getResourceAsStream("/WEB-INF/LanguageES.properties"));
                materiallan = props.getProperty("etiqueta.GralMaterialAll");
                cantinece = props.getProperty("etiqueta.RESCantNe");
                umedid = props.getProperty("etiqueta.CSPUnidadMedida");
                desc = props.getProperty("etiqueta.GralDescripcion");

            } else if (idioma.equals("EN")) {
                Properties props = new Properties();
                props.load(getServletContext().getResourceAsStream("/WEB-INF/LanguageEN.properties"));
                materiallan = props.getProperty("etiqueta.GralMaterialAll");
                cantinece = props.getProperty("etiqueta.RESCantNe");
                umedid = props.getProperty("etiqueta.CSPUnidadMedida");
                desc = props.getProperty("etiqueta.GralDescripcion");
            }

            switch (accion) {
                case "ConsultaMatchAlmacen":
                    String deno = "descripcion_" + idioma;
                    ArrayList<almacenes> a = ACC_Reservas.ObtenerInstancia().MM_MatchAlmacen(deno);
                    if (a.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < a.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + a.get(i).getId_almacen() + "', '" + id + "')\">");
                            out.println("<td>" + a.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + a.get(i).getNombre_alamcen() + "</td>");
                            out.println("<td>" + a.get(i).getCentro() + "</td>");
                        }
                        out.println("</tbody");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchCentroCoste":
                    String descripcion = "descripcion_" + idioma;
                    LinkedList<centro_coste> c = ACC_CentroCosto.ObtenerInstancia().ConsultaMatchMMCenCoste(ctdmax, centroco, sociedadco, descripco, descripcion);
                    if (c.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + c.get(i).getCentro_coste() + "', 'centroco')\">");
                            out.println("<td>" + c.get(i).getCentro_coste() + "</td>");
                            out.println("<td>" + c.get(i).getSociedad_co() + "</td>");
                            out.println("<td>" + c.get(i).getDescripcion() + "</td>");
                        }
                        out.println("</tbody");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchOrdenes":
                    ArrayList<plan_orden> pl = ACC_Reservas.ObtenerInstancia().MMConsultaMatchOrdenMM(ctdmax, numord, descripco);
                    if (pl.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pl.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + pl.get(i).getNum_orden() + "', 'orden')\">");
                            out.println("<td>" + pl.get(i).getNum_orden() + "</td>");
                            out.println("<td>" + pl.get(i).getTexto_breve() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;

                case "ValMate":
                if (ACC_Material.ObtenerInstancia().MMValidaMaterialReservas(mate, cen, al) == true) {
                        out.println(1);
                    } else {
                        out.println(2);
                    }
                    break;
                case "CarMat":
                    //materiales mart = ACC_Material.ObtenerInstancia().CargarDatosReserva(mate, idioma);
                    String denomin = "descripcion_" + idioma;
                    materiales mart = ACC_Material.ObtenerInstancia().MMCargaDatosMatReserva(mate, denomin);
                    if (mart.getDescripcion() == null || mart.getDescripcion().equals("")) {
                        out.println(0);
                    } else {
//                        JSONArray js = new JSONArray();
//                        js.add(mart.getDescripcion());
//                        js.add(mart.getUnidad_medida());
//                        out.println(js);
                        out.println("<input type=\"text\" value=\"" + mart.getDescripcion() + "\" id=\"descripcionre\"/> ");
                        out.println("<input type=\"text\" value=\"" + mart.getUnidad_medida() + "\" id=\"umre\"/> ");
                    }
                    break;
                case "ConsultaMatchClaseMov":
                    ArrayList<tipo_movimiento> tm = ACC_TipoMovimientos.ObtenerInstancia().MM_MatchTipoMovimiento();
                    if (tm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < tm.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + tm.get(i).getid_tipo_mov() + "', '" + id + "')\">");
                            out.println("<td>" + tm.get(i).getid_tipo_mov() + "</td>");
                            out.println("<td>" + tm.get(i).getdescripcion_mov() + "</td>");

                        }
                        out.println("</tbody");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "TablaPrincipal":

                    int i;
                    out.println("<table class=\"TablaCont\" id=\"TablaReservas\">\n"
                            + "        <thead id=\"CabeceraTabla\">\n"
                            + "                    <td>&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                    <td>"+materiallan+"</td>\n"
                            + "                    <td>"+cantinece+"&nbsp;&nbsp;&nbsp;</td>\n"
                            + "                    <td>"+umedid+"</td>\n"
                            + "                    <td >"+desc+"</td>\n"
                            + "\n"
                            + "        </thead>\n"
                            + "        <tbody>");
                    for (i = 0; i < 1; i++) {
                        out.println("<tr name=\"posi\" >\n"
                                + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"posicion\" value=" + i + " id=\"posicion" + i + "\"></td>\n"
                                + "                <td><input type=\"text\" name=\"material\" maxlength=\"40\" id=\"material" + i + "\" onblur=\"ValMateReserva(" + i + ")\" onclick=\"BtnShow(" + i + ")\" style=\"text-transform: uppercase;\"><button id=\"match_MA" + i + "\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"MatchMaterial('" + i + "')\"></button></td>\n"
                                + "                <td><input type=\"text\" min=\"1\" name=\"cantidad\" id=\"cantidad" + i + "\" onfocus=\"BtnHide()\"  onblur=\"this.value = checkDec(this.value, 3,'" + i + "')\"  onKeyUp=\"this.value = check99(this.value, '999999', 7 ,'" + i + "')\"  ></td>\n"
                                + "                <td><input type=\"text\" name=\"unidadmedida\" maxlength=\"2\" id=\"unidadmedida" + i + "\" disabled style=\"text-transform: uppercase;\"></td>\n"
                                + "                <td style=\"width: 40%;\"><input name=\"descripcion\" maxlength=\"50\" id=\"descripcion" + i + "\" disabled style=\"width: 100%; text-transform: uppercase;\"/></td>\n"
                                + "           </tr>");
                    }
                    out.print("</tbody>"
                            + "          </table>");

                    break;
                case "CarMatRese":
                    //materiales mart = ACC_Material.ObtenerInstancia().CargarDatosReserva(mate, idioma);
                    String denomina = "descripcion_" + idioma;
                    materiales marte = ACC_Material.ObtenerInstancia().MMCargaDatosMatReserva(mate, denomina);
                    if (marte.getDescripcion() == null || marte.getDescripcion().equals("")) {
                        out.println(0);
                    } else {
                        JSONArray js = new JSONArray();
                        js.add(marte.getDescripcion());
                        js.add(marte.getUnidad_medida());
                        out.println(js);
                    }
                    break;
                case "MatchTipoMovReservas":
                    ArrayList<tipo_movimiento> tmr = ACC_TipoMovimientos.ObtenerInstancia().MM_MatchTipoMovimientoReservas();
                    if (tmr.size() > 0) {
                        out.println("<select>");
                        out.println("<option></option>");
                        for (int l = 0; l < tmr.size(); l++) {
                            out.println("<option>" + tmr.get(l).getid_tipo_mov() + " - " + tmr.get(l).getdescripcion_mov() + "</option>");
                        }
                        out.println("</select>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValMaterialAlmacen":
                    if(ACC_Material.ObtenerInstancia().ValidarAlmacenMaterial(mate, al, alre, cen) == 1){
                        out.println(1);
                    }else{
                        out.println(0);
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
