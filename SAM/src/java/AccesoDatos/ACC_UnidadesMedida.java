package AccesoDatos;

import Entidades.unidades_medida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_UnidadesMedida {

    private static ACC_UnidadesMedida Instance = null;

    public static ACC_UnidadesMedida ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_UnidadesMedida();
        }
        return Instance;
    }

    public static void main(String[] args) {
        String des = "descripcion_ES";
        String query = "SELECT * FROM unidades_medida";
        System.out.println(ACC_UnidadesMedida.ObtenerInstancia().ConsultaMatchUnidadMedida(query, des));
    }

    public ArrayList<unidades_medida> ConsultaMCUnidadMedida(String um, String des, String descampo, String ctd) {
        ArrayList<unidades_medida> ume = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarUnidadmedida(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, um);
            ps.setString(2, des);
            ps.setString(3, descampo);
            ps.setString(4, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                unidades_medida u = new unidades_medida();
                u.setUnidad_medida(rs.getString("unidad_medida"));
                u.setDescripcion(rs.getString(descampo));
                ume.add(u);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCUnidadMedida por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ume;
    }

    public boolean ValidarUMedida(String um) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String sql = "{CALL MM.Solped_ValidarUnidadMedida(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, um);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public LinkedList<unidades_medida> ConsultaMatchUnidadMedida(String query, String desc) {
        LinkedList<unidades_medida> ums = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                unidades_medida um = new unidades_medida();
                um.setUnidad_medida(rs.getString("unidad_medida"));
                um.setDescripcion(rs.getString(desc));
                ums.add(um);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchUnidadMedida (ACC_UnidadesMedida) " + e);
        }
        return ums;
    }

    public ArrayList ConsultarUMDMatchOrd(String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList umds = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        unidades_medida um;
        String SP = "{CALL PM.Ordenes_ConsultarUnidadesMedida(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                um = new unidades_medida();
                um.setUnidad_medida(rs.getString("unidad_medida"));
                um.setDescripcion(rs.getString(des));
                umds.add(um);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarUMDMatchOrd(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return umds;
    }

    public int ValidarUnidadMedida(String UM) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT unidad_medida FROM unidades_medida WHERE unidad_medida='" + UM + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String un = rs.getString("unidad_medida");
                if (un.equals(UM)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidadUnidadMedida");
        }
        return 0;
    }

    public String ValidarUMDord(String umd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.unidades_medida_get_MOM(?)}";
        String un = "";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, umd);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                un = rs.getString("decimales");
            }
        } catch (Exception e) {
            System.err.println("Error en DecimalUnidadMedida" + e);
        }
        return un;
    }

    public String ValidarUMDOrd(String umd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();

        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarUMD(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, umd);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);

            cnx.CerrarConexion(con);
            while (rs.next()) {
                check = rs.getString("decimales");
            }
        } catch (Exception e) {
            System.err.println("Error en DecimalUnidadMedida" + e);
        }
        return check;
    }

    public String DecimalUnidadMedida(String umd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_GetTypeUMD(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, umd);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarRowOperacionOrd(ACC_BOMEquipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

}
