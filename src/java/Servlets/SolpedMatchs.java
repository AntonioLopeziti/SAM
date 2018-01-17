/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_SolpedReporte;
import AccesoDatos.ACC_Solped_cabecera2;
import AccesoDatos.ACC_Solped_posiciones2;
import Entidades.ReporteSolPed;
import Entidades.solped_cabecera;
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
 * @author AreConsulting
 */
@WebServlet(name = "SolpedMatchs", urlPatterns = {"/SolpedMatchs"})
public class SolpedMatchs extends HttpServlet {

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
         HttpSession session = request.getSession();
            String accion = request.getParameter("Action");
            String sam = (String) session.getAttribute("SAMSP");
            String sap = (String) session.getAttribute("SAPSP");
            String fecha1 = (String) session.getAttribute("FECHASP");
            String sam2 = (String) session.getAttribute("SAMSPF");
            String sap2 = (String) session.getAttribute("SAPFSP");
            String fecha2 = (String) session.getAttribute("FECHASPF");
            String centro = (String) session.getAttribute("CEN");
            String valor = (String) session.getAttribute("VAL");
            String like;
            String especial;
            String centros = request.getParameter("centro");
            String foliosam = request.getParameter("sam");
            String foliosap = request.getParameter("sap");
            String operacion = request.getParameter("ope");
           // String orden = request.getParameter("ord");
            String tipo = request.getParameter("tipo");
            
                       
            String solicitante = request.getParameter("solicitante");
             String almacen = request.getParameter("almacen");
              String material = request.getParameter("material");
               String posicion = request.getParameter("posicion");
                String imputacion = request.getParameter("imputacion");
                 String coste = request.getParameter("coste");
                  String orden = request.getParameter("orden");
            
