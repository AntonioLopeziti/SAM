/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Cabecera_ordenes_crea;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Stock;
import Entidades.cabecera_ordenes_crea;
import Entidades.equipos;
import Entidades.materiales_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import Entidades.servicios_ordenes_crea;
import Entidades.stock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionSAMNotificacionesPM", urlPatterns = {"/peticionSAMNotificacionesPM"})
public class peticionSAMNotificacionesPM extends HttpServlet {

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
            String Idioma = (String) session.getAttribute("Idioma");
            String ord = request.getParameter("ord");
            String ope = request.getParameter("ope");
            String accion = request.getParameter("act");

            switch (accion) {
                case "CarTAbUN":
                    String checa = "";
                    LinkedList<operaciones_ordenes_crea> tb = ACC_Orden.ObtenerInstancia().cargartablaoperacionescreaNOTI(ord, ope);
                    for (int i = 0; i < tb.size(); i++) {
                        String val = tb.get(i).getIndicador_valor_predeterminado_trabajo_relevante();
                        if ("X".equals(val)) {
                            checa = "checked";
                        } else {
                            checa = "";
                        }
                        out.println("<tr>");
                        out.println("<td> <input type=\"radio\" class=\"che\" value='" + tb.get(i).getClave_control() + "," + tb.get(i).getNum_operacion() + "," + tb.get(i).getCentro() + "'  name=\"checkbo\" /></td>");
                        out.println("<td><input type=\"checkbox\" id='nf" + i + "'  name=\"che\" " + checa + " disabled  /></td>");
                        out.println("<td>" + tb.get(i).getNum_operacion() + "</td>");
                        out.println("<td>" + tb.get(i).getClave_control() + "</td>");
                        out.println("<td>" + tb.get(i).getId_objeto_recurso() + "</td>");
                        out.println("<td name=\"cntx\">" + tb.get(i).getCentro() + "</td>");
                        out.println("<td>" + tb.get(i).getTexto_breve_operacion() + "</td>");
                        out.println("<td>" + tb.get(i).getCantidad_base() + "</td>");
//                    out.println("<td>"+tb.get(i).getUnidad_medida_operacion()+"</td>");
                        out.println("<td>" + tb.get(i).getDuracion_operacion() + "</td>");
                        out.println("<td>" + tb.get(i).getActividad_ya_notificada1() + "</td>");
                        out.println("<td>" + tb.get(i).getUnidad_duracion_normal() + "</td>");
//                    out.println("<td>"+tb.get(i).getTrabajo_operacion()+"</td>");
//                    out.println("<td>"+tb.get(i).getActividad_ya_notificada2()+"</td>");
//                    out.println("<td>"+tb.get(i).getUnidad_trabajo()+"</td>");
//                    out.println("<td>"+tb.get(i).getUnidad_medida_actividad_notificar1()+"</td>");
//                    out.println("<td>"+tb.get(i).getUnidad_medida_actividad_notificar2()+"</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr><td><input type=\"radio\" class=\"che\" id=\"checkbox3\" name=\"checkbo\" value=\"val4\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox4\" name=\"checkbo\" value=\"val5\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox5\" name=\"checkbo\" value=\"val6\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    ");
                    break;
                case "POn1P3SAM":
                    operaciones_ordenes_crea eq = ACC_Orden.ObtenerInstancia().cartabopecrP3(ord, ope);

                    out.println("<input type'text' id='nspp32' value='' />");
                    out.println("<input type'text' id='npspp32' value='" + eq.getNum_posicion_solped__orden() + "' />");
                    out.println("<input type'text' id='prep32' value='" + eq.getPrecio() + "' />");
                    out.println("<input type'text' id='clmop32' value='" + eq.getClave_moneda() + "' />");
                    out.println("<input type'text' id='cabap32' value='" + eq.getCantidad_base2() + "' />");
                    out.println("<input type'text' id='grarp32' value='" + eq.getGrupo_articulos() + "' />");
                    out.println("<input type'text' id='gcate32' value='" + eq.getGrupo_compras_actividad_trabajo_externa() + "' />");
                    out.println("<input type'text' id='ocop32' value='" + eq.getOrganizacion_compras() + "' />");
                    out.println("<input type'text' id='provp32' value='" + eq.getNum_cuenta_proveedor() + "' />");
                    out.println("<input type'text' id='solp32' value='" + eq.getSolicitante() + "' />");
                    break;
                case "POn2P3SAM":
                    LinkedList<servicios_ordenes_crea> tn = ACC_Orden.ObtenerInstancia().COnsuTAMNOPM023(ord);

                    for (int i = 0; i < tn.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + tn.get(i).getNum_linea() + "</td>");
                        out.println("<td>" + tn.get(i).getNum_servicio() + "</td>");
                        out.println("<td>" + tn.get(i).getTexto_breve() + "</td>");
                        out.println("<td>" + tn.get(i).getCantidad_con_signo() + "</td>");
                        out.println("<td>" + tn.get(i).getUnidad_medida_base() + "</td>");
                        out.println("<td>" + tn.get(i).getValor_neto_posicion() + "</td>");
                        out.println("<td>" + tn.get(i).getCantidad_base() + "</td>");
                        out.println("<td>" + tn.get(i).getGrupo_articulos() + "</td>");
                        out.println("<td>" + tn.get(i).getClase_coste() + "</td>");
                        out.println("</tr>");
                    }

                    break;
                case "POn3P3SAM":
                    LinkedList<servicios_ordenes_crea> ton = ACC_Orden.ObtenerInstancia().COnsuTAMNOPM023(ord);
                    out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                        <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\n"
                            + "                               ");
//           for(int i = 0; i < ton.size(); i++){
//                    out.println("<tr>");
//                    out.println("<td>"+ton.get(i).getNum_condicion_doc()+"</td>");
//                    out.println("<td>"+ton.get(i).getNum_doc()+"</td>");
//                    out.println("<td>"+ton.get(i).getIndicador_doc_anulado()+"</td>");
//                    out.println("<td>"+ton.get(i).getTexto_breve()+"</td>");
//                    out.println("<td>"+ton.get(i).getClase_coste()+"</td>");
//                    out.println("<td>"+ton.get(i).getFuncion()+"</td>");
//                    out.println("<td>"+ton.get(i).getCc_nomina()+"</td>");
//                    out.println("<td>"+ton.get(i).getModificacion_texto_explicativo()+"</td>");
//                    out.println("<td>"+ton.get(i).getCantidad_base()+"</td>");
//                    out.println("<td>"+ton.get(i).getUnidad_medida_base()+"</td>");
//                    out.println("<td>"+ton.get(i).getCasilla_seleccion()+"</td>");
//                    out.println("</tr>");
//           }
                    break;
                case "CabePM1":
                    operaciones_ordenes_crea equi = ACC_Orden.ObtenerInstancia().cargartablaNOoperacionescreaP3(ord, ope);
                    out.println("<input type'text' id='nspp12' value='" + ord + "' />");
                    out.println("<input type'text' id='npspp12' value='" + ope + "' />");
                    out.println("<input type'text' id='txbp12' value='" + equi.getTexto_breve_operacion() + "' />");
                    out.println("<input type'text' id='canbap12' value='" + equi.getCantidad_base() + "' />");
                    out.println("<input type'text' id='umpp12' value='" + equi.getUnidad_medida_operacion() + "' />");
                    out.println("<input type'text' maxlength=\"1\" id='ivptp12' value='" + equi.getIndicador_valor_predeterminado_trabajo_relevante() + "' />");
                    out.println("<input type'text' id='donp12' value='" + equi.getDuracion_operacion() + "' />");
                    out.println("<input type'text' id='udnp12' value='" + equi.getUnidad_duracion_normal() + "' />");
                    out.println("<input type'text' id='top12' value='" + equi.getTrabajo_operacion() + "' />");
                    out.println("<input type'text' id='utp12' value='" + equi.getUnidad_trabajo() + "' />");
                    out.println("<input type'text' id='aynp12' value='" + equi.getActividad_ya_notificada1() + "' />");
                    out.println("<input type'text' id='ayn2p12' value='" + equi.getActividad_ya_notificada2() + "' />");
                    break;
                case "TablasPM01MAt":
                    LinkedList<materiales_ordenes_crea> tno = ACC_Orden.ObtenerInstancia().MostraTABPM01NO(ord, ope);
                    if (tno.size() == 0) {
                        for (int l = 0; l < 50; l++) {
                            out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><div style='width:195px;'><input type='text' name='arre' id=\"matab1" + l + "\" onclick=\"mosbot('" + l + "');\"/><button id=\"matmat1" + l + "\" onclick=\"VentModalmat('matab1" + l + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td><td><div style='width:195px;'><input type='text' id=\"lotabp1" + l + "\" onclick=\"mosbotLot('" + l + "');\" /><button id=\"matlot1" + l + "\" onclick=\"VentModalLote('" + l + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td><td><input type='number' min='0' id=\"cumtabp1" + l + "\" name=\"cumtabp1\" /></td><td>&nbsp;</td><td>&nbsp;</td><td id=\"cein" + l + "\">&nbsp;</td><td id=\"unmin" + l + "\">&nbsp;</td><td id=\"almin" + l + "\" >&nbsp;</td><td id=\"Texde" + l + "\">&nbsp;</td></tr>");
                        }
                    } else {
                        for (int i = 0; i < tno.size(); i++) {
                            out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td>" + tno.get(i).getNum_reserva() + "</td>");
                            out.println("<td>" + tno.get(i).getNum_posicion_reserva() + "</td>");
                            out.println("<td><div style='width:195px;'><input type = 'text' id=\"matab1" + i + "\" onclick=\"mosbot('" + i + "');\" value=\"" + tno.get(i).getNum_material() + "\" /><button id=\"matmat1" + i + "\" onclick=\"VentModalmat('matab1" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td>");
                            out.println("<td><div style='width:195px;'><input type = 'text' id=\"lotabp1" + i + "\"  value=\"" + tno.get(i).getLote() + "\"' onclick=\"mosbotLot('" + i + "');\" /><button id=\"matlot1" + i + "\" onclick=\"VentModalLote('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td>");
                            out.println("<td><input type = 'number' id=\"cumtabp1" + i + "\" min='0' value=\"" + tno.get(i).getUnidad_medida_componente_pieza_bruto() + "\" name=\"cumtabp1\" /></td>");
                            out.println("<td>" + tno.get(i).getCantidad_necesaria_componente2() + "</td>");
                            out.println("<td>" + tno.get(i).getCantidad_base() + "</td>");
                            out.println("<td id=\"cein" + i + "\">" + tno.get(i).getCentro() + "</td>");
                            out.println("<td id=\"unmin" + i + "\" >" + tno.get(i).getUnidad_medida_base() + "</td>");
                            out.println("<td id=\"almin" + i + "\">" + tno.get(i).getAlmacen() + "</td>");
                            out.println("<td id=\"Texde" + i + "\">" + tno.get(i).getTexto_posicion_lista_materiales() + "</td>");
                            out.println("</tr>");
                        }

                        for (int la = 49; la >= tno.size(); la--) {

                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td><div style='width:195px;'><input type = 'text' id=\"matab1" + la + "\" onclick=\"mosbot('" + la + "');\"  /><button id=\"matmat1" + la + "\" onclick=\"VentModalmat('matab1" + la + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td>");
                            out.println("<td><div style='width:195px;'><input type='text' id=\"lotabp1" + la + "\" onclick=\"mosbotLot('" + la + "');\" /><button id=\"matlot1" + la + "\" onclick=\"VentModalLote('" + la + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td>");
                            out.println("<td><input type = 'number' id=\"cumtabp1" + la + "\" min='0' name=\"cumtabp1\" /></td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td id=\"cein" + la + "\">&nbsp;</td>");
                            out.println("<td id=\"unmin" + la + "\">&nbsp;</td>");
                            out.println("<td id=\"almin" + la + "\">&nbsp;</td>");
                            out.println("<td id=\"Texde" + la + "\">&nbsp;</td>");
                            out.println("</tr>");
                        }

                    }

                    break;
                case "CarLotes":
                    String mate = request.getParameter("mate");
                    LinkedList<stock> lot = ACC_Stock.ObtenerInstancia().ConsultaStockLotesNOT(mate);
                    out.println("<table>");
                    out.println("<tbody>");
                    for (int pe = 0; pe < lot.size(); pe++) {
                        out.println("<tr ondblclick=\"seleccionar('" + lot.get(pe).getLote() + "','" + ord + "','" + ope + "')\">");
                        out.println("<td>" + lot.get(pe).getLote() + "</td>");
                        out.println("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lot.get(pe).getStocklibre_utilizacion() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CarLotesEQ":
                    String mateeq = request.getParameter("mate");
                    LinkedList<stock> loteq = ACC_Stock.ObtenerInstancia().ConsultaStockLotesEQ(mateeq);
                    out.println("<table>");
                    out.println("<tbody>");
                    for (int pe = 0; pe < loteq.size(); pe++) {
                        out.println("<tr ondblclick=\"seleccionar('" + loteq.get(pe).getLote() + "','" + ord + "','" + ope + "')\">");
                        out.println("<td>" + loteq.get(pe).getLote() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CarLotesEQ2":
                    String matera = request.getParameter("mate");
                    LinkedList<stock> lote2 = ACC_Stock.ObtenerInstancia().ConsultaStockLotesEQ(matera);
                    if (lote2.size() > 0) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "CarLotes2":
                    String mater = request.getParameter("mate");
                    LinkedList<stock> lot2 = ACC_Stock.ObtenerInstancia().ConsultaStockLotesNOT(mater);
                    if (lot2.size() > 0) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "CarEQORD":
                    cabecera_ordenes_crea eqi = ACC_Cabecera_ordenes_crea.ObtenerInstancia().CargarDataCab(ord);
                    String ewq = eqi.getNum_equipo();
                    equipos eqpo = ACC_Equipos.ObtenerInstancia().CargarDMEquiposNOT(ewq, Idioma);
                    String ewqq = eqi.getEstatus();
                    out.println("<input type'text' id='Statusor' value='" + ewqq + "' />");
                    out.println("<input type'text' id='almno' value='" + eqpo.getAlmacen() + "' />");
                    out.println("<input type'text' id='cenno' value='" + eqpo.getCentro() + "' />");
                    out.println("<input type'text' id='eqsuno' value='" + eqpo.getEquipo_superior() + "' />");
                    out.println("<input type'text' id='lotno' value='" + eqpo.getLote() + "' />");
                    out.println("<input type'text' id='matno' value='" + eqpo.getMaterial() + "' />");
                    out.println("<input type'text' id='neqno' value='" + ewq + "' />");
                    out.println("<input type'text' id='seno' value='" + eqpo.getSerie() + "' />");
                    out.println("<input type'text' id='desne' value='" + eqpo.getDescripcion_equipo() + "' />");
                    break;

                default:
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
