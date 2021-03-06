/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_FlujoDocumentos;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_ReportePedidoSD;
import AccesoDatos.Consultas;
import Entidades.centros;
import Entidades.CabMovNotificaciones;
import Entidades.FlujoDocumentos;
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
@WebServlet(name = "PeticionVisualizarReportesFlujoDocs", urlPatterns = {"/PeticionVisualizarReportesFlujoDocs"})
public class PeticionVisualizarReportesFlujoDocs extends HttpServlet {

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
//            String sam1 = (String) session.getAttribute("SAM1");
//            String sam2 = (String) session.getAttribute("SAM2");
//            String sap1 = (String) session.getAttribute("SAP1");
//            String sap2 = (String) session.getAttribute("SAP2");
//            String fecha1 = (String) session.getAttribute("FECHA1");
//            String fecha2 = (String) session.getAttribute("FECHA2");
//            String cents = (String) session.getAttribute("CENTRO");
//            String cents2 = (String) session.getAttribute("CENTRO2");
//            String valor = (String) session.getAttribute("ERROR");
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
//            Parametros Para Cargar La Tabla
            String centroN = request.getParameter("centro");
            String centroN2 = request.getParameter("centro2");
            String docVen = request.getParameter("sam1");
            String docVen2 = request.getParameter("sam2");
            String mate = request.getParameter("sap1");
            String mate2 = request.getParameter("sap2");
            String fech = request.getParameter("Fecha1");
            String fech2 = request.getParameter("Fecha2");
            String tipoRad = request.getParameter("tipoRad");
            
            ///// Parametros Nuevo
            String Cliente  = request.getParameter("Cliente");
            String DClient  = request.getParameter("DCliente");
            String Cantida  = request.getParameter("Cantidad");
            String Materia  = request.getParameter("Material");
            String DMateri  = request.getParameter("DMaterial");

            //Parametro de Radio Buton 1 con Error y 0 Todos
            String radio = request.getParameter("radio");
            Consultas cn = new Consultas();
            switch (accion) {
                case "CargarSolicitante":
                    ArrayList<FlujoDocumentos> pt = AccesoDatos.ACC_FlujoDocumentos.ObtenerInstancia().MatchSolicitante(Cliente, DClient, Cantida);
                    if (pt.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pt.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pt.get(i).getSolicitante() + "','" + tipo + "')\">");
                            out.println("<td style=\"width:20%;\">" + pt.get(i).getSolicitante() + "</td>");
                            out.println("<td style=\"width:80%; text-align: left;\">" + pt.get(i).getCentro_solic() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarPedidos":
                    ArrayList<FlujoDocumentos> sam = AccesoDatos.ACC_FlujoDocumentos.ObtenerInstancia().MatchDocVentas();
                    if (sam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (FlujoDocumentos m : sam) {
                            out.println("<tr ondblclick=\"Select('" + m.getDoc_ventas() + "','" + tipo + "')\">");
                            out.println("<td>" + m.getNum_doc_ref() + "</td>");
                            out.println("<td>" + m.getDoc_ventas() + "</td>");
                            out.println("<td>" + m.getSolicitante() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarMateriales":
                    ArrayList<FlujoDocumentos> sap = AccesoDatos.ACC_FlujoDocumentos.ObtenerInstancia().MatchMaterial(Materia, DMateri, Cantida);
                    if (sap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (FlujoDocumentos n : sap) {
                            out.println("<tr ondblclick=\"Select('" + n.getNum_material() + "','" + tipo + "')\">");
                            out.println("<td style=\"width:20%;\">" + n.getNum_material() + "</td>");
                            out.println("<td style=\"width:80%; text-align: left;\">" + n.getCentro() + "</td>");
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
                    ArrayList<FlujoDocumentos> ord = AccesoDatos.ACC_FlujoDocumentos.ObtenerInstancia().SD_EjecutarConsultaFlujoDocs(centros, centros2, foliosam, foliosam2, foliosap, foliosap2, ff, fff);
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
                    if (mate.equals("")) {
                        mate = "";
                    }
                    if (mate2.equals("")) {
                        mate2 = "";
                    }
                    if (fech.equals("")) {
                        fech = "";
                    }
                    if (fech2.equals("")) {
                        fech2 = "";
                    }
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_FlujoDocumentos crp = new ACC_FlujoDocumentos();
                    String f1 = cn.DateFormatGuion(fech);
                    String f2 = cn.DateFormatGuion(fech2);
                    for (FlujoDocumentos a : crp.SD_EjecutarConsultaFlujoDocs(centroN, centroN2, docVen, docVen2, mate, mate2, f1, f2)) {
                        out.println("<tr>");
//                        out.println("<td>" + a.getSolicitante() + "</td>");
                        out.println("<td>" + a.getDenominacion_cliente() + "</td>");  //// Den. cliente
//                        out.println("<td>" + a.getDoc_ventas() + "</td>");
                        out.println("<td>" + a.getNum_doc_ref() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_pedido()) + "</td>");  //// Fecha Pedido
                        out.println("<td>" + a.getRefer_cliente() + "</td>");
                        out.println("<td>" + a.getPos_doc_ventas() + "</td>");
//                        out.println("<td>" + a.getNum_material() + "</td>");
                        out.println("<td>" + a.getTxt_breve_pos_ped() + "</td>");
                        out.println("<td>" + a.getVal_neto_pos_ped() + "</td>");
                        out.println("<td>" + a.getUm_cant_prev() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_ini()) + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_fin()) + "</td>");
                        out.println("<td>" + a.getCant_ent_efec() + "</td>");
                        out.println("<td>" + a.getNum_doc_comercial4()+ "</td>");
                        out.println("<td>" + cn.DateFormat(a.getMaterial_introd()) + " </td>"); //// Fecha Factura
                        out.println("<td>" + cn.DateFormat(a.getFecha_carga()) + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_planif_trans()) + "</td>");
                        out.println("<td>" + a.getDoc_ventas() + "</td>");
                        out.println("</tr>");
                       
                    }
                    out.println("<tr class=\"ocultar\">"
                            //+ "<td>0000000000</td>"  //// Cliente
                            + "<td>000000000000000000000000000000000000000000000000</td>" //// Den Cliente
//                            + "<td>000000000000000</td>" //// Doc Ventas
                            + "<td>000000000000000</td>" //// Folio SAM
                            + "<td>000000000000000</td>" //// Fecha pedido
                            + "<td>00000000000000000000000000000000000000000</td>" //// Refer. Cliente
                            + "<td>000000000</td>" //// Pos 
//                            + "<td>000000000000000000000</td>" //// Material
                            + "<td>00000000000000000000000000000000000000000</td>"  //// Den material
                            + "<td>00000000000000000000</td>" //// Cantidad pedido
                            + "<td>000000000</td>" //// Unidad Medida
                            + "<td>000000000000000</td>" //// Fecha Inicio
                            + "<td>000000000000000</td>" //// Fecha fin
                            + "<td>00000000000000000000</td>" //// Cant entregada
                            + "<td>00000000000000000000000</td>" //// Factura
                            + "<td>000000000000000</td>" //// Fecha factura
                            + "<td>000000000000000</td>" //// Fecha carga
                            + "<td>000000000000000</td>" //// Fecha Plan trans
                            + "<td>000000000000000</td>" //// Pedido SAP
                            + "</tr>");
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
