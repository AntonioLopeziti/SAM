/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.tipo_movimiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_TipoMovimientos {

    Conexion cnx = new Conexion();
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_TipoMovimientos Instance = null;

    public static ACC_TipoMovimientos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_TipoMovimientos();
        }
        return Instance;
    }

    //Metodo para match tipo de movimientos
    public ArrayList<tipo_movimiento> MM_MatchTipoMovimiento() {
        ArrayList<tipo_movimiento> tmov = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.TipoMovimientos_MatchTMov}");
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo_movimiento t = new tipo_movimiento();
                t.setid_tipo_mov(rs.getString("id_tipo_mov"));
                t.setdescripcion_mov(rs.getString("descripcion_mov"));
                tmov.add(t);
            }
        } catch (Exception e) {
            System.err.println("Error al traer datos de almacen: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return tmov;
    }
    
    //Metodo para match tipo de movimientos
    public ArrayList<tipo_movimiento> MM_MatchTipoMovimientoReservas() {
        ArrayList<tipo_movimiento> tmov = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.TipoMovimientos_MatchTipMovReservas}");
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo_movimiento t = new tipo_movimiento();
                t.setid_tipo_mov(rs.getString("id_tipo_mov"));
                t.setdescripcion_mov(rs.getString("descripcion_mov"));
                tmov.add(t);
            }
        } catch (Exception e) {
            System.err.println("Error al traer datos de almacen: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return tmov;
    }
    
    public LinkedList<tipo_movimiento> ConsultaMovimientosMatch(String query) {
        LinkedList<tipo_movimiento> mov = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                tipo_movimiento m = new tipo_movimiento();
                m.setid_tipo_mov(rs.getString("id_tipo_mov"));
                m.setdescripcion_mov(rs.getString("descripcion_mov"));
                mov.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error en el metodo ConsultaMovimientosMatch (ACC_TipoMovimientos) por: " + e);
        }
        cnx.CerrarConexion(con);
        return mov;
    }

    public ArrayList<tipo_movimiento> ConsultaMovimiento() {
        ArrayList<tipo_movimiento> mov = new ArrayList<>();
        Conexion cx = new Conexion();
        Connection con = cx.ObtenerConexion();
        String procedure = "{call MM.tipo_movimientos_MOM}";

        try {
            PreparedStatement ps = con.prepareStatement(procedure);
            ResultSet rss = ps.executeQuery();
            while (rss.next()) {
                tipo_movimiento m = new tipo_movimiento();
                m.setid_tipo_mov(rss.getString("id_tipo_mov"));
                m.setdescripcion_mov(rss.getString("descripcion_mov"));
                mov.add(m);
            }
        } 
        catch(Exception e){ 
            System.err.println("Error inesperado por :" + e);
        }
        finally{
            cx.CerrarConexion(con);
        }
        return mov;
    }

    public int ValidarTipoMovi(String Tipomov) {
        Conexion cnxx = new Conexion();
        Connection con = cnxx.ObtenerConexion();
        String Query = "{call MM.tipo_movimientos_valida(?)}";
        try {
            PreparedStatement sp = con.prepareStatement(Query);
            sp.setString(1, Tipomov);
            ResultSet rss = sp.executeQuery();
            while (rss.next()) {
                return 1;
            }
        } catch (Exception e) {
            System.err.println("Error inesperado por " + e);
        }
        finally {
            cnxx.CerrarConexion(con);
        }
        return 0;
    }

    //muestra match de tipo de movimiento
    public LinkedList<tipo_movimiento> MuestraMatchTipoMovimientos() {
        LinkedList<tipo_movimiento> timo = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        try {
            pst = con.prepareCall("{CALL MM.TipoMovimientos_MuestraMatch}");
            rs = pst.executeQuery();
            while (rs.next()) {
                tipo_movimiento t = new tipo_movimiento();
                t.setid_tipo_mov(rs.getString("id_tipo_mov"));
                t.setdescripcion_mov(rs.getString("descripcion_mov"));
                timo.add(t);
            }
        } catch (Exception e) {
            System.err.println("Error de match tipo movimientos: " + e);
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
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return timo;
    }
    
    //valida tipo de movimiento
    public boolean ValidaCampoTipoMovimiento(String tmov) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        tipo_movimiento m = new tipo_movimiento();
        try {
            ps = con.prepareCall("{CALL MM.TipoMovimientos_ValidarMov(?)}");
            ps.setString(1, tmov);
            rs = ps.executeQuery();
            while(rs.next()){
                String tmovimiento = rs.getString("id_tipo_mov");
                if(tmov.equals(tmovimiento)){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error de validar tipo de movimiento: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return false;
    }

}
