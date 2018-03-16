package AccesoDatos;

import Entidades.hojas_de_ruta;
import Entidades.HojaDeRutaPP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ACC_HojasRuta {

    private static ACC_HojasRuta Instance = null;

    public static ACC_HojasRuta ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_HojasRuta();
        }
        return Instance;
    }

    public boolean validarReg(String centro, String equipo) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM hojas_de_ruta where num_equipo= '" + equipo + "'AND centro='" + centro + "'";
        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            if (rs.absolute(1)) {
                cnx.CerrarConexion(con);
                return true;
            }
        } catch (Exception e) {
            System.err.println("Null Data" + e);
        }
        cnx.CerrarConexion(con);
        return false;
    }

    public ArrayList<hojas_de_ruta> ConsultaVisualizarHR(String Equipo, String centro, String alter) {
        ArrayList<hojas_de_ruta> hojaR = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{CALL PM.HojasRuta_GetALLHojasRuta(?,?,?)}";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Equipo);
            ps.setString(2, centro);
            ps.setString(3, alter);
            rs = ps.executeQuery();
            while (rs.next()) {
                hojas_de_ruta hr = new hojas_de_ruta();
                hr.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                hr.setTexto_hojaruta(rs.getString("texto_hojaruta"));
                hr.setNum_operacion(rs.getString("num_operacion"));
                hr.setId_objeto(rs.getString("id_objeto"));
                hr.setClave_control(rs.getString("clave_control"));
                hr.setCentro(rs.getString("centro"));
                hr.setAlternativa_lista_material(rs.getString("alternativa_lista_material"));
                hr.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                hr.setCantidad_base(rs.getString("cantidad_base"));
                hr.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                hr.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                hr.setTrabajo_operacion(rs.getString("trabajo_operacion"));
                hr.setUnidad_trabajo(rs.getString("unidad_trabajo"));
                hr.setTipo_hojaruta(rs.getString("tipo_hojaruta"));
                hr.setClave_grupo_hojaruta(rs.getString("clave_grupo_hojaruta"));
                hr.setSecuencia(rs.getString("secuencia"));
                hr.setNum_nodo_hojaruta(rs.getString("num_nodo_hojaruta"));
                hr.setLista_material(rs.getString("lista_material"));
                hr.setStatus(rs.getString("status"));
                hr.setDescripcion_operacion2(rs.getString("descripcion_operacion2"));
                hr.setUnidad_medida_operacion(rs.getString("unidad_medida_operacion"));
                hr.setOrganización_compras(rs.getString("organización_compras"));
                hr.setNum_cuenta_prove_acreedor(rs.getString("num_cuenta_prove_acreedor"));
                hr.setGrupo_articulos(rs.getString("grupo_articulos"));
                hr.setNum_reg_info_compras(rs.getString("num_reg_info_compras"));
                hr.setClase_coste(rs.getString("clase_coste"));
                hr.setClave_moneda(rs.getString("clave_moneda"));
                hr.setGrupo_compras_activi_traba_extra(rs.getString("grupo_compras_activi_traba_extra"));
                hr.setTipo_reginfo_compras(rs.getString("tipo_reginfo_compras"));
                hr.setIndicador_borrado(rs.getString("indicador_borrado"));
                hr.setNumServicio(rs.getString("num_servicio"));
                hr.setDescServicio(rs.getString("texto_breve_servicio"));
                hojaR.add(hr);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaVisualizarHR (ACC_hojas_de_ruta) " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return hojaR;
    }

    public ArrayList<hojas_de_ruta> ConsultaVisualizarHROrdenesO(String equi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList hrs = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProcOrg = "{call PM.Ordenes_ConsultarHojasDeRuta(?)}";

        try {
            ps = con.prepareStatement(ProcOrg);
            ps.setString(1, equi);
            rs = ps.executeQuery();

            while (rs.next()) {
                hojas_de_ruta hr = new hojas_de_ruta();
                hr.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                hr.setClave_grupo_hojaruta(rs.getString("clave_grupo_hojaruta"));
                hr.setTexto_hojaruta(rs.getString("texto_hojaruta"));
                hr.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                hrs.add(hr);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaVisualizarHROrdenes  por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return hrs;
    }
    public ArrayList<hojas_de_ruta> ConsultaVisualizarHROrdenesPP(String mat) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList hrs = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProcOrg = "{call PP.Ordenes_ConsultarHojasDeRuta(?)}";

        try {
            ps = con.prepareStatement(ProcOrg);
            ps.setString(1, mat);
            rs = ps.executeQuery();

            while (rs.next()) {
                hojas_de_ruta hr = new hojas_de_ruta();
                hr.setContador_grupo_hojaruta(rs.getString("cont_gpo_hr"));
                hr.setClave_grupo_hojaruta(rs.getString("clave_gpo_hr"));
                hr.setTexto_hojaruta(rs.getString("txt_brv_hr"));
                hr.setTexto_breve_operacion(rs.getString("txt_brv_op"));
                hrs.add(hr);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaVisualizarHROrdenes  por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return hrs;
    }

    public hojas_de_ruta ConsultaHojaRuta(String query) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        hojas_de_ruta hr = new hojas_de_ruta();
        try {
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                hr.setClave_grupo_hojaruta(rs.getString("clave_grupo_hojaruta"));
                hr.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        cnx.CerrarConexion(con);
        return hr;
    }

    public ArrayList ConsultaOperacionesXhr(String clsOrd, String contHR, String numHR) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList hrs = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        hojas_de_ruta hr;
        String SP = "{CALL PM.Ordenes_ValidarClsOrdOpe(?, ?, ?)}";
        String check;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, clsOrd);
            ps.setString(2, contHR);
            ps.setString(3, numHR);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (check.equals("0") || check.equals("1")) {
                hr = new hojas_de_ruta();
                hr.setNum_operacion(check);
                hrs.add(hr);
            } else {
                hr = new hojas_de_ruta();
                hr.setNum_operacion(rs.getString("num_operacion"));
                hr.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                hr.setCantidad_base(rs.getString("cantidad_base"));
                hr.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                hr.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                hr.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                hrs.add(hr);
                while (rs.next()) {
                    hr = new hojas_de_ruta();
                    hr.setNum_operacion(rs.getString(1));
                    hr.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                    hr.setCantidad_base(rs.getString("cantidad_base"));
                    hr.setDuracion_operacion_normal(rs.getString("duracion_operacion_normal"));
                    hr.setUnidad_duracion_normal(rs.getString("unidad_duracion_normal"));
                    hr.setPuesto_trabajo(rs.getString("puesto_trabajo"));
                    hrs.add(hr);
                }
            }

            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaOperacionesXhr(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return hrs;
    }
    
    //Visualizar Hojas de Ruta PP por Material 
    public ArrayList<HojaDeRutaPP> VisualizarHRPP(String Material, String centro, String alt){
        ArrayList<HojaDeRutaPP> hr = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "{CALL PP.HojasRuta_CargarHojasRutaPP(?,?,?)}";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1, Material);
            ps.setString(2, centro);
            ps.setString(3, alt);
            rs = ps.executeQuery();
            while(rs.next()){
                HojaDeRutaPP ru = new HojaDeRutaPP();
                ru.setCont_gpo_hr(rs.getString("cont_gpo_hr"));
                ru.setTxt_brv_hr(rs.getString("txt_brv_hr"));
                ru.setNum_op(rs.getString("num_op"));
                ru.setId_obj(rs.getString("id_obj"));
                ru.setClave_control(rs.getString("clave_control"));
                ru.setCentro_hr(rs.getString("centro_hr"));
                ru.setAlt_lista_mate(rs.getString("alt_lista_mate"));
                ru.setTxt_brv_op(rs.getString("txt_brv_op"));
                ru.setCnt_base(rs.getString("cnt_base"));
                ru.setDura_op(rs.getString("dura_op"));
                ru.setUnidad_dura(rs.getString("unidad_dura"));
                ru.setTbjo_op(rs.getString("tbjo_op"));
                ru.setUnidad_tbjo(rs.getString("unidad_tbjo"));
                ru.setTipo_hr(rs.getString("tipo_hr"));
                ru.setClave_gpo_hr(rs.getString("clave_gpo_hr"));
                ru.setSecuencia(rs.getString("secuencia"));
                ru.setNum_nodo(rs.getString("num_nodo"));
                ru.setLista_mate(rs.getString("lista_mate"));
                ru.setStatus_hr(rs.getString("status_hr"));
                //Descripcion de operacion 2
                ru.setUm_ope(rs.getString("um_ope"));
                ru.setOrg_compras(rs.getString("org_compras"));
                ru.setNum_cuenta_prov(rs.getString("num_cuenta_prov"));
                ru.setGpo_arts(rs.getString("gpo_arts"));
                ru.setNum_registros(rs.getString("num_registros"));
                ru.setClase_coste(rs.getString("clase_coste"));
                ru.setClave_moneda(rs.getString("clave_moneda"));
                ru.setGpo_compras(rs.getString("gpo_compras"));
                ru.setTipo_reg_comp(rs.getString("tipo_reg_comp"));
                ru.setInd_borrado(rs.getString("ind_borrado"));
                ru.setNum_servicio(rs.getString("num_servicio"));
                hr.add(ru);
                //Texto breve servicio
            }
        }catch (Exception e) {
            System.err.println("Error en metodo ConsultaVisualizarHR (ACC_hojas_de_ruta) " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return hr;
    }
    
    public ArrayList<hojas_de_ruta> ConsultaVisualizarHROrdenesOPP(String equi) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList hrs = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ProcOrg = "{call PM.Ordenes_ConsultarHojasDeRuta(?)}";

        try {
            ps = con.prepareStatement(ProcOrg);
            ps.setString(1, equi);
            rs = ps.executeQuery();

            while (rs.next()) {
                hojas_de_ruta hr = new hojas_de_ruta();
                hr.setContador_grupo_hojaruta(rs.getString("contador_grupo_hojaruta"));
                hr.setClave_grupo_hojaruta(rs.getString("clave_grupo_hojaruta"));
                hr.setTexto_hojaruta(rs.getString("texto_hojaruta"));
                hr.setTexto_breve_operacion(rs.getString("texto_breve_operacion"));
                hrs.add(hr);
            }
        } catch (Exception e) {
            System.err.println("Error en metodo ConsultaVisualizarHROrdenes  por: " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return hrs;
    }
    
    public String[] DataMaterialHR(String mat){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String[] response = new String[10];
        PreparedStatement ps;
        ResultSet rs;
        String SP = "{CALL PP.getDataMaterialHR(?)}";
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            rs.next();
            response[0] = rs.getString("puesto_trab");
            response[1] = rs.getString("clave_gpo_hr");
            response[2] = rs.getString("cont_gpo_hr");

        } catch (Exception ex) {
            System.err.println("Error en el metodo DataMatchEquipoOrdenes(ACC_Equipos por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return response;
    }

    public static void main(String[] args) {
        // System.out.println(ACC_HojasRuta.ObtenerInstancia().ConsultaVisualizarHR("CARI", "CARI651PS002A1002"));
    }
    
    public ArrayList ConsultaOperacionesHR_PP(String clsOrd, String contHR, String numHR) {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        ArrayList hrs = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs = null;
        hojas_de_ruta hr;
        String SP = "{CALL PP.Ordenes_ValidarClsOrdOpe(?, ?, ?)}";
        String check;
        try {
            ps = con.prepareStatement(SP);
            ps.setString(1, clsOrd);
            ps.setString(2, contHR);
            ps.setString(3, numHR);
            rs = ps.executeQuery();
            rs.next();
            check = rs.getString(1);
            if (check.equals("0") || check.equals("1")) {
                hr = new hojas_de_ruta();
                hr.setNum_operacion(check);
                hrs.add(hr);
            } else {
                hr = new hojas_de_ruta();
                hr.setNum_operacion(rs.getString("num_op"));
                hr.setTexto_breve_operacion(rs.getString("txt_brv_op"));
                hr.setCantidad_base(rs.getString("cnt_base"));
                hr.setDuracion_operacion_normal(rs.getString("dura_op"));
                hr.setUnidad_duracion_normal(rs.getString("unidad_dura"));
                hr.setPuesto_trabajo(rs.getString("puesto_trab"));
                hrs.add(hr);
                while (rs.next()) {
                    hr = new hojas_de_ruta();
                    hr.setNum_operacion(rs.getString(1));
                    hr.setTexto_breve_operacion(rs.getString("txt_brv_op"));
                    hr.setCantidad_base(rs.getString("cnt_base"));
                    hr.setDuracion_operacion_normal(rs.getString("dura_op"));
                    hr.setUnidad_duracion_normal(rs.getString("unidad_dura"));
                    hr.setPuesto_trabajo(rs.getString("puesto_trab"));
                    hrs.add(hr);
                }
            }

            cnx.CerrarConexion(con);
        } catch (Exception ex) {
            System.err.println("Error en el metodo ConsultaOperacionesXhr(ACC_PuestoTrabajo por: )" + ex);
        } finally {
            cnx.CerrarConexion(con);
        }
        return hrs;
    }
    
}
