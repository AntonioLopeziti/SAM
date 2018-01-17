/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Panda
 */
public class ListaMtrl {
    String material = "";
    String piezaFabricante = "";
    String Descripcion = "";
    String lote = "";
    String stock = "";
    String um = "";
    String almacen = "";
    String centro = "";

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
    
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPiezaFabricante() {
        return piezaFabricante;
    }

    public void setPiezaFabricante(String piezaFabricante) {
        this.piezaFabricante = piezaFabricante;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }
    
}
