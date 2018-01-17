/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
 
import Entidades.materiales;
import Entidades.usuario_grupo_materiales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Usuario_grupo_materiales {
    private static ACC_Usuario_grupo_materiales Instance =null;
    
    public static ACC_Usuario_grupo_materiales ObtenerInstancia(){
        if(Instance == null){
            Instance = new ACC_Usuario_grupo_materiales();
        }
        return Instance;
    }
    
    public LinkedList <usuario_grupo_materiales> CargaLIsta(String usuario){
        LinkedList<usuario_grupo_materiales> usg = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{call MM.usuario_grupo_materialesMOSTlist(?)}";
          
        try{
             ps = conn.prepareStatement(query);
             ps.setString(1, usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                usuario_grupo_materiales usgm = new usuario_grupo_materiales();
                usgm.setGrupo_usuario_lista_material(rs.getString("grupo_usuario_lista_material"));
                usgm.setNum_personal(rs.getString("num_personal"));
                usg.add(usgm);
            }
        }
        catch(Exception e){
            System.err.println("Error: "+e);
        }
        finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return usg;
    }
    
    
    public LinkedList <materiales> CargaDatosLisMatReserva(String idioma,String valis,String alm1,String alm2, String centro){
        LinkedList<materiales> ma = new LinkedList<>();
         Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = con.prepareCall("{CALL MM.usuario_grupo_materialesMOSTMAte(?,?,?,?)}");
            ps.setString(1, valis);
            ps.setString(2, alm1);
            ps.setString(3, alm2);
            ps.setString(4, centro);            
            rs = ps.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("num_material"));
                ma.add(m);
            }
        } catch (Exception e) {
            System.err.println("Erro al traer datos de materiales: " + e);
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return ma;    
    }
    
    
    public usuario_grupo_materiales CargaLIsta2(String usuario){
        usuario_grupo_materiales usgm = new usuario_grupo_materiales();    
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{call MM.usuario_grupo_materialesMOSTlist(?)}";
          
        try{
             ps = conn.prepareStatement(query);
             ps.setString(1, usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                usgm.setGrupo_usuario_lista_material(rs.getString("grupo_usuario_lista_material"));
                usgm.setNum_personal(rs.getString("num_personal"));
            }
        }
        catch(Exception e){
            System.err.println("Error: "+e);
        }
        finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return usgm;
    }
    
}
