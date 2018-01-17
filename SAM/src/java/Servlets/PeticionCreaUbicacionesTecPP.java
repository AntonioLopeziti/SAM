/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import Entidades.ubicacion_tecnica;
import AccesoDatos.ACC_UbicacionTecnica;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Are-Consulting
 */
@WebServlet(name = "PeticionCreaUbicacionesTecPP", urlPatterns = {"/PeticionCreaUbicacionesTecPP"})
public class PeticionCreaUbicacionesTecPP extends HttpServlet {

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
            String idUbTec = request.getParameter("idUbTec");
            String clase = request.getParameter("clase");
            String gpoAutor = request.getParameter("gpoAutor");
            String peso = request.getParameter("peso");
            String nInven = request.getParameter("nInvent");
            String tamDim = request.getParameter("tamDim");
            String pStaEnSer = request.getParameter("pStaEnSer");
            String cEmplza = request.getParameter("cEmplaz");
            String emplaz = request.getParameter("emplaz");
            String areaEmpl = request.getParameter("areaEmp");
            String ptoTrab = request.getParameter("ptoTrab");
            String abc = request.getParameter("indAbc");
            String centro = request.getParameter("centro");
            String socied = request.getParameter("socied");
            String actFijo = request.getParameter("actFijo");
            String actFijoDos = request.getParameter("actFijoDos");
            String sociedCC = request.getParameter("sociedCC");
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
                    ub.setGrupo_autorizacion(gpoAutor);
                    //peso
                    ub.setNum_inventario(nInven);
                    ub.setTamano_dimension(tamDim);
                    //pStaEnSer
                    ub.setCentro_emplazamiento(cEmplza);
                    ub.setEmplazamiento_activo_fijo(emplaz);
                    ub.setArea_empresa(areaEmpl);
                    ub.setPuesto_trabajo(ptoTrab);
                    ub.setIndicador_abc(abc);
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
                    if (ACC_UbicacionTecnica.ObtenerInstancia().InsertaUbTecPP(ub)) {
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
