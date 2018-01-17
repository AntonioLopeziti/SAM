/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.conversion_materiales;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Developer-Antonio
 */
public class ACC_ConversionMateriales {
    private static ACC_ConversionMateriales Instance = null;
    
    public static ACC_ConversionMateriales ObtenerInstancia(){
        if(Instance == null){
            Instance= new ACC_ConversionMateriales();
        }
        return Instance;
    }
    
    public LinkedList<conversion_materiales> ConsultaMatchUM_SP(String vari){
        LinkedList<conversion_materiales> cm = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        try{
            Statement st;
            ResultSet rs;
            
            st = conn.createStatement();
            rs = st.executeQuery(vari);
            while(rs.next()){
                conversion_materiales conm = new conversion_materiales();
                conm.setUnidad_medida(rs.getString("unidad_medida"));
                cm.add(conm);
            }
        }
        catch(Exception e){
            System.err.println("Error "+e);
        }
        con.CerrarConexion(conn);
        return cm;
    }
}
