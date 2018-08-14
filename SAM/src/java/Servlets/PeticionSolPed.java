/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_CrearPedidoSD;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Servicios;
import AccesoDatos.ACC_SolicitudPedidos;
import AccesoDatos.ACC_Textos_cabecera_solped;
import AccesoDatos.ACC_Textos_posiciones_solped;
import AccesoDatos.Conexion;
import AccesoDatos.Consultas;
import Entidades.SolpedCrea;
import Entidades.SolpedServicios;
import Entidades.folios;
import Entidades.textos_posiciones_solped;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

/**
 *
 */
@WebServlet(name = "PeticionSolPed", urlPatterns = {"/PeticionSolPed"})
public class PeticionSolPed extends HttpServlet {

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
            throws ServletException, IOException, SQLException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession ses = request.getSession();
            String user = (String) ses.getAttribute("Usuario");
            String Acc = request.getParameter("Accion");
            String POS = request.getParameter("PO");
            String CDO = request.getParameter("CD");
            String OCO = request.getParameter("OC");
            String GCO = request.getParameter("GC");
            String TIM = request.getParameter("TI");
            String TIP = request.getParameter("TP");
            String MAT = request.getParameter("MA");
            String TBR = request.getParameter("TB");
            String UME = request.getParameter("UM");
            String GAR = request.getParameter("GA");
            String CAN = request.getParameter("CA");
            String FEC = request.getParameter("FE");
            String CEN = request.getParameter("CE");
            String ALM = request.getParameter("AL");
            String SOL = request.getParameter("SO");
            String CMA = request.getParameter("CM");
            String CCO = request.getParameter("CC");
            String ORD = request.getParameter("OR");
            String fila = request.getParameter("fila");
            String fsp = request.getParameter("fsp");
            String ipsf = request.getParameter("ipsf");
            String texps = request.getParameter("texps");
            Consultas con = new Consultas();
            String FechaServidor = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String HoraServidor = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            SolpedCrea s = new SolpedCrea();
            folios fo = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("SP");
            String folioSAM = fo.getIdFolios() + fo.getFolioActual();
            switch (Acc) {
                case "ADD":
                    s.setClase_documento_solped(CDO);
                    s.setNum_posicion_solped(Chepos(POS));
                    s.setOrganizacion_compras(OCO);
                    s.setGrupo_compras(GCO);
                    s.setTipo_imputacion(TIM);
                    s.setTipo_posicion_doc_compras(TIP);
                    s.setNum_material(MAT);
                    s.setTexto_breve(TBR);
                    s.setUnidad_medida_solped(UME);
                    s.setGrupo_articulos(GAR);
                    s.setCantidad_solped(CAN);
                    s.setFecha_entraga_posicion(FEC);
                    s.setCentro(CEN);
                    s.setAlmacen(ALM);
                    s.setSolicitante(SOL);
                    s.setNum_cuenta_mayor(CMA);
                    s.setCentro_coste(CCO);
                    s.setNum_orden(ORD);
                    s.setFecha(FechaServidor);
                    s.setHora_dia(HoraServidor);
                    boolean b = ACC_SolicitudPedidos.ObtenerInstancia().InsertTemporal(s,ipsf);
                    if (b) {
                        ArrayList<SolpedCrea> so = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaTemp(user,ipsf);
                        if (so.size() > 0) {
                            int a;
                            out.println("<table>");
                            out.println("<tbody>");
                            for (a = 0; a < so.size(); a++) {
                                out.println("<tr>");
                                out.println("<td><input class=\"che\" type=\"radio\" name=\"DelPos\"/><input type=\"text\" id=\"posValoSo" + a + "\"  value=\"" + so.get(a).getNum_posicion_solped() + "\" hidden/> </td>");
                                out.println("<td>" + so.get(a).getNum_posicion_solped() + "</td>");
                                out.println("<td>" + so.get(a).getTipo_imputacion() + "</td>");
                                out.println("<td>" + so.get(a).getTipo_posicion_doc_compras() + "</td>");
                                out.println("<td>" + so.get(a).getNum_material() + "</td>");
                                out.println("<td>" + so.get(a).getTexto_breve() + "</td>");
                                out.println("<td>" + so.get(a).getUnidad_medida_solped() + "</td>");
                                out.println("<td>" + so.get(a).getGrupo_articulos() + "</td>");
                                out.println("<td>" + so.get(a).getCantidad_solped() + "</td>");
                                out.println("<td>" + con.DateFormat(so.get(a).getFecha_entraga_posicion()) + "</td>");
                                out.println("<td class=\"tdCentro\">" + so.get(a).getCentro() + "</td>");
                                out.println("<td>" + so.get(a).getAlmacen() + "</td>");
                                out.println("<td>" + so.get(a).getSolicitante() + "</td>");
                                out.println("<td>" + so.get(a).getOrganizacion_compras() + "</td>");
                                out.println("<td>" + so.get(a).getGrupo_compras() + "</td>");
                                out.println("<td>" + so.get(a).getNum_cuenta_mayor() + "</td>");
                                out.println("<td>" + so.get(a).getCentro_coste() + "</td>");
                                out.println("<td>" + so.get(a).getNum_orden() + "</td>");
                                out.println("</tr>");
                            }
                            for (int c = a; c < 10; c++) {
                                out.println("<tr>");
                                for (int l = 0; l < 18; l++) {
                                    out.println("<td>&nbsp;</td>");
                                }
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(1);
                    }
                    break;
                case "UPD":
                    s.setClase_documento_solped(CDO);
                    s.setNum_posicion_solped(Chepos(POS));
                    s.setOrganizacion_compras(OCO);
                    s.setGrupo_compras(GCO);
                    s.setTipo_imputacion(TIM);
                    s.setTipo_posicion_doc_compras(TIP);
                    s.setNum_material(MAT);
                    s.setTexto_breve(TBR);
                    s.setUnidad_medida_solped(UME);
                    s.setGrupo_articulos(GAR);
                    s.setCantidad_solped(CAN);
                    s.setFecha_entraga_posicion(FEC);
                    s.setCentro(CEN);
                    s.setAlmacen(ALM);
                    s.setSolicitante(SOL);
                    s.setNum_cuenta_mayor(CMA);
                    s.setCentro_coste(CCO);
                    s.setNum_orden(ORD);
                    s.setFecha(FechaServidor);
                    s.setHora_dia(HoraServidor);
                    boolean upd = ACC_SolicitudPedidos.ObtenerInstancia().UpdateTemporal(s,ipsf);
                    if (upd) {
                        ArrayList<SolpedCrea> so = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaTemp(user,ipsf);
                        if (so.size() > 0) {
                            int a;
                            out.println("<table>");
                            out.println("<tbody>");
                            for (a = 0; a < so.size(); a++) {
                                out.println("<tr>");
                                out.println("<td><input class=\"che\" type=\"radio\" name=\"DelPos\"/><input type=\"text\" id=\"posValoSo" + a + "\"  value=\"" + so.get(a).getNum_posicion_solped() + "\" hidden/> </td>");
                                out.println("<td>" + so.get(a).getNum_posicion_solped() + "</td>");
                                out.println("<td>" + so.get(a).getTipo_imputacion() + "</td>");
                                out.println("<td>" + so.get(a).getTipo_posicion_doc_compras() + "</td>");
                                out.println("<td>" + so.get(a).getNum_material() + "</td>");
                                out.println("<td>" + so.get(a).getTexto_breve() + "</td>");
                                out.println("<td>" + so.get(a).getUnidad_medida_solped() + "</td>");
                                out.println("<td>" + so.get(a).getGrupo_articulos() + "</td>");
                                out.println("<td>" + so.get(a).getCantidad_solped() + "</td>");
                                out.println("<td>" + con.DateFormat(so.get(a).getFecha_entraga_posicion()) + "</td>");
                                out.println("<td class=\"tdCentro\">" + so.get(a).getCentro() + "</td>");
                                out.println("<td>" + so.get(a).getAlmacen() + "</td>");
                                out.println("<td>" + so.get(a).getSolicitante() + "</td>");
                                out.println("<td>" + so.get(a).getOrganizacion_compras() + "</td>");
                                out.println("<td>" + so.get(a).getGrupo_compras() + "</td>");
                                out.println("<td>" + so.get(a).getNum_cuenta_mayor() + "</td>");
                                out.println("<td>" + so.get(a).getCentro_coste() + "</td>");
                                out.println("<td>" + so.get(a).getNum_orden() + "</td>");
                                out.println("</tr>");
                            }
                            for (int c = a; c < 10; c++) {
                                out.println("<tr>");
                                for (int l = 0; l < 18; l++) {
                                    out.println("<td>&nbsp;</td>");
                                }
                                out.println("</tr>");
                            }
                            out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(2);
                    }
                    break;
                case "DElTEXTPos":
                    ACC_Textos_posiciones_solped.ObtenerInstancia().EliminarModTexto(POS, user,ipsf);
                    break;
                case "SAVETEX":
                    ACC_Textos_posiciones_solped.ObtenerInstancia().InsertartxtPosTemp(Chepos(POS), fila, user, texps,ipsf);
                    break;
                    
                case "GuardarSolped":
                    String retorn = "";
                    int n = 0;
                    ArrayList<SolpedCrea> sl = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaTemp(user,ipsf);
                    ArrayList<SolpedServicios> se = ACC_Servicios.ObtenerInstancia().CargarServicios(user, "0",ipsf);
                    ArrayList<textos_posiciones_solped> t = ACC_Textos_posiciones_solped.ObtenerInstancia().CargarTxtPos(user,ipsf);

                    ACC_SolicitudPedidos.ObtenerInstancia().InsertarSolped(sl, ipsf, HoraServidor,ipsf);
                    ACC_Servicios.ObtenerInstancia().InsertarSolpedServicios(se, ipsf, user, HoraServidor);
                    ACC_Textos_posiciones_solped.ObtenerInstancia().InsertTxtPos(t, ipsf, user);
                 
                    int posSolped = ACC_SolicitudPedidos.ObtenerInstancia().retornposicionesSolped("N", user, ipsf);
                    int posServic = ACC_SolicitudPedidos.ObtenerInstancia().retornposicionesSolped("S", user, ipsf);
                    int postextos = ACC_SolicitudPedidos.ObtenerInstancia().retornposicionesSolped("T", user, ipsf);
                    if (posSolped != sl.size()) {
                        n = 1;  ////// las posiciones normales no coinciden
                    }
                    if (posServic != se.size()) {
                        n = 2; ////// las posiciones servicios no coinciden
                    }
                    if (postextos != t.size()) {
                        n = 3; ////// las posiciones servicios no coinciden
                    }
                    if (n != 0) { 
                        ACC_SolicitudPedidos.ObtenerInstancia().Eliminartablas("", user, "X");
                    } else {
                        ACC_SolicitudPedidos.ObtenerInstancia().Eliminartablas("", user, "");
                    }
                    JSONArray j = new JSONArray();
                    j.add(n);
                    j.add(fsp);
                    out.println(j);
                    break;
                case "RevisarFolio":
                    String ok = ACC_SolicitudPedidos.ObtenerInstancia().CheckFolio(folioSAM);
                    out.println(ok);
                    break;
                case "SAVETEXTCAB":
                    ACC_Textos_cabecera_solped.ObtenerInstancia().InsertTxtCabecera(ipsf, fila, user, texps);
                    break;
                case "FolioAct":
                    String ff = ACC_SolicitudPedidos.ObtenerInstancia().ActualizarFolioss(ipsf);
                    out.println(ff);
                    break;
                case "DeletePos":
                    if (ACC_SolicitudPedidos.ObtenerInstancia().solped_tempDelete(user, POS,ipsf)) {
                        ACC_SolicitudPedidos.ObtenerInstancia().solped_serviciosDelete(user, POS,ipsf);
                        ACC_SolicitudPedidos.ObtenerInstancia().tex_pos_solped_tempDelete(user, POS,ipsf);
                        ArrayList<SolpedCrea> so = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaTemp(user,ipsf);
                        int a;
                        out.println("<table>");
                        out.println("<tbody>");
                        for (a = 0; a < so.size(); a++) {
                            out.println("<tr>");
                            out.println("<td><input class=\"che\" type=\"radio\" name=\"DelPos\"/><input type=\"text\" id=\"posValoSo" + a + "\"  value=\"" + so.get(a).getNum_posicion_solped() + "\" hidden/> </td>");
                            out.println("<td>" + so.get(a).getNum_posicion_solped() + "</td>");
                            out.println("<td>" + so.get(a).getTipo_imputacion() + "</td>");
                            out.println("<td>" + so.get(a).getTipo_posicion_doc_compras() + "</td>");
                            out.println("<td>" + so.get(a).getNum_material() + "</td>");
                            out.println("<td>" + so.get(a).getTexto_breve() + "</td>");
                            out.println("<td>" + so.get(a).getUnidad_medida_solped() + "</td>");
                            out.println("<td>" + so.get(a).getGrupo_articulos() + "</td>");
                            out.println("<td>" + so.get(a).getCantidad_solped() + "</td>");
                            out.println("<td>" + con.DateFormat(so.get(a).getFecha_entraga_posicion()) + "</td>");
                            out.println("<td class=\"tdCentro\">" + so.get(a).getCentro() + "</td>");
                            out.println("<td>" + so.get(a).getAlmacen() + "</td>");
                            out.println("<td>" + so.get(a).getSolicitante() + "</td>");
                            out.println("<td>" + so.get(a).getOrganizacion_compras() + "</td>");
                            out.println("<td>" + so.get(a).getGrupo_compras() + "</td>");
                            out.println("<td>" + so.get(a).getNum_cuenta_mayor() + "</td>");
                            out.println("<td>" + so.get(a).getCentro_coste() + "</td>");
                            out.println("<td>" + so.get(a).getNum_orden() + "</td>");
                            out.println("</tr>");
                        }
                        for (int c = a; c < 10; c++) {
                            out.println("<tr>");
                            for (int l = 0; l < 18; l++) {
                                out.println("<td>&nbsp;</td>");
                            }
                            out.println("</tr>");
                        }
                        out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                        out.println("</tbody>");
                        out.println("</table>");
                    }
                    break;
                case "Reasic":
                    int Tamnua = Integer.parseInt(request.getParameter("NewPos"));
                    ArrayList<SolpedCrea> serv = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaTemp(user,ipsf);
                    int hola = serv.size();
                    for (int i = 0; i < hola; i++) {
                        if (Tamnua == i) {
                            int valn = i + 1;
                            String lon = String.valueOf(valn);
                            if (ACC_SolicitudPedidos.ObtenerInstancia().solped_serviciosUpdate(user, serv.get(i).getNum_posicion_solped(), Chepos(lon),ipsf) == true) {
                                if (ACC_SolicitudPedidos.ObtenerInstancia().solped_tempUpdate(user, serv.get(i).getNum_posicion_solped(), Chepos(lon),ipsf) == true) {
                                    if (ACC_SolicitudPedidos.ObtenerInstancia().tex_pos_solped_tempUpdate(user, serv.get(i).getNum_posicion_solped(), Chepos(lon),ipsf) == true) {
                                        out.println(1);
                                    } else {
                                        out.println(0);
                                    }
                                } else {
                                    out.println(0);
                                }
                            } else if (ACC_SolicitudPedidos.ObtenerInstancia().solped_tempUpdate(user, serv.get(i).getNum_posicion_solped(), Chepos(lon),ipsf) == true) {
                                out.println(1);
                            } else {
                                out.println(0);
                            }
                        }
                    }
                    break;
                case "CargarNuevaPosi":
                    ArrayList<SolpedCrea> so = ACC_SolicitudPedidos.ObtenerInstancia().CargarTablaTemp(user,ipsf);
                    int a;
                    out.println("<table>");
                    out.println("<tbody>");
                    for (a = 0; a < so.size(); a++) {
                        out.println("<tr>");
                        out.println("<td><input class=\"che\" type=\"radio\" name=\"DelPos\"/><input type=\"text\" id=\"posValoSo" + a + "\"  value=\"" + so.get(a).getNum_posicion_solped() + "\" hidden/> </td>");
                        out.println("<td>" + so.get(a).getNum_posicion_solped() + "</td>");
                        out.println("<td>" + so.get(a).getTipo_imputacion() + "</td>");
                        out.println("<td>" + so.get(a).getTipo_posicion_doc_compras() + "</td>");
                        out.println("<td>" + so.get(a).getNum_material() + "</td>");
                        out.println("<td>" + so.get(a).getTexto_breve() + "</td>");
                        out.println("<td>" + so.get(a).getUnidad_medida_solped() + "</td>");
                        out.println("<td>" + so.get(a).getGrupo_articulos() + "</td>");
                        out.println("<td>" + so.get(a).getCantidad_solped() + "</td>");
                        out.println("<td>" + con.DateFormat(so.get(a).getFecha_entraga_posicion()) + "</td>");
                        out.println("<td class=\"tdCentro\">" + so.get(a).getCentro() + "</td>");
                        out.println("<td>" + so.get(a).getAlmacen() + "</td>");
                        out.println("<td>" + so.get(a).getSolicitante() + "</td>");
                        out.println("<td>" + so.get(a).getOrganizacion_compras() + "</td>");
                        out.println("<td>" + so.get(a).getGrupo_compras() + "</td>");
                        out.println("<td>" + so.get(a).getNum_cuenta_mayor() + "</td>");
                        out.println("<td>" + so.get(a).getCentro_coste() + "</td>");
                        out.println("<td>" + so.get(a).getNum_orden() + "</td>");
                        out.println("</tr>");
                    }
                    for (int c = a; c < 10; c++) {
                        out.println("<tr>");
                        for (int l = 0; l < 18; l++) {
                            out.println("<td>&nbsp;</td>");
                        }
                        out.println("</tr>");
                    }
                    out.println("<tr class=\"ocultar\"><td>0000</td><td>00000000</td><td>0000000</td><td>0000000</td><td>000000000000000000000000000000000</td><td>00000000000000000000000000000000000000000000000000000000000000000000000</td><td>00000000</td><td>0000000000000000</td><td>0000000000000</td><td>00000000000000000</td><td>0000000000</td><td>000000000000000</td><td>00000000000000</td><td>00000000000000000</td><td>0000000000000000000</td><td>00000000000000000</td><td>00000000000000000</td><td>00000000000000000</td></tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    break;
            }
        }
    }

    public String Chepos(String data) {
        int valor = Integer.parseInt(data);
        String i = data;
        if (i.length() == 5) {
            return i;
        }
        if (valor < 10) {
            i = "000" + data + "0";
        }
        if (valor >= 10 && valor < 100) {
            i = "00" + data + "0";
        }
        if (valor >= 100 && valor < 1000) {
            i = "0" + data + "0";
        }
        if (valor >= 1000 && valor < 10000) {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSolPed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PeticionSolPed.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PeticionSolPed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PeticionSolPed.class.getName()).log(Level.SEVERE, null, ex);
        }
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
