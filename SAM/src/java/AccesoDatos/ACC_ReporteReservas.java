/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package AccesoDatos;

import Entidades.Listareservas;
import Entidades.reserva_cabecera_crea;
import Entidades.reserva_posiciones_crea;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import Entidades.reservas_materiales;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ACC_ReporteReservas {

    private static ACC_ReporteReservas Instance = null;

    public static ACC_ReporteReservas ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_ReporteReservas();
        }
        return Instance;
    }

    public int ValidarReservaLista(String reser) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String sql = "{call MM.ListaReserva_ValidarReserva(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, reser);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarResrvaLista por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarReservaSAMLista(String reser) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String sql = "{call MM.ListaReserva_ValidarReservaSAM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, reser);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarResrvaLista por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public static void main(String[] args) {
        System.out.println(ACC_ReporteReservas.ObtenerInstancia().ValidarReservaClase("101"));
    }

    public int ValidarReservaClase(String clase) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String check = "";
        String sql = "{call MM.ListaReservas_ValidarClaseMov(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, clase);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            System.out.println(check.trim());
            if (!check.trim().equals("0")) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarReservaClase por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarReservaSolicitante(String solic) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String check = "";
        String sql = "{call MM.ListaReservas_ValidarUsuario(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, solic);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            System.out.println(check.trim());
            if (!check.trim().equals("0")) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarReservaSolicitante por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarReservaMaterial(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        String check = "";
        String sql = "{call MM.ListaReservas_ValidarMaterial(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            System.out.println(check.trim());
            if (!check.trim().equals("0")) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarReservaMaterial por " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarQuery(String[] data) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int n = 0;
        String sql = "{call MM.ListaReservas_ValidarQuery(?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            rs = ps.executeQuery();
            while (rs.next()) {
                n = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarQuery, ACC_ReporteReservas por:  " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return n;
    }

    public int ValidarQueryS(String[] data) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int n = 0;
        String sql = "{call MM.ListaReservas_ValidarQueryS(?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            rs = ps.executeQuery();
            while (rs.next()) {
                n = 1;
            }
        } catch (Exception e) {
             System.err.println("Error en ValidarQueryS, ACC_ReporteReservas por:  " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return n;
    }

    public ArrayList<reservas_materiales> CargarTablaListaReserva(String[] data) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        ArrayList<reservas_materiales> rm = new ArrayList<>();
        String sql = "{call MM.ListaReservas_ValidarQuery(?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            rs = ps.executeQuery();
            while (rs.next()) {
                reservas_materiales r = new reservas_materiales();
                r.setNum_reservas(rs.getString("num_reservas"));
                r.setNum_posicion(rs.getString("num_posicion"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setFec_necesidad(rs.getString("fec_necesidad"));
                r.setClase_movimientos(rs.getString("clase_movimientos"));
                r.setCentro(rs.getString("centro"));
                r.setAlmacen(rs.getString("almacen"));
                r.setNum_material(rs.getString("num_material"));
                r.setTexto_breve(rs.getString("texto_posicion"));
                r.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                r.setUnidad_medida(rs.getString("unidad_medida"));
                r.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                r.setNum_orden(rs.getString("num_orden"));
                r.setCentro_coste(rs.getString("centro_coste"));
                r.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                r.setUsuario(rs.getString("usuario"));
                rm.add(r);
            }
        } catch (Exception e) {
           System.err.println("Error en CargarTablaListaReserva, ACC_ReporteReservas por:  " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return rm;
    }

    public ArrayList<reservas_materiales> CargarTablaListaReservaS(String[] data) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        ArrayList<reservas_materiales> rm = new ArrayList<>();
        String sql = "{call MM.ListaReservas_ValidarQueryS(?,?,?,?,?,?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            rs = ps.executeQuery();
            while (rs.next()) {
                reservas_materiales r = new reservas_materiales();
                r.setNum_reservas(rs.getString("folio_sap"));
                r.setNum_posicion(rs.getString("posicion_reserva"));
                r.setFolio_sam(rs.getString("folio_sam"));
                r.setFec_necesidad(rs.getString("fecha"));
                r.setClase_movimientos(rs.getString("clase_movimiento"));
                r.setCentro(rs.getString("centro"));
                r.setAlmacen(rs.getString("almacen"));
                r.setNum_material(rs.getString("num_material"));
                r.setTexto_breve("");
                r.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                r.setUnidad_medida(rs.getString("unidad_medida_base"));
                r.setNum_orden(rs.getString("num_orden"));
                r.setCentro_coste(rs.getString("centro_coste"));
                r.setAlmacen_receptor_emisor(rs.getString("almacen_destino"));
                r.setUsuario(rs.getString("usuario"));
                rm.add(r);
            }
        } catch (Exception e) {
           System.err.println("Error en CargarTablaListaReservaS, ACC_ReporteReservas por:  " + e);
        }finally {
            cnx.CerrarConexion(con);
        }
        return rm;
    }

    public LinkedList<String[]> ConsultaReservaCabeceraCrea(String query) {

        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[45];
                d[0] = rs.getString("folio_sam");
                d[1] = rs.getString("folio_sap");
                d[2] = rs.getString("fecha");
                d[3] = rs.getString("hora_dia");
                d[4] = rs.getString("centro");
                d[5] = rs.getString("clase_movimiento");
                d[6] = rs.getString("almacen");
                d[7] = rs.getString("centro_coste");
                d[8] = rs.getString("num_orden");
                d[9] = rs.getString("recibido");
                d[10] = rs.getString("error");
                d[11] = rs.getString("procesado");

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta reportes_cabecera vis por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public LinkedList<String[]> ConsultaReservaPosicionesCrea(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[23];
                d[0] = rs.getString("folio_sam");
                d[1] = rs.getString("posicion_reserva");
                d[2] = rs.getString("folio_sap");
                d[3] = rs.getString("num_material");
                d[4] = rs.getString("centro");
                d[5] = rs.getString("almacen");
                d[6] = rs.getString("cantidad_necesaria");
                d[7] = rs.getString("unidad_medida_base");
                d[8] = rs.getString("centro_coste");
                d[9] = rs.getString("num_orden");
                d[10] = rs.getString("clase_movimiento");
                d[11] = rs.getString("texto_posicion");
                d[12] = rs.getString("recibido");
                d[13] = rs.getString("procesado");
                d[14] = rs.getString("error");
                d[15] = rs.getString("remover");
                d[16] = rs.getString("modificar");

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta solped vis por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public LinkedList<String[]> ConsultaReservaMateriales(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[42];
                d[0] = rs.getString("num_reservas");
                d[1] = rs.getString("num_posicion");
                d[2] = rs.getString("posicion_borrada");
                d[3] = rs.getString("mov_mercancia_permitida");
                d[4] = rs.getString("salida_final_reserva");
                d[5] = rs.getString("num_material");
                d[6] = rs.getString("centro");
                d[7] = rs.getString("almacen");
                d[8] = rs.getString("num_lote");
                d[9] = rs.getString("id_stock_especial");
                d[10] = rs.getString("fec_necesidad");
                d[11] = rs.getString("cantidad_necesaria");
                d[12] = rs.getString("unidad_medida");
                d[13] = rs.getString("id_debe");
                d[14] = rs.getString("cantidad_fija");
                d[15] = rs.getString("cantidad_tomada");
                d[16] = rs.getString("valor_tomada");
                d[17] = rs.getString("calve_moneda");
                d[18] = rs.getString("cant_unidad_entrada");
                d[19] = rs.getString("unidad_medida_entrada");
                d[20] = rs.getString("centro_coste");
                d[21] = rs.getString("num_orden");
                d[22] = rs.getString("clase_movimientos");
                d[23] = rs.getString("num_cuenta_mayor");
                d[24] = rs.getString("centro_receptor_emisor");
                d[25] = rs.getString("almacen_receptor_emisor");
                d[26] = rs.getString("texto_posicion");
                d[27] = rs.getString("cant_necesaria_um");
                d[28] = rs.getString("tipo_list_mat");
                d[29] = rs.getString("lista_materiales");
                d[30] = rs.getString("txt_pos_listmat1");
                d[31] = rs.getString("txt_pos_listmat2");
                d[32] = rs.getString("num_conversion_un");
                d[33] = rs.getString("deno_conversion_un");
                d[34] = rs.getString("num_hoja_ruta");
                d[35] = rs.getString("secuencia");
                d[36] = rs.getString("num_operacion");
                d[37] = rs.getString("cant_base");
                d[38] = rs.getString("num_pos_orden");
                d[39] = rs.getString("grupo_art");
                d[40] = rs.getString("num_cuenta_proveedor");
                d[41] = rs.getString("folio_sam");

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta solped vis por: " + e);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public String ObtenerNumero(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        //LinkedList<Solped_posiciones> sp = new LinkedList<>();
        String num = "";
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                //Solped_posiciones s = new Solped_posiciones();
                num = rs.getString("count");

            }
        } catch (Exception ex) {
            System.err.println("Error en el metofo ObtenerNumDatosServ por: " + ex);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return num;
    }

    public LinkedList<String[]> ConsultaMatchFiltro(String query, String dato) {

        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[1];
                d[0] = rs.getString(dato);

                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta solped_posiciones vis por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return docs;
    }

    public ArrayList<reservas_materiales> SP_MatchReservaReportreservas2() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchReservaReportreservas2()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MatchReservaReportreservasSAM() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchReservaReportreservasSAM()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("folio_sam"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MatchPosicionReportreservas2() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchPosicionReportreservas2()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_posicion(rs.getString("num_posicion"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MatchClaseReportreservas2() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchClaseReportreservas2()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MatchMaterialReportreservas2() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchMaterialReportreservas2()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_material(rs.getString("num_material"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MatchAlmacenReportreservas2() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchAlmacenReportreservas2()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setAlmacen(rs.getString("almacen"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MatchOrdenReportreservas2() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchOrdenReportreservas2()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_orden(rs.getString("num_orden"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MatchCosteReportreservas2() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchCosteReportreservas2()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setCentro_coste(rs.getString("centro_coste"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        }
        finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ConsultaVaciaReservasmaterial() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterial()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_posiciones_crea> SP_MM_ConsultaVaciaReservasposiciones() {
        ArrayList<reserva_posiciones_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasposiciones()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea re = new reserva_posiciones_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_cabecera_crea> SP_MM_ConsultaVaciaReservasmateriales() {
        ArrayList<reserva_cabecera_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmateriales()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea re = new reserva_cabecera_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFecha(rs.getString("fecha"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                re.setUsuario(rs.getString("usuario"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ConsultaVaciaReservasmaterialCentro(String centro) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialCentro(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_posiciones_crea> SP_MM_ConsultaVaciaReservasposicionesCentro(String centro) {
        ArrayList<reserva_posiciones_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasposicionesCentro(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea re = new reserva_posiciones_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_cabecera_crea> SP_MM_ConsultaVaciaReservasmaterialesCentro(String centro) {
        ArrayList<reserva_cabecera_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialesCentro(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea re = new reserva_cabecera_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFecha(rs.getString("fecha"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                re.setUsuario(rs.getString("usuario"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ConsultaVaciaReservasmaterialRangosReservas(String reserva, String reserva2) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialRangosRervas(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, reserva);
            pst.setString(2, reserva2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ConsultaVaciaReservasmaterialReservas(String reserva) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialRervas(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, reserva);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ConsultaVaciaReservasmaterialRangosFechas(String fecha1, String fecha2) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialRangosFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, fecha1);
            pst.setString(2, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_cabecera_crea> SP_MM_ConsultaVaciaReservasmaterialesRangosFecha(String fecha1, String fecha2) {
        ArrayList<reserva_cabecera_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialesRangosFecha(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, fecha1);
            pst.setString(2, fecha2);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea re = new reserva_cabecera_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFecha(rs.getString("fecha"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                re.setUsuario(rs.getString("usuario"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ConsultaVaciaReservasmaterialFechas(String fecha1) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialFecha(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_cabecera_crea> SP_MM_ConsultaVaciaReservasmaterialesFecha(String fecha1) {
        ArrayList<reserva_cabecera_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialesFecha(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, fecha1);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea re = new reserva_cabecera_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFecha(rs.getString("fecha"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                re.setUsuario(rs.getString("usuario"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ReservasmaterialClaseMovimiento(String clase) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialClaseMovimiento(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, clase);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_posiciones_crea> SP_MM_ReservasposicionesClaseMovimiento(String clase) {
        ArrayList<reserva_posiciones_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasposicionesClaseMovimiento(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, clase);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea re = new reserva_posiciones_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_cabecera_crea> SP_MM_ReservasmaterialesClaseMovimiento(String clase) {
        ArrayList<reserva_cabecera_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialesClaseMovimiento(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, clase);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea re = new reserva_cabecera_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFecha(rs.getString("fecha"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                re.setUsuario(rs.getString("usuario"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ReservasmaterialMaterial(String material) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialMaterial(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, material);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_posiciones_crea> SP_MM_ReservasposicionesMaterial(String material) {
        ArrayList<reserva_posiciones_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasposicionesMaterial(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, material);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea re = new reserva_posiciones_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_cabecera_crea> SP_MM_ReservasmaterialesSolicitante(String solicitante) {
        ArrayList<reserva_cabecera_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaVaciaReservasmaterialesSolicitante(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, solicitante);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea re = new reserva_cabecera_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFecha(rs.getString("fecha"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                re.setUsuario(rs.getString("usuario"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MM_ReservasmaterialTextoBreve(String texto) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReservasmaterialTextoPosicion(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_posiciones_crea> SP_MM_ReservasposicionesTextoBreve(String texto) {
        ArrayList<reserva_posiciones_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ReservasposicionesTextoPosicion(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_posiciones_crea re = new reserva_posiciones_crea();
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<reserva_cabecera_crea> SP_MatchSolicitanteReportreservas2() {
        ArrayList<reserva_cabecera_crea> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchSolicitanteReservasmateriales()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reserva_cabecera_crea re = new reserva_cabecera_crea();
                re.setUsuario(rs.getString("usuario"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> SP_MatchTextoReportreservas2() {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.MatchTextoReservasmateriales()}";
        try {
            pst = con.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setTexto_posicion(rs.getString("texto_posicion"));
                sp_reservas.add(re);
            }
        } catch (Exception a) {
            System.err.println("Error inesperado al cargar los datos: " + a);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sp_reservas;
    }

    public ArrayList<reservas_materiales> MM_Listareservas_Materiales(String reserva1, String reserva2, String centro, String fecha1, String fecha2, String movimiento, String usuario, String material, String texto) {
        ArrayList<reservas_materiales> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaReservas_Materiales(?,?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, reserva1);
            pst.setString(2, reserva2);
            pst.setString(3, centro);
            pst.setString(4, fecha1);
            pst.setString(5, fecha2);
            pst.setString(6, movimiento);
            pst.setString(7, usuario);
            pst.setString(8, material);
            pst.setString(9, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                reservas_materiales re = new reservas_materiales();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFec_necesidad(rs.getString("fec_necesidad"));
                re.setClase_movimientos(rs.getString("clase_movimientos"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida(rs.getString("unidad_medida"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_receptor_emisor(rs.getString("almacen_receptor_emisor"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }

    public ArrayList<Listareservas> MM_Listareservas_Crea(String centro, String fecha1, String fecha2, String movimiento, String usuario, String material, String texto) {
        ArrayList<Listareservas> sp_reservas = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ListaReservas_Crea(?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, centro);
            pst.setString(2, fecha1);
            pst.setString(3, fecha2);
            pst.setString(4, movimiento);
            pst.setString(5, usuario);
            pst.setString(6, material);
            pst.setString(7, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                Listareservas re = new Listareservas();
                re.setNum_reservas(rs.getString("num_reservas"));
                re.setNum_posicion(rs.getString("num_posicion"));
                re.setFolio_sam(rs.getString("folio_sam"));
                re.setFecha(rs.getString("fecha"));
                re.setClase_movimiento(rs.getString("clase_movimiento"));
                re.setCentro(rs.getString("centro"));
                re.setAlmacen(rs.getString("almacen"));
                re.setNum_material(rs.getString("num_material"));
                re.setTexto_posicion(rs.getString("texto_posicion"));
                re.setCantidad_necesaria(rs.getString("cantidad_necesaria"));
                re.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                re.setCant_unidad_entrada(rs.getString("cant_unidad_entrada"));
                re.setNum_orden(rs.getString("num_orden"));
                re.setNum_cuenta_mayor(rs.getString("num_cuenta_mayor"));
                re.setAlmacen_destino(rs.getString("almacen_destino"));
                re.setUsuario(rs.getString("usuario"));
                sp_reservas.add(re);
            }
        } catch (Exception e) {
            System.err.println("Error al inesperado al cargar los datos debido a : " + e);
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
            } catch (Exception f) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + f);
            }
        }

        return sp_reservas;
    }
}
