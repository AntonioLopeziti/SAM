/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.centros;
import Entidades.reportes_estatus_ordenes;
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
 */
@WebServlet(name = "peticionVisualizarReportesEstatusOrdenes", urlPatterns = {"/peticionVisualizarReportesEstatusOrdenes"})
public class peticionVisualizarReportesEstatusOrdenes extends HttpServlet {

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
            /*Valores recibidos por session*/
            HttpSession session = request.getSession();
            String sam1 = (String) session.getAttribute("SAM1");
            String sam2 = (String) session.getAttribute("SAM2");
            String sap1 = (String) session.getAttribute("SAP1");
            String sap2 = (String) session.getAttribute("SAP2");
            String fecha1 = (String) session.getAttribute("FECHA1");
            String fecha2 = (String) session.getAttribute("FECHA2");
            String centro = (String) session.getAttribute("CENTRO");
            String valor = (String) session.getAttribute("ERROR");
            /*----------------------------*/
 /*Valores Accion Switch*/
            String accion = request.getParameter("Action");
            String tipo = request.getParameter("tipo");
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosam2 = request.getParameter("sam2");
            String foliosap = request.getParameter("sap");
            String foliosap2 = request.getParameter("sap2");
            String fe1 = request.getParameter("fecha1");
            String fe2 = request.getParameter("fecha2");
            Consultas cn = new Consultas();

            /*--------------------*/
            switch (accion) {
                case "ValidarQuery":
                    if (centros.equals("")) {
                        centros = " ";
                    }
                    if (foliosam.equals("")) {
                        foliosam = " ";
                    }
                    if (foliosam2.equals("")) {
                        foliosam2 = " ";
                    }
                    if (foliosap.equals("")) {
                        foliosap = " ";
                    }
                    if (foliosap2.equals("")) {
                        foliosap2 = " ";
                    }
                    if (fe1.equals("")) {
                        fe1 = " ";
                    }
                    if (fe2.equals("")) {
                        fe2 = " ";
                    }
                    String ff = cn.DateFormatGuion(fe1);
                    String fff = cn.DateFormatGuion(fe2);
                    ArrayList<reportes_estatus_ordenes> ord = ACC_Reportes.ObtenerInstancia().PM_Reporte_StatusTodos(valor, centros, foliosam, foliosam2, foliosap, foliosap2, ff, fff);
                    if (ord.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaVacia":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes cv = new ACC_Reportes();
                    for (reportes_estatus_ordenes v : cv.DatosStatusVacio(valor)) {
                        out.println("<tr>");
                        out.println("<td>" + v.getFolio_orden() + "</td>");
                        out.println("<td>" + v.getFolio_sam() + "</td>");
                        out.println("<td>" + v.getHora_sistema() + "</td>");
                        out.println("<td>" + cn.DateFormat(v.getFecha_sistema()) + "</td>");
                        out.println("<td>" + v.getNum_orden() + "</td>");
                        out.println("<td>" + v.getOperacion_realizada() + "</td>");
                        out.println("<td>" + v.getIndicador_posicion1() + "</td>");
                        out.println("<td>" + v.getIndicador_posicion2() + "</td>");
                        out.println("<td>" + v.getTexto_mensaje() + "</td>");
                        out.println("<td>" + v.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ReporteStatus":
                    if (centro.equals("")) {
                        centro = " ";
                    }
                    if (sam1.equals("")) {
                        sam1 = " ";
                    }
                    if (sam2.equals("")) {
                        sam2 = " ";
                    }
                    if (sap1.equals("")) {
                        sap1 = " ";
                    }
                    if (sap2.equals("")) {
                        sap2 = " ";
                    }
                    if (fecha1.equals("")) {
                        fecha1 = " ";
                    }
                    if (fecha2.equals("")) {
                        fecha2 = " ";
                    }
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes crp = new ACC_Reportes();
                    String f1 = cn.DateFormatGuion(fecha1);
                    String f2 = cn.DateFormatGuion(fecha2);
                    for (reportes_estatus_ordenes a : crp.PM_Reporte_StatusTodos(valor, centro, sam1, sam2, sap1, sap2, f1, f2)) {
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_orden() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_sistema() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_sistema()) + "</td>");
                        out.println("<td>" + a.getNum_orden() + "</td>");
                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
//                case "ConsultaCentro":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes cc = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : cc.DatosStatusCentro(valor, centro)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "ConsultaSamDerecha":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes tsdrso = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : tsdrso.StatusOrdenSAMDER(valor, sam2, sap1, fecha1, centro)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "ConsultaSAM":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes cm = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : cm.DatosStatusSam(valor, sam1)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "ConsultaSAP":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes cp = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : cp.DatosStatusSap(valor, sap1)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "consultaFECHA":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes cf = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : cf.DatosStatusFecha(valor, fecha1)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "RangoSAM":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes crm = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : crm.DatosStatusRangoSam(valor, sam1, sam2)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "rangoSAP":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes crp = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : crp.DatosStatusRangoSap(valor, sap1, sap2)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "rangosFECHAS":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes crf = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : crf.DatosStatusRangoFecha(valor, fecha1, fecha2)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
//                case "ConsultaTodos":
//                    out.println("<table id=\"TabBody\">");
//                    out.println("<tbody>");
//                    ACC_Reportes CT = new ACC_Reportes();
//                    for (reportes_estatus_ordenes a : CT.DatosStatusTodos(valor, sam1, sap1, fecha1, centro)) {
//                        out.println("<tr>");
//                        out.println("<td>" + a.getFolio_orden() + "</td>");
//                        out.println("<td>" + a.getFolio_sam() + "</td>");
//                        out.println("<td>" + a.getHora_sistema() + "</td>");
//                        out.println("<td>" + a.getFecha_sistema() + "</td>");
//                        out.println("<td>" + a.getNum_orden() + "</td>");
//                        out.println("<td>" + a.getOperacion_realizada() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion1() + "</td>");
//                        out.println("<td>" + a.getIndicador_posicion2() + "</td>");
//                        out.println("<td>" + a.getTexto_mensaje() + "</td>");
//                        out.println("<td>" + a.getCentro() + "</td>");
//                    }
//                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
//                    out.println("</tbody>");
//                    out.println("</table>");
//                    break;
                case "CentroStatus":
                    ArrayList<centros> pt = ACC_Centro.ObtenerInstancia().CentroReservass();
                    if (pt.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pt.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pt.get(i).getCentro() + "','centro')\">");
                            out.println("<td>" + pt.get(i).getCentro() + "</td>");
                            out.println("<td>" + pt.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SamStatus":
                    ArrayList<reportes_estatus_ordenes> sam = ACC_Reportes.ObtenerInstancia().SAMStatus();
                    if (sam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reportes_estatus_ordenes m : sam) {
                            out.println("<tr ondblclick=\"Select('" + m.getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + m.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SapStatus":
                    ArrayList<reportes_estatus_ordenes> sap = ACC_Reportes.ObtenerInstancia().SAPStatus();
                    if (sap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (reportes_estatus_ordenes n : sap) {
                            out.println("<tr ondblclick=\"Select('" + n.getFolio_orden() + "','" + tipo + "')\">");
                            out.println("<td>" + n.getFolio_orden() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCentro":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM2":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSamStatus(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP2":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSaPStatus(foliosap)) {
                        out.println(1);
                    } else {
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
