/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.ListadoOrdenesPP;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Panda
 */
public class ACC_ListadoOrdenesPP {

    private static ACC_ListadoOrdenesPP instance = null;

    public static ACC_ListadoOrdenesPP ObtenerInstancia() {
        if (instance == null) {
            instance = new ACC_ListadoOrdenesPP();
        }
        return instance;
    }

    public ArrayList<ListadoOrdenesPP> ObtenerListaOrdenesPP() {
        ArrayList<ListadoOrdenesPP> lo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "{CALL PP.pla_pp_listaOrdenes()}";
        try {
            ps = con.prepareStatement(sql);
//            ps.setString(1, mm);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoOrdenesPP ll = new ListadoOrdenesPP();
                ll.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                ll.setNum_orden(rs.getString("num_orden"));
                ll.setNum_material(rs.getString("num_material"));
                ll.setTexto_material(rs.getString("texto_material"));
                ll.setStatus(rs.getString("status"));
                ll.setCantidad_total(rs.getString("cantidad_total"));
                ll.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ll.setContador_notificacion(rs.getString("contador_notificacion"));
                lo.add(ll);
            }

        } catch (Exception e) {
            System.err.println("Error en ACC_ListadoOrdenesPP, ObtenerListaOrdenesPP(): " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return lo;
    }
}
