/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Usuarios;
import Entidades.usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Developer-Antonio
 */
@WebServlet(name = "peticionModuloVisualUsuario", urlPatterns = {"/peticionModuloVisualUsuario"})
public class peticionModuloVisualUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String verificarP(char per) {
        String x = "";
        if (per == '0') {
            x = "false";
        } else if (per == '1') {

            x = "true";
        }
        return x;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("Action");
            String Usuario = request.getParameter("Parametro1");
            String CtdMax = request.getParameter("Parametro2");

            switch (accion) {
                case "ValidarUsuario":
                    if (ACC_Usuarios.ObtenerInstancia().ValidarUsuario(Usuario)) {
                        out.println(1);
                    }
                    break;
                case "ConsultaUsuario":
                    if(CtdMax.length()==0){
                        CtdMax = "0";
                    }
                    ArrayList<usuarios> user = ACC_Usuarios.ObtenerInstancia().ListaUsuarioMC(Usuario, Integer.parseInt(CtdMax));
                    if (user.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < user.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + user.get(i).getUsuario() + "')\">");
                            out.println("<td>" + user.get(i).getUsuario() + "</td>");
                            out.println("<td>" + user.get(i).getNombre() + "</td>");
                            out.println("<td>" + user.get(i).getRFC() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarUsuario":
                    usuarios us = ACC_Usuarios.ObtenerInstancia().CargarUsuario(Usuario);
                    String cad = "" + us.getCentro() + ","
                            + ""+ us.getNombre()+","
                            + ""+us.getApellidoPat()+","
                            + ""+us.getApellidoMat()+","
                            + ""+us.getRFC()+","
                            + ""+us.getCorreo()+","
                            + ""+us.getTelefono()+","
                            + ""+us.getTelefono2()+","
                            + ""+us.getCalle()+","
                            + ""+us.getNumeroInt()+","
                            + ""+us.getNumeroExt()+","
                            + ""+us.getColonia()+","
                            + ""+us.getPoblacion()+","
                            + ""+us.getEstado()+","
                            + ""+us.getPais()+","
                            + ""+us.getHabilitado()+"";
                    out.println(cad);
                    break;
                case "CargarPermisos":
                    String p = ACC_Usuarios.ObtenerInstancia().VerificarPermisos(Usuario);
                    out.println(p);
                    break;
                default:
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
