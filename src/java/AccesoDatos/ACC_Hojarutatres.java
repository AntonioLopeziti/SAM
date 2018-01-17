/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.hojarutatres;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Hojarutatres {

    private static ACC_Hojarutatres Instance = null;

    public static ACC_Hojarutatres ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Hojarutatres();
        }
        return Instance;
    }

    public static void main(String[] args) {
        ACC_Hojarutatres sd = new ACC_Hojarutatres();
        System.out.println(sd.ConsultarHRutas());
    }

    public LinkedList<hojarutatres> ConsultarHRutas() {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "SELECT * FROM hojaruta3";
        LinkedList<hojarutatres> hrall = new LinkedList<>();

        try {
            Statement st;
            ResultSet rs;

            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                hojarutatres hr = new hojarutatres();
                hr.setContador_grupohojaruta(rs.getString("contador_grupohojaruta"));
                hr.setClave_gruphojaruta(rs.getString("clave_gruphojaruta"));
                hr.setDescripcion_contador(rs.getString("descripcion_contador"));
                hrall.add(hr);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return hrall;
    }

    public LinkedList<hojarutatres> ConsultaXPCL(String en1, String en2, String en3, String en4, String en5) {

        Conexion con = new Conexion();
        String query = "SELECT * FROM hojaruta3 where "
                + "contador_grupohojaruta like '" + en3 + "%' and clave_gruphojaruta like '" + en2 + "%' "
                + "and descripcion_contador like'" + en4 + "%' limit " + en5 + "";
        LinkedList<hojarutatres> rhx = new LinkedList<>();
        Connection conn = con.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;

            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                hojarutatres hrt = new hojarutatres();

                hrt.setContador_grupohojaruta(rs.getString("contador_grupohojaruta"));
                hrt.setClave_gruphojaruta(rs.getString("clave_gruphojaruta"));
                hrt.setDescripcion_contador(rs.getString("descripcion_contador"));
                rhx.add(hrt);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return rhx;
    }

}
