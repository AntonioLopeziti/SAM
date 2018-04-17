/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 */
public class canal_distribucion {
    int id_canal_dist = 0;
    String organizacion_ventas = "";
    String canal_distribucion = "";
    String denominacion = "";

    public int getId_canal_dist() {
        return id_canal_dist;
    }

    public void setId_canal_dist(int id_canal_dist) {
        this.id_canal_dist = id_canal_dist;
    }

    public String getOrganizacion_ventas() {
        return organizacion_ventas;
    }

    public void setOrganizacion_ventas(String organizacion_ventas) {
        this.organizacion_ventas = organizacion_ventas;
    }

    public String getCanal_distribucion() {
        return canal_distribucion;
    }

    public void setCanal_distribucion(String canal_distribucion) {
        this.canal_distribucion = canal_distribucion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
    
    
}
