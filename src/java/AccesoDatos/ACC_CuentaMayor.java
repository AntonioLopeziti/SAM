package AccesoDatos;

import Entidades.CeCos;
import Entidades.CuentaMayor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_CuentaMayor {

    private static ACC_CuentaMayor Instance = null;

    public static ACC_CuentaMayor ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_CuentaMayor();
        }
        return Instance;
    }
      public ArrayList<CeCos> ConsultaMCCuentaMayor(String cm, String des, int ctd, String user) {
        ArrayList<CeCos> ce = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarCuentaMayor(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cm);
            ps.setString(2, des);
            ps.setInt(3, ctd);
            ps.setString(4, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                CeCos c = new CeCos();
                c.setClaseCoste(rs.getString("clase_coste"));
                c.setDescripcion(rs.getString("descripcion_clase_coste"));
                ce.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCCuentaMayor por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ce;
    }

    public ArrayList ConsultarOrganizacionCompraOrden(String clsCo, String txt, String ctd) {
        ArrayList<CeCos> ce = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ConsultarCuentaMayor(?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, clsCo);
            ps.setString(2, txt);
            ps.setString(3, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {

                CeCos c = new CeCos();
                c.setClaseCoste(rs.getString("clase_coste"));
                c.setDescripcion(rs.getString("descripcion_clase_coste"));
                ce.add(c);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarOrganizacionCompraOrden(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);

        }
        return ce;

    }

    public boolean ValidarCMayor(String cm, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String sql = "{CALL MM.Solped_ValidarCuentaMayor(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cm);
            ps.setString(2, us);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarCMayor por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean validarCCCM(String cm, String cc) {
        boolean ban = false;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_ValidarCCostoCMayor(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cm);
            ps.setString(2, cc);
            rs = ps.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarCMayor por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    /////////////////////////

    public LinkedList<CeCos> ConsultaCuentaMayor(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<CeCos> cue = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CeCos c = new CeCos();
                c.setClaseCoste(rs.getString("clase_coste"));
                c.setDescripcion(rs.getString("descripcion_clase_coste"));
                cue.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCuentaMayor en ACC_CuentaMayor por: +e");
        }
        cnx.CerrarConexion(con);
        return cue;
    }

    public int ValidarClaseCoste(String clsC) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT clase_coste FROM cecos WHERE clase_coste='" + clsC + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String cl = rs.getString("clase_coste");
                if (cl.equals(clsC)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarClaseCoste");
        }
        cnx.CerrarConexion(con);
        return 0;
    }

    public LinkedList<CuentaMayor> ConsultaCuentaMayor(String query, String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<CuentaMayor> cue = new LinkedList<CuentaMayor>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CuentaMayor c = new CuentaMayor();
                c.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                c.setPlan_cuentas(rs.getString("plan_cuentas"));
                c.setDescripcion(rs.getString(des));
                cue.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCuentaMayor en ACC_CuentaMayor por: +e");
        }
        cnx.CerrarConexion(con);
        return cue;
    }
}
