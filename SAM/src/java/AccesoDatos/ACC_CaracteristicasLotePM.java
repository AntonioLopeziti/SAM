/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.caracteristicasLotePM;
import Entidades.decision_empleo_lote_crea;
import Entidades.inspeccion_codigos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Panda
 */
public class ACC_CaracteristicasLotePM {
    private static ACC_CaracteristicasLotePM Instance = null;
    
    public static ACC_CaracteristicasLotePM ObtenerInstacia(){
        if(Instance == null){
            Instance = new ACC_CaracteristicasLotePM();
        }
        return Instance;
    }
    public caracteristicasLotePM ConsultaMCAlmacenSolped(String mat, String lot) {
        caracteristicasLotePM cl = new caracteristicasLotePM();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PM.CaracteristicasLotePM(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ps.setString(2, lot);
            rs = ps.executeQuery();
            rs.next();
            cl.setEstatus_montaje(rs.getString("estatus_montaje"));
            cl.setNum_equipo(rs.getString("num_equipo"));
            cl.setFecha_montaje(rs.getString("fecha_montaje"));
            cl.setFecha_desmontaje(rs.getString("fecha_desmontaje"));
            cl.setUltima_medicion(rs.getString("ultima_medicion"));
            cl.setVal_over(rs.getString("val_over"));
            
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCAlmacenSolped, ACC_Almacenes por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cl;
    }
    public inspeccion_codigos consultaCodigo(String codigo, String cl){
        inspeccion_codigos cod = new inspeccion_codigos();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PM.inspeccion_codigosData(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            rs.next();
            cod.setGrupo_codigos(rs.getString("grupo_codigos"));
            if(cl.equals("EN")){
                cod.setDescripcion(rs.getString("descripcion_en"));
            }else{
                cod.setDescripcion(rs.getString("descripcion_es"));
            }
            
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCAlmacenSolped, ACC_Almacenes por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cod;
    }
    public decision_empleo_lote_crea consultaDE(String loteI){
        decision_empleo_lote_crea cod = new decision_empleo_lote_crea();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PM.getDataDE(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, loteI);
            rs = ps.executeQuery();
            rs.next();
            cod.setCodigo_decision_empleo(rs.getString("codigo_decision_empleo"));
            cod.setGrupo_codigo_decision_empleo(rs.getString("grupo_codigo_decision_empleo"));
            try{
                cod.setTexto_mensaje(rs.getString("texto_mensaje"));
            }catch(Exception e){
                cod.setTexto_mensaje(rs.getString("texto_breve"));
            }
            
        } catch (Exception e) {
            System.err.println("Error en DE por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cod;
    }
    public decision_empleo_lote_crea consultaDECap(String loteI){
        decision_empleo_lote_crea cod = new decision_empleo_lote_crea();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PM.getDataDECap(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, loteI);
            rs = ps.executeQuery();
            rs.next();
            cod.setCodigo_decision_empleo(rs.getString("codigo_decision_empleo"));
            cod.setGrupo_codigo_decision_empleo(rs.getString("grupo_codigo_decision_empleo"));
            try{
                cod.setTexto_mensaje(rs.getString("texto_mensaje"));
            }catch(Exception e){
                cod.setTexto_mensaje(rs.getString("texto_breve"));
            }
            
        } catch (Exception e) {
            System.err.println("Error en DE por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cod;
    }
    public int validaNotificacion(String orden){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PM.ConjuntoOperaciones(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("conjunto").equals("X")){
                    return 1;
                }
            }
        } catch (Exception e) {
            System.err.println("valida Notificacion:" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }
    public int validaNotificacion2(String orden){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PM.ConjuntoOperaciones(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("conjunto2").equals("X")){
                    return 1;
                }
            }
        } catch (Exception e) {
            System.err.println("valida Notificacion:" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }
    public int validaUserDE(String user){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PM.UsuarioDE(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("aceptar_decision_empleo").equals("X")){
                    return 1;
                }
            }
        } catch (Exception e) {
            System.err.println("valida Notificacion:" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }
}
