/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Equipos_notificaciones;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Ordenes_pm_notificaciones;
import AccesoDatos.ACC_Pm03_3_notificaciones;
import AccesoDatos.ACC_Pm_operaciones_notificaciones;
import AccesoDatos.ACC_Stock;
import AccesoDatos.ACC_Usuarios;
import AccesoDatos.Consultas;
import Entidades.folios;
import Entidades.materiales;
import Entidades.operaciones_ordenes_crea;
import Entidades.pm_operaciones_notificaciones;
import Entidades.stock;
import Entidades.usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "peticionNotificacionesOrdenesSAM", urlPatterns = {"/peticionNotificacionesOrdenesSAM"})
public class peticionNotificacionesOrdenesSAM extends HttpServlet {

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
            String Idioma = (String) session.getAttribute("Idioma");
            String ord = request.getParameter("ord");
            String acc = request.getParameter("acc");
            String nam = request.getParameter("nam");
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("CO");
            int fa = fo.getFolioActual();
            String condicion1 = "CO";
            String orden = request.getParameter("orden");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String ope = request.getParameter("ope");
            pm_operaciones_notificaciones tb = ACC_Pm_operaciones_notificaciones.ObtenerInstancia().INPGRNOTPMNOT(orden, ope);
            operaciones_ordenes_crea orpm = ACC_Orden.ObtenerInstancia().cargartablaoperacionescreaP3NOT(orden);
            String folen = "CO" + fo.getFolioActual();
            String fecont = Consultas.ObtenerInstancia().ObtenerFechaContableMov();
            String usu = request.getParameter("usu");

            switch (acc) {
                case "checarOrden":

                    if (ACC_Ordenes_pm_notificaciones.ObtenerInstancia().COMPORdenNOT(ord) == true) {
                        out.println(0);
                    } else if (ACC_Orden.ObtenerInstancia().COMPFOLORdenNOT(ord) == true) {
                        out.println(2);
                    } else {
                        out.println(1);
                    }
                    break;
                case "CambiFol":

                    if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT(condicion1, fa)) {
                        int foac = fo.getFolioActual();
                        out.println(1 + "," + foac);
                    } else {
                        out.println(0);
                    }
                    break;
                case "GuardCabec":

                    if (ACC_Equipos_notificaciones.ObtenerInstancia().INSERTcabecera_consumos_crea(folen, hora, fecha, tb.getCentro(), orden, usu, fecont)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "GuardCabecORD":
                    if (ACC_Equipos_notificaciones.ObtenerInstancia().INSERTcabecera_consumos_creaORD(folen, hora, fecha, orpm.getCentro(), orden, usu, fecont)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "valotote":
                    String material = request.getParameter("matab");
                    String lote = request.getParameter("lottabp");
                    stock in = ACC_Stock.ObtenerInstancia().ConsultarMateNotifiVAL(material, lote);
                    int mlo = ACC_Material.ObtenerInstancia().ConsultaLoteMaterialNOT(material);

                    if (!material.equals(in.getMaterial())) {
                        if (mlo == 0) {
                            out.println(0);
                        } else if (in.getMaterial() == null) {
                            String queryMate = "select top 1 * from inventarios where material='" + material + "'";
                            stock ine = ACC_Stock.ObtenerInstancia().ConsultarMateNotifi(queryMate);
                            String lotee = ine.getLote();
                            out.println(lotee);

                        }
                    } else {
                        out.println(2);
                    }
                    break;
                case "ACtuadurTra":
                    String nuOrd = request.getParameter("nuOrd");
                    String dutr = request.getParameter("dhm");

                    if (ACC_Pm03_3_notificaciones.ObtenerInstancia().PONACACNOT(dutr, nuOrd)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "CarMatInv":
                    String descn = "descripcion_" + Idioma;
                    String mate = request.getParameter("mate");
                    LinkedList cari = ACC_Material.ObtenerInstancia().CargarTodoMaterialNOT(mate, descn);
                    materiales car = ACC_Material.ObtenerInstancia().CargarMaterialNOT(mate);
                    String matrai = car.getMaterial();
                    if (cari.size() > 0) {
                        out.println(1 + "," + car.getCentro() + "," + car.getUnidad_medida() + "," + car.getSujeto_lote() + "," + car.getDescripcion() + "");
                    } else {
                        out.println(0);
                    }

                    break;
                case "accConsusu":
                    String cant = request.getParameter("cant");
                    ArrayList<usuarios> usua = ACC_Usuarios.ObtenerInstancia().ListaUsuarioNpm1(usu, cant, nam);
                    out.println("<table>");
                    out.println("<tbody>");
                    for (int i = 0; i < usua.size(); i++) {
                        out.println("<tr onclick=\"seleccionar('" + usua.get(i).getUsuario() + "','trrep1','VentanaModalUSU')\">");
                        out.println("<td>" + usua.get(i).getUsuario() + "</td>");
                        out.println("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + usua.get(i).getNombre() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
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
