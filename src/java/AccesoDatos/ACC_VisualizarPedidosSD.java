/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.SD_cabecera_pedidos_venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 */
public class ACC_VisualizarPedidosSD {
    
    private static ACC_VisualizarPedidosSD Instance = null;
    
    public static ACC_VisualizarPedidosSD ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_VisualizarPedidosSD();
        }
        return Instance;
    }
    
    public ArrayList<SD_cabecera_pedidos_venta> ConsultaMCPedidosSD(String doc, String clase, String can) {
        ArrayList<SD_cabecera_pedidos_venta> pv = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_ConsultaDocVentasMC(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, clase);
            ps.setString(3, can);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_cabecera_pedidos_venta p = new SD_cabecera_pedidos_venta();
                p.setDocumento_ventas(rs.getString("documento_ventas"));
                p.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                pv.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pv;
    }
    
    public SD_cabecera_pedidos_venta ObtenerCabeceraPed(String doc) {
        SD_cabecera_pedidos_venta cab = new SD_cabecera_pedidos_venta();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_ConsultarPedido(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            rs = ps.executeQuery();
            while (rs.next()) {
                cab.setDocumento_ventas(rs.getString("documento_ventas"));
                cab.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                cab.setSolicitante(rs.getString("solicitante"));
                cab.setTexto_visual_interlocutor1(rs.getString("texto_visual_interlocutor1"));
                cab.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                cab.setTexto_visual_interlocutor2(rs.getString("texto_visual_interlocutor2"));
                cab.setNum_pedido_cliente(rs.getString("num_pedido_cliente"));
                cab.setFecha_pedido_compra_cliente(rs.getString("fecha_pedido_compra_cliente"));
                cab.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                cab.setCanal_distribucion(rs.getString("canal_distribucion"));
                cab.setSector(rs.getString("sector"));
                cab.setArea_ventas(rs.getString("area_ventas"));
                cab.setOficina_ventas(rs.getString("oficina_ventas"));
                cab.setDenominacion_oficina_ventas(rs.getString("denominacion_oficina_ventas"));
                cab.setGrupo_vendedores(rs.getString("grupo_vendedores"));
                cab.setDenominacion_grupo_vendedores(rs.getString("denominacion_grupo_vendedores"));
                cab.setFecha_documento(rs.getString("fecha_documento"));
                cab.setMoneda_documento(rs.getString("moneda_documento"));
                cab.setNombre_responsable(rs.getString("nombre_responsable"));
                cab.setMotivo_pedido(rs.getString("motivo_pedido"));
                cab.setMoneda_documento2(rs.getString("moneda_documento2"));
                cab.setFecha_determinacion_precio_tipo_cam(rs.getString("fecha_determinacion_precio_tipo_cambio"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cab;
    }
}
