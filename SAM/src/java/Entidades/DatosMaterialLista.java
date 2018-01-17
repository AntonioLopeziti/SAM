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
public class DatosMaterialLista {
    String grupo_articulos;
    String descripcion_almacen;
    String descripcion_centro;
    String num_cuenta_proveedor;
    String nombre1;

    public String getNum_cuenta_proveedor() {
        return num_cuenta_proveedor;
    }

    public void setNum_cuenta_proveedor(String num_cuenta_proveedor) {
        this.num_cuenta_proveedor = num_cuenta_proveedor;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getGrupo_articulos() {
        return grupo_articulos;
    }

    public void setGrupo_articulos(String grupo_articulos) {
        this.grupo_articulos = grupo_articulos;
    }

    public String getDescripcion_almacen() {
        return descripcion_almacen;
    }

    public void setDescripcion_almacen(String descripcion_almacen) {
        this.descripcion_almacen = descripcion_almacen;
    }

    public String getDescripcion_centro() {
        return descripcion_centro;
    }

    public void setDescripcion_centro(String descripcion_centro) {
        this.descripcion_centro = descripcion_centro;
    }
}
