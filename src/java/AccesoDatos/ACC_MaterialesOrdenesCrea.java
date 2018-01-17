package AccesoDatos;

import Entidades.materiales_ordenes_crea;
import Entidades.operaciones_ordenes_crea;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;


public class ACC_MaterialesOrdenesCrea {

    private static ACC_MaterialesOrdenesCrea Instance = null;

    public static ACC_MaterialesOrdenesCrea ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_MaterialesOrdenesCrea();
        }
        return Instance;
    }

    public LinkedList<materiales_ordenes_crea> ConsultaMaterialesByOrd(String query) {
        LinkedList<materiales_ordenes_crea> materiales = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                materiales_ordenes_crea mat = new materiales_ordenes_crea();
                mat.setFolio_sam(rs.getString("folio_sam"));
                mat.setNum_material(rs.getString("num_material"));
                mat.setCentro(rs.getString("centro"));
                mat.setAlmacen(rs.getString("almacen"));
                mat.setLote(rs.getString("lote"));
                mat.setCantidad_emplear(rs.getString("cantidad_emplear"));
                mat.setNum_operacion(rs.getString("num_operacion"));
                mat.setTexto_breve_material(rs.getString("texto_breve_material"));
                mat.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                materiales.add(mat);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchUsuario (ACC_hojas_de_ruta) " + e);
        }
        cnx.CerrarConexion(con);
        return materiales;
    }

  

    public ArrayList ConsultaMaterialesSAM(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList mats = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        materiales_ordenes_crea mat;
        String SP = "{CALL PM.Ordenes_CargarMaterialesSAM(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            while (rs.next()) {
                mat = new materiales_ordenes_crea();
                mat.setNum_material(rs.getString("num_material"));
                mat.setTexto_breve_material(rs.getString("texto_breve_material"));
                mat.setCantidad_emplear(rs.getString("cantidad_emplear"));
                mat.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                mat.setAlmacen(rs.getString("almacen"));
                mat.setCentro(rs.getString("centro"));
                mat.setNum_operacion(rs.getString("num_operacion"));
                mat.setLote(rs.getString("lote"));
                mat.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                mat.setPuesto_descarga(rs.getString("puesto_descarga"));
                mat.setIndicador_material_granel(rs.getString("indicador_material_granel"));
                mat.setIndicador_toma_retroactiva(rs.getString("indicador_toma_retroactiva"));
                mats.add(mat);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarOperacionesSAM(ACC_OperacionesOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mats;
    }

    public boolean InsertMaterialOrdenes(materiales_ordenes_crea moc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst = null;
        boolean confirmacion = false;
        try {
            cbst = con.prepareCall("{CALL PM.Ordenes_InsertarMaterial(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbst.setString(1, moc.getFolio_sam());
            cbst.setString(2, moc.getHora_dia());
            cbst.setString(3, moc.getFecha());
            cbst.setString(4, moc.getNum_material());
            cbst.setString(5, moc.getCentro());
            cbst.setString(6, moc.getAlmacen());
            cbst.setString(7, moc.getLote());
            cbst.setString(8, moc.getCantidad_base());
            cbst.setString(9, moc.getNum_operacion());
            cbst.setString(10, moc.getTexto_breve_material());
            cbst.setString(11, moc.getUnidad_medida_base());

            confirmacion = cbst.execute();
            if (confirmacion == true) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error PS: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public String ValidarRowComponenteOrd(String mat, String umd, String cent, String alm) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarRowComponentes(?, ?, ?, ?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, umd);
            ps.setString(3, cent);
            ps.setString(4, alm);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarRowComponenteOrd(ACC_MaterialesOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

}
