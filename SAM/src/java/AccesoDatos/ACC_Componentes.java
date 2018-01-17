/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.componentes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Zil
 */
public class ACC_Componentes {
    
    private static ACC_Componentes Instance = null;
    
    public static ACC_Componentes ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_Componentes();
        }
        
        return Instance;
    }
    
    public componentes CargarDatosComponente(String num) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ResultSet rs;
        Statement st;
        componentes comp = new componentes();
        String query = "SELECT * FROM componentes WHERE num_material='" + num + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                comp.setId_com(rs.getInt("id_com"));
                comp.setNum_orden(rs.getString("num_orden"));
                comp.setNum_material(rs.getString("num_material"));
                comp.setNum_posicion_lista_material(rs.getString("num_posicion_lista_material"));
                comp.setTexto_breve_material(rs.getString("texto_breve_material"));
                comp.setCantidad_necesaria_componente(rs.getString("cantidad_necesaria_componente"));
                comp.setUnidad_medida_base(rs.getString("unidad_medida_base"));
                comp.setTipo_posicion_lista_material(rs.getString("tipo_posicion_lista_material"));
                comp.setIndicador_stock_especial_visualizar_dialogo(rs.getString("indicador_stock_especial_visualizar_dialogo"));
                comp.setAlmacen(rs.getString("almacen"));
                comp.setCentro(rs.getString("centro"));
                comp.setNum_operacion(rs.getString("num_operacion"));
                comp.setNum_lote(rs.getString("num_lote"));
                comp.setDestinatario_mercancias(rs.getString("destinatario_mercancias"));
                comp.setPuesto_descarga(rs.getString("puesto_descarga"));
                comp.setPosicion_borrada(rs.getString("posicion_borrada"));
                comp.setIndicador_material_granel(rs.getString("indicador_material_granel"));
                comp.setIndicador_toma_retroactiva(rs.getString("indicador_toma_retroactiva"));
                comp.setEfectividad_reserva_creacion_solped(rs.getString("efectividad_reserva_creacion_solped"));
            }
            
        } catch (Exception e) {
            System.err.println("Error en metodobCargarDatosVisual ACC_Usuarios por " + e);
        }
        cnx.CerrarConexion(con);
        return comp;
    }

    public LinkedList<componentes> ConsultaMatchMaterial(String query) {
        LinkedList<componentes> mat = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                componentes m = new componentes();
                m.setNum_material(rs.getString("num_material"));
                m.setTexto_breve_material(rs.getString("texto_breve_material"));
                m.setCentro(rs.getString("centro"));
                mat.add(m);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMatchMaterial (ACC_Material) " + e);
        }
        cnx.CerrarConexion(con);
        return mat;
    }
    
    public static void main(String[] args) {
        System.out.println(ACC_Componentes.ObtenerInstancia().CargarDatosComponente("ACCABREIMP"));
    }
}
