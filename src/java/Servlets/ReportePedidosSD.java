/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_ReportePedidoSD;
import AccesoDatos.Consultas;
import Entidades.centros;
import Entidades.CabMovNotificaciones;
import Entidades.reportes_estatus_ordenes;
import Entidades.Cabecera_PedidosSD;
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
@WebServlet(name = "ReportePedidosSD", urlPatterns = {"/ReportePedidosSD"})
public class ReportePedidosSD extends HttpServlet {

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
            String sam1 = (String) session.getAttribute("SAM1");
            String sam2 = (String) session.getAttribute("SAM2");
            String sap1 = (String) session.getAttribute("SAP1");
            String sap2 = (String) session.getAttribute("SAP2");
            String fecha1 = (String) session.getAttribute("FECHA1");
            String fecha2 = (String) session.getAttribute("FECHA2");
            String cents = (String) session.getAttribute("CENTRO");
            String cents2 = (String) session.getAttribute("CENTRO2");
            String valor = (String) session.getAttribute("ERROR");
            /*----------------------------*/
 /*Valores Accion Switch*/
            String accion = request.getParameter("Action");
            String tipo = request.getParameter("tipo");
            String centros = request.getParameter("centro");
            String centros2 = request.getParameter("centro2");
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
//            "&centro=" + centro + "&centro2=" + centro2 + "&sam1=" + sam1 + "&sam2=" + sam2 + "&Fecha1=" + fecha1 + "&Fecha2=" + fecha2;
//            Parametros Para Cargar La Tabla
            String centroN = request.getParameter("centro");
            String centroN2 = request.getParameter("centro2");
            String docVen = request.getParameter("sam1");
            String docVen2 = request.getParameter("sam2");
            String fech = request.getParameter("Fecha1");
            String fech2 = request.getParameter("Fecha2");
            String tipoRad = request.getParameter("tipoRad");

            //Parametro de Radio Buton 1 con Error y 0 Todos
            String radio = request.getParameter("radio");
            Consultas cn = new Consultas();
            switch (accion) {

                case "CentroStatus":
                    ArrayList<Cabecera_PedidosSD> pt = AccesoDatos.ACC_ReportePedidoSD.ObtenerInstancia().FolioSAMMatch(Centro, Ncentr, Cantid);
                    if (pt.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pt.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pt.get(i).getFolio_sam() + "','" + tipo + "')\">");
                            out.println("<td>" + pt.get(i).getFolio_sam() + "</td>");
                            out.println("<td>" + pt.get(i).getClase_documento() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "SamStatuss":
                    ArrayList<Cabecera_PedidosSD> sam = AccesoDatos.ACC_ReportePedidoSD.ObtenerInstancia().NumDocMatch(folSAM, CentroFol, CtdFol);
                    if (sam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (Cabecera_PedidosSD m : sam) {
                            out.println("<tr ondblclick=\"Select('" + m.getDocumento_ventas() + "','" + tipo + "')\">");
                            out.println("<td>" + m.getDocumento_ventas() + "</td>");
                            out.println("<td>" + m.getClase_documento() + "</td>");
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
                    if (centros2.equals("")) {
                        centros2 = " ";
                    }
                    if (foliosam.equals("")) {
                        foliosam = " ";
                    }
                    if (foliosam2.equals("")) {
                        foliosam2 = " ";
                    }
                    if (fe1.equals("")) {
                        fe1 = " ";
                    }
                    if (fe2.equals("")) {
                        fe2 = " ";
                    }
                    String ff = cn.DateFormatGuion(fe1);
                    String fff = cn.DateFormatGuion(fe2);
                    ArrayList<Cabecera_PedidosSD> ord = AccesoDatos.ACC_ReportePedidoSD.ObtenerInstancia().SD_Reporte_PedidosConsulta(centros, centros2, foliosam, foliosam2, ff, fff, radio);
                    if (ord.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ReporteMovNot":
                    if (centroN.equals("")) {
                        centroN = "";
                    }
                    if (centroN2.equals("")) {
                        centroN2 = "";
                    }
                    if (docVen.equals("")) {
                        docVen = "";
                    }
                    if (docVen2.equals("")) {
                        docVen2 = "";
                    }                    
                    if (fech.equals("")) {
                        fech = "";
                    }
                    if (fech2.equals("")) {
                        fech2 = "";
                    }
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");                   
                    ACC_ReportePedidoSD crp = new ACC_ReportePedidoSD();
                    String f1 = cn.DateFormatGuion(fech);
                    String f2 = cn.DateFormatGuion(fech2);
                    for (Cabecera_PedidosSD a : crp.SD_Reporte_PedidosConsulta(centroN, centroN2, docVen, docVen2, f1, f2, tipoRad)) {
                        out.println("<tr>");
                        out.println("<td></td>");
                        out.println("<td>" + a.getFolio_sam() + "</td>");
                        out.println("<td>" + a.getClase_documento() + "</td>");
                        out.println("<td></td>");
                        out.println("<td>" + a.getGrupo_vendedores() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_creacion()) + "</td>");
                        out.println("<td>" + a.getHora_creacion() + "</td>");
                        out.println("<td>" + a.getRecibido() + "</td>");
                        out.println("<td>" + a.getProcesado() + "</td>");
                        out.println("<td>" + a.getError() + "</td>");                        
                    }
                    out.println("<tr class=\"ocultar\"><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>0000000000000000</td><td>000000000000000000000000</td><td>00000000000000</td><td>00000000000000</td><td>00000000000000000000</td><td>00000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
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
