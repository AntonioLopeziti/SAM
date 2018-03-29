/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.ClaseOrdenPP;
import Entidades.PlanPP;
import Entidades.clase_orden;
import Entidades.plan_orden;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author AreConsulting
 */
public class ACC_PlanOrden {

    private static ACC_PlanOrden Instance = null;

    public static ACC_PlanOrden ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_PlanOrden();
        }
        return Instance;
    }

    //Metodo trae todo de stock
    public LinkedList<plan_orden> ConsultaPlanOrden(String query) {

        LinkedList<plan_orden> plan_ordenes = new LinkedList<plan_orden>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                plan_orden orden = new plan_orden();

                orden.setId_plan(rs.getInt("id_plan"));
                orden.setNum_orden(rs.getString("num_orden"));
                orden.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                orden.setStatus_sistema(rs.getString("status_sistema"));
                orden.setTexto_breve(rs.getString("texto_breve"));
                orden.setPuesto_trabajo_responsables_medidas_mante(rs.getString("puesto_trabajo_responsables_medidas_mante"));
                orden.setCentro_puesto_trabajo_responsable(rs.getString("centro_puesto_trabajo_responsable"));
                orden.setNum_notificacion(rs.getString("num_notificacion"));
                orden.setGastos_general_estimado_orden(rs.getString("gastos_general_estimado_orden"));
                orden.setClase_actividad_mante(rs.getString("clase_actividad_mante"));
                orden.setEstado_instalacion(rs.getString("estado_instalacion"));
                orden.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                orden.setFecha_fin_extrema(rs.getString("fecha_fin_extrema"));
                orden.setPrioridad(rs.getString("prioridad"));
                orden.setRevision_mante_servicio_cliente(rs.getString("revision_mante_servicio_cliente"));
                orden.setNum_hoja_mante_servicio_orden(rs.getString("num_hoja_mante_servicio_orden"));
                orden.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                orden.setDenominacion_ubitec(rs.getString("denominacion_ubitec"));
                orden.setNum_equipo(rs.getString("num_equipo"));
                orden.setDenominacion_objeto_tecnico(rs.getString("denominacion_objeto_tecnico"));
                orden.setConjunto(rs.getString("conjunto"));

                plan_ordenes.add(orden);
            }
            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
        }
        return plan_ordenes;
    }

    public ArrayList<plan_orden> SP_ConsultaUnoListaorden(String Status) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaUnoListaOrden(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Status);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaDosListaorden(String Status1, String Status2) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaDosListaOrden(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Status1);
            pst.setString(2, Status2);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaTresListaorden(String Status1, String Status2, String Status3) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaTresListaOrden(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, Status1);
            pst.setString(2, Status2);
            pst.setString(3, Status3);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidarListaorden(String orden, String clase, String ubicacion, String equipo) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidarListaOrden(?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, clase);
            pst.setString(3, ubicacion);
            pst.setString(4, equipo);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidar1Listaorden(String orden, String clase, String ubicacion) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidar1ListaOrden(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, clase);
            pst.setString(3, ubicacion);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidar11Listaorden(String orden, String clase, String equipo) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidar11ListaOrden(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, clase);
            pst.setString(3, equipo);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidar111Listaorden(String orden, String ubicacion, String equipo) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidar111ListaOrden(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, ubicacion);
            pst.setString(3, equipo);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidar2Listaorden(String orden, String clase) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidar2ListaOrden(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, clase);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidar22Listaorden(String orden, String ubicacion) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidar22ListaOrden(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, ubicacion);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidar222Listaorden(String orden, String equipo) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidar222ListaOrden(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, equipo);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidar3Listaorden(String orden) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidar3ListaOrden(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_ConsultaValidar4Listaorden(String orden, String clase, String ubicacion, String equipo) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ConsultaValidar4ListaOrden(?,?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, clase);
            pst.setString(3, ubicacion);
            pst.setString(4, equipo);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public ArrayList<plan_orden> SP_Consultaorden2Listaorden(String orden, String orden2) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.orden2ListaOrden(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, orden2);

            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_plan.add(ord);
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

        return sp_plan;
    }

    public boolean ValidarOrdenplan(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ValidarPlanordenorden(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean ValidarOrdenCreacab(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ValidarCabOrdenorden(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean PM_ListaOrdenesValidarOrden(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Lista_Ordenesvalidarorden(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean PM_ListaOrdenesValidarSAM(String sam) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Lista_Ordenesvalidarsam(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, sam);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean PM_ListaOrdenesValidarClase(String clase) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Lista_OrdenesvalidarClaseorden(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, clase);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean PM_ListaOrdenesValidarUbitec(String ubicacion) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Lista_OrdenesvalidarUbitec(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, ubicacion);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean PM_ListaOrdenesValidarEquipo(String equipo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Lista_OrdenesvalidarEquipo(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, equipo);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public boolean PM_ListaOrdenesValidarPuesto(String equipo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.[Lista_OrdenesvalidarPuestoTrabajo](?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, equipo);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }

    public ArrayList<plan_orden> ConsultaQuerySAP(String[] data) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ListaOrdenes_PlanOrdenn(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);
            pst.setString(16, data[15]);
            pst.setString(17, data[16]);
            pst.setString(18, data[17]);
            pst.setString(19, data[18]);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setFolio_sam(rs.getString("folio_sam"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                ord.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ord.setNum_equipo(rs.getString("num_equipo"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                sp_plan.add(ord);
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

        return sp_plan;
    }
    public ArrayList<plan_orden> ConsultaQuerySAM(String[] data) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.ListaOrdenes_CabeceraOrdenes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);
            pst.setString(16, data[15]);
            pst.setString(17, data[16]);
            pst.setString(18, data[17]);
            pst.setString(19, data[18]);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setClase_doc_ventas(rs.getString("clase_orden"));
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setFolio_sam(rs.getString("folio_sam"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                ord.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ord.setNum_equipo(rs.getString("num_equipo"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                sp_plan.add(ord);
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

        return sp_plan;
    }
     public ArrayList<plan_orden> CargarTextoPosicion(String orden, String pos, String ti) {
        ArrayList<plan_orden> tes = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PM.VisualizarOrden_CargarTextosOperacion(?,?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, orden);
            ps.setString(2, pos);
            ps.setString(3, ti);
            rs = ps.executeQuery();
            while (rs.next()) {
                plan_orden tsp = new plan_orden();
                tsp.setTexto(rs.getString("texto"));
                tes.add(tsp);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextoPosicion, ACC_PlanOrden por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return tes;
    }
     public ArrayList<plan_orden> CargarTextoPosicionPP(String orden, String pos, String ti) {
        ArrayList<plan_orden> tes = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conn = con.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PP.VisualizarOrden_CargarTextosOperacion(?,?,?)}";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, orden);
            ps.setString(2, pos);
            ps.setString(3, ti);
            rs = ps.executeQuery();
            while (rs.next()) {
                plan_orden tsp = new plan_orden();
                tsp.setTexto(rs.getString("linea_texto"));
                tes.add(tsp);
            }
        } catch (Exception e) {
            System.err.println("Error en CargarTextoPosicion, ACC_PlanOrden por: " + e);
        } finally {
            con.CerrarConexion(conn);
        }
        return tes;
    }
    //VALIDACIONES LISTA ORDENES PP
    public boolean PP_ListaOrdenesValidarClasePP(String clase) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.Lista_OrdenesvalidarClaseordenPP(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, clase);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }
    public boolean PP_ListaOrdenesValidarOrdenPP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.Lista_OrdenesvalidarordenPP(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }
    
    public boolean PP_ListaOrdenesValidarSAMPP(String sam) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.Lista_OrdenesvalidarsamPP(?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, sam);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);
                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }
        return false;
    }
    public boolean PP_ListaOrdenesValidarEqMaterialPP(String equipo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PM.Lista_OrdenesvalidarEquipo(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, equipo);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }

        return false;
    }
    //CONSULTAS MATCH LISTA DE ORDENES
    public ArrayList<ClaseOrdenPP> SP_MatchClaseOrdenListaordenPP(String limite, String orden, String centro) {
        ArrayList<ClaseOrdenPP> sp_claseorden = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.MatchClaseOrdenListaordenPP(?,?,?)}";        
        try {
            pst = con.prepareCall(query);
            pst.setString(1, limite);            
            pst.setString(2, orden);
            pst.setString(3, centro);
            rs = pst.executeQuery();
            while (rs.next()) {
                ClaseOrdenPP ord = new ClaseOrdenPP();
                ord.setClase_orden(rs.getString("clase_orden"));
                ord.setCentro(rs.getString("centro"));
                sp_claseorden.add(ord);
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

        return sp_claseorden;
    }
    public ArrayList<PlanPP> MatchListaOrdenPP(String limite, String orden, String texto){
        ArrayList<PlanPP> al_planPP = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.MatchOrdenListaordenPP(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, limite);
            pst.setString(2, orden);
            pst.setString(3, texto);
            rs = pst.executeQuery();
            while(rs.next()){
                PlanPP pln = new PlanPP();
                pln.setNum_orden(rs.getString("num_orden"));
                pln.setTexto_breve(rs.getString("texto_breve"));
                al_planPP.add(pln);
            }  
        }catch (Exception e) {
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

        return al_planPP;
    }
    public ArrayList<plan_orden> SP_MatchOrdenListaordenPP(String limite, String orden, String texto) {
        ArrayList<plan_orden> sp_planorden = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.MatchOrdenListaordenPP(?,?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, limite);
            pst.setString(2, orden);
            pst.setString(3, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_planorden.add(ord);
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

        return sp_planorden;
    }
    //Traer datos fecha de inicio extrema Lista de Ordenes PP
    public ArrayList<PlanPP> FechaInicioExtremoPP(String fecha, String cant){
        ArrayList<PlanPP> pln_folioPP = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ListaOrdenes_CargarFechaIniExPP(?,?)}";
        try{
            pst = con.prepareCall(query);
            pst.setString(1, fecha);
            pst.setString(2, cant);
            rs = pst.executeQuery();
            while(rs.next()){
                PlanPP fePP = new PlanPP();
                fePP.setNum_orden(rs.getString("num_orden"));
                fePP.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                pln_folioPP.add(fePP);
            }
            
        }catch (Exception e) {
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
        return pln_folioPP;
    }
    public ArrayList<PlanPP> MatchFolioListaOrdenesPP(String orden, String texto){
        ArrayList<PlanPP> pln_folioPP = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ListaOrdenes_CargarSAMPP(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, texto);
            rs = pst.executeQuery();
            while(rs.next()){
                PlanPP pa = new PlanPP();
                pa.setFolio_sam(rs.getString("folio_sam"));
                pa.setTexto_breve(rs.getString("texto_breve"));
                pln_folioPP.add(pa);
            }
            
        }catch (Exception e) {
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

        return pln_folioPP;
    }
    public ArrayList<plan_orden> SP_MatchOrdenListaordenSAMPP(String orden, String texto) {
        ArrayList<plan_orden> sp_planorden = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ListaOrdenes_CargarSAMPP(?,?)}";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            pst.setString(2, texto);
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setFolio_sam(rs.getString("folio_sam"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                sp_planorden.add(ord);
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

        return sp_planorden;
    }
    
    //NUEVA VALIDACION QUERY LISTA ORDENES PP
    public ArrayList<PlanPP> ConsultaTablaPlanPPSAP (String [] data){
        ArrayList<PlanPP> newPlanPP = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ListaOrdenes_PlanPPCargaOrdenesSAP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);         
            pst.setString(16, data[15]);         
            pst.setString(17, data[16]);    
            rs = pst.executeQuery();
            while(rs.next()){
                PlanPP plan = new PlanPP();
                plan.setClase_documento_ventas(rs.getString("clase_documento_ventas"));
                plan.setNum_orden(rs.getString("num_orden"));
                plan.setFolio_sam(rs.getString("folio_sam"));
                plan.setTexto_breve(rs.getString("texto_breve"));
                plan.setNum_material(rs.getString("num_material"));
                plan.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                plan.setFecha1(rs.getString("fecha1"));
                newPlanPP.add(plan);
            }
        }catch (Exception e) {
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

        return newPlanPP;
    }
    //VALIDACION QUERY LISTA ORDENES PP
    public ArrayList<plan_orden> ConsultaQuerySAPPP(String[] data) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ListaOrdenes_PlanOrdennPP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);            
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setClase_doc_ventas(rs.getString("clase_doc_ventas"));
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setFolio_sam(rs.getString("folio_sam"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                ord.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ord.setNum_equipo(rs.getString("num_equipo"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                sp_plan.add(ord);
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

        return sp_plan;
    }
    
    
    public ArrayList<plan_orden> ConsultaQuerySAMPP(String[] data) {
        ArrayList<plan_orden> sp_plan = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ListaOrdenes_CabeceraOrdenesPP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        try {
            pst = con.prepareCall(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.setString(4, data[3]);
            pst.setString(5, data[4]);
            pst.setString(6, data[5]);
            pst.setString(7, data[6]);
            pst.setString(8, data[7]);
            pst.setString(9, data[8]);
            pst.setString(10, data[9]);
            pst.setString(11, data[10]);
            pst.setString(12, data[11]);
            pst.setString(13, data[12]);
            pst.setString(14, data[13]);
            pst.setString(15, data[14]);            
            rs = pst.executeQuery();
            while (rs.next()) {
                plan_orden ord = new plan_orden();
                ord.setClase_doc_ventas(rs.getString("clase_orden"));
                ord.setNum_orden(rs.getString("num_orden"));
                ord.setFolio_sam(rs.getString("folio_sam"));
                ord.setTexto_breve(rs.getString("texto_breve"));
                ord.setUbicacion_tecnica(rs.getString("ubicacion_tecnica"));
                ord.setNum_equipo(rs.getString("num_equipo"));
                ord.setFecha_inicio_extrema(rs.getString("fecha_inicio_extrema"));
                sp_plan.add(ord);
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

        return sp_plan;
    }
    public boolean ValidarOrdenPlanPP(String orden) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "{call PP.ValidarPlanOrdenVisOrdPP(?)}";
        try {
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
            pst = con.prepareCall(query);
            pst.setString(1, orden);
            rs = pst.executeQuery();
            if (rs.next()) {
                cnx.CerrarConexion(con);

                return true;
            } else {
                cnx.CerrarConexion(con);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("ERROR en metodo ValidarDatos por:" + ex);
        } finally {
            try {
                if (con != null) {
                    cnx.CerrarConexion(con);
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception b) {
                System.err.println("Error inesperado al cerrar las conexiones debido a: " + b);
            }
        }
        return false;
    }
}
