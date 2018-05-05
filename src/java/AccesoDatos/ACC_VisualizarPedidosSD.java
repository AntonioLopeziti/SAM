/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.SD_cabecera_pedidos_venta;
import Entidades.SD_posiciones_pedido_condiciones;
import Entidades.SD_posiciones_pedido_reparto;
import Entidades.SD_posiciones_pedido_venta;
import Entidades.SD_posiciones_pedidos_expedicion;
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

    public ArrayList<SD_cabecera_pedidos_venta> ConsultaMCPedidosSD(String doc, String clase, String can, String folioSAM) {
        ArrayList<SD_cabecera_pedidos_venta> pv = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_ConsultaDocVentasMC(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, clase);
            ps.setString(3, can);
            ps.setString(4, folioSAM);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_cabecera_pedidos_venta p = new SD_cabecera_pedidos_venta();
                p.setDocumento_ventas(rs.getString("documento_ventas"));
                p.setFolio_sam(rs.getString("folio_sam"));
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
                cab.setFolio_sam(rs.getString("folio_sam"));
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
                cab.setValor_neto(rs.getString("valor_neto"));
                cab.setMoneda_documento(rs.getString("moneda_documento"));
                cab.setNombre_responsable(rs.getString("nombre_responsable"));
                cab.setMotivo_pedido(rs.getString("motivo_pedido"));
                cab.setFecha_determinacion_precio_tipo_cam(rs.getString("fecha_determinacion_precio_tipo_cambio"));
                cab.setFecha_pref_entrega(rs.getString("fecha"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cab;
    }

    public ArrayList<SD_posiciones_pedido_venta> GetItems(String pedido) {
        ArrayList<SD_posiciones_pedido_venta> pos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_CargarItems(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_posiciones_pedido_venta p = new SD_posiciones_pedido_venta();
                p.setNumero_documento_comercial(rs.getString("numero_documento_comercial"));
                p.setPosicion_documento_ventas(rs.getString("posicion_documento_ventas"));
                p.setNumero_material(rs.getString("numero_material"));
                p.setCantidad_pedido(rs.getString("cantidad_pedido"));
                p.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                p.setExisten_repartos(rs.getString("existen_repartos"));
                p.setTexto_breve_posicion_pedido_cliente(rs.getString("texto_breve_posicion_pedido_cliente"));
                p.setNumero_material_cliente(rs.getString("numero_material_cliente"));
                p.setTipo_pos_doc_com(rs.getString("tipo_pos_doc_com"));
                p.setPerfil_ind_merc_com(rs.getString("perfil_ind_merc_com"));
                p.setPosicion_sup_estra_lis_mat(rs.getString("posicion_sup_estr_lis_mat"));
                p.setTipo_fecha_pref_entrega(rs.getString("tipo_fecha_pref_entrega"));
                p.setFecha_reparto(rs.getString("fecha_reparto"));
                pos.add(p);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pos;
    }

    public SD_posiciones_pedidos_expedicion GetExpedicionPos(String doc, String pos) {
        SD_posiciones_pedidos_expedicion ex = new SD_posiciones_pedidos_expedicion();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_Espedicion(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                ex.setCentro(rs.getString("centro"));
                ex.setNombre_centro(rs.getString("nombre_centro"));
                ex.setPrioridad_entrega(rs.getString("prioridad_entrega"));
                ex.setDenominacion_prio_entre(rs.getString("denominacion_prio_entre"));
                ex.setAlmacen(rs.getString("almacen"));
                ex.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                ex.setPuesto_expedicion(rs.getString("puesto_exped"));
                ex.setDenominacion_pto_exp(rs.getString("denominacion_pto_exp"));
                ex.setRuta(rs.getString("ruta"));
                ex.setDenominacion_ruta(rs.getString("denominacion_ruta"));
                ex.setPeso_neto_pos(rs.getString("peso_neto_pos"));
                ex.setUnidad_peso(rs.getString("unidad_peso"));
                ex.setPeso_bruto_pos(rs.getString("peso_bruto_pos"));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ex;
    }

    public SD_posiciones_pedido_venta GetPosCampos(String doc, String pos) {
        SD_posiciones_pedido_venta po = new SD_posiciones_pedido_venta();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_CamposPos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                po.setCantidad(rs.getString("cantidad"));
                po.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                po.setValor_neto(rs.getString("valor_neto"));
                po.setMoneda_documento_comercial(rs.getString("moneda_documento_comercial"));
                po.setImporte_impuesto_moneda_doc(rs.getString("importe_impuesto_moneda_doc"));
                po.setDenominacion_status_trat_global(rs.getString("denominacion_status_trat_global"));
                po.setMotivo_rechazo(rs.getString("motivo_rechazo"));
                po.setDenominacion_sociedad_co(rs.getString("denominacion_sociedad_co"));
                po.setDenominacion_status_entrega(rs.getString("denominacion_status_entrega"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return po;
    }

    public ArrayList<SD_posiciones_pedido_condiciones> GetTableCondiciones(String doc, String pos) {
        ArrayList<SD_posiciones_pedido_condiciones> cond = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_TablaCondicion(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_posiciones_pedido_condiciones c = new SD_posiciones_pedido_condiciones();
                c.setVisualizacion_cond_inactivas(rs.getString("visualizacion_cond_inactivas"));
                c.setClase_condicion(rs.getString("clase_condicion"));
                c.setDenominacion_clase(rs.getString("denominacion_clase"));
                c.setImporte_porc_cond(rs.getString("importe_porc_cond"));
                c.setClave_moneda(rs.getString("clave_moneda"));
                c.setCantidad_base_cond(rs.getString("cantidad_base_cond"));
                c.setUnidad_med_cond_doc(rs.getString("unidad_med_cond_doc"));
                c.setValor_condicion(rs.getString("valor_condicion"));
                c.setContador_conx_cond(rs.getString("contador_conv_cond"));
                c.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                c.setDenominador_conv_cond(rs.getString("denominador_conv_cond"));
                c.setUnidad_med_cond(rs.getString("unidad_med_cond"));
                c.setValor_cond(rs.getString("valor_cond"));
                c.setMoneda_condicion(rs.getString("moneda_condicion"));
                c.setCondicion_estad(rs.getString("condicion_estad"));
                cond.add(c);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cond;
    }

    public ArrayList<SD_posiciones_pedido_reparto> GetReparto(String doc, String pos) {
        ArrayList<SD_posiciones_pedido_reparto> rep = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidos_GetRepartos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_posiciones_pedido_reparto pr = new SD_posiciones_pedido_reparto();
                pr.setPlazo_entrega_acordado(rs.getString("plazo_entrega_acordado"));
                pr.setCantidad_pedido_acom(rs.getString("cantidad_pedido_acom"));
                pr.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                pr.setCant_entreg_unid_venta(rs.getString("cant_entreg_unid_venta"));
                pr.setTipo_fehca(rs.getString("tipo_fecha"));
                pr.setFecha_reparto(rs.getString("fecha_reparto"));
                pr.setCant_pedida_cliente_umv(rs.getString("cant_pedida_cliente_umv"));
                pr.setCant_corregida(rs.getString("cant_coregida_umv"));
                pr.setCant_confirmada(rs.getString("cant_confirmada"));
                pr.setUnidad_med_venta(rs.getString("unidad_med_venta"));
                pr.setBloqueo_entrega_prop(rs.getString("bloqueo_entrega_prop"));
                pr.setTipo_pos_reparto(rs.getString("tipo_pos_reparto"));
                pr.setNumero_solicitud_ped(rs.getString("numero_solicitud_ped"));
                pr.setNum_pos_solc_ped(rs.getString("num_pos_solic_ped"));
                rep.add(pr);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rep;
    }

    public String GetTextoCabecera(String documento) {
        String texto = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_CargarTextoCabecera(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();
            while (rs.next()) {
                texto += rs.getString("texto");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return texto;
    }
    public String GetTextoPosicion(String documento, String Pos) {
        String texto = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarPedidosSD_CargarTextoPosicion(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ps.setString(2, Pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                texto += rs.getString("texto");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return texto;
    }
}
