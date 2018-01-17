/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_PlanOrden;
import AccesoDatos.ACC_PuestoTrabajo;
import AccesoDatos.ACC_UbicacionTecnica;
import AccesoDatos.Consultas;
import Entidades.clase_orden;
import Entidades.equipos;
import Entidades.plan_orden;
import Entidades.puesto_trabajo;
import Entidades.ubicacion_tecnica;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio
 */
@WebServlet(name = "peticionModuloListaOrdenes", urlPatterns = {"/peticionModuloListaOrdenes"})
public class peticionModuloListaOrdenes extends HttpServlet {

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
            String Accion = request.getParameter("acc");
            String Cant = request.getParameter("ctd");
            String Idioma = request.getParameter("Idioma");
            String orden = request.getParameter("ord");
            String orden2 = request.getParameter("ord2");
            String sam = request.getParameter("sam");
            String dsam = request.getParameter("DSAM");
            String texto = request.getParameter("texto");
            String ClaseOrden = request.getParameter("ClaseOrden");
            String TextoBreve = request.getParameter("TextoBreve");
            String Ubicacion = request.getParameter("Ubicacion");
            String DUbicacion = request.getParameter("DUbicacion");
            String Equipo = request.getParameter("Equipo");
            String DEquipo = request.getParameter("DEquipo");
            String Centro = request.getParameter("Centro");
            String Puesto = request.getParameter("Puesto");
            String DPuesto = request.getParameter("DPuesto");
            String Fecha = request.getParameter("Fecha");
//            Variables Receibidas
            String cl1 = request.getParameter("cl1");
            String cl2 = request.getParameter("cl2");
            String or1 = request.getParameter("or1");
            String or2 = request.getParameter("or2");
            String sa1 = request.getParameter("sa1");
            String sa2 = request.getParameter("sa2");
            String tb1 = request.getParameter("tb1");
            String tb2 = request.getParameter("tb2");
            String ub1 = request.getParameter("ub1");
            String ub2 = request.getParameter("ub2");
            String ep1 = request.getParameter("ep1");
            String ep2 = request.getParameter("ep2");
            String po1 = request.getParameter("po1");
            String po2 = request.getParameter("po2");
            String fc1 = request.getParameter("fc1");
            String fc2 = request.getParameter("fc2");
            String abi = request.getParameter("abi");
            String lib = request.getParameter("lib");
            String cte = request.getParameter("cte");
            Consultas con = new Consultas();
            switch (Accion) {
                case "ConsultaMatchClaseOrden":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<clase_orden> c = ACC_Orden.ObtenerInstancia().SP_MatchClaseOrdenListaorden(Cant, Idioma, ClaseOrden, TextoBreve);
                    if (c.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + c.get(i).getClase_orden() + "', 'ClaseOrden')\">");
                            out.println("<td>" + c.get(i).getClase_orden() + "</td>");
                            out.println("<td>" + c.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchClaseOrden2":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<clase_orden> c2 = ACC_Orden.ObtenerInstancia().SP_MatchClaseOrdenListaorden(Cant, Idioma, ClaseOrden, TextoBreve);
                    if (c2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c2.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + c2.get(i).getClase_orden() + "', 'ClaseOrden2')\">");
                            out.println("<td>" + c2.get(i).getClase_orden() + "</td>");
                            out.println("<td>" + c2.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrdenes":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<plan_orden> pl = ACC_Orden.ObtenerInstancia().SP_MatchOrdenListaorden(Cant, orden, texto);
                    if (pl.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pl.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + pl.get(i).getNum_orden() + "','Orden')\">");
                            out.println("<td>" + pl.get(i).getNum_orden() + "</td>");
                            out.println("<td>" + pl.get(i).getTexto_breve() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrdenessam":
                    ArrayList<plan_orden> sl = ACC_Orden.ObtenerInstancia().SP_MatchOrdenListaordenSAM(sam, dsam);
                    if (sl.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (Cant.length() > 0) {
                            for (int i = 0; i < sl.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + sl.get(i).getFolio_sam() + "','SAM')\">");
                                out.println("<td>" + sl.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + sl.get(i).getTexto_breve() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < Integer.parseInt(Cant); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + sl.get(i).getFolio_sam() + "','SAM')\">");
                                out.println("<td>" + sl.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + sl.get(i).getTexto_breve() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrdenessam2":
                    ArrayList<plan_orden> sl2 = ACC_Orden.ObtenerInstancia().SP_MatchOrdenListaordenSAM(sam, dsam);
                    if (sl2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (Cant.length() > 0) {
                            for (int i = 0; i < sl2.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + sl2.get(i).getFolio_sam() + "','SAM2')\">");
                                out.println("<td>" + sl2.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + sl2.get(i).getTexto_breve() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < Integer.parseInt(Cant); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + sl2.get(i).getFolio_sam() + "','SAM2')\">");
                                out.println("<td>" + sl2.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + sl2.get(i).getTexto_breve() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrdenes2":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<plan_orden> pl1 = ACC_Orden.ObtenerInstancia().SP_MatchOrdenListaorden(Cant, orden, texto);
                    if (pl1.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pl1.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + pl1.get(i).getNum_orden() + "','Orden2')\">");
                            out.println("<td>" + pl1.get(i).getNum_orden() + "</td>");
                            out.println("<td>" + pl1.get(i).getTexto_breve() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchUbicacion":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<ubicacion_tecnica> u = ACC_UbicacionTecnica.ObtenerInstancia().SP_MatchUbitecListaorden(Cant, Idioma, Ubicacion, DUbicacion);
                    if (u.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < u.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + u.get(i).getUbicacion_tecnica() + "', 'UbicacionTec')\">");
                            out.println("<td>" + u.get(i).getUbicacion_tecnica() + "</td>");
                            out.println("<td>" + u.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchUbicacion2":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<ubicacion_tecnica> u2 = ACC_UbicacionTecnica.ObtenerInstancia().SP_MatchUbitecListaorden(Cant, Idioma, Ubicacion, DUbicacion);
                    if (u2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < u2.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + u2.get(i).getUbicacion_tecnica() + "', 'UbicacionTec2')\">");
                            out.println("<td>" + u2.get(i).getUbicacion_tecnica() + "</td>");
                            out.println("<td>" + u2.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchEquipo":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<equipos> eq = ACC_Equipos.ObtenerInstancia().SP_MatchEquiposListaorden(Cant, Idioma, Equipo, DEquipo);
                    if (eq.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < eq.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + eq.get(i).getNum_equipo() + "', 'Equipo')\">");
                            out.println("<td>" + eq.get(i).getNum_equipo() + "</td>");
                            out.println("<td>" + eq.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchEquipo2":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<equipos> eq2 = ACC_Equipos.ObtenerInstancia().SP_MatchEquiposListaorden(Cant, Idioma, Equipo, DEquipo);
                    if (eq2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < eq2.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + eq2.get(i).getNum_equipo() + "', 'Equipo2')\">");
                            out.println("<td>" + eq2.get(i).getNum_equipo() + "</td>");
                            out.println("<td>" + eq2.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchPuesto":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<puesto_trabajo> pu = ACC_PuestoTrabajo.ObtenerInstancia().SP_MatchPuestoListaorden(Cant, Idioma, Puesto, DPuesto);
                    if (pu.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pu.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + pu.get(i).getPuesto_trabajo() + "', 'Puesto')\">");
                            out.println("<td>" + pu.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + pu.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMatchPuesto2":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<puesto_trabajo> pu2 = ACC_PuestoTrabajo.ObtenerInstancia().SP_MatchPuestoListaorden(Cant, Idioma, Puesto, DPuesto);
                    if (pu2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pu2.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + pu2.get(i).getPuesto_trabajo() + "', 'Puesto2')\">");
                            out.println("<td>" + pu2.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + pu2.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarOrden":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarOrden(orden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarSAM(sam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarClase":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarClase(ClaseOrden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarUbitec":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarUbitec(Ubicacion)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarEquipo":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarEquipo(Equipo)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarPuesto":
                    if (ACC_PlanOrden.ObtenerInstancia().PM_ListaOrdenesValidarPuesto(Puesto)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarQuery":
                    String fec1 = con.DateFormatGuion(fc1);
                    String fec2 = con.DateFormatGuion(fc2);
                    String[] data = {cl1, cl2, or1, or2, sa1, sa2, tb1, tb2, ub1, ub2, ep1, ep2, po1, po2, fec1, fec2, abi, lib, cte};
                    ArrayList<plan_orden> pa = ACC_PlanOrden.ObtenerInstancia().ConsultaQuerySAP(data);
                    ArrayList<plan_orden> sa = ACC_PlanOrden.ObtenerInstancia().ConsultaQuerySAM(data);
                    int p = pa.size();
                    int s = sa.size();
                    int to = p + s;
                    out.println(to);
                    break;
                case "CargarTabla":
                    String fec11 = con.DateFormatGuion(fc1);
                    String fec22 = con.DateFormatGuion(fc2);
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    String[] datas = {cl1, cl2, or1, or2, sa1, sa2, tb1, tb2, ub1, ub2, ep1, ep2, po1, po2, fec11, fec22, abi, lib, cte};
                    ArrayList<plan_orden> pa1 = ACC_PlanOrden.ObtenerInstancia().ConsultaQuerySAP(datas);
                    ArrayList<plan_orden> pa2 = ACC_PlanOrden.ObtenerInstancia().ConsultaQuerySAM(datas);
                    ArrayList<plan_orden> pf = new ArrayList<>();
                    pa1.addAll(pa2);
                    pf.addAll(pa1);
                    Collections.sort(pf, new Comparator<plan_orden>() {
                        public int compare(plan_orden o1, plan_orden o2) {
                            return o1.getFecha_inicio_extrema().compareTo(o2.getFecha_inicio_extrema());
                        }
                    });
                    for (plan_orden p1 : pf) {
                        out.println("<tr ondblclick=\"seleccionarOrden('" + p1.getNum_orden() + "','" + p1.getFolio_sam() + "')\">");
                        out.println("<td>" + p1.getClase_doc_ventas() + "</td>");
                        out.println("<td>" + p1.getNum_orden() + "</td>");
                        out.println("<td>" + p1.getFolio_sam() + "</td>");
                        out.println("<td>" + p1.getTexto_breve() + "</td>");
                        out.println("<td>" + p1.getUbicacion_tecnica() + "</td>");
                        out.println("<td>" + p1.getNum_equipo() + "</td>");
                        out.println("<td>" + DateFormat(p1.getFecha_inicio_extrema()) + "</td>");
                        out.println("<td><img src='images/" + SemaforoFecha(p1.getFecha_inicio_extrema()) + ".PNG' /></td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>00000000000000000</td>");
                    out.println("<td>00000000000000000</td>");
                    out.println("<td>000000000000000000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>0000000000</td>");
                    out.println("</tr");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
            }
        }
    }

    public String SemaforoFecha(String fecha) {
        String icon = "advertencia";
        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String Servidor = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
        try {
            Date Ser = sf.parse(Servidor);
            Date fec = sf.parse(fecha);
            Date f31 = sumarDiasAFecha(31);
            if (Ser.after(fec) || Ser.equals(fec)) {
                icon = "@0AQStatus@";
            } else if (fec.after(f31)) {
                icon = "@08QStatus@";
            } else {
                icon = "@09QStatus@";
            }

        } catch (ParseException ex) {
            Logger.getLogger(peticionModuloListaOrdenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return icon;
    }

    public Date sumarDiasAFecha(int dias) {
        Calendar calendar = Calendar.getInstance();
        Date fecha = new Date();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public String DateFormat(String date) {
        String fec = "";
        DateFormat fe1 = new SimpleDateFormat("dd-MM-yyyy");
        try {

            DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sf.parse(date);
            fec = fe1.format(d);

        } catch (ParseException ex) {
            Logger.getLogger(peticionModuloListaOrdenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fec;
    }

    public int compare(plan_orden o1, plan_orden o2) {
        return o1.getFecha_inicio_extrema().compareTo(o2.getFecha_inicio_extrema());
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
