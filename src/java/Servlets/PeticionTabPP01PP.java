/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Pp_operaciones_noti;
import Entidades.pp01_notifi;
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
 * @author Jhonatan
 */
@WebServlet(name = "PeticionTabPP01PP", urlPatterns = {"/PeticionTabPP01PP"})
public class PeticionTabPP01PP extends HttpServlet {

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
            String ord = request.getParameter("ord");
            String ope = request.getParameter("ope");

            LinkedList<pp01_notifi> tn = ACC_Pp_operaciones_noti.ObtenerInstancia().MostDatPP01(ord, ope);
            if (tn.size() == 0) {
                for (int i = 0; i < 50; i++) {
                    out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><div style='width:195px;'><input type='text' name='arre' id=\"matab1" + i + "\" onclick=\"mosbot('" + i + "');\"/><button id=\"matmat1" + i + "\" onclick=\"VentModalmat('matab1" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td><td><div style='width:195px;'><input type='text' id=\"lotabp1" + i + "\" onclick=\"mosbotLot('" + i + "');\" /><button id=\"matlot1" + i + "\" onclick=\"VentModalLote('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td><td><input type='number' min='0' id=\"cumtabp1" + i + "\" name=\"cumtabp1\" /></td><td>&nbsp;</td><td>&nbsp;</td><td id=\"cein" + i + "\">&nbsp;</td><td id=\"unmin" + i + "\">&nbsp;</td><td id=\"almin" + i + "\" >&nbsp;</td><td id=\"Texde" + i + "\">&nbsp;</td></tr>");
                }
            } else {
                for (int i = 0; i < tn.size(); i++) {
                    out.println("<tr>");
                    out.println("<td></td>");
                    out.println("<td>" + tn.get(i).getNum_reserva_nece_secundarias() + "</td>");
                    out.println("<td>" + tn.get(i).getNum_posicion_reserva_nece_secundaria() + "</td>");
                    out.println("<td><div style='width:195px;'><input type = 'text' id=\"matab1" + i + "\" onclick=\"mosbot('" + i + "');\" value=\"" + tn.get(i).getMaterial() + "\" /><button id=\"matmat1" + i + "\" onclick=\"VentModalmat('matab1" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td>");
                    out.println("<td><div style='width:195px;'><input type = 'text' id=\"lotabp1" + i + "\"  value=\"" + tn.get(i).getLote() + "\"' onclick=\"mosbotLot('" + i + "');\" /><button id=\"matlot1" + i + "\" onclick=\"VentModalLote('" + i + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td>");
                    out.println("<td><input type = 'number' id=\"cumtabp1" + i + "\" min='0' value=\"" + tn.get(i).getCantidad_unidad_medida_entrada() + "\" name=\"cumtabp1\" /></td>");
                    out.println("<td>" + tn.get(i).getCantidad_necesaria() + "</td>");
                    out.println("<td>" + tn.get(i).getCantidad_tomada() + "</td>");
                    out.println("<td id=\"cein" + i + "\">" + tn.get(i).getCentro() + "</td>");
                    out.println("<td id=\"unmin" + i + "\" >" + tn.get(i).getUnidad_medida_base() + "</td>");
                    out.println("<td id=\"almin" + i + "\">" + tn.get(i).getAlmacen() + "</td>");
                    out.println("<td id=\"Texde" + i + "\">" + tn.get(i).getTexto_posicion() + "</td>");
                    out.println("</tr>");
                }
                for (int la = 49; la >= tn.size(); la--) {
                    out.println("<tr>");
                    out.println("<td>&nbsp;</td>");
                    out.println("<td>&nbsp;</td>");
                    out.println("<td>&nbsp;</td>");
                    out.println("<td><div style='width:195px;'><input type = 'text' id=\"matab1" + la + "\" onclick=\"mosbot('" + la + "');\"  /><button id=\"matmat1" + la + "\" onclick=\"VentModalmat('matab1" + la + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none;'></button></div></td>");
                    out.println("<td><div style='width:195px;'><input type='text' id=\"lotabp1" + la + "\" onclick=\"mosbotLot('" + la + "');\" /><button id=\"matlot1" + la + "\" onclick=\"VentModalLote('" + la + "')\" class='BtnMatchIcon2' style='margin-left:1px; display:none; '></button></div></td>");
                    out.println("<td><input type = 'number' id=\"cumtabp1" + la + "\" min='0' name=\"cumtabp1\" /></td>");
                    out.println("<td>&nbsp;</td>");
                    out.println("<td>&nbsp;</td>");
                    out.println("<td id=\"cein" + la + "\">&nbsp;</td>");
                    out.println("<td id=\"unmin" + la + "\">&nbsp;</td>");
                    out.println("<td id=\"almin" + la + "\">&nbsp;</td>");
                    out.println("<td id=\"Texde" + la + "\">&nbsp;</td>");
                    out.println("</tr>");
                }
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
