/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.CabeceraAviso;
import Entidades.actividadesavisos;
import Entidades.areatexto;
import Entidades.aviso;
import Entidades.avisossap_modificados;
import Entidades.centros;
import Entidades.grupo_planificacion;
import Entidades.puesto_trabajo;
import Entidades.ubicacion_tecnica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class ACC_Aviso {

    Conexion cnx = new Conexion();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_Aviso Instance = null;

    public static ACC_Aviso ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Aviso();
        }
        return Instance;
    }

    public boolean ValidarAvis(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarAvis ACC_Aviso por:" + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public LinkedList<aviso> ConsultaMatchAviso(String query) {
        LinkedList<aviso> AvMatch = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                aviso ao = new aviso();
                ao.setNum_notificacion(rs.getString("num_notificacion"));
                ao.setFolio_sam(rs.getString("folio_sam"));
                ao.setDescripcion(rs.getString("descripcion"));
                AvMatch.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en ConsultaMatchAviso ACC_Aviso por: " + ex);
        }
        cnx.CerrarConexion(con);
        return AvMatch;
    }

    public LinkedList<aviso> ConsultaMatchAviso2(String query) {
        LinkedList<aviso> AvMatch = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                aviso ao = new aviso();
                ao.setNum_notificacion(rs.getString("num_notificacion"));
                ao.setFolio_sam(rs.getString("folio_sam"));
                ao.setDescripcion(rs.getString("descripcion"));
                AvMatch.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en ConsultaMatchAviso ACC_Aviso por: " + ex);
        }
        cnx.CerrarConexion(con);;

        return AvMatch;
    }

    public LinkedList<aviso> ConsultaMatchAviso1() {
        LinkedList<aviso> AvMatch = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        CallableStatement pst = null;
        String query = "{call PM.avisos_ConsultaMatchAviso1}";
        try {
            pst = conn.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                aviso ao = new aviso();
                ao.setClase_aviso(rs.getString("clase_aviso"));
                AvMatch.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en ConsultaMatchAviso ACC_Aviso por: " + ex);
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
        return AvMatch;
    }

    public boolean ValidarAviso(String Id) {
        query = "SELECT num_notificacion FROM  avisos WHERE num_notificacion='" + Id + "'";
        try {
            st = cnx.ObtenerConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String avi = rs.getString("num_notificacion");
                if (Id.equals(avi)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        cnx.CerrarConexion(cnx.ObtenerConexion());
        return false;
    }

    public aviso CargarAviso(String AVISOSAP) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        aviso av = new aviso();
        PreparedStatement pst = null;
        String query = "{call PM.aviso_CargarAviso(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, AVISOSAP);
            rs = pst.executeQuery();
            while (rs.next()) {
                av.setNum_notificacion(rs.getString("num_notificacion"));
                av.setClase_aviso(rs.getString("clase_aviso"));
                av.setDescripcion(rs.getString("descripcion"));
                av.setStatus_individual_breve_es(rs.getString("status_individual_breve_es"));
                av.setStatus_individual_obj_es(rs.getString("status_individual_obj_es"));
                av.setUbicación_tecnica(rs.getString("ubicación_tecnica"));
                av.setDenominacion_ubicacion_tecnica(rs.getString("denominacion_ubicacion_tecnica"));
                av.setNum_equipo(rs.getString("num_equipo"));
                av.setDenominacion_objeto_tecnico(rs.getString("denominacion_objeto_tecnico"));
                av.setConjunto(rs.getString("conjunto"));
                av.setGrupo_planificador_servicio_cliente_mante(rs.getString("grupo_planificador_servicio_cliente_mante"));
                av.setCentro_planificador_mante(rs.getString("centro_planificador_mante"));
                av.setNombre_grupo_plani_mante(rs.getString("nombre_grupo_plani_mante"));
                av.setPuesto_trabajo_responsable_medidas_mantenimiento(rs.getString("puesto_trabajo_responsable_medidas_mantenimiento"));
                av.setCentro(rs.getString("centro"));
                av.setTexto_breve_puesto_trabajo(rs.getString("texto_breve_puesto_trabajo"));
                av.setInterlocutor(rs.getString("interlocutor"));
                av.setNombre_visualizar_lista(rs.getString("nombre_visualizar_lista"));
                av.setInterlocutor2(rs.getString("interlocutor2"));
                av.setNombre_visualizar_lista2(rs.getString("nombre_visualizar_lista2"));
                av.setNombre_autor_aviso(rs.getString("nombre_autor_aviso"));
                av.setFecha_aviso(rs.getString("fecha_aviso"));
                av.setHora_aviso(rs.getString("hora_aviso"));
                av.setGrupo_codigo_codificacion(rs.getString("grupo_codigo_codificacion"));
                av.setTexto_breve(rs.getString("texto_breve"));
                av.setFolio_sam(rs.getString("folio_sam"));
            }
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception o) {
                System.out.println("Error: " + o);
            }
        }
        return av;
    }

    public LinkedList<areatexto> ConsultaArea(String AVISOSAP, String AVISOSAM) {
        LinkedList<areatexto> area = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.textos_avisos_ConsultaArea(?,?)}";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, AVISOSAP);
            pst.setString(2, AVISOSAM);
            rs = pst.executeQuery();
            while (rs.next()) {
                areatexto ar = new areatexto();
                ar.setTexto_accion(rs.getString("linea_texto"));
                area.add(ar);
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
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
        return area;
    }

    public LinkedList<actividadesavisos> ConsultaActividades(String AVISOSAP, String AVISOSAM) {
        LinkedList<actividadesavisos> acti = new LinkedList<actividadesavisos>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.avisos_actividades_ConsultaActividades(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, AVISOSAP);
            pst.setString(2, AVISOSAM);
            rs = pst.executeQuery();
            while (rs.next()) {
                actividadesavisos av = new actividadesavisos();
                av.setPosicion(rs.getString("num_posicion_registro_posicion"));
                av.setGrupo_codigo(rs.getString("grupo_codigo_acciones"));
                av.setCodigo_medida(rs.getString("codigo_medida"));
                av.setTexto_codigo(rs.getString("descripcion_ES"));
                av.setTexto_accion(rs.getString("texto_accion"));
                av.setFactor_cantidad(rs.getString("factor_cantidad_acciones"));
                av.setFecha_inicio(rs.getString("fecha_inicio"));
                av.setHora_inicio(rs.getString("hora_inicio_accion"));
                av.setFecha_fin(rs.getString("fecha_fin"));
                av.setHora_fin(rs.getString("hora_fin_accion"));
                av.setNum_actividad(rs.getString("num_actual_actividad"));
                acti.add(av);
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
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
        return acti;
    }

    public LinkedList<aviso> ConsultaMatchAvisosModVisual(String query) {
        LinkedList<aviso> avis = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            String q = query;
            while (rs.next()) {
                aviso a = new aviso();
                a.setNum_notificacion(rs.getString("num_notificacion"));
                a.setClase_aviso(rs.getString("clase_aviso"));
                a.setDescripcion(rs.getString("descripcion"));
                avis.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchAvisosModVisual (ACC_Aviso) " + e);
        }
        cnx.CerrarConexion(con);
        return avis;
    }

    public LinkedList<aviso> ConsultaLAvisoAvisos(String query) {
        LinkedList<aviso> AvMatch = new LinkedList<aviso>();
        try {
            st = cnx.ObtenerConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                aviso av = new aviso();
                av.setNum_notificacion(rs.getString("num_notificacion"));
                av.setClase_aviso(rs.getString("clase_aviso"));
                av.setDescripcion(rs.getString("descripcion"));
                av.setUbicación_tecnica(rs.getString("ubicación_tecnica"));
                av.setDenominacion_ubicacion_tecnica(rs.getString("denominacion_ubicacion_tecnica"));
                av.setNum_equipo(rs.getString("num_equipo"));
                av.setDenominacion_objeto_tecnico(rs.getString("denominacion_objeto_tecnico"));
                av.setConjunto(rs.getString("conjunto"));
                av.setGrupo_planificador_servicio_cliente_mante(rs.getString("grupo_planificador_servicio_cliente_mante"));
                av.setCentro_planificador_mante(rs.getString("centro_planificador_mante"));
                av.setNombre_grupo_plani_mante(rs.getString("nombre_grupo_plani_mante"));
                av.setPuesto_trabajo_responsable_medidas_mantenimiento(rs.getString("puesto_trabajo_responsable_medidas_mantenimiento"));
                av.setCentro(rs.getString("centro"));
                av.setTexto_breve_puesto_trabajo(rs.getString("texto_breve_puesto_trabajo"));
                av.setInterlocutor(rs.getString("interlocutor"));
                av.setNombre_visualizar_lista(rs.getString("nombre_visualizar_lista"));
                av.setInterlocutor2(rs.getString("interlocutor2"));
                av.setNombre_visualizar_lista2(rs.getString("nombre_visualizar_lista2"));
                av.setNombre_autor_aviso(rs.getString("nombre_autor_aviso"));
                av.setFecha_aviso(rs.getString("fecha_aviso"));
                av.setHora_aviso(rs.getString("hora_aviso"));
                av.setGrupo_codigo_codificacion(rs.getString("grupo_codigo_codificacion"));
                av.setTexto_breve(rs.getString("texto_breve"));
                av.setFolio_sam(rs.getString("folio_sam"));
                AvMatch.add(av);

            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
        }
        cnx.CerrarConexion(cnx.ObtenerConexion());
        return AvMatch;
    }

//****BETO acc_aviso
    public LinkedList<aviso> ObtenerAvisoByUsuario(String user) {
        LinkedList<aviso> av = new LinkedList<aviso>();
        //query = "SELECT * FROM avisos";
        query = "SELECT * FROM avisos WHERE usuario='" + user + "'";
        try {
            st = cnx.ObtenerConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                aviso a = new aviso();
                //  a.setNum_aviso(rs.getString("num_aviso"));
                //  a.setEquipo(rs.getString("equipo"));
                //  a.setId_ubitec(rs.getString("id_ubitec"));
                //  a.setCentro(rs.getString("centro"));
                //   a.setNum_ordenSAM(rs.getString("num_ordenSAM"));
                //   a.setNum_ordenSAP(rs.getString("num_ordenSAP"));
                av.add(a);

            }
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        cnx.CerrarConexion(cnx.ObtenerConexion());
        return av;
    }

    public aviso TenerAvisoOne(String id) {
        aviso avi = new aviso();
        query = "SELECT * FROM avisos WHERE num_notificacion='" + id + "'";
        try {
            st = cnx.ObtenerConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                avi.setNum_notificacion(rs.getString("num_notificacion"));
                avi.setClase_aviso(rs.getString("clase_aviso"));
                //  avi.setNum_aviso(rs.getString("num_aviso"));
                //    avi.setCarpeta(rs.getString("carpeta"));
                //    avi.setCentro(rs.getString("centro"));
                //    avi.setDescripcion_aviso(rs.getString("descripcion_aviso"));
                //    avi.setEquipo(rs.getString("equipo"));
                //    avi.setId_ubitec(rs.getString("id_ubitec"));
                //     avi.setNum_ordenSAM(rs.getString("num_ordenSAM"));
                //     avi.setNum_ordenSAP(rs.getString("num_ordenSAP"));

            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        cnx.CerrarConexion(cnx.ObtenerConexion());
        return avi;
    }

    public boolean ValidarClaseAvisoModVisual(String ClaseAviso) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM avisos where clase_aviso='" + ClaseAviso + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                String claseaviso = rs.getString("clase_aviso");
                if (claseaviso.equals(ClaseAviso)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }

            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarClaseAvisoModVisual (ACC_Aviso) por:" + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public boolean ValidarDescripcionModVisual(String Descripcion) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM avisos WHERE descripcion_aviso ='" + Descripcion + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String descripcion = rs.getString("descripcion_aviso");
                if (descripcion.equals(Descripcion)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarDescripcionModVisual (ACC_Aviso) por:" + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public boolean ValidarNotificacionModVisual(String Aviso) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * from avisos WHERE num_notificacion='" + Aviso + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String aviso = rs.getString("num_notificacion");
                if (aviso.equals(Aviso)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarNotificacionModVisual (ACC_Aviso) por:" + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public LinkedList<aviso> ModificarAviso(String query) {
        LinkedList<aviso> a = new LinkedList<aviso>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                aviso v = new aviso();
                v.setClase_aviso(rs.getString("clase_aviso"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setNum_notificacion(rs.getString("num_notificacion"));
                v.setFolio_sam(rs.getString("folio_sam"));
                a.add(v);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ModificarAviso (ACC_Aviso)por:" + ex);
        }
        cnx.CerrarConexion(con);
        return a;
    }

    public boolean ValidarAvisoModificary(String aviso) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String quer = "SELECT folio_sam FROM avisos WHERE folio_sam ='" + aviso + "'";
        try {
            ResultSet rs;
            Statement st;
            st = con.createStatement();
            rs = st.executeQuery(quer);
            while (rs.next()) {
                String a = rs.getString("folio_sam");
                if (aviso.equals(a)) {
                    cnx.CerrarConexion(con);
                    return true;
                } else {
                    cnx.CerrarConexion(con);
                    return false;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarAviso (ACC_Aviso) por:" + ex);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    /*Guardar Aviso*/
    public boolean Guardar(String q) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        try {
            Statement st;
            st = conn.createStatement();
            validar = st.executeUpdate(q);
            if (validar > 0) {
                con.CerrarConexion(conn);
                return true;
            } else {
                con.CerrarConexion(conn);
                return false;
            }

        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        }
        con.CerrarConexion(conn);
        return false;
    }

    public boolean ActualizarGua(String pref, int fol) {

        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        String query = "{call CNF.Folios_ActualizarFolio(?,?)}";
        boolean re = false;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, pref);
            pst.setInt(2, fol);
            if (pst.executeUpdate() == 1) {
                con.CerrarConexion(conn);
                return re = true;
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
            } catch (Exception o) {
                System.out.println("Error: " + o);
            }
        }
        return false;
    }

    /*------------*/
 /*Update Aviso*/
    public void Update(String query1, String query2) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            st = con.createStatement();
            st.executeUpdate(query1);
            st.executeUpdate(query2);
        } catch (Exception ex) {
            System.err.println("Error el metodo Update (ACC_Aviso) por:" + ex);
        }
        cnx.CerrarConexion(con);
    }

    public LinkedList<aviso> ConsultaLAvisoAvisos2(String noti, String noti2, String ub1, String ub2, String meeq, String meeq2, String fec1, String fec2) {
        LinkedList<aviso> AvMatch = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PM.avisosMonitor(?,?,?,?,?,?,?,?)}";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, noti);
            pst.setString(2, noti2);
            pst.setString(3, ub1);
            pst.setString(4, ub2);
            pst.setString(5, meeq);
            pst.setString(6, meeq2);
            pst.setString(7, fec1);
            pst.setString(8, fec2);
            rs = pst.executeQuery();
            while (rs.next()) {
                aviso av = new aviso();
                av.setNum_notificacion(rs.getString("num_notificacion"));
                av.setDescripcion(rs.getString("descripcion"));
                av.setFecha_aviso(rs.getString("fecha_aviso"));
                av.setFolio_sam(rs.getString("folio_sam"));
                AvMatch.add(av);

            }
        } catch (Exception ex) {
            System.err.println("Error:" + ex);
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
        return AvMatch;
    }

    public String GuardarCabecera_avisos_crea(String folio, String hor, String fecha, String centrop, String claseAviso, String textobreve, String equipo, String cod1, String codi2, String statOR, String material, String ubitec, String grupop, String puestot, String centro, String depres, String depres2, String responsable, String responsable2, String autor, String desc, String Random) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        //PreparedStatement pst = null;
        CallableStatement pst = null;
        String querys = "{call PM.Cabecera_avisos_crea_GuardarCabavicrea2(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        String Nfolio = "";
        try {
            pst = conn.prepareCall(querys);
            //pst = conn.prepareStatement(querys);
            pst.setString(1, folio);
            pst.setString(2, hor);
            pst.setString(3, fecha);
            pst.setString(4, centrop);
            pst.setString(5, claseAviso);
            pst.setString(6, textobreve);
            pst.setString(7, equipo);
            pst.setString(8, cod1);
            pst.setString(9, codi2);
            pst.setString(10, statOR);
            pst.setString(11, material);
            pst.setString(12, ubitec);
            pst.setString(13, grupop);
            pst.setString(14, puestot);
            pst.setString(15, centro);
            pst.setString(16, depres);
            pst.setString(17, depres2);
            pst.setString(18, responsable);
            pst.setString(19, responsable2);
            pst.setString(20, autor);
            pst.setString(21, desc);
            pst.registerOutParameter(22, java.sql.Types.VARCHAR);
            pst.executeUpdate();
            
                Nfolio = pst.getString(22);
            

        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception a) {
                System.err.println("Error: " + a);
            }
        }
        return Nfolio;
    }

    public String FolioPosAvisos(String random){
         String f = "";
         Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        CallableStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.AvisosCrear_SavePosFolio(?,?)}";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, random);
            ps.registerOutParameter(2, java.sql.Types.VARCHAR);
            ps.executeUpdate();
            f = ps.getString(2);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return f;
     }
    
    public boolean GuardarTEXTos(String fila, String linea, String foli) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        boolean re = false;
        String query = "{call PM.texto_avisos_crea_Guardar_te_av_cr(?,?,?)}";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, foli);
            pst.setString(2, fila);
            pst.setString(3, linea);
            if (pst.executeUpdate() == 1) {
                re = true;
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
            } catch (Exception a) {
                System.err.println("Error: " + a);
            }
        }
        return re;
    }

    public boolean GuardarAviQmm(String folTab, String hor, String fecha, String grupoCod, String Descod, String TexAci, String autor, String Feca1, String Feca2, String FuCant, String Hor1, String Hor2, int nuac, String ObjeLan, String ObjeLen) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        boolean re = false;
        String query = "{call PM.qmm_avisos_crea_SAVETABDat(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folTab);
            pst.setString(2, hor);
            pst.setString(3, fecha);
            pst.setString(4, grupoCod);
            pst.setString(5, Descod);
            pst.setString(6, TexAci);
            pst.setString(7, autor);
            pst.setString(8, Feca1);
            pst.setString(9, Feca2);
            pst.setString(10, FuCant);
            pst.setString(11, Hor1);
            pst.setString(12, Hor2);
            pst.setInt(13, nuac);
            pst.setString(14, ObjeLan);
            pst.setString(15, ObjeLen);
            if (pst.executeUpdate() == 1) {
                re = true;
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
            } catch (Exception a) {
                System.err.println("Error: " + a);
            }
        }
        return re;
    }

    public boolean ValidarAvisSAP(String folsap) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PM.avisos_ValidarFolioSap(?)}";
        boolean re = false;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folsap);
            rs = pst.executeQuery();
            if (rs.next()) {
                return re = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarAvis ACC_Aviso por:" + e);
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
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return re;
    }

    public boolean ValidarAvisSAM(String folsam, String folsam1) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "{call PM.avisos_ValidarFolioSAM(?,?)}";
        boolean re = false;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folsam);
            pst.setString(2, folsam1);
            rs = pst.executeQuery();
            if (rs.next()) {
                return re = true;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarAvis ACC_Aviso por:" + e);
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
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        return re;
    }

    public LinkedList<aviso> ConsultaModificarAvisoMATCH2(String cantidad2, String DAvisoSAMM, String AvisoSAMM, String numor) {
        LinkedList<aviso> c = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.avisos_ConsultaMatchNotificacion1(?,?,?,?)}";
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, cantidad2);
            pst.setString(2, DAvisoSAMM);
            pst.setString(3, AvisoSAMM);
            pst.setString(4, numor);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setNum_notificacion(res.getString("num_notificacion"));
                ao.setFolio_sam(res.getString("folio_sam"));
                ao.setDescripcion(res.getString("descripcion"));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaModificarAviso (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public LinkedList<aviso> ConsultaMatchMONIAviso(String TNotif, String Notifi) {
        LinkedList<aviso> c = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.avisos_ConsultaMatchMONIAviso(?,?)}";
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, TNotif);
            pst.setString(2, Notifi);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setNum_notificacion(res.getString("num_notificacion"));
                ao.setFolio_sam(res.getString("folio_sam"));
                ao.setDescripcion(res.getString("descripcion"));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaModificarAviso (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public boolean GuardarAV(String folAVsp, String folORDsp) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.avisosACTUALORDEN(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folAVsp);
            pst.setString(2, folORDsp);
            validar = pst.executeUpdate();
            if (validar > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception ex) {
                System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
            }
        }

        return false;
    }

    public boolean ACTUALIZArAV(String folORDsp, String folAVsp) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call  PM.cabecera_avisos_crea_ACTUORD(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folAVsp);
            pst.setString(2, folORDsp);
            validar = pst.executeUpdate();
            if (validar > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception ex) {
                System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
            }
        }

        return false;
    }

    public boolean GuardarAVSTA(String ti_co, String fe_co, String foldAV) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.cabecera_avisos_creaINSSTATUS(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ti_co);
            pst.setString(2, fe_co);
            pst.setString(3, foldAV);
            validar = pst.executeUpdate();
            if (validar > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception ex) {
                System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
            }
        }

        return false;
    }

    public boolean GuardarAVSTAsap(String foldAV) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call avisossap_modificadosINSSTATUS(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, foldAV);
            validar = pst.executeUpdate();
            if (validar > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception ex) {
                System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
            }
        }

        return false;
    }

    public boolean ACTULIZAVSTAsap(String foldAV) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call avisossap_modificadosacTUALSTAT(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, foldAV);
            validar = pst.executeUpdate();
            if (validar > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception ex) {
                System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
            }
        }

        return false;
    }

    public aviso ConsultaOrd(String SAp) {
        aviso av = new aviso();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call pm.avisosConsultanumord(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, SAp);
            rs = pst.executeQuery();
            while (rs.next()) {
                av.setNum_orden(rs.getString("num_orden"));
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

        return av;
    }

    public boolean GuardarAVSTALIgue(String ti_co, String fe_co, String foldAV, String Nombre, String fact) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call pm.cierre_ligue_avisosINSERTA(?,?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ti_co);
            pst.setString(2, fe_co);
            pst.setString(3, foldAV);
            pst.setString(4, Nombre);
            pst.setString(5, fact);
            validar = pst.executeUpdate();
            if (validar > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        } finally {
            try {
                if (conn != null) {
                    con.CerrarConexion(conn);
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception ex) {
                System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
            }
        }

        return false;
    }

    /*------------*/
    public static void main(String[] args) {
        String query = "";
        System.out.println(ACC_Aviso.ObtenerInstancia().ConsultaLAvisoAvisos2("", "", "", "", "", "", "", ""));
    }

    public ArrayList<aviso> ConsultarAviso(String TNotif, String Notifi) {
        ArrayList<aviso> c = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.MonitorAvisos_MatchAvisos(?,?)}";
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, Notifi);
            pst.setString(2, TNotif);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setNum_notificacion(res.getString("num_notificacion"));
                ao.setDescripcion(res.getString("descripcion"));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarAviso (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public ArrayList<aviso> ConsultarAvisoSAM(String folio, String txt) {
        ArrayList<aviso> c = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.MonitorAvisos_MatchSAM(?,?)}";
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, folio);
            pst.setString(2, txt);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setFolio_sam(res.getString("folio_sam"));
                ao.setDescripcion(res.getString("descripcion"));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarAvisoSAM (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public ArrayList<aviso> ConsultarAvisoClase() {
        ArrayList<aviso> c = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.MonitorAvisos_MatchClase()}";
        try {

            pst = conn.prepareStatement(querys);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setClase_aviso(res.getString("clase_aviso"));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarAvisoClase (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public ArrayList<aviso> ConsultarAvisoUbicacion(String ub, String txt, String campo) {
        ArrayList<aviso> c = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.MonitorAvisos_MatchUbicacion(?,?,?)}";
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, ub);
            pst.setString(2, txt);
            pst.setString(3, campo);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setUbicación_tecnica(res.getString("ubicacion_tecnica"));
                ao.setDescripcion(res.getString(campo));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarAvisoUbicacion (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public ArrayList<aviso> ConsultarAvisoEquipo(String eq, String txt, String campo) {
        ArrayList<aviso> c = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.MonitorAvisos_MatchEquipo(?,?,?)}";
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, eq);
            pst.setString(2, txt);
            pst.setString(3, campo);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setUbicación_tecnica(res.getString("num_equipo"));
                ao.setDescripcion(res.getString(campo));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarAvisoEquipo (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public ArrayList<aviso> ConsultarAvisoOrden(String ord, String des) {
        ArrayList<aviso> c = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.MonitorAvisos_MatchOrden(?,?)}";
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, ord);
            pst.setString(2, des);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setNum_orden(res.getString("num_orden"));
                ao.setFolio_sam(res.getString("folio_sam"));
                ao.setDescripcion(res.getString("texto_breve"));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarAvisoOrden (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public ArrayList<aviso> ConsultarAvisoPuesto(String Pto, String des, String campo) {
        ArrayList<aviso> c = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.MonitorAvisos_MatchPuesto(?,?,?)}";
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, Pto);
            pst.setString(2, des);
            pst.setString(3, campo);
            res = pst.executeQuery();
            while (res.next()) {
                aviso ao = new aviso();
                ao.setPuesto_trabajo_responsable_medidas_mantenimiento(res.getString("puesto_trabajo"));
                ao.setDescripcion(res.getString(campo));
                c.add(ao);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultarAvisoOrden (ACC_Cabecera_Aviso) por:" + ex);
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
        return c;
    }

    public int ValidarDatosMonitorAvisos(String dato, String proc) {
        int ban = 0;
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = proc;
        try {

            pst = conn.prepareStatement(querys);
            pst.setString(1, dato);
            res = pst.executeQuery();
            while (res.next()) {
                ban = 1;
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarDatosMonitorAvisos por:" + ex);
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
        return ban;
    }

    public ArrayList<aviso> ConsultaQuerySAP(String[] data) {
        ArrayList<aviso> avi = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.MonitorAvisos_CargarSAP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);
            pst.setString(16, data[15]);
            pst.setString(17, data[16]);
            pst.setString(18, data[17]);
            pst.setString(19, data[18]);
            pst.setString(20, data[19]);
            rs = pst.executeQuery();
            while (rs.next()) {
                aviso a = new aviso();
                a.setNum_notificacion(rs.getString("num_notificacion"));
                a.setFolio_sam(rs.getString("folio_sam"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setUbicación_tecnica(rs.getString("ubicación_tecnica"));
                a.setNum_equipo(rs.getString("num_equipo"));
                a.setNum_orden(rs.getString("num_orden"));
                a.setFecha_aviso(rs.getString("fecha_aviso"));
                avi.add(a);
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

        return avi;
    }

    public ArrayList<aviso> ConsultaQuerySAM(String[] data) {
        ArrayList<aviso> avi = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.MonitorAvisos_CargarSAM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);
            pst.setString(16, data[15]);
            pst.setString(17, data[16]);
            pst.setString(18, data[17]);
            pst.setString(19, data[18]);
            pst.setString(20, data[19]);
            rs = pst.executeQuery();
            while (rs.next()) {
                aviso a = new aviso();
                a.setNum_notificacion(rs.getString("folio_sap"));
                a.setFolio_sam(rs.getString("folio_sam"));
                a.setDescripcion(rs.getString("texto_breve"));
                a.setUbicación_tecnica(rs.getString("ubicacion_tecnica"));
                a.setNum_equipo(rs.getString("num_equipo"));
                a.setNum_orden(rs.getString("num_orden"));
                a.setFecha_aviso(rs.getString("fecha"));
                avi.add(a);
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

        return avi;
    }

    public ArrayList<aviso> CargarAvisosMC(String Clase, String Aviso, String texto) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<aviso> avis = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ModificarAvisos_CargarNotificaciones(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Clase);
            ps.setString(2, Aviso);
            ps.setString(3, texto);
            rs = ps.executeQuery();
            while (rs.next()) {
                aviso a = new aviso();
                a.setClase_aviso(rs.getString("clase_aviso"));
                a.setNum_notificacion(rs.getString("num_notificacion"));
                a.setFolio_sam(rs.getString("folio_sam"));
                a.setDescripcion(rs.getString("descripcion"));
                avis.add(a);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return avis;
    }

    public int Validaraviso(String Aviso) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ban = 0;
        String sql = "{call PM.Modificaraviso_ValidarAviso(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Aviso);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public aviso CargarAvisoSAP(String aviso, String lan) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        aviso av = new aviso();
        PreparedStatement pst = null;
        String query = "{call PM.aviso_CargarAviso(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, aviso);
            pst.setString(2, lan);
            rs = pst.executeQuery();
            while (rs.next()) {
                av.setNum_notificacion(rs.getString("num_notificacion"));
                av.setClase_aviso(rs.getString("clase_aviso"));
                av.setDescripcion(rs.getString("descripcion"));
                av.setStatus_individual_breve_es(rs.getString("status_individual_breve_" + lan));
                av.setUbicación_tecnica(rs.getString("ubicación_tecnica"));
                av.setNum_equipo(rs.getString("num_equipo"));
                av.setConjunto(rs.getString("conjunto"));
                av.setGrupo_planificador_servicio_cliente_mante(rs.getString("grupo_planificador_servicio_cliente_mante"));
                av.setCentro_planificador_mante(rs.getString("centro_planificador_mante"));
                av.setPuesto_trabajo_responsable_medidas_mantenimiento(rs.getString("puesto_trabajo_responsable_medidas_mantenimiento"));
                av.setNombre_autor_aviso(rs.getString("nombre_autor_aviso"));
                av.setFecha_aviso(rs.getString("fecha_aviso"));
                av.setHora_aviso(rs.getString("hora_aviso"));
                av.setTexto_breve(rs.getString("texto_breve"));
                av.setNum_orden(rs.getString("num_orden"));
            }
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        } finally {
            con.CerrarConexion(conn);
        }
        return av;
    }

    public aviso CargarAvisoSAM(String aviso) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        aviso av = new aviso();
        PreparedStatement pst = null;
        String query = "{call PM.aviso_CargarAvisoSAM(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, aviso);
            rs = pst.executeQuery();
            while (rs.next()) {
                av.setFolio_sam(rs.getString("folio_sam"));
                av.setClase_aviso(rs.getString("clase_aviso"));
                av.setDescripcion(rs.getString("texto_breve"));
                av.setStatus_individual_breve_es(rs.getString("status_sistema_aviso_conjunto"));
                av.setUbicación_tecnica(rs.getString("ubicacion_tecnica"));
                av.setNum_equipo(rs.getString("num_equipo"));
                av.setConjunto(rs.getString("conjunto"));
                av.setGrupo_planificador_servicio_cliente_mante(rs.getString("grupo_planificador_servicio_cliente_mante"));
                av.setCentro_planificador_mante(rs.getString("centro_planificacion_mante"));
                av.setPuesto_trabajo_responsable_medidas_mantenimiento(rs.getString("puesto_trabajo_responsable_medida_mante"));
                av.setNombre_autor_aviso(rs.getString("nombre_autor_aviso"));
                av.setFecha_aviso(rs.getString("fecha"));
                av.setHora_aviso(rs.getString("hora_dia"));
                av.setTexto_breve(rs.getString("texto_breve2"));
                av.setRecibido(rs.getString("recibido"));
                av.setProcesado(rs.getString("procesado"));
                av.setError(rs.getString("error"));
                av.setModificado(rs.getString("modificado"));
                av.setNum_orden(rs.getString("num_orden"));
            }
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        } finally {
            con.CerrarConexion(conn);
        }
        return av;
    }

    public ArrayList<aviso> CargarTextosAvisoSAP(String Aviso) {
        ArrayList<aviso> Tav = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.aviso_CargarTextosSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Aviso);
            rs = ps.executeQuery();
            while (rs.next()) {
                aviso a = new aviso();
                a.setTexto_breve(rs.getString("linea_texto"));
                Tav.add(a);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return Tav;
    }

    public ArrayList<aviso> CargarTextosAvisoSAM(String Aviso) {
        ArrayList<aviso> Tav = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.aviso_CargarTextosSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Aviso);
            rs = ps.executeQuery();
            while (rs.next()) {
                aviso a = new aviso();
                a.setTexto_breve(rs.getString("linea_texto"));
                Tav.add(a);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return Tav;
    }

    public ArrayList<actividadesavisos> CargarActividadesSAP(String aviso, String lan) {
        ArrayList<actividadesavisos> acti = new ArrayList<actividadesavisos>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.aviso_CargarActividadesSAP(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, aviso);
            pst.setString(2, lan);
            rs = pst.executeQuery();
            while (rs.next()) {
                actividadesavisos av = new actividadesavisos();
                av.setPosicion(rs.getString("num_actual_actividad"));
                av.setGrupo_codigo(rs.getString("grupo_codigo_acciones"));
                av.setCodigo_medida(rs.getString("codigo_medida"));
                av.setTexto_codigo(rs.getString("descripcion_" + lan));
                av.setTexto_accion(rs.getString("texto_accion"));
                av.setFactor_cantidad(rs.getString("factor_cantidad_acciones"));
                av.setFecha_inicio(rs.getString("fecha_inicio"));
                av.setHora_inicio(rs.getString("hora_inicio_accion"));
                av.setFecha_fin(rs.getString("fecha_fin"));
                av.setHora_fin(rs.getString("hora_fin_accion"));
                av.setNum_actividad("");
                acti.add(av);
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            con.CerrarConexion(conn);
        }
        return acti;
    }
    public ArrayList<actividadesavisos> CargarActividadesSAPMod(String aviso, String lan) {
        ArrayList<actividadesavisos> acti = new ArrayList<actividadesavisos>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.aviso_CargarActividadesSAP(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, aviso);
            pst.setString(2, lan);
            rs = pst.executeQuery();
            while (rs.next()) {
                actividadesavisos av = new actividadesavisos();
                av.setPosicion(rs.getString("num_posicion_registro_posicion"));
                av.setGrupo_codigo(rs.getString("grupo_codigo_acciones"));
                av.setCodigo_medida(rs.getString("codigo_medida"));
                av.setTexto_codigo(rs.getString("descripcion_" + lan));
                av.setTexto_accion(rs.getString("texto_accion"));
                av.setFactor_cantidad(rs.getString("factor_cantidad_acciones"));
                av.setFecha_inicio(rs.getString("fecha_inicio"));
                av.setHora_inicio(rs.getString("hora_inicio_accion"));
                av.setFecha_fin(rs.getString("fecha_fin"));
                av.setHora_fin(rs.getString("hora_fin_accion"));
                av.setNum_actividad(rs.getString("num_actual_actividad"));
                acti.add(av);
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            con.CerrarConexion(conn);
        }
        return acti;
    }

    public ArrayList<actividadesavisos> CargarActividadesSAM(String aviso, String lan) {
        ArrayList<actividadesavisos> acti = new ArrayList<actividadesavisos>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.aviso_CargarActividadesSAM(?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, aviso);
            pst.setString(2, lan);
            rs = pst.executeQuery();
            while (rs.next()) {
                actividadesavisos av = new actividadesavisos();
                av.setAutor(rs.getString("nombre_responsable_anadio_objeto"));
                av.setPosicion(rs.getString("num_claseificacion_actividad"));
                av.setFecha_dia(rs.getString("fecha"));
                av.setHora_dia(rs.getString("hora_dia"));
                av.setGrupo_codigo(rs.getString("grupo_codigo_acciones"));
                av.setCodigo_medida(rs.getString("codigo_actividad"));
                av.setTexto_codigo(rs.getString("texto_breve_codigo_" + lan));
                av.setTexto_accion(rs.getString("texto_accion"));
                av.setFactor_cantidad(rs.getString("factor_cantidad_acciones"));
                av.setFecha_inicio(rs.getString("fecha_inicio"));
                av.setHora_inicio(rs.getString("hora_inicio_accion"));
                av.setFecha_fin(rs.getString("fecha_fin"));
                av.setHora_fin(rs.getString("hora_fin_accion"));
                av.setNum_actividad("");
                acti.add(av);
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        } finally {
            con.CerrarConexion(conn);
        }
        return acti;
    }

    public String GetNameData(String dato, String lan, String tipo) {
        String name = "";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.aviso_GetNameData(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo);
            ps.setString(2, dato);
            ps.setString(3, lan);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return name;
    }

    public int ConsultarCTEC(String Aviso) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int c = 0;
        String sql = "{call pm.cierre_ligue_avisosCONS(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Aviso);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = 1;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return c;
    }

    public int ValidarDatosModiAvisos(String dato, String tipo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int a = 0;
        String sql = "{call PM.ModificarAviso_ValidarDatos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dato);
            ps.setString(2, tipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return a;
    }

    public ArrayList<centros> ConsultaCentroAviso() {
        ArrayList<centros> res = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call MM.ConsultaCentroAviso()}";
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                centros c = new centros();
                c.setCentro(rs.getString("centro"));
                c.setDescripcion(rs.getString("descripcion"));
                res.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return res;
    }

    public ArrayList<puesto_trabajo> ConsultaPTOOrdAviso(String lan) {
        ArrayList<puesto_trabajo> res = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ModificaAviso_ConsultaPtoOrd()}";
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                puesto_trabajo p = new puesto_trabajo();
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setDescripcion(rs.getString("denominacion_" + lan));
                p.setCentro(rs.getString("centro"));
                res.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return res;
    }

    public ArrayList<grupo_planificacion> ConsultaGeupolanMatch() {
        ArrayList<grupo_planificacion> grupoplan = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ModificarAviso_ConsulaGrupoPlan()}";

        try {
            pst = conn.prepareCall(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                grupo_planificacion g = new grupo_planificacion();
                g.setCentro_planificacion_mantenimiento(rs.getString("centro_planificacion_mantenimiento"));
                g.setGrupo_planificador_p_servicio_cliente_mante(rs.getString("geupo_planificador_servicio_cliente_mante"));
                g.setNombre_grupo_planificador(rs.getString("nombre_grupo_planificador_manteni"));
                grupoplan.add(g);
            }

        } catch (Exception e) {
            System.err.println("Error en el metodo AvisoMatchGrupoPlan (ACC_GrupoPlanificacion) por:" + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return grupoplan;
    }

    public String[] GetDataEquipoAviso(String Aviso) {
        String data[] = new String[3];
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call PM.ModificarAviso_GetDataEquipo(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Aviso);
            rs = ps.executeQuery();
            while (rs.next()) {
                data[0] = rs.getString("id_ubitec");
                data[1] = rs.getString("grupo_planificador");
                data[2] = rs.getString("puesto_responsable_medmante");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return data;
    }

    public void ActualizarAvisoSAM(String data[]) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call PM.ModificarAviso_ActualizarAviso(?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
    public void GuardarCabeceraSAP(String Folio, String fecha, String hora, String usuario, String folis) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call PM.ModificarAvisos_GuardarCabaceraSAP(?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Folio);
            ps.setString(2, fecha);
            ps.setString(3, hora);
            ps.setString(4, usuario);
            ps.setString(5, folis);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }

    public void DelAvisoSAM(String aviso) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call PM.ModificarAviso_DelActividadesAviso(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, aviso);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        
    }
    public void DelAvisoSAP(String aviso) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        String sql = "{call PM.ModificarAviso_DeleteSAPACT(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, aviso);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cnx.CerrarConexion(con);
        }
        
    }
    

    public void GuardarAviMod(String data[]) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        boolean re = false;
        String query = "{call PM.ModificarAviso_GuardarModificacion(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);
            pst.setString(16, data[15]);
            pst.setString(17, data[16]);
            pst.setString(18, data[17]);
            pst.executeUpdate();
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
            } catch (Exception a) {
                System.err.println("Error: " + a);
            }
        }
    }
    public void GuardarAviModSAP(String data[]) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        boolean re = false;
        String query = "{call PM.MdificarAviso_GuardarActividadesSAP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);
            pst.executeUpdate();
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
            } catch (Exception a) {
                System.err.println("Error: " + a);
            }
        }
    }
    public void GuardarAviModSAPDM(String data[]) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.ModificarAviso_ModificarSAPDM(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.executeUpdate();
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
            } catch (Exception a) {
                System.err.println("Error: " + a);
            }
        }
    }

}
