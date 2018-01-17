/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.qmm_avisos_crea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Qmm_avisos_crea {
 
    private static ACC_Qmm_avisos_crea Instance = null;
    public static ACC_Qmm_avisos_crea ObtenerInstancia(){
       if(Instance == null ) {
           Instance = new ACC_Qmm_avisos_crea();
       }
        return Instance;
    }
   public int RetornCanti(String fol){
    Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int x = 0;
        String query = "SELECT COUNT(folio_sam) folio_sam from qmm_avisos_crea where folio_sam='" + fol + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                x = rs.getInt("folio_sam");
            }
        } catch (Exception e) {
            System.err.println("Error en VerificarPosSolped por " + e);
        }
        con.CerrarConexion(conn);
        return x;  
   }
   
   public LinkedList<qmm_avisos_crea> ObtenerDatPATab(String id, String campo){
       LinkedList<qmm_avisos_crea> tb = new LinkedList<>();
       Conexion con = new Conexion();
       Connection conn = con.ObtenerConexion();
       String query= "{call PM.qmm_avisos_crea_ObtenerDatPATab(?)}";
       ResultSet rs = null;
       PreparedStatement pst = null;
       try{
           pst = conn.prepareStatement(query);
           pst.setString(1, id);
           rs = pst.executeQuery();
           while(rs.next()){
              qmm_avisos_crea tq = new qmm_avisos_crea();
              tq.setFolio_sam(rs.getString("folio_sam"));
              tq.setHora_dia(rs.getString("hora_dia"));
              tq.setFecha(rs.getString("fecha"));
              tq.setGrupo_codigo_acciones(rs.getString("grupo_codigo_acciones"));
              tq.setCodigo_actividad(rs.getString("codigo_actividad"));
              tq.setTexto_accion(rs.getString("texto_accion"));
              tq.setNombre_responsable_anadio_objeto(rs.getString("nombre_responsable_anadio_objeto"));
              tq.setFecha_creacion_registro(rs.getString("fecha_creacion_registro"));
              tq.setFecha_ultima_modificacion(rs.getString("fecha_ultima_modificacion"));
              tq.setFecha_inicio(rs.getString("fecha_inicio"));
              tq.setFecha_fin(rs.getString("fecha_fin"));
              tq.setFactor_cantidad_acciones(rs.getString("factor_cantidad_acciones"));
              tq.setHora_inicio_accion(rs.getString("hora_inicio_accion"));
              tq.setHora_fin_accion(rs.getString("hora_fin_accion"));
              tq.setHora_agrego_registro(rs.getString("hora_agrego_registro"));
              tq.setHora_modificacion(rs.getString("hora_modificacion"));
              tq.setNum_claseificacion_actividad(rs.getString("num_claseificacion_actividad"));
              tq.setTexto_breve_codigo(rs.getString(campo));
              tb.add(tq);
           } 
          
       }
       catch(Exception e){
           System.err.println("Error: "+e);
       }
       finally{
                  try{
                    if(conn != null)con.CerrarConexion(conn);;
                    if(pst != null)pst.close();
                    if(rs != null)rs.close();
                  }catch(Exception a){
                      System.err.println("Error inesperado al cerrar conexiones");
                  }
        }
       return tb;
   }
   
   public int RetornCantidattfr(String fol){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst= null;
        ResultSet rs = null;
        int x = 0;
        String query = "{call PM.qmm_avisos_crea_RetornCantidad(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fol);
            rs = pst.executeQuery();
            while (rs.next()) {
                x = rs.getInt("folio_sam");
            }
        } catch (Exception e) {
            System.err.println("Error en VerificarPosSolped por " + e);
        }
        finally{
                  try{
                    if(conn != null)con.CerrarConexion(conn);;
                    if(pst != null)pst.close();
                    if(rs != null)rs.close();
                  }catch(Exception a){
                      System.err.println("Error inesperado al cerrar conexiones");
                  }
        }
        return x;  
   }
   
   
    public boolean ELIMQMMAVCR(String foldAV) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs  = null;
        String query = "{call PM.qmm_avisos_creaeli(?)}";
        try {            
            pst = conn.prepareStatement(query);
            pst.setString(1, foldAV);
            validar = pst.executeUpdate();
            if (validar > 0) {
                 return true;
            }
               
        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        }
        finally{
              try {            
                 if (conn != null) {con.CerrarConexion(conn);}
                 if(rs != null){rs.close();}
                 if(pst != null){pst.close();}
               
        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        }  
                }
        
        return false;
    }
    
    
    public boolean Guardarqmavca(String folTab,String hor,String fecha,String grupoCod,String Descod,String TexAci,String autor,String Feca1,String Feca2,String FuCant,String Hor1,String Hor2,int nuac,String ObjeLanE,String ObjeLanI){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs  = null;
        String query = "{call PM.qmm_avisos_creaInsertmod(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {            
            pst = conn.prepareStatement(query);
            pst.setString(1, folTab);
            pst.setString(2, hor);
            pst.setString(3, fecha);
            pst.setString(4, grupoCod);
            pst.setString(5, Descod);
            pst.setString(6, TexAci);
            pst.setString(7, autor);
            pst.setString(8, Feca1);
            pst.setString(9, Feca2);
            pst.setString(10, FuCant);
            pst.setString(11, Hor1);
            pst.setString(12, Hor2);
            pst.setInt(13, nuac);
            pst.setString(14, ObjeLanE);
            pst.setString(15, ObjeLanI);
            validar = pst.executeUpdate();
            if (validar > 0) {
                 return true;
            }
               
        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        }
        finally{
              try {            
                 if (conn != null) {con.CerrarConexion(conn);}
                 if(rs != null){rs.close();}
                 if(pst != null){pst.close();}
               
        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        }  
                }
        
        return false;
   
    }
   
    public static void main(String[] args) {
        System.out.println(ACC_Qmm_avisos_crea.ObtenerInstancia().RetornCantidattfr("AV21000003"));
    }
}
