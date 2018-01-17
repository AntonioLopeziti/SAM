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
public class tipo_posicion {

    int id_tp = 0;
    String num_tipo_posicion = "";
    String tipo_posicion = "";
    String descripcion = "";

    public int getId_tp() {
        return id_tp;
    }

    public void setId_tp(int id_tp) {
        this.id_tp = id_tp;
    }

    public String getNum_tipo_posicion() {
        return num_tipo_posicion;
    }

    public void setNum_tipo_posicion(String num_tipo_posicion) {
        this.num_tipo_posicion = num_tipo_posicion;
    }

    public String getTipo_posicion() {
        return tipo_posicion;
    }

    public void setTipo_posicion(String tipo_posicion) {
        this.tipo_posicion = tipo_posicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
