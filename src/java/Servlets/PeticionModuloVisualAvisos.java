/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Aviso;
import AccesoDatos.ACC_Cabecera_aviso;
import AccesoDatos.Consultas;
import Entidades.CabeceraAviso;
import Entidades.actividadesavisos;
import Entidades.aviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "PeticionModuloVisualAvisos", urlPatterns = {"/PeticionModuloVisualAvisos"})
public class PeticionModuloVisualAvisos extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String Clase = request.getParameter("Clase");
            String Aviso = request.getParameter("Aviso");
            String Texto = request.getParameter("Texto");
            String Tipo = request.getParameter("Tipo");
            String Ctd = request.getParameter("Ctd");
            HttpSession session = request.getSession();
            String Lan = (String) session.getAttribute("Idioma");
            String dato = request.getParameter("Dato");
            String param = request.getParameter("Par");
            Consultas c = new Consultas();
            switch (Accion) {
                case "ConsultaMatchAvisos":
                    ArrayList<aviso> Cavi = ACC_Aviso.ObtenerInstancia().CargarAvisosMC(Clase, Aviso, Texto);
                    if (Cavi.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (Ctd.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(Ctd); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + Cavi.get(i).getNum_notificacion() + "', '" + Cavi.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + Cavi.get(i).getClase_aviso() + "</td>");
                                out.println("<td>" + Cavi.get(i).getNum_notificacion() + "</td>");
                                out.println("<td>" + Cavi.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + Cavi.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < Cavi.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + Cavi.get(i).getNum_notificacion() + "', '" + Cavi.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + Cavi.get(i).getClase_aviso() + "</td>");
                                out.println("<td>" + Cavi.get(i).getNum_notificacion() + "</td>");
                                out.println("<td>" + Cavi.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + Cavi.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarAviso":
                    int av = ACC_Aviso.ObtenerInstancia().Validaraviso(Aviso);
                    out.println(av);
                    break;
                case "CargarAviso":
                    JSONArray j = new JSONArray();
                    if (Tipo.equals("1")) {
                        aviso avi = ACC_Aviso.ObtenerInstancia().CargarAvisoSAP(Aviso, Lan);
                        j.add(avi.getNum_notificacion());
                        j.add(avi.getClase_aviso());
                        j.add(avi.getDescripcion());
                        j.add(avi.getStatus_individual_breve_es());
                        j.add(avi.getUbicación_tecnica());
                        j.add(avi.getNum_equipo());
                        j.add(avi.getConjunto());
                        j.add(avi.getGrupo_planificador_servicio_cliente_mante());
                        j.add(avi.getCentro_planificador_mante());
                        j.add(avi.getPuesto_trabajo_responsable_medidas_mantenimiento());
                        j.add(avi.getNombre_autor_aviso());
                        j.add(c.DateFormat(avi.getFecha_aviso()));
                        j.add(avi.getHora_aviso());
                        j.add(avi.getTexto_breve());
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add(avi.getNum_orden());
                        out.println(j);
                    } else if (Tipo.equals("2")) {
                        aviso avs = ACC_Aviso.ObtenerInstancia().CargarAvisoSAM(Aviso);
                        j.add(avs.getFolio_sam());
                        j.add(avs.getClase_aviso());
                        j.add(avs.getDescripcion());
                        j.add(avs.getStatus_individual_breve_es());
                        j.add(avs.getUbicación_tecnica());
                        j.add(avs.getNum_equipo());
                        j.add(avs.getConjunto());
                        j.add(avs.getGrupo_planificador_servicio_cliente_mante());
                        j.add(avs.getCentro_planificador_mante());
                        j.add(avs.getPuesto_trabajo_responsable_medidas_mantenimiento());
                        j.add(avs.getNombre_autor_aviso());
                        j.add(c.DateFormat(avs.getFecha_aviso()));
                        j.add(avs.getHora_aviso());
                        j.add(avs.getTexto_breve());
                        j.add(avs.getRecibido());
                        j.add(avs.getProcesado());
                        j.add(avs.getError());
                        j.add(avs.getNum_orden());
                        out.println(j);
                    } else {
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        j.add("");
                        out.println(j);
                    }
                    break;
                case "CargarAvisoTexto":
                    String Cadena = "";
                    if (Tipo.equals("1")) {
                        for (aviso a : ACC_Aviso.ObtenerInstancia().CargarTextosAvisoSAP(Aviso)) {
                            Cadena += a.getTexto_breve();
                        }
                        out.println(Cadena);
                    } else if (Tipo.equals("2")) {
                        for (aviso s : ACC_Aviso.ObtenerInstancia().CargarTextosAvisoSAM(Aviso)) {
                            Cadena += s.getTexto_breve();
                        }
                        out.println(Cadena);
                    } else {
                        out.println(Cadena);
                    }
                    break;
                case "CargarActividades":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    if (Tipo.equals("1")) {
                        int a;
                        ArrayList<actividadesavisos> ac = ACC_Aviso.ObtenerInstancia().CargarActividadesSAP(Aviso, Lan);
                        for (a = 0; a < ac.size(); a++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + ac.get(a).getPosicion() + "</td>");
                            out.println("<td>" + ac.get(a).getGrupo_codigo() + "</td>");
                            out.println("<td>" + ac.get(a).getCodigo_medida() + "</td>");
                            out.println("<td>" + ac.get(a).getTexto_codigo() + "</td>");
                            out.println("<td>" + ac.get(a).getTexto_accion() + "</td>");
                            out.println("<td></td>");
//                            out.println("<td>" + ac.get(a).getFactor_cantidad() + "</td>");
                            out.println("<td>" + c.DateFormat(ac.get(a).getFecha_inicio()) + "</td>");
                            out.println("<td>" + ac.get(a).getHora_inicio() + "</td>");
                            out.println("<td>" + c.DateFormat(ac.get(a).getFecha_fin()) + "</td>");
                            out.println("<td>" + ac.get(a).getHora_fin() + "</td>");
//                            out.println("<td>" + ac.get(a).getNum_actividad() + "</td>");
                            out.println("</tr>");
                        }
                        for (int n = a; n < 5; n++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    } else if (Tipo.equals("2")) {
                        int b;
                        ArrayList<actividadesavisos> ac = ACC_Aviso.ObtenerInstancia().CargarActividadesSAM(Aviso, Lan);
                        for (b = 0; b < ac.size(); b++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + ac.get(b).getPosicion() + "</td>");
                            out.println("<td>" + ac.get(b).getGrupo_codigo() + "</td>");
                            out.println("<td>" + ac.get(b).getCodigo_medida() + "</td>");
                            out.println("<td>" + ac.get(b).getTexto_codigo() + "</td>");
                            out.println("<td>" + ac.get(b).getTexto_accion() + "</td>");
                            out.println("<td></td>");
//                            out.println("<td>" + ac.get(b).getFactor_cantidad() + "</td>");
                            out.println("<td>" + c.DateFormat(ac.get(b).getFecha_inicio()) + "</td>");
                            out.println("<td>" + ac.get(b).getHora_inicio() + "</td>");
                            out.println("<td>" + c.DateFormat(ac.get(b).getFecha_fin()) + "</td>");
                            out.println("<td>" + ac.get(b).getHora_fin() + "</td>");
//                            out.println("<td>" + ac.get(b).getNum_actividad() + "</td>");
                            out.println("</tr>");
                        }
                        for (int n = b; n < 5; n++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    } else {
                        for (int i = 0; i < 5; i++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>0000</td>");
                    out.println("<td>000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000</td>");
                    out.println("<td>000000000000000000000000</td>");
                    out.println("<td>000000000000000000000000</td>");
                    out.println("<td>000</td>");
//                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
//                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "GetNameData":
                    String nam = ACC_Aviso.ObtenerInstancia().GetNameData(dato, Lan, param);
                    out.println(nam);
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
