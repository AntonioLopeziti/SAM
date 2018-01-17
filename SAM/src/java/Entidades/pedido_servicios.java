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
public class pedido_servicios {
   int ps = 0;
   int id_ps;
   String pedido;
   String posicion;
   String posicion_servicio;
   String servicio;
   String num_posicion_doc_compras;
   String num_doc_compras = "";
   String num_linea = "";
   String cantidad;
   String valor_neto_posición;
   String num_servicio = "";
   String cantidad_con_signo = "";
   String unidad_medida_base = "";
   String texto_breve = "";
   String precio_bruto = "";
   String clave_moneda = "";
   String valor_neto_posicion = "";
   String pedido_cantidad_entrada = "";
   String num_orden = "";

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }
    
    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    public String getPosicion_servicio() {
        return posicion_servicio;
    }

    public void setPosicion_servicio(String posicion_servicio) {
        this.posicion_servicio = posicion_servicio;
    }
    
    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNum_doc_compras() {
        return num_doc_compras;
    }

    public void setNum_doc_compras(String num_doc_compras) {
        this.num_doc_compras = num_doc_compras;
    }

    public String getNum_linea() {
        return num_linea;
    }

    public void setNum_linea(String num_linea) {
        this.num_linea = num_linea;
    }

    public String getNum_servicio() {
        return num_servicio;
    }

    public void setNum_servicio(String num_servicio) {
        this.num_servicio = num_servicio;
    }

    public String getCantidad_con_signo() {
        return cantidad_con_signo;
    }

    public void setCantidad_con_signo(String cantidad_con_signo) {
        this.cantidad_con_signo = cantidad_con_signo;
    }

    public String getUnidad_medida_base() {
        return unidad_medida_base;
    }

    public void setUnidad_medida_base(String unidad_medida_base) {
        this.unidad_medida_base = unidad_medida_base;
    }

    public String getTexto_breve() {
        return texto_breve;
    }

    public void setTexto_breve(String texto_breve) {
        this.texto_breve = texto_breve;
    }

    public String getPrecio_bruto() {
        return precio_bruto;
    }

    public void setPrecio_bruto(String precio_bruto) {
        this.precio_bruto = precio_bruto;
    }

    public String getClave_moneda() {
        return clave_moneda;
    }

    public void setClave_moneda(String clave_moneda) {
        this.clave_moneda = clave_moneda;
    }

    public String getValor_neto_posicion() {
        return valor_neto_posicion;
    }

    public void setValor_neto_posicion(String valor_neto_posicion) {
        this.valor_neto_posicion = valor_neto_posicion;
    }

    public String getPedido_cantidad_entrada() {
        return pedido_cantidad_entrada;
    }

    public void setPedido_cantidad_entrada(String pedido_cantidad_entrada) {
        this.pedido_cantidad_entrada = pedido_cantidad_entrada;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }
    
    public int getId_ps() {
        return id_ps;
    }

    public void setId_ps(int id_ps) {
        this.id_ps = id_ps;
    }
    
    public String getNum_posicion_doc_compras() {
        return num_posicion_doc_compras;
    }

    public void setNum_posicion_doc_compras(String num_posicion_doc_compras) {
        this.num_posicion_doc_compras = num_posicion_doc_compras;
    }
    
    public String getValor_neto_posición() {
        return valor_neto_posición;
    }

    public void setValor_neto_posición(String valor_neto_posición) {
        this.valor_neto_posición = valor_neto_posición;
    }
   
}
