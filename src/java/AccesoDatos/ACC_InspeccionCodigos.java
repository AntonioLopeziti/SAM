package AccesoDatos;

import Entidades.cabecera_lotes_inspeccion_movimientos_crea;
import Entidades.inspeccion_codigos;
import Entidades.posiciones_lotes_inspeccion_movimientos_crea;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ACC_InspeccionCodigos {

    private static ACC_InspeccionCodigos Instance = null;

    public static ACC_InspeccionCodigos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_InspeccionCodigos();
        }
        return Instance;
    }

    public String ConsultarGpoCod(String conjSel) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_GpoCodXConjSel(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, conjSel);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en ConsultarGpoCod" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public ArrayList ConsultaCodigos(String idi, String conjSel) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList ctrls = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        inspeccion_codigos cl;
        String SP = "{CALL MM.Movimientos_ConsultarCodig(?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, idi);
            ps.setString(2, conjSel);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl = new inspeccion_codigos();
                cl.setCodigo(rs.getString("codigo"));
                cl.setValoracion_codigo(rs.getString("valoracion_codigo"));
                cl.setDescripcion(rs.getString("descripcion_" + idi));
                ctrls.add(cl);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaCodigos(ACC_InspeccionCodigos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ctrls;
    }

    public String ValidarCodigoInsp(String cod, String grupo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_ValidarCodigo(?,?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, cod);
            ps.setString(2, grupo);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarCodigoInsp" + e);
        }
        return check;
    }

    public boolean InsertCabeceraLotInsp(cabecera_lotes_inspeccion_movimientos_crea cabLotIns) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst = null;
        boolean confirmacion = false;
        try {
            cbst = con.prepareCall("{CALL MM.Movimientos_InsertarCabeceraLotInsp(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbst.setString(1, cabLotIns.getFolio_sam());
            cbst.setString(2, cabLotIns.getFecha());
            cbst.setString(3, cabLotIns.getHora_dia());
            cbst.setString(4, cabLotIns.getMaterial());
            cbst.setString(5, cabLotIns.getTexto_breve_material());
            cbst.setString(6, cabLotIns.getNum_doc_compras());
            cbst.setString(7, cabLotIns.getFolio_sam_mov());
            cbst.setString(8, cabLotIns.getCentro());
            cbst.setString(9, cabLotIns.getCreador_registro_datos());
            cbst.setString(10, cabLotIns.getUsuario());
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

    public boolean InsertPosLotInspCalidad(posiciones_lotes_inspeccion_movimientos_crea posLotInsp) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst = null;
        boolean confirmacion = false;
        try {
            cbst = con.prepareCall("{CALL MM.Movimientos_InsertarInspPosLot(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbst.setString(1, posLotInsp.getFolio_sam());
            cbst.setString(2, posLotInsp.getNum_caracteristica_inspeccion());
            cbst.setString(3, posLotInsp.getFecha());
            cbst.setString(4, posLotInsp.getHora_dia());
            cbst.setString(5, posLotInsp.getTexto_breve_caracteristica_inspeccion());
            cbst.setString(6, posLotInsp.getDescripcion_breve_conjunto_seleccion());
            cbst.setString(7, posLotInsp.getEntrada_catalogo_conjunto_seleccion());
            cbst.setString(8, posLotInsp.getTamano_muestra_inspeccionar_carac());
            cbst.setString(9, posLotInsp.getNum_unidades_muestreo_defectuoso());
            cbst.setString(10, posLotInsp.getValor_original_anterior_tratamiento_entradas());
            cbst.setString(11, posLotInsp.getCodigo());
            cbst.setString(12, posLotInsp.getUnidad_medida_graban_cuantitativos());
            cbst.setString(13, posLotInsp.getTexto_breve());
            cbst.setString(14, posLotInsp.getCatalogo());
            cbst.setString(15, posLotInsp.getCreador_registro_datos());

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

}
