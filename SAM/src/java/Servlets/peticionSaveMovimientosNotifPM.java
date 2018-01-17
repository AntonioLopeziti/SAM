/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Pm_operaciones_notificaciones;
import AccesoDatos.ACC_Posiciones_consumos_crea;
import AccesoDatos.ACC_Stock;
import AccesoDatos.Consultas;
import Entidades.folios;
import Entidades.pm_operaciones_notificaciones;
import Entidades.stock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionSaveMovimientosNotifPM", urlPatterns = {"/peticionSaveMovimientosNotifPM"})
public class peticionSaveMovimientosNotifPM extends HttpServlet {

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
            HttpSession session = request.getSession();

            String idio = (String) session.getAttribute("Idioma");
            String material = request.getParameter("matab");
            Double cantidad = Double.parseDouble(request.getParameter("cumtabp"));
            String lote = request.getParameter("lotabp");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String usu = request.getParameter("usu");
            String ope = request.getParameter("ope");
            String orden = request.getParameter("orden");

            pm_operaciones_notificaciones tb = ACC_Pm_operaciones_notificaciones.ObtenerInstancia().INPGRNOTPM(orden, ope);

            stock in = ACC_Stock.ObtenerInstancia().ConsultarMateNotifiPM(material,lote);
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("CO");

            Double resu = Double.parseDouble(in.getStocklibre_utilizacion()) - cantidad;
            String res2 = resu+"00"; 
            int fa = fo.getFolioActual() + 1;
            String te;
            String accion = request.getParameter("accion");
            if ("ES".equals(idio)) {
                te = in.getDescripcion_ES();
            } else {
                te = in.getDescripcion_EN();
            }
            
            String foli ="CO" + fo.getFolioActual(); 
            int posi = ACC_Posiciones_consumos_crea.ObtenerInstancia().RetornPosis(foli) + 1;
                                 
            switch (accion) {
                
                case "uardarDAt":
                    
                        if (ACC_Posiciones_consumos_crea.ObtenerInstancia().INSERTposiciones_consumos_crea(foli,hora,fecha,orden,lote,in.getUnidad_medida(),cantidad,te,material,in.getCentro(),posi)) {
                            if (ACC_Posiciones_consumos_crea.ObtenerInstancia().UPDATEINVETA(res2,cantidad,material,lote)) {
                                out.println(0);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }
                    
                    break;
                case "uardarDAtOR":
                    if (ACC_Posiciones_consumos_crea.ObtenerInstancia().INSERTposiciones_consumos_creaORD(foli,hora,fecha,orden,lote,in.getUnidad_medida(),cantidad,te,material,in.getCentro(),posi)) {
                            if (ACC_Posiciones_consumos_crea.ObtenerInstancia().UPDATEINVETA(res2,cantidad,material,lote)) {
                                out.println(0);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }
                    break;
                default:
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
