/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Sector;
import Entidades.canal_distribucion;
import Entidades.clase_pedido_sd;
import Entidades.grupo_vendedores;
import Entidades.oficina_ventas;
import Entidades.organizacion_ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 */
public class ACC_CrearPedidoSD {

    public static ACC_CrearPedidoSD Instance = null;

    public static ACC_CrearPedidoSD ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_CrearPedidoSD();
        }
        return Instance;
    }

    public ArrayList<clase_pedido_sd> GetClasePedido() {
        ArrayList<clase_pedido_sd> cpedi = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ConsultaClasePedido}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clase_pedido_sd c = new clase_pedido_sd();
                c.setClase_documento_ventas(rs.getString("clase_documento_venta"));
                c.setDenominacion(rs.getString("denominacion"));
                cpedi.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cpedi;
    }

    public ArrayList<organizacion_ventas> GetOrgVentas() {
        ArrayList<organizacion_ventas> org = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ConsultaOrgVentas}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                organizacion_ventas o = new organizacion_ventas();
                o.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                o.setDenominacion(rs.getString("denominacion"));
                org.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return org;
    }

    public ArrayList<canal_distribucion> GetCanalDistribucion() {
        ArrayList<canal_distribucion> can = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ConsultaCanalDist}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                canal_distribucion c = new canal_distribucion();
                c.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                c.setCanal_distribucion(rs.getString("canal_distribucion"));
                c.setDenominacion(rs.getString("denominacion_ES"));
                can.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return can;
    }

    public ArrayList<Sector> GetSector() {
        ArrayList<Sector> sec = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ConsultaSector}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sector s = new Sector();
                s.setSector(rs.getString("sector"));
                s.setDescripcion(rs.getString("denominacion_ES"));
                sec.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sec;
    }

    public ArrayList<oficina_ventas> GetOficinaVentas() {
        ArrayList<oficina_ventas> ofic = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ConsultaOFicinaVentas}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                oficina_ventas o = new oficina_ventas();
                o.setOficina_ventas(rs.getString("oficina_ventas"));
                o.setDenominacion(rs.getString("denominacion"));
                ofic.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ofic;
    }

    public ArrayList<grupo_vendedores> GetGrupoVendedores(String grupo, String denomi, String cant) {
        ArrayList<grupo_vendedores> gpo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ConsultaGpoVendedores(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, grupo);
            ps.setString(2, denomi);
            ps.setString(3, cant);
            rs = ps.executeQuery();
            while (rs.next()) {
                grupo_vendedores g = new grupo_vendedores();
                g.setGrupo_vendedores(rs.getString("grupo_vendedores"));
                g.setDenominacion(rs.getString("denominacion"));
                gpo.add(g);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return gpo;
    }
}
