/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import AccesoDatos.ACC_Almacenes;
import AccesoDatos.ACC_Centro;
import AccesoDatos.ACC_CentroCosto;
import AccesoDatos.ACC_ClaveMoneda;
import AccesoDatos.ACC_CuentaMayor;
import AccesoDatos.ACC_Folios;
import AccesoDatos.ACC_GrupoArticulos;
import AccesoDatos.ACC_GrupoCompras;
import AccesoDatos.ACC_Material;
import AccesoDatos.ACC_Orden;
import AccesoDatos.ACC_OrganizacionCompras;
import AccesoDatos.ACC_Servicios;
import AccesoDatos.ACC_SolicitudPedidos;
import AccesoDatos.ACC_Textos_posiciones_solped;
import AccesoDatos.ACC_TipoImputacion;
import AccesoDatos.ACC_TipoPosicion;
import AccesoDatos.ACC_UnidadesMedida;
import AccesoDatos.Consultas;
import Entidades.CeCos;
import Entidades.SolpedCrea;
import Entidades.almacenes;
import Entidades.centros;
import Entidades.folios;
import Entidades.grupo_articulos;
import Entidades.grupo_compras;
import Entidades.materiales;
import Entidades.organizacion_compras;
import Entidades.plan_orden;
import Entidades.servicios;
import Entidades.textos_posiciones_solped;
import Entidades.tipo_imputacion;
import Entidades.tipo_posicion;
import Entidades.unidades_medida;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "peticionCrearSolPed", urlPatterns = {"/peticionCrearSolPed"})
public class peticionCrearSolPed extends HttpServlet {

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
            String Usu = (String) session.getAttribute("Usuario");
            String Accion = request.getParameter("Accion");
            String Ctd = request.getParameter("Ctd");
            String Idioma = (String) session.getAttribute("Idioma");

            ///////// Tipo de Imputacion variables 
            /// Organizacion Compras 
            String OCompras = request.getParameter("OCompras");
            //// Grupo Compras 
            String GCompras = request.getParameter("GCompras");
            String DenGCompras = request.getParameter("DenGCompras");
            //// Tipo de Imputacion
            String TipoImp = request.getParameter("TipoImp");
            //////// Tipo Posicion
            String TipoPos = request.getParameter("TipoPos");
            /////// Material
            String Tips = request.getParameter("tipoSolp");
            String Material = request.getParameter("Material");
            String TextoMat = request.getParameter("TextoMat");
            String Centro = request.getParameter("Centro");
            String TipM = request.getParameter("Tipo");
            /////// Centro
            String CentroSP = request.getParameter("CentroSP");
            String CentroNomSP = request.getParameter("CentroNomSP");
            /// Almacen
            String DenAlm = request.getParameter("DenAlm");
            String Almacen = request.getParameter("Almacen");
            ////// Unidad Medida
            String UM = request.getParameter("UM");
            String TextoUM = request.getParameter("TextoUM");
            ///// Grupo Articulos
            String GArt = request.getParameter("GArt");
            String DGArt = request.getParameter("DGArt");
            String DSGArt = request.getParameter("DSGArt");
            ///// Cuenta Mayor
            String NCuenta = request.getParameter("NCuenta");
            String DNCuenta = request.getParameter("DNCuenta");
            ///// Centro Costo
            String CCosto = request.getParameter("CCosto");
            String DCCosto = request.getParameter("DCCos");
            String Sociedad = request.getParameter("Sociedad");
            ////// Orden
            String ClOrden = request.getParameter("ClaseOrden");
            String Orden = request.getParameter("Orden");
            String DOrden = request.getParameter("DOrd");
            ////// Servicios
            String Servicio = request.getParameter("Servicio");
            String DServicio = request.getParameter("DServicio");
            ////// IP de usuario
            String ipsf = request.getParameter("ipsf");            
            //////
            String dato = request.getParameter("dato");
            String CVal = request.getParameter("CVAL");
            Consultas con = new Consultas();

