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
public class SolpedCrea {

    int id_solped;
    String folio_sam;
    String num_posicion_solped;
    String tipo_posicion_doc_compras;
    String num_material;
    String fecha;
    String hora_dia;
    String num_solped;
    String clase_documento_solped;
    String tipo_imputacion;
    String texto_breve;
    String cantidad_solped;
    String unidad_medida_solped;
    String tipo_fecha;
    String fecha_entraga_posicion;
    String grupo_articulos;
    String centro;
    String almacen;
    String grupo_compras;
    String solicitante;
    String fecha_solicitud;
    String proveedor_deseado;
    String num_cuenta_proveedor;
    String indice_registro_no_valido;
    String tipo_posicion_doc_compras2;
    String num_registro_info_compras;
    String organizacion_compras;
    String num_cuenta_mayor;
    String centro_coste;
    String num_contrato_superior;
    String num_posicion_contrato_superior;
    String indicador_distribucion_imputacion_multiple;
    String num_cuenta_mayor2;
    String num_orden;
    String sociedad_co;
    String centro_coste2;
    String texto_cabecera;
    String texto_posicion;
    String recibido = "";
    String procesado = "";
    String error = "";
    String Modificado = "";
    String StatusMod = "";

    public String getStatusMod() {
        return StatusMod;
    }

    public void setStatusMod(String StatusMod) {
        this.StatusMod = StatusMod;
    }
    
    public String getModificado() {
        return Modificado;
    }

    public void setModificado(String Modificado) {
        this.Modificado = Modificado;
    }
    String precio_solped;
    String clave_moneda;

    public int getId_solped() {
        return id_solped;
    }

    public void setId_solped(int id_solped) {
        this.id_solped = id_solped;
    }

