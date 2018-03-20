/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.cabecera_ordenes_crea;
import Entidades.materiales_ordenes_crea;
import Entidades.notificaciones_cabecera_vis;
import Entidades.operaciones_ordenes_crea;
import Entidades.ordenes_pp_notificaciones;
import Entidades.pm03_3_notificaciones;
import Entidades.pp_operaciones_noti;
import Entidades.pp01_notifi;
import Entidades.pp03_1_notificaciones;
import Entidades.pp03_2_notificaciones;
import Entidades.pp_03_3_notificaciones;
import Entidades.PlanPP;
import Entidades.servicios_ordenes_crea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Jhonatan
 */
public class ACC_Ordenes_pp_notificaciones {

    private static ACC_Ordenes_pp_notificaciones Instance = null;

    public static ACC_Ordenes_pp_notificaciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Ordenes_pp_notificaciones();
        }
        return Instance;
    }
    public LinkedList<PlanPP> ObtenerNotificPP(String cant, String orden, String deso){
        LinkedList<PlanPP> pln = new LinkedList<>();
        String query = "{call PP.NotOrden_TodosMatchNotiPP(?,?,?)}";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        try{
            pst = conn.prepareStatement(query);
            pst.setString(1, cant);
            pst.setString(2, orden);
            pst.setString(3, deso);            
            rs = pst.executeQuery();
            while (rs.next()) {
                PlanPP pa = new PlanPP();
                pa.setNum_orden(rs.getString("num_orden"));
                pa.setTexto_breve(rs.getString("texto_breve"));
                pln.add(pa);
            }
        }catch (Exception e) {
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
        return pln;
    }
    public LinkedList<ordenes_pp_notificaciones> ObtenOrdenNOTIPP(String cann, String orde, String deso, String plao) {
        LinkedList<ordenes_pp_notificaciones> orn = new LinkedList<>();
        String query = "{call PP.NotOrden_TodosMatchNotiPP(?,?,?,?)}";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, cann);
            pst.setString(2, orde);
            pst.setString(3, deso);
            pst.setString(4, plao);
            rs = pst.executeQuery();
            while (rs.next()) {
                ordenes_pp_notificaciones or = new ordenes_pp_notificaciones();
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setTexto_breve(rs.getString("texto_breve"));
                orn.add(or);
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
        return orn;
    }

    public boolean COMPORdenNOTPP(String ord) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ord_pp_noti_COMPORdenNOTPP(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                String orden = rs.getString("num_orden");
                if (ord.equals(orden)) {
                    return true;
                }
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
        return false;
    }

    public boolean COMPFOLORdenNOTPP(String ord) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.op_ord_crea_COMPFOLORdenNOTPP(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                String orden = rs.getString("folio_sam");
                if (ord.equals(orden)) {
                    con.CerrarConexion(conn);
                    return true;
                }
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
        return false;
    }

    public ordenes_pp_notificaciones ObtenStatusCNPMNOTPP(String orde) {
        ordenes_pp_notificaciones or = new ordenes_pp_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.ord_pp_noti_COMPORdenNOTPP(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, orde);
            rs = pst.executeQuery();
            while (rs.next()) {
                or.setId_opmn(rs.getInt("id_opmn"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setStatus(rs.getString("status"));
                or.setTexto_breve(rs.getString("texto_breve"));
                or.setClase_orden(rs.getString("clase_orden"));
                or.setTipo_orden(rs.getString("tipo_orden"));
                or.setCentro(rs.getString("centro"));

            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return or;
    }

    public boolean POSNOCRE_INSERTAPP(String folpnc, String ord, String ope, String honot, String fenot, String durp1, String trrep1, String nf, String nofip1, String durp2) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PP.posiciones_notificaciones_crea_INSERTAR_PP(?,?,?,?,?,?,?,?,?,?)}";
        int can;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folpnc);
            pst.setString(2, ord);
            pst.setString(3, ope);
            pst.setString(4, honot);
            pst.setString(5, fenot);
            pst.setString(6, durp1);
            pst.setString(7, trrep1);
            pst.setString(8, nf);
            pst.setString(9, nofip1);
            pst.setString(10, durp2);
            can = pst.executeUpdate();
            if (can > 0) {
                return true;
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
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public boolean CANOCRE_INSERTAPP(String folicn, String ord, String ope, String honot, String fenot, String fecco, String usu) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PP.cab_notificaciones_crea_insertar_PP(?,?,?,?,?,?,?)}";
        int can;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folicn);
            pst.setString(2, ord);
            pst.setString(3, ope);
            pst.setString(4, honot);
            pst.setString(5, fenot);
            pst.setString(6, fecco);
            pst.setString(7, usu);
            can = pst.executeUpdate();
            if (can > 0) {
                return true;
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
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public ordenes_pp_notificaciones ObtStatusCNPP(String orde) {
        ordenes_pp_notificaciones or = new ordenes_pp_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PP.ord_pp_not_ObtStatusCNPP(?)}";
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, orde);
            rs = pst.executeQuery();
            while (rs.next()) {

                or.setId_opmn(rs.getInt("id_opmn"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setSociedad_co(rs.getString("sociedad_co"));
                or.setStatus(rs.getString("status"));
                or.setTexto_breve(rs.getString("texto_breve"));
                or.setClase_orden(rs.getString("clase_orden"));
                or.setTipo_orden(rs.getString("tipo_orden"));
                or.setCentro(rs.getString("centro"));

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
        return or;
    }

    public boolean InsertStatus_notificacionessapPP(String fsam, String fecha, String hora, String stats, String orden, String orpm, String usu) {
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

    public boolean ordpmnotiActualPP(String operacion, String orden) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PP.ordenes_pp_notificaciones_ActualizarPP(?,?)}";
        int can;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, operacion);
            pst.setString(2, orden);
            can = pst.executeUpdate();
            if (can > 0) {
                return true;
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
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    public LinkedList<ordenes_pp_notificaciones> OrdenesMatchNOTPP(String CtdMax, String Orden, String TxtBrv) {
        LinkedList<ordenes_pp_notificaciones> pmorden = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ordenes_pp_noti_OrdenesMatchNOTPP(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, CtdMax);
            pst.setString(2, Orden);
            pst.setString(3, TxtBrv);
            rs = pst.executeQuery();
            while (rs.next()) {
                ordenes_pp_notificaciones opmn = new ordenes_pp_notificaciones();
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

    public ordenes_pp_notificaciones OrdenesMatchNOTextPP(String Orden) {
        ordenes_pp_notificaciones opmn = new ordenes_pp_notificaciones();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ordenes_pp_noti_OrdenesMatctexopPP(?)}";

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

    public boolean ValidarOrdenesVisualNOPP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ordenes_ppValidarOrdenesVisualPP(?)}";
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

    public notificaciones_cabecera_vis ObtenerDatosPP(String orden) {
        notificaciones_cabecera_vis vis = new notificaciones_cabecera_vis();
        Conexion con = new Conexion();
        String query = "{call PP.notif_cab_vis_ObtenerDatosPP(?)}";
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                vis.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
            }
        } catch (Exception ex) {
            System.err.println("Error de Resumen: " + ex);
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
        return vis;
    }

    public LinkedList<notificaciones_cabecera_vis> GetResumenNotificacionesPP(String orden, String opera) {
        LinkedList<notificaciones_cabecera_vis> cabevis = new LinkedList<>();
        Conexion con = new Conexion();
        String query = "{call PP.noti_csb_vis_GetResumenNotificacionesCreaPP(?,?)}";
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, orden);
            pst.setString(2, opera);
            rs = pst.executeQuery();
            while (rs.next()) {
                notificaciones_cabecera_vis vis = new notificaciones_cabecera_vis();
                vis.setId_ncv(rs.getInt("id_ncv"));
                vis.setNum_orden(rs.getString("num_orden"));
                vis.setIndicador_cabecera(rs.getString("indicador_cabecera"));
                vis.setNum_operacion(rs.getString("num_operacion"));
                vis.setSuboperacion(rs.getString("suboperacion"));
                vis.setClase_capacidad(rs.getString("clase_capacidad"));
                vis.setContador_notificacion(rs.getString("contador_notificacion"));
                vis.setNotificacion_parcial_final(rs.getString("notificacion_parcial_final"));
                vis.setIndicador_doc_anulado(rs.getString("indicador_doc_anulado"));
                vis.setFecha_contabilizacion(rs.getString("fecha_contabilizacion"));
                vis.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                vis.setTrabajo_real(rs.getString("trabajo_real"));
                vis.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                vis.setClase_actividad_notificacion(rs.getString("clase_actividad_notificacion"));
                vis.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                vis.setCl_reg_notificacion(rs.getString("cl_reg_notificacion"));
                vis.setInicio_real_ejecucion_fecha(rs.getString("inicio_real_ejecucion_fecha"));
                vis.setFin_real_ejecucion_fecha(rs.getString("fin_real_ejecucion_fecha"));
                vis.setTrabajo_pronosticado_real_resto(rs.getString("trabajo_pronosticado_real_resto"));
                vis.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                vis.setInicio_mas_temprano_programado_ejecucion_fecha(rs.getString("inicio_mas_temprano_programado_ejecucion_fecha"));
                vis.setInicio_programado_mas_tardio_efectua_fecha(rs.getString("inicio_programado_mas_tardio_efectua_fecha"));
                vis.setFin_mas_temprano_programado_ejecucion_fecha(rs.getString("fin_mas_temprano_programado_ejecucion_fecha"));
                vis.setFin_mas_tardio_programado_ejecucion_fecha(rs.getString("fin_mas_tardio_programado_ejecucion_fecha"));
                vis.setId_objeto(rs.getString("id_objeto"));
                cabevis.add(vis);
            }
        } catch (Exception ex) {
            System.err.println("Error de Resumen: " + ex);
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
        return cabevis;
    }

    public cabecera_ordenes_crea CargarDataCabPP(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        cabecera_ordenes_crea coc = new cabecera_ordenes_crea();
        String SP = "{CALL PP.Ordenes_CargarCabeceraSAMPP(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            rs.next();
            coc.setEstatus(rs.getString("estatus"));
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarDataCab(ACC_CabeceraOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return coc;
    }

    public operaciones_ordenes_crea cargarTablaNoOperacionesCreaP3PP(String ord, String ope) {
        operaciones_ordenes_crea op = new operaciones_ordenes_crea();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.operaciones_ordenes_CargarTablaNoOperacionesCreaPP(?,?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {

                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));

            }
        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
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
        return op;
    }

    public LinkedList<materiales_ordenes_crea> MostraTABPM01NOPP(String ord, String ope) {
        LinkedList<materiales_ordenes_crea> mpm = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.materiales_ordenes_crea_MostraTABPP01NOPP(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales_ordenes_crea ma = new materiales_ordenes_crea();
                ma.setNum_reserva(rs.getString("num_reserva"));
                ma.setNum_posicion_reserva(rs.getString("num_posicion_reserva"));
                ma.setNum_material(rs.getString("num_material"));
                ma.setLote(rs.getString("lote"));
                ma.setUnidad_medida_componente_pieza_bruto(rs.getString("unidad_medida_componente_pieza_bruto"));
                ma.setCantidad_necesaria_componente2(rs.getString("cantidad_necesaria_componente2"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setCentro(rs.getString("centro"));
                ma.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                ma.setAlmacen(rs.getString("almacen"));
                ma.setTexto_posicion_lista_materiales(rs.getString("texto_posicion_lista_materiales"));
                mpm.add(ma);
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
        return mpm;
    }

    public pp_operaciones_noti INPGRNOTPMNOTPP(String ord, String ope) {
        pp_operaciones_noti pmon = new pp_operaciones_noti();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.pp_operaciones_notificaciones_INPGRNOTPPNOTPP(?,?)}";
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

    public LinkedList<pp01_notifi> ShowDatPP1PP(String ord, String ope) {
        LinkedList<pp01_notifi> np1 = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.pp01_notificaciones_ShowDatPP1NOTPP(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {
                pp01_notifi np = new pp01_notifi();
                np.setNum_reserva_nece_secundarias(rs.getString("num_reserva_nece_secundarias"));
                np.setNum_posicion_reserva_nece_secundaria(rs.getString("num_posicion_reserva_nece_secundaria"));
                np.setClase_registro(rs.getString("clase_registro"));
                np.setClase_necesidad(rs.getString("clase_necesidad"));
                np.setStatus_reserva(rs.getString("status_reserva"));
                np.setPosicion_borrada(rs.getString("posicion_borrada"));
                np.setMovimiento_mercancia_permitido_reserva(rs.getString("movimiento_mercancia_permitido_reserva"));
                np.setSalida_final_reserva(rs.getString("salida_final_reserva"));
                np.setFalta(rs.getString("falta"));
                np.setMaterial(rs.getString("material"));
                np.setCentro(rs.getString("centro"));
                np.setAlmacen(rs.getString("almacen"));
                np.setArea_suministro_produccion(rs.getString("area_suministro_produccion"));
                np.setLote(rs.getString("lote"));
                np.setDistribucion_diferencias(rs.getString("distribucion_diferencias"));
                np.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                np.setFecha_necesidad_componente(rs.getString("fecha_necesidad_componente"));
                np.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                np.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                np.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                np.setCantidad_fija(rs.getString("cantidad_fija"));
                np.setCantidad_tomada(rs.getString("cantidad_tomada"));
                np.setValor_toma(rs.getString("valor_toma"));
                np.setClave_moneda(rs.getString("clave_moneda"));
                np.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                np.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                np.setNum_orden_previsional(rs.getString("num_orden_previsional"));
                np.setNum_solped(rs.getString("num_solped"));
                np.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                np.setNum_orden(rs.getString("num_orden"));
                np.setNum_material_conjunto_superior(rs.getString("num_material_conjunto_superior"));
                np.setSerie(rs.getString("serie"));
                np.setTexto_posicion(rs.getString("texto_posicion"));
                np1.add(np);
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
        return np1;
    }

    public operaciones_ordenes_crea cartabopecrP3PP(String ord, String ope) {
        operaciones_ordenes_crea op = new operaciones_ordenes_crea();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.operaciones_ordenes_crea_cartabopcreP3PP(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            pst.setString(2, ope);
            rs = pst.executeQuery();
            while (rs.next()) {

                op.setFolio_sam(rs.getString("folio_sam"));
                op.setNum_orden(rs.getString("num_orden"));
                op.setNum_hoja_ruta_operaciones_orden(rs.getString("num_hoja_ruta_operaciones_orden"));
                op.setContador_general_orden(rs.getString("contador_general_orden"));
                op.setHora_dia(rs.getString("hora_dia"));
                op.setFecha(rs.getString("fecha"));
                op.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                op.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                op.setTipo_grupo_hoja_ruta(rs.getString("tipo_grupo_hoja_ruta"));
                op.setIncremento_operaciones_referenciadas(rs.getString("incremento_operaciones_referenciadas"));
                op.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                op.setContador_interno(rs.getString("contador_interno"));
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setClave_control(rs.getString("clave_control"));
                op.setId_objeto_recurso(rs.getString("id_objeto_recurso"));
                op.setCentro(rs.getString("centro"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setActividad_ya_notificada1(rs.getString("actividad_ya_notificada1"));
                op.setActividad_ya_notificada2(rs.getString("actividad_ya_notificada2"));
                op.setActividad_ya_notificada3(rs.getString("actividad_ya_notificada3"));
                op.setActividad_ya_notificada4(rs.getString("actividad_ya_notificada4"));
                op.setActividad_ya_notificada5(rs.getString("actividad_ya_notificada5"));
                op.setActividad_ya_notificada6(rs.getString("actividad_ya_notificada6"));
                op.setUnidad_medida_actividad_notificar1(rs.getString("unidad_medida_actividad_notificar1"));
                op.setUnidad_medida_actividad_notificar2(rs.getString("unidad_medida_actividad_notificar2"));
                op.setUnidad_medida_actividad_notificar3(rs.getString("unidad_medida_actividad_notificar3"));
                op.setUnidad_medida_actividad_notificar4(rs.getString("unidad_medida_actividad_notificar4"));
                op.setUnidad_medida_actividad_notificar5(rs.getString("unidad_medida_actividad_notificar5"));
                op.setUnidad_medida_actividad_notificar6(rs.getString("unidad_medida_actividad_notificar6"));
                op.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                op.setIndicador_valor_predeterminado_trabajo_relevante(rs.getString("indicador_valor_predeterminado_trabajo_relevante"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setNum_posicion_solped__orden(rs.getString("num_posicion_solped__orden"));
                op.setOrganizacion_compras(rs.getString("organizacion_compras"));
                op.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                op.setGrupo_articulos(rs.getString("grupo_articulos"));
                op.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                op.setPrecio(rs.getString("precio"));
                op.setCantidad_base2(rs.getString("cantidad_base2"));
                op.setClave_moneda(rs.getString("clave_moneda"));
                op.setClase_coste(rs.getString("clase_coste"));
                op.setSolicitante(rs.getString("solicitante"));
                op.setNum_notificacion_operacion(rs.getString("num_notificacion_operacion"));

            }
        } catch (Exception e) {
            System.err.println("Error en Metodo cargaroperacionescrea por " + e);
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
        return op;
    }

    public LinkedList<servicios_ordenes_crea> COnsuTAMNOPP023PP(String ord) {
        LinkedList<servicios_ordenes_crea> so = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.servicios_ordenes_crea_COnsuTAMPP023PP(?)}";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                servicios_ordenes_crea sc = new servicios_ordenes_crea();
                sc.setFolio_sam(rs.getString("folio_sam"));
                sc.setNum_paquete(rs.getString("num_paquete"));
                sc.setNum_linea1(rs.getString("num_linea1"));
                sc.setNum_linea2(rs.getString("num_linea2"));
                sc.setIndicador_borrado(rs.getString("indicador_borrado"));
                sc.setNum_servicio(rs.getString("num_servicio"));
                sc.setNivel_jerarquico_grupo(rs.getString("nivel_jerarquico_grupo"));
                sc.setNivel_estructura(rs.getString("nivel_estructura"));
                sc.setAsignacion_servicio(rs.getString("asignacion_servicio"));
                sc.setNum_subpaquete(rs.getString("num_subpaquete"));
                sc.setDenominacion_ambito_servicio(rs.getString("denominacion_ambito_servicio"));
                sc.setEdicion_ambito_servicio(rs.getString("edicion_ambito_servicio"));
                sc.setPosicion_catalogo_prestaciones_estandar(rs.getString("posicion_catalogo_prestaciones_estandar"));
                sc.setNum_servicio_proveedor(rs.getString("num_servicio_proveedor"));
                sc.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                sc.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                sc.setTolerancia_sobrecumplimiento(rs.getString("tolerancia_sobrecumplimiento"));
                sc.setSobrecumplimiento_ilimitado(rs.getString("sobrecumplimiento_ilimitado"));
                sc.setBusqueda_limites(rs.getString("busqueda_limites"));
                sc.setActualizar_condiciones(rs.getString("actualizar_condiciones"));
                sc.setCantidad_base(rs.getString("cantidad_base"));
                sc.setPrecio_bruto(rs.getString("precio_bruto"));
                sc.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
                sc.setLimite_inferior(rs.getString("limite_inferior"));
                sc.setLimite_superior(rs.getString("limite_superior"));
                sc.setTexto_breve(rs.getString("texto_breve"));
                sc.setIndicador_distribucion_imputacion_multiple(rs.getString("indicador_distribucion_imputacion_multiple"));
                sc.setIndicador_factura_parcial(rs.getString("indicador_factura_parcial"));
                sc.setNum_personal(rs.getString("num_personal"));
                sc.setAgrupacion_paises(rs.getString("agrupacion_paises"));
                sc.setCc_nomina(rs.getString("cc_nomina"));
                sc.setTexto_explicativo_cc_nomina(rs.getString("texto_explicativo_cc_nomina"));
                sc.setFuncion(rs.getString("funcion"));
                sc.setNum_actual_tablas_interfaces(rs.getString("num_actual_tablas_interfaces"));
                sc.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
                sc.setFecha_activado_registro_tabla(rs.getString("fecha_activado_registro_tabla"));
                sc.setNum_paquete_original(rs.getString("num_paquete_original"));
                sc.setEntrada_linea_paquete_plan(rs.getString("entrada_linea_paquete_plan"));
                sc.setEntrada_no_planif_pedido(rs.getString("entrada_no_planif_pedido"));
                sc.setEntrada_no_planif_contr(rs.getString("entrada_no_planif_contr"));
                sc.setEntrada_servicio_no_planificado_modelo(rs.getString("entrada_servicio_no_planificado_modelo"));
                sc.setEntrada_servicio_no_planificado_cp_modelo(rs.getString("entrada_servicio_no_planificado_cp_modelo"));
                sc.setLinea_servicio_refiere_limites_cpe(rs.getString("linea_servicio_refiere_limites_cpe"));
                sc.setEntrada_no_plan_linea_limite(rs.getString("entrada_no_plan_linea_limite"));
                sc.setPedido_cantidad_entrada(rs.getString("pedido_cantidad_entrada"));
                sc.setValor_registrado(rs.getString("valor_registrado"));
                sc.setPedido_abierto_valor_ordenado(rs.getString("pedido_abierto_valor_ordenado"));
                sc.setPedido_abierto_cantidad_ordenada(rs.getString("pedido_abierto_cantidad_ordenada"));
                sc.setValor_previsto(rs.getString("valor_previsto"));
                sc.setPedido_abierto_valor_llamado_no_planif(rs.getString("pedido_abierto_valor_llamado_no_planif"));
                sc.setPedido_abierto_cantidad_ordenada_forma_no_plan(rs.getString("pedido_abierto_cantidad_ordenada_forma_no_plan"));
                sc.setAlternativa_nota_posicion_base(rs.getString("alternativa_nota_posicion_base"));
                sc.setLinea_base(rs.getString("linea_base"));
                sc.setLinea_alternativa(rs.getString("linea_alternativa"));
                sc.setLinea_licitante(rs.getString("linea_licitante"));
                sc.setLinea_suplementaria(rs.getString("linea_suplementaria"));
                sc.setLinea_cantidad_libre(rs.getString("linea_cantidad_libre"));
                sc.setLinea_informativa(rs.getString("linea_informativa"));
                sc.setLinea_global(rs.getString("linea_global"));
                sc.setLinea_reserva(rs.getString("linea_reserva"));
                sc.setIndicador_iva(rs.getString("indicador_iva"));
                sc.setDomicilio_fiscal(rs.getString("domicilio_fiscal"));
                sc.setModificacion_precio_hoja_entrada(rs.getString("modificacion_precio_hoja_entrada"));
                sc.setGrupo_articulos(rs.getString("grupo_articulos"));
                sc.setPrecio_bruto2(rs.getString("precio_bruto2"));
                sc.setIva_soportado_no_deducible(rs.getString("iva_soportado_no_deducible"));
                sc.setImporte_base_impuesto(rs.getString("importe_base_impuesto"));
                sc.setNum_condicion_doc(rs.getString("num_condicion_doc"));
                sc.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                sc.setTrabajo_interno(rs.getString("trabajo_interno"));
                sc.setClave_referencia_srm(rs.getString("clave_referencia_srm"));
                sc.setClase_coste(rs.getString("clase_coste"));
                sc.setTrabajo_interno2(rs.getString("trabajo_interno2"));
                sc.setCpo_asignacion(rs.getString("cpo_asignacion"));
                sc.setClave_posicion_mensaje_esoa(rs.getString("clave_posicion_mensaje_esoa"));
                sc.setTax_tariff_code(rs.getString("tax_tariff_code"));
                sc.setFecha(rs.getString("fecha"));
                sc.setHora_inicio(rs.getString("hora_inicio"));
                sc.setHora_final(rs.getString("hora_final"));
                sc.setNum_externo_personal(rs.getString("num_externo_personal"));
                sc.setContador_registro_entrada_tiempos(rs.getString("contador_registro_entrada_tiempos"));
                sc.setIndicador_doc_anulado(rs.getString("indicador_doc_anulado"));
                sc.setNum_doc(rs.getString("num_doc"));
                sc.setNum_formula(rs.getString("num_formula"));
                sc.setValor_formula1(rs.getString("valor_formula1"));
                sc.setValor_formula2(rs.getString("valor_formula2"));
                sc.setValor_formula3(rs.getString("valor_formula3"));
                sc.setValor_formula4(rs.getString("valor_formula4"));
                sc.setValor_formula5(rs.getString("valor_formula5"));
                sc.setCampo_personalizado1(rs.getString("campo_personalizado1"));
                sc.setCampo_personalizado2(rs.getString("campo_personalizado2"));
                sc.setCampo_personalizado3(rs.getString("campo_personalizado3"));
                sc.setCampo_personalizado4(rs.getString("campo_personalizado4"));
                sc.setNum_objeto_modulo_relaciones_asignado(rs.getString("num_objeto_modulo_relaciones_asignado"));
                sc.setModificacion_texto_breve_permitida(rs.getString("modificacion_texto_breve_permitida"));
                sc.setNum_calculo_coste(rs.getString("num_calculo_coste"));
                sc.setVariante_cal_coste(rs.getString("variante_cal_coste"));
                sc.setIdentificacion_lines(rs.getString("identificacion_lines"));
                sc.setLinea_interna(rs.getString("linea_interna"));
                sc.setGrupo_subcontratista(rs.getString("grupo_subcontratista"));
                sc.setLinea_riesgo(rs.getString("linea_riesgo"));
                sc.setCasilla_seleccion(rs.getString("casilla_seleccion"));
                sc.setModificacion_texto_explicativo(rs.getString("modificacion_texto_explicativo"));
                sc.setNum_grupo_numero_asignacion_ejecucion(rs.getString("num_grupo_numero_asignacion_ejecucion"));
                sc.setNum_actual_num_asignacion_ejecucion(rs.getString("num_actual_num_asignacion_ejecucion"));
                sc.setIndicador_immpresion(rs.getString("indicador_immpresion"));
                sc.setNum_suplementario(rs.getString("num_suplementario"));
                sc.setStatus_suplemento(rs.getString("status_suplemento"));
                sc.setTipo_objeto_linea_catalogo_servicios(rs.getString("tipo_objeto_linea_catalogo_servicios"));
                sc.setNum_subposicion(rs.getString("num_subposicion"));
                sc.setNum_linea(rs.getString("num_linea"));
                sc.setEntrada_servicio_permitida(rs.getString("entrada_servicio_permitida"));
                sc.setTamano_lote_calculo_costes(rs.getString("tamano_lote_calculo_costes"));
                sc.setPrecio_global_posicion_principal_definida(rs.getString("precio_global_posicion_principal_definida"));
                sc.setClave_referencia_externa_prestacion(rs.getString("clave_referencia_externa_prestacion"));
                sc.setPedido_cantidad_registrada_factura(rs.getString("pedido_cantidad_registrada_factura"));
                sc.setFecha_inicio_periodo_prestacion_servicios(rs.getString("fecha_inicio_periodo_prestacion_servicios"));
                sc.setFecha_fin_periodo_prestacion_servicios(rs.getString("fecha_fin_periodo_prestacion_servicios"));
                so.add(sc);
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
        return so;
    }

    public pp_operaciones_noti INPGRNOTPPNOTPP(String ord, String ope) {
        pp_operaciones_noti pmon = new pp_operaciones_noti();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.pp_operaciones_notificaciones_INPGRNOTPPNOTPP(?,?)}";
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

    public LinkedList<pp03_1_notificaciones> TABGRNOTPP(String ord) {
        LinkedList<pp03_1_notificaciones> tpn = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.pp03_1_notificaciones_TABGRNOTPP(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                pp03_1_notificaciones ppon = new pp03_1_notificaciones();
                ppon.setId_pp1(rs.getInt("id_pp1"));
                ppon.setNum_orden(rs.getString("num_orden"));
                ppon.setNum_linea(rs.getString("num_linea"));
                ppon.setTexto_breve(rs.getString("texto_breve"));
                ppon.setCantidad_sign(rs.getString("cantidad_signo"));
                ppon.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                ppon.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
                ppon.setCatidad_base(rs.getString("cantidad_base"));
                ppon.setGrupo_articulos(rs.getString("grupo_articulos"));
                ppon.setClase_coste(rs.getString("clase_coste"));
                tpn.add(ppon);
//            pm03_1_notificaciones pmon = new pm03_1_notificaciones();
//            pmon.setId_pm1(rs.getInt("id_pm1"));
//            pmon.setNum_orden(rs.getString("num_orden"));
//            pmon.setNum_linea(rs.getString("num_linea"));
//            pmon.setNum_servicio(rs.getString("num_servicio"));
//            pmon.setTexto_breve(rs.getString("texto_breve"));
//            pmon.setCantidad_sign(rs.getString("cantidad_signo"));
//            pmon.setUnidad_medida_base(rs.getString("unidad_medida_base"));
//            pmon.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
//            pmon.setCatidad_base(rs.getString("catidad_base"));
//            pmon.setGrupo_articulos(rs.getString("grupo_articulos"));
//            pmon.setClase_coste(rs.getString("clase_coste"));
//            tpn.add(pmon);
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
        return tpn;
    }

    public LinkedList<pp03_2_notificaciones> TABGRNOTPP_2(String ord) {
        LinkedList<pp03_2_notificaciones> tpn = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PP.pp03_2_notificaciones_TABGRNOTPP(?)}";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                pp03_2_notificaciones pmon = new pp03_2_notificaciones();
                pmon.setId_pp2(rs.getInt("id_pm2"));
                pmon.setNum_orden(rs.getString("num_orden"));
                pmon.setNum_solped(rs.getString("num_solped"));
                pmon.setNum_posicion_solped_orden(rs.getString("num_posicion_solped_orden"));
                pmon.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                pmon.setNum_doc_compras(rs.getString("num_doc_compras"));
                pmon.setIndicador_borrado_doc_compras(rs.getString("indicador_borrado_doc_compras"));
                pmon.setTexto_breve(rs.getString("texto_breve"));
                pmon.setCentro(rs.getString("centro"));
                pmon.setAlmacen(rs.getString("almacen"));
                pmon.setNum_contrato_superior(rs.getString("num_contrato_superior"));
                pmon.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
                pmon.setCantidad_pedido(rs.getString("cantidad_pedido"));
                pmon.setUnidad_medida_pedido(rs.getString("unidad_medida_pedido"));
                pmon.setValor_neto_pedido_moneda_pedido(rs.getString("valor_neto_pedido_moneda_pedido"));
                tpn.add(pmon);
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
        return tpn;
    }

    public LinkedList<pp_03_3_notificaciones> TABGRNOTPM_3(String ord) {
        LinkedList<pp_03_3_notificaciones> tpn = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.pp03_3_notificaciones_TABGRNOTPP(?)}";
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, ord);
            rs = pst.executeQuery();
            while (rs.next()) {
                pp_03_3_notificaciones pmon = new pp_03_3_notificaciones();
                pmon.setId_pp3(rs.getInt("id_pm3"));
                pmon.setNum_orden(rs.getString("num_orden"));
                pmon.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                pmon.setNum_doc_compras(rs.getString("num_doc_compras"));
                pmon.setEjercicio_doc_material(rs.getString("ejercicio_doc_material"));
                pmon.setNum_doc_material(rs.getString("num_doc_material"));
                pmon.setPosicion_doc_material(rs.getString("posicion_doc_material"));
                pmon.setTipo_historial_pedido(rs.getString("tipo_historial_pedido"));
                pmon.setClase_movimiento_gestion_stock(rs.getString("clase_movimiento_gestion_stock"));
                pmon.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
                pmon.setCantidad(rs.getString("cantidad"));
                pmon.setImporte_moneda_doc(rs.getString("importe_moneda_doc"));
                pmon.setClave_moneda(rs.getString("clave_moneda"));
                pmon.setResponsable_anadio_objeto(rs.getString("responsable_anadio_objeto"));
                tpn.add(pmon);
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
        return tpn;
    }
    
    public boolean PONACACNOTPP(String dutr ,String nuOrd){
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PP.pp_operaciones_notificaciones_ActTiemNotPP(?,?)}";
        int can;
        try{
           pst = conn.prepareStatement(query);
           pst.setString(1, dutr);
           pst .setString(2, nuOrd);
           can = pst.executeUpdate();
           if(can > 0){
               return true;
           }
        }
        catch(Exception e){
            System.err.println("Error: "+e);
        }
        finally{
            try{
            if(conn != null){con.CerrarConexion(conn);}
            if(pst != null){pst.close();}
            }
            catch(Exception e){
                System.err.println("Error: "+e);
            }
        }
        return false;
    }

}