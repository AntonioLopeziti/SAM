/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Erick_Jimenez
 */
public class materiales_almacen {
    
    int id_ma;
    String material;
    String centro;
    String almacen;
    String texto_material;

    public int getId_ma() {
        return id_ma;
    }

    public void setId_ma(int id_ma) {
        this.id_ma = id_ma;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public String getTexto_material() {
        return texto_material;
    }

    public void setTexto_material(String texto_material) {
        this.texto_material = texto_material;
    }
    
    
}
