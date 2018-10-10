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
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "peticionInventario", urlPatterns = {"/peticionInventario"})
public class peticionInventario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession ses = request.getSession();
            String lan = (String) ses.getAttribute("Idioma");
            String Acc = request.getParameter("Accion");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String material = request.getParameter("material");
            String garticulo = request.getParameter("garticulo");
            String almacen = request.getParameter("almacen");
            String centro = request.getParameter("centro");
            String lote = request.getParameter("lote");
            String tipo = request.getParameter("tipo");
            switch (Acc) {
                case "ConsultaMateriales":
                    ArrayList<stock> mat = ACC_Stock.ObtenerInstancia().StockCargarMateriales(lan, v1, v2);
                    if (mat.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (v3.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(v3); i++) {
                                out.println("<tr ondblclick=\"Select('" + mat.get(i).getMaterial() + "','material','VentanaModalMaterial','BuscarParamMaterial','ConsultaTablaMaterial','namemate')\">");
                                out.println("<td>" + mat.get(i).getMaterial() + "</td>");
                                out.println("<td>" + mat.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < mat.size(); i++) {
                                out.println("<tr ondblclick=\"Select('" + mat.get(i).getMaterial() + "','material','VentanaModalMaterial','BuscarParamMaterial','ConsultaTablaMaterial','namemate')\">");
                                out.println("<td>" + mat.get(i).getMaterial() + "</td>");
                                out.println("<td>" + mat.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                    case "ConsultaMaterialesStock":
                    ArrayList<stock> mater = ACC_Stock.ObtenerInstancia().CargarMaterialesStock(lan, v1, v2);
                    if (mater.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (v3.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(v3); i++) {
                                out.println("<tr ondblclick=\"Select('" + mater.get(i).getMaterial() + "','material','VentanaModalMaterial','BuscarParamMaterial','ConsultaTablaMaterial','namemate')\">");
                                out.println("<td>" + mater.get(i).getMaterial() + "</td>");
                                out.println("<td>" + mater.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < mater.size(); i++) {
                                out.println("<tr ondblclick=\"Select('" + mater.get(i).getMaterial() + "','material','VentanaModalMaterial','BuscarParamMaterial','ConsultaTablaMaterial','namemate')\">");
                                out.println("<td>" + mater.get(i).getMaterial() + "</td>");
                                out.println("<td>" + mater.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaGrupoArticulo":
                    ArrayList<stock> ga = ACC_Stock.ObtenerInstancia().StockCargarGArticulo(lan, v1, v2);
                    if (ga.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (v3.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(v3); i++) {
                                out.println("<tr ondblclick=\"Select('" + ga.get(i).getGrupoArticulos() + "','grupoarticulo','VentanaModalGrupoArticulo','BuscarParamGrupoArticulo','ConsultaTablaGArticulo','namegart')\">");
                                out.println("<td>" + ga.get(i).getGrupoArticulos() + "</td>");
                                out.println("<td>" + ga.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < ga.size(); i++) {
                                out.println("<tr ondblclick=\"Select('" + ga.get(i).getGrupoArticulos() + "','grupoarticulo','VentanaModalGrupoArticulo','BuscarParamGrupoArticulo','ConsultaTablaGArticulo','namegart')\">");
                                out.println("<td>" + ga.get(i).getGrupoArticulos() + "</td>");
                                out.println("<td>" + ga.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarAlmacen":
                    ArrayList<stock> alm = ACC_Stock.ObtenerInstancia().StockCargarAlmacen(lan);
                    if (alm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < alm.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + alm.get(i).getAlmacen() + "','almacen','VentanaModalAlmacen','','','')\">");
                            out.println("<td>" + alm.get(i).getAlmacen() + "</td>");
                            out.println("<td>" + alm.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                case "ConsultarCentro":
                    ArrayList<stock> ce = ACC_Stock.ObtenerInstancia().StockCargarCentro();
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + ce.get(i).getCentro() + "','centro','VentanaModalCentro','','','')\">");
                            out.println("<td>" + ce.get(i).getCentro() + "</td>");
                            out.println("<td>" + ce.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarLote":
                    ArrayList<stock> lo = ACC_Stock.ObtenerInstancia().StockCargarLote(lan,material);
                    if (lo.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < lo.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + lo.get(i).getLote() + "','lote','VentanaModalLote','','','')\">");
                            out.println("<td style=\"width: 15%;\">" + lo.get(i).getLote() + "</td>");
                            out.println("<td style=\"width: 15%;\">" + lo.get(i).getNum_doc() + "</td>");
                            out.println("<td style=\"width: 10%;\">" + lo.get(i).getPos_doc() + "</td>");
                            out.println("<td style=\"width: 10%;\">" + lo.get(i).getMaterial() + "</td>");
                            out.println("<td style=\"width: 30%; text-align: left;\">" + lo.get(i).getDescripcion() + "</td>");
                            out.println("<td style=\"width: 10%;\">" + lo.get(i).getCentro() + "</td>");
                            out.println("<td style=\"width: 10%;\">" + lo.get(i).getAlmacen() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarMaterial":
                    int m = ACC_Stock.ObtenerInstancia().StockValidarMaterial(material);
                    out.println(m);
                    break;
                case "ValidarGArticulo":
                    int g = ACC_Stock.ObtenerInstancia().StockValidarGArticulo(garticulo);
                    out.println(g);
                    break;
                case "ValidarAlmacen":
                    int a = ACC_Stock.ObtenerInstancia().StockValidarAlmacen(almacen);
                    out.println(a);
                    break;
                case "ValidarCentro":
                    int c = ACC_Stock.ObtenerInstancia().StockValidarCentro(centro);
                    out.println(c);
                    break;
                case "ValidarLote":
                    int l = ACC_Stock.ObtenerInstancia().StockValidarLote(lote);
                    out.println(l);
                    break;
                case "ValidarQuery":
                    String data[] = {lan, material, garticulo, almacen, centro, lote};
                    int tip = Integer.parseInt(tipo);
                    switch (tip) {
                        case 0:
                            int q1 = ACC_Stock.ObtenerInstancia().StockValidarQueryTodo(data);
                            out.println(q1);
                            break;
                        case 1:
                            int q2 = ACC_Stock.ObtenerInstancia().StockValidarQuerySuma(data);
                            out.println(q2);
                            break;
                        case 2:
                            int q3 = ACC_Stock.ObtenerInstancia().StockValidarQueryTraslado(data);
                            out.println(q3);
                            break;
                    }
                    break;
                case "CargarTabla":
                    Properties props = new Properties();
                    props.load(getServletContext().getResourceAsStream("/WEB-INF/Language" + lan + ".properties"));
                    String materiallan = props.getProperty("etiqueta.GralMaterialAll");
                    String Descrlan = props.getProperty("etiqueta.GralDescripcion");
                    String Almaclan = props.getProperty("etiqueta.GralAlmacenAll");
                    String Centrolan = props.getProperty("etiqueta.GralCentroAll");
                    String lotelan = props.getProperty("etiqueta.STOCKNumLote");
                    String umlan = props.getProperty("etiqueta.CSPUM");
                    String galan = props.getProperty("etiqueta.STOCKGeupoArtc");
                    String stoklibre = props.getProperty("etiqueta.STOCKLibreUtili");
                    String stoktras = props.getProperty("etiqueta.STOCKStocktras");

                    String data1[] = {lan, material, garticulo, almacen, centro, lote};
                    int tipc = Integer.parseInt(tipo);
                    switch (tipc) {
                        case 0:
                            out.println("<section class=\"SecHead\">");
                            out.println("<table id=\"TabHead\">");
                            out.println("<thead>");
                            out.println("<tr>");
                            out.println("<td>" + materiallan + "</td>");
                            out.println("<td>" + Descrlan + "</td>");
                            out.println("<td>" + Almaclan + "</td>");
                            out.println("<td>" + Centrolan + "</td>");
                            out.println("<td>" + lotelan + "</td>");
                            out.println("<td>" + umlan + "</td>");
                            out.println("<td>" + galan + "</td>");
                            out.println("<td> Stk.E </td>");
                            out.println("<td>" + stoklibre + "</td>");
                            out.println("<td>" + stoktras + "</td>");
                            out.println("<td> Num.Doc. </td>");
                            out.println("<td> Pos. </td>");
                            out.println("</tr>");
                            out.println("</thead>");
                            out.println("</table>");
                            out.println("</section>");
                            out.println("<section class=\"SecBody\" id=\"SecCuerpo\">");
                            out.println("<table id=\"TabBody\">");
                            for (stock st : ACC_Stock.ObtenerInstancia().StockCargarQueryTodo(data1)) {
                                out.println("<tr>");
                                out.println("<td>" + st.getMaterial() + "</td>");
                                out.println("<td>" + st.getDescripcion() + "</td>");
                                out.println("<td>" + st.getAlmacen() + "</td>");
                                out.println("<td>" + st.getCentro() + "</td>");
                                out.println("<td>" + st.getLote() + "</td>");
                                out.println("<td>" + st.getUnidad_medida() + "</td>");
                                out.println("<td>" + st.getGrupoArticulos() + "</td>");
                                out.println("<td>" + st.getIndicador_se() + "</td>");
                                out.println("<td>" + st.getStocklibre_utilizacion() + "</td>");
                                out.println("<td>" + st.getStock_traslado() + "</td>");
                                out.println("<td>" + st.getNum_doc() + "</td>");
                                out.println("<td>" + st.getPos_doc() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\">");
                            out.println("<td>00000000000000</td>");//12
                            out.println("<td>0000000000000000000000000000000000</td>");//40
                            out.println("<td>00000000000</td>");//6
                            out.println("<td>00000000000</td>");//12
                            out.println("<td>000000000000000</td>");//12
                            out.println("<td>000000000</td>");//12
                            out.println("<td>0000000000000000</td>");//12
                            out.println("<td>000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>0000000000</td>");//12
                            out.println("</tr>");
                            out.println("</table>");
                            out.println("</section>");
                            break;
                        case 1:
                            out.println("<section class=\"SecHead\">");
                            out.println("<table id=\"TabHead\">");
                            out.println("<thead>");
                            out.println("<tr>");
                            out.println("<td>" + materiallan + "</td>");
                            out.println("<td>" + Descrlan + "</td>");
                            out.println("<td>" + Almaclan + "</td>");
                            out.println("<td>" + Centrolan + "</td>");
                            out.println("<td>" + umlan + "</td>");
                            out.println("<td>" + galan + "</td>");
                            out.println("<td>" + stoklibre + "</td>");
                            out.println("</tr>");
                            out.println("</thead>");
                            out.println("</table>");
                            out.println("</section>");
                            out.println("<section class=\"SecBody\" id=\"SecCuerpo\">");
                            out.println("<table id=\"TabBody\">");
                            for (stock sti : ACC_Stock.ObtenerInstancia().StockCargarQuerySuma(data1)) {
                                out.println("<tr>");
                                out.println("<td>" + sti.getMaterial() + "</td>");
                                out.println("<td>" + sti.getDescripcion() + "</td>");
                                out.println("<td>" + sti.getAlmacen() + "</td>");
                                out.println("<td>" + sti.getCentro() + "</td>");
                                out.println("<td>" + sti.getUnidad_medida() + "</td>");
                                out.println("<td>" + sti.getGrupoArticulos() + "</td>");
                                out.println("<td>" + sti.getStocklibre_utilizacion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\">");
                            out.println("<td>00000000000000</td>");//12
                            out.println("<td>00000000000000000000000000</td>");//40
                            out.println("<td>00000000000</td>");//6
                            out.println("<td>00000000000</td>");//12
                            out.println("<td>0000000</td>");//12
                            out.println("<td>00000000000000000</td>");//12
                            out.println("<td>00000000000</td>");//12
                            out.println("</tr>");
                            out.println("</table>");
                            out.println("</section>");
                            break;
                        case 2:
                            out.println("<section class=\"SecHead\">");
                            out.println("<table id=\"TabHead\">");
                            out.println("<thead>");
                            out.println("<tr>");
                            out.println("<td>" + materiallan + "</td>");
                            out.println("<td>" + Descrlan + "</td>");
                            out.println("<td>" + Almaclan + "</td>");
                            out.println("<td>" + Centrolan + "</td>");
                            out.println("<td>" + lotelan + "</td>");
                            out.println("<td>" + umlan + "</td>");
                            out.println("<td>" + galan + "</td>");
                            out.println("<td> Stk.E </td>");
                            out.println("<td>" + stoklibre + "</td>");
                            out.println("<td>" + stoktras + "</td>");
                            out.println("<td> Num.Doc </td>");
                            out.println("<td> Pos. </td>");
                            out.println("</tr>");
                            out.println("</thead>");
                            out.println("</table>");
                            out.println("</section>");
                            out.println("<section class=\"SecBody\" id=\"SecCuerpo\">");
                            out.println("<table id=\"TabBody\">");
                            for (stock stic : ACC_Stock.ObtenerInstancia().StockCargarQueryTraslado(data1)) {
                                out.println("<tr>");
                                out.println("<td>" + stic.getMaterial() + "</td>");
                                out.println("<td>" + stic.getDescripcion() + "</td>");
                                out.println("<td>" + stic.getAlmacen() + "</td>");
                                out.println("<td>" + stic.getCentro() + "</td>");
                                out.println("<td>" + stic.getLote() + "</td>");
                                out.println("<td>" + stic.getUnidad_medida() + "</td>");
                                out.println("<td>" + stic.getGrupoArticulos() + "</td>");
                                out.println("<td>" + stic.getIndicador_se() + "</td>");
                                out.println("<td>" + stic.getStocklibre_utilizacion() + "</td>");
                                out.println("<td>" + stic.getStock_traslado()+ "</td>");
                                out.println("<td>" + stic.getNum_doc() + "</td>");
                                out.println("<td>" + stic.getPos_doc() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\">");
                            out.println("<td>00000000000000</td>");//12
                            out.println("<td>0000000000000000000000000000000000</td>");//40
                            out.println("<td>00000000000</td>");//6
                            out.println("<td>00000000000</td>");//12
                            out.println("<td>0000000000000000000</td>");//12
                            out.println("<td>0000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>000000000</td>");//12
                            out.println("</tr>");
                            out.println("</table>");
                            out.println("</section>");
                            break;
                    }
                    break;
                case "CargarTablaReserva":
                    Properties prop = new Properties();
                    prop.load(getServletContext().getResourceAsStream("/WEB-INF/Language" + lan + ".properties"));
                    String mate = prop.getProperty("etiqueta.GralMaterialAll");
                    String Desc = prop.getProperty("etiqueta.GralDescripcion");
                    String Alma = prop.getProperty("etiqueta.GralAlmacenAll");
                    String Cent = prop.getProperty("etiqueta.GralCentroAll");
                    String lot = prop.getProperty("etiqueta.STOCKNumLote");
                    String umn = prop.getProperty("etiqueta.CSPUM");
                    String gal = prop.getProperty("etiqueta.STOCKGeupoArtc");
                    String stoklibr = prop.getProperty("etiqueta.STOCKLibreUtili");
                    String stoktra = prop.getProperty("etiqueta.STOCKStocktras");

                    String data2[] = {lan, material, almacen, centro};
                            out.println("<section class=\"SecHead\">");
                            out.println("<table id=\"TabHead\">");
                            out.println("<thead>");
                            out.println("<tr>");
                            out.println("<td>" + mate + "</td>");
                            out.println("<td>" + Desc + "</td>");
                            out.println("<td>" + Alma + "</td>");
                            out.println("<td>" + Cent + "</td>");
                            out.println("<td>" + lot + "</td>");
                            out.println("<td>" + umn + "</td>");
                            out.println("<td>" + gal + "</td>");
                            out.println("<td> Stk.E </td>");
                            out.println("<td>" + stoklibr + "</td>");
                            out.println("<td>" + stoktra + "</td>");
                            out.println("<td> Num.Doc. </td>");
                            out.println("<td> Pos. </td>");
                            out.println("</tr>");
                            out.println("</thead>");
                            out.println("</table>");
                            out.println("</section>");
                            out.println("<section class=\"SecBody\" id=\"SecCuerpo\">");
                            out.println("<table id=\"TabBody\">");
                            for (stock st : ACC_Stock.ObtenerInstancia().StockCargarQueryTodoReservas(data2)) {
                                out.println("<tr>");
                                out.println("<td>" + st.getMaterial() + "</td>");
                                out.println("<td>" + st.getDescripcion() + "</td>");
                                out.println("<td>" + st.getAlmacen() + "</td>");
                                out.println("<td>" + st.getCentro() + "</td>");
                                out.println("<td>" + st.getLote() + "</td>");
                                out.println("<td>" + st.getUnidad_medida() + "</td>");
                                out.println("<td>" + st.getGrupoArticulos() + "</td>");
                                out.println("<td>" + st.getIndicador_se() + "</td>");
                                out.println("<td>" + st.getStocklibre_utilizacion() + "</td>");
                                out.println("<td>" + st.getStock_traslado() + "</td>");
                                out.println("<td>" + st.getNum_doc() + "</td>");
                                out.println("<td>" + st.getPos_doc() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\">");
                            out.println("<td>00000000000000</td>");//12
                            out.println("<td>0000000000000000000000000000000000</td>");//40
                            out.println("<td>00000000000</td>");//6
                            out.println("<td>00000000000</td>");//12
                            out.println("<td>000000000000000</td>");//12
                            out.println("<td>000000000</td>");//12
                            out.println("<td>0000000000000000</td>");//12
                            out.println("<td>000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>0000000000000</td>");//12
                            out.println("<td>0000000000</td>");//12
                            out.println("</tr>");
                            out.println("</table>");
                            out.println("</section>");
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
