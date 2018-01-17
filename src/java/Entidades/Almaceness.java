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
public class Almaceness {
    String id_almacen;
    String descripcion_ES;
    String descripcion_EN;
    String descripcion;
    String centro;

    public Almaceness() {
    }

    public Almaceness(String id_almacen, String descripcion, String centro) {
        this.id_almacen = id_almacen;
        this.descripcion = descripcion;
        this.centro = centro;
    }
    
    

    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
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
    
    
}
