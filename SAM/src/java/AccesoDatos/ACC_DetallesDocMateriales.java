/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.DatosMaterialLista;
import Entidades.cabecera_doc_materiales;
import Entidades.detalles_doc_materiales;
import Entidades.detalles_posiciones_doc_material;
import Entidades.materiales;
import Entidades.movimientos_detalle;
/*Nuevas Consultas*/
import Entidades.movimientos_detalle_crea;
import Entidades.pedidoprov;
/*--------*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class ACC_DetallesDocMateriales {

    private static ACC_DetallesDocMateriales Instance = null;

    public static ACC_DetallesDocMateriales ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_DetallesDocMateriales();
        }
        return Instance;
    }

    // Consulta a Detalles y Cabecera de Doc Materiales para Fecha Contable
    public LinkedList<detalles_doc_materiales> ConsultaDocTabla(String lim,
            String cmov, String cen, String alm, String numcue, String fecha) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaFContable (?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cmov);
            ps.setString(3, cen);
            ps.setString(4, alm);
            ps.setString(5, numcue);
            ps.setString(6, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error al pintar datos" + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return ddmat;
    }

    //Consulta movimientos detalle crea para Fecha Contable
    public LinkedList<movimientos_detalle_crea> ConsultaTablaMovCrea(String lim, String cmov, String fecha) {
        LinkedList<movimientos_detalle_crea> movcrea = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MovimientosDetalleCrea_ConsultaFContable(?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cmov);
            ps.setString(3, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movcrea.add(mdc);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos detalle crea: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion: " + e);
            }
        }
        return movcrea;
    }

    //Consulta vacia
    public LinkedList<detalles_doc_materiales> ConsultaVaciaDocTable(String lim) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaVacia(?)}");
            ps.setString(1, lim);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setDescripcion_ES(rs.getString("descripcion_ES"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                d.setNombre1(rs.getString("nombre1"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    //consulta vacia - query 2
    public LinkedList<detalles_doc_materiales> SeleccionaMovDetalle() {
        LinkedList<detalles_doc_materiales> movdc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MovimientosDetalleCrea_ConsultaVacia}");
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setDescripcion_ES(rs.getString("texto_breve_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_compras"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                d.setFecha_contabilizacion(rs.getString("fecha"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad1"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_base"));
                d.setAlmacen_destino(rs.getString("almacen_receptor"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                d.setNombre1(rs.getString(""));
                movdc.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos_detalle_crea : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return movdc;
    }

    //Consulta Filtrada 
    public LinkedList<detalles_doc_materiales> ConsultaFiltradaDoc(String lim,
            String mat, String cen, String alm, String fecha, String nlote, String ncuenta,
            String mov) {
        LinkedList<detalles_doc_materiales> detdm = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaFiltrada(?, ?, ?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, mat);
            ps.setString(3, cen);
            ps.setString(4, alm);
            ps.setString(5, fecha);
            ps.setString(6, nlote);
            ps.setString(7, ncuenta);
            ps.setString(8, mov);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                detdm.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error al hacer la consulta Filtrada: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return detdm;
    }

    //consulta para accion Filtros query1
    public LinkedList<detalles_doc_materiales> ConsultaFiltrosDocTable(String lim) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraMaterialesMovimientos_Filtros(?)}");
            ps.setString(1, lim);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    //Consulta para accion Filtros query2
    public LinkedList<movimientos_detalle_crea> ConsultaMovDetalleFiltros() {
        LinkedList<movimientos_detalle_crea> movdc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MovimientosDetalleCrea_ConsultaFiltros}");
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movdc.add(mdc);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos_detalle_crea : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return movdc;
    }

    public static void main(String[] args) {
        LinkedList<detalles_doc_materiales> mat1 = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMaterialDocTable("500", "10000006", "", "", "", "", "");
        LinkedList<movimientos_detalle_crea> mate1 = ACC_DetallesDocMateriales.ObtenerInstancia().ConsultaMovDetalleMaterial("500", "10000006", "", "", "", "", "");
        for (int i = 0; i < mate1.size(); i++) {
            System.out.println(mate1.get(i).getNum_material());
        }
        for (int j = 0; j < mat1.size(); j++) {
            System.out.println(mat1.get(j).getNum_material());
        }
    }

    //Consulta para Accion Material query1
    public LinkedList<detalles_doc_materiales> ConsultaMaterialDocTable(String lim,
            String mat, String cen, String alm, String ncuenta, String mov, String fe) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaMaterial(?, ?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, mat);
            ps.setString(3, cen);
            ps.setString(4, alm);
            ps.setString(5, ncuenta);
            ps.setString(6, mov);
            ps.setString(7, fe);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    public LinkedList<detalles_doc_materiales> MM_ConsultaMaterialesEspacio(String lim,
            String mat, String cen, String alm, String ncuenta, String mov, String fe) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaMaterial_VACIO(?,?,?,?,?,?,?)}");
            ps.setString(1, lim);
            ps.setString(2, mat);
            ps.setString(3, cen);
            ps.setString(4, alm);
            ps.setString(5, ncuenta);
            ps.setString(6, mov);
            ps.setString(7, fe);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    // Consulta para Accion Material query2
    public LinkedList<movimientos_detalle_crea> ConsultaMovDetalleMaterial(String lim,
            String mat, String cen, String alm, String ncuenta, String mov, String fecha) {
        LinkedList<movimientos_detalle_crea> movdc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MovimientosDetalleCrea_ConsultaMat(?, ?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, mat);
            ps.setString(3, cen);
            ps.setString(4, alm);
            ps.setString(5, ncuenta);
            ps.setString(6, mov);
            ps.setString(7, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movdc.add(mdc);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos_detalle_crea : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return movdc;
    }

// Consulta para Accion Rangos de Material query1
    public LinkedList<detalles_doc_materiales> ConsultaRangosMatDocTable(String lim,
            String mat, String mat2, String cen, String alm, String ncuenta, String mov, String fe) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaRangoMateriales(?, ?, ?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, mat);
            ps.setString(3, mat2);
            ps.setString(4, cen);
            ps.setString(5, alm);
            ps.setString(6, ncuenta);
            ps.setString(7, mov);
            ps.setString(8, fe);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    //Consulta para Accion Rangos Material query2
    public LinkedList<movimientos_detalle_crea> ConsultaMovDetalleRangosMaterial(String lim,
            String mat, String mat2, String cen, String alm, String ncuenta, String mov, String fecha) {
        LinkedList<movimientos_detalle_crea> movdc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MovimientosDetalleCrea_ConsultaRangoMaterial(?, ?, ?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, mat);
            ps.setString(3, mat2);
            ps.setString(4, cen);
            ps.setString(5, alm);
            ps.setString(6, ncuenta);
            ps.setString(7, mov);
            ps.setString(8, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movdc.add(mdc);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos_detalle_crea : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return movdc;
    }

    // consulta para Accion Centros query1
    public LinkedList<detalles_doc_materiales> ConsultaCentroDocTable(String lim,
            String cen, String alm, String ncuenta, String mov, String fe) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaCentros(?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cen);
            ps.setString(3, alm);
            ps.setString(4, ncuenta);
            ps.setString(5, mov);
            ps.setString(6, fe);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    //consulta para accion centro query2
    public LinkedList<movimientos_detalle_crea> ConsultaMovDetalleCentros(String lim,
            String cen, String alm, String ncuenta, String mov, String fecha) {
        LinkedList<movimientos_detalle_crea> movdc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MovimientosDetalleCrea_ConsultaCentro(?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cen);
            ps.setString(3, alm);
            ps.setString(4, ncuenta);
            ps.setString(5, mov);
            ps.setString(6, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movdc.add(mdc);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos_detalle_crea : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return movdc;
    }

    //Consulta para accion almacen query1
    public LinkedList<detalles_doc_materiales> ConsultaAlmacenDocTable(String lim,
            String cen, String alm, String ncuenta, String mov, String fe) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMaterial_ConsultaAlmacen(?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cen);
            ps.setString(3, alm);
            ps.setString(4, ncuenta);
            ps.setString(5, mov);
            ps.setString(6, fe);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    //consulta para accion almacen query2
    public LinkedList<movimientos_detalle_crea> ConsultaMovDetalleAlmacen(String lim,
            String cen, String alm, String ncuenta, String mov, String fecha) {
        LinkedList<movimientos_detalle_crea> movdc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MovimientosDetalleCrea_ConsultaAlmacen(?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cen);
            ps.setString(3, alm);
            ps.setString(4, ncuenta);
            ps.setString(5, mov);
            ps.setString(6, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movdc.add(mdc);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos_detalle_crea : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return movdc;
    }

    //consulta para accion proveedor query1
    public LinkedList<detalles_doc_materiales> ConsultaProveedorDocTable(String lim,
            String cen, String alm, String ncuenta, String mov, String fe) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaProveedor(?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cen);
            ps.setString(3, alm);
            ps.setString(4, ncuenta);
            ps.setString(5, mov);
            ps.setString(6, fe);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    //consulta para accion proveedores query2
    public LinkedList<movimientos_detalle_crea> ConsultaMovDetalleProveedor(String lim,
            String cen, String alm, String ncuenta, String mov, String fecha) {
        LinkedList<movimientos_detalle_crea> movdc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MovimientosDetalleCrea_ConsultaProveedor(?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cen);
            ps.setString(3, alm);
            ps.setString(4, ncuenta);
            ps.setString(5, mov);
            ps.setString(6, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movdc.add(mdc);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos_detalle_crea : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return movdc;
    }

    // consulta para accion clase movimiento query1
    public LinkedList<detalles_doc_materiales> ConsultaClMovimientoDocTable(String lim,
            String cen, String alm, String ncuenta, String mov, String fe) {
        LinkedList<detalles_doc_materiales> ddmat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.DetallesCabeceraDocMateriales_ConsultaMovimiento(?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, cen);
            ps.setString(3, alm);
            ps.setString(4, ncuenta);
            ps.setString(5, mov);
            ps.setString(6, fe);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ddmat.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerra conexion");
            }
        }
        return ddmat;
    }

    //consulta para accion clase movimiento query2
    public LinkedList<movimientos_detalle_crea> ConsultaMovDetalleCMovimiento(String lim,
            String mov, String fecha) {
        LinkedList<movimientos_detalle_crea> movdc = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MovimientosDetalleCrea_ConsultaProveedor(?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, mov);
            ps.setString(3, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movdc.add(mdc);
            }
        } catch (Exception e) {
            System.err.println("Error de consulta movimientos_detalle_crea : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return movdc;
    }

    public ArrayList<detalles_doc_materiales> CargarTablaDocSAP(String id, String Des) {
        ArrayList<detalles_doc_materiales> cdm = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.DocumentosMaterial_CargarDatosTablaSAP(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, Des);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales dm = new detalles_doc_materiales();
                dm.setNum_doc_material(rs.getString("num_doc_material"));
                dm.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setNum_pedido(rs.getString("num_pedido"));
                dm.setNum_material(rs.getString("num_material"));
                dm.setDescripcion(rs.getString(Des));
                dm.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                dm.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                dm.setCentro_coste(rs.getString("centro_coste"));
                dm.setNum_orden(rs.getString("num_orden"));
                dm.setSociedad(rs.getString("sociedad"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setCentro(rs.getString("centro"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setAlmacen_destino(rs.getString("almacen_destino"));
                dm.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                cdm.add(dm);
            }
        } catch (Exception e) {
            System.err.println("error en CargarTablaDocSAP por" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cdm;
    }

    public ArrayList<movimientos_detalle_crea> CargarTablaDocSAM(String id) {
        ArrayList<movimientos_detalle_crea> cdm = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.DocumentosMaterial_CargarDatosTablaSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle_crea dm = new movimientos_detalle_crea();
                dm.setNum_doc_material(rs.getString("folio_sam"));
                dm.setPosicion(rs.getString("indice_registro_no_valido"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setNum_doc_compras(rs.getString("num_doc_compras"));
                dm.setNum_material(rs.getString("num_material"));
                dm.setTexto_breve_material(rs.getString("texto_breve_material"));
                dm.setCantidad_unidad_medida_entrada(rs.getString("cantidad1"));
                dm.setUnidad_medida_entrada(rs.getString("unidad_medida_base"));
                dm.setCentro_coste(rs.getString("centro_coste"));
                dm.setNum_orden(rs.getString("num_orden"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setCentro(rs.getString("centro"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setAlmacen_receptor(rs.getString("almacen_receptor"));
                dm.setNum_lote_proveedor(rs.getString("num_lote_proveedor"));
                cdm.add(dm);
            }
        } catch (Exception e) {
            System.err.println("error en CargarTablaDocSAM por" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cdm;
    }

    public int verificar311ws(String folio) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call }";
        try {
        } catch (Exception e) {
            System.err.println("error en verificar311ws por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public detalles_doc_materiales ObtenerPosicionDetalle(String doc, String pos, String Des) {
        detalles_doc_materiales dm = new detalles_doc_materiales();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.DocumentosMaterial_CargarPosicionSAP(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            ps.setString(3, Des);
            rs = ps.executeQuery();
            while (rs.next()) {
                dm.setNum_material(rs.getString("num_material"));
                dm.setDescripcion(rs.getString(Des));
                dm.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
                dm.setGrupo_articulos(rs.getString("grupo_articulos"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setCentro(rs.getString("centro"));
                dm.setNombre(rs.getString("nombre"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                dm.setAlmacen_destino(rs.getString("almacen_destino"));
                dm.setPuesto_descarga(rs.getString("puesto_descarga"));
                dm.setNum_pedido(rs.getString("num_pedido"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setNum_lote_proveedor("");
                dm.setProveedor_recibe_entrega(rs.getString("proveedor_recibe_entrega"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerPosicionDetalle por:  " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return dm;
    }

    public detalles_doc_materiales ObtenerPosicionDetalleSAM(String doc, String pos) {
        detalles_doc_materiales dm = new detalles_doc_materiales();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.DocumentosMaterial_CargarPosicionSAM(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ps.setString(2, pos);
            rs = ps.executeQuery();
            while (rs.next()) {
                dm.setNum_material(rs.getString("num_material"));
                dm.setDescripcion(rs.getString("texto_breve_material"));
                dm.setNum_material_utilizado_proveedor("");
                dm.setGrupo_articulos("");
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setIndicador_debe_haber("");
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setCentro(rs.getString("centro"));
                dm.setNombre("");
                dm.setAlmacen(rs.getString("almacen"));
                dm.setDenominacion_almacen("");
                dm.setAlmacen_destino(rs.getString("almacen_receptor"));
                dm.setPuesto_descarga(rs.getString(""));
                dm.setNum_pedido(rs.getString("num_doc_compras"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setNum_lote_proveedor(rs.getString("num_lote_proveedor"));
                dm.setProveedor_recibe_entrega("");
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerPosicionDetalle por:  " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return dm;
    }

    public LinkedList<detalles_doc_materiales> ConsultaDetallesDocTable(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<detalles_doc_materiales> docs = new LinkedList();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_material(rs.getString("num_material"));
                d.setCentro(rs.getString("centro"));
                d.setAlmacen(rs.getString("almacen"));
                d.setClase_movimiento(rs.getString("clase_movimiento"));
                d.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
                d.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setAlmacen_destino(rs.getString("almacen_destino"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return docs;
    }

    public LinkedList<detalles_doc_materiales> ConsultaDetallesDocById(String query, String Des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<detalles_doc_materiales> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                detalles_doc_materiales dm = new detalles_doc_materiales();
                dm.setId_dd_(rs.getInt("id_dd_"));
                dm.setNum_doc_material(rs.getString("num_doc_material"));
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setNum_pedido(rs.getString("num_pedido"));
                dm.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                dm.setPuesto_descarga(rs.getString("puesto_descarga"));
                dm.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                dm.setNum_material(rs.getString("num_material"));
                dm.setDescripcion(rs.getString(Des));
                dm.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                dm.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                dm.setCentro_coste(rs.getString("centro_coste"));
                dm.setNum_orden(rs.getString("num_orden"));
                dm.setSociedad(rs.getString("sociedad"));
                dm.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                dm.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setCentro(rs.getString("centro"));
                dm.setNombre(rs.getString("nombre"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                dm.setProveedor_recibe_entrega(rs.getString("proveedor_recibe_entrega"));
                dm.setNombre1(rs.getString("nombre1"));
                dm.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                dm.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                dm.setGrupo_articulos(rs.getString("grupo_articulos"));
                dm.setFolio_sam(rs.getString("folio_sam"));
                dm.setAlmacen_destino(rs.getString("almacen_destino"));
                docs.add(dm);
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return docs;
    }

    public detalles_doc_materiales ConsultaDetalles(String query, String Des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        detalles_doc_materiales dm = new detalles_doc_materiales();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setId_dd_(rs.getInt("id_dd_"));
                dm.setNum_doc_material(rs.getString("num_doc_material"));
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setNum_pedido(rs.getString("num_pedido"));
                dm.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                dm.setPuesto_descarga(rs.getString("puesto_descarga"));
                dm.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                dm.setNum_material(rs.getString("num_material"));
                dm.setDescripcion(rs.getString(Des));
                dm.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                dm.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                dm.setCentro_coste(rs.getString("centro_coste"));
                dm.setNum_orden(rs.getString("num_orden"));
                dm.setSociedad(rs.getString("sociedad"));
                dm.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                dm.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setCentro(rs.getString("centro"));
                dm.setNombre(rs.getString("nombre"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                dm.setProveedor_recibe_entrega(rs.getString("proveedor_recibe_entrega"));
                dm.setNombre1(rs.getString("nombre1"));
                dm.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                dm.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                dm.setGrupo_articulos(rs.getString("grupo_articulos"));
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return dm;
    }

    /*Consultas movimientos_detalle_crea */
    public LinkedList<movimientos_detalle_crea> SelectMovimientosDetalles(String query) {
        LinkedList<movimientos_detalle_crea> movimientos = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                movimientos_detalle_crea mdc = new movimientos_detalle_crea();
                mdc.setFolio_sam(rs.getString("folio_sam"));
                mdc.setNum_material(rs.getString("num_material"));
                mdc.setCentro(rs.getString("centro"));
                mdc.setAlmacen(rs.getString("almacen"));
                mdc.setClase_movimiento(rs.getString("clase_movimiento"));
                mdc.setNum_doc_material(rs.getString("num_doc_material"));
                mdc.setNum_posicion_doc_compras(rs.getString("indice_registro_no_valido"));
                mdc.setFecha(rs.getString("fecha"));
                mdc.setCantidad1(rs.getString("cantidad1"));
                mdc.setUnidad_medidabase(rs.getString("unidad_medida_base"));
                mdc.setAlmacen_destino(rs.getString("almacen_receptor"));
                mdc.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                movimientos.add(mdc);
            }
        } catch (Exception ex) {
            System.err.println("Error en ACC_detallesDocMateriales en el metodo SelectMovimientosDetalles por: " + ex);
        }
        cnx.CerrarConexion(con);
        return movimientos;
    }

    /*----------------------------------*/
 /*--Filtros detalles_doc_materiales--*/
    public LinkedList<detalles_doc_materiales> SelectDetallesMateriales(String query) {
        LinkedList<detalles_doc_materiales> detalles = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                detalles_doc_materiales dm = new detalles_doc_materiales();
                dm.setId_dd_(rs.getInt("id_dd_"));
                dm.setNum_doc_material(rs.getString("num_doc_material"));
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setNum_pedido(rs.getString("num_pedido"));
                dm.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                dm.setPuesto_descarga(rs.getString("puesto_descarga"));
                dm.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                dm.setNum_material(rs.getString("num_material"));
                dm.setDescripcion(rs.getString("descripcion_ES"));
                dm.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                dm.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                dm.setCentro_coste(rs.getString("centro_coste"));
                dm.setNum_orden(rs.getString("num_orden"));
                dm.setSociedad(rs.getString("sociedad"));
                dm.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                dm.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setCentro(rs.getString("centro"));
                dm.setNombre(rs.getString("nombre"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                dm.setProveedor_recibe_entrega(rs.getString("proveedor_recibe_entrega"));
                dm.setNombre1(rs.getString("nombre1"));
                dm.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                dm.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                dm.setGrupo_articulos(rs.getString("grupo_articulos"));
                dm.setFolio_sam(rs.getString("folio_sam"));
                dm.setFecha_contabilizacion(rs.getString("fecha_contabilizacion_doc"));
                detalles.add(dm);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo SelectDetallesMateriales por:" + ex);
        }
        cnx.CerrarConexion(con);
        return detalles;
    }

    /**
     * **********************************
     */
//    public LinkedList<detalles_doc_materiales> ConsultaPosDoc(String num) {
//        String query = "SELECT * FROM detalles_doc_materiales WHERE num_doc_material = '" + num + "' OR folio_sam = '" + num + "' ORDER BY pos_doc_compras";
//        /*boolean checkNum = IsNumeric(num);
//        if (checkNum) {
//            Long nu = Long.parseLong(num);
//            query = "SELECT * FROM solped_posiciones_vis WHERE CAST(folio_sap AS bigint) = '" + nu + "'";
//        } else {
//            query = "SELECT * FROM solped_posiciones_vis WHERE folio_sam = '" + num + "'";
//        }*/
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        LinkedList<detalles_doc_materiales> sol = new LinkedList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {
//                detalles_doc_materiales s = new detalles_doc_materiales();
//                s.setNum_posicion_doc_compras(rs.getString("pos_doc_compras"));
//                sol.add(s);
//            }
//        } catch (Exception e) {
//            System.err.println("Error en Consulta por " + e);
//        }
//        cnx.CerrarConexion(con);
//        return sol;
//    }

    public detalles_posiciones_doc_material ConsultaDetal(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        detalles_posiciones_doc_material doc = new detalles_posiciones_doc_material();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                detalles_posiciones_doc_material dm = new detalles_posiciones_doc_material();
                doc.setMaterial(rs.getString("num_material"));
                doc.setNum_material_proveedor(rs.getString("num_material_utilizado_proveedor"));
                doc.setGrupo_articulos(rs.getString("grupo_articulos"));
                doc.setClase_movimiento(rs.getString("clase_movimiento"));
                doc.setIndicador_lote_especial(rs.getString("indicador_stock_especial"));
                doc.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                doc.setNombre1(rs.getString("nombre1"));
                doc.setCentro(rs.getString("centro"));
                doc.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                doc.setAlmacen(rs.getString("almacen"));
                doc.setPuesto_descarga(rs.getString("puesto_descarga"));
                doc.setPedido(rs.getString("num_pedido"));
                doc.setPosicion_pedido(rs.getString("num_posicion_doc_compras"));
                doc.setProveedor_recibe_entrega(rs.getString("proveedor_recibe_entrega"));
                doc.setLote(rs.getString("num_lote"));
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return doc;
    }

    public ArrayList<detalles_doc_materiales> ObtenerMov101Doc(String doc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.Movimientos_CargarMov101Doc(?)}";
        ArrayList<detalles_doc_materiales> ddm = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            rs = ps.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setFolio_sam(rs.getString("folio_sam"));
                d.setNum_pedido(rs.getString("num_pedido"));
                ddm.add(d);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        cnx.CerrarConexion(con);
        return ddm;
    }

    public ArrayList<detalles_doc_materiales> ObetenerDocmov102Vis(String doc, String idioma) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<detalles_doc_materiales> dd = new ArrayList<>();
        String sql = "{CALL MM.Movimientos_ObtenerDoc102Vis(?,?)}";
        String des = "descripcion_" + idioma;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, doc);
            st.setString(2, des);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                detalles_doc_materiales d = new detalles_doc_materiales();
                d.setNum_doc_material(rs.getString("num_doc_material"));
                d.setPos_doc_compras(rs.getString("pos_doc_compras"));
                d.setNum_material(rs.getString("num_material"));
                d.setDescripcion(rs.getString(des));
                d.setAlmacen(rs.getString("almacen"));
                d.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                d.setNum_lote(rs.getString("num_lote"));
                d.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                d.setCentro(rs.getString("centro"));
                d.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                d.setNum_pedido(rs.getString("num_pedido"));
                d.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                d.setCentro_coste(rs.getString("centro_coste"));
                d.setNum_orden(rs.getString("num_orden"));
                d.setCantidad_cancelada(rs.getString("cantidad_cancelada"));
                dd.add(d);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return dd;
    }

    public ArrayList<movimientos_detalle> ObtenerMov102crea(String doc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<movimientos_detalle> md = new ArrayList<>();
        String sql = "{CALL  MM.Movimientos_Movimientos_ObtenerDoc102Crea(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, doc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                movimientos_detalle m = new movimientos_detalle();
                m.setFolio_sam(rs.getString("folio_sam"));
                m.setIndice_registro_no_valido(rs.getString("indice_registro_no_valido"));
                m.setNum_material(rs.getString("num_material"));
                m.setTexto_breve_material(rs.getString("texto_breve_material"));
                m.setAlmacen(rs.getString("almacen"));
                m.setNum_lote(rs.getString("num_lote"));
                m.setCantidad1(rs.getString("cantidad1"));
                m.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                m.setCentro(rs.getString("centro"));
                m.setFecha(rs.getString("fecha"));
                m.setNum_doc_compras(rs.getString("num_doc_compras"));
                m.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                m.setCentro_coste(rs.getString("centro_coste"));
                m.setNum_orden(rs.getString("num_orden"));
                m.setClase_coste(rs.getString("clase_coste"));

                String query = "{CALL  MM.MovimientosCantidadCancelada(?,?)}";
                PreparedStatement ps2 = con.prepareStatement(query);
                ps2.setString(1, doc);
                ps2.setString(2, m.getNum_posicion_doc_compras());
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    m.setCantidad_cancelada(rs2.getString("cantidad_cancelada") + "00");
                }
                md.add(m);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return md;
    }

    public detalles_doc_materiales ConsultaPosi(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        detalles_doc_materiales dm = new detalles_doc_materiales();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setNum_doc_material(rs.getString("num_doc_material"));
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setNum_pedido(rs.getString("num_pedido"));
                dm.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                dm.setPuesto_descarga(rs.getString("puesto_descarga"));
                dm.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                dm.setNum_material(rs.getString("num_material"));
                dm.setDescripcion_ES(rs.getString("descripcion_ES"));
                dm.setDescripcion_EN(rs.getString("descripcion_EN"));
                dm.setCantidad_unidad_medida_entrada(rs.getString("cantidad_unidad_medida_entrada"));
                dm.setUnidad_medida_entrada(rs.getString("unidad_medida_entrada"));
                dm.setCentro_coste(rs.getString("centro_coste"));
                dm.setNum_orden(rs.getString("num_orden"));
                dm.setSociedad(rs.getString("sociedad"));
                dm.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                dm.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setCentro(rs.getString("centro"));
                dm.setNombre(rs.getString("nombre"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                dm.setProveedor_recibe_entrega(rs.getString("proveedor_recibe_entrega"));
                dm.setNombre1(rs.getString("nombre1"));
                dm.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                dm.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                dm.setGrupo_articulos(rs.getString("grupo_articulos"));
                dm.setAlmacen_destino(rs.getString("almacen_destino"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return dm;
    }

    public detalles_doc_materiales ConsultaPosiCrea(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        detalles_doc_materiales dm = new detalles_doc_materiales();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setNum_doc_material(rs.getString("folio_sam"));
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setNum_pedido(rs.getString("num_doc_compras"));
                dm.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                //dm.setPuesto_descarga(rs.getString("puesto_descarga"));
                //dm.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                dm.setNum_material(rs.getString("num_material"));
                dm.setDescripcion_ES(rs.getString("texto_breve_material"));
                //dm.setDescripcion_EN(rs.getString("descripcion_EN"));
                dm.setCantidad_unidad_medida_entrada(rs.getString("cantidad1"));
                dm.setUnidad_medida_entrada(rs.getString("unidad_medida_base"));
                dm.setCentro_coste(rs.getString("centro_coste"));
                dm.setNum_orden(rs.getString("num_orden"));
                //dm.setSociedad(rs.getString("sociedad"));
                //dm.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                //dm.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setCentro(rs.getString("centro"));
                //dm.setNombre(rs.getString("nombre"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setAlmacen_destino(rs.getString("almacen_receptor"));
                dm.setNum_lote_proveedor(rs.getString("num_lote_proveedor"));
                //dm.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                //dm.setProveedor_recibe_entrega(rs.getString("proveedor_recibe_entrega"));
                //dm.setNombre1(rs.getString("nombre1"));
                //dm.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                //dm.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                //dm.setGrupo_articulos(rs.getString("grupo_articulos"));

            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return dm;
    }

    public LinkedList<movimientos_detalle_crea> ConsultaDetallesDocCrea(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<movimientos_detalle_crea> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                movimientos_detalle_crea dm = new movimientos_detalle_crea();
                dm.setNum_doc_material(rs.getString("folio_sam"));
                dm.setPosicion(rs.getString("indice_registro_no_valido"));
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setNum_lote(rs.getString("num_lote"));
                dm.setClase_movimiento(rs.getString("clase_movimiento"));
                dm.setNum_doc_compras(rs.getString("num_doc_compras"));
                dm.setNum_posicion_doc_compras(rs.getString("num_posicion_doc_compras"));
                //dm.setPuesto_descarga(rs.getString("puesto_descarga"));
                //dm.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                dm.setNum_material(rs.getString("num_material"));
                dm.setTexto_breve_material(rs.getString("texto_breve_material"));
                dm.setCantidad_unidad_medida_entrada(rs.getString("cantidad1"));
                dm.setUnidad_medida_entrada(rs.getString("unidad_medida_base"));
                dm.setCentro_coste(rs.getString("centro_coste"));
                dm.setNum_orden(rs.getString("num_orden"));
                //dm.setSociedad(rs.getString("sociedad"));
                //dm.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                //dm.setNum_material_utilizado_proveedor(rs.getString("num_material_utilizado_proveedor"));
                dm.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                dm.setCentro(rs.getString("centro"));
                //dm.setNombre(rs.getString("nombre"));
                dm.setAlmacen(rs.getString("almacen"));
                dm.setAlmacen_receptor(rs.getString("almacen_receptor"));
                //dm.setDenominacion_almacen(rs.getString("denominacion_almacen"));
                //dm.setProveedor_recibe_entrega(rs.getString("proveedor_recibe_entrega"));
                //dm.setNombre1(rs.getString("nombre1"));
                //dm.setIndicador_debe_haber(rs.getString("indicador_debe_haber"));
                //dm.setCampo_texto_longitud(rs.getString("campo_texto_longitud"));
                //dm.setGrupo_articulos(rs.getString("grupo_articulos"));
                //dm.setFolio_sam(rs.getString("folio_sam"));
                docs.add(dm);
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return docs;
    }

    public DatosMaterialLista ConsultaDetallesMGA(String mate) {
        String query = "SELECT grupo_articulos FROM materiales WHERE material = '" + mate + "'";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        DatosMaterialLista dm = new DatosMaterialLista();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setGrupo_articulos(rs.getString("grupo_articulos"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return dm;
    }

    public DatosMaterialLista ConsultaDetallesCen(String centro) {
        String query = "SELECT descripcion FROM centros WHERE centro = '" + centro + "'";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        DatosMaterialLista dm = new DatosMaterialLista();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setDescripcion_centro(rs.getString("descripcion"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return dm;
    }

    public DatosMaterialLista ConsultaDetallesAm(String almacen, String idioma) {
        String descripcion = "";
        if (idioma.equals("ES")) {
            descripcion = "descripcion_ES";
        } else {
            descripcion = "descripcion_EN";
        }

        String query = "SELECT " + descripcion + " FROM almacenes WHERE id_almacen = '" + almacen + "'";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        DatosMaterialLista dm = new DatosMaterialLista();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setDescripcion_almacen(rs.getString(descripcion));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return dm;
    }

    public DatosMaterialLista ConsultaDetallesProv(String pedido) {
        String query = "SELECT num_cuenta_proveedor, nombre1 FROM pedidos_detalle WHERE num_doc_compras = '" + pedido + "'";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        DatosMaterialLista dm = new DatosMaterialLista();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                dm.setNombre1(rs.getString("nombre1"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return dm;
    }

    public pedidoprov ConsultaDetallesProvs(String pedido) {
        String query = "SELECT num_cuenta_proveedor, nombre1 FROM pedidos_detalle WHERE num_doc_compras = '" + pedido + "'";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        pedidoprov dm = new pedidoprov();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setProveedor(rs.getString("num_cuenta_proveedor"));
                dm.setDescripcion(rs.getString("nombre1"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return dm;
    }
}
