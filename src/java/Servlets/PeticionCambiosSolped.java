/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.Consultas;
import Entidades.SolicitudPedidos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PeticionCambiosSolped", urlPatterns = {"/PeticionCambiosSolped"})
public class PeticionCambiosSolped extends HttpServlet {

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
            SolicitudPedidos slp = new SolicitudPedidos();
            slp.setClasedoc_solped(request.getParameter("cl"));
            slp.setTexto_cabecera(request.getParameter("tc"));
            slp.setNum_posicion(request.getParameter("dp"));
            slp.setTipo_imputacion(request.getParameter("ip"));
            slp.setTipo_posicion_doccompras(request.getParameter("ps"));
            slp.setMaterial(request.getParameter("mm"));
            slp.setTexto_breve(request.getParameter("tb"));
            slp.setCantidad_solped(request.getParameter("cn"));
            slp.setUnidad_medida_solped(request.getParameter("um"));
            slp.setFecha_entrega(request.getParameter("fe"));
            slp.setGrupo_articulos(request.getParameter("ga"));
            slp.setCentro(request.getParameter("ct"));
            slp.setAlmacen(request.getParameter("al"));
            slp.setGrupo_compras(request.getParameter("gc"));
            slp.setNombre_solicitante(request.getParameter("sl"));
            slp.setNum_necesidad(request.getParameter("nn"));
            slp.setProveedor_deseado(request.getParameter("pd"));
            slp.setProveedor(request.getParameter("pf"));
            slp.setOrganizacion_commpras(request.getParameter("oc"));
            slp.setNum_contrato_superior(request.getParameter("cr"));
            slp.setNum_posicion_contrato_sup(request.getParameter("pc"));
            slp.setNum_reginfo_compras(request.getParameter("ri"));
            slp.setIndicador_distribucion_imputa_multi(request.getParameter("dn"));
            slp.setNum_cuenta_mayor(request.getParameter("cm"));
            slp.setSociedad_co(request.getParameter("sc"));
            slp.setCentro_coste(request.getParameter("cc"));
            slp.setTexto_posicion(request.getParameter("tp"));
            slp.setNum_necesidad(request.getParameter("id"));
            slp.setFecha("");
            slp.setHora("000000");    
            
            String campos = ""
                    + "      material='" + slp.getMaterial() + "',"
                    + "      fecha='" + slp.getFecha() + "', "
                    + "      hora='"+slp.getHora()+"', "
                    + "      clasedoc_solped='" + slp.getClasedoc_solped() + "', "
                    + "      tipo_imputacion='" + slp.getTipo_imputacion() + "',"
                    + "      texto_breve='" + slp.getTexto_breve() + "', "
                    + "      cantidad_solped='" + slp.getCantidad_solped() + "',"
                    + "      unidad_medida_solped='" + slp.getUnidad_medida_solped() + "', "
                    + "      fecha_entrega='" + slp.getFecha_entrega() + "',"
                    + "      grupo_articulos='" + slp.getGrupo_articulos() + "',"
                    + "      centro='"+slp.getCentro()+"', "
                    + "      almacen='"+slp.getAlmacen()+"', "
                    + "      grupo_compras='"+slp.getGrupo_compras()+"',"
                    + "      nombre_solicitante='"+slp.getNombre_solicitante()+"', "
                    + "      proveedor_deseado='" + slp.getProveedor_deseado() + "', "
                    + "      proveedor='" + slp.getProveedor() + "', "
                    + "      indice_reg_novalido= '0' ,"
                    + "      tipo_posicion_doccompras='"+slp.getTipo_posicion_doccompras()+"', "
                    + "      num_reginfo_compras='"+slp.getNum_reginfo_compras()+"', "
                    + "      organizacion_commpras='" + slp.getOrganizacion_commpras() + "',"
                    + "      num_contrato_superior='" + slp.getNum_contrato_superior() + "',"
                    + "      num_posicion_contrato_sup='" + slp.getNum_posicion_contrato_sup() + "', "
                    + "      indicador_distribucion_imputa_multi='" + slp.getIndicador_distribucion_imputa_multi() + "', "
                    + "      num_cuenta_mayor='" + slp.getNum_cuenta_mayor() + "', "
                    + "      sociedad_co='"+slp.getSociedad_co()+"', "
                    + "      centro_coste='" + slp.getCentro_coste() +"', "
                    + "      texto_cabecera='" + slp.getTexto_cabecera()+ "', "
                    + "      texto_posicion='" + slp.getTexto_posicion() + "', "
                    + "      error=''";
            
            String condicion = "num_necesidad='" + slp.getNum_necesidad()+ "' AND num_posicion='" + slp.getNum_posicion() + "'";
            
            if(Consultas.ObtenerInstancia().Update("solped", campos, condicion))
            {
                out.println(0);
            }
            else
            {
                out.println("Error al Guardar los Datos");
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
