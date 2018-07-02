/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.*;
import Entidades.usuarios;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AREConsulting
 */
@WebServlet(name = "Login", urlPatterns = {"/Autenticar"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=iso-8859-1");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Conexion c = new Conexion();
            HttpSession session = request.getSession();
            String Usuario = request.getParameter("Usuario");
            String Password = request.getParameter("Password");
            String Idioma = request.getParameter("Idioma");
            String Usuarioroot = "ADMINISTRADOR";
            String Pwdroot = "321783e29ce5511a28416a84bce3bc48a19d03ba";
            String PwdDefault = "63f10d08837efc789bdf65edb02f440bdb6a35c3";
            ACC_Usuarios consul = new ACC_Usuarios();
            /////////   Contraseña sineti.1
            ////// Verificar Conexiones y accesos
            try {
                if (Usuarioroot.equals(Usuario) && Pwdroot.equals(Password)) {
                    session.setAttribute("Usuario", Usuarioroot);
                    session.setAttribute("Idioma", Idioma);
                    out.println(4);
                } else if (c.ObtenerConexion() != null) {
                    if (consul.UsuarioHabiltado(Usuario)) {
                        if (consul.login(Usuario, Password)) {
                            if (Password.equals(PwdDefault)) {
                                out.println(6); //// Cambio de Clave
                            } else {
                                usuarios u = ACC_Usuarios.ObtenerInstancia().CargarDatosSesion(Usuario);
                                session.setAttribute("Usuario", u.getUsuario());
                                session.setAttribute("Idioma", Idioma);
                                session.setAttribute("CentroUsuario", u.getCentro());
                                out.println(1); //// Acceso al sistema SAM
                            }
                        } else {
                            out.println(5);   //// Error de credenciales de Acceso
                        }
                    } else {
                        out.println(3); ////// Usuario Deshabilitado o no esta dado de alta
                    }
                } else {
                    out.println(2); //// Hay Conexion nula en servidor local a base de datos SAM
                }
            } catch (Exception e) {
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

    public void ejecutarPrgrama() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "C:\\conexionconfig\\BFDOFFLINE.sap");
            pb.start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void CerrarNavegadores() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "taskkill -f -im chrome.exe");
            pb.start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