    public String getFolio_sam() {
        return folio_sam;
    }

    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }

    public String getNum_posicion_solped() {
        return num_posicion_solped;
    }

    public void setNum_posicion_solped(String num_posicion_solped) {
        this.num_posicion_solped = num_posicion_solped;
    }

    public String getTipo_posicion_doc_compras() {
        return tipo_posicion_doc_compras;
    }

    public void setTipo_posicion_doc_compras(String tipo_posicion_doc_compras) {
        this.tipo_posicion_doc_compras = tipo_posicion_doc_compras;
    }

    public String getNum_material() {
        return num_material;
    }

    public void setNum_material(String num_material) {
        this.num_material = num_material;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_dia() {
        return hora_dia;
    }

    public void setHora_dia(String hora_dia) {
        this.hora_dia = hora_dia;
    }

    public String getNum_solped() {
        return num_solped;
    }

    public void setNum_solped(String num_solped) {
        this.num_solped = num_solped;
    }

    public String getClase_documento_solped() {
        return clase_documento_solped;
    }

    public void setClase_documento_solped(String clase_documento_solped) {
        this.clase_documento_solped = clase_documento_solped;
    }

    public String getTipo_imputacion() {
        return tipo_imputacion;
    }

    public void setTipo_imputacion(String tipo_imputacion) {
        this.tipo_imputacion = tipo_imputacion;
    }

    public String getTexto_breve() {
        return texto_breve;
    }

    public void setTexto_breve(String texto_breve) {
        this.texto_breve = texto_breve;
    }

    public String getCantidad_solped() {
        return cantidad_solped;
    }

    public void setCantidad_solped(String cantidad_solped) {
        this.cantidad_solped = cantidad_solped;
    }

    public String getUnidad_medida_solped() {
        return unidad_medida_solped;
    }

    public void setUnidad_medida_solped(String unidad_medida_solped) {
        this.unidad_medida_solped = unidad_medida_solped;
    }

    public String getTipo_fecha() {
        return tipo_fecha;
    }

    public void setTipo_fecha(String tipo_fecha) {
        this.tipo_fecha = tipo_fecha;
    }

    public String getFecha_entraga_posicion() {
        return fecha_entraga_posicion;
    }

    public void setFecha_entraga_posicion(String fecha_entraga_posicion) {
        this.fecha_entraga_posicion = fecha_entraga_posicion;
    }

    public String getGrupo_articulos() {
        return grupo_articulos;
    }

    public void setGrupo_articulos(String grupo_articulos) {
        this.grupo_articulos = grupo_articulos;
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

    public String getGrupo_compras() {
        return grupo_compras;
    }

    public void setGrupo_compras(String grupo_compras) {
        this.grupo_compras = grupo_compras;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getProveedor_deseado() {
        return proveedor_deseado;
    }

    public void setProveedor_deseado(String proveedor_deseado) {
        this.proveedor_deseado = proveedor_deseado;
    }

    public String getNum_cuenta_proveedor() {
        return num_cuenta_proveedor;
    }

    public void setNum_cuenta_proveedor(String num_cuenta_proveedor) {
        this.num_cuenta_proveedor = num_cuenta_proveedor;
    }

    public String getIndice_registro_no_valido() {
        return indice_registro_no_valido;
    }

    public void setIndice_registro_no_valido(String indice_registro_no_valido) {
        this.indice_registro_no_valido = indice_registro_no_valido;
    }

    public String getTipo_posicion_doc_compras2() {
        return tipo_posicion_doc_compras2;
    }

    public void setTipo_posicion_doc_compras2(String tipo_posicion_doc_compras2) {
        this.tipo_posicion_doc_compras2 = tipo_posicion_doc_compras2;
    }

    public String getNum_registro_info_compras() {
        return num_registro_info_compras;
    }

    public void setNum_registro_info_compras(String num_registro_info_compras) {
        this.num_registro_info_compras = num_registro_info_compras;
    }

    public String getOrganizacion_compras() {
        return organizacion_compras;
    }

    public void setOrganizacion_compras(String organizacion_compras) {
        this.organizacion_compras = organizacion_compras;
    }

    public String getNum_cuenta_mayor() {
        return num_cuenta_mayor;
    }

    public void setNum_cuenta_mayor(String num_cuenta_mayor) {
        this.num_cuenta_mayor = num_cuenta_mayor;
    }

    public String getCentro_coste() {
        return centro_coste;
    }

    public void setCentro_coste(String centro_coste) {
        this.centro_coste = centro_coste;
    }

    public String getNum_contrato_superior() {
        return num_contrato_superior;
    }

    public void setNum_contrato_superior(String num_contrato_superior) {
        this.num_contrato_superior = num_contrato_superior;
    }

    public String getNum_posicion_contrato_superior() {
        return num_posicion_contrato_superior;
    }

    public void setNum_posicion_contrato_superior(String num_posicion_contrato_superior) {
        this.num_posicion_contrato_superior = num_posicion_contrato_superior;
    }

    public String getIndicador_distribucion_imputacion_multiple() {
        return indicador_distribucion_imputacion_multiple;
    }

    public void setIndicador_distribucion_imputacion_multiple(String indicador_distribucion_imputacion_multiple) {
        this.indicador_distribucion_imputacion_multiple = indicador_distribucion_imputacion_multiple;
    }

    public String getNum_cuenta_mayor2() {
        return num_cuenta_mayor2;
    }

    public void setNum_cuenta_mayor2(String num_cuenta_mayor2) {
        this.num_cuenta_mayor2 = num_cuenta_mayor2;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getSociedad_co() {
        return sociedad_co;
    }

    public void setSociedad_co(String sociedad_co) {
        this.sociedad_co = sociedad_co;
    }

    public String getCentro_coste2() {
        return centro_coste2;
    }

    public void setCentro_coste2(String centro_coste2) {
        this.centro_coste2 = centro_coste2;
    }

    public String getTexto_cabecera() {
        return texto_cabecera;
    }

    public void setTexto_cabecera(String texto_cabecera) {
        this.texto_cabecera = texto_cabecera;
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

    public String getPrecio_solped() {
        return precio_solped;
    }

    public void setPrecio_solped(String precio_solped) {
        this.precio_solped = precio_solped;
    }

    public String getClave_moneda() {
        return clave_moneda;
    }

    public void setClave_moneda(String clave_moneda) {
        this.clave_moneda = clave_moneda;
    }
    

}
