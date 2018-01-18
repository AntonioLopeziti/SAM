/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.PlanInspeccionC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Panda
 */
public class ACC_CaracteristicasPlanInspeccion {

    private static ACC_CaracteristicasPlanInspeccion Instance = null;

    public static ACC_CaracteristicasPlanInspeccion ObtenerInstancia() {
        if (Instance == null) {
            Instance = new ACC_CaracteristicasPlanInspeccion();
        }
        return Instance;
    }
    public String obtenerCL(String mov)
    {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL QM.Cl_imov_MOM(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mov);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("clase_informe");
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return "";
    }
    public boolean validaMatCld(String mat)
    {
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL QM.ValidaMatPlaInspeccion(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return false;
    }
    public ArrayList<PlanInspeccionC> PlanInspecC(String mat)
    {
        ArrayList<PlanInspeccionC> pi = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL QM.PlanInspeccionC(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PlanInspeccionC p = new PlanInspeccionC();
                p.setNum_caracteristica_inspeccion(rs.getString("num_caracteristica_inspeccion"));
                p.setTexto_breve_caracteristicas_inspeccion(rs.getString("texto_breve_caracteristicas_inspeccion"));
                p.setDescripcion_breve_conjunto_seleccion(rs.getString("descripcion_breve_conjunto_seleccion"));
                p.setEntrada_catalogo_conjunto_seleccion(rs.getString("entrada_catalogo_conjunto_seleccion"));
                p.setFactor_cantidad_muestra(rs.getString("factor_cantidad_muestra"));
                p.setTamano_muestra_inspeccion_caracteristicas(rs.getString("tamano_muestra_inspeccion_caracteristicas"));
                p.setGrupo_codigo_conjunto_seleccion(rs.getString("grupo_codigo_conjunto_seleccion"));
                p.setUnidad_medida_graban_cuantitativos(rs.getString("unidad_medida_graban_cuantitativos"));
                p.setRenglon(rs.getString("renglon"));
                p.setCl_catalogo_grupo_codigo(rs.getString("cl_catalogo_grupo_codigo"));
                p.setTipo_caracteristica(rs.getString("tipo_caracteristica"));
                pi.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pi;
    }
    public ArrayList<PlanInspeccionC> QMCaracteristicasPM(String ord)
    {
        ArrayList<PlanInspeccionC> pi = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL PM.qm01_2_notificaciones_cld(?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ord);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PlanInspeccionC p = new PlanInspeccionC();
                p.setNum_caracteristica_inspeccion(rs.getString("num_caracteristicas_inspeccion"));
                p.setTexto_breve_caracteristicas_inspeccion(rs.getString("texto_breve_caracteristicas_inspeccion"));
                p.setDescripcion_breve_conjunto_seleccion(rs.getString("descripcion_breve_conjunto_seleccion"));
                p.setEntrada_catalogo_conjunto_seleccion(rs.getString("entrada_catalogo_conjunto_seleccion"));
                p.setFactor_cantidad_muestra(rs.getString("tamano_muestra_inpeccionar_carac"));
                p.setTamano_muestra_inspeccion_caracteristicas(rs.getString("tamano_muestra_inpeccionar_carac"));
                p.setGrupo_codigo_conjunto_seleccion(rs.getString("grupo_codigos"));
                p.setUnidad_medida_graban_cuantitativos(rs.getString("un_medida_graba_cuantitativos"));
                p.setRenglon(rs.getString("tipo_caracteristicas"));
                p.setLimite_inferior(rs.getString("limite_inferior"));
                p.setLimite_superior(rs.getString("limite_superior"));
                p.setIndicador_limite_inferior(rs.getString("indicador_limte_inferior"));
                p.setIndicador_limite_superior(rs.getString("indicador_tolerancia_superior"));
//                p.setCl_catalogo_grupo_codigo(rs.getString("cl_catalogo_grupo_codigo"));
//                p.setTipo_caracteristica(rs.getString("tipo_caracteristica"));
                pi.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pi;
    }
    public ArrayList<PlanInspeccionC> QMCaracteristicasPMConjunto(String nlote, String orden)
    {
        ArrayList<PlanInspeccionC> pi = new ArrayList<>();
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL PM.notificacionesConjunto(?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nlote);
            ps.setString(2, orden);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PlanInspeccionC p = new PlanInspeccionC();
                try{
                    p.setNum_caracteristica_inspeccion(rs.getString("num_caracteristicas_inspeccion"));
                }catch(Exception e){
                    p.setNum_caracteristica_inspeccion(rs.getString("num_caracteristica_inspeccion"));
                }
                try{
                    p.setTexto_breve_caracteristicas_inspeccion(rs.getString("texto_breve_caracteristicas_inspeccion"));
                }catch(Exception e){
                    p.setTexto_breve_caracteristicas_inspeccion(rs.getString("texto_breve_caracteristica_inspeccion"));
                }
                p.setDescripcion_breve_conjunto_seleccion(rs.getString("descripcion_breve_conjunto_seleccion"));
                p.setEntrada_catalogo_conjunto_seleccion(rs.getString("entrada_catalogo_conjunto_seleccion"));
                try{
                    p.setFactor_cantidad_muestra(rs.getString("tamano_muestra_inspeccionar_carac"));
                    p.setTamano_muestra_inspeccion_caracteristicas(rs.getString("tamano_muestra_inspeccionar_carac"));
                }catch(Exception e){
                    p.setFactor_cantidad_muestra(rs.getString("tamano_muestra_inps_carac"));
                    p.setTamano_muestra_inspeccion_caracteristicas(rs.getString("tamano_muestra_inps_carac"));
                }
                p.setValor_original_anterior_tratamiento_entradas(rs.getString("valor_original_anterior_tratamiento_entradas"));
                p.setGrupo_codigo_conjunto_seleccion("");
                try{
                    p.setUnidad_medida_graban_cuantitativos(rs.getString("unidad_medida_graban_cuantitativos"));
                }catch(Exception e){
                    p.setUnidad_medida_graban_cuantitativos(rs.getString("unidad_medida_grab_dat_cuanti"));
                }
                try{
                    if(rs.getString("valoracion_resultado_inspeccion").equals("")){
                        p.setValoracion_resultado_inspeccion(rs.getString("valoracion_vis"));
                    }else{
                        p.setValoracion_resultado_inspeccion(rs.getString("valoracion_resultado_inspeccion"));
                    }
                }catch(Exception e){
                    p.setValoracion_resultado_inspeccion(rs.getString("valor_resultado_inspeccion"));
                }                
                p.setRenglon(rs.getString("tipo_caracteristica"));
                p.setTexto_breve(rs.getString("texto_breve"));
                p.setCodigo(rs.getString("codigo"));
//                p.setCl_catalogo_grupo_codigo(rs.getString("cl_catalogo_grupo_codigo"));
//                p.setTipo_caracteristica(rs.getString("tipo_caracteristica"));
                pi.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return pi;
    }
    public String GetDesIC(String orden, String pos, String codigo){
        Conexion cnx = new Conexion();
        Connection con = cnx.ObtenerConexion();
        String sql = "{CALL pm.qm_getDescripcionInspecCod(?,?,?)}";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            ps.setString(2, pos);
            ps.setString(3, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("descripcion_es");
            }
        } catch (Exception e) {
            System.err.println("Error en ConsultarMCPedidos por " + e);
        } finally {
            cnx.CerrarConexion(con);
        }
        return "";
    }
}
