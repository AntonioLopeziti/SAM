/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Solped_posiciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
/**
 *
 * @author JaroMX
 */
public class ACC_Solped_posiciones {
        Conexion cnx = new Conexion();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    String query;
    private static ACC_Solped_posiciones Instance = null;

    public static ACC_Solped_posiciones ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Solped_posiciones();
        }
        return Instance;
    } 
    
    public LinkedList<Solped_posiciones> ObtenerFolioSAP(String query, String tipo){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<Solped_posiciones> sp = new LinkedList<>();
            try{
                Statement st;
                ResultSet rs;
                st = con.createStatement();
                rs = st.executeQuery(query);
                    while(rs.next()){
                        Solped_posiciones s = new Solped_posiciones();
                        s.setOrganización_compras(rs.getString("organización_compras"));
                    }
            }catch(Exception ex){
                System.err.println("Error en el metodo ObtenerDatos por:" + ex);
            }
        return sp;
    }
    
    /*Cargar Datos Visualizar Solped*/
    public Solped_posiciones CargarDatos(String folio, String tipo){
    Conexion cnx = new Conexion();
    Connection con = cnx.ObtenerConexion();
    Solped_posiciones sp = new Solped_posiciones();
    String foliotipo = "folio_"+tipo;
    String query = "SELECT * FROM  solped_posiciones_vis WHERE "+foliotipo+" = '"+folio+"'";
    
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
                while(rs.next()){
                    sp.setFolio_sam(rs.getString("folio_sam"));
                    sp.setGrupo_compras(rs.getString("grupo_compras"));
                    sp.setOrganización_compras(rs.getString("organización_compras"));
                    sp.setTexto_cabecera(rs.getString("texto_cabecera"));
                }
        }catch(Exception ex){
            System.err.println("Error en el metodo CargarDatos por:" + ex);
        };
    cnx.CerrarConexion(con);
    return sp;
    }
    /*------------------------------*/
    /*Cargar Datos a tabla*/
    public LinkedList<Solped_posiciones> ObtenerDatosTabla(String query){
       Conexion cnx = new Conexion();
       Connection con = cnx.ObtenerConexion();
       LinkedList<Solped_posiciones> sp = new LinkedList<>();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
                while (rs.next()){
                    Solped_posiciones s = new Solped_posiciones();
                    s.setFolio_sam(rs.getString("folio_sam"));
                    s.setNum_posicion_solped(rs.getString("num_posicion_solped"));
                    s.setTipo_posicion_doc_compras(rs.getString("tipo_posicion_doc_compras"));
                    s.setNum_material(rs.getString("num_material"));
                    s.setTipo_imputacion(rs.getString("tipo_imputacion"));
                    s.setTexto_breve(rs.getString("texto_breve"));
                    s.setCantidad_solped(rs.getString("cantidad_solped"));
                    s.setUnidad_medida_solped(rs.getString("unidad_medida_solped"));
                    s.setFecha_entrega(rs.getString("fecha_entrega"));
                    s.setGrupo_articulos(rs.getString("grupo_articulos"));
                    s.setCentro(rs.getString("centro"));
                    s.setAlmacen(rs.getString("almacen"));
                    s.setGrupo_compras(rs.getString("grupo_compras"));
                    s.setSolicitante(rs.getString("solicitante"));
                    s.setProveedor_deseado(rs.getString("proveedor_deseado"));
                    s.setNum_contrato_superior(rs.getString("num_contrato_superior"));
                    s.setNum_posicion_contrato_superior(rs.getString("num_posicion_contrato_superior"));
                }
        }catch(Exception ex){
            System.err.println("Error en el metofo ObtenerDatosTabla por: "+ex);
        }
       return sp;
    }
    /*--------------------*/
}
