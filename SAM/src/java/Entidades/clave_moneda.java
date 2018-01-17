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
public class clave_moneda {
   int id_cm;
   String clave_moneda;
   String descripcion;

    public int getId_cm() {
        return id_cm;
    }

    public void setId_cm(int id_cm) {
        this.id_cm = id_cm;
    }

    public String getClave_moneda() {
        return clave_moneda;
    }

    public void setClave_moneda(String clave_moneda) {
        this.clave_moneda = clave_moneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
}
