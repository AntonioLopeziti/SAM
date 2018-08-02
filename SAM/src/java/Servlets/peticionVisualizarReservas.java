/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reservas;
import Entidades.reserva_cabecera_crea;
import Entidades.reserva_posiciones_crea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "peticionVisualizarReservas", urlPatterns = {"/peticionVisualizarReservas"})
public class peticionVisualizarReservas extends HttpServlet {

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
            String Accion = request.getParameter("Action");
            String Nreserva = request.getParameter("NReserva");
            String Cantidad = request.getParameter("Cantidad");
            String Usuario = request.getParameter("UsuarioReserva");
            String Tipo = request.getParameter("Tipo");
            switch (Accion) {
                case "ConsultarReserva":
                    ArrayList<reserva_cabecera_crea> re = ACC_Reservas.ObtenerInstancia().ConsultaMCReserva(Nreserva, Usuario);
                    if (re.size() > 0) {
                        if (IsNumeric(Cantidad)) {
                            int lim = Integer.parseInt(Cantidad);
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < lim; i++) {
                                out.println("<tr ondblclick=\"Seleccionar('" + re.get(i).getFolio_sap() + "', '" + re.get(i).getFolio_sam() + "');\">");
                                out.println("<td>" + re.get(i).getFolio_sap() + "</td>");
                                out.println("<td>" + re.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + re.get(i).getUsuario() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < re.size(); i++) {
                                out.println("<tr ondblclick=\"Seleccionar('" + re.get(i).getFolio_sap() + "', '" + re.get(i).getFolio_sam() + "');\">");
                                out.println("<td>" + re.get(i).getFolio_sap() + "</td>");
                                out.println("<td>" + re.get(i).getFolio_sam() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarReserva":
                    int SAP = ACC_Reservas.ObtenerInstancia().ValidarReservaSAP(Nreserva);
                    int SAM = ACC_Reservas.ObtenerInstancia().ValidarReservaSAM(Nreserva);
                    out.println(SAP + "," + SAM);
                    break;
                case "CargarCabecera":
                    JSONArray j = new JSONArray();
                    if (Tipo.equals("P")) {
                        reserva_posiciones_crea r = ACC_Reservas.ObtenerInstancia().CargarDatosCabSAP(Nreserva);
                        j.add(r.getCentro());
                        j.add(r.getAlmacen());
                        j.add(r.getClase_movimiento());
                        j.add(r.getCentro_coste());
                        j.add(r.getNum_orden());
                        j.add(r.getError());
                        j.add(r.getAlmacen_destino());
                        j.add(r.getFolio_sap());
                        j.add(r.getFolio_sam());
                    } else if (Tipo.equals("M")) {
                        reserva_posiciones_crea r = ACC_Reservas.ObtenerInstancia().CargarDatosCabSAM(Nreserva);
                        j.add(r.getCentro());
                        j.add(r.getAlmacen());
                        j.add(r.getClase_movimiento());
                        j.add(r.getCentro_coste());
                        j.add(r.getNum_orden());
                        j.add(r.getError());
                        j.add(r.getAlmacen_destino());
                        j.add(r.getFolio_sap());
                        j.add(r.getFolio_sam());
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
                    }
                    out.println(j);
                    break;
                case "CargarTablaReserva":
                    if (Tipo.equals("P")) {
                        int i;
                        ArrayList<reserva_posiciones_crea> r = ACC_Reservas.ObtenerInstancia().LoadTabResSAP(Nreserva);
                        if (r.size() > 0) {
                            out.println("<table id=\"TabBody\">");
                            out.println("<tbody>");
                            for (i = 0; i < r.size(); i++) {
                                out.println("<tr>");
                                out.println("<td></td>");
                                out.println("<td>" + r.get(i).getNum_material() + "</td>");
                                out.println("<td>" + r.get(i).getCantidad_necesaria() + "</td>");
                                out.println("<td>" + r.get(i).getUnidad_medida_base() + "</td>");
                                out.println("<td>" + r.get(i).getTexto_posicion() + "</td>");
                                out.println("</tr>");
                            }
                            for (int a = i; a < 16; a++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\">\n"
                                    + "                                            <td>00000</td>\n"
                                    + "                                            <td>000000000000000000000000000000000000</td>\n"
                                    + "                                            <td>0000000000000000000</td>\n"
                                    + "                                            <td>00000000000000000</td>\n"
                                    + "                                            <td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                    + "                                        </tr>");
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table id=\"TabBody\">");
                            out.println("<tbody>");
                            for (int l = 0; l < 15; l++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\">\n"
                                    + "                                            <td>00000</td>\n"
                                    + "                                            <td>000000000000000000000000000000000000</td>\n"
                                    + "                                            <td>0000000000000000000</td>\n"
                                    + "                                            <td>00000000000000000</td>\n"
                                    + "                                            <td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                    + "                                        </tr>");
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else if (Tipo.equals("M")) {
                        ArrayList<reserva_posiciones_crea> r = ACC_Reservas.ObtenerInstancia().LoadTabResSAM(Nreserva);
                        if (r.size() > 0) {
                            int x;
                            out.println("<table id=\"TabBody\">");
                            out.println("<tbody>");
                            for (x = 0; x < r.size(); x++) {
                                out.println("<tr>");
                                out.println("<td></td>");
                                out.println("<td>" + r.get(x).getNum_material() + "</td>");
                                out.println("<td>" + r.get(x).getCantidad_necesaria() + "</td>");
                                out.println("<td>" + r.get(x).getUnidad_medida_base() + "</td>");
                                out.println("<td>" + r.get(x).getTexto_posicion() + "</td>");
                                out.println("</tr>");
                            }
                            for (int b = x; b < 15; b++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\">\n"
                                    + "                                            <td>00000</td>\n"
                                    + "                                            <td>000000000000000000000000000000000000</td>\n"
                                    + "                                            <td>0000000000000000000</td>\n"
                                    + "                                            <td>00000000000000000</td>\n"
                                    + "                                            <td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                    + "                                        </tr>");
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table id=\"TabBody\">");
                            out.println("<tbody>");
                            for (int d = 0; d < 15; d++) {
                                out.println("<tr>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("<td>&nbsp;</td>");
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\">\n"
                                    + "                                            <td>00000</td>\n"
                                    + "                                            <td>000000000000000000000000000000000000</td>\n"
                                    + "                                            <td>0000000000000000000</td>\n"
                                    + "                                            <td>00000000000000000</td>\n"
                                    + "                                            <td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                    + "                                        </tr>");
                            out.println("</tbody>");
                            out.println("</table>");
                        }

                    } else {
                        out.println("<table id=\"TabBody\">");
                        out.println("<tbody>");
                        for (int i = 0; i < 15; i++) {
                            out.println("<tr>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("<td>&nbsp;</td>");
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\">\n"
                                + "                                            <td>00000</td>\n"
                                + "                                            <td>000000000000000000000000000000000000</td>\n"
                                + "                                            <td>0000000000000000000</td>\n"
                                + "                                            <td>00000000000000000</td>\n"
                                + "                                            <td>0000000000000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                + "                                        </tr>");
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                    break;
            }
        }
    }

    public boolean IsNumeric(String dato) {
        try {
            Integer.parseInt(dato);
            return true;
        } catch (NumberFormatException n) {
            return false;
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
