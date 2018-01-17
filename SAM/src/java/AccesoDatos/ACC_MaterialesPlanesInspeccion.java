package AccesoDatos;

import Entidades.materialesPlanesInspeccion;
import Entidades.qm_cabecera_n;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ACC_MaterialesPlanesInspeccion {

    private static ACC_MaterialesPlanesInspeccion Instance = null;

    public static ACC_MaterialesPlanesInspeccion ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_MaterialesPlanesInspeccion();
        }
        return Instance;
    }

    public materialesPlanesInspeccion CargarMaterialOrden(String numMat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        materialesPlanesInspeccion mat = new materialesPlanesInspeccion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_CargarCabeceraMatCalidad(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, numMat);
            rs = ps.executeQuery();
            rs.next();
            mat = new materialesPlanesInspeccion();
            mat.setNum_material(rs.getString("num_material"));
            mat.setTexto_breve_material(rs.getString("texto_breve_material"));
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarMaterialOrden(ACC_Equipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mat;
    }
    public qm_cabecera_n CargarCabceraPM(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        qm_cabecera_n cab = new qm_cabecera_n();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.qm_cabecera_cld(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            rs.next();
            cab.setNum_lote_inspeccion(rs.getString("num_lote_inspeccion"));
            cab.setCreado_registro_datos(rs.getString("creado_registro_datos"));
            cab.setUltimo_modificador_registro_datos(rs.getString("ultimo_modificador_registro_datos"));
            cab.setTexto_breve(rs.getString("texto_breve"));
            cab.setCentro(rs.getString("centro"));
            cab.setFecha_creacion_lote(rs.getString("fecha_creacion_lote"));
            cab.setFecha_modificacion_registro_datos(rs.getString("fecha_modificacion_registro_datos"));
            cab.setHora_creacion_lote(rs.getString("hora_creacion_lote"));
            cab.setHora_modificacion_lote(rs.getString("hora_modificacion_lote"));
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarMaterialOrden(ACC_Equipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cab;
    }
}
