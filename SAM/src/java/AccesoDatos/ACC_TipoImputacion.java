/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.tipo_imputacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 */
public class ACC_TipoImputacion {

    private static ACC_TipoImputacion Instance = null;

    public static ACC_TipoImputacion ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_TipoImputacion();
        }
        return Instance;
    }

    public ArrayList<tipo_imputacion> CargarTipoImputacion(String campo) {
        ArrayList<tipo_imputacion> ti = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarTImputacion(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, campo);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo_imputacion t = new tipo_imputacion();
                t.setTipo_imputacion(rs.getString("tipo_imputacion"));
                t.setDescripcion(rs.getString(campo));
                ti.add(t);
            }
        } catch (Exception e) {
            System.err.println("Error CargarTipoImputacion por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ti;
    }

    public LinkedList<tipo_imputacion> ConsultaMatchTipoImputacion(String query, String des) {
        LinkedList<tipo_imputacion> ti = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tipo_imputacion t = new tipo_imputacion();
                t.setTipo_imputacion(rs.getString("tipo_imputacion"));
                t.setDescripcion(rs.getString(des));
                ti.add(t);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en ConsultaMatchTipoImputacion (ACC_TipoImpuacion) por: " + e);
        }
        return ti;
    }

    public boolean ValidarTI(String ti) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT tipo_imputacion FROM tipo_imputacion WHERE tipo_imputacion = '" + ti + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String imp = rs.getString("tipo_imputacion");
                if (imp.equals(ti)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo VaidarUsuarioModVisual (ACC_Usuario) por:" + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public boolean ValidarTimputacion(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarTimputacion ACC_TipoImputacion por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public static void main(String[] args) {
        ACC_TipoImputacion u = new ACC_TipoImputacion();
        System.out.println(u.ValidarTI("8"));

    }
}
