///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Servlets;
//
//import AccesoDatos.ACC_notificaciones_cabecera_vis;
//import Entidades.notificaciones_cabecera_vis;
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
//@WebServlet(name = "peticionResumenNotificacionesPM", urlPatterns = {"/peticionResumenNotificacionesPM"})
//public class peticionResumenNotificacionesPM extends HttpServlet {
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
//            String Orden = request.getParameter("Parametro1");
//            
//            if(Orden == "" || Orden == null){
//                out.println(0);
//            }
//            else{
//                out.println("<table>");
//                out.println("<tr>");
//                out.println("<td><b>Indicador Op.</b></td>");
//                out.println("<td><b>Op.</b></td>");
//                out.println("<td><b>SbOp</b></td>");
//                out.println("<td><b>Cl.</b></td>");
//                out.println("<td><b>Par</b></td>");
//                out.println("<td><b>Not.</b></td>");
//                out.println("<td><b>F</b></td>");
//                out.println("<td><b>A</b></td>");
//                out.println("<td><b>FeCont</b></td>");
//                out.println("<td><b>PstoTbjo</b></td>");
//                out.println("<td><b>Tbjo.real</b></td>");
//                out.println("<td><b>Un</b></td>");
//                out.println("<td><b>ClAct</b></td>");
//                out.println("<td><b>Descripción</b></td>");
//                out.println("<td><b>Cl.</b></td>");
//                out.println("<td><b>Fecha Inicio Real</b></td>");
//                out.println("<td><b>Fecha Fin Real</b></td>");
//                out.println("<td><b>Pronóst.trabajo</b></td>");
//                out.println("<td><b>Trabajo</b></td>");
//                out.println("<td><b>FechaInicMásTmp</b></td>");
//                out.println("<td><b>FechainicMásTardía</b></td>");
//                out.println("<td><b>FechaFinMásTmpr</b></td>");
//                out.println("<td><b>FechaFinMásTrd.</b></td>");
//                out.println("</tr>");
//                
//                LinkedList<notificaciones_cabecera_vis> nct = ACC_notificaciones_cabecera_vis.ObtenerInstancia().GetResumenNotificaciones(Orden);
//                for(int i = 0; i < nct.size(); i++){
//                    out.println("<tr>");
//                    out.println("<td>" + nct.get(i).getIndicador_cabecera() + "</td>");
//                    out.println("<td>" + nct.get(i).getNum_operacion() + "</td>");
//                    out.println("<td>" + nct.get(i).getSuboperacion() + "</td>");
//                    out.println("<td>" + nct.get(i).getClase_capacidad() + "</td>");
//                    out.println("<td>" + "" + "</td>");
//                    out.println("<td>" + nct.get(i).getContador_notificacion() + "</td>");
//                    out.println("<td>" + nct.get(i).getNotificacion_parcial_final() + "</td>");
//                    out.println("<td>" + nct.get(i).getIndicador_doc_anulado() + "</td>");
//                    out.println("<td>" + nct.get(i).getFecha_contabilizacion() + "</td>");
//                    out.println("<td>" + nct.get(i).getPuesto_trabajo() + "</td>");
//                    out.println("<td>" + nct.get(i).getTrabajo_real() + "</td>");
//                    out.println("<td>" + nct.get(i).getUnidad_trabajo() + "</td>");
//                    out.println("<td>" + nct.get(i).getClase_actividad_notificacion() + "</td>");
//                    out.println("<td>" + nct.get(i).getTexto_breve_operacion() + "</td>");
//                    out.println("<td>" + nct.get(i).getCl_reg_notificacion() + "</td>");
//                    out.println("<td>" + nct.get(i).getInicio_real_ejecucion_fecha() + "</td>");
//                    out.println("<td>" + nct.get(i).getFin_real_ejecucion_fecha() + "</td>");
//                    out.println("<td>" + nct.get(i).getTrabajo_pronosticado_real_resto() + "</td>");
//                    out.println("<td>" + nct.get(i).getTrabajo_operacion() + "</td>");
//                    out.println("<td>" + nct.get(i).getInicio_mas_temprano_programado_ejecucion_fecha() + "</td>");
//                    out.println("<td>" + nct.get(i).getInicio_programado_mas_tardio_efectua_fecha() + "</td>");
//                    out.println("<td>" + nct.get(i).getFin_mas_temprano_programado_ejecucion_fecha() + "</td>");
//                    out.println("<td>" + nct.get(i).getFin_mas_tardio_programado_ejecucion_fecha() + "</td>");
//                    out.println("</tr");
//                }
//                out.println("</table>");
//            }
//        }
//    }
////
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
