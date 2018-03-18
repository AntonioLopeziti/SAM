package AccesoDatos;

import Entidades.ordenes_control;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ACC_OrdenesControl {

    private static ACC_OrdenesControl Instance = null;

    public static ACC_OrdenesControl ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_OrdenesControl();
        }
        return Instance;
    }

    public ordenes_control CargarDataCtrlSAP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ordenes_control coc = new ordenes_control();
        String query = "{call PM.Ordenes_CargarCtrlSAP(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setNombre_autor(rs.getString("nombre_autor"));
                coc.setFecha_entrada(rs.getString("fecha_entrada"));
                coc.setModificado_por(rs.getString("modificado_por"));
                coc.setFecha_modificacion(rs.getString("fecha_modificacion"));
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return coc;
    }
    public ordenes_control CargarDataCtrlPP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ordenes_control coc = new ordenes_control();
        String query = "{call PP.Ordenes_CargarCtrlSAP(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setNombre_autor(rs.getString("nombre_autor"));
                coc.setFecha_entrada(rs.getString("fecha_entrada"));
                coc.setModificado_por(rs.getString("modificado_por"));
                coc.setFecha_modificacion(rs.getString("fecha_modificacion"));
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return coc;
    }

}
