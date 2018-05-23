package AccesoDatos;

import Entidades.Lotes;
import Entidades.almacenes;
import Entidades.stock;
import Entidades.Almaceness;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.LinkedList;
import Entidades.Stock_Traslado;
import Entidades.tabla305;
import java.util.ArrayList;

public class ACC_Stock {
    
    private static ACC_Stock Instance = null;
    
    public static ACC_Stock ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Stock();
        }
        return Instance;
    }
    
    public ArrayList<stock> StockCargarMateriales(String lan, String mat, String des) {
        ArrayList<stock> inv = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.Inventario_CargarMateriales(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lan);
            ps.setString(2, mat);
            ps.setString(3, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setMaterial(rs.getString("material"));
                s.setDescripcion(rs.getString("descripcion_" + lan));
                inv.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en StrockCargarMateriales, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return inv;
    }
    
    public ArrayList<stock> StockCargarGArticulo(String lan, String gar, String des) {
        ArrayList<stock> inv = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.Inventario_CargarGrupoArticulo(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lan);
            ps.setString(2, gar);
            ps.setString(3, des);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setGrupoArticulos(rs.getString("grupo_articulo"));
                s.setDescripcion(rs.getString("denominacion_" + lan));
                inv.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en StockCargarGArticulo, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return inv;
    }
    
    public ArrayList<stock> StockCargarAlmacen(String lan) {
        ArrayList<stock> inv = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.Inventario_CargarAlmacen(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lan);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setAlmacen(rs.getString("id_almacen"));
                s.setDescripcion(rs.getString("descripcion_" + lan));
                inv.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en StockCargarAlmacen, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return inv;
    }
    
    public ArrayList<stock> StockCargarCentro() {
        ArrayList<stock> inv = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.Inventario_CargarCentro()}";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setCentro(rs.getString("centro"));
                s.setDescripcion(rs.getString("descripcion"));
                inv.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en StockCargarCentro, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return inv;
    }
    
    public ArrayList<stock> StockCargarLote(String lan) {
        ArrayList<stock> inv = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.Inventarios_Inventario_CargarLote(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lan);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setLote(rs.getString("lote"));
                s.setAlmacen(rs.getString("almacen"));
                s.setMaterial(rs.getString("material"));
                s.setDescripcion(rs.getString("descripcion_" + lan));
                s.setCentro(rs.getString("centro"));
                inv.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en StockCargarLote, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return inv;
    }
    
    public int StockValidarMaterial(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call MM.Inventario_ValidarMaterial(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en StockValidarMaterial, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    public int StockValidarGArticulo(String gar) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call MM.Inventario_ValidarGArticulo(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, gar);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en StockValidarGArticulo, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    public int StockValidarAlmacen(String a) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call MM.Inventario_ValidarAlmacen(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en Inventario_ValidarAlmacen, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    public int StockValidarCentro(String c) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call MM.Inventario_ValidarCentro(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en StockValidarCentro, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    public int StockValidarLote(String l) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call MM.Inventario_ValidarLote(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, l);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en StockValidarLote, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    public int StockValidarQueryTodo(String d[]) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call MM.Inventarios_ConsultaTodo(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en StockValidarQueryTodo, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    public int StockValidarQuerySuma(String d[]) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call MM.Inventarios_ConsultaSumatoria(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en StockValidarQuerySuma, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    public int StockValidarQueryTraslado(String d[]) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call MM.Inventarios_ConsultaTraslado(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.out.println("Error en StockValidarQueryTraslado, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    public ArrayList<stock> StockCargarQueryTodo(String d[]) {
        ArrayList<stock> st = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.Inventarios_ConsultaTodo(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setMaterial(rs.getString("material"));
                s.setDescripcion(rs.getString("descripcion_" + d[0]));
                s.setAlmacen(rs.getString("almacen"));
                s.setCentro(rs.getString("centro"));
                s.setLote(rs.getString("lote"));
                s.setUnidad_medida(rs.getString("unidad_medida"));
                s.setGrupoArticulos(rs.getString("grupo_articulos"));
                s.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                s.setStock_traslado(rs.getString("stock_traslado"));
                st.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en StockValidarQueryTodo, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return st;
    }
    
    public ArrayList<stock> StockCargarQuerySuma(String d[]) {
        ArrayList<stock> st = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.Inventarios_ConsultaSumatoria(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setMaterial(rs.getString("material"));
                s.setDescripcion(rs.getString("descripcion_" + d[0]));
                s.setAlmacen(rs.getString("almacen"));
                s.setCentro(rs.getString("centro"));
                s.setUnidad_medida(rs.getString("unidad_medida"));
                s.setGrupoArticulos(rs.getString("grupo_articulos"));
                s.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                st.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en StockCargarQuerySuma, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return st;
    }
    
    public ArrayList<stock> StockCargarQueryTraslado(String d[]) {
        ArrayList<stock> st = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{call MM.Inventarios_ConsultaTraslado(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, d[0]);
            ps.setString(2, d[1]);
            ps.setString(3, d[2]);
            ps.setString(4, d[3]);
            ps.setString(5, d[4]);
            ps.setString(6, d[5]);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setMaterial(rs.getString("material"));
                s.setDescripcion(rs.getString("descripcion_" + d[0]));
                s.setAlmacen(rs.getString("almacen"));
                s.setCentro(rs.getString("centro"));
                s.setLote(rs.getString("lote"));
                s.setUnidad_medida(rs.getString("unidad_medida"));
                s.setGrupoArticulos(rs.getString("grupo_articulos"));
                s.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                s.setStock_traslado(rs.getString("stock_traslado"));
                st.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en StockCargarQueryTraslado, ACC_Stock por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return st;
    }
    
    public String ValidarSujLotByMat(String mat, String lot) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_ValidarSujLote(?, ?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, lot);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarSujLotByMat" + e);
        }
        return check;
    }
    
    public String ValidarStockLibre(String mat, String alm, String lot, String ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL MM.Movimientos_ValidarStockLibre(?, ?, ?, ?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, alm);
            ps.setString(3, lot);
            ps.setString(4, ctd);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarSujLotByMat" + e);
        }
        return check;
    }
    
    public ArrayList<stock> ConsultaLoteByMat(String mat) {
        String query = "{call MM.Movimientos_LoteByMate(?)}";
        ArrayList<stock> stockmateriales = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                stock stockmat = new stock();
                stockmat.setMaterial(rs.getString("material"));
                stockmat.setCentro(rs.getString("centro"));
                stockmat.setAlmacen(rs.getString("almacen"));
                stockmat.setLote(rs.getString("lote"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                
                stockmateriales.add(stockmat);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return stockmateriales;
    }
    
    static String Num(String data) {
        String nf = "";
        if (data.indexOf(".") != -1) {
            String[] n = data.split("\\.");
            String n1 = n[0];
            String n2 = n[1];
            
            if (n2.length() == 1) {
                n2 = n2 + "00";
                nf = n1 + "." + n2;
            } else if (n2.length() == 2) {
                n2 = n2 + "0";
                nf = n1 + "." + n2;
            } else {
                return data;
            }
        } else {
            nf = data += ".000";
        }
        
        return nf;
    }
    
    public static void main(String[] args) {
        ACC_Stock s = new ACC_Stock();
        System.out.println(s.Num("1.900"));
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

    //Validaciones Stock Material Filtros
    public boolean ValidarMATR(String mtrl) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ValMat(?)}");
            pst.setString(1, mtrl);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_Materiales por: " + e);
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
    
    public boolean ValidarTPM(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
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
            System.err.println("Error en ValidarOCompras ACC_TPM por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }
    
    public boolean ValidarGRA(String gart) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ValGArt(?)}");
            pst.setString(1, gart);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_Materiales por: " + e);
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
    
    public boolean ValidarTXT(String txtSM, String no_campoTxt) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ValTxt(?,?)}");
            pst.setString(1, txtSM);
            pst.setString(2, no_campoTxt);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_Materiales por: " + e);
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
    
    public boolean ValidarALM(String almace) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ValAlm(?)}");
            pst.setString(1, almace);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_Materiales por: " + e);
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
    
    public boolean ValidarCEN(String cnt) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ValCentro(?)}");
            pst.setString(1, cnt);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_Materiales por: " + e);
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
    
    public boolean ValidarLOT(String lott) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ValLot(?)}");
            pst.setString(1, lott);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_Materiales por: " + e);
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
    //Metodo prueba trae todo vacio sumatoria

    public ArrayList<stock> ConsultaStockMaTodosSumVa(String val, String vl, String no_campo, String limite, String like, String cant) {
        ArrayList<stock> stVacioSuma = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ConsVacia(?,?,?,?,?,?)}");
            pst.setString(1, val);
            pst.setString(2, vl);
            pst.setString(3, limite);
            pst.setString(4, no_campo);
            pst.setString(5, like);
            pst.setString(6, cant);
            rs = pst.executeQuery();
            while (rs.next()) {
                stock st = new stock();
                st.setMaterial(rs.getString("material"));
                st.setDescripcion(rs.getString(no_campo));
                st.setAlmacen(rs.getString("almacen"));
                st.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                stVacioSuma.add(st);
                
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
        return stVacioSuma;
    }

    //Metodo trae todo de stock
    public ArrayList<stock> ConsultaStockMaterialess(String val, String vl, String no_campo, String limite, String like, String cant) {
        ArrayList<stock> stVacio = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ConsVacia(?,?,?,?,?,?)}");
            pst.setString(1, val);
            pst.setString(2, vl);
            pst.setString(3, limite);
            pst.setString(4, no_campo);
            pst.setString(5, like);
            pst.setString(6, cant);
            rs = pst.executeQuery();
            while (rs.next()) {
                stock st = new stock();
                st.setCentro(rs.getString("centro"));
                st.setAlmacen(rs.getString("almacen"));
                st.setGrupoArticulos(rs.getString("grupo_articulos"));
                st.setLote(rs.getString("lote"));
                st.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                st.setCentro(rs.getString("centro"));
                st.setUnidad_medida(rs.getString("unidad_medida"));
                st.setStock_traslado(rs.getString("stock_traslado"));
                st.setMaterial(rs.getString("material"));
                st.setDescripcion(rs.getString(no_campo));
                stVacio.add(st);
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
        return stVacio;
    }
    //Metodo Trae Sumatoria De Stock Lib Utilizacion por Material y Almacen con filtros

    public ArrayList<stock> ConsultaStockMaTodosSum(String material, String grupoarticulos, String textomaterial, String almacen, String centro, String numerolote, String val, String vl, String no_campoSum, String limite, String lik, String cantid) {
        ArrayList<stock> stSum = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ConsSuma(?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, material);
            pst.setString(2, grupoarticulos);
            pst.setString(3, textomaterial);
            pst.setString(4, almacen);
            pst.setString(5, centro);
            pst.setString(6, numerolote);
            pst.setString(7, val);
            pst.setString(8, vl);
            pst.setString(9, no_campoSum);
            pst.setString(10, limite);
            pst.setString(11, lik);
            pst.setString(12, cantid);
            rs = pst.executeQuery();
            while (rs.next()) {
                stock st = new stock();
                st.setMaterial(rs.getString("material"));
                st.setDescripcion(rs.getString(no_campoSum));
                st.setAlmacen(rs.getString("almacen"));
                st.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                stSum.add(st);
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
        return stSum;
    }
    
    public ArrayList<stock> ConsultaStockMaTodos(String material, String grupoarticulos, String textomaterial, String almacen, String centro, String numerolote, String val, String vl, String no_campoT, String limite, String likeT, String cantT) {
        ArrayList<stock> stTodos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ConsTodos(?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, material);
            pst.setString(2, grupoarticulos);
            pst.setString(3, textomaterial);
            pst.setString(4, almacen);
            pst.setString(5, centro);
            pst.setString(6, numerolote);
            pst.setString(7, val);
            pst.setString(8, vl);
            pst.setString(9, no_campoT);
            pst.setString(10, limite);
            pst.setString(11, likeT);
            pst.setString(12, cantT);
            rs = pst.executeQuery();
            while (rs.next()) {
                stock st = new stock();
                st.setCentro(rs.getString("centro"));
                st.setAlmacen(rs.getString("almacen"));
                st.setGrupoArticulos(rs.getString("grupo_articulos"));
                st.setLote(rs.getString("lote"));
                st.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                st.setCentro(rs.getString("centro"));
                st.setUnidad_medida(rs.getString("unidad_medida"));
                st.setStock_traslado(rs.getString("stock_traslado"));
                st.setMaterial(rs.getString("material"));
                st.setDescripcion(rs.getString(no_campoT));
                stTodos.add(st);
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
        return stTodos;
    }
    
    public boolean ValidarPRO(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
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
            System.err.println("Error en ValidarPRO ACC_Stock por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }
    
    public boolean ValidarTP(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
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
            System.err.println("Error en ValidarTP ACC_Stock por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }
    
    public LinkedList<Lotes> ConsultaLoteStock(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<Lotes> cen = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Lotes c = new Lotes();
                c.setMaterial(rs.getString("material"));
                c.setDescripcion(rs.getString("descripcion_ES"));
                c.setCantidad(rs.getString("stocklibre_utilizacion"));
                c.setCentro(rs.getString("centro"));
                c.setAlmacen(rs.getString("almacen"));
                c.setLote(rs.getString("lote"));
                cen.add(c);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en Consulta Centros Coste por: " + e);
        }
        return cen;
    }

    //Metodo trae todo de stock
    public LinkedList<stock> ConsultaStockMateriales(String query) {
        LinkedList<stock> stockmateriales = new LinkedList<stock>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                stock stockmat = new stock();
                stockmat.setId_inven(rs.getInt("id_inven"));
                stockmat.setMaterial(rs.getString("material"));
                stockmat.setDescripcion_ES(rs.getString("descripcion_ES"));
                stockmat.setDescripcion_EN(rs.getString("descripcion_EN"));
                stockmat.setCentro(rs.getString("centro"));
                stockmat.setUnidad_medida(rs.getString("unidad_medida"));
                stockmat.setAlmacen(rs.getString("almacen"));
                stockmat.setDescripcion_almacen(rs.getString("descripcion_almacen"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                stockmat.setStockcontrol_calidad(rs.getString("stockcontrol_calidad"));
                stockmat.setStock_bloqueado(rs.getString("stock_bloqueado"));
                stockmat.setStock_traslado(rs.getString("stock_traslado"));
                stockmat.setLote(rs.getString("lote"));
                stockmat.setTipo_material(rs.getString("tipo_material"));
                stockmat.setGrupoArticulos(rs.getString("grupo_articulos"));
                stockmat.setSerie(rs.getString("serie"));
                stockmat.setIndicador_lote(rs.getString("indicador_lote"));
                stockmateriales.add(stockmat);
                
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return stockmateriales;
    }
    
    public stock ConsultarMateNotifi(String query) {
        stock in = new stock();
        Conexion con = new Conexion();
        try {
            Statement st;
            ResultSet rs;
            Connection conn = con.ObtenerConexion();
            
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                in.setLote(rs.getString("lote"));
                in.setId_inven(rs.getInt("id_inven"));
                in.setMaterial(rs.getString("material"));
                in.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                in.setUnidad_medida(rs.getString("unidad_medida"));
                in.setDescripcion_ES(rs.getString("descripcion_ES"));
                in.setCentro(rs.getString("centro"));
            }
            con.CerrarConexion(conn);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        
        return in;
    }
    
    public int ConsultaLote(String mat, String cantidad, String centro, String almacen, String lote) {
        double cnt = 0.000;
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        query = "{call MM.consultaLote_MOM(?,?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            sp.setString(2, centro);
            sp.setString(3, almacen);
            sp.setString(4, lote);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                cnt = Double.parseDouble(rs.getString("stocklibre_utilizacion"));
            }
            double cc = Double.parseDouble(cantidad);
            if (cc > cnt) {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 1;
    }
    
    public int ConsultaLote2(String mat, String centro, String almacen) {
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        query = "{call MM.consultaMaterialAlmacen_MOM(?,?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            sp.setString(2, centro);
            sp.setString(3, almacen);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                return 1;
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }
    
    public int ConsultaCntST(String mat, String cantidad, String centro) {
        double rt = 0.000, cnt = 0.000;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        
        String query = "{call MM.stock_transferecia_cnt_MOM(?,?)}";
        
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            sp.setString(2, centro);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                cnt = Double.parseDouble(rs.getString("stock_traslado"));
                rt = 1;
            }
            double cc = Double.parseDouble(cantidad);
            if (cc > cnt) {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            rt = 0;
        } finally {
            cnx.CerrarConexion(con);
        }
        return 1;
    }
    
    public int ConsultaUM(String mat, String um) {
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        query = "{call MM.consultaUM_MOM(?,?)}";
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            sp.setString(2, um);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                return 1;
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return 0;
    }
    
    public LinkedList<stock> ConsultaInventarios() {
        String query = "";
        LinkedList<stock> stockmateriales = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            query = "select material, centro, almacen, lote, stocklibre_utilizacion from inventarios order by material";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                stock stockmat = new stock();
                try {
                    stockmat.setMaterial(Integer.parseInt(rs.getString("material")) + "");
                } catch (Exception e) {
                    stockmat.setMaterial(rs.getString("material"));
                }
                
                stockmat.setCentro(rs.getString("centro"));
                stockmat.setAlmacen(rs.getString("almacen"));
                stockmat.setLote(rs.getString("lote"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                
                stockmateriales.add(stockmat);
                
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return stockmateriales;
    }

//    public void ActualizaInventario(String mat, String ctr, String cnd, String lote) {
//        String query;
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        ResultSet rs;
//        int rr = 0, rm, sl = 0;
//        try {
//            query = "select * from inventarios where material='" + mat + "' and centro = '" + ctr + "' and lote ='" + lote + "'";
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//            while (rs.next()) {
//                rr++;
//                sl = rs.getInt("stocklibre_utilizacion");
//            }
//        } catch (Exception ex) {
//            System.err.println("Error: " + ex);
//        }
//        if (rr > 0) {
//            Double val = Double.parseDouble(cnd);
//            rm = sl + val.intValue();
//            try {
//                query = "update inventarios set stocklibre_utilizacion = '" + rm + "', ultimo_stocklibre = '" + rm + "' where material='" + mat + "' and centro = '" + ctr + "' and lote ='" + lote + "'";
//                st = con.createStatement();
//                st.executeUpdate(query);
//            } catch (Exception ex) {
//                System.err.println("Error: " + ex);
//            }
//        } else {
//            stock sk = new stock();
//            try {
//                query = "select top 1 * from inventarios where material='" + mat + "'";
//                st = con.createStatement();
//                rs = st.executeQuery(query);
//                while (rs.next()) {
//                    sk.setMaterial(rs.getString("material"));
//                    sk.setDescripcion_ES(rs.getString("descripcion_ES"));
//                    sk.setDescripcion_EN(rs.getString("descripcion_EN"));
//                    sk.setUnidad_medida(rs.getString("unidad_medida"));
//                    sk.setAlmacen(rs.getString("almacen"));
//                    sk.setDescripcion_almacen(rs.getString("descripcion_almacen"));
//                    sk.setStocklibre_utilizacion(rs.getInt("stocklibre_utilizacion"));
//                    sk.setTipo_material(rs.getString("tipo_material"));
//                    sk.setGrupoArticulos(rs.getString("grupo_articulos"));
//                }
//            } catch (Exception ex) {
//                System.err.println("Error: " + ex);
//            }
//            Double vl = Double.parseDouble(cnd);
//            try {
//                query = "insert into inventarios values ('" + sk.getMaterial() + "',"
//                        + "'" + sk.getDescripcion_ES() + "', '" + sk.getDescripcion_EN() + "',"
//                        + "'" + ctr + "', '" + sk.getUnidad_medida() + "', "
//                        + "'" + sk.getAlmacen() + "', '" + sk.getDescripcion_almacen() + "', "
//                        + "'" + vl.intValue() + "', '0','0','0',"
//                        + "'" + lote + "', '','','','', '" + vl.intValue() + "')";
//                st = con.createStatement();
//                st.executeUpdate(query);
//            } catch (Exception ex) {
//                System.err.println("Error: " + ex);
//            }
//        }
//        cnx.CerrarConexion(con);
//    }
    public int VerificarExistentes(String[][] tabla, int tam) {
        int rr = 0, rtn = 1;
        Double rm;
        Double sl = 0.00;
        String stock = "";
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String n2 = "";
        String sql = "{CALL MM.Movimientos_VarificarExistentesStock(?,?,?,?)}";
        for (int f = 0; f < tam; f++) {
            n2 = tabla[f][5];
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, n2);
                ps.setString(2, tabla[f][10]);
                ps.setString(3, tabla[f][2]);
                ps.setString(4, tabla[f][11]);
                rs = ps.executeQuery();
                while (rs.next()) {
                    rr++;
                    stock = rs.getString("stocklibre_utilizacion");
                    sl = Double.parseDouble(stock);
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        if (rr == tam) {
            for (int f = 0; f < tam; f++) {
                try {
                    n2 = tabla[f][5];
                    String sql2 = "{CALL MM.Movimientos_VarificarExistentesStock2(?,?,?,?)}";
                    ps = con.prepareStatement(sql2);
                    ps.setString(1, n2);
                    ps.setString(2, tabla[f][10]);
                    ps.setString(3, tabla[f][2]);
                    ps.setString(4, tabla[f][11]);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        rr++;
                        stock = rs.getString("ultimo_stocklibre");
                        sl = Double.parseDouble(stock);
                    }
                } catch (Exception ex) {
                    System.err.println("Error: " + ex);
                }
                Double val = Double.parseDouble(tabla[f][3]);
                rm = sl - val;
                if (rm >= 0) {
                    try {
                        if (tabla[f][9].equals("V")) {
                            String sql3 = "{CALL MM.Movimientos_actualizarStockultimostock(?,?,?,?,?)}";
                            ps = con.prepareStatement(sql3);
                            ps.setString(1, Num(String.valueOf(rm)));
                            ps.setString(2, n2);
                            ps.setString(3, tabla[f][10]);
                            ps.setString(4, tabla[f][2]);
                            ps.setString(5, tabla[f][11]);
                            ps.executeUpdate();
                        }
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                    rtn = 2;
                } else {
                    return 1;
                }
            }
        } else {
            rtn = 1;
        }
        cnx.CerrarConexion(con);
        return rtn;
    }
    
    public int VerificarExistentesN(String[][] tabla, int tam)//NuevoLalo
    {
        int rr = 0, rtn = 1;
        double ls = 0.000, rm, sl = 0.00;
        String SP;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        PreparedStatement ps;
        String n2 = "";
        for (int f = 0; f < tam; f++) {
            try {
                int mm = Integer.parseInt(tabla[f][2]);
                n2 = "";
//                for (int i = tabla[f][2].length(); i < 18; i++) {
//                    n2 += "0";
//                }
                n2 += mm;
            } catch (Exception e) {
                n2 = tabla[f][2];
            }
            try {
                SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, n2);
                ps.setString(2, tabla[f][3]);
                ps.setString(3, tabla[f][0]);
                ps.setString(4, tabla[f][4]);
                rs = ps.executeQuery();
                while (rs.next()) {
                    rr++;
                    sl = rs.getDouble("stocklibre_utilizacion");
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        if (rr == tam) {
            for (int f = 0; f < tam; f++) {
                try {
                    int mm = Integer.parseInt(tabla[f][2]);
                    n2 = "";
//                    for (int i = tabla[f][2].length(); i < 18; i++) {
//                        n2 += "0";
//                    }
                    n2 += mm;
                } catch (Exception e) {
                    n2 = tabla[f][2];
                }
                try {
                    SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
                    ps = con.prepareStatement(SP);
                    ps.setString(1, n2);
                    ps.setString(2, tabla[f][3]);
                    ps.setString(3, tabla[f][0]);
                    ps.setString(4, tabla[f][4]);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        rr++;
                        ls = Double.parseDouble(rs.getString("ultimo_stocklibre"));
                    }
                } catch (Exception ex) {
                    System.err.println("Error: " + ex);
                }
                Double val = Double.parseDouble(tabla[f][1]);
                rm = ls - val;
                DecimalFormat df = new DecimalFormat("#.##");
                String fmt = df.format(rm);
                if (rm >= 0) {
                    try {
                        SP = "{CALL MM.Movimientos_VerificarExistentesNUpdateUltimoStock(?, ?, ?, ?, ?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, Num(String.valueOf(fmt)));
                        ps.setString(2, n2);
                        ps.setString(3, tabla[f][3]);
                        ps.setString(4, tabla[f][0]);
                        ps.setString(5, tabla[f][4]);
                        ps.executeUpdate();
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                    rtn = 2;
                } else {
                    return 1;
                }
            }
        } else {
            rtn = 1;
        }
        cnx.CerrarConexion(con);
        return rtn;
    }
    
    public void UpdateMovimiento201UltimoStock(String ultStock, String mate, String centro, String lote, String alm) {
        String SP;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_VerificarExistentesNUpdateUltimoStock(?, ?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, ultStock);
            ps.setString(2, mate);
            ps.setString(3, centro);
            ps.setString(4, lote);
            ps.setString(5, alm);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        
        cnx.CerrarConexion(con);
    }
    
    public void UpdateMovimiento261Stock(String ultStock, String mate, String centro, String lote, String alm) {
        String SP;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.MovimientoUpdateStock(?, ?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, ultStock);
            ps.setString(2, mate);
            ps.setString(3, centro);
            ps.setString(4, lote);
            ps.setString(5, alm);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        
        cnx.CerrarConexion(con);
    }
    
    public void UpdateInventarioUltCentroD(String ultCentD, String mate, String centro, String lote, String alm) {
        String SP;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_InventarioUpdateUltCentroD(?, ?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, ultCentD);
            ps.setString(2, mate);
            ps.setString(3, centro);
            ps.setString(4, lote);
            ps.setString(5, alm);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        
        cnx.CerrarConexion(con);
    }
    
    public void UpdateMovimiento201StockLibre(String stockL, String mate, String centro, String lote, String alm) {
        String SP;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_VerificarExistentesNUpdateStockLibre(?, ?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, stockL);
            ps.setString(2, mate);
            ps.setString(3, centro);
            ps.setString(4, lote);
            ps.setString(5, alm);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    
    public void UpdateMovimiento305UltimoStock(String ultSt, String mate, String centro) {
        String SP;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_UpdateStockTransUltimoStock(?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, ultSt);
            ps.setString(2, mate);
            ps.setString(3, centro);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    
    public void UpdateInventarioCtdCentroD(String ctd, String mate, String centro, String lote, String almacen) {
        String SP;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_InventarioUpdateCtdCentD(?, ?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, ctd);
            ps.setString(2, mate);
            ps.setString(3, centro);
            ps.setString(4, lote);
            ps.setString(5, almacen);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    
    public void UpdateMovimiento305StockTraslado(String StoTras, String mate, String centro) {
        String SP;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_UpdateStockTransStockTranslado(?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, StoTras);
            ps.setString(2, mate);
            ps.setString(3, centro);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    
    public int VerificarExistentesNT(String[][] tabla, int tam)//NuevoLalo
    {
        int rr = 0, rtn = 1;
        double ls = 0.000, rm;
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String n2;
        PreparedStatement ps;
        String SP;
        for (int f = 0; f < tam; f++) {
            try {
                int mm = Integer.parseInt(tabla[f][2]);
                n2 = "";
                n2 += mm;
            } catch (Exception e) {
                n2 = tabla[f][2];
            }
            try {
                SP = "{CALL MM.Movimientos_VerificarExistentesNT(?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, n2);
                ps.setString(2, tabla[f][3]);
                rs = ps.executeQuery();
                while (rs.next()) {
                    rr++;
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        if (rr == tam) {
            for (int f = 0; f < tam; f++) {
                try {
                    int mm = Integer.parseInt(tabla[f][2]);
                    n2 = "";
                    n2 += mm;
                } catch (Exception e) {
                    n2 = tabla[f][2];
                }
                try {
                    SP = "{CALL MM.Movimientos_VerificarExistentesNT(?, ?)}";
                    ps = con.prepareStatement(SP);
                    ps.setString(1, n2);
                    ps.setString(2, tabla[f][3]);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        rr++;
                        ls = Double.parseDouble(rs.getString("ultimo_stock"));
                    }
                } catch (Exception ex) {
                    System.err.println("Error: " + ex);
                }
                Double val = Double.parseDouble(tabla[f][1]);
                rm = ls - val;
                DecimalFormat df = new DecimalFormat("#.##");
                String fmt = df.format(rm);
                if (rm >= 0) {
                    try {
                        SP = "{CALL MM.Movimientos_UpdateStockTransUltimoStock(?, ?, ?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, Num(String.valueOf(fmt)));
                        ps.setString(2, n2);
                        ps.setString(3, tabla[f][3]);
                        ps.executeUpdate();
                        
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                    rtn = 2;
                } else {
                    return 1;
                }
            }
        } else {
            rtn = 1;
        }
        cnx.CerrarConexion(con);
        return rtn;
    }

//    public Double UltimoLU(String mat, String ctr, String lote) {
//        String query;
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        Statement st;
//        ResultSet rs;
//        Double sl = 0.000;
//        try {
//            query = "select * from inventarios where material='" + mat + "' and centro = '" + ctr + "' and lote ='" + lote + "'";
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//            while (rs.next()) {
//                sl = rs.getDouble("stocklibre_utilizacion");
//            }
//        } catch (Exception ex) {
//            System.err.println("Error: " + ex);
//        }
//        cnx.CerrarConexion(con);
//        return sl.intValue();
//    }
    public int ConsultaLote202(String mat, String centro, String almacen, String lote) {
        int rt = 0;
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
//        try {
//            String n = "";
//            int mm = Integer.parseInt(mat);
//            n += mm;
//            if (mat.length() == 18) {
//                query = "select * from inventarios where material = '" + mat + "' and centro = '" + centro + "' and almacen = '" + almacen + "' and lote = '" + lote + "'";
//            } else {
//                query = "select * from inventarios where material = '" + n + "' and centro = '" + centro + "' and almacen = '" + almacen + "' and lote = '" + lote + "'";
//            }
//        } catch (Exception e) {
        query = "select * from inventarios where material = '" + mat + "' and centro = '" + centro + "' and almacen = '" + almacen + "' and lote = '" + lote + "'";
//        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                rt = 1;
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            rt = 0;
        }
        return rt;
    }
    
    public stock CargarDataInventario(String num) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        stock stockmat = new stock();
        String query = "SELECT * FROM inventarios WHERE material='" + num + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                stockmat.setId_inven(rs.getInt("id_inven"));
                stockmat.setMaterial(rs.getString("material"));
                stockmat.setDescripcion_ES(rs.getString("descripcion_ES"));
                stockmat.setDescripcion_EN(rs.getString("descripcion_EN"));
                stockmat.setCentro(rs.getString("centro"));
                stockmat.setUnidad_medida(rs.getString("unidad_medida"));
                stockmat.setAlmacen(rs.getString("almacen"));
                stockmat.setDescripcion_almacen(rs.getString("descripcion_almacen"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                stockmat.setStockcontrol_calidad(rs.getString("stockcontrol_calidad"));
                stockmat.setStock_bloqueado(rs.getString("stock_bloqueado"));
                stockmat.setStock_traslado(rs.getString("stock_traslado"));
                stockmat.setLote(rs.getString("lote"));
                stockmat.setTipo_material(rs.getString("tipo_material"));
                stockmat.setGrupoArticulos(rs.getString("grupo_articulos"));
                stockmat.setSerie(rs.getString("serie"));
                stockmat.setIndicador_lote(rs.getString("indicador_lote"));
            }
            
        } catch (Exception e) {
            System.err.println("Error en metodobCargarDatosVisual ACC_Usuarios por " + e);
        }
        cnx.CerrarConexion(con);
        return stockmat;
    }
    
    public int ValidarMatInventario(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT material FROM inventarios WHERE material='" + mat + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String m = rs.getString("material");
                if (m.equals(mat)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarClaseOrden (ACC_ClaseOrden) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
    
    public int ValidarLotInventario(String lot) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT lote FROM inventarios WHERE lote='" + lot + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String l = rs.getString("lote");
                if (l.equals(lot)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarClaseOrden (ACC_ClaseOrden) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
    
    public LinkedList<stock> ConsultaStockLotes(String query) {
        LinkedList<stock> stockmateriales = new LinkedList<stock>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                stock stockmat = new stock();
                stockmat.setLote(rs.getString("lote"));
                stockmateriales.add(stockmat);
                
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return stockmateriales;
    }
    
    public Double UltimoLU(String mat, String ctr, String lote, String almacen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        Double sl = 0.00;
        String SP;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, ctr);
            ps.setString(3, lote);
            ps.setString(4, almacen);
            rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getDouble("stocklibre_utilizacion");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return sl;
    }
    
    public Double UltimoST(String mat, String ctr) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        Double sl = 0.00;
        PreparedStatement ps;
        String SP;
        try {
            SP = "{CALL MM.Movimientos_VerificarExistentesNT(?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, ctr);
            rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getDouble("ultimo_stock");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return sl;
    }
    
    public Double LbreST(String mat, String ctr) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        Double sl = 0.00;
        PreparedStatement ps;
        String SP;
        try {
            SP = "{CALL MM.Movimientos_VerificarExistentesNT(?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, ctr);
            rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getDouble("stock_traslado");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return sl;
    }
    
    public Double LibreLU(String mat, String ctr, String lote, String almacen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        Double sl = 0.00;
        String SP;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, ctr);
            ps.setString(3, lote);
            ps.setString(4, almacen);
            rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getDouble("ultimo_stocklibre");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return sl;
    }
    
    public int VerificarExistentes300N(String[][] tabla, int tam)//NuevoLalo
    {
        int rtn = 1;
        double sl = 0.000, rm, cd = 0.000, rr;
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String n2;
        PreparedStatement ps;
        String SP;
        
        for (int f = 0; f < tam; f++) {
            try {
                int mm = Integer.parseInt(tabla[f][2]);
                n2 = "";
//                for(int i =  tabla[f][2].length(); i < 18; i++){ n2+="0"; }
                n2 += mm;
            } catch (Exception e) {
                n2 = tabla[f][2];
            }
            try {
                SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, n2);
                ps.setString(2, tabla[f][3]);
                ps.setString(3, tabla[f][0]);
                ps.setString(4, tabla[f][4]);
                rs = ps.executeQuery();
                while (rs.next()) {
                    sl = Double.parseDouble(rs.getString("ultimo_stocklibre"));
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
//            try {
//                query = "select * from inventarios where material='" + n2 + "' and centro = '" + tabla[f][5] + "' and lote ='" + tabla[f][0] + "' and almacen = '" + tabla[f][4] + "'";
//                st = con.createStatement();
//                rs = st.executeQuery(query);
//                while (rs.next()) {
//                    cd = Double.parseDouble(rs.getString("ultimo_transito"));
//                }
//            } catch (Exception ex) {
//                System.err.println("Error: " + ex);
//            }
            Double val = Double.parseDouble(tabla[f][1]);//[1] Cantidad
            DecimalFormat df = new DecimalFormat("#.##");
            rm = sl - val;
//            rr = cd + val;
            String fmt = df.format(rm);
//            String fmr = df.format(rr);
            if (rm >= 0) {
                try {
                    SP = "{CALL MM.Movimientos_VerificarExistentesNUpdateUltimoStock(?, ?, ?, ?, ?)}";
                    ps = con.prepareStatement(SP);
                    ps.setString(1, Num(String.valueOf(fmt)));
                    ps.setString(2, n2);
                    ps.setString(3, tabla[f][3]);
                    ps.setString(4, tabla[f][0]);
                    ps.setString(5, tabla[f][4]);
                    ps.executeUpdate();
                } catch (Exception ex) {
                    System.err.println("Error: " + ex);
                }
//                try {
//                    query = "update inventarios set ultimo_transito = '" + Num(String.valueOf(fmr)) + "' where material='" + n2 + "' and centro = '" + tabla[f][5] + "' and lote ='" + tabla[f][0] + "' and almacen = '" + tabla[f][4] + "'";
//                    st = con.createStatement();
//                    st.executeUpdate(query);
//                } catch (Exception ex) {
//                    System.err.println("Error: " + ex);
//                }
                rtn = 2;
            } else {
                cnx.CerrarConexion(con);
                return 1;
            }
        }
        cnx.CerrarConexion(con);
        return rtn;
    }
    
    public Double UltimoLUC(String mat, String ctr, String lote, String almacen) {
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        Double sl = 0.00;
        try {
            query = "select * from inventarios where material='" + mat + "' and centro = '" + ctr + "' and lote ='" + lote + "' and almacen = '" + almacen + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                sl = rs.getDouble("stock_traslado");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return sl;
    }
    
    public Double LibreLUC(String mat, String ctr, String lote, String almacen) {
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        Double sl = 0.00;
        try {
            query = "select * from inventarios where material='" + mat + "' and centro = '" + ctr + "' and lote ='" + lote + "' and almacen = '" + almacen + "'";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                sl = rs.getDouble("ultimo_transito");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return sl;
    }
    
    public int VerificarExistentes300NC(String[][] tabla, int tam)//NuevoLalo
    {
        int rtn = 1;
        double sl = 0.000, cd = 0.000, rm, rr;
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String n2;
        
        for (int f = 0; f < tam; f++) {
            try {
                int mm = Integer.parseInt(tabla[f][2]);
                n2 = "";
//                for (int i = tabla[f][2].length(); i < 18; i++) {
//                    n2 += "0";
//                }
                n2 += mm;
            } catch (Exception e) {
                n2 = tabla[f][2];
            }
            try {
                query = "select * from inventarios where material='" + n2 + "' and centro = '" + tabla[f][3] + "' and lote ='" + tabla[f][0] + "' and almacen = '" + tabla[f][4] + "'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                while (rs.next()) {
                    sl = Double.parseDouble(rs.getString("ultimo_transito"));
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
            try {
                query = "select * from inventarios where material='" + n2 + "' and centro = '" + tabla[f][3] + "' and lote ='" + tabla[f][0] + "' and almacen = '" + tabla[f][4] + "'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                while (rs.next()) {
                    cd = Double.parseDouble(rs.getString("ultimo_stocklibre"));
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
            Double val = Double.parseDouble(tabla[f][1]);//[1] Cantidad
            DecimalFormat df = new DecimalFormat("#.##");
            rm = sl - val;
            rr = cd + val;
            String fmt = df.format(rm);
            String fmr = df.format(rr);
            if (rm >= 0) {
                try {
                    query = "update inventarios set ultimo_transito = '" + Num(String.valueOf(fmt)) + "' where material='" + n2 + "' and centro = '" + tabla[f][3] + "' and lote ='" + tabla[f][0] + "' and almacen = '" + tabla[f][4] + "'";
                    st = con.createStatement();
                    st.executeUpdate(query);
                } catch (Exception ex) {
                    System.err.println("Error: " + ex);
                }
                try {
                    query = "update inventarios set ultimo_stocklibre = '" + Num(String.valueOf(fmr)) + "' where material='" + n2 + "' and centro = '" + tabla[f][3] + "' and lote ='" + tabla[f][0] + "' and almacen = '" + tabla[f][4] + "'";
                    st = con.createStatement();
                    st.executeUpdate(query);
                } catch (Exception ex) {
                    System.err.println("Error: " + ex);
                }
                rtn = 2;
            } else {
                cnx.CerrarConexion(con);
                return 1;
            }
        }
        cnx.CerrarConexion(con);
        return rtn;
    }
    
    public int VerificarExistentes300(String[][] tabla, int tam)//NuevoLalo
    {
        int rtn = 1, cont = 0;
        double sd = 0.000, sl = 0.000, cd = 0.000, rm = -1.000, rr = 0.000, rd = 0.000;
        String d_almacen = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String n2;
        String SP;
        PreparedStatement ps;
        for (int f = 0; f < tam; f++) {
            try {
                int mm = Integer.parseInt(tabla[f][2]);
                n2 = "";
//                for(int i =  tabla[f][2].length(); i < 18; i++){ n2+="0"; }
                n2 += mm;
            } catch (Exception e) {
                n2 = tabla[f][2];
            }
            try {
                cont = 0;
                SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, n2);
                ps.setString(2, tabla[f][3]);
                ps.setString(3, tabla[f][0]);
                ps.setString(4, tabla[f][4]);
                rs = ps.executeQuery();
                while (rs.next()) {
                    sl = rs.getDouble("ultimo_stocklibre");
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
            try {
                SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, n2);
                ps.setString(2, tabla[f][3]);
                ps.setString(3, tabla[f][0]);
                ps.setString(4, tabla[f][5]);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cd = rs.getDouble("ultimo_centro_destino");
                    sd = rs.getDouble("ultimo_stocklibre");
                    cont++;
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
            Double val = Double.parseDouble(tabla[f][1]);//[1] Cantidad
            DecimalFormat df = new DecimalFormat("#.##");
            rm = sl - val;
            rr = cd + val;
            rd = sd + val;
            String fmt = df.format(rm);
            String fmr = df.format(rr);
            String fmd = df.format(rd);
            
            if (rm >= 0) {
                String ck = ACC_Almacenes.ObtenerInstancia().verificaAlmacenDes(tabla[f][5], tabla[f][3]);
                String al;
                if (!ck.trim().equals("")) {
                    al = "TR01";
                } else {
                    al = tabla[f][5];
                }
                if (cont > 0) {
                    try {
                        SP = "{CALL MM.Movimientos_VerificarExistentesNUpdateUltimoStock(?, ?, ?, ?, ?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, Num(String.valueOf(fmt)));
                        ps.setString(2, n2);
                        ps.setString(3, tabla[f][3]);
                        ps.setString(4, tabla[f][0]);
                        ps.setString(5, tabla[f][4]);
                        ps.executeUpdate();
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                    try {
                        SP = "{CALL MM.Movimientos_InventariosUpdateUltimoCentDest(?, ?, ?, ?, ?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, Num(String.valueOf(fmr)));
                        ps.setString(2, n2);
                        ps.setString(3, tabla[f][3]);
                        ps.setString(4, tabla[f][0]);
                        ps.setString(5, al);
                        ps.executeUpdate();
                        
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                    try {
                        SP = "{CALL MM.Movimientos_VerificarExistentesNUpdateUltimoStock(?, ?, ?, ?, ?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, Num(String.valueOf(fmd)));
                        ps.setString(2, n2);
                        ps.setString(3, tabla[f][3]);
                        ps.setString(4, tabla[f][0]);
                        ps.setString(5, al);
                        ps.executeUpdate();
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                } else {
                    stock sk = new stock();
                    try {
                        SP = "{CALL MM.Movimientos_FirstMat(?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, n2);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            sk.setMaterial(rs.getString("material"));
                            sk.setDescripcion_ES(rs.getString("descripcion_ES"));
                            sk.setDescripcion_EN(rs.getString("descripcion_EN"));
                            sk.setUnidad_medida(rs.getString("unidad_medida"));
//                            sk.setAlmacen(rs.getString("almacen"));
//                            sk.setDescripcion_almacen(rs.getString("descripcion_almacen"));
//                            sk.setStocklibre_utilizacion(rs.getInt("stocklibre_utilizacion"));
                            sk.setTipo_material(rs.getString("tipo_material"));
                            sk.setGrupoArticulos(rs.getString("grupo_articulos"));
                            sk.setIndicador_lote(rs.getString("sujeto_lote"));
                        }
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                    try {
                        SP = "{CALL MM.Movimientos_FirstAlmacen(?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, al);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            d_almacen = rs.getString("descripcion_ES");
                        }
                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }
                    Double vl = Double.parseDouble(tabla[f][1]);
                    try {
                        SP = "{CALL MM.Movimientos_InsertInventario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, sk.getMaterial());
                        ps.setString(2, sk.getDescripcion_ES());
                        ps.setString(3, sk.getDescripcion_EN());
                        ps.setString(4, tabla[f][3]);
                        ps.setString(5, sk.getUnidad_medida());
                        ps.setString(6, al);
                        ps.setString(7, d_almacen);
                        ps.setString(8, Num(String.valueOf(vl)));
                        ps.setString(9, tabla[f][0]);//Pos 1
                        ps.setString(10, sk.getTipo_material());//lote
                        ps.setString(11, sk.getGrupoArticulos());
                        ps.setString(12, sk.getIndicador_lote());
                        ps.executeUpdate();
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                    try {
                        SP = "{CALL MM.Movimientos_VerificarExistentesNUpdateUltimoStock(?, ?, ?, ?, ?)}";
                        ps = con.prepareStatement(SP);
                        ps.setString(1, Num(String.valueOf(fmt)));
                        ps.setString(2, n2);
                        ps.setString(3, tabla[f][3]);
                        ps.setString(4, tabla[f][0]);
                        ps.setString(5, tabla[f][4]);
                        ps.executeUpdate();
                    } catch (Exception ex) {
                        System.err.println("Error: " + ex);
                    }
                }
                rtn = 2;
            } else {
                cnx.CerrarConexion(con);
                return 1;
            }
        }
        cnx.CerrarConexion(con);
        return rtn;
    }
    
    public Double UltimoLUD(String mat, String ctr, String lote, String almacen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        Double sl = 0.00;
        PreparedStatement ps;
        String SP;
        try {
            SP = "{CALL MM.Movimientos_ConsultarInventarioUltL(?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, ctr);
            ps.setString(3, lote);
            ps.setString(4, almacen);
            rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getDouble("cantidad_centro_destino");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return sl;
    }
    
    public Double LibreLUD(String mat, String ctr, String lote, String almacen) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        Double sl = 0.00;
        PreparedStatement ps;
        String SP;
        try {
            SP = "{CALL MM.Movimientos_ConsultarInventarioUltL(?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, ctr);
            ps.setString(3, lote);
            ps.setString(4, almacen);
            rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getDouble("ultimo_centro_destino");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return sl;
    }
    
    public ArrayList<stock> ConsultaInventariosC(String centro, String mat) {
        String query = "{call MM.inventarios_MOM(?,?)}";
        ArrayList<stock> stockmateriales = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            sp.setString(2, centro);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                stock stockmat = new stock();
                
                stockmat.setMaterial(rs.getString("material"));
                stockmat.setCentro(rs.getString("centro"));
                stockmat.setAlmacen(rs.getString("almacen"));
                stockmat.setLote(rs.getString("lote"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                
                stockmateriales.add(stockmat);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return stockmateriales;
    }
    
    public ArrayList<stock> ConsultaInventariosC2(String centro, String mat, String mov, String alm) {
        String query = "{call MM.inventarios_MOM(?,?,?)}";
        ArrayList<stock> stockmateriales = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            sp.setString(2, centro);
            sp.setString(3, alm);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                stock stockmat = new stock();
                
                stockmat.setMaterial(rs.getString("material"));
                stockmat.setCentro(rs.getString("centro"));
                stockmat.setAlmacen(rs.getString("almacen"));
                stockmat.setLote(rs.getString("lote"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                if (mov.equals("101") || mov.equals("201") || mov.equals("261") || mov.equals("303") || mov.equals("311")) {
                    if (Double.parseDouble(stockmat.getStocklibre_utilizacion()) >= 1) {
                        stockmateriales.add(stockmat);
                    }
                } else {
                    stockmateriales.add(stockmat);
                }
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return stockmateriales;
    }
    
    public ArrayList<stock> ConsultaInventariosEE(String centro, String mat, String mov, String alm, String ped, String pos) {
        String query = "{call MM.inventariosEE_MOM(?,?,?,?,?)}";
        ArrayList<stock> stockmateriales = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            PreparedStatement sp = con.prepareStatement(query);
            sp.setString(1, mat);
            sp.setString(2, centro);
            sp.setString(3, alm);
            sp.setString(4, ped);
            sp.setString(5, pos);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                stock stockmat = new stock();
                
                stockmat.setMaterial(rs.getString("material"));
                stockmat.setCentro(rs.getString("centro"));
                stockmat.setAlmacen(rs.getString("almacen"));
                stockmat.setLote(rs.getString("lote"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                if (mov.equals("101") || mov.equals("201") || mov.equals("261") || mov.equals("303") || mov.equals("311")) {
                    if (Double.parseDouble(stockmat.getStocklibre_utilizacion()) >= 1) {
                        stockmateriales.add(stockmat);
                    }
                } else {
                    stockmateriales.add(stockmat);
                }
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return stockmateriales;
    }
    
    public int ConsultaCantidad(String mat, String centro, String almacen, String lote) {
        int rt = 0;
        String query;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
//        try {
//            String n = "";
//            int mm = Integer.parseInt(mat);
//            n += mm;
//            if (mat.length() == 18) {
//                query = "select * from inventarios where material = '" + mat + "' and centro = '" + centro + "' and almacen = '" + almacen + "' and lote = '" + lote + "'";
//            } else {
//                query = "select * from inventarios where material = '" + n + "' and centro = '" + centro + "' and almacen = '" + almacen + "' and lote = '" + lote + "'";
//            }
//        } catch (Exception e) {
        query = "select * from inventarios where material = '" + mat + "' and centro = '" + centro + "' and almacen = '" + almacen + "' and lote = '" + lote + "'";
//        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                rt = Integer.parseInt(rs.getString("stock_traslado"));
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            rt = 0;
        }
        return rt;
    }
    
    public String VerificarMatLote(String material) {
        String m = "0";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL MM.VerificarMatSujetoLote(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, material);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = material;
            }
        } catch (Exception e) {
            System.err.println("error VerificarMatLote por  " + e);
        }
        cnx.CerrarConexion(con);
        return m;
    }
    
    public int SujeTlote(String material) {
        int m = 0;
        String query = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        query = "SELECT material FROM materiales WHERE material = '" + material + "' AND sujeto_lote = 'X'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                m = 1;
            }
        } catch (Exception e) {
            System.err.println("error VerificarMatLote por  " + e);
        }
        cnx.CerrarConexion(con);
        return m;
    }
    
    public int sujetoLoteMate(String Material) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int a = 0;
        String query = "{call MM.SujetoLote_MOM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Material);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
            a = 0;
        } finally {
            cnx.CerrarConexion(con);
        }
        return a;
    }
    
    public void ActualizaInventario(String mat, String ctr, String cnd, String lote, String almacen) {
        String query, d_almacen = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        int rr = 0;
        double sl = 0.000, rm;
        PreparedStatement ps;
        String SP;
        try {
            SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, ctr);
            ps.setString(3, lote);
            ps.setString(4, almacen);
            rs = ps.executeQuery();
            while (rs.next()) {
                rr++;
                sl = Double.parseDouble(rs.getString("stocklibre_utilizacion"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        if (rr > 0) {
            Double val = Double.parseDouble(cnd);
            rm = sl + val;
            DecimalFormat df = new DecimalFormat("#.##");
            String fmt = df.format(rm);
            String nf = Num(String.valueOf(fmt));
            try {
                SP = "{CALL MM.Movimientos_InventarioUpdateStocks(?, ?, ?, ?, ?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, nf);
                ps.setString(2, nf);
                ps.setString(3, mat);
                ps.setString(4, ctr);
                ps.setString(5, lote);
                ps.setString(6, almacen);
                ps.executeUpdate();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            } finally {
                cnx.CerrarConexion(con);
            }
        } else {
            stock sk = new stock();
            try {
                SP = "{CALL MM.Movimientos_FirstMat(?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, mat);
                rs = ps.executeQuery();
                while (rs.next()) {
                    sk.setMaterial(rs.getString("material"));
                    sk.setDescripcion_ES(rs.getString("descripcion_ES"));
                    sk.setDescripcion_EN(rs.getString("descripcion_EN"));
                    sk.setUnidad_medida(rs.getString("unidad_medida"));
                    sk.setTipo_material(rs.getString("tipo_material"));
                    sk.setGrupoArticulos(rs.getString("grupo_articulos"));
                    sk.setIndicador_lote(rs.getString("sujeto_lote"));
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
            try {
                SP = "{CALL MM.Movimientos_FirstAlmacen(?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, almacen);
                rs = ps.executeQuery();
                while (rs.next()) {
                    d_almacen = rs.getString("descripcion_ES");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
            Double vl = Double.parseDouble(cnd);
            String nfi = Num(String.valueOf(String.valueOf(vl)));
            try {
                SP = "{CALL MM.Movimientos_InsertInventario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, sk.getMaterial());
                ps.setString(2, sk.getDescripcion_ES());
                ps.setString(3, sk.getDescripcion_EN());
                ps.setString(4, ctr);
                ps.setString(5, sk.getUnidad_medida());
                ps.setString(6, almacen);
                ps.setString(7, d_almacen);
                ps.setString(8, nfi);
                ps.setString(9, lote);
                ps.setString(10, sk.getTipo_material());
                ps.setString(11, sk.getGrupoArticulos());
                ps.setString(12, sk.getIndicador_lote());
                ps.executeUpdate();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            } finally {
                cnx.CerrarConexion(con);
            }
        }
    }
    
    public void ActualizarrInventario(String mat, String ctr, String cnd, String lote, String almacen) {
        String SP, d_almacen = null;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        int rr = 0;
        double rm, sl = 0.000;
        PreparedStatement ps;
        try {
            SP = "{CALL MM.Movimientos_VerificarExistentesN(?, ?, ?, ?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            ps.setString(2, ctr);
            ps.setString(3, lote);
            ps.setString(4, almacen);
            rs = ps.executeQuery();
            while (rs.next()) {
                rr++;
                sl = Double.parseDouble(rs.getString("stocklibre_utilizacion"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        if (rr > 0) {
            Double val = Double.parseDouble(cnd);
            rm = sl + val;
            DecimalFormat df = new DecimalFormat("#.##");
            String fmt = df.format(rm);
            String nf = Num(String.valueOf(fmt));
            try {
                SP = "{CALL MM.Movimientos_InventarioUpdateStocks(?, ?, ?, ?, ?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, nf);
                ps.setString(2, nf);
                ps.setString(3, mat);
                ps.setString(4, ctr);
                ps.setString(5, lote);
                ps.setString(6, almacen);
                ps.executeUpdate();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            } finally {
                cnx.CerrarConexion(con);
            }
        } else {
            stock sk = new stock();
            try {
                SP = "{CALL MM.Movimientos_FirstMat(?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, mat);
                rs = ps.executeQuery();
                while (rs.next()) {
                    sk.setMaterial(rs.getString("material"));
                    sk.setDescripcion_ES(rs.getString("descripcion_ES"));
                    sk.setDescripcion_EN(rs.getString("descripcion_EN"));
                    sk.setUnidad_medida(rs.getString("unidad_medida"));
                    sk.setTipo_material(rs.getString("tipo_material"));
                    sk.setGrupoArticulos(rs.getString("grupo_articulos"));
                    sk.setIndicador_lote(rs.getString("sujeto_lote"));
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
            try {
                SP = "{CALL MM.Movimientos_FirstAlmacen(?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, almacen);
                rs = ps.executeQuery();
                while (rs.next()) {
                    d_almacen = rs.getString("descripcion_ES");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
            Double vl = Double.parseDouble(cnd);
            String nfi = Num(String.valueOf(String.valueOf(vl)));
            try {
                SP = "{CALL MM.Movimientos_InsertInventario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                ps = con.prepareStatement(SP);
                ps.setString(1, sk.getMaterial());
                ps.setString(2, sk.getDescripcion_ES());
                ps.setString(3, sk.getDescripcion_EN());
                ps.setString(4, ctr);
                ps.setString(5, sk.getUnidad_medida());
                ps.setString(6, almacen);
                ps.setString(7, d_almacen);
                ps.setString(8, nfi);
                ps.setString(9, lote);
                ps.setString(10, sk.getTipo_material());
                ps.setString(11, sk.getGrupoArticulos());
                ps.setString(12, sk.getIndicador_lote());
                ps.executeUpdate();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            } finally {
                cnx.CerrarConexion(con);
            }
        }
    }
    
    public int ValidarSujLotMate(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT indicador_lote FROM inventarios WHERE material='" + mat + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String l = rs.getString("indicador_lote");
                if (l.equals("X")) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarClaseOrden (ACC_ClaseOrden) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
    
    public int ValidarLotInventarioMat(String mat, String lot) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT lote FROM inventarios WHERE material='" + mat + "' AND lote='" + lot + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if (!rs.next()) {
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarClaseOrden (ACC_ClaseOrden) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
    
    public String GETULCAN(String doc, String pos) {
        String ct = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        
        PreparedStatement sp = null;
        ResultSet rs = null;
        String sql = "{CALL MM.ObtenerCantidadPedidosDetalle_MOM(?,?)}";
        
        try {
            sp = con.prepareStatement(sql);
            sp.setString(1, doc);
            sp.setString(2, pos);
            
            rs = sp.executeQuery();
            while (rs.next()) {
                ct = rs.getString("ultima_cantidad");
            }
        } catch (Exception e) {
            System.err.println("Error por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ct;
    }
    
    public Stock_Traslado mDatos305(String material, String centro, String lang) {
        Stock_Traslado st = new Stock_Traslado();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call MM.stock_transferecia_get_MOM(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, material);
            ps.setString(2, centro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                st.setStock_traslado(rs.getString("stock_traslado"));
                st.setUnidad_medida(rs.getString("unidad_medida"));
                st.setCentro(rs.getString("centro"));
                st.setDescripcion(rs.getString("descripcion_" + lang));
            }
        } catch (Exception e) {
            System.err.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return st;
    }
    
    public LinkedList<Stock_Traslado> ConsultaStock_T(String texto, String lang, String Material, String Cantidad) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<Stock_Traslado> mate = new LinkedList<>();
        String query = "{call MM.stock_transfereciaMatch_MOM(?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, texto);
            ps.setString(2, Material);
            ps.setString(3, Cantidad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Stock_Traslado ma = new Stock_Traslado();
                ma.setCentro(rs.getString("centro"));
                ma.setMaterial(rs.getString("material"));
                ma.setStock_traslado(rs.getString("stock_traslado"));
                ma.setSuejto_lote(rs.getString("sujeto_lote"));
                ma.setUnidad_medida(rs.getString("unidad_medida"));
                ma.setDescripcion(rs.getString("descripcion_" + lang));
                mate.add(ma);
            }
        } catch (Exception e) {
            System.err.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mate;
    }
    
    public LinkedList<stock> ConsultaStockLotesNOT(String mate) {
        LinkedList<stock> stockmateriales = new LinkedList<stock>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.inventarios_FOLIOSNOTI(?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, mate);
            rs = pst.executeQuery();
            while (rs.next()) {
                stock stockmat = new stock();
                stockmat.setLote(rs.getString("lote"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                stockmateriales.add(stockmat);
                
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
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
                System.err.println("Error: " + e);
            }
        }
        return stockmateriales;
    }
    
    public stock ConsultarMateNotifi01(String mate, String lotabp) {
        stock in = new stock();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.inventarios_MATERIAALESNOTI(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, mate);
            pst.setString(2, lotabp);
            rs = pst.executeQuery();
            while (rs.next()) {
                in.setLote(rs.getString("lote"));
                in.setId_inven(rs.getInt("id_inven"));
                in.setMaterial(rs.getString("material"));
                in.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                in.setUnidad_medida(rs.getString("unidad_medida"));
                in.setDescripcion_ES(rs.getString("descripcion_ES"));
                in.setCentro(rs.getString("centro"));
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
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return in;
    }
    
    public stock ConsultarMateNotifiVAL(String mate, String lote) {
        stock in = new stock();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.inventarios_VALINVEN(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, mate);
            pst.setString(2, lote);
            rs = pst.executeQuery();
            while (rs.next()) {
                in.setLote(rs.getString("lote"));
                in.setId_inven(rs.getInt("id_inven"));
                in.setMaterial(rs.getString("material"));
                in.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                in.setUnidad_medida(rs.getString("unidad_medida"));
                in.setDescripcion_ES(rs.getString("descripcion_ES"));
                in.setCentro(rs.getString("centro"));
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
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return in;
    }
    
    public void elimina305(String usu) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{call d_tabla305_T_MOM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usu);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    
    public stock ConsultarMateNotifiPM(String material, String lote) {
        stock in = new stock();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.inventariosCONSUL(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, material);
            pst.setString(2, lote);
            rs = pst.executeQuery();
            while (rs.next()) {
                in.setLote(rs.getString("lote"));
                in.setId_inven(rs.getInt("id_inven"));
                in.setMaterial(rs.getString("material"));
                in.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                in.setUnidad_medida(rs.getString("unidad_medida"));
                in.setDescripcion_ES(rs.getString("descripcion_ES"));
                in.setCentro(rs.getString("centro"));
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
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return in;
    }

    //Trae datos Almacen Stock Material
    public ArrayList<Almaceness> ConsultaMatchAlmacenn(String mate, String texto_mate, String cet, String idioma, String no_campoAlm, String limite) {
        ArrayList<Almaceness> alm = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call MM.StockMat_ConsAlm(?,?,?,?,?,?)}");
            pst.setString(1, mate);
            pst.setString(2, cet);
            pst.setString(3, texto_mate);
            pst.setString(4, idioma);
            pst.setString(5, no_campoAlm);
            pst.setString(6, limite);
            rs = pst.executeQuery();
            while (rs.next()) {
                Almaceness al = new Almaceness();
                al.setId_almacen(rs.getString("id_almacen"));
                al.setDescripcion(rs.getString(no_campoAlm));
                al.setCentro(rs.getString("centro"));
                alm.add(al);
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
        return alm;
    }

    //Stock Material Consulta Lote
    public ArrayList<Lotes> ConsultaLoteStockk(String idioma) {
        ArrayList<Lotes> cen = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            if (idioma.equals("ES")) {
                pst = con.prepareCall("{call MM.StockMat_ConsLoteEs()}");
                rs = pst.executeQuery();
                while (rs.next()) {
                    Lotes c = new Lotes();
                    c.setLote(rs.getString("lote"));
                    c.setAlmacen(rs.getString("almacen"));
                    c.setCentro(rs.getString("centro"));
                    c.setMaterial(rs.getString("material"));
                    c.setDescripcion_ES(rs.getString("descripcion_ES"));
                    cen.add(c);
                }
            } else if (idioma.equals("EN")) {
                pst = con.prepareCall("{call MM.StockMat_ConsLoteEn()}");
                rs = pst.executeQuery();
                while (rs.next()) {
                    Lotes c = new Lotes();
                    c.setLote(rs.getString("lote"));
                    c.setAlmacen(rs.getString("almacen"));
                    c.setCentro(rs.getString("centro"));
                    c.setMaterial(rs.getString("material"));
                    c.setDescripcion_EN(rs.getString("descripcion_EN"));
                    cen.add(c);
                }
            } else {
                
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en Consulta Centros Coste por: " + e);
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
        return cen;
    }
    
    public ArrayList<tabla305> GuardaPosiciones(String mat, String des, String cnt, String um, String lote, String ctr, String usu) {
        ArrayList<tabla305> ar = new ArrayList<>();
        if (mat != null) {
            Conexion cnx = new Conexion();
            Connection con = cnx.ObtenerConexion();
            String query = "{call ingresa_tabla305_T_MOM(?,?,?,?,?,?,?)}";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, mat);
                ps.setString(2, des);
                ps.setString(3, cnt);
                ps.setString(4, um);
                ps.setString(5, lote);
                ps.setString(6, ctr);
                ps.setString(7, usu);
                ps.executeUpdate();
                query = "{call s_tabla305_T_MOM(?)}";
                PreparedStatement ps2 = con.prepareStatement(query);
                ps2.setString(1, usu);
                ResultSet rs = ps2.executeQuery();
                while (rs.next()) {
                    tabla305 tt = new tabla305();
                    tt.setMaterial(rs.getString("material"));
                    tt.setDescripcion(rs.getString("descripcion"));
                    tt.setCantidad(rs.getString("cantidad"));
                    tt.setUnidad_medida(rs.getString("unidad_medida"));
                    tt.setLote(rs.getString("lote"));
                    tt.setCentro(rs.getString("centro"));
                    ar.add(tt);
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            } finally {
                cnx.CerrarConexion(con);
            }
        }
        return ar;
    }
    
    public LinkedList<stock> MatNPMMalmNOTstock(String mmmat, String mmtxtbr, String lan, String mmtipM) {
        LinkedList<stock> mt = new LinkedList<>();
        String query = "{call MM.inventarios_almacen_match(?,?,?,?)}";
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            
            pst = conn.prepareStatement(query);
            pst.setString(1, mmmat);
            pst.setString(2, mmtxtbr);
            pst.setString(3, lan);
            pst.setString(4, mmtipM);
            rs = pst.executeQuery();
            while (rs.next()) {
                stock mat = new stock();
                mat.setMaterial(rs.getString("material"));
                mat.setDescripcion_EN(rs.getString("Descripcion_EN"));
                mat.setDescripcion_ES(rs.getString("Descripcion_ES"));
                mat.setAlmacen(rs.getString("almacen"));
                mat.setTipo_material(rs.getString("tipo_material"));
                
                mt.add(mat);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return mt;
    }
    
    public LinkedList<stock> ConsultaStockLotesEQ(String mate) {
        LinkedList<stock> stockmateriales = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.inventarios_EQNOTI(?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, mate);
            rs = pst.executeQuery();
            while (rs.next()) {
                stock stockmat = new stock();
                stockmat.setLote(rs.getString("lote"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                stockmateriales.add(stockmat);
                
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
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
                System.err.println("Error: " + e);
            }
        }
        return stockmateriales;
    }
    
    public LinkedList<stock> ConsultaStockLotesEQEX(String mate) {
        LinkedList<stock> stockmateriales = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.inventarios_EQloteEX(?)}";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, mate);
            rs = pst.executeQuery();
            while (rs.next()) {
                stock stockmat = new stock();
                stockmat.setLote(rs.getString("lote"));
                stockmat.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                stockmateriales.add(stockmat);
                
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
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
                System.err.println("Error: " + e);
            }
        }
        return stockmateriales;
    }
    
    public boolean InsertarMATR(String mtrl, String descripcion_ES, String descripcion_EN, String centro, String unidad_medida, String lote, String tipo_material, String grupo_articulos) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        try {
            pst = con.prepareCall("{call MM.inventariosINSErtaMTEQ(?,?,?,?,?,?,?,?)}");
            pst.setString(1, mtrl);
            pst.setString(2, descripcion_ES);
            pst.setString(3, descripcion_EN);
            pst.setString(4, centro);
            pst.setString(5, unidad_medida);
            pst.setString(6, lote);
            pst.setString(7, tipo_material);
            pst.setString(8, grupo_articulos);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
    
    public boolean ACTUALequipos_not(String orden, String lote) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        try {
            pst = con.prepareCall("{call PM.equipos_notificacionesacTUALIZAR(?,?)}");
            pst.setString(2, orden);
            pst.setString(1, lote);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
    
    public boolean ACTUAINveta(String mat, String lote, String stocklibre) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        int cont;
        try {
            pst = con.prepareCall("{call MM.inventarioACTUALIZAR(?,?,?)}");
            pst.setString(1, mat);
            pst.setString(2, lote);
            pst.setString(3, stocklibre);
            cont = pst.executeUpdate();
            if (cont > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error : " + e);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
    
    public stock ConsultarINVENTARIOSMM(String material, String lote) {
        stock in = new stock();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.inventariosCONSULTA(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, material);
            pst.setString(2, lote);
            rs = pst.executeQuery();
            while (rs.next()) {
                in.setLote(rs.getString("lote"));
                in.setId_inven(rs.getInt("id_inven"));
                in.setMaterial(rs.getString("material"));
                in.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
                in.setUnidad_medida(rs.getString("unidad_medida"));
                in.setDescripcion_ES(rs.getString("descripcion_ES"));
                in.setCentro(rs.getString("centro"));
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
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return in;
    }
    
    public String getCantidad311(String mat, String alm, String centro, String lote) {
        String stck = "0.000";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.GetCantidadStock311(?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ps.setString(2, alm);
            ps.setString(3, centro);
            ps.setString(4, lote);
            rs = ps.executeQuery();
            while (rs.next()) {
                stck = rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return stck;
    }
    
    public void Actualizarstock311(String mat, String almacen, String centro, String lote, String cantidad) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        stock sk = new stock();
        String SP = "";
        String d_almacen = "";
        try {
            SP = "{CALL MM.Movimientos_FirstMat(?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            while (rs.next()) {
                sk.setMaterial(rs.getString("material"));
                sk.setDescripcion_ES(rs.getString("descripcion_ES"));
                sk.setDescripcion_EN(rs.getString("descripcion_EN"));
                sk.setUnidad_medida(rs.getString("unidad_medida"));
                sk.setTipo_material(rs.getString("tipo_material"));
                sk.setGrupoArticulos(rs.getString("grupo_articulos"));
                sk.setIndicador_lote(rs.getString("sujeto_lote"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        try {
            SP = "{CALL MM.Movimientos_FirstAlmacen(?)}";
            ps = con.prepareStatement(SP);
            ps.setString(1, almacen);
            rs = ps.executeQuery();
            while (rs.next()) {
                d_almacen = rs.getString("descripcion_ES");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        
        try {
            String sql = "{call MM.ActualizarStock311Su(?,?,?,?,?,?,?,?,?,?,?,?)}";
            ps = con.prepareStatement(sql);
            ps.setString(1, cantidad);
            ps.setString(2, mat);
            ps.setString(3, almacen);
            ps.setString(4, d_almacen);
            ps.setString(5, centro);
            ps.setString(6, lote);
            ps.setString(7, sk.getDescripcion_ES());
            ps.setString(8, sk.getDescripcion_EN());
            ps.setString(9, sk.getUnidad_medida());
            ps.setString(10, sk.getTipo_material());
            ps.setString(11, sk.getGrupoArticulos());
            ps.setString(12, sk.getIndicador_lote());
            ps.executeQuery();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    
    public ArrayList<stock> ConsultaLoteStockNuevo(String mat, String centro, String alm) {
        ArrayList<stock> sto = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        String sql = "{call MM.MovimientosMateriales_ConsultaLoteNuevo(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ps.setString(2, centro);
            ps.setString(3, alm);
            rs = ps.executeQuery();
            while (rs.next()) {
                stock s = new stock();
                s.setMaterial(rs.getString(1));
                s.setLote(rs.getString(2));
                s.setStocklibre_utilizacion(rs.getString(3));
                s.setNum_doc(rs.getString(4));
                s.setPos_doc(rs.getString(5));
                sto.add(s);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return sto;
    }

    public stock VerificarExistenciaMovis(String mat, String cen, String alm, String lot, String doc, String pos) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        stock st = new stock();
        String sql = "{call MM.MovimeintosMateriales_ExisteciaMateriales(?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,mat);
            ps.setString(2,cen);
            ps.setString(3,alm);
            ps.setString(4,lot);
            ps.setString(5,doc);
            ps.setString(6,pos);
            rs = ps.executeQuery();
            while(rs.next()){
                st.setMaterial(rs.getString("material"));
                st.setStocklibre_utilizacion(rs.getString("stocklibre_utilizacion"));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return st;
    }
}
