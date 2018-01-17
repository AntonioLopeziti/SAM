/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Stock;
import Entidades.GrupoArticulos;
import Entidades.Almaceness;
import Entidades.almacenes;
import Entidades.centros;
import Entidades.Lotes;
import java.io.IOException;
import java.io.PrintWriter;
import Entidades.materiales;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "PeticionMaterialDenominacion", urlPatterns = {"/PeticionMaterialDenominacion"})
public class PeticionMaterialDenominacion extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("Action");
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String mate = request.getParameter("Parametro1");

            String material = request.getParameter("MATERIAL");
            String material2 = request.getParameter("MATERIAL2");
            String tipomaterial = request.getParameter("TIPOMATERIAL");
            String tipomaterial2 = request.getParameter("TIPOMATERIAL2");
            String grupoarticulos = request.getParameter("GRUPOARTICULOS");
            String grupoarticulos2 = request.getParameter("GRUPOARTICULOS2");
            String textomaterial = request.getParameter("TEXTOMATERIAL");
            String textomaterial2 = request.getParameter("TEXTOMATERIAL2");
            String almacen = request.getParameter("ALMACEN");
            String almacen2 = request.getParameter("ALMACEN2");
            String centri = request.getParameter("CENTRO");
            String centri2 = request.getParameter("CENTRO2");
            String numerolote = request.getParameter("NUMEROLOTE");
            String numerolote2 = request.getParameter("NUMEROLOTE2");
            String maximo = request.getParameter("CANTIDADMAXIMA");
            String valorcheck = request.getParameter("VL");
            String valorTras = request.getParameter("VAL");

            session.setAttribute("MiMaterial", material);
            session.setAttribute("MiMaterial2", material2);
            session.setAttribute("MiTipoMaterial", tipomaterial);
            session.setAttribute("MiTipoMaterial2", tipomaterial2);
            session.setAttribute("MiGrupoArticulos", grupoarticulos);
            session.setAttribute("MiGrupoArticulos2", grupoarticulos2);
            session.setAttribute("MiTextoMaterial", textomaterial);
            session.setAttribute("MiTextoMaterial2", textomaterial2);
            session.setAttribute("MiAlmacen", almacen);
            session.setAttribute("MiAlmacen2", almacen2);
            session.setAttribute("MiCentri", centri);
            session.setAttribute("MiCentri2", centri2);
            session.setAttribute("MiNumeroLote", numerolote);
            session.setAttribute("MiNumeroLote2", numerolote2);
            session.setAttribute("MiCantidadMaxima", maximo);
            session.setAttribute("MiCheck", valorcheck);
            session.setAttribute("MiCheckTras", valorTras);

            String texto_mate = request.getParameter("Parametro2");
            String cet = request.getParameter("Parametro3");
            String limite = request.getParameter("Parametro4");
            String valor = request.getParameter("id");
            String centro = request.getParameter("Centros");
            String descr = request.getParameter("Descrip");
            String canti = request.getParameter("Cantidad");
            String descripcion = "";
            if (idioma.equals("ES")) {
                descripcion = "descripcion_es";
            } else if (idioma.equals("EN")) {
                descripcion = "descripcion_en";
            } else {
                descripcion = null;
            }

            String mtrl = request.getParameter("MATR");
            String mtrl2 = request.getParameter("MTRN2");
            String cent = request.getParameter("CNT");
            String tpm = request.getParameter("TPM");
            String gra = request.getParameter("GAR");
            String txt = request.getParameter("TXT");
            String alma = request.getParameter("ALM");
            String lot = request.getParameter("LOT");
            String maa = request.getParameter("Parametro1");
            String dess = request.getParameter("Parametro2");
            String centrr = request.getParameter("Parametro3");
            String caat = request.getParameter("Parametro4");

            String mater = request.getParameter("MATR");
            String gart = request.getParameter("GAR");
            String txtSM = request.getParameter("TXT");
            String almace = request.getParameter("ALM");
            String lott = request.getParameter("LOT");
            String cnt = request.getParameter("CNT");
            session.setAttribute("MA", mater);
            switch (accion) {
                case "ConsultaMaterialess":
                    String no_campo = "descripcion_" + idioma;
                    ArrayList<materiales> ga = ACC_Material.ObtenerInstancia().ConsultaMatchMateriales(mate, cet, texto_mate, idioma, no_campo, limite);
                    if (ga.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ga.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ga.get(i).getMaterial() + "', 'material')\">");
                            out.println("<td>" + ga.get(i).getMaterial() + "</td>");
                            out.println("<td>" + ga.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + ga.get(i).getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchGrupoArticuloo":
                    if (idioma.equals("ES")) {
                        ArrayList<GrupoArticulos> gaa = ACC_Material.ObtenerInstancia().ConsultaMatchGrupoArticuloo(idioma);
                        if (gaa.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < gaa.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + gaa.get(i).getGrupo_articulo() + "', 'grupoarticulo')\">");
                                out.println("<td>" + gaa.get(i).getGrupo_articulo() + "</td>");
                                out.println("<td>" + gaa.get(i).getDenominacion_ES() + "</td>");
                                out.println("<td>" + gaa.get(i).getDescripcion_ES() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(0);
                        }
                    } else if (idioma.equals("EN")) {
                        ArrayList<GrupoArticulos> gaaa = ACC_Material.ObtenerInstancia().ConsultaMatchGrupoArticuloo(idioma);
                        if (gaaa.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < gaaa.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + gaaa.get(i).getGrupo_articulo() + "', 'grupoarticulo')\">");
                                out.println("<td>" + gaaa.get(i).getGrupo_articulo() + "</td>");
                                out.println("<td>" + gaaa.get(i).getDenominacion_EN() + "</td>");
                                out.println("<td>" + gaaa.get(i).getDescripcion_EN() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(0);
                        }
                    }

                    break;
                case "ConsultaCentro":
                    ArrayList<centros> ce = ACC_Centro.ObtenerInstancia().ConsultaMatchCentroo();
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ce.get(i).getCentro() + "', 'centro')\">");
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
                //Stock Material Consulta Almacen               
                case "ConsultarAlmacenn":
                    String no_campoAlm = "descripcion_" + idioma;
                    ArrayList<Almaceness> alm = ACC_Stock.ObtenerInstancia().ConsultaMatchAlmacenn(mate, texto_mate, cet, idioma, no_campoAlm, limite);
                    if (alm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < alm.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + alm.get(i).getId_almacen() + "', 'almacen')\">");
                            out.println("<td>" + alm.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + alm.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + alm.get(i).getCentro() + "</td>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarAlmacen":
                    String qers = "";
                    try {
                        int ca = Integer.parseInt(caat);
                        qers = "SELECT TOP " + ca + " * FROM almacenes WHERE id_almacen like '" + maa + "%' AND descripcion_ES like '" + dess + "%' AND centro like '" + centrr + "%'";
                    } catch (Exception e) {
                        qers = "SELECT * FROM almacenes WHERE id_almacen like '" + maa + "%' AND descripcion_ES like '" + dess + "%' AND centro like '" + centrr + "%'";
                    }
                    LinkedList<almacenes> a = ACC_Stock.ObtenerInstancia().ConsultaMatchAlmacen(qers);
                    if (a.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < a.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + a.get(i).getId_almacen() + "', 'almacen')\">");
                            out.println("<td>" + a.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + a.get(i).getNombre_alamcen() + "</td>");
                            out.println("<td>" + a.get(i).getCentro() + "</td>");
                        }
                        out.println("</tbody");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                //Consulta Lote Stock Material    
                case "ConsultaLotee":
                    if (idioma.equals("ES")) {
                        ArrayList<Lotes> l = ACC_Stock.ObtenerInstancia().ConsultaLoteStockk(idioma);
                        if (l.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < l.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + l.get(i).getLote() + "', 'lote')\">");
                                out.println("<td>" + l.get(i).getLote() + "</td>");
                                out.println("<td>" + l.get(i).getAlmacen() + "</td>");
                                out.println("<td>" + l.get(i).getCentro() + "</td>");
                                out.println("<td>" + l.get(i).getMaterial() + "</td>");
                                out.println("<td>" + l.get(i).getDescripcion_ES() + "</td>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(0);
                        }
                    } else if (idioma.equals("EN")) {
                        ArrayList<Lotes> l = ACC_Stock.ObtenerInstancia().ConsultaLoteStockk(idioma);
                        if (l.size() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < l.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + l.get(i).getLote() + "', 'lote')\">");
                                out.println("<td>" + l.get(i).getLote() + "</td>");
                                out.println("<td>" + l.get(i).getAlmacen() + "</td>");
                                out.println("<td>" + l.get(i).getCentro() + "</td>");
                                out.println("<td>" + l.get(i).getMaterial() + "</td>");
                                out.println("<td>" + l.get(i).getDescripcion_EN() + "</td>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println(0);
                        }
                    }

                    break;
                case "ConsultaLote":
                    String qeri = "SELECT * FROM MM.inventarios";
                    LinkedList<Lotes> l = ACC_Stock.ObtenerInstancia().ConsultaLoteStock(qeri);
                    if (l.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < l.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + l.get(i).getLote() + "', 'lote')\">");
                            out.println("<td>" + l.get(i).getLote() + "</td>");
                            out.println("<td>" + l.get(i).getAlmacen() + "</td>");
                            out.println("<td>" + l.get(i).getCentro() + "</td>");
                            out.println("<td>" + l.get(i).getMaterial() + "</td>");
                            out.println("<td>" + l.get(i).getDescripcion() + "</td>");
                        }
                        out.println("</tbody");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarMaterial":
                    if (ACC_Stock.ObtenerInstancia().ValidarMATR(mater)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarGrupoArticulos":
                    if (ACC_Stock.ObtenerInstancia().ValidarGRA(gart)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarTextoMaterial":
                    String no_campoTxt = "descripcion_" + idioma;
                    if (ACC_Stock.ObtenerInstancia().ValidarTXT(txtSM, no_campoTxt)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarAlmacen":
                    if (ACC_Stock.ObtenerInstancia().ValidarALM(almace)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCentro":
                    if (ACC_Stock.ObtenerInstancia().ValidarCEN(cnt)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarLote":
                    if (ACC_Stock.ObtenerInstancia().ValidarLOT(lott)) {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionMaterialDenominacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PeticionMaterialDenominacion.class.getName()).log(Level.SEVERE, null, ex);
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
