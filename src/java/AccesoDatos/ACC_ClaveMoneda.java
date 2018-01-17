package AccesoDatos;

import Entidades.clave_moneda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_ClaveMoneda {

    private static ACC_ClaveMoneda Instance = null;

    public static ACC_ClaveMoneda ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_ClaveMoneda();
        }
        return Instance;
    }

    public int ValidarClaveMoneda(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT clave_moneda FROM clave_moneda WHERE clave_moneda='" + id + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String cm = rs.getString("clave_moneda");
                if (cm.equals(id)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarClaveMoneda por " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }

    public LinkedList<clave_moneda> ConsultaMatchClvMon(String query, String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<clave_moneda> clvMon = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                clave_moneda cm = new clave_moneda();
                cm.setClave_moneda(rs.getString("clave_moneda"));
                cm.setDescripcion(rs.getString(des));
                clvMon.add(cm);
            }
        } catch (Exception e) {
            System.err.println("Error ConsultaMatchGAR(ACC_GrupoArticulos) por: " + e);
        }
        cnx.CerrarConexion(con);
        return clvMon;
    }
 public ArrayList ConsultarClvMonedaOrden(String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList clvs = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        clave_moneda clv;
        String SP = "{CALL PM.Ordenes_ConsultarClaveMoneda(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                clv = new clave_moneda();
                clv.setClave_moneda(rs.getString("clave_moneda"));
                clv.setDescripcion(rs.getString(des));
                clvs.add(clv);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarClvMonedaOrden(ACC_PuestoTrabajo por: )" + ex);
        }finally {
            cnx.CerrarConexion(con);
        }
        return clvs;
    }
    public int ValidarClvM(String ClvM) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT clave_moneda FROM clave_moneda WHERE clave_moneda='" + ClvM + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String clv = rs.getString("clave_moneda");
                if (clv.equals(ClvM)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidadClvMone");
        }
        cnx.CerrarConexion(con);
        return 0;
    }

  
}
