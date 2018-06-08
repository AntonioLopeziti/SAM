/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_FlujoDeudoresSD;
import AccesoDatos.Consultas;
import Entidades.centros;
import Entidades.FlujoDeudoresSD;
import Entidades.CabMovNotificaciones;
import Entidades.reportes_estatus_ordenes;
import Entidades.Cabecera_PedidosSD;
import Entidades.ClientesPedidoSDCrea;
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
@WebServlet(name = "PeticionFlujoDeudoresSD", urlPatterns = {"/PeticionFlujoDeudoresSD"})
public class PeticionFlujoDeudoresSD extends HttpServlet {

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
            String vendedor = request.getParameter("vendedor");
            String factura = request.getParameter("factura");
            String clienteUno = request.getParameter("clienteUno");
            String clienteDos = request.getParameter("clienteDos");
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
            String vendedorN = request.getParameter("vendedor");
            String facturaN = request.getParameter("factura");
            String cliUnoN = request.getParameter("cliUno");
            String cliDosN = request.getParameter("cliDos");
            String fech = request.getParameter("Fecha1");
            String fech2 = request.getParameter("Fecha2");

            Consultas cn = new Consultas();

            switch (accion) {
                case "ValidarQuery":
                    if (vendedor.equals("")) {
                        vendedor = " ";
                    }
                    if (factura.equals("")) {
                        factura = " ";
                    }
                    if (clienteUno.equals("")) {
                        clienteUno = " ";
                    }
                    if (clienteDos.equals("")) {
                        clienteDos = " ";
                    }
                    if (fe1.equals("")) {
                        fe1 = " ";
                    }
                    if (fe2.equals("")) {
                        fe2 = " ";
                    }
                    String ff = cn.DateFormatGuion(fe1);
                    String fff = cn.DateFormatGuion(fe2);
                    ArrayList<FlujoDeudoresSD> ord = AccesoDatos.ACC_FlujoDeudoresSD.ObtenerInstancia().SD_Reporte_FLujoDocsConsulta(vendedor, factura, clienteUno, clienteDos, ff, fff);
                    if (ord.size() >= 1) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ReporteMovNot":
                    if (vendedorN.equals("")) {
                        vendedorN = "";
                    }
                    if (facturaN.equals("")) {
                        facturaN = "";
                    }
                    if (cliUnoN.equals("")) {
                        cliUnoN = "";
                    }
                    if (cliDosN.equals("")) {
                        cliDosN = "";
                    }
                    if (fech.equals("")) {
                        fech = "";
                    }
                    if (fech2.equals("")) {
                        fech2 = "";
                    }
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ACC_FlujoDeudoresSD crp = new ACC_FlujoDeudoresSD();
                    String f1 = cn.DateFormatGuion(fech);
                    String f2 = cn.DateFormatGuion(fech2);
                    for (FlujoDeudoresSD a : crp.SD_Reporte_FLujoDocsConsulta(vendedorN, facturaN, cliUnoN, cliDosN, f1, f2)) {
                        out.println("<tr>");
                        out.println("<td>" + a.getEjercicio() + "</td>");
                        out.println("<td>" + a.getMes_contable() + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_contable()) + "</td>");
                        out.println("<td>" + cn.DateFormat(a.getFecha_vencimiento()) + "</td>");
                        out.println("<td>" + a.getDias_vencimiento() + "</td>");
                        out.println("<td>" + a.getFactura() + "</td>");
                        out.println("<td>" + a.getImporte() + "</td>");
                        out.println("<td>" + a.getMoneda() + "</td>");
                        out.println("<td>" + a.getCliente() + "</td>");
                        out.println("<td>" + a.getNombre_cliente() + "</td>");
                        out.println("<td>" + a.getVendedor() + "</td>");
                        out.println("<td>" + a.getNombre_vendedor() + "</td>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>0000000000000000</td>"
                            + "<td>000000000000000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>00000000000000000000</td>"
                            + "<td>00000000000000000000000000000000000000</td>"
                            + "<td>00000000000000000000</td>"
                            + "<td>00000000000000000000</td>"
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
