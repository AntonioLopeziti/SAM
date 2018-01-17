/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_MonitorStatus;
import AccesoDatos.ACC_MonitorStatusCont2;
import AccesoDatos.Consultas;
import Entidades.MonitorStatus;
import Entidades.MonitorStatusCont2;
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
 * @author Panda
 */
@WebServlet(name = "PeticionMonitorStatusCont2", urlPatterns = {"/PeticionMonitorStatusCont2"})
public class PeticionMonitorStatusCont2 extends HttpServlet {

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
            String Language = (String) session.getAttribute("Idioma");
            String Tabla = request.getParameter("val");
            String Modo = request.getParameter("modo");
            String Centro = request.getParameter("ct");
            String Ubitec = request.getParameter("ub");
            String Equipo = request.getParameter("eq");
            String Jerarq = request.getParameter("jr");
            String SFI = request.getParameter("sf");
            String op = request.getParameter("caso");
            String eq = request.getParameter("equipo");
            String Rquery = request.getParameter("");
            String Equipo2 = request.getParameter("eq2");
            String pue = request.getParameter("pue");
            Consultas con = new Consultas();

            //String modo, String centro, String ubitec, String equipo, String jerarq, String sfi
            switch (op) {
                case "uno":
                    int c;
                    String input;
                    LinkedList<MonitorStatus> Msc;
                    if(Equipo2.equals("")){
                        Msc = ACC_MonitorStatus.ObtenerInstancia().ConsultaRelacion(Modo, Centro, Ubitec, Equipo, Jerarq, SFI, Equipo2, pue);
                    }else{
                        Msc = ACC_MonitorStatus.ObtenerInstancia().ConsultaRelacion(Modo, Centro, Ubitec, Equipo, Jerarq, SFI, Equipo2, pue);
                    }

                    if (Tabla == null || Tabla == "") {
                        if (Language.equals("ES")) {
                            //Tabla Principal
                            out.println("<table id='tablauno' class=\"TablaCont\">\n"
                                    + "                            <thead>\n"
                                    + "                                <tr id=\"CabeceraTabla\">\n"
                                    + "                                    <td>&nbsp;</td>\n"
                                    + "                                    <td>Nivel</td>\n"
                                    + "                                    <td>Status</td>\n"
                                    + "                                    <td>Equipo&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>Denominación&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>Contador</td>\n"
                                    + "                                    <td>St.Contador</td>\n"
                                    + "                                    <td>Últ.Med.Anexada</td>\n"
                                    + "                                    <td>StatusContador</td>\n"
                                    + "                                    <td>UMC</td>\n"
                                    + "                                    <td>Ubicación</td>\n"
                                    + "                                    <td>Material</td>\n"
                                    + "                                    <td>Centro</td>\n"
                                    + "                                    <td>No.Serie</td>\n"
                                    + "                                    <td>Almacén</td>\n"
                                    + "                                    <td>Lote</td>\n"
                                    + "                                </tr>\n"
                                    + "                            </thead>\n"
                                    + "                            <tbody>\n");
                            for (c = 0; c < Msc.size(); c++) {
                                if (Msc.get(c).getDoc_medicion().equals("")) {
                                    input = "&nbsp;";
                                } else {
                                    input = "<input id=\"rbt\" onclick=\"carghar()\" type=\"radio\" name=\"monitor\" value=" + Msc.get(c).getEquipo() + " " + Msc.get(c).getJerarquia() + "\">";
                                }
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>" + input + "</td>"
                                        + "<td>" + Msc.get(c).getNivel() + "</td>"
                                        + "<td><img src='images/" + Msc.get(c).getElem_ref_pmps().replace("\\", "") + ".PNG' /></td>"
                                        + "<td>" + Msc.get(c).getEquipo() + "</td>"
                                        + "<td>" + Msc.get(c).getDen_objtec() + "</td>"
                                        + "<td>" + Msc.get(c).getPunto_medida() + "</td>"
                                        + "<td>" + Msc.get(c).getDoc_medicion() + "</td>"
                                        + "<td>" + Msc.get(c).getUlt_med_anexada() + "</td>"
                                        + "<td>" + Msc.get(c).getStatus_contador() + "</td>"
                                        + "<td>" + Msc.get(c).getUnidad_medida_entradadoc() + "</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>" + Msc.get(c).getMaterial() + "</td>"
                                        + "<td>" + Msc.get(c).getCentro() + "</td>"
                                        + "<td>" + Msc.get(c).getSerie() + "</td>"
                                        + "<td>" + Msc.get(c).getAlmacen() + "</td>"
                                        + "<td>" + Msc.get(c).getLote() + "</td>"
                                        + "</tr>");
                            }
                            for (int i = c; i < 10; i++) {
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.print("</tbody>"
                                    + "                              </table>");

                            //Tabla Secundaria
                            out.println("<br><table id='tablados' class=\"TablaCont\">\n"
                                    + "                            <thead>\n"
                                    + "                                <tr id=\"CabeceraTabla\">\n"
                                    + "                                    <td>&nbsp;</td>\n"
                                    + "                                    <td>Nivel</td>\n"
                                    + "                                    <td>ICONO</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Equipo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fec.Ord.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OrdenPM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DenominaciónEquipo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TextoPlan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ItemPlan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                </tr>\n"
                                    + "                            </thead>\n"
                                    + "                            <tbody>\n");
                            for (c = 0; c < Msc.size(); c++) {
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            for (int i = c; i < 10; i++) {
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.print("</tbody>"
                                    + "                              </table>");
                        } else {
                            //Tabla Principal
                            out.println("<table id='tablauno' class=\"TablaCont\">\n"
                                    + "                            <thead>\n"
                                    + "                                <tr id=\"CabeceraTabla\">\n"
                                    + "                                    <td>&nbsp;</td>\n"
                                    + "                                    <td>Level</td>\n"
                                    + "                                    <td>Status</td>\n"
                                    + "                                    <td>Equipment&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>Denomination&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>Counter</td>\n"
                                    + "                                    <td>St.Counter</td>\n"
                                    + "                                    <td>LastMea.Annexed</td>\n"
                                    + "                                    <td>CounterStatus</td>\n"
                                    + "                                    <td>UMC</td>\n"
                                    + "                                    <td>Ubication</td>\n"
                                    + "                                    <td>Material</td>\n"
                                    + "                                    <td>Center</td>\n"
                                    + "                                    <td>No.Serie</td>\n"
                                    + "                                    <td>Stock</td>\n"
                                    + "                                    <td>Lot/td>\n"
                                    + "                                </tr>\n"
                                    + "                            </thead>\n"
                                    + "                            <tbody>\n");
                            for (c = 0; c < Msc.size(); c++) {
                                if (Msc.get(c).getDoc_medicion().equals("")) {
                                    input = "&nbsp;";
                                } else {
                                    input = "<input id=\"rbt\" type=\"radio\" name=\"monitor\" onclick=\"carghar()\" value=" + Msc.get(c).getEquipo() + " " + Msc.get(c).getJerarquia() + "\">";
                                }
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>" + input + "</td>"
                                        + "<td>" + Msc.get(c).getNivel() + "</td>"
                                        + "<td><img src='images/" + Msc.get(c).getElem_ref_pmps().replace("\\", "") + ".PNG' /></td>"
                                        + "<td>" + Msc.get(c).getEquipo() + "</td>"
                                        + "<td>" + Msc.get(c).getDen_objtec() + "</td>"
                                        + "<td>" + Msc.get(c).getPunto_medida() + "</td>"
                                        + "<td>" + Msc.get(c).getDoc_medicion() + "</td>"
                                        + "<td>" + Msc.get(c).getUlt_med_anexada() + "</td>"
                                        + "<td>" + Msc.get(c).getStatus_contador() + "</td>"
                                        + "<td>" + Msc.get(c).getUnidad_medida_entradadoc() + "</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>" + Msc.get(c).getMaterial() + "</td>"
                                        + "<td>" + Msc.get(c).getCentro() + "</td>"
                                        + "<td>" + Msc.get(c).getSerie() + "</td>"
                                        + "<td>" + Msc.get(c).getAlmacen() + "</td>"
                                        + "<td>" + Msc.get(c).getLote() + "</td>"
                                        + "</tr>");
                            }
                            for (int i = c; i < 10; i++) {
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.print("</tbody>"
                                    + "                              </table>");

                            //Tabla Secundaria
                            out.println("<table id='tablados' class=\"TablaCont\">\n"
                                    + "                            <thead>\n"
                                    + "                                <tr id=\"CabeceraTabla\">\n"
                                    + "                                    <td>&nbsp;</td>\n"
                                    + "                                    <td>Level</td>\n"
                                    + "                                    <td>ICONO</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Equipo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DateOrder&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OrderPM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DenominationEquipment&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TextPlan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ItemPlan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                </tr>\n"
                                    + "                            </thead>\n"
                                    + "                            <tbody>\n");
                            for (c = 0; c < Msc.size(); c++) {
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            for (int i = c; i < 10; i++) {
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.print("</tbody>"
                                    + "                              </table>");
                        }
                    }
                    break;

                case "dos":
                    int c1;
                    String input1;
                    String var;

                    LinkedList<MonitorStatus> Msc1 = ACC_MonitorStatus.ObtenerInstancia().ConsultaRelacion(Modo, Centro, Ubitec, Equipo, Jerarq, SFI, Equipo2, pue);

                    LinkedList<MonitorStatusCont2> MscJ1 = ACC_MonitorStatusCont2.ObtenerInstancia().ConsultaMonitorStatus2(eq);
                    if (Tabla == null || Tabla == "") {
                        if (Language.equals("ES")) {
                            //Tabla Secundaria
                            out.println("<table id='tablados' class=\"TablaCont\">\n"
                                    + "                            <thead>\n"
                                    + "                                <tr id=\"CabeceraTabla\">\n"
                                    + "                                    <td>&nbsp;</td>\n"
                                    + "                                    <td>Nivel</td>\n"
                                    + "                                    <td>ICONO</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Equipo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fec.Ord.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OrdenPM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DenominaciónEquipo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TextoPlan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ItemPlan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                </tr>\n"
                                    + "                            </thead>\n"
                                    + "                            <tbody>\n");

                            for (c1 = 0; c1 < MscJ1.size(); c1++) {

                                if (MscJ1.get(c1).getNum_orden().equals("")) {
                                    input1 = "&nbsp;";
                                } else {
                                    input1 = "<input id=\"rbt\" type=\"radio\" name=\"mon\" value='" + MscJ1.get(c1).getNum_orden() + "'\">";
                                }
                                //Si la fecha es igual a cero, no pintar el semaforo
                                if (MscJ1.get(c1).getInicio_programado().equals("0000-00-00")) 
                                {
                                    var = "";  
                                } else 
                                {
                                    var = "<img src='images/" + MscJ1.get(c1).getElem_referencia_pm_ps().replace("\\", "") + ".PNG' />";                                                                         
                                }
                                out.println(""
                                        + "<tr>"
                                        + "<td>" + input1 + "</td>"
                                        + "<td>" + MscJ1.get(c1).getNivel() + "</td>"
                                        + "<td>" + var +"</td>"
                                        + "<td>" + MscJ1.get(c1).getNum_equipo() + "</td>"
                                        + "<td>" + con.DateFormat(String.valueOf(MscJ1.get(c1).getInicio_programado())) + "</td>"
                                        + "<td>" + MscJ1.get(c1).getNum_orden() + "</td>"
                                        + "<td>" + MscJ1.get(c1).getDenominacion_obj_tecnico() + "</td>"
                                        + "<td>" + MscJ1.get(c1).getPlan_mante_preventivo() + "</td>"
                                        + "<td>" + MscJ1.get(c1).getDescricpion_posicion() + "</td>"
                                        + "<td>" + MscJ1.get(c1).getPosicion_mantenimiento() + "</td>"
                                        + "</tr>");
                            }
                            for (int i = c1; i < 10; i++) {
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.print("</tbody>"
                                    + "                              </table>");
                        } else {
                            out.println("<table id='tablados' class=\"TablaCont\">\n"
                                    + "                            <thead>\n"
                                    + "                                <tr id=\"CabeceraTabla\">\n"
                                    + "                                    <td>&nbsp;</td>\n"
                                    + "                                    <td>Level</td>\n"
                                    + "                                    <td>Icon</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Equipment&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DateOrder&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OrderPM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DenominationEquipment&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TextPlan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n"
                                    + "                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ItemPlan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + "</td>\n"
                                    + "                                </tr>\n"
                                    + "                            </thead>\n"
                                    + "                            <tbody>\n");
                            for (c1 = 0; c1 < MscJ1.size(); c1++) {
                                if (MscJ1.get(c1).getNum_orden().equals("")) {
                                    input1 = "&nbsp;";
                                } else {
                                    input1 = "<input id=\"rbt\" type=\"radio\" name=\"mon\" value=" + MscJ1.get(c1).getNum_orden() + "\">";
                                }
                                //Si la fecha es igual a cero, no pintar el semaforo
                                if (MscJ1.get(c1).getInicio_programado().equals("0000-00-00")) {
                                    var = ""; 
                                } else {
                                    var = "<img src='images/" + MscJ1.get(c1).getElem_referencia_pm_ps().replace("\\", "") + ".PNG' />";                                                                          
                                }
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>" + input1 + "</td>"
                                        + "<td>" + MscJ1.get(c1).getNivel() + "</td>"
                                        + "<td>" + var + "</td>"
                                        + "<td>" + MscJ1.get(c1).getNum_equipo() + "</td>"
                                        + "<td>" + con.DateFormat(String.valueOf(MscJ1.get(c1).getInicio_programado())) + "</td>"
                                        + "<td>" + MscJ1.get(c1).getNum_orden() + "</td>"
                                        + "<td>" + MscJ1.get(c1).getDenominacion_obj_tecnico() + "</td>"
                                        + "<td>" + MscJ1.get(c1).getPlan_mante_preventivo() + "</td>"
                                        + "<td>" + MscJ1.get(c1).getDescricpion_posicion() + "</td>"
                                        + "<td>" + MscJ1.get(c1).getPosicion_mantenimiento() + "</td>"
                                        + "</tr>");
                            }
                            for (int i = c1; i < 10; i++) {
                                out.println(""
                                        + "                               <tr>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "<td>&nbsp;</td>"
                                        + "</tr>");
                            }
                            out.print("</tbody>"
                                    + "                              </table>");
                        }
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
