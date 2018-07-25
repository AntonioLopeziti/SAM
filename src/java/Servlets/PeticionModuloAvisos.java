/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.Consultas;
import AccesoDatos.ACC_GrupoPlanificacion;
import AccesoDatos.ACC_Usuarios;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Equipos;
import AccesoDatos.ACC_Aviso;
import AccesoDatos.ACC_Avisossap_modificados;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_ClaseOrden;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Grupo_codigos;
import AccesoDatos.ACC_PuestoTrabajo;
import AccesoDatos.ACC_Qmm_avisos_crea;
import AccesoDatos.ACC_Reservas;
import AccesoDatos.ACC_UbicacionTecnica;
import Entidades.puesto_trabajo;
import Entidades.grupo_planificacion;
import Entidades.usuarios;
import Entidades.centros;
import Entidades.materiales;
import Entidades.equipos;
import Entidades.ubicacion_tecnica;
import Entidades.aviso;
import Entidades.avisossap_modificados;
import Entidades.clase_orden;
import Entidades.folios;
import Entidades.grupo_codigos;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author JaroMX
 */
@WebServlet(name = "PeticionModuloAvisos", urlPatterns = {"/PeticionModuloAvisos"})
public class PeticionModuloAvisos extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
 /*Idioma*/
            HttpSession session = request.getSession();
            String Lenguaje = (String) session.getAttribute("Idioma");
            String Nombre = (String) session.getAttribute("Usuario");
            String accion = request.getParameter("Action");
            String aviso = request.getParameter("Parametro1");
            String descripcion = request.getParameter("Parametro2");
            String notificacion = request.getParameter("Paramaetro3");
            String ctdmax = request.getParameter("Parametro4");
            /*Match Ubicacion tecnica*/

            String descr = request.getParameter("Parametro6");
            String sociedad = request.getParameter("Parametro7");
            String ubitec = request.getParameter("Parametro8");
            /*Match equipos*/
            String equipo = request.getParameter("Parametro9");
            String denominacion = request.getParameter("Parametro10");
            /*Match Conjunto (Materiales)*/
            String material = request.getParameter("Parametro5");

            String centrop = request.getParameter("Parametro11");
            String claseAviso = "M3";
            String status = "MEAB";
            String denoubitec = request.getParameter("Parametro14");
            String textobrevep = request.getParameter("Parametro15");
            String colonia = request.getParameter("Parametro16");
            String poblacion = request.getParameter("Parametro17");
            String estado = request.getParameter("Parametro18");
            String pais = request.getParameter("Parametro19");
            String telefono = request.getParameter("Parametro20");
            String correo = request.getParameter("Parametro21");
            String statOR = request.getParameter("statOR");
            String grupop = request.getParameter("Parametro22");
            String centrop6 = request.getParameter("Parametro23");

            String Equipo = request.getParameter("Equi");
            String ubte = request.getParameter("Ubite");
            /*Match puesto trabajo*/
            String puestot = request.getParameter("Parametro24");
            String centro = request.getParameter("Parametro25");

            String depres = request.getParameter("Parametro26");
            String depres2 = request.getParameter("Parametro27");
            String responsable = request.getParameter("Parametro28");
            String responsable2 = request.getParameter("Parametro29");
            String autor = request.getParameter("Parametro30");
            String fecha = request.getParameter("Parametro31");
            String hor = request.getParameter("Parametro32");
            String cod1 = request.getParameter("Parametro33");
            String codi2 = request.getParameter("Parametro34");
            String desc = request.getParameter("Parametro35");
            String nota1 = request.getParameter("parrafo1");
            String nota2 = request.getParameter("parrafo2");
            String nota3 = request.getParameter("parrafo3");
            String nota4 = request.getParameter("parrafo4");
            String nota5 = request.getParameter("parrafo5");
            String nota6 = request.getParameter("parrafo6");
            String folio = request.getParameter("Parametro37");
            String textobreve = request.getParameter("Parametro38");
            String id = request.getParameter("id");
            String filas = "2";
            String vacio = "";

            String Random = request.getParameter("Random");
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("AV");
            String folioSAM = fo.getIdFolios() + fo.getFolioActual();

            switch (accion) {
                case "ConsultaAviso":

                    LinkedList<aviso> a = ACC_Aviso.ObtenerInstancia().ConsultaMatchAviso1();
                    if (a.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < a.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + a.get(i).getClase_aviso() + "', 'avisos')\">");
                            out.println("<td>" + a.get(i).getClase_aviso() + "</td>");
                            out.println("<td>" + a.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaUbitec":
                    String deno = "denominacion_" + Lenguaje;

                    LinkedList<ubicacion_tecnica> ubi = ACC_UbicacionTecnica.ObtenerInstancia().AvisoUbicacionMatch(ctdmax, ubitec, deno, descr, sociedad);
                    if (ubi.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ubi.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ubi.get(i).getUbicacion_tecnica() + "|" + ubi.get(i).getDenominacion() + "','ubitec')\">");
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
                case "ConsultaCentro":
                    String Centr = request.getParameter("Centr");
                    String Denoc = request.getParameter("Denoc");
                    String CANCe = request.getParameter("CANCe");
                    LinkedList<centros> cetr = ACC_Centro.ObtenerInstancia().DataMasterCentrosMOD(Centr, Denoc, CANCe);
                    if (cetr.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cetr.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + cetr.get(i).getCentro() + "', 'centro')\">");
                            out.println("<td>" + cetr.get(i).getCentro() + "</td>");
                            out.println("<td>" + cetr.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                    break;
                case "ConsultaEquipos":
                    String de = "denominacion_" + Lenguaje;

                    LinkedList<equipos> equi = ACC_Equipos.ObtenerInstancia().AvisoEquiposMatch(ctdmax, equipo, de, denominacion);
                    if (equi.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < equi.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + equi.get(i).getNum_equipo() + "|" + equi.get(i).getDenominacion_es() + "','equipo')\">");
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
                    String desmat = "descripcion_" + Lenguaje;

                    LinkedList<materiales> ma = ACC_Material.ObtenerInstancia().ConsultaMatchMaterial(ctdmax, material, "", desmat, descripcion, "");
                    if (ma.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ma.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ma.get(i).getMaterial() + "|" + ma.get(i).getDescripcion() + "','conjunto')\">");
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
                    int e = Integer.parseInt(ctdmax);
                    LinkedList<grupo_planificacion> gru = ACC_GrupoPlanificacion.obtenerInstancia().AvisoMatchGrupoPlanPA(grupop, centrop, ctdmax);
                    if (gru.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < gru.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + gru.get(i).getGrupo_planificador_p_servicio_cliente_mante() + "|" + gru.get(i).getCentro_planificacion_mantenimiento() + "', 'grupop')\">");
                            out.println("<td>" + gru.get(i).getGrupo_planificador_p_servicio_cliente_mante() + "</td>");
                            out.println("<td>" + gru.get(i).getCentro_planificacion_mantenimiento() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println("No se encuentran datos");
                    }
                    break;
                case "CargarGrupoPlanificacion":
                    grupo_planificacion g = ACC_GrupoPlanificacion.obtenerInstancia().CargarGrupo(id);
                    out.println("<input type=\"text\" value=\"" + g.getId_gp() + "\" id=\"idGrupo\"/> ");
                    out.println("<input type=\"text\" value=\"" + g.getGrupo_planificador_p_servicio_cliente_mante() + "\" id=\"GrupoM\"/>");
                    out.println("<input type=\"text\" value=\"" + g.getCentro_planificacion_mantenimiento() + "\" id=\"CentroM\"/>");
                    break;

                case "GuardarAviso":
                    String folioSAM2 = fo.getIdFolios() + fo.getFolioActual();
                    Consultas c1 = new Consultas();
                    String NFolio = ACC_Aviso.ObtenerInstancia().GuardarCabecera_avisos_crea(folio, hor, c1.DateFormatGuion(fecha), centrop, claseAviso, textobreve, equipo, cod1, codi2, statOR, material, ubitec, grupop, puestot, centro, depres, depres2, responsable, responsable2, autor, desc, Random);
                    //if (ACC_Aviso.ObtenerInstancia().GuardarCabecera_avisos_crea(folio, hor, c1.DateFormatGuion(fecha), centrop, claseAviso, textobreve, equipo, cod1, codi2, statOR, material, ubitec, grupop, puestot, centro, depres, depres2, responsable, responsable2, autor, desc) != "") {
                    if(NFolio != ""){
                        out.println(2 + "," + NFolio);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaPuestoTrabajo":
                    String ptrRe = request.getParameter("ptrRe");
                    String ptrCe = request.getParameter("ptrCe");
                    String y = "denominacion_" + Lenguaje;

                    LinkedList<puesto_trabajo> ptr = ACC_PuestoTrabajo.ObtenerInstancia().elAvisoPuestoTrabajo(ctdmax, y, descripcion, centro, puestot);
                    if (ptr.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ptr.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + ptr.get(i).getPuesto_trabajo() + "|" + ptr.get(i).getCentro() + "|" + ptr.get(i).getDenominacion() + "|" + ptrRe + "|" + ptrCe + "','ptr')\">");
                            out.println("<td>" + ptr.get(i).getPuesto_trabajo() + "</td>");
                            out.println("<td>" + ptr.get(i).getCentro() + "</td>");
                            out.println("<td>" + ptr.get(i).getDenominacion() + "</td>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCUca":
                    int eq;
//                    int Ubte;
//                    if (ubitec.equals("")) {
//                        Ubte = 1;
//                    } else {
//                        Ubte = ACC_UbicacionTecnica.ObtenerInstancia().ConsultaUbicaciones(ubitec);
//                    }
                    if (equipo.equals("")) {
                        eq = 1;
                    } else {
                        eq = ACC_Equipos.ObtenerInstancia().ConsultaEquipos(equipo);
                    }
                    //out.println(Ubte + "," + eq);
                    out.println(eq);
                    break;

                case "MatchGrupCod":
                    String textoidi = "texto_" + Lenguaje;
                    String co = request.getParameter("numbe");
                    out.println("<table>");
                    out.println("<tbody>");
                    ArrayList<grupo_codigos> gc = ACC_Grupo_codigos.ObtenerInstancia().ObetenrCod(textoidi);
                    for (int m = 0; m < gc.size(); m++) {
                        out.println("<tr onclick=\"seleccionarGC('" + gc.get(m).getGrupo_codigos() + "','" + gc.get(m).getCodigo() + "','" + gc.get(m).getTexto() + "','" + co + "','GrupCodi')\">");
                        out.println("<td>" + gc.get(m).getCodigo() + "</td>");
                        out.println("<td>" + gc.get(m).getTexto() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "GuardarTABDat":
                    String grupoCod = request.getParameter("grupoCod");
                    String Descod = request.getParameter("Descod");
                    String texCO = request.getParameter("texCO");
                    String TexAci = request.getParameter("TexAci");
                    String FuCant = request.getParameter("FuCant");
                    String Feca1 = request.getParameter("Feca1");
                    String Hor1 = request.getParameter("Hor1");
                    String Feca2 = request.getParameter("Feca2");
                    String Hor2 = request.getParameter("Hor2");
                    String folTab = request.getParameter("folTab");
                    String ObjeLan = "";
                    String ObjeLen = "";
                    if (Lenguaje.equals("ES")) {
                        ObjeLan = texCO;
                        ObjeLen = "";
                    } else {
                        ObjeLan = "";
                        ObjeLen = texCO;

                    }
                    int nuac = ACC_Qmm_avisos_crea.ObtenerInstancia().RetornCantidattfr(folTab) + 1;
                    Consultas con = new Consultas();
                    if (ACC_Aviso.ObtenerInstancia().GuardarAviQmm(folTab, hor, fecha, grupoCod, Descod, TexAci, autor, con.DateFormatGuion(Feca1), con.DateFormatGuion(Feca2), FuCant, Hor1, Hor2, nuac, ObjeLan, ObjeLen) == true) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                case "ValidarEEquip":

                    equipos eqp = ACC_Equipos.ObtenerInstancia().ConsultaEquipoCrearAvisos(Equipo);

                    if (!Equipo.equals(eqp.getNum_equipo())) {
                        out.println(0);
                    } else {
                        out.println("<input type=\"text\" id=\"GrPL\" value=\"" + eqp.getGrupo_planificador() + "\"/>");
                        out.println("<input type=\"text\" id=\"CPMa\" value=\"" + eqp.getCentro_plani_mante() + "\"/>");
                        out.println("<input type=\"text\" id=\"IDUbc\" value=\"" + eqp.getId_ubitec() + "\"/>");
                        out.println("<input type=\"text\" id=\"CPTr\" value=\"" + eqp.getCentro_puesto_trabajo() + "\"/>");
                        out.println("<input type=\"text\" id=\"CPPTRA\" value=\"" + eqp.getPuesto_responsable_medmnte() + "\"/>");

                    }
                    break;
                case "ValidarUbitec":
                    String denom = "denominacion_" + Lenguaje;
                    ubicacion_tecnica ute = ACC_UbicacionTecnica.ObtenerInstancia().CargarDatosUbicaicon(ubte, denom);

                    if (!ubte.equals(ute.getUbicacion_tecnica())) {
                        out.println(0);
                    } else {
                        out.println("<input type=\"text\" id=\"GrPL2\" value=\"" + ute.getGrupo_planificador_servicio_cliente_mante() + "\"/>");
                        out.println("<input type=\"text\" id=\"CPMa2\" value=\"" + ute.getCentro_planificacion_mante() + "\"/>");
                        out.println("<input type=\"text\" id=\"IDUbc2\" value=\"" + ute.getUbicacion_tecnica() + "\"/>");
                        out.println("<input type=\"text\" id=\"CPTr2\" value=\"" + ute.getCentro_emplazamiento() + "\"/>");
                        out.println("<input type=\"text\" id=\"CPPTRA2\" value=\"" + ute.getPuesto_trabajo() + "\"/>");
                    }
                    break;
                case "ValidarClasOrde":
                    ArrayList<clase_orden> clo = ACC_ClaseOrden.ObtenerInstancia().ConsultarClaseOrdenAV("descripcion_" + Lenguaje);

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
                    }

                    break;
                case "ACTaviORD":

                    String folORD = request.getParameter("folORD");
                    String folAV = request.getParameter("folAV");
                    if (ACC_Aviso.ObtenerInstancia().ACTUALIZArAV(folORD, folAV)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }

                    break;
                case "ACTaviORDSAP":
                    String folORDsp = request.getParameter("folORD");
                    String folAVsp = request.getParameter("folAV");
                    if (ACC_Aviso.ObtenerInstancia().GuardarAV(folAVsp, folORDsp) == true) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                case "GuardaTEXTos":
                    String fila = request.getParameter("fila");
                    String linea = request.getParameter("linea");
                    String foli = request.getParameter("foli");

                    if (ACC_Aviso.ObtenerInstancia().GuardarTEXTos(fila, linea, foli) == true) {

                    } else {
                    }

                    break;
                case "NuevFolio":
                    folios f = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("AV");
                    int fol = f.getFolioActual();

                    if (ACC_Aviso.ObtenerInstancia().ActualizarGua("AV", fol) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "TERconAV":
                    String ti_co = request.getParameter("ti_co");
                    String fe_co = request.getParameter("fe_co");
                    String foldAV = request.getParameter("folDavi");
                    folios fos = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("CL");
                    String fact = "CL" + fos.getFolioActual();
                    if (ACC_Aviso.ObtenerInstancia().GuardarAVSTA(ti_co, fe_co, foldAV)) {
                        if (ACC_Aviso.ObtenerInstancia().GuardarAVSTALIgue(ti_co, fe_co, foldAV, Nombre, fact)) {
                            if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT("CL", fos.getFolioActual())) {
                                out.println(0);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }

                    } else {
                        out.println(1);
                    }
                    break;
                case "TERconSAP":

                    String ti_co1 = request.getParameter("ti_co");
                    String fe_co1 = request.getParameter("fe_co");
                    String foldAV1 = request.getParameter("folDavi");
                    folios fos1 = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("CL");
                    String fact1 = "CL" + fos1.getFolioActual();

//                     avisossap_modificados asm =ACC_Avisossap_modificados.ObtenerInstancia().Cargaravisossap(folda);
//                    if(!asm.getFolio_aviso_sap().equals("")){
//                        if (ACC_Aviso.ObtenerInstancia().ACTULIZAVSTAsap(folda)) {
//                                out.println(0);
//                            } else {
//                                out.println(1);
//                            }
//                    }else{
//                        if (ACC_Aviso.ObtenerInstancia().GuardarAVSTAsap(folda) == true) {
//                            out.println(0);
//                        } else {
//                            out.println(1);
//                        }
//                  }
                    if (ACC_Aviso.ObtenerInstancia().GuardarAVSTALIgue(ti_co1, fe_co1, foldAV1, Nombre, fact1)) {
                        if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT("CL", fos1.getFolioActual())) {
                            out.println(0);
                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(1);
                    }
                    break;
                case "RevisarFolio":
                    String ok = ACC_Reservas.ObtenerInstancia().CheckFolioAVISOS(folioSAM);
                    out.println(folioSAM);
                    break;
                case "ActualizarFolioAviso":
                    String fwe = ACC_Aviso.ObtenerInstancia().FolioPosAvisos(Random);
                    out.println(fwe);
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
            Logger.getLogger(PeticionModuloAvisos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PeticionModuloAvisos.class.getName()).log(Level.SEVERE, null, ex);
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
