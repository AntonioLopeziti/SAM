/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.plan_orden;
import Entidades.planop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Planop {

    public static ACC_Planop Instance = null;

    public static ACC_Planop ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Planop();
        }
        return Instance;
    }

   
    public LinkedList<plan_orden> PlanorMAPM(String Idioma, String meeq, String meubte, String metxt) {
        LinkedList<plan_orden> pl = new LinkedList<>();
        Conexion con = new Conexion();
        String query = "SELECT * FROM plan_orden where "
                + "num_orden like'" + meubte + "%' and centro_puesto_trabajo_responsable like'" + meeq + "%'"
                + " and texto_breve like'" + metxt + "%'";

        try {
            Statement st;
            ResultSet rs;
            Connection conn = con.ObtenerConexion();
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                plan_orden plo = new plan_orden();
                plo.setCentro_puesto_trabajo_responsable(rs.getString("centro_puesto_trabajo_responsable"));
                plo.setNum_orden(rs.getString("num_orden"));
                plo.setTexto_breve(rs.getString("Texto_breve"));
                pl.add(plo);
            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return pl;
    }

}
