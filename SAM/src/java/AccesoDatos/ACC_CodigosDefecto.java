/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.CodigosDefecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Panda
 */
public class ACC_CodigosDefecto {
    private static ACC_CodigosDefecto Instance = null;

    public static ACC_CodigosDefecto ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_CodigosDefecto();
        }
        return Instance;
    }
    
    public int validaGrupoCod(String gc)
    {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL QM.validaGrupoC(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, gc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }
    
    public ArrayList<CodigosDefecto> ConsultaCodDefecto(String catalogo, String grupoC)
    {
        ArrayList<CodigosDefecto> cd = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL QM.CodigosDefectoMatch(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, catalogo);
            ps.setString(2, grupoC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CodigosDefecto p = new CodigosDefecto();
                p.setGrupo_codigos(rs.getString("grupo_codigos"));
                p.setCodigo(rs.getString("codigo"));
                p.setTexto_breve_codigo(rs.getString("texto_breve_codigo"));
                cd.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cd;
    }
}
