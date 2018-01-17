/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.solped_cabecera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
/**
 *
 * @author JaroMX
 */
public class ACC_Solped_cabecera {
    Conexion cnx = new Conexion();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_Solped_cabecera Instance = null;

    public static ACC_Solped_cabecera ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Solped_cabecera();
        }
        return Instance;
    } 
    
    public boolean ValidarFolio (String query,String folio,String tipo){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String tipofolio = "folio_"+tipo;
            try{
                Statement st;
                ResultSet rs;
                st = con.createStatement();
                rs = st.executeQuery(query);
                    while(rs.next()){
                        String s = rs.getString(tipofolio);
                            if(folio.equals(s)){
                                return true;
                            } else {
                                return false;
                            }
                    }
            }catch(Exception ex){
                System.err.println("Error en el metodo ValidarSAP (ACC_Solped_cabecera) por:" + ex);
            }
            cnx.CerrarConexion(con);
        return false;
    }
    /*Visualizar folio SAP/SAM*/
    public LinkedList<solped_cabecera> CargarFolios(String query, String tipo){
        String folio = "folio_"+tipo;
        LinkedList<solped_cabecera> s = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
            try {
                Statement st;
                ResultSet rs;
                st = con.createStatement();
                rs = st.executeQuery(query);
                    while(rs.next()){
                        solped_cabecera sp = new solped_cabecera();
                        sp.setFolio(rs.getString(folio));
                        s.add(sp);
                    }
                cnx.CerrarConexion(con);
            }catch(Exception ex){
                System.err.println("Error en el metodo CargarFolios por:" + ex);
            }
    return s;
    }
    /*-----------------------*/

}
