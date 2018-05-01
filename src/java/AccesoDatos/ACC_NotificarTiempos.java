/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.CabNotTiempo;
import Entidades.ControlListaOrdenes;
import Entidades.control_tiempos;
import Entidades.OrdenesOperaciones;
import Entidades.PlanPP;
import Entidades.PosNotTiempo;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Jhonatan
 */
public class ACC_NotificarTiempos {

    private static ACC_NotificarTiempos Instance = null;

    public static ACC_NotificarTiempos ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_NotificarTiempos();
        }

        return Instance;
    }

    public ArrayList<ControlListaOrdenes> FiltroOrdenesLib() {
        ArrayList<ControlListaOrdenes> cl = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.NotTiempo_FiltrarOrdenes()}";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ControlListaOrdenes cont = new ControlListaOrdenes();
                cont.setNum_orden(rs.getString("num_orden"));
                cl.add(cont);
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar OrdenesFab, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cl;
    }

    //Consultar ordenes de fabricacion por match
    public ArrayList<PlanPP> ConsultarOrdenesFabPP(String matchOr, String matchTxt, String matchCnt) {
        ArrayList<PlanPP> pl = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String proc = "{CALL PP.NotTiempo_ConsultarOrdenesFabPP (?,?,?)}";
        try {
            ps = con.prepareStatement(proc);
            ps.setString(1, matchOr);
            ps.setString(2, matchTxt);
            ps.setString(3, matchCnt);
            rs = ps.executeQuery();
            while (rs.next()) {
                PlanPP pp = new PlanPP();
                pp.setNum_orden(rs.getString("num_orden"));
                pp.setTexto_breve(rs.getString("texto_breve"));
                pl.add(pp);
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar OrdenesFab, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pl;
    }

    //Verificar y cargar datos por Usuario
    public control_tiempos CargarDatosPorUs(String usuario, String orden) {
        control_tiempos ct = new control_tiempos();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.NotTiempos_CargarDatosPorUsuario(?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                ct.setNo_personal(rs.getString("no_personal"));
                ct.setNot_parcial(rs.getString("not_parcial"));
                ct.setNot_final(rs.getString("not_final"));
                ct.setNot_final_aut(rs.getString("not_final_aut"));
                ct.setComp_reserva(rs.getString("comp_reserva"));
                ct.setOrden_fab(rs.getString("orden_fab"));
                ct.setNum_op(rs.getString("num_op"));
                ct.setCtd_buena(rs.getString("ctd_buena"));
                ct.setCtd_mala(rs.getString("ctd_mala"));
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar Datos Usuario, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ct;
    }

    //Cargar automaticamente operaciones de la orden de fabricación seleccionada
    public ArrayList<OrdenesOperaciones> MostrarOperacionesPP(String orden) {
        ArrayList<OrdenesOperaciones> mo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pro = "{CALL PP.NotTiempo_CargarOperacionesPP(?)}";
        try {
            ps = con.prepareStatement(pro);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrdenesOperaciones p = new OrdenesOperaciones();
                p.setNum_orden(rs.getString("num_orden"));
                p.setNum_operacion(rs.getString("num_operacion"));
                p.setClave_control(rs.getString("clave_control"));
                mo.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar OrdenesFab, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mo;
    }

    //Validar Ordenes de Fabricacion por input
    public int ValidarOrdenFab(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{call PP.NotTiempo_ValidarOrdenFab(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar OrdenesFab, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    //Validar numero/nombre de personal
    public int ValidarUsuario(String usuario) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String sql = "{CALL PP.NotTiempo_ValidarUsuario(?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en validar num de personal, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    public int ValidarNotifCreada(String us, String orden){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String query = "{CALL PP.NotTiempo_ValidarNotifCreada(?,?)}";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1, us);
            ps.setString(2, orden);
            rs = ps.executeQuery();
            while(rs.next()){
                ban = 1;
            }
        }catch (Exception e) {
            System.err.println("Error en validar num de personal, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    //Validar que al blur de la orden solo se acepten ordenes LIB.
    public int ValidarStatusLibBlur(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String query = "{CALL PP.NotTiempo_ValidarOrdenTablaPPSoloLib(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en borrar el registro de tabla interna en, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    //Validar status de ordenes en PP.control_listadoOrdenes
    public int ValidarStatusOrdenTab(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String query = "{CALL PP.NotTiempo_ValidarOrdenTablaControl(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                ban = 1;
            }
        } catch (Exception e) {
            System.err.println("Error en borrar el registro de tabla interna en, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    //Obtener la cantidad base de la orden seleccionada
    public PlanPP ObtenerCantidadOrden(String orden) {
        PlanPP plan = new PlanPP();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.NotTiempo_ObtenerCantidadOrden(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                plan.setCantidad_total(rs.getString("cantidad_total"));
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar Datos Usuario, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return plan;
    }
    //insertar registro en tabla de cabecera
    public boolean InsertarPosNotTiempo(PosNotTiempo posno){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL PP.NotTiempo_InsertarRegistroPosNot(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, posno.getNum_orden());
            ps.setString(2, posno.getCont_not());
            ps.setString(3, posno.getFolio_not_tiemp());
            ps.setString(4, posno.getFecha_offline());
            ps.setString(5, posno.getHora_offline());
            ps.setString(6, posno.getNum_material());            
            ps.setString(7, posno.getCentro());
            ps.setString(8, posno.getActiv_not_par());
            ps.setString(9, posno.getActiv_not_final());
            ps.setString(10, posno.getNot_final());
            ps.setString(11, posno.getComp_reservas());
            ps.setString(12, posno.getCant_buena());
            ps.setString(13, posno.getRechazo_notif());
            ps.setString(14, posno.getNum_personal());
            ps.setString(15, posno.getFecha_inic_notificada_ej());
            ps.setString(16, posno.getHora_notificada_inic_ej());
            ps.setString(17, posno.getFecha_fin_notificada_ej());
            ps.setString(18, posno.getHora_notificada_fin_ej());
            ps.setString(19, posno.getUnidad_medida());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        }catch (Exception e) {
            System.err.println("Error en Insertar Orden en Posiciones por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    //borra el registro en la tabla control al insertar en cabecera y posicion
    public boolean BorraRegTablaCont (String usuario, String orden){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String sql = "{CALL PP.NotTiempo_BorraRegTablaCont(?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, orden);
            if(ps.executeUpdate() == 1){
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en validar num de personal, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }
    //insertar registro en tabla de posiciones 
    public boolean InsertarCabNotTiempo(CabNotTiempo cnta) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL PP.NotTiempo_InsertarRegistroCabNot(?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, cnta.getNum_orden());
            ps.setString(2, cnta.getFolio_not_tiem());
            ps.setString(3, cnta.getFecha_offline());
            ps.setString(4, cnta.getHora_offline());
            ps.setString(5, cnta.getNum_mat_ord());
            ps.setString(6, cnta.getCentro());
            ps.setString(7, cnta.getAct_not_par());
            ps.setString(8, cnta.getAct_not_final());
            ps.setString(9, cnta.getNot_final());
            ps.setString(10, cnta.getCom_reserv());
            ps.setString(11, cnta.getNum_personal());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarMaterial por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    //Insertar Notificacion de Tiempo en Tabla de Control
    public boolean InsertarNotifTiempoPP(control_tiempos res) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        Boolean ban = false;
        String query = "{CALL PP.NotTiempo_InsertarRegistro(?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, res.getNo_personal());
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "X");
            ps.setString(5, "");
            ps.setString(6, res.getOrden_fab());
            ps.setString(7, "0010");
            ps.setString(8, res.getCtd_buena());
            ps.setString(9, res.getCtd_mala());
            ps.setString(10, res.getHora());
            ps.setString(11, res.getFecha());
            if (ps.executeUpdate() == 1) {
                ban = true;
            }
        } catch (Exception e) {
            System.err.println("Error en InsertarMaterial por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return ban;
    }

    //Traer el registro que hay en pantalla
    public ArrayList<control_tiempos> ObtenerRegistro(String usuario, String orden) {
        ArrayList<control_tiempos> mo = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pro = "{CALL PP.NotTiempo_ObtenerRegistro(?,?)}";
        try {
            ps = con.prepareStatement(pro);
            ps.setString(1, usuario);
            ps.setString(2, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                control_tiempos p = new control_tiempos();
                p.setNo_personal(rs.getString("no_personal"));
                p.setNot_parcial(rs.getString("not_parcial"));
                p.setNot_final(rs.getString("not_final"));
                p.setNot_final_aut(rs.getString("not_final_aut"));
                p.setComp_reserva(rs.getString("comp_reserva"));
                p.setOrden_fab(rs.getString("orden_fab"));
                p.setNum_op(rs.getString("num_op"));
                p.setCtd_buena(rs.getString("ctd_buena"));
                p.setCtd_mala(rs.getString("ctd_mala"));
                p.setHora(rs.getString("hora"));
                p.setFecha(rs.getString("fecha"));
                mo.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar OrdenesFab, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return mo;
    }

    public control_tiempos ObtenerRegistroOrdenes(String usuario, String orden) {
        control_tiempos cnTi = new control_tiempos();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.NotTiempo_ObtenerRegistro(?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                cnTi.setNo_personal(rs.getString("no_personal"));
                cnTi.setNot_parcial(rs.getString("not_parcial"));
                cnTi.setNot_final(rs.getString("not_final"));
                cnTi.setNot_final_aut(rs.getString("not_final_aut"));
                cnTi.setComp_reserva(rs.getString("comp_reserva"));
                cnTi.setOrden_fab(rs.getString("orden_fab"));
                cnTi.setNum_op(rs.getString("num_op"));
                cnTi.setCtd_buena(rs.getString("ctd_buena"));
                cnTi.setCtd_mala(rs.getString("ctd_mala"));
                cnTi.setHora(rs.getString("hora"));
                cnTi.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar Datos Usuario, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return cnTi;
    }

    public PlanPP ObtenerDatosPlan(String orden) {
        PlanPP plan = new PlanPP();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.NotTiempo_ObtenerDatosMatCen(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                plan.setNum_material(rs.getString("num_material"));
                plan.setCentro(rs.getString("centro"));
                plan.setContador_notificacion(rs.getString("contador_notificacion"));
                plan.setUnidad_medida(rs.getString("unidad_medida_base"));
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar Datos Usuario, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return plan;
    }

    //Verificar Status de exceso de cantidades por orden
    public PlanPP VerificarStatusCantidad(String orden) {
        PlanPP pn = new PlanPP();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.NotTiempo_VerificarStatusCantidad(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            while (rs.next()) {
                pn.setExceso_suministro(rs.getString("exceso_suministro"));
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar Datos Usuario, ACC_NotificarTiempos por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pn;
    }
}
