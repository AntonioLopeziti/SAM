/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.textos_cabecera_solped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ACC_Textos_cabecera_solped {

    private static ACC_Textos_cabecera_solped Instance = null;

    public static ACC_Textos_cabecera_solped ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Textos_cabecera_solped();
        }
        return Instance;
    }

    public ArrayList<textos_cabecera_solped> ObtenerTextoSolCabSolpeSAP(String Solped) {
        ArrayList<textos_cabecera_solped> tcs = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolpedCargarTextoCabeceraSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Solped);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_cabecera_solped s = new textos_cabecera_solped();
                s.setLinea_texto(rs.getString("linea_texto"));
                tcs.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerTextoSolCabSolpeSAP, ACC_Textos_cabecera_solped por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return tcs;
    }

    public ArrayList<textos_cabecera_solped> ObtenerTextoSolCabSolped(String Solped) {
        ArrayList<textos_cabecera_solped> tcs = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolpedCargarTextoCabecera(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Solped);
            rs = ps.executeQuery();
            while (rs.next()) {
                textos_cabecera_solped s = new textos_cabecera_solped();
                s.setLinea_texto(rs.getString("linea_texto"));
                tcs.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerTextoSolCabSolped, ACC_Textos_cabecera_solped por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return tcs;
    }

    public void InsertTxtCabecera(String folio, String fila, String user, String txt) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_InsertarTxtCab(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, fila);
            ps.setString(3, user);
            ps.setString(4, txt);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en InsertTxtCabecera, ACC_Textos_cabecera_solped por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
}
