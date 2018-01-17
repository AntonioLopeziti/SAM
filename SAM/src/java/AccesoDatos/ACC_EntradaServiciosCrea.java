/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.entrada_servicios_crea;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author AREConsulting
 */
public class ACC_EntradaServiciosCrea {

    public static ACC_EntradaServiciosCrea Instance = null;

    public static ACC_EntradaServiciosCrea ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_EntradaServiciosCrea();
        }
        return Instance;
    }

//    public static void main (String [] da){
//        String queryD = "INSERT INTO entrada_servicios_crea (id_esc, folio_sam, num_doc_compras, num_posicion_doc_compras, indece_registro_no_valido, centro, num_servicio, cantidad, texto_breve, precio_bruto, cantidad_base, fecha, hora_dia, folio_sap, recibido, procesado, error) VALUES (3, 'ESC', 010, 5, 3, 'BA', 3010, 1, 'CHI', 10, 3, '290916', '5', '', '', '', '')";
//        ACC_EntradaServiciosCrea.ObtenerInstancia().InsertEntradaServiciosCrea(queryD);
//    }
    public boolean InsertEntradaServiciosCrea(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int validar;
        try {
            Statement st = con.createStatement();
            validar = st.executeUpdate(query);
            if (validar >= 0) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error al insertar: " + ex);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public LinkedList<entrada_servicios_crea> ObtieneNumFolio(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<entrada_servicios_crea> esc = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                entrada_servicios_crea sc = new entrada_servicios_crea();
                sc.setFolio_sam(rs.getString("folio_sam"));
                esc.add(sc);
            }
        } catch (Exception ex) {
            System.err.println("Error al obtener folio: " + ex);
        }
        cnx.CerrarConexion(con);
        return esc;
    }

}
