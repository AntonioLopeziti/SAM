package AccesoDatos;

import Entidades.ListaMtrl;
import Entidades.bom_equipo;
import Entidades.materiales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class ACC_BOMEquipos {

    private static ACC_BOMEquipos instance = null;

    public static ACC_BOMEquipos ObtenerInstancia() {
        if (instance == null) {
            instance = new ACC_BOMEquipos();
        }
        return instance;
    }
    
    public ArrayList<ListaMtrl> ObtenerLMNotificacionesCrea(String equipo, String lg) {
        ArrayList<ListaMtrl> lm = new ArrayList<>();
        ArrayList<String> mat = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "{CALL PM.Componente_ListaMat(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, equipo);
            rs = ps.executeQuery();
            while(rs.next()){                
                mat.add(rs.getString("componente_listamaterial"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerDatosBOOM por " + e);
        }
        String sql = "{CALL PM.ListaMaterialNotificacionesCrea(?)}";
        try {
            for(String mm : mat){
                ps = con.prepareStatement(sql);
                ps.setString(1, mm);
                rs = ps.executeQuery();
                while(rs.next()){
                    ListaMtrl ll = new ListaMtrl();
                    ll.setMaterial(rs.getString("material"));
                    ll.setPiezaFabricante(rs.getString("materia"));
                    ll.setDescripcion(rs.getString("descripcion_" + lg));
                    ll.setLote(rs.getString("lote"));
                    ll.setStock(rs.getString("stocklibre_utilizacion"));
                    ll.setUm(rs.getString("unidad_medida"));
                    ll.setCentro(rs.getString("centro"));
                    ll.setAlmacen(rs.getString("almacen"));
                    lm.add(ll);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ListaMaterial Noti por: " + e);
        }
        
        finally {
            cnx.CerrarConexion(con);
        }
        return lm;
    }
    public ArrayList<bom_equipo> ObtenerDatosBOOM(String equipo, String Centro, String alter) {
        ArrayList<bom_equipo> bom = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PM.BoomEquipos_ObtenerBOMEquipos(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo);
            ps.setString(2, Centro);
            ps.setString(3, alter);
            rs = ps.executeQuery();
            while(rs.next()){
                bom_equipo b = new bom_equipo();
                b.setUtilizacion_listamaterial(rs.getString("utilizacion_listamaterial"));
                b.setLista_materiales(rs.getString("lista_materiales"));
                b.setCentro_suministrador(rs.getString("centro"));
                b.setComponente_listamaterial(rs.getString("componente_listamaterial"));
                b.setCantidad_componente(rs.getString("cantidad_componente"));
                b.setUnidad_medida_componente(rs.getString("unidad_medida_componente"));
                b.setIndicador_borrado(rs.getString("indicador_borrado"));
                b.setPeticion_borrado_listamaterial(rs.getString("peticion_borrado_listamaterial"));
                bom.add(b);
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerDatosBOOM por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return bom;
    }

    public LinkedList<bom_equipo> ObtenerBomEquipoBOM(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<bom_equipo> be = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bom_equipo b = new bom_equipo();
                b.setUtilizacion_listamaterial(rs.getString("utilizacion_listamaterial"));
                b.setLista_materiales(rs.getString("lista_materiales"));
                b.setCentro_suministrador(rs.getString("centro_suministrador"));
                b.setComponente_listamaterial(rs.getString("componente_listamaterial"));
                b.setCantidad_componente(rs.getString("cantidad_componente"));
                b.setUnidad_medida_componente(rs.getString("unidad_medida_componente"));
                b.setIndicador_borrado(rs.getString("indicador_borrado"));
                b.setPeticion_borrado_listamaterial(rs.getString("peticion_borrado_listamaterial"));
                be.add(b);

            }
        } catch (Exception e) {
            System.err.println("Error en obtenerBomEquipo(ACC_BOMEquipo) por: " + e);
        }
        cnx.CerrarConexion(con);
        return be;
    }

    public ArrayList<materiales> ObtenerBomEquipoBOMOrdenes(String equi, String idi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList boms = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String ProcOrg = "{call PM.Ordenes_ConsultarLstMaterial(?,?)}";
        try {
            ps = con.prepareStatement(ProcOrg);
            ps.setString(1, equi);
            ps.setString(2, idi);
            rs = ps.executeQuery();
            while (rs.next()) {
                materiales bom = new materiales();
                bom.setMaterial(rs.getString("material"));
                bom.setDescripcion(rs.getString("descripcion_" + idi));
                bom.setMateria(rs.getString("materia"));
                bom.setUnidad_medida(rs.getString("unidad_medida"));
                boms.add(bom);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ObtenerBomEquipoBOMOrdenes  por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return boms;
    }

    public LinkedList<bom_equipo> ObtenerLstMat(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        LinkedList<bom_equipo> be = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bom_equipo b = new bom_equipo();
                b.setComponente_listamaterial(rs.getString("componente_listamaterial"));

                be.add(b);

            }
        } catch (Exception e) {
            System.err.println("Error en obtenerBomEquipo(ACC_BOMEquipo) por: " + e);
        }
        cnx.CerrarConexion(con);
        return be;
    }

    public ArrayList ConsultaComponentesByBoomE(String numEqui, String numLst, String alt, String campoDes) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList mts = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        materiales m;
        String SP = "{CALL PM.Ordenes_ValidarEquipoComps(?, ?, ?, ?)}";
        String check;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, numEqui);
            ps.setString(2, numLst);
            ps.setString(3, alt);
            ps.setString(4, campoDes);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (check.equals("0") || check.equals("1")) {
                m = new materiales();
                m.setMaterial(check);
                mts.add(m);
            } else {
                m = new materiales();
                m.setMaterial(rs.getString("material"));
                m.setDescripcion(rs.getString(campoDes));
                m.setUnidad_medida(rs.getString("unidad_medida"));
                mts.add(m);
                while (rs.next()) {
                    m = new materiales();
                    m.setMaterial(rs.getString("material"));
                    m.setDescripcion(rs.getString(campoDes));
                    m.setUnidad_medida(rs.getString("unidad_medida"));
                    mts.add(m);
                }
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaComponentesByBoomE(ACC_BOMEquipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mts;
    }

    public bom_equipo ConsultaBOMequi(String query) {
        Conexion cnx = new Conexion();
        bom_equipo b = new bom_equipo();
        Connection con = cnx.ObtenerConexion();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                b.setLista_materiales(rs.getString("lista_materiales"));
                b.setAlternativa_listamateriales(rs.getString("alternativa_listamaterial"));
                b.setTipo_listamaterial(rs.getString("tipo_listamaterial"));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        cnx.CerrarConexion(con);
        return b;
    }
    
    // VISUALIZAR EQUIPOS BOOM PP
    public ArrayList<bom_equipo> ObtenerDatosBOOMPP(String equipo, String Centro, String alter) {
        ArrayList<bom_equipo> bom = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "{CALL PP.BoomEquipos_ObtenerBOMEquipos(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo);
            ps.setString(2, Centro);
            ps.setString(3, alter);
            rs = ps.executeQuery();
            while(rs.next()){
                bom_equipo b = new bom_equipo();
                b.setUtilizacion_listamaterial(rs.getString("utilizacion_listamaterial"));
                b.setLista_materiales(rs.getString("lista_materiales"));
                b.setCentro_suministrador(rs.getString("centro_suministrador"));
                b.setComponente_listamaterial(rs.getString("componente_listamaterial"));
                b.setCantidad_componente(rs.getString("cantidad_componente"));
                b.setUnidad_medida_componente(rs.getString("unidad_medida_componente"));
                b.setIndicador_borrado(rs.getString("indicador_borrado"));
                b.setPeticion_borrado_listamaterial(rs.getString("peticion_borrado_listamaterial"));
                bom.add(b);
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerDatosBOOM por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return bom;
    }
    
    public ArrayList<ListaMtrl> ObtenerLMNotificacionesCreaPP(String equipo, String lg) {
        ArrayList<ListaMtrl> lm = new ArrayList<>();
        ArrayList<String> mat = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "{CALL PP.Componente_ListaMat(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, equipo);
            rs = ps.executeQuery();
            while(rs.next()){                
                mat.add(rs.getString("componente_listamaterial"));
            }
        } catch (Exception e) {
            System.err.println("Error en ObtenerDatosBOOM por " + e);
        }
        String sql = "{CALL PP.ListMat_NotificacionesCreaPP(?)}";
        try {
            for(String mm : mat){
                ps = con.prepareStatement(sql);
                ps.setString(1, mm);
                rs = ps.executeQuery();
                while(rs.next()){
                    ListaMtrl ll = new ListaMtrl();
                    ll.setMaterial(rs.getString("material"));
                    ll.setPiezaFabricante(rs.getString("materia"));
                    ll.setDescripcion(rs.getString("descripcion_" + lg));
                    ll.setLote(rs.getString("lote"));
                    ll.setStock(rs.getString("stocklibre_utilizacion"));
                    ll.setUm(rs.getString("unidad_medida"));
                    ll.setCentro(rs.getString("centro"));
                    ll.setAlmacen(rs.getString("almacen"));
                    lm.add(ll);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en ListaMaterial Noti por: " + e);
        }
        
        finally {
            cnx.CerrarConexion(con);
        }
        return lm;
    }

}
