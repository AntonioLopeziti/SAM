/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CrearPedidoSD;
import AccesoDatos.ACC_Folios;
import AccesoDatos.Consultas;
import Entidades.Sector;
import Entidades.canal_distribucion;
import Entidades.clase_pedido_sd;
import Entidades.clientes;
import Entidades.folios;
import Entidades.grupo_vendedores;
import Entidades.materiales_venta;
import Entidades.oficina_ventas;
import Entidades.organizacion_ventas;
import Entidades.unidades_medida;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "peticionPedidoSDCrear", urlPatterns = {"/peticionPedidoSDCrear"})
public class peticionPedidoSDCrear extends HttpServlet {

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
            String Accion = request.getParameter("Accion");
            String Denom = request.getParameter("DescripcionCPedido");
            String Canti = request.getParameter("Ctd");
            String GpoVen = request.getParameter("GpoV");
            String Materi = request.getParameter("Material");
            String client = request.getParameter("Cliente");
            String nombre = request.getParameter("Nombre");
            String variable = request.getParameter("variable");
            String tipo = request.getParameter("tipo");
            String org = request.getParameter("org");
            String canal = request.getParameter("canal");
            String sector = request.getParameter("sector");
            String solic = request.getParameter("solicitante");
            String desti = request.getParameter("destinatario");

