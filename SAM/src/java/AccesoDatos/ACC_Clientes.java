/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Developer-Antonio
 */
public class ACC_Clientes {

    private static ACC_Clientes Instance = null;

    public static ACC_Clientes ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Clientes();
        }
        return Instance;
    }

    public LinkedList<clientes> ConsultaClienteMatch(String query) {
        LinkedList<clientes> clie = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                clientes c = new clientes();
                c.setIdCliente(rs.getString("IdCliente"));
                c.setNombre1(rs.getString("nombre1"));
                clie.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error: En metodo ConsultaClienteMatch (ACC_Clientes) " + e);
        }
        cnx.CerrarConexion(con);
        return clie;
    }

    public clientes ObtenerDatosClientes(String id, String soc, String org, String can, String sec) {
        clientes c = new clientes();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM MM.clientes WHERE IdCliente='" + id + "' AND sociedad='" + soc + "' AND organizacion_ventas='" + org + "' AND canal_distribucion='" + can + "' AND sector='" + sec + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                c.setIdCliente(rs.getString("IdCliente"));
                c.setNombre1(rs.getString("Nombre1"));
                c.setNombre2(rs.getString("nombre2"));
                c.setNombre3(rs.getString("nombre3"));
                c.setNombre4(rs.getString("nombre4"));
                c.setPoblacion(rs.getString("poblacion"));
                c.setLugarResidencia(rs.getString("lugar_residencia"));
                c.setCalle(rs.getString("calle"));
                c.setDistrito(rs.getString("distrito"));
                c.setNumEdificio(rs.getString("num_edificio"));
                c.setNif(rs.getString("nif"));
                c.setClaveCondicionPago(rs.getString("clave_condicion_pago"));
                c.setClasificacionCliente(rs.getString("clasificacion_cliente"));
                c.setGrupoCuentaDeudor(rs.getString("grupo_cuenta_deudor"));
                c.setCuentaAsoConta(rs.getString("cuenta_aso_conta"));
                c.setMoneda(rs.getString("moneda"));
                c.setIncoParte1(rs.getString("inco_parte1"));
                c.setIncoParte2(rs.getString("inco_parte2"));
                c.setGrupoVendedores(rs.getString("grupo_vendedores"));
                c.setNivelSociedad(rs.getString("nivel_sociedad"));
                c.setBloqueoContaSociedad(rs.getString("bloqueo_contabili_sociedad"));
                c.setPeticionBorraRegistoMaestro(rs.getString("peticion_borra_registro_maestro"));
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ObtenerDatosCliente ACC_clientes por: " + e);
        }
        cnx.CerrarConexion(con);
        return c;
    }
    public boolean InsertarClienteCrea (clientes cli){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL MM.Clientes_InsertClie(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, cli.getNombre1());
            ps.setString(2, cli.getPoblacion());
            ps.setString(3, cli.getLugarResidencia());
            ps.setString(4, cli.getCalle());
            ps.setString(5, cli.getDistrito());
            ps.setString(6, cli.getNumEdificio());
            ps.setString(7, cli.getNif());
            ps.setString(8, cli.getClaveCondicionPago());
            ps.setString(9, cli.getGrupoCuentaDeudor());
            ps.setString(10, cli.getCuentaAsoConta());
            ps.setString(11, cli.getMoneda());
            ps.setString(12, cli.getIncoParte1());
            ps.setString(13, cli.getIncoParte2());
        }catch (Exception e) {
            System.err.println("Error en InsertarMaterial por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
}
