/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Developer-Antonio
 */
public class conversion_materiales {
    int id_conver;
    String material_conver;
    String denominacion_conver_unidad_medida_base;
    String unidad_medida;
    String numerador_conversion_um_base;
    String unidad_medida_pedido;

    public int getId_conver() {
        return id_conver;
    }

    public void setId_conver(int id_conver) {
        this.id_conver = id_conver;
    }

    public String getMaterial_conver() {
        return material_conver;
    }

    public void setMaterial_conver(String material_conver) {
        this.material_conver = material_conver;
    }

    public String getDenominacion_conver_unidad_medida_base() {
        return denominacion_conver_unidad_medida_base;
    }

    public void setDenominacion_conver_unidad_medida_base(String denominacion_conver_unidad_medida_base) {
        this.denominacion_conver_unidad_medida_base = denominacion_conver_unidad_medida_base;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getNumerador_conversion_um_base() {
        return numerador_conversion_um_base;
    }

    public void setNumerador_conversion_um_base(String numerador_conversion_um_base) {
        this.numerador_conversion_um_base = numerador_conversion_um_base;
    }

    public String getUnidad_medida_pedido() {
        return unidad_medida_pedido;
    }

    public void setUnidad_medida_pedido(String unidad_medida_pedido) {
        this.unidad_medida_pedido = unidad_medida_pedido;
    }
    
}
