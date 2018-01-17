/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Ficheros;
import AccesoDatos.ACC_UbicacionTecnica;
import Entidades.ClassDocumentos;
import Entidades.DmsDocs;
import Entidades.Ficheros;
import Entidades.equipos;
import Entidades.ubicacion_tecnica;
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

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionVisualizarDocs", urlPatterns = {"/PeticionVisualizarDocs"})
public class PeticionVisualizarDocs extends HttpServlet {

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
            String Accion = request.getParameter("Action");
            String v3 = request.getParameter("v3");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String equip = request.getParameter("equip");
            String cnt = request.getParameter("centroo");
            String ubte = request.getParameter("ubte");
            String avi = request.getParameter("avi");
            String loi = request.getParameter("loi");
            String cmv = request.getParameter("cmv");
            String ruta = request.getParameter("ruta");
            String msgg = request.getParameter("msgg");
            String valeq = request.getParameter("valeq");
            String ip = request.getRemoteAddr();
            HttpSession session = request.getSession();
            String centr = (String)session.getAttribute("Centro");
  

            switch (Accion) {
                case "VentanaModalEquipo":
                    switch (v1) {
                        case (""):
                            ArrayList<equipos> eqp = ACC_Equipos.ObtenerInstancia().ConsultarEquipoop();
                            if (eqp.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < eqp.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarr('" + eqp.get(i).getNum_equipo() + "')\">");
                                    out.println("<td>" + eqp.get(i).getNum_equipo() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);

                            }
                            break;
                        default:
                            ArrayList<equipos> eqp2 = ACC_Equipos.ObtenerInstancia().ConsultarEquipoopp(v1);
                            if (eqp2.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < eqp2.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarr('" + eqp2.get(i).getNum_equipo() + "')\">");
                                    out.println("<td>" + eqp2.get(i).getNum_equipo() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);

                            }
                    }
                    break;
                case "VentanaModalUbicacion":
                    switch (v1) {
                        case "":
                            ArrayList<ubicacion_tecnica> uts = ACC_UbicacionTecnica.ObtenerInstancia().MatchAllUbiTecc();
                            if (uts.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < uts.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarub('" + uts.get(i).getUbicacion_tecnica() + "')\">");
                                    out.println("<td>" + uts.get(i).getUbicacion_tecnica() + "</td>");
                                    out.println("<td>" + uts.get(i).getDenominacion() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);
                            }
                        default:
                            ArrayList<ubicacion_tecnica> utss = ACC_UbicacionTecnica.ObtenerInstancia().MatchAllUbiTecc();
                            if (utss.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < utss.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarub('" + utss.get(i).getUbicacion_tecnica() + "')\">");
                                    out.println("<td>" + utss.get(i).getUbicacion_tecnica() + "</td>");
                                    out.println("<td>" + utss.get(i).getDenominacion() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);
                            }
                            break;
                    }
                    break;
                case "VentanaModalAvisos":
                    switch (v1) {
                        case "":
                            ArrayList<DmsDocs> eqp = ACC_Equipos.ObtenerInstancia().ConsultarAvisosVisDoc();
                            if (eqp.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < eqp.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarAV('" + eqp.get(i).getNum_notificacion() + "')\">");
                                    out.println("<td>" + eqp.get(i).getNum_notificacion() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);

                            }
                            break;
                        default:
                            ArrayList<DmsDocs> eqpp = ACC_Equipos.ObtenerInstancia().ConsultarAvisosVisDocc(v1);
                            if (eqpp.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < eqpp.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarAV('" + eqpp.get(i).getNum_notificacion() + "')\">");
                                    out.println("<td>" + eqpp.get(i).getNum_notificacion() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);

                            }
                    }
                    break;
                case "VentanaModalNotiPM":
                    switch (v1) {
                        case "":
                            File[] Noti = ACC_Ficheros.ObtenerInstancia().DirectorioFolder("C:\\Archivos\\NotificacionesPM");
                            if (Noti == null) {
                                out.println(0 + ", #btnNotiPMM");
                            } else if (Noti.length > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (File folder1 : Noti) {
                                    int pos = folder1.getAbsolutePath().lastIndexOf(File.separator);
                                    out.println("<tr ondblclick=\"seleccionar('" + folder1.getAbsolutePath().substring(pos + 1, folder1.toString().length()) + "', 'bxNoticaPM', 'VentanaModalNotiPM')\">");
                                    out.println("<td>" + folder1.getAbsolutePath().substring(pos + 1, folder1.toString().length()) + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0 + ", #btnNotiPMM");
                            }
                            break;
                        default:
                            List<File> fol = ACC_Ficheros.ObtenerInstancia().DirectorioFoldersB("C:\\Archivos\\NotificacionesPM", v1);
                            if (fol == null) {
                                out.println(0 + ", #btnNotiPMM");
                            } else if (fol.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < Integer.parseInt(v3); i++) {
                                    try {
                                        int pos = fol.get(i).getAbsolutePath().lastIndexOf(File.separator);
                                        out.println("<tr ondblclick=\"seleccionar('" + fol.get(i).getAbsolutePath().substring(pos + 1, fol.get(i).toString().length()) + "', 'bxNoticaPM', 'VentanaModalNotiPM')\">");
                                        out.println("<td>" + fol.get(i).getAbsolutePath().substring(pos + 1, fol.get(i).toString().length()) + "</td>");
                                        out.println("</tr>");
                                    } catch (Exception e) {
                                    }
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0 + ", #btnNotiPMM");
                            }
                            break;
                    }
                    break;
                case "VentanaModalNotiQM":
                    switch (v1) {
                        case "":
                            ArrayList<DmsDocs> eqp = ACC_Equipos.ObtenerInstancia().ConsultarNotili();
                            if (eqp.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < eqp.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarLI('" + eqp.get(i).getNum_lote() + "')\">");
                                    out.println("<td>" + eqp.get(i).getNum_lote() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);

                            }
                            break;
                        default:
                            ArrayList<DmsDocs> eqp2 = ACC_Equipos.ObtenerInstancia().ConsultarNotilii(v1);
                            if (eqp2.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < eqp2.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarLI('" + eqp2.get(i).getNum_lote() + "')\">");
                                    out.println("<td>" + eqp2.get(i).getNum_lote() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);

                            }
                            break;
                    }
                    break;
                case "VentanaModalMovimientos":
                    switch (v1) {
                        case "":
                            ArrayList<ClassDocumentos> eqp = ACC_Equipos.ObtenerInstancia().ConsultarClasDocss();
                            if (eqp.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < eqp.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarCD('" + eqp.get(i).getClase_documento() + "')\">");
                                    out.println("<td>" + eqp.get(i).getClase_documento() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);

                            }
                            break;
                        default:
                            ArrayList<ClassDocumentos> eqpp = ACC_Equipos.ObtenerInstancia().ConsultarClasDocsss(v1);
                            if (eqpp.size() > 0) {
                                out.println("<table>");
                                out.println("<tbody>");
                                for (int i = 0; i < eqpp.size(); i++) {
                                    out.println("<tr ondblclick=\"seleccionarLI('" + eqpp.get(i).getClase_documento() + "')\">");
                                    out.println("<td>" + eqpp.get(i).getClase_documento() + "</td>");
                                    out.println("</tr>");
                                }
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println(0);

                            }
                            break;
                    }
                    break;
                case "getDAvisos":
                    out.println(ACC_Ficheros.ObtenerInstancia().GetDAviso(v1));
                    break;
                case "getDUbicTec":
                    out.println(ACC_Ficheros.ObtenerInstancia().GetDUbicTec(v1));
                    break;
                case "getDEquipo":
                    out.println(ACC_Ficheros.ObtenerInstancia().GetDEquipo(v1));
                    break;
                case "getCtr":
                    out.println(ACC_Ficheros.ObtenerInstancia().GetCtrDMS());
                    break;
                case "EqQuery":
                    int q1 = ACC_Ficheros.ObtenerInstancia().VisDoccPorEq(equip);
                    out.println(q1);
                    break;
                case "EjecutarQ":
                    int q11 = ACC_Ficheros.ObtenerInstancia().VisDoccPorUb(ubte);
                    out.println(q11);
                    break;
                case "EjecutarQAV":
                    int qav = ACC_Ficheros.ObtenerInstancia().VisDoccPorAv(avi);
                    out.println(qav);
                    break;
                case "EjecutarQLI":
                    int liv = ACC_Ficheros.ObtenerInstancia().VisDoccPorLi(loi);
                    out.println(liv);
                    break;
                case "EjecutarQCM":
                    int cmm = ACC_Ficheros.ObtenerInstancia().VisDoccPorCM(cmv);
                    out.println(cmm);
                    break;
                case "CargaTabla":
                    ArrayList<DmsDocs> dcs = ACC_Ficheros.ObtenerInstancia().MostClassDoc(equip);
                    int con = 0, c3 = 0;
                    ArrayList<Ficheros> fi = new ArrayList<>();
                    if (dcs.size() > 0) {
                        out.println("<table id=\"TabBodyN\">\n"
                                + "                                        <tbody>");
                        for (con = 0; con < dcs.size(); con++) {
                            String ruttap1 = "C:/OffLine/DMS/" + cnt + "/" + dcs.get(con).getClase_documento();
                            fi = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
                            for (Ficheros nf : fi) {
                                String nomaj = nf.getName();
                                String sjk = dcs.get(con).getCampo_texto_longitud();
                                if (sjk.equals(nomaj)) {
                                    //out.println("<tr ondblclick=\"SendPath('" + c2 + "')\">"
                                    out.println("<tr ondblclick=\"abrVen('" + c3 + "')\">"   
                                            + "<td>" + dcs.get(con).getNum_documento() + "</td>"
                                            + "<td>" + dcs.get(con).getDocumento_parcial() + "</td>"
                                            + "<td>" + dcs.get(con).getVersion_documento() + "</td>"
                                            + "<td>" + dcs.get(con).getClase_documento() + "</td>"
                                            + "<td>" + dcs.get(con).getCampo_texto_longitud() + "</td>"
                                            + "<td name=\"tdFch\" hidden>" + nf.getFichero() + "</td>"
                                            + "<td>" + nf.getApl() + "</td>"
                                            + "<td>" + nf.getAplicacion() + "</td>"
                                            + "</tr>");
                                    c3++;
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
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>0000000000000000000000000000</td>"
                                + "<td>000000</td>"
                                + "<td>0000000</td>"
                                + "<td>000000000</td>"
                                + "<td>00000000000000000000000000000000000000000000000000000000000</td>"
                                + "<td>000000000000000000</td>"
                                + "<td>000000000000000000000000000</td>"
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
                case "CargaTabla2":
                    ArrayList<DmsDocs> dcsUb = ACC_Ficheros.ObtenerInstancia().MostClassDocEq(ubte);
                    int conn = 0, c2 = 0;
                    ArrayList<Ficheros> fii = new ArrayList<>();
                    if (dcsUb.size() > 0) {
                        out.println("<table id=\"TabBodyN\">\n"
                                + "                                        <tbody>");
                        for (conn = 0; conn < dcsUb.size(); conn++) {
                            String ruttap1 = "C:/OffLine/DMS/" + cnt + "/" + dcsUb.get(conn).getClase_documento();
                            fii = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
                            for (Ficheros nff : fii) {
                                String nomaj = nff.getName();
                                String sjk = dcsUb.get(conn).getCampo_texto_longitud();
                                if (sjk.equals(nomaj)) {
                                    int cp = conn - 1;
                                    //out.println("<tr ondblclick=\"SendPath('" + c2 + "')\">"
                                    out.println("<tr ondblclick=\"abrVen('" + c2 + "')\">"   
                                            + "<td>" + dcsUb.get(conn).getNum_documento() + "</td>"
                                            + "<td>" + dcsUb.get(conn).getDocumento_parcial() + "</td>"
                                            + "<td>" + dcsUb.get(conn).getVersion_documento() + "</td>"
                                            + "<td>" + dcsUb.get(conn).getClase_documento() + "</td>"
                                            + "<td>" + dcsUb.get(conn).getCampo_texto_longitud() + "</td>"
                                            + "<td name=\"tdFch\" hidden>" + nff.getFichero() + "</td>"
                                            + "<td>" + nff.getApl() + "</td>"
                                            + "<td>" + nff.getAplicacion() + "</td>"
                                            + "</tr>");
                                    c2++;
                                }

                            }
                        }
                        for (int c1 = conn; c1 < 12; c1++) {
                            out.println("<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>0000000000000000000000000000</td>"
                                + "<td>000000</td>"
                                + "<td>0000000</td>"
                                + "<td>000000000</td>"
                                + "<td>00000000000000000000000000000000000000000000000000000000000</td>"
                                + "<td>000000000000000000</td>"
                                + "<td>000000000000000000000000000</td>"
                                + "</tr>"
                                + "</tbody>"
                                + "</table>");

                    } else {
                        out.println(0);
                    }
                    break;
                case "CargaTabla3":
                    ArrayList<DmsDocs> dcsAv = ACC_Ficheros.ObtenerInstancia().MostClassDocAv(avi);
                    int cont = 0, c4 = 0;
                    ArrayList<Ficheros> fa = new ArrayList<>();
                    if (dcsAv.size() > 0) {
                        out.println("<table id=\"TabBodyN\">\n"
                                + "                                        <tbody>");
                        for (cont = 0; cont < dcsAv.size(); cont++) {
                            String ruttap1 = "C:/OffLine/DMS/" + cnt + "/" + dcsAv.get(cont).getClase_documento();
                            fa = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
                            for (Ficheros nff : fa) {
                                String nomaj = nff.getName();
                                String sjk = dcsAv.get(cont).getCampo_texto_longitud();
                                if (sjk.equals(nomaj)) {
                                    int cp = cont - 1;
                                    int c = 0;
                                    //out.println("<tr ondblclick=\"SendPath('" + c2 + "')\">"
                                    out.println("<tr ondblclick=\"abrVen('" + c4 + "')\">"   
                                            + "<td>" + dcsAv.get(cont).getNum_documento() + "</td>"
                                            + "<td>" + dcsAv.get(cont).getDocumento_parcial() + "</td>"
                                            + "<td>" + dcsAv.get(cont).getVersion_documento() + "</td>"
                                            + "<td>" + dcsAv.get(cont).getClase_documento() + "</td>"
                                            + "<td>" + dcsAv.get(cont).getCampo_texto_longitud() + "</td>"
                                            + "<td name=\"tdFch\" hidden>" + nff.getFichero() + "</td>"
                                            + "<td>" + nff.getApl() + "</td>"
                                            + "<td>" + nff.getAplicacion() + "</td>"
                                            + "</tr>");
                                    c4++;
                                }

                            }
                        }
                        for (int c1 = cont; c1 < 12; c1++) {
                            out.println("<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>0000000000000000000000000000</td>"
                                + "<td>000000</td>"
                                + "<td>0000000</td>"
                                + "<td>000000000</td>"
                                + "<td>00000000000000000000000000000000000000000000000000000000000</td>"
                                + "<td>000000000000000000</td>"
                                + "<td>000000000000000000000000000</td>"
                                + "</tr>"
                                + "</tbody>"
                                + "</table>");

                    } else {
                        out.println(0);
                    }
                    break;
                case "CargaTabla4":
                    ArrayList<DmsDocs> dcsLI = ACC_Ficheros.ObtenerInstancia().MostClassDocLI(loi);
                    int cou = 0, c5 = 0;
                    ArrayList<Ficheros> flo = new ArrayList<>();
                    if (dcsLI.size() > 0) {
                        out.println("<table id=\"TabBodyN\">\n"
                                + "                                        <tbody>");
                        for (cou = 0; cou < dcsLI.size(); cou++) {
                            String ruttap1 = "C:/OffLine/DMS/" + cnt + "/" + dcsLI.get(cou).getClase_documento();
                            flo = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
                            for (Ficheros nff : flo) {
                                String nomaj = nff.getName();
                                String sjk = dcsLI.get(cou).getCampo_texto_longitud();
                                if (sjk.equals(nomaj)) {
                                    int cp = cou-1;
                                    int c = 0;
                                    //out.println("<tr ondblclick=\"SendPath('" + c2 + "')\">"
                                    out.println("<tr ondblclick=\"abrVen('" + c5 + "')\">"   
                                            + "<td>" + dcsLI.get(cou).getNum_documento() + "</td>"
                                            + "<td>" + dcsLI.get(cou).getDocumento_parcial() + "</td>"
                                            + "<td>" + dcsLI.get(cou).getVersion_documento() + "</td>"
                                            + "<td>" + dcsLI.get(cou).getClase_documento() + "</td>"
                                            + "<td>" + dcsLI.get(cou).getCampo_texto_longitud() + "</td>"
                                            + "<td name=\"tdFch\" hidden>" + nff.getFichero() + "</td>"
                                            + "<td>" + nff.getApl() + "</td>"
                                            + "<td>" + nff.getAplicacion() + "</td>"
                                            + "</tr>");
                                    c5++;
                                }

                            }
                        }
                        for (int c1 = cou; c1 < 12; c1++) {
                            out.println("<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>0000000000000000000000000000</td>"
                                + "<td>000000</td>"
                                + "<td>0000000</td>"
                                + "<td>000000000</td>"
                                + "<td>00000000000000000000000000000000000000000000000000000000000</td>"
                                + "<td>000000000000000000</td>"
                                + "<td>000000000000000000000000000</td>"
                                + "</tr>"
                                + "</tbody>"
                                + "</table>");

                    } else {
                        out.println(0);
                    }
                case "CargaTabla5":
                    ArrayList<DmsDocs> dcsCM = ACC_Ficheros.ObtenerInstancia().MostClassDocCM(cmv);
                    int cntt = 0, c6 = 0;
                    ArrayList<Ficheros> fcm = new ArrayList<>();
                    if (dcsCM.size() > 0) {
                        out.println("<table id=\"TabBodyN\">\n"
                                + "                                        <tbody>");
                        for (cntt = 0; cntt < dcsCM.size(); cntt++) {
                            String ruttap1 = "C:/OffLine/DMS/" + cnt + "/" + dcsCM.get(cntt).getClase_documento();
                            fcm = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
                            for (Ficheros nff : fcm) {
                                String nomaj = nff.getName();
                                String sjk = dcsCM.get(cntt).getCampo_texto_longitud();
                                if (sjk.equals(nomaj)) {
                                    int cp = cntt - 1;
                                    int c = 0;
                                    //out.println("<tr ondblclick=\"SendPath('" + c2 + "')\">"
                                    out.println("<tr ondblclick=\"abrVen('" + c6 + "')\">"   
                                            + "<td>" + dcsCM.get(cntt).getNum_documento() + "</td>"
                                            + "<td>" + dcsCM.get(cntt).getDocumento_parcial() + "</td>"
                                            + "<td>" + dcsCM.get(cntt).getVersion_documento() + "</td>"
                                            + "<td>" + dcsCM.get(cntt).getClase_documento() + "</td>"
                                            + "<td>" + dcsCM.get(cntt).getCampo_texto_longitud() + "</td>"
                                            + "<td name=\"tdFch\" hidden>" + nff.getFichero() + "</td>"
                                            + "<td>" + nff.getApl() + "</td>"
                                            + "<td>" + nff.getAplicacion() + "</td>"
                                            + "</tr>");
                                    c6++;
                                }

                            }
                        }
                        for (int c1 = cntt; c1 < 12; c1++) {
                            out.println("<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>0000000000000000000000000000</td>"
                                + "<td>000000</td>"
                                + "<td>0000000</td>"
                                + "<td>000000000</td>"
                                + "<td>00000000000000000000000000000000000000000000000000000000000</td>"
                                + "<td>000000000000000000</td>"
                                + "<td>000000000000000000000000000</td>"
                                + "</tr>"
                                + "</tbody>"
                                + "</table>");

                    } else {
                        out.println(0);
                    }
                    break;

//                    ArrayList<DmsDocs> dcs = ACC_Ficheros.ObtenerInstancia().MostClassDocEq(ubTec);
//                    int con  = 0;
//                    ArrayList<Ficheros> fi = new ArrayList<>();
//                    if (dcs.size() > 0) {
//                        out.println("<table id=\"TabBody\">\n"
//                                + "                                        <tbody>");
//                        for (con = 0; con < dcs.size(); con++) {
//                            String ruttap1 = "C:/OffLine/DMS/" + centroo + "/" + dcs.get(con).getClase_documento();
//                            fi = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
//                            for (Ficheros nf : fi) {
//                                String nomaj = nf.getName();
//                                String sjk = dcs.get(con).getCampo_texto_longitud();
//                                if (sjk.equals(nomaj)) {
//                                    int cn = con-1;
//                                    out.println("<tr ondblclick=\"SendPath('" + cn + "')\">"
//                                            + "<td>" + nf.getApl() + "</td>"
//                                            + "<td>" + nf.getName() + "</td>"
//                                            + "<td>" + nf.getAplicacion() + "</td>"
//                                            + "<td name=\"tdFch\">" + nf.getFichero() + "</td>"
//                                            + "</tr>");
//                                }
//                            }
//                        }
//                        for (int c1 = con; c1 < 12; c1++) {
//                            out.println("<tr>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "</tr>");
//                        }
//                        out.println("<tr class=\"ocultar\">"
//                                + "<td>ADMON_POR</td>"
//                                + "<td>000000000000000000000000000000000000000000000000</td>"
//                                + "<td>ADMON_PORTUAREGRAL_</td>"
//                                + "<td>00000000000000000000000000000000000000000000000000000000000000000000000000000</td>"
//                                + "</tr>"
//                                + "</tbody>"
//                                + "</table>");
//
//                    } else {
//                        out.println(0);
//                    }
//                    break;
//                case "EnviarSocket":
//                    String[] cdd = ruta.split(",");
//                    if (ACC_Ficheros.ObtenerInstancia().SendFile("C:\\OffLine\\DMS\\" +cdd[0] + "\\" + cdd[1] + "\\" + cdd[2], ip)) {
//                        out.println(0);
//                    } else {
//                        out.println(1);
//                    }
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
