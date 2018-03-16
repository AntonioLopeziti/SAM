/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.SD_cotizaciones_cabecera;
import Entidades.SD_posiciones_cotizaciones;
import Entidades.SD_posiciones_cotizaciones_condicion;
import Entidades.SD_posiciones_cotizaciones_expedicion;
import Entidades.SD_posiciones_cotizaciones_repartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 */
public class ACC_CotizacionesSD {

    public static ACC_CotizacionesSD Instance = null;

    public static ACC_CotizacionesSD ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_CotizacionesSD();
        }
        return Instance;
    }

    public ArrayList<SD_cotizaciones_cabecera> MCDocumentos(String doc, String cla, String can) {
        ArrayList<SD_cotizaciones_cabecera> cot = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarCotizacion_CargarDocMC(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, cla);
            ps.setString(3, can);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_cotizaciones_cabecera c = new SD_cotizaciones_cabecera();
                c.setDocumento_ventas(rs.getString("documento_ventas"));
                c.setClase_documento(rs.getString("clase_documento"));
                cot.add(c);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cot;
    }

    public int VerificarDocumento(String Doc) {
        int doc = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarCotizacion_VerificarDocumento(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Doc);
            rs = ps.executeQuery();
            while (rs.next()) {
                doc = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }

        return doc;
    }

    public SD_cotizaciones_cabecera GetCabecera(String documento) {
        SD_cotizaciones_cabecera cab = new SD_cotizaciones_cabecera();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarCotizacion_CargarCabecera(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();
            while (rs.next()) {
                cab.setClase_documento(rs.getString("clase_documento"));
                cab.setDocumento_ventas(rs.getString("documento_ventas"));
                cab.setSolicitante(rs.getString("solicitante"));
                cab.setTexto_solicitante(rs.getString("texto_solicitante"));
                cab.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                cab.setTexto_destinatario(rs.getString("texto_destinatario"));
                cab.setNum_pedido_cliente(rs.getString("num_pedido_cliente"));
                cab.setFecha_pedido_compras(rs.getString("fecha_pedido_compras"));
                cab.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                cab.setCanal_distribucion(rs.getString("canal_distribucion"));
                cab.setSector(rs.getString("sector"));
                cab.setArea_ventas(rs.getString("area_ventas"));
                cab.setOficina_ventas(rs.getString("oficina_ventas"));
                cab.setDenominacion_oficina(rs.getString("denominacion_oficina"));
                cab.setGrupo_vendedores(rs.getString("grupo_vendedores"));
                cab.setDenominacion_grupov(rs.getString("denominacion_grupov"));
                cab.setFecha_documento(rs.getString("fecha_documento"));
                cab.setValor_neto(rs.getString("valor_neto"));
                cab.setMoneda_doc_comercial(rs.getString("moneda_doc_comercial"));
                cab.setResponsable(rs.getString("responsable"));
                cab.setMotivo_pedido(rs.getString("motivo_pedido"));
                cab.setFecha_determinacion_precios(rs.getString("fecha_determinacion_precios"));
                cab.setFecha(rs.getString("fecha"));
                cab.setNum_condicion_documento(rs.getString("num_condicion_documento"));
                cab.setFecha_valido_a(rs.getString("fecha_valido_a"));
                cab.setFecha_valido_de(rs.getString("fecha_valido_de"));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cab;
    }

    public ArrayList<SD_posiciones_cotizaciones> GetPosiciones(String documento) {
        ArrayList<SD_posiciones_cotizaciones> pos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD_VisualizarCotizaciones_CargarPosiciones(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_posiciones_cotizaciones p = new SD_posiciones_cotizaciones();
                p.setNum_doc_comercial(rs.getString("num_doc_comercial"));
                p.setPosicion_doc_comercial(rs.getString("posicion_doc_comercial"));
                p.setMaterial(rs.getString("material"));
                p.setCantidad_pedido(rs.getString("cantidad_pedido"));
                p.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                p.setExisten_repartos(rs.getString("existen_repartos"));
                p.setTexto_breve_posicion_pedido(rs.getString("texto_breve_posicion_pedido"));
                p.setMaterial_cliente(rs.getString("material_cliente"));
                p.setTipo_posicion_doc_comercial(rs.getString("tipo_posicion_doc_comercial"));
                p.setPerfil_indicador_merca_peli(rs.getString("perfil_indicador_merca_peli"));
                p.setPosicion_superior(rs.getString("posicion_superior"));
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

    public SD_posiciones_cotizaciones_expedicion GetExpedicion(String doc, String pos) {
        SD_posiciones_cotizaciones_expedicion ex = new SD_posiciones_cotizaciones_expedicion();
        String sql = "{call SD.VisualizarCotizacion_CargarExpedicion(?,?)}";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                ex.setCentro(rs.getString("centro"));
                ex.setDenominacion_centro(rs.getString("denominacion_centro"));
                ex.setPriotidad_entrega(rs.getString("prioridad_entrega"));
                ex.setDenominacion_prioridad_entrega(rs.getString("denominacion_prioridad_entrega"));
                ex.setAlmacen(rs.getString("almacen"));
                ex.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                ex.setPuesto_expedcion(rs.getString("puesto_expedicion"));
                ex.setDenominacion_puesto_expedicion(rs.getString("denominacion_puesto_exp"));
                ex.setRuta(rs.getString("ruta"));
                ex.setDenominacion_ruta(rs.getString("denominacion_ruta"));
                ex.setPeso_bruto(rs.getString("peso_neto"));
                ex.setUnidad_medida_peso(rs.getString("unidad_medida_peso"));
                ex.setPeso_bruto(rs.getString("peso_bruto"));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ex;
    }

    public SD_posiciones_cotizaciones CargarCampos(String doc, String pos) {
        SD_posiciones_cotizaciones cot = new SD_posiciones_cotizaciones();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarCotizacion_CargarCamposPos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                cot.setCantidad(rs.getString("cantidad"));
                cot.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                cot.setValor_neta(rs.getString("valor_neto"));
                cot.setMoneda_doc_comercial(rs.getString("moneda_doc_comercial"));
                cot.setImporte_impuesto(rs.getString("importe_impuesto"));
                cot.setDenominacion_status_tratamiento_global(rs.getString("denominacion_status_tratamiento_global"));
                cot.setMotivo_rechazo(rs.getString("motivo_rechazo"));
                cot.setDenominacion_sociedad_co(rs.getString("denominacion_sociedad_co"));
                cot.setDenominacion_status_entrega(rs.getString("denominacion_status_entrega"));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cot;
    }

    public ArrayList<SD_posiciones_cotizaciones_condicion> GetTableCondicion(String doc, String pos) {
        ArrayList<SD_posiciones_cotizaciones_condicion> cond = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarCotizacion_TablaCondicion(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_posiciones_cotizaciones_condicion c = new SD_posiciones_cotizaciones_condicion();
                c.setVisualizacion_condiciones_inactivas(rs.getString("visualizacion_condiciones_inactivas"));
                c.setClase_condicion(rs.getString("clase_condicion"));
                c.setDenominacion_clase_condicion(rs.getString("denominacion_clase_condicion"));
                c.setImporte(rs.getString("importe"));
                c.setClave_moneda(rs.getString("clave_moneda"));
                c.setCantidad_base_condicion(rs.getString("cantidad_base_condicion"));
                c.setUnidad_medida_condicion(rs.getString("unidad_medida_condicion"));
                c.setValor_condicion(rs.getString("valor_condicion"));
                c.setContador_conversion(rs.getString("contador_conversion"));
                c.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                c.setDenominacor_cov_condicion(rs.getString("denominador_conv_condicion"));
                c.setUnidad_medida_condicion2(rs.getString("unidad_medida_condicion2"));
                c.setValor_condicion2(rs.getString("valor_condicion2"));
                c.setMoneda_condicion(rs.getString("moneda_condicion"));
                c.setCondicion_estadistica(rs.getString("condicion_estadistica"));
                cond.add(c);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cond;
    }
     public ArrayList<SD_posiciones_cotizaciones_repartos> GetReparto(String doc, String pos) {
        ArrayList<SD_posiciones_cotizaciones_repartos> rep = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.VisualizarCotizacion_GetRepartos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                SD_posiciones_cotizaciones_repartos pr = new SD_posiciones_cotizaciones_repartos();
                pr.setPlazo_entrega(rs.getString("plazo_entrega"));
                pr.setCantidad_pedido(rs.getString("cantidad_pedido"));
                pr.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                pr.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                pr.setTipo_fecha(rs.getString("tipo_fecha"));
                pr.setFecha_reparto(rs.getString("fecha_reparto"));
                pr.setCantidad_pedida(rs.getString("cantidad_pedida"));
                pr.setCantidad_corregida(rs.getString("cantidad_corregida"));
                pr.setCantidad_confirmada(rs.getString("cantidad_confirmada"));
                pr.setUnidad_medida_b(rs.getString("unidad_medida_b"));
                pr.setBloqueo_entrega(rs.getString("bloqueo_entrega"));
                pr.setTipo_posicion_reparto(rs.getString("tipo_posicion_reparto"));
                pr.setNum_solped_pedido(rs.getString("num_solped_pedido"));
                pr.setNum_posicion_solped_pedido(rs.getString("num_posicion_solped_pedido"));
                rep.add(pr);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rep;
    }

    public static void main(String[] args) {
        ACC_CotizacionesSD n = new ACC_CotizacionesSD();
        int x = n.VerificarDocumento("0020000028");
        System.out.println(x);
    }
}
