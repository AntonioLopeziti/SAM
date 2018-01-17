/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 */
public class Qm_Cabetodo {

    int id_qc;
    String num_orden = "";
    String texto_breve = "";
    String num_lote_inspeccion = "";
    String centro = "";
    String creado_registro_datos = "";
    String fecha_creacion_lote = "";
    String hora_creacion_lote = "";
    String ultimo_modificador_registro_datos = "";
    String fecha_modificacion_registro_datos = "";
    String hora_modificacion_lote = "";

    public int getId_qc() {
        return id_qc;
    }

    public void setId_qc(int id_qc) {
        this.id_qc = id_qc;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getTexto_breve() {
        return texto_breve;
    }

    public void setTexto_breve(String texto_breve) {
        this.texto_breve = texto_breve;
    }

    public String getNum_lote_inspeccion() {
        return num_lote_inspeccion;
    }

    public void setNum_lote_inspeccion(String num_lote_inspeccion) {
        this.num_lote_inspeccion = num_lote_inspeccion;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCreado_registro_datos() {
        return creado_registro_datos;
    }

    public void setCreado_registro_datos(String creado_registro_datos) {
        this.creado_registro_datos = creado_registro_datos;
    }

    public String getFecha_creacion_lote() {
        return fecha_creacion_lote;
    }

    public void setFecha_creacion_lote(String fecha_creacion_lote) {
        this.fecha_creacion_lote = fecha_creacion_lote;
    }

    public String getHora_creacion_lote() {
        return hora_creacion_lote;
    }

    public void setHora_creacion_lote(String hora_creacion_lote) {
        this.hora_creacion_lote = hora_creacion_lote;
    }

    public String getUltimo_modificador_registro_datos() {
        return ultimo_modificador_registro_datos;
    }

    public void setUltimo_modificador_registro_datos(String ultimo_modificador_registro_datos) {
        this.ultimo_modificador_registro_datos = ultimo_modificador_registro_datos;
    }

    public String getFecha_modificacion_registro_datos() {
        return fecha_modificacion_registro_datos;
    }

    public void setFecha_modificacion_registro_datos(String fecha_modificacion_registro_datos) {
        this.fecha_modificacion_registro_datos = fecha_modificacion_registro_datos;
    }

    public String getHora_modificacion_lote() {
        return hora_modificacion_lote;
    }

    public void setHora_modificacion_lote(String hora_modificacion_lote) {
        this.hora_modificacion_lote = hora_modificacion_lote;
    }
    
}
