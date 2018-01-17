/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reservas;
import AccesoDatos.Consultas;
import Entidades.reserva_cabecera_crea;
import Entidades.reserva_posiciones_crea;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ModificarReservas", urlPatterns = {"/ModificarReservas"})
public class ModificarReservas extends HttpServlet {

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
            /*Variablea Case*/
            String accion = request.getParameter("Action");
            String query = "";
            /*--------------*/
 /*variables Consultas*/
            String sam = request.getParameter("sam");
            /*-------------------*/
 /*Variables de la tabla*/
            String id = request.getParameter("Id");
            String cantidad = request.getParameter("cantidad");
            String check = request.getParameter("remover");
            /*---------------------*/
            //DATOS
            String cen1 = request.getParameter("Cen1");
            String alm1 = request.getParameter("Alm1");
            String mov1 = request.getParameter("Mov1");
            String cencos1 = request.getParameter("CenCos1");
            String ord1 = request.getParameter("Ord1");
            String almdes1 = request.getParameter("AlmDes1");
            String posi1 = request.getParameter("Posi1");
            String mate1 = request.getParameter("Mate1");
            String uni1 = request.getParameter("UniMed");
            String des1 = request.getParameter("Des");
            switch (accion) {
                case "ConsultaFolioSAM":
                    String FolSAm = request.getParameter("FolSAm");
                    String FecSAm = request.getParameter("FecSAm");
                    String numAcMaxFS = request.getParameter("numAcMaxFS");
                    LinkedList<reserva_cabecera_crea> a = ACC_Reservas.ObtenerInstancia().MMReservaCabeceraCreaMatchFolioSam(numAcMaxFS, FolSAm, FecSAm);
                    if (a.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < a.size(); i++) {
                            out.println("<tr ondblclick=\"seleccionar('" + a.get(i).getFolio_sam() + "', 'sam')\">");
                            out.println("<td>" + a.get(i).getFolio_sam() + "</td>");
                            out.println("<td>" + a.get(i).getFecha() + "</td>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaCargarDatos":
                    reserva_cabecera_crea reserva = ACC_Reservas.ObtenerInstancia().MMConsultaAllDatosReservaCabecera(sam);
                    JSONArray jr = new JSONArray();
                    jr.add(reserva.getId_rc());
                    jr.add(reserva.getFolio_sam());
                    jr.add(reserva.getFolio_sap());
                    jr.add(reserva.getFecha());
                    jr.add(reserva.getHora_dia());
                    jr.add(reserva.getCentro());
                    jr.add(reserva.getClase_movimiento());
                    jr.add(reserva.getAlmacen());
                    jr.add(reserva.getCentro_coste());
                    jr.add(reserva.getNum_orden());
                    jr.add(reserva.getRecibido());
                    jr.add(reserva.getProcesado());
                    jr.add(reserva.getError());
                    jr.add(reserva.getAlmacen_destino());
                    out.println(jr);
                    break;
                case "ValidarSAM":
                    boolean valor = ACC_Reservas.ObtenerInstancia().MMValidarFolioSamCabecera(sam);
                    if (valor == true) {
                        reserva_cabecera_crea rscc = ACC_Reservas.ObtenerInstancia().MMConsultaDatosReservasCabecera(sam);
                        JSONArray js = new JSONArray();
                        js.add(rscc.getError());
                        js.add(rscc.getRecibido());
                        js.add(rscc.getProcesado());
                        js.add(rscc.getUsuario());
                        out.println(js);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaCargarDatosTabla":
                    LinkedList<reserva_posiciones_crea> b = ACC_Reservas.ObtenerInstancia().MMObtieneDatosTablaPosiciones(sam);
                    if (b.size() > 0) {
                        for (int i = 0; i < b.size(); i++) {
                            out.println("<tr>");
                            out.println("<td> <input type=\"checkbox\" style=\"size: 100%;\" name=\"remover\" value=\"0\" id=\"eliminar\"/> </td>");
                            out.println("<td> <input disabled type=\"text\" name=\"material\" id=\"material" + i + " \" value=\"" + b.get(i).getNum_material() + "\" /> </td>");
                            out.println("<td> <input  type=\"text\" min=\"1\" name=\"cantidad\" id=\"cantidad" + i + "\" value=\"" + b.get(i).getCantidad_necesaria() + "\" onblur=\" this.value = checkDec(this.value, 3);\" onfocus=\"PermitWord('" + i + "') \"   onKeyUp=\"this.value = check99(this.value, 999999, 7,'" + i + "')\" disabled /> </td>");
                            out.println("<td> <input disabled type=\"text\" name=\"unidadmedida\" id=\"unidadmedida" + i + "\" value=\"" + b.get(i).getUnidad_medida_base() + "\"/> </td>");
                            out.println("<td style=\"width: 40%;\"> <input disabled type=\"text\" name=\"descripcion\" id=\"descripcion\" " + i + "\" value=\"" + b.get(i).getTexto_posicion() + "\" style=\"width: 100%; text-transform: uppercase;\"/></td>");
                            out.println("<td> <label style=\"display:none;\" id=\"Id" + i + "\">" + b.get(i).getId_rpc() + "</label> </td>");
                            out.println("<tr>");
                        }
                        for (int j = 0; j < 5; j++) {
                            out.println(""
                                    + "<tr class=\"prueba79\">"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        //out.println("</tbody>");
                    } else {
                        out.println("<tbody>");
                        for (int k = 0; k < 5; k++) {
                            out.println(""
                                    + "<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>");
                        }
                        out.println("</tbody>");
                    }
                    break;
                case "ELiminarDato":
                    ACC_Reservas.ObtenerInstancia().MMUpdatePosicionesCabeceraReservasCrea(sam);
                    break;
                case "UpdatePosiciones":
                    ACC_Reservas.ObtenerInstancia().MMInsertarReservaPosicionesCrea(sam, posi1, mate1, cen1, alm1, cantidad, uni1, cencos1, ord1, mov1, des1, almdes1, check);
                    break;
                case "UpdateCabecera":
                    String fecha = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String hora = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                    ACC_Reservas.ObtenerInstancia().MMUPDATEReservasCabeceraCreaMod(sam, fecha, hora);
//MMInsertarReservasCabeceraCrea(sam, fecha, hora, cen1, mov1, alm1, cencos1, ord1, almdes1);
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
