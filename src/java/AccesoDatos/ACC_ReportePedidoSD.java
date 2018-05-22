/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Cabecera_PedidosSD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jhonatan
 */
    public class ACC_ReportePedidoSD extends Conexion{
        Conexion cnx = new Conexion();
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        String query;
        private static ACC_ReportePedidoSD Instance = null;

        public static ACC_ReportePedidoSD ObtenerInstancia() {
            if (Instance == null) {
                Instance = new ACC_ReportePedidoSD();
            }
            return Instance;
        }

    public ArrayList<Cabecera_PedidosSD> FolioSAMMatch(String folSAM, String CentroFol, String CtdFol) {
        ArrayList<Cabecera_PedidosSD> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call SD.ReportePedidosMatchFolio(?,?,?)}");
            pst.setString(1, folSAM);
            pst.setString(2, CentroFol);
            pst.setString(3, CtdFol);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cabecera_PedidosSD so = new Cabecera_PedidosSD();
                so.setFolio_sam(rs.getString("folio_sam"));
                so.setClase_documento(rs.getString("clase_documento"));
                sam.add(so);
            }
        } catch (Exception e) {
            System.err.println("Error en CentroReservass, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }
    public ArrayList<Cabecera_PedidosSD> NumDocMatch(String folSAM, String CentroFol, String CtdFol) {
        ArrayList<Cabecera_PedidosSD> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call SD.ReportePedidosMatchDocVentas(?,?,?)}");
            pst.setString(1, folSAM);
            pst.setString(2, CentroFol);
            pst.setString(3, CtdFol);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cabecera_PedidosSD so = new Cabecera_PedidosSD();
                so.setDocumento_ventas(rs.getString("documento_ventas"));
                so.setClase_documento(rs.getString("clase_documento"));
                sam.add(so);
            }
        } catch (Exception e) {
            System.err.println("Error en CentroReservass, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }
    
    //Consulta Reporte Todos
    public ArrayList<Cabecera_PedidosSD> SD_Reporte_PedidosConsulta(String centros, String centros2, String foliosam, String foliosam2, String fe1, String fe2, String radio) {
        ArrayList<Cabecera_PedidosSD> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call SD.Reporte_PedidosTodos(?,?,?,?,?,?,?)}");
            pst.setString(1, centros);
            pst.setString(2, centros2);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);            
            pst.setString(5, fe1);
            pst.setString(6, fe2);
            pst.setString(7, radio);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cabecera_PedidosSD or = new Cabecera_PedidosSD();
                //Clase de movimiento
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setClase_documento(rs.getString("Clase_documento"));
                //Cliente
                or.setGrupo_vendedores(rs.getString("grupo_vendedores"));
                or.setFecha_creacion(rs.getString("fecha_creacion"));
                or.setHora_creacion(rs.getString("hora_creacion"));     
                or.setRecibido(rs.getString("recibido"));
                or.setProcesado(rs.getString("procesado"));
                or.setError(rs.getString("error"));
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
