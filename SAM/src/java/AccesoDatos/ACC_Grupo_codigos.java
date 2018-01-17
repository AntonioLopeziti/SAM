/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.grupo_codigos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Grupo_codigos {

    private static ACC_Grupo_codigos Instance = null;

    public static ACC_Grupo_codigos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Grupo_codigos();
        }
        return Instance;
    }

    public ArrayList<grupo_codigos> ObetenrCod(String Idioma) {
        ArrayList<grupo_codigos> gc = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.grupo_codigos_ObetenrCodAviso(?)}";
        ResultSet rs = null;
        CallableStatement pst = null;
        
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, Idioma);
            rs = pst.executeQuery();
            while (rs.next()) {
                grupo_codigos grc = new grupo_codigos();
                grc.setCatalogo(rs.getString("catalogo"));
                grc.setGrupo_codigos(rs.getString("grupo_codigos"));
                grc.setCodigo(rs.getString("codigo"));
                grc.setTexto(rs.getString(Idioma));

                gc.add(grc);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
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
        return gc;
    }

}
