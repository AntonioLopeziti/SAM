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
public class ubicaciones {
    String id_ubi;
    String id_ubicacion;
    String almacen;
    String centro;
    String solcitante;

    public String getId_ubi() {
        return id_ubi;
    }

    public void setId_ubi(String id_ubi) {
        this.id_ubi = id_ubi;
    }

    public String getSolcitante() {
        return solcitante;
    }

    public void setSolcitante(String solcitante) {
        this.solcitante = solcitante;
    }
    
    

    public String getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(String id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }
    
}
