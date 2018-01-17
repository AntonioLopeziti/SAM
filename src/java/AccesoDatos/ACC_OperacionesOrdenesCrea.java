package AccesoDatos;

import Entidades.operaciones_ordenes_crea;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ACC_OperacionesOrdenesCrea {

    private static ACC_OperacionesOrdenesCrea Instance = null;

    public static ACC_OperacionesOrdenesCrea ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_OperacionesOrdenesCrea();
        }
        return Instance;
    }

    public operaciones_ordenes_crea ObtieneCampos(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        operaciones_ordenes_crea oc = new operaciones_ordenes_crea();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                oc.setNum_operacion(rs.getString("num_operacion"));
                oc.setPrecio(rs.getString("precio"));
                oc.setGrupo_articulos(rs.getString("grupo_articulos"));
                oc.setOrganizacion_compras(rs.getString("organizacion_compras"));
                oc.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                oc.setSolicitante(rs.getString("solicitante"));
                oc.setDuracion_operacion(rs.getString("duracion_operacion"));
                oc.setClase_coste(rs.getString("clase_coste"));
            }
        } catch (Exception ex) {
            System.err.println("Error al obtener campos: " + ex);
        }
        cnx.CerrarConexion(con);
        return oc;
    }

    public operaciones_ordenes_crea CargarFirstOpeSAM(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        operaciones_ordenes_crea ope = new operaciones_ordenes_crea();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ConsultarOperacionesSAM(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            rs.next();

            ope = new operaciones_ordenes_crea();
            ope.setNum_operacion(rs.getString("num_operacion"));
            ope.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
            ope.setCentro(rs.getString("centro"));
            ope.setNum_solped(rs.getString("num_solped"));
            ope.setClave_control(rs.getString("clave_control"));
            ope.setTrabajo_operacion(rs.getString("trabajo_operacion"));
            ope.setUnidad_trabajo(rs.getString("unidad_trabajo"));
            ope.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
            ope.setNum_orden(rs.getString("num_orden"));
            ope.setCantidad_base(rs.getString("cantidad_base"));
            ope.setDuracion_operacion(rs.getString("duracion_operacion"));
            ope.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarFirstOpeSAM(ACC_OperacionesOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ope;
    }

    public boolean InsertOperacionOrdenes(operaciones_ordenes_crea ooc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst = null;
        boolean confirmacion = false;
        try {
            cbst = con.prepareCall("{CALL PM.Ordenes_InsertarOperacion(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbst.setString(1, ooc.getFolio_sam());
            cbst.setString(2, ooc.getHora_dia());
            cbst.setString(3, ooc.getFecha());
            cbst.setString(4, ooc.getNum_operacion());
            cbst.setString(5, ooc.getClave_control());
            cbst.setString(6, ooc.getCentro());
            cbst.setString(7, ooc.getTexto_breve_operacion());
            cbst.setString(8, ooc.getCantidad_base());
            cbst.setString(9, ooc.getDuracion_operacion());
            cbst.setString(10, ooc.getUnidad_duracion_normal());
            cbst.setString(11, ooc.getNum_solped());
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

    public boolean InsertOperacion2Ordenes(operaciones_ordenes_crea ooc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst;
        boolean confirmacion;
        try {
            cbst = con.prepareCall("{CALL PM.Ordenes_InsertarOperacion2(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbst.setString(1, ooc.getUnidad_trabajo());
            cbst.setString(2, ooc.getCantidad_operacion());
            cbst.setString(3, ooc.getOrganizacion_compras());
            cbst.setString(4, ooc.getGrupo_compras_actividad_trabajo_externa());
            cbst.setString(5, ooc.getGrupo_articulos());
            cbst.setString(6, ooc.getPrecio());
            cbst.setString(7, ooc.getClave_moneda());
            cbst.setString(8, ooc.getClase_coste());
            cbst.setString(9, ooc.getSolicitante());
            cbst.setString(10, ooc.getNum_operacion());
            cbst.setString(11, ooc.getFolio_sam());
            cbst.setString(12, ooc.getNum_cuenta_proveedor());
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

    public ArrayList ConsultaOperacionesByOrd(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList ops = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        operaciones_ordenes_crea ope;
        String SP = "{CALL PM.Ordenes_CargarOperacionesSAM(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                ope = new operaciones_ordenes_crea();
                ope.setNum_operacion(rs.getString("num_operacion"));
                ope.setNum_solped(rs.getString("num_solped"));
                ope.setCentro(rs.getString("centro"));
                ope.setClave_control(rs.getString("clave_control"));
                ope.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                ope.setCantidad_base(rs.getString("cantidad_base"));
                ope.setDuracion_operacion(rs.getString("duracion_operacion"));
                ope.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                ops.add(ope);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchPuestoTrabajo(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ops;
    }

    public ArrayList ConsultaOperacionesConMat(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList ops = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        operaciones_ordenes_crea ope;
        String SP = "{CALL PM.Ordenes_CargarOperacionesConMatSAM(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                ope = new operaciones_ordenes_crea();
                ope.setNum_operacion(rs.getString("num_operacion"));
                ope.setCantidad_base(rs.getString("cantidad_base"));
                ope.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                ope.setPrecio(rs.getString("precio"));
                ope.setClave_moneda(rs.getString("clave_moneda"));
                ope.setGrupo_articulos(rs.getString("grupo_articulos"));
                ope.setOrganizacion_compras(rs.getString("organizacion_compras"));
                ope.setGrupo_compras_actividad_trabajo_externa(rs.getString("grupo_compras_actividad_trabajo_externa"));
                ope.setSolicitante(rs.getString("solicitante"));
                ope.setClase_coste(rs.getString("clase_coste"));
                ope.setNum_cuenta_proveedor(rs.getString("num_cuenta_proveedor"));
                ops.add(ope);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchPuestoTrabajo(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ops;
    }

    public ArrayList ConsultarOperacionesSAM(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList ops = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        operaciones_ordenes_crea op;
        String SP = "{CALL PM.Ordenes_CargarOperacionesSAM(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            while (rs.next()) {
                op = new operaciones_ordenes_crea();
                op.setNum_operacion(rs.getString("num_operacion"));
                op.setNum_solped(rs.getString("num_solped"));
                op.setCentro(rs.getString("centro"));
                op.setClave_control(rs.getString("clave_control"));
                op.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                op.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                op.setCantidad_base(rs.getString("cantidad_base"));
                op.setDuracion_operacion(rs.getString("duracion_operacion"));
                op.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                op.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                ops.add(op);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarOperacionesSAM(ACC_OperacionesOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ops;
    }

    public String ValidarRowOperacionOrd(String ptoTr, String centP, String clvCtrl, String umd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarRowOperacion(?, ?, ?, ?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ptoTr);
            ps.setString(2, centP);
            ps.setString(3, clvCtrl);
            ps.setString(4, umd);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarRowOperacionOrd(ACC_BOMEquipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public String ValidarRowOperacionStaOrd(String ptoTr, String centP, String clvCtrl) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarRowStaOperacion(?, ?, ?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ptoTr);
            ps.setString(2, centP);
            ps.setString(3, clvCtrl);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarRowOperacionOrd(ACC_BOMEquipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

}
