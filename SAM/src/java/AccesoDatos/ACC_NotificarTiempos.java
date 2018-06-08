/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.CabNotTiempo;
import Entidades.texto_actividades;
import Entidades.ControlListaOrdenes;
import Entidades.MotivosRechazo;
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
    public ArrayList<MotivosRechazo> GetMotivosRC(String centro) {
        ArrayList<MotivosRechazo> cl = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.getMotivoRC(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, centro);
            rs = ps.executeQuery();
            while (rs.next()) {
                MotivosRechazo cont = new MotivosRechazo();
                cont.setMotivo(rs.getString("motivo"));
                cl.add(cont);
            }
        } catch (Exception e) {
            System.err.println("Error en Consultar GetMotivosRC, ACC_NotificarTiempos por: " + e);
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
                pp.setTexto_material(rs.getString("texto_material"));
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
    public control_tiempos CargarDatosPorUs(String usuario, String orden, String operacion) {
        control_tiempos ct = new control_tiempos();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.NotTiempos_CargarDatosPorUsuario(?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, orden);
            ps.setString(3, operacion);
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
    public texto_actividades obtenerTextosAct(String puesto) {
        texto_actividades ct = new texto_actividades();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String query = "{CALL PP.actividadesPuestoTrabajo(?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, puesto);
            rs = ps.executeQuery();
            while (rs.next()) {
                ct.setTexto_actividad1(rs.getString("texto_actividad1"));
                ct.setTexto_actividad2(rs.getString("texto_actividad2"));
                ct.setTexto_actividad3(rs.getString("texto_actividad3"));
                ct.setTexto_actividad4(rs.getString("texto_actividad4"));
                ct.setTexto_actividad5(rs.getString("texto_actividad5"));
                ct.setTexto_actividad6(rs.getString("texto_actividad6"));
                ct.setIndicador_visualiza1(rs.getString("indicador_visualiza1"));
                ct.setIndicador_visualiza2(rs.getString("indicador_visualiza2"));
                ct.setIndicador_visualiza3(rs.getString("indicador_visualiza3"));
                ct.setIndicador_visualiza4(rs.getString("indicador_visualiza4"));
                ct.setIndicador_visualiza5(rs.getString("indicador_visualiza5"));
                ct.setIndicador_visualiza6(rs.getString("indicador_visualiza6"));
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
    public int ValidarNotifCreada(String us, String orden, String operacion){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        int ban = 0;
        String query = "{CALL PP.NotTiempo_ValidarNotifCreada(?,?,?)}";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1, us);
            ps.setString(2, orden);
            ps.setString(3, operacion);
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
//                plan.setCantidad_total(rs.getString("cantidad_total"));
                plan.setCantidad_total(rs.getString("restante"));
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
        String query = "{CALL PP.NotTiempo_InsertarRegistroPosNot(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, posno.getNum_orden());
            ps.setString(2, posno.getNum_operacion());
            ps.setString(3, posno.getNum_notificacion());
            ps.setString(4, posno.getFolio_sam());
            ps.setString(5, posno.getClase_orden());
            ps.setString(6, posno.getPuesto_trabajo());
            ps.setString(7, posno.getCentro());
            ps.setString(8, posno.getMaterial());
            ps.setString(9, posno.getTexto_breve());
            ps.setString(10, posno.getNum_notificacion_sam());
            ps.setString(11, posno.getNotificacion_parcial());
            ps.setString(12, posno.getCompensar());
            ps.setString(13, posno.getCantidad_buena());
            ps.setString(14, posno.getUnidad_medida());
            ps.setString(15, posno.getRechazo());
            ps.setString(16, posno.getCantidad_trabajo());
            ps.setString(17, posno.getMotivo_desviacion());
            ps.setString(18, posno.getActividad_notificar1());
            ps.setString(19, posno.getUnidad_medida_notificar1());
            ps.setString(20, posno.getIndicador_actividad1());
            ps.setString(21, posno.getActividad_notificar2());
            ps.setString(22, posno.getUnidad_medida_notificar2());
            ps.setString(23, posno.getIndicador_actividad2());
            ps.setString(24, posno.getActividad_notificar3());
            ps.setString(25, posno.getUnidad_medida_notificar3());
            ps.setString(26, posno.getIndicador_actividad3());
            ps.setString(27, posno.getActividad_notificar4());
            ps.setString(28, posno.getUnidad_medida_notificar4());
            ps.setString(29, posno.getIndicador_actividad4());
            ps.setString(30, posno.getActividad_notificar5());
            ps.setString(31, posno.getUnidad_medida_notificar5());
            ps.setString(32, posno.getIndicador_actividad5());
            ps.setString(33, posno.getActividad_notificar6());
            ps.setString(34, posno.getUnidad_medida_notificar6());
            ps.setString(35, posno.getIndicador_actividad6());
            ps.setString(36, posno.getNum_personal());
            ps.setString(37, posno.getFecha_inicio());
            ps.setString(38, posno.getHora_inicio());
            ps.setString(39, posno.getFecha_fin());
            ps.setString(40, posno.getHora_fin());
            ps.setString(41, posno.getFecha_contabilizacion());
            ps.setString(42, posno.getTexto_notificacion());
            ps.setString(43, posno.getUsuario());
            ps.setString(44, posno.getRecibido());
            ps.setString(45, posno.getProcesado());
            ps.setString(46, posno.getFecha_recibido());
            ps.setString(47, posno.getHora_recibido());
            ps.setString(48, posno.getMensaje());
            ps.setString(49, posno.getMotivo());
            
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
            ps.setString(7, res.getNum_op());
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

    public PlanPP ObtenerDatosPlan(String orden, String ope) {
        PlanPP plan = new PlanPP();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.NotTiempo_ObtenerDatosMatCen(?,?)}";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, orden);
            ps.setString(2, ope);
            rs = ps.executeQuery();
            while (rs.next()) {
                plan.setNum_material(rs.getString("num_material"));
                plan.setCentro(rs.getString("centro"));
                plan.setContador_notificacion(rs.getString("contador_notificacion"));
                plan.setUnidad_medida(rs.getString("unidad_medida_base"));
                plan.setPuesto_trabajo_responsable(rs.getString("puesto_trabajo"));
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
