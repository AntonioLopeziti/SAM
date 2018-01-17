/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.ordenes_pm_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author AREConsulting
 */
public class ACC_OrdenesPMNotificaciones {

    private static ACC_OrdenesPMNotificaciones Instance = null;

    public static ACC_OrdenesPMNotificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_OrdenesPMNotificaciones();
        }
        return Instance;
    }

    //Metodo valida Ordenes
    public boolean ValidarOrdenesVisual(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM PM.ordenes_pm_notificaciones WHERE num_orden='" + orden + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String ord = rs.getString("num_orden");
                if (ord.equals(orden)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error de orden: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public LinkedList<ordenes_pm_notificaciones> ConsultaMatchOrdenes() {
        Conexion cnx = new Conexion();
        String query = "SELECT * FROM ordenes_pm_notificaciones";
        LinkedList<ordenes_pm_notificaciones> matordenes = new LinkedList<ordenes_pm_notificaciones>();
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                ordenes_pm_notificaciones pmnoti = new ordenes_pm_notificaciones();

                pmnoti.setId_opmn(rs.getInt("id_opmn"));
                pmnoti.setClase_orden(rs.getString("clase_orden"));
                pmnoti.setSociedad_co(rs.getString("sociedad_co"));
                pmnoti.setNum_orden(rs.getString("num_orden"));
                pmnoti.setStatus(rs.getString("status"));
                pmnoti.setTexto_breve(rs.getString("texto_breve"));
                pmnoti.setTipo_orden(rs.getString("tipo_orden"));

                matordenes.add(pmnoti);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return matordenes;
    }

//    public static void main(String[] args) {
//        ACC_OrdenesPMNotificaciones wa = new ACC_OrdenesPMNotificaciones();
//        int s = wa.OrdenesMatch("", "", 0).size();
//        System.out.println("Tamaño: " + s);
//    }
    public LinkedList<ordenes_pm_notificaciones> OrdenesMatch(String query) {
        LinkedList<ordenes_pm_notificaciones> pmorden = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ordenes_pm_notificaciones opmn = new ordenes_pm_notificaciones();
                opmn.setId_opmn(rs.getInt("id_opmn"));
                opmn.setClase_orden(rs.getString("clase_orden"));
                opmn.setSociedad_co(rs.getString("sociedad_co"));
                opmn.setNum_orden(rs.getString("num_orden"));
                opmn.setStatus(rs.getString("status"));
                opmn.setTexto_breve(rs.getString("texto_breve"));
                opmn.setTipo_orden(rs.getString("tipo_orden"));
                pmorden.add(opmn);
            }
        } catch (Exception e) {
            System.err.println("Error en la consulta: " + e);
        }
        cnx.CerrarConexion(con);
        return pmorden;
    }

    public LinkedList<ordenes_pm_notificaciones> OrdenesMatchNOT(String CtdMax, String Orden, String TxtBrv) {
        LinkedList<ordenes_pm_notificaciones> pmorden = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ordenes_pm_notificaciones_OrdenesMatchNOT(?,?,?)}";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, CtdMax);
            pst.setString(2, Orden);
            pst.setString(3, TxtBrv);
            rs = pst.executeQuery();
            while (rs.next()) {
                ordenes_pm_notificaciones opmn = new ordenes_pm_notificaciones();
                opmn.setNum_orden(rs.getString("num_orden"));
                pmorden.add(opmn);
            }
        } catch (Exception e) {
            System.err.println("Error en la consulta: " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                };
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return pmorden;
    }

    public ordenes_pm_notificaciones OrdenesMatchNOText(String Orden) {
        ordenes_pm_notificaciones opmn = new ordenes_pm_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ordenes_pm_notificaciones_OrdenesMatctexop(?)}";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, Orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                opmn.setTexto_breve(rs.getString("texto_breve_operacion"));
            }
        } catch (Exception e) {
            System.err.println("Error en la consulta: " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                };
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return opmn;
    }

    public boolean ValidarOrdenesVisualNO(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ordenes_pmValidarOrdenesVisual(?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                String ord = rs.getString("num_orden");
                if (ord.equals(orden)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error de orden: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                };
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }

}
