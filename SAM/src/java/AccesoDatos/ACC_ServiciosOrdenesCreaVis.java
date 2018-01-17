/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.servicios_ordenes_crea_vis;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author AREConsulting
 */
public class ACC_ServiciosOrdenesCreaVis {

    public static ACC_ServiciosOrdenesCreaVis Instance = null;

    public static ACC_ServiciosOrdenesCreaVis ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_ServiciosOrdenesCreaVis();
        }
        return Instance;
    }

    public LinkedList<servicios_ordenes_crea_vis> ObtieneServiciosOrdenesVis(String query) {
        Conexion cnx = new Conexion();
        LinkedList<servicios_ordenes_crea_vis> serord = new LinkedList<>();
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                servicios_ordenes_crea_vis v = new servicios_ordenes_crea_vis();
                v.setFolio_sam(rs.getString("folio_sam"));
                v.setNum_operacion(rs.getString("num_operacion"));
                v.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                v.setClase_coste(rs.getString("clase_coste"));
                v.setNum_servicio(rs.getString("num_servicio"));
                v.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                v.setGrupo_articulos(rs.getString("grupo_articulos"));
                serord.add(v);
            }
        } catch (Exception ex) {
            System.err.println("Error de datos vis: " + ex);
        }
        return serord;
    }

}
