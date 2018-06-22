/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.FlujoDocumentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jhonatan
 */
public class ACC_FlujoDocumentos extends Conexion {

    Conexion cnx = new Conexion();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_FlujoDocumentos Instance = null;
    
    public static ACC_FlujoDocumentos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_FlujoDocumentos();
        }
        return Instance;
    }
    
    public ArrayList<FlujoDocumentos> MatchSolicitante(String solic, String cent, String CtdFol) {
        ArrayList<FlujoDocumentos> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call SD.ReporteFlujoDocsMatchSolic(?,?,?)}");
            pst.setString(1, solic);
            pst.setString(2, cent);
            pst.setString(3, CtdFol);
            rs = pst.executeQuery();
            while (rs.next()) {
                FlujoDocumentos so = new FlujoDocumentos();
                so.setSolicitante(rs.getString("solicitante"));
                so.setCentro_solic(rs.getString("centro_solic"));
                sam.add(so);
            }
        } catch (Exception e) {
            System.err.println("Error en CentroReservass, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }
    
    public ArrayList<FlujoDocumentos> MatchDocVentas() {
        ArrayList<FlujoDocumentos> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call SD.ReporteFlujoDocsMatchPedVenta}");            
            rs = pst.executeQuery();
            while (rs.next()) {
                FlujoDocumentos so = new FlujoDocumentos();
                so.setDoc_ventas(rs.getString("doc_ventas"));
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
    
    public ArrayList<FlujoDocumentos> MatchMaterial(String folOrd, String CentroOrd, String CtdOrd) {
        ArrayList<FlujoDocumentos> sap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call SD.ReporteFlujoDocsMatchMaterial(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, folOrd);
            pst.setString(2, CentroOrd);
            pst.setString(3, CtdOrd);
            rs = pst.executeQuery();
            while (rs.next()) {
                FlujoDocumentos so = new FlujoDocumentos();
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

    public ArrayList<FlujoDocumentos> SD_EjecutarConsultaFlujoDocs(String centros, String centros2, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<FlujoDocumentos> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call SD.Reporte_FlujoDocsTodos(?,?,?,?,?,?,?,?)}");
            pst.setString(1, centros);
            pst.setString(2, centros2);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                FlujoDocumentos or = new FlujoDocumentos();
                or.setSolicitante(rs.getString("solicitante"));
                or.setDoc_ventas(rs.getString("doc_ventas"));
                or.setNum_doc_ref(rs.getString("num_doc_ref"));
                or.setRefer_cliente(rs.getString("refer_cliente"));
                or.setPos_doc_ventas(rs.getString("pos_doc_ventas"));
                or.setNum_material(rs.getString("num_material"));
                or.setVal_neto_pos_ped(rs.getString("val_neto_pos_ped"));
                or.setUm_cant_prev(rs.getString("um_cant_prev"));
                or.setFecha_ini(rs.getString("fecha_ini"));
                or.setFecha_fin(rs.getString("fecha_fin"));
                or.setCant_ent_efec(rs.getString("cant_ent_efec"));
                or.setNum_doc_comercial4(rs.getString("num_doc_comercial4"));
                or.setFecha_carga(rs.getString("fecha_carga"));
                or.setFecha_planif_trans(rs.getString("fecha_planif_trans"));
                or.setNum_doc_comp(rs.getString("num_doc_comp"));
                or.setMaterial_introd(rs.getString("material_introd"));
                or.setTxt_breve_pos_ped(rs.getString("txt_breve_pos_ped"));
                or.setDenominacion_cliente(rs.getString("denominacion_cliente"));
                or.setFecha_pedido(rs.getString("fecha_pedido"));
//                or.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
//                or.setNum_orden(rs.getString("num_orden"));
//                or.setNum_lote(rs.getString("num_lote"));
//                or.setUm_cant_prev(rs.getString("um_cant_prev"));
//                or.setCant_prev_um(rs.getString("cant_prev_um"));
//                or.setFecha_cre_reg(rs.getString("fecha_cre_reg"));
//                or.setCentro_solic(rs.getString("centro_solic"));
//                or.setSolicitante(rs.getString("solicitante"));
//                or.setAlmacen(rs.getString("almacen"));
//                //Mandante
//                or.setGpo_articulos(rs.getString("gpo_articulos"));
//                or.setNum_material(rs.getString("num_material"));
//                or.setMaterial_introd(rs.getString("material_introd"));
//                or.setVal_neto_pos_ped(rs.getString("val_neto_pos_ped"));
//                //Asigacion
//                //Mat.precio                
//                or.setPos_doc_ventas(rs.getString("pos_doc_ventas"));
//                or.setJerarquia_prod(rs.getString("jerarquia_prod"));
//                or.setRuta(rs.getString("ruta"));
//                or.setSector(rs.getString("sector"));
//                or.setDoc_ventas(rs.getString("doc_ventas"));
//                //TpDocVntas
//                or.setOficina_ventas(rs.getString("oficina_ventas"));
//                or.setGpo_vendedores(rs.getString("gpo_vendedores"));
//                or.setOrg_ventas(rs.getString("org_ventas"));
//                or.setCanal_distrib(rs.getString("canal_distrib"));
//                or.setMoneda_doc_com(rs.getString("moneda_doc_com"));
//                or.setCentro(rs.getString("centro"));
//                or.setRefer_cliente(rs.getString("refer_cliente"));
//                //Entrega
//                //Pos.Ent
//                or.setCant_ent_efec(rs.getString("cant_ent_efec"));
//                or.setUm_cant_prev(rs.getString("um_cant_prev"));
//                //Transporte
//                or.setClase_med_transp(rs.getString("clase_med_transp"));
//                //Cant.Trans
//                //UMT
//                //Mov.Entrega
//                //pos.Entrega
//                or.setCant_ent_efec(rs.getString("cant_ent_efec"));
//                //UME
//                //Factura
//                //PosFactura
//                //Cant Factura
//                //UMF
//                //Destinatario de merca
//                or.setPeso_total(rs.getString("peso_total"));
//                or.setFecha_carga(rs.getString("fecha_carga"));
//                //Entrega Externa
//                or.setPeso_neto(rs.getString("peso_neto"));
//                or.setFecha_planif_trans(rs.getString("fecha_planif_trans"));
//                or.setPto_exped(rs.getString("pto_exped"));
//                or.setNum_lote(rs.getString("num_lote"));
//                or.setUnidad_peso(rs.getString("unidad_peso"));
//                or.setCant_ent_efec(rs.getString("cant_ent_efec"));
//                //Denom Ruta
//                //Creado por
//                //No_pedido cliente
//                or.setGastos_transp(rs.getString("gastos_transp"));
//                or.setNum_transp(rs.getString("num_transp"));
//                or.setStatus_transfer(rs.getString("status_transfer"));
//                //Importe Gasto                
//                //****** FALTANTES *****//
//                //Docto de compras
//                or.setSuplem1(rs.getString("suplem1"));
//                or.setSuplem2(rs.getString("suplem2"));
//                or.setSuplem3(rs.getString("suplem3"));
//                or.setSuplem4(rs.getString("suplem4"));
//                or.setClase_med_transp(rs.getString("clase_med_transp"));
//                or.setId__exte(rs.getString("id__exte"));
//                or.setId_exte2(rs.getString("id_exte2"));
//                or.setRuta(rs.getString("ruta"));
//                or.setClas_tranp(rs.getString("clas_tranp"));
//                or.setSignatu(rs.getString("signatu"));                
//                //****** FALTANTES *****//
//                or.setStatus_glob(rs.getString("status_glob"));
//                //Transportista
//                //Denominacion
//                //Clase de ex
//                or.setFecha_ini(rs.getString("fecha_ini"));
//                or.setFecha_fin(rs.getString("fecha_fin"));
//                or.setStatus(rs.getString("status"));
//                or.setStock_vs_lin(rs.getString("stock_vs_lin"));                
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
    
    public String DesFlujoDocs(String var1, String var2) {
        String des = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.FlujoDocumentos_CargarDatos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,var1);
            ps.setString(2,var2);
            rs = ps.executeQuery();
            while(rs.next()){
                des = rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return des;
    }
}
