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
public class Stock_Traslado {
    String centro = "";
    String material = "";
    String stock_traslado = "";
    String suejto_lote = "";
    String unidad_medida = "";
    String descripcion = "";

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getStock_traslado() {
        return stock_traslado;
    }

    public void setStock_traslado(String stock_traslado) {
        this.stock_traslado = stock_traslado;
    }

    public String getSuejto_lote() {
        return suejto_lote;
    }

    public void setSuejto_lote(String suejto_lote) {
        this.suejto_lote = suejto_lote;
    }
        
}
