/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Jhonatan
 */
public class GrupoArticulos {
    String grupo_articulo;
    String denominacion_ES;
    String denominacion_EN;
    String descripcion_ES;
    String descripcion_EN;

    public GrupoArticulos() {
    }

    public GrupoArticulos(String grupo_articulo, String denominacion_ES, String denominacion_EN, String descripcion_ES, String descripcion_EN) {
        this.grupo_articulo = grupo_articulo;
        this.denominacion_ES = denominacion_ES;
        this.denominacion_EN = denominacion_EN;
        this.descripcion_ES = descripcion_ES;
        this.descripcion_EN = descripcion_EN;
    }

    public String getGrupo_articulo() {
        return grupo_articulo;
    }

    public void setGrupo_articulo(String grupo_articulo) {
        this.grupo_articulo = grupo_articulo;
    }

    public String getDenominacion_ES() {
        return denominacion_ES;
    }

    public void setDenominacion_ES(String denominacion_ES) {
        this.denominacion_ES = denominacion_ES;
    }

    public String getDenominacion_EN() {
        return denominacion_EN;
    }

    public void setDenominacion_EN(String denominacion_EN) {
        this.denominacion_EN = denominacion_EN;
    }

    public String getDescripcion_ES() {
        return descripcion_ES;
    }

    public void setDescripcion_ES(String descripcion_ES) {
        this.descripcion_ES = descripcion_ES;
    }

    public String getDescripcion_EN() {
        return descripcion_EN;
    }

    public void setDescripcion_EN(String descripcion_EN) {
        this.descripcion_EN = descripcion_EN;
    }
    
    
}
