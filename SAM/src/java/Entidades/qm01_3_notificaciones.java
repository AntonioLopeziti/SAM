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
public class qm01_3_notificaciones {
  
    int id_qm3;
    String num_orden;
    String num_lote_inspeccion = "";
    String num_caracteristicas_inspeccion = "";
    String num_resultado_detallado = "";
    String texto_breve_caracteristicas_inspeccion = "";
    String entrada_catalogo_conjunto_seleccion = "";
    String num_unidades_muestreo_registradas = "";
    String valor_original_anterior_tratamiento_entradas = "";
    String codigo = "";
    String icono_valoracion_carac_muestre_parcial = "";
    String descripcion_breve_conjunto_seleccion = "";
    String texto_breve = "";
    String creador_registro_datos = "";

    public int getId_qm3() {
        return id_qm3;
    }

    public void setId_qm3(int id_qm3) {
        this.id_qm3 = id_qm3;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getNum_caracteristicas_inspeccion() {
        return num_caracteristicas_inspeccion;
    }

    public void setNum_caracteristicas_inspeccion(String num_caracteristicas_inspeccion) {
        this.num_caracteristicas_inspeccion = num_caracteristicas_inspeccion;
    }

    public String getNum_resultado_detallado() {
        return num_resultado_detallado;
    }

    public void setNum_resultado_detallado(String num_resultado_detallado) {
        this.num_resultado_detallado = num_resultado_detallado;
    }

    public String getTexto_breve_caracteristicas_inspeccion() {
        return texto_breve_caracteristicas_inspeccion;
    }

    public void setTexto_breve_caracteristicas_inspeccion(String texto_breve_caracteristicas_inspeccion) {
        this.texto_breve_caracteristicas_inspeccion = texto_breve_caracteristicas_inspeccion;
    }

    public String getEntrada_catalogo_conjunto_seleccion() {
        return entrada_catalogo_conjunto_seleccion;
    }

    public void setEntrada_catalogo_conjunto_seleccion(String entrada_catalogo_conjunto_seleccion) {
        this.entrada_catalogo_conjunto_seleccion = entrada_catalogo_conjunto_seleccion;
    }

    public String getCreador_registro_datos() {
        return creador_registro_datos;
    }

    public void setCreador_registro_datos(String creador_registro_datos) {
        this.creador_registro_datos = creador_registro_datos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValor_original_anterior_tratamiento_entradas() {
        return valor_original_anterior_tratamiento_entradas;
    }

    public void setValor_original_anterior_tratamiento_entradas(String valor_original_anterior_tratamiento_entradas) {
        this.valor_original_anterior_tratamiento_entradas = valor_original_anterior_tratamiento_entradas;
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

    public String getNum_unidades_muestreo_registradas() {
        return num_unidades_muestreo_registradas;
    }

    public void setNum_unidades_muestreo_registradas(String num_unidades_muestreo_registradas) {
        this.num_unidades_muestreo_registradas = num_unidades_muestreo_registradas;
    }

    public String getIcono_valoracion_carac_muestre_parcial() {
        return icono_valoracion_carac_muestre_parcial;
    }

    public void setIcono_valoracion_carac_muestre_parcial(String icono_valoracion_carac_muestre_parcial) {
        this.icono_valoracion_carac_muestre_parcial = icono_valoracion_carac_muestre_parcial;
    }

    public String getDescripcion_breve_conjunto_seleccion() {
        return descripcion_breve_conjunto_seleccion;
    }

    public void setDescripcion_breve_conjunto_seleccion(String descripcion_breve_conjunto_seleccion) {
        this.descripcion_breve_conjunto_seleccion = descripcion_breve_conjunto_seleccion;
    }

    
}
