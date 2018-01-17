/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Stock;
import Entidades.stock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author AREConsulting
 */
@WebServlet(name = "PeticionStockAllMateriales", urlPatterns = {"/PeticionStockAllMateriales"})
public class PeticionStockAllMateriales extends HttpServlet {

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
        HttpSession session1 = request.getSession();
        String Idioma = (String) session1.getAttribute("Idioma");
        String materiallan = "";
        String Textibrelan = "";
        String Almaclan = "";
        String StockLi = "";
        String Stocktras = "";
        String loten = "";
        String Gartc = "";
        String Cenlan = "";
        String umlan = "";

        if (Idioma.equals("ES")) {
            Properties props = new Properties();
            props.load(getServletContext().getResourceAsStream("/WEB-INF/LanguageES.properties"));
            materiallan = props.getProperty("etiqueta.GralMaterialAll");
            Textibrelan = props.getProperty("etiqueta.GralDescripcion");
            Almaclan = props.getProperty("etiqueta.CSPAlmac");
            StockLi = props.getProperty("etiqueta.STOCKLibreUtili");
            Stocktras = props.getProperty("etiqueta.STOCKStocktras");
            loten = props.getProperty("etiqueta.STOCKNumLote");
            Gartc = props.getProperty("etiqueta.STOCKGeupoArtc");
            Cenlan = props.getProperty("etiqueta.GralCentroAll");
            umlan = props.getProperty("etiqueta.CSPUM");

        } else if (Idioma.equals("EN")) {
            Properties props = new Properties();
            props.load(getServletContext().getResourceAsStream("/WEB-INF/LanguageEN.properties"));
            materiallan = props.getProperty("etiqueta.GralMaterialAll");
            Textibrelan = props.getProperty("etiqueta.GralDescripcion");
            Almaclan = props.getProperty("etiqueta.CSPAlmac");
            StockLi = props.getProperty("etiqueta.STOCKLibreUtili");
            Stocktras = props.getProperty("etiqueta.STOCKStocktras");
            loten = props.getProperty("etiqueta.STOCKNumLote");
            Gartc = props.getProperty("etiqueta.STOCKGeupoArtc");
            Cenlan = props.getProperty("etiqueta.GralCentroAll");
            umlan = props.getProperty("etiqueta.CSPUM");
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //String ub = request.getParameter("q");
            String accion = request.getParameter("Action");
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String material = (String) session.getAttribute("MiMaterial");
            String material2 = (String) session.getAttribute("MiMaterial2");
            String tipomaterial = (String) session.getAttribute("MiTipoMaterial");
            String grupoarticulos = (String) session.getAttribute("MiGrupoArticulos");
            String textomaterial = (String) session.getAttribute("MiTextoMaterial");
            String almacen = (String) session.getAttribute("MiAlmacen");
            String centro = (String) session.getAttribute("MiCentri");
            String numerolote = (String) session.getAttribute("MiNumeroLote");
            String limite = (String) session.getAttribute("MiCantidadMaxima");
            String che = (String) session.getAttribute("MiCheck");
            String cheTras = (String) session.getAttribute("MiCheckTras");
            String vl = request.getParameter("VL");
            String val = request.getParameter("VAL");
            String canti = request.getParameter("CANTI");
            if (limite.equals("")) {
                limite = "10000";
            } else {
                limite = limite;
            }
            switch (accion) {

                case "ConsultaVacia":
                    if (che.equals("1")) {
                        String like = "(stocklibre_utilizacion <> '0.000' OR stock_bloqueado <> '0.000' OR stockcontrol_calidad <> '0.000' OR stock_traslado <> '0.000' )";
                        String cant = "'0.000'";
                        String no_campo = "descripcion_" + idioma;
                        out.println("<section class=\"SecHead\">");
                        out.println("<table id=\"TabHead\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<td>" + materiallan + "</td>");
                        out.println("<td>" + Textibrelan + "</td>");
                        out.println("<td>" + Almaclan + "</td>");
                        out.println("<td>" + StockLi + "</td>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("</table>");
                        out.println("</section>");
                        out.println("<section class=\"SecBody\" id=\"SecCuerpo\">");
                        out.println("<table id=\"TabBody\">");
                        ACC_Stock stockConsSumVa = new ACC_Stock();
                        for (stock st : stockConsSumVa.ConsultaStockMaTodosSumVa(che, cheTras, no_campo, limite, like, cant)) {
                            out.println("<tr>");
                            out.println("<td>" + st.getMaterial() + "</td>");
                            out.println("<td>" + st.getDescripcion() + "</td>");
                            out.println("<td>" + st.getAlmacen() + "</td>");
                            out.println("<td>" + st.getStocklibre_utilizacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">");
                        out.println("<td>0000000000</td>");//12
                        out.println("<td>0000000000000</td>");//40
                        out.println("<td>00000000</td>");//6
                        out.println("<td>0000000000</td>");//12
                        out.println("</tr>");
                        out.println("</table>");
                        out.println("</section>");
                    } else {
                        String like = "(stocklibre_utilizacion <> '0.000' OR stock_bloqueado <> '0.000' OR stockcontrol_calidad <> '0.000' OR stock_traslado <> '0.000' )";
                        String cant = "'0.000'";
                        String no_campo = "descripcion_" + idioma;
                        out.println("<section class=\"SecHead\">");
                        out.println("<table id=\"TabHead\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<td>" + materiallan + "</td>");
                        out.println("<td>" + Textibrelan + "</td>");
                        out.println("<td>" + Cenlan + "</td>");
                        out.println("<td>" + umlan + "</td>");
                        out.println("<td>" + Almaclan + "</td>");
                        out.println("<td>" + StockLi + "</td>");
                        out.println("<td>" + Stocktras + "</td>");
                        out.println("<td>" + loten + "</td>");
                        out.println("<td>" + Gartc + "</td>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("</table>");
                        out.println("</section>");
                        out.println("<section class=\"SecBody\" id=\"SecCuerpo\">");
                        out.println("<table id=\"TabBody\">");
                        ACC_Stock stockConsVa = new ACC_Stock();
                        for (stock st : stockConsVa.ConsultaStockMaterialess(che, cheTras, no_campo, limite, like, cant)) {
                            out.println("<tr>");
                            out.println("<td>" + st.getMaterial() + "</td>");
                            out.println("<td>" + st.getDescripcion() + "</td>");
                            out.println("<td>" + st.getCentro() + "</td>");
                            out.println("<td>" + st.getUnidad_medida() + "</td>");
                            out.println("<td>" + st.getAlmacen() + "</td>");
                            out.println("<td>" + st.getStocklibre_utilizacion() + "</td>");
                            out.println("<td>" + st.getStock_traslado() + "</td>");
                            out.println("<td>" + st.getLote() + "</td>");
                            out.println("<td>" + st.getGrupoArticulos() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">");
                        out.println("<td>0000000</td>");//12
                        out.println("<td>0000000000000</td>");//40
                        out.println("<td>0000000</td>");//4
                        out.println("<td>000000</td>");//4
                        out.println("<td>00000000</td>");//6
                        out.println("<td>0000000000</td>");//12
                        out.println("<td>0000000000</td>");//12
                        out.println("<td>0000000000</td>");//12
                        out.println("<td>0000000000</td>");//12
                        out.println("</tr>");
                        out.println("</table>");
                        out.println("</section>");
                    }
                    break;
                case "ConsultaTodos":
                    if (che.equals("1")) {
                        String lik = "(stocklibre_utilizacion <> '0.000' OR stock_bloqueado <> '0.000' OR stockcontrol_calidad <> '0.000' OR stock_traslado <> '0.000' )";
                        String cantid = "'0.000'";
                        String no_campoSum = "descripcion_" + idioma;
                        out.println("<section class=\"SecHead\">");
                        out.println("<table id=\"TabHead\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<td>" + materiallan + "</td>");
                        out.println("<td>" + Textibrelan + "</td>");
                        out.println("<td>" + Almaclan + "</td>");
                        out.println("<td>" + StockLi + "</td>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("</table>");
                        out.println("</section>");
                        out.println("<section class=\"SecBody\" id=\"SecCuerpo\">");
                        out.println("<table id=\"TabBody\">");
                        ACC_Stock stockConsSum = new ACC_Stock();
                        for (stock st : stockConsSum.ConsultaStockMaTodosSum(material, grupoarticulos, textomaterial, almacen, centro, numerolote, che, cheTras, no_campoSum, limite, lik, cantid)) {
                            out.println("<tr>");
                            out.println("<td>" + st.getMaterial() + "</td>");
                            out.println("<td>" + st.getDescripcion() + "</td>");
                            out.println("<td>" + st.getAlmacen() + "</td>");
                            out.println("<td>" + st.getStocklibre_utilizacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">");
                        out.println("<td>000000000000</td>");//12
                        out.println("<td>00000000000</td>");//40
                        out.println("<td>000000</td>");//6
                        out.println("<td>000000000000</td>");//12
                        out.println("</tr>");
                        out.println("</table>");
                        out.println("</section>");
                    } else {

                        String likeT = "(stocklibre_utilizacion <> '0.000' OR stock_bloqueado <> '0.000' OR stockcontrol_calidad <> '0.000' OR stock_traslado <> '0.000' )";
                        String cantT = "'0.000'";
                        String no_campoT = "descripcion_" + idioma;
                        out.println("<section class=\"SecHead\">");
                        out.println("<table id=\"TabHead\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<td>" + materiallan + "</td>");
                        out.println("<td>" + Textibrelan + "</td>");
                        out.println("<td>" + Cenlan + "</td>");
                        out.println("<td>" + umlan + "</td>");
                        out.println("<td>" + Almaclan + "</td>");
                        out.println("<td>" + StockLi + "</td>");
                        out.println("<td>" + Stocktras + "</td>");
                        out.println("<td>" + loten + "</td>");
                        out.println("<td>" + Gartc + "</td>");
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("</table>");
                        out.println("</section>");
                        out.println("<section class=\"SecBody\" id=\"SecCuerpo\">");
                        out.println("<table id=\"TabBody\">");
                        out.println("</tr>");
                        ACC_Stock stockConsTo = new ACC_Stock();
                        for (stock st : stockConsTo.ConsultaStockMaTodos(material, grupoarticulos, textomaterial, almacen, centro, numerolote, che, cheTras, no_campoT, limite, likeT, cantT)) {
                            out.println("<tr>");
                            out.println("<td>" + st.getMaterial() + "</td>");
                            out.println("<td>" + st.getDescripcion() + "</td>");
                            out.println("<td>" + st.getCentro() + "</td>");
                            out.println("<td>" + st.getUnidad_medida() + "</td>");
                            out.println("<td>" + st.getAlmacen() + "</td>");
                            out.println("<td>" + st.getStocklibre_utilizacion() + "</td>");
                            out.println("<td>" + st.getStock_traslado() + "</td>");
                            out.println("<td>" + st.getLote() + "</td>");
                            out.println("<td>" + st.getGrupoArticulos() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">");
                        out.println("<td>0000000</td>");//12
                        out.println("<td>0000000000000</td>");//40
                        out.println("<td>0000000</td>");//4
                        out.println("<td>000000</td>");//4
                        out.println("<td>00000000</td>");//6
                        out.println("<td>0000000000</td>");//12
                        out.println("<td>0000000000</td>");//12
                        out.println("<td>0000000000</td>");//12
                        out.println("<td>0000000000</td>");//12
                        out.println("</tr>");
                        out.println("</table>");
                        out.println("</section>");
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
