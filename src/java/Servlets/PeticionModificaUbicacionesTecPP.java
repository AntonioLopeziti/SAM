/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_UbicacionTecnica;
import Entidades.ubicacion_tecnica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jhonatan
 */
@WebServlet(name = "PeticionModificaUbicacionesTecPP", urlPatterns = {"/PeticionModificaUbicacionesTecPP"})
public class PeticionModificaUbicacionesTecPP extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("Action");
            String idUbTec = request.getParameter("idUbTec");
            String clase = request.getParameter("clase");
            String gpoAut = request.getParameter("gpoAut");
            String peso = request.getParameter("peso");
            String nInvent = request.getParameter("nInvent");
            String tamDim = request.getParameter("tamDim");
            String pStaEnSer = request.getParameter("pStaEnSer");
            String cEmplaz = request.getParameter("cEmplaz");
            String emplaz = request.getParameter("emplaz");
            String areaEmp = request.getParameter("areaEmp");
            String ptoTrab = request.getParameter("ptoTrab");
            String indAbc = request.getParameter("indAbc");
            String socied = request.getParameter("socied");
            String actFijo = request.getParameter("actFijo");
            String actFijoDos = request.getParameter("actFijoDos");
            String centro = request.getParameter("centro");
            String sociedadCc = request.getParameter("sociedadCc");
            String centroPlani = request.getParameter("centroPlani");
            String gpoPlanif = request.getParameter("gpoPlanif");
            String ptoTrabRes = request.getParameter("ptoTrabRes");
            String ptoTrabResDos = request.getParameter("ptoTrabResDos");
            String ubtec = request.getParameter("ubtec");

            switch (accion) {
                case "GuardarDatos":
                    ubicacion_tecnica ub = new ubicacion_tecnica();
                    ub.setUbicacion_tecnica(idUbTec);
                    //clase
                    ub.setGrupo_autorizacion(gpoAut);
                    //peso
                    ub.setNum_inventario(nInvent);
                    ub.setTamano_dimension(tamDim);
                    //pStaEnSer
                    ub.setCentro_emplazamiento(cEmplaz);
                    ub.setEmplazamiento_activo_fijo(emplaz);
                    ub.setArea_empresa(areaEmp);
                    ub.setPuesto_trabajo(ptoTrab);
                    ub.setIndicador_abc(indAbc);
                    ub.setCentro_coste(centro);
                    ub.setSociedad(socied);
                    //actFijo
                    //actFijoDos
                    //sociedCC
                    ub.setCentro_planificacion_mante(centroPlani);
                    ub.setGrupo_planificador_servicio_cliente_mante(gpoPlanif);
                    //ub.setPuesto_trabajo(ptoTrabRes);
                    //ptoTabResDos
                    //ubTec
                    if (ACC_UbicacionTecnica.ObtenerInstancia().ModUbTecPP(ub)) {
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
