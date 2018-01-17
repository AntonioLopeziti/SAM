/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_RepSolicitudPedido;
import AccesoDatos.Consultas;
import Entidades.ReporteSolPed;
import Entidades.centros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "peticionListaSolped", urlPatterns = {"/peticionListaSolped"})
public class peticionListaSolped extends HttpServlet {

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
            HttpSession session = request.getSession();
            String lan = (String) session.getAttribute("Idioma");
            String Accion = request.getParameter("Action");
            String SAM = request.getParameter("SAM");
            String SAP = request.getParameter("SAP");
            String SOL = request.getParameter("SOL");
            String ALM = request.getParameter("ALM");
            String MAT = request.getParameter("MAT");
            String TPO = request.getParameter("TPO");
            String TIM = request.getParameter("TIM");
            //////// Parametros 
            String SM1 = request.getParameter("SM1");
            String SM2 = request.getParameter("SM2");
            String SP1 = request.getParameter("SP1");
            String SP2 = request.getParameter("SP2");
            String FC1 = request.getParameter("FC1");
            String FC2 = request.getParameter("FC2");
            String SLC = request.getParameter("SLC");
            String AMC = request.getParameter("AMC");
            String MTL = request.getParameter("MTL");
            String POS = request.getParameter("POS");
            String IMT = request.getParameter("IMT");
            String CEN = request.getParameter("CEN");
            Consultas con = new Consultas();
            switch (Accion) {
                case "CargarCentro":
                    ArrayList<centros> cet = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    out.println("<select id=\"centro\">");
                    for (centros ce : cet) {
                        out.println("<option>" + ce.getCentro() + "</option>");
                    }
                    out.println("</select>");
                    break;
                case "CargarSAM":
                    ArrayList<ReporteSolPed> MCSAM = ACC_RepSolicitudPedido.ObtenerInstancia().CargarSAMListaSolped();
                    if (MCSAM.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCSAM.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCSAM.get(i).getFolio_sam() + "','sam1')\">");
                            out.println("<td>" + MCSAM.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAM2":
                    ArrayList<ReporteSolPed> MCSAM2 = ACC_RepSolicitudPedido.ObtenerInstancia().CargarSAMListaSolped();
                    if (MCSAM2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCSAM2.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCSAM2.get(i).getFolio_sam() + "','sam2')\">");
                            out.println("<td>" + MCSAM2.get(i).getFolio_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAP":
                    ArrayList<ReporteSolPed> MCSAP = ACC_RepSolicitudPedido.ObtenerInstancia().CargarSAPListaSolped();
                    if (MCSAP.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCSAP.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCSAP.get(i).getFolio_sap() + "','sap1')\">");
                            out.println("<td>" + MCSAP.get(i).getFolio_sap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAP2":
                    ArrayList<ReporteSolPed> MCSAP2 = ACC_RepSolicitudPedido.ObtenerInstancia().CargarSAPListaSolped();
                    if (MCSAP2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCSAP2.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCSAP2.get(i).getFolio_sap() + "','sap2')\">");
                            out.println("<td>" + MCSAP2.get(i).getFolio_sap() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSolicitante":
                    ArrayList<ReporteSolPed> MCSOL = ACC_RepSolicitudPedido.ObtenerInstancia().CargarUsuarioListaSolped();
                    if (MCSOL.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCSOL.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCSOL.get(i).getUsuario() + "','solicitante')\">");
                            out.println("<td>" + MCSOL.get(i).getUsuario() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarAlmacen":
                    ArrayList<ReporteSolPed> MCAlm = ACC_RepSolicitudPedido.ObtenerInstancia().CargarAlmacenListaSolped();
                    if (MCAlm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCAlm.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCAlm.get(i).getAlmacen() + "','almacen')\">");
                            out.println("<td>" + MCAlm.get(i).getAlmacen() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarMaterial":
                    ArrayList<ReporteSolPed> MCMAT = ACC_RepSolicitudPedido.ObtenerInstancia().CargarMaterialListaSolped();
                    if (MCMAT.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCMAT.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCMAT.get(i).getMaterial() + "','material')\">");
                            out.println("<td>" + MCMAT.get(i).getMaterial() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarTPosicion":
                    ArrayList<ReporteSolPed> MCTPO = ACC_RepSolicitudPedido.ObtenerInstancia().CargarTipoPoscionListaSolped(lan);
                    if (MCTPO.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCTPO.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCTPO.get(i).getTipo_posicion_doc() + "','posicion')\">");
                            out.println("<td>" + MCTPO.get(i).getTipo_posicion_doc() + "</td>");
                            out.println("<td>" + MCTPO.get(i).getDesc_tipo_pos() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarTImputacion":
                    ArrayList<ReporteSolPed> MCTIM = ACC_RepSolicitudPedido.ObtenerInstancia().CargarTipoImputacionListaSolped(lan);
                    if (MCTIM.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < MCTIM.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + MCTIM.get(i).getTipo_imputacion() + "','imputacion')\">");
                            out.println("<td>" + MCTIM.get(i).getTipo_imputacion() + "</td>");
                            out.println("<td>" + MCTIM.get(i).getDesc_tipo_imp() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarSAM":
                    int s1 = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarSAMSolped(SAM);
                    out.println(s1);
                    break;
                case "ValidarSAP":
                    int sp = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarSAPSolped(SAP);
                    out.println(sp);
                    break;
                case "ValidarSolicitate":
                    int so = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarUsuarioSolped(SOL);
                    out.println(so);
                    break;
                case "ValidarAlmacen":
                    int al = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarAlmacenSolped(ALM);
                    out.println(al);
                    break;
                case "ValidarMaterial":
                    int mat = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarMaterialSolped(MAT);
                    out.println(mat);
                    break;
                case "ValidarTPos":
                    int tp = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarTipoPosSolped(TPO);
                    out.println(tp);
                    break;
                case "ValidarTIM":
                    int tim = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarTipoImpSolped(TIM);
                    out.println(tim);
                    break;
                case "ValidarQuery":
                    String ff1 = con.DateFormatGuion(FC1);
                    String ff2 = con.DateFormatGuion(FC2);
                    String[] Repo = {SP1, SP2, SM1, SM2, ff1, ff2, SLC, AMC, MTL, POS, IMT, CEN};
                    int rep = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarListaSolpedQuery(Repo);
                    int cre = ACC_RepSolicitudPedido.ObtenerInstancia().ValidarListaSolpedQueryS(Repo);
                    int nd = rep + cre;
                    out.println(nd);
                    break;
                case "CargarTabla":
                    String ff11 = con.DateFormatGuion(FC1);
                    String ff22 = con.DateFormatGuion(FC2);
                    String[] Repo1 = {SP1, SP2, SM1, SM2, ff11, ff22, SLC, AMC, MTL, POS, IMT, CEN};
                    ArrayList<ReporteSolPed> re1 = ACC_RepSolicitudPedido.ObtenerInstancia().CargarTablaRepo(Repo1);
                    ArrayList<ReporteSolPed> re2 = ACC_RepSolicitudPedido.ObtenerInstancia().CargarTablaSolpCrea(Repo1);
                    ArrayList<ReporteSolPed> ref = new ArrayList<>();
                    re1.addAll(re2);
                    ref.addAll(re1);
                     Collections.sort(ref, new Comparator<ReporteSolPed>() {
                        public int compare(ReporteSolPed o1, ReporteSolPed o2) {
                            return o1.getFecha().compareTo(o2.getFecha());
                        }
                    });
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (ReporteSolPed rs : ref) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getFolio_sam() + "</td>");
                        out.println("<td>" + rs.getNum_posicion_solped() + "</td>");
                        out.println("<td>" + rs.getFolio_sap() + "</td>");
                        out.println("<td>" + con.DateFormat(rs.getFecha()) + "</td>");
                        out.println("<td>" + rs.getTipo_posicion_doc() + "</td>");
                        out.println("<td>" + rs.getTipo_imputacion() + "</td>");
                        out.println("<td>" + rs.getMaterial() + "</td>");
                        out.println("<td>" + rs.getTexto_breve() + "</td>");
                        out.println("<td>" + rs.getCantidad_solped() + "</td>");
                        out.println("<td>" + rs.getUnidad_medida_solepd() + "</td>");
                        out.println("<td>" + rs.getCentro() + "</td>");
                        out.println("<td>" + rs.getAlmacen() + "</td>");
                        out.println("<td>" + rs.getUsuario() + "</td>");
                        out.println("<td>" + con.DateFormat(rs.getFecha_liberacion()) + "</td>");
                        out.println("<td>" + rs.getIndicador_liberacion() + "</td>");
                        out.println("<td>" + rs.getDenominacion_codigo_liberacion() + "</td>");
                        out.println("<td>" + rs.getProcesado() + "</td>");
                        out.println("<td>" + rs.getError() + "</td>");
                        out.println("<td>" + rs.getPedido() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>0000000000000</td>"
                            + "<td>000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>000000</td>"
                            + "<td>000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>0000000000000000000000000000000000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>00000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>0000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>00000000000000</td>"
                            + "<td>0000000</td>"
                            + "<td>000000000000000000000</td>"
                            + "<td>0000000</td>"
                            + "<td>0000000</td>"
                            + "<td>0000000000000</td>"
                            + "</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;

            }
        }
    }
          public int compare(ReporteSolPed o1, ReporteSolPed o2) {
        return o1.getFecha().compareTo(o2.getFecha());
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
