package AccesoDatos;

import Entidades.folios;
import Entidades.prefijo_folio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_Folios {

    private static ACC_Folios Instance = null;

    public static ACC_Folios ObtenerIstancia() {
        if (Instance == null) {
            Instance = new ACC_Folios();
        }
        return Instance;
    }

    public folios ObtenerFolioExcedido(String id) {
        folios fo = new folios();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL CNF.Folios_QueryFolioExc(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                fo.setFolioActual(rs.getInt("folio_actual"));
                fo.setFolioFinal(rs.getInt("folio_final"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerFolioExcedido, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fo;
    }

    public folios ObtenerDatosFolios(String pref) {
        folios f = new folios();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pr = "{CALL CNF.Folios_ObtenerDatosFolio(?)}";
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, pref);
            rs = ps.executeQuery();
            while (rs.next()) {
                f.setIdFolios(rs.getString("id_folio"));
                f.setFolioInicial(rs.getInt("folio_inicial"));
                f.setFolioFinal(rs.getInt("folio_final"));
                f.setFolioActual(rs.getInt("folio_actual"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerDatosFolios, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return f;
    }
    

    public void ActualizarFolio(String pref, int Actual) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL CNF.Folios_ActualizarFolio(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pref);
            ps.setInt(2, Actual);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ActualizarFolio, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public LinkedList<folios> TenerFolio(String id) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.folios_ObtenerFolio(?)}";
        PreparedStatement pst = null;
        ResultSet rs = null;
        LinkedList<folios> fol = new LinkedList<>();
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                folios fo = new folios();

                fo.setIdFolios(rs.getString("id_folio"));
                fo.setFolioActual(rs.getInt("folio_actual"));
                fo.setFolioInicial(rs.getInt("folio_inicial"));
                fo.setFolioFinal(rs.getInt("folio_final"));
                fol.add(fo);
            }
        } catch (Exception e) {
            System.err.println("Error en TenerFolio, ACC_Folios por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return fol;
    }

    public String ObtenerFolioOrden() {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL CNF.Folios_ObtenerDatosFolio(?)}";
        String check = "";
        String prefijo = "OR";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, prefijo);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString("folio_actual");
        } catch (Exception e) {
            System.err.println("Error en ObtenerFolioOrden, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public String ActualizarFolioOrden(String pref, String folAct) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        String SP = "{CALL CNF.Folios_ActualizarFolio(?, ?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, pref);
            ps.setString(2, folAct);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en ActualizarFolioOrden, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public folios ObtenerDatos() {
        String id = "AV";
        folios fo = new folios();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.folios_ObtenerFolio(?)}";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                fo.setIdFolios(rs.getString("id_folio"));
                fo.setFolioActual(rs.getInt("folio_actual"));
                fo.setFolioInicial(rs.getInt("folio_inicial"));
                fo.setFolioFinal(rs.getInt("folio_final"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerDatos, ACC_Folios por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return fo;
    }

    public boolean InsertarFolio(folios f) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbts = null;
        boolean confirmacion = false;
        try {
            cbts = con.prepareCall("{CALL CNF.Folios_crearFolios(?, ?, ?, ?)}");
            cbts.setString(1, f.getIdFolios());
            cbts.setInt(2, f.getFolioInicial());
            cbts.setInt(3, f.getFolioFinal());
            cbts.setInt(4, f.getFolioActual());
            if (cbts.executeUpdate() == 1) {
                confirmacion = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarFolio, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return confirmacion;
    }

    public ArrayList<prefijo_folio> MatchPrefijos(prefijo_folio f, int limit) {
        ArrayList<prefijo_folio> pref = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProMat = "{CALL CNF.sp_PrefFolios(?, ?, ?)}";
        try {
            ps = con.prepareStatement(ProMat);
            ps.setInt(1, limit);
            ps.setString(2, f.getPrefijo());
            ps.setString(3, f.getDescripcion());
            rs = ps.executeQuery();
            while (rs.next()) {
                prefijo_folio pf = new prefijo_folio();
                pf.setPrefijo(rs.getString("Prefijo"));
                pf.setDescripcion(rs.getString("Descripcion_ES"));
                pref.add(pf);
            }
        } catch (Exception e) {
            System.err.println("Error en MatchPrefijos, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pref;
    }

    public ArrayList<prefijo_folio> MatchPrefijosAll(prefijo_folio f) {
        ArrayList<prefijo_folio> pref = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProMat = "{CALL CNF.PrefFolios_MuestraAll(?, ?)}";
        try {
            ps = con.prepareStatement(ProMat);
            ps.setString(1, f.getPrefijo());
            ps.setString(2, f.getDescripcion());
            rs = ps.executeQuery();
            while (rs.next()) {
                prefijo_folio pf = new prefijo_folio();
                pf.setPrefijo(rs.getString("Prefijo"));
                pf.setDescripcion(rs.getString("Descripcion_ES"));
                pref.add(pf);
            }
        } catch (Exception e) {
            System.err.println("Error en MatchPrefijosAll, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pref;
    }

    public ArrayList<folios> GetAllFolios() {
        ArrayList<folios> fo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL CNF.Folios_ObtenerAll}");
            rs = ps.executeQuery();
            while (rs.next()) {
                fo.add(new folios(
                        rs.getString("id_folio"),
                        rs.getInt("folio_inicial"),
                        rs.getInt("folio_final"),
                        rs.getInt("folio_actual")
                ));
            }
        } catch (Exception e) {
            System.err.println("Error en GetAllFolios, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return fo;
    }

    public boolean ValidaPrefijo(String prefijo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean ban = false;
        try {
            ps = con.prepareCall("{CALL CNF.PrefFolios_validar(?)}");
            ps.setString(1, prefijo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidaPrefijo, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean ValidarFolioExistente(String prefijo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL CNF.Folios_ValidaExistente(?)}");
            ps.setString(1, prefijo);
            rs = ps.executeQuery();
            while (rs.next()) {
                String pref = rs.getString("id_folio");
                if (prefijo.equals(pref)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarFolioExistente, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public folios CargarAllDatos(String pref) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        folios f = new folios();
        try {
            ps = con.prepareCall("{CALL CNF.Folios_ObtenerDatosFolio(?)}");
            ps.setString(1, pref);
            rs = ps.executeQuery();
            while (rs.next()) {
                f.setIdFolios(rs.getString("id_folio"));
                f.setFolioInicial(rs.getInt("folio_inicial"));
                f.setFolioFinal(rs.getInt("folio_final"));
                f.setFolioActual(rs.getInt("folio_actual"));
            }
        } catch (Exception e) {
            System.err.println("Error en CargarAllDatos, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return f;
    }

    public boolean ActualizaFolio(folios f) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        boolean confirmacion = false;
        try {
            CallableStatement cbts = con.prepareCall("{CALL CNF.[Folios_ActualizarDatosFolio](?, ?, ?, ?)}");
            cbts.setString(1, f.getIdFolios());
            cbts.setInt(2, f.getFolioInicial());
            cbts.setInt(3, f.getFolioFinal());
            cbts.setInt(4, f.getFolioActual());
            if (cbts.executeUpdate() == 1) {
                confirmacion = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ActualizaFolio, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return confirmacion;
    }

    public boolean ActualizarFolioNOT(String pref, int Actual) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL CNF.Folios_ActualizarFolio(?,?)}";
        int cont;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pref);
            ps.setInt(2, Actual);
            cont = ps.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en ActualizarFolioNOT, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public folios CargarDatosFolios(String pref) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM CNF.folios WHERE id_folio='" + pref + "'";
        folios f = new folios();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                f.setIdFolios(rs.getString("id_folio"));
                f.setFolioInicial(rs.getInt("folio_inicial"));
                f.setFolioFinal(rs.getInt("folio_final"));
                f.setFolioActual(rs.getInt("folio_actual"));

            }
        } catch (Exception e) {
            System.err.println("Error en metodo CargarDatosFolios ACC_Folios() por: " + e);
        }
        cnx.CerrarConexion(con);
        return f;
    }
    public boolean ActualizarFolioNOTPP(String pref, int Actual) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{CALL CNF.Folios_ActualizarFolio(?,?)}";
        int cont;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pref);
            ps.setInt(2, Actual);
            cont = ps.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en ActualizarFolioNOT, ACC_Folios por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }
}
