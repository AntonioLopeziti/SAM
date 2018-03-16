package AccesoDatos;

import Entidades.ClassDocumentos;
import Entidades.DmsDocs;
import Entidades.equipos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_Equipos {

    private static ACC_Equipos Instance = null;

    public static ACC_Equipos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Equipos();
        }
        return Instance;
    }

    public ArrayList ConsultarEquipoMatchOrd(String noEqui, String denominacion, String campoDen, String ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList eqs = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        equipos eq;
        String SP = "{CALL PM.Ordenes_ConsultarEquipo(?, ?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, noEqui);
            ps.setString(2, denominacion);
            ps.setString(3, campoDen);
            ps.setString(4, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                eq = new equipos();
                eq.setNum_equipo(rs.getString("num_equipo"));
                eq.setDenominacion_es(rs.getString(campoDen));
                eqs.add(eq);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultarEquipoMatchOrd por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eqs;
    }

    public static void main(String[] args) {
        System.out.println(ACC_Equipos.ObtenerInstancia().ConsultarEquipoMatchMOAV("1", "", "", "", ""));
    }
    public ArrayList<equipos> ConsultarEquipoop(){
        ArrayList<equipos> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.VisDocss_ConsultarEquipo()}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            rs = ps.executeQuery();
            while (rs.next()) {
                equipos e = new equipos();
                e.setNum_equipo(rs.getString("num_equipo"));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
        
    }
    
    public ArrayList<ClassDocumentos> ConsultarClasDocss(){
        ArrayList<ClassDocumentos> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.VisDocss_ConsultaClasDocTab()}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassDocumentos e = new ClassDocumentos();
                e.setClase_documento(rs.getString("clase_documento"));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
        
    }
    public ArrayList<ClassDocumentos> ConsultarClasDocsss( String v1){
        ArrayList<ClassDocumentos> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.VisDocss_ConsultaClasDocTabb(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, v1);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassDocumentos e = new ClassDocumentos();
                e.setClase_documento(rs.getString("clase_documento"));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
        
    }

    public ArrayList<DmsDocs> ConsultarNotili(){
        ArrayList<DmsDocs> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.VisDocss_ConsultarNumLo()}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs e = new DmsDocs();
                e.setNum_lote(rs.getString("num_lote"));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
        
    }
    public ArrayList<DmsDocs> ConsultarNotilii(String v1){
        ArrayList<DmsDocs> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.VisDocss_ConsultarNumLoo(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, v1);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs e = new DmsDocs();
                e.setNum_lote(rs.getString("num_lote"));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
        
    }
    public ArrayList<equipos> ConsultarEquipoopp(String v1){
        ArrayList<equipos> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.VisDocss_ConsultarEquipoo(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, v1);
            rs = ps.executeQuery();
            while (rs.next()) {
                equipos e = new equipos();
                e.setNum_equipo(rs.getString("num_equipo"));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
        
    }
    public ArrayList<equipos> ConsultarEquipoMC(String Eq, String Des, String DenIdioma, String Ctd) {
        ArrayList<equipos> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.EquiposDM_ConsultarEquipo(?,?,?,?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, Eq);
            ps.setString(2, Des);
            ps.setString(3, DenIdioma);
            ps.setString(4, Ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                equipos e = new equipos();
                e.setNum_equipo(rs.getString("num_equipo"));
                e.setDescripcion_equipo(rs.getString(DenIdioma));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
    }

    public equipos GetObjtNOTPM(String eq, String lan) {
        equipos equ = new equipos();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "select * from PM.equipos where num_equipo ='" + eq + "'";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                equ.setDescripcion_equipo(rs.getString("denominacion_" + lan));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        con.CerrarConexion(conn);
        return equ;
    }

    public equipos CargarDMEquipos(String Equipo, String den, String desMat) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        equipos eq = new equipos();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Proc = "{CALL PM.EquiposDM_CargarDatosequipos(?)}";
        try {

            ps = conn.prepareStatement(Proc);
            ps.setString(1, Equipo);
            rs = ps.executeQuery();

            while (rs.next()) {
                eq.setId_equipo(rs.getInt("id_equipo"));
                eq.setId_ubitec(rs.getString("id_ubitec"));
                eq.setNum_equipo(rs.getString("num_equipo"));
                eq.setDescripcion_equipo(rs.getString(den));
                eq.setTipo_equipo(rs.getString("tipo_equipo"));
                eq.setTipo_objtecnico(rs.getString("tipo_objtecnico"));
                eq.setGrupo_autorizaciones(rs.getString("grupo_autorizaciones"));
                eq.setPais_fabricacion(rs.getString("pais_fabricacion"));
                eq.setFabricante_activofijo(rs.getString("fabricante_activofijo"));
                eq.setDenominacion_tipofabri(rs.getString("denominacion_tipofabri"));
                eq.setNum_material_porpiezafabri(rs.getString("num_material_porpiezafabri"));
                eq.setSerie_segunfabri(rs.getString("serie_segunfabri"));
                eq.setAno_construccion(rs.getString("ano_construccion"));
                eq.setMes_construccion(rs.getString("mes_construccion"));
                eq.setCentro_emplazamiento(rs.getString("centro_emplazamiento"));
                eq.setEmplazamiento_activofijo(rs.getString("emplazamiento_activofijo"));
                eq.setArea_empresa(rs.getString("area_empresa"));
                eq.setCampo_clasificacion(rs.getString("campo_clasificacion"));
                eq.setSociedad(rs.getString("sociedad"));
                eq.setNum_activofijo_vehiculo(rs.getString("num_activofijo_vehiculo"));
                eq.setCentro_coste(rs.getString("centro_coste"));
                eq.setCentro_plani_mante(rs.getString("centro_plani_mante"));
                eq.setPuesto_responsable_medmnte(rs.getString("puesto_responsable_medmante"));
                eq.setNombre_respo_anaobj(rs.getString("nombre_respo_anaobj"));
                eq.setId_obj_puestotraba(rs.getString("id_obj_puestotraba"));
                eq.setMaterial(rs.getString("material"));
                eq.setDescripcion_material(rs.getString(desMat));
                eq.setSerie(rs.getString("serie"));
                eq.setTipo_stock_movimerca(rs.getString("tipo_stock_movimerca"));
                eq.setCentro(rs.getString("centro"));
                eq.setAlmacen(rs.getString("almacen"));
                eq.setLote(rs.getString("lote"));
                eq.setIndicador_stock_especial(rs.getString("indicador_stock_especial"));
                eq.setNum_deudor(rs.getString("num_deudor"));
                eq.setProveedor(rs.getString("proveedor"));
                eq.setFecha_ulti_movimerca(rs.getString("fecha_ulti_movimerca"));
                eq.setPrimera_entrada(rs.getString("primera_entrada"));
                eq.setPunto_medida(rs.getString("punto_medida"));
                eq.setUnidad_medida_punto(rs.getString("unidad_medida_punto"));
                eq.setEquipo_superior(rs.getString("equipo_superior"));
                eq.setGrupo_planificador(rs.getString("grupo_planificador"));
                eq.setIndicador_abc(rs.getString("indicador_abc"));
                eq.setCentro_puesto_trabajo(rs.getString("centro_puesto_trabajo"));
                eq.setLote_maestro(rs.getString("lote_maestro"));
            }
        } catch (Exception e) {
            System.err.println("Error en CargarDMEquipos por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return eq;
    }

    public String getExisNumEqui(String equi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();

        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarNumE(?)}";
        String check = "";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, equi);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);

            cnx.CerrarConexion(con);
            while (rs.next()) {
                check = rs.getString("num_equipo");
            }
        } catch (Exception e) {
            System.err.println("Error en DecimalUnidadMedida" + e);
        }
        return check;
    }

    
    
    
    
    
    public String[] DataMatchEquipoOrdenes(String numEqui) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String[] response = new String[10];
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarNumEquipo(?)}";
        String check;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, numEqui);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (check.equals("x")) {
                response[0] = "x";
            } else {
                response[0] = checkNull(rs.getString("id_ubitec"));
                response[1] = checkNull(rs.getString("centro_plani_mante"));
                response[2] = checkNull(rs.getString("puesto_responsable_medmante"));
                response[3] = checkNull(rs.getString("clave_grupo_hojaruta"));
                response[4] = checkNull(rs.getString("contador_grupo_hojaruta"));
                response[5] = checkNull(rs.getString("lista_materiales"));
                response[6] = checkNull(rs.getString("alternativa_listamaterial"));
                response[7] = checkNull(rs.getString("tipo_listamaterial"));
            }

        } catch (Exception ex) {
            System.err.println("Error en el metodo DataMatchEquipoOrdenes(ACC_Equipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return response;
    }

    public String checkNull(String data) {
        if (data.equals("null")) {
            data = "";
        } else {

        }
        return data;
    }

    public int ConsultaEquipos(String id) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        int res = 0;
        String query = "{call PM.equipos_ConsultaEquipos(?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                equipos equ = new equipos();
                equ.setNum_equipo(rs.getString("num_equipo"));
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
    ///BETO acc_equipos   

    /*Crear-Modificar Avisos*/
    public LinkedList<equipos> AvisoEquipos(String query, String denominacion) {
        LinkedList<equipos> e = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                equipos q = new equipos();
                q.setNum_equipo(rs.getString("num_equipo"));
                q.setDenominacion_es(rs.getString(denominacion));
                e.add(q);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo AvisoEquipos (ACC_Equipos)por: " + ex);
        }
        cnx.CerrarConexion(con);
        return e;
    }

    /*----------------------*/
    public int ValidarNumEquipo(String equi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT num_equipo FROM PM.equipos WHERE num_equipo='" + equi + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String e = rs.getString("num_equipo");
                if (e.equals(equi)) {
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

    public equipos ConsultaEquipoCrearAvisos(String equipo) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        equipos eq = new equipos();
        ResultSet rs = null;
        CallableStatement pst = null;
        String query = "{call PM.equipos_ConsultaEquipoCrearAvisos(?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, equipo);
            rs = pst.executeQuery();

            while (rs.next()) {
                eq.setNum_equipo(rs.getString("num_equipo"));
                eq.setId_ubitec(rs.getString("id_ubitec"));
                eq.setCentro_plani_mante(rs.getString("centro_plani_mante"));
                eq.setPuesto_responsable_medmnte(rs.getString("puesto_responsable_medmante"));
                eq.setGrupo_planificador(rs.getString("grupo_planificador"));
                eq.setCentro_puesto_trabajo(rs.getString("centro_puesto_trabajo"));
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
                System.err.println("Error :" + e);
            }
        }
        return eq;
    }

    public LinkedList<equipos> AvisoEquiposMatch(String ctdmax, String equipo, String de, String denominacion) {
        LinkedList<equipos> e = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.equipos_AvisoEquiposMatch(?,?,?,?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, ctdmax);
            pst.setString(2, equipo);
            pst.setString(3, de);
            pst.setString(4, denominacion);
            rs = pst.executeQuery();
            while (rs.next()) {
                equipos q = new equipos();
                q.setNum_equipo(rs.getString("num_equipo"));
                q.setDenominacion_es(rs.getString(de));
                e.add(q);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo AvisoEquipos (ACC_Equipos)por: " + ex);
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
        return e;
    }

    public ArrayList<equipos> SP_MatchEquiposListaorden(String Cant, String Idioma, String Equipo, String denEq) {
        ArrayList<equipos> sp_equipos = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.MatchEquiposListaorden(?,?,?,?)}";
        String denominacion = "denominacion_" + Idioma;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Cant);
            pst.setString(2, Idioma);
            pst.setString(3, Equipo);
            pst.setString(4, denEq);
            rs = pst.executeQuery();
            while (rs.next()) {
                equipos eq = new equipos();
                eq.setNum_equipo(rs.getString("num_equipo"));
                eq.setDenominacion(rs.getString(denominacion));
                sp_equipos.add(eq);
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

        return sp_equipos;
    }
    public LinkedList<equipos> ConsultarEquipoMatchMOAV(String Cantid, String des, String Equipo, String DEquipo, String Ubicac) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        LinkedList<equipos> equi = new LinkedList<>();
        PreparedStatement pst = null;
        String query = "{call PM.equipos_ConsultarEquipoMatchMOAV(?,?,?,?,?)}";
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, Cantid);
            pst.setString(2, des);
            pst.setString(3, Equipo);
            pst.setString(4, DEquipo);
            pst.setString(5, Ubicac);
            rs = pst.executeQuery();
            while (rs.next()) {
                equipos equ = new equipos();
                equ.setNum_equipo(rs.getString("num_equipo"));
                equ.setDescripcion_equipo(rs.getString(des));
                equ.setId_ubitec(rs.getString("id_ubitec"));
                equi.add(equ);
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

    public equipos GetObjtNOTPMnoti(String eq, String lan) {
        equipos equ = new equipos();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.equipos_GetObjtNOTPM(?)}";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, eq);
            rs = pst.executeQuery();
            while (rs.next()) {
                equ.setDescripcion_equipo(rs.getString("denominacion_" + lan));
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
        return equ;
    }

    public equipos CargarDMEquiposNOT(String eq, String lan) {
        equipos equ = new equipos();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.EQUIPOSNOTIFICACIONESCONS(?)}";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            pst = conn.prepareStatement(query);
            pst.setString(1, eq);
            rs = pst.executeQuery();
            while (rs.next()) {
                equ.setDescripcion_equipo(rs.getString("denominacion_" + lan));
                equ.setCentro(rs.getString("centro"));
                equ.setAlmacen(rs.getString("almacen"));
                equ.setLote(rs.getString("lote"));
                equ.setEquipo_superior(rs.getString("equipo_superior"));
                equ.setMaterial(rs.getString("material"));
                equ.setSerie(rs.getString("serie"));
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
        return equ;
    }

    public String ObtenerDes(String equipo, String denidio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String des = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PM.Boomequipo_ObtenerDescripcionEquipo(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo);
            ps.setString(2, denidio);
            rs = ps.executeQuery();
            while (rs.next()) {
                des = rs.getString(denidio);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return des;
    }    
    public String ObtenerDesByM(String comp, String idi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String des = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PM.VisualizarBomEdescByM(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, comp);
            ps.setString(2, idi);
            rs = ps.executeQuery();
            while (rs.next()) {
                des = rs.getString("descripcion_"+idi);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return des;
    }

    public equipos CargarDataEmplazamientoSAM(String equi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        equipos coc = new equipos();
        String query = "{call PM.Ordenes_CargarEmplSAMequi(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, equi);
            rs = pst.executeQuery();
            while (rs.next()) {
                coc.setCentro_emplazamiento(rs.getString("centro_emplazamiento"));
                coc.setEmplazamiento_activofijo(rs.getString("emplazamiento_activofijo"));
                coc.setArea_empresa(rs.getString("area_empresa"));
                coc.setPuesto_responsable_medmnte(rs.getString("puesto_responsable_medmante"));
                coc.setIndicador_abc(rs.getString("indicador_abc"));
                coc.setCampo_clasificacion(rs.getString("campo_clasificacion"));
                coc.setSociedad(rs.getString("sociedad"));
                coc.setNum_activofijo_vehiculo(rs.getString("num_activofijo_vehiculo"));
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
    public ArrayList<DmsDocs> ConsultarAvisosVisDoc(){
        ArrayList<DmsDocs> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.VisDocss_ConsultarAvisoDoc()}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs e = new DmsDocs();
                if(!rs.getString("num_notificacion").equals("")){
                    e.setNum_notificacion(rs.getString("num_notificacion"));
                    eq.add(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
        
    }
    public ArrayList<DmsDocs> ConsultarAvisosVisDocc(String v1){
        ArrayList<DmsDocs> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PM.VisDocss_ConsultarAvisoDocc(?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, v1);
            rs = ps.executeQuery();
            while (rs.next()) {
                DmsDocs e = new DmsDocs();
                e.setNum_notificacion(rs.getString("num_notificacion"));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
        
    }
    
    public ArrayList<equipos> ConsultarEquipoMCPP(String Mate, String Des, String DenIdioma, String Ctd) {
        ArrayList<equipos> eq = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String pr = "{CALL PP.MaterialesHR_ConsultarMate(?,?,?,?)}";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(pr);
            ps.setString(1, Mate);
            ps.setString(2, Des);
            ps.setString(3, DenIdioma);
            ps.setString(4, Ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                equipos e = new equipos();
                e.setNum_equipo(rs.getString("num_equipo"));
                e.setDescripcion_equipo(rs.getString(DenIdioma));
                eq.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error en ConsultarEquipoMC por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return eq;
    }
    
    public String ObtenerDesPP(String equipo, String denidio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String des = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PP.BoomEquipo_ObtenerDescripcionEquipoPP(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo);
            ps.setString(2, denidio);
            rs = ps.executeQuery();
            while (rs.next()) {
                des = rs.getString(denidio);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return des;
    }
    
    public String ObtenerDesByMPP(String comp, String idi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String des = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PP.VisualizarBomEdescByMPP(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, comp);
            ps.setString(2, idi);
            rs = ps.executeQuery();
            while (rs.next()) {
                des = rs.getString("descripcion_"+idi);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return des;
    }
    
    public int ConsultaEquiposPP(String id) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        int res = 0;
        String query = "{call PP.equipos_ConsultaEquiposPP(?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                equipos equ = new equipos();
                equ.setNum_equipo(rs.getString("num_equipo"));
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
//    public ArrayList<equipos> ConsultarEquipoopp(String v1){
//        ArrayList<equipos> eq = new ArrayList<>();
//        Conexion cnx = new Conexion();
//        Connection con = cnx.ObtenerConexion();
//        String pr = "{CALL PM.VisDocss_ConsultarEquipoo(?)}";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = con.prepareStatement(pr);
//            ps.setString(1, v1);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                equipos e = new equipos();
//                e.setNum_equipo(rs.getString("num_equipo"));
//                eq.add(e);
//            }
//        } catch (Exception e) {
//            System.out.println("Error en ConsultarEquipoMC por: " + e);
//        } finally {
//            cnx.CerrarConexion(con);
//        }
//        return eq;
//        
//    }
public String[] DataMatchEquipoOrdenesPP(String numEqui) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String[] response = new String[10];
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PM.Ordenes_ValidarNumEquipo(?)}";
        String check;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, numEqui);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (check.equals("x")) {
                response[0] = "x";
            } else {
                response[0] = checkNull(rs.getString("id_ubitec"));
                response[1] = checkNull(rs.getString("centro_plani_mante"));
                response[2] = checkNull(rs.getString("puesto_responsable_medmante"));
                response[3] = checkNull(rs.getString("clave_grupo_hojaruta"));
                response[4] = checkNull(rs.getString("contador_grupo_hojaruta"));
                response[5] = checkNull(rs.getString("lista_materiales"));
                response[6] = checkNull(rs.getString("alternativa_listamaterial"));
                response[7] = checkNull(rs.getString("tipo_listamaterial"));
            }

        } catch (Exception ex) {
            System.err.println("Error en el metodo DataMatchEquipoOrdenes(ACC_Equipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return response;
    }
}
