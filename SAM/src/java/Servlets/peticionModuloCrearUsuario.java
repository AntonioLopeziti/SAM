/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Usuarios;
import Entidades.usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "peticionModuloCrearUsuario", urlPatterns = {"/peticionModuloCrearUsuario"})
public class peticionModuloCrearUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int evaluar(String e) {
        if (e.equals("")) {
            return 0;
        }
        return Integer.parseInt(e);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("Action");
            String usuario = request.getParameter("Usuario");
            String Passwor = request.getParameter("Password");
            String Nombre = request.getParameter("Nombre");
            String ApePate = request.getParameter("APP");
            String ApeMate = request.getParameter("APM");
            String RFC = request.getParameter("RFC");
            String Email = request.getParameter("Email");
            String Tel1 = request.getParameter("Tel1");
            String Tel2 = request.getParameter("Tel2");
            String Calle = request.getParameter("Calle");
            String NumInte = request.getParameter("NumInt");
            String NumExte = request.getParameter("NumExt");
            String Colonia = request.getParameter("Colonia");
            String Poblaci = request.getParameter("Poblacion");
            String Estado = request.getParameter("Estado");
            String Pais = request.getParameter("Pais");
            String Permisos = request.getParameter("Permisos");
            String Centro = request.getParameter("Centro");
            String habilitado = request.getParameter("hab");

            switch (accion) {
                case "ValidarUsuario":
                    if (ACC_Usuarios.ObtenerInstancia().ValidarUsuario(usuario)) {
                        out.println(1); ///// El usuario Existe
                    }
                    break;
                case "GuardarDatos":
                    usuarios u = new usuarios();
                    u.setUsuario(usuario);
                    u.setPassword(Passwor);
                    u.setNombre(Nombre);
                    u.setApellidoPat(ApePate);
                    u.setApellidoMat(ApeMate);
                    u.setRFC(RFC);
                    u.setCorreo(Email);
                    u.setTelefono(Tel1);
                    u.setTelefono2(Tel2);
                    u.setCalle(Calle);
                    if (NumInte.length() == 0) {
                        NumInte = "0";
                    }
                    u.setNumeroInt(Integer.parseInt(NumInte));
                    u.setNumeroExt(Integer.parseInt(NumExte));
                    u.setColonia(Colonia);
                    u.setPoblacion(Poblaci);
                    u.setEstado(Estado);
                    u.setPais(Pais);
                    u.setPermisos(Permisos);
                    u.setCentro(Centro);
                    u.setHabilitado(1);
                    if (ACC_Usuarios.ObtenerInstancia().InsertarUsuario(u)) {
                        out.println(5); /// Consulta Exitosa
                    } else {
                        out.println(6); /// Error al ejecutar la consulta
                    }
                    break;
                case "ModificarDatosWP":
                    usuarios us = new usuarios();
                    us.setUsuario(usuario);
                    us.setPassword(Passwor);
                    us.setNombre(Nombre);
                    us.setApellidoPat(ApePate);
                    us.setApellidoMat(ApeMate);
                    us.setRFC(RFC);
                    us.setCorreo(Email);
                    us.setTelefono(Tel1);
                    us.setTelefono2(Tel2);
                    us.setCalle(Calle);
                    if (NumInte.length() == 0) {
                        NumInte = "0";
                    }
                    us.setNumeroInt(Integer.parseInt(NumInte));
                    us.setNumeroExt(Integer.parseInt(NumExte));
                    us.setColonia(Colonia);
                    us.setPoblacion(Poblaci);
                    us.setEstado(Estado);
                    us.setPais(Pais);
                    us.setPermisos(Permisos);
                    us.setCentro(Centro);
                    us.setHabilitado(Integer.parseInt(habilitado));
                    if (ACC_Usuarios.ObtenerInstancia().ModificarUser(us)) {
                        out.println(5); /// Consulta Exitosa
                    } else {
                        out.println(6); /// Error al ejecutar la consulta
                    }
                    break;
                case "ValidarCentro":
                    int RC = ACC_Centro.ObtenerInstancia().ValidarCentro(Centro);
                    out.println(RC);
                    break;
                case "ModificarClaveDefault":
                    if (ACC_Usuarios.ObtenerInstancia().ActualizarClaveDefault(usuario, Passwor)) {
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
