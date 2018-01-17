/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Aviso;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_ClaseOrden;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Grupo_codigos;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_UbicacionTecnica;
import AccesoDatos.Consultas;
import Entidades.actividadesavisos;
import Entidades.aviso;
import Entidades.centros;
import Entidades.clase_orden;
import Entidades.equipos;
import Entidades.folios;
import Entidades.grupo_codigos;
import Entidades.grupo_planificacion;
import Entidades.materiales;
import Entidades.puesto_trabajo;
import Entidades.ubicacion_tecnica;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * @author JaroMX
 */
@WebServlet(name = "PeticionModuloModificarAvisos", urlPatterns = {"/PeticionModuloModificarAvisos"})
public class PeticionModuloModificarAvisos extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String Lan = (String) session.getAttribute("Idioma");
            String Use = (String) session.getAttribute("Usuario");
            String Accion = request.getParameter("Accion");
            String Aviso = request.getParameter("Aviso");
            String Tipo = request.getParameter("Tipo");
            String FeCT = request.getParameter("FechaCT");
            String HoCT = request.getParameter("HoraCT");
            String Dato = request.getParameter("Dato");
            String Cate = request.getParameter("Cate");
            String ctdmax = request.getParameter("Parametro4");
            String descr = request.getParameter("Parametro6");
            String sociedad = request.getParameter("Parametro7");
            String ubitec = request.getParameter("Parametro8");
            String equipo = request.getParameter("Parametro9");
            String denominacion = request.getParameter("Parametro10");
            String material = request.getParameter("Parametro5");
            String descripcion = request.getParameter("Parametro2");
            Consultas c = new Consultas();
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("AS");
            int foAc = fo.getFolioActual();
            String ff = fo.getIdFolios() + foAc;
            switch (Accion) {
                case "CargarAviso":
                    JSONArray j = new JSONArray();
                    if (Tipo.equals("1")) {
                        aviso avi = ACC_Aviso.ObtenerInstancia().CargarAvisoSAP(Aviso, Lan);
                        j.add(avi.getNum_notificacion());
                        j.add(avi.getClase_aviso());
                        j.add(avi.getDescripcion());
                        j.add(avi.getStatus_individual_breve_es());
                        j.add(avi.getNum_orden());
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
                        j.add("");
                        j.add(avi.getNum_orden());
                        out.println(j);
                    } else if (Tipo.equals("2")) {
                        aviso avs = ACC_Aviso.ObtenerInstancia().CargarAvisoSAM(Aviso);
                        j.add(avs.getFolio_sam());
                        j.add(avs.getClase_aviso());
                        j.add(avs.getDescripcion());
                        j.add(avs.getStatus_individual_breve_es());
                        j.add(avs.getNum_orden());
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
                        j.add(avs.getModificado());
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
                case "ConsultarCierreTecnico":
                    int co = ACC_Aviso.ObtenerInstancia().ConsultarCTEC(Aviso);
                    out.println(co);
                    break;
                case "InsertarCierreTecnico":
                    folios fos = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("CL");
                    String fact = fos.getIdFolios() + fos.getFolioActual();
                    if (Tipo.equals("1")) {
                        if (ACC_Aviso.ObtenerInstancia().GuardarAVSTALIgue(HoCT, FeCT, Aviso, Use, fact)) {
                            if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT("CL", fos.getFolioActual())) {
                                out.println(1);
                            }
                        }
                    } else if (Tipo.equals("2")) {
                        if (ACC_Aviso.ObtenerInstancia().GuardarAVSTA(HoCT, FeCT, Aviso)) {
                            if (ACC_Aviso.ObtenerInstancia().GuardarAVSTALIgue(HoCT, FeCT, Aviso, Use, fact)) {
                                if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT("CL", fos.getFolioActual())) {
                                    out.println(1);
                                } else {
                                    out.println(0);
                                }
                            } else {
                                out.println(0);
                            }

                        } else {
                            out.println(1);
                        }
                    }
                    break;
                case "CargarActividadesVisual":
                    out.println("<table>");
                    out.println("<tbody>");
                    if (Tipo.equals("1")) {
                        int a;
                        ArrayList<actividadesavisos> ac = ACC_Aviso.ObtenerInstancia().CargarActividadesSAP(Aviso, Lan);
                        for (a = 0; a < ac.size(); a++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT2\" style=\"background: none\" value=\"" + ac.get(a).getPosicion() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT3\" style=\"background: none\" value=\"" + ac.get(a).getGrupo_codigo() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT4\" style=\"background: none\" value=\"" + ac.get(a).getCodigo_medida() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT5\" style=\"background: none\" value=\"" + ac.get(a).getTexto_codigo() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT6\" style=\"background: none\" value=\"" + ac.get(a).getTexto_accion() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT7\" style=\"background: none\" value=\"" + ac.get(a).getFactor_cantidad() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\" value=\"" + c.DateFormat(ac.get(a).getFecha_inicio()) + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\" value=\"" + ac.get(a).getHora_inicio() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\" value=\"" + c.DateFormat(ac.get(a).getFecha_fin()) + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\" value=\"" + ac.get(a).getHora_fin() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT10\" style=\"background: none\" value=\"" + ac.get(a).getNum_actividad() + "\" /></td>");
                            out.println("</tr>");
                        }
                        for (int n = a; n < 6; n++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT2\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT3\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT4\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT5\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT6\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT7\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT10\" style=\"background: none\" /></td>");
                            out.println("</tr>");
                        }

                    } else if (Tipo.equals("2")) {
                        int b;
                        ArrayList<actividadesavisos> ac = ACC_Aviso.ObtenerInstancia().CargarActividadesSAM(Aviso, Lan);
                        for (b = 0; b < ac.size(); b++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT2\" style=\"background: none\" value=\"" + ac.get(b).getPosicion() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT3\" style=\"background: none\" value=\"" + ac.get(b).getGrupo_codigo() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT4\" style=\"background: none\" value=\"" + ac.get(b).getCodigo_medida() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT5\" style=\"background: none\" value=\"" + ac.get(b).getTexto_codigo() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT6\" style=\"background: none\" value=\"" + ac.get(b).getTexto_accion() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT7\" style=\"background: none\" value=\"" + ac.get(b).getFactor_cantidad() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\" value=\"" + c.DateFormat(ac.get(b).getFecha_inicio()) + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\" value=\"" + ac.get(b).getHora_inicio() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\" value=\"" + c.DateFormat(ac.get(b).getFecha_fin()) + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\" value=\"" + ac.get(b).getHora_fin() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT10\" style=\"background: none\" value=\"" + ac.get(b).getNum_actividad() + "\" /></td>");
                            out.println("</tr>");
                        }
                        for (int n = b; n < 6; n++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT2\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT3\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT4\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT5\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT6\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT7\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\"  /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT10\" style=\"background: none\" /></td>");
                            out.println("</tr>");
                        }
                    } else {
                        for (int i = 0; i < 5; i++) {
                            out.println("<tr>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT2\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT3\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT4\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT5\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT6\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT1\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT7\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT8\" style=\"background: none\" /></td>");
                            out.println("<td><input type=\"text\" readOnly class=\"TDACT9\" style=\"background: none\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDACT10\" style=\"background: none\" /></td>");
                            out.println("</tr>");
                        }
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CargarActividadesSAP":
                    int k;
                    ArrayList<actividadesavisos> ac2 = ACC_Aviso.ObtenerInstancia().CargarActividadesSAP(Aviso, Lan);
                    if (ac2.size() > 0) {
                        for (k = 0; k < ac2.size(); k++) {
                            out.println("<tr id=\"trFilaAviso" + k + "\">");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
                            out.println("<td style=\"display:none\" ><input type=\"checkbox\" class=\"TDACT1\" name=\"DelActi\"/></td>");
                            out.println("<td><input type=\"text\" readOnly  class=\"TDACT2\" name=\"TDPosicionAct\" style=\"background: none\" value=\"" + ac2.get(k).getPosicion() + "\" /></td>");
                            out.println("<td><div style=\"width:110px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameGCodigos\" id=\"txtGCod" + k + "\"  class=\"TDACT3S\" maxlength=\"8\" onfocus=\"VerMCCodigos('" + k + "')\" value=\"" + ac2.get(k).getGrupo_codigo() + "\" /><button style=\"display: none;\" onclick=\"AbrirGcodigos('" + k + "')\" id=\"btnGcodigo" + k + "\" class=\"BtnMatchIcon\" name=\"btnGcodigos\"></button></div></td>");
                            out.println("<td><input type=\"text\"  class=\"TDACT4S\" name=\"NameCodigos\" style=\"text-transform: uppercase;\" id=\"txtCod" + k + "\"  maxlength=\"4\" onfocus=\"QuitarMC(" + k + ");\" value=\"" + ac2.get(k).getCodigo_medida() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly name=\"NameCodigosTexts\"  class=\"TDACT5\"  id=\"txtCodtext" + k + "\" onfocus=\"QuitarMC(" + k + ");\" style=\"background: none\" value=\"" + ac2.get(k).getTexto_codigo() + "\" /></td>");
                            out.println("<td><input type=\"text\" name=\"NameTextsAcc\" id=\"TDtxtAcc" + k + "\"class=\"TDACT6S\"  maxlength=\"40\"  onfocus=\"QuitarMC(" + k + ");\" value=\"" + ac2.get(k).getTexto_accion() + "\" /></td>");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
//                            out.println("<td><input type=\"text\" name=\"NameFactor\"  id=\"TDFactor" + k + "\" class=\"TDACT7S\" maxlength=\"3\" onfocus=\"QuitarMC(" + k + ");\" value=\"" + ac2.get(k).getFactor_cantidad() + "\" /></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFInicio\" id=\"TDFecIn" + k + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaIn('" + k + "')\" value=\"" + c.DateFormat(ac2.get(k).getFecha_inicio()) + "\" /><button style=\"display: none;\" onclick=\"AbrirFInci('" + k + "')\" id=\"btnFInicio" + k + "\" class=\"BtnMatchIcon\" name=\"btnFInicio\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHInicio\" id=\"TDHoraIn" + k + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + k + ");\" value=\"" + ac2.get(k).getHora_inicio() + "\" /></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFFin\" id=\"TDFechFin" + k + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaFin('" + k + "')\" value=\"" + c.DateFormat(ac2.get(k).getFecha_fin()) + "\" /><button style=\"display: none;\" onclick=\"AbrirFFin('" + k + "')\" id=\"btnFFin" + k + "\" class=\"BtnMatchIcon\" name=\"btnFFin\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHFin\" id=\"TDHoraFin" + k + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + k + ");\" value=\"" + ac2.get(k).getHora_fin() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly name=\"NameActi\" class=\"TDACT10\" style=\"background: none\" value=\"" + ac2.get(k).getNum_actividad() + "\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" name=\"NameDele\" id=\"TDFilaEl" + k + "\" readOnly  style=\"background: none\" value=\"\" /></td>");
                            out.println("</tr>");
                        }
                        for (int n = k; n < 4; n++) {
                            out.println("<tr id=\"trFilaAviso" + n + "\">");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
                            out.println("<td style=\"display:none\" ><input type=\"checkbox\" class=\"TDACT1\" name=\"DelActi\"/></td>");
                            out.println("<td><input type=\"text\" readOnly name=\"TDPosicionAct\" hidden value=\"0\"  class=\"TDACT2\" style=\"background: none\"/></td>");
                            out.println("<td><div style=\"width:110px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameGCodigos\" id=\"txtGCod" + n + "\"  class=\"TDACT3S\" maxlength=\"8\" onfocus=\"VerMCCodigos('" + n + "')\" /><button style=\"display: none;\" onclick=\"AbrirGcodigos('" + n + "')\" id=\"btnGcodigo" + n + "\" class=\"BtnMatchIcon\" name=\"btnGcodigos\"></button></div></td>");
                            out.println("<td><input type=\"text\"  class=\"TDACT4S\" name=\"NameCodigos\"  style=\"text-transform: uppercase;\" id=\"txtCod" + n + "\"  maxlength=\"4\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
                            out.println("<td><input type=\"text\" readOnly name=\"NameCodigosTexts\"  class=\"TDACT5\"  id=\"txtCodtext" + n + "\" onfocus=\"QuitarMC(" + n + ");\" style=\"background: none\"/></td>");
                            out.println("<td><input type=\"text\" name=\"NameTextsAcc\" id=\"TDtxtAcc" + n + "\"class=\"TDACT6S\"  maxlength=\"40\"  onfocus=\"QuitarMC(" + n + ");\"  /></td>");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
//                            out.println("<td><input type=\"text\" name=\"NameFactor\"  id=\"TDFactor" + n + "\" class=\"TDACT7S\" maxlength=\"3\" onfocus=\"QuitarMC(" + n + ");\" /></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFInicio\" id=\"TDFecIn" + n + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaIn('" + n + "')\"  /><button style=\"display: none;\" onclick=\"AbrirFInci('" + n + "')\" id=\"btnFInicio" + n + "\" class=\"BtnMatchIcon\" name=\"btnFInicio\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHInicio\" id=\"TDHoraIn" + n + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFFin\" id=\"TDFechFin" + n + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaFin('" + n + "')\" /><button style=\"display: none;\" onclick=\"AbrirFFin('" + n + "')\" id=\"btnFFin" + n + "\" class=\"BtnMatchIcon\" name=\"btnFFin\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHFin\" id=\"TDHoraFin" + n + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
//                            out.println("<td><input type=\"text\" readOnly  name=\"NameActi\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" name=\"NameDele\" id=\"TDFilaEl" + n + "\" readOnly  style=\"background: none\" value=\"\" /></td>");
                            out.println("</tr>");
                        }
                    } else {
                        for (int n = 0; n < 6; n++) {
                            out.println("<tr id=\"trFilaAviso" + n + "\">");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
                            out.println("<td style=\"display:none\" ><input type=\"checkbox\" class=\"TDACT1\" name=\"DelActi\"/></td>");
                            out.println("<td><input type=\"text\" readOnly name=\"TDPosicionAct\" hidden value=\"0\" class=\"TDACT2\" style=\"background: none\"/></td>");
                            out.println("<td><div style=\"width:110px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameGCodigos\" id=\"txtGCod" + n + "\"  class=\"TDACT3S\" maxlength=\"8\" onfocus=\"VerMCCodigos('" + n + "')\" /><button style=\"display: none;\" onclick=\"AbrirGcodigos('" + n + "')\" id=\"btnGcodigo" + n + "\" class=\"BtnMatchIcon\" name=\"btnGcodigos\"></button></div></td>");
                            out.println("<td><input type=\"text\"  class=\"TDACT4S\" name=\"NameCodigos\"  style=\"text-transform: uppercase;\" id=\"txtCod" + n + "\"  maxlength=\"4\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
                            out.println("<td><input type=\"text\" readOnly name=\"NameCodigosTexts\"  class=\"TDACT5\"  id=\"txtCodtext" + n + "\" onfocus=\"QuitarMC(" + n + ");\" style=\"background: none\"/></td>");
                            out.println("<td><input type=\"text\" name=\"NameTextsAcc\" id=\"TDtxtAcc" + n + "\"class=\"TDACT6S\"  maxlength=\"40\"  onfocus=\"QuitarMC(" + n + ");\"  /></td>");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
//                            out.println("<td><input type=\"text\" name=\"NameFactor\"  id=\"TDFactor" + n + "\" class=\"TDACT7S\" maxlength=\"3\" onfocus=\"QuitarMC(" + n + ");\" /></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFInicio\" id=\"TDFecIn" + n + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaIn('" + n + "')\"  /><button style=\"display: none;\" onclick=\"AbrirFInci('" + n + "')\" id=\"btnFInicio" + n + "\" class=\"BtnMatchIcon\" name=\"btnFInicio\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHInicio\" id=\"TDHoraIn" + n + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFFin\" id=\"TDFechFin" + n + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaFin('" + n + "')\" /><button style=\"display: none;\" onclick=\"AbrirFFin('" + n + "')\" id=\"btnFFin" + n + "\" class=\"BtnMatchIcon\" name=\"btnFFin\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHFin\" id=\"TDHoraFin" + n + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
//                            out.println("<td><input type=\"text\" readOnly  name=\"NameActi\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" name=\"NameDele\" id=\"TDFilaEl" + n + "\" readOnly  style=\"background: none\" value=\"\" /></td>");
                            out.println("</tr>");
                        }
                    }
                    break;
                case "CargarActividadesSAMEdicion":
                    int b;
                    ArrayList<actividadesavisos> ac = ACC_Aviso.ObtenerInstancia().CargarActividadesSAM(Aviso, Lan);
                    if (ac.size() > 0) {
                        for (b = 0; b < ac.size(); b++) {
                            out.println("<tr id=\"trFilaAviso" + b + "\">");
                            out.println("<td><input type=\"checkbox\" class=\"TDACT1\" name=\"DelActi\"/></td>");
                            out.println("<td><input type=\"text\" readOnly  class=\"TDACT2\" style=\"background: none\" value=\"" + ac.get(b).getPosicion() + "\" /></td>");
                            out.println("<td><div style=\"width:110px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameGCodigos\" id=\"txtGCod" + b + "\"  class=\"TDACT3S\" maxlength=\"8\" onfocus=\"VerMCCodigos('" + b + "')\" value=\"" + ac.get(b).getGrupo_codigo() + "\" /><button style=\"display: none;\" onclick=\"AbrirGcodigos('" + b + "')\" id=\"btnGcodigo" + b + "\" class=\"BtnMatchIcon\" name=\"btnGcodigos\"></button></div></td>");
                            out.println("<td><input type=\"text\"  class=\"TDACT4S\" name=\"NameCodigos\" style=\"text-transform: uppercase;\" id=\"txtCod" + b + "\"  maxlength=\"4\" onfocus=\"QuitarMC(" + b + ");\" value=\"" + ac.get(b).getCodigo_medida() + "\" /></td>");
                            out.println("<td><input type=\"text\" readOnly name=\"NameCodigosTexts\"  class=\"TDACT5\"  id=\"txtCodtext" + b + "\" onfocus=\"QuitarMC(" + b + ");\" style=\"background: none\" value=\"" + ac.get(b).getTexto_codigo() + "\" /></td>");
                            out.println("<td><input type=\"text\" name=\"NameTextsAcc\" id=\"TDtxtAcc" + b + "\"class=\"TDACT6S\"  maxlength=\"40\"  onfocus=\"QuitarMC(" + b + ");\" value=\"" + ac.get(b).getTexto_accion() + "\" /></td>");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
//                            out.println("<td><input type=\"text\" name=\"NameFactor\"  id=\"TDFactor" + b + "\" class=\"TDACT7S\" maxlength=\"3\" onfocus=\"QuitarMC(" + b + ");\" value=\"" + ac.get(b).getFactor_cantidad() + "\" /></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFInicio\" id=\"TDFecIn" + b + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaIn('" + b + "')\" value=\"" + c.DateFormat(ac.get(b).getFecha_inicio()) + "\" /><button style=\"display: none;\" onclick=\"AbrirFInci('" + b + "')\" id=\"btnFInicio" + b + "\" class=\"BtnMatchIcon\" name=\"btnFInicio\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHInicio\" id=\"TDHoraIn" + b + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + b + ");\" value=\"" + ac.get(b).getHora_inicio() + "\" /></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFFin\" id=\"TDFechFin" + b + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaFin('" + b + "')\" value=\"" + c.DateFormat(ac.get(b).getFecha_fin()) + "\" /><button style=\"display: none;\" onclick=\"AbrirFFin('" + b + "')\" id=\"btnFFin" + b + "\" class=\"BtnMatchIcon\" name=\"btnFFin\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHFin\" id=\"TDHoraFin" + b + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + b + ");\" value=\"" + ac.get(b).getHora_fin() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly name=\"NameActi\" class=\"TDACT10\" style=\"background: none\" value=\"" + ac.get(b).getNum_actividad() + "\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" name=\"NameDele\" id=\"TDFilaEl" + b + "\" readOnly  style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namefechacreada\" class=\"TDACT10\" style=\"background: none\" value=\"" + ac.get(b).getFecha_dia() + "\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namehoracreada\" class=\"TDACT10\" style=\"background: none\" value=\"" + ac.get(b).getHora_dia() + "\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"NameAutor\" class=\"TDACT10\" style=\"background: none\" value=\"" + ac.get(b).getAutor() + "\" /></td>");
                            out.println("</tr>");
                        }
                        for (int n = b; n < 4; n++) {
                            out.println("<tr id=\"trFilaAviso" + n + "\">");
                            out.println("<td><input type=\"checkbox\" class=\"TDACT1\" name=\"DelActi\"/></td>");
                            out.println("<td><input type=\"text\" readOnly  class=\"TDACT2\" style=\"background: none\"/></td>");
                            out.println("<td><div style=\"width:110px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameGCodigos\" id=\"txtGCod" + n + "\"  class=\"TDACT3S\" maxlength=\"8\" onfocus=\"VerMCCodigos('" + n + "')\" /><button style=\"display: none;\" onclick=\"AbrirGcodigos('" + n + "')\" id=\"btnGcodigo" + n + "\" class=\"BtnMatchIcon\" name=\"btnGcodigos\"></button></div></td>");
                            out.println("<td><input type=\"text\"  class=\"TDACT4S\" name=\"NameCodigos\"  style=\"text-transform: uppercase;\" id=\"txtCod" + n + "\"  maxlength=\"4\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
                            out.println("<td><input type=\"text\" readOnly name=\"NameCodigosTexts\"  class=\"TDACT5\"  id=\"txtCodtext" + n + "\" onfocus=\"QuitarMC(" + n + ");\" style=\"background: none\"/></td>");
                            out.println("<td><input type=\"text\" name=\"NameTextsAcc\" id=\"TDtxtAcc" + n + "\"class=\"TDACT6S\"  maxlength=\"40\"  onfocus=\"QuitarMC(" + n + ");\"  /></td>");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
//                            out.println("<td><input type=\"text\" name=\"NameFactor\"  id=\"TDFactor" + n + "\" class=\"TDACT7S\" maxlength=\"3\" onfocus=\"QuitarMC(" + n + ");\" /></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFInicio\" id=\"TDFecIn" + n + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaIn('" + n + "')\"  /><button style=\"display: none;\" onclick=\"AbrirFInci('" + n + "')\" id=\"btnFInicio" + n + "\" class=\"BtnMatchIcon\" name=\"btnFInicio\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHInicio\" id=\"TDHoraIn" + n + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFFin\" id=\"TDFechFin" + n + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaFin('" + n + "')\" /><button style=\"display: none;\" onclick=\"AbrirFFin('" + n + "')\" id=\"btnFFin" + n + "\" class=\"BtnMatchIcon\" name=\"btnFFin\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHFin\" id=\"TDHoraFin" + n + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
//                            out.println("<td><input type=\"text\" readOnly name=\"NameActi\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" name=\"NameDele\" id=\"TDFilaEl" + n + "\" readOnly  style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namefechacreada\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namehoracreada\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"NameAutor\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("</tr>");
                        }
                    } else {
                        for (int n = 0; n < 4; n++) {
                            out.println("<tr id=\"trFilaAviso" + n + "\">");
                            out.println("<td><input type=\"checkbox\" class=\"TDACT1\" name=\"DelActi\"/></td>");
                            out.println("<td><input type=\"text\" readOnly  class=\"TDACT2\" style=\"background: none\"/></td>");
                            out.println("<td><div style=\"width:110px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameGCodigos\" id=\"txtGCod" + n + "\"  class=\"TDACT3S\" maxlength=\"8\" onfocus=\"VerMCCodigos('" + n + "')\" /><button style=\"display: none;\" onclick=\"AbrirGcodigos('" + n + "')\" id=\"btnGcodigo" + n + "\" class=\"BtnMatchIcon\" name=\"btnGcodigos\"></button></div></td>");
                            out.println("<td><input type=\"text\"  class=\"TDACT4S\" name=\"NameCodigos\" style=\"text-transform: uppercase;\" id=\"txtCod" + n + "\"  maxlength=\"4\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
                            out.println("<td><input type=\"text\" readOnly name=\"NameCodigosTexts\"  class=\"TDACT5\"  id=\"txtCodtext" + n + "\" onfocus=\"QuitarMC(" + n + ");\" style=\"background: none\"/></td>");
                            out.println("<td><input type=\"text\" name=\"NameTextsAcc\" id=\"TDtxtAcc" + n + "\"class=\"TDACT6S\"  maxlength=\"40\"  onfocus=\"QuitarMC(" + n + ");\"  /></td>");
                            out.println("<td><input type=\"text\"  readOnly class=\"TDACT1\"  style=\"background: none\"/></td>");
//                            out.println("<td><input type=\"text\" name=\"NameFactor\"  id=\"TDFactor" + n + "\" class=\"TDACT7S\" maxlength=\"3\" onfocus=\"QuitarMC(" + n + ");\" /></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFInicio\" id=\"TDFecIn" + n + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaIn('" + n + "')\"  /><button style=\"display: none;\" onclick=\"AbrirFInci('" + n + "')\" id=\"btnFInicio" + n + "\" class=\"BtnMatchIcon\" name=\"btnFInicio\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHInicio\" id=\"TDHoraIn" + n + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
                            out.println("<td><div style=\"width:120px;\"><input type=\"text\" style=\"text-transform: uppercase;\" name=\"NameFFin\" id=\"TDFechFin" + n + "\" readOnly  class=\"TDACT111SS\" maxlength=\"10\" onfocus=\"VerMCFechaFin('" + n + "')\"  /><button style=\"display: none;\" onclick=\"AbrirFFin('" + n + "')\" id=\"btnFFin" + n + "\" class=\"BtnMatchIcon\" name=\"btnFFin\"></button></div></td>");
                            out.println("<td><input type=\"time\" name=\"NameHFin\" id=\"TDHoraFin" + n + "\" class=\"TDACT11\" onfocus=\"QuitarMC(" + n + ");\"/></td>");
//                            out.println("<td><input type=\"text\" readOnly name=\"NameActi\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" name=\"NameDele\" id=\"TDFilaEl" + n + "\" readOnly  style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namefechacreada\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"Namehoracreada\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("<td style=\"display:none\"><input type=\"text\" readOnly name=\"NameAutor\" class=\"TDACT10\" style=\"background: none\" value=\"\" /></td>");
                            out.println("</tr>");
                        }
                    }
                    break;
                case "ConsultaClaseOrden":
                    ArrayList<clase_orden> clo = ACC_ClaseOrden.ObtenerInstancia().ConsultarClaseOrdenAV("descripcion_" + Lan);
                    if (clo.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < clo.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + clo.get(i).getClase_orden() + "','CLasOR')\">");
                            out.println("<td>" + clo.get(i).getClase_orden() + "</td>");
                            out.println("<td>" + clo.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaCentro":
                    ArrayList<centros> ce = ACC_Aviso.ObtenerInstancia().ConsultaCentroAviso();
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ce.get(i).getCentro() + "','Centro')\">");
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
                case "ConsultaPuestoOrd":
                    ArrayList<puesto_trabajo> ptoor = ACC_Aviso.ObtenerInstancia().ConsultaPTOOrdAviso(Lan);
                    if (ptoor.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ptoor.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ptoor.get(i).getPuesto_trabajo() + "-" + ptoor.get(i).getCentro() + "','PuestoOrden')\">");
                            out.println("<td>" + ptoor.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + ptoor.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarDatos":
                    int a = ACC_Aviso.ObtenerInstancia().ValidarDatosModiAvisos(Dato, Cate);
                    out.println(a);
                    break;
                case "ConsultaUbitec":
                    String deno = "denominacion_" + Lan;
                    LinkedList<ubicacion_tecnica> ubi = ACC_UbicacionTecnica.ObtenerInstancia().AvisoUbicacionMatch(ctdmax, ubitec, deno, descr, sociedad);
                    if (ubi.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ubi.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ubi.get(i).getUbicacion_tecnica() + "','ubitec')\">");
                            out.println("<td>" + ubi.get(i).getUbicacion_tecnica() + "</td>");
                            out.println("<td>" + ubi.get(i).getDenominacion() + "</td>");
                            out.println("<td>" + ubi.get(i).getSociedad() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaEquipos":
                    String de = "denominacion_" + Lan;
                    LinkedList<equipos> equi = ACC_Equipos.ObtenerInstancia().AvisoEquiposMatch(ctdmax, equipo, de, denominacion);
                    if (equi.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < equi.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + equi.get(i).getNum_equipo() + "','equipo')\">");
                            out.println("<td>" + equi.get(i).getDenominacion_es() + "</td>");
                            out.println("<td>" + equi.get(i).getNum_equipo() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaMateriales":
                    String desmat = "descripcion_" + Lan;
                    LinkedList<materiales> ma = ACC_Material.ObtenerInstancia().ConsultaMatchMaterial(ctdmax, material, "", desmat, descripcion, "");
                    if (ma.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ma.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ma.get(i).getMaterial() + "','conjunto')\">");
                            out.println("<td>" + ma.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + ma.get(i).getMaterial() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaGrupoPlanificacion":
                    ArrayList<grupo_planificacion> gp = ACC_Aviso.ObtenerInstancia().ConsultaGeupolanMatch();
                    if (gp.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < gp.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + gp.get(i).getGrupo_planificador_p_servicio_cliente_mante() + "-" + gp.get(i).getCentro_planificacion_mantenimiento() + "-" + gp.get(i).getNombre_grupo_planificador() + "','GPlan')\">");
                            out.println("<td>" + gp.get(i).getCentro_planificacion_mantenimiento() + "</td>");
                            out.println("<td>" + gp.get(i).getGrupo_planificador_p_servicio_cliente_mante() + "</td>");
                            out.println("<td>" + gp.get(i).getNombre_grupo_planificador() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaPuesto":
                    ArrayList<puesto_trabajo> pto = ACC_Aviso.ObtenerInstancia().ConsultaPTOOrdAviso(Lan);
                    if (pto.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pto.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + pto.get(i).getPuesto_trabajo() + "-" + pto.get(i).getDescripcion() + "','Puesto')\">");
                            out.println("<td>" + pto.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + pto.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaGCodigos":
                    String idinp = request.getParameter("IdInput");
                    String textoidi = "texto_" + Lan;
                    out.println("<table>");
                    out.println("<tbody>");
                    ArrayList<grupo_codigos> gc = ACC_Grupo_codigos.ObtenerInstancia().ObetenrCod(textoidi);
                    for (int m = 0; m < gc.size(); m++) {
                        out.println("<tr onclick=\"seleccionar('" + gc.get(m).getGrupo_codigos() + "|" + gc.get(m).getCodigo() + "|" + gc.get(m).getTexto() + "|" + idinp + "','GrupCodigo')\">");
                        out.println("<td>" + gc.get(m).getGrupo_codigos() + "</td>");
                        out.println("<td>" + gc.get(m).getCodigo() + "</td>");
                        out.println("<td>" + gc.get(m).getTexto() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "CargarDatosMaestroEquipo":
                    String dat[] = ACC_Aviso.ObtenerInstancia().GetDataEquipoAviso(equipo);
                    JSONArray js = new JSONArray();
                    js.add(dat[0]);
                    js.add(dat[1]);
                    js.add(dat[2]);
                    out.println(js);
                    break;
                case "GuardarCabeceraAvisoSAM":
                    String folioSAM = request.getParameter("FSAM");
                    String textobre = request.getParameter("textobreve");
                    String ubicatec = request.getParameter("ubicaci");
                    String numequip = request.getParameter("nummequipo");
                    String conjunto = request.getParameter("conjun");
                    String gpoPlani = request.getParameter("grupoplan");
                    String puestotr = request.getParameter("puestotra");
                    String textobr2 = request.getParameter("texto2");
                    String data[] = {folioSAM, textobre, ubicatec, numequip, conjunto, gpoPlani, puestotr, textobr2};
                    ACC_Aviso.ObtenerInstancia().ActualizarAvisoSAM(data);
                    break;
                case "GuardarCabeceraAvisoSAP":
                    String foliS = request.getParameter("FoliSAP");
                    String fechaS = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String horaS = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                    String userSAP = Use;
                    ACC_Aviso.ObtenerInstancia().GuardarCabeceraSAP(foliS, fechaS, horaS, userSAP, ff);
                    break;
                case "DELDATAACT":
                    ACC_Aviso.ObtenerInstancia().DelAvisoSAM(Aviso);
                    break;
                case "DELDATAACTSAP":
                    ACC_Aviso.ObtenerInstancia().DelAvisoSAP(Aviso);
                    break;
                case "GuardarACSAM":
                    String folioSM = request.getParameter("FolSAM");
                    String posiciS = request.getParameter("PosiSAM");
                    String GrupoCo = request.getParameter("GCodigo");
                    String codig = request.getParameter("Codigo");
                    String txtcodig = request.getParameter("TxtCodigo");
                    String TxtAcci = request.getParameter("TxtAcci");
                    String Factor = request.getParameter("Factor");
                    String FInicio = request.getParameter("FInicio");
                    String HInicio = request.getParameter("HInicio");
                    String FFin = request.getParameter("FFin");
                    String HFin = request.getParameter("HFin");
                    String Activid = request.getParameter("Activid");
                    String fModif = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String homodi = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                    String FCreada = request.getParameter("FCreada");
                    if (FCreada.length() > 0) {
                        FCreada = FCreada;
                    } else {
                        FCreada = fModif;
                    }
                    String HCreada = request.getParameter("HCreada");
                    if (HCreada.length() > 0) {
                        HCreada = HCreada;
                    } else {
                        HCreada = homodi;
                    }
                    String Autor = request.getParameter("Autor");
                    if (Autor.length() > 0) {
                        Autor = Autor;
                    } else {
                        Autor = Use;
                    }
                    String datamod[] = {
                        folioSM,
                        FormatHora(HCreada),
                        FCreada,
                        GrupoCo,
                        codig,
                        TxtAcci,
                        Autor,
                        fModif,
                        FormatHora(homodi),
                        FInicio,
                        FFin,
                        Factor,
                        FormatHora(HInicio),
                        FormatHora(HFin),
                        Activid,
                        txtcodig,
                        Use,
                        posiciS
                    };
                    ACC_Aviso.ObtenerInstancia().GuardarAviMod(datamod);
                    break;
                case "GuardarACSSAP":
                    String foliSAPP = request.getParameter("Foli");
                    String posiSAPP = request.getParameter("posiSAP");
                    String indborr = request.getParameter("indBor");
                    String fechaSAp = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String horaSeap = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                    String Activida = request.getParameter("Activid");
                    String txtACCio = request.getParameter("TxtAcci");
                    String GrupCodi = request.getParameter("GCodigo");
                    String codigoAc = request.getParameter("Codigo");
                    String txtCodfi = request.getParameter("TxtCodigo");
                    String fechsap1 = request.getParameter("FInicio");
                    String fechasa2 = request.getParameter("FFin");
                    String horasap1 = request.getParameter("HInicio");
                    String horasap2 = request.getParameter("HFin");
                    String factorca = request.getParameter("Factor");
                    String usesap = Use;
                    String pos1 = Chepos(Integer.parseInt(posiSAPP));
                    String datsap[] = {
                        foliSAPP,
                        fechaSAp,
                        FormatHora(horaSeap),
                        Activida,
                        txtACCio,
                        GrupCodi,
                        codigoAc,
                        fechsap1,
                        fechasa2,
                        FormatHora(horasap1),
                        FormatHora(horasap2),
                        usesap,
                        ff,
                        indborr,
                        pos1
                    };
                    String dataDM[] = {
                        foliSAPP,
                        GrupCodi,
                        codigoAc,
                        txtCodfi,
                        txtACCio,
                        factorca,
                        fechsap1,
                        FormatHora(horasap1),
                        fechasa2,
                        FormatHora(horasap2),
                        Activida,
                        pos1,
                        indborr
                    };
                    ACC_Aviso.ObtenerInstancia().GuardarAviModSAP(datsap);
                    ACC_Aviso.ObtenerInstancia().GuardarAviModSAPDM(dataDM);
                    break;
                case "FolioAct":
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("AS", fo.getFolioActual());
                    break;
            }

        }
    }

    public String FormatHora(String hora) {
        String time = hora;
        if (hora.length() < 10) {
            String ar[] = hora.split(":");
            String hh = ar[0];
            String mm = ar[1];
            time = hh + ":" + mm + ":" + "00";
        }
        return time;
    }

    public String Chepos(int data) {
        String i = String.valueOf(data);
        if (data < 10) {
            i = "000" + data;
        }
        if (data >= 10 && data < 100) {
            i = "00" + data;
        }
        if (data >= 100 && data < 1000) {
            i = "0" + data;
        }
        if (data >= 1000 && data < 10000) {
            i = String.valueOf(data);
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
