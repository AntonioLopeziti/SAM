/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author AreConsulting
 */
public class ACC_SolpedReporte {
    
     private static ACC_SolpedReporte Instance = null;

    public static ACC_SolpedReporte ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_SolpedReporte();
        }
        return Instance;
    }
    
    
    
      public LinkedList<String[]> ConsultaSolpedCrea(String query) {
          
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[45];
                d[0] = rs.getString("id_spc");
                d[1] = rs.getString("folio_sam");
                d[2] = rs.getString("num_posicion_solped");
                d[3] = rs.getString("tipo_posicion_doc_compras");
                d[4] = rs.getString("num_material");
                d[5] = rs.getString("fecha");
                d[6] = rs.getString("hora_dia");
                d[7] = rs.getString("num_solped");
                d[8] = rs.getString("clase_documento_solped");
                d[9] = rs.getString("tipo_imputacion");
               d[10] = rs.getString("texto_breve");
               d[11] = rs.getString("cantidad_solped");
               d[12] = rs.getString("unidad_medida_solped");
               d[13] = rs.getString("tipo_fecha");
               d[14] = rs.getString("fecha_entraga_posicion");
               d[15] = rs.getString("grupo_articulos");
               d[16] = rs.getString("centro");
               d[17] = rs.getString("almacen");
               d[18] = rs.getString("grupo_compras");
               d[19] = rs.getString("solicitante");
               d[20] = rs.getString("fecha_solicitud");
               d[21] = rs.getString("proveedor_deseado");
               d[22] = rs.getString("num_cuenta_proveedor"); 
               d[23] = rs.getString("indice_registro_no_valido");
               d[24] = rs.getString("tipo_posicion_doc_compras2");
               d[25] = rs.getString("num_registro_info_compras");
               d[26] = rs.getString("organizacion_compras");
               d[27] = rs.getString("num_cuenta_mayor");
               d[28] = rs.getString("centro_coste");
               d[29] = rs.getString("num_contrato_superior"); 
               d[30] = rs.getString("num_posicion_contrato_superior");
               d[31] = rs.getString("indicador_distribucion_imputacion_multiple");
               d[32] = rs.getString("num_cuenta_mayor2");
               d[33] = rs.getString("num_orden");
               d[34] = rs.getString("sociedad_co");
               d[35] = rs.getString("centro_coste2");
               d[36] = rs.getString("texto_cabecera");
               d[37] = rs.getString("texto_posicion");
               d[38] = rs.getString("recibido");
               d[39] = rs.getString("procesado");
               d[40] = rs.getString("modificado");
               d[41] = rs.getString("error");
               d[42] = rs.getString("precio_solped");
               d[43] = rs.getString("clave_moneda");
               d[44] = rs.getString("SolicitanteTemp");
                
                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta solped vis por: " + e);
        }
        cnx.CerrarConexion(con);
        return docs;
    }

   public LinkedList<String[]> ConsultaSolpedServiciosCrea(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[23];
                d[0] = rs.getString("id_sps");
                d[1] = rs.getString("folio_sam");
                d[2] = rs.getString("num_posicion_solped");
                d[3] = rs.getString("num_posicion_solped2");
                d[4] = rs.getString("num_servicio");
                d[5] = rs.getString("fecha");
                d[6] = rs.getString("hora_dia");
                d[7] = rs.getString("texto_breve");
                d[8] = rs.getString("cantidad");
                d[9] = rs.getString("unidad_medida_base");
               d[10] = rs.getString("cantidad_base");
               d[11] = rs.getString("precio_bruto");
               d[12] = rs.getString("grupo_articulos");
               d[13] = rs.getString("num_cuenta_mayor");
               d[14] = rs.getString("centro_coste");
               d[15] = rs.getString("num_orden");
               d[16] = rs.getString("num_solped");
               d[17] = rs.getString("recibido");
               d[18] = rs.getString("procesado");
               d[19] = rs.getString("modificado");
               d[20] = rs.getString("error");
               d[21] = rs.getString("solicitante");
               d[22] = rs.getString("SolicitanteTemp"); 
              
                
                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta solped vis por: " + e);
        }
        cnx.CerrarConexion(con);
        return docs;
    }
     
     
     
     
     
     
     
     
    public LinkedList<String[]> ConsultaPosiciones(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[41];
                d[0] = rs.getString("num_posicion_solped");
                d[1] = rs.getString("tipo_posicion_doc_compras");
                d[2] = rs.getString("num_material");
                d[3] = rs.getString("fecha");
                d[4] = rs.getString("hora_dia");
                d[5] = rs.getString("clase_doc_solped");
                d[6] = rs.getString("tipo_imputacion");
                d[7] = rs.getString("texto_breve");
                d[8] = rs.getString("cantidad_solped");
                d[9] = rs.getString("cantidad_solped");
               d[10] = rs.getString("unidad_medida_solped");
               d[11] = rs.getString("tipo_fecha");
               d[12] = rs.getString("fecha_entrega");
               d[13] = rs.getString("grupo_articulos");
               d[14] = rs.getString("centro");
               d[15] = rs.getString("almacen");
               d[16] = rs.getString("grupo_compras");
               d[17] = rs.getString("solicitante");
               d[18] = rs.getString("fecha_solicitud");
               d[19] = rs.getString("proveedor_deseado");
               d[20] = rs.getString("num_cuenta_proveedor");
               d[21] = rs.getString("indice_registro_no_valido");
               d[22] = rs.getString("tipo_posicion_doc_compras2"); 
               d[23] = rs.getString("num_registro_info_compras");
               d[24] = rs.getString("organización_compras");
               d[25] = rs.getString("num_cuenta_mayor");
               d[26] = rs.getString("centro_coste");
               d[27] = rs.getString("num_contrato_superior");
               d[28] = rs.getString("num_posicion_contrato_superior");
               d[29] = rs.getString("indicador_distribucion_imputacion_multiple"); 
               d[30] = rs.getString("num_cuenta_mayor2");
               d[31] = rs.getString("num_orden");
               d[32] = rs.getString("sociedad_co");
               d[33] = rs.getString("centro_coste2");
               d[34] = rs.getString("texto_cabecera");
               d[35] = rs.getString("texto_posicion");
               d[36] = rs.getString("recibido");
               d[37] = rs.getString("procesado");
               d[38] = rs.getString("error");
               d[39] = rs.getString("precio_solped");
               d[40] = rs.getString("clave_moneda");
                
                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta solped vis por: " + e);
        }
        cnx.CerrarConexion(con);
        return docs;
    }

    
        public LinkedList<String[]> ConsultaServicios(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[40];
                d[0] = rs.getString("num_solped");
                d[1] = rs.getString("num_posicion_solped");
                d[2] = rs.getString("num_linea");
                d[3] = rs.getString("num_servicio");
                d[4] = rs.getString("cantidad");
                d[5] = rs.getString("unidad_medida_base");
                d[6] = rs.getString("texto_breve");
                d[7] = rs.getString("precio_bruto");
                d[8] = rs.getString("clave_moneda");
                d[9] = rs.getString("centro_coste");
               d[10] = rs.getString("valor_neto_posicion");

                
                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta solped_servicoos vis por: " + e);
        }
        cnx.CerrarConexion(con);
        return docs;
    }

        
        
          public String ObtenerNumeroSer(String query){
       Conexion cnx = new Conexion();
       Connection con = cnx.ObtenerConexion();
       //LinkedList<Solped_posiciones> sp = new LinkedList<>();
       String num="";
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
                while (rs.next()){
                    //Solped_posiciones s = new Solped_posiciones();
                    num= rs.getString("count");
            
                }
        }catch(Exception ex){
            System.err.println("Error en el metofo ObtenerNumDatosServ por: "+ex);
        }
        cnx.CerrarConexion(con);
       return num;
    }
     public LinkedList<String[]> ConsultaMatchFiltro(String query, String dato ) {
        
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        LinkedList<String[]> docs = new LinkedList();

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String[] d = new String[1];
                d[0] = rs.getString(dato);
              
               
                docs.add(d);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta solped_posiciones vis por: " + e);
        }
        cnx.CerrarConexion(con);
        return docs;
    }
    
}
