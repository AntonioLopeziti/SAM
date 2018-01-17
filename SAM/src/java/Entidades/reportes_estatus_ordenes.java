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
public class reportes_estatus_ordenes {
    int id_stat;
    String folio_orden;
    String folio_sam;
    String fecha_sistema;
    String hora_sistema;
    String num_orden;
    String operacion_realizada;
    String indicador_posicion1;
    String indicador_posicion2;
    String texto_mensaje;
    String centro;
    
    public int getId_stat() {
        return id_stat;
    }

    public void setId_stat(int id_stat) {
        this.id_stat = id_stat;
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

    public String getFecha_sistema() {
        return fecha_sistema;
    }

    public void setFecha_sistema(String fecha_sistema) {
        this.fecha_sistema = fecha_sistema;
    }

    public String getHora_sistema() {
        return hora_sistema;
    }

    public void setHora_sistema(String hora_sistema) {
        this.hora_sistema = hora_sistema;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getOperacion_realizada() {
        return operacion_realizada;
    }

    public void setOperacion_realizada(String operacion_realizada) {
        this.operacion_realizada = operacion_realizada;
    }

    public String getIndicador_posicion1() {
        return indicador_posicion1;
    }

    public void setIndicador_posicion1(String indicador_posicion1) {
        this.indicador_posicion1 = indicador_posicion1;
    }

    public String getIndicador_posicion2() {
        return indicador_posicion2;
    }

    public void setIndicador_posicion2(String indicador_posicion2) {
        this.indicador_posicion2 = indicador_posicion2;
    }

    public String getTexto_mensaje() {
        return texto_mensaje;
    }

    public void setTexto_mensaje(String texto_mensaje) {
        this.texto_mensaje = texto_mensaje;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }
}
