/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.tipo_info;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Antonio
 */
public class ACC_TipoInfoRecords {
    
    private static ACC_TipoInfoRecords Instance = null;
    
    public static ACC_TipoInfoRecords ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_TipoInfoRecords();
        }
        return Instance;
    }
    
    public LinkedList<tipo_info> ConsultaTipoInfoMacth(String query, String Desc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<tipo_info> inf = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tipo_info ti = new tipo_info();
                ti.setValor(rs.getString("valor"));
                ti.setDescripcion(rs.getString(Desc));
                inf.add(ti);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en ConsulraTipoInfoMatch (ACC_TipoInfoRecords) por: " + e);
        }
        return inf;
    }
    
}