            ////// Variables de guardado  /////
            String CLASE = request.getParameter("CLASE");
            String ORGVE = request.getParameter("ORGVE");
            String CANAL = request.getParameter("CANAL");
            String SECTO = request.getParameter("SECTO");
            String GRUPV = request.getParameter("GRUPV");
            String OFICV = request.getParameter("OFICV");
            String FECHE = request.getParameter("FECHE");
            String FECHP = request.getParameter("FECHP");
            String REFCL = request.getParameter("REFCL");
            String USUAR = request.getParameter("USUAR");
            String SOLIC = request.getParameter("SOLIC");
            String DESTI = request.getParameter("DESTI");
            String MATER = request.getParameter("MATER");
            String DESCR = request.getParameter("DESCR");
            String UNIDA = request.getParameter("UNIDA");
            String CANTI = request.getParameter("CANTI");
            String POSIC = request.getParameter("POSIC");
            String FILA = request.getParameter("FILA");
            String POS = request.getParameter("POS");
            String TEXTOCAB = request.getParameter("TEXTOCAB");
            String TEXTPOS = request.getParameter("TEXTPOS");
            String FechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String HoraActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("PV");
            String folioSAM = fo.getIdFolios() + fo.getFolioActual();
            switch (Accion) {
                case "ConsultarClasePedido":
                    ArrayList<clase_pedido_sd> cpe = ACC_CrearPedidoSD.ObtenerInstancia().GetClasePedido();
                    if (cpe.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cpe.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + cpe.get(i).getClase_documento_ventas() + "','VentanaModalClasePedido','ClasePedido')\" >");
                            out.println("<td>" + cpe.get(i).getClase_documento_ventas() + "</td>");
                            out.println("<td>" + cpe.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "ConsultarClientes":
                    ArrayList<clientes> cli = ACC_CrearPedidoSD.ObtenerInstancia().GetClientes(client, nombre, Canti);
                    if (cli.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cli.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + cli.get(i).getIdCliente() + "','VentanaModalCliente','BuscarParDeudores','ConsultaTablaDeudores','Deudor')\" >");
                            out.println("<td>" + cli.get(i).getIdCliente() + "</td>");
                            out.println("<td>" + cli.get(i).getNombre1() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrgVentas":
                    ArrayList<organizacion_ventas> orgv = ACC_CrearPedidoSD.ObtenerInstancia().GetOrgVentas();
                    if (orgv.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < orgv.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + orgv.get(i).getOrganizacion_ventas() + "','VentanaModalOrgVentas','orgVentas')\" >");
                            out.println("<td>" + orgv.get(i).getOrganizacion_ventas() + "</td>");
                            out.println("<td>" + orgv.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarCanalDis":
                    ArrayList<canal_distribucion> cana = ACC_CrearPedidoSD.ObtenerInstancia().GetCanalDistribucion();
                    if (cana.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < cana.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + cana.get(i).getCanal_distribucion() + "','VentanaModalCanalDist','CanalDis')\" >");
                            out.println("<td>" + cana.get(i).getOrganizacion_ventas() + "</td>");
                            out.println("<td>" + cana.get(i).getCanal_distribucion() + "</td>");
                            out.println("<td>" + cana.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarSector":
                    ArrayList<Sector> sect = ACC_CrearPedidoSD.ObtenerInstancia().GetSector();
                    if (sect.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < sect.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + sect.get(i).getSector() + "','VentanaModalSector','Sector')\" >");
                            out.println("<td>" + sect.get(i).getSector() + "</td>");
                            out.println("<td>" + sect.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOficinaVentas":
                    ArrayList<oficina_ventas> ofic = ACC_CrearPedidoSD.ObtenerInstancia().GetOficinaVentas();
                    if (ofic.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ofic.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarData('" + ofic.get(i).getOficina_ventas() + "','VentanaModalOficinaVentas','OficinaVentas')\" >");
                            out.println("<td>" + ofic.get(i).getOficina_ventas() + "</td>");
                            out.println("<td>" + ofic.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarGpoVendedores":
                    ArrayList<grupo_vendedores> gpo = ACC_CrearPedidoSD.ObtenerInstancia().GetGrupoVendedores(GpoVen, Denom, Canti);
                    if (gpo.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < gpo.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + gpo.get(i).getGrupo_vendedores() + "','VentanaModalGrpoVend','BuscarParGpovend','ConsultaTablaGpoVend','GpoVendedores')\" >");
                            out.println("<td>" + gpo.get(i).getGrupo_vendedores() + "</td>");
                            out.println("<td>" + gpo.get(i).getDenominacion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarUnidadMedida":
                    ArrayList<unidades_medida> ume = ACC_CrearPedidoSD.ObtenerInstancia().GetUnidadMedida();
                    if (ume.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ume.size(); i++) {
                            out.println("<tr ondblclick=\"SeleccionarDataGrid('" + ume.get(i).getUnidad_medida() + "','VentanaModalUMedida','tdUmedi')\" >");
                            out.println("<td>" + ume.get(i).getUnidad_medida() + "</td>");
                            out.println("<td>" + ume.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarMateriales":
                    ArrayList<materiales_venta> mat = ACC_CrearPedidoSD.ObtenerInstancia().GetMateriales(Materi, Denom, Canti);
                    if (mat.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < mat.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + mat.get(i).getMaterial() + "','VentanaModalMateriales','BuscarParMateriales','ConsultaTablaMateriales','tdMater')\" >");
                            out.println("<td>" + mat.get(i).getMaterial() + "</td>");
                            out.println("<td>" + mat.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "CargarCliente":
                    String[] car = ACC_CrearPedidoSD.ObtenerInstancia().CargarCliente(client);
                    if (car[0] == null || car[0] == "") {
                        out.println(0);
                    } else {
                        String AreVent = car[3] + " " + car[5] + " " + car[7];
                        JSONArray j = new JSONArray();
                        j.add(car[0]);
                        j.add(car[1]);
                        j.add(car[2]);
                        j.add(car[4]);
                        j.add(car[6]);
                        j.add(AreVent);
                        out.println(j);
                    }
                    break;
                case "Cargardenominacion":
                    String denomi = ACC_CrearPedidoSD.ObtenerInstancia().denominacion(variable, tipo);
                    out.println(denomi);
                    break;
                case "ValidarMaterial":
                    materiales_venta ma = ACC_CrearPedidoSD.ObtenerInstancia().getDMat(Materi, org, canal, sector);
                    if (ma.getMaterial() == null || ma.getMaterial() == "") {
                        out.println(0);
                    } else {
                        JSONArray ja = new JSONArray();
                        ja.add(ma.getMaterial());
                        ja.add(ma.getDescripcion());
                        ja.add(ma.getUnidad_medida_base());
                        out.println(ja);
                    }
                    break;
                case "ObtenerTextoEmba":
                    String texto = ACC_CrearPedidoSD.ObtenerInstancia().GetTextoComercial(Materi, org, sector);
                    out.println(texto);
                    break;

                case "ValidarInterlocutor":
                    int a = ACC_CrearPedidoSD.ObtenerInstancia().ValidarInterlocutor(solic, desti);
                    out.println(a);
                    break;
                case "Guardarcabacera":
                    String FECHAENT = Consultas.ObtenerInstancia().DateFormatGuion(FECHE);
                    String FECHAPRE = Consultas.ObtenerInstancia().DateFormatGuion(FECHP);
                    ACC_CrearPedidoSD.ObtenerInstancia().InsertarCabecera1(folioSAM, CLASE, ORGVE, CANAL, SECTO, GRUPV, OFICV, FECHAENT, FECHAPRE, REFCL, USUAR, FechaActual, HoraActual);
                    ACC_CrearPedidoSD.ObtenerInstancia().GuardarCliente(folioSAM, SOLIC, "AG", USUAR, FechaActual, HoraActual);
                    ACC_CrearPedidoSD.ObtenerInstancia().GuardarCliente(folioSAM, DESTI, "WE", USUAR, FechaActual, HoraActual);
                    break;
                case "GuardarPosiciones":
                    int POSDO = Integer.parseInt(POSIC) + 1;
                    String POSFIN = String.valueOf(POSDO) + "0";
                    ACC_CrearPedidoSD.ObtenerInstancia().GuardarMateriales(folioSAM, POSFIN, MATER, DESCR, UNIDA, USUAR, FechaActual, HoraActual);
                    ACC_CrearPedidoSD.ObtenerInstancia().GuardarCantidades(folioSAM, POSFIN, CANTI, USUAR, FechaActual, HoraActual);
                    break;
                case "ActaulizarFolio":
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("PV", fo.getFolioActual());
                    out.println(folioSAM);
                    break;
                case "GuardarTextCab":
                    ACC_CrearPedidoSD.ObtenerInstancia().InsertTxtCabecera(folioSAM, FILA, USUAR, TEXTOCAB, FechaActual, HoraActual);
                    break;
                case "GuardarTextPos":
                    int POSTXT = Integer.parseInt(POS) + 1;
                    String POSTF = String.valueOf(POSTXT) + "0";
                    ACC_CrearPedidoSD.ObtenerInstancia().InsertTxtPosicion(folioSAM, POSTF, FILA, USUAR, TEXTPOS, FechaActual, HoraActual);
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
