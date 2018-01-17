///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Servlets;
//
//import AccesoDatos.ACC_OrganizacionCompras;
//import AccesoDatos.ACC_Proveedor;
//import AccesoDatos.ACC_Sociedades;
//import Entidades.organizacion_compras;
//import Entidades.proveedor;
//import Entidades.sociedades;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.LinkedList;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author Developer-Antonio
// */
//@WebServlet(name = "peticionModuloVisualizarProveedores", urlPatterns = {"/peticionModuloVisualizarProveedores"})
//public class peticionModuloVisualizarProveedores extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            String Accion = request.getParameter("accion");
//            String CtdAciertos = request.getParameter("ctd");
//            String idioma = request.getParameter("Idioma");
//            ////// Proveedor
//            String Nombre = request.getParameter("nombre");
//            String Acreedor = request.getParameter("acreedor");
//            //////// Sociedad
//            String sociedad = request.getParameter("sociedad");
//            String NomSocie = request.getParameter("NomSociedad");
//            String Poblacio = request.getParameter("poblacion");
//            String moneda = request.getParameter("moneda");
//            ////// Organizacion Compras
//            String Compras = request.getParameter("Compras");
//            String Denominacion = request.getParameter("Denominacion");
//
//            switch (Accion) {
//                case "ConsultaMatchProveedor":
//                    String query;
//                    try {
//                        int limite = Integer.parseInt(CtdAciertos);
//                        query = "SELECT DISTINCT TOP " + limite + " * FROM proveedores WHERE IdProveedor LIKE '%" + Acreedor + "%'  AND nombre1 LIKE '%" + Nombre + "%' ORDER BY IdProveedor";
//                    } catch (Exception e) {
//                        query = "SELECT * FROM proveedores WHERE IdProveedor LIKE '%" + Acreedor + "%'  AND nombre1 LIKE '%" + Nombre + "%' ORDER BY IdProveedor";
//                    }
//
//                    LinkedList<proveedor> pr = ACC_Proveedor.ObtenerInstancia().ConsultaMatchProveedor(query);
//                    if (pr.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (int i = 0; i < pr.size(); i++) {
//                            out.println("<tr ondblclick=\"seleccionar('" + pr.get(i).getIdProveedor() + "', 'proveedor')\">");
//                            out.println("<td>" + pr.get(i).getIdProveedor() + "</td>");
//                            out.println("<td>" + pr.get(i).getNombre1() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//                    } else {
//                        out.println(0);
//                    }
//                    break;
//                case "ConsultaMatchSociedad":
//                    String querysoc;
//                    String des = "descripcion_" + idioma;
//                    try {
//                        int limit = Integer.parseInt(CtdAciertos);
//                        if (Acreedor.equals("") || Acreedor == null) {
//                            querysoc = "SELECT DISTINCT TOP " + limit + " soc.sociedad, soc." + des + ", soc.poblacion, soc.clave_moneda FROM sociedades soc INNER JOIN proveedores pr ON soc.sociedad = pr.sociedad WHERE soc.sociedad LIKE '%" + sociedad + "%' AND soc." + des + " LIKE '%" + NomSocie + "%' AND soc.poblacion LIKE'" + Poblacio + "%'  AND soc.clave_moneda LIKE '%" + moneda + "%' ORDER BY soc.sociedad";
//                        } else {
//                            querysoc = "SELECT DISTINCT TOP " + limit + " soc.sociedad, soc." + des + ", soc.poblacion, soc.clave_moneda FROM sociedades soc INNER JOIN proveedores pr ON pr.IdProveedor='" + Acreedor + "' WHERE soc.sociedad = pr.sociedad AND soc.sociedad LIKE '%" + sociedad + "%' AND soc." + des + "  LIKE '%" + NomSocie + "%' AND soc.poblacion LIKE '%" + Poblacio + "%'  AND soc.clave_moneda LIKE '%" + moneda + "%' ORDER BY soc.sociedad";
//                        }
//
//                    } catch (Exception w) {
//                        if (Acreedor.equals("") || Acreedor == null) {
//                            querysoc = "SELECT DISTINCT soc.sociedad, soc." + des + ", soc.poblacion, soc.clave_moneda FROM sociedades soc INNER JOIN proveedores pr ON soc.sociedad = pr.sociedad WHERE soc.sociedad LIKE '%" + sociedad + "%' AND soc." + des + " LIKE'" + NomSocie + "%' AND soc.poblacion LIKE '%" + Poblacio + "%'  AND soc.clave_moneda LIKE '%" + moneda + "%' ORDER BY soc.sociedad";
//                        } else {
//                            querysoc = "SELECT DISTINCT soc.sociedad, soc." + des + ", soc.poblacion, soc.clave_moneda FROM sociedades soc INNER JOIN proveedores pr ON pr.IdProveedor='" + Acreedor + "' WHERE soc.sociedad = pr.sociedad AND soc.sociedad LIKE '%" + sociedad + "%' AND soc." + des + "  LIKE '%" + NomSocie + "%' AND soc.poblacion LIKE '%" + Poblacio + "%'  AND soc.clave_moneda LIKE '%" + moneda + "%' ORDER BY soc.sociedad";
//                        }
//                    }
//
//                    LinkedList<sociedades> soci = ACC_Sociedades.ObtenerIntancia().MatchObtenerSociedadesClientes(querysoc, des);
//                    if (soci.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (int i = 0; i < soci.size(); i++) {
//                            out.println("<tr ondblclick=\"seleccionar('" + soci.get(i).getSociedad() + "', 'sociedad')\">");
//                            out.println("<td>" + soci.get(i).getSociedad() + "</td>");
//                            out.println("<td>" + soci.get(i).getDeninacion() + "</td>");
//                            out.println("<td>" + soci.get(i).getMoneda() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//                    } else {
//                        out.println(0);
//                    }
//                    break;
//                case "ConsultaMatchOrgCompras":
//                    String queryorg = "";
//                    String deno = "descripcion_" + idioma;
//                    try {
//                        int limi = Integer.parseInt(CtdAciertos);
//                        if (Acreedor.equals("") || Acreedor == null) {
//                            queryorg = "SELECT  DISTINCT TOP " + limi + " org.organizacion_compras, org." + deno + " FROM organizacion_compras org INNER JOIN  proveedores pr ON  org.organizacion_compras = pr.organizacion_compras WHERE org.organizacion_compras LIKE '%" + Compras + "%' AND " + deno + " LIKE '%" + Denominacion + "%' ORDER BY org.organizacion_compras";
//                        } else {
//                            queryorg = "SELECT  DISTINCT TOP " + limi + " org.organizacion_compras, org." + deno + " FROM organizacion_compras org INNER JOIN  proveedores pr ON pr.IdProveedor='" + Acreedor + "' WHERE org.organizacion_compras = pr.organizacion_compras AND org.organizacion_compras LIKE '%" + Compras + "%' AND " + deno + " LIKE '%" + Denominacion + "%' ORDER BY org.organizacion_compras ";
//                        }
//                    } catch (Exception e) {
//                        if (Acreedor.equals("") || Acreedor == null) {
//                            queryorg = "SELECT  DISTINCT org.organizacion_compras, org." + deno + " FROM organizacion_compras org INNER JOIN  proveedores pr ON  org.organizacion_compras = pr.organizacion_compras WHERE org.organizacion_compras LIKE '%" + Compras + "%' AND " + deno + " LIKE '%" + Denominacion + "%' ORDER BY org.organizacion_compras";
//                        } else {
//                            queryorg = "SELECT  DISTINCT org.organizacion_compras, org." + deno + " FROM organizacion_compras org INNER JOIN  proveedores pr ON pr.IdProveedor='" + Acreedor + "' WHERE org.organizacion_compras = pr.organizacion_compras AND org.organizacion_compras LIKE '%" + Compras + "%' AND " + deno + " LIKE '%" + Denominacion + "%' ORDER BY org.organizacion_compras ";
//                        }
//                    }
//                    LinkedList<organizacion_compras> o = ACC_OrganizacionCompras.ObtenerInstancia().ConsultaMatchOCProveedor(queryorg, deno);
//                    if (o.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (int i = 0; i < o.size(); i++) {
//                            out.println("<tr ondblclick=\"seleccionar('" + o.get(i).getOrganizacion_compras() + "', 'compras')\">");
//                            out.println("<td>" + o.get(i).getOrganizacion_compras() + "</td>");
//                            out.println("<td>" + o.get(i).getDescripcion() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//                    } else {
//                        out.println(0);
//                    }
//                    break;
//                case "CargarProveedor":
//                    String queryDatos = "SELECT TOP 1 * FROM proveedores WHERE IdProveedor='" + Acreedor + "' AND sociedad='" + sociedad + "' AND organizacion_compras='" + Compras + "'";
//                    proveedor p = ACC_Proveedor.ObtenerInstancia().ObtenerDatosProveedor(queryDatos);
//                    if (p.getIdProveedor() == null || p.getIdProveedor().equals("")) {
//                        out.println(0);
//                    } else {
//                        String cad = "" + p.getNombre1() + ","
//                                + "" + p.getNombre2() + ","
//                                + "" + p.getNombre3() + ","
//                                + "" + p.getNombre4() + ","
//                                + "" + p.getPoblacion() + ","
//                                + "" + p.getLugarResidencia() + ","
//                                + "" + p.getCalle() + ","
//                                + "" + p.getDistrito() + ","
//                                + "" + p.getNumEdificio() + ","
//                                + "" + p.getNIF() + ","
//                                + "" + p.getClaveCondicionesPago() + ","
//                                + "" + p.getIndicadorABC() + ","
//                                + "" + p.getGrupoCuentasAcreedor() + ","
//                                + "" + p.getCuentaAsociadaConta() + ","
//                                + "" + p.getMonedaPedido() + ","
//                                + "" + p.getValorMinimoPedido() + ","
//                                + "" + p.getIncoPart1() + ","
//                                + "" + p.getIncoPart2() + ","
//                                + "" + p.getClaveControlConfir() + ","
//                                + "" + p.getGrupoCompras() + ","
//                                + "" + p.getPeticionBorradorMaestro() + ","
//                                + "" + p.getBloqueoContabilizaionSociedad() + ","
//                                + "" + p.getPeticionBorradorCentral() + ",";
//                        out.println(cad);
//
//                    }
//                    break;
//
//                default:
//                    break;
//            }
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
