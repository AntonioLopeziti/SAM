/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.equipos_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Equipos_notificaciones {
    private static ACC_Equipos_notificaciones Instance = null;

    public static ACC_Equipos_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Equipos_notificaciones();
        }
        return Instance;
    }
    
    public equipos_notificaciones  equipoNOPM(String ord){
        equipos_notificaciones en = new equipos_notificaciones();
        Conexion con = new Conexion();
       Connection conn = con.ObtenerConexion();
        String query = "SELECT * FROM PM.equipos_notificaciones where num_orden = '"+ord+"'";
        try{
           ResultSet rs;
           Statement st;
           st = conn.createStatement();
           rs = st.executeQuery(query);
           while(rs.next()){
               en.setId_en(rs.getInt("id_en"));
               en.setAlmacen(rs.getString("almacen"));
               en.setCentro(rs.getString("centro"));
               en.setEquipo_superior(rs.getString("equipo_superior"));
               en.setLote(rs.getString("lote"));
               en.setMaterial(rs.getString("material"));
               en.setNum_equipo(rs.getString("num_equipo"));
               en.setNum_orden(rs.getString("num_orden"));
               en.setSerie(rs.getString("serie"));
               en.setMontado(rs.getString("montado"));
           }
        }
         catch(Exception e){
             System.err.println("Errr; "+e);
         }
       con.CerrarConexion(conn);
        return en;
    }
    public boolean ACTUALequipos_notificaciones(String operacion,String orden)  {
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      int cont;
      String query = "{call PM.equipos_notificaciones_ACTUAL(?,?)}";
      try{
        pst = conn.prepareStatement(query);
        pst.setString(1, operacion);
        pst.setString(2, orden);
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
    
    
    
    public boolean INSERTcabecera_consumos_crea(String folen,String hora,String fecha,String Centro,String orden,String usu,String fecont)  {
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      int cont;
      String query = "{call PM.cabecera_consumos_crea_GuardCabec(?,?,?,?,?,?,?)}";
      try{
        pst = conn.prepareStatement(query);
        pst.setString(1, folen);
        pst.setString(2, hora);
        pst.setString(3, fecha);
        pst.setString(4, Centro);
        pst.setString(5, orden);
        pst.setString(6, usu);
        pst.setString(7,fecont);
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
    
    
    public boolean INSERTcabecera_consumos_creaORD(String folen,String hora,String fecha,String Centro,String orden,String usu,String fecont)  {
      Conexion con = new Conexion();
      Connection conn = con.ObtenerConexion();
      PreparedStatement pst = null;
      int cont;
      String query = "{call PM.cabecera_consumos_crea_INSERTERORD(?,?,?,?,?,?,?)}";
      try{
        pst = conn.prepareStatement(query);
        pst.setString(1, folen);
        pst.setString(2, hora);
        pst.setString(3, fecha);
        pst.setString(4, Centro);
        pst.setString(5, orden);
        pst.setString(6, usu);
        pst.setString(7,fecont);
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
