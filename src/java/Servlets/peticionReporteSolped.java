///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Servlets;
//
//import AccesoDatos.ACC_Centro;
//import AccesoDatos.ACC_Reportes;
//import Entidades.Reportes;
//import Entidades.centros;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// */
//@WebServlet(name = "peticionReporteSolped", urlPatterns = {"/peticionReporteSolped"})
//public class peticionReporteSolped extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            String Acc = request.getParameter("Accion");
//            switch (Acc) {
//                case "CargarCentros":
//                    ArrayList<centros> cet = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
//                    out.println("<select id=\"centro\">");
//                    for (centros ce : cet) {
//                        out.println("<option>" + ce.getCentro() + "</option>");
//                    }
//                    out.println("</select>");
//                    break;
//                case "CargarSAM":
//                    ArrayList<Reportes> rsam = ACC_Reportes.ObtenerInstancia().MCFolioSAMSolped();
//                    if (rsam.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody");
//                        for (int i = 0; i < rsam.size(); i++) {
//                            String sm = rsam.get(i).getFoliosam();
//                            out.println("<tr onclick=\"Select('" + i + "','sami','VentanaModalSAM')\">");
//                            out.println("<td>" + rsam.get(i).getFoliosam() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody");
//                        out.println("</table");
//                    } else {
//                        out.println(0);
//                    }
//                    break;
//                case "CargarSAM2":
//                    ArrayList<Reportes> rsam2 = ACC_Reportes.ObtenerInstancia().MCFolioSAMSolped();
//                    if (rsam2.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody");
//                        for (int i = 0; i < rsam2.size(); i++) {
//                            out.println("<tr ondblclick=\"Select('" + rsam2.get(i).getFoliosam() + "','samf','VentanaModalSAM2')\">");
//                            out.println("<td>" + rsam2.get(i).getFoliosam() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody");
//                        out.println("</table");
//                    } else {
//                        out.println(0);
//                    }
//                    break;
//            }
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
