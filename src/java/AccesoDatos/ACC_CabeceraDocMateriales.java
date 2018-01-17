/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.cabecera_doc_materiales;
import Entidades.movimientos_detalle_crea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Zil
 */
public class ACC_CabeceraDocMateriales {

    private static ACC_CabeceraDocMateriales Instance = null;

    public static ACC_CabeceraDocMateriales ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_CabeceraDocMateriales();
        }
        return Instance;
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM cabecera_doc_materiales WHERE num_doc_material = '4900000039'";
        System.out.println(ACC_CabeceraDocMateriales.ObtenerInstancia().ConsultaCabeceraById(query));

    }

    public int ValidarDocMaterialesSAM(String Doc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int ban = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.DcoumentosMaterial_ValidarDocSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Doc);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarDocMaterialesSAM por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarDocMaterialesSAP(String Doc) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        int ban = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.DcoumentosMaterial_ValidarDocSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Doc);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarDocMaterialesSAP por" + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public cabecera_doc_materiales CargarDatosCabeceraSAP(String Id) {
        cabecera_doc_materiales cd = new cabecera_doc_materiales();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.DocumentosMaterial_CargarDatosCabeceraSAP(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cd.setNum_doc_material(rs.getString("num_doc_material"));
                cd.setFolio_sam(rs.getString("folio_sam"));
                cd.setEjercicio_doc_material(rs.getString("ejercicio_doc_material"));
                cd.setFecha_doc_en_doc(rs.getString("fecha_doc_en_doc"));
                cd.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
                cd.setNum_nota_entrega_externa(rs.getString("num_nota_entrega_externa"));
                cd.setNum_carta_porte_entrada_mercancias(rs.getString("num_carta_porte_entrada_mercancias"));
                cd.setTexto_cabecera_doc(rs.getString("texto_cabecera_doc"));
                cd.setNum_cuenta_proveedor_acreedor(rs.getString("num_cuenta_proveedor_acreedor"));
                cd.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.err.println("Error en CargarDatosCabeceraSAP por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cd;
    }

    public cabecera_doc_materiales CargarDatosCabeceraSAM(String Id) {
        cabecera_doc_materiales cd = new cabecera_doc_materiales();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL MM.DocumentosMaterial_CargarDatosCabeceraSAM(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cd.setFolio_sam(rs.getString("folio_sam"));
                cd.setFecha_doc_en_doc(rs.getString("fecha"));
                cd.setNum_nota_entrega_externa(rs.getString("num_nota_entrega_externa"));
                cd.setNum_carta_porte_entrada_mercancias(rs.getString("texto"));
                cd.setTexto_cabecera_doc(rs.getString("texto_cabecera"));
                if (!(rs.getString("num_cuenta_proveedor").equals(""))) {
                    cd.setNum_cuenta_proveedor_acreedor(rs.getString("num_cuenta_proveedor"));
                    cd.setNombre(rs.getString("nombre1"));
                }
            }
        } catch (Exception e) {
            System.err.println("Error en CargarDatosCabeceraSAM por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cd;
    }

    public LinkedList<cabecera_doc_materiales> ConsultaCabeceraById(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<cabecera_doc_materiales> cdocs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                cabecera_doc_materiales cd = new cabecera_doc_materiales();
                cd.setId_cd(rs.getInt("id_cd"));
                cd.setNum_doc_material(rs.getString("num_doc_material"));
                cd.setEjercicio_doc_material(rs.getString("ejercicio_doc_material"));
                cd.setFecha_doc_en_doc(rs.getString("fecha_doc_en_doc"));
                cd.setFecha_contabilizacion_doc(rs.getString("fecha_contabilizacion_doc"));
                cd.setNum_nota_entrega_externa(rs.getString("num_nota_entrega_externa"));
                cd.setNum_carta_porte_entrada_mercancias(rs.getString("num_carta_porte_entrada_mercancias"));
                cd.setTexto_cabecera_doc(rs.getString("texto_cabecera_doc"));
                cd.setNum_cuenta_proveedor_acreedor(rs.getString("num_cuenta_proveedor_acreedor"));
                cd.setNombre(rs.getString("nombre"));

                cdocs.add(cd);
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return cdocs;
    }

    public cabecera_doc_materiales ConsultaPosFol(String valor) {
        String query = "SELECT * FROM cabecera_doc_materiales where folio_sam = '" + valor + "' OR num_doc_material = '" + valor + "'";
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        cabecera_doc_materiales dm = new cabecera_doc_materiales();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dm.setNum_doc_material(rs.getString("num_doc_material"));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        cnx.CerrarConexion(con);
        return dm;
    }

    public LinkedList<cabecera_doc_materiales> ConsultaCabeceraCrea(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<cabecera_doc_materiales> cdocs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                cabecera_doc_materiales cd = new cabecera_doc_materiales();
                cd.setNum_doc_material(rs.getString("folio_sam"));
                //cd.setEjercicio_doc_material(rs.getString("ejercicio_doc_material"));
                cd.setFecha_doc_en_doc(rs.getString("fecha"));
                cd.setFecha_contabilizacion_doc(rs.getString("fecha"));
                cd.setNum_nota_entrega_externa(rs.getString("num_nota_entrega_externa"));
                cd.setNum_carta_porte_entrada_mercancias(rs.getString("texto"));
                cd.setTexto_cabecera_doc(rs.getString("texto_cabecera"));
                //cd.setNum_cuenta_proveedor_acreedor(rs.getString("num_cuenta_proveedor_acreedor"));
                //cd.setNombre(rs.getString("nombre"));

                cdocs.add(cd);
            }
        } catch (Exception e) {
            System.err.println("Error en el CargarTodoMaterial (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return cdocs;
    }

    public ArrayList<cabecera_doc_materiales> MCDocumentos(String clase, String docu) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<cabecera_doc_materiales> mc = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocumentos_MCDocumentos(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase);
            ps.setString(2, docu);
            rs = ps.executeQuery();
            while (rs.next()) {
                cabecera_doc_materiales c = new cabecera_doc_materiales();
                c.setClase_movimiento(rs.getString("clase_movimiento"));
                c.setNum_doc_material(rs.getString("num_doc_material"));
                c.setFolio_sam(rs.getString("folio_sam"));
                mc.add(c);
            }
        } catch (Exception e) {
            System.err.println();
        } finally {
            cnx.CerrarConexion(con);
        }
        return mc;
    }

    public int Verfi311(String folio, String user) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocumentos_Aceptar311WS(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en Verfi311 por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    public int VerRechazo(String folio) {
        int ban = 0;
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocumento_ValidarRechazo311(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en VerRechazo por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    public int ValidarMov311(String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocumentos_ValidaMovGenerado(?)}";
        int ban = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            rs.next();
            String a = rs.getString(1);
            if(!a.equals("0")){
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarMovHecho por : " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    public int ValidarPosMov(String folio) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call MM.VisualizarDocumentos_ValidarPos311(?)}";
        int ban = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            rs.next();
            String a = rs.getString(1);
            if(a.equals("0")){
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarMovHecho por : " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
}
