/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Zebra;
import AccesoDatos.Consultas;
import AccesoDatos.EnvioDatosEtiqueta;
import Entidades.Zebra_noti_PT;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author music
 */
@WebServlet(name = "peticionReporteEtiquetas", urlPatterns = {"/peticionReporteEtiquetas"})
public class peticionReporteEtiquetas extends HttpServlet {

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
            String Action = request.getParameter("Action");
            String Tipo = request.getParameter("Tipo");
            String Var = request.getParameter("Var");
            String Orden = request.getParameter("Orden");
            String SAM = request.getParameter("SAM");
            String Puesto = request.getParameter("Puesto");
            String Fecha = request.getParameter("Fecha");
            
            /////// Imprimir Etiquetas
            String ORD = request.getParameter("ORD");
            String FSA = request.getParameter("FSA");
            String PTO = request.getParameter("PTO");
            String FEC = request.getParameter("FEC");
            String HOR = request.getParameter("HOR");
            String LOT = request.getParameter("LOT");
            String ANC = request.getParameter("ANC");
            String CAN = request.getParameter("CAN");
            String UME = request.getParameter("UME");
            String CLI = request.getParameter("CLI");
            String DES = request.getParameter("DES");
            String MAT = request.getParameter("MAT");
            String RUT = request.getParameter("RUT");
            String STO = request.getParameter("STO");
            switch (Action) {
                case "ValidarDatos":
                    int x = ACC_Zebra.ObtenerInstancia().ValidarDatos(Tipo, Var);
                    out.println(x);
                    break;
                case "ConsultaOrden":
                    ArrayList<Zebra_noti_PT> Or = ACC_Zebra.ObtenerInstancia().ConsultaOrdenReporte();
                    if (Or.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < Or.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + Or.get(i).getOrden() + "','ORDEN')\">");
                            out.println("<td>" + Or.get(i).getOrden() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "Consultasam":
                    ArrayList<Zebra_noti_PT> sa = ACC_Zebra.ObtenerInstancia().ConsultaSAMReporte();
                    if (sa.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sa.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + sa.get(i).getFol_sam() + "','SAM')\">");
                            out.println("<td>" + sa.get(i).getFol_sam() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultaPuesto":
                    ArrayList<Zebra_noti_PT> pt = ACC_Zebra.ObtenerInstancia().ConsultaPuestoReporte();
                    if (pt.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pt.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + pt.get(i).getPuesto_trabajo() + "','PTO')\">");
                            out.println("<td>" + pt.get(i).getPuesto_trabajo() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarQuery":
                    ArrayList<Zebra_noti_PT> tab = ACC_Zebra.ObtenerInstancia().CargarTablaEtiqueta(Orden, SAM, Puesto, Consultas.ObtenerInstancia().DateFormatGuion(Fecha));
                    if (tab.size() > 0) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "CargarTabla":
                    ArrayList<Zebra_noti_PT> t = ACC_Zebra.ObtenerInstancia().CargarTablaEtiqueta(Orden, SAM, Puesto,  Consultas.ObtenerInstancia().DateFormatGuion(Fecha));
                    out.println("<table id=\"TabBody\">");
                    out.println("<tbody>");
                    for (Zebra_noti_PT rs : t) {
                        out.println("<tr>");
                        out.println("<td><input type=\"checkbox\" style\"width:80%\" name=\"tdChb\" id=\"chke\"/></td>");
                        out.println("<td name=\"tdOrden\">" + rs.getOrden() + "</td>");
                        out.println("<td name=\"tdSAM\">" + rs.getFol_sam() + "</td>");
                        out.println("<td name=\"tdPuesto\">" + rs.getPuesto_trabajo() + "</td>");
                        out.println("<td name=\"tdCliente\">" + rs.getCliente() + "</td>");
                        out.println("<td name=\"tdfecha\"'>" + Consultas.ObtenerInstancia().DateFormat(rs.getFecha()) + "</td>");
                        out.println("<td name=\"tdhora\">" + rs.getHora() + "</td>");
                        out.println("<td name=\"tdmaterial\">" + rs.getNro_material() + "</td>");
                        out.println("<td name=\"tddesc\">" + rs.getDescripcion() + "</td>");
                        out.println("<td name=\"tdtdlote\">" + rs.getLote() + "</td>");
                        out.println("<td name=\"tdcanti\">" + rs.getCantidad() + "</td>");
                        out.println("<td name=\"tdume\">" + rs.getUm() + "</td>");
                        out.println("<td name=\"tdancho\">" + rs.getAncho() + "</td>");
                        out.println("<td name=\"tdruta\">" + rs.getRuta() + "</td>");
                        out.println("<td name=\"tdstock\">" + rs.getStock() + "</td>");
                        out.println("<td name=\"tdstock\">" + rs.getClmovi() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\">"
                            + "<td>00000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>000000000000000000</td>"
                            + "<td>000000000000000000000000000000000000000000000000</td>"
                            + "<td>0000000000000</td>"
                            + "<td>00000000000</td>"
                            + "<td>0000000000000000000000000000</td>"
                            + "<td>00000000000000000000000000000000000000000000000000000</td>"
                            + "<td>0000000000000000000</td>"
                            + "<td>00000000000000000</td>"
                            + "<td>00000000</td>"
                            + "<td>00000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>000000000000</td>"
                            + "<td>0000000000</td>"
                            + "</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
                case "Imprimir":
                    String FECF = Consultas.ObtenerInstancia().DateFormatGuion(FEC);
                    Zebra_noti_PT zb = new Zebra_noti_PT();
                    zb.setOrden(ORD);
                    zb.setPuesto_trabajo(PTO);
                    zb.setFol_sam(FSA);
                    zb.setLote(LOT);
                    zb.setAncho(ANC);
                    zb.setFecha(FECF.replace("-", "/"));
                    zb.setHora(HOR);
                    zb.setCantidad(CAN);
                    zb.setUm(UME);
                    zb.setCliente(CLI);
                    zb.setDescripcion(DES);
                    zb.setNro_material(MAT);
                    zb.setRuta(RUT);
                    zb.setStock(STO);
                    String[] prop = ACC_Zebra.ObtenerInstancia().getImp(PTO);
                    String Dir = prop[0];
                    String tipo = prop[1];
                    String[] pa = Dir.split("-");
                    String Ip = pa[0];
                    String Imp = pa[1];
                     String CodigoEnviar = "";
                    if (tipo.trim().equals("1")) {
                        CodigoEnviar = ACC_Zebra.ObtenerInstancia().ConvertCodeZebraTLP(zb);
                    } else {
                        CodigoEnviar = ACC_Zebra.ObtenerInstancia().ConvertCodeZebra(zb);
                    }
                    String env = CodigoEnviar + "<>" + Imp;
                    EnvioDatosEtiqueta en = new EnvioDatosEtiqueta();
                    String rs = en.EnviarDatosSocket(env, Ip);
                    out.println(Integer.parseInt(rs));
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
