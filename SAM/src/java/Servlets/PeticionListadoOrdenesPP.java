/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_ListadoOrdenesPP;
import AccesoDatos.Consultas;
import Entidades.ListadoOrdenesPP;
import Entidades.StatusOrdenes;
import Entidades.folios;
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
 * @author Panda
 */
@WebServlet(name = "PeticionListadoOrdenesPP", urlPatterns = {"/PeticionListadoOrdenesPP"})
public class PeticionListadoOrdenesPP extends HttpServlet {

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
            String action = request.getParameter("action");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");
            
            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("LT");
            folios fn = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("NP");
            
            switch(action){
                case "tablaListado":
                    int cc = 0;
                    ArrayList<ListadoOrdenesPP> lo = ACC_ListadoOrdenesPP.ObtenerInstancia().ObtenerListaOrdenesPP();
                    out.println("<table id=\"TabBody\">\n" +
"                                <tbody>");
                    for(ListadoOrdenesPP ll : lo){
                        out.println("	    <tr>\n" +
                                    "	    <td><input type=\"radio\" name=\"gender\" value=\"" + cc + "\"></td>\n" +
                                    "	    <td id=\"tdPP1" + cc + "\">" + ll.getClase_documento_ventas() + "</td>\n" +
                                    "	    <td id=\"tdPP2" + cc + "\">" + ll.getNum_orden() + "</td>\n" +
                                    "	    <td id=\"tdPP3" + cc + "\">" + ll.getFolio_sam() + "</td>\n" + //Folio SAM
                                    "	    <td id=\"tdPC3" + cc + "\">" + ll.getCentro() + "</td>\n" + //Centro
                                    "	    <td id=\"tdPP4" + cc + "\">" + ll.getNum_material() + "</td>\n" +
                                    "	    <td id=\"tdPP5" + cc + "\">" + ll.getTexto_material() + "</td>\n" +
                                    "	    <td id=\"tdPP6" + cc + "\">" + ll.getStatus() + "</td>\n" +
                                    "	    <td id=\"tdPP7" + cc + "\">" + ll.getCantidad_total() + "</td>\n" +
                                    "	    <td id=\"tdPP8" + cc + "\">" + ll.getFecha_inicio_extrema() + "</td>\n" +
                                    "	    <td id=\"tdPP9" + cc + "\">" + ll.getContador_notificacion() + "</td>\n" +
//                                    "	    <td><input type=\"checkbox\" name=\"habilitado\"></td>\n" +
                                    "	    <td>" + ll.getHabilitado() + "</td>\n" +
                                "	    </tr>");
                        cc++;
                    }
                    for(int i = cc; i < 19; i++){
                        out.println("<tr><td>&nbsp</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                    }
                    out.println("<tr class=\"ocultar\">\n" +
                        "        <td>00</td>\n" +
                        "        <td>0000000000</td>\n" +
                        "        <td>00000000000</td>\n" +
                        "        <td>00000000000</td>\n" +
                        "        <td>000000000</td>\n" +
                        "        <td>000000000000000</td>\n" +
                        "        <td>0000000000000000000000000000000</td>\n" +
                        "        <td>00000000000000000000000000000000</td>\n" +
                        "        <td>000000000000</td>\n" +
                        "        <td>00000000000</td>\n" +
                        "        <td>00000000</td>\n" +
                        "        <td>00000</td>\n" +
                        "    </tr>\n" +
                        "</tbody>\n" +
                        "</table>");
                    break;
                case "guardaStatus":
                    StatusOrdenes so = new StatusOrdenes();
                    so.setFolio_sam("LT" + fo.getFolioActual());
                    so.setFolio_orden(v1);
                    so.setFecha_serv(fechaActual);
                    so.setHora_serv(horaActual);
                    so.setNum_orden(v2);
                    so.setCentro(v3);
                    so.setOperacion_sam(v4);
                    so.setUsuario(v5);
                    ACC_ListadoOrdenesPP.ObtenerInstancia().guardaStatusOrden(so);
                    ACC_ListadoOrdenesPP.ObtenerInstancia().CambiaStatusOrden(so, v6);
                    out.println("LT" + fo.getFolioActual());
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("LT", fo.getFolioActual());
                    break;
                case "guardaStatusNoti":
                    StatusOrdenes sn = new StatusOrdenes();
                    sn.setFolio_orden(v1);
                    sn.setFolio_sam("NP" + fn.getFolioActual());
                    sn.setFecha_serv(fechaActual);
                    sn.setHora_serv(horaActual);
                    sn.setNum_orden(v2);
                    sn.setCentro(v3);
                    sn.setOperacion_sam(v4);
                    sn.setUsuario(v5);
                    ACC_ListadoOrdenesPP.ObtenerInstancia().guardaStatusOrden(sn);
                    ACC_ListadoOrdenesPP.ObtenerInstancia().CambiaStatusOrden(sn, v6);
                    out.println("NP" + fn.getFolioActual());
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("NP", fn.getFolioActual());
                    break;
                case "guardaHabilitado":
                    StatusOrdenes ss = new StatusOrdenes();
                    ss.setNum_orden(v1);
                    ss.setFolio_sam(v2);
                    ss.setOperacion_sam(v3);
                    ss.setStatus(v4);
                    ss.setCentro(v5);
                    ss.setNum_lote(v6);//Número de Material
                    ACC_ListadoOrdenesPP.ObtenerInstancia().GuardaHabilitado(ss);
                    break;
                case "truncarControl":
                    ACC_ListadoOrdenesPP.ObtenerInstancia().truncateControl();
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
