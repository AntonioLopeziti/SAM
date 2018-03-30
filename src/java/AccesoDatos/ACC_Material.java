package AccesoDatos;

import Entidades.canal;
import Entidades.centros;
import Entidades.grupoarticulo;
import Entidades.materiales;
import Entidades.GrupoArticulos;
import Entidades.PlanPP;
import Entidades.materiales_almacen;
import Entidades.organizacion;
import Entidades.tipomaterial;
import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_Material {

    private static ACC_Material Instance = null;

    public static ACC_Material ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Material();
        }
        return Instance;
    }

    public boolean sujetoLote(String centro, String material) {
        String dec = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();

        String query = "{CALL PP.sujetoLotePP(?,?)}";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, centro);
            ps.setString(2, material);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error sujetoLote(), ACC_Material por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public int validaCantidad101(String cnt, String orden) {
        String exceso = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        double cc = 0.000;

        String query = "{CALL PP.cntOrden(?)}";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                cc = Double.parseDouble(rs.getString("cantidad_total"));
                exceso = rs.getString("exceso_suministro");
            }

            if (exceso.equals("X")) {
                return 1;
            } else if (Double.parseDouble(cnt) <= cc) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Error validaCantidad101(), ACC_Material por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }

    public int validaCantidad261(String material, String lote, String centro, String cnt) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        double cc = 0.000;

        String query = "{CALL PP.Notif_ConsultarCantidad261(?,?,?)}";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, material);
            ps.setString(2, lote);
            ps.setString(3, centro);
            rs = ps.executeQuery();
            while (rs.next()) {
                cc = Double.parseDouble(rs.getString("stocklibre_utilizacion"));
            }
            if (Double.parseDouble(cnt) <= cc) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println("Error validaCantidad261(), ACC_Material por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }
    public int validalote261(String material, String lote, String centro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();

        String query = "{CALL PP.Notif_ConsultarCantidad261(?,?,?)}";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, material);
            ps.setString(2, lote);
            ps.setString(3, centro);
            rs = ps.executeQuery();
            while (rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error validalote261(), ACC_Material por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }

    public String MMGetUniMed(String um) {
        String u = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.UnidadesMedida_ConsultaUniReservas(?)}");
            ps.setString(1, um);
            rs = ps.executeQuery();
            while (rs.next()) {
                u = rs.getString("decimales");
            }
        } catch (Exception e) {
            System.err.println("Error al traer el dato: " + e);
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
        return u;
    }

    public ArrayList<materiales> CargarMaterialMCSolped(String mat, String des, String cen, String tm, String descampo, String ctd, String us, String tips) {
        ArrayList<materiales> mate = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.Solped_CargarMateriales(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ps.setString(2, des);
            ps.setString(3, cen);
            ps.setString(4, tm);
            ps.setString(5, descampo);
            ps.setString(6, ctd);
            ps.setString(7, us);
            ps.setString(8, tips);
            rs = ps.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString(descampo));
                m.setCentro(rs.getString("centro"));
                m.setTipo_material(rs.getString("tipo_material"));
                m.setUnidad_medida(rs.getString("unidad_medida"));
                m.setGrupo_articulos(rs.getString("grupo_articulos"));
                m.setCategoria_valoracion(rs.getString("categoria_valoracion"));
                mate.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error CargarMaterialMCSolped por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mate;
    }

    public String GetDecUM(String um) {
        String dec = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();

        String query = "{CALL MM.GetDecUMMaterial(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, um);
            rs = ps.executeQuery();
            while (rs.next()) {
                dec = rs.getString("decimales");
            }
        } catch (Exception e) {
            System.out.println("Error GetDecUM por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return dec;
    }

    public String unidadM(String mat) {
        String um = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.unidadMedida_MOM(?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                um = rs.getString("unidad_medida");
            }
        } catch (Exception e) {
            System.err.println("Error inesperado por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return um;
    }

    public String unidadMT(String mat) {
        String um = "", query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            query = "select * from stock_transferecia where material = '" + mat + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                um = rs.getString("unidad_medida");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        cnx.CerrarConexion(con);
        return um;
    }

    public int ConsultaLoteMaterial(String Material) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.SujetoLote_MOM(?)}";

        int lote = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Material);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lote = 1;
            }
        } catch (Exception e) {
            System.err.println("Error por: " + e);
            lote = 0;
        } finally {
            cnx.CerrarConexion(con);
        }
        return lote;
    }

    public boolean ValidarMaterialModVisual(String mate, String centro) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT material FROM materiales WHERE material='" + mate + "' AND centro='" + centro + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String materi = rs.getString("material");
                if (materi.equals(mate)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultarMateriales (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public LinkedList<tipomaterial> ConsultaMatchTipoMaterial(String query, String idioma) {
        LinkedList<tipomaterial> tm = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String descripcion = "";
        if (idioma.equals("ES")) {
            descripcion = "descripcion_es";
        } else if (idioma.equals("EN")) {
            descripcion = "descripcion_en";
        } else {
            descripcion = null;
        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                tipomaterial t = new tipomaterial();
                t.setTipo(rs.getString("tipo_material"));
                t.setDescripcion(rs.getString(descripcion));
                tm.add(t);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
        }
        cnx.CerrarConexion(con);
        return tm;
    }

    public LinkedList<canal> ConsultaMatchCanal(String query, String idioma) {
        LinkedList<canal> can = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String descripcion = "";
        if (idioma.equals("ES")) {
            descripcion = "descripcion_es";
        } else if (idioma.equals("EN")) {
            descripcion = "descripcion_en";
        } else {
            descripcion = null;
        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                canal ca = new canal();
                ca.setCanal(rs.getString("canal_distribucion"));
                ca.setDescripcion(rs.getString(descripcion));
                can.add(ca);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
        }
        cnx.CerrarConexion(con);
        return can;
    }

    public LinkedList<grupoarticulo> ConsultaMatchGrupoArticulo(String query, String idioma) {
        LinkedList<grupoarticulo> gr = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String descripcion = "";
        String denominacion = "";
        if (idioma.equals("ES")) {
            descripcion = "descripcion_es";
            denominacion = "denominacion_es";
        } else if (idioma.equals("EN")) {
            descripcion = "descripcion_en";
            denominacion = "denominacion_en";
        } else {
            descripcion = null;
            denominacion = "";
        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                grupoarticulo g = new grupoarticulo();
                g.setGrupoArticulo(rs.getString("grupo_articulo"));
                g.setDenominacion(rs.getString(denominacion));
                g.setDescripcion(rs.getString(descripcion));
                gr.add(g);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
        }
        cnx.CerrarConexion(con);
        return gr;
    }

    public LinkedList<centros> ConsultaMatchCentro(String query) {
        LinkedList<centros> cen = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                centros c = new centros();

                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                cen.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Centro) " + e);
        }
        cnx.CerrarConexion(con);
        return cen;
    }

    public ArrayList ConsultaMatchMaterialOrden(String txt, String mt, String cent, String campoD, String ctd, String Pz) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList mats = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        materiales mat;
        String SP = "{CALL PM.Ordenes_ConsultarMaterial(?, ?, ?, ?, ?,?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, txt);
            ps.setString(2, mt);
            ps.setString(3, cent);
            ps.setString(4, campoD);
            ps.setString(5, ctd);
            ps.setString(6, Pz);
            rs = ps.executeQuery();
            while (rs.next()) {
                mat = new materiales();
                mat.setCentro(rs.getString("centro"));
                mat.setMaterial(rs.getString("material"));
                mat.setDescripcion(rs.getString(campoD));
                mat.setMateria(rs.getString("materia"));
                mats.add(mat);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchPuestoTrabajo(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mats;
    }

    public boolean ValidarMa(String m) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT material FROM materiales WHERE material = '" + m + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String mat = rs.getString("material");
                if (mat.equals(m)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo VaidarUsuarioModVisual (ACC_Usuario) por:" + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public LinkedList<materiales> CargarMaterialLstMat(String des, String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<materiales> mate = new LinkedList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                materiales ma = new materiales();
                ma.setMaterial(rs.getString("material"));
                ma.setDescripcion(rs.getString(des));
                ma.setCentro(rs.getString("centro"));
                mate.add(ma);
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return mate;
    }

    public LinkedList<materiales> MatNPMMatc(String mmmat, String mmtxtbr, String lan) {
        LinkedList<materiales> mt = new LinkedList<>();
        String query = "select * from materiales where material like'" + mmmat + "%'"
                + " and descripcion_" + lan + " like'" + mmtxtbr + "%'";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();

        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                materiales mat = new materiales();
                mat.setMaterial(rs.getString("material"));
                mat.setDescripcion(rs.getString("descripcion_" + lan));
                mt.add(mat);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return mt;
    }

    /*Crear-Modificar Avisos*/
    public LinkedList<materiales> AvisoMaterial(String query, String descripcion) {
        LinkedList<materiales> ma = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                materiales m = new materiales();
                m.setDescripcion(rs.getString(descripcion));
                m.setMaterial(rs.getString("material"));
                ma.add(m);
            }
        } catch (Exception ex) {
            System.err.println("Error en metodo AvisoMaterial (ACC_Material) por:" + ex);
        }
        cnx.CerrarConexion(con);
        return ma;
    }

    //Obtiene datos de la tabla material1111111111111111
    public materiales MMCargaDatosMatReserva(String mat, String deno) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        materiales m = new materiales();
        try {
            ps = con.prepareCall("{CALL MM.Materiales_ObtenerDatosMaterial(?)}");
            ps.setString(1, mat);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setUnidad_medida(rs.getString("unidad_medida"));
                m.setDescripcion(rs.getString(deno));
            }
        } catch (Exception e) {
            System.err.println("Erro al traer datos de materiales: " + e);
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
        return m;
    }

    /*---------------------*/
    public materiales CargarDatosReserva(String mate, String idioma) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        materiales ma = new materiales();
        String query = "SELECT * FROM MM.materiales WHERE material = '" + mate + "'";
        String descripcion = null;
        if (idioma.equals("ES")) {
            descripcion = "descripcion_ES";
        } else if (idioma.equals("EN")) {
            descripcion = "descripcion_EN";
        } else {
            descripcion = null;
        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setDescripcion(rs.getString(descripcion));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodoCargarDatosVisualMa (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return ma;
    }

    public int validMaterial(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT material FROM materiales WHERE material='" + id + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String mat = rs.getString("material");
                if (mat.equals(id)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }

        } catch (Exception e) {
            System.err.println("Error en validMaterial por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }

    public ArrayList<materiales> ConsultaMaterial(String texto, String lang, String Material, String Cantidad) {
        ArrayList<materiales> mm = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.materialesMatch_MOM(?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, texto);
            sp.setString(2, Material);
            sp.setString(3, Cantidad);
            sp.setString(4, "descripcion_" + lang);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString("descripcion_" + lang));
                mm.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mm;
    }

    public String ConsultaNombreMaterial(String Material, String lang) {
        String mm = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.nombre_material_MOM(?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, Material);
            sp.setString(2, "descripcion_" + lang);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                mm = rs.getString("descripcion_" + lang);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mm;
    }

    public materiales ValidarMaterial(String m, String d, String c, String us, String ts) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        materiales ma = new materiales();
        String query = "{CALL MM.Solped_ValidarMaterial(?,?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, m);
            ps.setString(2, d);
            ps.setString(3, c);
            ps.setString(4, us);
            ps.setString(5, ts);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setDescripcion(rs.getString(d));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setGrupo_articulos(rs.getString("grupo_articulos"));
                ma.setCategoria_valoracion(rs.getString("categoria_valoracion"));
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarMaterial ACC_Material por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ma;
    }

    public materiales CargarMaterialOrden(String numMat, String campoDes) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        materiales mat = new materiales();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarNumMaterial(?, ?)}";
        String check;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, numMat);
            ps.setString(2, campoDes);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (check.equals("x")) {
                mat = new materiales();
                mat.setMaterial("x");
            } else {
                mat = new materiales();
                mat.setMaterial(rs.getString("material"));
                mat.setUnidad_medida(rs.getString("unidad_medida"));
                mat.setCentro(rs.getString("centro"));
                mat.setDescripcion(rs.getString(campoDes));
            }

        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarMaterialOrden(ACC_Equipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mat;
    }

    public materiales CargarMaterial(String mate) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        materiales ma = new materiales();
        String query = "SELECT * FROM materiales WHERE material = '" + mate + "'";
        String descripcion = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setNum_material_ant(rs.getString("num_material_ant"));
                ma.setGrupo_articulos(rs.getString("grupo_articulos"));
                ma.setTipo_material(rs.getString("tipo_material"));
                ma.setSector(rs.getString("sector"));
                ma.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                ma.setGrupo_estadi_material(rs.getString("grupo_estadi_material"));
                ma.setGrupo_tipos_posi_ma_mate(rs.getString("grupo_tipos_posi_ma_mate"));
                ma.setJerarquia_produc(rs.getString("jerarquia_produc"));
                ma.setGrupo_precios_mate(rs.getString("grupo_precios_mate"));
                ma.setGrupo_imputa_material(rs.getString("grupo_imputa_material"));
                ma.setGrupo_tipo_posi_gen(rs.getString("grupo_tipo_posi_gen"));
                ma.setGrupo_veri_de_dispo(rs.getString("grupo_veri_de_dispo"));
                ma.setGrupo_transporte(rs.getString("grupo_transporte"));
                ma.setCentro_beneficio(rs.getString("centro_beneficio"));
                ma.setSujeto_lote(rs.getString("sujeto_lote"));
                ma.setDescripcion(rs.getString("descripcion_ES"));
                ma.setGrupo_carga(rs.getString("grupo_carga"));
                ma.setGrupo_compras(rs.getString("grupo_compras"));
                ma.setCara_plan_nece(rs.getString("cara_plan_nece"));
                ma.setPunto_pedido(rs.getString("punto_pedido"));
                ma.setCiclo_plan_nece(rs.getString("ciclo_plan_nece"));
                ma.setTam_lote_plan_nece(rs.getString("tam_lote_plan_nece"));
                ma.setTama_lote_min(rs.getString("tama_lote_min"));
                ma.setHoriz_plan_fijo(rs.getString("horiz_plan_fijo"));
                ma.setPlanificador_necesi(rs.getString("planificador_necesi"));
                ma.setTama_lote_max(rs.getString("tama_lote_max"));
                ma.setStock_maximo(rs.getString("stock_maximo"));
                ma.setClase_aprovisionamiento(rs.getString("clase_aprovisionamiento"));
                ma.setTiempo_trata_en_merca_dia(rs.getString("tiempo_trata_en_merca_dia"));
                ma.setStock_seguridad(rs.getString("stock_seguridad"));
                ma.setStock_seguridad_minimo(rs.getString("stock_seguridad_minimo"));
                ma.setClase_clase_aprov_espe(rs.getString("clase_aprovi_espe"));
                ma.setPlazo_entre_previ_dia(rs.getString("plazo_entre_previ_dia"));
                ma.setExiste_para_insp_mate_cen(rs.getString("existe_para_insp_mate_cen"));
                ma.setQm_activo_apro(rs.getString("qm_activo_apro"));
                ma.setIndicador_control_precios(rs.getString("indicador_control_precios"));
                ma.setPrecio_medio_vari_inte_per(rs.getString("precio_medio_vari_inte_per"));
                ma.setPrecio_estandar(rs.getString("precio_estandar"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setClase_valoracion(rs.getString("clase_valoracion"));
                ma.setCategoria_valoracion(rs.getString("categoria_valoracion"));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodoCargarDatosVisualMa (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return ma;
    }

    public LinkedList<materiales_almacen> MatNPMMalm(String mmmat, String mmtxtbr, String lan) {
        LinkedList<materiales_almacen> mt = new LinkedList<>();
        String query = "select top " + lan + " * from materiales_almacen where material like'" + mmmat + "%'"
                + " and texto_material like'" + mmtxtbr + "%' and almacen='M100'";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();

        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                materiales_almacen mat = new materiales_almacen();
                mat.setMaterial(rs.getString("material"));
                mat.setTexto_material(rs.getString("texto_material"));
                mat.setAlmacen(rs.getString("almacen"));
                mt.add(mat);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return mt;
    }

    public String CheckLIMat(String mat) {
        String ok = "NOT";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String que = "SELECT TOP 1 a.material, a.existe_para_insp_mate_cen  FROM materiales AS a INNER JOIN materiales_planes_inspeccion AS b on a.material = b.num_material WHERE a.existe_para_insp_mate_cen ='X' AND b.num_material = '" + mat + "' ";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(que);
            if (rs.next()) {
                ok = rs.getString("material");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        cnx.CerrarConexion(con);
        return ok;
    }

//    public static void main(String[] args) {
//        ACC_Material m = new ACC_Material();
//        System.out.println(m.CheckLIMat("20000022"));
//    }
    public LinkedList<materiales_almacen> Centro(String query) {
        LinkedList<materiales_almacen> cn = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                materiales_almacen ca = new materiales_almacen();
                ca.setCentro(rs.getString("centro"));
                cn.add(ca);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return cn;
    }

    public static void main(String args[]) {
        System.out.println(ACC_Material.ObtenerInstancia().ValidarAlmacenMaterial("10001000", "A100", "M100", "BAJA"));
    }

    public int ValidarAlmacenMaterial(String mat, String a1, String a2, String ce) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        int ban = 0;
        int check = 0;
        String sql = "{call MM.ReservaMaterial_Validar311(?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ps.setString(2, a1);
            ps.setString(3, a2);
            ps.setString(4, ce);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getInt(1);
            if (check == 2) {
                ban = 1;
            }

        } catch (Exception e) {
            System.err.println("Error en ValidarAlmacen ACC_ListaMateriales por " + e);
        }
        return ban;
    }

    public boolean MMValidaMaterialReservas(String mat, String cen, String alm) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.MaterialesAlmacen_ValidaMat(?, ?, ?)}");
            ps.setString(1, mat);
            ps.setString(2, cen);
            ps.setString(3, alm);
            rs = ps.executeQuery();
            while (rs.next()) {
                String mate = rs.getString("material");
                if (mat.equals(mate)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error al traer datos");
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

    public boolean ValidarMaterialModVisual2(String mate, String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String materi = rs.getString("material");
                if (materi.equals(mate)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultarMateriales (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public String obtenerCuentaMayor(String catval) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT TOP 1 num_cuenta_mayor FROM obyc WHERE categoria_valoracion = '" + catval + "'";
        String C = "N";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                C = rs.getString("num_cuenta_mayor");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        cnx.CerrarConexion(con);
        return C;
    }

    public int RelacionCMMaterial(String cv, String cm) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int n = 2;
        String query = "SELECT * FROM obyc WHERE categoria_valoracion = '" + cv + "' AND num_cuenta_mayor = '" + cm + "' ";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                n = 1;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        cnx.CerrarConexion(con);
        return n;
    }

    public LinkedList<materiales> MMConsultaMatchMateriales(String lim, String mat, String cen, String deno, String descripcion, String tpmat) {
        LinkedList<materiales> mats = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall("{CALL MM.Materiales_MatchMateriales(?, ?, ?, ?, ?, ?)}");
            ps.setString(1, lim);
            ps.setString(2, mat);
            ps.setString(3, cen);
            ps.setString(4, deno);
            ps.setString(5, descripcion);
            ps.setString(6, tpmat);
            rs = ps.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setCentro(rs.getString("centro"));
                m.setDescripcion(rs.getString(deno));
                m.setTipo_material(rs.getString("tipo_material"));
                mats.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error de traer datos en materiales: " + e);
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
        return mats;
    }

    public LinkedList<materiales> ConsultaMatchMaterialOfReservas(
            String mate, String des, String cen, String tipo, String lim, String deno) {

        LinkedList<materiales> mat = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        String query = "{call MM.Materiales_MuestraMatchMate(?, ?, ?, ?, ?)}";

        try {

            pst = conn.prepareCall(query);
            pst.setString(1, mate);
            pst.setString(2, des);
            pst.setString(3, cen);
            pst.setString(4, tipo);
            pst.setString(5, lim);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString(deno));
                m.setCentro(rs.getString("centro"));
                m.setTipo_material(rs.getString("tipo_material"));
                mat.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
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
        return mat;
    }

    public LinkedList<materiales> ConsultaMatchMaterial(String ctdaciertos, String mate, String cetr, String descrip, String texto_mate, String tpmat) {
        LinkedList<materiales> mat = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        String query = "{call MM.materiales_visulizar_materiales_match(?,?,?,?,?,?)}";

        try {

            pst = conn.prepareCall(query);
            pst.setString(1, ctdaciertos);
            pst.setString(2, mate);
            pst.setString(3, cetr);
            pst.setString(4, descrip);
            pst.setString(5, texto_mate);
            pst.setString(6, tpmat);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString(descrip));
                m.setCentro(rs.getString("centro"));
                m.setTipo_material(rs.getString("tipo_material"));
                mat.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
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
        return mat;
    }

    public LinkedList<organizacion> ConsultaMatchOrganizacion() {
        LinkedList<organizacion> or = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        String query = "{call MM.organizacion_ventas_ConsultaMatchOrganizacion}";
        try {
            pst = conn.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                organizacion o = new organizacion();
                o.setOrganizacion(rs.getString("organizacion_ventas"));
                o.setDescripcion(rs.getString("denominacion"));
                or.add(o);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
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
        return or;
    }

    public materiales CargarDatosVisualMa(String mate, String centro, String orga, String can, String idioma) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        materiales ma = new materiales();
        String descripcion = null;
        if (idioma.equals("ES")) {
            descripcion = "descripcion_ES";
        } else if (idioma.equals("EN")) {
            descripcion = "descripcion_EN";
        } else {
            descripcion = null;
        }
        ResultSet rs = null;
        CallableStatement pst = null;
        String query = "{call MM.materiales_CargarDatosVisualMateriales(?,?,?,?,?)}";

        try {

            pst = conn.prepareCall(query);
            pst.setString(1, mate);
            pst.setString(2, centro);
            pst.setString(3, orga);
            pst.setString(4, can);
            pst.setString(5, descripcion);
            rs = pst.executeQuery();
            while (rs.next()) {
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                ma.setCanal_distribucion(rs.getString("canal_distribucion"));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setNum_material_ant(rs.getString("num_material_ant"));
                ma.setGrupo_articulos(rs.getString("grupo_articulos"));
                ma.setTipo_material(rs.getString("tipo_material"));
                ma.setSector(rs.getString("sector"));
                ma.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                ma.setGrupo_estadi_material(rs.getString("grupo_estadi_material"));
                ma.setGrupo_tipos_posi_ma_mate(rs.getString("grupo_tipos_posi_ma_mate"));
                ma.setJerarquia_produc(rs.getString("jerarquia_produc"));
                ma.setGrupo_precios_mate(rs.getString("grupo_precios_mate"));
                ma.setGrupo_imputa_material(rs.getString("grupo_imputa_material"));
                ma.setGrupo_tipo_posi_gen(rs.getString("grupo_tipo_posi_gen"));
                ma.setGrupo_veri_de_dispo(rs.getString("grupo_veri_de_dispo"));
                ma.setGrupo_transporte(rs.getString("grupo_transporte"));
                ma.setCentro_beneficio(rs.getString("centro_beneficio"));
                ma.setSujeto_lote(rs.getString("sujeto_lote"));
                ma.setDescripcion(rs.getString(descripcion));
                ma.setGrupo_carga(rs.getString("grupo_carga"));
                ma.setGrupo_compras(rs.getString("grupo_compras"));
                ma.setCara_plan_nece(rs.getString("cara_plan_nece"));
                ma.setPunto_pedido(rs.getString("punto_pedido"));
                ma.setCiclo_plan_nece(rs.getString("ciclo_plan_nece"));
                ma.setTam_lote_plan_nece(rs.getString("tam_lote_plan_nece"));
                ma.setTama_lote_min(rs.getString("tama_lote_min"));
                ma.setHoriz_plan_fijo(rs.getString("horiz_plan_fijo"));
                ma.setPlanificador_necesi(rs.getString("planificador_necesi"));
                ma.setTama_lote_max(rs.getString("tama_lote_max"));
                ma.setStock_maximo(rs.getString("stock_maximo"));
                ma.setClase_aprovisionamiento(rs.getString("clase_aprovisionamiento"));
                ma.setTiempo_trata_en_merca_dia(rs.getString("tiempo_trata_en_merca_dia"));
                ma.setStock_seguridad(rs.getString("stock_seguridad"));
                ma.setStock_seguridad_minimo(rs.getString("stock_seguridad_minimo"));
                ma.setClase_clase_aprov_espe(rs.getString("clase_aprovi_espe"));
                ma.setPlazo_entre_previ_dia(rs.getString("plazo_entre_previ_dia"));
                ma.setExiste_para_insp_mate_cen(rs.getString("existe_para_insp_mate_cen"));
                ma.setQm_activo_apro(rs.getString("qm_activo_apro"));
                ma.setIndicador_control_precios(rs.getString("indicador_control_precios"));
                ma.setPrecio_medio_vari_inte_per(rs.getString("precio_medio_vari_inte_per"));
                ma.setPrecio_estandar(rs.getString("precio_estandar"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setClase_valoracion(rs.getString("clase_valoracion"));
                ma.setCategoria_valoracion(rs.getString("categoria_valoracion"));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodoCargarDatosVisualMa (ACC_Material) por: " + e);

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
        return ma;
    }

    public LinkedList<materiales_almacen> MatNPMMalmNOT(String mmmat, String mmtxtbr, String lan) {
        LinkedList<materiales_almacen> mt = new LinkedList<>();
        String query = "{call MM.materiales_almacen_match(?,?,?)}";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, mmmat);
            pst.setString(2, mmtxtbr);
            pst.setString(3, lan);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales_almacen mat = new materiales_almacen();
                mat.setMaterial(rs.getString("material"));
                mat.setTexto_material(rs.getString("texto_material"));
                mat.setAlmacen(rs.getString("almacen"));
                mt.add(mat);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return mt;
    }

    public LinkedList<materiales> ConsultaMatMatch(String mat, String des, String lim, String deno) {
        LinkedList<materiales> ma = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        try {
            pst = con.prepareCall("{CALL MM.Materiales_MatchMaterialAll(?, ?, ?)}");
            pst.setString(1, mat);
            pst.setString(2, des);
            pst.setString(3, lim);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setCentro(rs.getString("centro"));
                m.setDescripcion(rs.getString(deno));
                ma.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error match mat: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return ma;
    }

    public int ConsultaLoteMaterialNOT(String Material) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call MM.materiales_ConsNOT(?)}";

        int lote = 0;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, Material);
            rs = pst.executeQuery();
            while (rs.next()) {
                lote = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
            lote = 0;
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
        return lote;
    }

    //Metodo para validar material
    public boolean ValidaMaterial(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        materiales m = new materiales();
        try {
            ps = con.prepareCall("{CALL MM.Material_ValidaMat(?)}");
            ps.setString(1, mat);
            rs = ps.executeQuery();
            while (rs.next()) {
                String material = rs.getString("material");
                if (mat.equals(material)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error de validar material: " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return false;
    }

    public LinkedList<materiales> CargarTodoMaterialNOT(String mater, String descripcion) {
        LinkedList<materiales> mate = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call MM.materiales_TABPM01(?)}";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, mater);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales ma = new materiales();
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setNum_material_ant(rs.getString("num_material_ant"));
                ma.setGrupo_articulos(rs.getString("grupo_articulos"));
                ma.setTipo_material(rs.getString("tipo_material"));
                ma.setGrupo_transporte(rs.getString("grupo_transporte"));
                ma.setGrupo_compras(rs.getString("grupo_compras"));
                ma.setSujeto_lote(rs.getString("sujeto_lote"));
                ma.setDescripcion(rs.getString(descripcion));
                ma.setCara_plan_nece(rs.getString("cara_plan_nece"));
                ma.setPunto_pedido(rs.getString("punto_pedido"));
                ma.setCiclo_plan_nece(rs.getString("ciclo_plan_nece"));
                ma.setHoriz_plan_fijo(rs.getString("horiz_plan_fijo"));
                ma.setPlanificador_necesi(rs.getString("planificador_necesi"));
                ma.setTam_lote_plan_nece(rs.getString("tam_lote_plan_nece"));
                ma.setTama_lote_min(rs.getString("tama_lote_min"));
                ma.setTama_lote_max(rs.getString("tama_lote_max"));
                ma.setStock_maximo(rs.getString("stock_maximo"));
                ma.setClase_aprovisionamiento(rs.getString("clase_aprovisionamiento"));
                ma.setClase_clase_aprov_espe(rs.getString("clase_aprovi_espe"));
                ma.setTiempo_trata_en_merca_dia(rs.getString("tiempo_trata_en_merca_dia"));
                ma.setPlazo_entre_previ_dia(rs.getString("plazo_entre_previ_dia"));
                ma.setStock_seguridad(rs.getString("stock_seguridad"));
                ma.setStock_seguridad_minimo(rs.getString("stock_seguridad_minimo"));
                ma.setExiste_para_insp_mate_cen(rs.getString("existe_para_insp_mate_cen"));
                ma.setQm_activo_apro(rs.getString("qm_activo_apro"));
                ma.setSector(rs.getString("sector"));
                ma.setGrupo_tipo_posi_gen(rs.getString("grupo_tipo_posi_gen"));
                ma.setGrupo_veri_de_dispo(rs.getString("grupo_veri_de_dispo"));
                ma.setCentro_beneficio(rs.getString("centro_beneficio"));
                ma.setGrupo_carga(rs.getString("grupo_carga"));
                ma.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                ma.setGrupo_precios_mate(rs.getString("grupo_precios_mate"));
                ma.setGrupo_estadi_material(rs.getString("grupo_estadi_material"));
                ma.setGrupo_imputa_material(rs.getString("grupo_imputa_material"));
                ma.setGrupo_tipos_posi_ma_mate(rs.getString("grupo_tipos_posi_ma_mate"));
                ma.setJerarquia_produc(rs.getString("jerarquia_produc"));
                ma.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                ma.setGrupo_vendedores(rs.getString("grupo_vendedores"));
                ma.setCanal_distribucion(rs.getString("canal_distribucion"));
                ma.setIndicador_control_precios(rs.getString("indicador_control_precios"));
                ma.setPrecio_medio_vari_inte_per(rs.getString("precio_medio_vari_inte_per"));
                ma.setPrecio_estandar(rs.getString("precio_estandar"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setClase_valoracion(rs.getString("clase_valoracion"));
                ma.setCategoria_valoracion(rs.getString("categoria_valoracion"));
                mate.add(ma);
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
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
        return mate;
    }

    public materiales CargarMaterialNOT(String mate) {
        materiales ma = new materiales();
        String descripcion = null;
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call MM.materiales_TABPM01(?)}";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, mate);
            rs = pst.executeQuery();
            while (rs.next()) {
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setNum_material_ant(rs.getString("num_material_ant"));
                ma.setGrupo_articulos(rs.getString("grupo_articulos"));
                ma.setTipo_material(rs.getString("tipo_material"));
                ma.setSector(rs.getString("sector"));
                ma.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                ma.setGrupo_estadi_material(rs.getString("grupo_estadi_material"));
                ma.setGrupo_tipos_posi_ma_mate(rs.getString("grupo_tipos_posi_ma_mate"));
                ma.setJerarquia_produc(rs.getString("jerarquia_produc"));
                ma.setGrupo_precios_mate(rs.getString("grupo_precios_mate"));
                ma.setGrupo_imputa_material(rs.getString("grupo_imputa_material"));
                ma.setGrupo_tipo_posi_gen(rs.getString("grupo_tipo_posi_gen"));
                ma.setGrupo_veri_de_dispo(rs.getString("grupo_veri_de_dispo"));
                ma.setGrupo_transporte(rs.getString("grupo_transporte"));
                ma.setCentro_beneficio(rs.getString("centro_beneficio"));
                ma.setSujeto_lote(rs.getString("sujeto_lote"));
                ma.setDescripcion(rs.getString("descripcion_ES"));
                ma.setGrupo_carga(rs.getString("grupo_carga"));
                ma.setGrupo_compras(rs.getString("grupo_compras"));
                ma.setCara_plan_nece(rs.getString("cara_plan_nece"));
                ma.setPunto_pedido(rs.getString("punto_pedido"));
                ma.setCiclo_plan_nece(rs.getString("ciclo_plan_nece"));
                ma.setTam_lote_plan_nece(rs.getString("tam_lote_plan_nece"));
                ma.setTama_lote_min(rs.getString("tama_lote_min"));
                ma.setHoriz_plan_fijo(rs.getString("horiz_plan_fijo"));
                ma.setPlanificador_necesi(rs.getString("planificador_necesi"));
                ma.setTama_lote_max(rs.getString("tama_lote_max"));
                ma.setStock_maximo(rs.getString("stock_maximo"));
                ma.setClase_aprovisionamiento(rs.getString("clase_aprovisionamiento"));
                ma.setTiempo_trata_en_merca_dia(rs.getString("tiempo_trata_en_merca_dia"));
                ma.setStock_seguridad(rs.getString("stock_seguridad"));
                ma.setStock_seguridad_minimo(rs.getString("stock_seguridad_minimo"));
                ma.setClase_clase_aprov_espe(rs.getString("clase_aprovi_espe"));
                ma.setPlazo_entre_previ_dia(rs.getString("plazo_entre_previ_dia"));
                ma.setExiste_para_insp_mate_cen(rs.getString("existe_para_insp_mate_cen"));
                ma.setQm_activo_apro(rs.getString("qm_activo_apro"));
                ma.setIndicador_control_precios(rs.getString("indicador_control_precios"));
                ma.setPrecio_medio_vari_inte_per(rs.getString("precio_medio_vari_inte_per"));
                ma.setPrecio_estandar(rs.getString("precio_estandar"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setClase_valoracion(rs.getString("clase_valoracion"));
                ma.setCategoria_valoracion(rs.getString("categoria_valoracion"));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodoCargarDatosVisualMa (ACC_Material) por: " + e);
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
        return ma;
    }
    //Stock Material

    public ArrayList<materiales> ConsultaMatchMateriales(String mate, String cet, String texto_mate, String idioma, String no_campo, String limite) {
        ArrayList<materiales> mat = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ConsMat(?,?,?,?,?,?)}");
            pst.setString(1, mate);
            pst.setString(2, cet);
            pst.setString(3, texto_mate);
            pst.setString(4, idioma);
            pst.setString(5, no_campo);
            pst.setString(6, limite);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales ma = new materiales();
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setDescripcion(rs.getString(no_campo));
                mat.add(ma);
            }
        } catch (Exception e) {
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
        return mat;
    }

    //Stock Material Match Grupo Articulos 
    public ArrayList<GrupoArticulos> ConsultaMatchGrupoArticuloo(String idioma) {
        ArrayList<GrupoArticulos> gr = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            if (idioma.equals("ES")) {
                pst = con.prepareCall("{call MM.StockMat_ConsGpoArtES()}");
                rs = pst.executeQuery();
                while (rs.next()) {
                    GrupoArticulos g = new GrupoArticulos();
                    g.setGrupo_articulo(rs.getString("grupo_articulo"));
                    g.setDenominacion_ES(rs.getString("denominacion_ES"));
                    g.setDescripcion_ES(rs.getString("descripcion_ES"));
                    gr.add(g);
                }
            } else if (idioma.equals("EN")) {
                pst = con.prepareCall("{call MM.StockMat_ConsGpoArtEN()}");
                rs = pst.executeQuery();
                while (rs.next()) {
                    GrupoArticulos g = new GrupoArticulos();
                    g.setGrupo_articulo(rs.getString("grupo_articulo"));
                    g.setDenominacion_EN(rs.getString("denominacion_EN"));
                    g.setDescripcion_EN(rs.getString("descripcion_EN"));
                    gr.add(g);
                }
            } else {

            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
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

        return gr;
    }

    public String ValidarMatExis(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_ValidarMaterial(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarMatExis" + e);
        }
        return check;
    }

    public String ValidarMatExis303(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_ValidarMaterial303(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarMatExis303" + e);
        }
        return check;
    }

    public String ValidarMtl303(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_ValidarMTL(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarMatExis303" + e);
        }
        return check;
    }

    public String CheckLotVal303(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.MovimientosValidarSujLot(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarMatExis303" + e);
        }
        return check;
    }

    public boolean ValidarMateCrea(String mate) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String proc = "{CALL  MM.Material_ValidarCrearMaterial(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(proc);
            ps.setString(1, mate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println();
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }

    public boolean InsertarMateCrea(materiales mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL MM.Materiales_InsertMate(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, mat.getMaterial());
            ps.setString(2, mat.getCentro());
            ps.setString(3, mat.getUnidad_medida());
            ps.setString(4, mat.getGrupo_articulos());
            ps.setString(5, mat.getTipo_material());
            ps.setString(6, mat.getGrupo_transporte());
            ps.setString(7, mat.getGrupo_compras());
            ps.setString(8, mat.getSujeto_lote());
            ps.setString(9, mat.getCara_plan_nece());
            ps.setString(10, mat.getPunto_pedido());
            ps.setString(11, mat.getHoriz_plan_fijo());
            ps.setString(12, mat.getPlanificador_necesi());
            ps.setString(13, mat.getTama_lote_min());
            ps.setString(14, mat.getTama_lote_max());
            //Falto
            ps.setString(15, mat.getStock_maximo());
            ps.setString(16, mat.getClase_aprovisionamiento());
            //Falto
            ps.setString(17, mat.getPlazo_entre_previ_dia());
            ps.setString(18, mat.getStock_seguridad());
            ps.setString(19, mat.getStock_seguridad_minimo());
            ps.setString(20, mat.getQm_activo_apro());
            ps.setString(21, mat.getSector());
            ps.setString(22, mat.getGrupo_tipo_posi_gen());
            ps.setString(23, mat.getGrupo_veri_de_dispo());
            ps.setString(24, mat.getCentro_beneficio());
            ps.setString(25, mat.getGrupo_carga());
            ps.setString(26, mat.getUnidad_medida_venta());
            ps.setString(27, mat.getGrupo_imputa_material());
            ps.setString(28, mat.getJerarquia_produc());
            ps.setString(29, mat.getOrganizacion_ventas());
            ps.setString(30, mat.getIndicador_control_precios());
            ps.setString(31, mat.getPrecio_estandar());
            ps.setString(32, mat.getCantidad_base());
            ps.setString(33, mat.getClase_valoracion());
            ps.setString(34, mat.getCategoria_valoracion());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarMaterial por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public boolean InsertarMateCreaPP(materiales mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL PP.Materiales_InsertMate(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, mat.getMaterial());
            ps.setString(2, mat.getCentro());
            ps.setString(3, mat.getUnidad_medida());
            ps.setString(4, mat.getGrupo_articulos());
            ps.setString(5, mat.getTipo_material());
            ps.setString(6, mat.getGrupo_transporte());
            ps.setString(7, mat.getGrupo_compras());
            ps.setString(8, mat.getSujeto_lote());
            ps.setString(9, mat.getCara_plan_nece());
            ps.setString(10, mat.getPunto_pedido());
            ps.setString(11, mat.getHoriz_plan_fijo());
            ps.setString(12, mat.getPlanificador_necesi());
            ps.setString(13, mat.getTama_lote_min());
            ps.setString(14, mat.getTama_lote_max());
            //Falto
            ps.setString(15, mat.getStock_maximo());
            ps.setString(16, mat.getClase_aprovisionamiento());
            //Falto
            ps.setString(17, mat.getPlazo_entre_previ_dia());
            ps.setString(18, mat.getStock_seguridad());
            ps.setString(19, mat.getStock_seguridad_minimo());
            ps.setString(20, mat.getQm_activo_apro());
            ps.setString(21, mat.getSector());
            ps.setString(22, mat.getGrupo_tipo_posi_gen());
            ps.setString(23, mat.getGrupo_veri_de_dispo());
            ps.setString(24, mat.getCentro_beneficio());
            ps.setString(25, mat.getGrupo_carga());
            ps.setString(26, mat.getUnidad_medida_venta());
            ps.setString(27, mat.getGrupo_imputa_material());
            ps.setString(28, mat.getJerarquia_produc());
            ps.setString(29, mat.getOrganizacion_ventas());
            ps.setString(30, mat.getIndicador_control_precios());
            ps.setString(31, mat.getPrecio_estandar());
            ps.setString(32, mat.getCantidad_base());
            ps.setString(33, mat.getClase_valoracion());
            ps.setString(34, mat.getCategoria_valoracion());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarMaterial por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    //////// CONSULTA MATCH MATERIAL VIS MAT PP
    public LinkedList<materiales> ConsultaMatchMaterialPP(String ctdaciertos, String mate, String cetr, String descrip, String texto_mate, String tpmat) {
        LinkedList<materiales> mat = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        String query = "{call PP.materiales_visulizar_materiales_match(?,?,?,?,?,?)}";

        try {

            pst = conn.prepareCall(query);
            pst.setString(1, ctdaciertos);
            pst.setString(2, mate);
            pst.setString(3, cetr);
            pst.setString(4, descrip);
            pst.setString(5, texto_mate);
            pst.setString(6, tpmat);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString(descrip));
                m.setCentro(rs.getString("centro"));
                m.setTipo_material(rs.getString("tipo_material"));
                mat.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
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
        return mat;
    }

    public materiales CargarDatosVisualMaPP(String mate, String centro, String orga, String can, String idioma) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        materiales ma = new materiales();
        String descripcion = null;
        if (idioma.equals("ES")) {
            descripcion = "descripcion_ES";
        } else if (idioma.equals("EN")) {
            descripcion = "descripcion_EN";
        } else {
            descripcion = null;
        }
        ResultSet rs = null;
        CallableStatement pst = null;
        String query = "{call PP.materiales_CargarDatosVisualMateriales(?,?,?,?,?)}";

        try {

            pst = conn.prepareCall(query);
            pst.setString(1, mate);
            pst.setString(2, centro);
            pst.setString(3, orga);
            pst.setString(4, can);
            pst.setString(5, descripcion);
            rs = pst.executeQuery();
            while (rs.next()) {
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                ma.setCanal_distribucion(rs.getString("canal_distribucion"));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setNum_material_ant(rs.getString("num_material_ant"));
                ma.setGrupo_articulos(rs.getString("grupo_articulos"));
                ma.setTipo_material(rs.getString("tipo_material"));
                ma.setSector(rs.getString("sector"));
                ma.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                ma.setGrupo_estadi_material(rs.getString("grupo_estadi_material"));
                ma.setGrupo_tipos_posi_ma_mate(rs.getString("grupo_tipos_posi_ma_mate"));
                ma.setJerarquia_produc(rs.getString("jerarquia_produc"));
                ma.setGrupo_precios_mate(rs.getString("grupo_precios_mate"));
                ma.setGrupo_imputa_material(rs.getString("grupo_imputa_material"));
                ma.setGrupo_tipo_posi_gen(rs.getString("grupo_tipo_posi_gen"));
                ma.setGrupo_veri_de_dispo(rs.getString("grupo_veri_de_dispo"));
                ma.setGrupo_transporte(rs.getString("grupo_transporte"));
                ma.setCentro_beneficio(rs.getString("centro_beneficio"));
                ma.setSujeto_lote(rs.getString("sujeto_lote"));
                ma.setDescripcion(rs.getString(descripcion));
                ma.setGrupo_carga(rs.getString("grupo_carga"));
                ma.setGrupo_compras(rs.getString("grupo_compras"));
                ma.setCara_plan_nece(rs.getString("cara_plan_nece"));
                ma.setPunto_pedido(rs.getString("punto_pedido"));
                ma.setCiclo_plan_nece(rs.getString("ciclo_plan_nece"));
                ma.setTam_lote_plan_nece(rs.getString("tam_lote_plan_nece"));
                ma.setTama_lote_min(rs.getString("tama_lote_min"));
                ma.setHoriz_plan_fijo(rs.getString("horiz_plan_fijo"));
                ma.setPlanificador_necesi(rs.getString("planificador_necesi"));
                ma.setTama_lote_max(rs.getString("tama_lote_max"));
                ma.setStock_maximo(rs.getString("stock_maximo"));
                ma.setClase_aprovisionamiento(rs.getString("clase_aprovisionamiento"));
                ma.setTiempo_trata_en_merca_dia(rs.getString("tiempo_trata_en_merca_dia"));
                ma.setStock_seguridad(rs.getString("stock_seguridad"));
                ma.setStock_seguridad_minimo(rs.getString("stock_seguridad_minimo"));
                ma.setClase_clase_aprov_espe(rs.getString("clase_aprovi_espe"));
                ma.setPlazo_entre_previ_dia(rs.getString("plazo_entre_previ_dia"));
                ma.setExiste_para_insp_mate_cen(rs.getString("existe_para_insp_mate_cen"));
                ma.setQm_activo_apro(rs.getString("qm_activo_apro"));
                ma.setIndicador_control_precios(rs.getString("indicador_control_precios"));
                ma.setPrecio_medio_vari_inte_per(rs.getString("precio_medio_vari_inte_per"));
                ma.setPrecio_estandar(rs.getString("precio_estandar"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setClase_valoracion(rs.getString("clase_valoracion"));
                ma.setCategoria_valoracion(rs.getString("categoria_valoracion"));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodoCargarDatosVisualMa (ACC_Material) por: " + e);

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
        return ma;
    }

    //MONITOR DE MATERIALES        
    public int ConsultarMateMonEq(String id) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        int res = 0;
        String query = "{CALL PP.Mate_ConsultaMaterialMonitorPP(?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales mat = new materiales();
                mat.setMaterial(rs.getString("material"));
                res = 1;
            }
        } catch (Exception e) {
            res = 0;
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
                System.err.println("Error :" + e);
            }
        }
        return res;
    }

    public LinkedList<materiales> ConsultarMateMonEqPP(String Mate, String DenMat, String CaMat, String des) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        LinkedList<materiales> equi = new LinkedList<>();
        PreparedStatement pst = null;
//        String query = "{call PM.equipos_ConsultarEquipoMatchMOAV(?,?,?,?,?)}";
        String query = "{call PP.Materiales_ConsultarMaterMatchMonPP(?,?,?,?)}";
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, Mate);
            pst.setString(2, DenMat);
            pst.setString(3, CaMat);
            pst.setString(4, des);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales ms = new materiales();
                ms.setMaterial(rs.getString("material"));
                ms.setDescripcion_material(rs.getString(des));
                equi.add(ms);
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
            } catch (Exception a) {
                System.err.println("Error :" + a);
            }
        }
        return equi;
    }

    public String getExisNumMatePP(String mate) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PP.Ordenes_ValidarNumMat(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mate);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            while (rs.next()) {
                check = rs.getString("material");
            }
        } catch (Exception e) {
            System.err.println("Error en ACC_Material(), getExisNumMatePP" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public ArrayList ConsultarMaterialMatchOrdPP(String denMat, String numMat, String descIdMat, String ctdMat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList eqs = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PP.Ordenes_ConsultarMaterial(?, ?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, denMat);
            ps.setString(2, numMat);
            ps.setString(3, descIdMat);
            ps.setString(4, ctdMat);
            rs = ps.executeQuery();
            while (rs.next()) {
                materiales eq = new materiales();
                eq.setMaterial(rs.getString("material"));
                eq.setDescripcion_material(rs.getString(descIdMat));
                eqs.add(eq);
            }

        } catch (Exception e) {
            System.err.println("Error en metodo ConsultarEquipoMatchOrd por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eqs;
    }

    public ArrayList<PlanPP> MatchMaterialesListOrdenPP(String Cant, String Idioma, String Mate, String DenMate) {
        ArrayList<PlanPP> plMa = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.MatchMateriales_ListaordenPP(?,?,?,?)}";
        String denominacion = "denominacion_" + Idioma;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Cant);
            pst.setString(2, Idioma);
            pst.setString(3, Mate);
            pst.setString(4, DenMate);
            rs = pst.executeQuery();
            while (rs.next()) {
                PlanPP py = new PlanPP();
                py.setNum_material(rs.getString("num_material"));
                py.setTexto_material(rs.getString("texto_material"));
                plMa.add(py);
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
        return plMa;
    }

    public ArrayList<materiales> SP_MatchMateListaordenPP(String Cant, String Idioma, String Mate, String DenMate) {
        ArrayList<materiales> sp_mate = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.MatchMateriales_ListaordenPP(?,?,?,?)}";
        String denominacion = "denominacion_" + Idioma;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Cant);
            pst.setString(2, Idioma);
            pst.setString(3, Mate);
            pst.setString(4, DenMate);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales eq = new materiales();
                eq.setMaterial(rs.getString("material"));
                eq.setDescripcion(rs.getString(denominacion));
//                eq.setNum_equipo(rs.getString("num_equipo"));
//                eq.setDenominacion(rs.getString(denominacion));
                sp_mate.add(eq);
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

        return sp_mate;
    }

    public ArrayList<materiales_almacen> listadoMaterialesHabilitado(String centro, String almacen) {
        ArrayList<materiales_almacen> mate = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.ListadoMaterialesHabilitar(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, centro);
            ps.setString(2, almacen);
            rs = ps.executeQuery();
            while (rs.next()) {
                materiales_almacen m = new materiales_almacen();
                m.setMaterial(rs.getString("material"));
                m.setCentro(rs.getString("centro"));
                m.setAlmacen(rs.getString("almacen"));
                m.setTexto_material(rs.getString("texto_material"));
                m.setHabilitado(rs.getString("habilitado"));
                mate.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error listadoMaterialesHabilitado por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mate;
    }

    public int ValidaMaterialHabilitado(String mat, String ctr, String alm) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareCall("{CALL MM.MaterialHabilitado(?,?,?)}");
            ps.setString(1, mat);
            ps.setString(2, ctr);
            ps.setString(3, alm);
            rs = ps.executeQuery();
            while (rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidaMaterialHabilitado: " + e);
            return 0;
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion: " + e);
            }
        }
        return 0;
    }

    public LinkedList<materiales> CargarTodoMaterialNotPP(String mater, String descripcion) {
        LinkedList<materiales> mate = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.materiales_TABPP01PP(?)}";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, mater);
            rs = pst.executeQuery();
            while (rs.next()) {
                materiales ma = new materiales();
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setNum_material_ant(rs.getString("num_material_ant"));
                ma.setGrupo_articulos(rs.getString("grupo_articulos"));
                ma.setTipo_material(rs.getString("tipo_material"));
                ma.setGrupo_transporte(rs.getString("grupo_transporte"));
                ma.setGrupo_compras(rs.getString("grupo_compras"));
                ma.setSujeto_lote(rs.getString("sujeto_lote"));
                ma.setDescripcion(rs.getString(descripcion));
                ma.setCara_plan_nece(rs.getString("cara_plan_nece"));
                ma.setPunto_pedido(rs.getString("punto_pedido"));
                ma.setCiclo_plan_nece(rs.getString("ciclo_plan_nece"));
                ma.setHoriz_plan_fijo(rs.getString("horiz_plan_fijo"));
                ma.setPlanificador_necesi(rs.getString("planificador_necesi"));
                ma.setTam_lote_plan_nece(rs.getString("tam_lote_plan_nece"));
                ma.setTama_lote_min(rs.getString("tama_lote_min"));
                ma.setTama_lote_max(rs.getString("tama_lote_max"));
                ma.setStock_maximo(rs.getString("stock_maximo"));
                ma.setClase_aprovisionamiento(rs.getString("clase_aprovisionamiento"));
                ma.setClase_clase_aprov_espe(rs.getString("clase_aprovi_espe"));
                ma.setTiempo_trata_en_merca_dia(rs.getString("tiempo_trata_en_merca_dia"));
                ma.setPlazo_entre_previ_dia(rs.getString("plazo_entre_previ_dia"));
                ma.setStock_seguridad(rs.getString("stock_seguridad"));
                ma.setStock_seguridad_minimo(rs.getString("stock_seguridad_minimo"));
                ma.setExiste_para_insp_mate_cen(rs.getString("existe_para_insp_mate_cen"));
                ma.setQm_activo_apro(rs.getString("qm_activo_apro"));
                ma.setSector(rs.getString("sector"));
                ma.setGrupo_tipo_posi_gen(rs.getString("grupo_tipo_posi_gen"));
                ma.setGrupo_veri_de_dispo(rs.getString("grupo_veri_de_dispo"));
                ma.setCentro_beneficio(rs.getString("centro_beneficio"));
                ma.setGrupo_carga(rs.getString("grupo_carga"));
                ma.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                ma.setGrupo_precios_mate(rs.getString("grupo_precios_mate"));
                ma.setGrupo_estadi_material(rs.getString("grupo_estadi_material"));
                ma.setGrupo_imputa_material(rs.getString("grupo_imputa_material"));
                ma.setGrupo_tipos_posi_ma_mate(rs.getString("grupo_tipos_posi_ma_mate"));
                ma.setJerarquia_produc(rs.getString("jerarquia_produc"));
                ma.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                ma.setGrupo_vendedores(rs.getString("grupo_vendedores"));
                ma.setCanal_distribucion(rs.getString("canal_distribucion"));
                ma.setIndicador_control_precios(rs.getString("indicador_control_precios"));
                ma.setPrecio_medio_vari_inte_per(rs.getString("precio_medio_vari_inte_per"));
                ma.setPrecio_estandar(rs.getString("precio_estandar"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setClase_valoracion(rs.getString("clase_valoracion"));
                ma.setCategoria_valoracion(rs.getString("categoria_valoracion"));
                mate.add(ma);
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
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
        return mate;
    }

    public materiales CargarMaterialNotPP(String mate) {
        materiales ma = new materiales();
        String descripcion = null;
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PP.materiales_TABPP01PP(?)}";
//        String query = "{call MM.materiales_TABPM01(?)}";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, mate);
            rs = pst.executeQuery();
            while (rs.next()) {
                ma.setMaterial(rs.getString("material"));
                ma.setCentro(rs.getString("centro"));
                ma.setOrganizacion_ventas(rs.getString("organizacion_ventas"));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setNum_material_ant(rs.getString("num_material_ant"));
                ma.setGrupo_articulos(rs.getString("grupo_articulos"));
                ma.setTipo_material(rs.getString("tipo_material"));
                ma.setSector(rs.getString("sector"));
                ma.setUnidad_medida_venta(rs.getString("unidad_medida_venta"));
                ma.setGrupo_estadi_material(rs.getString("grupo_estadi_material"));
                ma.setGrupo_tipos_posi_ma_mate(rs.getString("grupo_tipos_posi_ma_mate"));
                ma.setJerarquia_produc(rs.getString("jerarquia_produc"));
                ma.setGrupo_precios_mate(rs.getString("grupo_precios_mate"));
                ma.setGrupo_imputa_material(rs.getString("grupo_imputa_material"));
                ma.setGrupo_tipo_posi_gen(rs.getString("grupo_tipo_posi_gen"));
                ma.setGrupo_veri_de_dispo(rs.getString("grupo_veri_de_dispo"));
                ma.setGrupo_transporte(rs.getString("grupo_transporte"));
                ma.setCentro_beneficio(rs.getString("centro_beneficio"));
                ma.setSujeto_lote(rs.getString("sujeto_lote"));
                ma.setDescripcion(rs.getString("descripcion_ES"));
                ma.setGrupo_carga(rs.getString("grupo_carga"));
                ma.setGrupo_compras(rs.getString("grupo_compras"));
                ma.setCara_plan_nece(rs.getString("cara_plan_nece"));
                ma.setPunto_pedido(rs.getString("punto_pedido"));
                ma.setCiclo_plan_nece(rs.getString("ciclo_plan_nece"));
                ma.setTam_lote_plan_nece(rs.getString("tam_lote_plan_nece"));
                ma.setTama_lote_min(rs.getString("tama_lote_min"));
                ma.setHoriz_plan_fijo(rs.getString("horiz_plan_fijo"));
                ma.setPlanificador_necesi(rs.getString("planificador_necesi"));
                ma.setTama_lote_max(rs.getString("tama_lote_max"));
                ma.setStock_maximo(rs.getString("stock_maximo"));
                ma.setClase_aprovisionamiento(rs.getString("clase_aprovisionamiento"));
                ma.setTiempo_trata_en_merca_dia(rs.getString("tiempo_trata_en_merca_dia"));
                ma.setStock_seguridad(rs.getString("stock_seguridad"));
                ma.setStock_seguridad_minimo(rs.getString("stock_seguridad_minimo"));
                ma.setClase_clase_aprov_espe(rs.getString("clase_aprovi_espe"));
                ma.setPlazo_entre_previ_dia(rs.getString("plazo_entre_previ_dia"));
                ma.setExiste_para_insp_mate_cen(rs.getString("existe_para_insp_mate_cen"));
                ma.setQm_activo_apro(rs.getString("qm_activo_apro"));
                ma.setIndicador_control_precios(rs.getString("indicador_control_precios"));
                ma.setPrecio_medio_vari_inte_per(rs.getString("precio_medio_vari_inte_per"));
                ma.setPrecio_estandar(rs.getString("precio_estandar"));
                ma.setCantidad_base(rs.getString("cantidad_base"));
                ma.setClase_valoracion(rs.getString("clase_valoracion"));
                ma.setCategoria_valoracion(rs.getString("categoria_valoracion"));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodoCargarDatosVisualMa (ACC_Material) por: " + e);
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
        return ma;
    }

    public ArrayList<materiales> ConsultarMaterialHRVis(String Mate, String desc, String DenIdioma, String Ctd) {
        ArrayList<materiales> mt = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String proc = "{CALL PP.MaterialesHR_ConsultarMate(?,?,?,?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, Mate);
            ps.setString(2, desc);
            ps.setString(3, DenIdioma);
            ps.setString(4, Ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                materiales m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString(DenIdioma));
                mt.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarMateMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mt;
    }
//    public ArrayList<equipos> ConsultarEquipoMCPP(String Mate, String Des, String DenIdioma, String Ctd) {
//        ArrayList<equipos> eq = new ArrayList<>();
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        String pr = "{CALL PP.MaterialesHR_ConsultarMate(?,?,?,?)}";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = con.prepareStatement(pr);
//            ps.setString(1, Mate);
//            ps.setString(2, Des);
//            ps.setString(3, DenIdioma);
//            ps.setString(4, Ctd);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                equipos e = new equipos();
//                e.setNum_equipo(rs.getString("num_equipo"));
//                e.setDescripcion_equipo(rs.getString(DenIdioma));
//                eq.add(e);
//            }
//        } catch (Exception e) {
//            System.out.println("Error en ConsultarEquipoMC por: " + e);
//        } finally {
//            cnx.CerrarConexion(con);
//        }
//        return eq;
//    }
}
