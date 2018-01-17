/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_Centro;
import AccesoDatos.Consultas;
import Entidades.reportes_reservas;
import Entidades.ReporteNotificaciones;
import Entidades.ReporteOrdenes;
import Entidades.ReporteSolPed;
import Entidades.ReporteAvisos;
import Entidades.ReporteMovimientos;
import Entidades.centros;
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

@WebServlet(name = "PeticionVisualizarReportesReservas", urlPatterns = {"/PeticionVisualizarReportesReservas"})
public class PeticionVisualizarReportesReservas extends HttpServlet {

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
 /*Valores Obtenidos por session*/
            HttpSession session = request.getSession();
            String centro = (String) session.getAttribute("CENTRO");
            String sam1 = (String) session.getAttribute("SAM1");
            String sam2 = (String) session.getAttribute("SAM2");
            String sap1 = (String) session.getAttribute("SAP1");
            String sap2 = (String) session.getAttribute("SAP2");
            String fecha1 = (String) session.getAttribute("FECHA1");
            String fecha2 = (String) session.getAttribute("FECHA2");
            String error = (String) session.getAttribute("ERROR");
            String valor = (String) session.getAttribute("VAL");

            /*-----------------------------*/
 /*Valores Accion Switch*/
            String accion = request.getParameter("Action");
            String like;
            String query;
            String tipo = request.getParameter("tipo");
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosam2 = request.getParameter("sam2");
            String foliosap = request.getParameter("sap");
            String foliosap2 = request.getParameter("sap2");
            String fe1 = request.getParameter("fecha1");
            String fe2 = request.getParameter("fecha2");
            String valo = request.getParameter("valor");
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
                    ArrayList<reportes_reservas> res = ACC_Reportes.ObtenerInstancia().MM_Reporte_ReservasValidarQuery(valo, centros, foliosam, foliosam2, foliosap, foliosap2, ff, fff);
                    if (res.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaVacia":                    
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes report = new ACC_Reportes();
                    for (reportes_reservas a : report.SP_RReservas(error, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaCentro":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporCentro = new ACC_Reportes();
                    for (reportes_reservas a : reporCentro.SP_RReservas(error, centro)) {                        
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "RangoSAM":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporDOSSAM = new ACC_Reportes();
                    for (reportes_reservas a : reporDOSSAM.SP_RReservasDOSSAM(error, sam1, sam2)) {                        
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSAM1":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporSAM1 = new ACC_Reportes();
                    for (reportes_reservas a : reporSAM1.SP_RReservasSAM1(error, sam1)) {                        
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "RangosSAP":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporDOSSAP = new ACC_Reportes();
                    for (reportes_reservas a : reporDOSSAP.SP_RReservasDOSSAP(error, sap1, sap2)) {                        
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaSAP1":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporSAP1 = new ACC_Reportes();
                    for (reportes_reservas a : reporSAP1.SP_RReservasSAP1(error, sap1)) {
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "RangosFECHAS":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporDOSFE = new ACC_Reportes();
                    String f1 = cn.DateFormatGuion(fecha1);
                    String f2 = cn.DateFormatGuion(fecha2);
                    for (reportes_reservas a : reporDOSFE.SP_RReservasDOSFE(error, f1, f2)) {                        
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ConsultaFECHA1":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_Reportes reporFE1 = new ACC_Reportes();
                    String f11 = cn.DateFormatGuion(fecha1);
                    for (reportes_reservas a : reporFE1.SP_RReservasFE1(error, f11)) {                        
                        out.println("<tr>");
                        out.println("<td>" + a.getFolio_sap() + "</td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getHora_dia() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000000000000000000</td><td>0000000000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td><td>0000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CentroReserva":
                    ArrayList<centros> ce = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (centros sc : ce) {
                            out.println("<tr>");
                            out.println("<tr ondblclick=\"Select('" + sc.getCentro() + "','centro')\">");
                            out.println("<td>" + sc.getCentro() + "</td>");
                            out.println("<td>" + sc.getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CentroReservaa":
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
                case "SAMreserva":
                    ArrayList<reportes_reservas> sr = ACC_Reportes.ObtenerInstancia().SAMreserva();
                    if (sr.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sr.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + sr.get(i).getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + sr.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAPreserva":
                    ArrayList<reportes_reservas> sapr = ACC_Reportes.ObtenerInstancia().SAPreserva();
                    if (sapr.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sapr.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + sapr.get(i).getFolio_sap() + "','" + tipo + "')\">");
                            out.println("<td>" + sapr.get(i).getFolio_sap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAMnotificaciones":
                    ArrayList<ReporteNotificaciones> sam = ACC_Reportes.ObtenerInstancia().PM_MatchNotSam();
                    if (sam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteNotificaciones m : sam) {
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
                case "SAPnotificaciones":
                    ArrayList<ReporteNotificaciones> not = ACC_Reportes.ObtenerInstancia().PM_MatchReportNotificaciones();
                    if (not.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteNotificaciones n : not) {
                            out.println("<tr ondblclick=\"Select('" + n.getFolio_sap() + "','" + tipo + "')\">");
                            out.println("<td>" + n.getFolio_sap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAMordenes":
                    ArrayList<ReporteOrdenes> o = ACC_Reportes.ObtenerInstancia().SAMordenes();
                    if (o.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < o.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + o.get(i).getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + o.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAPordenes":
                    ArrayList<ReporteOrdenes> sapF = ACC_Reportes.ObtenerInstancia().SAPordenes();
                    if (sapF.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sapF.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + sapF.get(i).getNum_orden() + "','" + tipo + "')\">");
                            out.println("<td>" + sapF.get(i).getNum_orden() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAMsolped":
                    ArrayList<ReporteSolPed> matchsam = ACC_Reportes.ObtenerInstancia().sp_solpedmatchsam();
                    if (matchsam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteSolPed q : matchsam) {
                            out.println("<tr ondblclick=\"Select('" + q.getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + q.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAMReportesolped":
                    ArrayList<ReporteSolPed> matchsa = ACC_Reportes.ObtenerInstancia().sp_reportesolpedmatchsam();
                    if (matchsa.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteSolPed q : matchsa) {
                            out.println("<tr ondblclick=\"Select('" + q.getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + q.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAPsolped":
                    ArrayList<ReporteSolPed> sap = ACC_Reportes.ObtenerInstancia().sp_solpedmatchsap();
                    if (sap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteSolPed r : sap) {
                            out.println("<tr ondblclick=\"Select('" + r.getFolio_sap() + "','" + tipo + "')\">");
                            out.println("<td>" + r.getFolio_sap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAPSolpedcreamatch":
                    ArrayList<ReporteSolPed> rs = ACC_Reportes.ObtenerInstancia().sp_matchsolpedcreasap();
                    if (rs.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteSolPed r : rs) {
                            out.println("<tr ondblclick=\"Select('" + r.getNum_solped() + "','" + tipo + "')\">");
                            out.println("<td>" + r.getNum_solped() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAMavisos":
                    ArrayList<ReporteAvisos> s = ACC_Reportes.ObtenerInstancia().SAMavisos();
                    if (s.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < s.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + s.get(i).getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + s.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAPavisos":
                    ArrayList<ReporteAvisos> sapAvU = ACC_Reportes.ObtenerInstancia().SAPavisos();
                    if (sapAvU.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sapAvU.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + sapAvU.get(i).getNum_notificacion() + "','" + tipo + "')\">");
                            out.println("<td>" + sapAvU.get(i).getNum_notificacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAMmovimientos":
                    ArrayList<ReporteMovimientos> rm = ACC_Reportes.ObtenerInstancia().MM_MatchMovSam();
                    if (rm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteMovimientos u : rm) {
                            out.println("<tr ondblclick=\"Select('" + u.getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + u.getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SAPmovimientos":
                    ArrayList<ReporteMovimientos> sm = ACC_Reportes.ObtenerInstancia().MM_MatchMovSap();
                    if (sm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (ReporteMovimientos v : sm) {
                            out.println("<tr ondblclick=\"Select('" + v.getNum_doc_materila() + "','" + tipo + "')\">");
                            out.println("<td>" + v.getNum_doc_materila() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                //Valida Centro Rep Ordenes
                case "ValidarCentroo":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCentro":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentroNotificaciones(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    if (ACC_Reportes.ObtenerInstancia().ValidarRAvSAM(sam1)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAMRES":
                    if (ACC_Reportes.ObtenerInstancia().ValidarReResSAM(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAPRES":
                    if (ACC_Reportes.ObtenerInstancia().ValidarReResSAP(foliosap)) {
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
