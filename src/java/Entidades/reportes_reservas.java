/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author JaroMX
 */
public class reportes_reservas {
int id_reservas;
String folio_sam;
String indice_registro_no_valido;
String folio_sap;
String fecha;
String hora_dia;
String centro;
String clase_movimiento;
String almacen;
String centro_coste;
String num_orden;
String recibido;
String procesado;
String error;

    public int getId_reservas() {
        return id_reservas;
    }

    public void setId_reservas(int id_reservas) {
        this.id_reservas = id_reservas;
    }

    public String getFolio_sam() {
        return folio_sam;
    }

    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }

    public String getIndice_registro_no_valido() {
        return indice_registro_no_valido;
    }

    public void setIndice_registro_no_valido(String indice_registro_no_valido) {
        this.indice_registro_no_valido = indice_registro_no_valido;
    }

    public String getFolio_sap() {
        return folio_sap;
    }

    public void setFolio_sap(String folio_sap) {
        this.folio_sap = folio_sap;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_dia() {
        return hora_dia;
    }

    public void setHora_dia(String hora_dia) {
        this.hora_dia = hora_dia;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getClase_movimiento() {
        return clase_movimiento;
    }

    public void setClase_movimiento(String clase_movimiento) {
        this.clase_movimiento = clase_movimiento;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getCentro_coste() {
        return centro_coste;
    }

    public void setCentro_coste(String centro_coste) {
        this.centro_coste = centro_coste;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getRecibido() {
        return recibido;
    }

    public void setRecibido(String recibido) {
        this.recibido = recibido;
    }

    public String getProcesado() {
        return procesado;
    }

    public void setProcesado(String procesado) {
        this.procesado = procesado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
