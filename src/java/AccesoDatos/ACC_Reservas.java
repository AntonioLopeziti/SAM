/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.almacenes;
import Entidades.centro_coste;
import Entidades.centros;
import Entidades.plan_orden;
import Entidades.reserva_cabecera_crea;
import Entidades.reserva_posiciones_crea;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 */
public class ACC_Reservas {

    private static ACC_Reservas Instance = null;

    public static ACC_Reservas ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Reservas();
        }
        return Instance;
    }

    //Metodo para match de almacen
    public ArrayList<almacenes> MM_MatchAlmacen(String deno) {
        ArrayList<almacenes> malm = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.almacenes_MatchAlmacenes}");
            rs = ps.executeQuery();
            while (rs.next()) {
                almacenes a = new almacenes();
                a.setId_almacen(rs.getString("id_almacen"));
                a.setNombre_alamcen(rs.getString(deno));
                a.setCentro(rs.getString("centro"));
                malm.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error al traer datos de almacen: " + e);
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
        return malm;
    }

    //metodo para guardar en la tabla reserva_posiciones_crea - modificar
    public boolean MMInsertarReservaPosicionesCrea(
            String fo, String pos, String mat, String cen, String almacen, String cantidad, String uni, String cecos, String orden,
            String mov, String des, String almdes, String remo
    ) {
        boolean ban = false;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean conf = true;
        try {
            ps = con.prepareCall("{CALL MM.ReservaPosicionesCrea_GuardaReserva(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            ps.setString(1, fo);
            ps.setString(2, pos);
            ps.setString(3, mat);
            ps.setString(4, cen);
            ps.setString(5, almacen);
            ps.setString(6, cantidad);
            ps.setString(7, uni);
            ps.setString(8, cecos);
            ps.setString(9, orden);
            ps.setString(10, mov);
            ps.setString(11, des);
            ps.setString(12, almdes);
            ps.setString(13, remo);
            if (ps.executeUpdate() > 0) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error al insertar en posiciones crea");
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return ban;
    }

    //METODO PARA ACTUALIZAR LA CABECERA - modificar
    public boolean MMUPDATEReservasCabeceraCreaMod(
            String fo, String fecha, String hora
    ) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean confirmacion = false;
        try {
            ps = con.prepareCall("{CALL MM.ReservaCabeceraCrea_UpdateCabecera(?, ?, ?)}");
            ps.setString(1, fo);
            ps.setString(2, fecha);
            ps.setString(3, hora);
            if (ps.executeUpdate() > 0) {
                confirmacion = true;
            }
        } catch (Exception e) {
            System.err.println("Error al insertar en reservas_cabecera_crea");
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return confirmacion;
    }

    // metodo para guardar en la tabla reservas_cabecera_crea - crear
    public boolean MMInsertarReservasCabeceraCrea(
            String fo, String fecha, String hora, String centro, String clase,
            String almacen, String cencos, String orden, String almdestino, String usuario
    ) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean confirmacion = false;
        try {
            ps = con.prepareCall("{CALL MM.ReservaCabeceraCrea_GuardaReserva(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            ps.setString(1, fo);
            ps.setString(2, fecha);
            ps.setString(3, hora);
            ps.setString(4, centro);
            ps.setString(5, clase);
            ps.setString(6, almacen);
            ps.setString(7, cencos);
            ps.setString(8, orden);
            ps.setString(9, almdestino);
            ps.setString(10, usuario);
            if (ps.executeUpdate() > 0) {
                confirmacion = true;
            }
        } catch (Exception e) {
            System.err.println("Error al insertar en reservas_cabecera_crea");
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return confirmacion;
    }

    //metodo para guardar posiciones de reservas - crear
    public boolean MMInsertarReservaPosicionesCreaUno(
            String fo, String pos, String mat, String cen, String almacen, String cantidad, String uni, String cecos, String orden,
            String mov, String des, String almdes, String remo
    ) {
        boolean ban = false;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean conf = true;
        try {
            ps = con.prepareCall("{CALL MM.ReservaPosicionesCrea_GuardaReservaUno(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            ps.setString(1, fo);
            ps.setString(2, pos);
            ps.setString(3, mat);
            ps.setString(4, cen);
            ps.setString(5, almacen);
            ps.setString(6, cantidad);
            ps.setString(7, uni);
            ps.setString(8, cecos);
            ps.setString(9, orden);
            ps.setString(10, mov);
            ps.setString(11, des);
            ps.setString(12, almdes);
            ps.setString(13, remo);
            if (ps.executeUpdate() > 0) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error al insertar en posiciones crea");
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return ban;
    }
    public int ReservaPosC(String fol) {
        int cc = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String proc = "{CALL MM.ResevasCount(?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, fol);
            rs = ps.executeQuery();
            while (rs.next()) {
                cc++;
            }
        } catch (Exception e) {
            System.err.println("Error en Metodo ReservaPos por: " + e);
        } finally {
            cnx.ObtenerConexion();
        }
        return cc;
    }
    //Metodo para actualizar el folio - crea reservas
    public boolean MMUpdateFolioReservas(String fol) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean confirma = true;
        try {
            ps = con.prepareCall("{CALL CNF.Folios_ActualizaFolioActual(?)}");
            ps.setString(1, fol);
            confirma = ps.execute();
            if (confirma == true) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar el folio de reservas: " + e);
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return false;
    }
    
    public void EliminaPosRes(String fol) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL MM.EliminaPosReserva(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fol);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error esta vaina por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public ArrayList<reserva_cabecera_crea> ConsultaMCReserva(String nres) {
        ArrayList<reserva_cabecera_crea> res = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualReservas_CargarMCReservas(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nres);
            rs = ps.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea rc = new reserva_cabecera_crea();
                rc.setFolio_sap(rs.getString("num_reservas"));
                rc.setFolio_sam(rs.getString("folio_sam"));
                res.add(rc);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMCReserva por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return res;
    }

    public LinkedList<almacenes> ConsultaMatchAlmacen(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<almacenes> alm = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                almacenes a = new almacenes();
                a.setId_almacen(rs.getString("id_almacen"));
                a.setNombre_alamcen(rs.getString("descripcion_ES"));
                a.setCentro(rs.getString("centro"));
                alm.add(a);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en Consulta Almacenes por: " + e);
        }
        return alm;
    }

    public LinkedList<centro_coste> ConsultaMatchCentroCoste(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<centro_coste> cen = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                centro_coste c = new centro_coste();
                c.setCentro_coste(rs.getString("centro_coste"));
                c.setSociedad_co(rs.getString("sociedad_co"));
                c.setDescripcion(rs.getString("descripcion_ES"));
                cen.add(c);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en Consulta Centros Coste por: " + e);
        }
        return cen;
    }

    public boolean ValidarCEN(String cen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call QM.InspMat_ValCen(?)}");
            pst.setString(1, cen);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_OrganizacionCompras por: " + e);
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

    public boolean ValidarALM(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        centros cen = new centros();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_OrganizacionCompras por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public boolean ValidarCCO(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        centros cen = new centros();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_OrganizacionCompras por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public LinkedList<plan_orden> MMConsultaMatchOrdenMM(String lim, String numord, String des) {
        LinkedList<plan_orden> ordmm = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.OrdenesMM_MatchOrMM(?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, numord);
            ps.setString(3, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                plan_orden o = new plan_orden();
                o.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                o.setNum_orden(rs.getString("num_orden"));
                o.setTexto_breve(rs.getString("denominacion_general"));
                ordmm.add(o);
            }
        } catch (Exception e) {
            System.err.println("Error al traer los datos de ordenes_mm: " + e);
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return ordmm;
    }

    public boolean ValidarOrdMM(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.OrdenesMM_Validacion(?)}");
            ps.setString(1, ord);
            rs = ps.executeQuery();
            while (rs.next()) {
                String or = rs.getString("num_orden");
                if (ord.equals(or)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error de validar orden_mm: " + e);
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
        return false;
    }

    public boolean ValidarOR(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        centros cen = new centros();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String a = rs.getString("estatus");
                StringTokenizer sttok = new StringTokenizer(a);
                String tok = sttok.nextElement().toString();
                if (tok.equals("ABIE") || tok.equals("LIB.")) {
                    return true;
                } else {
                    return false;
                }
            }
            /*PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }*/
        } catch (Exception e) {
            System.err.println("Error en: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    //METODO PARA VALIDAR EL FOLIO SAM EN CABECERA
    public boolean MMValidarFolioSamCabecera(String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.ReservaPosicionesCrea_ValidaFolio(?)}");
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while (rs.next()) {
                String f = rs.getString("folio_sam");
                if (folio.equals(f)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error al validar el folio sam: " + e);
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return false;
    }

    public boolean ValidarSAM(String sam) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT folio_sam FROM MM.reserva_cabecera_crea WHERE folio_sam = '" + sam + "'";
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String a = rs.getString("folio_sam");
                if (sam.equals(a)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarSAM por:" + ex);
        }
        return false;
    }

    //METODO PARA MATCH DE FOLIO_SAM PARA MODIFICAR RESERVAS
    public LinkedList<reserva_cabecera_crea> MMReservaCabeceraCreaMatchFolioSam(String lim, String folio, String fecha) {
        LinkedList<reserva_cabecera_crea> res = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.ReservaCabeceraCrea_MatchaFolioSAM(?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, folio);
            ps.setString(3, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea r = new reserva_cabecera_crea();
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setFecha(rs.getString("fecha"));
                res.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error para el match de folio sam: " + e);
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return res;
    }

    /*----------------*/
 /*Consulta MATCH Folio SAM ModificarReservas*/
    public LinkedList<reserva_cabecera_crea> ConsultaFolioSAM(String query) {
        LinkedList<reserva_cabecera_crea> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reserva_cabecera_crea rc = new reserva_cabecera_crea();
                rc.setFolio_sam(rs.getString("folio_sam"));
                rc.setFecha(rs.getString("fecha"));
                sam.add(rc);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo CosultaFolioSAM por:" + ex);
        }
        return sam;
    }

    public LinkedList<reserva_cabecera_crea> ConsultaReservas(String query) {
        LinkedList<reserva_cabecera_crea> sam = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reserva_cabecera_crea rc = new reserva_cabecera_crea();
                rc.setFolio_sap(rs.getString("num_reservas"));
                rc.setFolio_sam(rs.getString("folio_sam"));
                sam.add(rc);
            }

        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaReservas por:" + ex);
            cnx.CerrarConexion(con);
        }
        cnx.CerrarConexion(con);
        return sam;
    }

    //Metodo para trer datos de reserva_cabecera_crea
    public reserva_cabecera_crea MMConsultaDatosReservasCabecera(String folio) {
        reserva_cabecera_crea reser = new reserva_cabecera_crea();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.ReservaPosicionesCrea_TraeDatosCabecera(?)}");
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while (rs.next()) {
                reser.setRecibido(rs.getString("recibido"));
                reser.setProcesado(rs.getString("procesado"));
                reser.setError(rs.getString("error"));
                reser.setUsuario(rs.getString("usuario"));
            }
        } catch (Exception e) {
            System.err.println("Error al traer los datos de reservas: " + e);
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return reser;
    }

    public reserva_cabecera_crea MMConsultaAllDatosReservaCabecera(String folio) {
        reserva_cabecera_crea reser = new reserva_cabecera_crea();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.ReservaCabeceraCrea_ConsultaDatosReserva(?)}");
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while (rs.next()) {
                reser.setId_rc(rs.getInt("id_rc"));
                reser.setFolio_sam(rs.getString("folio_sam"));
                reser.setFolio_sap(rs.getString("folio_sap"));
                reser.setFecha(rs.getString("fecha"));
                reser.setHora_dia(rs.getString("hora_dia"));
                reser.setCentro(rs.getString("centro"));
                reser.setClase_movimiento(rs.getString("clase_movimiento"));
                reser.setAlmacen(rs.getString("almacen"));
                reser.setCentro_coste(rs.getString("centro_coste"));
                reser.setNum_orden(rs.getString("num_orden"));
                reser.setRecibido(rs.getString("recibido"));
                reser.setProcesado(rs.getString("procesado"));
                reser.setError(rs.getString("error"));
                reser.setAlmacen_destino(rs.getString("almacen_destino"));
            }
        } catch (Exception e) {
            System.err.println("Error al traer los datos: " + e);
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
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
        return reser;
    }

    /*------------------------------------------*/
 /*Cargar  los datos Reserva materiales*/
    public reserva_cabecera_crea ConsultaReserva(String query) {
        reserva_cabecera_crea reserva = new reserva_cabecera_crea();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reserva.setId_rc(rs.getInt("id_rc"));
                reserva.setFolio_sam(rs.getString("folio_sam"));
                reserva.setFolio_sap(rs.getString("folio_sap"));
                reserva.setFecha(rs.getString("fecha"));
                reserva.setHora_dia(rs.getString("hora_dia"));
                reserva.setCentro(rs.getString("centro"));
                reserva.setClase_movimiento(rs.getString("clase_movimiento"));
                reserva.setAlmacen(rs.getString("almacen"));
                reserva.setCentro_coste(rs.getString("centro_coste"));
                reserva.setNum_orden(rs.getString("num_orden"));
                reserva.setRecibido(rs.getString("recibido"));
                reserva.setProcesado(rs.getString("procesado"));
                reserva.setError(rs.getString("error"));
                reserva.setAlmacen_destino(rs.getString("almacen_destino"));

            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaCargarReserva por: " + ex);
        }
        return reserva;
    }

    //METODO PARA TRAER LOS DATOS DE RESERVA POSICIONES CREA******
    public LinkedList<reserva_posiciones_crea> MMObtieneDatosTablaPosiciones(String folio) {
        LinkedList<reserva_posiciones_crea> posiciones = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.ReservaPosicionesCrea_ObtieneDatosPosiciones(?)}");
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea r = new reserva_posiciones_crea();
                r.setId_rpc(rs.getInt("id_rpc"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setNum_material(rs.getString("num_material"));
                r.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                r.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                r.setTexto_posicion(rs.getString("texto_posicion"));
                posiciones.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error al traer datos de reserva_posiciones_crea: " + e);
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
        return posiciones;
    }

    //METODO ESPECIAL PARA LLENAR LA MODIFICACION DE RESERVAS - Modificar
    public boolean MMUpdatePosicionesCabeceraReservasCrea(String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean confirmame = true;
        try {
            ps = con.prepareCall("{CALL MM.ReservaPosicionesCrea_InsertAll(?)}");
            ps.setString(1, folio);
            //confirmame = ps.executeUpdate();
            if (ps.executeUpdate() > 0) {
                return confirmame;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al hacer el metodo de llenado: " + e);
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
        return false;
    }

    //METODO PARA ACTUALIZAR LA RESERVA
    public boolean MMUpdateReservaPosicionesCrea(String cant, String che, String ide) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean confirma = true;
        try {
            ps = con.prepareCall("{CALL MM.ReservaPosicionesCrea_ActualizarTabla(?, ?, ?)}");
            ps.setString(1, cant);
            ps.setString(2, che);
            ps.setString(3, ide);
            confirma = ps.execute();
            if (confirma == true) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar la reserva: " + e);
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
        return false;
    }

    /*-----------------------------------------*/
 /*Cargar servicios de tabla */
    public LinkedList<reserva_posiciones_crea> CargarDatosTabla(String query) {
        LinkedList<reserva_posiciones_crea> posiciones = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                reserva_posiciones_crea pos = new reserva_posiciones_crea();
                pos.setId_rpc(rs.getInt("id_rpc"));
                pos.setFolio_sam(rs.getString("folio_sam"));
                pos.setPosicion_reserva(rs.getString("posicion_reserva"));
                pos.setFolio_sap(rs.getString("folio_sap"));
                pos.setNum_material(rs.getString("num_material"));
                pos.setCentro(rs.getString("centro"));
                pos.setAlmacen(rs.getString("almacen"));
                pos.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                pos.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                pos.setCentro_coste(rs.getString("centro_coste"));
                pos.setNum_orden(rs.getString("num_orden"));
                pos.setClase_movimiento(rs.getString("clase_movimiento"));
                pos.setTexto_posicion(rs.getString("texto_posicion"));
                pos.setRecibido(rs.getString("recibido"));
                pos.setProcesado(rs.getString("procesado"));
                pos.setError(rs.getString("error"));
                posiciones.add(pos);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarDatosTabla por :" + ex);
        }
        return posiciones;
    }

    public ArrayList<reserva_posiciones_crea> CargarreservasMC(String pos, String clas, String mat, String ctr, String alm, String resv, String usr, String txt) {
        ArrayList<reserva_posiciones_crea> rpc = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.reservas_materiales_Match_MOM(?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, pos);
            sp.setString(2, clas);
            sp.setString(3, mat);
            sp.setString(4, ctr);
            sp.setString(5, alm);
            sp.setString(6, resv);
            sp.setString(7, usr);
            sp.setString(8, txt);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea r = new reserva_posiciones_crea();
                r.setFolio_sap(rs.getString("num_reservas"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setPosicion_reserva(rs.getString("num_posicion"));
                r.setClase_movimiento(rs.getString("clase_movimientos"));
                r.setCentro(rs.getString("centro"));
                r.setAlmacen(rs.getString("almacen"));
                r.setUsuario(rs.getString("usuario"));
                r.setTexto_posicion(rs.getString("texto_posicion"));
                try {
                    r.setNum_material(Integer.parseInt(rs.getString("num_material")) + "");
                } catch (Exception e) {
                    r.setNum_material(rs.getString("num_material"));
                }
                rpc.add(r);
            }
        } catch (Exception e) {
            cnx.CerrarConexion(con);
            System.err.println("Error");
        }
        cnx.CerrarConexion(con);
        return rpc;
    }

    public int ValidarReservAmbas(String v) {
        int n = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Long vl = 0L;
        String query;
        try {
            vl = Long.parseLong(v);
            query = "{call MM.reservas_materiales_valida_MOM(?,?)}";
        } catch (Exception e) {
            query = "{call MM.reservas_materiales_valida2_MOM(?,?)} ";
        }

        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, vl.toString());
            sp.setString(2, v);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                n = 1;
            }
        } catch (Exception b) {
            n = 0;
        }
        if (n == 0) {
            try {
                query = "{call MM.reserva_posiciones_crea_valida_MOM(?)} ";
                PreparedStatement sp = con.prepareStatement(query);
                sp.setString(1, v);
                ResultSet rs = sp.executeQuery();
                while (rs.next()) {
                    n = 1;
                }
            } catch (Exception e) {
                n = 0;
            }
        }
        cnx.CerrarConexion(con);
        return n;
    }

    public String ValidarDataRes(String cl, String v) {
        String n = "0";
        Long vl = 0L;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query;
        try {
            vl = Long.parseLong(v);
            query = "{call MM.reservas_materialesV_MOM(?,?,?)}";
        } catch (Exception e) {
            query = "{call MM.reservas_materialesV2_MOM(?,?,?)}";
        }
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, vl.toString());
            sp.setString(2, v);
            sp.setString(3, cl);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                n = "reservas_materialesV_MOM|" + vl + "|" + v + "|" + cl;
            }
        } catch (Exception b) {
            System.out.println(b);
            n = "0";
        }
        try {
            query = "{call MM.reserva_posiciones_creaV_MOM(?,?,?)}";
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, vl.toString());
            sp.setString(2, v);
            sp.setString(3, cl);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                n = "reserva_posiciones_creaV_MOM|" + vl + "|" + v + "|" + cl;
            }
        } catch (Exception e) {
            n = "0";
            System.out.println(e);
        }
        cnx.CerrarConexion(con);
        return n;
    }

    public int ValidarErrorReserva(String reserva) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call mm.Reservas_ValidarReserva_MOM(?)}";
        int ban = 0;
        String data = "";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, reserva);
            rs = ps.executeQuery();
            while(rs.next()){
                data = rs.getString("error");
                if(data.trim().length() > 0){
                    ban = 1;
                }
            }
        } catch (Exception e) {
            System.err.println("Error enValidarErrorReserva por " + e);
        }
        return ban;
    }
     public static void main(String[] args) {
        ACC_Reservas r = new ACC_Reservas();
        System.out.println(r.ValidarErrorReserva("RE59000020"));
//        System.out.println(r.ValidarErrorReserva("0000000641"));
    }

    public ArrayList<reserva_posiciones_crea> cargarPosiResMov(String query, String nr, String folio, String clase) {
        String nquery = "{call MM." + query + "(?,?,?)}";
        ArrayList<reserva_posiciones_crea> res = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            PreparedStatement sp = con.prepareStatement(nquery);
            sp.setString(1, nr);
            sp.setString(2, folio);
            sp.setString(3, clase);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea r = new reserva_posiciones_crea();
                r.setNum_material(rs.getString("num_material"));
                r.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                r.setNum_orden(rs.getString("num_orden"));
                r.setCentro_coste(rs.getString("centro_coste"));
                try {
                    r.setFolio_sap(rs.getString("num_reservas"));
                } catch (Exception e) {
                }
                r.setFolio_sam(rs.getString("folio_sam"));
                try {
                    r.setNum_posicion(Integer.parseInt(rs.getString("num_posicion")));
                } catch (Exception e) {
                    r.setNum_posicion(Integer.parseInt(rs.getString("posicion_reserva")) / 10);
                }
                try {
                    r.setUnidad_medida_base(rs.getString("unidad_medida"));
                } catch (Exception e) {
                    r.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                }
                try {
                    r.setAlmacen_destino(rs.getString("almacen_receptor_emisor"));
                } catch (Exception e) {
                    r.setAlmacen_destino(rs.getString("almacen_destino"));
                }

                res.add(r);
            }
        } catch (Exception e) {
            System.out.println("Error en metodo por " + e);
        }
        return res;
    }

    public int ValidarReservaSAP(String NRes) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.VisualReservas_ValidarReservasSAP(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ban = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NRes);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en metodo ValidaReservaSAP por " + e);
        }
        return ban;
    }

    public int ValidarReservaSAM(String NRes) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.VisualReservas_ValidarReservasSAM(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ban = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, NRes);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en metodo ValidaReservaSAP por " + e);
        }
        return ban;
    }

    public reserva_posiciones_crea CargarDatosCabSAM(String res) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        reserva_posiciones_crea r = new reserva_posiciones_crea();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualReservas_CargarDatosCabeceraSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, res);
            rs = ps.executeQuery();
            while (rs.next()) {
                r.setCentro(rs.getString("centro"));
                r.setAlmacen(rs.getString("almacen"));
                r.setClase_movimiento(rs.getString("clase_movimiento"));
                r.setCentro_coste(rs.getString("centro_coste"));
                r.setNum_orden(rs.getString("num_orden"));
                r.setError(rs.getString("error"));
                r.setAlmacen_destino(rs.getString("almacen_destino"));
            }
        } catch (Exception e) {
            System.out.println("Error en metodo CargarDatosCabSAM por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return r;
    }

    public reserva_posiciones_crea CargarDatosCabSAP(String res) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        reserva_posiciones_crea r = new reserva_posiciones_crea();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualReservas_CargarDatosCabeceraSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, res);
            rs = ps.executeQuery();
            while (rs.next()) {
                r.setCentro(rs.getString("centro"));
                r.setAlmacen(rs.getString("almacen"));
                r.setClase_movimiento(rs.getString("clase_movimientos"));
                r.setCentro_coste(rs.getString("centro_coste"));
                r.setNum_orden(rs.getString("num_orden"));
                r.setError("");
                r.setAlmacen_destino(rs.getString("almacen_receptor_emisor"));
            }
        } catch (Exception e) {
            System.out.println("Error en metodo CargarDatosCabSAM por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return r;
    }

    public ArrayList<reserva_posiciones_crea> LoadTabResSAP(String reserva) {
        ArrayList<reserva_posiciones_crea> rsp = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualReservas_LoadTabResSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, reserva);
            rs = ps.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea r = new reserva_posiciones_crea();
                r.setNum_material(rs.getString("num_material"));
                r.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                r.setUnidad_medida_base(rs.getString("unidad_medida"));
                r.setTexto_posicion(rs.getString("texto_posicion"));
                rsp.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en LoasTabRes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rsp;
    }

    public ArrayList<reserva_posiciones_crea> LoadTabResSAM(String reservas) {
        ArrayList<reserva_posiciones_crea> rsp = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.VisualReservas_LoadTabResSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, reservas);
            rs = ps.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea r = new reserva_posiciones_crea();
                r.setNum_material(rs.getString("num_material"));
                r.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                r.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                r.setTexto_posicion(rs.getString("texto_posicion"));
                rsp.add(r);
            }
        } catch (Exception e) {
            System.err.println("Error en LoasTabRes por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rsp;
    }

}
