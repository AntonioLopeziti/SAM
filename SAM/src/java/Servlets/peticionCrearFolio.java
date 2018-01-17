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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "peticionCrearFolio", urlPatterns = {"/peticionCrearFolio"})
public class peticionCrearFolio extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            String accion = request.getParameter("acc");
            String prefij = request.getParameter("prefijo");
            String descri = request.getParameter("descripcion");
            String cantAc = request.getParameter("ctd");
            String idioma = request.getParameter("idioma");
            String pref = request.getParameter("Prefij");
            String FolIni = request.getParameter("folioInicial");
            String FolAct = request.getParameter("folioActual");
            String FolFin = request.getParameter("folioFinal");

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
                case "GuardarDatos":
                    folios dts = new folios();
                    dts.setIdFolios(pref);
                    dts.setFolioInicial(Integer.parseInt(FolIni));
                    dts.setFolioFinal(Integer.parseInt(FolFin));
                    dts.setFolioActual(Integer.parseInt(FolAct));
                    if (ACC_Folios.ObtenerIstancia().ValidaPrefijo(pref)) {
                        if (ACC_Folios.ObtenerIstancia().ValidarFolioExistente(pref)) {
                            out.println(1);
                        } else if (ACC_Folios.ObtenerIstancia().InsertarFolio(dts)) {
                            out.println(2); // retorna el 2 si los datos se insertaron exitosamente
                        } else {
                            out.println(3); // retorna el valor si hubo error en la insercciÃ³n
                        }
                    } else {
                        out.println(0); // No existe tal folio
                    }
                    break;
                case "CargarTablafolios":
                    //LinkedList<folios> fo = ACC_Folios.ObtenerIstancia().TenerFolio();
                    ArrayList<folios> fo = ACC_Folios.ObtenerIstancia().GetAllFolios();
                    int i;
                    out.println("<table>"
                            + "<tbody>");
                    if (fo.size() > 0) {
                        for (i = 0; i < fo.size(); i++) {
                            out.println("<tr\">");
                            out.println("<td> " + fo.get(i).getIdFolios() + " </td>");
                            out.println("<td>" + fo.get(i).getFolioInicial() + "</td>");
                            out.println("<td>" + fo.get(i).getFolioFinal() + "</td>");
                            out.println("<td>" + fo.get(i).getFolioActual() + "</td>");
                            out.println("</tr>");
                        }
                        for (int j = i; j < 10; j++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }

                    } else {
                        for (int j = 0; j < 10; j++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("</tbody>"
                            + "</table>");
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
