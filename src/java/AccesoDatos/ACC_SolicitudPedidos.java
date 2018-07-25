/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.SolpedCrea;
import Entidades.SolpedServicios;
import Entidades.Solped_Cabecera_vis;
import Entidades.Solped_Posiciones_vis;
import Entidades.Solped_Servicios_vis;
import Entidades.textos_cabecera_solped;
import Entidades.textos_posiciones_solped;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ACC_SolicitudPedidos {

    private static ACC_SolicitudPedidos Instance = null;

    public static ACC_SolicitudPedidos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_SolicitudPedidos();
        }
        return Instance;
    }

    public ArrayList<String[]> ObteneTipoSolped(String lang, String centro) {
        ArrayList<String[]> Dat1 = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.SolpedCargarTipoDocSolped(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lang);
            ps.setString(2, centro);
            rs = ps.executeQuery();
            while (rs.next()) {
                String[] ret = new String[2];
                ret[0] = rs.getString("clase_pedido");
                ret[1] = rs.getString(lang);
                Dat1.add(ret);
            }

        } catch (Exception e) {
            System.err.println("Error en ObteneTipoSolped, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return Dat1;
    }

    public String ValidarSolpedCrea(String num) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ret = "0";
        String sql = "{CALL MM.Solped_ValidarFolioSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, num);
            rs = ps.executeQuery();
            while (rs.next()) {
                ret = rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarSolpedCrea, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ret;
    }

    public ArrayList<Solped_Posiciones_vis> CargarTablaSolpedSAP(String solped) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<Solped_Posiciones_vis> sp = new ArrayList<>();
        String sql = "{CALL MM.SolpedCargarTablaModSAP(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solped_Posiciones_vis s = new Solped_Posiciones_vis();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                s.setNum_material(rs.getString("num_material"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setCantidad_solped(rs.getString("cantidad_solped"));
                s.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                s.setFecha_entrega(rs.getString("fecha_entrega"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setCentro(rs.getString("centro"));
                s.setAlmacen(rs.getString("almacen"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setOrganización_compras(rs.getString("organización_compras"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
                s.setIndicador_borrado(rs.getString("indicador_borrado"));
                sp.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTablaSolpedSAP, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sp;
    }

    public boolean VerificarSAP(String solped) {
        boolean ban = false;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_ConsultaSAPLib(?)}";
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = true;
            }

        } catch (Exception e) {
            System.err.println("Error en VerificarSAP, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public void Insertdata(String sap1, String pos, String sam, String can, String con, String fecha, String hora) {
        Conexion cnx = new Conexion();
        Connection conn = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_CancelarPos(?,?,?,?,?,?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sap1);
            ps.setString(2, pos);
            ps.setString(3, sam);
            ps.setString(4, can);
            ps.setString(5, con);
            ps.setString(6, fecha);
            ps.setString(7, hora);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en Insertdata, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(conn);
        }
    }

    public void ActualizarIndicadorSolped(String solped, String pos, String ind) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_ActualizarIndSolped(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            ps.setString(2, pos);
            ps.setString(3, ind);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ActualizarIndicadorSolped, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public ArrayList<Solped_Posiciones_vis> ConsultaMCSolped(String sol, String fecha) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Solped_Posiciones_vis> so = new ArrayList<>();
        String sql = "{CALL MM.VisualizarSolped_CargarConsultaMCSolped(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sol);
            ps.setString(2, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solped_Posiciones_vis s = new Solped_Posiciones_vis();
                s.setFolio_sap(rs.getString("folio_sap"));
                s.setFolio_sam(rs.getString("folio_sam"));
                s.setFecha(rs.getString("fecha"));
                so.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en Solped_Posiciones_vis, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return so;
    }

    public int ValidarSolpedSAP(String fol) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ban = 0;
        String sql = "{CALL MM.VisualSolped_ValidarSolpedSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, fol);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarSolpedSAP, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarSolpedSAM(String fol) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ban = 0;
        String sql = "{CALL MM.VisualSolped_ValidarSolpedSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, fol);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarSolpedSAM, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<Solped_Posiciones_vis> ObtenerTablaSolpedSAP(String solped) {
        ArrayList<Solped_Posiciones_vis> so = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.VisualSolped_ObtenerTablaSolpedSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solped_Posiciones_vis s = new Solped_Posiciones_vis();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                s.setNum_material(rs.getString("num_material"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setCantidad_solped(rs.getString("cantidad_solped"));
                s.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                s.setFecha_entrega(rs.getString("fecha_entrega"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setCentro(rs.getString("centro"));
                s.setAlmacen(rs.getString("almacen"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setOrganización_compras(rs.getString("organización_compras"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
                s.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orden(rs.getString("num_orden"));
                so.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerTablaSolpedSAP, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return so;
    }

    public ArrayList<Solped_Posiciones_vis> ObtenerTablaSolpedSAM(String solped) {
        ArrayList<Solped_Posiciones_vis> so = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.VisualSolped_ObtenerTablaSolpedSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solped_Posiciones_vis s = new Solped_Posiciones_vis();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                s.setNum_material(rs.getString("num_material"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setCantidad_solped(rs.getString("cantidad_solped"));
                s.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                s.setFecha_entrega(rs.getString("fecha_entraga_posicion"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setCentro(rs.getString("centro"));
                s.setAlmacen(rs.getString("almacen"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setOrganización_compras(rs.getString("organizacion_compras"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
                s.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orden(rs.getString("num_orden"));
                so.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerTablaSolpedSAM, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return so;
    }

    public Solped_Posiciones_vis CargarDatosCabeceraSAP(String solped) {
        Solped_Posiciones_vis s = new Solped_Posiciones_vis();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolped_ObtenerDatosCabeceraSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            rs = ps.executeQuery();
            while (rs.next()) {
                s.setClase_doc_solped(rs.getString("clase_pedido"));
                s.setTexto_cabecera(rs.getString("texto_cabecera"));
                s.setFolio_sap(rs.getString("folio_sap"));
                s.setFolio_sam(rs.getString("folio_sam"));
                s.setOrganización_compras(rs.getString("organización_compras"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
            }
        } catch (Exception e) {
            System.err.println("Error en CargarDatosCabeceraSAP, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return s;
    }

    public Solped_Posiciones_vis CargarDatosCabeceraSAM(String solped) {
        Solped_Posiciones_vis s = new Solped_Posiciones_vis();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolped_ObtenerDatosCabeceraSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            rs = ps.executeQuery();
            while (rs.next()) {
                s.setClase_doc_solped(rs.getString("clase_documento_solped"));
                s.setFolio_sap(rs.getString("num_solped"));
                s.setFolio_sam(rs.getString("folio_sam"));
                s.setOrganización_compras(rs.getString("organizacion_compras"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
                s.setError(rs.getString("error"));
            }
        } catch (Exception e) {
            System.err.println("Error en CargarDatosCabeceraSAM, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return s;
    }

    public String[] DatosLiberacionSAP(String solped, String pos) {
        String data[] = new String[3];
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.SolpedObtenerVistaLib(?,?)}";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, solped);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                data[0] = rs.getString("indicador_liberacion");
                data[1] = rs.getString("estrategia_liberacion_solped");
                data[2] = rs.getString("denominacion_codigo_liberacion");
            }
        } catch (Exception e) {
            System.err.println("Error en DatosLiberacionSAP, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return data;
    }

    public Solped_Posiciones_vis CargarPosicionSAP(String solped, String pos) {
        Solped_Posiciones_vis v = new Solped_Posiciones_vis();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolped_CargarPosicionSAP(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setTipo_imputacion(rs.getString("tipo_imputacion"));
                v.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                v.setNum_material(rs.getString("num_material"));
                v.setCantidad_solped(rs.getString("cantidad_solped"));
                v.setFecha_entrega(rs.getString("fecha_entrega"));
                v.setCentro(rs.getString("centro"));
                v.setAlmacen(rs.getString("almacen"));
                v.setTexto_breve(rs.getString("texto_breve"));
                v.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                v.setGrupo_articulos(rs.getString("grupo_articulos"));
                v.setSolicitante(rs.getString("solicitante"));
                v.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                v.setCentro_coste(rs.getString("centro_coste"));
                v.setNum_orden(rs.getString("num_orden"));
                v.setTexto_posicion(rs.getString("texto_posicion"));
            }
        } catch (Exception e) {
            System.err.println("Error en CargarPosicionSAP, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return v;
    }

    public Solped_Posiciones_vis CargarPosicionSAM(String solped, String pos) {
        Solped_Posiciones_vis v = new Solped_Posiciones_vis();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolped_CargarPosicionSAM(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setTipo_imputacion(rs.getString("tipo_imputacion"));
                v.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                v.setNum_material(rs.getString("num_material"));
                v.setCantidad_solped(rs.getString("cantidad_solped"));
                v.setFecha_entrega(rs.getString("fecha_entraga_posicion"));
                v.setCentro(rs.getString("centro"));
                v.setAlmacen(rs.getString("almacen"));
                v.setTexto_breve(rs.getString("texto_breve"));
                v.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                v.setGrupo_articulos(rs.getString("grupo_articulos"));
                v.setSolicitante(rs.getString("solicitante"));
                v.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                v.setCentro_coste(rs.getString("centro_coste"));
                v.setNum_orden(rs.getString("num_orden"));
                v.setTexto_posicion(rs.getString("texto_posicion"));
            }
        } catch (Exception e) {
            System.err.println("Error en CargarPosicionSAM, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return v;
    }

    public ArrayList<Solped_Servicios_vis> CargarServiciosSAP(String solped, String pos) {
        ArrayList<Solped_Servicios_vis> solp = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolped_CargarServicioPosicionSAP(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solped_Servicios_vis s = new Solped_Servicios_vis();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setNum_linea(rs.getString("num_linea"));
                s.setNum_servicio(rs.getString("num_servicio"));
                s.setCantidad(rs.getString("cantidad"));
                s.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setPrecio_bruto(rs.getString("precio_bruto"));
                solp.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarServiciosSAP, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return solp;
    }

    public ArrayList<Solped_Servicios_vis> CargarServiciosSAM(String solped, String pos) {
        ArrayList<Solped_Servicios_vis> solp = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualSolped_CargarServicioPosicionSAM(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, solped);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solped_Servicios_vis s = new Solped_Servicios_vis();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setNum_linea(rs.getString("num_posicion_solped2"));
                s.setNum_servicio(rs.getString("num_servicio"));
                s.setCantidad(rs.getString("cantidad"));
                s.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setPrecio_bruto(rs.getString("precio_bruto"));
                solp.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarServiciosSAM, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return solp;
    }

    public boolean InsertTemporal(SolpedCrea s) {
        boolean ban = false;
        Conexion cnx = new Conexion();
        Connection cnn = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_InsertarPosTemporal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setString(1, s.getNum_posicion_solped());
            ps.setString(2, s.getClase_documento_solped());
            ps.setString(3, s.getTipo_imputacion());
            ps.setString(4, s.getTipo_posicion_doc_compras());
            ps.setString(5, s.getNum_material());
            ps.setString(6, s.getTexto_breve());
            ps.setString(7, s.getUnidad_medida_solped());
            ps.setString(8, s.getGrupo_articulos());
            ps.setString(9, s.getCantidad_solped());
            ps.setString(10, s.getFecha_entraga_posicion());
            ps.setString(11, s.getCentro());
            ps.setString(12, s.getAlmacen());
            ps.setString(13, s.getSolicitante());
            ps.setString(14, s.getOrganizacion_compras());
            ps.setString(15, s.getGrupo_compras());
            ps.setString(16, s.getNum_cuenta_mayor());
            ps.setString(17, s.getCentro_coste());
            ps.setString(18, s.getNum_orden());
            ps.setString(19, s.getFecha());
            ps.setString(20, s.getHora_dia());
            ps.setString(21, s.getSolicitante());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertTemporal, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(cnn);
        }
        return ban;
    }

    public boolean UpdateTemporal(SolpedCrea s) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_ActualizarPosTemporal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, s.getNum_posicion_solped());
            ps.setString(2, s.getTipo_imputacion());
            ps.setString(3, s.getTipo_posicion_doc_compras());
            ps.setString(4, s.getNum_material());
            ps.setString(5, s.getTexto_breve());
            ps.setString(6, s.getUnidad_medida_solped());
            ps.setString(7, s.getGrupo_articulos());
            ps.setString(8, s.getCantidad_solped());
            ps.setString(9, s.getFecha_entraga_posicion());
            ps.setString(10, s.getCentro());
            ps.setString(11, s.getAlmacen());
            ps.setString(12, s.getSolicitante());
            ps.setString(13, s.getNum_cuenta_mayor());
            ps.setString(14, s.getCentro_coste());
            ps.setString(15, s.getNum_orden());
            ps.setString(16, s.getSolicitante());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en UpdateTemporal, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean UpdateTemporalMod(SolpedCrea s, String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_ActualizarPosTemporalMod(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, s.getNum_posicion_solped());
            ps.setString(3, s.getTipo_imputacion());
            ps.setString(4, s.getTipo_posicion_doc_compras());
            ps.setString(5, s.getNum_material());
            ps.setString(6, s.getTexto_breve());
            ps.setString(7, s.getUnidad_medida_solped());
            ps.setString(8, s.getGrupo_articulos());
            ps.setString(9, s.getCantidad_solped());
            ps.setString(10, s.getFecha_entraga_posicion());
            ps.setString(11, s.getCentro());
            ps.setString(12, s.getAlmacen());
            ps.setString(13, s.getSolicitante());
            ps.setString(14, s.getNum_cuenta_mayor());
            ps.setString(15, s.getCentro_coste());
            ps.setString(16, s.getNum_orden());
            ps.setString(17, s.getSolicitante());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en UpdateTemporalMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public ArrayList<SolpedCrea> CargarTablaTemp(String user) {
        ArrayList<SolpedCrea> sol = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarTemp(?)}";
        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, user);
            rs = sp.executeQuery();
            while (rs.next()) {
                SolpedCrea s = new SolpedCrea();
                s.setNum_posicion_solped(rs.getString("posicion"));
                s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                s.setTipo_posicion_doc_compras(rs.getString("tipo_posicion"));
                s.setNum_material(rs.getString("material"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setUnidad_medida_solped(rs.getString("unidad_medida"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setFecha_entraga_posicion(rs.getString("fecha_entrega"));
                s.setCentro(rs.getString("centro"));
                s.setAlmacen(rs.getString("almacen"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setOrganizacion_compras(rs.getString("organizacion_compras"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
                s.setNum_cuenta_mayor(rs.getString("cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orden(rs.getString("num_orden"));
                s.setCantidad_solped(rs.getString("cantidad"));
                s.setClase_documento_solped(rs.getString("clase_documento"));
                s.setHora_dia(rs.getString("hora"));
                s.setFecha(rs.getString("fecha"));
                sol.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTablaTemp, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sol;
    }

    public ArrayList<SolpedCrea> CargarTablaSolped(String folio, String tabla, String us) {
        ArrayList<SolpedCrea> sol = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarTablaSolped(?,?,?)}";
        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, folio);
            sp.setString(2, tabla);
            sp.setString(3, us);
            rs = sp.executeQuery();
            while (rs.next()) {
                SolpedCrea s = new SolpedCrea();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                s.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                s.setNum_material(rs.getString("num_material"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setFecha_entraga_posicion(rs.getString("fecha_entraga_posicion"));
                s.setCentro(rs.getString("centro"));
                s.setAlmacen(rs.getString("almacen"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setOrganizacion_compras(rs.getString("organizacion_compras"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
                s.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orden(rs.getString("num_orden"));
                s.setCantidad_solped(rs.getString("cantidad_solped"));
                s.setClase_documento_solped(rs.getString("clase_documento_solped"));
                s.setHora_dia(rs.getString("hora_dia"));
                s.setFecha(rs.getString("fecha"));
                sol.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTablaSolped, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sol;
    }

    public ArrayList<SolpedCrea> CargarPosicion(String user) {
        ArrayList<SolpedCrea> so = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarPosicion(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                SolpedCrea s = new SolpedCrea();
                s.setNum_posicion_solped(rs.getString("posicion"));
                so.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarPosicion, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return so;
    }

    public void BorrarTemporal(String user) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL MM.Solped_EliminarDatosTemporal(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("Error en BorrarTemporal, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public SolpedCrea ObtenerDatosposicion(String pos, String user) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        SolpedCrea s = new SolpedCrea();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarDatosPosicion(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pos);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                s.setTipo_posicion_doc_compras(rs.getString("tipo_posicion"));
                s.setNum_material(rs.getString("material"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setUnidad_medida_solped(rs.getString("unidad_medida"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setCantidad_solped(rs.getString("cantidad"));
                s.setFecha_entraga_posicion(rs.getString("fecha_entrega"));
                s.setCentro(rs.getString("centro"));
                s.setAlmacen(rs.getString("almacen"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setNum_cuenta_mayor(rs.getString("cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orden(rs.getString("num_orden"));
            }

        } catch (Exception e) {
            System.err.println("Error en ObtenerDatosposicion, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return s;
    }

    public void InsertarSolped(ArrayList<SolpedCrea> sl, String folio, String hor, String ipsf) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_GuardarDatos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            for (SolpedCrea s : sl) {
                ps = con.prepareStatement(sql);
                ps.setString(1, folio);
                ps.setString(2, s.getNum_posicion_solped());
                ps.setString(3, s.getTipo_posicion_doc_compras());
                ps.setString(4, s.getNum_material());
                ps.setString(5, s.getFecha());
                ps.setString(6, hor);
                ps.setString(7, s.getClase_documento_solped());
                ps.setString(8, s.getTipo_imputacion());
                ps.setString(9, s.getTexto_breve());
                ps.setString(10, s.getCantidad_solped());
                ps.setString(11, s.getUnidad_medida_solped());
                ps.setString(12, s.getFecha_entraga_posicion());
                ps.setString(13, s.getGrupo_articulos());
                ps.setString(14, s.getCentro());
                ps.setString(15, s.getAlmacen());
                ps.setString(16, s.getGrupo_compras());
                ps.setString(17, s.getSolicitante());
                ps.setString(18, s.getOrganizacion_compras());
                ps.setString(19, s.getNum_cuenta_mayor());
                ps.setString(20, s.getCentro_coste());
                ps.setString(21, s.getNum_orden());
                ps.setString(22, ipsf);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarSolped, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public boolean InsertarSolpedTem(SolpedCrea s, String folio) {
        boolean ban = false;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_GuardarDatos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, s.getNum_posicion_solped());
            ps.setString(3, s.getTipo_posicion_doc_compras());
            ps.setString(4, s.getNum_material());
            ps.setString(5, s.getFecha());
            ps.setString(6, s.getHora_dia());
            ps.setString(7, s.getClase_documento_solped());
            ps.setString(8, s.getTipo_imputacion());
            ps.setString(9, s.getTexto_breve());
            ps.setString(10, s.getCantidad_solped());
            ps.setString(11, s.getUnidad_medida_solped());
            ps.setString(12, s.getFecha_entraga_posicion());
            ps.setString(13, s.getGrupo_articulos());
            ps.setString(14, s.getCentro());
            ps.setString(15, s.getAlmacen());
            ps.setString(16, s.getGrupo_compras());
            ps.setString(17, s.getSolicitante());
            ps.setString(18, s.getOrganizacion_compras());
            ps.setString(19, s.getNum_cuenta_mayor());
            ps.setString(20, s.getCentro_coste());
            ps.setString(21, s.getNum_orden());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarSolpedTem, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public SolpedCrea ObtenerDatosSolpedCab(String num) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        SolpedCrea s = new SolpedCrea();
        String sql = "{CALL MM.Solped_CargarDatosCab(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, num);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setClase_documento_solped(rs.getString("clase_documento_solped"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
                s.setOrganizacion_compras(rs.getString("organizacion_compras"));
                s.setError(rs.getString("error"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerDatosSolpedCab, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return s;
    }

    public ArrayList<SolpedCrea> CargarPosi(String num, String tabla, String us) {
        ArrayList<SolpedCrea> so = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.[Solped_CargarPos](?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, num);
            ps.setString(2, tabla);
            ps.setString(3, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                SolpedCrea s = new SolpedCrea();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                so.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarPosi, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return so;
    }

    public SolpedCrea ObtenerPosicion(String folio, String pos, String tabla, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        SolpedCrea s = new SolpedCrea();
        String sql = "{CALL MM.Solped_CargarPosiciones(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, pos);
            ps.setString(3, tabla);
            ps.setString(4, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                s.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                s.setNum_material(rs.getString("num_material"));
                s.setCantidad_solped(rs.getString("cantidad_solped"));
                s.setFecha_entraga_posicion(rs.getString("fecha_entraga_posicion"));
                s.setCentro(rs.getString("centro"));
                s.setAlmacen(rs.getString("almacen"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orden(rs.getString("num_orden"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerPosicion, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return s;
    }

    public boolean VerificarEdicion(String num, String user) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_VerificarEdidcion(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, num);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en VerificarEdicion, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public void EstatusSolpedMod(ArrayList<SolpedCrea> sl, String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.[Solped_InsertarTemMod](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            for (SolpedCrea s : sl) {
                ps = con.prepareStatement(sql);
                ps.setString(1, folio);
                ps.setString(2, s.getNum_posicion_solped());
                ps.setString(3, s.getTipo_posicion_doc_compras());
                ps.setString(4, s.getNum_material());
                ps.setString(5, s.getFecha());
                ps.setString(6, s.getHora_dia());
                ps.setString(7, s.getClase_documento_solped());
                ps.setString(8, s.getTipo_imputacion());
                ps.setString(9, s.getTexto_breve());
                ps.setString(10, s.getCantidad_solped());
                ps.setString(11, s.getUnidad_medida_solped());
                ps.setString(12, s.getFecha_entraga_posicion());
                ps.setString(13, s.getGrupo_articulos());
                ps.setString(14, s.getCentro());
                ps.setString(15, s.getAlmacen());
                ps.setString(16, s.getGrupo_compras());
                ps.setString(17, s.getSolicitante());
                ps.setString(18, s.getOrganizacion_compras());
                ps.setString(19, s.getNum_cuenta_mayor());
                ps.setString(20, s.getCentro_coste());
                ps.setString(21, s.getNum_orden());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error en EstatusSolpedMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void InsertarServiciosMod(ArrayList<SolpedServicios> sl) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.solped_servicios_crea_modINSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            for (SolpedServicios s : sl) {
                ps = con.prepareStatement(sql);
                ps.setString(1, s.getFolio_sam());
                ps.setString(2, s.getNum_posicion_solped());
                ps.setString(3, s.getNum_posicion_solped2());
                ps.setString(4, s.getNum_servicio());
                ps.setString(5, s.getFecha());
                ps.setString(6, s.getHora());
                ps.setString(7, s.getTexto_breve());
                ps.setString(8, s.getCantidad());
                ps.setString(9, s.getUnidad_medida_base());
                ps.setString(10, s.getCantidad_base());
                ps.setString(11, s.getPrecio_bruto());
                ps.setString(12, s.getGrupo_articulos());
                ps.setString(13, s.getNum_cuenta_mayor());
                ps.setString(14, s.getCentro_coste());
                ps.setString(15, s.getNum_orde());
                ps.setString(16, s.getRecibido());
                ps.setString(17, s.getProcesado());
                ps.setString(18, s.getModificado());
                ps.setString(19, s.getError());
                ps.setString(20, s.getSolicitante());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarServiciosMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public boolean InsertarTemMod(SolpedCrea s, String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.[Solped_InsertarTemMod](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        boolean ban = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, s.getNum_posicion_solped());
            ps.setString(3, s.getTipo_posicion_doc_compras());
            ps.setString(4, s.getNum_material());
            ps.setString(5, s.getFecha());
            ps.setString(6, s.getHora_dia());
            ps.setString(7, s.getClase_documento_solped());
            ps.setString(8, s.getTipo_imputacion());
            ps.setString(9, s.getTexto_breve());
            ps.setString(10, s.getCantidad_solped());
            ps.setString(11, s.getUnidad_medida_solped());
            ps.setString(12, s.getFecha_entraga_posicion());
            ps.setString(13, s.getGrupo_articulos());
            ps.setString(14, s.getCentro());
            ps.setString(15, s.getAlmacen());
            ps.setString(16, s.getGrupo_compras());
            ps.setString(17, s.getSolicitante());
            ps.setString(18, s.getOrganizacion_compras());
            ps.setString(19, s.getNum_cuenta_mayor());
            ps.setString(20, s.getCentro_coste());
            ps.setString(21, s.getNum_orden());
            if (ps.executeUpdate() > 0) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarTemMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public void CancelStatus(String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call mm.solped_ActualizarStatus(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en CancelStatus, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public boolean solped_tempDelete(String us, String pos) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call MM.solped_temp_ELIMINAR(?,?)}";
        int validar;
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, us);
            pst.setString(2, pos);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_tempDelete, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean solped_txt_CABDELETE(String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.textos_cabecera_solpedDELETE(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_txt_CABDELETE, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public ArrayList<SolpedServicios> CargarServiciosModTemp1(String Solped, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<SolpedServicios> se = new ArrayList<>();
        String sql = "{CALL MM.solped_servicios_crea_modCONSULTA2(?,?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Solped);
            ps.setString(2, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                SolpedServicios s = new SolpedServicios();
                s.setId_sps(rs.getInt("id_sps"));
                s.setFolio_sam(rs.getString("folio_sam"));
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setNum_posicion_solped2(rs.getString("num_posicion_solped2"));
                s.setNum_servicio(rs.getString("num_servicio"));
                s.setFecha(rs.getString("fecha"));
                s.setHora(rs.getString("hora_dia"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setCantidad(rs.getString("cantidad"));
                s.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                s.setCantidad_base(rs.getString("cantidad_base"));
                s.setPrecio_bruto(rs.getString("precio_bruto"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orde(rs.getString("num_orden"));
                s.setNum_solped(rs.getString("num_solped"));
                s.setRecibido(rs.getString("recibido"));
                s.setProcesado(rs.getString("procesado"));
                s.setError(rs.getString("error"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setSolicitanteTemp(rs.getString("SolicitanteTemp"));
                se.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarServiciosModTemp1, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return se;
    }

    public boolean solped_serviciosDelete(String us, String pos) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call  MM.solped_servicios_crea_temp_ELIMINARPO(?,?)}";
        int validar;
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, us);
            pst.setString(2, pos);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_serviciosDelete, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean tex_pos_solped_tempDelete(String us, String pos) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call  MM.textos_posiciones_solped_temp_POSELIM(?,?)}";
        int validar;
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, us);
            pst.setString(2, pos);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en tex_pos_solped_tempDelete, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean solped_serviciosUpdate(String user, String posv, String posn) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.solped_servicios_crea_tempACTUALIZAR(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, posv);
            pst.setString(3, posn);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_serviciosUpdate, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean solped_tempUpdate(String user, String posv, String posn) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.solped_temp_tempACTUALIZAR(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, posv);
            pst.setString(3, posn);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_tempUpdate, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean tex_pos_solped_tempUpdate(String user, String posv, String posn) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.textos_posiciones_solped_tempACTUALIZAR(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, posv);
            pst.setString(3, posn);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_tempUpdate, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean solped_tempDeleteMod(String us, String pos, String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call MM.solped_ModELIMINAR(?,?,?)}";
        int validar;
        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, us);
            pst.setString(2, pos);
            pst.setString(3, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_tempDeleteMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean solped_serviciosDeleteMod(String us, String pos, String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call  MM.solped_servicios_crea_mod_ELIMINARPO(?,?,?)}";
        int validar;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, us);
            pst.setString(2, pos);
            pst.setString(3, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_serviciosDeleteMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean tex_pos_solped_tempDeleteMod(String us, String pos, String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call  MM.textos_posiciones_solped_mod_POSELIM(?,?,?)}";
        int validar;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, us);
            pst.setString(2, pos);
            pst.setString(3, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en tex_pos_solped_tempDeleteMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean solped_serviciosUpdateMod(String user, String posv, String posn, String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.solped_servicios_crea_modACTUALIZAR(?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, posv);
            pst.setString(3, posn);
            pst.setString(4, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_serviciosUpdateMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean solped_ModUpdate(String user, String posv, String posn, String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.solped_Mod_ACTUALIZAR(?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, posv);
            pst.setString(3, posn);
            pst.setString(4, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_ModUpdate, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean tex_pos_solped_ModUpdate(String user, String posv, String posn, String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.textos_posiciones_solped_modACTUALIZAR(?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, posv);
            pst.setString(3, posn);
            pst.setString(4, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en tex_pos_solped_ModUpdate, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public ArrayList<SolpedCrea> CargarTablaSolpedMod(String folio, String us) {
        ArrayList<SolpedCrea> sol = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement sp = null;
        ResultSet rs = null;
        String sql = "{CALL MM.solped_ModConsultar(?,?)}";
        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, folio);
            sp.setString(2, us);
            rs = sp.executeQuery();
            while (rs.next()) {
                SolpedCrea s = new SolpedCrea();
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                s.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                s.setNum_material(rs.getString("num_material"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setFecha_entraga_posicion(rs.getString("fecha_entraga_posicion"));
                s.setCentro(rs.getString("centro"));
                s.setAlmacen(rs.getString("almacen"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setOrganizacion_compras(rs.getString("organizacion_compras"));
                s.setGrupo_compras(rs.getString("grupo_compras"));
                s.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orden(rs.getString("num_orden"));
                s.setCantidad_solped(rs.getString("cantidad_solped"));
                s.setClase_documento_solped(rs.getString("clase_documento_solped"));
                s.setHora_dia(rs.getString("hora_dia"));
                s.setFecha(rs.getString("fecha"));
                sol.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTablaSolpedMod, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sol;
    }

    public boolean solped_CREADELETE(String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.solped_ModDELETE(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_CREADELETE, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public void EstatusSolped(ArrayList<SolpedCrea> sl, String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.Solped_Insertarsolped_crea(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            for (SolpedCrea s : sl) {
                ps = con.prepareStatement(sql);
                ps.setString(1, folio);
                ps.setString(2, s.getNum_posicion_solped());
                ps.setString(3, s.getTipo_posicion_doc_compras());
                ps.setString(4, s.getNum_material());
                ps.setString(5, Consultas.ObtenerInstancia().ObtenerFechaActualServidor());
                ps.setString(6, s.getHora_dia());
                ps.setString(7, s.getClase_documento_solped());
                ps.setString(8, s.getTipo_imputacion());
                ps.setString(9, s.getTexto_breve());
                ps.setString(10, s.getCantidad_solped());
                ps.setString(11, s.getUnidad_medida_solped());
                ps.setString(12, s.getFecha_entraga_posicion());
                ps.setString(13, s.getGrupo_articulos());
                ps.setString(14, s.getCentro());
                ps.setString(15, s.getAlmacen());
                ps.setString(16, s.getGrupo_compras());
                ps.setString(17, s.getSolicitante());
                ps.setString(18, s.getOrganizacion_compras());
                ps.setString(19, s.getNum_cuenta_mayor());
                ps.setString(20, s.getCentro_coste());
                ps.setString(21, s.getNum_orden());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error en EstatusSolped, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public ArrayList<SolpedServicios> CargarServiciosNO(String Solped, String us) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<SolpedServicios> se = new ArrayList<>();
        String sql = "{CALL MM.solped_servicios_crea_modCONSULTAS(?,?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Solped);
            ps.setString(2, us);
            rs = ps.executeQuery();
            while (rs.next()) {
                SolpedServicios s = new SolpedServicios();
                s.setId_sps(rs.getInt("id_sps"));
                s.setFolio_sam(rs.getString("folio_sam"));
                s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                s.setNum_posicion_solped2(rs.getString("num_posicion_solped2"));
                s.setNum_servicio(rs.getString("num_servicio"));
                s.setFecha(rs.getString("fecha"));
                s.setHora(rs.getString("hora_dia"));
                s.setTexto_breve(rs.getString("texto_breve"));
                s.setCantidad(rs.getString("cantidad"));
                s.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                s.setCantidad_base(rs.getString("cantidad_base"));
                s.setPrecio_bruto(rs.getString("precio_bruto"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                s.setCentro_coste(rs.getString("centro_coste"));
                s.setNum_orde(rs.getString("num_orden"));
                s.setNum_solped(rs.getString("num_solped"));
                s.setRecibido(rs.getString("recibido"));
                s.setProcesado(rs.getString("procesado"));
                s.setError(rs.getString("error"));
                s.setSolicitante(rs.getString("solicitante"));
                s.setSolicitanteTemp(rs.getString("SolicitanteTemp"));
                se.add(s);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarServiciosNO, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return se;
    }

    public boolean solped_ServiciosNODELETE(String fol) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        int validar;
        String query = "{call MM.solped_servicios_crea_modDELETE(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fol);
            validar = pst.executeUpdate();
            if (validar >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en solped_ServiciosNODELETE, ACC_SolicitudPedidos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public void InsertarServicios(ArrayList<SolpedServicios> sl) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.solped_servicios_creaINSERTAR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement ps = null;
        try {
            for (SolpedServicios s : sl) {
                ps = con.prepareStatement(sql);
                ps.setString(1, s.getFolio_sam());
                ps.setString(2, s.getNum_posicion_solped());
                ps.setString(3, s.getNum_posicion_solped2());
                ps.setString(4, s.getNum_servicio());
                ps.setString(5, s.getFecha());
                ps.setString(6, s.getHora());
                ps.setString(7, s.getTexto_breve());
                ps.setString(8, s.getCantidad());
                ps.setString(9, s.getUnidad_medida_base());
                ps.setString(10, s.getCantidad_base());
                ps.setString(11, s.getPrecio_bruto());
                ps.setString(12, s.getGrupo_articulos());
                ps.setString(13, s.getNum_cuenta_mayor());
                ps.setString(14, s.getCentro_coste());
                ps.setString(15, s.getNum_orde());
                ps.setString(16, s.getRecibido());
                ps.setString(17, s.getProcesado());
                ps.setString(18, s.getModificado());
                ps.setString(19, s.getError());
                ps.setString(20, s.getSolicitante());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarServicios, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public int retornposicionesSolped(String tabla, String user, String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int pos = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{Call MM.Solped_RevisarPos(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,tabla);
            ps.setString(2, user);
            ps.setString(3, folio);
            rs = ps.executeQuery();
            while(rs.next()){
                pos = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("Error en retornposicionesSolped, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pos;
    }
    
   
        public int retornfoliSolped(int foliosam, String indi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.Verificar_folSolPed(?,?)}";
        int ban = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, foliosam);
            ps.setString(2, indi);
            rs = ps.executeQuery();
            while (rs.next()) {
                    ban = 1;
                
            }
        } catch (Exception e) {
            System.err.println("Error  por " + e);
        }
        return ban;
    }

    
    public void Eliminartablas(String folio, String user, String ind) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{Call MM.Solped_Borrartablas(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, user);
            ps.setString(3, ind);
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("Error en EliminartablaError, ACC_SolicitudPedidos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    
    
        public String CheckFolio(String folio) {
        String x = "0";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null; 
        String sql = "{call MM.CrearsolPedidos_RevisarFolio(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            if (rs.next()) {
                x = "1";
            } else {
                x = folio;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return x;
    }


        public int Checko(String folio) {
        int x = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.CrearsolPedidos_RevisarFolio(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            if (rs.next()) {
                x = 1;
            } else {
                x = 2;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return x;
    }        
   

     public String ActualizarFolioss(String ipsf){
         String f = "";
         Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.creaSOLPED_guardarFolio(?,?)}";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, ipsf);
            ps.registerOutParameter(2, java.sql.Types.VARCHAR);
            ps.executeUpdate();
            f = ps.getString(2);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return f;
     }
        
}
