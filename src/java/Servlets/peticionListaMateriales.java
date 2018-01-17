/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_ListaMateriales;
import AccesoDatos.Consultas;
import Entidades.ListaMateriales;
import Entidades.centros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(name = "peticionListaMateriales", urlPatterns = {"/peticionListaMateriales"})
public class peticionListaMateriales extends HttpServlet {

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
            HttpSession ses = request.getSession();
            String lan = (String) ses.getAttribute("Idioma");
            String Acc = request.getParameter("Accion");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String material = request.getParameter("material");
            String material2 = request.getParameter("material2");
            String centro = request.getParameter("centro");
            String almacen = request.getParameter("almacen");
            String proveedor = request.getParameter("proveedor");
            String clase = request.getParameter("clase");
            String fecha = request.getParameter("fecha");
            Consultas con = new Consultas();
            switch (Acc) {
                case "ConsultarMateriales":
                    ArrayList<ListaMateriales> mate = ACC_ListaMateriales.ObtenerInstancia().ConsultaMCMateriales(v1, v2, lan);
                    if (mate.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (v3.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(v3); i++) {
                                out.println("<tr ondblclick=\"SelectData('" + mate.get(i).getMaterial() + "','material','VentanaModalMaterial','BuscarParamMaterial','ConsultaTablaMaterial','matename')\">");
                                out.println("<td>" + mate.get(i).getMaterial() + "</td>");
                                out.println("<td>" + mate.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < mate.size(); i++) {
                                out.println("<tr ondblclick=\"SelectData('" + mate.get(i).getMaterial() + "','material','VentanaModalMaterial','BuscarParamMaterial','ConsultaTablaMaterial','matename')\">");
                                out.println("<td>" + mate.get(i).getMaterial() + "</td>");
                                out.println("<td>" + mate.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarMateriales2":
                    ArrayList<ListaMateriales> mate2 = ACC_ListaMateriales.ObtenerInstancia().ConsultaMCMateriales(v1, v2, lan);
                    if (mate2.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (v3.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(v3); i++) {
                                out.println("<tr ondblclick=\"SelectData('" + mate2.get(i).getMaterial() + "','material2','VentanaModalMaterial2','BuscarParamMaterial2','ConsultaTablaMaterial2','matename2')\">");
                                out.println("<td>" + mate2.get(i).getMaterial() + "</td>");
                                out.println("<td>" + mate2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < mate2.size(); i++) {
                                out.println("<tr ondblclick=\"SelectData('" + mate2.get(i).getMaterial() + "','material2','VentanaModalMaterial2','BuscarParamMaterial2','ConsultaTablaMaterial2','matename2')\">");
                                out.println("<td>" + mate2.get(i).getMaterial() + "</td>");
                                out.println("<td>" + mate2.get(i).getDescripcion() + "</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarCentro":
                    ArrayList<ListaMateriales> cet = ACC_ListaMateriales.ObtenerInstancia().ConsultaMCCentros();

                    if (cet.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cet.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + cet.get(i).getCentro() + "','centro','VentanaModalCentro','','','')\">");
                            out.println("<td>" + cet.get(i).getCentro() + "</td>");
                            out.println("<td>" + cet.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "ConsultarAlmacen":
                    ArrayList<ListaMateriales> alm = ACC_ListaMateriales.ObtenerInstancia().ConsultaMCAlmacen(lan);

                    if (alm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < alm.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + alm.get(i).getAlmacen() + "','almacen','VentanaModalAlmacen','','','')\">");
                            out.println("<td>" + alm.get(i).getAlmacen() + "</td>");
                            out.println("<td>" + alm.get(i).getDescr_alm() + "</td>");
                            out.println("<td>" + alm.get(i).getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "ConsultarProveedor":
                    ArrayList<ListaMateriales> pro = ACC_ListaMateriales.ObtenerInstancia().ConsultaMCProveedores(v1, v2);
                    if (pro.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        if (v3.length() > 0) {
                            for (int i = 0; i < Integer.parseInt(v3); i++) {
                                out.println("<tr ondblclick=\"SelectData('" + pro.get(i).getProveedor() + "','proveedor','VentanaModalProveedor','','','')\">");
                                out.println("<td>" + pro.get(i).getProveedor() + "</td>");
                                out.println("<td>" + pro.get(i).getNombre_prov() + "</td>");
                                out.println("</tr>");
                            }
                        } else {
                            for (int i = 0; i < pro.size(); i++) {
                                out.println("<tr ondblclick=\"SelectData('" + pro.get(i).getProveedor() + "','proveedor','VentanaModalProveedor','','','')\">");
                                out.println("<td>" + pro.get(i).getProveedor() + "</td>");
                                out.println("<td>" + pro.get(i).getNombre_prov() + "</td>");
                                out.println("</tr>");
                            }
                        }

                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarClase":
                    ArrayList<ListaMateriales> clas = ACC_ListaMateriales.ObtenerInstancia().ConsultaMCClase();
                    if (clas.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < clas.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + clas.get(i).getClase_movimiento() + "','clase','VentanaModalClaseM','','','')\">");
                            out.println("<td>" + clas.get(i).getClase_movimiento() + "</td>");
                            out.println("<td>" + clas.get(i).getDescr_clase() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        out.println("</tbody>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarMaterial":
                    int m = ACC_ListaMateriales.ObtenerInstancia().ValidarMaterial(material);
                    out.println(m);
                    break;
                case "ValidarCentro":
                    int c = ACC_ListaMateriales.ObtenerInstancia().ValidarCentro(centro);
                    out.println(c);
                    break;
                case "ValidarAlmacen":
                    int a = ACC_ListaMateriales.ObtenerInstancia().ValidarAlmacen(almacen);
                    out.println(a);
                    break;
                case "ValidarProveedor":
                    int p = ACC_ListaMateriales.ObtenerInstancia().ValidarProveedor(proveedor);
                    out.println(p);
                    break;
                case "ValidarClase":
                    int cm = ACC_ListaMateriales.ObtenerInstancia().ValidarClase(clase);
                    out.println(cm);
                    break;
                case "ValidarQuery":
                    String df = con.DateFormatGuion(fecha);
                    String[] data = {material, material2, centro, almacen, clase, proveedor, df, lan};
                    int dd = ACC_ListaMateriales.ObtenerInstancia().ValidarQuery(data);
                    int md = ACC_ListaMateriales.ObtenerInstancia().ValidarQuery2(data);
                    int nh = dd + md;
                    out.println(nh);
                    break;
                case "CargarTabla":
                    String dfc = con.DateFormatGuion(fecha);
                    String[] data1 = {material, material2, centro, almacen, clase, proveedor, dfc, lan};
                    ArrayList<ListaMateriales> lm = ACC_ListaMateriales.ObtenerInstancia().CargarTabla(data1);
                    ArrayList<ListaMateriales> lm2 = ACC_ListaMateriales.ObtenerInstancia().CargarTabla2(data1);
                    ArrayList<ListaMateriales> lmf = new ArrayList<>();
                    lm.addAll(lm2);
                    lmf.addAll(lm);
                    Collections.sort(lmf, new Comparator<ListaMateriales>() {
                        public int compare(ListaMateriales o1, ListaMateriales o2) {
                            return o1.getFecha_contable().compareTo(o2.getFecha_contable());
                        }
                    });
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (int x = 0; x < lmf.size(); x++) {
                        out.println("<tr ondblclick=\"Select('" + lmf.get(x).getNum_doc_compras() + "', '" + lm.get(x).getFolio_sam() + "');\">");
                        out.println("<td>" + lmf.get(x).getMaterial() + "</td>");
                        out.println("<td>" + lmf.get(x).getDescripcion() + "</td>");
                        out.println("<td>" + lmf.get(x).getCentro() + "</td>");
                        out.println("<td>" + lmf.get(x).getAlmacen() + "</td>");
                        out.println("<td>" + con.DateFormat(lmf.get(x).getFecha_contable()) + "</td>");
                        out.println("<td>" + lmf.get(x).getClase_movimiento() + "</td>");
                        out.println("<td>" + lmf.get(x).getAlmacen_destino() + "</td>");
                        out.println("<td>" + lmf.get(x).getIndicador_stock() + "</td>");
                        out.println("<td>" + lmf.get(x).getNum_doc_compras() + "</td>");
                        out.println("<td>" + lmf.get(x).getFolio_sam() + "</td>");
                        out.println("<td>" + lmf.get(x).getNum_posicion_comp() + "</td>");
                        out.println("<td>" + lmf.get(x).getProveedor() + "</td>");
                        out.println("<td>" + lmf.get(x).getNombre_prov() + "</td>");
                        out.println("<td>" + lmf.get(x).getCantidad() + "</td>");
                        out.println("<td>" + lmf.get(x).getUm() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>00000000000000000</td>"
                            + "<td>000000000000000000000000000000000</td>"
                            + "<td>00000000</td>"
                            + "<td>00000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>00000000000000000</td>"
                            + "<td>00000000000000000</td>"
                            + "<td>0000</td>"
                            + "<td>000000000000000000000</td>"
                            + "<td>000000000000000</td>"
                            + "<td>00000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>000000000000000000000000000000000</td>"
                            + "<td>00000000000000000000000</td>"
                            + "<td>00000</td>"
                            + "</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
            }
        }
    }

    public int compare(ListaMateriales o1, ListaMateriales o2) {
        return o1.getFecha_contable().compareTo(o2.getFecha_contable());
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
