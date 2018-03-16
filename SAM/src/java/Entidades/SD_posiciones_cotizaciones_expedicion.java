/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 */
public class SD_posiciones_cotizaciones_expedicion {

    int id_ec = 0;
    String num_doc_comercial = "";
    String posicion_doc_comercial = "";
    String centro = "";
    String denominacion_centro = "";
    String almacen = "";
    String denominacion_almacen = "";
    String puesto_expedcion = "";
    String denominacion_puesto_expedicion = "";
    String ruta = "";
    String denominacion_ruta = "";
    String priotidad_entrega = "";
    String denominacion_prioridad_entrega = "";
    String peso_neto = "";
    String unidad_medida_peso = "";
    String peso_bruto = "";

    public String getPeso_neto() {
        return peso_neto;
    }

    public void setPeso_neto(String peso_neto) {
        this.peso_neto = peso_neto;
    }
    
    

    public int getId_ec() {
        return id_ec;
    }

    public void setId_ec(int id_ec) {
        this.id_ec = id_ec;
    }

    public String getNum_doc_comercial() {
        return num_doc_comercial;
    }

    public void setNum_doc_comercial(String num_doc_comercial) {
        this.num_doc_comercial = num_doc_comercial;
    }

    public String getPosicion_doc_comercial() {
        return posicion_doc_comercial;
    }

    public void setPosicion_doc_comercial(String posicion_doc_comercial) {
        this.posicion_doc_comercial = posicion_doc_comercial;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getDenominacion_centro() {
        return denominacion_centro;
    }

    public void setDenominacion_centro(String denominacion_centro) {
        this.denominacion_centro = denominacion_centro;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getDenominacion_almacen() {
        return denominacion_almacen;
    }

    public void setDenominacion_almacen(String denominacion_almacen) {
        this.denominacion_almacen = denominacion_almacen;
    }

    public String getPuesto_expedcion() {
        return puesto_expedcion;
    }

    public void setPuesto_expedcion(String puesto_expedcion) {
        this.puesto_expedcion = puesto_expedcion;
    }

    public String getDenominacion_puesto_expedicion() {
        return denominacion_puesto_expedicion;
    }

    public void setDenominacion_puesto_expedicion(String denominacion_puesto_expedicion) {
        this.denominacion_puesto_expedicion = denominacion_puesto_expedicion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDenominacion_ruta() {
        return denominacion_ruta;
    }

    public void setDenominacion_ruta(String denominacion_ruta) {
        this.denominacion_ruta = denominacion_ruta;
    }

    public String getPriotidad_entrega() {
        return priotidad_entrega;
    }

    public void setPriotidad_entrega(String priotidad_entrega) {
        this.priotidad_entrega = priotidad_entrega;
    }

    public String getDenominacion_prioridad_entrega() {
        return denominacion_prioridad_entrega;
    }

    public void setDenominacion_prioridad_entrega(String denominacion_prioridad_entrega) {
        this.denominacion_prioridad_entrega = denominacion_prioridad_entrega;
    }

    public String getUnidad_medida_peso() {
        return unidad_medida_peso;
    }

    public void setUnidad_medida_peso(String unidad_medida_peso) {
        this.unidad_medida_peso = unidad_medida_peso;
    }

    public String getPeso_bruto() {
        return peso_bruto;
    }

    public void setPeso_bruto(String peso_bruto) {
        this.peso_bruto = peso_bruto;
    }

}
