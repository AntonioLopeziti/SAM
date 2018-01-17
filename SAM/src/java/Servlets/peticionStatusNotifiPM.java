/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Equipos_notificaciones;
import AccesoDatos.ACC_Ficheros;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_Ordenes_pm_notificaciones;
import AccesoDatos.ACC_Pm_operaciones_notificaciones;
import AccesoDatos.ACC_Stock;
import AccesoDatos.Consultas;
import Entidades.DmsDocs;
import Entidades.Ficheros;
import Entidades.folios;
import Entidades.materiales;
import Entidades.operaciones_ordenes_crea;
import Entidades.ordenes_pm_notificaciones;
import Entidades.stock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick_Jimenez
 */
@WebServlet(name = "peticionStatusNotifiPM", urlPatterns = {"/peticionStatusNotifiPM"})
public class peticionStatusNotifiPM extends HttpServlet {

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
 /* libbot */
            String operacion = request.getParameter("ope");
            String caso = request.getParameter("caso");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String orden = request.getParameter("ord");
            String stats = request.getParameter("stat");
            String usu = request.getParameter("usu");
            String notlote22 = request.getParameter("notlote22");
            String matera = request.getParameter("matw");
            String centr = request.getParameter("centr");
            String mat = request.getParameter("mat");
            String lot = request.getParameter("lot");
            String eq = request.getParameter("eq");
            String ulm = request.getParameter("ulm");
            String fol = "ES";
            
            String ruta = request.getParameter("ruta");
            String ip = request.getRemoteAddr();
            String equip = request.getParameter("equi");
            String cnt = request.getParameter("centroo");
            
            int c = 0;
            
