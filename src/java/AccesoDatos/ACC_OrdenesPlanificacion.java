package AccesoDatos;

import Entidades.ordenes_planificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ACC_OrdenesPlanificacion {

    private static ACC_OrdenesPlanificacion Instance = null;

    public static ACC_OrdenesPlanificacion ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_OrdenesPlanificacion();
        }
        return Instance;
    }

    public ordenes_planificacion CargarDataPlanificacionSAP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ordenes_planificacion coc = new ordenes_planificacion();
        String query = "{call PM.Ordenes_CargarPlanifiSAP(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setPlan_mantenimiento_preventivo(rs.getString("plan_mantenimiento_preventivo"));
                coc.setPosicion_mantenimiento(rs.getString("posicion_mantenimiento"));
                coc.setTipo_hoja_ruta(rs.getString("tipo_hoja_ruta"));
                coc.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                coc.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
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
