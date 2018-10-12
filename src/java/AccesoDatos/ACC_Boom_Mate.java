/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.boom_material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Jhonatan
 */
public class ACC_Boom_Mate {
    private static ACC_Boom_Mate Instance = null;

    public static ACC_Boom_Mate ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Boom_Mate();
        }
        return Instance;
    }
    public ArrayList<boom_material> ObtenerDatosBOMATEPP (String mate, String centro, String alt, String utl){
        ArrayList<boom_material> mat = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String query = "{CALL PP.BoomMate_ObtenerBOOMAtePP(?,?,?,?)}";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1, mate);
            ps.setString(2, centro);
            ps.setString(3, alt);
            ps.setString(4, utl);
            rs = ps.executeQuery();
            while(rs.next()){
                boom_material bm = new boom_material();
                bm.setLista_mate(rs.getString("lista_mate"));
                bm.setCentro_suminist(rs.getString("centro_suminist"));
                bm.setComp_list_mate(rs.getString("comp_list_mate"));
                bm.setCnt_componente(rs.getString("cnt_componente"));
                bm.setUm_componente(rs.getString("um_componente"));
                bm.setInd_borrado(rs.getString("ind_borrado"));
                bm.setPet_borrado_list(rs.getString("pet_borrado_list"));
                mat.add(bm);
                
            }
        }catch (Exception e) {
            System.err.println("Error en ObtenerDatosBOOM por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mat;
    }
    
    public String ObtenerDesByMPP(String comp, String idi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String des = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PP.VisualizarBomEdescByMPP(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, comp);
            ps.setString(2, idi);
            rs = ps.executeQuery();
            while (rs.next()) {
                des = rs.getString("descripcion_"+idi);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return des;
    }
}
