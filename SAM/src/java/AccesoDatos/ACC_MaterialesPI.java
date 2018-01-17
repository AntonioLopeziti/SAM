/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.MaterialesPI;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonathan Lopez
 */
public class ACC_MaterialesPI {

    private static ACC_MaterialesPI Instance = null;

    public static ACC_MaterialesPI ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_MaterialesPI();
        }
        return Instance;
    }

    public static void main(String[] args) {
        ACC_MaterialesPI m = new ACC_MaterialesPI();
        System.out.println(m.ValidarMaterial(""));
    }

    public boolean ValidarMaterial(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;        
        try {
            pst = con.prepareCall("{call QM.InspMat_ValMat(?)}");
            pst.setString(1, mat);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);                
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarMaterial ACC_MaterialesPI por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public LinkedList<MaterialesPI> ConsultaMatchMaterial(String query) {
        LinkedList<MaterialesPI> mat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                MaterialesPI m = new MaterialesPI();
                m.setNum_material(rs.getString("num_material"));
                m.setTexto_breve_material(rs.getString("texto_breve_material"));
                m.setCentro(rs.getString("centro"));
                mat.add(m);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
        }
        return mat;
    }

    public MaterialesPI CargarDatosVisualMa(String mate, String centro, String grupohoja) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        MaterialesPI ma = new MaterialesPI();
        try {
            pst = con.prepareCall("{call QM.InspMat_CargarDatos(?,?,?)}");
            pst.setString(1, mate);
            pst.setString(2, centro);
            pst.setString(3, grupohoja);
            rs = pst.executeQuery();          
            while (rs.next()) {
                
                ma.setNum_material(rs.getString("num_material"));
                ma.setTexto_breve_material(rs.getString("texto_breve_material"));
                ma.setTipo_hoja_ruta(rs.getString("tipo_hoja_ruta"));
                ma.setContador_grupo_hoja_ruta(rs.getString("contador_grupo_hoja_ruta"));
                ma.setContador_criterios_adicionales(rs.getString("contador_criterios_adicionales"));
                ma.setContador_interno(rs.getString("contador_interno"));
            }
        } catch (Exception e) {
            System.err.println("Error en el metodoCargarDatosVisualMa (ACC_Material) por: " + e);
        }
        cnx.CerrarConexion(con);
        return ma;
    }
    public ArrayList<MaterialesPI> ConsultaOperacioness(String materi, String centro, String grupo){
        ArrayList<MaterialesPI> cen = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null; 
        try{
            pst = con.prepareCall("{call QM.InspMat_MostOpera(?,?,?)}");
            pst.setString(1, materi);
            pst.setString(2, centro);
            pst.setString(3, grupo);
            rs = pst.executeQuery();
            while(rs.next()){
                MaterialesPI ar = new MaterialesPI();
                ar.setNum_nodo_hoja_ruta(rs.getString("num_nodo_hoja_ruta"));
                ar.setNum_operacion(rs.getString("num_operacion"));
                ar.setClave_control(rs.getString("clave_control"));
                ar.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                ar.setVariante_proceso_cierre_punto_inspeccion(rs.getString("variante_proceso_cierre_punto_inspeccion"));
                cen.add(ar);
            }
            
        }catch(Exception e) {
            System.err.println("Error en Consulta Operaciones por: " + e);
        }finally{
            try{
                if(con != null)cnx.CerrarConexion(con);
                if(pst != null)pst.close();
                if(rs != null)rs.close();
            }catch(Exception a){
                  System.err.println("Error inesperado al cerrar conexiones");
            }            
        }
        return cen;
    }
    

    public ArrayList<MaterialesPI> ConsultaCaracterisitcass(String materica,String centroo,String gpoo,String operacion) {
        ArrayList<MaterialesPI> mca = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null; 
        try {
            pst = con.prepareCall("{call QM.InspMat_MostCaract(?,?,?,?)}");
            pst.setString(1, materica);
            pst.setString(2, centroo);
            pst.setString(3, gpoo);
            pst.setString(4, operacion);
            rs = pst.executeQuery();
            while (rs.next()) {
                MaterialesPI ar = new MaterialesPI();
                ar.setVariante_proceso_cierra_punto_inspeccion(rs.getString("variante_proceso_cierra_punto_inspeccion"));
                ar.setTexto_breve_caracteristicas_inspeccion(rs.getString("texto_breve_caracteristicas_inspeccion"));
                ar.setClave_idioma_caracteristicas(rs.getString("clave_idioma"));
                ar.setProcedimiento_muestro_carac_inspeccion(rs.getString("procedimiento_muestro_carac_inspeccion"));
                ar.setUnidad_medida_muestra(rs.getString("unidad_medida_muestra"));
                ar.setFactor_cantidad_muestra(rs.getString("factor_cantidad_muestra"));
                ar.setEntrada_catalogo_conjunto_seleccion(rs.getString("entrada_catalogo_conjunto_seleccion"));
                ar.setCl_catalogo_grupo_codigo(rs.getString("cl_catalogo_grupo_codigo"));
                ar.setGrupo_codigo_conjunto_seleccion(rs.getString("grupo_codigo_conjunto_seleccion"));
                ar.setCentro_caracteristicas(rs.getString("centro"));
                ar.setBarra_ind_impuesto_caract_inspeccion(rs.getString("barra_ind_impuesto_caract_inspeccion"));
                mca.add(ar);
            }            
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }finally{
            try{
                if(con != null)cnx.CerrarConexion(con);
                if(pst != null)pst.close();
                if(rs != null)rs.close();
            }catch(Exception a){
                  System.err.println("Error inesperado al cerrar conexiones");
            }            
        }
        return mca;
    }

    public LinkedList<MaterialesPI> ConsultaMatchGrupo(String query) {
        LinkedList<MaterialesPI> cen = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                MaterialesPI c = new MaterialesPI();
                c.setNum_material(rs.getString("num_material"));
                c.setTexto_breve_material(rs.getString("texto_breve_material"));
                c.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                cen.add(c);
            }
            cnx.CerrarConexion(con);
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_MaterialesPI) " + e);
        }
        return cen;
    }

    public boolean ValidarGRP(String grupo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareCall("{call QM.InspMat_ValHojaRuta(?)}");
            pst.setString(1, grupo);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);                
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error en ValidarOCompras ACC_MaterialesPI por: " + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public MaterialesPI ObtenerDatosMateLI(String mate) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        MaterialesPI m = new MaterialesPI();
        String query = "SELECT TOP 1  * FROM materiales_planes_inspeccion WHERE num_material='" + mate + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                m.setNum_material(rs.getString("num_material"));
                m.setTexto_breve_material(rs.getString("texto_breve_material"));
                m.setCentro(rs.getString("centro"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return m;
    }
    
//    public LinkedList<MaterialesPI>CaractericticasPI(String mate){
//        
//    }
    
    //Planes de Inspeccion Nuevo
    public ArrayList <MaterialesPI> ConsultaMatchPlaInsMaterial(String mate, String texto_mate, String cetr, String limite){
        ArrayList <MaterialesPI> mat = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = con.prepareCall("{call QM.InspMat_ConsMat(?,?,?,?)}");
            pst.setString(1,mate);
            pst.setString(2,texto_mate);
            pst.setString(3,cetr);
            pst.setString(4,limite);   
            rs = pst.executeQuery();
            while(rs.next()){
                MaterialesPI mp = new MaterialesPI();
                mp.setNum_material(rs.getString("num_material"));
                mp.setTexto_breve_material(rs.getString("texto_breve_material"));
                mp.setCentro(rs.getString("centro"));
                mat.add(mp);
            }
        }catch(Exception e){
            System.err.println("Error al traer los datos"+e);
        }finally{
            try{
                if(con != null)cnx.CerrarConexion(con);
                if(pst != null)pst.close();
                if(rs != null)rs.close();
            }catch(Exception a){
                System.err.println("Error inesperado al cerrar conexiones"+a);
            }
        }
        return mat;
    }
    //Planes Inspeccion Consulta Hoja Ruta
    public ArrayList <MaterialesPI >ConsultarMatchPlaInsHojaRuta(String matgrp){
        ArrayList <MaterialesPI> hoja = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = con.prepareCall("{call QM.InspMat_ConsHoRuta(?)}");
            pst.setString(1,matgrp); 
            rs = pst.executeQuery();
            while(rs.next()){
                MaterialesPI mp = new MaterialesPI();
                mp.setClave_grupo_hoja_ruta(rs.getString("clave_grupo_hoja_ruta"));
                mp.setNum_material(rs.getString("num_material"));
                mp.setTexto_breve_material(rs.getString("texto_breve_material"));                
                hoja.add(mp);
            }
        }catch(Exception e){
            System.err.println("Error al traer los datos"+e);
        }finally{
            try{
                if(con != null)cnx.CerrarConexion(con);
                if(pst != null)pst.close();
                if(rs != null)rs.close();
            }catch(Exception a){
                System.err.println("Error inesperado al cerrar conexiones"+a);
            }
        }
        return hoja;
    }
}
