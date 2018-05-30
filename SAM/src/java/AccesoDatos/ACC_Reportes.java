/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.CabMovNotificaciones;
import Entidades.PosNotTiempo;
import Entidades.Repo_solped;
import Entidades.ReporteActividadesAvisos;
import Entidades.ReporteAvisos;
import Entidades.ReporteContadorEquipos;
import Entidades.ReporteMovimientos;
import Entidades.ReporteMovimientosIvent;
import Entidades.MovNotificaciones;
import Entidades.PosNotifTiempoOrdenes;
import Entidades.ReporteNotificaciones;
import Entidades.ReporteOrdenes;
import Entidades.ReporteSolPed;
import Entidades.Reportes;
import Entidades.almacenes;
import Entidades.StatusOrdPP;
/*Reportes entradas*/
import Entidades.reportes_entradas;
/*----------------*/
 /*Reportes Reservas*/
import Entidades.reportes_reservas;
/*----------------*/
import Entidades.aviso;
import Entidades.centros;
import Entidades.reporte_dms;
import Entidades.reporte_ivent;
import Entidades.reporte_lotes_inspeccion_pm;

/*Reportes Consumos*/
import Entidades.reportes_consumos;
/*----------------*/
 /*Reportes Estatus Ordenes*/
import Entidades.reportes_estatus_ordenes;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.sql.Connection;
import java.util.HashSet;

/**
 *
 */
public class ACC_Reportes extends Conexion {

    Conexion cnx = new Conexion();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_Reportes Instance = null;

    public static ACC_Reportes ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Reportes();
        }
        return Instance;
    }
