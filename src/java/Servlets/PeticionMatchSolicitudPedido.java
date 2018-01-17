/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_RepSolicitudPedido;
import Entidades.tipo_imputacion;
import Entidades.tipo_posicion;
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
 */
@WebServlet(name = "PeticionMatchSolicitudPedido", urlPatterns = {"/PeticionMatchSolicitudPedido"})
public class PeticionMatchSolicitudPedido extends HttpServlet {

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
            HttpSession session = request.getSession();
            String accion = request.getParameter("Action");
            String sam1 = request.getParameter("sam1");
            String sap1 = request.getParameter("sap1");
            String fecha1 = request.getParameter("fecha1");
            String sam2 = request.getParameter("sam2");
            String sap2 = request.getParameter("sap2");
            String fecha2 = request.getParameter("fecha2");
            String centro = request.getParameter("centro");
            String solicitante = request.getParameter("solicitante");
            String almacen = request.getParameter("almacen");
            String material = request.getParameter("material");
            String posicion = request.getParameter("posicion");
            String imputacion = request.getParameter("imputacion");
            String campo = request.getParameter("campo");
            String campo2 = request.getParameter("campo2");
            String valor = request.getParameter("valor");
            String Idioma = (String) session.getAttribute("Idioma");
            
            session.setAttribute("sam1", sam1);
            session.setAttribute("sap1", sap1);
            session.setAttribute("fecha1", fecha1);
            session.setAttribute("sam2", sam2);
            session.setAttribute("sap2", sap2);
            session.setAttribute("fecha2", fecha2);
            session.setAttribute("centro", centro);
            session.setAttribute("solicitante", solicitante);
            session.setAttribute("almacen", almacen);
            session.setAttribute("material", material);
            session.setAttribute("posicion", posicion);
            session.setAttribute("imputacion", imputacion);

