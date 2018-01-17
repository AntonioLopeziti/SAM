/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Solped_cabecera;
import AccesoDatos.ACC_Solped_posiciones;
import Entidades.solped_cabecera;
import Entidades.Solped_posiciones;
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
 * @author JaroMX
 */
@WebServlet(name = "ModulovisualizarSolped", urlPatterns = {"/ModulovisualizarSolped"})
public class ModulovisualizarSolped extends HttpServlet {

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
            String accion = request.getParameter("Action");
            String idioma = request.getParameter("Idioma");
            String ctdmax = request.getParameter("cdtmax");
            
            /*Validar folio sap/sam */
            String sap = request.getParameter("sap");
            String sam = request.getParameter("sam");
            /*Consulta Folio SAP/SAM*/
            String folio = request.getParameter("folio");
            String type = request.getParameter("tipo");
            switch(accion){
                case"ValidarfolioSAP":
                    String tipo = "sap";
                    String query1 = "SELECT folio_sap FROM solped_cabecera_vis WHERE folio_sap = '"+sap+"'";
                    boolean val = ACC_Solped_cabecera.ObtenerInstancia().ValidarFolio(query1, sap, tipo);
                    if (val == true){
                        out.println(1);
                    }
                break;
                case"ValidarfolioSAM":
                    String tipo1 = "sam";
                    String query2 = "SELECT folio_sam FROM solped_cabecera_vis WHERE folio_sam = '"+sam+"'";
                    boolean val1 = ACC_Solped_cabecera.ObtenerInstancia().ValidarFolio(query2, sam, tipo1);
                    if (val1 == true){
                        out.println(1);
                    }
                break;
                case"ConsultaFolioSAP":
                    int a = Integer.parseInt(ctdmax);
                    tipo = "sap";
                    String query3 = "SELECT DISTINCT TOP "+a+" * FROM solped_cabecera_vis WHERE folio_"+tipo+" LIKE '"+folio+"%'";
                    LinkedList<solped_cabecera> sc = ACC_Solped_cabecera.ObtenerInstancia().CargarFolios(query3, tipo);
                        if (sc.size() > 0){
                            out.println("<table>");
                            out.println("<tbody>");
                                for (int i = 0; i < sc.size(); i++){
                                    out.println("<tr ondblclick=\"Select('" + sc.get(i).getFolio() + "','sap')\">");
                                    out.println("<td>" + sc.get(i).getFolio() + "</td>");
                                    out.println("</tr>");
                                }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                        out.println(0);
                        }
                break;
                case"ConsultaFolioSAM":
                    a = Integer.parseInt(ctdmax);
                    tipo = "sam";
                    query3 = "SELECT DISTINCT TOP "+a+" * FROM solped_cabecera_vis WHERE folio_"+tipo+" LIKE '"+folio+"%'";
                    LinkedList<solped_cabecera> s = ACC_Solped_cabecera.ObtenerInstancia().CargarFolios(query3, tipo);
                        if (s.size() > 0){
                            out.println("<table>");
                            out.println("<tbody>");
                                for (int i = 0; i < s.size(); i++){
                                    out.println("<tr ondblclick=\"Select('" + s.get(i).getFolio() + "','sam')\">");
                                    out.println("<td>" + "00000" + s.get(i).getFolio() + "</td>");
                                    out.println("</tr>");
                                }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                        out.println(0);
                        }
                break;
                case "CargarDatos":
                Solped_posiciones pos = ACC_Solped_posiciones.ObtenerInstancia().CargarDatos(folio, type);
                out.println("<input type=\"text\" value=\"" + pos.getFolio_sam() + "\" id=\"Folio_VSP\"/> ");
                out.println("<input type=\"text\" value=\"" + pos.getGrupo_compras() + "\" id=\"GrupoCompras_VSP\"/> ");
                out.println("<input type=\"text\" value=\"" + pos.getOrganización_compras() + "\" id=\"Orgcompras_VSP\"/> ");
                out.println("<input type=\"text\" value=\"" + pos.getTexto_cabecera() + "\" id=\"Textocaecera_VSP\"/> ");
                break;
                case "CargarDatosTabla":
                String tipofolio ="folio_"+type;
                String query = "SELECT * FROM  solped_posiciones_vis WHERE "+tipofolio+" = '"+folio+"'";
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
