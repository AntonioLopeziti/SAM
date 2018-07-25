/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reservas;
import AccesoDatos.ACC_TipoMovimientos;
import AccesoDatos.ACC_CentroCosto;
import AccesoDatos.ACC_Folios;
import AccesoDatos.Consultas;
import Entidades.almacenes;
import Entidades.centros;
import Entidades.tipo_movimiento;
import Entidades.centro_coste;
import Entidades.folios;
import Entidades.materiales;
import Entidades.plan_orden;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

/**
 *
 * @author panda
 */
@WebServlet(name = "peticionCrearReserva", urlPatterns = {"/peticionCrearReserva"})
public class peticionCrearReserva extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String Centro = request.getParameter("Centro");
            String CCosto = request.getParameter("CCossto");
            String Orden = request.getParameter("Orden");
            String Descri = request.getParameter("Descripcion");
            String Cantid = request.getParameter("Cantidad");
            String Cantidad = request.getParameter("CantidadNecesaria");
            String UnidadMedida = request.getParameter("UnidadMedida");
            String Material = request.getParameter("Material");
            String Posicion = request.getParameter("Posicion");
            String PosicionItem = request.getParameter("PosicionItem");
            String Almacen = request.getParameter("Almacen");
            String Descripcion = request.getParameter("Descripcion");
            String Random = request.getParameter("Random");
            String AlmacenDes = "";
            String Tipo = request.getParameter("Tipo");
            String Valor1 = request.getParameter("Valor1");
            String Valor2 = request.getParameter("Valor2");
            String Valor3 = request.getParameter("Valor3");
            String TipoMov = request.getParameter("TipoMov");
            String FolioF = request.getParameter("FolioF");
            String FechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String HoraActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("RE");
            String folioSAM = fo.getIdFolios() + fo.getFolioActual();
            HttpSession session = request.getSession();
            String Usu = (String) session.getAttribute("Usuario");
            
            switch (Accion) {
                case "ConsultarCentro":
                    ArrayList<centros> ce = ACC_Reservas.ObtenerInstancia().ConsultaCentrosReserva();
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ce.get(i).getCentro() + "', 'VentanaModalCentro', 'Centro')\">");
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
                case "ConsultarAlmacen":
                    ArrayList<almacenes> al = ACC_Reservas.ObtenerInstancia().ConsultaAlmacenReserva(Centro);
                    if (al.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < al.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + al.get(i).getId_almacen() + "', 'VentanaModalAlmacen', 'Almacen')\">");
                            out.println("<td>" + al.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + al.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + al.get(i).getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaTipoMovimientos":
                    ArrayList<tipo_movimiento> tmr = ACC_TipoMovimientos.ObtenerInstancia().MM_MatchTipoMovimientoReservas();
                    if (tmr.size() > 0) {
                        out.println("<select>");
                        out.println("<option></option>");
                        for (int l = 0; l < tmr.size(); l++) {
                            out.println("<option>" + tmr.get(l).getid_tipo_mov() + " - " + tmr.get(l).getdescripcion_mov() + "</option>");
                        }
                        out.println("</select>");
                    } else {
                        out.println("<select>");
                        out.println("<option></option>");
                        out.println("</select>");
                    }
                    break;
                case "ConsultarCentroCosto":
                    ArrayList<centro_coste> c = ACC_CentroCosto.ObtenerInstancia().ConsultarCentroCosteReserva(CCosto, Descri, Cantid,Usu);
                    if (c.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + c.get(i).getCentro_costo() + "', 'VentanaModalCCosto', 'CentroCoste')\">");
                            out.println("<td style=\"width:40%;\">" + c.get(i).getCentro_costo() + "</td>");
                            out.println("<td style=\"width:60%; text-align:left;\">" + c.get(i).getDescripcion() + "</td>");
                        }
                        out.println("</tbody");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrden":
                    ArrayList<plan_orden> pl = ACC_Reservas.ObtenerInstancia().MMConsultaMatchOrdenMM(Cantid, Orden, Descri);
                    if (pl.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pl.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + pl.get(i).getNum_orden() + "','VentanaModalOrden', 'Orden')\">");
                            out.println("<td style=\"width: 35%;\">" + pl.get(i).getNum_orden() + "</td>");
                            out.println("<td style=\"width: 65%; text-align: left;\">" + pl.get(i).getTexto_breve() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarMaterial":
//                  ArrayList<materiales> ma = ACC_Reservas.ObtenerInstancia().ConsultaMateriales(Material, Descri, Cantid, Centro, Almacen);
                    ArrayList<materiales> ma = ACC_Reservas.ObtenerInstancia().Matchmateriales(Material, Descri, Centro, Almacen, Cantid, Usu);
                    if (ma.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ma.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionarMate('" + ma.get(i).getNum_material() + "','" + ma.get(i).getTexto_material() + "', '" + ma.get(i).getUnidad_medida() + "', '" + Posicion + "',  'VentanaModalMateriales')\">");
                            out.println("<td style=\"width: 30%;\">" + ma.get(i).getNum_material() + "</td>");
                            out.println("<td style=\"width: 70%; text-align: left;\">" + ma.get(i).getTexto_material()+ "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarMaterial":
                    materiales mar = ACC_Reservas.ObtenerInstancia().CargarMaterial(Material, Centro, Almacen);
                    JSONArray js = new JSONArray();
                    js.add(mar.getMaterial());
                    js.add(mar.getDescripcion());
                    js.add(mar.getUnidad_medida());
                    out.println(js);
                    break;
                case "CargarTablaPos":
                    out.println("<table id=\"TabBody2\">");
                    out.println("<tbody>");
                    for (int i = 0; i < 10; i++) {
                        out.println("<tr id=\"tr" + i + "\">");
                        out.println("<td><input type=\"checkbox\" name=\"Cehckbx\" value=\"" + i + "\"/></td>");
                        out.println("<td><input type=\"text\" class='tdCMatch' id=\"tdMater" + i + "\" name=\"MaterTD\" onfocus=\"MostrarMatch('tdMater', 'matchtdmaterial', '" + i + "')\" maxlength=\"40\"/><button id=\"matchtdmaterial" + i + "\" onclick=\"MostrarMatchGridMateriales('VentanaModalMateriales', 'handle6', '" + i + "');\" name=\"matchMaterial\" class='BtnMatchIconGrid'></button></td>");
                        out.println("<td><input type=\"text\" class=\"tdSMatch\" id=\"tdCanti" + i + "\" name=\"CantiTD\" onblur=\"this.value = checkDec(this.value, 3,'" + i + "')\" onKeyPress=\"return soloNumeros(event)\" onfocus=\"QuitarMatch()\"/></td>");
                        out.println("<td><input type=\"text\" class=\"tdCMatch\" id=\"tdUmedi" + i + "\" name=\"UMediTD\" onfocus=\"QuitarMatch()\" readOnly/></td>");
                        out.println("<td><input type=\"text\" class='tdSMatch' id=\"tdDescr" + i + "\" name=\"DesciTD\" onfocus=\"QuitarMatch()\" readOnly/></td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\" id=\"temporalro\"><td>00</td><td>0000000000000000000000</td><td>0000000000000000000000000</td><td>000000000000000000000</td><td>0000000000000000000000000000000000000000000000000000000000000000000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "ValidarDato":
                    int res = ACC_Reservas.ObtenerInstancia().ValidarDato(Tipo, Valor1, Valor2, Valor3);
                    out.println(res);
                    break;
                case "RevisarFolio":
                    String ok = ACC_Reservas.ObtenerInstancia().CheckFolio(folioSAM);
                    out.println(ok);
                    break;
                case "Guardarcabacera":
                    ACC_Reservas.ObtenerInstancia().GuardaCabecera(Random, FechaActual, HoraActual, Centro, TipoMov, Almacen, CCosto, Orden, AlmacenDes, Usu );
                    break;
                case "GuardarItems":
                    ACC_Reservas.ObtenerInstancia().GuardaItems(FolioF, Chepos(PosicionItem), Material, Centro, Almacen, Cantidad, UnidadMedida, CCosto, Orden, TipoMov, Descripcion, AlmacenDes );
                    break;
                case "ActualizarFolio":
//                    ACC_Folios.ObtenerIstancia().ActualizarFolio("RE", fo.getFolioActual());
                    String fwe =  ACC_Reservas.ObtenerInstancia().FolioPos(Random);
                    out.println(fwe);
                    break;
            }
        }
    }
public String Chepos(String data) {
        int valor = Integer.parseInt(data);
        String i = data;
        if (i.length() == 5) {
            return i;
        }
        if (valor < 10) {
            i = "000" + data + "0";
        }
        if (valor >= 10 && valor < 100) {
            i = "00" + data + "0";
        }
        if (valor >= 100 && valor < 1000) {
            i = "0" + data + "0";
        }
        if (valor >= 1000 && valor < 10000) {
            i = data + "0";
        }
        return i;
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
