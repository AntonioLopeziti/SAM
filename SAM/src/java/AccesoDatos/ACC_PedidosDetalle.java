/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.imprefol;
import Entidades.pedido_detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ACC_PedidosDetalle {

    public static ACC_PedidosDetalle Instance = null;

    public static ACC_PedidosDetalle ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_PedidosDetalle();
        }
        return Instance;
    }

    public ArrayList<pedido_detalle> ConsultaMCPedidos(String pedido, String fech, int Ctd) {
        ArrayList<pedido_detalle> ped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection co = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pro = "{CALL MM.PedidoServicio_ConsultaPedidoMC(?,?,?)}";
        try {
            ps = co.prepareStatement(pro);
            ps.setString(1, pedido);
            ps.setString(2, fech);
            ps.setInt(3, Ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setFecha_entrega_posicion(rs.getString("fecha_doc_compras"));
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setCentro(rs.getString("centro"));
                ped.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(co);
        }
        return ped;
    }

    public boolean ValidarDocumentoPed(String pedido, int pos) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String proc = "{CALL MM.PedidoServicio_ValidarDoc(?,?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, pedido);
            ps.setInt(2, pos);
            rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarDocumentoPed por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean ChecKlib(String pedido) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        PreparedStatement ps = null;
        ResultSet rs=  null;
        String proc = "{CALL MM.PedidoServicio_ValLiberacion(?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, pedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ChecKlib  por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public LinkedList<pedido_detalle> GetMatchPedidos(String query) {
        Conexion cnx = new Conexion();
        LinkedList<pedido_detalle> pedids = new LinkedList<>();
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setFecha_entrega_posicion(rs.getString("fecha_doc_compras"));
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setCentro(rs.getString("centro"));
                pedids.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error obtener pedido: " + ex);
        }
        return pedids;
    }

    public LinkedList<pedido_detalle> GetDatosPedido(String query) {
        Conexion cnx = new Conexion();
        LinkedList<pedido_detalle> pedids = new LinkedList<>();
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                pedido_detalle p = new pedido_detalle();
                p.setFecha_entrega_posicion(rs.getString("fecha_doc_compras"));
                p.setNum_doc_compras(rs.getString("num_doc_compras"));
                p.setCentro(rs.getString("centro"));
                p.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                p.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                pedids.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error obtener pedido: " + ex);
        }
        return pedids;
    }

    public LinkedList<imprefol> ConsultaFolios(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<imprefol> alm = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                imprefol a = new imprefol();
                a.setFolio(rs.getString("num_posicion_doc_compras"));
                a.setPosicion(rs.getString("folio_sam"));
                alm.add(a);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en Consulta Folios Entradas por: " + e);
        }
        return alm;
    }

    public boolean InsertarHistorial(String query) {
        Conexion cnx = new Conexion();
        Connection Con = cnx.ObtenerConexion();
        int validar;
        try {

            Statement st = Con.createStatement();
            validar = st.executeUpdate(query);
            if (validar >= 0) {
                cnx.CerrarConexion(Con);
                return true;
            } else {
                cnx.CerrarConexion(Con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
        }
        cnx.CerrarConexion(Con);
        return false;
    }

}
