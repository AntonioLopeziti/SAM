/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_PedidoServicios;
import AccesoDatos.ACC_PedidosDetalle;
import AccesoDatos.Consultas;
import Entidades.entrada_servicios_crea;
import Entidades.folios;
import Entidades.pedido_servicios;
import Entidades.pedido_detalle;
import Entidades.pedido_historial;
import Entidades.textos_entrada_servicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "PeticionPedidoServicio", urlPatterns = {"/PeticionPedidoServicio"})
public class PeticionPedidoServicio extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("Action");
            String doccom = request.getParameter("DocCom");
            String fecDoc = request.getParameter("FechaDoc");
            String Ctd = request.getParameter("Ctd");
            String posici = request.getParameter("PosItem");
            String linea = request.getParameter("linea");
            String posicion = request.getParameter("Posicion");
            String noservicio = request.getParameter("NoServicio");
            String cantetrar = request.getParameter("CantEntrar");
            String ums = request.getParameter("UMS");
            String desservicio = request.getParameter("DesServicio");
            String cantentregada = request.getParameter("CantEntregada");
            String preciouni = request.getParameter("PrecioUni");
            String Centro = request.getParameter("Centro");
            String CanS = request.getParameter("CS");
            String num = request.getParameter("Num");
            String refpse = request.getParameter("refpsee");
            String tedcpse = request.getParameter("tedcpsee");
            String texbrpse = request.getParameter("texbrpsee");
            String usu = request.getParameter("usu");
            String calidad = request.getParameter("Calidad");
            String plazos = request.getParameter("Plazos");

            switch (accion) {
                case "VerificarFolio":
                    folios f = ACC_Folios.ObtenerIstancia().ObtenerFolioExcedido("EN");
                    int folf = f.getFolioFinal();
                    int folA = f.getFolioActual();
                    if (folA > folf) {
                        out.println(1);
                    }
                    break;
                case "ConsultaMatchPedidoMM":
                    if (Ctd.length() == 0) {
                        Ctd = "0";
                    }
                    ArrayList<pedido_detalle> pe = ACC_PedidosDetalle.ObtenerInstancia().ConsultaMCPedidos(doccom, fecDoc, Integer.parseInt(Ctd));
                    if (pe.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pe.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pe.get(i).getNum_doc_compras() + "|" + pe.get(i).getCentro() + "')\">");
                            out.println("<td>" + pe.get(i).getFecha_entrega_posicion() + "</td>");
                            out.println("<td>" + pe.get(i).getNum_doc_compras() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidaPedidoMM":
                    if (posici.length() == 0) {
                        posici = "0";
                    }
                    ACC_PedidosDetalle pedi = new ACC_PedidosDetalle();
                    if (pedi.ValidarDocumentoPed(doccom, Integer.parseInt(posici))) {
                        if (pedi.ChecKlib(doccom)) {
                            ArrayList<pedido_servicios> pse = ACC_PedidoServicios.ObtenerInstancia().CargarTablaServicios(doccom, Integer.parseInt(posici));
                            if (pse.size() > 0) {
                                out.println("<table id=\"TabBody\">");
                                out.println("<tbody>");
                                for (int i = 0; i < pse.size(); i++) {
                                    out.println("<tr>");
                                    out.println("<td><input type=\"radio\"  name=\"checkbo\" value=\"" + i + "\"/> <label style=\"display:none;\" id=\"etId" + i + "\">" + pse.get(i).getId_ps() + "</label> </td>");
                                    out.println("<td id=\"etPosicion" + i + "\">" + Integer.parseInt(pse.get(i).getNum_posicion_doc_compras()) + "</td>");
                                    out.println("<td  id=\"etnumlinea" + i + "\">" + Integer.parseInt(pse.get(i).getNum_linea()) + "</td>");
                                    out.println("<td id=\"etServicio" + i + "\">" + pse.get(i).getNum_servicio() + "</td>");
                                    out.println("<td> <input type=\"text\" maxlength=\"7\" onfocus=\"numericdata('txtCantidad" + i + "');\" style=\"width:100%; border:none;\" id=\"txtCantidad" + i + "\" /> </td>");
                                    out.println("<td id=\"etUnidadMedida" + i + "\">" + pse.get(i).getUnidad_medida_base() + "</td>");
                                    out.println("<td> <input type=\"text\" maxlength=\"40\" style=\"width:100%; border:none; \" id=\"txtDescripcion" + i + "\" value=\"" + pse.get(i).getTexto_breve() + "\" disabled/> </td>");
                                    out.println("<td id=\"etCantSolicitada" + i + "\">" + pse.get(i).getCantidad_con_signo() + " </td>");
                                    out.println("<td id=\"etCantEntregada" + i + "\">" + pse.get(i).getPedido_cantidad_entrada() + " </td>");
                                    out.println("<td id=\"etPrecioUni" + i + "\">" + pse.get(i).getPrecio_bruto() + " </td>");
                                    out.println("<td  class=\"ocultar\"> <input type=\"text\" maxlength=\"5\" onfocus=\"numericdata('txtPrecioPor" + i + "');\" style=\" width:30px; border:none; \" id=\"txtPrecioPor" + i + "\" value=\"1\" /> </td>");
                                    out.println("</tr>");
                                }
                                for (int j = 0; j < 17; j++) {
                                    out.println(""
                                            + "<tr>"
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
                                            + "</tr>");
                                }
                                out.println(" <tr class=\"ocultar\">\n"
                                        + "                                        <td>0000</td>\n"
                                        + "                                        <td>000000000000</td>\n"
                                        + "                                        <td>000000000000</td>\n"
                                        + "                                        <td>000000000000000000000</td>\n"
                                        + "                                        <td>00000000000000000000</td>\n"
                                        + "                                        <td>00000000000</td>\n"
                                        + "                                        <td>00000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                        + "                                        <td>000000000000000000</td>\n"
                                        + "                                        <td>000000000000000000</td>\n"
                                        + "                                        <td>000000000000000</td>\n"
                                        + "                                        </tr>");
                                out.println("</tbody>");
                                out.println("</table>");
                            } else {
                                out.println("<table id=\"TabBody\">");
                                out.println("<tbody>");
                                for (int k = 0; k < 17; k++) {
                                    out.println(""
                                            + "<tr>"
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
                                            + "</tr>");
                                }
                                out.println(" <tr class=\"ocultar\">\n"
                                        + "                                        <td>0000</td>\n"
                                        + "                                        <td>000000000000</td>\n"
                                        + "                                        <td>000000000000</td>\n"
                                        + "                                        <td>000000000000000000000</td>\n"
                                        + "                                        <td>00000000000000000000</td>\n"
                                        + "                                        <td>00000000000</td>\n"
                                        + "                                        <td>00000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                                        + "                                        <td>000000000000000000</td>\n"
                                        + "                                        <td>000000000000000000</td>\n"
                                        + "                                        <td>000000000000000</td>\n"
                                        + "                                        </tr>");
                                out.println("</tbody>");
                                out.println("</table>");

                            }
                        } else {
                            out.println(2);
                        }
                    } else {
                        out.println(1);
                    }
                    break;
                case "InsertarPedidoServicio":
                    folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("EN");
                    String folioSAM = fo.getIdFolios() + fo.getFolioActual();
                    String fecha = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String hora = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                    entrada_servicios_crea en = new entrada_servicios_crea();
                    en.setFolio_sam(folioSAM);
                    en.setNum_doc_compras(doccom);
                    en.setNum_posicion_doc_compras(posicion);
                    en.setIndice_registro_no_valido(1);
                    en.setCentro(Centro);
                    en.setNum_servicio(noservicio);
                    en.setCantidad(cantetrar + ".000");
                    en.setTexto_breve(desservicio);
                    en.setPrecio_bruto(preciouni);
                    en.setCantidad_base("1");
                    en.setFecha(fecha);
                    en.setHora_dia(hora);
                    en.setPosicion_servicio(linea);
                    en.setTexto_documento(tedcpse);
                    en.setTexto_referencia(refpse);
                    en.setUsuario(usu);
                    en.setNota_calidad_prestacion(calidad);
                    en.setNota_cumplim_prestacion(plazos);
                    
                    String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String FContable = Consultas.ObtenerInstancia().ObtenerFechaContableMov();
                    String Fch = FContable.equals("") ? fechaActual : FContable;
                    
                    pedido_historial ph = new pedido_historial();
                    ph.setNum_doc_compras(doccom);
                    ph.setNum_posicion_doc_compras(posicion);
                    ph.setTexto_breve(desservicio);
                    ph.setCantidad_pedido(CanS);
                    ph.setUnidad_medida_base(ums);
                    ph.setNum_doc_material(folioSAM);
                    ph.setCantidad(cantetrar + ".000");
                    ph.setUnidad_medida_base2(ums);
                    ph.setFecha_entrega_posicion(fecha);
                    ph.setFecha_contabilizacion_doc(Fch);
                    ph.setFolio_sam(folioSAM);
                    String pos1 = checkpos(Integer.parseInt(posicion));
                    if (ACC_PedidoServicios.ObtenerInstancia().InsertarEntradaServicio(en)) {
                        if (ACC_PedidoServicios.ObtenerInstancia().ActualizarCantidadPedidoSer(doccom, posicion, linea, noservicio, cantentregada + ".000")) {
                            if (ACC_PedidoServicios.ObtenerInstancia().InsertResgitroPedidoHistorial(ph, pos1)) {
                                out.println(4);
                            } else {
                                out.println(3); //// Error al insertar registro en pedido Historial
                            }
                        } else {
                            out.println(2); // Error al Actualizar la cantidad del pedido
                        }
                    } else {
                        out.println(1); /// Error al insertar
                    }
                    break;
                case "CleanTable":
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (int j = 0; j < 20; j++) {
                        out.println(""
                                + "<tr>"
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
                                + "</tr>");
                    }
                    out.println(" <tr class=\"ocultar\">\n"
                            + "                                        <td>0000</td>\n"
                            + "                                        <td>000000000000</td>\n"
                            + "                                        <td>000000000000</td>\n"
                            + "                                        <td>000000000000000000000</td>\n"
                            + "                                        <td>00000000000000000000</td>\n"
                            + "                                        <td>00000000000</td>\n"
                            + "                                        <td>00000000000000000000000000000000000000000000000000000000000000000000000000000</td>\n"
                            + "                                        <td>000000000000000000</td>\n"
                            + "                                        <td>000000000000000000</td>\n"
                            + "                                        <td>000000000000000</td>\n"
                            + "                                        </tr>");
                    out.println("</tbody>");
                    out.println("</table>");

                    break;
                case "GuardaTEXTos":
                    folios fol = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("EN");
                    String folSAM = fol.getIdFolios() + fol.getFolioActual();
                    String foli = request.getParameter("foliD");
                    String fila = request.getParameter("fila");
                    String lineas = request.getParameter("lineas");
                    textos_entrada_servicios tes = new textos_entrada_servicios();
                    tes.setFolio_sam(folSAM);
                    tes.setContador_posicion(foli);
                    tes.setFormato(fila);
                    tes.setTexto(lineas);
                    if (ACC_PedidoServicios.ObtenerInstancia().InsertartextEntradaServicio(tes)) {
                        out.println(folSAM);
                    } else {
                        out.println(0);
                    }
                    break;
                case "confole":
                    folios fole = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("EN");
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("EN", fole.getFolioActual());
                    out.println(fole.getIdFolios() + fole.getFolioActual());
                    break;

            }

        }
    }
      public String checkpos(int data) {
        String i = String.valueOf(data);
        if (data < 10) {
            i = "000" + data + "0";
        }
        if (data >= 10 && data < 100) {
            i = "000" + data;
        }
        if (data >= 100 && data < 1000) {
            i = "00" + data;
        }
        if (data >= 1000 && data < 10000) {
            i =  "0"  + data;
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PeticionPedidoServicio.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PeticionPedidoServicio.class.getName()).log(Level.SEVERE, null, ex);
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
