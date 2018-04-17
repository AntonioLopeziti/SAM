/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 */
public class grupo_vendedores {
    int id_gpo_vend = 0;
    String grupo_vendedores = "";
    String denominacion = "";

    public int getId_gpo_vend() {
        return id_gpo_vend;
    }

    public void setId_gpo_vend(int id_gpo_vend) {
        this.id_gpo_vend = id_gpo_vend;
    }

    public String getGrupo_vendedores() {
        return grupo_vendedores;
    }

    public void setGrupo_vendedores(String grupo_vendedores) {
        this.grupo_vendedores = grupo_vendedores;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
}
