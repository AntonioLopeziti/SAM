/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author AREConsulting
 */
public class servicios {
    int id_servicio;
    String servicio = "";
    String descripcion = "";
    String unidad_medida = "";
    String categoria_valoracion = "";
    String denominacion_catevalo = "";
    String grupo_articulos = "";
    String sector;
    String tipo_servicio;
    String denominacion_tipo;

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getCategoria_valoracion() {
        return categoria_valoracion;
    }

    public void setCategoria_valoracion(String categoria_valoracion) {
        this.categoria_valoracion = categoria_valoracion;
    }

    public String getDenominacion_catevalo() {
        return denominacion_catevalo;
    }

    public void setDenominacion_catevalo(String denominacion_catevalo) {
        this.denominacion_catevalo = denominacion_catevalo;
    }

    public String getGrupo_articulos() {
        return grupo_articulos;
    }

    public void setGrupo_articulos(String grupo_articulos) {
        this.grupo_articulos = grupo_articulos;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getDenominacion_tipo() {
        return denominacion_tipo;
    }

    public void setDenominacion_tipo(String denominacion_tipo) {
        this.denominacion_tipo = denominacion_tipo;
    }
    
    
}
