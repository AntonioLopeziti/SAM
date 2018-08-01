/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Usuarios;
import AccesoDatos.Conexion;
import Entidades.usuarioRoot;
import Entidades.usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "Conexiones", urlPatterns = {"/Conexiones"})
public class Conexiones extends HttpServlet {

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
            usuarioRoot u = new usuarioRoot();
            String Action = request.getParameter("Accion");
            String Usuario = request.getParameter("Usuario");
            String PwdDefault = "63f10d08837efc789bdf65edb02f440bdb6a35c3";
            //// Conexion Local            
            u.setUsuarioSAM(request.getParameter("User"));
            u.setPasswordSAM(request.getParameter("Pwd"));
            u.setServidorSAM(request.getParameter("Server"));
            u.setPuertoSAM(request.getParameter("Port"));
            u.setBaseDatosSAM(request.getParameter("DB"));
            u.setWebService(request.getParameter("WS"));
            Conexion cnx = new Conexion();
            switch (Action) {
                case "CargarDatosServidor":
                    String[] data = cnx.CargarDatos();
                    if (data[0].length() > 0) {
                        JSONArray Jd = new JSONArray();
                        Jd.add(data[0]);
                        Jd.add(data[1]);
                        Jd.add(data[2]);
                        Jd.add(data[3]);
                        Jd.add(data[4]);
//                        Jd.add(data[5]);
                        out.println(Jd);
                    } else {
                        out.println(0);
                    }
                    break;

                case "ConexionSAM":
                    boolean CheckCnx = cnx.ProbarConexionLocal(u);
                    if (CheckCnx) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;

                case "SaveConexion":
                    boolean save = cnx.GuardarConfiguracion(u);
                    if (save == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;

                case "SaveWS":
                    boolean saveWS = cnx.GuardarWS(u);
                    if (saveWS == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarUsuario":
                    Conexion co = new Conexion();
                    Connection con = co.ObtenerConexion();
                    if (con != null) {
                        ArrayList<usuarios> user = ACC_Usuarios.ObtenerInstancia().CargarUsuarioReset();
                        if (user.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < user.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + user.get(i).getUsuario() + "','" + user.get(i).getNombre() + "')\">");
                                out.println("<td>" + user.get(i).getUsuario() + "</td>");
                                out.println("<td>" + user.get(i).getNombre() + "</td>");
                                out.println("<td>" + user.get(i).getCentro() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ResetClave":
                    int n = ACC_Usuarios.ObtenerInstancia().ResetUser(Usuario, PwdDefault);
                    out.println(n);
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
