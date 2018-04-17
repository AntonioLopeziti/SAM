/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 */
public class organizacion_ventas {
    int id_org_ventas = 0;
    String organizacion_ventas = "";
    String denominacion = "";

    public int getId_org_ventas() {
        return id_org_ventas;
    }

    public void setId_org_ventas(int id_org_ventas) {
        this.id_org_ventas = id_org_ventas;
    }

    public String getOrganizacion_ventas() {
        return organizacion_ventas;
    }

    public void setOrganizacion_ventas(String organizacion_ventas) {
        this.organizacion_ventas = organizacion_ventas;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
    
}