            switch (Accion) {
                case "VerificarFolio":
                    folios f = ACC_Folios.ObtenerIstancia().ObtenerFolioExcedido("SP");
                    int folf = f.getFolioFinal();
                    int folA = f.getFolioActual();
                    if (folA > folf) {
                        out.println(1);
                    }
                    break;
                case "ConusltarTipoSolped":
                    String lan1 = "denominacion_doc_compras_" + Idioma;
                    ArrayList<String[]> ndata = ACC_SolicitudPedidos.ObtenerInstancia().ObteneTipoSolped(lan1, Centro);
                    out.println("<option></option>");
                    for (int c = 0; c < ndata.size(); c++) {
                        out.println("<option value=\"" + ndata.get(c)[0] + "\">" + ndata.get(c)[0] + "&nbsp;" + ndata.get(c)[1] + "</option>");
                    }
                    break;
                case "ConsultarOCompras":
                    ArrayList<organizacion_compras> oc = ACC_OrganizacionCompras.ObtenerInstancia().ConsultaMCOrgCompras();
                    for (int c = 0; c < oc.size(); c++) {
                        out.println("<option>" + oc.get(c).getOrganizacion_compras() + "</option>");
                    }
                    break;
                case "ConsultarGCompras":
                    ArrayList<grupo_compras> gc = ACC_GrupoCompras.ObtenerInstancia().ConsultaMCGrupoCompras(GCompras, DenGCompras, Integer.parseInt(Ctd));
                    if (gc.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < gc.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + gc.get(i).getId_grupo_compras() + "','VentanaModalGCompras','BuscarParamGCompras_SP','ConsultaTablaGCompras','GpoCompras')\" >");
                            out.println("<td>" + gc.get(i).getId_grupo_compras() + "</td>");
                            out.println("<td>" + gc.get(i).getDenominacion_grupocompras() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");

                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarTipoImputacion":
                    String Des = "descripcion_" + Idioma;
                    ArrayList<tipo_imputacion> ti = ACC_TipoImputacion.ObtenerInstancia().CargarTipoImputacion(Des);
                    out.println("<option></option>");
                    for (int t = 0; t < ti.size(); t++) {
                        out.println("<option value=\"" + ti.get(t).getTipo_imputacion() + "\">" + ti.get(t).getTipo_imputacion() + "&nbsp;&nbsp;" + ti.get(t).getDescripcion() + "</option>");
                    }
                    break;
                case "ConsultarTipoPosicion":
                    String Desc = "descripcion_" + Idioma;
                    ArrayList<tipo_posicion> tp = ACC_TipoPosicion.ObtenerInstancia().CargarTipoPosicion(Desc);
                    out.println("<option></option>");
                    for (int t = 0; t < tp.size(); t++) {
                        out.println("<option  value=\"" + tp.get(t).getTipo_posicion() + "\">" + tp.get(t).getTipo_posicion() + "&nbsp;&nbsp;" + tp.get(t).getDescripcion() + "</option>");
                    }
                    break;
                case "ConsultarMateriales":
                    String desMat = "descripcion_" + Idioma;
                    ArrayList<materiales> m = ACC_Material.ObtenerInstancia().CargarMaterialMCSolped(Material, TextoMat, Centro, TipM, desMat, Ctd, Usu, Tips);
                    if (m.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < m.size(); i++) {
                            out.println("<tr ondblclick=\"SelectMaterial('" + m.get(i).getMaterial() + "', '" + m.get(i).getDescripcion() + "', '" + m.get(i).getUnidad_medida() + "', '" + m.get(i).getGrupo_articulos() + "', '" + m.get(i).getCentro() + "', '" + m.get(i).getCategoria_valoracion() + "')\" >");
                            out.println("<td>" + m.get(i).getMaterial() + "</td>");
                            out.println("<td>" + m.get(i).getDescripcion() + "</td>");
                            out.println("<td>" + m.get(i).getCentro() + "</td>");
                            out.println("<td>" + m.get(i).getTipo_material() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarCentro":
                    ArrayList<centros> ce = ACC_Centro.ObtenerInstancia().ConsultarCentros(CentroSP, CentroNomSP, Integer.parseInt(Ctd));
                    if (ce.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ce.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + ce.get(i).getCentro() + "','VentanaModalCentro','BuscarParamCentro_SP','ConsultaTablaCentro','Centro')\" >");
                            out.println("<td>" + ce.get(i).getCentro() + "</td>");
                            out.println("<td>" + ce.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarAlmacen":
                    String desAlm = "descripcion_" + Idioma;
                    ArrayList<almacenes> al = ACC_Almacenes.ObtenerInstancia().ConsultaMCAlmacenSolped(Almacen, DenAlm, CentroSP, desAlm, Ctd);
                    if (al.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < al.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + al.get(i).getId_almacen() + "','VentanaModalAlmacen','BuscarParamAlmacen_SP','ConsultaTablaAlmacen','Almacen')\" >");
                            out.println("<td>" + al.get(i).getId_almacen() + "</td>");
                            out.println("<td>" + al.get(i).getNombre_alamcen() + "</td>");
                            out.println("<td>" + al.get(i).getCentro() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarUM":
                    String DeUM = "descripcion_" + Idioma;
                    ArrayList<unidades_medida> ume = ACC_UnidadesMedida.ObtenerInstancia().ConsultaMCUnidadMedida(UM, TextoUM, DeUM, Ctd);
                    if (ume.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < ume.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + ume.get(i).getUnidad_medida() + "','VentanaModalUM','BuscarParamUM_SP','ConsultaTablaUM','unidamedida')\" >");
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
                case "ConsultarGArticulos":
                    String desga = "descripcion_" + Idioma;
                    String DenGa = "denominacion_" + Idioma;
                    ArrayList<grupo_articulos> gar = ACC_GrupoArticulos.ObtenerInstancia().ConsultaMCGrupoArticulos(GArt, DGArt, DSGArt, DenGa, desga, Ctd);
                    if (gar.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int i = 0; i < gar.size(); i++) {
                            out.println("<tr ondblclick=\"SelectData('" + gar.get(i).getGrupo_articulo() + "','VentanaModalGArticulos','BuscarParamGArticulos_SP','ConsultaTablaGArticulos','GpoArticulo')\" >");
                            out.println("<td>" + gar.get(i).getGrupo_articulo() + "</td>");
                            out.println("<td>" + gar.get(i).getDenominacion() + "</td>");
                            out.println("<td>" + gar.get(i).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }

                    break;
                case "ConsultarCMayor":
                    ArrayList<CeCos> cm = ACC_CuentaMayor.ObtenerInstancia().ConsultaMCCuentaMayor(NCuenta, DNCuenta, Integer.parseInt(Ctd), Usu);
                    if (cm.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int n = 0; n < cm.size(); n++) {
                            out.println("<tr ondblclick=\"SelectData('" + cm.get(n).getClaseCoste() + "','VentanaModalCuentaMayor','BuscarParamCuentaMayor','ConsultaTablaCMayor','ctaMayor')\">");
                            out.println("<td>" + cm.get(n).getClaseCoste() + "</td>");
                            out.println("<td>" + cm.get(n).getDescripcion() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarCCosto":
                    ArrayList<CeCos> cc = ACC_CentroCosto.ObtenerInstancia().ConsultaMCCentroCoste(CCosto, DCCosto, Sociedad, Integer.parseInt(Ctd), Usu);
                    if (cc.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int n = 0; n < cc.size(); n++) {
                            out.println("<tr ondblclick=\"SelectData('" + cc.get(n).getCentroCos() + "','VentanaModalCentroCosto','BuscarParamCCosto','ConsultaTablaCCosto','CenCosto')\">");
                            out.println("<td>" + cc.get(n).getCentroCos() + "</td>");
                            out.println("<td>" + cc.get(n).getDenominacion() + "</td>");
                            out.println("<td>" + cc.get(n).getSociedad() + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ConsultarOrden":
                    ArrayList<plan_orden> po = ACC_Orden.ObtenerInstancia().ObtenerDatosMatchOrdenes(ClOrden, Orden, DOrden);
                    if (po.size() > 0) {
                        if (Ctd.length() > 0) {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int n = 0; n < Integer.parseInt(Ctd); n++) {
                                out.println("<tr ondblclick=\"SelectOrden('" + po.get(n).getNum_orden() + "','" + po.get(n).getFolio_sam() + "')\">");
                                out.println("<td>" + po.get(n).getNum_orden() + "</td>");
                                out.println("<td>" + po.get(n).getFolio_sam() + "</td>");
                                out.println("<td>" + po.get(n).getTexto_breve() + "</td>");
                                out.println("<td>" + po.get(n).getClase_doc_ventas() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        } else {
                            out.println("<table>");
                            out.println("<tbody>");
                            for (int n = 0; n < po.size(); n++) {
                                out.println("<tr ondblclick=\"Select('" + po.get(n).getNum_orden() + "','Orden')\">");
                                out.println("<td>" + po.get(n).getNum_orden() + "</td>");
                                out.println("<td>" + po.get(n).getTexto_breve() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            out.println("</table>");
                        }
                    } else {
                        out.println(0);
                    }
                    break;

                case "ConsultarServicios":
                    String valSer = (String) session.getAttribute("ValorFServicio");
                    String DesSer = "descripcion_" + Idioma;
                    ArrayList<servicios> se = ACC_Servicios.ObtenerInstancia().CargarMCServicios(Servicio, DServicio, DesSer, Ctd);
                    if (se.size() > 0) {
                        out.println("<table>");
                        out.println("<tbody>");
                        for (int s = 0; s < se.size(); s++) {
                            out.println("<tr ondblclick=\"SelectServicio('" + se.get(s).getServicio() + "','" + se.get(s).getDescripcion() + "', '" + se.get(s).getUnidad_medida() + "', '" + valSer + "')\">");
                            out.println("<td>" + se.get(s).getServicio() + "</td>");
                            out.println("<td>" + se.get(s).getDescripcion() + "</td>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarGCompras":
                    if (ACC_GrupoCompras.ObtenerInstancia().ValidarGCompras(GCompras)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarMate":
                    String desMate = "descripcion_" + Idioma;
                    materiales mat = ACC_Material.ObtenerInstancia().ValidarMaterial(Material, desMate, Centro, Usu, Tips);
                    if (mat.getMaterial().equals("") || mat.getMaterial() == null) {
                        out.println(1);
                    } else {
                        JSONArray j = new JSONArray();
                        j.add(mat.getMaterial());
                        j.add(mat.getCentro());
                        j.add(mat.getDescripcion());
                        j.add(mat.getUnidad_medida());
                        j.add(mat.getGrupo_articulos());
                        out.println(j);
                    }
                    break;
                case "ValidarCentro":
                    if (ACC_Centro.ObtenerInstancia().ValidarCentroSP(CentroSP)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarAlmacen":
                    if (ACC_Almacenes.ObtenerInstancia().ValidarAlmaceSP(Almacen)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarUMedida":
                    if (ACC_UnidadesMedida.ObtenerInstancia().ValidarUMedida(UM)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "ValidarGArticulo":
                    if (ACC_GrupoArticulos.ObtenerInstancia().ValidarGArticulo(GArt)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "validarCMayor":
                    if (ACC_CuentaMayor.ObtenerInstancia().ValidarCMayor(NCuenta, Usu)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;
                case "validarCCosto":
                    if (ACC_CentroCosto.ObtenerInstancia().ValidarCCosto(CCosto, Usu)) {
                        out.println(1);
                    }
                    break;
                case "validarOrden":
                    String sali[] = ACC_Orden.ObtenerInstancia().ValidarOrden(Orden);
                    if (sali[0] == "" || sali[0] == null) {
                        out.println(2);
                    } else {
                        String cad = "" + sali[0] + "," + sali[1] + "";
                        out.println(cad);
                    }
                    break;
                case "ValidarCentroCuenta":
                    if (ACC_CuentaMayor.ObtenerInstancia().validarCCCM(NCuenta, CCosto)) {
                        out.println(1);
                    } else {
                        out.println(0);
                    }
                    break;

                case "umed":
                    String resum = ACC_Material.ObtenerInstancia().GetDecUM(UM);
                    out.println(resum);
                    break;

                case "ValidarServiciopos":
                    servicios s = ACC_Servicios.ObtenerInstancia().ObtenerServici(Servicio, Idioma);
                    JSONArray jse = new JSONArray();
                    jse.add(s.getServicio());
                    jse.add(s.getDescripcion());
                    jse.add(s.getUnidad_medida());
                    if (s.getServicio().equals("") || s.getServicio().equals(null)) {
                        out.println(2);
                    } else {
                        out.println(jse);
                    }
                    break;
                case "ValidarCatValMate":
                    String deMate = "descripcion_" + Idioma;
                    materiales mt = ACC_Material.ObtenerInstancia().ValidarMaterial(dato, deMate, Centro, Usu, Tips);
                    String cv = mt.getCategoria_valoracion();
                    int d = ACC_Material.ObtenerInstancia().RelacionCMMaterial(cv, NCuenta);
                    out.println(d);

                    break;
                case "GetCMayorMate":
                    String cvalo = ACC_Material.ObtenerInstancia().obtenerCuentaMayor(CVal);
                    out.println(cvalo);
                    break;
                case "GetCVSer":
                    String sad = ACC_Servicios.ObtenerInstancia().GetCavalor(Servicio);
                    out.println(sad);
                    break;
                case "CargarListaPos":
                    ArrayList<SolpedCrea> spl = ACC_SolicitudPedidos.ObtenerInstancia().CargarPosicion(Usu,ipsf);
                    out.println("<option></option>");
                    for (int c = 0; c < spl.size(); c++) {
                        out.println("<option>" + spl.get(c).getNum_posicion_solped() + "</option>");
                    }
                    break;
                case "Limpiartabla":
                    out.println("<table>");
                    out.println("<tbody>");
                    for (int c = 0; c < 10; c++) {
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
                case "Limpiartemporal":
                    ACC_SolicitudPedidos.ObtenerInstancia().BorrarTemporal(Usu,ipsf);
                    ACC_Textos_posiciones_solped.ObtenerInstancia().EliminarTxtTemp(Usu,ipsf);
                    ACC_Servicios.ObtenerInstancia().EliminarSerTemporal(Usu,ipsf);
                    break;
                case "CargarDatosPosicion":
                    SolpedCrea sc = ACC_SolicitudPedidos.ObtenerInstancia().ObtenerDatosposicion(dato, Usu,ipsf);
                    JSONArray JSol = new JSONArray();
                    JSol.add(sc.getNum_material());
                    JSol.add(sc.getCantidad_solped());
                    JSol.add(con.DateFormat(sc.getFecha_entraga_posicion()));
                    JSol.add(sc.getCentro());
                    JSol.add(sc.getAlmacen());
                    JSol.add(sc.getTexto_breve());
                    JSol.add(sc.getUnidad_medida_solped());
                    JSol.add(sc.getGrupo_articulos());
                    JSol.add(sc.getNum_cuenta_mayor());
                    JSol.add(sc.getCentro_coste());
                    JSol.add(sc.getNum_orden());
                    JSol.add(sc.getTipo_imputacion());
                    JSol.add(sc.getTipo_posicion_doc_compras());
                    out.println(JSol);
                    break;
                case "CargartTxtPos":
                    ArrayList<textos_posiciones_solped> tx = ACC_Textos_posiciones_solped.ObtenerInstancia().CargarTextoPosicionTemp(Usu, dato,ipsf);
                    JSONArray jat = new JSONArray();
                    String arr = "";
                    for (int i = 0; i < tx.size(); i++) {
                        arr += tx.get(i).getLinea_texto();
                    }
                    jat.add(arr);
                    out.println(jat);
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
