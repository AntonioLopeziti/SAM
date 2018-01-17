///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Servlets;
//
//import AccesoDatos.ACC_SolicitudPedidos;
//import AccesoDatos.ACC_Textos_cabecera_solped;
//import AccesoDatos.ACC_Textos_posiciones_solped;
//import Entidades.SolpedCrea;
//import Entidades.SolpedServicios;
//import Entidades.textos_cabecera_solped;
//import Entidades.textos_posiciones_solped;
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
// * @author Antonio
// */
//@WebServlet(name = "peticionVisualizarSolpedCrea", urlPatterns = {"/peticionVisualizarSolpedCrea"})
//public class peticionVisualizarSolpedCrea extends HttpServlet {
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
//            String Accion = request.getParameter("Accion");
//            String NumSAP = request.getParameter("NumSAP");
//            String NumSAM = request.getParameter("NumSAM");
//            String Posicion = request.getParameter("Posicion");
//            String NumeroSolped = request.getParameter("NumeroSolped");
//            String query = "SELECT * FROM solped_crea WHERE num_solped='" + NumeroSolped + "' OR folio_sam='" + NumeroSolped + "'";
//            switch (Accion) {
//                case "CargrSolp":
//                    int i;
//                    LinkedList<SolpedCrea> s = ACC_SolicitudPedidos.ObtenerInstancia().ConsultaSolped(query);
//                    if (s.size() > 0) {
//                        out.println("<tbody>");
//                        for (i = 0; i < s.size(); i++) {
//                            out.println("<tr>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>" + s.get(i).getNum_posicion_solped() + "</td>");
//                            out.println("<td>" + s.get(i).getTipo_imputacion() + "</td>");
//                            out.println("<td>" + s.get(i).getTipo_posicion_doc_compras() + "</td>");
//                            out.println("<td>" + s.get(i).getNum_material() + "</td>");
//                            out.println("<td>" + s.get(i).getTexto_breve() + "</td>");
//                            out.println("<td>" + s.get(i).getCantidad_solped() + "</td>");
//                            out.println("<td>" + s.get(i).getUnidad_medida_solped() + "</td>");
//                            out.println("<td>" + s.get(i).getPrecio_solped() + "</td>");
//                            out.println("<td>" + s.get(i).getClave_moneda() + "</td>");
//                            out.println("<td>" + s.get(i).getFecha_entraga_posicion() + "</td>");
//                            out.println("<td>" + s.get(i).getGrupo_articulos() + "</td>");
//                            out.println("<td>" + s.get(i).getCentro() + "</td>");
//                            out.println("<td>" + s.get(i).getAlmacen() + "</td>");
//                            out.println("<td>" + s.get(i).getSolicitante() + "</td>");
//                            out.println("<td>" + s.get(i).getOrganizacion_compras() + "</td>");
//                            out.println("<td>" + s.get(i).getGrupo_compras() + "</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("</tr>");
//                        }
//                        for (int j = i; j < 7; j++) {
//                            out.println("<tr>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("<tr>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">ADMON_PORTUARIA__/td>\n"
//                                + "                <td class=\"ocultar\">ADMON_PORTUARIA__INTEGRAL_DE_TOPO_S_Mas_Espacio</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">ADMON_PORTUARIA</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "                <td class=\"ocultar\">&nbsp;</td>\n"
//                                + "           </tr>");
//                        out.println("</tbody>");
//
//                    } else {
//                        for (int j = 0; j < 7; j++) {
//                            out.println("<tr>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("<td>&nbsp;</td>");
//                            out.println("</tr>");
//                        }
//                    }
//                    break;
//                case "CargarDatosCab":
//                    SolpedCrea vc = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerDatosSolped(query);
//                    LinkedList<textos_cabecera_solped> st = ACC_SolicitudPedidos.ObtenerInstancia().ObtenertxtoCabecera(NumeroSolped);
//                    String text = "";
//                    for (i = 0; i < st.size(); i++) {
//                        text += st.get(i).getLinea_texto();
//                    }
//                    out.println("<input type=\"text\" id=\"ClaseDoc1\" value=\"" + vc.getClase_documento_solped() + "\"/>");
//                    out.println("<input type=\"text\" id=\"NumSolped1\" value=\"" + vc.getNum_solped() + "\"/>");
//                    out.println("<input type=\"text\" id=\"OrgCompras1\" value=\"" + vc.getOrganizacion_compras() + "\"/>");
//                    out.println("<input type=\"text\" id=\"GrupoCom1\" value=\"" + vc.getGrupo_compras() + "\"/>");
//                    out.println("<input type=\"text\" id=\"NumNece1\" value=\"" + vc.getFolio_sam() + "\"/>");
//                    out.println("<input type=\"text\" id=\"TxtCab\" value=\"\"/>");
//                    out.println("<input type=\"text\" id=\"Txtreci\" value=\"" + vc.getRecibido() + "\"/>");
//                    out.println("<input type=\"text\" id=\"Txtproce\" value=\"" + vc.getProcesado() + "\"/>");
//                    out.println("<input type=\"text\" id=\"TxtError\" value=\"" + vc.getError() + "\"/>");
//                    out.println("<input type=\"text\" id=\"TxtModi\" value=\"" + vc.getModificado() + "\"/>");
//                    break;
//                case "CargarListaSelect":
//                    LinkedList<SolpedCrea> spl = ACC_SolicitudPedidos.ObtenerInstancia().ConsultaSolped(query);
//                    out.println("<select id=\"Distribucion_SP\">"
//                            + "<option></option>");
//                    for (int c = 0; c < spl.size(); c++) {
//                        out.println("<option>" + spl.get(c).getNum_posicion_solped() + "</option>");
//                    }
//                    out.println("</select>");
//                    break;
//                case "ObtenerPosicion":
//                    String queryPos = "";
//                    if (NumSAP != "" && NumSAM != "") {
//                        queryPos = "SELECT * FROM solped_crea WHERE num_solped='" + NumSAP + "' AND folio_sam='" + NumSAM + "'  AND num_posicion_solped='" + Posicion + "'";
//                    }
//                    if (NumSAP != "" && NumSAM == "") {
//                        queryPos = "SELECT * FROM solped_crea WHERE num_solped='" + NumSAP + "'  AND num_posicion_solped='" + Posicion + "'";
//                    }
//                    if (NumSAM != "" && NumSAP == "") {
//                        queryPos = "SELECT * FROM solped_crea WHERE  folio_sam='" + NumSAM + "'  AND num_posicion_solped='" + Posicion + "'";
//                    }
//                    SolpedCrea s1 = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerDatosSolped(queryPos);
////                    LinkedList<textos_posiciones_solped> stp = ACC_SolicitudPedidos.ObtenerInstancia().ObtenertxtoPos(NumSAM, Posicion);
////                    String textp = "";
////                    for (i = 0; i < stp.size(); i++) {
////                        textp += stp.get(i).getLinea_texto();
////                    }
//                    out.println("<input type=\"text\" id=\"Inputacion_SP1\" value=\"" + s1.getTipo_imputacion() + "\"/>");
//                    out.println("<input type=\"text\" id=\"Posicion_SP1\" value=\"" + s1.getTipo_posicion_doc_compras() + "\"/>");
//                    out.println("<input type=\"text\" id=\"Material_SP1\" value=\"" + s1.getNum_material() + "\"/>");
//                    out.println("<input type=\"text\" id=\"Cantidad_SP1\" value=\"" + s1.getCantidad_solped() + "\"/>");
//                    out.println("<input type=\"text\" id=\"FechaEntr_SP1\" value=\"" + s1.getFecha_entraga_posicion() + "\"/>");
//                    out.println("<input type=\"text\" id=\"Centro_SP1\" value=\"" + s1.getCentro() + "\"/>");
//                    out.println("<input type=\"text\" id=\"Almacen_SP1\" value=\"" + s1.getAlmacen() + "\"/>");
//                    out.println("<input type=\"text\" id=\"textobreve_SP1\" value=\"" + s1.getTexto_breve() + "\"/>");
//                    out.println("<input type=\"text\" id=\"UM_SP1\" value=\"" + s1.getUnidad_medida_solped() + "\"/>");
//                    out.println("<input type=\"text\" id=\"GrpoArtic_SP1\" value=\"" + s1.getGrupo_articulos() + "\"/>");
//                    out.println("<input type=\"text\" id=\"Solicitante_SP1\" value=\"" + s1.getSolicitante() + "\"/>");
//                    out.println("<input type=\"text\" id=\"PrecioValor_SP1\" value=\"" + s1.getPrecio_solped() + "\"/>");
//                    out.println("<input type=\"text\" id=\"ClaveMoneda_SP1\" value=\"" + s1.getClave_moneda() + "\"/>");
//                    out.println("<input type=\"text\" id=\"CtaMayor_SP1\" value=\"" + s1.getNum_cuenta_mayor() + "\"/>");
//                    out.println("<input type=\"text\" id=\"CentroCosto_SP1\" value=\"" + s1.getCentro_coste() + "\"/>");
//                    out.println("<input type=\"text\" id=\"Orden_SP1\" value=\"" + s1.getNum_orden() + "\"/>");
//                    out.println("<input type=\"text\" id=\"TextPos_SP1\" value=\"\"/>");
//                    break;
//                case "ObtenerPosicionServicios":
//                    String queryPosSer = "";
//                    if (NumSAP != "" && NumSAM != "") {
//                        queryPosSer = "SELECT * FROM solped_servicios_crea WHERE num_solped='" + NumSAP + "' AND folio_sam='" + NumSAM + "'  AND num_posicion_solped='" + Posicion + "' ORDER BY num_posicion_solped2 ";
//                    }
//                    if (NumSAP != "" && NumSAM == "") {
//                        queryPosSer = "SELECT * FROM solped_servicios_crea WHERE num_solped='" + NumSAP + "'  AND num_posicion_solped='" + Posicion + "' ORDER BY num_posicion_solped2";
//                    }
//                    if (NumSAM != "" && NumSAP == "") {
//                        queryPosSer = "SELECT * FROM solped_servicios_crea WHERE  folio_sam='" + NumSAM + "'  AND num_posicion_solped='" + Posicion + "' ORDER BY num_posicion_solped2";
//                    }
//                    LinkedList<SolpedServicios> ser = ACC_SolicitudPedidos.ObtenerInstancia().CargarServicios(queryPosSer);
//                    int h;
//                    if (ser.size() > 0) {
//                        out.println("<tbody>");
//                        for (h = 0; h < ser.size(); h++) {
//                            out.println("<tr>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" value=\"" + ser.get(h).getNum_posicion_solped() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" value=\"" + ser.get(h).getNum_posicion_solped2() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" value=\"" + ser.get(h).getNum_servicio() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" value=\"" + ser.get(h).getCantidad() + "\"  /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" value=\"" + ser.get(h).getUnidad_medida_base() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER7\" style=\"background: none\" value=\"" + ser.get(h).getPrecio_bruto() + "\" /></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" value=\"" + ser.get(h).getTexto_breve() + "\" /></td>");
//                            out.println("</tr>");
//                        }
//                        for (int j = h; j < 10; j++) {
//                            out.println("<tr>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER7\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" readOnly/></td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                    } else {
//                        out.println("<tbody>");
//                        for (int l = 0; l < 10; l++) {
//                            out.println("<tr>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER1\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER2\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER3\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER4\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER5\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER6\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER7\" style=\"background: none\" readOnly/></td>");
//                            out.println("<td><input type=\"text\" readOnly class=\"TDSER8\" style=\"background: none\" readOnly/></td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                    }
//                    break;
//                case "LoadTxtCab":
//                    String queryq = "SELECT  * FROM  textos_cabecera_solped  WHERE folio_sam='" + NumeroSolped + "'";
//                    LinkedList<textos_cabecera_solped> tcs = ACC_Textos_cabecera_solped.ObtenerInstancia().ObtenerTextoSolCabSolped(queryq);
//                    String cad = "";
//                    for (int l = 0; l < tcs.size(); l++) {
//                        cad += tcs.get(l).getLinea_texto();
//                    }
//                    if (cad.length() > 0) {
//                         out.println(cad);
//                    }
//                   
//                    break;
//                case "mostTEPO":
//                    String queryqu = "select * from  textos_posiciones_solped  where folio_sam='" + NumeroSolped + "' and num_posicion_solped = '" + Posicion + "'";
//                    LinkedList<textos_posiciones_solped> tsp = ACC_Textos_posiciones_solped.ObtenerInstancia().MostrarText(queryqu);
//                    String ca = "";
//                    for (int j = 0; j < tsp.size(); j++) {
//                        ca += tsp.get(j).getLinea_texto();
//                    }
//                    out.println(ca);
//
//                    break;
//            }
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
