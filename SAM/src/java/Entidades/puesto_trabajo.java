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
public class puesto_trabajo {

    public int getId_pt() {
        return id_pt;
    }

    public void setId_pt(int id_pt) {
        this.id_pt = id_pt;
    }

    public String getClase_puesto_trabajo() {
        return clase_puesto_trabajo;
    }

    public void setClase_puesto_trabajo(String clase_puesto_trabajo) {
        this.clase_puesto_trabajo = clase_puesto_trabajo;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getPuesto_trabajo() {
        return puesto_trabajo;
    }

    public void setPuesto_trabajo(String puesto_trabajo) {
        this.puesto_trabajo = puesto_trabajo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    int id_pt;
    String clase_puesto_trabajo;
    String centro;
    String puesto_trabajo;
    String denominacion;
    String denominacion_ES;
    String denominacion_EN;
    String descripcion;
    String descripcion_ES;
    String descripcion_EN;
}
