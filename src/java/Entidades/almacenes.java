/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Zil
 */
public class almacenes {
int id_almacenes;
String id_almacen;
String nombre_alamcen;
String centro;
String almacen_ivend;
String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlmacen_ivend() {
        return almacen_ivend;
    }

    public void setAlmacen_ivend(String almacen_ivend) {
        this.almacen_ivend = almacen_ivend;
    }

    public int getId_almacenes() {
        return id_almacenes;
    }

    public void setId_almacenes(int id_almacenes) {
        this.id_almacenes = id_almacenes;
    }


    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getNombre_alamcen() {
        return nombre_alamcen;
    }

    public void setNombre_alamcen(String nombre_alamcen) {
        this.nombre_alamcen = nombre_alamcen;
    }

   
    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }


}
