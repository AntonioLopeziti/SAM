/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.cabecera_ordenes_crea;
import Entidades.ordenes_pm_notificaciones;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Ordenes_pm_notificaciones {

    private static ACC_Ordenes_pm_notificaciones Instance = null;

    public static ACC_Ordenes_pm_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Ordenes_pm_notificaciones();
        }
        return Instance;
    }

    public LinkedList<ordenes_pm_notificaciones> ObtenOrdenCNPM(String plao, String orde, String deso, String canm) {
        LinkedList<ordenes_pm_notificaciones> orn = new LinkedList<>();
        String query = "";
        if (canm.length() > 0) {
             query = "SELECT top " + canm + " * FROM PM.ordenes_pm_notificaciones where "
                    + "num_orden like '" + orde + "%' and texto_breve like '" + deso + "%' "
                    + "and sociedad_co like '" + plao + "%'";
        } else {
             query = "SELECT  * FROM PM.ordenes_pm_notificaciones where "
                    + "num_orden like '" + orde + "%' and texto_breve like '" + deso + "%' "
                    + "and sociedad_co like '" + plao + "%'";
        }
        Conexion con = new Conexion();
        try {
            ResultSet rs;
            Statement st;
            Connection conn = con.ObtenerConexion();
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ordenes_pm_notificaciones or = new ordenes_pm_notificaciones();
                or.setId_opmn(rs.getInt("id_opmn"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setStatus(rs.getString("status"));
                or.setTexto_breve(rs.getString("texto_breve"));
                or.setClase_orden(rs.getString("clase_orden"));
                or.setTipo_orden(rs.getString("tipo_orden"));
                orn.add(or);
            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return orn;
    }

    public ordenes_pm_notificaciones ObtenStatusCNPM(String orde) {
        ordenes_pm_notificaciones or = new ordenes_pm_notificaciones();
        String query = "SELECT * FROM PM.ordenes_pm_notificaciones where "
                + "num_orden = '" + orde + "'";

        Conexion con = new Conexion();
        try {
            ResultSet rs;
            Statement st;
            Connection conn = con.ObtenerConexion();
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                or.setId_opmn(rs.getInt("id_opmn"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setStatus(rs.getString("status"));
                or.setTexto_breve(rs.getString("texto_breve"));
                or.setClase_orden(rs.getString("clase_orden"));
                or.setTipo_orden(rs.getString("tipo_orden"));
                or.setCentro(rs.getString("centro"));

            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return or;
    }

    public boolean COMPORden(String query, String ord) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String orden = rs.getString("num_orden");
                if (ord.equals(orden)) {
                    con.CerrarConexion(conn);
                    return true;
                } else {
                    con.CerrarConexion(conn);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return false;
    }
    
    
        public LinkedList<ordenes_pm_notificaciones> ObtenOrdenNOTI(String cann, String orde, String deso, String plao) {
        LinkedList<ordenes_pm_notificaciones> orn = new LinkedList<>();
        String query = "{call PM.cab_ord_cr_ALLparaMatchNotifi(?,?,?,?)}";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
            
            pst = conn.prepareStatement(query);
            pst.setString(1, cann);
            pst.setString(2, orde);
            pst.setString(3, deso);
            pst.setString(4, plao);
            rs = pst.executeQuery();
            while (rs.next()) {
                ordenes_pm_notificaciones or = new ordenes_pm_notificaciones();
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setTexto_breve(rs.getString("texto_breve"));
                orn.add(or);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try{
            if(conn != null){con.CerrarConexion(conn);}
            if(rs != null){rs.close();}
            if(pst != null){pst.close();}
            }
           catch(Exception e){
               System.err.println("Error: "+e);
           } 
        }
        return orn;
    }
        
 public boolean COMPORdenNOT(String ord) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;   
        String query = "{call PM.ord_pm_noti_COMPORdenNOT(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                String orden = rs.getString("num_orden");
                if (ord.equals(orden)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try{
            if(conn != null){con.CerrarConexion(conn);}
            if(rs != null){rs.close();}
            if(pst != null){pst.close();}
            }
           catch(Exception e){
               System.err.println("Error: "+e);
           } 
        }
        return false;
    }       
    
 
    public ordenes_pm_notificaciones ObtenStatusCNPMNOT(String orde) {
        ordenes_pm_notificaciones or = new ordenes_pm_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PM.ord_pm_noti_COMPORdenNOT(?)}";

       
        try {  
            pst = conn.prepareStatement(query);
            pst.setString(1, orde);
            rs = pst.executeQuery();
            while (rs.next()) {

                or.setId_opmn(rs.getInt("id_opmn"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setStatus(rs.getString("status"));
                or.setTexto_breve(rs.getString("texto_breve"));
                or.setClase_orden(rs.getString("clase_orden"));
                or.setTipo_orden(rs.getString("tipo_orden"));
                or.setCentro(rs.getString("centro"));

            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return or;
    }
    
    
    public ordenes_pm_notificaciones ObtStatusCNPM(String orde) {
        ordenes_pm_notificaciones or = new ordenes_pm_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.ord_pm_not_ObtStatusCNPM(?)}";
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, orde);
            rs = pst.executeQuery();
            while (rs.next()) {

                or.setId_opmn(rs.getInt("id_opmn"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setStatus(rs.getString("status"));
                or.setTexto_breve(rs.getString("texto_breve"));
                or.setClase_orden(rs.getString("clase_orden"));
                or.setTipo_orden(rs.getString("tipo_orden"));
                or.setCentro(rs.getString("centro"));

            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try{
               if(conn != null){con.CerrarConexion(conn);}
               if(pst != null){pst.close();}
               if(rs != null){rs.close();}
            }
            catch(Exception e){
                System.err.println("Error: "+e);
            }
        }
        return or;
    }
    
    public boolean ordpmnotiActual(String operacion, String orden){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PM.ordenes_pm_notificaciones_Actualizar(?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst .setString(1, operacion);
           pst.setString(2, orden);
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
     
    
    public boolean POSNOCRE_INSERTA(String folpnc,String ord,String ope,String honot,String fenot,String durp1,String trrep1,String nf,String nofip1, String durp2){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PM.posiciones_notificaciones_crea_INSERTAR(?,?,?,?,?,?,?,?,?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst.setString(1, folpnc);
           pst.setString(2, ord);
           pst.setString(3, ope);
           pst.setString(4, honot);
           pst.setString(5, fenot);
           pst.setString(6, durp1);
           pst.setString(7, trrep1);
           pst.setString(8, nf);
           pst.setString(9, nofip1);
           pst.setString(10, durp2);
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
      public boolean CANOCRE_INSERTA(String folicn,String ord,String ope,String honot,String fenot,String fecco,String usu){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PM.cabecera_notificaciones_crea_insertar(?,?,?,?,?,?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst.setString(1, folicn);
           pst.setString(2, ord);
           pst.setString(3, ope);
           pst.setString(4, honot);
           pst.setString(5, fenot);
           pst.setString(6, fecco);
           pst.setString(7, usu);
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