            switch (accion) {

                case "centro":
                    LinkedList<String[]> datosSolicitante = new LinkedList<String[]>();
                    String[] sol = new String[7];
                    datosSolicitante = ACC_RepSolicitudPedido.ObtenerInstancia().ObtenerDatosMAtch("centro", "centro");
                    if (datosSolicitante.size() > 0) {
                        for (int i = 0; i < datosSolicitante.size(); i++) {
                            sol = datosSolicitante.get(i);
                            out.println("<option value='" + sol[0] + "'>" + sol[0] + "</option>");
                        }
                    }else{
                        out.println("<option></option>");
                    }
                    break;
                case "folio_sam":
                    LinkedList<String[]> datosFolioSam = new LinkedList<String[]>();
                    String[] folioSAM = new String[7];
                    datosFolioSam = ACC_RepSolicitudPedido.ObtenerInstancia().ObtenerDatosMAtch("folio_sam", "folio_sam");
                    if (datosFolioSam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < datosFolioSam.size(); i++) {
                            folioSAM = datosFolioSam.get(i);

                            out.println("<tr ondblclick=\"Select('" + folioSAM[0] + "','sam1')\">");
                            out.println("<td>" + folioSAM[0] + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "folio_sam2":
                    LinkedList<String[]> datosFolioSam2 = new LinkedList<String[]>();
                    String[] folioSAM2 = new String[7];
                    datosFolioSam2 = ACC_RepSolicitudPedido.ObtenerInstancia().ObtenerDatosMAtch("folio_sam", "folio_sam");

                    if (datosFolioSam2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < datosFolioSam2.size(); i++) {
                            folioSAM2 = datosFolioSam2.get(i);

                            out.println("<tr ondblclick=\"Select('" + folioSAM2[0] + "','sam2')\">");
                            out.println("<td>" + folioSAM2[0] + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "folio_sap":
                    LinkedList<String[]> datosFolioSap = new LinkedList<String[]>();
                    String[] folioSAP = new String[7];
                    datosFolioSap = ACC_RepSolicitudPedido.ObtenerInstancia().ObtenerDatosMAtch("folio_sap", "num_solped");

                    if (datosFolioSap.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < datosFolioSap.size(); i++) {
                            folioSAP = datosFolioSap.get(i);

                            out.println("<tr ondblclick=\"Select('" + folioSAP[0] + "','sap1')\">");
                            out.println("<td>" + folioSAP[0] + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "folio_sap2":
                    LinkedList<String[]> datosFolioSap2 = new LinkedList<String[]>();
                    String[] folioSAP2 = new String[7];
                    datosFolioSap2 = ACC_RepSolicitudPedido.ObtenerInstancia().ObtenerDatosMAtch("folio_sap", "num_solped");

                    if (datosFolioSap2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < datosFolioSap2.size(); i++) {
                            folioSAP2 = datosFolioSap2.get(i);

                            out.println("<tr ondblclick=\"Select('" + folioSAP2[0] + "','sap2')\">");
                            out.println("<td>" + folioSAP2[0] + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "solicitante":
                    LinkedList<String[]> datosSolicitantee = new LinkedList<String[]>();
                    String[] solicitanteString = new String[7];
                    datosSolicitantee = ACC_RepSolicitudPedido.ObtenerInstancia().ObtenerDatosMAtch("nombre_solicitante", "solicitante");

                    if (datosSolicitantee.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < datosSolicitantee.size(); i++) {
                            solicitanteString = datosSolicitantee.get(i);

                            out.println("<tr ondblclick=\"Select('" + solicitanteString[0] + "','solicitante')\">");
                            out.println("<td>" + solicitanteString[0] + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "almacen":
                    LinkedList<String[]> datosAlmacen = new LinkedList<String[]>();
                    String[] almacenString = new String[7];
                    datosAlmacen = ACC_RepSolicitudPedido.ObtenerInstancia().ObtenerDatosMAtch("almacen", "almacen");

                    if (datosAlmacen.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < datosAlmacen.size(); i++) {
                            almacenString = datosAlmacen.get(i);

                            out.println("<tr ondblclick=\"Select('" + almacenString[0] + "','almacen')\">");
                            out.println("<td>" + almacenString[0] + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "material":
                    LinkedList<String[]> datosMaterial = new LinkedList<String[]>();
                    String[] materialString = new String[7];
                    datosMaterial = ACC_RepSolicitudPedido.ObtenerInstancia().ObtenerDatosMAtch("num_material", "num_material");

                    if (datosMaterial.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < datosMaterial.size(); i++) {
                            materialString = datosMaterial.get(i);

                            out.println("<tr ondblclick=\"Select('" + materialString[0] + "','material')\">");
                            out.println("<td>" + materialString[0] + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "posicion":
                    ArrayList<tipo_posicion> pos = ACC_RepSolicitudPedido.ObtenerInstancia().ListaSolpedPosicion(Idioma);
                    if (pos.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pos.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pos.get(i).getTipo_posicion() + "','posicion')\">");
                            out.println("<td>" + pos.get(i).getTipo_posicion() + "</td>");
                            out.println("<td>" + pos.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "imputacion":
                    ArrayList<tipo_imputacion> imp = ACC_RepSolicitudPedido.ObtenerInstancia().ListaSolpedImputacion(Idioma);
                    if (imp.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < imp.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + imp.get(i).getTipo_imputacion() + "','imputacion')\">");
                            out.println("<td>" + imp.get(i).getTipo_imputacion()+ "</td>");
                            out.println("<td>" + imp.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "validar":
                    String valido = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarSolped(campo, campo2, valor);
                    if (valido == "") {
                        out.println(0);
                    } else {
                        out.println(valido);
                    }
                    break;
                case "validarImputacion":
                    if(ACC_RepSolicitudPedido.ObtenerInstancia().ValidarImputacion(imputacion)){
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarPosicion":
                    if(ACC_RepSolicitudPedido.ObtenerInstancia().ValidarPosicion(posicion)){
                        out.println(1);
                    } else{
                        out.println(0);
                    }
                    break;
                default:
                    out.println(1);
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
