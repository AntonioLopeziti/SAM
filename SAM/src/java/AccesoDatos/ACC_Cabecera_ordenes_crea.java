package AccesoDatos;

import Entidades.cabecera_ordenes_crea;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_Cabecera_ordenes_crea {

    private static ACC_Cabecera_ordenes_crea Instance = null;

    public static ACC_Cabecera_ordenes_crea ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Cabecera_ordenes_crea();
        }
        return Instance;
    }

    public boolean IngresaCabeOrden(String foli) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;

        boolean ins = false;
        String query = "INSERT INTO cabecera_ordenes_crea"
                + "(folio_sam"
                + ",num_orden"
                + ",ubicacion_tecnica"
                + ",hora_dia"
                + ",fecha"
                + ",indice_registro_no_valido"
                + ",centro_planificacion_mantenimiento"
                + ",clase_orden"
                + ",puesto_trabajo_responsable_medidas_mante"
                + ",texto_breve"
                + ",num_equipo"
                + ",fecha_inicio_extrema"
                + ",fecha_fin_extrema"
                + ",folio_sap"
                + ",recibido"
                + ",procesado"
                + " ,error)"
                + "VALUES"
                + "(folio_sam,"
                + "num_orden,"
                + "ubicacion_tecnica,"
                + "hora_dia,"
                + "fecha,"
                + "indice_registro_no_valido,"
                + "centro_planificacion_mantenimiento,"
                + "clase_orden,"
                + "puesto_trabajo_responsable_medidas_mante,"
                + "texto_breve,"
                + "num_equipo,"
                + "fecha_inicio_extrema,"
                + "fecha_fin_extrema,"
                + "folio_sap,"
                + "recibido,"
                + "procesado,"
                + "error)";
        try {
            st = con.createStatement();
            int s = st.executeUpdate(query);

            if (s < 0) {
                ins = true;
            } else {
                ins = false;
            }

        } catch (Exception e) {
            System.err.println("Error en metodo verSolPed () por: " + e);
        }
        cnx.CerrarConexion(con);
        return ins;
    }

    public String ValidarCabeceraOrden(String clsO, String numE, String ubiT, String cent, String ptoT) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarDatosCabecera(?, ?, ?, ?, ?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, clsO);
            ps.setString(2, numE);
            ps.setString(3, ubiT);
            ps.setString(4, cent);
            ps.setString(5, ptoT);
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

    public ArrayList ConsultaMatchOrden(String plMant, String ord, String txtO, String ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList cecos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        cabecera_ordenes_crea coc;
        String SP = "{CALL PM.Ordenes_ConsultarOrdenesMod(?, ?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, plMant);
            ps.setString(2, ord);
            ps.setString(3, txtO);
            ps.setString(4, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                coc = new cabecera_ordenes_crea();
                coc.setFolio_sam(rs.getString("folio_sam"));
                coc.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                coc.setTexto_breve(rs.getString("texto_breve"));
                cecos.add(coc);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchOrden(ACC_CabeceraOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cecos;
    }

    public String ValidarOrden(String id) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarOrden(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, id);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarOrden(ACC_BOMEquipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public String truncateOrden(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_TruncateOrden(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception ex) {
            System.err.println("Error en el metodo truncateOrden(ACC_Cabecera_ordenes_crea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

    public cabecera_ordenes_crea CargarDataCab(String ord) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        cabecera_ordenes_crea coc = new cabecera_ordenes_crea();
        String SP = "{CALL PM.Ordenes_CargarCabeceraSAM(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ord);
            rs = ps.executeQuery();
            rs.next();
            coc.setFolio_sam(rs.getString("folio_sam"));
            coc.setNum_orden(rs.getString("num_orden"));
            coc.setEstatus(rs.getString("estatus"));
            coc.setClase_orden(rs.getString("clase_orden"));
            coc.setTexto_breve(rs.getString("texto_breve"));
            coc.setPuesto_trabajo_responsable_medidas_mante(rs.getString("puesto_trabajo_responsable_medidas_mante"));
            coc.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
            coc.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
            coc.setFecha_fin_extrema(rs.getString("fecha_fin_extrema"));
            coc.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
            coc.setNum_equipo(rs.getString("num_equipo"));
            coc.setRecibido(rs.getString("recibido"));
            coc.setProcesado(rs.getString("procesado"));
            coc.setError(rs.getString("error"));
            coc.setModificado(rs.getString("modificado"));
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarDataCab(ACC_CabeceraOrdenesCrea por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return coc;
    }

    public boolean InsertCabeceraOrdenes(cabecera_ordenes_crea coc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement cbst = null;
        boolean confirmacion = false;
        try {
            cbst = con.prepareCall("{CALL PM.Ordenes_InsertarCabeceraOrdenes(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbst.setString(1, coc.getFolio_sam());
            cbst.setString(2, coc.getUbicacion_tecnica());
            cbst.setString(3, coc.getHora_dia());
            cbst.setString(4, coc.getFecha());
            cbst.setString(5, coc.getCentro_planificacion_mantenimiento());
            cbst.setString(6, coc.getClase_orden());
            cbst.setString(7, coc.getPuesto_trabajo_responsable_medidas_mante());
            cbst.setString(8, coc.getTexto_breve());
            cbst.setString(9, coc.getNum_equipo());
            cbst.setString(10, coc.getFecha_inicio_extrema());
            cbst.setString(11, coc.getFecha_fin_extrema());
            cbst.setString(12, coc.getUsuario());
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

    public cabecera_ordenes_crea SP_CargarDatosCabecera(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        cabecera_ordenes_crea coc = new cabecera_ordenes_crea();
        String query = "{call PM.CargarDatosCab(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setFolio_sam(rs.getString("folio_sam"));
                coc.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                coc.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                coc.setClase_orden(rs.getString("clase_orden"));
                coc.setPuesto_trabajo_responsable_medidas_mante(rs.getString("puesto_trabajo_responsable_medidas_mante"));
                coc.setTexto_breve(rs.getString("texto_breve"));
                coc.setNum_equipo(rs.getString("num_equipo"));
                coc.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                coc.setFecha_fin_extrema(rs.getString("fecha_fin_extrema"));
                coc.setError(rs.getString("error"));
                coc.setModificado(rs.getString("modificado"));
                coc.setProcesado(rs.getString("procesado"));
                coc.setFolio_sap(rs.getString("folio_sap"));
                coc.setRecibido(rs.getString("recibido"));
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

        return coc;
    }

    public String GetGPPlanEquipo(String equipo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call GetGpoPlaEquipo(?)}";
        String grupo = "";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo);
            rs = ps.executeQuery();
            if(rs.next()){
                grupo = rs.getString("grupo_planificador");
            }
        } catch (Exception e) {
            System.err.println("Error en GetGPPlanEquipo ACC_Cabecera_ordenes_crea por:  " + e);
        }finally{
            cnx.CerrarConexion(con);
        }
        return grupo;
    }

    public LinkedList<cabecera_ordenes_crea> ConsultaMatchOrdenmoav(String Cantid, String Orden, String DOrden) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        LinkedList<cabecera_ordenes_crea> cab = new LinkedList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.cabecera_ordenes_crea_ConsultahOrdenmoav(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, Cantid);
            pst.setString(2, Orden);
            pst.setString(3, DOrden);
            rs = pst.executeQuery();
            while (rs.next()) {
                cabecera_ordenes_crea c = new cabecera_ordenes_crea();
//                c.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                c.setFolio_sam(rs.getString("folio_sam"));
                c.setTexto_breve(rs.getString("texto_breve"));
                cab.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error ConsultaMatchGAR(ACC_GrupoArticulos) por: " + e);
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
        return cab;
    }

    public cabecera_ordenes_crea CargarDataCtrlSAM(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        cabecera_ordenes_crea coc = new cabecera_ordenes_crea();
        String query = "{call PM.Ordenes_CargarCtrlSAM(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setFecha(rs.getString("fecha"));
                coc.setUsuario(rs.getString("usuario"));
                coc.setFecha_ultima_modificacion(rs.getString("fecha_ultima_modificacion"));
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

        return coc;
    }

    public String ValidarUserOrd(String acre) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarUser(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, acre);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en ValidarUserOrd" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return check;
    }

}
