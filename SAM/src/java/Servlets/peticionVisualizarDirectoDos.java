/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CabeceraDocMateriales;
import AccesoDatos.ACC_DetallesDocMateriales;
import Entidades.DatosMaterialLista;
import Entidades.cabecera_doc_materiales;
import Entidades.detalles_doc_materiales;
import Entidades.detalles_posiciones_doc_material;
import Entidades.pedidoprov;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Angel
 */
@WebServlet(name = "peticionVisualizarDirectoDos", urlPatterns = {"/peticionVisualizarDirectoDos"})
public class peticionVisualizarDirectoDos extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String NUMDOC = request.getParameter("FOLIO");
            String POSDOC = request.getParameter("POSICIONDOC");
            HttpSession session = request.getSession();
            String Idioma = (String) session.getAttribute("Idioma");

            switch (Accion) {
//                case "ValidarPosicion":
//                    cabecera_doc_materiales cd = ACC_CabeceraDocMateriales.ObtenerInstancia().ConsultaPosFol(NUMDOC);
//                    boolean doccrea = ACC_CabeceraDocMateriales.ObtenerInstancia().ValidarDocMaterialCrea(NUMDOC);
//                    boolean docvis = ACC_CabeceraDocMateriales.ObtenerInstancia().ValidarDocMaterialSap(NUMDOC);
//                    if (doccrea) {
//                        out.print(NUMDOC);
//                    } else if (docvis) {
//                        String nd = cd.getNum_doc_material();
//                        out.print(nd);
//                    } else {
//                        out.println(0);
//                    }
//                    break;
                case "ObtenerPosicion":
                    String keri = "SELECT * FROM detalles_doc_materiales WHERE (num_doc_material = '" + NUMDOC + "' OR folio_sam = '" + NUMDOC + "') AND pos_doc_compras = '" + POSDOC + "'";
                    detalles_doc_materiales dl = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaPosi(keri);
                    if (NUMDOC.equals("")) {
                        out.println(0);
                    } else {
                        String datos = "" + dl.getDescripcion_ES() + ","
                                + "" + dl.getNum_material() + ","
                                + "" + dl.getGrupo_articulos() + ","
                                + "" + dl.getClase_movimiento() + ","
                                + "" + dl.getIndicador_stock_especial() + ","
                                + "" + dl.getIndicador_debe_haber() + ","
                                + "" + dl.getNombre() + ","
                                + "" + dl.getDenominacion_almacen() + ","
                                + "" + dl.getNum_cuenta_proveedor() + ","
                                + "" + dl.getCentro() + ","
                                + "" + dl.getAlmacen() + ","
                                + "" + dl.getNum_pedido() + ","
                                + "" + dl.getNum_posicion_doc_compras() + ","
                                + "" + dl.getNombre1() + ","
                                + "" + dl.getNum_cuenta_proveedor() + ","
                                + "" + dl.getNum_lote() + ","
                                + "" + dl.getNum_material_utilizado_proveedor() + ","
                                + "" + dl.getPuesto_descarga() + ","
                                + "" + dl.getAlmacen_destino() + ","
                                + "" + dl.getCampo_texto_longitud() + "";
                        out.println(datos);
                    }
                    break;
                case "ObtenerPosicionCrea":
                    String k = "SELECT * FROM movimientos_detalle_crea WHERE folio_sam = '" + NUMDOC + "' AND indice_registro_no_valido = '" + POSDOC + "'";
                    detalles_doc_materiales dlc = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaPosiCrea(k);
                    String mta = dlc.getNum_material();
                    String cnt = dlc.getCentro();
                    String al = dlc.getAlmacen();
                    String num_ped = dlc.getNum_pedido();
                    DatosMaterialLista dml = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesMGA(mta);
                    DatosMaterialLista dhc = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesCen(cnt);
                    DatosMaterialLista dam = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesAm(al , Idioma);
                    pedidoprov psd = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaDetallesProvs(num_ped);
                    if (NUMDOC.equals("")) {
                        out.println(0);
                    } else {
                        String datos = "" + dlc.getDescripcion_ES() + ","
                                + "" + dlc.getNum_material() + ","
                                + "" + dml.getGrupo_articulos() + ","
                                + "" + dlc.getClase_movimiento() + ","
                                + "" + dlc.getIndicador_stock_especial() + ","
                                + ","
                                + "" + dhc.getDescripcion_centro() + ","
                                + "" + dam.getDescripcion_almacen() + "," 
                                + "" + dlc.getNum_cuenta_proveedor() + ","
                                + "" + dlc.getCentro() + ","
                                + "" + dlc.getAlmacen() + ","
                                + "" + dlc.getNum_pedido() + ","
                                + "" + dlc.getNum_posicion_doc_compras() + ","
                                + ","
                                + "" + dlc.getNum_cuenta_proveedor() + ","
                                + "" + dlc.getNum_lote() + ","
                                + ","
                                + ","
                                + "" + dlc.getAlmacen_destino() + ","
                                + "" + psd.getProveedor() + ","
                                + "" + psd.getDescripcion() + ","
                                + "" + dlc.getNum_lote_proveedor() + "";
                        out.println(datos);
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
