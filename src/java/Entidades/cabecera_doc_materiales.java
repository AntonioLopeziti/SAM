/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 */
public class cabecera_doc_materiales {

    int id_cd = 0;
    String clase_movimiento = "";
    String num_doc_material = "";
    String ejercicio_doc_material = "";
    String fecha_doc_en_doc = "";
    String fecha_contabilizacion_doc = "";
    String num_nota_entrega_externa = "";
    String num_carta_porte_entrada_mercancias = "";
    String texto_cabecera_doc = "";
    String num_cuenta_proveedor_acreedor = "";
    String nombre = "";
    String folio_sam = "";

    public String getClase_movimiento() {
        return clase_movimiento;
    }

    public void setClase_movimiento(String clase_movimiento) {
        this.clase_movimiento = clase_movimiento;
    }

    public String getFolio_sam() {
        return folio_sam;
    }

    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }

    public int getId_cd() {
        return id_cd;
    }

    public void setId_cd(int id_cd) {
        this.id_cd = id_cd;
    }

    public String getNum_doc_material() {
        return num_doc_material;
    }

    public void setNum_doc_material(String num_doc_material) {
        this.num_doc_material = num_doc_material;
    }

    public String getEjercicio_doc_material() {
        return ejercicio_doc_material;
    }

    public void setEjercicio_doc_material(String ejercicio_doc_material) {
        this.ejercicio_doc_material = ejercicio_doc_material;
    }

    public String getFecha_doc_en_doc() {
        return fecha_doc_en_doc;
    }

    public void setFecha_doc_en_doc(String fecha_doc_en_doc) {
        this.fecha_doc_en_doc = fecha_doc_en_doc;
    }

    public String getFecha_contabilizacion_doc() {
        return fecha_contabilizacion_doc;
    }

    public void setFecha_contabilizacion_doc(String fecha_contabilizacion_doc) {
        this.fecha_contabilizacion_doc = fecha_contabilizacion_doc;
    }

    public String getNum_nota_entrega_externa() {
        return num_nota_entrega_externa;
    }

    public void setNum_nota_entrega_externa(String num_nota_entrega_externa) {
        this.num_nota_entrega_externa = num_nota_entrega_externa;
    }

    public String getNum_carta_porte_entrada_mercancias() {
        return num_carta_porte_entrada_mercancias;
    }

    public void setNum_carta_porte_entrada_mercancias(String num_carta_porte_entrada_mercancias) {
        this.num_carta_porte_entrada_mercancias = num_carta_porte_entrada_mercancias;
    }

    public String getTexto_cabecera_doc() {
        return texto_cabecera_doc;
    }

    public void setTexto_cabecera_doc(String texto_cabecera_doc) {
        this.texto_cabecera_doc = texto_cabecera_doc;
    }

    public String getNum_cuenta_proveedor_acreedor() {
        return num_cuenta_proveedor_acreedor;
    }

    public void setNum_cuenta_proveedor_acreedor(String num_cuenta_proveedor_acreedor) {
        this.num_cuenta_proveedor_acreedor = num_cuenta_proveedor_acreedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
