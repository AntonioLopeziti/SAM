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
public class ReporteOrdenes {

    String folio_sam;
    String num_orden;
    String ubicacion_tecnica;
    String hora_dia;
    String fecha;
    String indice_registro_no_valido;
    String centro_planificacion_mantenimiento;
    String clase_orden;
    String puesto_trabajo_responsable;
    String texto_breve;
    String num_equipo;
    String recibido;
    String procesado;
    String error;
    public String getFolio_sam() {
        return folio_sam;
    }

    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }
    
    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }
    
    public String getUbicacion_tecnica() {
        return ubicacion_tecnica;
    }

    public void setUbicacion_tecnica(String ubicacion_tecnica) {
        this.ubicacion_tecnica = ubicacion_tecnica;
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
    
    public String getIndice_registro_no_valido() {
        return indice_registro_no_valido;
    }

    public void setIndice_registro_no_valido(String indice_registro_no_valido) {
        this.indice_registro_no_valido = indice_registro_no_valido;
    }
    
    public String getCentro_planificacion_mante() {
        return centro_planificacion_mantenimiento;
    }

    public void setCentro_planificacion_mante(String centro_planificacion_mantenimiento) {
        this.centro_planificacion_mantenimiento = centro_planificacion_mantenimiento;
    }
    
    public String getClase_orden() {
        return clase_orden;
    }

    public void setClase_orden(String clase_orden) {
        this.clase_orden = clase_orden;
    }
    
    public String getPuesto_trabajo_responsable() {
        return puesto_trabajo_responsable;
    }

    public void setPuesto_trabajo_responsable(String puesto_trabajo_responsable) {
        this.puesto_trabajo_responsable = puesto_trabajo_responsable;
    }
    
    public String getTexto_breve() {
        return texto_breve;
    }

    public void setTexto_breve(String texto_breve) {
        this.texto_breve = texto_breve;
    }
    
    public String getNum_equipo() {
        return num_equipo;
    }

    public void setNum_equipo(String num_equipo) {
        this.num_equipo = num_equipo;
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
