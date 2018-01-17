/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import AccesoDatos.Consultas;
import Entidades.ReporteMovimientosIvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "peticionReporteMovimientosIvent", urlPatterns = {"/peticionReporteMovimientosIvent"})
public class peticionReporteMovimientosIvent extends HttpServlet {

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
            String Acc = request.getParameter("Accion");
            String Mat = request.getParameter("mat");
            String Alm = request.getParameter("alm");

            String MATE = request.getParameter("MATE");
            String ALMA = request.getParameter("ALMA");
            String FEC1 = request.getParameter("FEC1");
            String FEC2 = request.getParameter("FEC2");
            String RADI = request.getParameter("RADI");
            Consultas con = new Consultas();
            switch (Acc) {
                case "CargarMaterialIvent":
                    ArrayList<ReporteMovimientosIvent> mat = ACC_Reportes.ObtenerInstancia().MCReportevent_CargarMateriales();
                    if (mat.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mat.size(); i++) {
                            out.println("<tr ondblclick=\"Selecdata('" + mat.get(i).getMaterial() + "','materialivent','VentanaModalMaterial')\">");
                            out.println("<td>" + mat.get(i).getMaterial() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarAlmacenIvent":
                    ArrayList<ReporteMovimientosIvent> al = ACC_Reportes.ObtenerInstancia().MCReportevent_CargarAlamcen();
                    if (al.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < al.size(); i++) {
                            out.println("<tr ondblclick=\"Selecdata('" + al.get(i).getAlmacen() + "','almivent','VentanaModalAlmacenIvent')\">");
                            out.println("<td>" + al.get(i).getAlmacen() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarMaterial":
                    int m = ACC_Reportes.ObtenerInstancia().ReporteMovimientosIvent_ValidarMaterial(Mat);
                    out.println(m);
                    break;
                case "ValidarAlmacen":
                    int a = ACC_Reportes.ObtenerInstancia().ReporteMovimientosIvent_ValidarAlamcen(Alm);
                    out.println(a);
                    break;
                case "ValidarQuery":
                    String fe1 = con.DateFormatGuion(FEC1);
                    String fe2 = con.DateFormatGuion(FEC2);
                    ArrayList<ReporteMovimientosIvent> r1 = ACC_Reportes.ObtenerInstancia().ReporteMovimientosIvent_CargaValidaIvent(MATE, ALMA, fe1, fe2, RADI);
                    out.println(r1.size());
                    break;
                case "CargarTabla":
                    String fe11 = con.DateFormatGuion(FEC1);
                    String fe22 = con.DateFormatGuion(FEC2);
                    ArrayList<ReporteMovimientosIvent> riv = ACC_Reportes.ObtenerInstancia().ReporteMovimientosIvent_CargaValidaIvent(MATE, ALMA, fe11, fe22, RADI);
                     Collections.sort(riv, new Comparator<ReporteMovimientosIvent>() {
                        public int compare(ReporteMovimientosIvent o1, ReporteMovimientosIvent o2) {
                            return o1.getFecha().compareTo(o2.getFecha());
                        }
                    });
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (ReporteMovimientosIvent ven : riv ) {
                        out.println("<tr>");
                        out.println("<td>" + ven.getFolio() + "</td>");
                        out.println("<td>" + ven.getPosicion() + "</td>");
                        out.println("<td>" + ven.getInd_mov() + "</td>");
                        out.println("<td>" + ven.getCantidad() + "</td>");
                        out.println("<td>" + con.DateFormat(ven.getFecha()) + "</td>");
                        out.println("<td>" + ven.getAlmacen() + "</td>");
                        out.println("<td>" + ven.getMaterial() + "</td>");
                        out.println("<td>" + ven.getDescripcion() + "</td>");
                        out.println("<td>" + ven.getMensaje() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>0000000000000</td>"
                            + "<td>00000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>0000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>0000000000000000000000000000000000000000000000</td>"
                            + "<td>000000000000000000000000000000000000000000000000000000000000000000000</td>"
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
