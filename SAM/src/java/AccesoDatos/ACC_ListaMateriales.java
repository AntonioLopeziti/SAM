/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.ListaMateriales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 */
public class ACC_ListaMateriales {

    private static ACC_ListaMateriales Instance = null;

    public static ACC_ListaMateriales ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_ListaMateriales();
        }
        return Instance;
    }

    public ArrayList<ListaMateriales> ConsultaMCMateriales(String m, String des, String lan) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<ListaMateriales> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ListaMateriales_CargarMateriales(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, m);
            ps.setString(2, des);
            ps.setString(3, lan);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListaMateriales l = new ListaMateriales();
                l.setMaterial(rs.getString("material"));
                l.setDescripcion(rs.getString("descripcion_" + lan));
                lista.add(l);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCMateriales ACC_ListaMateriales por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return lista;
    }

    public ArrayList<ListaMateriales> ConsultaMCCentros() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<ListaMateriales> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ListaMateriales_CargarCentro}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListaMateriales l = new ListaMateriales();
                l.setCentro(rs.getString("centro"));
                l.setDescripcion(rs.getString("descripcion"));
                lista.add(l);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCCentros ACC_ListaMateriales por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return lista;
    }

    public ArrayList<ListaMateriales> ConsultaMCAlmacen(String lan) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<ListaMateriales> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ListaMateriales_CargarAlmacen(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lan);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListaMateriales l = new ListaMateriales();
                l.setAlmacen(rs.getString("id_almacen"));
                l.setDescr_alm(rs.getString("descripcion_"+lan));
                l.setCentro(rs.getString("centro"));
                lista.add(l);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCAlmacen ACC_ListaMateriales por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return lista;
    }
    public ArrayList<ListaMateriales> ConsultaMCProveedores(String Num, String nom) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<ListaMateriales> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ListaMateriales_CargarProveedores(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Num);
            ps.setString(2, nom);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListaMateriales l = new ListaMateriales();
                l.setProveedor(rs.getString("IdProveedor"));
                l.setNombre_prov(rs.getString("nombre1"));
                lista.add(l);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCProveedores ACC_ListaMateriales por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return lista;
    }
    public ArrayList<ListaMateriales> ConsultaMCClase() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<ListaMateriales> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ListaMateriales_CargarTMov}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListaMateriales l = new ListaMateriales();
                l.setClase_movimiento(rs.getString("id_tipo_mov"));
                l.setDescr_clase(rs.getString("descripcion_mov"));
                lista.add(l);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCClase ACC_ListaMateriales por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return lista;
    }
     public int ValidarMaterial(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String check = "";
        String sql = "{call MM.ListaMateriales_ValidarMaterial(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (!check.trim().equals("0")) {
                ban = 1;
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarMaterial ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
     public int ValidarCentro(String cen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String check = "";
        String sql = "{call MM.ListaMateriales_ValidarCentro(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cen);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (!check.trim().equals("0")) {
                ban = 1;
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarCentro ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
     public int ValidarAlmacen(String alm) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String check = "";
        String sql = "{call MM.ListaMateriales_ValidarAlmacen(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alm);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (!check.trim().equals("0")) {
                ban = 1;
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarAlmacen ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
     public int ValidarProveedor(String pro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String check = "";
        String sql = "{call MM.ListaMateriales_ValidarProveedor(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pro);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (!check.trim().equals("0")) {
                ban = 1;
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarProveedor ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
     public int ValidarClase(String cla) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String check = "";
        String sql = "{call MM.ListaMateriales_ValidarClase(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cla);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (!check.trim().equals("0")) {
                ban = 1;
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarClase ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
     public int ValidarQuery(String[]d) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String sql = "{call MM.ListaMaterial_ValidarQueryDoc(?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            ps.setString(7, d[6]);
            ps.setString(8, d[7]);
            rs = ps.executeQuery();
            while(rs.next()){
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarQuery ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
     public ArrayList<ListaMateriales> CargarTabla(String[]d) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        ArrayList<ListaMateriales> lista = new ArrayList<>();
        String sql = "{call MM.ListaMaterial_ValidarQueryDoc(?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            ps.setString(7, d[6]);
            ps.setString(8, d[7]);
            rs = ps.executeQuery();
            while(rs.next()){
                ListaMateriales l = new ListaMateriales();
                l.setMaterial(rs.getString("num_material"));
                l.setDescripcion(rs.getString("descripcion_"+d[7]));
                l.setCentro(rs.getString("centro"));
                l.setAlmacen(rs.getString("almacen"));
                l.setFecha_contable(rs.getString("fecha_contabilizacion_doc"));
                l.setClase_movimiento(rs.getString("clase_movimiento"));
                l.setAlmacen_destino(rs.getString("almacen_destino"));
                l.setIndicador_stock(rs.getString("indicador_stock_especial"));
                l.setNum_doc_compras(rs.getString("num_doc_material"));
                l.setFolio_sam(rs.getString("folio_sam"));
                l.setNum_posicion_comp(rs.getString("pos_doc_compras"));
                l.setProveedor(rs.getString("num_cuenta_proveedor"));
                l.setNombre_prov(rs.getString("nombre1"));
                l.setCantidad(rs.getString("cantidad_unidad_medida_entrada"));
                l.setUm(rs.getString("unidad_medida_entrada"));
                lista.add(l);
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarQuery ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return lista;
    }
     public int ValidarQuery2(String[]d) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String sql = "{call MM.ListaMaterial_ValidarQueryMov(?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            ps.setString(7, d[6]);
            ps.setString(8, d[7]);
            rs = ps.executeQuery();
            while(rs.next()){
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarQuery ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
      public ArrayList<ListaMateriales> CargarTabla2(String[]d) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        ArrayList<ListaMateriales> lista = new ArrayList<>();
        String sql = "{call MM.ListaMaterial_ValidarQueryMov(?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            ps.setString(7, d[6]);
            ps.setString(8, d[7]);
            rs = ps.executeQuery();
            while(rs.next()){
                ListaMateriales l = new ListaMateriales();
                l.setMaterial(rs.getString("num_material"));
                l.setDescripcion(rs.getString("texto_breve_material"));
                l.setCentro(rs.getString("centro"));
                l.setAlmacen(rs.getString("almacen"));
                l.setFecha_contable(rs.getString("fecha_contable"));
                l.setClase_movimiento(rs.getString("clase_movimiento"));
                l.setAlmacen_destino(rs.getString("almacen_receptor"));
                l.setIndicador_stock(rs.getString("indicador_stock_especial"));
                l.setNum_doc_compras(rs.getString("num_doc_material"));
                l.setFolio_sam(rs.getString("folio_sam"));
                l.setNum_posicion_comp(rs.getString("indice_registro_no_valido"));
                l.setProveedor(rs.getString("num_cuenta_proveedor"));
                l.setNombre_prov("");
                l.setCantidad(rs.getString("cantidad1"));
                l.setUm(rs.getString("unidad_medida_base"));
                lista.add(l);
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarQuery ACC_ListaMateriales por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return lista;
    }
}
