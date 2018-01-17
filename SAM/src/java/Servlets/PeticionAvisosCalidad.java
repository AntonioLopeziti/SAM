/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_AvisosCalidad;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Usuarios;
import AccesoDatos.Consultas;
import Entidades.AvisosCalidad;
import Entidades.folios;
import Entidades.usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionAvisosCalidad", urlPatterns = {"/PeticionAvisosCalidad"})
public class PeticionAvisosCalidad extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Action = request.getParameter("Action");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");

            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("TQ");

            String fcActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            String FContable = Consultas.ObtenerInstancia().ObtenerFechaContableMov();

            String Fch = FContable.equals("") ? fcActual : FContable;
            String fl;

            switch (Action) {
                case "AvisosUsuario":
                    int i = 0;
                    ArrayList<AvisosCalidad> ac = ACC_AvisosCalidad.ObtenerInstancia().ConsultaAvisosUsr(v1);
                    out.println("<table id=\"TabBody\">\n"
                            + "<tbody>");
                    for (AvisosCalidad aa : ac) {
                        if (aa.getStatus_sistema_aviso().equals("MELI")) {
                            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
                            out.println("<tr ondblclick=\"AbrirVentanaTexto('" + i + "')\">");
                            try {
                                Date fechaActual = new Date();
                                String fechaSistema = fm.format(fechaActual);
                                Date fechaDate1 = fm.parse(fechaSistema);
                                Date fechaDate2 = fm.parse(aa.getFecha_inicio_prevista().replace("-", "/"));
                                Date fechaDate3 = fm.parse(aa.getFecha_fin_planif().replace("-", "/"));
                                if (fechaDate1.before(fechaDate2)) {
                                    out.println("<td><img src='images/@08QStatus@.PNG' /></td>");
                                } else if (fechaDate2.before(fechaDate1) && fechaDate1.before(fechaDate3)) {
                                    out.println("<td><img src='images/@09QStatus@.PNG' /></td>");
                                } else {
                                    out.println("<td><img src='images/@0AQStatus@.PNG' /></td>");
                                }
                            } catch (Exception e) {
                                System.out.println("Error: " + e);
                            }
                        } else {
                            out.println("<tr>"
                                    + "<td></td>");
                        }
                        Consultas c = new Consultas();
                        out.println(""
                                + "<td name=\"cld1\" >" + aa.getNum_aviso() + "</td>"
                                + "<td name=\"cld2\" >" + aa.getNum_correlativo_medida_mante() + "</td>"
                                + "<td name=\"cld3\" >" + aa.getNum_clasificacion_medida() + "</td>"
                                + "<td name=\"cld4\" >" + aa.getTexto_breve_medida_mante() + "</td>"
                                + "<td name=\"cld5\" >" + aa.getGrupo_codigos_medidas() + "</td>"
                                + "<td name=\"cld6\" >" + aa.getCodigo_medidas() + "</td>"
                                + "<td name=\"cld7\" >" + aa.getRol_responsable_medida() + "</td>"
                                + "<td name=\"cld8\" >" + aa.getResponsable_medida_num_interlocutor() + "</td>"
                                + "<td name=\"cld9\" >" + c.DateFormat(aa.getFecha_inicio_prevista()) + "</td>"
                                + "<td name=\"cld10\" >" + aa.getHora_prevista_inicio_medida() + "</td>"
                                + "<td name=\"cld11\" >" + c.DateFormat(aa.getFecha_fin_planif()) + "</td>"
                                + "<td name=\"cld12\" >" + aa.getHora_prevista_finalizacion_medida() + "</td>"
                                + "<td name=\"cld9n\" hidden>" + c.DateFormat(aa.getFecha_ultima_modificacion()) + "</td>"
                                + "<td name=\"cld10n\" hidden>" + aa.getHora_modificacion() + "</td>"
                                + "<td name=\"cld13\" >" + aa.getNum_posicion_registro_posicion() + "</td>");
                        i++;
                    }
                    for (int x = i; x < 23; x++) {
                        out.println("<tr>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "<td hidden>&nbsp;</td>"
                                + "<td hidden>&nbsp;</td>"
                                + "<td>&nbsp;</td>"
                                + "</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>000000000000000</td>"
                            + "<td>00000000000000000000000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>000000000000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td hidden>0000000000</td>"
                            + "<td hidden>0000000000</td>"
                            + "<td>0000000000000</td>"
                            + "</tr>"
                            + "</tbody>\n"
                            + "</table>");
                    break;
                case "getDataAvisoQM":
                    AvisosCalidad av = ACC_AvisosCalidad.ObtenerInstancia().getDataAvisoCalida(v1, v2, v3);
                    JSONArray js = new JSONArray();
                    js.add(av.getDescripcion_breve_grupo_codigos());
                    js.add(av.getTexto_breve_codigos_medidas());
                    js.add(av.getStatus_sistema_aviso());
                    out.println(js);
                    break;
                case "GetTxtQM":
                    String txt = ACC_AvisosCalidad.ObtenerInstancia().TextoAvisoQM(v1, v2, v3);
                    String tx2 = ACC_AvisosCalidad.ObtenerInstancia().TextoAvisoCreaQM(v1, v2, v3);
                    out.println(txt + " " + tx2);
                    break;
                case "cabeceraQM":
                    fl = "TQ" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().CabeceraTextosAvQM(fl, v1, v2, v3, v4, Fch, horaActual);
                    Consultas.ObtenerInstancia().UpdateFhAndHr(v1, v2, v5, v6, Fch, horaActual);
                    break;
                case "posicionesQM":
                    fl = "TQ" + fo.getFolioActual();
                    Consultas.ObtenerInstancia().PosicionesTextosAvQM(fl, v1, v2, v3, v4, v5, Fch, horaActual);
                    break;                    
                case "ActualizarFolio":
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("TQ", fo.getFolioActual());
                    out.println(fo.getFolioActual());
                    break;
                case "ActualizaStatus":
                    ACC_AvisosCalidad.ObtenerInstancia().ActualizaStatus(v1, v2, v3, v4);
                    break;
                case "ConsultaUsuario":
                    if(v3.length()==0){
                        v3 = "0";
                    }
                    ArrayList<usuarios> user = ACC_Usuarios.ObtenerInstancia().ListaUsuarioAvisosQM(v1, v2, Integer.parseInt(v3));
                    if (user.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int x = 0; x < user.size(); x++) {
                            out.println("<tr ondblclick=\"seleccionar('" + user.get(x).getUsuario() + "')\">");
                            out.println("<td>" + user.get(x).getUsuario() + "</td>");
                            out.println("<td>" + user.get(x).getNombre() + "</td>");
                            out.println("<td>" + user.get(x).getApellidoPat() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidaUsuario":
                    if(ACC_Usuarios.ObtenerInstancia().ValidarUsuario(v1)){
                        out.println(1);
                    }
                    break;
                default:
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
        } catch (ParseException ex) {
            Logger.getLogger(PeticionAvisosCalidad.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(PeticionAvisosCalidad.class.getName()).log(Level.SEVERE, null, ex);
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
