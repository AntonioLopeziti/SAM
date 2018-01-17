/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Ordenes_pp_notificaciones;
import AccesoDatos.ACC_Pp_operaciones_noti;
import AccesoDatos.ACC_BOMEquipos;
import AccesoDatos.ACC_Folios;
import Entidades.ordenes_pp_notificaciones;
import Entidades.pp_operaciones_noti;
import Entidades.ListaMtrl;
import Entidades.folios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jhonatan
 */
@WebServlet(name = "PeticionNotificacionesOrdenesSAMPP", urlPatterns = {"/PeticionNotificacionesOrdenesSAMPP"})
public class PeticionNotificacionesOrdenesSAMPP extends HttpServlet {

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
            HttpSession session = request.getSession();
            String Idioma = (String) session.getAttribute("Idioma");
            String ord = request.getParameter("ord");
            String acc = request.getParameter("acc");

            //PeticionOperacion
            //String ord = request.getParameter("ord");
            String oper = request.getParameter("oper");
            //LlenarTabMax
            String ope = request.getParameter("ope");
            //Lista de Materiales
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            //Liberar Ordenes
            String operacion = request.getParameter("ope");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String orden = request.getParameter("ord");
            String stats = request.getParameter("stat");
            String usu = request.getParameter("usu");
            String notlote22 = request.getParameter("notlote22");
            String matera = request.getParameter("matw");
            String centr = request.getParameter("centr");
            String mat = request.getParameter("mat");
            String lot = request.getParameter("lot");
            String eq = request.getParameter("eq");
            String ulm = request.getParameter("ulm");
            String fol = "ES";
            switch (acc) {
                case "checarOrden":
                    if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().COMPORdenNOTPP(ord) == true) {
                        out.println(0);
                    } else if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().COMPFOLORdenNOTPP(ord) == true) {
                        out.println(2);
                    } else {
                        out.println(1);
                    }
                    break;
                case "ChecarStatusOrdenOpe":
                    ordenes_pp_notificaciones pl = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtenStatusCNPMNOTPP(ord);
                    out.println("<input type='text' id ='nosta' value='" + pl.getStatus() + "' />");
                    break;
                case "LlenarTabMax":
                    LinkedList<pp_operaciones_noti> tb = ACC_Pp_operaciones_noti.ObtenerInstancia().TABGRNOTPMNotPP(ord, ope);
                    String checa = "";
                    String checa1 = "";
                    for (int i = 0; i < tb.size(); i++) {
                        String val = tb.get(i).getIndicador_valor_prede_traba_relevante();
                        String val2 = tb.get(i).getId_objeto_recurso();
                        if ("X".equals(val)) {
                            checa = "checked";
                        } else {
                            checa = "";
                        }
                        if ("X".equals(val2)) {
                            checa1 = "checked";
                        } else {
                            checa1 = "";
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
                        out.println("<td>" + tb.get(i).getDuracion_operacion_normal() + "</td>");
                        out.println("<td>" + tb.get(i).getActividad_ya_notificada01() + "</td>");
                        out.println("<td>" + tb.get(i).getUnidad_duracion_normal() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr><td><input type=\"radio\" class=\"che\" id=\"checkbox3\" name=\"checkbo\" value=\"val4\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox4\" name=\"checkbo\" value=\"val5\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    <tr><td><input type=\"radio\" class=\"che\" id=\"checkbox5\" name=\"checkbo\" value=\"val6\"/></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td> <td>&nbsp;</td></tr>\n"
                            + "                                                    ");
                    break;
                case "ListaMaterialNotificacionesC":
                    int v = 0;
                    ArrayList<ListaMtrl> lm = ACC_BOMEquipos.ObtenerInstancia().ObtenerLMNotificacionesCreaPP(v1, v2);
                    out.println("<table id=\"TabBody3\">\n"
                            + "<tbody>");
                    for (ListaMtrl p : lm) {
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" name=\"CKlmNotiC\" value=\""+ v + "\"></td>"
                                + "<td name=\"lm1\" id=\"ll1" + v + "\">" + p.getMaterial() + "</td>"
                                + "<td name=\"lm2\" id=\"ll2" + v + "\">" + p.getPiezaFabricante() + "</td>"
                                + "<td name=\"lm3\" id=\"ll3" + v + "\">" + p.getDescripcion() + "</td>"
                                + "<td name=\"lm4\" id=\"ll4" + v + "\">" + p.getLote() + "</td>"
                                + "<td name=\"lm5\" id=\"ll5" + v + "\">" + p.getStock() + "</td>"
                                + "<td name=\"lm7\" id=\"ll7" + v + "\" hidden>" + p.getCentro()+ "</td>"
                                + "<td name=\"lm8\" id=\"ll8" + v + "\" hidden>" + p.getAlmacen()+ "</td>"
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
                case "DatosCab":
                    ordenes_pp_notificaciones opm = ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ObtStatusCNPP(ord);
                    folios folSAM = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios(fol);
                    int NEfol = folSAM.getFolioActual();
                    ///////////////////////////////
                    String fsam1 = "ES" + folSAM.getFolioActual();
                    String condi = "ES";
                    if (ACC_Pp_operaciones_noti.ObtenerInstancia().InsertStatus_notificacionessapPP(fsam1, fecha, hora, stats, orden, opm.getCentro(), usu) == true) {
                        if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().ordpmnotiActualPP(operacion, orden) == true) {
                            if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT(condi, NEfol) == true) {
                                out.println(0);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(1);
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
