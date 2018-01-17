/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import AccesoDatos.Consultas;
import Entidades.folios;
import Entidades.prefijo_folio;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "peticionModificarFolio", urlPatterns = {"/peticionModificarFolio"})
public class peticionModificarFolio extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("acc");
            String prefij = request.getParameter("prefijo");
            String descri = request.getParameter("descripcion");
            String cantAc = request.getParameter("ctd");
            String idioma = request.getParameter("idioma");
            String FolIni = request.getParameter("FolioInicial");
            String FolFin = request.getParameter("folioFinal");
            String FolAct = request.getParameter("folioActual");

            switch (accion) {
                case "ConsultarMatchPrefijos":
                    prefijo_folio dtsp = new prefijo_folio();
                    dtsp.setDescripcion(descri);
                    dtsp.setPrefijo(prefij);
                    String descr = "Descripcion_" + idioma + "";
                    if (cantAc.equals("")) {
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
                        int limite = Integer.parseInt(cantAc);
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
                case "ValidarDatos":
                    if (ACC_Folios.ObtenerIstancia().ValidarFolioExistente(prefij)) {
                        folios f = ACC_Folios.ObtenerIstancia().CargarAllDatos(prefij);
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
                case "ActualzarDatos":
                    int folfi = Integer.parseInt(FolFin);
                    int folin = Integer.parseInt(FolIni);
                    int folac = Integer.parseInt(FolAct);
                    folios dts = new folios();
                    dts.setIdFolios(prefij);
                    dts.setFolioInicial(folin);
                    dts.setFolioFinal(folfi);
                    dts.setFolioActual(folac);
                    if(ACC_Folios.ObtenerIstancia().ActualizaFolio(dts)){
                        out.println(1); /// La actualizaciÃ³n fue un exito
                    } else {
                        out.println(0); /// Hubo Error en la ActualizaciÃ³n
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(peticionModificarFolio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(peticionModificarFolio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
