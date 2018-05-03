/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.ListadoOrdenesPP;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entidades.StatusOrdenes;
import java.sql.Statement;

/**
 *
 * @author Panda
 */
public class ACC_ListadoOrdenesPP {

    private static ACC_ListadoOrdenesPP instance = null;

    public static ACC_ListadoOrdenesPP ObtenerInstancia() {
        if (instance == null) {
            instance = new ACC_ListadoOrdenesPP();
        }
        return instance;
    }

    public ArrayList<ListadoOrdenesPP> ObtenerListaOrdenesPP() {
        ArrayList<ListadoOrdenesPP> lo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        PreparedStatement ps2;
        ResultSet rs;
        ResultSet rs2;
        int c = 0;

        String sql = "{CALL PP.pla_pp_listaOrdenes()}";//Modificar a inner join para ordenes creadas en SAM
        String sql2 = "{CALL PP.habilitado_control(?,?)}";
        try {
            ps = con.prepareStatement(sql);
//            ps.setString(1, mm);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoOrdenesPP ll = new ListadoOrdenesPP();
                ll.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                ll.setNum_orden(rs.getString("num_orden"));
                ll.setFolio_sam(rs.getString("folio_sam"));
                ll.setCentro(rs.getString("centro"));
                ll.setNum_material(rs.getString("num_material"));
                ll.setTexto_material(rs.getString("texto_material"));
                ll.setStatus(rs.getString("status"));
                ll.setCantidad_total(rs.getString("cantidad_total"));
                ll.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ll.setContador_notificacion(rs.getString("contador_notificacion"));
                if(rs.getString("txt_mensaje") != null){ ll.setMensaje(rs.getString("txt_mensaje")); }
                ps2 = con.prepareStatement(sql2);
                ps2.setString(1, ll.getFolio_sam());
                ps2.setString(2, ll.getNum_orden());
                rs2 = ps2.executeQuery();
                rs2.next();
                if(rs2.getInt("resultado") == 1){
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\">");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }else{
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked>");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }
                c++;
                lo.add(ll);
            }

        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP, ObtenerListaOrdenesPP(): " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lo;
    }
    //Metodo para el Monitor PP por centro
    public ArrayList<ListadoOrdenesPP> ObtenerListaOrdenesPPCentro(String centro) {
        ArrayList<ListadoOrdenesPP> lo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        PreparedStatement ps2;
        ResultSet rs;
        ResultSet rs2;
        int c = 0;

        String sql = "{CALL PP.pla_pp_listaOrdenesCentro(?)}";//Modificar a inner join para ordenes creadas en SAM
        String sql2 = "{CALL PP.habilitado_control(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, centro);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoOrdenesPP ll = new ListadoOrdenesPP();
                ll.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                ll.setNum_orden(rs.getString("num_orden"));
                ll.setFolio_sam(rs.getString("folio_sam"));
                ll.setCentro(rs.getString("centro"));
                ll.setNum_material(rs.getString("num_material"));
                ll.setTexto_material(rs.getString("texto_material"));
                ll.setStatus(rs.getString("status"));
                ll.setCantidad_total(rs.getString("cantidad_total"));
                ll.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ll.setContador_notificacion(rs.getString("contador_notificacion"));
                if(rs.getString("txt_mensaje") != null){ ll.setMensaje(rs.getString("txt_mensaje")); }
                ps2 = con.prepareStatement(sql2);
                ps2.setString(1, ll.getFolio_sam());
                ps2.setString(2, ll.getNum_orden());
                rs2 = ps2.executeQuery();
                rs2.next();
                if(rs2.getInt("resultado") == 1){
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\">");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }else{
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked>");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }
                c++;
                lo.add(ll);
            }

        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP, ObtenerListaOrdenesPP(): " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lo;
    }
    //Metodo para el Monitor PP por Folio
    public ArrayList<ListadoOrdenesPP> ObtenerListaOrdenesPPFolio(String folio) {
        ArrayList<ListadoOrdenesPP> lo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        PreparedStatement ps2;
        ResultSet rs;
        ResultSet rs2;
        int c = 0;

        String sql = "{CALL PP.pla_pp_listaOrdenesFolio(?)}";//Modificar a inner join para ordenes creadas en SAM
        String sql2 = "{CALL PP.habilitado_control(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoOrdenesPP ll = new ListadoOrdenesPP();
                ll.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                ll.setNum_orden(rs.getString("num_orden"));
                ll.setFolio_sam(rs.getString("folio_sam"));
                ll.setCentro(rs.getString("centro"));
                ll.setNum_material(rs.getString("num_material"));
                ll.setTexto_material(rs.getString("texto_material"));
                ll.setStatus(rs.getString("status"));
                ll.setCantidad_total(rs.getString("cantidad_total"));
                ll.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ll.setContador_notificacion(rs.getString("contador_notificacion"));
                if(rs.getString("txt_mensaje") != null){ ll.setMensaje(rs.getString("txt_mensaje")); }
                ps2 = con.prepareStatement(sql2);
                ps2.setString(1, ll.getFolio_sam());
                ps2.setString(2, ll.getNum_orden());
                rs2 = ps2.executeQuery();
                rs2.next();
                if(rs2.getInt("resultado") == 1){
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\">");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }else{
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked>");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }
                c++;
                lo.add(ll);
            }

        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP, ObtenerListaOrdenesPP(): " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lo;
    }
    //Metodo para el Monitor PP por Material
    public ArrayList<ListadoOrdenesPP> ObtenerListaOrdenesPPMaterial(String material) {
        ArrayList<ListadoOrdenesPP> lo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        PreparedStatement ps2;
        ResultSet rs;
        ResultSet rs2;
        int c = 0;

        String sql = "{CALL PP.pla_pp_listaOrdenesMaterial(?)}";//Modificar a inner join para ordenes creadas en SAM
        String sql2 = "{CALL PP.habilitado_control(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, material);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoOrdenesPP ll = new ListadoOrdenesPP();
                ll.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                ll.setNum_orden(rs.getString("num_orden"));
                ll.setFolio_sam(rs.getString("folio_sam"));
                ll.setCentro(rs.getString("centro"));
                ll.setNum_material(rs.getString("num_material"));
                ll.setTexto_material(rs.getString("texto_material"));
                ll.setStatus(rs.getString("status"));
                ll.setCantidad_total(rs.getString("cantidad_total"));
                ll.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ll.setContador_notificacion(rs.getString("contador_notificacion"));
                if(rs.getString("txt_mensaje") != null){ ll.setMensaje(rs.getString("txt_mensaje")); }
                ps2 = con.prepareStatement(sql2);
                ps2.setString(1, ll.getFolio_sam());
                ps2.setString(2, ll.getNum_orden());
                rs2 = ps2.executeQuery();
                rs2.next();
                if(rs2.getInt("resultado") == 1){
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\">");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }else{
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked>");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }
                c++;
                lo.add(ll);
            }

        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP, ObtenerListaOrdenesPP(): " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lo;
    }
    //Metodo para el Monitor PP por Centro y Folio
    public ArrayList<ListadoOrdenesPP> ObtenerListaOrdenesPPCenFol(String centro, String folio) {
        ArrayList<ListadoOrdenesPP> lo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        PreparedStatement ps2;
        ResultSet rs;
        ResultSet rs2;
        int c = 0;

        String sql = "{CALL PP.pla_pp_listaOrdenesCentroFol(?,?)}";//Modificar a inner join para ordenes creadas en SAM
        String sql2 = "{CALL PP.habilitado_control(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, centro);
            ps.setString(2, folio);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoOrdenesPP ll = new ListadoOrdenesPP();
                ll.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                ll.setNum_orden(rs.getString("num_orden"));
                ll.setFolio_sam(rs.getString("folio_sam"));
                ll.setCentro(rs.getString("centro"));
                ll.setNum_material(rs.getString("num_material"));
                ll.setTexto_material(rs.getString("texto_material"));
                ll.setStatus(rs.getString("status"));
                ll.setCantidad_total(rs.getString("cantidad_total"));
                ll.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ll.setContador_notificacion(rs.getString("contador_notificacion"));
                if(rs.getString("txt_mensaje") != null){ ll.setMensaje(rs.getString("txt_mensaje")); }
                ps2 = con.prepareStatement(sql2);
                ps2.setString(1, ll.getFolio_sam());
                ps2.setString(2, ll.getNum_orden());
                rs2 = ps2.executeQuery();
                rs2.next();
                if(rs2.getInt("resultado") == 1){
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\">");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }else{
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked>");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }
                c++;
                lo.add(ll);
            }

        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP, ObtenerListaOrdenesPP(): " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lo;
    }
    //Metodo para el Monitor PP por Centro y Material
    public ArrayList<ListadoOrdenesPP> ObtenerListaOrdenesPPCenMat(String centro, String material) {
        ArrayList<ListadoOrdenesPP> lo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        PreparedStatement ps2;
        ResultSet rs;
        ResultSet rs2;
        int c = 0;

        String sql = "{CALL PP.pla_pp_listaOrdenesCentroMate(?,?)}";//Modificar a inner join para ordenes creadas en SAM
        String sql2 = "{CALL PP.habilitado_control(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, centro);
            ps.setString(2, material);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoOrdenesPP ll = new ListadoOrdenesPP();
                ll.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                ll.setNum_orden(rs.getString("num_orden"));
                ll.setFolio_sam(rs.getString("folio_sam"));
                ll.setCentro(rs.getString("centro"));
                ll.setNum_material(rs.getString("num_material"));
                ll.setTexto_material(rs.getString("texto_material"));
                ll.setStatus(rs.getString("status"));
                ll.setCantidad_total(rs.getString("cantidad_total"));
                ll.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ll.setContador_notificacion(rs.getString("contador_notificacion"));
                if(rs.getString("txt_mensaje") != null){ ll.setMensaje(rs.getString("txt_mensaje")); }
                ps2 = con.prepareStatement(sql2);
                ps2.setString(1, ll.getFolio_sam());
                ps2.setString(2, ll.getNum_orden());
                rs2 = ps2.executeQuery();
                rs2.next();
                if(rs2.getInt("resultado") == 1){
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\">");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }else{
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked>");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }
                c++;
                lo.add(ll);
                System.out.println("Error datos por: " + lo.size());
            }

        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP, ObtenerListaOrdenesPP(): " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lo;
    }
    //Metodo para el Monitor PP por Folio y Material
    public ArrayList<ListadoOrdenesPP> ObtenerListaOrdenesPPFolMat(String folio, String material) {
        ArrayList<ListadoOrdenesPP> lo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        PreparedStatement ps2;
        ResultSet rs;
        ResultSet rs2;
        int c = 0;
        String sql = "{CALL PP.pla_pp_listaOrdenesFolioMate(?,?)}";//Modificar a inner join para ordenes creadas en SAM
        String sql2 = "{CALL PP.habilitado_control(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, material);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoOrdenesPP ll = new ListadoOrdenesPP();
                ll.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                ll.setNum_orden(rs.getString("num_orden"));
                ll.setFolio_sam(rs.getString("folio_sam"));
                ll.setCentro(rs.getString("centro"));
                ll.setNum_material(rs.getString("num_material"));
                ll.setTexto_material(rs.getString("texto_material"));
                ll.setStatus(rs.getString("status"));
                ll.setCantidad_total(rs.getString("cantidad_total"));
                ll.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ll.setContador_notificacion(rs.getString("contador_notificacion"));
                if(rs.getString("txt_mensaje") != null){ ll.setMensaje(rs.getString("txt_mensaje")); }
                ps2 = con.prepareStatement(sql2);
                ps2.setString(1, ll.getFolio_sam());
                ps2.setString(2, ll.getNum_orden());
                rs2 = ps2.executeQuery();
                rs2.next();
                if(rs2.getInt("resultado") == 1){
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\">");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }else{
                    if(rs.getString("status").substring(0, 4).equals("LIB.")){
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked>");
                    }else{
                        ll.setHabilitado("<input type=\"checkbox\" name=\"habilitado\" value=\"" + c + "\" checked disabled>");
                    }
                }
                c++;
                lo.add(ll);
                System.out.println("Error datos por: " + lo.size());
            }

        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP, ObtenerListaOrdenesPP(): " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lo;
    }
    
    public void guardaStatusOrden(StatusOrdenes so){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PP.guardaStatusOrden(?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement pss = con.prepareStatement(query);
            pss.setString(1, so.getFolio_sam());
            pss.setString(2, so.getFolio_orden());
            pss.setString(3, so.getFecha_serv());
            pss.setString(4, so.getHora_serv());
            pss.setString(5, so.getNum_orden());
            pss.setString(6, so.getCentro());
            pss.setString(7, so.getOperacion_sam());
            pss.setString(8, so.getUsuario());
            pss.setString(9, so.getStatus());
            pss.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP(), guardaStatusOrden() por: " + e);
        }
        cnx.CerrarConexion(con);
    }
    
    public void CambiaStatusOrden(StatusOrdenes so, String nsts){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PP.cambiarStatusOrdenesPP(?,?,?)}";
        try {
            PreparedStatement pss = con.prepareStatement(query);
            pss.setString(1, so.getNum_orden());
            pss.setString(2, so.getFolio_orden());
            pss.setString(3, nsts);
            pss.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP(), CambiaStatusOrden() por: " + e);
        }
        cnx.CerrarConexion(con);
    }
    
    public void GuardaHabilitado(StatusOrdenes so){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PP.control_listadoOrdenesPP_Inserta(?,?,?,?,?,?)}";
        try {
            PreparedStatement pss = con.prepareStatement(query);
            pss.setString(1, so.getNum_orden());
            pss.setString(2, so.getFolio_sam());
            pss.setString(3, so.getOperacion_sam());
            pss.setString(4, so.getStatus());
            pss.setString(5, so.getCentro());
            pss.setString(6, so.getNum_lote());
            pss.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP(), GuardaHabilitado() por: " + e);
        }
        cnx.CerrarConexion(con);
    }
    public void truncateControl(){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PP.Truncate_controlListaPP}";
        try {
            PreparedStatement pss = con.prepareStatement(query);
            pss.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP(), truncateControl() por: " + e);
        }
        cnx.CerrarConexion(con);
    }    
    public ArrayList<StatusOrdenes> SAMStatusSO(String folOrd, String CentroOrd, String CtdOrd) {
        ArrayList<StatusOrdenes> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PP.ListaOrdenesFabTodosFolios(?,?,?)}");
            pst.setString(1, folOrd);
            pst.setString(2, CentroOrd);
            pst.setString(3, CtdOrd);
            rs = pst.executeQuery();
            while (rs.next()) {
                StatusOrdenes so = new StatusOrdenes();                
                so.setNum_orden(rs.getString("num_orden"));
                so.setCentro(rs.getString("centro"));
                sam.add(so);
            }
        } catch (Exception e) {
            System.err.println("Error en CentroReservass, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }
       
    public ArrayList<StatusOrdenes> SAPStatusOP(String folMate, String CentroMate, String CtdMate) {
        ArrayList<StatusOrdenes> sap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ListaOrdenesFabTodosMaterial(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, folMate);
            pst.setString(2, CentroMate);
            pst.setString(3, CtdMate);
            rs = pst.executeQuery();
            while (rs.next()) {
                StatusOrdenes so = new StatusOrdenes();                
                so.setNum_material(rs.getString("num_material"));
                so.setCentro(rs.getString("centro"));
                sap.add(so);
            }
        } catch (Exception ex) {
            System.err.println("ERROR en el metodo SAPStatus por :" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sap;
    }
    //Validar Centro de Filtros 
    public boolean ValidarCentro(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReportesNotificacionesValidacionCentro(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo werewerweValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }
    //Validar Folio de Filtros
    /*[ReportesStatusOrdenesPP] STOREPROCEDURE VALIDAR SAM*/
    public boolean ValidarSamStatusSO(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        boolean ban = false;
        ResultSet rs = null;
        String query = "{call PP.ListaOrdenesFab_ValidarStatusSam(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }
        return ban;
    }
    //Validar Num de Orden Filtros
    public boolean ValidarSaPStatusSO(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean band = false;
        String query = "{call PP.ListaOrdenesFab_ValidarStatusMaterial(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                band = true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return band;
    }
    //Consulta Todos Status Ordenes PP
    public ArrayList<StatusOrdenes> PP_Reporte_StatusTodosSO(String centros, String foliosam, String foliosap) {
        ArrayList<StatusOrdenes> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.Reporte_StatusOrdenesPPTodos(?,?,?,?,?,?,?)}");            
            pst.setString(1, centros);
            pst.setString(2, foliosam);            
            pst.setString(3, foliosap);            
            rs = pst.executeQuery();
            while (rs.next()) {
                StatusOrdenes or = new StatusOrdenes();
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_serv(rs.getString("fecha_serv"));
                or.setHora_serv(rs.getString("hora_serv"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setCentro(rs.getString("centro"));
                or.setOperacion_sam(rs.getString("operacion_sam"));
                or.setUsuario(rs.getString("usuario"));                                                            
                sp_todos.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_todos;
    }
}
