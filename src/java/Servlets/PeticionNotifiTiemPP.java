/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.Consultas;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Ordenes_pp_notificaciones;
import AccesoDatos.ACC_PP03_Notificaciones;
import Entidades.folios;
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
@WebServlet(name = "PeticionNotifiTiemPP", urlPatterns = {"/PeticionNotifiTiemPP"})
public class PeticionNotifiTiemPP extends HttpServlet {

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
            String ord = request.getParameter("ord");
            String ope = request.getParameter("ope");
            String nf = request.getParameter("nf");
            String fenot = request.getParameter("fenot");
            String honot = request.getParameter("honot");
            String durp1 = request.getParameter("durp1");
            String durp2 = request.getParameter("durp2");
            String trrep1 = request.getParameter("trrep1");
            String nofip1 = request.getParameter("nofip1");
            String usu = request.getParameter("usu");
            String fecco = Consultas.ObtenerInstancia().ObtenerFechaContableMov();
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("NO");
            int fa = fo.getFolioActual();
            String condicion1 = "NO";
            String folpnc = "NO" + fo.getFolioActual();
            String folicn = "NO" + fo.getFolioActual();

            if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().POSNOCRE_INSERTAPP(folpnc, ord, ope, honot, fenot, durp1, trrep1, nf, nofip1, durp2) == true) {
                if (ACC_Ordenes_pp_notificaciones.ObtenerInstancia().CANOCRE_INSERTAPP(folicn, ord, ope, honot, fenot, fecco, trrep1)) {
                    if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOTPP(condicion1, fa)) {
                        out.println(0 + ",NO" + fo.getFolioActual());
                        if ("X".equals(nf)) {
                            if (ACC_PP03_Notificaciones.ObtenerInstancia().PONActualPP("X", ord, ope)) {
                                out.println(0 + ",NO" + fo.getFolioActual());
                            } else {
                                out.println(1);

                            }
                        } else if ("".equals(nf)) {
                            if (ACC_PP03_Notificaciones.ObtenerInstancia().PONActualPP("", ord, ope)) {
                                out.println(0 + ",NO" + fo.getFolioActual());
                            } else {
                                out.println(1);
                            }
                        }
                    } else {
                        out.println(1);
                    }
                } else {
                    out.println(1);
                }
            } else {
                out.println(1);
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
