/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.texto_avisos_crea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Texto_avisos_crea {
    
    private static ACC_Texto_avisos_crea Instance = null;

    public static ACC_Texto_avisos_crea ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Texto_avisos_crea();
        }
        return Instance;
    }
    

public LinkedList<texto_avisos_crea> ConsulText(String id){
    LinkedList<texto_avisos_crea> tea = new LinkedList<>();
    String query = "{call PM.texto_avisos_crea_ConsulText(?)}";
    Conexion con = new Conexion();
    Connection conn = con.ObtenerConexion();
    ResultSet rs = null;
    PreparedStatement pst = null;
         
     try{
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            
             while(rs.next()){
                texto_avisos_crea ta = new texto_avisos_crea();
                ta.setFolio_sam(rs.getString("folio_sam"));
                ta.setFormato(rs.getString("formato"));
                ta.setLinea_texto(rs.getString("linea_texto"));
                tea.add(ta);
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
    return tea;    
}


 public boolean DELETETEXAVCREMO(String foldAV) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs  = null;
        String query = "{call PM.texto_avisos_creaaeli(?)}";
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

public static void main(String[] args) {
        System.out.println(ACC_Texto_avisos_crea.ObtenerInstancia().ConsulText("AV21000003"));
    }
}

