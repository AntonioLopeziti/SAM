/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.tipo_posicion;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 */
public class ACC_TipoPosicion {

    private static ACC_TipoPosicion Instance = null;

    public static ACC_TipoPosicion ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_TipoPosicion();
        }
        return Instance;
    }

    public ArrayList<tipo_posicion> CargarTipoPosicion(String Desc) {
        ArrayList<tipo_posicion> tp = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarTPosicion(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Desc);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo_posicion t = new tipo_posicion();
                t.setTipo_posicion(rs.getString("tipo_posicion_ES"));
                t.setDescripcion(rs.getString(Desc));
                tp.add(t);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTipoPosicion por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return tp;
    }

    public LinkedList<tipo_posicion> ConsultaMatcTipoPosicionSP(String query, String tipo, String desc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<tipo_posicion> tip = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tipo_posicion ti = new tipo_posicion();
                ti.setNum_tipo_posicion(rs.getString("num_tipo_posicion"));
                ti.setTipo_posicion(rs.getString(tipo));
                ti.setDescripcion(rs.getString(desc));
                tip.add(ti);
            }
            cnx.CerrarConexion(con);

        } catch (Exception e) {
            System.err.println("Error en Consulta MatcTipoPosicionSP (ACC_TipoPosicion) por: " + e);
        }
        return tip;
    }

    public boolean ValidarTipoPosLan(String id, String idioma) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String tipopos = "tipo_posicion_" + idioma;
        String query = "SELECT " + tipopos + " FROM tipo_posicion WHERE " + tipopos + "='" + id + "'";
        String posi = "";
        if (idioma.equals("ES")) {
            posi = "F";
        } else if (idioma.equals("EN")) {
            posi = "D";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String tp = rs.getString(tipopos);
                if (tp.equals(id) && id.equals(posi)) {
                    cnx.CerrarConexion(con);
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarTipoPosLan ACC_TipoPosicion por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public static void main(String[] args) {
        ACC_TipoPosicion tp = new ACC_TipoPosicion();
        System.out.println(tp.ValidarTipoPosLan("D", "EN"));
    }

}
