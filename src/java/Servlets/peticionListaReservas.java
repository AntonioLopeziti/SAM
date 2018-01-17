/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_ReporteReservas;
import AccesoDatos.Consultas;
import Entidades.centros;
import Entidades.reserva_cabecera_crea;
import Entidades.reservas_materiales;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "peticionListaReservas", urlPatterns = {"/peticionListaReservas"})
public class peticionListaReservas extends HttpServlet {

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
            String Acc = request.getParameter("Accion");
            String Res = request.getParameter("Reserva");
            String Sam = request.getParameter("Sam");
            String Clase = request.getParameter("Clase");
            String Sol = request.getParameter("Sol");
            String Mat = request.getParameter("Mat");
            ///////// PARAMETROS DE DATOS 
            String R1 = request.getParameter("R1");
            String R2 = request.getParameter("R2");
            String S1 = request.getParameter("S1");
            String S2 = request.getParameter("S2");
            String F1 = request.getParameter("F1");
            String F2 = request.getParameter("F2");
            String Cl = request.getParameter("Cl");
            String Sl = request.getParameter("Sl");
            String Mt = request.getParameter("Mat");
            String Ce = request.getParameter("Ce");
            Consultas con  = new Consultas();
            switch (Acc) {
                case "CargarCentros":
                    ArrayList<centros> cet = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    out.println("<select id=\"SelectCentros\">");
                    for (centros ce : cet) {
                        out.println("<option>" + ce.getCentro() + "</option>");
                    }
                    out.println("</select>");
                    break;
                case "CargarReservas":
                    ArrayList<reservas_materiales> re = ACC_ReporteReservas.ObtenerInstancia().SP_MatchReservaReportreservas2();
                    if (re.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < re.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + re.get(i).getNum_reservas() + "','reserva', 'VentanaModalReserva')\">");
                            out.println("<td>" + re.get(i).getNum_reservas() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarReservas2":
                    ArrayList<reservas_materiales> res = ACC_ReporteReservas.ObtenerInstancia().SP_MatchReservaReportreservas2();
                    if (res.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < res.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + res.get(i).getNum_reservas() + "','reserva2','VentanaModalReserva2')\">");
                            out.println("<td>" + res.get(i).getNum_reservas() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAM":
                    ArrayList<reservas_materiales> sam = ACC_ReporteReservas.ObtenerInstancia().SP_MatchReservaReportreservasSAM();
                    if (sam.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sam.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + sam.get(i).getNum_reservas() + "','Sam','VentanaModalSAM')\">");
                            out.println("<td>" + sam.get(i).getNum_reservas() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSAM2":
                    ArrayList<reservas_materiales> sam2 = ACC_ReporteReservas.ObtenerInstancia().SP_MatchReservaReportreservasSAM();
                    if (sam2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sam2.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + sam2.get(i).getNum_reservas() + "','Sam2','VentanaModalSAM2')\">");
                            out.println("<td>" + sam2.get(i).getNum_reservas() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarCMov":
                    ArrayList<reservas_materiales> clas = ACC_ReporteReservas.ObtenerInstancia().SP_MatchClaseReportreservas2();
                    if (clas.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < clas.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + clas.get(i).getClase_movimientos() + "','clase','VentanaModalClase')\">");
                            out.println("<td>" + clas.get(i).getClase_movimientos() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarSolicitante":
                    ArrayList<reserva_cabecera_crea> alma = ACC_ReporteReservas.ObtenerInstancia().SP_MatchSolicitanteReportreservas2();
                    if (alma.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < alma.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + alma.get(i).getUsuario() + "','solicitante','VentanaModalSolicitante')\">");
                            out.println("<td>" + alma.get(i).getUsuario() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarMaterial":
                    ArrayList<reservas_materiales> mat = ACC_ReporteReservas.ObtenerInstancia().SP_MatchMaterialReportreservas2();
                    if (mat.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mat.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + mat.get(i).getNum_material() + "','material','VentanaModalMaterial')\">");
                            out.println("<td>" + mat.get(i).getNum_material() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarReserva":
                    int r = ACC_ReporteReservas.ObtenerInstancia().ValidarReservaLista(Res);
                    out.println(r);
                    break;
                case "ValidarReservaSAM":
                    int s = ACC_ReporteReservas.ObtenerInstancia().ValidarReservaSAMLista(Sam);
                    out.println(s);
                    break;
                case "ValidarReservaClase":
                    int c = ACC_ReporteReservas.ObtenerInstancia().ValidarReservaClase(Clase);
                    out.println(c);
                    break;
                case "ValidarReservaSolicitante":
                    int u = ACC_ReporteReservas.ObtenerInstancia().ValidarReservaSolicitante(Sol);
                    out.println(u);
                    break;
                case "ValidarReservaMaterial":
                    int m = ACC_ReporteReservas.ObtenerInstancia().ValidarReservaMaterial(Mat);
                    out.println(m);
                    break;
                case "ValidarQuery":
                    String ff1 = con.DateFormatGuion(F1);
                    String ff2 = con.DateFormatGuion(F2);
                    String[] ar = {R1, R2, S1, S2, ff1, ff2, Cl, Sl, Mt, Ce};
                    int q = ACC_ReporteReservas.ObtenerInstancia().ValidarQuery(ar);
                    int qs = ACC_ReporteReservas.ObtenerInstancia().ValidarQueryS(ar);
                    int f = q + qs;
                    out.println(f);
                    break;
                case "CargarTabla":
                    String ff11= con.DateFormatGuion(F1);
                    String ff22 = con.DateFormatGuion(F2);
                    String[] myarray = {R1, R2, S1, S2, ff11, ff22, Cl, Sl, Mt,Ce};
                    ArrayList<reservas_materiales> sapdata = ACC_ReporteReservas.ObtenerInstancia().CargarTablaListaReserva(myarray);
                    ArrayList<reservas_materiales> samdata = ACC_ReporteReservas.ObtenerInstancia().CargarTablaListaReservaS(myarray);
                    ArrayList<reservas_materiales> rsf = new ArrayList<>();
                    sapdata.addAll(samdata);
                    rsf.addAll(sapdata);
                      Collections.sort(rsf, new Comparator<reservas_materiales>() {
                        public int compare(reservas_materiales o1, reservas_materiales o2) {
                            return o1.getFec_necesidad().compareTo(o2.getFec_necesidad());
                        }
                    });
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (reservas_materiales t1 : rsf) {
                        out.println("<tr>");
                        out.println("<td>" + t1.getNum_reservas() + "</td>");
                        out.println("<td>" + t1.getNum_posicion() + "</td>");
                        out.println("<td>" + t1.getFolio_sam() + "</td>");
                        out.println("<td>" + con.DateFormat(t1.getFec_necesidad()) + "</td>");
                        out.println("<td>" + t1.getClase_movimientos() + "</td>");
                        out.println("<td>" + t1.getCentro() + "</td>");
                        out.println("<td>" + t1.getAlmacen() + "</td>");
                        out.println("<td>" + t1.getNum_material() + "</td>");
                        out.println("<td>" + t1.getTexto_breve() + "</td>");
                        out.println("<td>" + t1.getCantidad_necesaria() + "</td>");
                        out.println("<td>" + t1.getUnidad_medida() + "</td>");
                        out.println("<td>" + t1.getCant_unidad_entrada() + "</td>");
                        out.println("<td>" + t1.getNum_orden() + "</td>");
                        out.println("<td>" + t1.getCentro_coste() + "</td>");
                        out.println("<td>" + t1.getAlmacen_receptor_emisor() + "</td>");
                        out.println("<td>" + t1.getUsuario() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>000000000000000</td>");
                    out.println("<td>0000000000</td>");
                    out.println("<td>0000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>00000000000000000000000000000000000000000</td>");
                    out.println("<td>00000000000000000</td>");
                    out.println("<td>0000000</td>");
                    out.println("<td>000000000000000000000000</td>");
                    out.println("<td>00000000000000000</td>");
                    out.println("<td>0000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("<td>0000000000000000</td>");
                    out.println("</tr>");
                    out.println("</table>");
                    out.println("</tbody>");
                    break;
            }
        }
    }
      public int compare(reservas_materiales o1, reservas_materiales o2) {
        return o1.getFec_necesidad().compareTo(o2.getFec_necesidad());
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
