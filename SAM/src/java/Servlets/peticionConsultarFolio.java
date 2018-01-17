/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import Entidades.folios;
import Entidades.prefijo_folio;
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
import org.json.simple.JSONArray;

/**
 *
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionConsultarFolio", urlPatterns = {"/peticionConsultarFolio"})
public class peticionConsultarFolio extends HttpServlet {

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
            String accio = request.getParameter("Acc");
            String folio = request.getParameter("Folio");
            String descr = request.getParameter("des");
            String CtdAc = request.getParameter("CtdAcc");
            String Idiom = request.getParameter("idioma");
            switch (accio) {
                case "CargarMatchFolios":
                    prefijo_folio dtsp = new prefijo_folio();
                    dtsp.setDescripcion(descr);
                    dtsp.setPrefijo(folio);
                    //String descr = "Descripcion_" + idioma + "";
                    if (CtdAc.equals("")) {
                        ArrayList<prefijo_folio> pf = ACC_Folios.ObtenerIstancia().MatchPrefijosAll(dtsp);
                        if (pf.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < pf.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + pf.get(i).getPrefijo() + "', 'cliente')\">");
                                out.println("<td>" + pf.get(i).getPrefijo() + "</td>");
                                out.println("<td>" + pf.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(0);
                        }
                    } else {
                        int limite = Integer.parseInt(CtdAc);
                        ArrayList<prefijo_folio> ps = ACC_Folios.ObtenerIstancia().MatchPrefijos(dtsp, limite);
                        if (ps.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < ps.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + ps.get(i).getPrefijo() + "', 'cliente')\">");
                                out.println("<td>" + ps.get(i).getPrefijo() + "</td>");
                                out.println("<td>" + ps.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(0);
                        }
                    }
                    break;

                case "CargarDatosFolios":
                    if (ACC_Folios.ObtenerIstancia().ValidarFolioExistente(folio)){
                        folios f = ACC_Folios.ObtenerIstancia().CargarAllDatos(folio);
                        JSONArray j = new JSONArray();
                        j.add(f.getIdFolios());
                        j.add(f.getFolioInicial());
                        j.add(f.getFolioFinal());
                        j.add(f.getFolioActual());
                        out.println(j);
                    } else {
                        out.println(0);
                    }
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
