package AccesoDatos;

import Entidades.puesto_trabajo;
import Entidades.ubicacion_tecnica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.servlet.http.HttpSession;

public class ACC_PuestoTrabajo {

    private static ACC_PuestoTrabajo Instance = null;

    public static ACC_PuestoTrabajo ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_PuestoTrabajo();
        }
        return Instance;
    }

    /*Crear-Modificar Avisos*/
    public LinkedList<puesto_trabajo> AvisoPuestoTrabajo(String query, String denominacion) {
        LinkedList<puesto_trabajo> pt = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                puesto_trabajo p = new puesto_trabajo();
                p.setCentro(rs.getString("centro"));
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setDenominacion(rs.getString(denominacion));
                pt.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo AvisoPuestoTrabajo (ACC_PuestoTrabajo por: )" + ex);
        }
        return pt;
    }

    /*-----------------------*/
    public int ValidaPuesTrab(String da,String puestot,String centro) {
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        CallableStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.puesto_trabajo_ValidaPuesTrab(?,?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1, puestot);
            pst.setString(2, centro);
             rs = pst.executeQuery();
            while (rs.next()) {
                String pt = rs.getString("puesto_trabajo");
                String ce = rs.getString("centro");
                if (da.equals(pt) || da.equals(ce)) {
                    return 1;
                } else {
                    return 0;
                }

            }

        } catch (Exception e) {
            System.err.println("Error; " + e);
        }

        finally{
            try{
              if(conn != null)con.CerrarConexion(conn);
              if(pst != null)pst.close();
              if(rs !=null)rs.close();
            }
            catch(Exception ex){
                System.err.println("Error: "+ex);
            }
        }
        return 0;
    }

    public LinkedList<puesto_trabajo> ConsultaMatchPuestoTrabajoTabla(String query, String denominacion) {
        LinkedList<puesto_trabajo> pt = new LinkedList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                puesto_trabajo p = new puesto_trabajo();
                p.setCentro(rs.getString("centro"));
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setDenominacion(rs.getString(denominacion));
                pt.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo AvisoPuestoTrabajo (ACC_PuestoTrabajo por: )" + ex);
        }
        return pt;
    }

     public ArrayList ConsultaMatchPuestoTrabajoOrd(String clsPto, String centro, String ptoTr, String denominacion, String campoDen, String ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList pts = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        puesto_trabajo p;
        String SP = "{CALL PM.Ordenes_ConsultarPtoTr(?, ?, ?, ?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, clsPto);
            ps.setString(2, centro);
            ps.setString(3, ptoTr);
            ps.setString(4, denominacion);
            ps.setString(5, campoDen);
            ps.setString(6, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new puesto_trabajo();
                p.setCentro(rs.getString("centro"));
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setDenominacion(rs.getString(campoDen));
                pts.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchPuestoTrabajo(ACC_PuestoTrabajo por: )" + ex);
        }finally {
            cnx.CerrarConexion(con);
        }
        return pts;
    }

    public int ValidarPtoTr(String ptoTr) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT puesto_trabajo FROM puesto_trabajo WHERE puesto_trabajo='" + ptoTr + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String pt = rs.getString("puesto_trabajo");
                if (pt.equals(ptoTr)) {
                    cnx.CerrarConexion(con);
                    return 1;
                } else {
                    cnx.CerrarConexion(con);
                    return 0;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ValidarPtoTr (ACC_PuestoTrabajo) por: " + e);
        }
        cnx.CerrarConexion(con);
        return 0;
    }
    
      public ArrayList<puesto_trabajo> SP_MatchPuestoListaorden(String Cant, String Idioma, String Puesto, String denPt) {
        ArrayList<puesto_trabajo> pue = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.MatchPuestoListaorden(?,?,?,?)}";
        String denominacion = "denominacion_" + Idioma;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Cant);
            pst.setString(2, denominacion);
            pst.setString(3, denPt);
            pst.setString(4, Puesto);
            rs = pst.executeQuery();
            while (rs.next()) {
                puesto_trabajo p = new puesto_trabajo();
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setDenominacion(rs.getString(denominacion));
                pue.add(p);
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

        return pue;
    }
    public LinkedList<puesto_trabajo> elAvisoPuestoTrabajo(String ctdmax,String y,String descripcion,String centro,String puestot) {
        LinkedList<puesto_trabajo> pt = new LinkedList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        ResultSet rs= null;
        CallableStatement pst = null;
        String query = "{call PM.puesto_trabajo_elAvisoPuestoTrabajo(?,?,?,?,?)}";
        try {
            pst = conn.prepareCall(query);
            pst.setString(1,ctdmax );
            pst.setString(2, y);
            pst.setString(3,descripcion );
            pst.setString(4, centro);
            pst.setString(5, puestot);
            rs = pst.executeQuery();
            while (rs.next()) {
                puesto_trabajo p = new puesto_trabajo();
                p.setCentro(rs.getString("centro"));
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setDenominacion(rs.getString(y));
                pt.add(p);
            }
        } catch (Exception ex) {
            System.err.println("Error en el metodo AvisoPuestoTrabajo (ACC_PuestoTrabajo por: )" + ex);
        }
        finally{
            try{
                if(conn != null)con.CerrarConexion(conn);
                if(pst != null)pst.close();
                if(rs != null)rs.close();
            }
            catch(Exception e){
                System.err.println("Error :"+e);
            }
        }
        return pt;
    }
    
    public ArrayList<puesto_trabajo> SP_MatchPuestoListaordenPP(String Cant, String Idioma, String Puesto, String denPt) {
        ArrayList<puesto_trabajo> pue = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.MatchPuestoListaordenPP(?,?,?,?)}";
        String denominacion = "denominacion_" + Idioma;
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Cant);
            pst.setString(2, denominacion);
            pst.setString(3, denPt);
            pst.setString(4, Puesto);
            rs = pst.executeQuery();
            while (rs.next()) {
                puesto_trabajo p = new puesto_trabajo();
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setDenominacion(rs.getString(denominacion));
                pue.add(p);
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

        return pue;
    }
    
   public static void main(String[] args){
       System.out.println(ACC_PuestoTrabajo.ObtenerInstancia().ValidaPuesTrab("BAJA", "BAJA", ""));
   }
   
   //Consultar Match Para Ordenes PP
   public ArrayList ConsultaMatchPuestoTrabajoOrdPP(String clsPto, String centro, String ptoTr, String denominacion, String campoDen, String ctd) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList pts = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        puesto_trabajo p;
        String SP = "{CALL PM.Ordenes_ConsultarPtoTr(?, ?, ?, ?, ?, ?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, clsPto);
            ps.setString(2, centro);
            ps.setString(3, ptoTr);
            ps.setString(4, denominacion);
            ps.setString(5, campoDen);
            ps.setString(6, ctd);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new puesto_trabajo();
                p.setCentro(rs.getString("centro"));
                p.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                p.setDenominacion(rs.getString(campoDen));
                pts.add(p);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaMatchPuestoTrabajo(ACC_PuestoTrabajo por: )" + ex);
        }finally {
            cnx.CerrarConexion(con);
        }
        return pts;
    }
}
