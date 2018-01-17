///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Servlets;
//
//import AccesoDatos.ACC_EntradaServiciosCrea;
//import AccesoDatos.ACC_Folios;
//import AccesoDatos.ACC_PedidoServicios;
//import AccesoDatos.ACC_PedidosDetalle;
//import AccesoDatos.Consultas;
//import Entidades.entrada_servicios_crea;
//import Entidades.folios;
//import Entidades.pedido_servicios;
//import Entidades.pedido_detalle;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.LinkedList;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author AREConsulting
// */
//@WebServlet(name = "peticionPedidoServicioExterno", urlPatterns = {"/peticionPedidoServicioExterno"})
//public class peticionPedidoServicioExterno extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//
//            String accion = request.getParameter("acc");
//            String fecha = request.getParameter("FechaDoc");
//            String doccom = request.getParameter("DocCom");
//            String Poaici = request.getParameter("Posi");
//            String centro = request.getParameter("Centro");
//            String Ctd = request.getParameter("Ctd");
//
//            /*DATOS DE TABLA*/
//            String posicion = request.getParameter("Posicion");
//            String noservicio = request.getParameter("NoServicio");
//            String cantetrar = request.getParameter("CantEntrar");
//            String ums = request.getParameter("UMS");
//            String desservicio = request.getParameter("DesServicio");
//            String cantsolicitada = request.getParameter("CantSolicitada");
//            String cantentregada = request.getParameter("CantEntregada");
//            String preciouni = request.getParameter("PrecioUni");
//            String preciopor = request.getParameter("PrecioPor");
//
//            String fechaIn = request.getParameter("Fecha");
//            String horaIn = request.getParameter("Hora");
//
//            folios fo = ACC_Folios.ObtenerIstancia().ObtenerFolio("EN");
//            int fa = fo.getFolioActual() + 1;
//            String tabla = "folios";
//            String campo = "folio_actual = '" + fa + "'";
//            String condicion = "id_folio = 'EN'";
//            switch (accion) {
//                case "ConsultaMatchPedidoMM":
//                    int LimPedido = Integer.parseInt(Ctd);
//                    String queryMatchPedidoMM = "SELECT DISTINCT TOP " + LimPedido + " * FROM pedidos_detalle WHERE num_doc_compras LIKE '" + doccom + "%'";
//                    LinkedList<pedido_detalle> pe = ACC_PedidosDetalle.ObtenerInstancia().GetMatchPedidos(queryMatchPedidoMM);
//                    if (pe.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (int i = 0; i < pe.size(); i++) {
//                            out.println("<tr ondblclick=\"Select('" + pe.get(i).getNum_doc_compras() + "|" + pe.get(i).getCentro() + "', 'CePedidoMM')\">");
//                            out.println("<td>" + pe.get(i).getFecha_entrega_posicion() + "</td>");
//                            out.println("<td>" + pe.get(i).getNum_doc_compras() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//                    } else {
//                        out.println(0);
//                    }
//                    break;
//                case "ValidaPedidoMM":
//                    ACC_PedidosDetalle pedi = new ACC_PedidosDetalle();
//                    if (pedi.PedidoMM(doccom, Poaici) == true) {
//                        out.println(1);
//                    } else {
//                        out.println(0);
//                    }
//                    break;
//                case "GetDatosTablaPedidoServicios":
//                    String queryGetTabla = "SELECT * FROM pedido_servicios WHERE num_doc_compras = '" + doccom + "'";
//                    LinkedList<pedido_servicios> pse = ACC_PedidoServicios.ObtenerInstancia().CargarTablaServicios(queryGetTabla);
//                    double dat1 = Double.parseDouble(pse.get(0).getPedido_cantidad_entrada());
//                    double dat2 = Double.parseDouble(pse.get(1).getCantidad_con_signo());
//                    double result = dat1 - dat2;
//                    if (pse.size() > 0) {
//                        out.println("<tbody>");
//                        for (int i = 0; i < pse.size(); i++) {
//                            out.println("<tr>");
//                            out.println("<td> <label name=\"posicion\" id=\"etPosicion" + i + "\">" + pse.get(i).getNum_linea() + "</label> </td>");
//                            out.println("<td> <label name=\"servicio\" id=\"etServicio" + i + "\">" + pse.get(i).getNum_servicio() + "</label> </td>");
//                            out.println("<td> <input name=\"cantidad\" type=\"number\" style=\"width:200px; border:none;\" name=\"txtCantidad\" id=\"txtCantidad" + i + "\" value=\"" + pse.get(i).getPedido_cantidad_entrada() + "\"/> </td>");
//                            out.println("<td> <label name=\"um\" id=\"etUnidadMedida" + i + "\">" + pse.get(i).getUnidad_medida_base() + "</label> </td>");
//                            out.println("<td> <input name=\"des\" type=\"text\" style=\"width:200px; border:none; \" name=\"txtDescripcion\" id=\"txtDescripcion" + i + "\" value=\"" + pse.get(i).getTexto_breve() + "\"/> </td>");
//                            out.println("<td> <label name=\"cantidadsigno\" id=\"etCantSolicitada" + i + "\">" + pse.get(i).getCantidad_con_signo() + "</label> </td>");
//                            out.println("<td> <label name=\"entregada\" id=\"etCantEntregada" + i + "\">" + result + "</label> </td>");
//                            out.println("<td> <label name=\"precio\" id=\"etPrecioUni" + i + "\">" + pse.get(i).getPrecio_bruto() + "</label> </td>");
//                            out.println("<td> <input name=\"por\" type=\"number\" style=\" width:30px; border:none; \" id=\"txtPrecioPor" + i + "\" value=\"1\" /> </td>");
//                            out.println("<tr>");
//                        }
//                        for (int j = 0; j < 15; j++) {
//                            out.println(""
//                                    + "<tr>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "</tr>");
//                        }
//                        out.println("</tbody>");
//                    } else {
//                        out.println("<tbody>");
//                        for (int k = 0; k < 15; k++) {
//                            out.println(""
//                                    + "<tr>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>"
//                                    + "<td>&nbsp;</td>");
//                        }
//                        out.println("</tbody>");
//                    }
//                    break;
//                case "InsertarPedidoServicio":
//                    /*ACC_PedidosDetalle pd = new ACC_PedidosDetalle();
//                    if (pd.PedidoMM(doccom) == true) {
//                        out.println(1);*/
//
//                    String queryGuardar = "INSERT INTO entrada_servicios_crea (folio_sam, num_doc_compras, num_posicion_doc_compras, indice_registro_no_valido, centro, num_servicio, cantidad, texto_breve, precio_bruto, cantidad_base, fecha, hora_dia, folio_sap, recibido, procesado, error) VALUES ('EN" + fo.getFolioActual() + "', '" + doccom + "', '" + posicion + "', ' ', '', '" + noservicio + "', '" + cantetrar + "', '" + desservicio + "', '" + preciouni + "', 1, '" + fechaIn + "', '" + horaIn + "', '', '', '', '')";
//                    if (Consultas.ObtenerInstancia().Insert(queryGuardar) == true) {
//                        Consultas.ObtenerInstancia().Update(tabla, campo, condicion);
//                        folios f = ACC_Folios.ObtenerIstancia().ObtenerFolio("EN");
//                        int fs = f.getFolioActual() + 1;
//                        out.println(1);
//                    }
//                    /*if (ACC_EntradaServiciosCrea.ObtenerInstancia().InsertEntradaServiciosCrea(queryGuardar) == true) {
//                        if (Consultas.ObtenerInstancia().Update(tabla, campo, condicion) == true) {
//                            out.println(1);
//                        }
//                    } else {
//                        out.println(0);
//                    }*/
//                    break;
//                case "FolioActulizar":
//                    Consultas.ObtenerInstancia().Update(tabla, campo, condicion);
//                    out.println(1);
//                    break;
//            }
//        }
//    }
//
//// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
