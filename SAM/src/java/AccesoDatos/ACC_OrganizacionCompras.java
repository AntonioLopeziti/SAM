package AccesoDatos;

import Entidades.organizacion_compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ACC_OrganizacionCompras {

    private static ACC_OrganizacionCompras Instance = null;

    public static ACC_OrganizacionCompras ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_OrganizacionCompras();
        }
        return Instance;
    }

    public ArrayList<organizacion_compras> ConsultaMCOrgCompras() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<organizacion_compras> or = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProcOrg = "{CALL MM.Solped_CargarOrgCompras}";
        try {
            ps = con.prepareStatement(ProcOrg);
            rs = ps.executeQuery();
            while (rs.next()) {
                organizacion_compras o = new organizacion_compras();
                o.setOrganizacion_compras(rs.getString("organizacion_compras"));
                or.add(o);
            }
        } catch (Exception e) {
            System.err.println("Error ConsultaMCOrgCompras ACC_OrganizacionCompras por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return or;
    }

    public ArrayList ConsultarOrganizacionCompraOrden(String idioma) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList orgs = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        organizacion_compras org;
        String SP = "{CALL PM.Ordenes_ConsultarOrganizacionCompras(?)}";
        String desOrC = "descripcion_" + idioma;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, idioma);
            rs = ps.executeQuery();
            while (rs.next()) {
                org = new organizacion_compras();
                org.setOrganizacion_compras(rs.getString("organizacion_compras"));
                org.setDescripcion(rs.getString(desOrC));
                orgs.add(org);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en ConsultarOrganizacionCompraOrden ACC_OrganizacionCompras por: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return orgs;
    }
}