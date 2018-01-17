/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CaracteristicasLotePM;
import Entidades.caracteristicasLotePM;
import Entidades.decision_empleo_lote_crea;
import Entidades.inspeccion_codigos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author Panda
 */
@WebServlet(name = "PatecionNotificacionesCmb", urlPatterns = {"/PatecionNotificacionesCmb"})
public class PatecionNotificacionesCmb extends HttpServlet {

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
            String accion = request.getParameter("accion");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            
            switch(accion){
                case "getDataEQ":
                    //v1 -> material, v2 -> lote
                    caracteristicasLotePM cl = ACC_CaracteristicasLotePM.ObtenerInstacia().ConsultaMCAlmacenSolped(v1, v2);
                    JSONArray js = new JSONArray();
                    js.add(cl.getEstatus_montaje());
                    js.add(cl.getNum_equipo());
                    js.add(cl.getFecha_montaje());
                    js.add(cl.getFecha_desmontaje());
                    js.add(cl.getUltima_medicion());
                    js.add(cl.getVal_over());
                    out.println(js);
                    break;
                case "getDataCod":
                    inspeccion_codigos cd = ACC_CaracteristicasLotePM.ObtenerInstacia().consultaCodigo(v1, v2);
                    JSONArray jj = new JSONArray();
                    jj.add(cd.getGrupo_codigos());
                    jj.add(cd.getDescripcion());
                    out.println(jj);
                    break;
                case "getDataDE":
                    decision_empleo_lote_crea de = ACC_CaracteristicasLotePM.ObtenerInstacia().consultaDE(v1);
                    JSONArray je = new JSONArray();
                    je.add(de.getCodigo_decision_empleo());
                    je.add(de.getGrupo_codigo_decision_empleo());
                    je.add(de.getTexto_mensaje());
                    out.println(je);
                    break;
                case "getDataDEcap":
                    decision_empleo_lote_crea dec = ACC_CaracteristicasLotePM.ObtenerInstacia().consultaDECap(v1);
                    JSONArray jec = new JSONArray();
                    jec.add(dec.getCodigo_decision_empleo());
                    jec.add(dec.getGrupo_codigo_decision_empleo());
                    jec.add(dec.getTexto_mensaje());
                    out.println(jec);
                    break;
                case "ValidaOrdenCon":
                    JSONArray jc = new JSONArray();
                    jc.add(ACC_CaracteristicasLotePM.ObtenerInstacia().validaNotificacion(v1));
                    jc.add(ACC_CaracteristicasLotePM.ObtenerInstacia().validaNotificacion2(v1));
                    out.println(jc);
                    break;
                case "ValidaUserDE":
                    out.println(ACC_CaracteristicasLotePM.ObtenerInstacia().validaUserDE(v1));
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
