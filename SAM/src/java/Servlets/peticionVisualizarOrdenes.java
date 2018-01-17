package Servlets;

import AccesoDatos.ACC_OperacionesOrdenesCrea;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Plan_Op;
import AccesoDatos.ACC_ServiciosOrdenesCrea;
import AccesoDatos.ACC_ServiciosOrdenesCreaVis;
import AccesoDatos.ACC_ServiciosPM;
import Entidades.componentes;
import Entidades.operaciones_ordenes_crea;
import Entidades.plan_orden;
import Entidades.planop;
import Entidades.servicios_ordenes_crea;
import Entidades.servicios_ordenes_crea_vis;
import Entidades.servicios_pm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AREConsulting
 */
@WebServlet(name = "peticionVisualizarOrdenes", urlPatterns = {"/peticionVisualizarOrdenes"})
public class peticionVisualizarOrdenes extends HttpServlet {

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
            String Accion = request.getParameter("acc");
            String orden = request.getParameter("ord");
            String texto = request.getParameter("texto");
            String Cant = request.getParameter("ctd");

            String clave = request.getParameter("Clave");
            String or = request.getParameter("NumOr");
            String opera = request.getParameter("Ope");
            String check;
            switch (Accion) {
                case "ValidarOrden":
                    check = ACC_Orden.ObtenerInstancia().ValidarOrdenType(orden);
                    out.println(check);
                    break;
                case "ConsultarOrdenes":
                    ArrayList<plan_orden> pl = ACC_Orden.ObtenerInstancia().ConsultaMatchOrdenes(orden, texto, Cant);
                    if (pl.size() > 0) {
                        try {
                            int limite = Integer.parseInt(Cant);
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < limite; i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + pl.get(i).getNum_orden() + "', '" + pl.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + pl.get(i).getNum_orden() + "</td>");
                                out.println("<td>" + pl.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + pl.get(i).getTexto_breve() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } catch (Exception e) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int i = 0; i < pl.size(); i++) {
                                out.println("<tr ondblclick=\"seleccionar('" + pl.get(i).getNum_orden() + "', '" + pl.get(i).getFolio_sam() + "')\">");
                                out.println("<td>" + pl.get(i).getNum_orden() + "</td>");
                                out.println("<td>" + pl.get(i).getFolio_sam() + "</td>");
                                out.println("<td>" + pl.get(i).getTexto_breve() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;

            }

        }
    }

    public boolean IsNumeric(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
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
