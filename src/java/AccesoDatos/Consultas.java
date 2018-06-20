/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.reporte_ivent;
import Servlets.peticionModuloListaOrdenes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Consultas {

    private static Consultas instanciar = null;

    public static Consultas ObtenerInstancia() {
        if (instanciar == null) {
            instanciar = new Consultas();
        }
        return instanciar;
    }

    public ArrayList<reporte_ivent> CargarReportesIvent(String docu) {
        ArrayList<reporte_ivent> ri = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocGetRepIvent(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, docu);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_ivent r = new reporte_ivent();
                r.setPosicion(rs.getString("posicion"));
                r.setMaterial(rs.getString("material"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setAlmacen(rs.getString("almacen"));
                r.setCantidad(rs.getString("cantidad"));
                r.setMensaje(rs.getString("mensaje"));
                ri.add(r);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ri;
    }

    public ArrayList<reporte_ivent> CargarRep2(String docu) {
        ArrayList<reporte_ivent> ri = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.ChecarEnvi(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, docu);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_ivent r = new reporte_ivent();
                r.setPosicion(rs.getString("folio"));
                ri.add(r);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ri;
    }

    public ArrayList<reporte_ivent> VerificarMensaje311(String docu) {
        ArrayList<reporte_ivent> ri = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocumentos_VerificarMensaje(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, docu);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte_ivent r = new reporte_ivent();
                r.setPosicion(rs.getString("mensaje"));
                ri.add(r);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ri;
    }

    public void ActualizarRpoIvent(String docu, String pos, String mate, String alma, String msg) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocActIventMSG(?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, docu);
            ps.setString(2, pos);
            ps.setString(3, mate);
            ps.setString(4, alma);
            ps.setString(5, msg);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizarRpCancelacion(String docu, String folio, String msg) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocActuCancelacion(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, docu);
            ps.setString(2, folio);
            ps.setString(3, msg);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void reporte_ivent(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.reporte_ivent_MOM(?,?,?,?,?,?,?,?,?,?)}";
        try {
            String n2 = "";
            for (int n = v1.length(); n < 4; n++) {
                n2 += "0";
            }
            n2 += v1;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, n2);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public boolean posicionesMM(String folio, String cnt) {
        int c = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL MM.RegistrosMM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (Exception e) {
            System.err.println("Error en Cantidad Pos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return Integer.parseInt(cnt) == c;
    }

    public void CabeceraCreaMov(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14, String v15, String v16, String v17, String v18, String v19, String v20) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
//        String query = "{CALL MM.InsertMovimientosCabeceraCrea_MOM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        String query = "{CALL MM.InsertMovimientosCabeceraCreaMM_MOM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.setString(15, v15);
            ps.setString(16, v16);
            ps.setString(17, v17);
            ps.setString(18, v18);
            ps.setString(19, v19);
            ps.setString(20, v20);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error esta vaina por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void BorrarCabMM(String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.BoraraCabeceraMOM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, folio);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error esta vaina por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void BorrarRegistroMM(String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.BorarRegistrosMM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, folio);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error esta vaina por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void BorrarHistorialMM(String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.BorraPedidoHistorialMM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, folio);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error esta vaina por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizarIndReporteIvent(String folio, String folio2) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.ActualizarIndiReporteIvent(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, folio);
            ps.setString(2, folio2);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error esta vaina por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void InsertarMovDetallesCrea(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14, String v15, String v16, String v17, String v18, String v19, String v20, String v21, String v22, String v23, String v24, String v25, String v26, String v27, String v28, String v29, String v30, String v31, String v32, String v33, String v34, String v35, String v36, String v37, String v38, String v39, String v40, String v41, String v42, String v43, String v44, String v45, String v46, String v47, String v48, String v49, String v50, String v51) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.MovimientosDetalleCrea_MOM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.setString(15, v15);
            ps.setString(16, v16);
            ps.setString(17, v17);
            ps.setString(18, v18);
            ps.setString(19, v19);
            ps.setString(20, v20);
            ps.setString(21, v21);
            ps.setString(22, v22);
            ps.setString(23, v23);
            ps.setString(24, v24);
            ps.setString(25, v25);
            ps.setString(26, v26);
            ps.setString(27, v27);
            ps.setString(28, v28);
            ps.setString(29, v39);
            ps.setString(30, v30);
            ps.setString(31, v31);
            ps.setString(32, v32);
            ps.setString(33, v33);
            ps.setString(34, v34);
            ps.setString(35, v35);
            ps.setString(36, v36);
            ps.setString(37, v37);
            ps.setString(38, v38);
            ps.setString(39, v39);
            ps.setString(40, v40);
            ps.setString(41, v41);
            ps.setString(42, v42);
            ps.setString(43, v43);
            ps.setString(44, v44);
            ps.setString(45, v45);
            ps.setString(46, v46);
            ps.setString(47, v47);
            ps.setString(48, v48);
            ps.setString(49, v49);
            ps.setString(40, v40);
            ps.setString(41, v41);
            ps.setString(42, v42);
            ps.setString(43, v43);
            ps.setString(44, v44);
            ps.setString(45, v45);
            ps.setString(46, v46);
            ps.setString(47, v47);
            ps.setString(48, v48);
            ps.setString(49, v49);
            ps.setString(50, v50);
            ps.setString(51, v51);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error Insertar Movimientos Detalles Crea por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizarPedidosDetalle(String v1, String v2, String v3, String v4) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.UpdatePedidosDetalle_MOM(?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error Actualizar Movimientos Detalles Crea por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void InsertarPedidosHistorial(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14, String v15, String v16) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.PedidosHistorial_MOM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.setString(15, v15);
            ps.setString(16, v16);

            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error Insertar Pedidos Historial por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizarDetallesDocMateriales(String v1, String v2, String v3) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.UpdateDetallesDocMateriales_MOM(?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error Actualizar DetallesDocMateriales por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizarMovimientosDetalleCrea(String v1, String v2, String v3) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.UpdateMovimientosDetalleCrea_MOM(?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error Update MovimientosDetalleCrea por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void PosicionesCreaDet(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14, String v15, String v16, String v17, String v18, String v19, String v20, String v21, String v22, String v23, String v24, String v25, String v26, String v27, String v28, String v29, String v30, String v31, String v32, String v33, String v34, String v35, String v36, String v37, String v38, String v39, String v40, String v41, String v42, String v43, String v44, String v45, String v46, String v47, String v48, String v49, String v50, String v51, String v52, String v53, String v54, String v55) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.posiciones_MovMateriales_MOM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.setString(15, v15);
            ps.setString(16, v16);
            ps.setString(17, v17);
            ps.setString(18, v18);
            ps.setString(19, v19);
            ps.setString(20, v20);
            ps.setString(21, v21);
            ps.setString(22, v22);
            ps.setString(23, v23);
            ps.setString(24, v24);
            ps.setString(25, v25);
            ps.setString(26, v26);
            ps.setString(27, v27);
            ps.setString(28, v28);
            ps.setString(29, v29);
            ps.setString(30, v30);
            ps.setString(31, v31);
            ps.setString(32, v32);
            ps.setString(33, v33);
            ps.setString(34, v34);
            ps.setString(35, v35);
            ps.setString(36, v36);
            ps.setString(37, v37);
            ps.setString(38, v38);
            ps.setString(39, v39);
            ps.setString(40, v40);
            ps.setString(41, v41);
            ps.setString(42, v42);
            ps.setString(43, v43);
            ps.setString(44, v44);
            ps.setString(45, v45);
            ps.setString(46, v46);
            ps.setString(47, v47);
            ps.setString(48, v48);
            ps.setString(49, v49);
            ps.setString(50, v50);
            ps.setString(51, v51);
            ps.setString(52, v52);
            ps.setString(53, v53);
            ps.setString(54, v54);
            ps.setString(55, v55);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void CabeceraCreaDet(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14, String v15, String v16, String v17, String v18, String v19, String v20, String v21, String v22, String v23, String v24, String v25, String v26, String v27, String v28, String v29, String v30, String v31, String v32, String v33, String v34, String v35, String v36, String v37, String v38, String v39, String v40, String v41, String v42, String v43, String v44, String v45, String v46, String v47, String v48, String v49, String v50, String v51) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.InsertMovimientosDetalleCrea_MOM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.setString(15, v15);
            ps.setString(16, v16);
            ps.setString(17, v17);
            ps.setString(18, v18);
            ps.setString(19, v19);
            ps.setString(20, v20);
            ps.setString(21, v21);
            ps.setString(22, v22);
            ps.setString(23, v23);
            ps.setString(24, v24);
            ps.setString(25, v25);
            ps.setString(26, v26);
            ps.setString(27, v27);
            ps.setString(28, v28);
            ps.setString(29, v29);
            ps.setString(30, v30);
            ps.setString(31, v31);
            ps.setString(32, v32);
            ps.setString(33, v33);
            ps.setString(34, v34);
            ps.setString(35, v35);
            ps.setString(36, v36);
            ps.setString(37, v37);
            ps.setString(38, v38);
            ps.setString(39, v39);
            ps.setString(40, v40);
            ps.setString(41, v41);
            ps.setString(42, v42);
            ps.setString(43, v43);
            ps.setString(44, v44);
            ps.setString(45, v45);
            ps.setString(46, v46);
            ps.setString(47, v47);
            ps.setString(48, v48);
            ps.setString(49, v49);
            ps.setString(50, v50);
            ps.setString(51, v51);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public boolean Insert(String query) {
        Conexion cnx = new Conexion();
        Connection Con = cnx.ObtenerConexion();
        int validar;
        try {
            Statement st = Con.createStatement();
            validar = st.executeUpdate(query);
            if (validar >= 0) {
                cnx.CerrarConexion(Con);
                return true;
            } else {
                cnx.CerrarConexion(Con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
        }
        cnx.CerrarConexion(Con);
        return false;
    }

    public boolean Update(String tabla, String campos, String condicion) {
        Conexion cnx = new Conexion();
        Connection Con = cnx.ObtenerConexion();
        int validar;
        String query = "update " + tabla + " set " + campos + " where " + condicion;
        try {
            Statement st = Con.createStatement();
            validar = st.executeUpdate(query);
            if (validar >= 0) {
                cnx.CerrarConexion(Con);
                return true;
            } else {
                cnx.CerrarConexion(Con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        cnx.CerrarConexion(Con);
        return false;
    }

    public boolean Delete(String query) {
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
            System.err.println("Error:" + ex);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public void ExecuteQuery(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st = con.createStatement();
            st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String GetTolerancia(String pedido, String pos) {
        String Tole = "0";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String q = "{CALL MM.Cnf_Obtenertolerancia(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, pedido);
            ps.setString(2, pos);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tole = rs.getString("tolerancia");
            }

        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            cnx.CerrarConexion(con);
        }
        return Tole;
    }

    public String ObtenerFechaActualServidor() {
        Date fecha = new Date();
        DateFormat fFecha = new SimpleDateFormat("yyyy-MM-dd");
        String calendar = fFecha.format(fecha);
        return calendar;
    }

    public String ObtenerhoraActualServidor() {
        Date time = new Date();
        DateFormat fFecha = new SimpleDateFormat("HH:mm:ss");
        String tie = fFecha.format(time);
        return tie;
    }

    public static void main(String[] args) {
        Consultas sd = new Consultas();

        System.out.println(sd.ObtenerhoraActualServidor());
    }

    public String Chepos(int data) {
        String i = String.valueOf(data);
        if (data < 10) {
            i = "000" + data + "0";
        }
        if (data >= 10 && data < 100) {
            i = "00" + data + "0";
        }
        if (data >= 100 && data < 1000) {
            i = "0" + data + "0";
        }
        if (data >= 1000 && data < 10000) {
            i = data + "0";
        }
        return i;
    }

    public String ObtenerFechaContableMov() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String fcont = "";
        String sql = "{CALL dbo.SELECT_fecha_contable_ivend}";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fcont = rs.getString("fecha_contable");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fcont;
    }

    public void DefectosCalidad(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL QM.IngresaCabeceraDefectos_MOM(?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void PosDefCalidad(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL QM.posicionesDefectos_Cld(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void TxtDefCalidad(String v1, String v2, String v3, String v4) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL QM.TextosDefectos_CLD(?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en txt Calidad por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void DecisionEmpleoTexto(String v1, String v2, String v3) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.IngresaTextoDE(?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ResultadosTextoLibre(String v1, String v2, String v3, String v4, String v5) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.IngresaTextoLibreResultados(?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en Texto Resultados Noti: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizaConjunto(String v1) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.ActualizaConjunto(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void ActualizaConjunto2(String v1) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.ActualizaConjunto2(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void DecisionEmpleo(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.IngresaDecisionEmpleoCap(?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void DecisionEmpleoCap(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.IngresaDecisionEmpleo(?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void CabCalidadPM(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14, String v15) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.cabeceraCalidad(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.setString(15, v15);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void PosCalidadPM(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v10, String v11, String v12, String v13, String v14, String v15) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL PM.posicionesCalidad(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.setString(9, v9);
            ps.setString(10, v10);
            ps.setString(11, v11);
            ps.setString(12, v12);
            ps.setString(13, v13);
            ps.setString(14, v14);
            ps.setString(15, v15);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ValidarUMedida ACC_UnidadesMedida por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void CabeceraTextosAvQM(String v1, String v2, String v3, String v4, String v5, String v6, String v7) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL QM.InsertaCabeceraCalidadAv(?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void UpdateFhAndHr(String v1, String v2, String v3, String v4, String v5, String v6) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL QM.ActualizaHrAndFc(?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void PosicionesTextosAvQM(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL QM.IngresaPosicionesAvQM(?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.setString(5, v5);
            ps.setString(6, v6);
            ps.setString(7, v7);
            ps.setString(8, v8);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public String DateFormat(String date) {
        String fec = date;
        if (date.trim().length() > 0) {
            if (date.equals("0000-00-00")) {
                fec = "";
            } else {

                DateFormat fe1 = new SimpleDateFormat("dd.MM.yyyy");
                try {

                    DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date d = sf.parse(date);
                    fec = fe1.format(d);

                } catch (ParseException ex) {
                    fec = "";
                }
            }
        } else {
            fec = "";
        }
        return fec;
    }

    public String DateFormatGuion(String date) {
        String fec = date;
        if (date.trim().length() > 0) {
            DateFormat fe1 = new SimpleDateFormat("yyyy-MM-dd");
            try {

                DateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
                Date d = sf.parse(date);
                fec = fe1.format(d);

            } catch (ParseException ex) {
                fec = "";
            }
        } else {
            fec = "";
        }
        return fec;
    }
}
