package AccesoDatos;

import Entidades.clase_orden;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_ClaseOrden {

    private static ACC_ClaseOrden instance = null;

    public static ACC_ClaseOrden ObtenerInstancia() {
        if (instance == null) {
            instance = new ACC_ClaseOrden();
        }
        return instance;
    }

    public LinkedList<clase_orden> ConsultarClaseOrden(String query, String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<clase_orden> clas = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                clase_orden cl = new clase_orden();
                cl.setClase_orden(rs.getString("clase_orden"));
                cl.setDescripcion(rs.getString(des));
                clas.add(cl);
            }
        } catch (Exception e) {
            System.err.println("Error en meotodo ConsultarClase Orden(ACC_ClaseOrden) por: " + e);
        }
        cnx.CerrarConexion(con);
        return clas;
    }

    public ArrayList ConsultaClaseOrdenOrd(String idioma) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList clo = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String ProcOrg = "{call PM.Ordenes_ConsultarClaseOrden}";
        String des = "descripcion_" + idioma;
        try {
            ps = con.prepareStatement(ProcOrg);
            rs = ps.executeQuery();
            while (rs.next()) {
                clase_orden c = new clase_orden();
                c.setClase_orden(rs.getString("clase_orden"));  
                c.setDescripcion(rs.getString(des));
                clo.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMCOrgCompras por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return clo;
    }

    public int ValidarClaseOrden(String clOr) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT clase_orden FROM clase_orden WHERE clase_orden='" + clOr + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String cl = rs.getString("clase_orden");
                if (cl.equals(clOr)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarClaseOrden (ACC_ClaseOrden) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
    public ArrayList<clase_orden> ConsultarClaseOrdenAV(String des) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList<clase_orden> clas = new ArrayList<>();
        String query = "{call PM.clase_orden_ConsultarClaseOrden}";
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                clase_orden cl = new clase_orden();
                cl.setClase_orden(rs.getString("clase_orden"));
                cl.setDescripcion(rs.getString(des));
                clas.add(cl);
            }
        } catch (Exception e) {
            System.err.println("Error en meotodo ConsultarClase Orden(ACC_ClaseOrden) por: " + e);
        }
        finally{
            try{
                if(con != null){cnx.CerrarConexion(con);}
                if(rs != null){rs.close();}
                if(pst != null){pst.close();}
            }
            catch(Exception a) {
            System.err.println("Error en meotodo ConsultarClase Orden(ACC_ClaseOrden) por: " + a);
            }
        }
        return clas;
    }
    
    //MOSTRAR CLASE DE ORDEN EN ORDENES PP
    public ArrayList ConsultaClaseOrdenOrdPP(String idioma) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList clo = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String ProcOrg = "{call PP.Ordenes_ConsultarClaseOrdenPP}";
        String des = "descripcion_" + idioma;
        try {
            ps = con.prepareStatement(ProcOrg);
            rs = ps.executeQuery();
            while (rs.next()) {
                clase_orden c = new clase_orden();
                c.setClase_orden(rs.getString("clase_orden"));  
                c.setDescripcion(rs.getString(des));
                clo.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaMCOrgCompras por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return clo;
    }
    
}
