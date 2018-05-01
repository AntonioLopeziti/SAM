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
import Entidades.CabMovNotificaciones;
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
 * @author Jhonatan
 */
@WebServlet(name = "PeticionVisualizarReportesMovNot", urlPatterns = {"/PeticionVisualizarReportesMovNot"})
public class PeticionVisualizarReportesMovNot extends HttpServlet {

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
            //Match
            String Cantid = request.getParameter("Ctd");
            String Centro = request.getParameter("Centro");
            String Ncentr = request.getParameter("CentroNom");
            
            String folSAM = request.getParameter("folSAM");
            String CentroFol = request.getParameter("CentroFol");
            String CtdFol = request.getParameter("CtdFol");   
            
            String folOrd = request.getParameter("folOrd");
            String CentroOrd = request.getParameter("CentroOrd");
            String CtdOrd = request.getParameter("CtdOrd");                     
            Consultas cn = new Consultas();
            switch (accion) {
                
                case "CentroStatus":
                    ArrayList<centros> pt = ACC_Centro.ObtenerInstancia().CentroReservasFiltros(Centro, Ncentr, Cantid);
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
                case "SamStatuss":
                    ArrayList<CabMovNotificaciones> sam = ACC_Reportes.ObtenerInstancia().SAMStatusMN(folSAM,CentroFol, CtdFol);
                    if (sam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (CabMovNotificaciones m : sam) {
                            out.println("<tr ondblclick=\"Select('" + m.getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + m.getFolio_sam() + "</td>");
                            out.println("<td>" + m.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SapStatus":
                    ArrayList<CabMovNotificaciones> sap = ACC_Reportes.ObtenerInstancia().SAPStatusMN(folOrd, CentroOrd, CtdOrd);
                    if (sap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (CabMovNotificaciones n : sap) {
                            out.println("<tr ondblclick=\"Select('" + n.getNum_orden() + "','" + tipo + "')\">");
                            out.println("<td>" + n.getNum_orden() + "</td>");
                            out.println("<td>" + n.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
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
                    ArrayList<CabMovNotificaciones> ord = ACC_Reportes.ObtenerInstancia().PP_Reporte_StatusTodosMN(centros, foliosam, foliosam2, foliosap, foliosap2, ff, fff);
                    if (ord.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCentroo":
                    if (ACC_Reportes.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM22":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSamStatusMN(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP22":
                    if (ACC_Reportes.ObtenerInstancia().ValidarSaPStatusMN(foliosap)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ReporteMovNot":
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
                    for (CabMovNotificaciones a : crp.PP_Reporte_StatusTodosMN(centro, sam1, sam2, sap1, sap2, f1, f2)) {
                        out.println("<tr>");                        
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getNum_material() + "</td>");                                                
                        out.println("<td>" + cn.DateFormat(a.getFecha()) + "</td>");
                        out.println("<td>" + a.getHora() + "</td>");
                        out.println("<td>" + a.getNum_orden() + "</td>");
                        out.println("<td>" + a.getCentro() + "</td>");
                        out.println("<td>" + a.getAlmacen() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");
                        out.println("<td>" + a.getUsuario() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>00000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                    
//                    or.setFolio_sam(rs.getString("folio_sam"));
//                or.setHora(rs.getString("hora"));
//                or.setFecha(rs.getString("fecha"));
//                or.setNum_orden(rs.getString("num_orden"));
//                or.setNum_material(rs.getString("num_material"));                        
//                or.setCentro(rs.getString("centro"));
//                or.setAlmacen(rs.getString("almacen"));
//                or.setError(rs.getString("error"));
//                or.setUsuario(rs.getString("usuario"));
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
