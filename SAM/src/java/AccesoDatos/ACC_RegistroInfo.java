/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.registroinfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author AREConsulting
 */
public class ACC_RegistroInfo {

    private static ACC_RegistroInfo Instance = null;

    public static ACC_RegistroInfo ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_RegistroInfo();
        }
        return Instance;
    }

    public LinkedList<registroinfo> ObtenerMatchRegInfo(String query) {
        LinkedList<registroinfo> reg = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                registroinfo ri = new registroinfo();
                ri.setIdRegistroinfo(rs.getString("IdRegistroinfo"));
                ri.setNum_material(rs.getString("num_material"));
                ri.setProveedor(rs.getString("proveedor"));
                ri.setTipo_reginfo_compras(rs.getString("tipo_reginfo_compras"));
                reg.add(ri);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en Metodo ObtenerMatchRegInfo (ACC_ResgistroInfo) por: " + e);
        }
        return reg;
    }

    public registroinfo ObtenerDatosRegistroInfo(String query) {
        registroinfo r = new registroinfo();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                r.setIdRegistroinfo(rs.getString("IdRegistroinfo"));
                r.setNum_material(rs.getString("num_material"));
                r.setProveedor(rs.getString("proveedor"));
                r.setNombre1(rs.getString("nombre1"));
                r.setOrganizacion_compras(rs.getString("organizacion_compras"));
                r.setTipo_reginfo_compras(rs.getString("tipo_reginfo_compras"));
                r.setCentro(rs.getString("centro"));
                r.setGrupo_articulos(rs.getString("grupo_articulos"));
                r.setGrupo_compras(rs.getString("grupo_compras"));
                r.setPlazo_entrega_dias(rs.getString("plazo_entrega_dias"));
                r.setMaterial_utilizado_proveedor(rs.getString("material_utilizado_proveedor"));
                r.setCatiddad_pedido_estandar(rs.getString("catiddad_pedido_estandar"));
                r.setCantidad_pedido_maxima(rs.getString("cantidad_pedido_maxima"));
                r.setTexto_pedido_material_norelevante(rs.getString("texto_pedido_material_norelevante"));
                r.setIndicador_obli_confir_pedido(rs.getString("indicador_obli_confir_pedido"));
                r.setLimite_tolerancia_entrega_incompleta(rs.getString("limite_tolerancia_entrega_incompleta"));
                r.setLimite_tolerancia_exceso_suministro(rs.getString("limite_tolerancia_exceso_suministro"));
                r.setDenominador_conver_um(rs.getString("denominador_conver_um"));
                r.setUnidad_medida_pedido(rs.getString("unidad_medida_pedido"));
                r.setNumerador_conversion_um(rs.getString("numerador_conversion_um"));
                r.setUnidad_medida(rs.getString("unidad_medida"));
                r.setPrecio_neto_info_compras(rs.getString("precio_neto_info_compras"));
                r.setClave_moneda(rs.getString("clave_moneda"));
                r.setCantidad_base(rs.getString("cantidad_base"));
                r.setUnidad_medida_precio_pedido(rs.getString("unidad_medida_precio_pedido"));
                r.setIndicador_iva(rs.getString("indicador_iva"));
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarRagistro (ACC_RegistroInfo) por: " + e);
        }
        return r;
    }
    public boolean ValidarInfoReCrea(String info){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String proc = "{CALL  MM.InfoRec_ValidarCrearInfoRec(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(proc);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println();
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }
    public boolean InsertaInfoRecCrea (registroinfo regInf){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL MM.InfoRec_InsertInfoRec(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, regInf.getIdRegistroinfo());
            ps.setString(2, regInf.getNum_material());
            ps.setString(3, regInf.getProveedor());
            ps.setString(4, regInf.getOrganizacion_compras());
            ps.setString(5, regInf.getTipo_reginfo_compras());
            ps.setString(6, regInf.getCentro());
            ps.setString(7, regInf.getGrupo_articulos());
            ps.setString(8, regInf.getGrupo_compras());
            ps.setString(9, regInf.getPlazo_entrega_dias());
            ps.setString(10, regInf.getCatiddad_pedido_estandar());
            ps.setString(11, regInf.getCantidad_pedido_maxima());
            ps.setString(12, regInf.getTexto_pedido_material_norelevante());
            ps.setString(13, regInf.getIndicador_obli_confir_pedido());
            ps.setString(14, regInf.getLimite_tolerancia_exceso_suministro());
            ps.setString(15, regInf.getLimite_tolerancia_entrega_incompleta());
            ps.setString(16, regInf.getDenominador_conver_um());
            ps.setString(17, regInf.getUnidad_medida_pedido());
            ps.setString(18, regInf.getNumerador_conversion_um());
            ps.setString(19, regInf.getUnidad_medida());
            ps.setString(20, regInf.getPrecio_neto_info_compras());
            ps.setString(21, regInf.getClave_moneda());
            ps.setString(22, regInf.getCantidad_base());
            ps.setString(23, regInf.getUnidad_medida_precio_pedido());
            ps.setString(24, regInf.getIndicador_iva());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        }catch (Exception e) {
            System.err.println("Error en InsertarInfoRec por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
}
