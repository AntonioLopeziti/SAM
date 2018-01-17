package AccesoDatos;

import Entidades.ubicacion_tecnica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_UbicacionTecnica {

    private static ACC_UbicacionTecnica Instance = null;

    public static ACC_UbicacionTecnica ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_UbicacionTecnica();
        }
        return Instance;
    }

    //MUESTRA MATCH CON LIMITE
    public ArrayList<ubicacion_tecnica> MatchUbicacionesTec(ubicacion_tecnica ut, int limite, String deno) {
        ArrayList<ubicacion_tecnica> ubitec = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("{CALL PM.UbicacionesTecnica_MatchUbicaciones(?, ?, ?, ?)}");
            ps.setInt(1, limite);
            ps.setString(2, ut.getUbicacion_tecnica());
            ps.setString(3, deno);
            ps.setString(4, ut.getDenominacion());
            rs = ps.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica ub = new ubicacion_tecnica();
                ub.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ub.setDenominacion(rs.getString(deno));
                ubitec.add(ub);
            }
        } catch (Exception e) {
            System.err.println("Error match Ubicaciones Tec: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ubitec;
    }

    //MUESTRA MATCH SIN LIMITE Y LOS DEMAS CAMPOS EN BLANCO
    public ArrayList<ubicacion_tecnica> MatchAllUbiTec(ubicacion_tecnica ut, String deno) {
        ArrayList<ubicacion_tecnica> ubitec = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("{CALL PM.UbicacionesTecnica_MatchAll(?, ?, ?)}");
            ps.setString(1, ut.getUbicacion_tecnica());
            ps.setString(2, ut.getDenominacion());
            ps.setString(3, deno);
            rs = ps.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica ub = new ubicacion_tecnica();
                ub.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ub.setDenominacion(rs.getString(deno));
                ubitec.add(ub);
            }
        } catch (Exception e) {
            System.err.println("Error match Ubicaciones Tec: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ubitec;

    }
    public ArrayList<ubicacion_tecnica> MatchAllUbiTecc() {
        ArrayList<ubicacion_tecnica> ubitec = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("{CALL PM.UbicacionesTecnica_MatchAlll()}");
            rs = ps.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica ub = new ubicacion_tecnica();
                ub.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ub.setDenominacion(rs.getString("denominacion_ES"));
                ubitec.add(ub);
            }
        } catch (Exception e) {
            System.err.println("Error match Ubicaciones Tec: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ubitec;

    }

    //CARGA TODOS LOS DATOS DE LA UBICACION SELECCIONADA
    public ubicacion_tecnica CargarDatosUbiTec(String ubi, String deno) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ubicacion_tecnica u = new ubicacion_tecnica();
        try {
            ps = con.prepareCall("{CALL PM.UbicacionTecnica_CargarAllDatos (?)}");
            ps.setString(1, ubi);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                u.setDenominacion(rs.getString(deno));
                u.setCentro_planificacion_mante(rs.getString("centro_planificacion_mante"));
                u.setGrupo_autorizacion(rs.getString("grupo_autorizacion"));
                u.setCentro_emplazamiento(rs.getString("centro_emplazamiento"));
                u.setEmplazamiento_activo_fijo(rs.getString("emplazamiento_activo_fijo"));
                u.setArea_empresa(rs.getString("area_empresa"));
                u.setSociedad(rs.getString("sociedad"));
                u.setCentro_coste(rs.getString("centro_coste"));
                u.setGrupo_planificador_servicio_cliente_mante(rs.getString("grupo_planificador_servicio_cliente_mante"));
                u.setPuesto_trabajo(rs.getString("puesto_trabajo"));
            }
        } catch (Exception e) {
            System.err.println("Error de todos los datos: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return u;
    }

    public ubicacion_tecnica CargarDatosUbicaicon(String query, String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ubicacion_tecnica u = new ubicacion_tecnica();
        try {
            ps = con.prepareCall("{CALL  PM.avisos_ConsultaUBitec1(?)}");
            ps.setString(1, query);
            rs = ps.executeQuery();
            while (rs.next()) {

                u.setId_ut(rs.getInt("id_ut"));
                u.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                u.setDenominacion(rs.getString(des));
                u.setCentro_planificacion_mante(rs.getString("centro_planificacion_mante"));
                u.setIndicador_estructura_ubitec(rs.getString("indicador_estructura_ubitec"));
                u.setGrupo_autorizacion(rs.getString("grupo_autorizacion"));
                u.setPais_fabricacion(rs.getString("pais_fabricacion"));
                u.setDenominacion_tipo_fabricacion(rs.getString("denominacion_tipo_fabricacion"));
                u.setNum_pieza_fabricante(rs.getString("num_pieza_fabricante"));
                u.setNum_serie_segun_fabricante(rs.getString("num_serie_segun_fabricante"));
                u.setAno_construccion(rs.getString("ano_construccion"));
                u.setCentro_emplazamiento(rs.getString("centro_emplazamiento"));
                u.setEmplazamiento_activo_fijo(rs.getString("emplazamiento_activo_fijo"));
                u.setArea_empresa(rs.getString("area_empresa"));
                u.setCampo_clasificacion(rs.getString("campo_clasificacion"));
                u.setSociedad(rs.getString("sociedad"));
                u.setCentro_coste(rs.getString("centro_coste"));
                u.setGrupo_planificador_servicio_cliente_mante(rs.getString("grupo_planificador_servicio_cliente_mante"));
                u.setId_obj_puesto_trabajo(rs.getString("id_obj_puesto_trabajo"));
                u.setMontaje_equipos_permitido_ubitec(rs.getString("montaje_equipos_permitido_ubitec"));
                u.setMontaje_individual_equipo_ubitec(rs.getString("montaje_individual_equipo_ubitec"));
                u.setIdobj_puesto_trabajo_pps(rs.getString("idobj_puesto_trabajo_pps"));
                u.setPuesto_trabajo(rs.getString("puesto_trabajo"));
            }
        } catch (Exception e) {
            System.err.println("Error de todos los datos: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return u;
    }

    public int ConsultaUbicaciones(String ubi) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ubicaciones_tecnicas_ConsultaUbicaciones(?)}";
        int res = 0;
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, ubi);
            rs = pst.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica p = new ubicacion_tecnica();
                p.setUbicacion_tecnica(
                        rs.getString("ubicacion_tecnica"));
                res = 1;
            }

        } catch (Exception ex) {
            System.err.println("Error:" + ex);
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
            } catch (Exception a) {
                System.err.println("Error :" + a);
            }
        }
        return res;

    }

    public LinkedList<ubicacion_tecnica> AvisoUbicacion(String query, String denominacion) {
        Conexion cnx = new Conexion();
        LinkedList<ubicacion_tecnica> ubi = new LinkedList<>();
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ubicacion_tecnica u = new ubicacion_tecnica();
                u.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                u.setDenominacion(rs.getString(denominacion));
                u.setSociedad(rs.getString("sociedad"));
                ubi.add(u);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo AvisoUbicacion (ACC_UbicacionTecnica)por: " + ex);
        }
        return ubi;
    }

