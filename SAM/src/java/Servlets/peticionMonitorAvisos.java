/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Aviso;
import AccesoDatos.Consultas;
import Entidades.aviso;
import Entidades.plan_orden;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antonio
 */
@WebServlet(name = "peticionMonitorAvisos", urlPatterns = {"/peticionMonitorAvisos"})
public class peticionMonitorAvisos extends HttpServlet {

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
            HttpSession session = request.getSession();
            String Idioma = (String) session.getAttribute("Idioma");
            String Accion = request.getParameter("Accion");
            String Notifi = request.getParameter("Notificacion");
            String TNotif = request.getParameter("TNotificacion");
            String FolSAM = request.getParameter("SAM");
            String TxtSAM = request.getParameter("TSAM");
            String Cantid = request.getParameter("Cantidad");
            String Ubicac = request.getParameter("Ubicacion");
            String TUbica = request.getParameter("TUbica");
            String Equipo = request.getParameter("Equipo");
            String DEequi = request.getParameter("DEqui");
            String Orden = request.getParameter("Orden");
            String DOrden = request.getParameter("DOrden");
            String Puesto = request.getParameter("Puesto");
            String DPuest = request.getParameter("DPuesto");
            String Clase = request.getParameter("Clase");

            String N1 = request.getParameter("N1");
            String N2 = request.getParameter("N2");
            String S1 = request.getParameter("S1");
            String S2 = request.getParameter("S2");
            String C1 = request.getParameter("C1");
            String C2 = request.getParameter("C2");
            String U1 = request.getParameter("U1");
            String U2 = request.getParameter("U2");
            String E1 = request.getParameter("E1");
            String E2 = request.getParameter("E2");
            String O1 = request.getParameter("O1");
            String O2 = request.getParameter("O2");
            String P1 = request.getParameter("P1");
            String P2 = request.getParameter("P2");
            String F1 = request.getParameter("F1");
            String F2 = request.getParameter("F2");
            String PEND = request.getParameter("PEND");
            String POSP = request.getParameter("POSP");
            String TRAT = request.getParameter("TRAT");
            String CONC = request.getParameter("CONC");
            Consultas cosn = new Consultas();

