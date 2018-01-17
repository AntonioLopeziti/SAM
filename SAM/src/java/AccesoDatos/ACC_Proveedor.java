/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ACC_Proveedor {

    private static ACC_Proveedor Instance = null;

    public static ACC_Proveedor ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Proveedor();
        }
        return Instance;
    }

    public String ObtenerNombreProvedor(String numpro) {
        String nom = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.DocumentosMateriales_ObtenerProveedor(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, numpro);
            rs = ps.executeQuery();
            while (rs.next()) {
                nom = rs.getString("nombre1");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return nom;
    }

    public LinkedList<proveedor> ConsultaMatchProveedor(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<proveedor> prov = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                proveedor p = new proveedor();
                p.setIdProveedor(rs.getString("IdProveedor"));
                p.setNombre1(rs.getString("nombre1"));
                p.setPoblacion(rs.getString("poblacion"));
                prov.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error em metodo ConsultaMatchProveedor (ACC_Proveedor) por: " + e);
        } finally {

        }
        return prov;
    }

    public proveedor ObtenerDatosProveedor(String query) {
        proveedor p = new proveedor();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                p.setIdProveedor(rs.getString("IdProveedor"));
                p.setSociedad(rs.getString("sociedad"));
                p.setOrganizacionCompras(rs.getString("organizacion_compras"));
                p.setNombre1(rs.getString("nombre1"));
                p.setNombre2(rs.getString("nombre2"));
                p.setNombre3(rs.getString("nombre3"));
                p.setNombre4(rs.getString("nombre4"));
                p.setPoblacion(rs.getString("poblacion"));
                p.setLugarResidencia(rs.getString("lugar_residencia"));
                p.setCalle(rs.getString("calle"));
                p.setDistrito(rs.getString("distrito"));
                p.setNumEdificio(rs.getString("num_edificio"));
                p.setNIF(rs.getString("nif"));
                p.setClaveCondicionesPago(rs.getString("clave_condiciones_pago"));
                p.setIndicadorABC(rs.getString("indicador_abc"));
                p.setGrupoCuentasAcreedor(rs.getString("grupo_cuentas_acreedor"));
                p.setCuentaAsociadaConta(rs.getString("cuenta_asociada_conta"));
                p.setMonedaPedido(rs.getString("moneda_pedido"));
                p.setValorMinimoPedido(rs.getString("valor_minimo_pedido"));
                p.setIncoPart1(rs.getString("inco_parte1"));
                p.setIncoPart2(rs.getString("inco_parte2"));
                p.setClaveControlConfir(rs.getString("clave_control_confir"));
                p.setGrupoCompras(rs.getString("grupo_compras"));
                p.setPeticionBorradorMaestro(rs.getString("peticion_borrador_maestro"));
                p.setBloqueoContabilizaionSociedad(rs.getString("bloqueo_contabilizacion_sociedad"));
                p.setPeticionBorradorCentral(rs.getString("peticion_borrador_central"));
                p.setBloqueoContabilizaionSociedad(rs.getString("bloqueo_contabilizacion_sociedad"));
                p.setPeticionBorradorCentral(rs.getString("peticion_borrador_central"));
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en metodo Obtener DatosProveedor(ACC_Proveedor) por: " + e);
        }
        return p;
    }

    public LinkedList<proveedor> ObtenerAllProvCSP(String d1, String d2, String d3, String d4, String d5, String d6) {
        LinkedList<proveedor> pr = new LinkedList<>();
        Conexion con = new Conexion();
        String query = "SELECT * FROM proveedores"
                + " where  codificacion_poblacion like'" + d3 + "%' "
                + "and poblacion like'" + d4 + "%' and nombre1 like'" + d5 + "%'"
                + " and `IdProveedor` like'" + d6 + "%'";
        try {
            Connection conn = con.ObtenerConexion();
            Statement st;
            ResultSet rs;

            st = conn.createStatement();
            rs = st.executeQuery(query);
            con.ObtenerConexion();
            while (rs.next()) {
                proveedor p = new proveedor();
                p.setIdProveedor(rs.getString("IdProveedor"));
                p.setSociedad(rs.getString("sociedad"));
                p.setOrganizacionCompras(rs.getString("organizacion_compras"));
                p.setNombre1(rs.getString("nombre1"));
                p.setNombre2(rs.getString("nombre2"));
                p.setNombre3(rs.getString("nombre3"));
                p.setNombre4(rs.getString("nombre4"));
                p.setPoblacion(rs.getString("poblacion"));
                p.setLugarResidencia(rs.getString("lugar_residencia"));
                p.setCalle(rs.getString("calle"));
                p.setDistrito(rs.getString("distrito"));
                p.setNumEdificio(rs.getString("num_edificio"));
                p.setNIF(rs.getString("nif"));
                p.setClaveCondicionesPago(rs.getString("clave_condiciones_pago"));
                p.setIndicadorABC(rs.getString("indicador_abc"));
                p.setGrupoCuentasAcreedor(rs.getString("grupo_cuentas_acreedor"));
                p.setCuentaAsociadaConta(rs.getString("cuenta_asociada_conta"));
                p.setMonedaPedido(rs.getString("moneda_pedido"));
                p.setValorMinimoPedido(rs.getString("valor_minimo_pedido"));
                p.setIncoPart1(rs.getString("inco_parte1"));
                p.setIncoPart2(rs.getString("inco_parte2"));
                p.setClaveControlConfir(rs.getString("clave_control_confir"));
                p.setGrupoCompras(rs.getString("grupo_compras"));
                p.setPeticionBorradorMaestro(rs.getString("peticion_borrador_maestro"));
                p.setBloqueoContabilizaionSociedad(rs.getString("bloqueo_contabilizacion_sociedad"));
                p.setPeticionBorradorCentral(rs.getString("peticion_borrador_central"));
                p.setBloqueoContabilizaionSociedad(rs.getString("bloqueo_contabilizacion_sociedad"));
                p.setPeticionBorradorCentral(rs.getString("peticion_borrador_central"));
                pr.add(p);
            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return pr;
    }

    // Match proveedor
    public LinkedList<proveedor> MuestraMatchProveedor(String nom, String pob, String acre, int limite) {
        LinkedList<proveedor> prove = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        try {
            pst = con.prepareCall("{CALL MM.proveedores_MuestraMatch(?, ?, ?, ?)}");
            pst.setString(1, nom);
            pst.setString(2, pob);
            pst.setString(3, acre);
            pst.setInt(4, limite);
            rs = pst.executeQuery();
            while (rs.next()) {
                proveedor p = new proveedor();
                p.setIdProveedor(rs.getString("IdProveedor"));
                p.setNombre1(rs.getString("nombre1"));
                p.setPoblacion(rs.getString("poblacion"));
                prove.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error del match proveedores: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return prove;
    }

    public ArrayList<proveedor> MuestraMatchProveedor(String nom, String pob, String acre, String limite) {
        ArrayList<proveedor> prove = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        try {
            pst = con.prepareCall("{CALL MM.proveedores_MuestraMatch(?, ?, ?, ?)}");
            pst.setString(1, nom);
            pst.setString(2, pob);
            pst.setString(3, acre);
            pst.setString(4, limite);
            rs = pst.executeQuery();
            while (rs.next()) {
                proveedor p = new proveedor();
                p.setIdProveedor(rs.getString("IdProveedor"));
                p.setNombre1(rs.getString("nombre1"));
                p.setPoblacion(rs.getString("poblacion"));
                prove.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error del match proveedores: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return prove;
    }

    //valida campo proveedor
    public boolean ValidaCampoProveedor(String pro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        proveedor m = new proveedor();
        try {
            ps = con.prepareCall("{CALL MM.Proveedores_ValidarProveedor(?)}");
            ps.setString(1, pro);
            rs = ps.executeQuery();
            while (rs.next()) {
                String proveedor = rs.getString("IdProveedor");
                if (pro.equals(proveedor)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error de validar proveedor: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return false;
    }

    public String ValidarAcreOrd(String acre) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarAcre(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, acre);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en DecimalUnidadMedida" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public boolean InsertaProvCrea(proveedor prov) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL MM.Proveedores_InsertProv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, prov.getNombre1());
            ps.setString(2, prov.getPoblacion());
            ps.setString(3, prov.getLugarResidencia());
            ps.setString(4, prov.getCalle());
            ps.setString(5, prov.getDistrito());
            ps.setString(6, prov.getNumEdificio());
            ps.setString(7, prov.getNIF());
            ps.setString(8, prov.getClaveCondicionesPago());
            ps.setString(9, prov.getIndicadorABC());
            ps.setString(10, prov.getGrupoCuentasAcreedor());
            ps.setString(11, prov.getCuentaAsociadaConta());
            ps.setString(12, prov.getMonedaPedido());
            ps.setString(13, prov.getValorMinimoPedido());
            ps.setString(14, prov.getIncoPart1());
            ps.setString(15, prov.getIncoPart2());
            ps.setString(16, prov.getClaveControlConfir());
            ps.setString(17, prov.getGrupoCompras());
            ps.setString(18, prov.getPeticionBorradorMaestro());
            ps.setString(19, prov.getBloqueoContabilizaionSociedad());
            ps.setString(20, prov.getPeticionBorradorCentral());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarProveedor por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;

    }
}
