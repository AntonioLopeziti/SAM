/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.pm_operaciones_notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Erick_Jimenez
 */
public class ACC_Pm_operaciones_notificaciones {

    private static ACC_Pm_operaciones_notificaciones Instance = null;

    public static ACC_Pm_operaciones_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Pm_operaciones_notificaciones();
        }
        return Instance;
    }

    public LinkedList<pm_operaciones_notificaciones> TABGRNOTPM(String ord, String ope) {
        LinkedList<pm_operaciones_notificaciones> tpn = new LinkedList<>();
        Conexion con = new Conexion();
        String query = "select * from PM.pm_operaciones_notificaciones where num_orden = '" + ord + "' and num_operacion like'" + ope + "%'";
        try {
            Connection conn = con.ObtenerConexion();
            ResultSet rs;
            Statement st;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                pm_operaciones_notificaciones pmon = new pm_operaciones_notificaciones();
                pmon.setActividad_ya_notificada01(rs.getString("actividad_ya_notificada01"));
                pmon.setActividad_ya_notificada02(rs.getString("Actividad_ya_notificada02"));
                pmon.setActividad_ya_notificada03(rs.getString("Actividad_ya_notificada03"));
                pmon.setActividad_ya_notificada04(rs.getString("Actividad_ya_notificada04"));
                pmon.setActividad_ya_notificada05(rs.getString("Actividad_ya_notificada05"));
                pmon.setActividad_ya_notificada06(rs.getString("Actividad_ya_notificada06"));
                pmon.setCantidad_base(rs.getString("cantidad_base"));
                pmon.setCantidad_base2(rs.getString("cantidad_base2"));
                pmon.setCantidad_operacion(rs.getString("Cantidad_operacion"));
                pmon.setClase_coste(rs.getString("clase_coste"));
                pmon.setClave_control(rs.getString("clave_control"));
                pmon.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                pmon.setClave_moneda(rs.getString("clave_moneda"));
                pmon.setContador_general_orden(rs.getString("contador_general_orden"));
                pmon.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                pmon.setContador_interno(rs.getString("contador_interno"));
                pmon.setCentro(rs.getString("centro"));
                pmon.setIndicador_valor_prede_traba_relevante(rs.getString("indicador_valor_prede_traba_relevante"));
                pmon.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                pmon.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                pmon.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                pmon.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                pmon.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                pmon.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                pmon.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                pmon.setUnidad_medida_actividad_notificar01(rs.getString("unidad_medida_actividad_notificar01"));
                pmon.setUnidad_medida_actividad_notificar02(rs.getString("unidad_medida_actividad_notificar02"));
                pmon.setNum_operacion(rs.getString("num_operacion"));
                tpn.add(pmon);
            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return tpn;
    }

    public pm_operaciones_notificaciones INPGRNOTPM(String ord, String ope) {
        pm_operaciones_notificaciones pmon = new pm_operaciones_notificaciones();
        Conexion con = new Conexion();
        String query = "select * from pm_operaciones_notificaciones where num_orden = '" + ord + "' and num_operacion ='" + ope + "'";
        try {
            Connection conn = con.ObtenerConexion();
            ResultSet rs;
            Statement st;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                pmon.setActividad_ya_notificada01(rs.getString("actividad_ya_notificada01"));
                pmon.setActividad_ya_notificada02(rs.getString("Actividad_ya_notificada02"));
                pmon.setActividad_ya_notificada03(rs.getString("Actividad_ya_notificada03"));
                pmon.setActividad_ya_notificada04(rs.getString("Actividad_ya_notificada04"));
                pmon.setActividad_ya_notificada05(rs.getString("Actividad_ya_notificada05"));
                pmon.setActividad_ya_notificada06(rs.getString("Actividad_ya_notificada06"));
                pmon.setCantidad_base(rs.getString("cantidad_base"));
                pmon.setCantidad_base2(rs.getString("cantidad_base2"));
                pmon.setCantidad_operacion(rs.getString("Cantidad_operacion"));
                pmon.setClase_coste(rs.getString("clase_coste"));
                pmon.setClave_control(rs.getString("clave_control"));
                pmon.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                pmon.setClave_moneda(rs.getString("clave_moneda"));
                pmon.setContador_general_orden(rs.getString("contador_general_orden"));
                pmon.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                pmon.setContador_interno(rs.getString("contador_interno"));
                pmon.setCentro(rs.getString("centro"));
                pmon.setIndicador_valor_prede_traba_relevante(rs.getString("indicador_valor_prede_traba_relevante"));
                pmon.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                pmon.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                pmon.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                pmon.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                pmon.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                pmon.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                pmon.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                pmon.setUnidad_medida_actividad_notificar01(rs.getString("unidad_medida_actividad_notificar01"));
                pmon.setUnidad_medida_actividad_notificar02(rs.getString("unidad_medida_actividad_notificar02"));
                pmon.setNum_operacion(rs.getString("num_operacion"));
                pmon.setNum_solicitud_pedido(rs.getString("num_solicitud_pedido"));
                pmon.setNum_posicion_socitud_pedido_orden(rs.getString("num_posicion_socitud_pedido_orden"));
                pmon.setPrecio(rs.getString("precio"));
                pmon.setGrupo_articulos(rs.getString("grupo_articulos"));
                pmon.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                pmon.setOrganizacion_compras(rs.getString("organizacion_compras"));
                pmon.setProveedor(rs.getString("proveedor"));
                pmon.setSolicitante(rs.getString("solicitante"));

            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return pmon;
    }

    public LinkedList<pm_operaciones_notificaciones> TABGRNOTPMNot(String ord, String ope) {
        LinkedList<pm_operaciones_notificaciones> tpn = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.pm_operaciones_notificaciones_TABGRNOTPM(?,?)}";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {
                pm_operaciones_notificaciones pmon = new pm_operaciones_notificaciones();
                pmon.setActividad_ya_notificada01(rs.getString("actividad_ya_notificada01"));
                pmon.setActividad_ya_notificada02(rs.getString("Actividad_ya_notificada02"));
                pmon.setActividad_ya_notificada03(rs.getString("Actividad_ya_notificada03"));
                pmon.setActividad_ya_notificada04(rs.getString("Actividad_ya_notificada04"));
                pmon.setActividad_ya_notificada05(rs.getString("Actividad_ya_notificada05"));
                pmon.setActividad_ya_notificada06(rs.getString("Actividad_ya_notificada06"));
                pmon.setCantidad_base(rs.getString("cantidad_base"));
                pmon.setCantidad_base2(rs.getString("cantidad_base2"));
                pmon.setCantidad_operacion(rs.getString("Cantidad_operacion"));
                pmon.setClase_coste(rs.getString("clase_coste"));
                pmon.setClave_control(rs.getString("clave_control"));
                pmon.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                pmon.setClave_moneda(rs.getString("clave_moneda"));
                pmon.setContador_general_orden(rs.getString("contador_general_orden"));
                pmon.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                pmon.setContador_interno(rs.getString("contador_interno"));
                pmon.setCentro(rs.getString("centro"));
                pmon.setIndicador_valor_prede_traba_relevante(rs.getString("indicador_valor_prede_traba_relevante"));
                pmon.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                pmon.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                pmon.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                pmon.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                pmon.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                pmon.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                pmon.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                pmon.setUnidad_medida_actividad_notificar01(rs.getString("unidad_medida_actividad_notificar01"));
                pmon.setUnidad_medida_actividad_notificar02(rs.getString("unidad_medida_actividad_notificar02"));
                pmon.setNum_operacion(rs.getString("num_operacion"));
                tpn.add(pmon);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return tpn;
    }

    public void AlmacenM200(String v1, String v2) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.ActualizaM200(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizaRelacionMonitor(String equipo, String centro, String lote, String cantidad) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.actualizaMonitorEQ_Notifi(?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, equipo);
            ps.setString(2, centro);
            ps.setString(3, lote);
            ps.setString(4, cantidad);
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizaRelacionMA(String equipo, String centro, String cantidad) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.actualizaRelacionNoti(?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, equipo);
            ps.setString(2, centro);
            ps.setString(3, cantidad);
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public boolean InsertStatus_notificaciones(String fsam, String fecha, String hora, String stats, String orden, String orpm, String usu) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        String query = "{call PM.status_notificaciones_InsertSt_not(?,?,?,?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fsam);
            pst.setString(2, fecha);
            pst.setString(3, hora);
            pst.setString(4, stats);
            pst.setString(5, orden);
            pst.setString(6, orpm);
            pst.setString(7, usu);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public boolean InsertStatus_notificacionessap(String fsam, String fecha, String hora, String stats, String orden, String orpm, String usu) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        String query = "{call PM.status_notificaciones_InsertSt_notsap(?,?,?,?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fsam);
            pst.setString(2, fecha);
            pst.setString(3, hora);
            pst.setString(4, stats);
            pst.setString(5, orden);
            pst.setString(6, orpm);
            pst.setString(7, usu);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public boolean InsertStatus_notificacioneseq(String fsam, String fecha, String hora, String stats, String orden, String usu, String notlote22, String centro) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        String query = "{call PM.status_notificaciones_InsertStatus_notificacioneseq(?,?,?,?,?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fsam);
            pst.setString(2, fecha);
            pst.setString(3, hora);
            pst.setString(4, stats);
            pst.setString(5, orden);
            pst.setString(6, usu);
            pst.setString(7, notlote22);
            pst.setString(8, centro);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public pm_operaciones_notificaciones INPGRNOTPMNOT(String ord, String ope) {
        pm_operaciones_notificaciones pmon = new pm_operaciones_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PM.pm_operaciones_notificaciones_INPGRNOTPMNOT(?,?)}";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {

                pmon.setActividad_ya_notificada01(rs.getString("actividad_ya_notificada01"));
                pmon.setActividad_ya_notificada02(rs.getString("Actividad_ya_notificada02"));
                pmon.setActividad_ya_notificada03(rs.getString("Actividad_ya_notificada03"));
                pmon.setActividad_ya_notificada04(rs.getString("Actividad_ya_notificada04"));
                pmon.setActividad_ya_notificada05(rs.getString("Actividad_ya_notificada05"));
                pmon.setActividad_ya_notificada06(rs.getString("Actividad_ya_notificada06"));
                pmon.setCantidad_base(rs.getString("cantidad_base"));
                pmon.setCantidad_base2(rs.getString("cantidad_base2"));
                pmon.setCantidad_operacion(rs.getString("Cantidad_operacion"));
                pmon.setClase_coste(rs.getString("clase_coste"));
                pmon.setClave_control(rs.getString("clave_control"));
                pmon.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                pmon.setClave_moneda(rs.getString("clave_moneda"));
                pmon.setContador_general_orden(rs.getString("contador_general_orden"));
                pmon.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                pmon.setContador_interno(rs.getString("contador_interno"));
                pmon.setCentro(rs.getString("centro"));
                pmon.setIndicador_valor_prede_traba_relevante(rs.getString("indicador_valor_prede_traba_relevante"));
                pmon.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                pmon.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                pmon.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                pmon.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                pmon.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                pmon.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                pmon.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                pmon.setUnidad_medida_actividad_notificar01(rs.getString("unidad_medida_actividad_notificar01"));
                pmon.setUnidad_medida_actividad_notificar02(rs.getString("unidad_medida_actividad_notificar02"));
                pmon.setNum_operacion(rs.getString("num_operacion"));
                pmon.setNum_solicitud_pedido(rs.getString("num_solicitud_pedido"));
                pmon.setNum_posicion_socitud_pedido_orden(rs.getString("num_posicion_socitud_pedido_orden"));
                pmon.setPrecio(rs.getString("precio"));
                pmon.setGrupo_articulos(rs.getString("grupo_articulos"));
                pmon.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                pmon.setOrganizacion_compras(rs.getString("organizacion_compras"));
                pmon.setProveedor(rs.getString("proveedor"));
                pmon.setSolicitante(rs.getString("solicitante"));

            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return pmon;
    }

    public boolean updatEStatus_notificaciones(String fsam, String stats) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        String query = "{call pm.cabecera_ordenes_creaACTUALNOT(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fsam);
            pst.setString(2, stats);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
    public boolean ValidaQM01(String orden) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs;
        String query = "{call PM.ValidaQM01_CT(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                if(rs.getString("conjunto").equals("X") && rs.getString("conjunto2").equals("X")){
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
}
