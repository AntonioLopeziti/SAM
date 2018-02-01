/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_PlanOrden;
import AccesoDatos.ACC_Material;
import AccesoDatos.Consultas;
import Entidades.clase_orden;
import Entidades.plan_orden;
import Entidades.materiales;
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
 * @author Jhonatan
 */
@WebServlet(name = "PeticionModuloListaOrdenesPP", urlPatterns = {"/PeticionModuloListaOrdenesPP"})
public class PeticionModuloListaOrdenesPP extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
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
            String Mate = request.getParameter("Mate");
            String DenMate = request.getParameter("DenMate");
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
//            String ub1 = request.getParameter("ub1");
//            String ub2 = request.getParameter("ub2");
            String ep1 = request.getParameter("ep1");
            String ep2 = request.getParameter("ep2");
//            String po1 = request.getParameter("po1");
//            String po2 = request.getParameter("po2");
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
                    ArrayList<clase_orden> c = ACC_PlanOrden.ObtenerInstancia().SP_MatchClaseOrdenListaordenPP(Cant, Idioma, ClaseOrden, TextoBreve);
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
                case "ConsultarOrdenes":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<plan_orden> pl = ACC_PlanOrden.ObtenerInstancia().SP_MatchOrdenListaordenPP(Cant, orden, texto);
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
                    ArrayList<plan_orden> sl = ACC_PlanOrden.ObtenerInstancia().SP_MatchOrdenListaordenSAMPP(sam, dsam);
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
                case "ConsultaMatchMaterial":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<materiales> eq = ACC_Material.ObtenerInstancia().SP_MatchMateListaordenPP(Cant, Idioma, Mate, DenMate);
                    if (eq.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < eq.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + eq.get(i).getMaterial() + "', 'Equipo')\">");
                            out.println("<td>" + eq.get(i).getMaterial() + "</td>");
                            out.println("<td>" + eq.get(i).getDescripcion() + "</td>");
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
                    ArrayList<clase_orden> c2 = ACC_PlanOrden.ObtenerInstancia().SP_MatchClaseOrdenListaordenPP(Cant, Idioma, ClaseOrden, TextoBreve);
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
                case "ConsultaMatchMate2":
                    if (Cant.length() == 0) {
                        Cant = "999";
                    }
                    ArrayList<materiales> eq2 = ACC_Material.ObtenerInstancia().SP_MatchMateListaordenPP(Cant, Idioma, Mate, DenMate);
                    if (eq2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < eq2.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + eq2.get(i).getMaterial() + "', 'Equipo2')\">");
                            out.println("<td>" + eq2.get(i).getMaterial() + "</td>");
                            out.println("<td>" + eq2.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarClase":
                    if (ACC_PlanOrden.ObtenerInstancia().PP_ListaOrdenesValidarClasePP(ClaseOrden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;                
                case "ValidarOrden":
                    if (ACC_PlanOrden.ObtenerInstancia().PP_ListaOrdenesValidarOrdenPP(orden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    if (ACC_PlanOrden.ObtenerInstancia().PP_ListaOrdenesValidarSAMPP(sam)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarEquipo":
                    if (ACC_PlanOrden.ObtenerInstancia().PP_ListaOrdenesValidarEqMaterialPP(Mate)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarQuery":
                    String fec1 = con.DateFormatGuion(fc1);
                    String fec2 = con.DateFormatGuion(fc2);
//                    String[] data = {cl1, cl2, or1, or2, sa1, sa2, tb1, tb2, ub1, ub2, ep1, ep2, po1, po2, fec1, fec2, abi, lib, cte};
                    String[] data = {cl1, cl2, or1, or2, sa1, sa2, tb1, tb2, ep1, ep2, fec1, fec2, abi, lib, cte};
                    ArrayList<plan_orden> pa = ACC_PlanOrden.ObtenerInstancia().ConsultaQuerySAPPP(data);
                    ArrayList<plan_orden> sa = ACC_PlanOrden.ObtenerInstancia().ConsultaQuerySAMPP(data);
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
//                    String[] datas = {cl1, cl2, or1, or2, sa1, sa2, tb1, tb2, ub1, ub2, ep1, ep2, po1, po2, fec11, fec22, abi, lib, cte};
                    String[] datas = {cl1, cl2, or1, or2, sa1, sa2, tb1, tb2, ep1, ep2, fec11, fec22, abi, lib, cte};
                    ArrayList<plan_orden> pa1 = ACC_PlanOrden.ObtenerInstancia().ConsultaQuerySAPPP(datas);
                    ArrayList<plan_orden> pa2 = ACC_PlanOrden.ObtenerInstancia().ConsultaQuerySAMPP(datas);
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
                        out.println("<td>" + p1.getNum_equipo() + "</td>");
                        out.println("<td>" + DateFormat(p1.getFecha_inicio_extrema()) + "</td>");
                        out.println("<td></td>");
                        out.println("<td></td>");
                        out.println("<td><img src='images/" + SemaforoFecha(p1.getFecha_inicio_extrema()) + ".PNG' /></td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>00000000000000000</td>");
                    out.println("<td>00000000000000000</td>");
                    out.println("<td>000000000000000000000000000000000000000000</td>");
                    out.println("<td>000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000</td>");
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