            folios fp = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios("CC");
            switch (caso) {
                case "ValidaOrdenesQM01":
                    if(ACC_Pm_operaciones_notificaciones.ObtenerInstancia().ValidaQM01(orden)){
                        out.println(1);
                    }else{
                        out.println(0);
                    }
                    break;
                case "DatosCab":
                    ordenes_pm_notificaciones opm = ACC_Ordenes_pm_notificaciones.ObtenerInstancia().ObtStatusCNPM(orden);
                    folios folSAM = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios(fol);
                    int NEfol = folSAM.getFolioActual();
                    ///////////////////////////////
                    String fsam1 = "ES" + folSAM.getFolioActual();
                    String condi = "ES";
                    if (ACC_Pm_operaciones_notificaciones.ObtenerInstancia().InsertStatus_notificacionessap(fsam1, fecha, hora, stats, orden, opm.getCentro(), usu) == true) {
                        if (ACC_Ordenes_pm_notificaciones.ObtenerInstancia().ordpmnotiActual(operacion, orden) == true) {
                            if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT(condi, NEfol) == true) {
                                out.println(0);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(1);
                    }
                    break;
                case "DatosEqu":
                    folios foliSAM = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios(fol);
                    int NEWfol = foliSAM.getFolioActual();
                    String fsameq = "ES" + foliSAM.getFolioActual();
                    String condin = "ES";

                    if (ACC_Pm_operaciones_notificaciones.ObtenerInstancia().InsertStatus_notificacioneseq(fsameq, fecha, hora, stats, orden, usu, notlote22, centr) == true) {
                        if (ACC_Equipos_notificaciones.ObtenerInstancia().ACTUALequipos_notificaciones(operacion, orden) == true) {
                            if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT(condin, NEWfol) == true) {
                                out.println(0 + " " + operacion);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(1);
                    }
                    break;
                case "ActualizaM200":
                    ACC_Pm_operaciones_notificaciones.ObtenerInstancia().AlmacenM200(mat, lot);
                    break;
                case "ActualizaRelacionNoti":
                    ACC_Pm_operaciones_notificaciones.ObtenerInstancia().ActualizaRelacionMonitor(eq, centr, lot, ulm);
                    break;
                case "ActualizaRelacionMA":
                    ACC_Pm_operaciones_notificaciones.ObtenerInstancia().ActualizaRelacionMA(eq, centr, ulm);
                    out.println("CC" + fp.getFolioActual());
                    ACC_Folios.ObtenerIstancia().ActualizarFolio("CC", fp.getFolioActual());
                    break;
                case "DatosCabSAM":

                    operaciones_ordenes_crea orpm = ACC_Orden.ObtenerInstancia().OBTFOLORdenNOT(orden);
                    folios folSAM1 = ACC_Folios.ObtenerIstancia().ObtenerDatosFolios(fol);
                    int NEfol1 = folSAM1.getFolioActual();
                    String fsam = "ES" + folSAM1.getFolioActual();
                    String condil = "ES";

                    if (ACC_Pm_operaciones_notificaciones.ObtenerInstancia().InsertStatus_notificaciones(fsam, fecha, hora, stats, orden, orpm.getCentro(), usu) == true) {
                        if (ACC_Pm_operaciones_notificaciones.ObtenerInstancia().updatEStatus_notificaciones(orden, operacion)) {
                            if (ACC_Folios.ObtenerIstancia().ActualizarFolioNOT(condil, NEfol1) == true) {
                                out.println(0);
                            } else {
                                out.println(1);
                            }
                        } else {
                            out.println(1);
                        }
                    } else {
                        out.println(1);
                    }
                    break;
                case "INSinv":
                    String matw = request.getParameter("matw");
                    stock inst = ACC_Stock.ObtenerInstancia().ConsultarMateNotifiPM(matw, notlote22);
                    if (inst.getMaterial().equals(matw)) {
                        Double resu = Double.parseDouble(inst.getStocklibre_utilizacion()) + 1;
                        String res2 = resu + "00";
                        if (ACC_Stock.ObtenerInstancia().ACTUAINveta(matw, notlote22, res2)) {
                            out.println(1);
                        } else {
                            out.println(0);
                        }

                    } else {
                        materiales matt = ACC_Material.ObtenerInstancia().CargarMaterialNOT(matw);
                        if (matt.getMaterial().equals(matw)) {
                            if (ACC_Stock.ObtenerInstancia().InsertarMATR(matw, matt.getDescripcion(), matt.getDescripcion(), matt.getCentro(), matt.getUnidad_medida(), notlote22, matt.getTipo_material(), matt.getGrupo_articulos())) {
                                out.println(1);
                            } else {
                                out.println(0);
                            }
                        } else {
                            out.println(0);
                        }
                    }
                    break;
                case "ValLOt":
                    LinkedList<stock> lote2 = ACC_Stock.ObtenerInstancia().ConsultaStockLotesEQEX(notlote22);
                    if (lote2.size() > 0) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ACTUEqu":
                    stock inx = ACC_Stock.ObtenerInstancia().ConsultarINVENTARIOSMM(matera, notlote22);
                    Double p = Double.parseDouble(inx.getStocklibre_utilizacion()) - 1;
                    String res2 = p + "00";
                    if (ACC_Stock.ObtenerInstancia().ACTUAINveta(matera, notlote22, res2)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ActLot":
                    if (ACC_Stock.ObtenerInstancia().ACTUALequipos_not(orden, notlote22)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "matchDocs":
                    ArrayList<DmsDocs> dcs = ACC_Ficheros.ObtenerInstancia().MostClassDoc(equip);
                    int con  = 0, c2 = 0;
                    ArrayList<Ficheros> fi = new ArrayList<>();
                    if (dcs.size() > 0) {
                        out.println("<table id=\"TabBody\">\n"
                                + "                                        <tbody>");
                        for (con = 0; con < dcs.size(); con++) {
                            String ruttap1 = "C:/OffLine/DMS/" + cnt + "/" + dcs.get(con).getClase_documento();
                            fi = ACC_Ficheros.ObtenerInstancia().MostrarFicheros(ruttap1);
                            for (Ficheros nf : fi) {
                                String nomaj = nf.getName();
                                String sjk = dcs.get(con).getCampo_texto_longitud();
                                if (sjk.equals(nomaj)) {
                                    //out.println("<tr ondblclick=\"SendPath('" + c2 + "')\">"
                                    out.println("<tr ondblclick=\"abrVen('" + c2 + "')\">"   
                                            + "<td>" + nf.getApl() + "</td>"
                                            + "<td>" + nf.getName() + "</td>"
                                            + "<td>" + nf.getAplicacion() + "</td>"
                                            + "<td name=\"tdFch\">" + nf.getFichero() + "</td>"
                                            + "</tr>");
                                    c2++;
                                }
                            }
                        }
                        for (int c1 = con; c1 < 12; c1++) {
                            out.println("<tr>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "<td>&nbsp;</td>"
                                    + "</tr>");
                        }
                        out.println("<tr class=\"ocultar\">"
                                + "<td>ADMON_POR</td>"
                                + "<td>000000000000000000000000000000000000000000000000</td>"
                                + "<td>ADMON_PORTUAREGRAL_</td>"
                                + "<td>00000000000000000000000000000000000000000000000000000000000000000000000000000</td>"
                                + "</tr>"
                                + "</tbody>"
                                + "</table>");

                    } else {
                        out.println(0);
                    }
                    case "EnviarSocket":
                    String[] cdd = ruta.split(",");
                    if (ACC_Ficheros.ObtenerInstancia().SendFile("C:\\OffLine\\DMS\\" +cdd[0] + "\\" + cdd[1] + "\\" + cdd[2], ip)) {
                        out.println(0);
                    } else {
                        out.println(1);
                    }
                    break;
                    case "EnviarMod":
                    String[] cdm = ruta.split(",");
                    if (ACC_Ficheros.ObtenerInstancia().SendMod("C:\\OffLine\\DMS\\" + cdm[0] + "\\" + cdm[1] + "\\" + cdm[2], ip)) {
                        out.println(0);
                    } else {
                        out.println(1);
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
