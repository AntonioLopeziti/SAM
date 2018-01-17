/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_HojasRuta;
import Entidades.hojas_de_ruta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zil
 */
@WebServlet(name = "peticionVisualHojaRuta", urlPatterns = {"/peticionVisualHojaRuta"})
public class peticionVisualHojaRuta extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String centro = request.getParameter("c");
            String equipo = request.getParameter("e");
            String action = request.getParameter("a");
//            equipo = "CARI651PS002A1002";
//            centro = "cARi";
//            action = "consultarRegistros";
            switch (action) {
                case "validarRegistros":
                    if (ACC_HojasRuta.ObtenerInstancia().validarReg(centro, equipo)) {
                        out.println(1); ///// Existen reg
                    } else {
                        out.println(0); ///// No existen reg
                    }
                    break;
                case "consultarRegistros":
//                    LinkedList<hojas_de_ruta> hr = ACC_HojasRuta.ObtenerInstancia().ConsultaVisualizarHR(centro, equipo);
//                    out.println("<tbody>");
//                    for (int i = 0; i < 10; i++) {
//                        out.println("<tr>");
//                        out.println("<td>"+hr.get(i).getContador_grupo_hojaruta()+"</td>");
//                        out.println("<td>"+hr.get(i).getTexto_hojaruta()+"</td>");
//                        out.println("<td>"+hr.get(i).getNum_operacion()+"</td>");
//                        out.println("<td>"+hr.get(i).getId_objeto()+"</td>");
//                        out.println("<td>"+hr.get(i).getClave_control()+"</td>");
//                        out.println("<td>"+hr.get(i).getCentro()+"</td>");
//                        out.println("<td>"+hr.get(i).getAlternativa_lista_material()+"</td>");
//                        out.println("<td>"+hr.get(i).getTexto_breve_operacion()+"</td>");
//                        out.println("<td>"+hr.get(i).getCantidad_base()+"</td>");
//                        out.println("<td>"+hr.get(i).getDuracion_operacion_normal()+"</td>");
//                        out.println("<td>"+hr.get(i).getUnidad_duracion_normal()+"</td>");
//                        out.println("<td>"+hr.get(i).getTrabajo_operacion()+"</td>");
//                        out.println("<td>"+hr.get(i).getUnidad_trabajo()+"</td>");
//                        out.println("<td>"+hr.get(i).getTipo_hojaruta()+"</td>");
//                        out.println("<td>"+hr.get(i).getClave_grupo_hojaruta()+"</td>");
//                        out.println("<td>"+hr.get(i).getSecuencia()+"</td>");
//                        out.println("<td>"+hr.get(i).getNum_nodo_hojaruta()+"</td>");
//                        out.println("<td>"+hr.get(i).getLista_material()+"</td>");
//                        out.println("<td>"+hr.get(i).getStatus()+"</td>");
//                        out.println("<td>"+hr.get(i).getDescripcion_operacion2()+"</td>");
//                        out.println("<td>"+hr.get(i).getUnidad_medida_operacion()+"</td>");
//                        out.println("<td>"+hr.get(i).getOrganización_compras()+"</td>");
//                        out.println("<td>"+hr.get(i).getNum_cuenta_prove_acreedor()+"</td>");
//                        out.println("<td>"+hr.get(i).getGrupo_articulos()+"</td>");
//                        out.println("<td>"+hr.get(i).getNum_reg_info_compras()+"</td>");
//                        out.println("<td>"+hr.get(i).getClase_coste()+"</td>");
//                        out.println("<td>"+hr.get(i).getClave_moneda()+"</td>");
//                        out.println("<td>"+hr.get(i).getGrupo_compras_activi_traba_extra()+"</td>");
//                        out.println("<td>"+hr.get(i).getTipo_reginfo_compras()+"</td>");
//                        out.println("<td>"+hr.get(i).getIndicador_borrado()+"</td>");                        
////                        out.println("</tr>");
//                    }
//
//                    out.println("</tbody>");
//
//                    break;
//            

            }}
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
