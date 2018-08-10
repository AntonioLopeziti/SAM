/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Servicios;
import AccesoDatos.ACC_SolicitudPedidos;
import AccesoDatos.Conexion;
import Entidades.SolpedServicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 */
@WebServlet(name = "peticionCargarServiciosPosicion", urlPatterns = {"/peticionCargarServiciosPosicion"})
public class peticionCargarServiciosPosicion extends HttpServlet {

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
            String posicion = request.getParameter("posicion");
            HttpSession session = request.getSession();
            String u = (String) session.getAttribute("Usuario");
            String valorDatoSer = request.getParameter("ValorFila");
            session.setAttribute("ValorFServicio", valorDatoSer);
            String ipsf = request.getParameter("ipsf");
            out.println("<table>");
            out.println("<tbody>");
            if (posicion == null || posicion == "" || posicion == "0") {
                for (int i = 0; i < 10; i++) {
                    out.println("<tr>"
                            + "<td><input type=\"checkbox\" class=\"TDSER1\" name=\"ServicesDel\"/></td>"
                            + "<td><input type=\"text\" class=\"TDSER2\" readOnly style=\"background:none;\" name=\"tsPosSol\"/></td>"
                            + "<td><input type=\"text\" class=\"TDSER3\" readOnly style=\"background:none;\" name=\"POS\"></td>"
                            + "<td><div style=\"width:110px;\"><input type=\"text\" class=\"TDSER4\" maxlength=\"18\" id=\"Ser" + i + "\" name=\"Sevic\" onfocus=\"VerMCServicios('" + i + "')\"/><button  style=\"display : none;\" onclick=\"AbrirServicios('" + i + "')\" id=\"btnservi" + i + "\" class=\"BtnMatchIcon\" name=\"butoservice\"></button></div></td>"
                            + "<td><input type=\"text\" class=\"TDSER5\" maxlength=\"7\" id=\"SerCan" + i + "\"  name=\"Cant\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
                            + "<td><input type=\"text\" class=\"TDSER6\" maxlength=\"3\" id=\"SerUM" + i + "\" style=\"text-transform: uppercase;\" name=\"unim\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
                            + "<td><input type=\"text\" class=\"TDSER8\" maxlength=\"40\" id=\"SerDes" + i + "\" name=\"des\" onfocus=\"QuitarMC(" + i + ");\" disabled/></td>"
                            + "</tr>");
                }
            } else {
                int v;
                ArrayList<SolpedServicios> s = ACC_Servicios.ObtenerInstancia().CargarServicios(u, posicion, ipsf);
                if (s.size() > 0) {
                    for (v = 0; v < s.size(); v++) {
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" class=\"TDSER1\" name=\"ServicesDel\"></td>"
                                + "<td><input type=\"text\" class=\"TDSER2\" readOnly style=\"background:none;\" name=\"tsPosSol\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER3\" readOnly style=\"background:none;\" name=\"POS\"></td>"
                                + "<td><div style=\"width:110px;\"><input type=\"text\"  class=\"TDSER4\" value=\"" + s.get(v).getNum_servicio() + "\" maxlength=\"18\" id=\"Ser" + v + "\" name=\"Sevic\" onfocus=\"VerMCServicios('" + v + "')\"/><button  style=\"display : none;\" onclick=\"AbrirServicios('" + v + "')\" id=\"btnservi" + v + "\" class=\"BtnMatchIcon\" name=\"butoservice\"></button></div></td>"
                                + "<td><input type=\"text\" class=\"TDSER5\" value=\"" + s.get(v).getCantidad() + "\" maxlength=\"7\"  id=\"SerCan" + v + "\"  name=\"Cant\" onfocus=\"QuitarMC(" + v + ");\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER6\" value=\"" + s.get(v).getUnidad_medida_base() + "\" readOnly  style=\"text-transform: uppercase;\" maxlength=\"3\" id=\"SerUM" + v + "\" name=\"unim\" onfocus=\"QuitarMC(" + v + ");\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER8\" value=\"" + s.get(v).getTexto_breve() + "\" maxlength=\"40\" id=\"SerDes" + v + "\" name=\"des\" onfocus=\"QuitarMC(" + v + ");\" disabled/></td>"
                                + "</tr>");
                    }
                    for (int l = v; l <= 10; l++) {
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" class=\"TDSER1\" name=\"ServicesDel\"></td>"
                                + "<td><input type=\"text\" class=\"TDSER2\" readOnly style=\"background:none;\" name=\"tsPosSol\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER3\" readOnly style=\"background:none;\" name=\"POS\"></td>"
                                + "<td><div style=\"width:110px;\"><input type=\"text\"  class=\"TDSER4\" maxlength=\"18\" id=\"Ser" + l + "\" name=\"Sevic\" onfocus=\"VerMCServicios('" + l + "')\"/><button  style=\"display : none;\" onclick=\"AbrirServicios('" + l + "')\" id=\"btnservi" + l + "\" class=\"BtnMatchIcon\" name=\"butoservice\"></button></div></td>"
                                + "<td><input type=\"text\" class=\"TDSER5\" maxlength=\"7\"  id=\"SerCan" + l + "\"  name=\"Cant\" onfocus=\"QuitarMC(" + v + ");\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER6\" maxlength=\"3\" id=\"SerUM" + l + "\" style=\"text-transform: uppercase;\" name=\"unim\" onfocus=\"QuitarMC(" + v + ");\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER8\" maxlength=\"40\" id=\"SerDes" + l + "\" name=\"des\" onfocus=\"QuitarMC(" + v + ");\" disabled/></td>"
                                + "</tr>");
                    }

                } else {
                    for (int i = 0; i <= 10; i++) {
                        out.println("<tr>"
                                + "<td><input type=\"checkbox\" class=\"TDSER1\" name=\"ServicesDel\"></td>"
                                + "<td><input type=\"text\" class=\"TDSER2\" readOnly style=\"background:none;\" name=\"tsPosSol\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER3\" readOnly style=\"background:none;\" name=\"POS\"></td>"
                                + "<td><div style=\"width:110px;\"><input type=\"text\"  class=\"TDSER4\" maxlength=\"18\" id=\"Ser" + i + "\" name=\"Sevic\" onfocus=\"VerMCServicios('" + i + "')\"/><button  style=\"display : none;\" onclick=\"AbrirServicios('" + i + "')\" id=\"btnservi" + i + "\" class=\"BtnMatchIcon\" name=\"butoservice\"></button></div></td>"
                                + "<td><input type=\"text\" class=\"TDSER5\" maxlength=\"7\"  id=\"SerCan" + i + "\"  name=\"Cant\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER6\" maxlength=\"3\" id=\"SerUM" + i + "\" name=\"unim\" style=\"text-transform: uppercase;\" onfocus=\"QuitarMC(" + i + ");\"/></td>"
                                + "<td><input type=\"text\" class=\"TDSER8\" maxlength=\"40\" id=\"SerDes" + i + "\" name=\"des\" onfocus=\"QuitarMC(" + i + ");\" disabled/></td>"
                                + "</tr>");
                    }
                }
            }
            out.println("</tbody>");
            out.println("</table>");
        }
    }

    public String checkpos(int data) {
        String i = String.valueOf(data);
        if (data < 10) {
            i = "000" + data + "0";
        }
        if (data >= 10 && data < 100) {
            i = "00" + data + "0";
        }
        if (data >= 100 && data < 1000) {
            i = "0" + data + "0";
        }
        if (data >= 1000 && data < 10000) {
            i = data + "0";
        }
        return i;
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
