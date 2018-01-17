/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 */
public class pedido_historial {
    int id_pedido = 0;
    String num_doc_compras = "";
    String num_posicion_doc_compras = "";
    String num_material = "";
    String texto_breve = "";
    String cantidad_pedido = "";
    String unidad_medida_base = "";
    String tipo_historial_pedido = "";
    String clase_movimiento = "";
    String num_doc_material = "";
    String num_apunte_contable = "";
    String cantidad = "";
    String unidad_medida_base2 = "";
    String fecha_entrega_posicion = "";
    String fecha_contabilizacion_doc = "";
    String folio_sam = "";

    public String getFolio_sam() {
        return folio_sam;
    }

    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNum_doc_compras() {
        return num_doc_compras;
    }

    public void setNum_doc_compras(String num_doc_compras) {
        this.num_doc_compras = num_doc_compras;
    }

    public String getNum_posicion_doc_compras() {
        return num_posicion_doc_compras;
    }

    public void setNum_posicion_doc_compras(String num_posicion_doc_compras) {
        this.num_posicion_doc_compras = num_posicion_doc_compras;
    }

    public String getNum_material() {
        return num_material;
    }

    public void setNum_material(String num_material) {
        this.num_material = num_material;
    }

    public String getTexto_breve() {
        return texto_breve;
    }

    public void setTexto_breve(String texto_breve) {
        this.texto_breve = texto_breve;
    }

    public String getCantidad_pedido() {
        return cantidad_pedido;
    }

    public void setCantidad_pedido(String cantidad_pedido) {
        this.cantidad_pedido = cantidad_pedido;
    }

    public String getUnidad_medida_base() {
        return unidad_medida_base;
    }

    public void setUnidad_medida_base(String unidad_medida_base) {
        this.unidad_medida_base = unidad_medida_base;
    }

    public String getTipo_historial_pedido() {
        return tipo_historial_pedido;
    }

    public void setTipo_historial_pedido(String tipo_historial_pedido) {
        this.tipo_historial_pedido = tipo_historial_pedido;
    }

    public String getClase_movimiento() {
        return clase_movimiento;
    }

    public void setClase_movimiento(String clase_movimiento) {
        this.clase_movimiento = clase_movimiento;
    }

    public String getNum_doc_material() {
        return num_doc_material;
    }

    public void setNum_doc_material(String num_doc_material) {
        this.num_doc_material = num_doc_material;
    }

    public String getNum_apunte_contable() {
        return num_apunte_contable;
    }

    public void setNum_apunte_contable(String num_apunte_contable) {
        this.num_apunte_contable = num_apunte_contable;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad_medida_base2() {
        return unidad_medida_base2;
    }

    public void setUnidad_medida_base2(String unidad_medida_base2) {
        this.unidad_medida_base2 = unidad_medida_base2;
    }

    public String getFecha_entrega_posicion() {
        return fecha_entrega_posicion;
    }

    public void setFecha_entrega_posicion(String fecha_entrega_posicion) {
        this.fecha_entrega_posicion = fecha_entrega_posicion;
    }

    public String getFecha_contabilizacion_doc() {
        return fecha_contabilizacion_doc;
    }

    public void setFecha_contabilizacion_doc(String fecha_contabilizacion_doc) {
        this.fecha_contabilizacion_doc = fecha_contabilizacion_doc;
    }
    
}
