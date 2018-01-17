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
 * @author Jhonatan
 */
public class ACC_PP03_Notificaciones {
    private static ACC_PP03_Notificaciones Instance = null;

    public static ACC_PP03_Notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_PP03_Notificaciones();
        }
        return Instance;
    }
    
    public boolean PONActualPP(String ind ,String orden, String ope){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PP.pp_operaciones_notificaciones_ACTUAL_PP(?,?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst.setString(1, ind);
           pst .setString(2, orden);
           pst.setString(3, ope);
           can = pst.executeUpdate();
           if(can > 0){
               return true;
           }
        }
        catch(Exception e){
            System.err.println("Error: "+e);
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
