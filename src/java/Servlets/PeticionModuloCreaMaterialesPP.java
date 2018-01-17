/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Centro;
import Entidades.materiales;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Are-Consulting
 */
@WebServlet(name = "PeticionModuloCreaMaterialesPP", urlPatterns = {"/PeticionModuloCreaMaterialesPP"})
public class PeticionModuloCreaMaterialesPP extends HttpServlet {

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
            String accion = request.getParameter("Action");
            String mater = request.getParameter("Mate");
            String cntro = request.getParameter("Centro");
            String organiz = request.getParameter("Organiz");
            String canal = request.getParameter("Canal");
            String ubm = request.getParameter("Ubm");
            String nomat = request.getParameter("NoMat");
            String tipmat = request.getParameter("TipMat");
            String gpoart = request.getParameter("GpoArt");
            String sector = request.getParameter("Sector");
            String umvent = request.getParameter("UmVent");
            String gmater = request.getParameter("Gmater");
            String gtpmate = request.getParameter("GtpMate");
            String jerapro = request.getParameter("Jerapro");
            String gropoimate = request.getParameter("GropoiMate");
            String gtpgen = request.getParameter("Gtpgen");
            String gvdispo = request.getParameter("Gvdispo");
            String gpotransp = request.getParameter("GpoTransporte");
            String centrobene = request.getParameter("CentroBene");
            String sujetolote = request.getParameter("SujetoLote");
            String grupocarga = request.getParameter("GrupoCarga");
            String grupocompras = request.getParameter("GrupoCompras");
            String caraplan = request.getParameter("CaraPlann");
            String puntoped = request.getParameter("PuntoPed");
            String gpnece = request.getParameter("Gpnece");
            String tlmin = request.getParameter("Tlmin");
            String hppfijo = request.getParameter("Hppfijo");
            String pnecesi = request.getParameter("Pnecesi");
            String tlmax = request.getParameter("Tlmax");
            String stockmax = request.getParameter("StockMax");
            String claseapro = request.getParameter("Claseapro");
            String tmdia = request.getParameter("Tmdia");
            String stockseg = request.getParameter("StockSeg");
            String stocksegm = request.getParameter("StockSegM");
            String claseaprov = request.getParameter("ClaseAprov");
            String pepdia = request.getParameter("Pepdia");
            String epimcen = request.getParameter("Epimcen");
            String qmapor = request.getParameter("Qmapor");
            String icprecios = request.getParameter("Icprecios");
            String pmviper = request.getParameter("PmViper");
            String precioestandar = request.getParameter("PrecioEstandar");
            String cantidadbase = request.getParameter("CantidadBase");
            String clasevaloracion = request.getParameter("ClaseValoracion");
            String cateval = request.getParameter("CateVal");
            
            switch (accion) {
                case "validaMateEx":
                    if (ACC_Material.ObtenerInstancia().ValidarMateCrea(mater)) {
                        out.println(1); ///// El material Existe
                    }else{
                        out.println(0);
                    }
                    break;
                case "ValidarCentro":
                    if(ACC_Centro.ObtenerInstancia().ValidarCentroCreaCen(cntro)){
                        out.println(1); ///// El centro Existe
                    }else{
                        out.println(0);
                    }
                    break;
                case "GuardarDatos":
                    materiales mat = new materiales();
                    mat.setMaterial(mater);
                    mat.setCentro(cntro);
                    mat.setUnidad_medida(ubm);
                    mat.setGrupo_articulos(gpoart);
                    mat.setTipo_material(tipmat);
                    mat.setGrupo_transporte(gpotransp);
                    mat.setGrupo_compras(grupocompras);
                    mat.setSujeto_lote(sujetolote);
                    //mat.setDescripcion();
                    mat.setCara_plan_nece(caraplan);
                    mat.setPunto_pedido(puntoped);
                    //mat.setCiclo_plan_nece(gpnece);
                    mat.setHoriz_plan_fijo(hppfijo);
                    mat.setPlanificador_necesi(pnecesi);
                    //mat.setTam_lote_plan_nece(gpnece);
                    mat.setTama_lote_min(tlmin);
                    mat.setTama_lote_max(tlmax);
                    mat.setStock_maximo(stockmax);
                    mat.setClase_aprovisionamiento(claseaprov);
                    //mat.setClase_clase_aprov_espe(claseaprov);
                    //mat.setTiempo_trata_en_merca_dia(precioestandar);
                    mat.setPlazo_entre_previ_dia(pepdia);
                    mat.setStock_seguridad(stockseg);
                    mat.setStock_seguridad_minimo(stocksegm);
                    //mat.setExiste_para_insp_mate_cen(epimcen);
                    mat.setQm_activo_apro(qmapor);
                    mat.setSector(sector);
                    mat.setGrupo_tipo_posi_gen(gtpgen);
                    mat.setGrupo_veri_de_dispo(gvdispo);
                    mat.setCentro_beneficio(centrobene);
                    mat.setGrupo_carga(grupocarga);
                    mat.setUnidad_medida_venta(umvent);
                    //mat.setGrupo_precios_mate(gropoimate);
                    //mat.setGrupo_estadi_material(gropoimate);
                    mat.setGrupo_imputa_material(gropoimate);
                    //mat.setGrupo_tipos_posi_ma_mate(gropoimate);
                    mat.setJerarquia_produc(jerapro);
                    mat.setOrganizacion_ventas(organiz);
                    //mat.setGrupo_vendedores(grupocompras);
                    //mat.setCanal_distribucion(clasevaloracion);
                    mat.setIndicador_control_precios(icprecios);
                    //mat.setPrecio_medio_vari_inte_per(precioestandar);
                    mat.setPrecio_estandar(precioestandar);
                    mat.setCantidad_base(cantidadbase);
                    mat.setClase_valoracion(clasevaloracion);
                    mat.setCategoria_valoracion(cateval);
                    //mat.setNum_pieza_fabricante(cantidadbase);
                    //mat.setMateria(mater);
                    if (ACC_Material.ObtenerInstancia().InsertarMateCreaPP(mat)) {
                        out.println(5); /// Consulta Exitosa
                    } else {
                        out.println(6); /// Error al ejecutar la consulta
                    }
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