            switch (Accion) {
                case "ConsultarNotificacion":
                    ArrayList<aviso> av = ACC_Aviso.ObtenerInstancia().ConsultarAviso(TNotif, Notifi);
                    if (av.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Notificacion','" + av.get(i).getNum_notificacion() + "')\">");
                                out.println("<td>" + av.get(i).getNum_notificacion() + "</td>");
                                out.println("<td>" + av.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < av.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Notificacion','" + av.get(i).getNum_notificacion() + "')\">");
                                out.println("<td>" + av.get(i).getNum_notificacion() + "</td>");
                                out.println("<td>" + av.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }

                    break;
                case "ConsultarNotificacion2":
                    ArrayList<aviso> av2 = ACC_Aviso.ObtenerInstancia().ConsultarAviso(TNotif, Notifi);
                    if (av2.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Notificacion2','" + av2.get(i).getNum_notificacion() + "')\">");
                                out.println("<td>" + av2.get(i).getNum_notificacion() + "</td>");
                                out.println("<td>" + av2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < av2.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Notificacion2','" + av2.get(i).getNum_notificacion() + "')\">");
                                out.println("<td>" + av2.get(i).getNum_notificacion() + "</td>");
                                out.println("<td>" + av2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarSAM":
                    ArrayList<aviso> sa = ACC_Aviso.ObtenerInstancia().ConsultarAvisoSAM(FolSAM, TxtSAM);
                    if (sa.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('SAM','" + sa.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + sa.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + sa.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < sa.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('SAM','" + sa.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + sa.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + sa.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarSAM2":
                    ArrayList<aviso> sa2 = ACC_Aviso.ObtenerInstancia().ConsultarAvisoSAM(FolSAM, TxtSAM);
                    if (sa2.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('SAM2','" + sa2.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + sa2.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + sa2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < sa2.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('SAM2','" + sa2.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + sa2.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + sa2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarClase":
                    ArrayList<aviso> cl = ACC_Aviso.ObtenerInstancia().ConsultarAvisoClase();
                    if (cl.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cl.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('Clase','" + cl.get(i).getClase_aviso() + "')\">");
                            out.println("<td>" + cl.get(i).getClase_aviso() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarClase2":
                    ArrayList<aviso> cl2 = ACC_Aviso.ObtenerInstancia().ConsultarAvisoClase();
                    if (cl2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cl2.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('Clase2','" + cl2.get(i).getClase_aviso() + "')\">");
                            out.println("<td>" + cl2.get(i).getClase_aviso() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarUbicacion":
                    String desUb = "denominacion_" + Idioma;
                    ArrayList<aviso> ub = ACC_Aviso.ObtenerInstancia().ConsultarAvisoUbicacion(Ubicac, TUbica, desUb);
                    if (ub.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Ubicacion','" + ub.get(i).getUbicación_tecnica() + "')\">");
                                out.println("<td>" + ub.get(i).getUbicación_tecnica() + "</td>");
                                out.println("<td>" + ub.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < ub.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Ubicacion','" + ub.get(i).getUbicación_tecnica() + "')\">");
                                out.println("<td>" + ub.get(i).getUbicación_tecnica() + "</td>");
                                out.println("<td>" + ub.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarUbicacion2":
                    String desUb2 = "denominacion_" + Idioma;
                    ArrayList<aviso> ub2 = ACC_Aviso.ObtenerInstancia().ConsultarAvisoUbicacion(Ubicac, TUbica, desUb2);
                    if (ub2.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Ubicacion2','" + ub2.get(i).getUbicación_tecnica() + "')\">");
                                out.println("<td>" + ub2.get(i).getUbicación_tecnica() + "</td>");
                                out.println("<td>" + ub2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < ub2.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Ubicacion2','" + ub2.get(i).getUbicación_tecnica() + "')\">");
                                out.println("<td>" + ub2.get(i).getUbicación_tecnica() + "</td>");
                                out.println("<td>" + ub2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarEquipo":
                    String eqip = "denominacion_" + Idioma;
                    ArrayList<aviso> eq = ACC_Aviso.ObtenerInstancia().ConsultarAvisoEquipo(Equipo, DEequi, eqip);
                    if (eq.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Equipo','" + eq.get(i).getUbicación_tecnica() + "')\">");
                                out.println("<td>" + eq.get(i).getUbicación_tecnica() + "</td>");
                                out.println("<td>" + eq.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < eq.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Equipo','" + eq.get(i).getUbicación_tecnica() + "')\">");
                                out.println("<td>" + eq.get(i).getUbicación_tecnica() + "</td>");
                                out.println("<td>" + eq.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarEquipo2":
                    String eqip2 = "denominacion_" + Idioma;
                    ArrayList<aviso> eq2 = ACC_Aviso.ObtenerInstancia().ConsultarAvisoEquipo(Equipo, DEequi, eqip2);
                    if (eq2.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Equipo2','" + eq2.get(i).getUbicación_tecnica() + "')\">");
                                out.println("<td>" + eq2.get(i).getUbicación_tecnica() + "</td>");
                                out.println("<td>" + eq2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < eq2.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Equipo2','" + eq2.get(i).getUbicación_tecnica() + "')\">");
                                out.println("<td>" + eq2.get(i).getUbicación_tecnica() + "</td>");
                                out.println("<td>" + eq2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrden":
                    ArrayList<aviso> ord = ACC_Aviso.ObtenerInstancia().ConsultarAvisoOrden(Orden, DOrden);
                    if (ord.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionarOrden('" + ord.get(i).getNum_orden() + "','" + ord.get(i).getFolio_sam() + "','Orden','Aviso5')\">");
                                out.println("<td>" + ord.get(i).getNum_orden() + "</td>");
                                out.println("<td>" + ord.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + ord.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < ord.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionarOrden('" + ord.get(i).getNum_orden() + "','" + ord.get(i).getFolio_sam() + "','Orden','Aviso5')\">");
                                out.println("<td>" + ord.get(i).getNum_orden() + "</td>");
                                out.println("<td>" + ord.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + ord.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrden2":
                    ArrayList<aviso> ord2 = ACC_Aviso.ObtenerInstancia().ConsultarAvisoOrden(Orden, DOrden);
                    if (ord2.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionarOrden('" + ord2.get(i).getNum_orden() + "','" + ord2.get(i).getFolio_sam() + "','Orden2','Aviso12')\">");
                                out.println("<td>" + ord2.get(i).getNum_orden() + "</td>");
                                out.println("<td>" + ord2.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + ord2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < ord2.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionarOrden('" + ord2.get(i).getNum_orden() + "','" + ord2.get(i).getFolio_sam() + "','Orden2','Aviso12')\">");
                                out.println("<td>" + ord2.get(i).getNum_orden() + "</td>");
                                out.println("<td>" + ord2.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + ord2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarPuesto":
                    String pto = "denominacion_" + Idioma;
                    ArrayList<aviso> pt = ACC_Aviso.ObtenerInstancia().ConsultarAvisoPuesto(Puesto, DPuest, pto);
                    if (pt.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Puesto','" + pt.get(i).getPuesto_trabajo_responsable_medidas_mantenimiento() + "')\">");
                                out.println("<td>" + pt.get(i).getPuesto_trabajo_responsable_medidas_mantenimiento() + "</td>");
                                out.println("<td>" + pt.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < pt.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Puesto','" + pt.get(i).getPuesto_trabajo_responsable_medidas_mantenimiento() + "')\">");
                                out.println("<td>" + pt.get(i).getPuesto_trabajo_responsable_medidas_mantenimiento() + "</td>");
                                out.println("<td>" + pt.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarPuesto2":
                    String pto2 = "denominacion_" + Idioma;
                    ArrayList<aviso> pt2 = ACC_Aviso.ObtenerInstancia().ConsultarAvisoPuesto(Puesto, DPuest, pto2);
                    if (pt2.size() > 0) {
                        if (Cantid.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < Integer.parseInt(Cantid); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Puesto2','" + pt2.get(i).getPuesto_trabajo_responsable_medidas_mantenimiento() + "')\">");
                                out.println("<td>" + pt2.get(i).getPuesto_trabajo_responsable_medidas_mantenimiento() + "</td>");
                                out.println("<td>" + pt2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < pt2.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('Puesto2','" + pt2.get(i).getPuesto_trabajo_responsable_medidas_mantenimiento() + "')\">");
                                out.println("<td>" + pt2.get(i).getPuesto_trabajo_responsable_medidas_mantenimiento() + "</td>");
                                out.println("<td>" + pt2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarNotificacion":
                    String sqlnot = "{call PM.MonitorAvisos_ValidarNotificacion(?)}";
                    int a = ACC_Aviso.ObtenerInstancia().ValidarDatosMonitorAvisos(Notifi, sqlnot);
                    out.println(a);
                    break;
                case "ValidarSAM":
                    String sqlsam = "{call PM.MonitorAvisos_ValidarFolioSAM(?)}";
                    int b = ACC_Aviso.ObtenerInstancia().ValidarDatosMonitorAvisos(FolSAM, sqlsam);
                    out.println(b);
                    break;
                case "ValidarClase":
                    String sqlcla = "{call PM.MonitorAviso_ValidarClase(?)}";
                    int c = ACC_Aviso.ObtenerInstancia().ValidarDatosMonitorAvisos(Clase, sqlcla);
                    out.println(c);
                    break;
                case "ValidarUbicacion":
                    String sqlubi = "{call PM.MonitorAviso_ValidarUbicacion(?)}";
                    int d = ACC_Aviso.ObtenerInstancia().ValidarDatosMonitorAvisos(Ubicac, sqlubi);
                    out.println(d);
                    break;
                case "ValidarEquipo":
                    String sqlequ = "{call PM.MonitorAviso_ValidarEquipo(?)}";
                    int e = ACC_Aviso.ObtenerInstancia().ValidarDatosMonitorAvisos(Equipo, sqlequ);
                    out.println(e);
                    break;
                case "ValidarOrden":
                    String sqlord = "{call PM.MonitorAviso_ValidarOrden(?)}";
                    int f = ACC_Aviso.ObtenerInstancia().ValidarDatosMonitorAvisos(Orden, sqlord);
                    out.println(f);
                    break;
                case "ValidarPuesto":
                    String sqlpto = "{call PM.MonitorAviso_ValidarPuesto(?)}";
                    int g = ACC_Aviso.ObtenerInstancia().ValidarDatosMonitorAvisos(Puesto, sqlpto);
                    out.println(g);
                    break;
                case "ValidarQuery":
                    String ff1 = cosn.DateFormatGuion(F1);
                    String ff2 = cosn.DateFormatGuion(F2);
                    String data[] = {N1, N2, S1, S2, C1, C2, U1, U2, E1, E2, O1, O2, P1, P2, ff1, ff2, PEND, POSP, TRAT, CONC};
                    ArrayList<aviso> as = ACC_Aviso.ObtenerInstancia().ConsultaQuerySAP(data);
                    ArrayList<aviso> am = ACC_Aviso.ObtenerInstancia().ConsultaQuerySAM(data);
                    int a1 = as.size() + am.size();
                    out.print(a1);
                    break;
                case "CargarTabla":
                    String ff11 = cosn.DateFormatGuion(F1);
                    String ff22 = cosn.DateFormatGuion(F2);
                    String data1[] = {N1, N2, S1, S2, C1, C2, U1, U2, E1, E2, O1, O2, P1, P2, ff11, ff22, PEND, POSP, TRAT, CONC};
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    ArrayList<aviso> avis = new ArrayList<>();
                    ArrayList<aviso> sap = ACC_Aviso.ObtenerInstancia().ConsultaQuerySAP(data1);
                    ArrayList<aviso> sam = ACC_Aviso.ObtenerInstancia().ConsultaQuerySAM(data1);
                    sap.addAll(sam);
                    avis.addAll(sap);
                    Collections.sort(avis, new Comparator<aviso>() {
                        public int compare(aviso a1, aviso a2) {
                            return a1.getFecha_aviso().compareTo(a2.getFecha_aviso());
                        }
                    });
                    for (aviso av1 : avis) {
                        out.println("<tr ondblclick=\"seleccionaravuso('" + av1.getNum_notificacion() + "','" + av1.getFolio_sam() + "')\">");
                        out.println("<td>" + av1.getNum_notificacion() + "</td>");
                        out.println("<td>" + av1.getFolio_sam() + "</td>");
                        out.println("<td>" + av1.getDescripcion() + "</td>");
                        out.println("<td>" + av1.getUbicación_tecnica() + "</td>");
                        out.println("<td>" + av1.getNum_equipo() + "</td>");
                        out.println("<td>" + av1.getNum_orden() + "</td>");
                        out.println("<td>" + DateFormat(av1.getFecha_aviso()) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000</td>");
                    out.println("<td>0000000000000000000000000000</td>");
                    out.println("<td>00000000000000000000</td>");
                    out.println("<td>00000000000000000000</td>");
                    out.println("</tr");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;

            }
        }
    }

    public String DateFormat(String date) {
        String fec = "";
        DateFormat fe1 = new SimpleDateFormat("dd.MM.yyyy");
        try {

            DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sf.parse(date);
            fec = fe1.format(d);

        } catch (ParseException ex) {
            Logger.getLogger(peticionModuloListaOrdenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fec;
    }

    public int compare(aviso av, aviso a2) {
        return av.getFecha_aviso().compareTo(a2.getFecha_aviso());
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
