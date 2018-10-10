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
public class reserva_posiciones_crea {
    int id_rpc;
    String folio_sam;
    String posicion_reserva;
    String folio_sap = "";
    String num_material;
    String centro;
    String almacen;
    String cantidad_necesaria;
    String unidad_medida_base;
    String centro_coste;
    String num_orden;
    String clase_movimiento;
    String texto_posicion = "";
    String recibido;
    String procesado;
    String error;
    String modificar;
    String almacen_destino;
    String usuario = "";
    String Cantida_tomada = "";

    public String getCantida_tomada() {
        return Cantida_tomada;
    }

    public void setCantida_tomada(String Cantida_tomada) {
        this.Cantida_tomada = Cantida_tomada;
    }
    
    int num_posicion;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getNum_posicion() {
        return num_posicion;
    }

    public void setNum_posicion(int num_posicion) {
        this.num_posicion = num_posicion;
    }

    public String getModificar() {
        return modificar;
    }

    public void setModificar(String modificar) {
        this.modificar = modificar;
    }
    
    
    public int getId_rpc() {
        return id_rpc;
    }

    public void setId_rpc(int id_rpc) {
        this.id_rpc = id_rpc;
    }

    public String getFolio_sam() {
        return folio_sam;
    }

    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }

    public String getPosicion_reserva() {
        return posicion_reserva;
    }

    public void setPosicion_reserva(String posicion_reserva) {
        this.posicion_reserva = posicion_reserva;
    }

    public String getFolio_sap() {
        return folio_sap;
    }

    public void setFolio_sap(String folio_sap) {
        this.folio_sap = folio_sap;
    }

    public String getNum_material() {
        return num_material;
    }

    public void setNum_material(String num_material) {
        this.num_material = num_material;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getCantidad_necesaria() {
        return cantidad_necesaria;
    }

    public void setCantidad_necesaria(String cantidad_necesaria) {
        this.cantidad_necesaria = cantidad_necesaria;
    }

    public String getUnidad_medida_base() {
        return unidad_medida_base;
    }

    public void setUnidad_medida_base(String unidad_medida_base) {
        this.unidad_medida_base = unidad_medida_base;
    }

    public String getCentro_coste() {
        return centro_coste;
    }

    public void setCentro_coste(String centro_coste) {
        this.centro_coste = centro_coste;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getClase_movimiento() {
        return clase_movimiento;
    }

    public void setClase_movimiento(String clase_movimiento) {
        this.clase_movimiento = clase_movimiento;
    }

    public String getTexto_posicion() {
        return texto_posicion;
    }

    public void setTexto_posicion(String texto_posicion) {
        this.texto_posicion = texto_posicion;
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

    public String getAlmacen_destino() {
        return almacen_destino;
    }

    public void setAlmacen_destino(String almacen_destino) {
        this.almacen_destino = almacen_destino;
    }
   
    
}
