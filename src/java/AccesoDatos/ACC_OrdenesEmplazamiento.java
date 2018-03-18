package AccesoDatos;

import Entidades.ordenes_emplazamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ACC_OrdenesEmplazamiento {

    private static ACC_OrdenesEmplazamiento Instance = null;

    public static ACC_OrdenesEmplazamiento ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_OrdenesEmplazamiento();
        }
        return Instance;
    }

    public ordenes_emplazamiento CargarDataEmplazamientoSAP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ordenes_emplazamiento coc = new ordenes_emplazamiento();
        String query = "{call PM.Ordenes_CargarEmplazamientoSAP(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setCentro_emplazamiento(rs.getString("centro_emplazamiento"));
                coc.setEmplazamiento_objeto_mantenimiento(rs.getString("emplazamiento_objeto_mantenimiento"));
                coc.setLocall(rs.getString("locall"));
                coc.setArea_empresa(rs.getString("area_empresa"));
                coc.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                coc.setIndicador_abc(rs.getString("indicador_abc"));
                coc.setCampo_clasificacion(rs.getString("campo_clasificacion"));
                coc.setSociedad(rs.getString("sociedad"));
                coc.setNum_principal_activo_fijo(rs.getString("num_principal_activo_fijo"));
                coc.setSubnumero_activo_fijo(rs.getString("subnumero_activo_fijo"));
                coc.setCentro_coste(rs.getString("centro_coste"));
                coc.setElemento_plan_estructura(rs.getString("elemento_plan_estructura"));

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
    public ordenes_emplazamiento CargarDataEmplazamientoPP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ordenes_emplazamiento coc = new ordenes_emplazamiento();
        String query = "{call PP.Ordenes_CargarEmplazamientoSAP(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setCentro_emplazamiento(rs.getString("centro_emplazamiento"));
                coc.setEmplazamiento_objeto_mantenimiento(rs.getString("emplazamiento_objeto_mantenimiento"));
                coc.setLocall(rs.getString("locall"));
                coc.setArea_empresa(rs.getString("area_empresa"));
                coc.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                coc.setIndicador_abc(rs.getString("indicador_abc"));
                coc.setCampo_clasificacion(rs.getString("campo_clasificacion"));
                coc.setSociedad(rs.getString("sociedad"));
                coc.setNum_principal_activo_fijo(rs.getString("num_principal_activo_fijo"));
                coc.setSubnumero_activo_fijo(rs.getString("subnumero_activo_fijo"));
                coc.setCentro_coste(rs.getString("centro_coste"));
                coc.setElemento_plan_estructura(rs.getString("elemento_plan_estructura"));

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
