/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Sector;
import Entidades.canal_distribucion;
import Entidades.clase_pedido_sd;
import Entidades.clientes;
import Entidades.grupo_vendedores;
import Entidades.materiales_venta;
import Entidades.oficina_ventas;
import Entidades.organizacion_ventas;
import Entidades.unidades_medida;
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

    public ArrayList<unidades_medida> GetUnidadMedida() {
        ArrayList<unidades_medida> ume = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ConsultaUMedida}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                unidades_medida u = new unidades_medida();
                u.setUnidad_medida(rs.getString("unidad_medida"));
                u.setDescripcion(rs.getString("denominacion"));
                ume.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ume;
    }

    public ArrayList<materiales_venta> GetMateriales(String material, String denominacion, String cantidad) {
        ArrayList<materiales_venta> mv = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ConsultaMateriales(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, material);
            ps.setString(2, denominacion);
            ps.setString(3, cantidad);
            rs = ps.executeQuery();
            while (rs.next()) {
                materiales_venta m = new materiales_venta();
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString("descripcion_es"));
                m.setCentro(rs.getString("centro"));
                mv.add(m);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mv;
    }

    public ArrayList<clientes> GetClientes(String cliente, String nombre, String cantidad, String sql) {
        ArrayList<clientes> cl = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String sql = "{call SD.CrearPedidos_ConsultaClientes(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente);
            ps.setString(2, nombre);
            ps.setString(3, cantidad);
            rs = ps.executeQuery();
            while (rs.next()) {

                clientes c = new clientes();
                c.setIdCliente(rs.getString("IdCliente"));
                c.setNombre1(rs.getString("nombre1"));
                cl.add(c);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cl;

    }

    public String[] CargarCliente(String cliente) {
        String[] datos = new String[8];
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_Cargarclientedatos(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return datos;
    }

    public String denominacion(String variable, String tipo) {
        String den = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_CargarDescripcion(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, variable);
            ps.setString(2, tipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                den = rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return den;
    }

    public materiales_venta getDMat(String mat, String org, String can, String cliente) {
        materiales_venta m = new materiales_venta();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_CargarMaterial(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ps.setString(2, org);
            ps.setString(3, can);
            ps.setString(4, cliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString("descripcion_material_cliente"));
                m.setUnidad_medida_base(rs.getString("unidad_medida_base"));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return m;
    }

    public String GetTextoComercial(String mat, String org, String sec) {
        String texto = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_CargarTextoComercial(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ps.setString(2, org);
            ps.setString(3, sec);
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

    public clientes ValidarInterlocutor(String sol, String dm) {
        clientes c = new clientes();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call SD.CrearPedidos_ValidarInterlocutor(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sol);
            ps.setString(2, dm);
            rs = ps.executeQuery();
            while (rs.next()) {
               c.setIdCliente(rs.getString("IdCliente"));
               c.setNombre1(rs.getString("nombre1"));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return c;
    }

    public void InsertarCabecera1(String folioSAM, String Clase, String Org, String Can, String Sec, String gpo, String ofic, String fe, String fp, String ref, String usu, String fechA, String Hora) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call SD.CrearPedidos_InsertarPedido(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folioSAM);
            ps.setString(2, Clase);
            ps.setString(3, Org);
            ps.setString(4, Can);
            ps.setString(5, Sec);
            ps.setString(6, gpo);
            ps.setString(7, ofic);
            ps.setString(8, fe);
            ps.setString(9, fp);
            ps.setString(10, ref);
            ps.setString(11, usu);
            ps.setString(12, fechA);
            ps.setString(13, Hora);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    public void GuardarCliente(String folio, String funcion, String cliente, String usuario, String fecha, String hora ){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call SD.CrearPedidos_InsertarClientePedido(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, funcion);
            ps.setString(3, cliente);
            ps.setString(4, usuario);
            ps.setString(5, fecha);
            ps.setString(6, hora);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        
    }
    public void GuardarMateriales(String folio, String posicion, String material, String descripcion, String unidad, String usuario, String fecha, String hora ){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call SD.CrearPedidos_InsertarPosicionesPedido(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, posicion);
            ps.setString(3, material);
            ps.setString(4, descripcion);
            ps.setString(5, unidad);
            ps.setString(6, usuario);
            ps.setString(7, fecha);
            ps.setString(8, hora);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        
    }
    public void GuardarCantidades(String folio, String posicion, String cantidad,  String usuario, String Fecha, String hora ){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call SD.CrearPedidos_InsertarCantidadesPedido(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, posicion);
            ps.setString(3, cantidad);
            ps.setString(4, usuario);
            ps.setString(5, Fecha);
            ps.setString(6, hora);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        
    }
     public void InsertTxtCabecera(String folio, String fila, String user, String txt, String Fecha, String hora) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL SD.[CrearPedidos_InsertarTextoCabecera](?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, fila);
            ps.setString(3, txt);
            ps.setString(4, user);
            ps.setString(5, Fecha);
            ps.setString(6, hora);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
     public void InsertTxtPosicion(String folio, String pos,  String fila, String user, String txt, String Fecha, String hora) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL SD.[CrearPedidos_InsertarTextoPosicion](?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, pos);
            ps.setString(3, fila);
            ps.setString(4, txt);
            ps.setString(5, user);
            ps.setString(6, Fecha);
            ps.setString(7, hora);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
}
