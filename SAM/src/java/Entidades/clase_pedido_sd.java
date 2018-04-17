/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 */
public class clase_pedido_sd {
     int id_clase_pedido = 0;
     String clase_documento_ventas  = "";
     String denominacion = "";

    public int getId_clase_pedido() {
        return id_clase_pedido;
    }

    public void setId_clase_pedido(int id_clase_pedido) {
        this.id_clase_pedido = id_clase_pedido;
    }

    public String getClase_documento_ventas() {
        return clase_documento_ventas;
    }

    public void setClase_documento_ventas(String clase_documento_ventas) {
        this.clase_documento_ventas = clase_documento_ventas;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
     
}
