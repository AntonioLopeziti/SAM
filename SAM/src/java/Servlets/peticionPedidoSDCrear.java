/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CrearPedidoSD;
import Entidades.Sector;
import Entidades.canal_distribucion;
import Entidades.clase_pedido_sd;
import Entidades.grupo_vendedores;
import Entidades.oficina_ventas;
import Entidades.organizacion_ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "peticionPedidoSDCrear", urlPatterns = {"/peticionPedidoSDCrear"})
public class peticionPedidoSDCrear extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String Denom = request.getParameter("DescripcionCPedido");
            String Canti = request.getParameter("Ctd");
            String GpoVen = request.getParameter("GpoV");
            switch (Accion) {
                case "ConsultarClasePedido":
                    ArrayList<clase_pedido_sd> cpe = ACC_CrearPedidoSD.ObtenerInstancia().GetClasePedido();
                    if (cpe.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cpe.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + cpe.get(i).getClase_documento_ventas() + "','VentanaModalClasePedido','ClasePedido')\" >");
                            out.println("<td>" + cpe.get(i).getClase_documento_ventas() + "</td>");
                            out.println("<td>" + cpe.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "ConsultarOrgVentas":
                    ArrayList<organizacion_ventas> orgv = ACC_CrearPedidoSD.ObtenerInstancia().GetOrgVentas();
                    if (orgv.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < orgv.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + orgv.get(i).getOrganizacion_ventas() + "','VentanaModalOrgVentas','orgVentas')\" >");
                            out.println("<td>" + orgv.get(i).getOrganizacion_ventas() + "</td>");
                            out.println("<td>" + orgv.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarCanalDis":
                    ArrayList<canal_distribucion> cana = ACC_CrearPedidoSD.ObtenerInstancia().GetCanalDistribucion();
                    if (cana.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cana.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + cana.get(i).getCanal_distribucion() + "','VentanaModalCanalDist','CanalDis')\" >");
                            out.println("<td>" + cana.get(i).getOrganizacion_ventas() + "</td>");
                            out.println("<td>" + cana.get(i).getCanal_distribucion() + "</td>");
                            out.println("<td>" + cana.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarSector":
                    ArrayList<Sector> sect = ACC_CrearPedidoSD.ObtenerInstancia().GetSector();
                    if (sect.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sect.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + sect.get(i).getSector() + "','VentanaModalSector','Sector')\" >");
                            out.println("<td>" + sect.get(i).getSector() + "</td>");
                            out.println("<td>" + sect.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOficinaVentas":
                    ArrayList<oficina_ventas> ofic = ACC_CrearPedidoSD.ObtenerInstancia().GetOficinaVentas();
                    if (ofic.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ofic.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + ofic.get(i).getOficina_ventas() + "','VentanaModalOficinaVentas','OficinaVentas')\" >");
                            out.println("<td>" + ofic.get(i).getOficina_ventas() + "</td>");
                            out.println("<td>" + ofic.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarGpoVendedores":
                    ArrayList<grupo_vendedores> gpo = ACC_CrearPedidoSD.ObtenerInstancia().GetGrupoVendedores(GpoVen, Denom, Canti);
                    if (gpo.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < gpo.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + gpo.get(i).getGrupo_vendedores() + "','VentanaModalGrpoVend','BuscarParGpovend','ConsultaTablaGpoVend','GpoVendedores')\" >");
                            out.println("<td>" + gpo.get(i).getGrupo_vendedores() + "</td>");
                            out.println("<td>" + gpo.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
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
