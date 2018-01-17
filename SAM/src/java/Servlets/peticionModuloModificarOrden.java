
package Servlets;

import AccesoDatos.ACC_Cabecera_ordenes_crea;
import Entidades.cabecera_ordenes_crea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "peticionModuloModificarOrden", urlPatterns = {"/peticionModuloModificarOrden"})
public class peticionModuloModificarOrden extends HttpServlet {

    public String checkEmptyOpe(String data) {
        String answer;
        if (data == null) {
            answer = "";
        } else {
            answer = data;
        }
        return answer;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Accion = request.getParameter("acc");
            String ordVal = request.getParameter("ordVal");
            String modPl = request.getParameter("modPlm");
            String modOr = request.getParameter("modOrd");
            String modTx = request.getParameter("modTxtB");
            String modNA = request.getParameter("modAcO");
            String check;
            switch (Accion) {
                case "validarOrden":
                    check = ACC_Cabecera_ordenes_crea.ObtenerInstancia().ValidarOrden(ordVal);
                    out.println(check);
                    break;
                case "ConsultaModOrden":
                    ArrayList<cabecera_ordenes_crea> modOrd = ACC_Cabecera_ordenes_crea.ObtenerInstancia().ConsultaMatchOrden(modPl,modOr,modTx,modNA);
                    if (modOrd.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < modOrd.size(); i++) {
                            out.println("<tr ondblclick=\"select('Orden','" + modOrd.get(i).getFolio_sam() + "');\">");
                            out.println("<td>" + modOrd.get(i).getCentro_planificacion_mantenimiento() + "</td>");
                            out.println("<td>" + modOrd.get(i).getFolio_sam() + "</td>");
                            out.println("<td>" + modOrd.get(i).getTexto_breve() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
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
