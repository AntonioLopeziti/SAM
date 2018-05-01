/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Almacen;
import Entidades.centros;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 */
public class ACC_Centro {

    private static ACC_Centro Instance = null;

    public static ACC_Centro ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Centro();
        }
        return Instance;
    }

    public LinkedList<Almacen> ConsultaCentrosAl(String lang) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        LinkedList<Almacen> cen = new LinkedList<Almacen>();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.almacenes_consultaalmacenes}";
        try {
            pst = conn.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Almacen a = new Almacen();
                a.setId_almacen(rs.getString("id_almacen"));
                a.setDescripcion(rs.getString("descripcion_" + lang));
                a.setCentro(rs.getString("centro"));
                cen.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCentros, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return cen;
    }

    public ArrayList<centros> ConsultarCentros(String cen, String Des, int ctd) {
        ArrayList<centros> ce = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Centros_ConsultarCentros(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cen);
            ps.setString(2, Des);
            ps.setInt(3, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                centros c = new centros();
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                ce.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarCentros, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ce;
    }

    public ArrayList<centros> ConsultarCentrosCOEQ(String cen, String Des, String ctd) {
        ArrayList<centros> ce = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Centros_ConsultarCentrosCOE(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cen);
            ps.setString(2, Des);
            ps.setString(3, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                centros c = new centros();
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                ce.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarCentrosCOEQ, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ce;
    }

    public boolean ValidarCentroSP(String cen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean ban = false;
        String sql = "{CALL  MM.Solped_ValidarCentro(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cen);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarCentroSP, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public String ValidarCentro303Exis(String cent) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_ValidarCentro303(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, cent);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarCentro303Exis, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public int ValidarCentro(String centr) {

        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call MM.centros_validarcentross(?)}";

        CallableStatement pst = null;
        ResultSet rs = null;

        try {
            pst = conn.prepareCall(query);
            pst.setString(1, centr);
            rs = pst.executeQuery();

            while (rs.next()) {

                String centro = rs.getString("centro");
                if (centro.equals(centr)) {
                    return 1;
                }

            }
        } catch (Exception e) {
            System.err.println("Error en ValidarCentro, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return 0;
    }
    
    public boolean ValidarCentroCreaCen(String centr) {
        Conexion cnx = new Conexion();
        Connection conn = cnx.ObtenerConexion();
        String query = "{call MM.centros_validarcentross(?)}";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, centr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println();
        } finally {
            cnx.CerrarConexion(conn);
        }
        return false;
    }

    public int ValidarCentro303(String centr) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call MM.centros_intcentros303(?)}";

        try {
            CallableStatement pst = conn.prepareCall(query);
            pst.setString(1, centr);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String centro = rs.getString("centro");
                if (centro.equals(centr)) {
                    con.CerrarConexion(conn);
                    return 1;
                } else {
                    con.CerrarConexion(conn);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarCentro303, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return 0;
    }

    public ArrayList<centros> ConsultaCentrosAll() {
        ArrayList<centros> c303 = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String storeP = "{call MM.centros_Consultarcentros303}";
        try {
            PreparedStatement ps = con.prepareStatement(storeP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                centros c = new centros();
                c.setId_centro(rs.getInt("id_centro"));
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                c303.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCentrosAll, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return c303;
    }

    public ArrayList<centros> CentroReservass() {
        ArrayList<centros> ctn = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PM.ROrdenes_repOrdConsCen()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                centros cn = new centros();
                cn.setCentro(rs.getString("centro"));
                cn.setDescripcion(rs.getString("descripcion"));
                ctn.add(cn);
            }
        } catch (Exception e) {
            System.err.println("Error en CentroReservass, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ctn;
    }
    public ArrayList<centros> CentroReservasFiltros(String centro, String Ncent, String cnt) {
        ArrayList<centros> ctn = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call PP.Centros_ConsultarCentrosRepsP(?,?,?)}");            
            pst.setString(1, centro);
            pst.setString(2, Ncent);
            pst.setString(3, cnt);
            rs = pst.executeQuery();
            while (rs.next()) {
                centros cn = new centros();
                cn.setCentro(rs.getString("centro"));
                cn.setDescripcion(rs.getString("descripcion"));
                ctn.add(cn);
            }
        } catch (Exception e) {
            System.err.println("Error en CentroRepNot, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ctn;
    }

    public ArrayList<centros> MM_MatchCentro() {
        ArrayList<centros> sp_matchCentro = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call MM.Centros_MatchCentros}";
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
        } catch (Exception e) {
            System.err.println("Error en MM_MatchCentro, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sp_matchCentro;
    }

    public int CentroDestinoT(String centro, String mat, String alm, String lote) {
        int rt = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.materiales_almacen_s_MOM(?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, mat);
            ps.setString(2, alm);
            ps.setString(3, centro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rt = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en CentroDestinoT, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return rt;
    }

    public boolean InsertCentro(String centro, String desc) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call MM.centros_insertar_centros(?,?)}";
        try {
            CallableStatement pst = conn.prepareCall(query);
            pst.setString(1, centro);
            pst.setString(2, desc);
            int rso = pst.executeUpdate();
            if (rso == -1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Error en InsertCentro, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public boolean InsertCentro303(String centro, String desc) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call MM.centros_insertar_centros303(?,?)}";
        CallableStatement pst = null;
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, centro);
            pst.setString(2, desc);
            int rso = pst.executeUpdate();
            if (rso == -1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Error en InsertCentro303, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return false;
    }

    public void EliminaCentro(String cen) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call MM.[centros_eliminarcentro](?)}";
        try {
            CallableStatement pst = conn.prepareCall(query);
            pst.setString(1, cen);
            boolean lo = pst.execute();
            System.out.println(lo);
        } catch (Exception e) {
            System.err.println("Error en EliminaCentro, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
    }

    public void EliminaCentro303(String cen) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call MM.[centros_eliminarcentro303](?)}";
        try {
            CallableStatement pst = conn.prepareCall(query);
            pst.setString(1, cen);
            int pa = pst.executeUpdate();
            System.out.println(pa);
        } catch (Exception e) {
            System.err.println("Error en EliminaCentro303, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
    }

    public ArrayList<centros> ConsultaCentros() {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ArrayList<centros> cen = new ArrayList<>();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.centros_ConsultarcentrosCE}";
        try {
            pst = conn.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                centros c = new centros();
                c.setId_centro(rs.getInt("id_centro"));
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                cen.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCentros, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return cen;
    }

    public ArrayList<centros> ConsultaCentros303() {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ArrayList<centros> cen = new ArrayList<>();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.centros_Consultarcentros303}";
        try {
            pst = conn.prepareCall(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                centros c = new centros();
                c.setId_centro(rs.getInt("id_centro"));
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                cen.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCentros303, ACC_Centro por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return cen;
    }

    public boolean ValidaCampoCentro(String cen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        centros m = new centros();
        try {
            ps = con.prepareCall("{CALL MM.Centros_ValidarCentro(?)}");
            ps.setString(1, cen);
            rs = ps.executeQuery();
            while (rs.next()) {
                String centro = rs.getString("centro");
                if (cen.equals(centro)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidaCampoCentro, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public ArrayList<centros> ConsultaMatchCentroo() {
        ArrayList<centros> ctn = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ConsCent()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                centros cn = new centros();
                cn.setCentro(rs.getString("centro"));
                cn.setDescripcion(rs.getString("descripcion"));
                ctn.add(cn);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaMatchCentroo, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ctn;
    }

    public ArrayList<centros> ConsultaCentrosQM() {
        ArrayList<centros> ctn = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call QM.InspMat_ConsCentro()}");
            rs = pst.executeQuery();
            while (rs.next()) {
                centros cn = new centros();
                cn.setCentro(rs.getString("centro"));
                cn.setDescripcion(rs.getString("descripcion"));
                ctn.add(cn);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultaCentrosQM, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ctn;
    }

    public LinkedList<centros> DataMasterCentrosMOD(String Centr, String Denoc, String CANCe) {
        LinkedList<centros> res = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.CENTROS_MODAVI(?,?,?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, Centr);
            pst.setString(2, Denoc);
            pst.setString(3, CANCe);
            rs = pst.executeQuery();
            while (rs.next()) {
                centros c = new centros();
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                res.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en DataMasterCentrosMOD, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return res;
    }

    //////////////////////// checking /////////////////////////////////////////
    public boolean ValidarCentroModVisual(String centr) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT centro FROM centros WHERE centro='" + centr + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String centro = rs.getString("centro");
                if (centro.equals(centr)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultarCentros (ACC_Centro) por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public LinkedList<centros> ConsultaMatchCentro(String cent, int limite) {
        LinkedList<centros> cen = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = null;
        if (cent.equals("") || cent.equals(null)) {
            query = "SELECT * FROM centros LIMIT " + limite + "";
        } else {
            query = "SELECT * FROM centros WHERE centro LIKE '" + cent + "%' LIMIT " + limite + "";
        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            String q = query;
            while (rs.next()) {
                centros c = new centros();
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                cen.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchCentros (ACC_Centro)" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cen;
    }

    public LinkedList<centros> AllPlantTaskList(String li) {
        LinkedList<centros> ce = new LinkedList<>();
        String query = "SELECT * FROM centros limit " + li + "";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                centros cen = new centros();
                cen.setCentro(rs.getString("centro"));
                cen.setDescripcion(rs.getString("descripcion"));
                ce.add(cen);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return ce;
    }

    public LinkedList<centros> ShowPlaModHr(String cet, String des) {
        LinkedList<centros> cen = new LinkedList<>();
        Conexion con = new Conexion();
        String query = "SELECT * FROM centros where centro like '" + cet + "%' and descripcion like '" + des + "%'";
        Connection conn = con.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;

            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                centros ce = new centros();
                ce.setCentro(rs.getString("centro"));
                ce.setDescripcion(rs.getString("descripcion"));
                cen.add(ce);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return cen;
    }

    public LinkedList<centros> ConsultaMatchCentroSP(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<centros> cen = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                centros c = new centros();
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                cen.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMatchCentroSP(ACC_Centro) por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cen;
    }

    public int CentroDestino(String centro, String mat, String alm, String lote) {
        int rt = 0;
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        query = "select * from materiales_almacen_303 where material='" + mat + "' and almacen ='" + alm + "' and centro='" + centro + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                rt = 1;
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            rt = 0;
        } finally {
            cnx.CerrarConexion(con);
        }
        return rt;
    }
    
    public ArrayList<centros> ConsultarCentrosCOEQPP(String cen, String Des, String ctd) {
        ArrayList<centros> ce = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PP.Centros_ConsultarCentrosCOEPP(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cen);
            ps.setString(2, Des);
            ps.setString(3, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                centros c = new centros();
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                ce.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarCentrosCOEQ, ACC_Centro por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ce;
    }

}
