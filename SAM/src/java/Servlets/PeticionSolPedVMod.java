/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Servicios;
import AccesoDatos.ACC_SolicitudPedidos;
import AccesoDatos.Conexion;
import AccesoDatos.Consultas;
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
 * @author Antonio
 */
@WebServlet(name = "PeticionSolPedVMod", urlPatterns = {"/PeticionSolPedVMod"})
public class PeticionSolPedVMod extends HttpServlet {

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
            HttpSession ses = request.getSession();
            String us = (String) ses.getAttribute("Usuario");
            String Action = request.getParameter("Action");
            String Posici = request.getParameter("PosN");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");
            String v7 = request.getParameter("v7");
            String v8 = request.getParameter("v8");
            String v9 = request.getParameter("v9");
            String v10 = request.getParameter("v10");
            String posdel = request.getParameter("Pos");
            String solped = request.getParameter("Solped");
            switch (Action) {
                case "GuardaServicio":
                    String FechaServidor = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
                    String HoraServidor = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
                    ACC_Servicios.ObtenerInstancia().InsertarServiciosTempMod(Posici, v10, v1, FechaServidor, HoraServidor, v5, v2, v3, v4, v6, v7, v8, v9, us, solped);
                    break;
                case "DElTEXTSERV":
                    ACC_Servicios.ObtenerInstancia().EliminarPosSerTemporalMod(us, posdel, solped);
                    break;
            }
//            String Posici = request.getParameter("PosN");
//            String FolSAM = request.getParameter("Folio");
//            String v1 = request.getParameter("v1");
//            String v2 = request.getParameter("v2");
//            String v3 = request.getParameter("v3");
//            String v4 = request.getParameter("v4");
//            String v5 = request.getParameter("v5");
//            String v6 = request.getParameter("v6");
//            String v7 = request.getParameter("v7");
//            String v8 = request.getParameter("v8");
//            String v9 = request.getParameter("v9");
//            String v10 = request.getParameter("v10");
////            String ElmiPos = "DELETE FROM solped_servicios_crea_"+us+" WHERE folio_sam = '"+FolSAM+"' AND num_posicion_solped = '"+Posici+"' AND SolicitanteTemp ='"+us+"' ";
////            String que = "SELECT COUNT (SolicitanteTemp) as SolicitanteTemp from solped_crea where SolicitanteTemp = '" + us + "' AND folio_sam = ''";
////            int posAct = ACC_SolicitudPedidos.ObtenerInstancia().VerificarPosSolped(que) + 1;
//            switch (Action) {
//                case "GuardaServicio":
////                    Consultas.ObtenerInstancia().ExecuteQuery(ElmiPos);
//                     String InsertSer = "INSERT INTO solped_servicios_crea_"+us+" ("
//                    + "folio_sam,"
//                    + "num_posicion_solped,"
//                    + "num_posicion_solped2,"
//                    + "num_servicio,"
//                    + "fecha,"
//                    + "hora_dia,"
//                    + "texto_breve,"
//                    + "cantidad,"
//                    + "unidad_medida_base,"
//                    + "cantidad_base,"
//                    + "precio_bruto,"
//                    + "grupo_articulos,"
//                    + "num_cuenta_mayor,"
//                    + "centro_coste,"
//                    + "num_orden,"
//                    + "num_solped,"
//                    + "recibido,"
//                    + "procesado,"
//                    + "modificado,"
//                    + "error,"
//                    + "solicitante,"
//                    + "SolicitanteTemp) values("
//                    + "'"+FolSAM+"',"
//                    + "'" + Posici + "',"
//                    + "'" + v10 + "',"
//                    + "'" + v1 + "',"
//                    + "'',"
//                    + "'',"
//                    + "'" + v5 + "',"
//                    + "'" + v2 + "',"
//                    + "'" + v3 + "',"
//                    + "'1',"
//                    + "'" + v4 + "',"
//                    + "'" + v6 + "',"
//                    + "'" + v7 + "', "
//                    + "'" + v8 + "', "
//                    + "'" + v9 + "', "
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'" + us + "',"
//                    + "'" + us + "')";
//                   Consultas.ObtenerInstancia().ExecuteQuery(InsertSer); 
//                    break;
//            }
//             Conexion cnx = new Conexion();
//            HttpSession ses = request.getSession();
//            String us = (String) ses.getAttribute("Usuario");
//            String solped = request.getParameter("Solped");
//            String PosSolped = request.getParameter("PosicionNormal");
//            String PosServicio = request.getParameter("Posicionservice");
//            String Servicio = request.getParameter("Servicio");
//            String Cantidad = request.getParameter("Cantidad");
//            String UnMedida = request.getParameter("UnidadM");
//            String Precio = request.getParameter("Precio");
//            String Descripcion = request.getParameter("Descripcion");
//            String Fecha = request.getParameter("Fecha");
//            String GrupoArt = request.getParameter("GrupoArticulos");
//            String CuentaM = request.getParameter("CuentaMayor");
//            String CentroCoste = request.getParameter("CentroCoste");
//            String NumOrden = request.getParameter("num_orde");
//            String CantPrecio = request.getParameter("CantidadPrecio");
//             String query = "SELECT COUNT (SolicitanteTemp) as SolicitanteTemp from solped_crea_"+us+" where  folio_sam = '"+solped+"'";
//            int posAct = ACC_SolicitudPedidos.ObtenerInstancia().VerificarPosSolped(query) + 1;
//            String InsertSer = "INSERT INTO solped_servicios_crea_"+us+" ("
//                    + "folio_sam,"
//                    + "num_posicion_solped,"
//                    + "num_posicion_solped2,"
//                    + "num_servicio,"
//                    + "fecha,"
//                    + "hora_dia,"
//                    + "texto_breve,"
//                    + "cantidad,"
//                    + "unidad_medida_base,"
//                    + "cantidad_base,"
//                    + "precio_bruto,"
//                    + "grupo_articulos,"
//                    + "num_cuenta_mayor,"
//                    + "centro_coste,"
//                    + "num_orden,"
//                    + "num_solped,"
//                    + "recibido,"
//                    + "procesado,"
//                    + "modificado,"
//                    + "error,"
//                    + "solicitante,"
//                    + "SolicitanteTemp) values("
//                    + "'"+solped+"',"
//                    + "'" + Chepos(posAct) + "',"
//                    + "'" + PosServicio + "',"
//                    + "'" + Servicio + "',"
//                    + "'" + Fecha + "',"
//                    + "'',"
//                    + "'" + Descripcion + "',"
//                    + "'" + Cantidad + "',"
//                    + "'" + UnMedida + "',"
//                    + "'" + CantPrecio + "',"
//                    + "'" + Precio + "',"
//                    + "'" + GrupoArt + "',"
//                    + "'" + CuentaM + "', "
//                    + "'" + CentroCoste + "', "
//                    + "'" + NumOrden + "', "
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'" + us + "',"
//                    + "'" + us + "')";
//            String InsertSer2 = "INSERT INTO solped_servicios_crea_"+us+" ("
//                    + "folio_sam,"
//                    + "num_posicion_solped,"
//                    + "num_posicion_solped2,"
//                    + "num_servicio,"
//                    + "fecha,"
//                    + "hora_dia,"
//                    + "texto_breve,"
//                    + "cantidad,"
//                    + "unidad_medida_base,"
//                    + "cantidad_base,"
//                    + "precio_bruto,"
//                    + "grupo_articulos,"
//                    + "num_cuenta_mayor,"
//                    + "centro_coste,"
//                    + "num_orden,"
//                    + "num_solped,"
//                    + "recibido,"
//                    + "procesado,"
//                    + "modificado,"
//                    + "error,"
//                    + "solicitante,"
//                    + "SolicitanteTemp) values("
//                    + "'"+solped+"',"
//                    + "'" + PosSolped + "',"
//                    + "'" + PosServicio + "',"
//                    + "'" + Servicio + "',"
//                    + "'" + Fecha + "',"
//                    + "'',"
//                    + "'" + Descripcion + "',"
//                    + "'" + Cantidad + "',"
//                    + "'" + UnMedida + "',"
//                    + "'" + CantPrecio + "',"
//                    + "'" + Precio + "',"
//                    + "'" + GrupoArt + "',"
//                    + "'" + CuentaM + "', "
//                    + "'" + CentroCoste + "', "
//                    + "'" + NumOrden + "', "
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'',"
//                    + "'" + us + "',"
//                    + "'" + us + "')";
//            String condicion = "num_posicion_solped='" + PosSolped + "' AND num_posicion_solped2='" + PosServicio + "' AND folio_sam='"+solped+"'";
//            String tabla = "solped_servicios_crea_"+us+"";
//            String campos = "num_servicio='" + Servicio + "',"
//                    + "fecha='" + Fecha + "',"
//                    + "texto_breve='" + Descripcion + "',"
//                    + "cantidad='" + Cantidad + "',"
//                    + "cantidad_base='" + CantPrecio + "',"
//                    + "unidad_medida_base='" + UnMedida + "',"
//                    + "precio_bruto='" + Precio + "',"
//                    + "grupo_articulos='" + GrupoArt + "',"
//                    + "num_cuenta_mayor='" + CuentaM + "',"
//                    + "centro_coste='" + CentroCoste + "',"
//                    + "num_orden='" + NumOrden + "',"
//                    + "error =''";
//
//            if (PosSolped == null || PosSolped == "") {
//                if (Consultas.ObtenerInstancia().Insert(InsertSer)) {
//                    out.println(1);
//                }
//            } else if (PosSolped != null || PosSolped != "") {
//                String queryCheposSer = "SELECT * FROM solped_servicios_crea_"+us+" WHERE folio_sam='"+solped+"' AND num_posicion_solped='" + PosSolped + "' AND num_posicion_solped2='" + PosServicio + "'";
//                if (ACC_SolicitudPedidos.ObtenerInstancia().ChecarposiServicPosNormal(queryCheposSer)) {
//                    if (Consultas.ObtenerInstancia().Update(tabla, campos, condicion)) {
//                        out.println(1);
//                    } else if (Consultas.ObtenerInstancia().Insert(InsertSer2)) {
//                        out.println(1);
//                    }
//
//                } else if (Consultas.ObtenerInstancia().Insert(InsertSer2)) {
//                    out.println(1);
//                }
//            }

        }
    }

    public String Chepos(int data) {
        String i = String.valueOf(data);
        if (data < 10) {
            i = "000" + data + "0";
        }
        if (data >= 10 && data < 100) {
            i = "00" + data + "0";
        }
        if (data >= 100 && data < 1000) {
            i = "0" + data + "0";
        }
        if (data >= 1000 && data < 10000) {
            i = data + "0";
        }
        return i;
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
