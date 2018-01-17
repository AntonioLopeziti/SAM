package AccesoDatos;

import Entidades.grupo_compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_GrupoCompras {

    private static ACC_GrupoCompras Instance = null;

    public static ACC_GrupoCompras ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_GrupoCompras();
        }
        return Instance;
    }

    public ArrayList<grupo_compras> ConsultaMCGrupoCompras(String gc, String den, int ctd) {
        ArrayList<grupo_compras> grc = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarGrupoCompras(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, gc);
            ps.setString(2, den);
            ps.setInt(3, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                grupo_compras g = new grupo_compras();
                g.setId_grupo_compras(rs.getString("id_grupo_compras"));
                g.setDenominacion_grupocompras(rs.getString("denominacion_grupocompras"));
                grc.add(g);
            }
        } catch (Exception e) {
            System.err.println("Error ConsulraMCGrupoCompras por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return grc;
    }

    public ArrayList ConsultarGpoComprasOrden() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList gpos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        grupo_compras gpo;
        String SP = "{CALL PM.Ordenes_ConsultarGpoCompras}";
        try {
            ps = con.prepareStatement(SP);
            rs = ps.executeQuery();
            while (rs.next()) {
                gpo = new grupo_compras();
                gpo.setId_grupo_compras(rs.getString("id_grupo_compras"));
                gpo.setDenominacion_grupocompras(rs.getString("denominacion_grupocompras"));
                gpos.add(gpo);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarGpoComprasOrden(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return gpos;
    }

    public boolean ValidarGCompras(String gc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String sql = "{CALL MM.Solped_ValidarGrupoCompras(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, gc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarGCompras ACC_GrupoCompras por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    ////////////////////////////////////////////////////////////////////

    public int ValidarGrupoCompras(String gpoC) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT id_grupo_compras FROM grupo_compras WHERE id_grupo_compras='" + gpoC + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String GA = rs.getString("id_grupo_compras");
                if (gpoC.equals(GA)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarGeupoArituclo por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
}
