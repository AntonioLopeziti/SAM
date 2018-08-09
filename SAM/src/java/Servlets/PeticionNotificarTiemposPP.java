/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_NotificarTiempos;
import AccesoDatos.ACC_Usuarios;
import AccesoDatos.Consultas;
import Entidades.control_tiempos;
import Entidades.CabNotTiempo;
import Entidades.ControlListaOrdenes;
import Entidades.MotivosRechazo;
import Entidades.OrdenesOperaciones;
import Entidades.PlanPP;
import Entidades.folios;
import Entidades.PosNotTiempo;
import Entidades.texto_actividades;
import Entidades.usuarios;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

/**
 *
 * @author Jhonatan
 */
@WebServlet(name = "PeticionNotificarTiemposPP", urlPatterns = {"/PeticionNotificarTiemposPP"})
public class PeticionNotificarTiemposPP extends HttpServlet {

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
            String acc = request.getParameter("acc");
            String orden = request.getParameter("orden");
            String usuario = request.getParameter("usuario");
            String oper = request.getParameter("oper");
            String buena = request.getParameter("buena");
            String mala = request.getParameter("mala");
            String parcial = request.getParameter("parcial");
            String finall = request.getParameter("final");
            String autom = request.getParameter("autom");
            String reserv = request.getParameter("reserv");
            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");
            String v3 = request.getParameter("v3");
            String v4 = request.getParameter("v4");
            String v5 = request.getParameter("v5");
            String v6 = request.getParameter("v6");
            String v7 = request.getParameter("v7");
            String v8 = request.getParameter("v8");
            String v9 = request.getParameter("v9");
            String v10 = request.getParameter("v10");
            String v11 = request.getParameter("v11");
            String v12 = request.getParameter("v12");
            String v13 = request.getParameter("v13");
            String v14 = request.getParameter("v14");
            String v15 = request.getParameter("v15");
            String v16 = request.getParameter("v16");
            String v17 = request.getParameter("v17");
            String v18 = request.getParameter("v18");
            String v19 = request.getParameter("v19");
            String v20 = request.getParameter("v20");
            String v21 = request.getParameter("v21");
            String v22 = request.getParameter("v22");
            String v23 = request.getParameter("v23");
            //Filtros de Match Orden
            String matchOr = request.getParameter("modOrd");
            String matchTxt = request.getParameter("modTxtB");
            String matchCnt = request.getParameter("modAcO");
            String fechaActual = Consultas.ObtenerInstancia().ObtenerFechaActualServidor();
            String horaActual = Consultas.ObtenerInstancia().ObtenerhoraActualServidor();
            folios folioActual = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("PP");
            String par = "";
            String fin = "";
            String aut = "";
            String rese = "";
            switch (acc) {
                case "insertarDatos":
                    control_tiempos ctt = new control_tiempos();
                    if (parcial == "") {
                        par = "";
                    } else {
                        par = "X";
                    }
                    if (finall == "") {
                        fin = "";
                    } else {
                        fin = "X";
                    }
                    if (autom == "") {
                        aut = "";
                    } else {
                        aut = "X";
                    }
                    if (reserv == "") {
                        rese = "";
                    } else {
                        rese = "X";
                    }
                    ctt.setNo_personal(usuario);
                    ctt.setNot_parcial(par);
                    ctt.setNot_final(fin);
                    ctt.setNot_final_aut(aut);
                    ctt.setComp_reserva(rese);
                    ctt.setOrden_fab(orden);
                    ctt.setNum_op(oper);
                    ctt.setCtd_buena(buena);
                    ctt.setCtd_mala(mala);
                    ctt.setHora(horaActual);
                    ctt.setFecha(fechaActual);
                    if (ACC_NotificarTiempos.ObtenerInstancia().InsertarNotifTiempoPP(ctt)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "LlenarTablas":
                    control_tiempos cnto = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ObtenerRegistroOrdenes(usuario, orden);
                    PlanPP pla = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ObtenerDatosPlan(orden, v21);
                    CabNotTiempo cnta = new CabNotTiempo();
                    String fl = "PP" + folioActual.getFolioActual();
                    String folAct = "" + folioActual.getFolioActual();
                    cnta.setNum_orden(cnto.getOrden_fab());
                    cnta.setFolio_not_tiem(fl);
                    cnta.setFecha_offline(fechaActual);
                    cnta.setHora_offline(horaActual);
                    cnta.setNum_mat_ord(pla.getNum_material());
                    cnta.setCentro(pla.getCentro());
                    cnta.setAct_not_par(cnto.getNot_parcial());
                    cnta.setAct_not_final(cnto.getNot_final());
                    cnta.setNot_final(cnto.getNot_final_aut());
                    cnta.setCom_reserv(cnto.getComp_reserva());
                    cnta.setNum_personal(usuario);

                    PosNotTiempo posno = new PosNotTiempo();
                    posno.setNum_orden(cnto.getOrden_fab());
                    posno.setNum_operacion(v21);
                    posno.setNum_notificacion("0");
                    posno.setFolio_sam(fl);
                    posno.setClase_orden("0");
                    posno.setPuesto_trabajo(pla.getPuesto_trabajo_responsable());
                    posno.setCentro(pla.getCentro());
                    posno.setMaterial(pla.getNum_material());
                    posno.setTexto_breve("");
                    posno.setNum_notificacion_sam("0");
                    posno.setNotificacion_parcial("");
                    posno.setCompensar("");
                    posno.setCantidad_buena(v1);
                    posno.setUnidad_medida(pla.getUnidad_medida());
                    posno.setRechazo(v2);
                    posno.setCantidad_trabajo("0"); //????????????
                    posno.setMotivo_desviacion("");
                    posno.setActividad_notificar1(v3);
                    posno.setUnidad_medida_notificar1(v4);
                    posno.setIndicador_actividad1(v5);
                    posno.setActividad_notificar2(v6);
                    posno.setUnidad_medida_notificar2(v7);
                    posno.setIndicador_actividad2(v8);
                    posno.setActividad_notificar3(v9);
                    posno.setUnidad_medida_notificar3(v10);
                    posno.setIndicador_actividad3(v11);
                    posno.setActividad_notificar4(v12);
                    posno.setUnidad_medida_notificar4(v13);
                    posno.setIndicador_actividad4(v14);
                    posno.setActividad_notificar5(v15);
                    posno.setUnidad_medida_notificar5(v16);
                    posno.setIndicador_actividad5(v17);
                    posno.setActividad_notificar6(v18);
                    posno.setUnidad_medida_notificar6(v19);
                    posno.setIndicador_actividad6(v20);
                    posno.setNum_personal("");
                    posno.setFecha_inicio(cnto.getFecha());
                    posno.setHora_inicio(cnto.getHora());
                    posno.setFecha_fin(fechaActual);
                    posno.setHora_fin(horaActual);
                    posno.setFecha_contabilizacion("");
                    posno.setTexto_notificacion("");
                    posno.setUsuario(usuario);
                    posno.setRecibido("");
                    posno.setProcesado("");
                    posno.setFecha_recibido(fechaActual);
                    posno.setHora_recibido(horaActual);
                    posno.setMensaje("");
                    posno.setMotivo(v22);
                    if (ACC_NotificarTiempos.ObtenerInstancia().InsertarCabNotTiempo(cnta)) {
                        if (ACC_NotificarTiempos.ObtenerInstancia().InsertarPosNotTiempo(posno)) {
                            ACC_Folios.ObtenerIstancia().ActualizarFolio("PP", Integer.parseInt(folAct));
                            if (!v23.equals("PP03")) {
                                ACC_NotificarTiempos.ObtenerInstancia().ActualizaStatusOrdenPP(orden, v21);
                            } else {
                                //Descontar a la operacion PP03 (Cantidad)

                            }
                            out.println(fl);
                        } else {
                            out.println(0);
                        }
                    } else {
                        out.println(0);
                    }

                    break;
                case "validarCant":
                    PlanPP plan = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ObtenerCantidadOrden(orden);
                    String planCnt = plan.getCantidad_total();
                    float cntBuena = Float.parseFloat(buena);
                    float cntMala = Float.parseFloat(mala);
                    float suma = cntBuena + cntMala;
                    String res = Float.toString(suma);
                    String tot = res + "00";
                    float cntOrden = Float.parseFloat(planCnt);
                    float cntTotal = Float.parseFloat(tot);
                    if (cntTotal > cntOrden) {
                        //Si la cantidad total es mayor, no se debe realizar la notificacion de tiempos
                        out.println(0);
                    } else {
                        //Cantidad total de los inputs puede ser menos o igual a la cantidad base
                        out.println(1);
                    }
                    break;
                case "ConsultaUsuarios":
                    ArrayList<usuarios> us = AccesoDatos.ACC_Usuarios.ObtenerInstancia().ConsultarUsuarioNotTiemPP();
                    if (us.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < us.size(); i++) {
                            out.println("<tr ondblclick=\"Select('" + us.get(i).getUsuario() + "' ,'Usuario')\" >");
                            out.println("<td>" + us.get(i).getUsuario() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrdenesFab":
                    ArrayList<PlanPP> pl = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ConsultarOrdenesFabPP(matchOr, matchTxt, matchCnt, v1);
                    if (pl.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < pl.size(); i++) {
                            out.println("<tr ondblclick=\"SelectOrd('" + pl.get(i).getNum_orden() + "', 'Orden' , '" + pl.get(i).getTexto_breve() + "')\">");
                            out.println("<td>" + pl.get(i).getNum_orden() + "</td>");
                            out.println("<td>" + pl.get(i).getTexto_material() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
//                    int conta = 0;
//                    ArrayList<ControlListaOrdenes> lo = new ArrayList<>();
//                    if (pl.size() > 0) {
//                        for (conta = 0; conta < pl.size(); conta++) {
//                            lo = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().FiltroOrdenesLib();
//                            if (lo.size() > 0) {
//                                for (ControlListaOrdenes cnt : lo) {
//                                    String name = cnt.getNum_orden();
//                                    String nameRe = pl.get(conta).getNum_orden();
//                                    if (nameRe.equals(name)) {
//                                        out.println(0);
//                                    } else {
//                                    }
//                                }
//                            }
//                        }
//
                    } else {
                        out.println(0);
                    }

                    break;
                case "MostrarOperaciones":
                    ArrayList<OrdenesOperaciones> mo = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().MostrarOperacionesPP(orden);
                    if (mo.size() > 0) {
                        out.println("<select id=\"selNoOp\">");
                        for (int i = 0; i < mo.size(); i++) {
                            out.println("<option value=\"" + mo.get(i).getNum_operacion() + "\">" + mo.get(i).getNum_operacion() + "</option>");
                        }
                        out.println("</select>");

                        out.println("<select id=\"selClOp\" hidden>");
                        for (int i = 0; i < mo.size(); i++) {
                            out.println("<option value=\"" + mo.get(i).getClave_control() + "\">" + mo.get(i).getClave_control() + "</option>");
                        }
                        out.println("</select>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "revisarExcesoCant":
                    PlanPP ex = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().VerificarStatusCantidad(orden);
                    if (ex.getExceso_suministro().equals("X")) {
                        out.println("<input type=\"checkbox\" value=\"selection\" id=\"checkCntExceso\" disabled checked>");
                        out.println("<label style=\" width: 40%;\">Exceso Limitado</label>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "revDatosUs":
                    control_tiempos ct = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().CargarDatosPorUs(usuario, orden, oper);
                    if (ct.getNo_personal() == null || ct.getNo_personal().equals("")) {
                        out.println(0);
                    } else {
                        JSONArray j = new JSONArray();
                        j.add(ct.getNo_personal());
                        j.add(ct.getNot_parcial());
                        j.add(ct.getNot_final());
                        j.add(ct.getNot_final_aut());
                        j.add(ct.getComp_reserva());
                        j.add(ct.getOrden_fab());
                        j.add(ct.getNum_op());
                        j.add(ct.getCtd_buena());
                        j.add(ct.getCtd_mala());
                        out.println(j);
                    }
                    break;
                case "getActividades":
                    texto_actividades tx = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().obtenerTextosAct(v1);

                    JSONArray j = new JSONArray();
                    j.add(tx.getTexto_actividad1());
                    j.add(tx.getTexto_actividad2());
                    j.add(tx.getTexto_actividad3());
                    j.add(tx.getTexto_actividad4());
                    j.add(tx.getTexto_actividad5());
                    j.add(tx.getTexto_actividad6());
                    j.add(tx.getIndicador_visualiza1());
                    j.add(tx.getIndicador_visualiza2());
                    j.add(tx.getIndicador_visualiza3());
                    j.add(tx.getIndicador_visualiza4());
                    j.add(tx.getIndicador_visualiza5());
                    j.add(tx.getIndicador_visualiza6());
                    out.println(j);
                    break;
                case "getMotivosRC":
                    ArrayList<MotivosRechazo> mc = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().GetMotivosRC(v1);
                    for (int i = 0; i < mc.size(); i++) {
                        out.println("<input class=\"ckhRechazo\" type=\"radio\" name=\"ckRechazoIT\" value=\"" + mc.get(i).getMotivo() + "\"> " + mc.get(i).getMotivo() + "<br>");
                    }
                    break;
                case "borrarRegControl":
                    if (AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().BorraRegTablaCont(usuario, orden)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarOrdLibBlur":
                    int b = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ValidarStatusLibBlur(orden, v1);
                    out.println(b);
                    break;
                case "ValidarStatusOrden":
                    int z = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ValidarStatusOrdenTab(orden);
                    out.println(z);
                    break;
                case "validarOrdFab":
                    int o = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ValidarOrdenFab(orden);
                    out.println(o);
                    break;
                case "validarUsuario":
                    int u = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ValidarUsuario(usuario);
                    out.println(u);
                    break;
                case "validarNotifCread":
                    int p = AccesoDatos.ACC_NotificarTiempos.ObtenerInstancia().ValidarNotifCreada(usuario, orden, oper);
                    out.println(p);
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
