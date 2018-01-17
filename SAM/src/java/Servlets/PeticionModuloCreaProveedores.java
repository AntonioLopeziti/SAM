/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import Entidades.proveedor;
import AccesoDatos.ACC_Proveedor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Are-Consulting
 */
@WebServlet(name = "PeticionModuloCreaProveedores", urlPatterns = {"/PeticionModuloCreaProveedores"})
public class PeticionModuloCreaProveedores extends HttpServlet {

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
            String acreedor = request.getParameter("acreedor");
            String sociedad = request.getParameter("sociedad");
            String orgComp = request.getParameter("orgComp");
            String nomProv = request.getParameter("nomProv");
            String poblacion = request.getParameter("poblacion");
            String recidencia = request.getParameter("recidencia");
            String calle = request.getParameter("calle");
            String distrito = request.getParameter("distrito");
            String edificio = request.getParameter("edificio");
            String nif = request.getParameter("nif");
            String pago = request.getParameter("pago");
            String abc = request.getParameter("abc");
            String gpoCuenta = request.getParameter("gpoCuenta");
            String cuentaSo = request.getParameter("cuentaSo");
            String moneda = request.getParameter("moneda");
            String valor = request.getParameter("valor");
            String ico1 = request.getParameter("ico1");
            String ico2 = request.getParameter("ico2");
            String config = request.getParameter("config");
            String gpoComp = request.getParameter("gpoComp");            
            String tipChek = request.getParameter("tipChek");
            switch (accion) {
                case "GuardarDatos":
                    int tip = Integer.parseInt(tipChek);
                    switch (tip){
                        case 0:
                            proveedor pro = new proveedor();
                            pro.setNombre1(nomProv);
                            pro.setPoblacion(poblacion);
                            pro.setLugarResidencia(recidencia);
                            pro.setCalle(calle);
                            pro.setDistrito(distrito);
                            pro.setNumEdificio(edificio);
                            pro.setNIF(nif);
                            pro.setClaveCondicionesPago(pago);
                            pro.setIndicadorABC(abc);
                            pro.setGrupoCuentasAcreedor(gpoCuenta);
                            pro.setCuentaAsociadaConta(cuentaSo);
                            pro.setMonedaPedido(moneda);
                            pro.setValorMinimoPedido(valor);
                            pro.setIncoPart1(ico1);
                            pro.setIncoPart2(ico2);
                            pro.setClaveControlConfir(config);
                            pro.setGrupoCompras(gpoComp);
                            pro.setPeticionBorradorMaestro("");
                            pro.setBloqueoContabilizaionSociedad("");
                            pro.setPeticionBorradorCentral("");
                            if (ACC_Proveedor.ObtenerInstancia().InsertaProvCrea(pro)) {
                                out.println(5); /// Consulta Exitosa
                            } else {
                                out.println(6); /// Error al ejecutar la consulta
                            }
                            break;
                        case 1:
                            proveedor prov = new proveedor();
                            prov.setNombre1(nomProv);
                            prov.setPoblacion(poblacion);
                            prov.setLugarResidencia(recidencia);
                            prov.setCalle(calle);
                            prov.setDistrito(distrito);
                            prov.setNumEdificio(edificio);
                            prov.setNIF(nif);
                            prov.setClaveCondicionesPago(pago);
                            prov.setIndicadorABC(abc);
                            prov.setGrupoCuentasAcreedor(gpoCuenta);
                            prov.setCuentaAsociadaConta(cuentaSo);
                            prov.setMonedaPedido(moneda);
                            prov.setValorMinimoPedido(valor);
                            prov.setIncoPart1(ico1);
                            prov.setIncoPart2(ico2);
                            prov.setClaveControlConfir(config);
                            prov.setGrupoCompras(gpoComp);
                            prov.setPeticionBorradorMaestro("X");
                            prov.setBloqueoContabilizaionSociedad("");
                            prov.setPeticionBorradorCentral("");
                            if (ACC_Proveedor.ObtenerInstancia().InsertaProvCrea(prov)) {
                                out.println(5); /// Consulta Exitosa
                            } else {
                                out.println(6); /// Error al ejecutar la consulta
                            }
                            break;
                        case 2:
                            proveedor prove = new proveedor();
                            prove.setNombre1(nomProv);
                            prove.setPoblacion(poblacion);
                            prove.setLugarResidencia(recidencia);
                            prove.setCalle(calle);
                            prove.setDistrito(distrito);
                            prove.setNumEdificio(edificio);
                            prove.setNIF(nif);
                            prove.setClaveCondicionesPago(pago);
                            prove.setIndicadorABC(abc);
                            prove.setGrupoCuentasAcreedor(gpoCuenta);
                            prove.setCuentaAsociadaConta(cuentaSo);
                            prove.setMonedaPedido(moneda);
                            prove.setValorMinimoPedido(valor);
                            prove.setIncoPart1(ico1);
                            prove.setIncoPart2(ico2);
                            prove.setClaveControlConfir(config);
                            prove.setGrupoCompras(gpoComp);                    
                            prove.setPeticionBorradorMaestro("");
                            prove.setBloqueoContabilizaionSociedad("X");
                            prove.setPeticionBorradorCentral("");
                            if (ACC_Proveedor.ObtenerInstancia().InsertaProvCrea(prove)) {
                                out.println(5); /// Consulta Exitosa
                            } else {
                                out.println(6); /// Error al ejecutar la consulta
                            }
                            break;
                        case 3:
                            proveedor proved = new proveedor();
                            proved.setNombre1(nomProv);
                            proved.setPoblacion(poblacion);
                            proved.setLugarResidencia(recidencia);
                            proved.setCalle(calle);
                            proved.setDistrito(distrito);
                            proved.setNumEdificio(edificio);
                            proved.setNIF(nif);
                            proved.setClaveCondicionesPago(pago);
                            proved.setIndicadorABC(abc);
                            proved.setGrupoCuentasAcreedor(gpoCuenta);
                            proved.setCuentaAsociadaConta(cuentaSo);
                            proved.setMonedaPedido(moneda);
                            proved.setValorMinimoPedido(valor);
                            proved.setIncoPart1(ico1);
                            proved.setIncoPart2(ico2);
                            proved.setClaveControlConfir(config);
                            proved.setGrupoCompras(gpoComp);
                            proved.setPeticionBorradorMaestro("");
                            proved.setBloqueoContabilizaionSociedad("");
                            proved.setPeticionBorradorCentral("X");
                            if (ACC_Proveedor.ObtenerInstancia().InsertaProvCrea(proved)) {
                                out.println(5); /// Consulta Exitosa
                            } else {
                                out.println(6); /// Error al ejecutar la consulta
                            }
                            break;                
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