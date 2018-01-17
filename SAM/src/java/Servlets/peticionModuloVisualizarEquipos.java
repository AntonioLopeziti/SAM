/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Ficheros;
import AccesoDatos.Consultas;
import Entidades.DmsDocs;
import Entidades.Ficheros;
import Entidades.equipos;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

/**
 *
 * @author Antonio
 */
@WebServlet(name = "peticionModuloVisualizarEquipos", urlPatterns = {"/peticionModuloVisualizarEquipos"})
public class peticionModuloVisualizarEquipos extends HttpServlet {

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
            String Accion = request.getParameter("Action");
            String Ctd = request.getParameter("Ctd");
            String Equipo = request.getParameter("Equipo");
            String DenEquipo = request.getParameter("DEquipo");
            String ruta = request.getParameter("ruta");
            String ip = request.getRemoteAddr();
            HttpSession session = request.getSession();
            String idioma = (String) session.getAttribute("Idioma");
            String desEq = "denominacion_" + idioma;
            String cnt = request.getParameter("centroo");
            Consultas co = new Consultas();
            int c = 0;

            String equip = request.getParameter("equi");
            switch (Accion) {
                case "CargarMatchEquipos":
                    ArrayList<equipos> e = ACC_Equipos.ObtenerInstancia().ConsultarEquipoMC(Equipo, DenEquipo, desEq, Ctd);
                    if (e.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < e.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + e.get(i).getNum_equipo() + "')\">");
                            out.println("<td>" + e.get(i).getNum_equipo() + "</td>");
                            out.println("<td>" + e.get(i).getDescripcion_equipo() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);

                    }
                    break;
                case "CargarDatosEquipos":
                    String den = "denominacion_" + idioma;
                    String desMat = "descripcion_" + idioma;
                    equipos eq = ACC_Equipos.ObtenerInstancia().CargarDMEquipos(Equipo, den, desMat);
                    if (!Equipo.equals(eq.getNum_equipo())) {
                        out.println(0);
                    } else {
                        JSONArray ar = new JSONArray();
                        ar.add(eq.getDescripcion_equipo());
                        ar.add(eq.getGrupo_autorizaciones());
                        ar.add(eq.getFabricante_activofijo());
                        ar.add(eq.getDenominacion_tipofabri());
                        ar.add(eq.getNum_material_porpiezafabri());
                        ar.add(eq.getSerie_segunfabri());
                        ar.add(eq.getPais_fabricacion());
                        ar.add(eq.getAno_construccion());
                        ar.add(eq.getMes_construccion());
                        ar.add(eq.getCentro_emplazamiento());
                        ar.add(eq.getEmplazamiento_activofijo());
                        ar.add(eq.getArea_empresa());
                        ar.add(eq.getIndicador_abc());
                        ar.add(eq.getSociedad());
                        ar.add(eq.getCentro_coste());
                        ar.add(eq.getSociedad());
                        ar.add(eq.getCentro_plani_mante());
                        ar.add(eq.getGrupo_planificador());
                        ar.add(eq.getPuesto_responsable_medmnte());
                        ar.add(eq.getId_ubitec());
                        ar.add(eq.getEquipo_superior());
                        ar.add(eq.getMaterial());
                        ar.add(eq.getDescripcion_material());
                        ar.add(eq.getSerie());
                        ar.add(eq.getTipo_equipo());
                        ar.add(eq.getTipo_stock_movimerca());
                        ar.add(eq.getCentro());
                        ar.add(eq.getAlmacen());
                        ar.add(eq.getLote());
                        ar.add(eq.getIndicador_stock_especial());
                        ar.add(eq.getNum_deudor());
                        ar.add(eq.getLote_maestro());
                        ar.add(co.DateFormat(eq.getFecha_ulti_movimerca()));
                        ar.add(eq.getProveedor());
                        out.println(ar);
                    }
                    break;
                case "matchDocs":
                    ArrayList<DmsDocs> dcs = ACC_Ficheros.ObtenerInstancia().MostClassDoc(equip);
                    int con = 0,
                     c2 = 0;
                    ArrayList<Ficheros> fi = new ArrayList<>();
                    if (dcs.size() > 0) {
                        out.println("<table id=\"TabBody\">\n"
                                + "                                        <tbody>");
                        for (con = 0; con < dcs.size(); con++) {
                            String ruttap1 = "C:/OffLine/DMS/" + cnt + "/" + dcs.get(con).getClase_documento();
                            fi = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
                            for (Ficheros nf : fi) {
                                String nomaj = nf.getName();
                                String sjk = dcs.get(con).getCampo_texto_longitud();
                                if (sjk.equals(nomaj)) {
//                                    out.println("<tr ondblclick=\"SendPath('" + c2 + "')\">"
                                    out.println("<tr ondblclick=\"abrVen('" + c2 + "')\">"     
                                            + "<td>" + nf.getApl() + "</td>"
                                            + "<td>" + nf.getName() + "</td>"
                                            + "<td>" + nf.getAplicacion() + "</td>"
                                            + "<td name=\"tdFch\">" + nf.getFichero() + "</td>"
                                            + "</tr>");
                                    c2++;
                                }
                            }
                        }
                        for (int c1 = con; c1 < 12; c1++) {
                            out.println("<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>ADMON_POR</td>"
                                + "<td>000000000000000000000000000000000000000000000000</td>"
                                + "<td>ADMON_PORTUAREGRAL_</td>"
                                + "<td>00000000000000000000000000000000000000000000000000000000000000000000000000000</td>"
                                + "</tr>"
                                + "</tbody>"
                                + "</table>");

                    } else {
                        out.println(0);
                    }
                    break;
                case "EnviarSocket":
                    String[] cdd = ruta.split(",");
                    if (ACC_Ficheros.ObtenerInstancia().SendFile("C:\\OffLine\\DMS\\" + cdd[0] + "\\" + cdd[1] + "\\" + cdd[2], ip)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                case "EnviarMod":
                    String[] cdm = ruta.split(",");
                    if (ACC_Ficheros.ObtenerInstancia().SendMod("C:\\OffLine\\DMS\\" + cdm[0] + "\\" + cdm[1] + "\\" + cdm[2], ip)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
//                case "matchDocs":
//                    String sDirectorio = "C:\\Archivos\\Equipos\\" + equip;
//                    int x;
//                    File f = new File(sDirectorio);
//                    if (f.exists()) {
//
//                        File[] ficheros = f.listFiles();
//
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (x = 0; x < ficheros.length; x++) {
//                            System.out.println(ficheros[x].getName());
//
//                            out.println("<tr ondblclick=\"selectD('');\">");
//                            out.println("<td>" + ficheros[x].getName() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//                    } else {
//                        out.println(0);
//                    }
//
//                    break;
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
