/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Panda
 */
public class ACC_DocumentoInventario {
    private static ACC_DocumentoInventario Instance = null;

    public static ACC_DocumentoInventario ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_DocumentoInventario();
        }
        return Instance;
    }
    
    public void guarda_DocInventarioCreaCabecera(String folSAM, String hora, String fecha, String centro, String almacen, String usuario){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.ingresa_cabecera_doc_inventario_crea(?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, folSAM);
            ps.setString(2, hora);
            ps.setString(3, fecha);
            ps.setString(4, centro);
            ps.setString(5, almacen);
            ps.setString(6, usuario);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error ACC_DocumentoInventario ->  guarda_DocInventarioCreaCabecera" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    public void guarda_DocInventarioCreaPocisiones(String folSAM, String posicion, String hora, String fecha, String centro, String almacen, String material, String usuario){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.ingresa_posiciones_doc_inventario_crea(?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, folSAM);
            ps.setString(2, posicion);
            ps.setString(3, hora);
            ps.setString(4, fecha);
            ps.setString(5, centro);
            ps.setString(6, almacen);
            ps.setString(7, material);
            ps.setString(8, usuario);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error ACC_DocumentoInventario ->  guarda_DocInventarioCreaPocisiones" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    public void actualizaStatusMaterial(String material, String centro, String almacen){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.deshabilita_material(?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, material);
            ps.setString(2, centro);
            ps.setString(3, almacen);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error ACC_DocumentoInventario ->  actualizaStatusMaterial" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
}
