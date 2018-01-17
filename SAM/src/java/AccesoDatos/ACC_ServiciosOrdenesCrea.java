package AccesoDatos;

import Entidades.materiales_ordenes_crea;
import Entidades.servicios_ordenes_crea;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_ServiciosOrdenesCrea {

    public static ACC_ServiciosOrdenesCrea Instance = null;

    public static ACC_ServiciosOrdenesCrea ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_ServiciosOrdenesCrea();
        }
        return Instance;
    }

//    public static void main(String[] args) {
//        String queryPM02 = "SELECT * FROM servicios_ordenes_crea WHERE folio_sam = 'OR80000010' and num_operacion = '020'";
//        LinkedList<servicios_ordenes_crea> sc = ACC_ServiciosOrdenesCrea.ObtenerInstancia().ObtieneServiciosOrdenesCrea(queryPM02);
//        for (int i = 0; i < sc.size(); i++) {
//            System.out.println("num servicio: " + sc.get(i).getNum_servicio());
//        }
//    }
//    public LinkedList<servicios_ordenes_crea> ObtieneServiciosOrdenesCrea(String query) {
//        Conexion cnx = new Conexion();
//        LinkedList<servicios_ordenes_crea> serord = new LinkedList<>();
//        try {
//            Connection con = cnx.ObtenerConexion();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {
//                servicios_ordenes_crea so = new servicios_ordenes_crea();
//                so.setFolio_sam(rs.getString("folio_sam"));
//                so.setNum_operacion(rs.getString("num_operacion"));
//                so.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
//                so.setClase_coste(rs.getString("clase_coste"));
//                so.setNum_servicio(rs.getString("num_servicio"));
//                so.setUnidad_medida_base(rs.getString("unidad_medida_base"));
//                so.setGrupo_articulos(rs.getString("grupo_articulos"));
//                serord.add(so);
//            }
//        } catch (Exception ex) {
//            System.err.println("Erro al obtener datos: " + ex);
//        }
//        return serord;
//    }
    public ArrayList ObtieneServiciosOrdenesCrea(String ord, String ope) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList srs = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        servicios_ordenes_crea s;
        String SP = "{CALL PM.Ordenes_CargarServiciosByOpeSAM(?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            ps.setString(2, ope);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new servicios_ordenes_crea();
                s.setNum_servicio(rs.getString("num_servicio"));
                s.setCantidad_base(rs.getString("cantidad_base"));
                s.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                s.setClase_coste(rs.getString("clase_coste"));
                s.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                s.setNum_operacion(rs.getString("num_operacion"));

                srs.add(s);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ObtieneServiciosOrdenesCrea(ACC_OperacionesOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return srs;
    }

    public ArrayList ConsultaServiciosByOrd(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList srs = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        servicios_ordenes_crea s;
        String SP = "{CALL PM.Ordenes_CargarServiciosSAM(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new servicios_ordenes_crea();
                s.setNum_servicio(rs.getString("num_servicio"));
                s.setCantidad_con_signo(rs.getString("cantidad_con_signo"));
                s.setGrupo_articulos(rs.getString("grupo_articulos"));
                s.setClase_coste(rs.getString("clase_coste"));
                s.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                s.setNum_operacion(rs.getString("num_operacion"));
                s.setValor_neto_posicion(rs.getString("valor_neto_posicion"));
                s.setTexto_breve(rs.getString("texto_breve"));
                srs.add(s);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaServiciosByOrd(ACC_OperacionesOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return srs;
    }

    public String ValidarMatchServi1(String umd, String clvM, String gpoA, String gpoC, String orgC, String clsC) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarMatchServicio1(?, ?, ?, ?, ? , ?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, umd);
            ps.setString(2, clvM);
            ps.setString(3, gpoA);
            ps.setString(4, gpoC);
            ps.setString(5, orgC);
            ps.setString(6, clsC);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarMatchServi1(ACC_BOMEquipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public String ValidarMatchServi2(String servi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarMatchServicio2(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, servi);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarMatchServi2(ACC_BOMEquipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public boolean InsertServicioOrdenes(servicios_ordenes_crea soc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst = null;
        boolean confirmacion = false;
        try {
            cbst = con.prepareCall("{CALL PM.Ordenes_InsertarServicio(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbst.setString(1, soc.getFolio_sam());
            cbst.setString(2, soc.getNum_operacion());
            cbst.setString(3, soc.getNum_servicio());
            cbst.setString(4, soc.getCantidad_base());
            cbst.setString(5, soc.getUnidad_medida_base());
            cbst.setString(6, soc.getPrecio_bruto());
            cbst.setString(7, soc.getTexto_breve());
            cbst.setString(8, soc.getGrupo_articulos());
            cbst.setString(9, soc.getClase_coste());
            confirmacion = cbst.execute();
            if (confirmacion == true) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error PS: " + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }
}
