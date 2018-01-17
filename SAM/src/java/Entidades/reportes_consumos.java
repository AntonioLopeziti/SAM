/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class reportes_consumos {
  int id_concab;
  String folio_orden;
  String folio_sam;
  String hora_dia;
  String fecha_dia;
  String num_orden;
  String indi_posicion1;
  String indi_posicion2;
  String recibido;
  String procesado;
  String error;
  String centro;
  
    public int getId_concab() {
        return id_concab;
    }

    public void setId_concab(int id_concab) {
        this.id_concab = id_concab;
    }

    public String getFolio_orden() {
        return folio_orden;
    }

    public void setFolio_orden(String folio_orden) {
        this.folio_orden = folio_orden;
    }

    public String getFolio_sam() {
        return folio_sam;
    }

    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }

    public String getHora_dia() {
        return hora_dia;
    }

    public void setHora_dia(String hora_dia) {
        this.hora_dia = hora_dia;
    }

    public String getFecha_dia() {
        return fecha_dia;
    }

    public void setFecha_dia(String fecha_dia) {
        this.fecha_dia = fecha_dia;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getIndi_posicion1() {
        return indi_posicion1;
    }

    public void setIndi_posicion1(String indi_posicion1) {
        this.indi_posicion1 = indi_posicion1;
    }

    public String getIndi_posicion2() {
        return indi_posicion2;
    }

    public void setIndi_posicion2(String indi_posicion2) {
        this.indi_posicion2 = indi_posicion2;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
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
}
