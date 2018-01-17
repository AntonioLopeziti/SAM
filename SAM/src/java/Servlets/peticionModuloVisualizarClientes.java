/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Canal;
import AccesoDatos.ACC_Clientes;
import AccesoDatos.ACC_Organizacion;
import AccesoDatos.ACC_Sector;
import AccesoDatos.ACC_Sociedades;
import Entidades.Sector;
import Entidades.canal;
import Entidades.clientes;
import Entidades.organizacion;
import Entidades.sociedades;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AREConsulting
 */
@WebServlet(name = "peticionModuloVisualizarClientes", urlPatterns = {"/peticionModuloVisualizarClientes"})
public class peticionModuloVisualizarClientes extends HttpServlet {

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

            String Accion = request.getParameter("acc");
            String NombreCl = request.getParameter("nom");
            String ClienteCl = request.getParameter("cli");
            String CtdMaxCl = request.getParameter("ctd");
            String Sociedad = request.getParameter("sociedad");
            String NombreSoc = request.getParameter("NomSociedad");
            String Poblacion = request.getParameter("poblacion");
            String Moneda = request.getParameter("moneda");
            String Organiz = request.getParameter("org");
            String Denom = request.getParameter("den");
            String Canal = request.getParameter("canal");
            String DenCan = request.getParameter("denC");
            String idioma = request.getParameter("idioma");
            String Sector = request.getParameter("sector");
            String denSec = request.getParameter("denSe");
            switch (Accion) {
                case "ConsultarMatchCliente":
                    String query = "";
                    try {
                        int limite = Integer.parseInt(CtdMaxCl);
                        query = "SELECT DISTINCT TOP " + limite + " IdCliente, nombre1 FROM MM.clientes WHERE IdCliente LIKE '%" + ClienteCl + "%' AND nombre1 LIKE '%" + NombreCl + "%' ORDER BY IdCliente";
                    } catch (Exception e) {
                        query = "SELECT DISTINCT  IdCliente, nombre1 FROM MM.clientes WHERE IdCliente LIKE '%" + ClienteCl + "%' AND nombre1 LIKE '%" + NombreCl + "%' ORDER BY IdCliente";
                    }
                    LinkedList<clientes> c = ACC_Clientes.ObtenerInstancia().ConsultaClienteMatch(query);
                    if (c.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + c.get(i).getIdCliente() + "', 'cliente')\">");
                            out.println("<td>" + c.get(i).getIdCliente() + "</td>");
                            out.println("<td>" + c.get(i).getNombre1() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchSociedad":
                    String querysoc;
                    String descr = "descripcion_" + idioma;
                    try {
                        int limit = Integer.parseInt(CtdMaxCl);
                        if (ClienteCl.equals("") || ClienteCl == null) {
                            querysoc = "SELECT DISTINCT TOP " + limit + " soc.sociedad, soc." + descr + ", soc.poblacion, soc.clave_moneda FROM MM.sociedades soc INNER JOIN MM.clientes cl ON soc.sociedad = cl.sociedad WHERE soc.sociedad LIKE '%" + Sociedad + "%' AND soc." + descr + " LIKE '%" + NombreSoc + "%' AND soc.poblacion LIKE '%" + Poblacion + "%' AND soc.clave_moneda LIKE '%" + Moneda + "%' ORDER BY soc.sociedad";
                        } else {
                            querysoc = "SELECT DISTINCT TOP " + limit + " soc.sociedad, soc." + descr + ", soc.poblacion, soc.clave_moneda FROM MM.sociedades soc INNER JOIN MM.clientes cl ON soc.sociedad = cl.sociedad WHERE cl.IdCliente='" + ClienteCl + "'  AND soc.sociedad LIKE '%" + Sociedad + "%' AND  soc." + descr + " LIKE '%" + NombreSoc + "%' AND soc.poblacion LIKE '%" + Poblacion + "%' AND soc.clave_moneda LIKE '%" + Moneda + "%' ORDER BY soc.sociedad";
                        }
                    } catch (Exception e) {
                        if (ClienteCl.equals("") || ClienteCl == null) {
                            querysoc = "SELECT DISTINCT  soc.sociedad, soc." + descr + ", soc.poblacion, soc.clave_moneda FROM MM.sociedades soc INNER JOIN MM.clientes cl ON soc.sociedad = cl.sociedad WHERE soc.sociedad LIKE '%" + Sociedad + "%' AND soc." + descr + " LIKE '%" + NombreSoc + "%' AND soc.poblacion LIKE '%" + Poblacion + "%' AND soc.clave_moneda LIKE '%" + Moneda + "%' ORDER BY soc.sociedad";
                        } else {
                            querysoc = "SELECT DISTINCT soc.sociedad, soc." + descr + ", soc.poblacion, soc.clave_moneda FROM MM.sociedades soc INNER JOIN MM.clientes cl ON soc.sociedad = cl.sociedad WHERE cl.IdCliente='" + ClienteCl + "'  AND soc.sociedad LIKE '%" + Sociedad + "%' AND  soc." + descr + " LIKE '%" + NombreSoc + "%' AND soc.poblacion LIKE '%" + Poblacion + "%' AND soc.clave_moneda LIKE '%" + Moneda + "%' ORDER BY soc.sociedad";
                        }
                    }
                    LinkedList<sociedades> soci = ACC_Sociedades.ObtenerIntancia().MatchObtenerSociedadesClientes(querysoc, descr);
                    if (soci.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < soci.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + soci.get(i).getSociedad() + "', 'sociedad')\">");
                            out.println("<td>" + soci.get(i).getSociedad() + "</td>");
                            out.println("<td>" + soci.get(i).getDeninacion() + "</td>");
                            out.println("<td>" + soci.get(i).getMoneda() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "ConsultarMatchOrgVentas":
                    String queryOrg;
                    try {
                        int limi = Integer.parseInt(CtdMaxCl);
                        if (ClienteCl.equals("") || ClienteCl == null) {
                            queryOrg = "SELECT DISTINCT TOP " + limi + " ven.organizacion_ventas, ven.denominacion FROM MM.organizacion_ventas ven INNER JOIN MM.clientes cl ON ven.organizacion_ventas = cl.organizacion_ventas WHERE ven.organizacion_ventas LIKE '%" + Organiz + "%' AND ven.denominacion LIKE '%" + Denom + "%' ORDER BY ven.organizacion_ventas";
                        } else {
                            queryOrg = "SELECT DISTINCT TOP " + limi + " ven.organizacion_ventas, ven.denominacion FROM MM.organizacion_ventas ven INNER JOIN MM.clientes cl ON ven.organizacion_ventas = cl.organizacion_ventas  WHERE cl.IdCliente='" + ClienteCl + "' AND ven.organizacion_ventas LIKE '%" + Organiz + "%' AND ven.denominacion LIKE '%" + Denom + "%' ORDER BY ven.organizacion_ventas";
                        }
                    } catch (Exception e) {
                        if (ClienteCl.equals("") || ClienteCl == null) {
                            queryOrg = "SELECT DISTINCT  ven.organizacion_ventas, ven.denominacion FROM MM.organizacion_ventas ven INNER JOIN MM.clientes cl ON ven.organizacion_ventas = cl.organizacion_ventas WHERE ven.organizacion_ventas LIKE '%" + Organiz + "%' AND ven.denominacion LIKE '%" + Denom + "%' ORDER BY ven.organizacion_ventas";
                        } else {
                            queryOrg = "SELECT DISTINCT  ven.organizacion_ventas, ven.denominacion FROM MM.organizacion_ventas ven INNER JOIN MM.clientes cl ON ven.organizacion_ventas = cl.organizacion_ventas  WHERE cl.IdCliente='" + ClienteCl + "' AND ven.organizacion_ventas LIKE '%" + Organiz + "%' AND ven.denominacion LIKE '%" + Denom + "%' ORDER BY ven.organizacion_ventas";
                        }
                    }
                    LinkedList<organizacion> o = ACC_Organizacion.ObtenerInstancia().ConsultaMatchOVVisualCliente(queryOrg);
                    if (o.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < o.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + o.get(i).getOrganizacion() + "', 'ventas')\">");
                            out.println("<td>" + o.get(i).getOrganizacion() + "</td>");
                            out.println("<td>" + o.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarMatchCanal":
                    String querycanal = "";
                    String denom = "descripcion_" + idioma;
                    try {
                        int lim = Integer.parseInt(CtdMaxCl);
                        if (ClienteCl.equals("") || ClienteCl == null) {
                            querycanal = "SELECT DISTINCT TOP " + lim + " dis.canal_distribucion, dis." + denom + " FROM MM.canal_distribucion dis INNER JOIN MM.clientes cl ON cl.canal_distribucion = dis.canal_distribucion WHERE dis.canal_distribucion LIKE '%" + Canal + "%' AND dis." + denom + " LIKE '%" + DenCan + "%' ORDER BY dis.canal_distribucion ";
                        } else {
                            querycanal = "SELECT DISTINCT TOP " + lim + " dis.canal_distribucion, dis." + denom + " FROM MM.canal_distribucion dis INNER JOIN MM.clientes cl ON cl.canal_distribucion = dis.canal_distribucion WHERE cl.IdCliente='" + ClienteCl + "'  AND dis.canal_distribucion LIKE '%" + Canal + "%' AND dis." + denom + " LIKE '%" + DenCan + "%' ORDER BY dis.canal_distribucion ";
                        }
                    } catch (Exception e) {
                        if (ClienteCl.equals("") || ClienteCl == null) {
                            querycanal = "SELECT DISTINCT dis.canal_distribucion, dis." + denom + " FROM MM.canal_distribucion dis INNER JOIN MM.clientes cl ON cl.canal_distribucion = dis.canal_distribucion WHERE dis.canal_distribucion LIKE '%" + Canal + "%' AND dis." + denom + " LIKE '%" + DenCan + "%' ORDER BY dis.canal_distribucion ";
                        } else {
                            querycanal = "SELECT DISTINCT dis.canal_distribucion, dis." + denom + " FROM MM.canal_distribucion dis INNER JOIN MM.clientes cl ON cl.canal_distribucion = dis.canal_distribucion WHERE cl.IdCliente='" + ClienteCl + "'  AND dis.canal_distribucion LIKE '%" + Canal + "%' AND dis." + denom + " LIKE '%" + DenCan + "%' ORDER BY dis.canal_distribucion ";
                        }
                    }
                    LinkedList<canal> can = ACC_Canal.ObtenerInstancia().ConsultaMatchCanalCliente(querycanal, denom);
                    if (can.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < can.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + can.get(i).getCanal() + "', 'canal')\">");
                            out.println("<td>" + can.get(i).getCanal() + "</td>");
                            out.println("<td>" + can.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarMatchSector":
                    String des = "descripcion_" + idioma;
                    String querysect = "";
                    try {
                        int li = Integer.parseInt(CtdMaxCl);
                        if (ClienteCl.equals("") || ClienteCl == null) {
                            querysect = "SELECT DISTINCT TOP " + li + " s.sector, s." + des + " FROM MM.sector s INNER JOIN MM.clientes cl ON cl.sector=s.sector WHERE s.sector LIKE '%" + Sector + "%' AND s." + des + " LIKE '%" + denSec + "%' ORDER BY s.sector";
                        } else {
                            querysect = "SELECT DISTINCT TOP " + li + " s.sector, s." + des + " FROM MM.sector s INNER JOIN MM.clientes cl ON  cl.sector=s.sector WHERE cl.IdCliente='" + ClienteCl + "' AND s.sector LIKE'%" + Sector + "%' AND s." + des + " LIKE '%" + denSec + "%' ORDER BY s.sector";
                        }
                    } catch (Exception e) {
                        if (ClienteCl.equals("") || ClienteCl == null) {
                            querysect = "SELECT DISTINCT  s.sector, s." + des + " FROM MM.sector s INNER JOIN MM.clientes cl ON cl.sector=s.sector WHERE s.sector LIKE '%" + Sector + "%' AND s." + des + " LIKE '%" + denSec + "%' ORDER BY s.sector";
                        } else {
                            querysect = "SELECT DISTINCT  s.sector, s." + des + " FROM MM.sector s INNER JOIN MM.clientes cl ON  cl.sector=s.sector WHERE cl.IdCliente='" + ClienteCl + "' AND s.sector LIKE'%" + Sector + "%' AND s." + des + " LIKE '%" + denSec + "%' ORDER BY s.sector";
                        }
                    }
                    LinkedList<Sector> sec = ACC_Sector.ObtenerInstancia().MatchObtenerSectorCliente(querysect, des);
                    if (sec.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sec.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + sec.get(i).getSector() + "', 'sector')\">");
                            out.println("<td>" + sec.get(i).getSector() + "</td>");
                            out.println("<td>" + sec.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarCliente":
                    clientes cl = ACC_Clientes.ObtenerInstancia().ObtenerDatosClientes(ClienteCl, Sociedad, Organiz, Canal, Sector);
                    if (cl.getIdCliente() == "" || cl.getIdCliente() == null) {
                        out.println(0);
                    } else {
                        String cad = "" + cl.getNombre1() + ","
                                + "" + cl.getNombre2() + ","
                                + "" + cl.getNombre3() + ","
                                + "" + cl.getNombre4() + ","
                                + "" + cl.getPoblacion() + ","
                                + "" + cl.getLugarResidencia() + ","
                                + "" + cl.getCalle() + ","
                                + "" + cl.getDistrito() + ","
                                + "" + cl.getNumEdificio() + ","
                                + "" + cl.getNif() + ","
                                + "" + cl.getClaveCondicionPago() + ","
                                + "" + cl.getClasificacionCliente() + ","
                                + "" + cl.getGrupoCuentaDeudor() + ","
                                + "" + cl.getCuentaAsoConta() + ","
                                + "" + cl.getMoneda() + ","
                                + "" + cl.getIncoParte1() + ","
                                + "" + cl.getIncoParte2() + ","
                                + "" + cl.getGrupoVendedores() + ","
                                + "" + cl.getNivelSociedad() + ","
                                + "" + cl.getBloqueoContaSociedad() + ","
                                + "" + cl.getPeticionBorraRegistoMaestro() + "";
                        out.println(cad);
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
