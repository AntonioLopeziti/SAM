/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Jonathan Lopez
 */
public class Lotes {
    String material;
    String descripcion;
    String centro;
    String almacen;
    String lote;
    String cantidad;
    String descripcion_ES;
    String descripcion_EN;

    public Lotes() {
    }

    public Lotes(String material, String centro, String almacen, String lote, String descripcion_ES, String descripcion_EN) {
        this.material = material;
        this.centro = centro;
        this.almacen = almacen;
        this.lote = lote;
        this.descripcion_ES = descripcion_ES;
        this.descripcion_EN = descripcion_EN;
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
    

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
    
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
