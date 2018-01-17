/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author AREConsulting
 */
public class stock {
     int id_inven;
    String material;
    String descripcion_ES;
    String descripcion_EN;
    String clave_idioma;
    String centro;
    String unidad_medida;
    String almacen;
    String descripcion_almacen;
    String stocklibre_utilizacion;
    String stockcontrol_calidad;
    String stock_bloqueado;
    String stock_traslado;
    String lote;
    String GrupoArticulos;
    String tipo_material;
    String serie;
    String indicador_lote;
    String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public String getDescripcion_ES() {
        return descripcion_ES;
    }

    public void setDescripcion_ES(String descripcion_ES) {
        this.descripcion_ES = descripcion_ES;
    }

    public String getDescripcion_EN() {
        return descripcion_EN;
    }

    public void setDescripcion_EN(String descripcion_EN) {
        this.descripcion_EN = descripcion_EN;
    }

    public int getId_inven() {
        return id_inven;
    }

    public void setId_inven(int id_inven) {
        this.id_inven = id_inven;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getClave_idioma() {
        return clave_idioma;
    }

    public void setClave_idioma(String clave_idioma) {
        this.clave_idioma = clave_idioma;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getDescripcion_almacen() {
        return descripcion_almacen;
    }

    public void setDescripcion_almacen(String descripcion_almacen) {
        this.descripcion_almacen = descripcion_almacen;
    }

    public String getStocklibre_utilizacion() {
        return stocklibre_utilizacion;
    }

    public void setStocklibre_utilizacion(String stocklibre_utilizacion) {
        this.stocklibre_utilizacion = stocklibre_utilizacion;
    }

    public String getStockcontrol_calidad() {
        return stockcontrol_calidad;
    }

    public void setStockcontrol_calidad(String stockcontrol_calidad) {
        this.stockcontrol_calidad = stockcontrol_calidad;
    }

    public String getStock_bloqueado() {
        return stock_bloqueado;
    }

    public void setStock_bloqueado(String stock_bloqueado) {
        this.stock_bloqueado = stock_bloqueado;
    }

    public String getStock_traslado() {
        return stock_traslado;
    }

    public void setStock_traslado(String stock_traslado) {
        this.stock_traslado = stock_traslado;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getTipo_material() {
        return tipo_material;
    }

    public void setTipo_material(String tipo_material) {
        this.tipo_material = tipo_material;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getIndicador_lote() {
        return indicador_lote;
    }

    public void setIndicador_lote(String indicador_lote) {
        this.indicador_lote = indicador_lote;
    }
    
    public String getGrupoArticulos() {
        return GrupoArticulos;
    }

    public void setGrupoArticulos(String GrupoArticulos) {
        this.GrupoArticulos = GrupoArticulos;
    }
    
}