            switch (accion) {
                case "solicitante":
                    
                    
                    LinkedList<String[]> datosSolicitante=new LinkedList<String[]>();
                    String [] sol= new String[7];
                    datosSolicitante=ACC_SolpedReporte.ObtenerInstancia().ConsultaMatchFiltro("SELECT DISTINCT  solicitante FROM solped_posiciones_vis","solicitante");

                     if (datosSolicitante.size() > 0){
                        out.println("<table>");
                        out.println("<tbody>");
                            for (int i = 0; i < datosSolicitante.size(); i++){
                                sol=datosSolicitante.get(i);
                                
                                out.println("<tr ondblclick=\"Select('" + sol[0] + "','"+tipo+"')\">");
                                out.println("<td>" +  sol[0]  + "</td>");
                                out.println("</tr>");
                            }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {                   
                        out.println(0);
                    }
                    
                    
                    break;
                case "almacen":
                    LinkedList<String[]> datosAlmacen=new LinkedList<String[]>();
                    String [] alm= new String[7];
                    datosAlmacen=ACC_SolpedReporte.ObtenerInstancia().ConsultaMatchFiltro("SELECT DISTINCT  almacen FROM solped_posiciones_vis","almacen");

                     if (datosAlmacen.size() > 0){
                        out.println("<table>");
                        out.println("<tbody>");
                            for (int i = 0; i < datosAlmacen.size(); i++){
                                alm=datosAlmacen.get(i);
                                
                                out.println("<tr ondblclick=\"Select('" + alm[0] + "','"+tipo+"')\">");
                                out.println("<td>" +  alm[0]  + "</td>");
                                out.println("</tr>");
                            }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {                   
                        out.println(0);
                    }
                    break;
                case "material":
                     LinkedList<String[]> datosMaterial=new LinkedList<String[]>();
                    String [] mat= {""};
                    datosMaterial=ACC_SolpedReporte.ObtenerInstancia().ConsultaMatchFiltro("SELECT DISTINCT  num_material FROM solped_posiciones_vis","num_material");

                     if (datosMaterial.size() > 0){
                        out.println("<table>");
                        out.println("<tbody>");
                            for (int i = 0; i < datosMaterial.size(); i++){
                                mat=datosMaterial.get(i);
                                
                                out.println("<tr ondblclick=\"Select('" + mat[0] + "','"+tipo+"')\">");
                                out.println("<td>" +  mat[0]  + "</td>");
                                out.println("</tr>");
                            }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {                   
                        out.println(0);
                    }
                    break;
                case "posicion":
                    LinkedList<String[]> datosPosicion=new LinkedList<String[]>();
                    String [] pos= {""};
                    datosPosicion=ACC_SolpedReporte.ObtenerInstancia().ConsultaMatchFiltro("SELECT DISTINCT  tipo_posicion_doc_compras FROM solped_posiciones_vis","tipo_posicion_doc_compras");

                     if (datosPosicion.size() > 0){
                        out.println("<table>");
                        out.println("<tbody>");
                            for (int i = 0; i < datosPosicion.size(); i++){
                                pos=datosPosicion.get(i);
                                
                                out.println("<tr ondblclick=\"Select('" + pos[0] + "','"+tipo+"')\">");
                                out.println("<td>" +  pos[0]  + "</td>");
                                out.println("</tr>");
                            }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {                   
                        out.println(0);
                    }
                    break;    
                case "imputacion":
                     LinkedList<String[]> datosImputacion=new LinkedList<String[]>();
                    String [] imp= {""};
                    datosImputacion=ACC_SolpedReporte.ObtenerInstancia().ConsultaMatchFiltro("SELECT DISTINCT  tipo_imputacion FROM solped_posiciones_vis","tipo_imputacion");

                     if (datosImputacion.size() > 0){
                        out.println("<table>");
                        out.println("<tbody>");
                            for (int i = 0; i < datosImputacion.size(); i++){
                                imp=datosImputacion.get(i);
                                
                                out.println("<tr ondblclick=\"Select('" + imp[0] + "','"+tipo+"')\">");
                                out.println("<td>" +  imp[0]  + "</td>");
                                out.println("</tr>");
                            }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {                   
                        out.println(0);
                    }
                    break;    
                case "coste":
                    LinkedList<String[]> datosCoste=new LinkedList<String[]>();
                    String [] cos= {""};
                    datosCoste=ACC_SolpedReporte.ObtenerInstancia().ConsultaMatchFiltro("SELECT DISTINCT  centro_coste FROM solped_posiciones_vis","centro_coste");

                     if (datosCoste.size() > 0){
                        out.println("<table>");
                        out.println("<tbody>");
                            for (int i = 0; i < datosCoste.size(); i++){
                                cos=datosCoste.get(i);
                                
                                out.println("<tr ondblclick=\"Select('" + cos[0] + "','"+tipo+"')\">");
                                out.println("<td>" +  cos[0]  + "</td>");
                                out.println("</tr>");
                            }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {                   
                        out.println(0);
                    }
                    break;    
                case "orden":
                    LinkedList<String[]> datosOrden=new LinkedList<String[]>();
                    String [] ord= {""};
                    datosOrden=ACC_SolpedReporte.ObtenerInstancia().ConsultaMatchFiltro("SELECT DISTINCT  num_orden FROM solped_posiciones_vis","num_orden");

                     if (datosOrden.size() > 0){
                        out.println("<table>");
                        out.println("<tbody>");
                            for (int i = 0; i < datosOrden.size(); i++){
                                ord=datosOrden.get(i);
                                
                                out.println("<tr ondblclick=\"Select('" + ord[0] + "','"+tipo+"')\">");
                                out.println("<td>" +  ord[0]  + "</td>");
                                out.println("</tr>");
                            }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {                   
                        out.println(0);
                    }                 
                    break;
                    case "SAPsolped":
                    
                    String query = "SELECT * FROM solped_cabecera_vis";
                    
                 LinkedList<solped_cabecera> r = ACC_Solped_cabecera2.ObtenerInstancia().ConsultaGeneral(query);
                    
                    
                     if (r.size() > 0){
                        out.println("<table>");
                        out.println("<tbody>");
                            for (int i = 0; i < r.size(); i++){
                                out.println("<tr ondblclick=\"Select('" + r.get(i).getFolio_sap() + "','"+tipo+"')\">");
                                out.println("<td>" + r.get(i).getFolio_sap() + "</td>");
                                out.println("</tr>");
                            }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {                   
                        out.println(0);
                    }
                break;
                  case "ConsultaTodos":
      
                 String querySapTod = "SELECT * FROM solped_cabecera_vis   JOIN solped_posiciones_vis ON solped_cabecera_vis.folio_sap = solped_posiciones_vis.folio_sap WHERE solped_cabecera_vis.folio_sam BETWEEN '" + sam + "' AND '" + sam2 + "' AND solped_cabecera_vis.folio_sap BETWEEN '" + sap + "' AND '" + sap2 + "' AND solped_cabecera_vis.fecha BETWEEN '" + fecha1 + "' AND '" + fecha2 + "' AND solped_cabecera_vis.centro LIKE '" + centro + "%'  AND solped_posiciones_vis.solicitante like '"+solicitante+"%' AND solped_posiciones_vis.almacen like '"+almacen+"%' AND solped_posiciones_vis.num_material like '"+material+"%' AND solped_posiciones_vis.tipo_posicion_doc_compras like '"+posicion+"%' AND solped_posiciones_vis.tipo_imputacion like '"+imputacion+"%' AND solped_posiciones_vis.centro_coste like '"+coste+"%' AND solped_posiciones_vis.num_orden like '"+orden+"%'";

                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td><b>folio_sam</b></td>");
                    out.println("<td><b> folio_sap</b></td>");
                    out.println("<td><b> folio </b></td>");
                    out.println("<td><b> clase_documento_solped </b></td>");
                    out.println("<td><b> texto_cabecera </b></td>");
                    out.println("<td><b> solicitante </b></td>");
                    out.println("<td><b> centro </b></td>");
                    out.println("<td><b> fecha_solicitud     </b></td>");
                    out.println("<td><b> fecha_entrega_posicion</b></td>");
                    out.println("<td><b> fecha_liberacion_solped</b></td>");
                    out.println("<td><b> clase_pedido </b></td>");
                    out.println("<td><b> centro2 </b></td>");
                    out.println("<td><b>num_posicion_solped</b></td>");
                    out.println("<td><b>tipo_posicion_doc_compras</b></td>");
                    out.println("<td><b>num_material</b></td>");
                    out.println("<td><b>fecha</b></td>");
                    out.println("<td><b>hora_dia</b></td>");
                    out.println("<td><b>clase_doc_solped</b></td>");
                    out.println("<td><b>tipo_imputacion</b></td>");
                    out.println("<td><b>texto_breve</b></td>");
                    out.println("<td><b>cantidad_solped</b></td>");
                    out.println("<td><b>cantidad_solped</b></td>");
                    out.println("<td><b>unidad_medida_solped</b></td>");
                    out.println("<td><b>tipo_fecha</b></td>");
                    out.println("<td><b>fecha_entrega</b></td>");
                    out.println("<td><b>grupo_articulos</b></td>");
                    out.println("<td><b>centro</b></td>");
                    out.println("<td><b>almacen</b></td>");
                    out.println("<td><b>grupo_compras</b></td>");
                    out.println("<td><b>solicitante</b></td>");
                    out.println("<td><b>fecha_solicitud</b></td>");
                    out.println("<td><b>proveedor_deseado</b></td>");
                    out.println("<td><b>num_cuenta_proveedor</b></td>");
                    out.println("<td><b>indice_registro_no_valido</b></td>");
                    out.println("<td><b>tipo_posicion_doc_compras2 </b></td>");
                    out.println("<td><b>num_registro_info_compras</b></td>");
                    out.println("<td><b>organización_compras</b></td>");
                    out.println("<td><b>num_cuenta_mayor</b></td>");
                    out.println("<td><b>centro_coste</b></td>");
                    out.println("<td><b>num_contrato_superior</b></td>");
                    out.println("<td><b>num_posicion_contrato_superior</b></td>");
                    out.println("<td><b>indicador_distribucion_imputacion_multiple</b></td>");
                    out.println("<td><b>num_cuenta_mayor2</b></td>");
                    out.println("<td><b>num_orden</b></td>");
                    out.println("<td><b>sociedad_co</b></td>");
                    out.println("<td><b>centro_coste2</b></td>");
                    out.println("<td><b>texto_cabecera</b></td>");
                    out.println("<td><b>texto_posicion</b></td>");
                    out.println("<td><b>recibido</b></td>");
                    out.println("<td><b>procesado</b></td>");
                    out.println("<td><b>error</b></td>");
                    out.println("<td><b>precio_solped</b></td>");
                    out.println("<td><b>clave_moneda</b></td>");
                    out.println("<td><b>num_solped</b></td>");
                    out.println("<td><b>num_posicion_solped</b></td>");
                    out.println("<td><b>num_linea</b></td>");
                    out.println("<td><b>num_servicio</b></td>");
                    out.println("<td><b>cantidad</b></td>");
                    out.println("<td><b>unidad_medida_base</b></td>");
                    out.println("<td><b>texto_breve</b></td>");
                    out.println("<td><b>precio_bruto</b></td>");
                   out.println("<td><b>clave_moneda</b></td>");
                    out.println("<td><b>centro_coste</b></td>");
                    out.println("<td><b>valor_neto_posicion</b></td>");
                   
                    
                    
                    
                    out.println("</tr>");

                    LinkedList<solped_cabecera> cabeceraSapTod = ACC_Solped_cabecera2.ObtenerInstancia().ConsultaGeneral(querySapTod);

                     for (int i = 0; i < cabeceraSapTod.size(); i++) {
                          int ser=0;
                          int poss =0;
                        String posiciones = "";
                        String servicios = "";
                        LinkedList<String[]> datospos=new LinkedList<String[]>();
                        String [] d={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
                        
                        LinkedList<String[]> datoser=new LinkedList<String[]>();
                        String [] dd={"","","","","","","","","","",""};

                        if (cabeceraSapTod.get(i).getFolio_sam().equals("")) {
                              
                            String query22 = "SELECT count(*) AS 'count' FROM solped_posiciones_vis where folio_sap = '" + cabeceraSapTod.get(i).getFolio_sap() + "' group by folio_sap ";
                            //String query23 = "SELECT count(*) FROM solped_servicios_crea where folio_sam ="+cabecera.get(i).getFolio_sam()+" group by folio_sam";
                            posiciones = ACC_Solped_posiciones2.ObtenerInstancia().ObtenerNumero(query22);
                            datospos=ACC_SolpedReporte.ObtenerInstancia().ConsultaPosiciones("SELECT * FROM solped_posiciones_vis where folio_sap = '" +cabeceraSapTod.get(i).getFolio_sap()+"'");
                           datoser=ACC_SolpedReporte.ObtenerInstancia().ConsultaServicios("SELECT * FROM solped_servicios_vis where num_solped = '" +cabeceraSapTod.get(i).getFolio_sap()+"'");
                          servicios= ACC_SolpedReporte.ObtenerInstancia().ObtenerNumeroSer("SELECT count(*) AS 'count' FROM solped_servicios_vis where num_solped = '" + cabeceraSapTod.get(i).getFolio_sam() + "' group by num_solped ");
                            
                        } else {
                            
                            String query22 = "SELECT count(*) AS 'count' FROM solped_posiciones_vis where folio_sam = '" + cabeceraSapTod.get(i).getFolio_sam() + "' group by folio_sam ";
                            //String query23 = "SELECT count(*) FROM solped_servicios_crea where folio_sam ="+cabecera.get(i).getFolio_sam()+" group by folio_sam";
                            posiciones = ACC_Solped_posiciones2.ObtenerInstancia().ObtenerNumero(query22);
                            datospos=ACC_SolpedReporte.ObtenerInstancia().ConsultaPosiciones("SELECT * FROM solped_posiciones_vis where folio_sam = '" +cabeceraSapTod.get(i).getFolio_sam()+"'");
                          datoser=ACC_SolpedReporte.ObtenerInstancia().ConsultaServicios("SELECT * FROM solped_servicios_vis where folio_sam = '" +cabeceraSapTod.get(i).getFolio_sam()+"'");
                        servicios= ACC_SolpedReporte.ObtenerInstancia().ObtenerNumeroSer("SELECT count(*) AS 'count' FROM solped_servicios_vis where folio_sam = '" + cabeceraSapTod.get(i).getFolio_sam() + "' group by folio_sam ");

                            
                        }
                        if(servicios.equals("")){
                         ser = 0;
                        }else{
                            ser =Integer.parseInt(servicios);
                        }
                        if(posiciones.equals("")){
                         poss = 0;
                        }else{
                            poss =Integer.parseInt(posiciones);
                        } 
  
                        int aux = 0;                  
                        if (poss > ser) {
                            aux = poss;
                        } else {
                            aux = ser;
                        }
                        if (poss == 1 && ser == 1) {
                                 try{
                                     d = datospos.get(0);  
                                     
                                   if(datoser.size()>0){
                                      dd = datoser.get(0);
                                     }  
                                   
                            out.println("<tr>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio_sam() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio_sap() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getClase_documento_solped() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getTexto_cabecera() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getSolicitante() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getCentro() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_solicitud() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_entrega_posicion() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_liberacion_solped() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getClase_pedido() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getCentro2() + "</td>");
                            out.println("<td>" + d[0]+ "</td>");
                            out.println("<td>" + d[1]+ "</td>");
                            out.println("<td>" + d[2]+ "</td>");
                            out.println("<td>" + d[3]+ "</td>");
                            out.println("<td>" + d[4]+ "</td>");
                            out.println("<td>" + d[5]+ "</td>");
                            out.println("<td>" + d[6]+ "</td>");
                            out.println("<td>" + d[7]+ "</td>");
                            out.println("<td>" + d[8]+ "</td>");
                            out.println("<td>" + d[9]+ "</td>");
                            out.println("<td>" + d[10]+ "</td>");
                            out.println("<td>" + d[11]+ "</td>");
                            out.println("<td>" + d[12]+ "</td>");
                            out.println("<td>" + d[13]+ "</td>");
                            out.println("<td>" + d[14]+ "</td>");
                            out.println("<td>" + d[15]+ "</td>");
                            out.println("<td>" + d[16]+ "</td>");
                            out.println("<td>" + d[17]+ "</td>");
                            out.println("<td>" + d[18]+ "</td>");
                            out.println("<td>" + d[19]+ "</td>");
                            out.println("<td>" + d[20]+ "</td>");
                            out.println("<td>" + d[21]+ "</td>");
                            out.println("<td>" + d[22]+ "</td>");
                            out.println("<td>" + d[23]+ "</td>");
                            out.println("<td>" + d[24]+ "</td>");
                            out.println("<td>" + d[25]+ "</td>");
                            out.println("<td>" + d[26]+ "</td>");
                            out.println("<td>" + d[27]+ "</td>");
                            out.println("<td>" + d[28]+ "</td>");
                            out.println("<td>" + d[29]+ "</td>");
                            out.println("<td>" + d[30]+ "</td>");
                            out.println("<td>" + d[31]+ "</td>");
                            out.println("<td>" + d[32]+ "</td>");
                            out.println("<td>" + d[33]+ "</td>");
                            out.println("<td>" + d[34]+ "</td>");
                            out.println("<td>" + d[35]+ "</td>");
                            out.println("<td>" + d[36]+ "</td>");
                            out.println("<td>" + d[37]+ "</td>");
                            out.println("<td>" + d[38]+ "</td>");
                            out.println("<td>" + d[39]+ "</td>");
                            out.println("<td>" + d[40]+ "</td>");
                           out.println("<td>" + dd[0]+ "</td>");
                            out.println("<td>" + dd[1]+ "</td>");
                            out.println("<td>" + dd[2]+ "</td>");
                            out.println("<td>" + dd[3]+ "</td>");
                            out.println("<td>" + dd[4]+ "</td>");
                            out.println("<td>" + dd[5]+ "</td>");
                            out.println("<td>" + dd[6]+ "</td>");
                            out.println("<td>" + dd[7]+ "</td>");
                            out.println("<td>" + dd[8]+ "</td>");
                            out.println("<td>" + dd[9]+ "</td>");
                            out.println("<td>" + dd[10]+ "</td>");
                            out.println("</tr>");
                            
                                 }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}

                        } else if(poss<ser){
                     
                             for (int jj = 0; jj < aux; jj++) {
                                
                                     dd = datoser.get(jj);   
                                     if(datospos.size()>0){
                                      d = datospos.get(0);
                                     }
                                
                              out.println("<tr>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio_sam() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio_sap() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getClase_documento_solped() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getTexto_cabecera() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getSolicitante() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getCentro() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_solicitud() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_entrega_posicion() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_liberacion_solped() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getClase_pedido() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getCentro2() + "</td>");
                            out.println("<td>" + d[0]+ "</td>");
                            out.println("<td>" + d[1]+ "</td>");
                            out.println("<td>" + d[2]+ "</td>");
                            out.println("<td>" + d[3]+ "</td>");
                            out.println("<td>" + d[4]+ "</td>");
                            out.println("<td>" + d[5]+ "</td>");
                            out.println("<td>" + d[6]+ "</td>");
                            out.println("<td>" + d[7]+ "</td>");
                            out.println("<td>" + d[8]+ "</td>");
                            out.println("<td>" + d[9]+ "</td>");
                            out.println("<td>" + d[10]+ "</td>");
                            out.println("<td>" + d[11]+ "</td>");
                            out.println("<td>" + d[12]+ "</td>");
                            out.println("<td>" + d[13]+ "</td>");
                            out.println("<td>" + d[14]+ "</td>");
                            out.println("<td>" + d[15]+ "</td>");
                            out.println("<td>" + d[16]+ "</td>");
                            out.println("<td>" + d[17]+ "</td>");
                            out.println("<td>" + d[18]+ "</td>");
                            out.println("<td>" + d[19]+ "</td>");
                            out.println("<td>" + d[20]+ "</td>");
                            out.println("<td>" + d[21]+ "</td>");
                            out.println("<td>" + d[22]+ "</td>");
                            out.println("<td>" + d[23]+ "</td>");
                            out.println("<td>" + d[24]+ "</td>");
                            out.println("<td>" + d[25]+ "</td>");
                            out.println("<td>" + d[26]+ "</td>");
                            out.println("<td>" + d[27]+ "</td>");
                            out.println("<td>" + d[28]+ "</td>");
                            out.println("<td>" + d[29]+ "</td>");
                            out.println("<td>" + d[30]+ "</td>");
                            out.println("<td>" + d[31]+ "</td>");
                            out.println("<td>" + d[32]+ "</td>");
                            out.println("<td>" + d[33]+ "</td>");
                            out.println("<td>" + d[34]+ "</td>");
                            out.println("<td>" + d[35]+ "</td>");
                            out.println("<td>" + d[36]+ "</td>");
                            out.println("<td>" + d[37]+ "</td>");
                            out.println("<td>" + d[38]+ "</td>");
                            out.println("<td>" + d[39]+ "</td>");
                            out.println("<td>" + d[40]+ "</td>");
                            out.println("<td>" + dd[0]+ "</td>");
                            out.println("<td>" + dd[1]+ "</td>");
                            out.println("<td>" + dd[2]+ "</td>");
                            out.println("<td>" + dd[3]+ "</td>");
                            out.println("<td>" + dd[4]+ "</td>");
                            out.println("<td>" + dd[5]+ "</td>");
                            out.println("<td>" + dd[6]+ "</td>");
                            out.println("<td>" + dd[7]+ "</td>");
                            out.println("<td>" + dd[8]+ "</td>");
                            out.println("<td>" + dd[9]+ "</td>");
                            out.println("<td>" + dd[10]+ "</td>");
                            
                            
                            out.println("</tr>");

                            }
                           

                        } 
                        else {

                            for (int j = 0; j < aux; j++) {
                                
                                     d = datospos.get(j);   
                                     if(datoser.size()>0){
                                      dd = datoser.get(0);
                                     }
                                
                            out.println("<tr>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio_sam() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio_sap() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFolio() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getClase_documento_solped() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getTexto_cabecera() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getSolicitante() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getCentro() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_solicitud() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_entrega_posicion() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getFecha_liberacion_solped() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getClase_pedido() + "</td>");
                            out.println("<td>" + cabeceraSapTod.get(i).getCentro2() + "</td>");
                            out.println("<td>" + d[0]+ "</td>");
                            out.println("<td>" + d[1]+ "</td>");
                            out.println("<td>" + d[2]+ "</td>");
                            out.println("<td>" + d[3]+ "</td>");
                            out.println("<td>" + d[4]+ "</td>");
                            out.println("<td>" + d[5]+ "</td>");
                            out.println("<td>" + d[6]+ "</td>");
                            out.println("<td>" + d[7]+ "</td>");
                            out.println("<td>" + d[8]+ "</td>");
                            out.println("<td>" + d[9]+ "</td>");
                            out.println("<td>" + d[10]+ "</td>");
                            out.println("<td>" + d[11]+ "</td>");
                            out.println("<td>" + d[12]+ "</td>");
                            out.println("<td>" + d[13]+ "</td>");
                            out.println("<td>" + d[14]+ "</td>");
                            out.println("<td>" + d[15]+ "</td>");
                            out.println("<td>" + d[16]+ "</td>");
                            out.println("<td>" + d[17]+ "</td>");
                            out.println("<td>" + d[18]+ "</td>");
                            out.println("<td>" + d[19]+ "</td>");
                            out.println("<td>" + d[20]+ "</td>");
                            out.println("<td>" + d[21]+ "</td>");
                            out.println("<td>" + d[22]+ "</td>");
                            out.println("<td>" + d[23]+ "</td>");
                            out.println("<td>" + d[24]+ "</td>");
                            out.println("<td>" + d[25]+ "</td>");
                            out.println("<td>" + d[26]+ "</td>");
                            out.println("<td>" + d[27]+ "</td>");
                            out.println("<td>" + d[28]+ "</td>");
                            out.println("<td>" + d[29]+ "</td>");
                            out.println("<td>" + d[30]+ "</td>");
                            out.println("<td>" + d[31]+ "</td>");
                            out.println("<td>" + d[32]+ "</td>");
                            out.println("<td>" + d[33]+ "</td>");
                            out.println("<td>" + d[34]+ "</td>");
                            out.println("<td>" + d[35]+ "</td>");
                            out.println("<td>" + d[36]+ "</td>");
                            out.println("<td>" + d[37]+ "</td>");
                            out.println("<td>" + d[38]+ "</td>");
                            out.println("<td>" + d[39]+ "</td>");
                            out.println("<td>" + d[40]+ "</td>");
                            out.println("<td>" + dd[0]+ "</td>");
                            out.println("<td>" + dd[1]+ "</td>");
                            out.println("<td>" + dd[2]+ "</td>");
                            out.println("<td>" + dd[3]+ "</td>");
                            out.println("<td>" + dd[4]+ "</td>");
                            out.println("<td>" + dd[5]+ "</td>");
                            out.println("<td>" + dd[6]+ "</td>");
                            out.println("<td>" + dd[7]+ "</td>");
                            out.println("<td>" + dd[8]+ "</td>");
                            out.println("<td>" + dd[9]+ "</td>");
                            out.println("<td>" + dd[10]+ "</td>");
                            
                            
                            out.println("</tr>");

                            }
                        }
                    }
                   
                   LinkedList<String[]> datosSolpedCrea12=new LinkedList<String[]>();
                     
                         String queryCrea12 = "SELECT * FROM solped_crea  WHERE folio_sap = '"+sap+"' AND folio_sam LIKE '" + sam + "%' AND fecha_solicitud LIKE '" + fecha1 + "%' AND centro LIKE '" + centro + "%'   ";
                         datosSolpedCrea12 = ACC_SolpedReporte.ObtenerInstancia().ConsultaSolpedCrea(queryCrea12);
                         
                         for(int i=0; i<datosSolpedCrea12.size();i++){
                             
                             
                             String [] solpedCrea= new String[43];
                             solpedCrea=datosSolpedCrea12.get(i);
                             out.println("<tr>");
                            out.println("<td>" +solpedCrea[1] + "</td>");
                            out.println("<td> </td>");
                            out.println("<td> </td>");
                            out.println("<td>" + solpedCrea[8]+ "</td>");
                            out.println("<td> </td>");
                            out.println("<td>" + solpedCrea[19]+ "</td>");
                            out.println("<td></td>");
                            out.println("<td>" + solpedCrea[5]+ "</td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td> </td>");
                            out.println("<td>" + solpedCrea[2]+ "</td>");
                            out.println("<td>" + solpedCrea[3] + "</td>");
                            out.println("<td>" + solpedCrea[4] + "</td>");
                            out.println("<td>" + solpedCrea[13]+ "</td>");
                            out.println("<td>" + solpedCrea[6]+ "</td>");
                            out.println("<td></td>");
                            out.println("<td>" +solpedCrea[9] + "</td>");
                            out.println("<td>" +solpedCrea[10] + "</td>");
                            out.println("<td></td>");
                            out.println("<td>" +solpedCrea[11] + "</td>");
                            out.println("<td>" +solpedCrea[12] + "</td>");
                            out.println("<td></td>");
                            out.println("<td>" +solpedCrea[14] + "</td>");
                            out.println("<td>" +solpedCrea[15] + "</td>");
                            out.println("<td>" +solpedCrea[16] + "</td>");
                            out.println("<td>" +solpedCrea[17] + "</td>");
                            out.println("<td>" +solpedCrea[18] + "</td>");
                            out.println("<td>" +solpedCrea[19] + "</td>");
                            out.println("<td>" +solpedCrea[20] + "</td>");
                            out.println("<td>" +solpedCrea[21] + "</td>");
                            out.println("<td>" +solpedCrea[22] + "</td>");
                            out.println("<td>" +solpedCrea[23] + "</td>");
                            out.println("<td>" +solpedCrea[24] + "</td>");
                            out.println("<td>" +solpedCrea[25] + "</td>");
                            out.println("<td>" +solpedCrea[26] + "</td>");
                            out.println("<td>" +solpedCrea[27] + "</td>");
                            out.println("<td>" +solpedCrea[28] + "</td>");
                            out.println("<td>" +solpedCrea[29] + "</td>");
                            out.println("<td>" +solpedCrea[30] + "</td>");
                            out.println("<td>" +solpedCrea[31] + "</td>");
                            out.println("<td>" +solpedCrea[32] + "</td>");
                            out.println("<td>" +solpedCrea[33] + "</td>");
                            out.println("<td>" +solpedCrea[34] + "</td>");
                            out.println("<td>" +solpedCrea[35] + "</td>");
                            out.println("<td>" +solpedCrea[36] + "</td>");
                            out.println("<td>" +solpedCrea[37] + "</td>");
                            out.println("<td>" +solpedCrea[38] + "</td>");
                            out.println("<td>" +solpedCrea[39] + "</td>");
                            out.println("<td>" +solpedCrea[41] + "</td>");
                            out.println("<td>" +solpedCrea[42] + "</td>");
                            out.println("<td>" +solpedCrea[43] + "</td>");
                            out.println("<td>" +solpedCrea[7] + "</td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                            out.println("<td>" +solpedCrea[12] + "</td>");
                            out.println("<td></td>");
                            out.println("<td>" +solpedCrea[42] + "</td>");
                            out.println("<td>" +solpedCrea[43] + "</td>");
                            out.println("<td></td>");
                            out.println("<td></td>");
                             out.println("<tr>");
                            
                             LinkedList<String[]> datosSolpedSerCrea=new LinkedList<String[]>();
                     
                                String querySerCrea = "SELECT * FROM solped_servicios_crea WHERE folio_sam ='" +solpedCrea[1] +"' ";
                                datosSolpedSerCrea = ACC_SolpedReporte.ObtenerInstancia().ConsultaSolpedServiciosCrea(querySerCrea);
                                
                                for(int jj=0; jj<datosSolpedSerCrea.size();jj++){
                                    String [] solpedSerCrea= new String[23];
                                     solpedSerCrea=datosSolpedSerCrea.get(jj);
                                      out.println("<tr>");
                                       out.println("<td>"+solpedSerCrea[1]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[21]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[6]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[2]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[6]+"</td>");
                                       out.println("<td>"+solpedSerCrea[7]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[8]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[10]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[13]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[22]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[14]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[16]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[17]+"</td>");
                                       out.println("<td>"+solpedSerCrea[18]+"</td>");
                                       out.println("<td>"+solpedSerCrea[20]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[16]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[4]+"</td>");
                                       out.println("<td>"+solpedSerCrea[8]+"</td>");
                                       out.println("<td>"+solpedSerCrea[9]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[11]+"</td>");
                                       out.println("<td></td>");
                                       out.println("<td>"+solpedSerCrea[14]+"</td>");
                                       out.println("<td></td>");

                                       out.println("</tr>");
                                      
                            
                                }
                         
                     
                         
                         }
     
                    
            out.println("</table>");
                  
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
