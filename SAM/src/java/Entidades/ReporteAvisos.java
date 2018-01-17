/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Jonathan Lopez
 */
public class ReporteAvisos {
    String num_notificacion;
    String folio_sam;
    String hora_dia;
    String fecha;
    String recibido;
    String procesado;
    String error;
    String centro;
    
    public String getFolio_sam() {
        return folio_sam;
    }
    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }
    
    public String getNum_notificacion() {
        return num_notificacion;
    }
    public void setNum_notificacion(String num_notificacion) {
        this.num_notificacion = num_notificacion;
    }
    
    public String getCentro() {
        return centro;
    }
    public void setCentro(String centro) {
        this.centro = centro;
    }
    
    public String getHora_dia() {
        return hora_dia;
    }
    public void setHora_dia(String hora_dia) {
        this.hora_dia = hora_dia;
    }
    
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