////////////////  REPORTE SOLICITUDES DE PEDIDO ///////////////////////////////

    public ArrayList<Reportes> MCFolioSAMSolped() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Reportes> fm = new ArrayList<>();
        String sql = "{call MM.ReporteSolped_CargarFolioSAM}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reportes s = new Reportes();
                s.setFoliosam(rs.getString("folio_sam"));
                fm.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en MCFolioSAMSolped, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fm;
    }

    public ArrayList<Reportes> MCFolioSAPSolped() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Reportes> fm = new ArrayList<>();
        String sql = "{call MM.ReporteSolped_CargarFolioSAP}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reportes s = new Reportes();
                s.setFoliosap(rs.getString("folio_sap"));
                fm.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en MCFolioSAPSolped, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fm;
    }

    public int ReporteSolpedValidarSAM(String sam) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteSolped_ValidarSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sam);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteSolpedValidarSAM, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ReporteSolpedValidarSAP(String sap) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteSolped_ValidarSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sap);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteSolpedValidarSAP, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ReporteSolpedValidarQuerySAMCrea(String data[]) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int ban = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteSolped_CargarDatosSolped_crea(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);/// radio
            ps.setString(2, data[1]);/// centro
            ps.setString(3, data[2]);/// folio sam 
            ps.setString(4, data[3]);/// folio sam2
            ps.setString(5, data[6]);/// fecha
            ps.setString(6, data[7]);/// fecha
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteSolpedValidarQuerySAMCrea, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ReporteSolpedValidarTabla1(String data[]) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ban = 0;
        String sql = "{call MM.ReporteSolped_CargarTabla(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);/// radio
            ps.setString(2, data[1]);/// centro
            ps.setString(3, data[2]);/// folio sam 
            ps.setString(4, data[3]);/// folio sam2
            ps.setString(5, data[4]);/// folio sap1
            ps.setString(6, data[5]);/// folio sap2
            ps.setString(7, data[6]);/// fecha
            ps.setString(8, data[7]);/// fecha
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteSolpedValidarTabla1, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ReporteSolpedValidarTabla2(String data[]) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ban = 0;
        String sql = "{call MM.ReporteSolped_CargarTabla2(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);/// radio
            ps.setString(2, data[1]);/// centro
            ps.setString(3, data[2]);/// folio sam 
            ps.setString(4, data[3]);/// folio sam2
            ps.setString(5, data[4]);/// folio sap1
            ps.setString(6, data[5]);/// folio sap2
            ps.setString(7, data[6]);/// fecha
            ps.setString(8, data[7]);/// fecha
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteSolpedValidarTabla2, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<Repo_solped> ReporteSolpedCargarTabla1(String data[]) {
        ArrayList<Repo_solped> rep = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteSolped_CargarTabla(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);/// radio
            ps.setString(2, data[1]);/// centro
            ps.setString(3, data[2]);/// folio sam 
            ps.setString(4, data[3]);/// folio sam2
            ps.setString(5, data[4]);/// folio sap1
            ps.setString(6, data[5]);/// folio sap2
            ps.setString(7, data[6]);/// fecha
            ps.setString(8, data[7]);/// fecha
            rs = ps.executeQuery();
            while (rs.next()) {
                Repo_solped r = new Repo_solped();
                r.setFolio_sap(rs.getString("folio_sap"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setFecha(rs.getString("fecha"));
                r.setCentro(rs.getString("centro"));
                r.setRecibido(rs.getString("recibido"));
                r.setProcesado(rs.getString("procesado"));
                r.setError(rs.getString("error"));
                rep.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteSolpedCargarTabla1, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rep;
    }

    public ArrayList<Repo_solped> ReporteSolped_CargarTabla2(String data[]) {
        ArrayList<Repo_solped> rep = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteSolped_CargarTabla2(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);/// radio
            ps.setString(2, data[1]);/// centro
            ps.setString(3, data[2]);/// folio sam 
            ps.setString(4, data[3]);/// folio sam2
            ps.setString(5, data[4]);/// folio sap1
            ps.setString(6, data[5]);/// folio sap2
            ps.setString(7, data[6]);/// fecha
            ps.setString(8, data[7]);/// fecha
            rs = ps.executeQuery();
            while (rs.next()) {
                Repo_solped r = new Repo_solped();
                r.setFolio_sap(rs.getString("num_solped"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setFecha(rs.getString("fecha"));
                r.setCentro(rs.getString("centro"));
                r.setRecibido(rs.getString("recibido"));
                r.setProcesado(rs.getString("procesado"));
                r.setError(rs.getString("error"));
                rep.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteSolped_CargarTabla2, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rep;
    }

    public ArrayList<Repo_solped> ReporteSolpedCargarTablaSAMCrea(String data[]) {
        ArrayList<Repo_solped> rep = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteSolped_CargarDatosSolped_crea(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);/// radio
            ps.setString(2, data[1]);/// centro
            ps.setString(3, data[2]);/// folio sam 
            ps.setString(4, data[3]);/// folio sam2
            ps.setString(5, data[6]);/// fecha
            ps.setString(6, data[7]);/// fecha
            rs = ps.executeQuery();
            while (rs.next()) {
                Repo_solped r = new Repo_solped();
                r.setFolio_sap(rs.getString("num_solped"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setFecha(rs.getString("fecha"));
                r.setCentro(rs.getString("centro"));
                r.setRecibido(rs.getString("recibido"));
                r.setProcesado(rs.getString("procesado"));
                r.setError(rs.getString("error"));
                rep.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteSolpedCargarTablaSAMCrea, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rep;
    }

    //////////////////////////////////////////////////////////////////////////
    ///////////////// Reporte Movimientos (((((((((((((((((((((((((((((((((((/
    public ArrayList<ReporteMovimientos> MCFolioSAMMovimientos() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ReporteMovimientos> fm = new ArrayList<>();
        String sql = "{call MM.ReporteMovimientos_CargarFolioSAM}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteMovimientos r = new ReporteMovimientos();
                r.setFolio_sam(rs.getString("folio_sam"));
                fm.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en MCFolioSAMMovimientos, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fm;
    }

    public ArrayList<ReporteMovimientos> MCFolioSAPMovimientos() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ReporteMovimientos> fm = new ArrayList<>();
        String sql = "{call MM.ReporteMovimientos_CargarFolioSAP}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteMovimientos r = new ReporteMovimientos();
                r.setNum_doc_materila(rs.getString("num_doc_materila"));
                fm.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en MCFolioSAPMovimientos, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fm;
    }

    public int ReporteMovimientosValidarSAM(String sam) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteMovimientos_ValidarFolioSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sam);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteMovimientosValidarSAM, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ReporteMovimientosValidarSAP(String sap) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteMovimientos_ValidarFolioSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sap);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteMovimientosValidarSAP, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<ReporteMovimientos> ValidaCargaQueryMovimientos(String d[]) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<ReporteMovimientos> rm = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call  MM.ReporteMovimientos_ValidaCargaReporteMov(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            ps.setString(7, d[6]);
            ps.setString(8, d[7]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteMovimientos r = new ReporteMovimientos();
                r.setCentro(rs.getString("centro"));
                r.setNum_doc_materila(rs.getString("num_doc_materila"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setFecha(rs.getString("fecha"));
                r.setHora_dia(rs.getString("hora_dia"));
                r.setRecibido(rs.getString("recibido"));
                r.setProcesado(rs.getString("procesado"));
                r.setError(rs.getString("error"));
                rm.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en ValidaCargaQueryMovimientos, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rm;
    }

    ////////////////////// Reportes Ivent /////////////////////////////////////
    public ArrayList<ReporteMovimientosIvent> MCReportevent_CargarMateriales() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ReporteMovimientosIvent> fm = new ArrayList<>();
        String sql = "{call MM.ReporteIvent_CargarMaterial}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteMovimientosIvent r = new ReporteMovimientosIvent();
                r.setMaterial(rs.getString("material"));
                fm.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en MCReportevent_CargarMateriales, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fm;
    }

    public ArrayList<ReporteMovimientosIvent> MCReportevent_CargarAlamcen() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ReporteMovimientosIvent> fm = new ArrayList<>();
        String sql = "{call MM.ReporteIvent_CargarAlamcen}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteMovimientosIvent r = new ReporteMovimientosIvent();
                r.setAlmacen(rs.getString("almacen"));
                fm.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en MCReportevent_CargarAlamcen, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fm;
    }

    public int ReporteMovimientosIvent_ValidarMaterial(String mat) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteIvent_ValidarMatIvent(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteMovimientosIvent_ValidarMaterial, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ReporteMovimientosIvent_ValidarAlamcen(String alm) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteIvent_ValidarAlmacIvent(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, alm);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteMovimientosIvent_ValidarAlamcen, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<ReporteMovimientosIvent> ReporteMovimientosIvent_CargaValidaIvent(String mat, String alm, String f1, String f2, String rad) {
        ArrayList<ReporteMovimientosIvent> iv = new ArrayList<ReporteMovimientosIvent>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteIvent_CargarIvent(?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ps.setString(2, alm);
            ps.setString(3, f1);
            ps.setString(4, f2);
            ps.setString(5, rad);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteMovimientosIvent r = new ReporteMovimientosIvent();
                r.setFolio(rs.getString("folio"));
                r.setPosicion(rs.getString("posicion"));
                r.setMaterial(rs.getString("material"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setCantidad(rs.getString("cantidad"));
                r.setAlmacen(rs.getString("almacen"));
                r.setFecha(rs.getString("fecha"));
                r.setMensaje(rs.getString("mensaje"));
                r.setInd_mov(rs.getString("ind_movi"));
                iv.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en ReporteMovimientosIvent_CargaValidaIvent, ACC_Reportes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return iv;
    }

    //////////////////////////////////////////////////////////////////////////
    public ArrayList<Repo_solped> MM_RepoSolpedTodos(String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2, String usuario, String alma, String mate, String pos, String inpu) {
        ArrayList<Repo_solped> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Reporte_SolpedstatusTodos(?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, centros);
            pst.setString(2, foliosam);
            pst.setString(3, foliosam2);
            pst.setString(4, foliosap);
            pst.setString(5, foliosap2);
            pst.setString(6, fe1);
            pst.setString(7, fe2);
            pst.setString(8, usuario);
            pst.setString(9, alma);
            pst.setString(10, mate);
            pst.setString(11, pos);
            pst.setString(12, inpu);
            rs = pst.executeQuery();
            while (rs.next()) {
                Repo_solped equipo = new Repo_solped();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha_solicitud(rs.getString("fecha_solicitud"));
                equipo.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                equipo.setTipo_imputacion(rs.getString("tipo_imputacion"));
                equipo.setNum_material(rs.getString("num_material"));
                equipo.setTexto_breve_material(rs.getString("texto_breve_material"));
                equipo.setCantidad_solped(rs.getString("cantidad_solped"));
                equipo.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                equipo.setCentro(rs.getString("centro"));
                equipo.setAlmacen(rs.getString("almacen"));
                equipo.setNombre_solicitante(rs.getString("nombre_solicitante"));
                equipo.setFecha_liberacion_solped(rs.getString("fecha_liberacion_solped"));
                equipo.setIndicador_liberacion(rs.getString("indicador_liberacion"));
                equipo.setDenominacion_codigo_liberacion(rs.getString("denominacion_codigo_liberacion"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                equipo.setNum_pedido(rs.getString("num_pedido"));
                equipo.setFecha_creacion_doc_mod(rs.getString("fecha_creacion_doc_mod"));
                equipo.setIndicador_liberacion_doc_compras(rs.getString("indicador_liberacion_doc_compras"));
                sp_solped.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteContadorEquipos> PM_Reporte_ContadorEquiposTodos(String valo, String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Reporte_ContadoresEquipos(?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valo);
            pst.setString(2, centros);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<reportes_estatus_ordenes> PM_Reporte_StatusTodos(String valo, String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<reportes_estatus_ordenes> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.Reporte_StatusOrdenesTodos(?,?,?,?,?,?,?,?)}");
            pst.setString(1, valo);
            pst.setString(2, centros);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_todos.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_todos;
    }

    //Consulta Todos Mov Notificaciones
    public ArrayList<PosNotTiempo> PP_Reporte_StatusTodosMN(String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<PosNotTiempo> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.Reporte_MovNotTodos(?,?,?,?,?,?,?)}");
            pst.setString(1, centros);
            pst.setString(2, foliosam);
            pst.setString(3, foliosam2);
            pst.setString(4, foliosap);
            pst.setString(5, foliosap2);
            pst.setString(6, fe1);
            pst.setString(7, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                PosNotTiempo or = new PosNotTiempo();
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setHora_inicio(rs.getString("hora_inicio"));
                or.setFecha_inicio(rs.getString("fecha_inicio"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setMaterial(rs.getString("material"));
                or.setCentro(rs.getString("centro"));
//                or.setAlmacen(rs.getString("almacen"));
                or.setMensaje(rs.getString("mensaje"));
                or.setNum_personal(rs.getString("num_personal"));
                sp_todos.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_todos;
    }

    //Consulta Todos Status Ordenes PP
    public ArrayList<StatusOrdPP> PP_Reporte_StatusTodosSO(String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<StatusOrdPP> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.Reporte_StatusOrdenesPPTodos(?,?,?,?,?,?,?)}");
            pst.setString(1, centros);
            pst.setString(2, foliosam);
            pst.setString(3, foliosam2);
            pst.setString(4, foliosap);
            pst.setString(5, foliosap2);
            pst.setString(6, fe1);
            pst.setString(7, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                StatusOrdPP or = new StatusOrdPP();
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_serv(rs.getString("fecha_serv"));
                or.setHora_serv(rs.getString("hora_serv"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setCentro(rs.getString("centro"));
                or.setTxt_mensaje(rs.getString("txt_mensaje"));
                or.setUsuario(rs.getString("usuario"));
                sp_todos.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_todos;
    }

    public ArrayList<reportes_reservas> MM_Reporte_ReservasValidarQuery(String valo, String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<reportes_reservas> sp_centroRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.Reporte_ReservasTodos(?,?,?,?,?,?,?,?)}");
            pst.setString(1, valo);
            pst.setString(2, centros);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas rap = new reportes_reservas();
                rap.setFolio_sap(rs.getString("folio_sap"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro"));
                sp_centroRes.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centroRes;
    }

    public ArrayList<ReporteSolPed> MM_ReporteSolpedValidarQuery(String valo, String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Reporte_SolpedValidarQuery(?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valo);
            pst.setString(2, centros);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public LinkedList<ReporteAvisos> ConsultaVacia(String query) {
        LinkedList<ReporteAvisos> reporteavisos = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteAvisos repavi = new ReporteAvisos();
                repavi.setNum_notificacion(rs.getString("num_notificacion"));
                repavi.setFolio_sam(rs.getString("folio_sam"));
                repavi.setHora_dia(rs.getString("hora_dia"));
                repavi.setFecha(rs.getString("fecha"));
                repavi.setRecibido(rs.getString("recibido"));
                repavi.setProcesado(rs.getString("procesado"));
                repavi.setError(rs.getString("error"));
                repavi.setCentro(rs.getString("centro_planificacion_mante"));
                reporteavisos.add(repavi);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return reporteavisos;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENES(String valor, String centro) {
        ArrayList<ReporteOrdenes> sp_centro = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdCentroT(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_centro.add(ro);

            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones" + a);
            }
        }
        return sp_centro;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESVA(String valor) {
        ArrayList<ReporteOrdenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdCentroVacio(?)}");
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_vacio.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESSAMDOS(String valor, String sam, String sam2) {
        ArrayList<ReporteOrdenes> sp_dosSAM = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdCentroRangosSAM(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_dosSAM.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_dosSAM;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESSAMDER(String valor, String sam2, String sap, String fecha1, String centro) {
        ArrayList<ReporteOrdenes> sp_SAMDER = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdCentroSAMDER(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam2);
            pst.setString(3, sap);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAMDER.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAMDER;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESSAMIZQ(String valor, String sam, String sap, String fecha1, String centro) {
        ArrayList<ReporteOrdenes> sp_SAMIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdCentroSAMIZQ(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam);
            pst.setString(3, sap);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAMIZQ.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAMIZQ;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESSAPDER(String valor, String sap2, String sam, String fecha1, String centro) {
        ArrayList<ReporteOrdenes> sp_SAPDER = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdSAPDER(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap2);
            pst.setString(3, sam);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAPDER.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPDER;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESSAPIZQ(String valor, String sap, String sam, String fecha1, String centro) {
        ArrayList<ReporteOrdenes> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdSAPIZQ(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap);
            pst.setString(3, sam);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAPIZQ.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESSAPDOS(String valor, String sap, String sap2, String sam, String fecha1, String centro) {
        ArrayList<ReporteOrdenes> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdSAPDOS(?,?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap);
            pst.setString(3, sap2);
            pst.setString(4, sam);
            pst.setString(5, fecha1);
            pst.setString(6, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAPIZQ.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESFEIZQ(String valor, String fecha1, String sap, String sam, String centro) {
        ArrayList<ReporteOrdenes> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdFECIZQ(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, sap);
            pst.setString(4, sam);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAPIZQ.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESFEDER(String valor, String fecha2, String sap, String sam, String centro) {
        ArrayList<ReporteOrdenes> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdFECDER(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha2);
            pst.setString(3, sap);
            pst.setString(4, sam);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAPIZQ.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    public ArrayList<ReporteOrdenes> SP_RORDENESFEDOS(String valor, String fecha1, String fecha2, String sap, String sam, String centro) {
        ArrayList<ReporteOrdenes> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdFECDOS(?,?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            pst.setString(4, sap);
            pst.setString(5, sam);
            pst.setString(6, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAPIZQ.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    //Reporte Avisos Consulta Vacia
    public ArrayList<ReporteAvisos> SP_RAVISOSVA(String valor) {
        ArrayList<ReporteAvisos> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repAvCentroVacio(?)}");
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_vacio.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    //Reporte Avisos Consulta SAM Derecha
    public ArrayList<ReporteAvisos> SP_RAVISOSSAMDER(String valor, String sam2, String sap, String fecha1, String centro) {
        ArrayList<ReporteAvisos> sp_SAMDER = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvCentroSAMDER(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam2);
            pst.setString(3, sap);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_SAMDER.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAMDER;
    }

    // Reporte Avisos Consulta SAM Izquierda
    public ArrayList<ReporteAvisos> SP_RAVISOSSAMIZQ(String valor, String sam, String sap, String fecha1, String centro) {
        ArrayList<ReporteAvisos> sp_SAMIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvSAMIZQ(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam);
            pst.setString(3, sap);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_SAMIZQ.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAMIZQ;
    }

    // Reporte Avisos Consulta SAM DOS
    public ArrayList<ReporteAvisos> SP_RAVISOSSAMDOS(String valor, String sam, String sam2) {
        ArrayList<ReporteAvisos> sp_dosSAM = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvRangosSAM(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_dosSAM.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_dosSAM;
    }

    //Reporte Avisos Consulta SAP Derecha
    public ArrayList<ReporteAvisos> SP_RAVISOSSAPDER(String valor, String sap2, String sam, String fecha1, String centro) {
        ArrayList<ReporteAvisos> sp_SAPDER = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvSAPDER(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap2);
            pst.setString(3, sam);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_SAPDER.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPDER;
    }

    //Reporte Avisos Consulta SAP Izquierda
    public ArrayList<ReporteAvisos> SP_RAVISOSSAPIZQ(String valor, String sap, String sam, String fecha1, String centro) {
        ArrayList<ReporteAvisos> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvSAPIZQ(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap);
            pst.setString(3, sam);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_SAPIZQ.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    //Repprte Avisos Consulta DOS SAP
    public ArrayList<ReporteAvisos> SP_RAVISOSSAPDOS(String valor, String sap, String sap2, String sam, String fecha1, String centro) {
        ArrayList<ReporteAvisos> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvSAPDOS(?,?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap);
            pst.setString(3, sap2);
            pst.setString(4, sam);
            pst.setString(5, fecha1);
            pst.setString(6, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_SAPIZQ.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    //Reporte Avisos Consulta Fecha Izq
    public ArrayList<ReporteAvisos> SP_RAVISOSFEIZQ(String valor, String fecha1) {
        ArrayList<ReporteAvisos> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvFECIZQ(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_SAPIZQ.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    //Reporte Avisos Consulta Fecha Derecha
    public ArrayList<ReporteAvisos> SP_RAVISOSFEDER(String valor, String fecha2) {
        ArrayList<ReporteAvisos> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvFECDER(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_SAPIZQ.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    //Reporte Avisos Consulta Dos Fechas
    public ArrayList<ReporteAvisos> SP_RAVISOSFEDOS(String valor, String fecha1, String fecha2) {
        ArrayList<ReporteAvisos> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvFECDOS(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_SAPIZQ.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    //Reporte Avisos Consulta por Centro
    public ArrayList<ReporteAvisos> SP_RAVISOS(String valor, String centro) {
        ArrayList<ReporteAvisos> sp_centro = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvCentro(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_centro.add(rap);

            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centro;
    }

    public LinkedList<ReporteMovimientos> ConsultasMovimientos(String query) {
        LinkedList<ReporteMovimientos> reportemovimientos = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteMovimientos repmov = new ReporteMovimientos();
                repmov.setFolio_sam(rs.getString("folio_sam"));
                repmov.setHora_dia(rs.getString("hora_dia"));
                repmov.setFecha(rs.getString("fecha"));
                repmov.setNum_doc(rs.getString("num_doc_materila"));
                repmov.setCentro(rs.getString("centro"));
                repmov.setAlmacen(rs.getString("almacen"));
                repmov.setIndicador_una_posicion(rs.getString("indicador_posicion"));
                repmov.setCampo1(rs.getString("texto"));
                repmov.setCampo2(rs.getString("texto_cabecera"));
                repmov.setIndicador_posicion(rs.getString("poscion"));
                repmov.setAlmacen_receptor(rs.getString("almacen_receptor_emisor"));
                repmov.setCampo3(rs.getString("factura"));
                repmov.setCampo4(rs.getString("campo_usuario_cluster"));
                repmov.setNum_nota_entrada(rs.getString("num_nota_entrega_externa"));
                repmov.setNum_unidad_almacen(rs.getString("num_unidad_almacen"));
                repmov.setRecibido(rs.getString("recibido"));
                repmov.setProcesado(rs.getString("procesado"));
                repmov.setError(rs.getString("error"));
                reportemovimientos.add(repmov);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return reportemovimientos;
    }

    public LinkedList<ReporteNotificaciones> ConsultasNotificaciones(String query) {
        LinkedList<ReporteNotificaciones> reportenotificaciones = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteNotificaciones repnot = new ReporteNotificaciones();
                repnot.setFolio_sam(rs.getString("folio_sam"));
                repnot.setNum_operacion(rs.getString("num_operacion"));
                repnot.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                repnot.setNum_orden(rs.getString("num_orden"));
                repnot.setCentro(rs.getString("centro"));
                repnot.setContador_notificacion(rs.getString("contador_notificacion"));
                repnot.setHora_dia(rs.getString("hora_dia"));
                repnot.setFecha(rs.getString("fecha"));
                repnot.setRecibido(rs.getString("recibido"));
                repnot.setProcesado(rs.getString("procesado"));
                repnot.setError(rs.getString("error"));
                reportenotificaciones.add(repnot);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return reportenotificaciones;
    }

    public LinkedList<ReporteSolPed> ConsultasSolPed(String query) {
        LinkedList<ReporteSolPed> reportesolped = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteSolPed repsol = new ReporteSolPed();
                repsol.setNum_solped(rs.getString("folio_sap"));
                repsol.setFolio_sam(rs.getString("folio_sam"));
                repsol.setHora_dia(rs.getString("hora_dia"));
                repsol.setFecha(rs.getString("fecha"));
                repsol.setRecibido(rs.getString("recibido"));
                repsol.setProcesado(rs.getString("procesado"));
                repsol.setError(rs.getString("error"));
                repsol.setCentro(rs.getString("centro"));
                reportesolped.add(repsol);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return reportesolped;
    }

    public LinkedList<ReporteSolPed> ConsultasSolPedCrea(String query) {
        LinkedList<ReporteSolPed> reportesolped = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteSolPed repsol = new ReporteSolPed();
                repsol.setNum_solped(rs.getString("num_solped"));
                repsol.setFolio_sam(rs.getString("folio_sam"));
                repsol.setHora_dia(rs.getString("hora_dia"));
                repsol.setFecha(rs.getString("fecha"));
                repsol.setRecibido(rs.getString("recibido"));
                repsol.setProcesado(rs.getString("procesado"));
                repsol.setError(rs.getString("error"));
                repsol.setCentro(rs.getString("centro"));
                reportesolped.add(repsol);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return reportesolped;
    }

    public LinkedList<ReporteOrdenes> ConsultasOrdenes(String query) {
        LinkedList<ReporteOrdenes> reporteordenes = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteOrdenes repord = new ReporteOrdenes();
                repord.setFolio_sam(rs.getString("folio_sam"));
                repord.setNum_orden(rs.getString("num_orden"));
                repord.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                repord.setHora_dia(rs.getString("hora_dia"));
                repord.setFecha(rs.getString("fecha"));
                repord.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                repord.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                repord.setClase_orden(rs.getString("clase_orden"));
                repord.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                repord.setTexto_breve(rs.getString("texto_breve"));
                repord.setNum_equipo(rs.getString("num_equipo"));
                repord.setRecibido(rs.getString("recibido"));
                repord.setProcesado(rs.getString("procesado"));
                repord.setError(rs.getString("error"));
                reporteordenes.add(repord);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return reporteordenes;
    }

    /*[REPORTES ENTRADAS] busqueda por datos vacios*/
    public LinkedList<reportes_entradas> ConsultaEntradaVacia(String query) {
        LinkedList<reportes_entradas> en = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_entradas re = new reportes_entradas();
                re.setNum_doc_compras(rs.getString("num_doc_compras"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setHora_dia(rs.getString("hora_dia"));
                re.setFecha(rs.getString("fecha"));
                re.setRecibido(rs.getString("recibido"));
                re.setProcesado(rs.getString("procesado"));
                re.setError(rs.getString("error"));
                re.setCentro(rs.getString("centro"));
                en.add(re);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaEntradaVacia por:" + ex);
        }
        return en;
    }

    /*---------------------------------------------*/
 /*[REPORTES RESERVAS] busqueda de Datos*/
    public LinkedList<reportes_reservas> ConsultaReservas(String query) {
        LinkedList<reportes_reservas> rr = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_reservas res = new reportes_reservas();
                res.setFolio_sap(rs.getString("folio_sap"));
                res.setFolio_sam(rs.getString("folio_sam"));
                res.setHora_dia(rs.getString("hora_dia"));
                res.setFecha(rs.getString("fecha"));
                res.setRecibido(rs.getString("recibido"));
                res.setProcesado(rs.getString("procesado"));
                res.setError(rs.getString("error"));
                res.setCentro(rs.getString("centro"));
                rr.add(res);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaReservas por:" + ex);
        }
        return rr;
    }

    /*-------------------------------------*/
 /*[ReportesReservas] Consulta folio SAM*/
    public LinkedList<reportes_reservas> SAMreservas(String query) {
        LinkedList<reportes_reservas> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_reservas rr = new reportes_reservas();
                rr.setFolio_sam(rs.getString("folio_sam"));
                sam.add(rr);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAMreservas por:" + ex);
        }
        return sam;
    }

    /*-------------------------------------*/
 /*[ReportesReservas] Consulta folio SAP*/
    public LinkedList<reportes_reservas> SAPreservas(String query) {
        LinkedList<reportes_reservas> sap = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_reservas rr = new reportes_reservas();
                rr.setFolio_sap(rs.getString("folio_sap"));
                sap.add(rr);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metedo SAPreservas por: " + ex);
        }
        return sap;
    }

    /*-------------------------------------*/
 /*[ReportesEntradas] Consulta folio SAM*/
    public LinkedList<reportes_entradas> SAMentradas(String query) {
        LinkedList<reportes_entradas> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_entradas re = new reportes_entradas();
                re.setFolio_sam(rs.getString("folio_sam"));
                sam.add(re);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAMreservas por:" + ex);
        }
        return sam;
    }

    /*-------------------------------------*/
 /*[ReportesEntradas] Consulta folio SAP*/
    public LinkedList<reportes_entradas> SAPentradas(String query) {
        LinkedList<reportes_entradas> sap = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_entradas re = new reportes_entradas();
                re.setFolio_sap(rs.getString("folio_sap"));
                sap.add(re);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metedo SAPreservas por: " + ex);
        }
        return sap;
    }

    /*-------------------------------------*/
 /*[ReportesNotificaciones] Consulta folio SAM*/
    public LinkedList<ReporteNotificaciones> SAMnotificaciones(String query) {
        LinkedList<ReporteNotificaciones> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteNotificaciones re = new ReporteNotificaciones();
                re.setFolio_sam(rs.getString("folio_sam"));
                sam.add(re);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAMnotificaciones por: " + ex);
        }
        return sam;
    }

    /*-------------------------------------------*/
 /*[ReportesNotificaciones] Consulta folio SAP*/
    public LinkedList<ReporteNotificaciones> SAPnotificaciones(String query) {
        LinkedList<ReporteNotificaciones> sap = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteNotificaciones rn = new ReporteNotificaciones();
                rn.setContador_notificacion(rs.getString("contador_notificacion"));
                sap.add(rn);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAPnotificaciones por:" + ex);
        }
        return sap;
    }

    /*[ReportesOrdenes] Consulta folio SAP*/
    //Consulta Folio SAM 
    public ArrayList<ReporteOrdenes> SAMordenes() {
        ArrayList<ReporteOrdenes> samOrd = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdConsSAM()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes folSam = new ReporteOrdenes();
                folSam.setFolio_sam(rs.getString("folio_sam"));
                samOrd.add(folSam);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return samOrd;
    }

    //Consulta Folio SAP
    public ArrayList<ReporteOrdenes> SAPordenes() {
        ArrayList<ReporteOrdenes> sapOrd = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdConsSAP()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes folSap = new ReporteOrdenes();
                folSap.setNum_orden(rs.getString("num_orden"));
                sapOrd.add(folSap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sapOrd;
    }

    //Reporte Reservas
    // Reporte Reservas Consulta Folio SAM
    public ArrayList<reportes_reservas> SAMreserva() {
        ArrayList<reportes_reservas> samRs = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResConsSAM()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas RepRes = new reportes_reservas();
                RepRes.setFolio_sam(rs.getString("folio_sam"));
                samRs.add(RepRes);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return samRs;
    }

    //Reporte Reservas Consulta Folio SAP
    public ArrayList<reportes_reservas> SAPreserva() {
        ArrayList<reportes_reservas> sapRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResConsSAP()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas RsSap = new reportes_reservas();
                RsSap.setFolio_sap(rs.getString("folio_sap"));
                sapRes.add(RsSap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sapRes;
    }

    /*------------------------------------*/
 /*[ReportesSolped] Consulta folio SAM*/
    public LinkedList<ReporteSolPed> SAMsolped(String query) {
        LinkedList<ReporteSolPed> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteSolPed rsol = new ReporteSolPed();
                rsol.setFolio_sam(rs.getString("folio_sam"));
                sam.add(rsol);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAMsolped por:" + ex);
        }
        return sam;
    }

    /*-----------------------------------*/
 /*[ReportesSolped] Consulta folio SAP*/
    public LinkedList<ReporteSolPed> SAPsolped(String query) {
        LinkedList<ReporteSolPed> sap = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteSolPed rsol = new ReporteSolPed();
                rsol.setNum_solped(rs.getString("num_solped"));
                sap.add(rsol);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAPsolped por: " + ex);
        }
        return sap;
    }

    /*-----------------------------------*/
 /*[ReportesAvisos] Consulta folio SAM*/
    public LinkedList<ReporteAvisos> SAMavisos(String query) {
        LinkedList<ReporteAvisos> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteAvisos ra = new ReporteAvisos();
                ra.setFolio_sam(rs.getString("folio_sam"));
                sam.add(ra);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAMavisos por: " + ex);
        }
        return sam;
    }

    /*-----------------------------------*/
 /*[ReportesAvisos] Consulta folio SAP*/
    public ArrayList<ReporteAvisos> SAMavisos() {
        ArrayList<ReporteAvisos> samAvFS = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repOrdConsSAM()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos folSam = new ReporteAvisos();
                folSam.setFolio_sam(rs.getString("folio_sam"));
                samAvFS.add(folSam);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return samAvFS;
    }

    public ArrayList<ReporteAvisos> SAPavisos() {
        ArrayList<ReporteAvisos> samAvFS = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvConsSAP()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos folSam = new ReporteAvisos();
                folSam.setNum_notificacion(rs.getString("num_notificacion"));
                samAvFS.add(folSam);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return samAvFS;
    }

    /*----------------------------------------*/
 /*[ReportesMovimientos] Consulta folio SAP*/
    public LinkedList<ReporteMovimientos> SAPmovimientos(String query) {
        LinkedList<ReporteMovimientos> sap = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteMovimientos rm = new ReporteMovimientos();
                rm.setNum_doc_materila(rs.getString("num_doc_materila"));
                sap.add(rm);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAPmovimientos por: " + ex);
        }
        return sap;
    }

    /*----------------------------------------*/
 /*[ReportesNotificaciones] Busqueda de datos*/
    public LinkedList<ReporteNotificaciones> ReporteNotificaciones(String query) {
        LinkedList<ReporteNotificaciones> datos = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteNotificaciones rn = new ReporteNotificaciones();
                rn.setFolio_sam(rs.getString("folio_sam"));
                rn.setHora_dia(rs.getString("hora_dia"));
                rn.setContador_notificacion(rs.getString("folio_sap"));
                rn.setFecha(rs.getString("fecha"));
                rn.setCentro(rs.getString("centro"));
                rn.setNum_orden(rs.getString("num_orden"));
                rn.setNum_operacion(rs.getString("num_operacion"));
                rn.setRecibido(rs.getString("recibido"));
                rn.setProcesado(rs.getString("procesado"));
                rn.setError(rs.getString("error"));
                rn.setNotificacion_parcial_final(rs.getString("notificacion_parcial_final"));
                datos.add(rn);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ReporteNotificaciones por:" + ex);
        }
        return datos;
    }

    /*------------------------------------------*/
 /*[ReportesNotificaciones] Match orden*/
    public LinkedList<ReporteNotificaciones> ORDnotificaciones(String query) {
        LinkedList<ReporteNotificaciones> ord = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteNotificaciones rn = new ReporteNotificaciones();
                rn.setNum_orden(rs.getString("num_orden"));
                ord.add(rn);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ORDnotificaciones por :" + ex);
        }
        return ord;
    }

    /*------------------------------------*/
 /*[ReportesNotificaciones] Match operacion*/
    public LinkedList<ReporteNotificaciones> OPEnotificaciones(String query) {
        LinkedList<ReporteNotificaciones> ope = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteNotificaciones rn = new ReporteNotificaciones();
                rn.setNum_operacion(rs.getString("num_operacion"));
                ope.add(rn);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo OPEnotificaciones por:" + ex);
        }
        return ope;
    }

    /*------------------------------------*/
 /*[Reportes Consumos] Consulta folio SAM*/
    public LinkedList<reportes_consumos> SAMconsumos(String query) {
        LinkedList<reportes_consumos> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_consumos rc = new reportes_consumos();
                rc.setFolio_sam(rs.getString("folio_sam"));
                sam.add(rc);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAMconsumos por: " + ex);
        }
        return sam;
    }

    /*--------------------------------------*/
 /*[Reportes Consumos] Consulta folio SAP*/
    public LinkedList<reportes_consumos> SAPconsumos(String query) {
        LinkedList<reportes_consumos> sap = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_consumos rc = new reportes_consumos();
                rc.setFolio_orden(rs.getString("folio_orden"));
                sap.add(rc);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAPconsumos por:" + ex);
        }
        return sap;
    }

    /*--------------------------------------*/
 /*[Reportes Consumos] Obtener Datos*/
    public LinkedList<reportes_consumos> DATOSConsumos(String query) {
        LinkedList<reportes_consumos> datos = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_consumos rc = new reportes_consumos();
                rc.setId_concab(rs.getInt("id_concab"));
                rc.setFolio_orden(rs.getString("folio_orden"));
                rc.setFolio_sam(rs.getString("folio_sam"));
                rc.setHora_dia(rs.getString("hora_dia"));
                rc.setFecha_dia(rs.getString("fecha_dia"));
                rc.setNum_orden(rs.getString("num_orden"));
                rc.setRecibido(rs.getString("recibido"));
                rc.setProcesado(rs.getString("procesado"));
                rc.setError(rs.getString("error"));
                rc.setCentro(rs.getString("centro"));
                datos.add(rc);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("ERROR en el metodo DATOSConsumos por :" + ex);
        }
        return datos;
    }

    /*---------------------------------*/
 /*[Reportes] validar Datos reportes*/
    public boolean ValidarDatos(String query, String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    //Valida Datos Reporte Ordenes
    public boolean ValidarDatoss(String centro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdValCen(?)}");
            pst.setString(1, centro);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }

    //Validar SAM Reporte Avisos
    public boolean ValidarRAvSAM(String sam) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.RAvisos_repAvValSAM(?)}");
            pst.setString(1, sam);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }

    // Validar SAP Reporte Avisos
    public boolean ValidarRAvSAP(String sap) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repAvValSA(?)}");
            pst.setString(1, sap);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }

    /*----------------------------------------------------------*/
    public boolean ValidarROrSAM(String foliosam) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdValSAM(?)}");
            pst.setString(1, foliosam);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }

    public boolean ValidarROrSAP(String sap) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdValSAP(?)}");
            pst.setString(1, sap);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }

    /*[ReportesNotificaciones] STOREPROCEDURE VALIDAR CENTRO*/
    public boolean ValidarCentroNotificaciones(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteStatusMatchCentro(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo werewerweValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/
 /*[ReportesNotificaciones] STOREPROCEDURE VALIDAR SAM*/
    public boolean ValidarSamNotificaciones(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReportesNotificacionesValidacionSam(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/

 /*[ReportesNotificaciones] STOREPROCEDURE VALIDAR SAP*/
    public boolean ValidarSaPNotificaciones(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Reportes_(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/
 /*[ReportesNotificaciones] STOREPROCEDURE VALIDAR OPERACION*/
    public boolean ValidarOrdenNotificaciones(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReportesNotificacionesValidarOrden(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/
 /*[ReportesNotificaciones] STOREPROCEDURE VALIDAR SAP*/
    public boolean ValidarOperacionNotificaciones(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReportesNotificacionesValidarOperacion(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/
 /*[ReportesMovimientos] STOREPROCEDURE VALIDAR FOLIO SAM*/
    public boolean ValidarSamMovimientos(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteMovimientosValidacionSam(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/
 /*[ReportesMovimientos] STOREPROCEDURE VALIDAR FOLIO SAM*/
    public int ValidarSamEntradas(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int ban = 0;
        String query = "{call MM.ReporteEntradasValidacionSam(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }

        return ban;
    }

    public boolean ValidarSamContador(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteContadorValidacionSam(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean ValidarSapContador(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteContadorValidacionSap(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean ValidarSamConsumos(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteConsumosValidacionSam(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/
 /*[ReportesMovimientos] STOREPROCEDURE VALIDAR FOLIO SAM*/
    public boolean ValidarSapConsumos(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteConsumosValidacionSap(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/
 /*[ReportesMovimientos] STOREPROCEDURE VALIDAR FOLIO SAM*/
    public boolean ValidarSapEntradas(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteEntradasValidacionSap(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/
 /*[ReportesMovimientos] STOREPROCEDURE VALIDAR FOLIO SAP*/
    public boolean ValidarSapMovimientos(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall("{call MM.ReporteMovimientosValidacionSap(?)}");
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    /*----------------------------------------------------------*/

 /*[ReportesMovimientos] STOREPROCEDURE VALIDAR FOLIO SAP*/
    public int ValidarSapklEntradas(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int ban = 0;
        try {
            pst = con.prepareCall("{call MM.ReporteEntradasValidacionSap(?)}");
            pst.setString(1, dato);
            rs = pst.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }

        return ban;
    }

    /*----------------------------------------------------------*/
    public boolean ValidarFOLCREA(String fol_sam) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            String query = "SELECT folio_sam FROM solped_crea WHERE folio_sam = '" + fol_sam + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidadSolpedVis ACC_SolicitudPedidos por " + e.getMessage());
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public boolean ValidarFOLVIS(String fol_vis) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            String query = "SELECT folio_sam FROM reportes_solped WHERE folio_sam = '" + fol_vis + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidadSolpedVis ACC_SolicitudPedidos por " + e.getMessage());
        }
        cnx.CerrarConexion(con);
        return false;
    }

    /*------------------------*/
 /*----------------------------------------------------------*/
 /*--------------------------------------------*/
 /*--------------------------------------------*/
 /*----------------------------------------------------------*/
 /*--------------------------------------------*/
 /*[Reportes Estatus Ordenes] Consulta folio SAM*/
    public ArrayList<centros> CentroStatus() {
        ArrayList<centros> sp_matchCentro = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call PM.ReporteStatusOrdenMatchCentro}";
        ResultSet rs = null;
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                centros centro = new centros();
                centro.setCentro(rs.getString("centro"));
                centro.setDescripcion(rs.getString("descripcion"));
                sp_matchCentro.add(centro);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al traer los datos por: " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_matchCentro;
    }

    /*[Reportes Estatus Ordenes] Consulta folio SAM*/
    public ArrayList<reportes_estatus_ordenes> SAMStatus() {
        ArrayList<reportes_estatus_ordenes> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PM.ReporteStatusOrdenMatchSam}";
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_estatus_ordenes so = new reportes_estatus_ordenes();
                so.setFolio_sam(rs.getString("folio_sam"));
                sam.add(so);
            }
        } catch (Exception ex) {
            System.err.println("ERROR en el metodo SAMStatus por :" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }

    /*[Reportes Mov Not Consulta folio SAM*/
//    public MovNotificaciones SAMStatusMN() {
//        MovNotificaciones so = new MovNotificaciones();
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String query = "{call PM.ReporteMovNotMatchSam}";
//        try {
//            ps = con.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                so.setFolio_sam(rs.getString("folio_sam"));
//            }
//        } catch (Exception ex) {
//            System.err.println("ERROR en el metodo SAMStatus por :" + ex);
//        } finally {
//            cnx.CerrarConexion(con);
//        }
//        return so;
//    }

    /*[Reportes Estatus Ordenes] Consulta folio SAP*/
    public ArrayList<reportes_estatus_ordenes> SAPStatus() {
        ArrayList<reportes_estatus_ordenes> sap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call PM.ReporteStatusOrdenMatchSap}";
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_estatus_ordenes so = new reportes_estatus_ordenes();
                so.setFolio_orden(rs.getString("folio_orden"));
                sap.add(so);
            }
        } catch (Exception ex) {
            System.err.println("ERROR en el metodo SAPStatus por :" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sap;
    }

    /*[Reportes Mov Not Consulta folio SAP*/
    public ArrayList<PosNotTiempo> SAPStatusMN(String folOrd, String CentroOrd, String CtdOrd) {
        ArrayList<PosNotTiempo> sap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ReporteMovNotMatchSap(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, folOrd);
            pst.setString(2, CentroOrd);
            pst.setString(3, CtdOrd);
            rs = pst.executeQuery();
            while (rs.next()) {
                PosNotTiempo so = new PosNotTiempo();
                so.setNum_orden(rs.getString("num_orden"));
                so.setCentro(rs.getString("centro"));
                sap.add(so);
            }
        } catch (Exception ex) {
            System.err.println("ERROR en el metodo SAPStatus por :" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sap;
    }

    /*[Reportes Status Ordenes PP Consulta folio SAP*/
    public ArrayList<StatusOrdPP> SAPStatusOP(String folOrd, String CentroOrd, String CtdOrd) {
        ArrayList<StatusOrdPP> sap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ReporteStatOrdPPMatchSap(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, folOrd);
            pst.setString(2, CentroOrd);
            pst.setString(3, CtdOrd);
            rs = pst.executeQuery();
            while (rs.next()) {
                StatusOrdPP so = new StatusOrdPP();
                so.setNum_orden(rs.getString("num_orden"));
                so.setCentro(rs.getString("centro"));
                sap.add(so);
            }
        } catch (Exception ex) {
            System.err.println("ERROR en el metodo SAPStatus por :" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sap;
    }

    /*[ReportesNotificaciones] STOREPROCEDURE VALIDAR SAM*/
    public boolean ValidarSamStatus(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        boolean ban = false;
        ResultSet rs = null;
        String query = "{call PM.Reportes_ValidarStatusSam(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }
        return ban;
    }

    /*[ReportesMovNotificaciones] STOREPROCEDURE VALIDAR SAM*/
    public boolean ValidarSamStatusMN(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        boolean ban = false;
        ResultSet rs = null;
        String query = "{call PM.ReporteMovNot_ValidarStatusSam(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }
        return ban;
    }

    /*[ReportesStatusOrdenesPP] STOREPROCEDURE VALIDAR SAM*/
    public boolean ValidarSamStatusSO(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        boolean ban = false;
        ResultSet rs = null;
        String query = "{call PM.ReporteStatusOrdPP_ValidarStatusSam(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }
        return ban;
    }

    /*[ReportesNotificaciones] STOREPROCEDURE VALIDAR SAP*/
    public boolean ValidarSaPStatus(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean band = false;
        String query = "{call PM.Reportes_ValidarStatusSap(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                band = true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return band;
    }

    /*[ReportesMovNot] STOREPROCEDURE VALIDAR SAP*/
    public boolean ValidarSaPStatusMN(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean band = false;
        String query = "{call PM.ReporteMovNot_ValidarStatusSap(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                band = true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return band;
    }

    public boolean ValidarSaPStatusSO(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean band = false;
        String query = "{call PM.ReporteStatusOrdPP_ValidarStatusSap(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                band = true;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return band;
    }

    /*[Reportes Status Ordenes] Consulta Datos Vacia*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusVacio(String valor) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenVacio(?)}");
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*[Reportes Status Ordenes] Consulta Datos Centro*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusCentro(String valor, String centro) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenCentro(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*[Reportes Status Ordenes] Consulta Datos SAM*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusSam(String valor, String sam) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenSam(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*[Reportes Status Ordenes] Consulta Datos Sap*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusSap(String valor, String sap) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenSap(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*[Reportes Status Ordenes] Consulta Datos Fecha*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusFecha(String valor, String fecha) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenFecha(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*[Reportes Status Ordenes] Consulta Datos Rango Sam*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusRangoSam(String valor, String sam1, String sam2) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenRangoSam(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*[Reportes Status Ordenes] Consulta Datos  Rango Sap*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusRangoSap(String valor, String sap1, String sap2) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenRangoSap(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap1);
            pst.setString(3, sap2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*[Reportes Status Ordenes] Consulta Datos  Rango fecha*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusRangoFecha(String valor, String fecha1, String fecha2) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenRangoFecha(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    public ArrayList<reportes_estatus_ordenes> StatusOrdenSAMDER(String valor, String sam1, String sap1, String fecha1, String centro) {
        ArrayList<reportes_estatus_ordenes> sp_SAMDER = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenRangoUNOtodo(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sap1);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes ras = new reportes_estatus_ordenes();
                ras.setFolio_orden(rs.getString("folio_orden"));
                ras.setFolio_sam(rs.getString("folio_sam"));
                ras.setFecha_sistema(rs.getString("fecha_sistema"));
                ras.setHora_sistema(rs.getString("hora_sistema"));
                ras.setNum_orden(rs.getString("num_orden"));
                ras.setOperacion_realizada(rs.getString("operacion_realizada"));
                ras.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                ras.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                ras.setTexto_mensaje(rs.getString("texto_mensaje"));
                ras.setCentro(rs.getString("centro"));
                sp_SAMDER.add(ras);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAMDER;
    }

    /*[Reportes Status Ordenes] Consulta Datos  Rango Sap*/
    public ArrayList<reportes_estatus_ordenes> DatosStatusTodos(
            String valor, String sam1, String sap1, String fecha1, String centro) {
        ArrayList<reportes_estatus_ordenes> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteDatos_StatusOrdenRangoTODO(?,?,?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sap1);
            pst.setString(4, fecha1);
            pst.setString(5, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_estatus_ordenes or = new reportes_estatus_ordenes();

                or.setFolio_orden(rs.getString("folio_orden"));
                or.setFolio_sam(rs.getString("folio_sam"));
                or.setFecha_sistema(rs.getString("fecha_sistema"));
                or.setHora_sistema(rs.getString("hora_sistema"));
                or.setNum_orden(rs.getString("num_orden"));
                or.setOperacion_realizada(rs.getString("operacion_realizada"));
                or.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                or.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                or.setTexto_mensaje(rs.getString("texto_mensaje"));
                or.setCentro(rs.getString("centro"));
                sp_vacio.add(or);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*------------------------*/
 /*----------------------------------------------------------*/
 /*--------------------------------------------*/
 /*--------------------------------------------*/
 /*----------------------------------------------------------*/
 /*--------------------------------------------*/
    public LinkedList<reportes_estatus_ordenes> DATOSEstatus(String query) {
        LinkedList<reportes_estatus_ordenes> datos = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reportes_estatus_ordenes so = new reportes_estatus_ordenes();
                so.setId_stat(rs.getInt("id_stat"));
                so.setFolio_orden(rs.getString("folio_orden"));
                so.setFolio_sam(rs.getString("folio_sam"));
                so.setFecha_sistema(rs.getString("fecha_sistema"));
                so.setHora_sistema(rs.getString("hora_sistema"));
                so.setNum_orden(rs.getString("num_orden"));
                so.setOperacion_realizada(rs.getString("operacion_realizada"));
                so.setIndicador_posicion1(rs.getString("indicador_posicion1"));
                so.setIndicador_posicion2(rs.getString("indicador_posicion2"));
                so.setTexto_mensaje(rs.getString("texto_mensaje"));
                so.setCentro(rs.getString("centro"));
                datos.add(so);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("ERROR en el metodo DATOSEstatus por: " + ex);
        }
        return datos;
    }

    public LinkedList<ReporteContadorEquipos> ConsultaContadorEquipos(String query) {
        LinkedList<ReporteContadorEquipos> reporteconteq = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteContadorEquipos conteq = new ReporteContadorEquipos();
                conteq.setAlmacen(rs.getString("almacen"));
                conteq.setCantidad1(rs.getString("cantidad1"));
                conteq.setCantidad2(rs.getString("cantidad2"));
                conteq.setCentro(rs.getString("centro"));
                conteq.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                conteq.setEquipo(rs.getString("equipo"));
                conteq.setError(rs.getString("error"));
                conteq.setFecha(rs.getString("fecha"));
                conteq.setFecha_recibido(rs.getString("fecha_recibido"));
                conteq.setFolio_sam(rs.getString("folio_sam"));
                conteq.setFolio_sap(rs.getString("folio_sap"));
                conteq.setHora_dia(rs.getString("hora_dia"));
                conteq.setHora_recibido(rs.getString("hora_recibido"));
                conteq.setIcono(rs.getString("icono"));
                conteq.setId_rpc(rs.getInt("id_rpc"));
                conteq.setNivel(rs.getString("nivel"));
                conteq.setNum_lote(rs.getString("num_lote"));
                conteq.setNum_material(rs.getString("num_material"));
                conteq.setNum_serie(rs.getString("num_serie"));
                conteq.setProcesado(rs.getString("procesado"));
                conteq.setPunto_medida(rs.getString("punto_medida"));
                conteq.setRecibido(rs.getString("recibido"));
                conteq.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                conteq.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                conteq.setValor_contador(rs.getString("valor_contador"));

                reporteconteq.add(conteq);
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return reporteconteq;
    }

    public LinkedList<ReporteContadorEquipos> SAMContEq(String query) {
        LinkedList<ReporteContadorEquipos> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteContadorEquipos rr = new ReporteContadorEquipos();
                rr.setFolio_sam(rs.getString("folio_sam"));
                sam.add(rr);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
        }
        return sam;
    }

    public LinkedList<ReporteContadorEquipos> SAPContEq(String query) {
        LinkedList<ReporteContadorEquipos> sap = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ReporteContadorEquipos rr = new ReporteContadorEquipos();
                rr.setFolio_sap(rs.getString("folio_sap"));
                sap.add(rr);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo SAMreservas por:" + ex);
        }
        return sap;
    }

    public boolean ValidarAviso(String centros) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT centro FROM centros WHERE centro = '" + centros + "'";
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String a = rs.getString("centro");
                if (centros.equals(a)) {
                    return true;
                } else {
                    return false;
                }
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarAviso por:" + ex);
        }

        return false;
    }

    /*---------------------------------------*/
    public LinkedList<String[]> ConsultaPosiciones(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*REPORTE NOTIFICACIONES CONSULTA VACIA STOREPROCEDURE*/
    public ArrayList<ReporteNotificaciones> SP_RNOTIFICACION(String valor) {
        ArrayList<ReporteNotificaciones> sp_vacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.reportes_NotificacionesVacio(?)}");
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_vacio.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por :" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_vacio;
    }

    /*----------------------------------------------------*/
 /*STOREPROCEDURE REPORTE MOVIMIENTOS CONSULTA VACIA*/
    public ArrayList<ReporteMovimientos> SP_ReporteMovimientosVacia(String valor) {
        ArrayList<ReporteMovimientos> sp_movacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_MovimientosVacio(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movacio.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movacio;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE REPORTE ENTRADAS CONSULTA VACIA*/
    public ArrayList<reportes_entradas> SP_ReporteEntradasVacia(String valor) {
        ArrayList<reportes_entradas> sp_entvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_EntradasVacio(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();
                ent.setNum_doc_compras(rs.getString("num_doc_compras"));
                ent.setFolio_sam(rs.getString("folio_sam"));
                ent.setHora_dia(rs.getString("hora_dia"));
                ent.setFecha(rs.getString("fecha"));
                ent.setRecibido(rs.getString("recibido"));
                ent.setProcesado(rs.getString("procesado"));
                ent.setError(rs.getString("error"));
                ent.setCentro(rs.getString("centro"));
                sp_entvacio.add(ent);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_entvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorVacia(String valor) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorVacio(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorCentro(String valor, String centro) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorCentro(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorRangosSam(String valor, String sam1, String sam2) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorRangosSAM(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorSam(String valor, String sam1) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorSam(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorRangosSAP(String valor, String sap1, String sap2) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorRangosSAP(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap1);
            pst.setString(3, sap2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorSAP(String valor, String sap1) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorSap(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap1);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorRangosFecha(String valor, String fecha1, String fecha2) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorRangosFecha(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorFecha(String valor, String fecha1) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<ReporteContadorEquipos> SP_ReporteContadorTodos(String valor, String sam1, String sam2, String sap1, String sap2, String fecha1, String fecha2, String centro) {
        ArrayList<ReporteContadorEquipos> sp_contadorvacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ContadorFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            pst.setString(4, sap1);
            pst.setString(5, sap2);
            pst.setString(6, fecha1);
            pst.setString(7, fecha2);
            pst.setString(8, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equipo = new ReporteContadorEquipos();
                equipo.setFolio_sam(rs.getString("folio_sam"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setFolio_sap(rs.getString("folio_sap"));
                equipo.setFecha(rs.getString("fecha"));
                equipo.setHora_dia(rs.getString("hora_dia"));
                equipo.setNivel(rs.getString("nivel"));
                equipo.setIcono(rs.getString("icono"));
                equipo.setEquipo(rs.getString("equipo"));
                equipo.setDenominacion_equipo(rs.getString("denominacion_equipo"));
                equipo.setPunto_medida(rs.getString("punto_medida"));
                equipo.setDoc_medicion(rs.getString("doc_medicion"));
                equipo.setCantidad1(rs.getString("cantidad1"));
                equipo.setValor_contador(rs.getString("valor_contador"));
                equipo.setUnidad_medida_entrada_doc(rs.getString("unidad_medida_entrada_doc"));
                equipo.setRecibido(rs.getString("recibido"));
                equipo.setProcesado(rs.getString("procesado"));
                equipo.setError(rs.getString("error"));
                sp_contadorvacio.add(equipo);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contadorvacio;
    }

    public ArrayList<reportes_consumos> SP_ReporteConsumosVacia(String valor) {
        ArrayList<reportes_consumos> sp_convacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_ConsumosVacio(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_convacio.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_convacio;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE REPORTE MOVIMIENTOS CONSULTA CENTRO*/
    public ArrayList<ReporteMovimientos> SP_ReporteMovimientosCentro(String valor, String centro) {
        ArrayList<ReporteMovimientos> sp_movcentro = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_MovimientosCentro(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movcentro.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movcentro;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE REPORTE ENTRADAS CONSULTA CENTRO*/
    public ArrayList<reportes_entradas> SP_ReporteEntradasCentro(String valor, String centro) {
        ArrayList<reportes_entradas> sp_movcentro = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_EntradasCentro(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas mov = new reportes_entradas();
                mov.setNum_doc_compras(rs.getString("num_doc_compras"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movcentro.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movcentro;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE REPORTE ENTRADAS CONSULTA CENTRO*/
    public ArrayList<reportes_consumos> SP_ReporteConsumosCentro(String valor, String centro) {
        ArrayList<reportes_consumos> sp_movcentro = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ConsumosCentro(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_movcentro.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movcentro;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS SAM REPORTE MOVIMIENTOS*/
    public ArrayList<ReporteMovimientos> SP_ReporteMovimientosRangosSam(String valor, String sam1, String sam2) {
        ArrayList<ReporteMovimientos> sp_movrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_MovimientosRangosSAM(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movrangossam.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS SAM REPORTE MOVIMIENTOS*/
    public ArrayList<reportes_entradas> SP_ReporteEnradasRangosSam(String valor, String sam1, String sam2) {
        ArrayList<reportes_entradas> sp_entrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_EntradasRangosSAM(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();

                ent.setNum_doc_compras(rs.getString("num_doc_compras"));
                ent.setFolio_sam(rs.getString("folio_sam"));
                ent.setHora_dia(rs.getString("hora_dia"));
                ent.setFecha(rs.getString("fecha"));
                ent.setRecibido(rs.getString("recibido"));
                ent.setProcesado(rs.getString("procesado"));
                ent.setError(rs.getString("error"));
                ent.setCentro(rs.getString("centro"));
                sp_entrangossam.add(ent);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_entrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS SAM REPORTE MOVIMIENTOS*/
    public ArrayList<reportes_consumos> SP_ReporteConsumosRangosSam(String valor, String sam1, String sam2) {
        ArrayList<reportes_consumos> sp_conrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ComsumosRangosSAM(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_conrangossam.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_conrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS FECHA REPORTE ENTRADAS*/
    public ArrayList<reportes_entradas> SP_ReporteEnradasRangosSap(String valor, String sap1, String sap2) {
        ArrayList<reportes_entradas> sp_entrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_EntradasRangosSAP(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap1);
            pst.setString(3, sap2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();

                ent.setNum_doc_compras(rs.getString("num_doc_compras"));
                ent.setFolio_sam(rs.getString("folio_sam"));
                ent.setHora_dia(rs.getString("hora_dia"));
                ent.setFecha(rs.getString("fecha"));
                ent.setRecibido(rs.getString("recibido"));
                ent.setProcesado(rs.getString("procesado"));
                ent.setError(rs.getString("error"));
                ent.setCentro(rs.getString("centro"));
                sp_entrangossam.add(ent);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_entrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS FECHA REPORTE ENTRADAS*/
    public ArrayList<reportes_consumos> SP_ReporteConsumosRangosSap(String valor, String sap1, String sap2) {
        ArrayList<reportes_consumos> sp_conrangossap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ComsumosRangosSAP(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap1);
            pst.setString(3, sap2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_conrangossap.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_conrangossap;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS FECHA REPORTE CONSUMOS*/
    public ArrayList<reportes_consumos> SP_ReporteConsumosRangosFecha(String valor, String fecha1, String fecha2) {
        ArrayList<reportes_consumos> sp_conrangossap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ConsumosRangosFecha(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_conrangossap.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_conrangossap;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS FECHA REPORTE ENTRADAS*/
    public ArrayList<reportes_entradas> SP_ReporteEnradasRangosFecha(String valor, String fecha1, String fecha2) {
        ArrayList<reportes_entradas> sp_entrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_EntradasRangosFecha(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();

                ent.setNum_doc_compras(rs.getString("num_doc_compras"));
                ent.setFolio_sam(rs.getString("folio_sam"));
                ent.setHora_dia(rs.getString("hora_dia"));
                ent.setFecha(rs.getString("fecha"));
                ent.setRecibido(rs.getString("recibido"));
                ent.setProcesado(rs.getString("procesado"));
                ent.setError(rs.getString("error"));
                ent.setCentro(rs.getString("centro"));
                sp_entrangossam.add(ent);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_entrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA TODOS REPORTE ENTRADAS*/
    public ArrayList<reportes_entradas> SP_ReporteEnradasTodos(String valo, String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<reportes_entradas> sp_entrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Reportes_EntradasValQuery(?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valo);
            pst.setString(2, centros);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();

                ent.setNum_doc_compras(rs.getString("num_doc_compras"));
                ent.setFolio_sam(rs.getString("folio_sam"));
                ent.setHora_dia(rs.getString("hora_dia"));
                ent.setFecha(rs.getString("fecha"));
                ent.setRecibido(rs.getString("recibido"));
                ent.setProcesado(rs.getString("procesado"));
                ent.setError(rs.getString("error"));
                ent.setCentro(rs.getString("centro"));
                sp_entrangossam.add(ent);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_entrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA TODOS REPORTE CONSUMOS*/
    public ArrayList<reportes_consumos> SP_ReporteConsumosTodos(String valor, String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<reportes_consumos> sp_contodos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Reporte_ConsumosTodos(?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centros);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_contodos.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_contodos;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS SAM REPORTE MOVIMIENTOS*/
    public ArrayList<ReporteMovimientos> SP_ReporteEntradasRangosSam(String valor, String sam1, String sam2) {
        ArrayList<ReporteMovimientos> sp_movrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_MovimientosRangosSAM(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movrangossam.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS SAP REPORTE MOVIMIENTOS*/
    public ArrayList<ReporteMovimientos> SP_ReporteMovimientosRangosSap(String valor, String sap1, String sap2) {
        ArrayList<ReporteMovimientos> sp_movrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_MovimientosRangosSAP(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap1);
            pst.setString(3, sap2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movrangossam.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA RANGOS SAP REPORTE MOVIMIENTOS*/
    public ArrayList<ReporteMovimientos> SP_ReporteMovimientosRangosFecha(String valor, String fecha1, String fecha2) {
        ArrayList<ReporteMovimientos> sp_movrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_MovimientosRangosFecha(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movrangossam.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA  SAM REPORTE MOVIMIENTOS*/
    public ArrayList<ReporteMovimientos> SP_ReporteMovimientosSam(String valor, String sam1) {
        ArrayList<ReporteMovimientos> sp_movrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reporte_MovimientosFolioSAM(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movrangossam.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA  SAM REPORTE MOVIMIENTOS*/
    public ArrayList<reportes_entradas> SP_ReporteEntradasSam(String valor, String sam1) {
        ArrayList<reportes_entradas> sp_entsam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_EntradasSam(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();

                ent.setNum_doc_compras(rs.getString("num_doc_compras"));
                ent.setFolio_sam(rs.getString("folio_sam"));
                ent.setHora_dia(rs.getString("hora_dia"));
                ent.setFecha(rs.getString("fecha"));
                ent.setRecibido(rs.getString("recibido"));
                ent.setProcesado(rs.getString("procesado"));
                ent.setError(rs.getString("error"));
                ent.setCentro(rs.getString("centro"));
                sp_entsam.add(ent);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_entsam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA  SAM REPORTE MOVIMIENTOS*/
    public ArrayList<reportes_consumos> SP_ReporteConsumosSam(String valor, String sam1) {
        ArrayList<reportes_consumos> sp_consam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ConsumosSam(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_consam.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_consam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA  SAP REPORTE CONSUMOS*/
    public ArrayList<reportes_consumos> SP_ReporteConsumosSap(String valor, String sap1) {
        ArrayList<reportes_consumos> sp_consam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ConsumosSap(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_consam.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_consam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA FECHA REPORTE CONSUMOS*/
    public ArrayList<reportes_consumos> SP_ReporteConsumosFecha(String valor, String fecha1) {
        ArrayList<reportes_consumos> sp_consam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_ConsumosFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos cons = new reportes_consumos();
                cons.setFolio_orden(rs.getString("folio_orden"));
                cons.setFolio_sam(rs.getString("folio_sam"));
                cons.setHora_dia(rs.getString("hora_dia"));
                cons.setFecha_dia(rs.getString("fecha_dia"));
                cons.setNum_orden(rs.getString("num_orden"));
                cons.setIndi_posicion1(rs.getString("indi_posicion1"));
                cons.setIndi_posicion2(rs.getString("indi_posicion2"));
                cons.setError(rs.getString("error"));
                cons.setCentro(rs.getString("centro"));
                sp_consam.add(cons);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_consam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA  SAP REPORTE ENTRADAS*/
    public ArrayList<reportes_entradas> SP_ReporteEntradasSap(String valor, String sap1) {
        ArrayList<reportes_entradas> sp_entsam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_EntradasSap(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();

                ent.setNum_doc_compras(rs.getString("num_doc_compras"));
                ent.setFolio_sam(rs.getString("folio_sam"));
                ent.setHora_dia(rs.getString("hora_dia"));
                ent.setFecha(rs.getString("fecha"));
                ent.setRecibido(rs.getString("recibido"));
                ent.setProcesado(rs.getString("procesado"));
                ent.setError(rs.getString("error"));
                ent.setCentro(rs.getString("centro"));
                sp_entsam.add(ent);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_entsam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA  SAP REPORTE ENTRADAS*/
    public ArrayList<reportes_entradas> SP_ReporteEntradasFecha(String valor, String fecha1) {
        ArrayList<reportes_entradas> sp_entsam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reportes_EntradasFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();

                ent.setNum_doc_compras(rs.getString("num_doc_compras"));
                ent.setFolio_sam(rs.getString("folio_sam"));
                ent.setHora_dia(rs.getString("hora_dia"));
                ent.setFecha(rs.getString("fecha"));
                ent.setRecibido(rs.getString("recibido"));
                ent.setProcesado(rs.getString("procesado"));
                ent.setError(rs.getString("error"));
                ent.setCentro(rs.getString("centro"));
                sp_entsam.add(ent);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_entsam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA  SAP REPORTE MOVIMIENTOS*/
    public ArrayList<ReporteMovimientos> SP_ReporteMovimientosSap(String valor, String sap) {
        ArrayList<ReporteMovimientos> sp_movrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reporte_MovimientosFolioSAP(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movrangossam.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movrangossam;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA  SAP REPORTE MOVIMIENTOS*/
    public ArrayList<ReporteMovimientos> SP_ReporteMovimientosFecha(String valor, String fecha) {
        ArrayList<ReporteMovimientos> sp_movrangossam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.reporte_MovimientosFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movrangossam.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movrangossam;
    }

    /*-------------------------------------------------*/
 /*REPORTE NOTIFICACIONES CONSULTA POR CENTRO STOREPROCEDURE*/
    public ArrayList<ReporteNotificaciones> PM_SPNotificacionesCentro(String valor, String centro) {
        ArrayList<ReporteNotificaciones> sp_centro = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.reportes_NotificacionesCentro(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_centro.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por: " + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexion por: " + a);
            }
        }
        return sp_centro;
    }

    /*---------------------------------------------------------*/
 /*REPORTE NOTIFICACIONES CONSULTA POR RANGOS FOLIO SAM STOREPROCEDURE*/
    public ArrayList<ReporteNotificaciones> PM_NotificacionesRangosSam(String valor, String sam1, String sam2) {
        ArrayList<ReporteNotificaciones> sp_samrangos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.reportes_NotificacionesRangosSAM(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_samrangos.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos por : " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_samrangos;
    }

    /*-------------------------------------------------------------------*/
 /*REPORTE NOTIFICACIONES CONSULTA POR FOLIO SAM STOREPROCEDURE*/
    public ArrayList<ReporteNotificaciones> PM_NotificacionesFolioSam(String valor, String folio_sam) {
        ArrayList<ReporteNotificaciones> sp_foliosam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.reportes_NotificacionesFolioSAM(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, folio_sam);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_foliosam.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al traer los datos por: " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a :" + b);
            }
        }
        return sp_foliosam;
    }

    /*------------------------------------------------------------*/
 /*REPORTE NOTIFICACIONES CONSULTA POR RANGOS NUMERO DE ORDEN STOREPROCEDURE*/
    public ArrayList<ReporteNotificaciones> PM_NotificacionesRangosOrdenes(String valor, String orden1, String orden2) {
        ArrayList<ReporteNotificaciones> sp_rangosOrdenes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_NotificacionesRangosOrdenes(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, orden1);
            pst.setString(3, orden2);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_rangosOrdenes.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos por :" + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por :" + b);
            }
        }
        return sp_rangosOrdenes;
    }

    /*------------------------------------------------------------------------------*/
 /*REPORTE NOTIFICACIONES CONSULTA POR NUMERO DE ORDEN STOREPROCEDURE*/
    public ArrayList<ReporteNotificaciones> PM_NotificacionesNumeroOrden(String valor, String num_orden) {
        ArrayList<ReporteNotificaciones> sp_numOrden = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_NotificacionesNumeroOrden(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, num_orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_numOrden.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al traer los datos por:" + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }
        return sp_numOrden;
    }

    /*------------------------------------------------------------------*/
 /*METODO GENERAL CONSULTA POR RANGOS STOREPROCEDURE*/
    public ArrayList<ReporteNotificaciones> PM_ReporteRangosNotificaciones(String query, String valor, String rango1, String rango2) {
        ArrayList<ReporteNotificaciones> sp_rangos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, rango1);
            pst.setString(3, rango2);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_rangos.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos por: " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_rangos;
    }

    /*-------------------------------------------------*/
 /*METODO GENERAL CONSULTA POR RANGOS NUMERO DE OPERACION STOREPROCEDURE*/
    public ArrayList<ReporteNotificaciones> PM_ReporteRangosNotificacionesOperacion(String valor, String rango1, String rango2) {
        ArrayList<ReporteNotificaciones> sp_rangos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Reportes_NotificacionesRangosOperacion(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, rango1);
            pst.setString(3, rango2);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_rangos.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos por: " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_rangos;
    }

    /*-------------------------------------------------*/
 /*METODO GENERAL CONSULTA STOREPROCEDURE RANGOS NUMERO DE OPERACION */
    public ArrayList<ReporteNotificaciones> PM_ReporteNotificaciones(String query, String valor, String dato) {
        ArrayList<ReporteNotificaciones> sp_notificacion = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, dato);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_notificacion.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al traer los datos debido a: " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_notificacion;
    }

    /*-------------------------------------------------*/
 /*METODO GENERAL CONSULTA STOREPROCEDURE FOLIO SAP*/
    public ArrayList<ReporteNotificaciones> PM_ReporteNotificacionesFolioSap(String valor, String dato) {
        ArrayList<ReporteNotificaciones> sp_notificacion = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Reportes_NotificacionesFolioSap(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, dato);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_notificacion.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al traer los datos debido a: " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_notificacion;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA A NUMERO DE OPERACION*/
    public ArrayList<ReporteNotificaciones> PM_ReporteNotificacionesNumeroOperacion(String valor, String dato) {
        ArrayList<ReporteNotificaciones> sp_numOpe = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Reportes_NotificacionesNumeroOperacion(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, dato);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_numOpe.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al traer los datos debido a: " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_numOpe;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA A NUMERO DE OPERACION*/
    public ArrayList<ReporteNotificaciones> PM_ReporteNotificacionesNumeroOrden(String valor, String dato) {
        ArrayList<ReporteNotificaciones> sp_numOpe = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.reportes_NotificacionesNumeroOrden(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, dato);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_numOpe.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al traer los datos debido a: " + a);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_numOpe;
    }

    /*-------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAM REPORTE NOTIFICACIONES*/
    public ArrayList<ReporteNotificaciones> PM_MatchNotSam() {
        ArrayList<ReporteNotificaciones> sp_matchSam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteNotificacionesMatchSam}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_matchSam.add(new ReporteNotificaciones(
                        rs.getString("folio_sam")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchSam;
    }

    /*--------------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAM REPORTE NOTIFICACIONES*/
    public ArrayList<ReporteMovimientos> MM_MatchMovSam() {
        ArrayList<ReporteMovimientos> sp_matchMovSam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteMovimientosMatchSam}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos rm = new ReporteMovimientos();
                rm.setFolio_sam(rs.getString("folio_sam"));
                sp_matchMovSam.add(rm);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchMovSam;
    }

    /*--------------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAM REPORTE NOTIFICACIONES*/
    public ArrayList<ReporteMovimientos> MM_MatchMovSap() {
        ArrayList<ReporteMovimientos> sp_matchMovSam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteMovimientosMatchSap}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos rm = new ReporteMovimientos();
                rm.setNum_doc_materila(rs.getString("num_doc_materila"));
                sp_matchMovSam.add(rm);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchMovSam;
    }

    /*--------------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAM REPORTE NOTIFICACIONES*/
    public ArrayList<ReporteNotificaciones> PM_MatchNotOrden() {
        ArrayList<ReporteNotificaciones> sp_matchOrden = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteNotificacionesMatchOrden}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp_matchOrden.add(new ReporteNotificaciones(
                        rs.getString("num_orden")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchOrden;
    }

    /*--------------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAM REPORTE NOTIFICACIONES*/
    public ArrayList<reportes_entradas> MM_MatchEntFolioSam() {
        ArrayList<reportes_entradas> sp_matchSam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call  MM.ReporteEntradasMatchSam}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();
                ent.setFolio_sam(rs.getString("folio_sam"));
                sp_matchSam.add(ent);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchSam;
    }

    /*--------------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAM REPORTE NOTIFICACIONES*/
    public ArrayList<ReporteContadorEquipos> PM_MatchEquiposFolioSam() {
        ArrayList<ReporteContadorEquipos> sp_matchSam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call  PM.ReporteContadorMatchSam}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equi = new ReporteContadorEquipos();
                equi.setFolio_sam(rs.getString("folio_sam"));
                sp_matchSam.add(equi);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchSam;
    }

    /*--------------------------------------------------------*/
    public ArrayList<ReporteContadorEquipos> PM_MatchEquiposFolioSap() {
        ArrayList<ReporteContadorEquipos> sp_matchSap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteContadorMatchSap}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteContadorEquipos equi = new ReporteContadorEquipos();
                equi.setFolio_sap(rs.getString("folio_sap"));
                sp_matchSap.add(equi);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchSap;
    }

    /*--------------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAM REPORTE NOTIFICACIONES*/
    public ArrayList<reportes_consumos> MM_MatchConFolioSam() {
        ArrayList<reportes_consumos> sp_matchSam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call  MM.ReporteConsumosMatchSam}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos ent = new reportes_consumos();
                ent.setFolio_sam(rs.getString("folio_sam"));
                sp_matchSam.add(ent);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchSam;
    }

    /*--------------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAP REPORTE CONSUMOS*/
    public ArrayList<reportes_consumos> MM_MatchConFolioSap() {
        ArrayList<reportes_consumos> sp_matchSap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteConsumosMatchSap}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_consumos ent = new reportes_consumos();
                ent.setFolio_orden(rs.getString("folio_orden"));
                sp_matchSap.add(ent);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchSap;
    }

    /*--------------------------------------------------------*/
 /*STOREPROCEDURE REPORTES MATCH SAP REPORTE ENTRADAS*/
    public ArrayList<reportes_entradas> MM_MatchEntFolioSap() {
        ArrayList<reportes_entradas> sp_matchSap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteEntradasMatchSap}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_entradas ent = new reportes_entradas();
                ent.setFolio_sap(rs.getString("folio_sap"));
                sp_matchSap.add(ent);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_matchSap;
    }

    /*--------------------------------------------------------*/
    public ArrayList<ReporteNotificaciones> PM_MatchReportNotificaciones() {
        ArrayList<ReporteNotificaciones> match = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteNotificacionesMatch}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteNotificaciones r = new ReporteNotificaciones();
                r.setNum_orden(rs.getString("num_orden"));
                r.setFolio_sap(rs.getString("folio_sap"));
                r.setNum_operacion(rs.getString("num_operacion"));
                match.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error match Ubicaciones Tec: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return match;
    }

    /*---------------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA TODOS REPORTES NOTIFICACIONES*/
    public ArrayList<ReporteNotificaciones> PM_ReporteNotificacionesTodos(
            String valor, String sam1, String sam2, String ord1, String ord2, String ope1, String ope2, String sap, String centro) {
        ArrayList<ReporteNotificaciones> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteNotificacionesTodosVacio(?,?,?,?,?,?,?,?,?)}";
        try {

            pst = con.prepareCall("{call M.reportes_ContadorCentro(?,?)}");

            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            pst.setString(4, ord1);
            pst.setString(5, ord2);
            pst.setString(6, ope1);
            pst.setString(7, ope2);
            pst.setString(8, sap);
            pst.setString(9, centro);
            while (rs.next()) {
                sp_todos.add(new ReporteNotificaciones(
                        rs.getString("folio_sam"),
                        rs.getString("hora_dia"),
                        rs.getString("fecha"),
                        rs.getString("folio_sap"),
                        rs.getString("centro"),
                        rs.getString("notificacion_parcial_final"),
                        rs.getString("num_orden"),
                        rs.getString("num_operacion"),
                        rs.getString("recibido"),
                        rs.getString("procesado"),
                        rs.getString("error")
                ));
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos por: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_todos;
    }

    /*-----------------------------------------------------*/
 /*STOREPROCEDURE CONSULTA TODOS REPORTES NOTIFICACIONES*/
    public ArrayList<ReporteMovimientos> PM_ReporteMovimientosTodos(
            String valor, String sam, String sam2, String sap, String sap2, String fecha1, String fecha2, String centro) {
        ArrayList<ReporteMovimientos> sp_tod = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReporteMovimientosTodosVacio(?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam);
            pst.setString(3, sam2);
            pst.setString(4, sap);
            pst.setString(5, sap2);
            pst.setString(6, fecha1);
            pst.setString(7, fecha2);
            pst.setString(8, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mr = new ReporteMovimientos();
                mr.setNum_doc_materila(rs.getString("num_doc_materila"));
                mr.setFolio_sam(rs.getString("folio_sam"));
                mr.setHora_dia(rs.getString("hora_dia"));
                mr.setFecha(rs.getString("fecha"));
                mr.setRecibido(rs.getString("recibido"));
                mr.setProcesado(rs.getString("procesado"));
                mr.setError(rs.getString("error"));
                mr.setCentro(rs.getString("centro"));
                sp_tod.add(mr);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos por: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_tod;
    }

    public ArrayList<ReporteSolPed> sp_solpedmatchsam() {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.SolpedcreaMatchSam}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sam(rs.getString("folio_sam"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_reportesolpedmatchsam() {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedMatchSam}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sam(rs.getString("folio_sam"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_solpedmatchsap() {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedMatchSap}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_matchsolpedcreasap() {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.SolpedCreaMatchSap}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public boolean ValidarSapSolped(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedValidacionSap(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean ValidarSamreporteSolped(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedValidacionSamreporte(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean ValidarSamsolpedcreaSolped(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedValidacionSamsolpedcrea(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedVacio(String valor) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Reportesolpedvacia(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCreaVacio(String valor) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Reportesolpedcreavacia(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCentro(String valor, String centro) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedCentro(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCreaCentro(String valor, String centro) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedCreaCentro(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedRangosSAM(String valor, String sam, String sam2) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedRangosSam(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCreaRangosSAM(String valor, String sam, String sam2) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedCreaRangosSam(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedSAM(String valor, String sam) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedSam(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCreaSAM(String valor, String sam) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedCreaSam(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sam);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedRangosSAP(String valor, String sap, String sap2) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedRangosSap(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap);
            pst.setString(3, sap2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCreaRangosSAP(String valor, String sap, String sap2) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedCreaRangosSap(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap);
            pst.setString(3, sap2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedSAP(String valor, String sap) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedSap(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCreaSAP(String valor, String sap) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedCreaSap(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, sap);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedRangosFecha(String valor, String fecha1, String fecha2) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedRangosFecha(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCreaRangosFecha(String valor, String fecha1, String fecha2) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedCreaRangosFecha(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedFecha(String valor, String fecha1) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setFolio_sap(rs.getString("folio_sap"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    public ArrayList<ReporteSolPed> sp_ConsultaReporteSolpedCreaFecha(String valor, String fecha1) {
        ArrayList<ReporteSolPed> sp_solped = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteSolpedCreaFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed sol = new ReporteSolPed();
                sol.setNum_solped(rs.getString("num_solped"));
                sol.setFolio_sam(rs.getString("folio_sam"));
                sol.setHora_dia(rs.getString("hora_dia"));
                sol.setFecha(rs.getString("fecha"));
                sol.setRecibido(rs.getString("recibido"));
                sol.setProcesado(rs.getString("procesado"));
                sol.setError(rs.getString("error"));
                sol.setCentro(rs.getString("centro"));
                sp_solped.add(sol);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_solped;
    }

    //Validar SAM Reporte Reservas
    public boolean ValidarReResSAM(String sam) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResValSAM(?)}");
            pst.setString(1, sam);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }

    //Validar SAM Reporte Reservas
    public boolean ValidarReResSAP(String sap) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResValSAP(?)}");
            pst.setString(1, sap);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return false;
    }

    //Reporte Reservas Consulta por Centro
    public ArrayList<reportes_reservas> SP_RReservas(String valor, String centro) {
        ArrayList<reportes_reservas> sp_centroRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResCentro(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas rap = new reportes_reservas();
                rap.setFolio_sap(rs.getString("folio_sap"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro"));
                sp_centroRes.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centroRes;
    }

    //Reporte Reservas Consulta por SAM 1
    public ArrayList<reportes_reservas> SP_RReservasSAM1(String valor, String sam1) {
        ArrayList<reportes_reservas> sp_centroRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResSAMIZQ(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas rap = new reportes_reservas();
                rap.setFolio_sap(rs.getString("folio_sap"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro"));
                sp_centroRes.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centroRes;
    }

    //Reporte Reservas Consulta DOS SAM 
    public ArrayList<reportes_reservas> SP_RReservasDOSSAM(String valor, String sam1, String sam2) {
        ArrayList<reportes_reservas> sp_centroRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResDOSSAM(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sam1);
            pst.setString(3, sam2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas rap = new reportes_reservas();
                rap.setFolio_sap(rs.getString("folio_sap"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro"));
                sp_centroRes.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centroRes;
    }

    //Reporte Reservas Consulta por SAP 1
    public ArrayList<reportes_reservas> SP_RReservasSAP1(String valor, String sap1) {
        ArrayList<reportes_reservas> sp_centroRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResSAPIZQ(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas rap = new reportes_reservas();
                rap.setFolio_sap(rs.getString("folio_sap"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro"));
                sp_centroRes.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centroRes;
    }

    //Reporte Reservas Consulta DOS SAP
    public ArrayList<reportes_reservas> SP_RReservasDOSSAP(String valor, String sap1, String sap2) {
        ArrayList<reportes_reservas> sp_centroRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResDOSSAP(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, sap1);
            pst.setString(3, sap2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas rap = new reportes_reservas();
                rap.setFolio_sap(rs.getString("folio_sap"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro"));
                sp_centroRes.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centroRes;
    }

    //Reporte Reservas Consulta por FECHA IZQ
    public ArrayList<reportes_reservas> SP_RReservasFE1(String valor, String fecha1) {
        ArrayList<reportes_reservas> sp_centroRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResFeIzq(?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas rap = new reportes_reservas();
                rap.setFolio_sap(rs.getString("folio_sap"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro"));
                sp_centroRes.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centroRes;
    }

    //Reporte Reservas Consulta por FECHA IZQ
    public ArrayList<reportes_reservas> SP_RReservasDOSFE(String valor, String fecha1, String fecha2) {
        ArrayList<reportes_reservas> sp_centroRes = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.RReservas_repResDosFe(?,?,?)}");
            pst.setString(1, valor);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reportes_reservas rap = new reportes_reservas();
                rap.setFolio_sap(rs.getString("folio_sap"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro"));
                sp_centroRes.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_centroRes;
    }

    public boolean ValidarCentro(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ReportesNotificacionesValidacionCentro(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo werewerweValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public ArrayList<ReporteMovimientos> SP_Reporte_MovimientosTodos(String valor, String centro, String sam, String sam2, String sap, String sap2, String fecha1, String fecha2) {
        ArrayList<ReporteMovimientos> sp_movacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Reporte_MovimientosTodos(?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centro);
            pst.setString(3, sam);
            pst.setString(4, sam2);
            pst.setString(5, sap);
            pst.setString(6, sap2);
            pst.setString(7, fecha1);
            pst.setString(8, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteMovimientos mov = new ReporteMovimientos();

                mov.setNum_doc_materila(rs.getString("num_doc_materila"));
                mov.setFolio_sam(rs.getString("folio_sam"));
                mov.setHora_dia(rs.getString("hora_dia"));
                mov.setFecha(rs.getString("fecha"));
                mov.setRecibido(rs.getString("recibido"));
                mov.setProcesado(rs.getString("procesado"));
                mov.setError(rs.getString("error"));
                mov.setCentro(rs.getString("centro"));
                sp_movacio.add(mov);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer los datos por: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + a);
            }
        }
        return sp_movacio;
    }

    public ArrayList<reporte_ivent> MM_MatchMaterial() {
        ArrayList<reporte_ivent> sp_match = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchIventMaterial()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reporte_ivent rm = new reporte_ivent();
                rm.setMaterial(rs.getString("material"));
                sp_match.add(rm);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_match;
    }

    public ArrayList<almacenes> MM_MatchAlmacen(String idioma) {
        ArrayList<almacenes> sp_match = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String descripcion = "descripcion_" + idioma;
        String query = "{call MM.MatchIventAlmacenes(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, idioma);
            rs = pst.executeQuery();
            while (rs.next()) {
                almacenes rm = new almacenes();
                rm.setId_almacen(rs.getString("id_almacen"));
                rm.setDescripcion(rs.getString(descripcion));
                sp_match.add(rm);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_match;
    }

    public ArrayList<reporte_ivent> MM_ReporteIvent(String valor, String materiales, String almacenes, String fecha1, String fecha2) {
        ArrayList<reporte_ivent> sp_match = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteIventTodo(?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, materiales);
            pst.setString(3, almacenes);
            pst.setString(4, fecha1);
            pst.setString(5, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reporte_ivent rm = new reporte_ivent();
                rm.setFolio(rs.getString("folio"));
                rm.setPosicion(rs.getString("posicion"));
                rm.setCantidad(rs.getString("cantidad"));
                rm.setAlmacen(rs.getString("almacen"));
                rm.setMovimiento(rs.getString("movimiento"));
                rm.setFecha(rs.getString("fecha"));
                rm.setMaterial(rs.getString("material"));
                rm.setDescripcion(rs.getString("descripcion"));
                rm.setMensaje(rs.getString("mensaje"));
                sp_match.add(rm);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado debido a: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado debido a: " + b);
            }
        }
        return sp_match;
    }

    public boolean ValidarMaterialReporteIvent(String material) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Reporte_iventValidarMate(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, material);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean ValidarAlmacenReporteIvent(String almacen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.Reporte_iventValidarAlmacen(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, almacen);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean ValidarConsultaReporteIvent(String valor, String materiales, String almacenes, String fecha1, String fecha2) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReporteIventTodo(?,?,?,?,?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, materiales);
            pst.setString(3, almacenes);
            pst.setString(4, fecha1);
            pst.setString(5, fecha2);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
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
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public ArrayList<ReporteNotificaciones> PM_ReporteNotificacionesValidarQuery(String valor, String centro, String sam1, String sam2, String ord1, String ord2, String ope1, String ope2, String sap) {
        ArrayList<ReporteNotificaciones> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Reporte_Notificaciones_ValidarDatos(?,?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, valor);
            pst.setString(2, centro);
            pst.setString(3, sam1);
            pst.setString(4, sam2);
            pst.setString(5, ord1);
            pst.setString(6, ord2);
            pst.setString(7, ope1);
            pst.setString(8, ope2);
            pst.setString(9, sap);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteNotificaciones rn = new ReporteNotificaciones();
                rn.setFolio_sam(rs.getString("folio_sam"));
                rn.setHora_dia(rs.getString("hora_dia"));
                rn.setFecha(rs.getString("fecha"));
                rn.setFolio_sap(rs.getString("folio_sap"));
                rn.setCentro(rs.getString("centro"));
                rn.setNotificacion_parcial_final(rs.getString("notificacion_parcial_final"));
                rn.setNum_orden(rs.getString("num_orden"));
                rn.setNum_operacion(rs.getString("num_operacion"));
                rn.setRecibido(rs.getString("recibido"));
                rn.setProcesado(rs.getString("procesado"));
                rn.setError(rs.getString("error"));
                sp_todos.add(rn);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos por: " + a);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones por: " + b);
            }
        }
        return sp_todos;
    }

    public ArrayList<ReporteOrdenes> PM_Reporte_OrdenesTodos(String valo, String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<ReporteOrdenes> sp_SAPIZQ = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.Reporte_OrdenesTodos(?,?,?,?,?,?,?,?)}");
            pst.setString(1, valo);
            pst.setString(2, centros);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteOrdenes ro = new ReporteOrdenes();
                ro.setFolio_sam(rs.getString("folio_sam"));
                ro.setNum_orden(rs.getString("num_orden"));
                ro.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ro.setHora_dia(rs.getString("hora_dia"));
                ro.setFecha(rs.getString("fecha"));
                ro.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                ro.setCentro_planificacion_mante(rs.getString("centro_planificacion_mantenimiento"));
                ro.setClase_orden(rs.getString("clase_orden"));
                ro.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo_responsable"));
                ro.setTexto_breve(rs.getString("texto_breve"));
                ro.setNum_equipo(rs.getString("num_equipo"));
                ro.setRecibido(rs.getString("recibido"));
                ro.setProcesado(rs.getString("procesado"));
                ro.setError(rs.getString("error"));
                sp_SAPIZQ.add(ro);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos" + a);
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_SAPIZQ;
    }

    public ArrayList<ReporteAvisos> PM_Reporte_AvisosTodos(String valo, String centros, String foliosam, String foliosam2, String foliosap, String foliosap2, String fe1, String fe2) {
        ArrayList<ReporteAvisos> sp_todos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.Reporte_AvisosTodos(?,?,?,?,?,?,?,?)}");
            pst.setString(1, valo);
            pst.setString(2, centros);
            pst.setString(3, foliosam);
            pst.setString(4, foliosam2);
            pst.setString(5, foliosap);
            pst.setString(6, foliosap2);
            pst.setString(7, fe1);
            pst.setString(8, fe2);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteAvisos rap = new ReporteAvisos();
                rap.setNum_notificacion(rs.getString("num_notificacion"));
                rap.setFolio_sam(rs.getString("folio_sam"));
                rap.setHora_dia(rs.getString("hora_dia"));
                rap.setFecha(rs.getString("fecha"));
                rap.setRecibido(rs.getString("recibido"));
                rap.setProcesado(rs.getString("procesado"));
                rap.setError(rs.getString("error"));
                rap.setCentro(rs.getString("centro_planificacion_mante"));
                sp_todos.add(rap);
            }
        } catch (Exception a) {
            System.err.println("Error al traer los datos");
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
            } catch (Exception a) {
                System.err.println("Error inesperado al cerrar conexiones");
            }
        }
        return sp_todos;
    }

    public ArrayList<reportes_entradas> CargarTablaEntradass(String data[]) {
        ArrayList<reportes_entradas> re = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ReporteEntradas_CargaTabla(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            rs = ps.executeQuery();
            while (rs.next()) {
                reportes_entradas r = new reportes_entradas();
                r.setCentro(rs.getString("centro"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setFolio_sap(rs.getString("folio_sap"));
                r.setNum_doc_compras(rs.getString("num_doc_compras"));
                r.setFecha(rs.getString("fecha"));
                r.setHora_dia(rs.getString("hora_dia"));
                r.setRecibido(rs.getString("recibido"));
                r.setProcesado(rs.getString("procesado"));
                r.setError(rs.getString("error"));
                re.add(r);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return re;
    }

    public ArrayList<reporte_lotes_inspeccion_pm> CargarMCSAMLotePM() {
        ArrayList<reporte_lotes_inspeccion_pm> rlip = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteLotePM_CargarSAM}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_lotes_inspeccion_pm re = new reporte_lotes_inspeccion_pm();
                re.setFolio_sam(rs.getString("folio_sam"));
                rlip.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rlip;
    }

    public ArrayList<reporte_lotes_inspeccion_pm> CargarMCLotesLotePM() {
        ArrayList<reporte_lotes_inspeccion_pm> rlip = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteLotePM_CargarLotes}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_lotes_inspeccion_pm re = new reporte_lotes_inspeccion_pm();
                re.setNum_lote_insp(rs.getString("num_lote_insp"));
                rlip.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rlip;
    }

    public ArrayList<reporte_lotes_inspeccion_pm> CargarMCUsuariosLotePM() {
        ArrayList<reporte_lotes_inspeccion_pm> rlip = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteLotePM_CargarUsuarios}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_lotes_inspeccion_pm re = new reporte_lotes_inspeccion_pm();
                re.setCreador_registro_datos(rs.getString("creador_registro_datos"));
                rlip.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rlip;
    }

    public int ValidarDatosLotePM(String dato, String tip) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteLotePM_ValidarDatos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dato);
            ps.setString(2, tip);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<reporte_lotes_inspeccion_pm> CargarTablaLotesInpeccionPM(String data[]) {
        ArrayList<reporte_lotes_inspeccion_pm> rlip = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteLotePM_CargarTabla(?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.setString(9, data[8]);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_lotes_inspeccion_pm re = new reporte_lotes_inspeccion_pm();
                re.setCentro(rs.getString("centro"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setNum_lote_insp(rs.getString("num_lote_insp"));
                re.setFecha(rs.getString("fecha"));
                re.setHora_dia(rs.getString("hora_dia"));
                re.setCreador_registro_datos(rs.getString("creador_registro_datos"));
                re.setRecibido(rs.getString("recibido"));
                re.setProcesado(rs.getString("procesado"));
                re.setError(rs.getString("error"));
                rlip.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rlip;
    }

    public ArrayList<ReporteActividadesAvisos> CargarMCSAMActviAvisos() {
        ArrayList<ReporteActividadesAvisos> raa = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteActvidadesAvisos_CargarMCSAM}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteActividadesAvisos re = new ReporteActividadesAvisos();
                re.setFolio_sam(rs.getString("folio_sam"));
                raa.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return raa;
    }

    public ArrayList<ReporteActividadesAvisos> CargarMCNumActviAvisos() {
        ArrayList<ReporteActividadesAvisos> raa = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteActvidadesAvisos_CargarMCNot}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteActividadesAvisos re = new ReporteActividadesAvisos();
                re.setNum_notificacion(rs.getString("num_notificacion"));
                raa.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return raa;
    }

    public int ValidarDatosActAvisos(String dato, String tip) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteAvisosActividades_ValidarDatos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dato);
            ps.setString(2, tip);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<ReporteActividadesAvisos> CargarTablaActividadesAvisos(String data[]) {
        ArrayList<ReporteActividadesAvisos> rlip = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteActividadesAvisos_CargarTabla(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteActividadesAvisos re = new ReporteActividadesAvisos();
                re.setCentro(rs.getString("centro"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setNum_notificacion(rs.getString("num_notificacion"));
                re.setFecha(rs.getString("fecha"));
                re.setHora_dia(rs.getString("hora_dia"));
                re.setRecibido(rs.getString("recibido"));
                re.setProcesado(rs.getString("procesado"));
                re.setError(rs.getString("error"));
                rlip.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rlip;
    }

    public ArrayList<reporte_dms> CargarFolioDMSReporteDMS() {
        ArrayList<reporte_dms> raa = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call DMS.ReporteDMS_CargarSAM}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_dms re = new reporte_dms();
                re.setFolio_dms(rs.getString("folio_dms"));
                raa.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return raa;
    }

    public ArrayList<reporte_dms> CargarNumDocReporteDMS() {
        ArrayList<reporte_dms> raa = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ReporteDMS_CargarDoc}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_dms re = new reporte_dms();
                re.setNumero_documento(rs.getString("numero_documento"));
                raa.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return raa;
    }

    public ArrayList<reporte_dms> CargarClaseDocReporteDMS() {
        ArrayList<reporte_dms> raa = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call DMS.ReporteDMS_CargarClaseDoc}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_dms re = new reporte_dms();
                re.setClase_documento(rs.getString("clase_documento"));
                raa.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return raa;
    }

    public int ValidarDatosDMS(String dato, String tip) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call DMS.ReporteDMS_ValidarDatos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dato);
            ps.setString(2, tip);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<reporte_dms> CargarTablaDMS(String data[]) {
        ArrayList<reporte_dms> rlip = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call DMS.ReporteDMS_CargarTabla(?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.setString(9, data[8]);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_dms re = new reporte_dms();
                re.setCentro(rs.getString("centro"));
                re.setFolio_dms(rs.getString("folio_dms"));
                re.setNumero_documento(rs.getString("numero_documento"));
                re.setFecha(rs.getString("fecha"));
                re.setHora_dia(rs.getString("hora_dia"));
                re.setClase_documento(rs.getString("clase_documento"));
                re.setDescripcion_documento(rs.getString("descripcion_documento"));
                re.setRecibido(rs.getString("recibido"));
                re.setProcesado(rs.getString("procesado"));
                re.setError(rs.getString("error"));
                rlip.add(re);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rlip;
    }

    /*[Reportes Mov Notificaciones Consulta folio SAM*/
    public ArrayList<PosNotTiempo> SAMStatusMN(String folSAM, String CentroFol, String CtdFol) {
        ArrayList<PosNotTiempo> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ReporteMovNotMatchSam(?,?,?)}");
            pst.setString(1, folSAM);
            pst.setString(2, CentroFol);
            pst.setString(3, CtdFol);
            rs = pst.executeQuery();
            while (rs.next()) {
                PosNotTiempo so = new PosNotTiempo();
                so.setFolio_sam(rs.getString("folio_sam"));
                so.setCentro(rs.getString("centro"));
                sam.add(so);
            }
        } catch (Exception e) {
            System.err.println("Error en CentroReservass, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }

    /*[Reportes Status Ordenes PP Consulta folio SAM*/
    public ArrayList<StatusOrdPP> SAMStatusSO(String folSAM, String CentroFol, String CtdFol) {
        ArrayList<StatusOrdPP> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PP.ReporteStatusOrdPPMatchSam(?,?,?)}");
            pst.setString(1, folSAM);
            pst.setString(2, CentroFol);
            pst.setString(3, CtdFol);
            rs = pst.executeQuery();
            while (rs.next()) {
                StatusOrdPP so = new StatusOrdPP();
                so.setFolio_sam(rs.getString("folio_sam"));
                so.setCentro(rs.getString("centro"));
                sam.add(so);
            }
        } catch (Exception e) {
            System.err.println("Error en CentroReservass, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }
    /*-----------------------------------------------------*/
//    public static void main(String[] args) {
//        String query = "";
//        System.out.println(ACC_Reportes.ObtenerInstancia().DatosStatusVacio("1","BAJA"));
//    }
}
