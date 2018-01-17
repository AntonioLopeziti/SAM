/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author JaroMX
 */
public class grupo_planificacion {
    int id_gp;
    String grupo_planificador_p_servicio_cliente_mante;
    String centro_planificacion_mantenimiento;
    String nombre_grupo_planificador = "";

    public String getNombre_grupo_planificador() {
        return nombre_grupo_planificador;
    }

    public void setNombre_grupo_planificador(String nombre_grupo_planificador) {
        this.nombre_grupo_planificador = nombre_grupo_planificador;
    }
    
    public int getId_gp() {
        return id_gp;
    }

    public void setId_gp(int id_gp) {
        this.id_gp = id_gp;
    }

    public String getGrupo_planificador_p_servicio_cliente_mante() {
        return grupo_planificador_p_servicio_cliente_mante;
    }

    public void setGrupo_planificador_p_servicio_cliente_mante(String grupo_planificador_p_servicio_cliente_mante) {
        this.grupo_planificador_p_servicio_cliente_mante = grupo_planificador_p_servicio_cliente_mante;
    }

    public String getCentro_planificacion_mantenimiento() {
        return centro_planificacion_mantenimiento;
    }

    public void setCentro_planificacion_mantenimiento(String centro_planificacion_mantenimiento) {
        this.centro_planificacion_mantenimiento = centro_planificacion_mantenimiento;
    }
    
    
}
