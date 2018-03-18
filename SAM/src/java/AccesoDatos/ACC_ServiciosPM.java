/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.servicios_pm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author AREConsulting
 */
public class ACC_ServiciosPM {

    public static ACC_ServiciosPM Instance = null;

    public static ACC_ServiciosPM ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_ServiciosPM();
        }
        return Instance;
    }

    public static void main(String[] lu) {
        String q = "select * from servicios_pm where num_orden = '600000000065'";
        LinkedList<servicios_pm> p = ACC_ServiciosPM.ObtenerInstancia().ObtieneServiciosOrdenes(q);
        if (p.size() > 0) {
            for (int i = 0; i < p.size(); i++) {
                System.out.println("-> " + p.get(i).getNum_servicio());
            }
        } else {
            System.out.println("ERROOOOOOOOOOOOR");
        }
    }

    public LinkedList<servicios_pm> ObtieneServiciosOrdenes(String query) {
        Conexion cnx = new Conexion();
        LinkedList<servicios_pm> serpm = new LinkedList<>();
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                servicios_pm pm = new servicios_pm();
                pm.setFolio_sam(rs.getString("folio_sam"));
                pm.setNum_operacion(rs.getString("num_operacion"));
                pm.setCant_signo(rs.getString("cant_signo"));
                pm.setClase_coste(rs.getString("clase_coste"));
                pm.setNum_servicio(rs.getString("num_servicio"));
                pm.setUnidad_med_base(rs.getString("unidad_med_base"));
                pm.setGrupo_articulos(rs.getString("grupo_articulos"));
                serpm.add(pm);
            }
        } catch (Exception ex) {
            System.err.println("Erro de datos pm: " + ex);
        }
        return serpm;
    }

    public ArrayList CargarServiciosSAP(String ord, String noOpe) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList serpm = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        servicios_pm pm;
        String SP = "{CALL PM.Ordenes_ConsultarSeviciosSAP(?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            ps.setString(2, noOpe);
            rs = ps.executeQuery();
            while (rs.next()) {
                pm = new servicios_pm();
                pm.setFolio_sam(rs.getString("folio_sam"));
                pm.setNum_operacion(rs.getString("num_operacion"));
                pm.setCant_signo(rs.getString("cant_signo"));
                pm.setClase_coste(rs.getString("clase_coste"));
                pm.setNum_servicio(rs.getString("num_servicio"));
                pm.setUnidad_med_base(rs.getString("unidad_med_base"));
                pm.setGrupo_articulos(rs.getString("grupo_articulos"));
                serpm.add(pm);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarServiciosSAP(ACC_ServiciosPM por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return serpm;
    }
    public ArrayList CargarServiciosPP(String ord, String noOpe) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList serpm = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        servicios_pm pm;
        String SP = "{CALL PP.Ordenes_ConsultarSeviciosSAP(?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            ps.setString(2, noOpe);
            rs = ps.executeQuery();
            while (rs.next()) {
                pm = new servicios_pm();
                pm.setFolio_sam(rs.getString("folio_sam"));
                pm.setNum_operacion(rs.getString("num_operacion"));
                pm.setCant_signo(rs.getString("cant_signo"));
                pm.setClase_coste(rs.getString("clase_coste"));
                pm.setNum_servicio(rs.getString("num_servicio"));
                pm.setUnidad_med_base(rs.getString("unidad_med_base"));
                pm.setGrupo_articulos(rs.getString("grupo_articulos"));
                serpm.add(pm);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarServiciosSAP(ACC_ServiciosPM por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return serpm;
    }

}
