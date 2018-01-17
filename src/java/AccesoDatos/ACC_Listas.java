/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Listas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Zil
 */
public class ACC_Listas {

    private static ACC_Listas Instance = null;

    public static ACC_Listas ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Listas();
        }
        return Instance;
    }

    public static void main(String[] args) {
        ACC_Listas c = new ACC_Listas();
        System.out.println();
    }

    public LinkedList<Listas> ConsultaMatchNumListaMaterial(String query) {
        LinkedList<Listas> lsts = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Listas lst = new Listas();
                lst.setid_lista(rs.getInt("id_lista"));
                lst.setid_ubitec(rs.getString("id_ubitec"));
                lst.setnum_equipo(rs.getString("num_equipo"));
                lst.setlista_material(rs.getString("lista_material"));
                lst.setcentro(rs.getString("centro"));
                lst.setutilizacion_listamaterial(rs.getString("utilizacion_listamaterial"));
                lst.setnum_posicion_listamaterial(rs.getString("num_posicion_listamaterial"));
                lst.settipo_posicion_listamaterial(rs.getString("tipo_posicion_listamaterial"));
                lst.setcomponente_listamaterial(rs.getString("componente_listamaterial"));
                lst.setcantidad(rs.getString("cantidad"));
                lst.setunidad_medida_componente(rs.getString("unidad_medida_componente"));
                lst.setclase_documento(rs.getString("clase_documento"));
                lst.setid_posicion(rs.getString("id_posicion"));
                lst.setfecha_inicio_validez(rs.getString("fecha_inicio_validez"));
                lsts.add(lst);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchUsuario (ACC_hojas_de_ruta) " + e);
        }
        cnx.CerrarConexion(con);
        return lsts;
    }

}
