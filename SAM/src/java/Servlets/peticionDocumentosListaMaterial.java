/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Almacenes;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Proveedor;
import AccesoDatos.ACC_Stock;
import AccesoDatos.ACC_TipoMovimientos;
import Entidades.Almacen;
import Entidades.centros;
import Entidades.materiales;
import Entidades.proveedor;
import Entidades.tipo_movimiento;
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
 */
@WebServlet(name = "peticionDocumentosListaMaterial", urlPatterns = {"/peticionDocumentosListaMaterial"})
public class peticionDocumentosListaMaterial extends HttpServlet {

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
            HttpSession session = request.getSession();

            String Accion = request.getParameter("Accion");
            String Ctd = request.getParameter("Ctd");
            String Idioma = request.getParameter("Idioma");
            ///Material
            String Material = request.getParameter("Material");
            String TextoMat = request.getParameter("TextoMat");
            String select = request.getParameter("s");

            // Centro 
            String Centro = request.getParameter("Centro");
            //Almacen
            String Almacen = request.getParameter("Almacen");
            //Proveedor
            String Nombre = request.getParameter("Nombre");
            String Poblacion = request.getParameter("Poblacion");
            String Acredor = request.getParameter("Acreedor");
            // Clase 
            String Clase = request.getParameter("ClaseM");

            //    Accion = "ConsultarClasesM";
//            Idioma = "ES";
//            select = "lol";
//             Pasar Atributos
            String materialS = request.getParameter("MATERIAL");
            String material2S = request.getParameter("MATERIAL2");
            String centroS = request.getParameter("CENTRO");
            String almacenS = request.getParameter("ALMACEN");
            String loteS = request.getParameter("LOTE");
            String proveedorS = request.getParameter("PROVEEDOR");
            String clasemS = request.getParameter("CLASEM");
            String cantidadS = request.getParameter("CANTIDAD");
            String fecha = request.getParameter("FECHACON");
            String maa = request.getParameter("s");

            session.setAttribute("MiMaterial", materialS);
            session.setAttribute("MiMaterial2", material2S);
            session.setAttribute("MiCentro", centroS);
            session.setAttribute("MiAlmacen", almacenS);
            session.setAttribute("MiLote", loteS);
            session.setAttribute("MiProveedor", proveedorS);
            session.setAttribute("MiClaseM", clasemS);
            session.setAttribute("MiCantidad", cantidadS);
            session.setAttribute("MiFecha", fecha);

            //Variables de validaciones
            String matt = request.getParameter("MATR");
            String cntr = request.getParameter("CNT");
            String alm = request.getParameter("ALM");
            String lot = request.getParameter("LOT");
            String pr = request.getParameter("PROV");
            String tp = request.getParameter("TIPMOV");

            LinkedList<materiales> m;
            int limMat;
            switch (Accion) {
                case "ConsultarMateriales":
                    String desMat = "descripcion_" + Idioma;
                    limMat = Integer.parseInt(Ctd);
                    m = ACC_Material.ObtenerInstancia().ConsultaMatMatch(Material, TextoMat, Ctd, desMat);
                    if (m.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < m.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + m.get(i).getMaterial() + "','" + maa + "')\" >");
                            out.println("<td>" + m.get(i).getMaterial() + "</td>");
                            out.println("<td>" + m.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + m.get(i).getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarProveedores":
                    int limProv = Integer.parseInt(Ctd);
                    LinkedList<proveedor> p = ACC_Proveedor.ObtenerInstancia().MuestraMatchProveedor(Nombre, Poblacion, Acredor, limProv);
                    if (p.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < p.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + p.get(i).getIdProveedor() + "','Proveedor')\" >");
                            out.println("<td>" + p.get(i).getIdProveedor() + "</td>");
                            out.println("<td>" + p.get(i).getNombre1() + "</td>");
                            out.println("<td>" + p.get(i).getPoblacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;

                case "ConsultarCentros":
                    if (Centro == null) {
                        Centro = "";
                    }
                    ArrayList<centros> c = ACC_Centro.ObtenerInstancia().MM_MatchCentro();
                    if (c.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < c.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + c.get(i).getCentro() + "','Centro')\" >");
                            out.println("<td>" + c.get(i).getCentro() + "</td>");
                            out.println("<td>" + c.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;

                case "ConsultarAlmacenes":
                    if (Almacen == null) {
                        Almacen = "";
                    }
                    String desAlm = "descripcion_" + Idioma;
                    LinkedList<Almacen> a = ACC_Almacenes.ObtenerInstancia().MatchAlmacen(desAlm);
                    if (a.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < a.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + a.get(i).getId_almacen() + "','Almacen')\" >");
                            out.println("<td>" + a.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + a.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + a.get(i).getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");

                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarClasesM":
                    if (Clase == null) {
                        Clase = "";
                    }
                    LinkedList<tipo_movimiento> cl = ACC_TipoMovimientos.ObtenerInstancia().MuestraMatchTipoMovimientos();
                    if (cl.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cl.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + cl.get(i).getid_tipo_mov() + "','ClaseM')\" >");
                            out.println("<td>" + cl.get(i).getid_tipo_mov() + "</td>");
                            out.println("<td>" + cl.get(i).getdescripcion_mov() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");

                    } else {
                        out.println(0);
                    }
                    break;

                case "ConsultarFiltro":
                    String queryAll = "SELECT DISTINCT * FROM movimientos WHERE clase_movimiento LIKE '" + Clase + "%' ";

//                    LinkedList<movimientos> a = ACC_;
//                    if (a.size() > 0) {
//                        out.println("<table>");
//                        out.println("<tbody>");
//                        for (int i = 0; i < a.size(); i++) {
//                            out.println("<tr ondblclick=\"Select('" + a.get(i).getId_almacen() + "','Almacen')\" >");
//                            out.println("<td>" + a.get(i).getId_almacen() + "</td>");
//                            out.println("<td>" + a.get(i).getDescripcion() + "</td>");
//                            out.println("<td>" + a.get(i).getCentro() + "</td>");
//                            out.println("</tr>");
//                        }
//                        out.println("</tbody>");
//                        out.println("</table>");
//
//                    } else {
//                        out.println(0);
//                    }
                    break;
                case "ValidarMaterial":
                    if (ACC_Material.ObtenerInstancia().ValidaMaterial(matt) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarCentro":
                    if (ACC_Centro.ObtenerInstancia().ValidaCampoCentro(cntr) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarAlmacen":
                    if (ACC_Almacenes.ObtenerInstancia().ValidaCampoAlmacen(alm) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarLote":
//                    String kures = "SELECT lote FROM MM.inventarios WHERE  lote = '" + lot + "'";
//                    if (ACC_Stock.ObtenerInstancia().ValidarLOT(kures)) {
//                        out.println(1);
//                    } else {
//                        out.println(0);
//                    }
                    break;
                case "ValidarProveedor":
                    if (ACC_Proveedor.ObtenerInstancia().ValidaCampoProveedor(pr) == true) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarTipoMov":
                    if (ACC_TipoMovimientos.ObtenerInstancia().ValidaCampoTipoMovimiento(tp) == true) {
                        out.println(1);
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
