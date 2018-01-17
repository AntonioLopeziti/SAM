/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Posiciones_consumos_crea {
    private static ACC_Posiciones_consumos_crea Instance = null;
    public static ACC_Posiciones_consumos_crea ObtenerInstancia(){
       if(Instance == null ) {
           Instance = new ACC_Posiciones_consumos_crea();
       }
        return Instance;
    }
   public int RetornPosis(String fol){
    Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int x = 0;
        String query = "SELECT COUNT(folio_sam) folio_sam from posiciones_consumos_crea where folio_sam='" + fol + "'";
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
   
   
   public boolean INSERTposiciones_consumos_crea(String foli,String hora,String fecha,String orden,String lote,String Unidad_medida,Double cantidad,String te,String material,String Centro,int posi)  {
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      int cont;
      String query = "{call PM.posiciones_consumos_crea_INSERTAR(?,?,?,?,?,?,?,?,?,?,?)}";
      try{
        pst = conn.prepareStatement(query);
        pst.setString(1, foli);
        pst.setString(2, hora);
        pst.setString(3, fecha);
        pst.setString(4, orden);
        pst.setString(5, lote);
        pst.setString(6, Unidad_medida);
        pst.setDouble(7, cantidad);
        pst.setString(8, te);
        pst.setString(9, material);
        pst.setString(10, Centro);
        pst.setInt(11, posi);
        cont = pst.executeUpdate();
        if(cont > 0){
            return true;
        }
      }
      catch(Exception e){
          System.err.println("Error : "+e);
      }
      finally{
          try{
            if(conn != null){con.CerrarConexion(conn);}
            if(pst != null){pst.close();}
          }
          catch(Exception e){
              System.err.println("Error: "+e);
          }
      }
       return false;
      }
    
   
    public boolean INSERTposiciones_consumos_creaORD(String foli,String hora,String fecha,String orden,String lote,String Unidad_medida,Double cantidad,String te,String material,String Centro,int posi)  {
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      int cont;
      String query = "{call PM.posiciones_consumos_creaORD_INSERTAR(?,?,?,?,?,?,?,?,?,?,?)}";
      try{
        pst = conn.prepareStatement(query);
        pst.setString(1, foli);
        pst.setString(2, hora);
        pst.setString(3, fecha);
        pst.setString(4, orden);
        pst.setString(5, lote);
        pst.setString(6, Unidad_medida);
        pst.setDouble(7, cantidad);
        pst.setString(8, te);
        pst.setString(9, material);
        pst.setString(10, Centro);
        pst.setInt(11, posi);
        cont = pst.executeUpdate();
        if(cont > 0){
            return true;
        }
      }
      catch(Exception e){
          System.err.println("Error : "+e);
      }
      finally{
          try{
            if(conn != null){con.CerrarConexion(conn);}
            if(pst != null){pst.close();}
          }
          catch(Exception e){
              System.err.println("Error: "+e);
          }
      }
       return false;
      }
    
     public boolean UPDATEINVETA(String resu,Double cantidad,String material,String lote){
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      int cont;
      String query = "{call MM.inventariosUPDATE(?,?,?,?)}";
      try{
        pst = conn.prepareStatement(query);
        pst.setString(1, resu);
        pst.setDouble(2, cantidad);
        pst.setString(3, material);
        pst.setString(4, lote);
        cont = pst.executeUpdate();
        if(cont > 0){
            return true;
        }
      }
      catch(Exception e){
          System.err.println("Error : "+e);
      }
      finally{
          try{
            if(conn != null){con.CerrarConexion(conn);}
            if(pst != null){pst.close();}
          }
          catch(Exception e){
              System.err.println("Error: "+e);
          }
      }
       return false;
      }  
}
