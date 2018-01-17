/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import java.io.IOException;
import java.io.PrintWriter;
import AccesoDatos.ACC_RegistroInfo;
import Entidades.registroinfo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Are-Consulting
 */
@WebServlet(name = "PeticionModuloCreaInfoRecords", urlPatterns = {"/PeticionModuloCreaInfoRecords"})
public class PeticionModuloCreaInfoRecords extends HttpServlet {

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
            String info = request.getParameter("infoRe");            
            String material = request.getParameter("material");
            String proveedor = request.getParameter("proveedor");
            String orgComp = request.getParameter("orgComp");
            String infoTipo = request.getParameter("infoTipo");
            String centro = request.getParameter("centro");
            String gpoArts = request.getParameter("gpoArts");
            String gpoComps = request.getParameter("gpoComps");
            String plazaEnt = request.getParameter("plazaEnt");
            String numArPro = request.getParameter("numArPro");
            String cantStand = request.getParameter("cantStand");
            String cantMax = request.getParameter("cantMax");
            String sinText = request.getParameter("sinText");
            String inDobl = request.getParameter("inDobl");
            String tolSumim = request.getParameter("tolSumim");
            String tolecSum = request.getParameter("tolecSum");
            String cantUNP = request.getParameter("cantUNP");
            String cantUMP2 = request.getParameter("cantUMP2");
            String cantUMB = request.getParameter("cantUMB");
            String cantUMB2 = request.getParameter("cantUMB2");
            String precioNet = request.getParameter("precioNet");
            String claveMon = request.getParameter("claveMon");
            String cntBase = request.getParameter("cntBase");
            String cntBase2 = request.getParameter("cntBase2");
            String iva = request.getParameter("iva");
            switch (accion) {
                case "ValidarInfoRe":
                    if (ACC_RegistroInfo.ObtenerInstancia().ValidarInfoReCrea(info)) {
                        out.println(1); ///// El material Existe
                    }else{
                        out.println(0);
                    }
                    break;
                case "ValidarCentro":
                    if(ACC_Centro.ObtenerInstancia().ValidarCentroCreaCen(centro)){
                        out.println(1); ///// El centro Existe
                    }else{
                        out.println(0);
                    }
                    break;
                case "GuardarDatos":
                    registroinfo regInf = new registroinfo();
                    regInf.setIdRegistroinfo(info);
                    regInf.setNum_material(material);
                    regInf.setProveedor(proveedor);
                    regInf.setOrganizacion_compras(orgComp);
                    regInf.setTipo_reginfo_compras(infoTipo);
                    regInf.setCentro(centro);
                    regInf.setGrupo_articulos(gpoArts);
                    regInf.setGrupo_compras(gpoComps);
                    regInf.setPlazo_entrega_dias(plazaEnt);
                    //regInf.setMaterial_utilizado_proveedor(proveedor);
                    regInf.setCatiddad_pedido_estandar(cantStand);
                    regInf.setCantidad_pedido_maxima(cantMax);
                    regInf.setTexto_pedido_material_norelevante(sinText);
                    regInf.setIndicador_obli_confir_pedido(inDobl);
                    regInf.setLimite_tolerancia_exceso_suministro(tolSumim);
                    regInf.setLimite_tolerancia_entrega_incompleta(tolecSum);
                    regInf.setDenominador_conver_um(cantUNP);
                    regInf.setUnidad_medida_pedido(cantUMP2);
                    regInf.setNumerador_conversion_um(cantUMB);
                    regInf.setUnidad_medida(cantUMB2);
                    regInf.setPrecio_neto_info_compras(precioNet);
                    regInf.setClave_moneda(claveMon);
                    regInf.setCantidad_base(cntBase);
                    regInf.setUnidad_medida_precio_pedido(cntBase2);
                    regInf.setIndicador_iva(iva);
                    if (ACC_RegistroInfo.ObtenerInstancia().InsertaInfoRecCrea(regInf)) {
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
