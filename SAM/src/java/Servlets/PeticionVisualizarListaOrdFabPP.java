/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.Consultas;
import AccesoDatos.ACC_ListadoOrdenesPP;
import Entidades.centros;
import Entidades.StatusOrdenes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "PeticionVisualizarListaOrdFabPP", urlPatterns = {"/PeticionVisualizarListaOrdFabPP"})
public class PeticionVisualizarListaOrdFabPP extends HttpServlet {

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
            
            String folOrd = request.getParameter("folOrd");
            String CentroOrd = request.getParameter("CentroOrd");
            String CtdOrd = request.getParameter("CtdOrd"); 
            
            String folMate = request.getParameter("folMate");
            String CentroMate = request.getParameter("CentroMate");
            String CtdMate = request.getParameter("CtdMate");
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
                    ArrayList<StatusOrdenes> sam = ACC_ListadoOrdenesPP.ObtenerInstancia().SAMStatusSO(folOrd, CentroOrd, CtdOrd);
                    if (sam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (StatusOrdenes m : sam) {
                            out.println("<tr ondblclick=\"Select('" + m.getNum_orden() + "','" + tipo + "')\">");
                            out.println("<td>" + m.getNum_orden() + "</td>");
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
                    ArrayList<StatusOrdenes> sap = ACC_ListadoOrdenesPP.ObtenerInstancia().SAPStatusOP(folMate, CentroMate, CtdMate);
                    if (sap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (StatusOrdenes n : sap) {
                            out.println("<tr ondblclick=\"Select('" + n.getNum_material() + "','" + tipo + "')\">");
                            out.println("<td>" + n.getNum_material() + "</td>");
                            out.println("<td>" + n.getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    
                    break;
                case "ValidarCentroo":
                    if (ACC_ListadoOrdenesPP.ObtenerInstancia().ValidarCentro(centros)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM22":
                    if (ACC_ListadoOrdenesPP.ObtenerInstancia().ValidarSamStatusSO(foliosam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAP22":
                    if (ACC_ListadoOrdenesPP.ObtenerInstancia().ValidarSaPStatusSO(foliosap)) {
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
