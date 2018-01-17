/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.ReporteSolPed;
import Entidades.SolpedCrea;
import Entidades.pedido_detalle;
import Entidades.tipo_imputacion;
import Entidades.tipo_posicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ACC_RepSolicitudPedido {

    private static ACC_RepSolicitudPedido Instance = null;

    public static ACC_RepSolicitudPedido ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_RepSolicitudPedido();
        }
        return Instance;
    }

    public ArrayList<ReporteSolPed> CargarSAMListaSolped() {
        ArrayList<ReporteSolPed> sam = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaSolped_CargarSAM()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed s = new ReporteSolPed();
                s.setFolio_sam(rs.getString("folio_sam"));
                sam.add(s);
            }
        } catch (Exception a) {
            System.err.println("Error CargarSAMListaSolped ACCRepSolicitudSolped por : " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sam;
    }

    public ArrayList<ReporteSolPed> CargarSAPListaSolped() {
        ArrayList<ReporteSolPed> sap = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaSolped_CargarSAP()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed s = new ReporteSolPed();
                s.setFolio_sap(rs.getString("folio_sap"));
                sap.add(s);
            }
        } catch (Exception a) {
            System.err.println("Error CargarSAPListaSolped ACCRepSolicitudSolped por : " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sap;
    }

    public ArrayList<ReporteSolPed> CargarUsuarioListaSolped() {
        ArrayList<ReporteSolPed> sol = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaSolped_CargarSolicitante()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed u = new ReporteSolPed();
                u.setUsuario(rs.getString("nombre_solicitante"));
                sol.add(u);
            }
        } catch (Exception a) {
            System.err.println("Error CargarUsuarioListaSolped ACCRepSolicitudSolped por : " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sol;
    }

    public ArrayList<ReporteSolPed> CargarAlmacenListaSolped() {
        ArrayList<ReporteSolPed> alm = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaSolped_CargarAlmacen()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed a = new ReporteSolPed();
                a.setAlmacen(rs.getString("almacen"));
                alm.add(a);
            }
        } catch (Exception a) {
            System.err.println("Error CargarAlmacenListaSolped ACCRepSolicitudSolped por : " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return alm;
    }

    public ArrayList<ReporteSolPed> CargarMaterialListaSolped() {
        ArrayList<ReporteSolPed> mat = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaSolped_CargarMaterial()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed m = new ReporteSolPed();
                m.setMaterial(rs.getString("num_material"));
                mat.add(m);
            }
        } catch (Exception a) {
            System.err.println("Error CargarMaterialListaSolped ACCRepSolicitudSolped por : " + a);
        }finally {
            cnx.CerrarConexion(con);
        }
        return mat;
    }

    public ArrayList<ReporteSolPed> CargarTipoPoscionListaSolped(String Idioma) {
        ArrayList<ReporteSolPed> tpo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaSolped_TipoPosicion(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Idioma);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed tp = new ReporteSolPed();
                tp.setTipo_posicion_doc(rs.getString("tipo_posicion_" + Idioma));
                tp.setDesc_tipo_pos(rs.getString("descripcion_" + Idioma));
                tpo.add(tp);
            }
        } catch (Exception a) {
            System.err.println("Error CargarTipoPoscionListaSolped ACCRepSolicitudSolped por : " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return tpo;
    }

    public ArrayList<ReporteSolPed> CargarTipoImputacionListaSolped(String Idioma) {
        ArrayList<ReporteSolPed> tim = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaSolped_TipoImputacion(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Idioma);
            rs = pst.executeQuery();
            while (rs.next()) {
                ReporteSolPed ti = new ReporteSolPed();
                ti.setTipo_imputacion(rs.getString("tipo_imputacion"));
                ti.setDesc_tipo_imp(rs.getString("descripcion_" + Idioma));
                tim.add(ti);
            }
        } catch (Exception a) {
            System.err.println("Error CargarTipoImputacionListaSolped ACCRepSolicitudSolped por : " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return tim;
    }

    public int ValidarSAMSolped(String SAM) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ValidarSolpedSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, SAM);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarSAMSolped  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarSAPSolped(String SAP) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ValidarSolpedSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, SAP);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarSAPSolped  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarUsuarioSolped(String sol) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarSolicitante(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sol);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarUsuarioSolped  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarAlmacenSolped(String alm) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarAlmacen(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, alm);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarAlmacenSolped  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarMaterialSolped(String mat) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarMaterial(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarMaterialSolped  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarTipoPosSolped(String tp) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarTPosicion(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tp);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarTipoPosSolped  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarTipoImpSolped(String ti) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarTImputacion(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ti);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarTipoImpSolped  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarListaSolpedQuery(String data[]) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarQuery(?,?,?,?,?,?,?,?,?,?,?,?)}";
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
            ps.setString(10, data[9]);
            ps.setString(11, data[10]);
            ps.setString(12, data[11]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarListaSolpedQuery  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarListaSolpedQueryS(String data[]) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarQueryS(?,?,?,?,?,?,?,?,?,?,?,?)}";
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
            ps.setString(10, data[9]);
            ps.setString(11, data[10]);
            ps.setString(12, data[11]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarListaSolpedQueryS  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<ReporteSolPed> CargarTablaRepo(String data[]) {
        ArrayList<ReporteSolPed> rso = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarQuery(?,?,?,?,?,?,?,?,?,?,?,?)}";
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
            ps.setString(10, data[9]);
            ps.setString(11, data[10]);
            ps.setString(12, data[11]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteSolPed r = new ReporteSolPed();
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                r.setFolio_sap(rs.getString("folio_sap"));
                r.setFecha(rs.getString("fecha_solicitud"));
                r.setTipo_posicion_doc(rs.getString("tipo_posicion_doc_compras"));
                r.setTipo_imputacion(rs.getString("tipo_imputacion"));
                r.setMaterial(rs.getString("num_material"));
                r.setTexto_breve(rs.getString("texto_breve_material"));
                r.setCantidad_solped(rs.getString("cantidad_solped"));
                r.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                r.setCentro(rs.getString("centro"));
                r.setAlmacen(rs.getString("almacen"));
                r.setUsuario(rs.getString("nombre_solicitante"));
                r.setFecha_liberacion(rs.getString("fecha_liberacion_solped"));
                r.setIndicador_liberacion(rs.getString("indicador_liberacion_doc_compras"));
                r.setDenominacion_codigo_liberacion(rs.getString("denominacion_codigo_liberacion"));
                r.setProcesado(rs.getString("procesado"));
                r.setError(rs.getString("error"));
                r.setPedido(rs.getString("num_pedido"));
                rso.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarListaSolpedQueryS  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return rso;
    }
    public ArrayList<ReporteSolPed> CargarTablaSolpCrea(String data[]) {
        ArrayList<ReporteSolPed> rso = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL  MM.ListaSolped_ValidarQueryS(?,?,?,?,?,?,?,?,?,?,?,?)}";
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
            ps.setString(10, data[9]);
            ps.setString(11, data[10]);
            ps.setString(12, data[11]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteSolPed r = new ReporteSolPed();
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                r.setFolio_sap(rs.getString("num_solped"));
                r.setFecha(rs.getString("fecha_solicitud"));
                r.setTipo_posicion_doc(rs.getString("tipo_posicion_doc_compras"));
                r.setTipo_imputacion(rs.getString("tipo_imputacion"));
                r.setMaterial(rs.getString("num_material"));
                r.setTexto_breve(rs.getString("texto_breve"));
                r.setCantidad_solped(rs.getString("cantidad_solped"));
                r.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                r.setCentro(rs.getString("centro"));
                r.setAlmacen(rs.getString("almacen"));
                r.setUsuario(rs.getString("solicitante"));
                r.setFecha_liberacion("");
                r.setIndicador_liberacion("");
                r.setDenominacion_codigo_liberacion("");
                r.setProcesado(rs.getString("procesado"));
                r.setError(rs.getString("error"));
                r.setPedido("");
                rso.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarListaSolpedQueryS  ACCRepSolicitudSolped por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return rso;
    }

    public LinkedList ObtenerDatosMAtch(String campo, String campo2) {
        LinkedList<String[]> data = new LinkedList();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        String sql = "{CALL MM.ObtenerDatosMAtchSolPed(?,?)}";
        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, campo);
            sp.setString(2, campo2);
            rs = sp.executeQuery();
            while (rs.next()) {
                String[] d = new String[1];
                d[0] = rs.getString(campo);
                data.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error obtener datos match" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return data;
    }

    public LinkedList<String[]> ConsultaReporteSolped(String solicitante, String almacen, String material, String posicion, String imputacion, String centro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        LinkedList<String[]> docs = new LinkedList();
        String sql = "{CALL MM.SelectDatosRepoSolped(?,?,?,?,?,?)}";

        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, solicitante);
            sp.setString(2, almacen);
            sp.setString(3, material);
            sp.setString(4, posicion);
            sp.setString(5, imputacion);
            sp.setString(6, centro);
            rs = sp.executeQuery();
            while (rs.next()) {
                String[] d = new String[21];
                d[0] = rs.getString("folio_sam");
                d[1] = rs.getString("num_posicion_solped");
                d[2] = rs.getString("folio_sap");
                d[3] = rs.getString("fecha_solicitud");
                d[4] = rs.getString("tipo_posicion_doc_compras");
                d[5] = rs.getString("tipo_imputacion");
                d[6] = rs.getString("num_material");
                d[7] = rs.getString("texto_breve_material");
                d[8] = rs.getString("cantidad_solped");
                d[9] = rs.getString("unidad_medida_solped");
                d[10] = rs.getString("centro");
                d[11] = rs.getString("almacen");
                d[12] = rs.getString("nombre_solicitante");
                d[13] = rs.getString("fecha_liberacion_solped");
                d[14] = rs.getString("indicador_liberacion");
                d[15] = rs.getString("denominacion_codigo_liberacion");
                d[16] = rs.getString("procesado");
                d[17] = rs.getString("error");
                d[18] = rs.getString("num_pedido");
                d[19] = rs.getString("fecha_creacion_doc_mod");
                d[20] = rs.getString("indicador_liberacion_doc_compras");

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta consulta_repo_solped vis por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public LinkedList<String[]> ConsultaReporteSolpedSAMSAP(String SAM, String SAP, String solicitante, String almacen, String material, String posicion, String imputacion, String centro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        LinkedList<String[]> docs = new LinkedList();
        String sql = "{CALL MM.SelectDatosRepoSolpedTodo(?,?,?,?,?,?,?,?)}";

        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, SAM);
            sp.setString(2, SAP);
            sp.setString(3, solicitante);
            sp.setString(4, almacen);
            sp.setString(5, material);
            sp.setString(6, posicion);
            sp.setString(7, imputacion);
            sp.setString(8, centro);
            rs = sp.executeQuery();
            while (rs.next()) {
                String[] d = new String[21];
                d[0] = rs.getString("folio_sam");
                d[1] = rs.getString("num_posicion_solped");
                d[2] = rs.getString("folio_sap");
                d[3] = rs.getString("fecha_solicitud");
                d[4] = rs.getString("tipo_posicion_doc_compras");
                d[5] = rs.getString("tipo_imputacion");
                d[6] = rs.getString("num_material");
                d[7] = rs.getString("texto_breve_material");
                d[8] = rs.getString("cantidad_solped");
                d[9] = rs.getString("unidad_medida_solped");
                d[10] = rs.getString("centro");
                d[11] = rs.getString("almacen");
                d[12] = rs.getString("nombre_solicitante");
                d[13] = rs.getString("fecha_liberacion_solped");
                d[14] = rs.getString("indicador_liberacion");
                d[15] = rs.getString("denominacion_codigo_liberacion");
                d[16] = rs.getString("procesado");
                d[17] = rs.getString("error");
                d[18] = rs.getString("num_pedido");
                d[19] = rs.getString("fecha_creacion_doc_mod");
                d[20] = rs.getString("indicador_liberacion_doc_compras");

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta repo_solped_sam_sap vis por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public LinkedList<String[]> ConsultaReporteSolpedDer(String campo, String campo2, String dato, String solicitante, String almacen, String material, String posicion, String imputacion, String centro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        LinkedList<String[]> docs = new LinkedList();
        String sql = "{CALL MM.SelectDatosRepoSolpedDer(?,?,?,?,?,?,?,?,?)}";

        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, campo);
            sp.setString(2, campo2);
            sp.setString(3, dato);
            sp.setString(4, solicitante);
            sp.setString(5, almacen);
            sp.setString(6, material);
            sp.setString(7, posicion);
            sp.setString(8, imputacion);
            sp.setString(9, centro);
            rs = sp.executeQuery();
            while (rs.next()) {
                String[] d = new String[21];
                d[0] = rs.getString("folio_sam");
                d[1] = rs.getString("num_posicion_solped");
                d[2] = rs.getString("folio_sap");
                d[3] = rs.getString("fecha_solicitud");
                d[4] = rs.getString("tipo_posicion_doc_compras");
                d[5] = rs.getString("tipo_imputacion");
                d[6] = rs.getString("num_material");
                d[7] = rs.getString("texto_breve_material");
                d[8] = rs.getString("cantidad_solped");
                d[9] = rs.getString("unidad_medida_solped");
                d[10] = rs.getString("centro");
                d[11] = rs.getString("almacen");
                d[12] = rs.getString("nombre_solicitante");
                d[13] = rs.getString("fecha_liberacion_solped");
                d[14] = rs.getString("indicador_liberacion");
                d[15] = rs.getString("denominacion_codigo_liberacion");
                d[16] = rs.getString("procesado");
                d[17] = rs.getString("error");
                d[18] = rs.getString("num_pedido");
                d[19] = rs.getString("fecha_creacion_doc_mod");
                d[20] = rs.getString("indicador_liberacion_doc_compras");

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta repo_solped_derecha vis por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public LinkedList<String[]> ConsultaReporteSolpedIzq(String campo, String campo2, String dato, String solicitante, String almacen, String material, String posicion, String imputacion, String centro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        LinkedList<String[]> docs = new LinkedList();
        String sql = "{CALL MM.SelectDatosRepoSolpedIzq(?,?,?,?,?,?,?,?,?)}";

        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, campo);
            sp.setString(2, campo2);
            sp.setString(3, dato);
            sp.setString(4, solicitante);
            sp.setString(5, almacen);
            sp.setString(6, material);
            sp.setString(7, posicion);
            sp.setString(8, imputacion);
            sp.setString(9, centro);
            rs = sp.executeQuery();
            while (rs.next()) {
                String[] d = new String[21];
                d[0] = rs.getString("folio_sam");
                d[1] = rs.getString("num_posicion_solped");
                d[2] = rs.getString("folio_sap");
                d[3] = rs.getString("fecha_solicitud");
                d[4] = rs.getString("tipo_posicion_doc_compras");
                d[5] = rs.getString("tipo_imputacion");
                d[6] = rs.getString("num_material");
                d[7] = rs.getString("texto_breve_material");
                d[8] = rs.getString("cantidad_solped");
                d[9] = rs.getString("unidad_medida_solped");
                d[10] = rs.getString("centro");
                d[11] = rs.getString("almacen");
                d[12] = rs.getString("nombre_solicitante");
                d[13] = rs.getString("fecha_liberacion_solped");
                d[14] = rs.getString("indicador_liberacion");
                d[15] = rs.getString("denominacion_codigo_liberacion");
                d[16] = rs.getString("procesado");
                d[17] = rs.getString("error");
                d[18] = rs.getString("num_pedido");
                d[19] = rs.getString("fecha_creacion_doc_mod");
                d[20] = rs.getString("indicador_liberacion_doc_compras");

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta repo_solped_izquierda por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public LinkedList<String[]> ConsultaReporteSolpedIzqDer(String campo, String campo2, String dato1, String dato2, String solicitante, String almacen, String material, String posicion, String imputacion, String centro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        LinkedList<String[]> docs = new LinkedList();
        String sql = "{CALL MM.SelectDatosRepoSolpedIzqDer(?,?,?,?,?,?,?,?,?,?)}";

        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, campo);
            sp.setString(2, campo2);
            sp.setString(3, dato1);
            sp.setString(4, dato2);
            sp.setString(5, solicitante);
            sp.setString(6, almacen);
            sp.setString(7, material);
            sp.setString(8, posicion);
            sp.setString(9, imputacion);
            sp.setString(10, centro);
            rs = sp.executeQuery();
            while (rs.next()) {
                String[] d = new String[21];
                d[0] = rs.getString("folio_sam");
                d[1] = rs.getString("num_posicion_solped");
                d[2] = rs.getString("folio_sap");
                d[3] = rs.getString("fecha_solicitud");
                d[4] = rs.getString("tipo_posicion_doc_compras");
                d[5] = rs.getString("tipo_imputacion");
                d[6] = rs.getString("num_material");
                d[7] = rs.getString("texto_breve_material");
                d[8] = rs.getString("cantidad_solped");
                d[9] = rs.getString("unidad_medida_solped");
                d[10] = rs.getString("centro");
                d[11] = rs.getString("almacen");
                d[12] = rs.getString("nombre_solicitante");
                d[13] = rs.getString("fecha_liberacion_solped");
                d[14] = rs.getString("indicador_liberacion");
                d[15] = rs.getString("denominacion_codigo_liberacion");
                d[16] = rs.getString("procesado");
                d[17] = rs.getString("error");
                d[18] = rs.getString("num_pedido");
                d[19] = rs.getString("fecha_creacion_doc_mod");
                d[20] = rs.getString("indicador_liberacion_doc_compras");
                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta repo_solped_izquierda y  derecha vis por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public LinkedList<String[]> ConsultaReporteSolpedGeneral(String centro, String sam, String sap, String fecha, String solicitante, String almacen, String material, String posicion, String imputacion) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        LinkedList<String[]> docs = new LinkedList();
        String sql = "{CALL MM.SelectDatosRepoSolpedGeneral(?,?,?,?,?,?,?,?,?)}";

        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, centro);
            sp.setString(2, sam);
            sp.setString(3, sap);
            sp.setString(4, fecha);
            sp.setString(5, solicitante);
            sp.setString(6, almacen);
            sp.setString(7, material);
            sp.setString(8, posicion);
            sp.setString(9, imputacion);
            rs = sp.executeQuery();
            while (rs.next()) {
                String[] d = new String[21];
                d[0] = rs.getString("folio_sam");
                d[1] = rs.getString("num_posicion_solped");
                d[2] = rs.getString("folio_sap");
                d[3] = rs.getString("fecha_solicitud");
                d[4] = rs.getString("tipo_posicion_doc_compras");
                d[5] = rs.getString("tipo_imputacion");
                d[6] = rs.getString("num_material");
                d[7] = rs.getString("texto_breve_material");
                d[8] = rs.getString("cantidad_solped");
                d[9] = rs.getString("unidad_medida_solped");
                d[10] = rs.getString("centro");
                d[11] = rs.getString("almacen");
                d[12] = rs.getString("nombre_solicitante");
                d[13] = rs.getString("fecha_liberacion_solped");
                d[14] = rs.getString("indicador_liberacion");
                d[15] = rs.getString("denominacion_codigo_liberacion");
                d[16] = rs.getString("procesado");
                d[17] = rs.getString("error");
                d[18] = rs.getString("num_pedido");
                d[19] = rs.getString("fecha_creacion_doc_mod");
                d[20] = rs.getString("indicador_liberacion_doc_compras");

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta repo_solped  general vis por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public String ValidarSolped(String campo, String campo2, String valor) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        String Respuesta = "";
        String sql = "{CALL MM.RepSolpedValidar(?,?,?)}";

        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, campo);
            sp.setString(2, campo2);
            sp.setString(3, valor);
            rs = sp.executeQuery();
            while (rs.next()) {
                Respuesta = rs.getString(campo);

            }
        } catch (Exception e) {
            System.err.println("Error en consulta repo_solped vis por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return Respuesta;
    }

    public ArrayList<tipo_posicion> ListaSolpedPosicion(String idioma) {
        ArrayList<tipo_posicion> pos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.MatchListaSolpedPosicion(?)}");
            pst.setString(1, idioma);
            rs = pst.executeQuery();
            while (rs.next()) {
                tipo_posicion p = new tipo_posicion();
                p.setTipo_posicion(rs.getString("tipo_posicion_" + idioma));
                p.setDescripcion(rs.getString("descripcion_" + idioma));
                pos.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado debido a: " + e);
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
                System.err.println("Error inesperado al cerrar las conexiones por: " + e);
            }
        }
        return pos;
    }

    public ArrayList<tipo_imputacion> ListaSolpedImputacion(String idioma) {
        ArrayList<tipo_imputacion> imp = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.matchListaSolpedImputacion(?)}");
            pst.setString(1, idioma);
            rs = pst.executeQuery();
            while (rs.next()) {
                tipo_imputacion i = new tipo_imputacion();
                i.setTipo_imputacion(rs.getString("tipo_imputacion"));
                i.setDescripcion(rs.getString("descripcion_" + idioma));
                imp.add(i);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado debido a: " + e);
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
                System.err.println("Error inesperado al cerrar las conexiones por: " + e);
            }
        }
        return imp;
    }

    public boolean ValidarImputacion(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.ListaSoledValidacionImputacion(?)}");
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al traer datos por: " + e);
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
                System.err.println("Error inesperado al cerrar conexiones por: " + e);
            }
        }
        return false;
    }

    public boolean ValidarPosicion(String dato) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.ListaSolpedValidacionPosicion(?)}");
            pst.setString(1, dato);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("error inesperado al traer datos debido a: " + e);
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
                System.err.println("Error inesperado al cerrar conexiones por: " + e);
            }
        }
        return false;
    }
}
