/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidades.FlujoDeudoresSD;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Jhonatan
 */
public class ACC_FlujoDeudoresSD extends Conexion {
    Conexion cnx = new Conexion();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_FlujoDeudoresSD Instance = null;

    public static ACC_FlujoDeudoresSD ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_FlujoDeudoresSD();
        }
        return Instance;
    }

    //Consulta Reporte Todos
    public ArrayList<FlujoDeudoresSD> SD_Reporte_FLujoDocsConsulta(String vendedor, String factura, String clienteUno, String clienteDos, String fe1, String fe2) {
        ArrayList<FlujoDeudoresSD> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call SD.Reporte_FlujoDeudoresTodos(?,?,?,?,?,?)}");
            pst.setString(1, vendedor);
            pst.setString(2, factura);
            pst.setString(3, clienteUno);
            pst.setString(4, clienteDos);
            pst.setString(5, fe1);
            pst.setString(6, fe2);            
            rs = pst.executeQuery();
            while (rs.next()) {
                FlujoDeudoresSD or = new FlujoDeudoresSD();
                or.setEjercicio(rs.getString("ejercicio"));
                or.setMes_contable(rs.getString("mes_contable"));
                or.setFecha_contable(rs.getString("fecha_contable"));
                or.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
                or.setDias_vencimiento(rs.getString("dias_vencimiento"));
                or.setFactura(rs.getString("factura"));
                or.setImporte(rs.getString("importe"));
                or.setMoneda(rs.getString("moneda"));
                or.setCliente(rs.getString("cliente"));
                or.setNombre_cliente(rs.getString("nombre_cliente"));
                or.setVendedor(rs.getString("vendedor"));
                or.setNombre_vendedor(rs.getString("nombre_vendedor"));                
                sp_todos.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_todos;
    }
}