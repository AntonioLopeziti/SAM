/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.AvisosCalidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Panda
 */
public class ACC_AvisosCalidad {
    private static ACC_AvisosCalidad Instance = null;

    public static ACC_AvisosCalidad ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_AvisosCalidad();
        }
        return Instance;
    }
    
    public ArrayList<AvisosCalidad> ConsultaAvisosUsr(String usuario) {
        Conexion con = new Conexion();
        ArrayList<AvisosCalidad> AvUsr = new ArrayList<>();
        Connection conn = con.ObtenerConexion();
        ResultSet rs;
        PreparedStatement pst = null;
        String query = "{call QM.AvisosCalidadUsr(?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            while (rs.next()) {
                AvisosCalidad av = new AvisosCalidad();
                av.setNum_aviso(rs.getString("num_aviso"));
                av.setNum_correlativo_medida_mante(rs.getString("num_correlativo_medida_mante"));
                av.setNum_clasificacion_medida(rs.getString("num_clasificacion_medida"));
                av.setTexto_breve_medida_mante(rs.getString("texto_breve_medida_mante"));
                av.setGrupo_codigos_medidas(rs.getString("grupo_codigos_medidas"));
                av.setCodigo_medidas(rs.getString("codigo_medidas"));
                av.setRol_responsable_medida(rs.getString("rol_responsable_medida"));
                av.setResponsable_medida_num_interlocutor(rs.getString("responsable_medida_num_interlocutor"));
                av.setFecha_inicio_prevista(rs.getString("fecha_inicio_prevista"));
                av.setHora_prevista_inicio_medida(rs.getString("hora_prevista_inicio_medida"));
                av.setFecha_fin_planif(rs.getString("fecha_fin_planif"));
                av.setHora_prevista_finalizacion_medida(rs.getString("hora_prevista_finalizacion_medida"));
                av.setNum_posicion_registro_posicion(rs.getString("num_posicion_registro_posicion"));
                av.setStatus_sistema_aviso(rs.getString("status_sistema_aviso"));
                av.setFecha_ultima_modificacion(rs.getString("fecha_ultima_modificacion"));
                av.setHora_modificacion(rs.getString("hora_modificacion"));
                AvUsr.add(av);
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
        return AvUsr;
    }
    
    public AvisosCalidad getDataAvisoCalida(String aviso, String ncorr, String nclas) {
        Conexion con = new Conexion();
        AvisosCalidad av = new AvisosCalidad();
        Connection conn = con.ObtenerConexion();
        ResultSet rs;
        PreparedStatement pst = null;
        String query = "{call QM.DatosAvisosCalidadQM(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, aviso);
            pst.setString(2, ncorr);
            pst.setString(3, nclas);
            rs = pst.executeQuery();
            while (rs.next()) {
                av.setNum_aviso(rs.getString("num_aviso"));
                av.setNum_correlativo_medida_mante(rs.getString("num_correlativo_medida_mante"));
                av.setNum_clasificacion_medida(rs.getString("num_clasificacion_medida"));
                av.setTexto_breve_medida_mante(rs.getString("texto_breve_medida_mante"));
                av.setGrupo_codigos_medidas(rs.getString("grupo_codigos_medidas"));
                av.setCodigo_medidas(rs.getString("codigo_medidas"));
                av.setRol_responsable_medida(rs.getString("rol_responsable_medida"));
                av.setResponsable_medida_num_interlocutor(rs.getString("responsable_medida_num_interlocutor"));
                av.setFecha_inicio_prevista(rs.getString("fecha_inicio_prevista"));
                av.setHora_prevista_inicio_medida(rs.getString("hora_prevista_inicio_medida"));
                av.setFecha_fin_planif(rs.getString("fecha_fin_planif"));
                av.setHora_prevista_finalizacion_medida(rs.getString("hora_prevista_finalizacion_medida"));
                av.setNum_posicion_registro_posicion(rs.getString("num_posicion_registro_posicion"));
                av.setStatus_sistema_aviso(rs.getString("status_sistema_aviso"));
                av.setDescripcion_breve_grupo_codigos(rs.getString("descripcion_breve_grupo_codigos"));
                av.setTexto_breve_codigos_medidas(rs.getString("texto_breve_codigos_medidas"));
                return av;
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
    
    public String TextoAvisoQM(String aviso, String ncorre, String nclasi) {
        String texto = "";
        Conexion con = new Conexion();
        AvisosCalidad av = new AvisosCalidad();
        Connection conn = con.ObtenerConexion();
        ResultSet rs;
        PreparedStatement pst = null;
        String query = "{call QM.textosAvisoQM(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, aviso);
            pst.setString(2, ncorre);
            pst.setString(3, nclasi);
            rs = pst.executeQuery();
            while (rs.next()) {
                texto+=rs.getString("texto");                
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
        return texto;
    }
    public String TextoAvisoCreaQM(String aviso, String ncorre, String nclasi) {
        String texto = "";
        Conexion con = new Conexion();
        AvisosCalidad av = new AvisosCalidad();
        Connection conn = con.ObtenerConexion();
        ResultSet rs;
        PreparedStatement pst = null;
        String query = "{call QM.textosAvisoCreaQM(?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, aviso);
            pst.setString(2, ncorre);
            pst.setString(3, nclasi);
            rs = pst.executeQuery();
            while (rs.next()) {
                texto+=rs.getString("linea_texto");                
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
        return texto;
    }
    public void ActualizaStatus(String v1, String v2, String v3, String v4) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "{CALL QM.ActualizaStatusQM(?,?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            ps.setString(4, v4);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
    }
}
