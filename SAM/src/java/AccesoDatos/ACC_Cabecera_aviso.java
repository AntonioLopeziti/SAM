/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.CabeceraAviso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author JaroMX
 */
public class ACC_Cabecera_aviso {

    Conexion cnx = new Conexion();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_Cabecera_aviso Instance = null;

    public static ACC_Cabecera_aviso ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Cabecera_aviso();
        }
        return Instance;
    }

    public LinkedList<CabeceraAviso> ConsultaModificarAviso(String query) {
        LinkedList<CabeceraAviso> c = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                CabeceraAviso ca = new CabeceraAviso();
                ca.setClase_aviso(rs.getString("clase_aviso"));
                ca.setTexto_breve(rs.getString("texto_breve"));
                ca.setFolio_sam(rs.getString("folio_sam"));
                ca.setNum_orden(rs.getString("num_orden"));
                c.add(ca);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaModificarAviso (ACC_Cabecera_Aviso) por:" + ex);
        }
        cnx.CerrarConexion(con);
        return c;
    }

    public boolean ValidarAviso(String aviso) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String query = "SELECT folio_sam FROM cabecera_avisos_crea WHERE folio_sam = '" + aviso + "'";
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String a = rs.getString("folio_sam");
                if (aviso.equals(a)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarAviso (ACC_Cabecera_aviso) por:" + ex);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public CabeceraAviso CargarDatosAvisos(String folio, String idioma) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CabeceraAviso c = new CabeceraAviso();
        String status = "status_individual_objeto_breve_" + idioma;
        String query = "{call PM.cabecera_avisos_crea_CargarDatosAvisos(?)}";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, folio);
            rs = pst.executeQuery();
            while (rs.next()) {
                c.setFolio_sam(rs.getString("folio_sam"));
                c.setHora_dia(rs.getString("hora_dia"));
                c.setFecha(rs.getString("fecha"));
                c.setCentro_planificacion_mante(rs.getString("centro_planificacion_mante"));
                c.setClase_aviso(rs.getString("clase_aviso"));
                c.setTexto_breve(rs.getString("texto_breve"));
                c.setNum_equipo(rs.getString("num_equipo"));
                c.setGrupo_codigo_codificacion(rs.getString("grupo_codigo_codificacion"));
                c.setCodificacion(rs.getString("codificacion"));
                c.setFolio_sap(rs.getString("folio_sap"));
                c.setRecibido(rs.getString("recibido"));
                c.setProcesado(rs.getString("procesado"));
                c.setError(rs.getString("error"));
                c.setModificado(rs.getString("modificado"));
                c.setStatus_sistema_aviso_conjunto(rs.getString("status_sistema_aviso_conjunto"));
                c.setConjunto(rs.getString("conjunto"));
                c.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                c.setGrupo_planificador_servicio_cliente_mante(rs.getString("grupo_planificador_servicio_cliente_mante"));
                c.setPuesto_trabajo_responsable_medida_mante(rs.getString("puesto_trabajo_responsable_medida_mante"));
                c.setCentro(rs.getString("centro"));
                c.setInterlocutor(rs.getString("interlocutor"));
                c.setNombre_visualizaciones_lista(rs.getString("nombre_visualizaciones_lista"));
                c.setInterlocutor_vera(rs.getString("interlocutor_vera"));
                c.setNombre_visualizaciones_lista_vera(rs.getString("nombre_visualizaciones_lista_vera"));
                c.setNombre_autor_aviso(rs.getString("nombre_autor_aviso"));
                c.setTexto_breve2(rs.getString("texto_breve2"));
                c.setNum_orden(rs.getString("num_orden"));
                c.setStatus_concluido(rs.getString("status_concluido"));
                c.setFecha_concluido(rs.getString("fecha_concluido"));
                c.setHora_concluido(rs.getString("hora_concluido"));
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo CargarDatosAvisos (ACC_Cabecera_aviso) por: " + ex);
        }
        finally{
                  try{
                    if(conn != null)con.CerrarConexion(conn);;
                    if(pst != null)pst.close();
                    if(rs != null)rs.close();
                  }catch(Exception a){
                      System.err.println("Error inesperado al cerrar conexiones");
                  }
        }
        return c;
    }

    public boolean CArgarDatVIS(String folio) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        String query = "{call PM.cabecera_avisos_crea_CArgarDatVIS(?)}";
        boolean re = false;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {            
            pst = conn.prepareStatement(query);
            pst.setString(1, folio);
            rs = pst.executeQuery();
            while (rs.next()) {
                String a = rs.getString("folio_sam");
                if (folio.equals(a)) {
                    return re = true;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ValidarAviso (ACC_Cabecera_aviso) por:" + ex);
        }
        finally{
                  try{
                    if(conn != null)con.CerrarConexion(conn);;
                    if(pst != null)pst.close();
                    if(rs != null)rs.close();
                  }catch(Exception a){
                      System.err.println("Error inesperado al cerrar conexiones");
                  }
        }
        return false;
    }
    
     
    public LinkedList<CabeceraAviso> ConsultaModificarAvisoMATCH(String sam,String des,String ord,String can) {
        LinkedList<CabeceraAviso> c = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet res = null;
        PreparedStatement pst = null;
        String querys = "{call PM.avisos_ConsultaMatchNotificacion2(?,?,?,?)}";
        try {
            
            pst = conn.prepareStatement(querys);
            pst.setString(1, can);
            pst.setString(2, des);
            pst.setString(3, sam);
            pst.setString(4, ord);            
            res = pst.executeQuery();
            while (res.next()) {
                CabeceraAviso ca = new CabeceraAviso();
                ca.setClase_aviso(res.getString("clase_aviso"));
                ca.setTexto_breve(res.getString("texto_breve"));
                ca.setFolio_sam(res.getString("folio_sam"));
                ca.setNum_orden(res.getString("num_orden"));
                c.add(ca);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaModificarAviso (ACC_Cabecera_Aviso) por:" + ex);
        }
        finally{
                  try{
                    if(conn != null)con.CerrarConexion(conn);;
                    if(pst != null)pst.close();
                    if(rs != null)rs.close();
                  }catch(Exception a){
                      System.err.println("Error inesperado al cerrar conexiones");
                  }
        }
        return c;
    }
    
        public LinkedList<CabeceraAviso> ConsultaModificarAvisoSAM(String cdtmax,String aviso,String descripcion,String foliosam) {
        LinkedList<CabeceraAviso> c = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs = null;
        PreparedStatement pst = null;
         String query = "{call PM.cabecera_avisos_crea_Con_ModAviso(?,?,?,?)}";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, cdtmax);
            pst.setString(2, aviso);
            pst.setString(3, descripcion);
            pst.setString(4, foliosam);
            rs = pst.executeQuery();
            while (rs.next()) {
                CabeceraAviso ca = new CabeceraAviso();
                ca.setClase_aviso(rs.getString("clase_aviso"));
                ca.setTexto_breve(rs.getString("texto_breve"));
                ca.setFolio_sam(rs.getString("folio_sam"));
                ca.setNum_orden(rs.getString("num_orden"));
                c.add(ca);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaModificarAviso (ACC_Cabecera_Aviso) por:" + ex);
        }
        finally{
                  try{
                    if(conn != null)con.CerrarConexion(conn);
                    if(pst != null)pst.close();
                    if(rs != null)rs.close();
                  }catch(Exception a){
                      System.err.println("Error inesperado al cerrar conexiones");
                  }
        }
        return c;
    }
        
        
 public boolean ACTULIZAVCABMOD(String folio,String hor,String fecha,String centrop,String claseAviso,String textobreve,String equipo,String cod1,String codi2,String statOR,String material,String ubitec,String grupop,String puestot,String centro,String depres,String depres2,String responsable,String responsable2,String autor,String desc) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        int validar;
        PreparedStatement pst = null;
        ResultSet rs  = null;
        String query = "{call PM.cabecera_avisos_creaACTAULAVMO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {            
            pst = conn.prepareStatement(query);
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
            validar = pst.executeUpdate();
            if (validar > 0) {
                 return true;
            }
               
        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        }
        finally{
              try {            
                 if (conn != null) {con.CerrarConexion(conn);}
                 if(rs != null){rs.close();}
                 if(pst != null){pst.close();}
               
        } catch (Exception ex) {
            System.err.println("Error en metodo Guardar (ACC_Aviso) por:" + ex);
        }  
                }
        
        return false;
    }        
 
    public static void main(String[] args) {
        System.out.println(ACC_Cabecera_aviso.ObtenerInstancia().CArgarDatVIS("AV21000003"));
    }
}
