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
    
    public void guardaStatusOrden(StatusOrdenes so){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PP.guardaStatusOrden(?,?,?,?,?,?,?,?)}";
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
    
}