//    public LinkedList<ubicacion_tecnica> ConsultarUbiTMatch(String query, String des) {
//        Conexion cnx = new Conexion();
//        LinkedList<ubicacion_tecnica> ubiT = new LinkedList<>();
//        try {
//            Connection con = cnx.ObtenerConexion();
//            Statement st;
//            ResultSet rs;
//            st = cnx.ObtenerConexion().createStatement();
//            rs = st.executeQuery(query);
//            while (rs.next()) {
//                ubicacion_tecnica ub = new ubicacion_tecnica();
//                ub.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
//                ub.setDenominacion(rs.getString(des));
//                ubiT.add(ub);
//            }
//            cnx.CerrarConexion(con);
//        } catch (Exception e) {
//            System.err.println("Error: " + e);
//        }
//        return ubiT;
//    }
    public ArrayList ConsultarUbiTMatchOrd(String ubiT, String denominacion, String campoDen, String ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList ubis = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        ubicacion_tecnica ub;
        String SP = "{CALL PM.Ordenes_ConsultarUbicacionTecnica(?, ?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, ubiT);
            ps.setString(2, denominacion);
            ps.setString(3, campoDen);
            ps.setString(4, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                ub = new ubicacion_tecnica();
                ub.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ub.setDenominacion(rs.getString(campoDen));
                ubis.add(ub);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ubis;
    }

    public int ValidarUbicacionTecnica(String ubiT) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT ubicacion_tecnica FROM ubicaciones_tecnicas WHERE ubicacion_tecnica='" + ubiT + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String ub = rs.getString("ubicacion_tecnica");
                if (ub.equals(ubiT)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultarCentros (ACC_Centro) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }

    public LinkedList<ubicacion_tecnica> AvisoUbicacionMatch(String ctdmax, String ubitec, String deno, String descr, String sociedad) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        LinkedList<ubicacion_tecnica> ubi = new LinkedList<>();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ubicaciones_tecnicas_AvisoUbicacion(?,?,?,?,?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, ctdmax);
            pst.setString(2, ubitec);
            pst.setString(3, deno);
            pst.setString(4, descr);
            pst.setString(5, sociedad);
            rs = pst.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica u = new ubicacion_tecnica();
                u.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                u.setDenominacion(rs.getString(deno));
                u.setSociedad(rs.getString("sociedad"));
                ubi.add(u);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo AvisoUbicacion (ACC_UbicacionTecnica)por: " + ex);
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
        return ubi;
    }

    public LinkedList<ubicacion_tecnica> ConsultaUbicacionesTec(String query, String des) {
        Conexion cnx = new Conexion();
        LinkedList<ubicacion_tecnica> UbicTec = new LinkedList<ubicacion_tecnica>();
        try {
            Connection con = cnx.ObtenerConexion();
            Statement st;
            ResultSet rs;

            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ubicacion_tecnica u = new ubicacion_tecnica();
                u.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                u.setDenominacion(rs.getString(des));
                u.setCentro_planificacion_mante(rs.getString("centro_planificacion_mante"));
                UbicTec.add(u);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
        }
        return UbicTec;
    }

    public LinkedList<ubicacion_tecnica> ConsultaUbicacionesTecAM(String Cantid, String Ubicac, String desUb, String DUbica, String Centro) {
        Conexion con = new Conexion();
        LinkedList<ubicacion_tecnica> UbicTec = new LinkedList<>();
        PreparedStatement pst = null;
        String query = "{call PM.ubicaciones_tecnicas_ConsultaUbicacionesTecAM(?,?,?,?,?)}";
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, Cantid);
            pst.setString(2, Ubicac);
            pst.setString(3, desUb);
            pst.setString(4, DUbica);
            pst.setString(5, Centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica u = new ubicacion_tecnica();
                u.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                u.setDenominacion(rs.getString(desUb));
                u.setCentro_planificacion_mante(rs.getString("centro_planificacion_mante"));
                UbicTec.add(u);
            }
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
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
        return UbicTec;
    }

    public static void main(String[] args) {

        System.out.println(ACC_UbicacionTecnica.ObtenerInstancia().ConsultaUbicacionesTecAM("1", "", "denominacion_ES", "", ""));

//        ubicacion_tecnica ub = ACC_UbicacionTecnica.ObtenerInstancia().CargarDatosUbiTec("BAJA-DK1-AAEE", "denominacion_ES");
//        if (ub.getUbicacion_tecnica() == "" || ub.getUbicacion_tecnica() == null) {
//            System.out.println("NO HAY");
//        } else {
//            System.out.println(ub.getUbicacion_tecnica());
//        }
//    System.out.println(ACC_UbicacionTecnica.ObtenerInstancia().ValidarCentroCoste("BF01010203"));
    }

    public ArrayList<ubicacion_tecnica> SP_MatchUbitecListaorden(String limite, String Idioma, String Ubicacion, String DUbicacion) {
        ArrayList<ubicacion_tecnica> sp_ubitec = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.MatchUbitecListaorden(?,?,?,?)}";
        String denominacion = "denominacion_" + Idioma;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, limite);
            pst.setString(2, Idioma);
            pst.setString(3, Ubicacion);
            pst.setString(4, DUbicacion);
            rs = pst.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica ord = new ubicacion_tecnica();
                ord.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ord.setDenominacion(rs.getString(denominacion));
                sp_ubitec.add(ord);
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

        return sp_ubitec;
    }

    public ubicacion_tecnica CargarDataEmplazamientoSAMubi(String equi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ubicacion_tecnica coc = new ubicacion_tecnica();
        String query = "{call PM.Ordenes_CargarEmplSAMubi(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, equi);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setCentro_emplazamiento(rs.getString("centro_emplazamiento"));
                coc.setEmplazamiento_activo_fijo(rs.getString("emplazamiento_activo_fijo"));
                coc.setArea_empresa(rs.getString("area_empresa"));
                coc.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                coc.setIndicador_abc(rs.getString("indicador_abc"));
                coc.setCampo_clasificacion(rs.getString("campo_clasificacion"));
                coc.setSociedad(rs.getString("sociedad"));
                coc.setCentro_coste(rs.getString("centro_coste"));
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
    public boolean InsertaUbTecPP(ubicacion_tecnica ub){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL PP.UbicacionesTecnicas_InsertUbTec(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, ub.getUbicacion_tecnica());
            ps.setString(2, ub.getGrupo_autorizacion());
            ps.setString(3, ub.getNum_inventario());
            ps.setString(4, ub.getTamano_dimension());
            ps.setString(5, ub.getCentro_emplazamiento());
            ps.setString(6, ub.getEmplazamiento_activo_fijo());
            ps.setString(7, ub.getArea_empresa());
            ps.setString(8, ub.getPuesto_trabajo());
            ps.setString(9, ub.getIndicador_abc());
            ps.setString(10, ub.getCentro_coste());
            ps.setString(11, ub.getSociedad());
            ps.setString(12, ub.getCentro_planificacion_mante());
            ps.setString(13, ub.getGrupo_planificador_servicio_cliente_mante());  
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        }catch (Exception e) {
            System.err.println("Error en InsertarProveedor por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    
    //MUESTRA MATCH SIN LIMITE Y LOS DEMAS CAMPOS EN BLANCO UBIC TEC PP
    public ArrayList<ubicacion_tecnica> MatchAllUbiTecPP(ubicacion_tecnica ut, String deno) {
        ArrayList<ubicacion_tecnica> ubitec = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("{CALL PP.UbicacionesTecnica_MatchAll(?, ?, ?)}");
            ps.setString(1, ut.getUbicacion_tecnica());
            ps.setString(2, ut.getDenominacion());
            ps.setString(3, deno);
            rs = ps.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica ub = new ubicacion_tecnica();
                ub.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ub.setDenominacion(rs.getString(deno));
                ubitec.add(ub);
            }
        } catch (Exception e) {
            System.err.println("Error match Ubicaciones Tec: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ubitec;
    }
    
    //CARGA TODOS LOS DATOS DE LA UBICACION SELECCIONADA PP
    public ubicacion_tecnica CargarDatosUbiTecPP(String ubi, String deno) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ubicacion_tecnica u = new ubicacion_tecnica();
        try {
            ps = con.prepareCall("{CALL PP.UbicacionTecnica_CargarAllDatos (?)}");
            ps.setString(1, ubi);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                u.setDenominacion(rs.getString(deno));
                u.setCentro_planificacion_mante(rs.getString("centro_planificacion_mante"));
                u.setGrupo_autorizacion(rs.getString("grupo_autorizacion"));
                u.setCentro_emplazamiento(rs.getString("centro_emplazamiento"));
                u.setEmplazamiento_activo_fijo(rs.getString("emplazamiento_activo_fijo"));
                u.setArea_empresa(rs.getString("area_empresa"));
                u.setSociedad(rs.getString("sociedad"));
                u.setCentro_coste(rs.getString("centro_coste"));
                u.setGrupo_planificador_servicio_cliente_mante(rs.getString("grupo_planificador_servicio_cliente_mante"));
                u.setPuesto_trabajo(rs.getString("puesto_trabajo"));
            }
        } catch (Exception e) {
            System.err.println("Error de todos los datos: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return u;
    }
    
    //MUESTRA MATCH CON LIMITE UBIC TEC PP
    public ArrayList<ubicacion_tecnica> MatchUbicacionesTecPP(ubicacion_tecnica ut, int limite, String deno) {
        ArrayList<ubicacion_tecnica> ubitec = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("{CALL PP.UbicacionesTecnica_MatchUbicaciones(?, ?, ?, ?)}");
            ps.setInt(1, limite);
            ps.setString(2, ut.getUbicacion_tecnica());
            ps.setString(3, deno);
            ps.setString(4, ut.getDenominacion());
            rs = ps.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica ub = new ubicacion_tecnica();
                ub.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ub.setDenominacion(rs.getString(deno));
                ubitec.add(ub);
            }
        } catch (Exception e) {
            System.err.println("Error match Ubicaciones Tec: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ubitec;
    }
    // VISUALIZA UBICACIONES TECNICAS MONITOR PP
    public LinkedList<ubicacion_tecnica> AvisoUbicacionMatchPP(String ctdmax, String ubitec, String deno, String descr, String sociedad) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        LinkedList<ubicacion_tecnica> ubi = new LinkedList<>();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ubicaciones_tecnicas_AvisoUbicacionPP(?,?,?,?,?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, ctdmax);
            pst.setString(2, ubitec);
            pst.setString(3, deno);
            pst.setString(4, descr);
            pst.setString(5, sociedad);
            rs = pst.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica u = new ubicacion_tecnica();
                u.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                u.setDenominacion(rs.getString(deno));
                u.setSociedad(rs.getString("sociedad"));
                ubi.add(u);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo AvisoUbicacion (ACC_UbicacionTecnica)por: " + ex);
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
        return ubi;
    }
    
    public int ConsultaUbicacionesPP(String ubi) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ubicaciones_tecnicas_ConsultaUbicacionesPP(?)}";
        int res = 0;
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, ubi);
            rs = pst.executeQuery();
            while (rs.next()) {
                ubicacion_tecnica p = new ubicacion_tecnica();
                p.setUbicacion_tecnica(
                        rs.getString("ubicacion_tecnica"));
                res = 1;
            }

        } catch (Exception ex) {
            System.err.println("Error:" + ex);
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
            } catch (Exception a) {
                System.err.println("Error :" + a);
            }
        }
        return res;

    }
    
    //Modificar Ubicaciones Tecnicas PP
    public boolean ModUbTecPP(ubicacion_tecnica ub){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL PP.UbicacionesTecnicas_ModificarUbTec(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, ub.getUbicacion_tecnica());
            ps.setString(2, ub.getGrupo_autorizacion());
            ps.setString(3, ub.getNum_inventario());
            ps.setString(4, ub.getTamano_dimension());
            ps.setString(5, ub.getCentro_emplazamiento());
            ps.setString(6, ub.getEmplazamiento_activo_fijo());
            ps.setString(7, ub.getArea_empresa());
            ps.setString(8, ub.getPuesto_trabajo());
            ps.setString(9, ub.getIndicador_abc());
            ps.setString(10, ub.getCentro_coste());
            ps.setString(11, ub.getSociedad());
            ps.setString(12, ub.getCentro_planificacion_mante());
            ps.setString(13, ub.getGrupo_planificador_servicio_cliente_mante());  
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        }catch (Exception e) {
            System.err.println("Error en InsertarProveedor por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
}
