package AccesoDatos;

import Entidades.grupo_articulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_GrupoArticulos {

    private static ACC_GrupoArticulos Instance = null;

    public static ACC_GrupoArticulos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_GrupoArticulos();
        }
        return Instance;
    }

    public ArrayList<grupo_articulos> ConsultaMCGrupoArticulos(String ga, String den, String des, String dencampo, String descampo, String ctd) {
        ArrayList<grupo_articulos> gar = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarGrupoArticulo(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ga);
            ps.setString(2, den);
            ps.setString(3, des);
            ps.setString(4, dencampo);
            ps.setString(5, descampo);
            ps.setString(6, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                grupo_articulos g = new grupo_articulos();
                g.setGrupo_articulo(rs.getString("grupo_articulo"));
                g.setDenominacion(rs.getString(dencampo));
                g.setDescripcion(rs.getString(descampo));
                gar.add(g);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCGrupoArticulos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return gar;
    }

    public boolean ValidarGArticulo(String ga) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String sql = "{CALL MM.Solped_ValidarGrupoArticulo(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ga);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarGArticulo ACC_GrupoArticulos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    ////////////////////////////////////////////////////////////////////

    public LinkedList<grupo_articulos> ConsultaMatchGAR(String query, String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<grupo_articulos> alm = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                grupo_articulos a = new grupo_articulos();
                a.setGrupo_articulo(rs.getString("grupo_articulo"));
                a.setDenominacion(rs.getString(des));
                alm.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error ConsultaMatchGAR(ACC_GrupoArticulos) pot: " + e);
        }
        cnx.CerrarConexion(con);
        return alm;
    }

    public ArrayList ConsultarGpoArticuloOrden(String gpoA, String den, String des, String ctd, String idioma) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList gpos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        grupo_articulos gpo;
            String SP = "{CALL PM.Ordenes_ConsultarGpoArticulos(?, ? , ?, ?, ?)}";
        String desGpoA = "descripcion_" + idioma;
        String denGpoA = "denominacion_" + idioma;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, gpoA);
            ps.setString(2, den);
            ps.setString(3, des);
            ps.setString(4, ctd);
            ps.setString(5, idioma);
            rs = ps.executeQuery();
            while (rs.next()) {
                gpo = new grupo_articulos();
                gpo.setGrupo_articulo(rs.getString("grupo_articulo"));
                gpo.setDescripcion(rs.getString(desGpoA));
                gpo.setDenominacion(rs.getString(denGpoA));
                gpos.add(gpo);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarClvMonedaOrden(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return gpos;
    }

    public int ValidarGrupoArticulo(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT grupo_articulo FROM grupo_articulos WHERE grupo_articulo='" + id + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String GA = rs.getString("grupo_articulo");
                if (id.equals(GA)) {
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
