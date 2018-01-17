/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.avisossap_modificados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Avisossap_modificados {

    private static ACC_Avisossap_modificados Instance = null;

    public static ACC_Avisossap_modificados ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Avisossap_modificados();
        }
        return Instance;
    }
    
    
    public avisossap_modificados Cargaravisossap(String fol) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        avisossap_modificados c = new avisossap_modificados();
        String Query = "{call pm.cierre_ligue_avisosCONS(?)}";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

            pst = con.prepareStatement(Query);
            pst.setString(1, fol);
            rs = pst.executeQuery();
            while (rs.next()) {
                c.setStatus_cierre(rs.getString("estatus"));
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo por: " + ex);
        }
                finally{
              try {            
                 if (con != null) {cnx.CerrarConexion(con);}
                 if(rs != null){rs.close();}
                 if(pst != null){pst.close();}
               
        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        }  
                }
        return c;
    }
    
    public LinkedList<avisossap_modificados> CargaravisossapSTa(String Query) {
        LinkedList<avisossap_modificados> ca = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
       
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(Query);
            while (rs.next()) {
                avisossap_modificados c = new avisossap_modificados();
                c.setFolio_aviso_sap(rs.getString("folio_aviso_sap"));
                c.setFolio_orden_sam(rs.getString("folio_orden_sam"));
                c.setStatus_cierre(rs.getString("status_cierre"));
                ca.add(c);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo por: " + ex);
        }
        cnx.CerrarConexion(con);
        return ca;
    }
    
}
