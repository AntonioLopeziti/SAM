/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Aviso;
import AccesoDatos.ACC_Cabecera_aviso;
import AccesoDatos.ACC_Qmm_avisos_crea;
import AccesoDatos.ACC_Texto_avisos_crea;
import AccesoDatos.Consultas;
import Entidades.CabeceraAviso;
import Entidades.actividadesavisos;
import Entidades.areatexto;
import Entidades.aviso;
import Entidades.qmm_avisos_crea;
import Entidades.texto_avisos_crea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonathan Lopez
 */
@WebServlet(name = "peticionVisualizarAvisoGeneral", urlPatterns = {"/peticionVisualizarAvisoGeneral"})
public class peticionVisualizarAvisoGeneral extends HttpServlet {

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
            String Languaj = (String) session.getAttribute("Idioma");
            String accion = request.getParameter("Action");
            String AVISOSAP = request.getParameter("AvisoS");
            String AVISOSAM = request.getParameter("AvisoM");
            String Idioma = request.getParameter("Idioma");
            Consultas con = new Consultas();
            switch (accion) {
                case "CargarAviso":
                    if (AVISOSAM.equals("") || AVISOSAM == null) {                     
                    
                    aviso avi = ACC_Aviso.ObtenerInstancia().CargarAviso(AVISOSAP);
                    
                        out.println("<input type=\"text\" value=\"" + avi.getNum_notificacion() + "\" id=\"notifica\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getClase_aviso() + "\" id=\"clase_avi\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getDescripcion() + "\" id=\"descrip\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getStatus_individual_breve_es() + "\" id=\"status\"/> ");//modifico por idioma
                        out.println("<input type=\"text\" value=\"" + avi.getUbicación_tecnica() + "\" id=\"ubitec\"/> ");//Modifico por acento ubicación
                        out.println("<input type=\"text\" value=\"" + avi.getDenominacion_ubicacion_tecnica() + "\" id=\"desubi\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getNum_equipo() + "\" id=\"equipo\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getDenominacion_objeto_tecnico() + "\" id=\"desequi\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getConjunto() + "\" id=\"conjunt\"/> ");
                        out.println("<input type=\"text\" value=\"\" id=\"desconjunto\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getGrupo_planificador_servicio_cliente_mante() + "\" id=\"grupplani\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getCentro_planificador_mante() + "\" id=\"centroplani\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getNombre_grupo_plani_mante() + "\" id=\"nombrecen\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getCentro() + "\" id=\"cpm\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getNombre_autor_aviso() + "\" id=\"autor\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getTexto_breve_puesto_trabajo() + "\" id=\"denpuesto\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getCentro() + "\" id=\"cenemp\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getPuesto_trabajo_responsable_medidas_mantenimiento() + "\" id=\"puesto\"/> ");
                        out.println("<input type=\"text\" value=\"" + con.DateFormat(avi.getFecha_aviso()) + "\" id=\"fecha\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getHora_aviso() + "\" id=\"hora\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getTexto_breve() + "\" id=\"texto\"/> ");
                        
                    
                    } else if (AVISOSAP.equals("") || AVISOSAP == null) {
                        if(ACC_Cabecera_aviso.ObtenerInstancia().CArgarDatVIS(AVISOSAM) == true){
                    CabeceraAviso cabe = ACC_Cabecera_aviso.ObtenerInstancia().CargarDatosAvisos(AVISOSAM, Idioma);
                    out.println("<input type=\"text\" value=\"" + cabe.getFolio_sam() + "\" id=\"notifica\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getHora_dia() + "\" id=\"hora\"/> ");
                    out.println("<input type=\"text\" value=\"" + con.DateFormat(cabe.getFecha()) + "\" id=\"fecha\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getCentro() + "\" id=\"cpm\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getClase_aviso() + "\" id=\"clase_avi\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getTexto_breve() + "\" id=\"descrip\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getNum_equipo() + "\" id=\"equipo\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getGrupo_codigo_codificacion() + "\" id=\"GrupoCodificacion_A1\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getCodificacion() + "\" id=\"Codificacion_A1\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getStatus_sistema_aviso_conjunto()+ "\" id=\"status\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getUbicacion_tecnica() + "\" id=\"ubitec\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getConjunto() + "\" id=\"conjunt\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getGrupo_planificador_servicio_cliente_mante() + "\" id=\"grupplani\"/>");
                    out.println("<input type=\"text\" value=\"" + cabe.getPuesto_trabajo_responsable_medida_mante()+ "\" id=\"puesto\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getCentro_planificacion_mante() + "\" id=\"centroplani\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getTexto_breve2() + "\" id=\"texto\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getInterlocutor() + "\" id=\"Interlocutor_A1\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getNombre_visualizaciones_lista() + "\" id=\"DescripcionInterlocutor_A1\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getInterlocutor_vera() + "\" id=\"Interlocutor2_A1\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getNombre_visualizaciones_lista_vera() + "\" id=\"DrecripcionInterlocutor2_A1\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getNombre_autor_aviso() + "\" id=\"autor\"/> ");
                    out.println("<input type=\"text\" value=\"" + cabe.getNum_orden()+ "\" id=\"nuOrde\"/> ");
                    
                    }
                    else{
                        String queryCA = "SELECT * FROM PM.avisos WHERE folio_sam='" + AVISOSAM + "'";
                    
                    
                    aviso avi = ACC_Aviso.ObtenerInstancia().CargarAviso(AVISOSAM);
                    
                        out.println("<input type=\"text\" value=\"" + avi.getNum_notificacion() + "\" id=\"notifica\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getClase_aviso() + "\" id=\"clase_avi\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getDescripcion() + "\" id=\"descrip\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getStatus_individual_breve_es() + "\" id=\"status\"/> ");//modifico por idioma
                        out.println("<input type=\"text\" value=\"" + avi.getUbicación_tecnica() + "\" id=\"ubitec\"/> ");//Modifico por acento ubicación
                        out.println("<input type=\"text\" value=\"" + avi.getDenominacion_ubicacion_tecnica() + "\" id=\"desubi\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getNum_equipo() + "\" id=\"equipo\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getDenominacion_objeto_tecnico() + "\" id=\"desequi\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getConjunto() + "\" id=\"conjunt\"/> ");
                        out.println("<input type=\"text\" value=\"\" id=\"desconjunto\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getGrupo_planificador_servicio_cliente_mante() + "\" id=\"grupplani\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getCentro_planificador_mante() + "\" id=\"centroplani\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getNombre_grupo_plani_mante() + "\" id=\"nombrecen\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getCentro() + "\" id=\"cpm\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getNombre_autor_aviso() + "\" id=\"autor\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getTexto_breve_puesto_trabajo() + "\" id=\"denpuesto\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getCentro() + "\" id=\"cenemp\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getPuesto_trabajo_responsable_medidas_mantenimiento() + "\" id=\"puesto\"/> ");
                        out.println("<input type=\"text\" value=\"" + con.DateFormat(avi.getFecha_aviso()) + "\" id=\"fecha\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getHora_aviso() + "\" id=\"hora\"/> ");
                        out.println("<input type=\"text\" value=\"" + avi.getTexto_breve() + "\" id=\"texto\"/> ");
                       }
                    }
                    break;
                case "CargarTexto":
                     if (AVISOSAM.equals("") || AVISOSAM == null) {
                        
                        LinkedList<areatexto> avisoso = ACC_Aviso.ObtenerInstancia().ConsultaArea(AVISOSAP,AVISOSAM);
                        for (int i = 0; i < avisoso.size(); i++) {
                            out.println(avisoso.get(i).getTexto_accion());
                        }
                     }
                     else if (AVISOSAP.equals("") || AVISOSAP == null) {
                        LinkedList<texto_avisos_crea> tea = ACC_Texto_avisos_crea.ObtenerInstancia().ConsulText(AVISOSAM);

                           for(int l = 0; l < tea.size(); l++){

                               out.println(tea.get(l).getLinea_texto());
                           }
                     }
                    break;
                case "CargarActividad":
                    int i;
                    
                    LinkedList<actividadesavisos> acavi = ACC_Aviso.ObtenerInstancia().ConsultaActividades(AVISOSAP,AVISOSAM);
                    if (acavi.size() > 0) {
                        for (i = 0; i < acavi.size(); i++) {
                            out.println("<tr>");
                            out.println("<td></td>");
                            out.println("<td>" + acavi.get(i).getPosicion() + "</td>");
                            out.println("<td>" + acavi.get(i).getGrupo_codigo() + "</td>");
                            out.println("<td>" + acavi.get(i).getCodigo_medida() + "</td>");
                            out.println("<td>" + acavi.get(i).getTexto_codigo() + "</td>");
                            out.println("<td>" + acavi.get(i).getTexto_accion() + "</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>" + acavi.get(i).getFactor_cantidad() + "</td>");
                            out.println("<td>" + con.DateFormat(acavi.get(i).getFecha_inicio()) + "</td>");
                            out.println("<td>" + acavi.get(i).getHora_inicio() + "</td>");
                            out.println("<td>" + con.DateFormat(acavi.get(i).getFecha_fin()) + "</td>");
                            out.println("<td>" + acavi.get(i).getHora_fin() + "</td>");
                            out.println("<td>" + acavi.get(i).getNum_actividad() + "</td>");
                            out.println("</tr>");
                        }
                        for (int k = i; k < 5; k++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                    } else {
                        out.println(0);
                    }

                    break;
                case "Documentos":
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td><b> Clase </b></td>");
                    out.println("<td><b> Documento </b></td>");
                    out.println("<td><b> UVL </b></td>");
                    out.println("<td><b> Ult.V </b></td>");
                    out.println("<td><b> Liberados Parc. </b></td>");
                    out.println("<td><b> Vs </b></td>");
                    out.println("<td><b> Descripción </b></td>");
                    out.println("</tr>");
                    out.println("</table>");
                    break;
                    case "MostrarAvisos":
                    String campo = "texto_breve_codigo_"+Languaj;
                    LinkedList<qmm_avisos_crea> taa = ACC_Qmm_avisos_crea.ObtenerInstancia().ObtenerDatPATab(AVISOSAM, campo);
                    
                    for(int j = 0; j < taa.size(); j++){
               out.println("<tr><td></td><td><input type=\"text\" id=\"Tpos"+j+"\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\"\" disabled /></td>"
                             + "<td><input type=\"text\" id=\"grco"+j+"\" onclick='OculButt("+j+")' style=\"width: 72%;  background-color: #F2F2F2; border-width:0;\" value=\""+taa.get(j).getGrupo_codigo_acciones()+" readonly \"><button id='matmat1"+j+"' class='BtnMatchIcon2' style='margin-left:1px; display:none;' onclick='mostrarOPe("+j+")' ></button></td>"
                             + "<td><input type=\"text\" id=\"deco"+j+"\" style=\"width: 100%; border-width:0;\" value=\""+taa.get(j).getCodigo_actividad()+"\" disabled /></td>"
                             + "<td><input type=\"text\" id=\"teco"+j+"\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\""+taa.get(j).getTexto_breve_codigo()+"\" disabled /></td>"
                             + "<td><input type=\"text\" id=\"teac"+j+"\" style=\"width: 100%; border-width:0;\" value=\""+taa.get(j).getTexto_accion()+"\" disabled /></td><td></td>"
                             + "<td><input type=\"text\" id=\"FCan"+j+"\" class=\"numFac\" style=\"width: 100%; border-width:0;\" onkeypress='numeroTecla()' value=\""+taa.get(j).getFactor_cantidad_acciones()+"\" disabled /></td>"
                             + "<td><input type=\"date\" id=\"theDate"+j+"\" style=\"width: 100%; border-width:0;\" value=\""+taa.get(j).getFecha_inicio()+"\" disabled /> </td>"
                             + "<td><input type=\"text\" style=\"width: 80%;border-width:0;\" onclick=\"OculBTi("+j+")\" id=\"Time"+j+"\" value=\""+taa.get(j).getHora_inicio_accion()+"\" disabled /><button id='matmat"+j+"' onclick=\"TiemBoton('Time"+j+"')\" class='BtnMatchIcon2' style='margin-left:1px; display: none;'></button></td>"
                             + "<td><input type=\"date\" id=\"theDate1"+j+"\" style=\"width: 100%; border-width:0;\" value=\""+taa.get(j).getFecha_fin()+"\" disabled /></td>"
                             + "<td><input type=\"text\" style=\"width: 80%; border-width:0;\" onclick=\"OculBTi2("+j+")\" id=\"Time1"+j+"\" value=\""+taa.get(j).getHora_fin_accion()+"\" disabled /><button id='matma1"+j+"' onclick=\"TiemBoton('Time1"+j+"')\" class='BtnMatchIcon2' style='margin-left:1px; display: none;'></button></td>"
                             + "<td><input type=\"text\" id=\"TposAC"+j+"\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\""+taa.get(j).getNum_claseificacion_actividad()+"\" disabled /></td></tr>");
                    }
                    int tamFota =taa.size();
                    
                    for(int o = 4; o >= tamFota ; o--){
                   out.println("<tr><td></td><td><input type=\"text\" id=\"Tpos"+o+"\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\"\" readonly></td>"
                             + "<td><input type=\"text\" id=\"grco"+o+"\" onclick='OculButt("+o+")' style=\"width: 72%; background-color: #F2F2F2; border-width:0;\" value=\"\" readonly /><button id='matmat1"+o+"' class='BtnMatchIcon2' style='margin-left:-5px; display:none;' onclick='mostrarOPe("+o+")' ></button></td>"
                             + "<td><input type=\"text\" id=\"deco"+o+"\" style=\"width: 100%; border-width:0;\" value=\"\" disabled></td>"
                           + "  <td><input type=\"text\" id=\"teco"+o+"\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\"\" disabled></td>"
                             + "<td><input type=\"text\" id=\"teac"+o+"\" style=\"width: 100%; border-width:0;\" value=\"\"disabled ></td><td></td>"
                           + "  <td><input type=\"text\" id=\"FCan"+o+"\" class=\"numFac\" style=\"width: 100%; border-width:0;\" onkeypress='numeroTecla(this)' value=\"\" disabled></td>"
                             + "<td><input type=\"date\" id=\"theDate"+o+"\" style=\"width: 100%; border-width:0;\" value=\"\" disabled></td>"
                           + "  <td><input type=\"text\" style=\"width: 80%;border-width:0;\" onclick=\"OculBTi("+o+")\" id=\"Time"+o+"\" disabled /><button id='matmat"+o+"' onclick=\"TiemBoton('Time"+o+"')\" class='BtnMatchIcon2' style='margin-left:1px; display: none;'></button></td>"
                             + "<td><input type=\"date\" id=\"theDate1"+o+"\" style=\"width: 100%; border-width:0;\" value=\"\"disabled></td>"
                           + "  <td><input type=\"text\" style=\"width: 80%; border-width:0;\" onclick=\"OculBTi2("+o+")\" id=\"Time1"+o+"\" disabled /><button id='matma1"+o+"' onclick=\"TiemBoton('Time1"+o+"')\" class='BtnMatchIcon2' style='margin-left:1px; display: none;'></button></td>"
                             + "<td><input type=\"text\" id=\"TposAC"+o+"\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\"0\" disabled ></td></tr>");
                    }
                    out.println("<tr style=\"visibility: hidden;\" ><td></td><td><input type=\"text\"  style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" id=\"grco5\" value=\"\" readonly></td><td><input type=\"text\"style=\"width: 72%; border-width:0;\" value=\"\"></td><td><input type=\"text\"  style=\"width: 100%; border-width:0;\" value=\"\"></td><td><input type=\"text\"  style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\"\" readonly></td><td><input type=\"text\" style=\"width: 100%; border-width:0;\" value=\"\"></td><td></td><td><input type=\"text\" style=\"width: 100%; border-width:0;\" value=\"\"></td><td><input type=\"date\" style=\"width: 100%;background-color: #F2F2F2; border-width:0;\" value=\"\"></td><td><input type=\"time\" style=\"width: 70%;border-width:0;\" disabled></td><td><input type=\"date\" style=\"width: 100%;background-color: #F2F2F2; border-width:0;\" value=\"\"></td><td><input type=\"time\" style=\"width: 100%;background-color: #F2F2F2; border-width:0;\" ></td><td><input type=\"text\" style=\"width: 100%; background-color: #F2F2F2; border-width:0;\" value=\"0\" readonly></td></tr>");
                break;
                default:
                    out.println(1);
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
