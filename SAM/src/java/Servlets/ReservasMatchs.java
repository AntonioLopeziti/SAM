/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_ReporteReservas;
import AccesoDatos.ACC_SolpedReporte;
import AccesoDatos.ACC_Solped_cabecera2;
import Entidades.solped_cabecera2;
import AccesoDatos.ACC_Solped_posiciones2;
import AccesoDatos.Conexion;
import Entidades.Listareservas;
import Entidades.Solped_posiciones;
import Entidades.ReporteSolPed;
import Entidades.centros;
import Entidades.reserva_cabecera_crea;
import Entidades.reserva_posiciones_crea;
import Entidades.reservas_materiales;
import Entidades.solped_cabecera;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ReservasMatchs", urlPatterns = {"/ReservasMatchs"})
public class ReservasMatchs extends HttpServlet {

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
            HttpSession session = request.getSession();
            String accion = request.getParameter("Action");
            String reserva = request.getParameter("reserva");
            String posicion = request.getParameter("posicion");
            String fecha1 = request.getParameter("fecha1");
            String reserva2 = request.getParameter("reserva2");
            String posicion2 = request.getParameter("posicion2");
            String fecha2 = request.getParameter("fecha2");
            String centro = request.getParameter("centro");
            String clase = request.getParameter("clase");
            String material = request.getParameter("material");
            String almacen = request.getParameter("almacen");
            //String usuario  = request.getParameter("usuario");
            String orden = request.getParameter("orden");
            String coste = request.getParameter("coste");

            session.setAttribute("reserva", reserva);
            session.setAttribute("posicion", posicion);
            session.setAttribute("fecha1", fecha1);
            session.setAttribute("reserva2", reserva2);
            session.setAttribute("posicion2", posicion2);
            session.setAttribute("fecha2", fecha2);
            session.setAttribute("centro", centro);
            session.setAttribute("clase", clase);
            session.setAttribute("material", material);
            session.setAttribute("almacen", almacen);
            //session.setAttribute("usuario",usuario);
            session.setAttribute("orden", orden);
            session.setAttribute("coste", coste);
            switch (accion) {
                case "centro":
                    ArrayList<centros> cet = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    if (cet.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cet.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + cet.get(i).getCentro() + "','centro')\">");
                            out.println("<td>" + cet.get(i).getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "reserva":
                    ArrayList<reservas_materiales> re = ACC_ReporteReservas.ObtenerInstancia().SP_MatchReservaReportreservas2();
                    if (re.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < re.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + re.get(i).getNum_reservas() + "','reserva')\">");
                            out.println("<td>" + re.get(i).getNum_reservas() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "reserva2":
                    ArrayList<reservas_materiales> r = ACC_ReporteReservas.ObtenerInstancia().SP_MatchReservaReportreservas2();
                    if (r.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < r.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + r.get(i).getNum_reservas() + "','reserva2')\">");
                            out.println("<td>" + r.get(i).getNum_reservas() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;

                case "posicion":
                    ArrayList<reservas_materiales> pos = ACC_ReporteReservas.ObtenerInstancia().SP_MatchPosicionReportreservas2();
                    if (pos.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pos.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pos.get(i).getNum_posicion() + "','posicion')\">");
                            out.println("<td>" + pos.get(i).getNum_posicion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "posicion2":
                    ArrayList<reservas_materiales> po = ACC_ReporteReservas.ObtenerInstancia().SP_MatchPosicionReportreservas2();
                    if (po.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < po.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + po.get(i).getNum_posicion() + "','posicion2')\">");
                            out.println("<td>" + po.get(i).getNum_posicion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "clase":
                    ArrayList<reservas_materiales> clas = ACC_ReporteReservas.ObtenerInstancia().SP_MatchClaseReportreservas2();
                    if (clas.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < clas.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + clas.get(i).getClase_movimientos() + "','clase')\">");
                            out.println("<td>" + clas.get(i).getClase_movimientos() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "material":
                    ArrayList<reservas_materiales> mat = ACC_ReporteReservas.ObtenerInstancia().SP_MatchMaterialReportreservas2();
                    if (mat.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mat.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + mat.get(i).getNum_material() + "','material')\">");
                            out.println("<td>" + mat.get(i).getNum_material() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "almacen":
                    ArrayList<reserva_cabecera_crea> alma = ACC_ReporteReservas.ObtenerInstancia().SP_MatchSolicitanteReportreservas2();
                    if (alma.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < alma.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + alma.get(i).getUsuario() + "','almacen')\">");
                            out.println("<td>" + alma.get(i).getUsuario() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "orden":
                    ArrayList<reservas_materiales> ord = ACC_ReporteReservas.ObtenerInstancia().SP_MatchTextoReportreservas2();
                    if (ord.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ord.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + ord.get(i).getTexto_posicion() + "','orden')\">");
                            out.println("<td>" + ord.get(i).getTexto_posicion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "coste":
                    ArrayList<reservas_materiales> cos = ACC_ReporteReservas.ObtenerInstancia().SP_MatchCosteReportreservas2();
                    if (cos.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cos.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + cos.get(i).getCentro_coste() + "','coste')\">");
                            out.println("<td>" + cos.get(i).getCentro_coste() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                    case "ValidarQuery":
                    ArrayList<reservas_materiales> materiales = ACC_ReporteReservas.ObtenerInstancia().MM_Listareservas_Materiales(reserva,reserva2,centro,fecha1,fecha2,clase,almacen,material,orden);
                    ArrayList<Listareservas> reservascrea = ACC_ReporteReservas.ObtenerInstancia().MM_Listareservas_Crea(centro,fecha1,fecha2,clase,almacen,material,orden);
                    if (materiales.size() > 0 || reservascrea.size() > 0){
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                default:
                    out.println("1");
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
