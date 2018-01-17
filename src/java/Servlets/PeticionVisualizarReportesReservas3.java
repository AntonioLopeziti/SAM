/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Reportes;
import AccesoDatos.ACC_ReporteReservas;
import AccesoDatos.ACC_SolpedReporte;
import AccesoDatos.ACC_Solped_cabecera2;
import Entidades.solped_cabecera2;
import AccesoDatos.ACC_Solped_posiciones2;
import AccesoDatos.Conexion;
import Entidades.Solped_posiciones;
import Entidades.ReporteSolPed;
import Entidades.solped_cabecera;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "PeticionVisualizarReportesReservas3", urlPatterns = {"/PeticionVisualizarReportesReservas3"})
public class PeticionVisualizarReportesReservas3 extends HttpServlet {

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
            
            String reserva    = (String) session.getAttribute("reserva");
            String posicion   = (String) session.getAttribute("posicion");
            String fecha1     = (String) session.getAttribute("fecha1");
            String reserva2   = (String) session.getAttribute("reserva2");
            String posicion2  = (String) session.getAttribute("posicion2");
            String fecha2     = (String) session.getAttribute("fecha2");
            String centro     = (String) session.getAttribute("centro");
            String clase      = (String) session.getAttribute("clase");
            String material   = (String) session.getAttribute("material");
            String almacen    = (String) session.getAttribute("almacen");
            String usuario    = (String) session.getAttribute("usuario");
            String orden      = (String) session.getAttribute("orden");
            String coste      = (String) session.getAttribute("coste");

 
            
            
            
       
            switch (accion) {
                
              case "2fechas":
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td><b>num_reservas  </b></td>");
                    out.println("<td><b>num_posicion </b></td>");
                    out.println("<td><b>fec_necesidad </b></td>");
                    out.println("<td><b>clase_movimientos </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>texto_posicion </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>unidad_medida </b></td>");
                    out.println("<td><b>cantidad_tomada </b></td>");
                    out.println("<td><b>posicion_borrada </b></td>");
                    out.println("<td><b>mov_mercancia_permitida </b></td>");
                    out.println("<td><b>salida_final_reserva </b></td>");
                    out.println("<td><b>num_lote </b></td>");
                    out.println("<td><b>id_stock_especial  </b></td>");
                    out.println("<td><b>id_debe </b></td>");
                    out.println("<td><b>cantidad_fija </b></td>");
                    out.println("<td><b>valor_tomada </b></td>");
                    out.println("<td><b>calve_moneda </b></td>");
                    out.println("<td><b>cant_unidad_entrada  </b></td>");
                    out.println("<td><b>unidad_medida_entrada  </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>num_cuenta_mayor  </b></td>");
                    out.println("<td><b>centro_receptor_emisor  </b></td>");
                    out.println("<td><b>almacen_receptor_emisor  </b></td>");
                    out.println("<td><b>cant_necesaria_um  </b></td>");
                    out.println("<td><b>tipo_list_mat  </b></td>");
                    out.println("<td><b>lista_materiales </b></td>");
                    out.println("<td><b>txt_pos_listmat1 </b></td>");
                    out.println("<td><b>txt_pos_listmat2 </b></td>");
                    out.println("<td><b>num_conversion_un </b></td>");
                    out.println("<td><b>deno_conversion_un </b></td>");
                    out.println("<td><b>num_hoja_ruta </b></td>");
                    out.println("<td><b>secuencia </b></td>");
                    out.println("<td><b>num_operacion </b></td>");
                    out.println("<td><b>cant_base </b></td>");
                    out.println("<td><b>num_pos_orden </b></td>");
                    out.println("<td><b>grupo_art </b></td>");
                    out.println("<td><b>num_cuenta_proveedor </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>fecha </b></td>");
                    out.println("<td><b>hora_dia </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>clase_movimiento </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>recibido </b></td>");
                    out.println("<td><b>procesado </b></td>");
                    out.println("<td><b>error </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>posicion_reserva </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>unidad_medida_base </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden  </b></td>");
                    out.println("<td><b>clase_movimiento  </b></td>");
                    out.println("<td><b>texto_posicion  </b></td>");
                    out.println("<td><b>recibido  </b></td>");
                    out.println("<td><b>procesado  </b></td>");
                    out.println("<td><b>error  </b></td>");
                    out.println("<td><b>remover  </b></td>");
                    out.println("<td><b>modificar  </b></td>");
                    out.println("</tr>"); 
                    

                // Se obtienen todos los datos de la tabal principal (reservas_materiales)
                    LinkedList<String[]> reservas=new LinkedList<String[]>();
                    reservas=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaMateriales("SELECT * FROM reservas_materiales WHERE fec_necesidad BETWEEN '"+fecha1+"' AND '"+fecha2+"' AND clase_movimientos like '"+clase+"%' AND num_material like '"+material+"%' AND almacen like '"+almacen+"%' AND num_orden like '"+orden+"%' AND centro_coste like '"+coste+"%' AND centro like '"+centro+"%'");
                    
                    
                 //Ciclo for para recorrer todos los datos de la tabla principal (reservas_materiales)   
                    for (int i = 0; i < reservas.size(); i++) {   
                        String [] datosMateriales = new String[43] ;
                            datosMateriales=reservas.get(i);
                  //Se obtinen datos de cada folio para saber cuanas veces exiten las tabalas siguientes (reserva_cabecera y reservas_posiciones_crea)          
                  //se declaran losindices auxiliares que definiran el nuemero de veces a imprimir cada fila
                          int cab=0;
                          int pos =0;
                        String cabecera = "";
                        String posiciones = "";
                        
                        LinkedList<String[]> datosCabecera=new LinkedList<String[]>();
                            String [] c= new String[20];
                        
                        LinkedList<String[]> datoPosiciones=new LinkedList<String[]>();
                        String [] p=new String[20];

                        //obtenemos los indices de las tbalas usando el folio sam o sap
                        if (datosMateriales[41].equals("")) {
                         String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ";
                         cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                         datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sap = '" +datosMateriales[0]+"'");
                         datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sap = '" +datosMateriales[0]+"'");
                         posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ");
                        } else {
                          String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ";
                          cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                          datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sam = '" +datosMateriales[41]+"'");
                          datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sam = '" +datosMateriales[41]+"'");
                          posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ");
                        }
                   //Verficamos en que tabla se repit mas veces el folio_sam o folio sap, para imprimir
                   //ese numero de veces las fila con ese folio y si no existe niengun registro seteamos a 0 el indice
                        if(cabecera.equals("")){
                            cab = 0;
                        }else{cab =Integer.parseInt(cabecera);}
                        if(posiciones.equals("")){
                         pos = 0;
                        }else{pos =Integer.parseInt(posiciones);} 
                        //asignamos el nuemero mayor al indice aux
                        int aux = 0;                  
                        if (pos > cab) {
                            aux = pos;
                        } else {
                            aux = cab;
                        }
                        if (pos == 0 && cab ==0) {
                                 try{
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("</tr>");
                            
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        }else if (pos < cab) {
                                 try{
                                     
                              for (int j = 0; j < aux; j++) {
                                
                                     c = datosCabecera.get(j);   
                                     if(datoPosiciones.size()>0){
                                      p = datoPosiciones.get(0);
                                     }        
                                     
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                             out.println("<td>" + c[0]+ "</td>");
                            out.println("<td>" + c[1]+ "</td>");
                            out.println("<td>" + c[2]+ "</td>");
                            out.println("<td>" + c[3]+ "</td>");
                            out.println("<td>" + c[4]+ "</td>");
                            out.println("<td>" + c[5]+ "</td>");
                            out.println("<td>" + c[6]+ "</td>");
                            out.println("<td>" + c[7]+ "</td>");
                            out.println("<td>" + c[8]+ "</td>");
                            out.println("<td>" + c[9]+ "</td>");
                            out.println("<td>" + c[10]+ "</td>");
                            out.println("<td>" + c[11]+ "</td>");
                            out.println("<td>" + p[0]+ "</td>");
                            out.println("<td>" + p[1]+ "</td>");
                            out.println("<td>" + p[2]+ "</td>");
                            out.println("<td>" + p[3]+ "</td>");
                            out.println("<td>" + p[4]+ "</td>");
                            out.println("<td>" + p[5]+ "</td>");
                            out.println("<td>" + p[6]+ "</td>");
                            out.println("<td>" + p[7]+ "</td>");
                            out.println("<td>" + p[8]+ "</td>");
                            out.println("<td>" + p[9]+ "</td>");
                            out.println("<td>" + p[10]+ "</td>");
                            out.println("<td>" + p[11]+ "</td>");
                            out.println("<td>" + p[12]+ "</td>");
                            out.println("<td>" + p[13]+ "</td>");
                            out.println("<td>" + p[14]+ "</td>");
                            out.println("<td>" + p[15]+ "</td>");
                            out.println("<td>" + p[16]+ "</td>");
                            out.println("</tr>");
                              }
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        }
                    }
                   out.println("</table>");
                  break; 
            case "fechaDer":
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td><b>num_reservas  </b></td>");
                    out.println("<td><b>num_posicion </b></td>");
                    out.println("<td><b>fec_necesidad </b></td>");
                    out.println("<td><b>clase_movimientos </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>texto_posicion </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>unidad_medida </b></td>");
                    out.println("<td><b>cantidad_tomada </b></td>");
                    out.println("<td><b>posicion_borrada </b></td>");
                    out.println("<td><b>mov_mercancia_permitida </b></td>");
                    out.println("<td><b>salida_final_reserva </b></td>");
                    out.println("<td><b>num_lote </b></td>");
                    out.println("<td><b>id_stock_especial  </b></td>");
                    out.println("<td><b>id_debe </b></td>");
                    out.println("<td><b>cantidad_fija </b></td>");
                    out.println("<td><b>valor_tomada </b></td>");
                    out.println("<td><b>calve_moneda </b></td>");
                    out.println("<td><b>cant_unidad_entrada  </b></td>");
                    out.println("<td><b>unidad_medida_entrada  </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>num_cuenta_mayor  </b></td>");
                    out.println("<td><b>centro_receptor_emisor  </b></td>");
                    out.println("<td><b>almacen_receptor_emisor  </b></td>");
                    out.println("<td><b>cant_necesaria_um  </b></td>");
                    out.println("<td><b>tipo_list_mat  </b></td>");
                    out.println("<td><b>lista_materiales </b></td>");
                    out.println("<td><b>txt_pos_listmat1 </b></td>");
                    out.println("<td><b>txt_pos_listmat2 </b></td>");
                    out.println("<td><b>num_conversion_un </b></td>");
                    out.println("<td><b>deno_conversion_un </b></td>");
                    out.println("<td><b>num_hoja_ruta </b></td>");
                    out.println("<td><b>secuencia </b></td>");
                    out.println("<td><b>num_operacion </b></td>");
                    out.println("<td><b>cant_base </b></td>");
                    out.println("<td><b>num_pos_orden </b></td>");
                    out.println("<td><b>grupo_art </b></td>");
                    out.println("<td><b>num_cuenta_proveedor </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>fecha </b></td>");
                    out.println("<td><b>hora_dia </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>clase_movimiento </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>recibido </b></td>");
                    out.println("<td><b>procesado </b></td>");
                    out.println("<td><b>error </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>posicion_reserva </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>unidad_medida_base </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden  </b></td>");
                    out.println("<td><b>clase_movimiento  </b></td>");
                    out.println("<td><b>texto_posicion  </b></td>");
                    out.println("<td><b>recibido  </b></td>");
                    out.println("<td><b>procesado  </b></td>");
                    out.println("<td><b>error  </b></td>");
                    out.println("<td><b>remover  </b></td>");
                    out.println("<td><b>modificar  </b></td>");
                    out.println("</tr>"); 
                    

                // Se obtienen todos los datos de la tabal principal (reservas_materiales)
                    LinkedList<String[]> reservasDer=new LinkedList<String[]>();
                    reservasDer=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaMateriales("SELECT * FROM reservas_materiales WHERE fec_necesidad BETWEEN '0' AND '"+fecha2+"' AND clase_movimientos like '"+clase+"%' AND num_material like '"+material+"%' AND almacen like '"+almacen+"%' AND num_orden like '"+orden+"%' AND centro_coste like '"+coste+"%' AND centro like '"+centro+"%'");
                    
                    
                 //Ciclo for para recorrer todos los datos de la tabla principal (reservas_materiales)   
                    for (int i = 0; i < reservasDer.size(); i++) {   
                        String [] datosMateriales = new String[43] ;
                            datosMateriales=reservasDer.get(i);
                  //Se obtinen datos de cada folio para saber cuanas veces exiten las tabalas siguientes (reserva_cabecera y reservas_posiciones_crea)          
                  //se declaran losindices auxiliares que definiran el nuemero de veces a imprimir cada fila
                          int cab=0;
                          int pos =0;
                        String cabecera = "";
                        String posiciones = "";
                        
                        LinkedList<String[]> datosCabecera=new LinkedList<String[]>();
                            String [] c= new String[20];
                        
                        LinkedList<String[]> datoPosiciones=new LinkedList<String[]>();
                        String [] p=new String[20];

                        //obtenemos los indices de las tbalas usando el folio sam o sap
                        if (datosMateriales[41].equals("")) {
                         String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ";
                         cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                         datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sap = '" +datosMateriales[0]+"'");
                         datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sap = '" +datosMateriales[0]+"'");
                         posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ");
                        } else {
                          String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ";
                          cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                          datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sam = '" +datosMateriales[41]+"'");
                          datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sam = '" +datosMateriales[41]+"'");
                          posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ");
                        }
                   //Verficamos en que tabla se repit mas veces el folio_sam o folio sap, para imprimir
                   //ese numero de veces las fila con ese folio y si no existe niengun registro seteamos a 0 el indice
                        if(cabecera.equals("")){
                            cab = 0;
                        }else{cab =Integer.parseInt(cabecera);}
                        if(posiciones.equals("")){
                         pos = 0;
                        }else{pos =Integer.parseInt(posiciones);} 
                        //asignamos el nuemero mayor al indice aux
                        int aux = 0;                  
                        if (pos > cab) {
                            aux = pos;
                        } else {
                            aux = cab;
                        }
                        if (pos == 0 && cab ==0) {
                                 try{
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("</tr>");
                            
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        }else if (pos < cab) {
                                 try{
                                     
                              for (int j = 0; j < aux; j++) {
                                
                                     c = datosCabecera.get(j);   
                                     if(datoPosiciones.size()>0){
                                      p = datoPosiciones.get(0);
                                     }        
                                     
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                             out.println("<td>" + c[0]+ "</td>");
                            out.println("<td>" + c[1]+ "</td>");
                            out.println("<td>" + c[2]+ "</td>");
                            out.println("<td>" + c[3]+ "</td>");
                            out.println("<td>" + c[4]+ "</td>");
                            out.println("<td>" + c[5]+ "</td>");
                            out.println("<td>" + c[6]+ "</td>");
                            out.println("<td>" + c[7]+ "</td>");
                            out.println("<td>" + c[8]+ "</td>");
                            out.println("<td>" + c[9]+ "</td>");
                            out.println("<td>" + c[10]+ "</td>");
                            out.println("<td>" + c[11]+ "</td>");
                            out.println("<td>" + p[0]+ "</td>");
                            out.println("<td>" + p[1]+ "</td>");
                            out.println("<td>" + p[2]+ "</td>");
                            out.println("<td>" + p[3]+ "</td>");
                            out.println("<td>" + p[4]+ "</td>");
                            out.println("<td>" + p[5]+ "</td>");
                            out.println("<td>" + p[6]+ "</td>");
                            out.println("<td>" + p[7]+ "</td>");
                            out.println("<td>" + p[8]+ "</td>");
                            out.println("<td>" + p[9]+ "</td>");
                            out.println("<td>" + p[10]+ "</td>");
                            out.println("<td>" + p[11]+ "</td>");
                            out.println("<td>" + p[12]+ "</td>");
                            out.println("<td>" + p[13]+ "</td>");
                            out.println("<td>" + p[14]+ "</td>");
                            out.println("<td>" + p[15]+ "</td>");
                            out.println("<td>" + p[16]+ "</td>");
                            out.println("</tr>");
                              }
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        } 
                    }
                   out.println("</table>");
                  break; 
                  
            case "fechaIzq":
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td><b>num_reservas  </b></td>");
                    out.println("<td><b>num_posicion </b></td>");
                    out.println("<td><b>fec_necesidad </b></td>");
                    out.println("<td><b>clase_movimientos </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>texto_posicion </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>unidad_medida </b></td>");
                    out.println("<td><b>cantidad_tomada </b></td>");
                    out.println("<td><b>posicion_borrada </b></td>");
                    out.println("<td><b>mov_mercancia_permitida </b></td>");
                    out.println("<td><b>salida_final_reserva </b></td>");
                    out.println("<td><b>num_lote </b></td>");
                    out.println("<td><b>id_stock_especial  </b></td>");
                    out.println("<td><b>id_debe </b></td>");
                    out.println("<td><b>cantidad_fija </b></td>");
                    out.println("<td><b>valor_tomada </b></td>");
                    out.println("<td><b>calve_moneda </b></td>");
                    out.println("<td><b>cant_unidad_entrada  </b></td>");
                    out.println("<td><b>unidad_medida_entrada  </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>num_cuenta_mayor  </b></td>");
                    out.println("<td><b>centro_receptor_emisor  </b></td>");
                    out.println("<td><b>almacen_receptor_emisor  </b></td>");
                    out.println("<td><b>cant_necesaria_um  </b></td>");
                    out.println("<td><b>tipo_list_mat  </b></td>");
                    out.println("<td><b>lista_materiales </b></td>");
                    out.println("<td><b>txt_pos_listmat1 </b></td>");
                    out.println("<td><b>txt_pos_listmat2 </b></td>");
                    out.println("<td><b>num_conversion_un </b></td>");
                    out.println("<td><b>deno_conversion_un </b></td>");
                    out.println("<td><b>num_hoja_ruta </b></td>");
                    out.println("<td><b>secuencia </b></td>");
                    out.println("<td><b>num_operacion </b></td>");
                    out.println("<td><b>cant_base </b></td>");
                    out.println("<td><b>num_pos_orden </b></td>");
                    out.println("<td><b>grupo_art </b></td>");
                    out.println("<td><b>num_cuenta_proveedor </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>fecha </b></td>");
                    out.println("<td><b>hora_dia </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>clase_movimiento </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>recibido </b></td>");
                    out.println("<td><b>procesado </b></td>");
                    out.println("<td><b>error </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>posicion_reserva </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>unidad_medida_base </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden  </b></td>");
                    out.println("<td><b>clase_movimiento  </b></td>");
                    out.println("<td><b>texto_posicion  </b></td>");
                    out.println("<td><b>recibido  </b></td>");
                    out.println("<td><b>procesado  </b></td>");
                    out.println("<td><b>error  </b></td>");
                    out.println("<td><b>remover  </b></td>");
                    out.println("<td><b>modificar  </b></td>");
                    out.println("</tr>"); 
                    

                // Se obtienen todos los datos de la tabal principal (reservas_materiales)
                    LinkedList<String[]> reservasIzq=new LinkedList<String[]>();
                    reservasIzq=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaMateriales("SELECT * FROM reservas_materiales WHERE fec_necesidad like '"+fecha1+"' AND clase_movimientos like '"+clase+"%' AND num_material like '"+material+"%' AND almacen like '"+almacen+"%' AND num_orden like '"+orden+"%' AND centro_coste like '"+coste+"%' AND centro like '"+centro+"%'");
                    
                    
                 //Ciclo for para recorrer todos los datos de la tabla principal (reservas_materiales)   
                    for (int i = 0; i < reservasIzq.size(); i++) {   
                        String [] datosMateriales = new String[43] ;
                            datosMateriales=reservasIzq.get(i);
                  //Se obtinen datos de cada folio para saber cuanas veces exiten las tabalas siguientes (reserva_cabecera y reservas_posiciones_crea)          
                  //se declaran losindices auxiliares que definiran el nuemero de veces a imprimir cada fila
                          int cab=0;
                          int pos =0;
                        String cabecera = "";
                        String posiciones = "";
                        
                        LinkedList<String[]> datosCabecera=new LinkedList<String[]>();
                            String [] c= new String[20];
                        
                        LinkedList<String[]> datoPosiciones=new LinkedList<String[]>();
                        String [] p=new String[20];

                        //obtenemos los indices de las tbalas usando el folio sam o sap
                        if (datosMateriales[41].equals("")) {
                         String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ";
                         cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                         datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sap = '" +datosMateriales[0]+"'");
                         datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sap = '" +datosMateriales[0]+"'");
                         posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ");
                        } else {
                          String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ";
                          cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                          datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sam = '" +datosMateriales[41]+"'");
                          datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sam = '" +datosMateriales[41]+"'");
                          posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ");
                        }
                   //Verficamos en que tabla se repit mas veces el folio_sam o folio sap, para imprimir
                   //ese numero de veces las fila con ese folio y si no existe niengun registro seteamos a 0 el indice
                        if(cabecera.equals("")){
                            cab = 0;
                        }else{cab =Integer.parseInt(cabecera);}
                        if(posiciones.equals("")){
                         pos = 0;
                        }else{pos =Integer.parseInt(posiciones);} 
                        //asignamos el nuemero mayor al indice aux
                        int aux = 0;                  
                        if (pos > cab) {
                            aux = pos;
                        } else {
                            aux = cab;
                        }
                        if (pos == 0 && cab ==0) {
                                 try{
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("</tr>");
                            
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        }else if (pos < cab) {
                                 try{
                                     
                              for (int j = 0; j < aux; j++) {
                                
                                     c = datosCabecera.get(j);   
                                     if(datoPosiciones.size()>0){
                                      p = datoPosiciones.get(0);
                                     }        
                                     
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                             out.println("<td>" + c[0]+ "</td>");
                            out.println("<td>" + c[1]+ "</td>");
                            out.println("<td>" + c[2]+ "</td>");
                            out.println("<td>" + c[3]+ "</td>");
                            out.println("<td>" + c[4]+ "</td>");
                            out.println("<td>" + c[5]+ "</td>");
                            out.println("<td>" + c[6]+ "</td>");
                            out.println("<td>" + c[7]+ "</td>");
                            out.println("<td>" + c[8]+ "</td>");
                            out.println("<td>" + c[9]+ "</td>");
                            out.println("<td>" + c[10]+ "</td>");
                            out.println("<td>" + c[11]+ "</td>");
                            out.println("<td>" + p[0]+ "</td>");
                            out.println("<td>" + p[1]+ "</td>");
                            out.println("<td>" + p[2]+ "</td>");
                            out.println("<td>" + p[3]+ "</td>");
                            out.println("<td>" + p[4]+ "</td>");
                            out.println("<td>" + p[5]+ "</td>");
                            out.println("<td>" + p[6]+ "</td>");
                            out.println("<td>" + p[7]+ "</td>");
                            out.println("<td>" + p[8]+ "</td>");
                            out.println("<td>" + p[9]+ "</td>");
                            out.println("<td>" + p[10]+ "</td>");
                            out.println("<td>" + p[11]+ "</td>");
                            out.println("<td>" + p[12]+ "</td>");
                            out.println("<td>" + p[13]+ "</td>");
                            out.println("<td>" + p[14]+ "</td>");
                            out.println("<td>" + p[15]+ "</td>");
                            out.println("<td>" + p[16]+ "</td>");
                            out.println("</tr>");
                              }
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        } 
                    }
                   out.println("</table>");
                  break;               
                  
            case "posicionDerecho":
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td><b>num_reservas  </b></td>");
                    out.println("<td><b>num_posicion </b></td>");
                    out.println("<td><b>fec_necesidad </b></td>");
                    out.println("<td><b>clase_movimientos </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>texto_posicion </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>unidad_medida </b></td>");
                    out.println("<td><b>cantidad_tomada </b></td>");
                    out.println("<td><b>posicion_borrada </b></td>");
                    out.println("<td><b>mov_mercancia_permitida </b></td>");
                    out.println("<td><b>salida_final_reserva </b></td>");
                    out.println("<td><b>num_lote </b></td>");
                    out.println("<td><b>id_stock_especial  </b></td>");
                    out.println("<td><b>id_debe </b></td>");
                    out.println("<td><b>cantidad_fija </b></td>");
                    out.println("<td><b>valor_tomada </b></td>");
                    out.println("<td><b>calve_moneda </b></td>");
                    out.println("<td><b>cant_unidad_entrada  </b></td>");
                    out.println("<td><b>unidad_medida_entrada  </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>num_cuenta_mayor  </b></td>");
                    out.println("<td><b>centro_receptor_emisor  </b></td>");
                    out.println("<td><b>almacen_receptor_emisor  </b></td>");
                    out.println("<td><b>cant_necesaria_um  </b></td>");
                    out.println("<td><b>tipo_list_mat  </b></td>");
                    out.println("<td><b>lista_materiales </b></td>");
                    out.println("<td><b>txt_pos_listmat1 </b></td>");
                    out.println("<td><b>txt_pos_listmat2 </b></td>");
                    out.println("<td><b>num_conversion_un </b></td>");
                    out.println("<td><b>deno_conversion_un </b></td>");
                    out.println("<td><b>num_hoja_ruta </b></td>");
                    out.println("<td><b>secuencia </b></td>");
                    out.println("<td><b>num_operacion </b></td>");
                    out.println("<td><b>cant_base </b></td>");
                    out.println("<td><b>num_pos_orden </b></td>");
                    out.println("<td><b>grupo_art </b></td>");
                    out.println("<td><b>num_cuenta_proveedor </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>fecha </b></td>");
                    out.println("<td><b>hora_dia </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>clase_movimiento </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>recibido </b></td>");
                    out.println("<td><b>procesado </b></td>");
                    out.println("<td><b>error </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>posicion_reserva </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>unidad_medida_base </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden  </b></td>");
                    out.println("<td><b>clase_movimiento  </b></td>");
                    out.println("<td><b>texto_posicion  </b></td>");
                    out.println("<td><b>recibido  </b></td>");
                    out.println("<td><b>procesado  </b></td>");
                    out.println("<td><b>error  </b></td>");
                    out.println("<td><b>remover  </b></td>");
                    out.println("<td><b>modificar  </b></td>");
                    out.println("</tr>"); 
                    

                // Se obtienen todos los datos de la tabal principal (reservas_materiales)
                    LinkedList<String[]> posicionDer=new LinkedList<String[]>();
                    posicionDer=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaMateriales("SELECT * FROM reservas_materiales WHERE num_posicion BETWEEN '0' AND '"+posicion2+"' AND clase_movimientos like '"+clase+"%' AND num_material like '"+material+"%' AND almacen like '"+almacen+"%' AND num_orden like '"+orden+"%' AND centro_coste like '"+coste+"%' AND centro like '"+centro+"%'");
                    
                    
                 //Ciclo for para recorrer todos los datos de la tabla principal (reservas_materiales)   
                    for (int i = 0; i < posicionDer.size(); i++) {   
                        String [] datosMateriales = new String[43] ;
                            datosMateriales=posicionDer.get(i);
                  //Se obtinen datos de cada folio para saber cuanas veces exiten las tabalas siguientes (reserva_cabecera y reservas_posiciones_crea)          
                  //se declaran losindices auxiliares que definiran el nuemero de veces a imprimir cada fila
                          int cab=0;
                          int pos =0;
                        String cabecera = "";
                        String posiciones = "";
                        
                        LinkedList<String[]> datosCabecera=new LinkedList<String[]>();
                            String [] c= new String[20];
                        
                        LinkedList<String[]> datoPosiciones=new LinkedList<String[]>();
                        String [] p=new String[20];

                        //obtenemos los indices de las tbalas usando el folio sam o sap
                        if (datosMateriales[41].equals("")) {
                         String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ";
                         cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                         datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sap = '" +datosMateriales[0]+"'");
                         datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sap = '" +datosMateriales[0]+"'");
                         posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ");
                        } else {
                          String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ";
                          cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                          datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sam = '" +datosMateriales[41]+"'");
                          datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sam = '" +datosMateriales[41]+"'");
                          posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ");
                        }
                   //Verficamos en que tabla se repit mas veces el folio_sam o folio sap, para imprimir
                   //ese numero de veces las fila con ese folio y si no existe niengun registro seteamos a 0 el indice
                        if(cabecera.equals("")){
                            cab = 0;
                        }else{cab =Integer.parseInt(cabecera);}
                        if(posiciones.equals("")){
                         pos = 0;
                        }else{pos =Integer.parseInt(posiciones);} 
                        //asignamos el nuemero mayor al indice aux
                        int aux = 0;                  
                        if (pos > cab) {
                            aux = pos;
                        } else {
                            aux = cab;
                        }
                        if (pos == 0 && cab ==0) {
                                 try{
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("</tr>");
                            
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        }else if (pos < cab) {
                                 try{
                                     
                              for (int j = 0; j < aux; j++) {
                                
                                     c = datosCabecera.get(j);   
                                     if(datoPosiciones.size()>0){
                                      p = datoPosiciones.get(0);
                                     }        
                                     
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                             out.println("<td>" + c[0]+ "</td>");
                            out.println("<td>" + c[1]+ "</td>");
                            out.println("<td>" + c[2]+ "</td>");
                            out.println("<td>" + c[3]+ "</td>");
                            out.println("<td>" + c[4]+ "</td>");
                            out.println("<td>" + c[5]+ "</td>");
                            out.println("<td>" + c[6]+ "</td>");
                            out.println("<td>" + c[7]+ "</td>");
                            out.println("<td>" + c[8]+ "</td>");
                            out.println("<td>" + c[9]+ "</td>");
                            out.println("<td>" + c[10]+ "</td>");
                            out.println("<td>" + c[11]+ "</td>");
                            out.println("<td>" + p[0]+ "</td>");
                            out.println("<td>" + p[1]+ "</td>");
                            out.println("<td>" + p[2]+ "</td>");
                            out.println("<td>" + p[3]+ "</td>");
                            out.println("<td>" + p[4]+ "</td>");
                            out.println("<td>" + p[5]+ "</td>");
                            out.println("<td>" + p[6]+ "</td>");
                            out.println("<td>" + p[7]+ "</td>");
                            out.println("<td>" + p[8]+ "</td>");
                            out.println("<td>" + p[9]+ "</td>");
                            out.println("<td>" + p[10]+ "</td>");
                            out.println("<td>" + p[11]+ "</td>");
                            out.println("<td>" + p[12]+ "</td>");
                            out.println("<td>" + p[13]+ "</td>");
                            out.println("<td>" + p[14]+ "</td>");
                            out.println("<td>" + p[15]+ "</td>");
                            out.println("<td>" + p[16]+ "</td>");
                            out.println("</tr>");
                              }
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        } 
                    }
                   out.println("</table>");
                  break;  
                
           case "posicionIzquierdo":
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td><b>num_reservas  </b></td>");
                    out.println("<td><b>num_posicion </b></td>");
                    out.println("<td><b>fec_necesidad </b></td>");
                    out.println("<td><b>clase_movimientos </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>texto_posicion </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>unidad_medida </b></td>");
                    out.println("<td><b>cantidad_tomada </b></td>");
                    out.println("<td><b>posicion_borrada </b></td>");
                    out.println("<td><b>mov_mercancia_permitida </b></td>");
                    out.println("<td><b>salida_final_reserva </b></td>");
                    out.println("<td><b>num_lote </b></td>");
                    out.println("<td><b>id_stock_especial  </b></td>");
                    out.println("<td><b>id_debe </b></td>");
                    out.println("<td><b>cantidad_fija </b></td>");
                    out.println("<td><b>valor_tomada </b></td>");
                    out.println("<td><b>calve_moneda </b></td>");
                    out.println("<td><b>cant_unidad_entrada  </b></td>");
                    out.println("<td><b>unidad_medida_entrada  </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>num_cuenta_mayor  </b></td>");
                    out.println("<td><b>centro_receptor_emisor  </b></td>");
                    out.println("<td><b>almacen_receptor_emisor  </b></td>");
                    out.println("<td><b>cant_necesaria_um  </b></td>");
                    out.println("<td><b>tipo_list_mat  </b></td>");
                    out.println("<td><b>lista_materiales </b></td>");
                    out.println("<td><b>txt_pos_listmat1 </b></td>");
                    out.println("<td><b>txt_pos_listmat2 </b></td>");
                    out.println("<td><b>num_conversion_un </b></td>");
                    out.println("<td><b>deno_conversion_un </b></td>");
                    out.println("<td><b>num_hoja_ruta </b></td>");
                    out.println("<td><b>secuencia </b></td>");
                    out.println("<td><b>num_operacion </b></td>");
                    out.println("<td><b>cant_base </b></td>");
                    out.println("<td><b>num_pos_orden </b></td>");
                    out.println("<td><b>grupo_art </b></td>");
                    out.println("<td><b>num_cuenta_proveedor </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>fecha </b></td>");
                    out.println("<td><b>hora_dia </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>clase_movimiento </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>recibido </b></td>");
                    out.println("<td><b>procesado </b></td>");
                    out.println("<td><b>error </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>posicion_reserva </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>unidad_medida_base </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden  </b></td>");
                    out.println("<td><b>clase_movimiento  </b></td>");
                    out.println("<td><b>texto_posicion  </b></td>");
                    out.println("<td><b>recibido  </b></td>");
                    out.println("<td><b>procesado  </b></td>");
                    out.println("<td><b>error  </b></td>");
                    out.println("<td><b>remover  </b></td>");
                    out.println("<td><b>modificar  </b></td>");
                    out.println("</tr>"); 
                    

                // Se obtienen todos los datos de la tabal principal (reservas_materiales)
                    LinkedList<String[]> posicionIzq=new LinkedList<String[]>();
                    posicionIzq=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaMateriales("SELECT * FROM reservas_materiales WHERE num_posicion like '"+posicion+"' AND clase_movimientos like '"+clase+"%' AND num_material like '"+material+"%' AND almacen like '"+almacen+"%' AND num_orden like '"+orden+"%' AND centro_coste like '"+coste+"%' AND centro like '"+centro+"%'");
                    
                    
                 //Ciclo for para recorrer todos los datos de la tabla principal (reservas_materiales)   
                    for (int i = 0; i < posicionIzq.size(); i++) {   
                        String [] datosMateriales = new String[43] ;
                            datosMateriales=posicionIzq.get(i);
                  //Se obtinen datos de cada folio para saber cuanas veces exiten las tabalas siguientes (reserva_cabecera y reservas_posiciones_crea)          
                  //se declaran losindices auxiliares que definiran el nuemero de veces a imprimir cada fila
                          int cab=0;
                          int pos =0;
                        String cabecera = "";
                        String posiciones = "";
                        
                        LinkedList<String[]> datosCabecera=new LinkedList<String[]>();
                            String [] c= new String[20];
                        
                        LinkedList<String[]> datoPosiciones=new LinkedList<String[]>();
                        String [] p=new String[20];

                        //obtenemos los indices de las tbalas usando el folio sam o sap
                        if (datosMateriales[41].equals("")) {
                         String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ";
                         cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                         datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sap = '" +datosMateriales[0]+"'");
                         datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sap = '" +datosMateriales[0]+"'");
                         posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ");
                        } else {
                          String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ";
                          cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                          datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sam = '" +datosMateriales[41]+"'");
                          datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sam = '" +datosMateriales[41]+"'");
                          posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ");
                        }
                   //Verficamos en que tabla se repit mas veces el folio_sam o folio sap, para imprimir
                   //ese numero de veces las fila con ese folio y si no existe niengun registro seteamos a 0 el indice
                        if(cabecera.equals("")){
                            cab = 0;
                        }else{cab =Integer.parseInt(cabecera);}
                        if(posiciones.equals("")){
                         pos = 0;
                        }else{pos =Integer.parseInt(posiciones);} 
                        //asignamos el nuemero mayor al indice aux
                        int aux = 0;                  
                        if (pos > cab) {
                            aux = pos;
                        } else {
                            aux = cab;
                        }
                        if (pos == 0 && cab ==0) {
                                 try{
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("</tr>");
                            
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        }else if (pos < cab) {
                                 try{
                                     
                              for (int j = 0; j < aux; j++) {
                                
                                     c = datosCabecera.get(j);   
                                     if(datoPosiciones.size()>0){
                                      p = datoPosiciones.get(0);
                                     }        
                                     
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                             out.println("<td>" + c[0]+ "</td>");
                            out.println("<td>" + c[1]+ "</td>");
                            out.println("<td>" + c[2]+ "</td>");
                            out.println("<td>" + c[3]+ "</td>");
                            out.println("<td>" + c[4]+ "</td>");
                            out.println("<td>" + c[5]+ "</td>");
                            out.println("<td>" + c[6]+ "</td>");
                            out.println("<td>" + c[7]+ "</td>");
                            out.println("<td>" + c[8]+ "</td>");
                            out.println("<td>" + c[9]+ "</td>");
                            out.println("<td>" + c[10]+ "</td>");
                            out.println("<td>" + c[11]+ "</td>");
                            out.println("<td>" + p[0]+ "</td>");
                            out.println("<td>" + p[1]+ "</td>");
                            out.println("<td>" + p[2]+ "</td>");
                            out.println("<td>" + p[3]+ "</td>");
                            out.println("<td>" + p[4]+ "</td>");
                            out.println("<td>" + p[5]+ "</td>");
                            out.println("<td>" + p[6]+ "</td>");
                            out.println("<td>" + p[7]+ "</td>");
                            out.println("<td>" + p[8]+ "</td>");
                            out.println("<td>" + p[9]+ "</td>");
                            out.println("<td>" + p[10]+ "</td>");
                            out.println("<td>" + p[11]+ "</td>");
                            out.println("<td>" + p[12]+ "</td>");
                            out.println("<td>" + p[13]+ "</td>");
                            out.println("<td>" + p[14]+ "</td>");
                            out.println("<td>" + p[15]+ "</td>");
                            out.println("<td>" + p[16]+ "</td>");
                            out.println("</tr>");
                              }
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        } 
                    }
                   out.println("</table>");
                  break;                
               
         case "posicion2":
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td><b>num_reservas  </b></td>");
                    out.println("<td><b>num_posicion </b></td>");
                    out.println("<td><b>fec_necesidad </b></td>");
                    out.println("<td><b>clase_movimientos </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>texto_posicion </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>unidad_medida </b></td>");
                    out.println("<td><b>cantidad_tomada </b></td>");
                    out.println("<td><b>posicion_borrada </b></td>");
                    out.println("<td><b>mov_mercancia_permitida </b></td>");
                    out.println("<td><b>salida_final_reserva </b></td>");
                    out.println("<td><b>num_lote </b></td>");
                    out.println("<td><b>id_stock_especial  </b></td>");
                    out.println("<td><b>id_debe </b></td>");
                    out.println("<td><b>cantidad_fija </b></td>");
                    out.println("<td><b>valor_tomada </b></td>");
                    out.println("<td><b>calve_moneda </b></td>");
                    out.println("<td><b>cant_unidad_entrada  </b></td>");
                    out.println("<td><b>unidad_medida_entrada  </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>num_cuenta_mayor  </b></td>");
                    out.println("<td><b>centro_receptor_emisor  </b></td>");
                    out.println("<td><b>almacen_receptor_emisor  </b></td>");
                    out.println("<td><b>cant_necesaria_um  </b></td>");
                    out.println("<td><b>tipo_list_mat  </b></td>");
                    out.println("<td><b>lista_materiales </b></td>");
                    out.println("<td><b>txt_pos_listmat1 </b></td>");
                    out.println("<td><b>txt_pos_listmat2 </b></td>");
                    out.println("<td><b>num_conversion_un </b></td>");
                    out.println("<td><b>deno_conversion_un </b></td>");
                    out.println("<td><b>num_hoja_ruta </b></td>");
                    out.println("<td><b>secuencia </b></td>");
                    out.println("<td><b>num_operacion </b></td>");
                    out.println("<td><b>cant_base </b></td>");
                    out.println("<td><b>num_pos_orden </b></td>");
                    out.println("<td><b>grupo_art </b></td>");
                    out.println("<td><b>num_cuenta_proveedor </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>fecha </b></td>");
                    out.println("<td><b>hora_dia </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>clase_movimiento </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden </b></td>");
                    out.println("<td><b>recibido </b></td>");
                    out.println("<td><b>procesado </b></td>");
                    out.println("<td><b>error </b></td>");
                    out.println("<td><b>folio_sam </b></td>");
                    out.println("<td><b>posicion_reserva </b></td>");
                    out.println("<td><b>folio_sap </b></td>");
                    out.println("<td><b>num_material </b></td>");
                    out.println("<td><b>centro </b></td>");
                    out.println("<td><b>almacen </b></td>");
                    out.println("<td><b>cantidad_necesaria </b></td>");
                    out.println("<td><b>unidad_medida_base </b></td>");
                    out.println("<td><b>centro_coste </b></td>");
                    out.println("<td><b>num_orden  </b></td>");
                    out.println("<td><b>clase_movimiento  </b></td>");
                    out.println("<td><b>texto_posicion  </b></td>");
                    out.println("<td><b>recibido  </b></td>");
                    out.println("<td><b>procesado  </b></td>");
                    out.println("<td><b>error  </b></td>");
                    out.println("<td><b>remover  </b></td>");
                    out.println("<td><b>modificar  </b></td>");
                    out.println("</tr>"); 
                    

                // Se obtienen todos los datos de la tabal principal (reservas_materiales)
                    LinkedList<String[]> posiciones2=new LinkedList<String[]>();
                    posiciones2=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaMateriales("SELECT * FROM reservas_materiales WHERE num_posicion BETWEEN '"+posicion+"' AND '"+posicion2+"' AND clase_movimientos like '"+clase+"%' AND num_material like '"+material+"%' AND almacen like '"+almacen+"%' AND num_orden like '"+orden+"%' AND centro_coste like '"+coste+"%' AND centro like '"+centro+"%'");
                    
                    
                 //Ciclo for para recorrer todos los datos de la tabla principal (reservas_materiales)   
                    for (int i = 0; i < posiciones2.size(); i++) {   
                        String [] datosMateriales = new String[43] ;
                            datosMateriales=posiciones2.get(i);
                  //Se obtinen datos de cada folio para saber cuanas veces exiten las tabalas siguientes (reserva_cabecera y reservas_posiciones_crea)          
                  //se declaran losindices auxiliares que definiran el nuemero de veces a imprimir cada fila
                          int cab=0;
                          int pos =0;
                        String cabecera = "";
                        String posiciones = "";
                        
                        LinkedList<String[]> datosCabecera=new LinkedList<String[]>();
                            String [] c= new String[20];
                        
                        LinkedList<String[]> datoPosiciones=new LinkedList<String[]>();
                        String [] p=new String[20];

                        //obtenemos los indices de las tbalas usando el folio sam o sap
                        if (datosMateriales[41].equals("")) {
                         String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ";
                         cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                         datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sap = '" +datosMateriales[0]+"'");
                         datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sap = '" +datosMateriales[0]+"'");
                         posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sap = '" + datosMateriales[0] + "' group by folio_sap ");
                        } else {
                          String query22 = "SELECT count(*) AS 'count' FROM reserva_cabecera_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ";
                          cabecera = ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero(query22);
                          datosCabecera=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaCabeceraCrea("SELECT * FROM reserva_cabecera_crea where folio_sam = '" +datosMateriales[41]+"'");
                          datoPosiciones=ACC_ReporteReservas.ObtenerInstancia().ConsultaReservaPosicionesCrea("SELECT * FROM reserva_posiciones_crea where folio_sam = '" +datosMateriales[41]+"'");
                          posiciones= ACC_ReporteReservas.ObtenerInstancia().ObtenerNumero("SELECT count(*) AS 'count' FROM reserva_posiciones_crea where folio_sam = '" + datosMateriales[41] + "' group by folio_sam ");
                        }
                   //Verficamos en que tabla se repit mas veces el folio_sam o folio sap, para imprimir
                   //ese numero de veces las fila con ese folio y si no existe niengun registro seteamos a 0 el indice
                        if(cabecera.equals("")){
                            cab = 0;
                        }else{cab =Integer.parseInt(cabecera);}
                        if(posiciones.equals("")){
                         pos = 0;
                        }else{pos =Integer.parseInt(posiciones);} 
                        //asignamos el nuemero mayor al indice aux
                        int aux = 0;                  
                        if (pos > cab) {
                            aux = pos;
                        } else {
                            aux = cab;
                        }
                        if (pos == 0 && cab ==0) {
                                 try{
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("<td>&nbsp</td>");
                            out.println("</tr>");
                            
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
                        }else if (pos < cab) {
                                 try{
                                     
                              for (int j = 0; j < aux; j++) {
                                
                                     c = datosCabecera.get(j);   
                                     if(datoPosiciones.size()>0){
                                      p = datoPosiciones.get(0);
                                     }        
                                     
                            out.println("<tr>");
                            out.println("<td>" +datosMateriales[0]+ "</td>");
                            out.println("<td>" +datosMateriales[1]+ "</td>");
                            out.println("<td>" +datosMateriales[10]+ "</td>");
                            out.println("<td>" +datosMateriales[22]+ "</td>");
                            out.println("<td>" +datosMateriales[5]+ "</td>");
                            out.println("<td>" +datosMateriales[26]+ "</td>");
                            out.println("<td>" +datosMateriales[11]+ "</td>");
                            out.println("<td>" +datosMateriales[6]+ "</td>");
                            out.println("<td>" +datosMateriales[7]+ "</td>");
                            out.println("<td>" +datosMateriales[12]+ "</td>");
                            out.println("<td>" +datosMateriales[15]+ "</td>");
                            out.println("<td>" +datosMateriales[2]+ "</td>");
                            out.println("<td>" +datosMateriales[3]+ "</td>");
                            out.println("<td>" +datosMateriales[4]+ "</td>");
                            out.println("<td>" +datosMateriales[8]+ "</td>");
                            out.println("<td>" +datosMateriales[9]+ "</td>");
                            out.println("<td>" +datosMateriales[13]+ "</td>");
                            out.println("<td>" +datosMateriales[14]+ "</td>");
                            out.println("<td>" +datosMateriales[16]+ "</td>");
                            out.println("<td>" +datosMateriales[17]+ "</td>");
                            out.println("<td>" +datosMateriales[18]+ "</td>");
                            out.println("<td>" +datosMateriales[19]+ "</td>");
                            out.println("<td>" +datosMateriales[20]+ "</td>");
                            out.println("<td>" +datosMateriales[21]+ "</td>");
                            out.println("<td>" +datosMateriales[23]+ "</td>");
                            out.println("<td>" +datosMateriales[24]+ "</td>");
                            out.println("<td>" +datosMateriales[25]+ "</td>");
                            out.println("<td>" +datosMateriales[27]+ "</td>");
                            out.println("<td>" +datosMateriales[28]+ "</td>");
                            out.println("<td>" +datosMateriales[29]+ "</td>");
                            out.println("<td>" +datosMateriales[30]+ "</td>");
                            out.println("<td>" +datosMateriales[31]+ "</td>");
                            out.println("<td>" +datosMateriales[32]+ "</td>");
                            out.println("<td>" +datosMateriales[33]+ "</td>");
                            out.println("<td>" +datosMateriales[34]+ "</td>");
                            out.println("<td>" +datosMateriales[35]+ "</td>");
                            out.println("<td>" +datosMateriales[36]+ "</td>");
                            out.println("<td>" +datosMateriales[37]+ "</td>");
                            out.println("<td>" +datosMateriales[38]+ "</td>");
                            out.println("<td>" +datosMateriales[39]+ "</td>");
                            out.println("<td>" +datosMateriales[40]+ "</td>");
                            out.println("<td>" +datosMateriales[41]+ "</td>");
                             out.println("<td>" + c[0]+ "</td>");
                            out.println("<td>" + c[1]+ "</td>");
                            out.println("<td>" + c[2]+ "</td>");
                            out.println("<td>" + c[3]+ "</td>");
                            out.println("<td>" + c[4]+ "</td>");
                            out.println("<td>" + c[5]+ "</td>");
                            out.println("<td>" + c[6]+ "</td>");
                            out.println("<td>" + c[7]+ "</td>");
                            out.println("<td>" + c[8]+ "</td>");
                            out.println("<td>" + c[9]+ "</td>");
                            out.println("<td>" + c[10]+ "</td>");
                            out.println("<td>" + c[11]+ "</td>");
                            out.println("<td>" + p[0]+ "</td>");
                            out.println("<td>" + p[1]+ "</td>");
                            out.println("<td>" + p[2]+ "</td>");
                            out.println("<td>" + p[3]+ "</td>");
                            out.println("<td>" + p[4]+ "</td>");
                            out.println("<td>" + p[5]+ "</td>");
                            out.println("<td>" + p[6]+ "</td>");
                            out.println("<td>" + p[7]+ "</td>");
                            out.println("<td>" + p[8]+ "</td>");
                            out.println("<td>" + p[9]+ "</td>");
                            out.println("<td>" + p[10]+ "</td>");
                            out.println("<td>" + p[11]+ "</td>");
                            out.println("<td>" + p[12]+ "</td>");
                            out.println("<td>" + p[13]+ "</td>");
                            out.println("<td>" + p[14]+ "</td>");
                            out.println("<td>" + p[15]+ "</td>");
                            out.println("<td>" + p[16]+ "</td>");
                            out.println("</tr>");
                              }
                            }catch(Exception ex){System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);}
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
