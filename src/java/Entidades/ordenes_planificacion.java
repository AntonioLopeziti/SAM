/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Zil
 */
public class ordenes_planificacion {

    String id_op;
    String num_orden;
    String folio_orden_sam;
    String plan_mantenimiento_preventivo;
    String posicion_mantenimiento;
    String tipo_hoja_ruta;
    String clave_grupo_hoja_ruta;
    String contador_grupo_hoja_ruta;

    public String getId_op() {
        return id_op;
    }

    public void setId_op(String id_op) {
        this.id_op = id_op;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getFolio_orden_sam() {
        return folio_orden_sam;
    }

    public void setFolio_orden_sam(String folio_orden_sam) {
        this.folio_orden_sam = folio_orden_sam;
    }

    public String getPlan_mantenimiento_preventivo() {
        return plan_mantenimiento_preventivo;
    }

    public void setPlan_mantenimiento_preventivo(String plan_mantenimiento_preventivo) {
        this.plan_mantenimiento_preventivo = plan_mantenimiento_preventivo;
    }

    public String getPosicion_mantenimiento() {
        return posicion_mantenimiento;
    }

    public void setPosicion_mantenimiento(String posicion_mantenimiento) {
        this.posicion_mantenimiento = posicion_mantenimiento;
    }

    public String getTipo_hoja_ruta() {
        return tipo_hoja_ruta;
    }

    public void setTipo_hoja_ruta(String tipo_hoja_ruta) {
        this.tipo_hoja_ruta = tipo_hoja_ruta;
    }

    public String getClave_grupo_hoja_ruta() {
        return clave_grupo_hoja_ruta;
    }

    public void setClave_grupo_hoja_ruta(String clave_grupo_hoja_ruta) {
        this.clave_grupo_hoja_ruta = clave_grupo_hoja_ruta;
    }

    public String getContador_grupo_hoja_ruta() {
        return contador_grupo_hoja_ruta;
    }

    public void setContador_grupo_hoja_ruta(String contador_grupo_hoja_ruta) {
        this.contador_grupo_hoja_ruta = contador_grupo_hoja_ruta;
    }

}
