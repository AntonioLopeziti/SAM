/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author AREcosulting
 */
public class equipos {
    int id_equipo;
    String id_ubitec = "";
    String num_equipo = "";
    String descripcion_equipo = "";
    String centro_puesto_trabajo = "";

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    String denominacion;
    public String getCentro_puesto_trabajo() {
        return centro_puesto_trabajo;
    }

    public void setCentro_puesto_trabajo(String centro_puesto_trabajo) {
        this.centro_puesto_trabajo = centro_puesto_trabajo;
    }

    
    public String getDenominacion_es() {
        return denominacion_es;
    }

    public void setDenominacion_es(String denominacion_es) {
        this.denominacion_es = denominacion_es;
    }

    public String getDenominacion_en() {
        return denominacion_en;
    }

    public void setDenominacion_en(String denominacion_en) {
        this.denominacion_en = denominacion_en;
    }
    String denominacion_es;
    String denominacion_en;
    String tipo_equipo;
    String tipo_objtecnico;
    String grupo_autorizaciones;
    String pais_fabricacion;
    String fabricante_activofijo;
    String denominacion_tipofabri;
    String num_material_porpiezafabri;
    String serie_segunfabri;
    String ano_construccion;
    String mes_construccion;
    String centro_emplazamiento;
    String emplazamiento_activofijo;
    String area_empresa;
    String campo_clasificacion;
    String Sociedad;
    String num_activofijo_vehiculo;
    String centro_coste;
    String centro_plani_mante;
    String puesto_responsable_medmnte;
    String nombre_respo_anaobj;
    String id_obj_puestotraba;
    String material;
    String descripcion_material;
    String serie;
    String tipo_stock_movimerca;
    String centro;
    String almacen;
    String lote;
    String indicador_stock_especial;
    String num_deudor;
    String proveedor;
    String fecha_ulti_movimerca;
    String primera_entrada;
    String punto_medida;
    String unidad_medida_punto;
    String equipo_superior;
    String grupo_planificador;
    String indicador_abc;
    String lote_maestro;

    public String getLote_maestro() {
        return lote_maestro;
    }

    public void setLote_maestro(String lote_maestro) {
        this.lote_maestro = lote_maestro;
    }
 
    public String getIndicador_abc() {
        return indicador_abc;
    }

    public void setIndicador_abc(String indicador_abc) {
        this.indicador_abc = indicador_abc;
    }
    

    
    public String getGrupo_planificador() {
        return grupo_planificador;
    }

    public void setGrupo_planificador(String grupo_planificador) {
        this.grupo_planificador = grupo_planificador;
    }
    
    public String getEquipo_superior() {
        return equipo_superior;
    }

    public void setEquipo_superior(String equipo_superior) {
        this.equipo_superior = equipo_superior;
    }
    
    

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getId_ubitec() {
        return id_ubitec;
    }

    public void setId_ubitec(String id_ubitec) {
        this.id_ubitec = id_ubitec;
    }

    public String getNum_equipo() {
        return num_equipo;
    }

    public void setNum_equipo(String num_equipo) {
        this.num_equipo = num_equipo;
    }

    public String getDescripcion_equipo() {
        return descripcion_equipo;
    }

    public void setDescripcion_equipo(String descripcion_equipo) {
        this.descripcion_equipo = descripcion_equipo;
    }

    public String getTipo_equipo() {
        return tipo_equipo;
    }

    public void setTipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }

    public String getTipo_objtecnico() {
        return tipo_objtecnico;
    }

    public void setTipo_objtecnico(String tipo_objtecnico) {
        this.tipo_objtecnico = tipo_objtecnico;
    }

    public String getGrupo_autorizaciones() {
        return grupo_autorizaciones;
    }

    public void setGrupo_autorizaciones(String grupo_autorizaciones) {
        this.grupo_autorizaciones = grupo_autorizaciones;
    }

    public String getPais_fabricacion() {
        return pais_fabricacion;
    }

    public void setPais_fabricacion(String pais_fabricacion) {
        this.pais_fabricacion = pais_fabricacion;
    }

    public String getFabricante_activofijo() {
        return fabricante_activofijo;
    }

    public void setFabricante_activofijo(String fabricante_activofijo) {
        this.fabricante_activofijo = fabricante_activofijo;
    }

    public String getDenominacion_tipofabri() {
        return denominacion_tipofabri;
    }

    public void setDenominacion_tipofabri(String denominacion_tipofabri) {
        this.denominacion_tipofabri = denominacion_tipofabri;
    }

    public String getNum_material_porpiezafabri() {
        return num_material_porpiezafabri;
    }

    public void setNum_material_porpiezafabri(String num_material_porpiezafabri) {
        this.num_material_porpiezafabri = num_material_porpiezafabri;
    }

    public String getSerie_segunfabri() {
        return serie_segunfabri;
    }

    public void setSerie_segunfabri(String serie_segunfabri) {
        this.serie_segunfabri = serie_segunfabri;
    }

    public String getAno_construccion() {
        return ano_construccion;
    }

    public void setAno_construccion(String ano_construccion) {
        this.ano_construccion = ano_construccion;
    }

    public String getMes_construccion() {
        return mes_construccion;
    }

    public void setMes_construccion(String mes_construccion) {
        this.mes_construccion = mes_construccion;
    }

    public String getCentro_emplazamiento() {
        return centro_emplazamiento;
    }

    public void setCentro_emplazamiento(String centro_emplazamiento) {
        this.centro_emplazamiento = centro_emplazamiento;
    }

    public String getEmplazamiento_activofijo() {
        return emplazamiento_activofijo;
    }

    public void setEmplazamiento_activofijo(String emplazamiento_activofijo) {
        this.emplazamiento_activofijo = emplazamiento_activofijo;
    }

    public String getArea_empresa() {
        return area_empresa;
    }

    public void setArea_empresa(String area_empresa) {
        this.area_empresa = area_empresa;
    }

    public String getCampo_clasificacion() {
        return campo_clasificacion;
    }

    public void setCampo_clasificacion(String campo_clasificacion) {
        this.campo_clasificacion = campo_clasificacion;
    }

    public String getSociedad() {
        return Sociedad;
    }

    public void setSociedad(String Sociedad) {
        this.Sociedad = Sociedad;
    }

    public String getNum_activofijo_vehiculo() {
        return num_activofijo_vehiculo;
    }

    public void setNum_activofijo_vehiculo(String num_activofijo_vehiculo) {
        this.num_activofijo_vehiculo = num_activofijo_vehiculo;
    }

    public String getCentro_coste() {
        return centro_coste;
    }

    public void setCentro_coste(String centro_coste) {
        this.centro_coste = centro_coste;
    }

    public String getCentro_plani_mante() {
        return centro_plani_mante;
    }

    public void setCentro_plani_mante(String centro_plani_mante) {
        this.centro_plani_mante = centro_plani_mante;
    }

    public String getPuesto_responsable_medmnte() {
        return puesto_responsable_medmnte;
    }

    public void setPuesto_responsable_medmnte(String puesto_responsable_medmnte) {
        this.puesto_responsable_medmnte = puesto_responsable_medmnte;
    }

    public String getNombre_respo_anaobj() {
        return nombre_respo_anaobj;
    }

    public void setNombre_respo_anaobj(String nombre_respo_anaobj) {
        this.nombre_respo_anaobj = nombre_respo_anaobj;
    }

    public String getId_obj_puestotraba() {
        return id_obj_puestotraba;
    }

    public void setId_obj_puestotraba(String id_obj_puestotraba) {
        this.id_obj_puestotraba = id_obj_puestotraba;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescripcion_material() {
        return descripcion_material;
    }

    public void setDescripcion_material(String descripcion_material) {
        this.descripcion_material = descripcion_material;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo_stock_movimerca() {
        return tipo_stock_movimerca;
    }

    public void setTipo_stock_movimerca(String tipo_stock_movimerca) {
        this.tipo_stock_movimerca = tipo_stock_movimerca;
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

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getIndicador_stock_especial() {
        return indicador_stock_especial;
    }

    public void setIndicador_stock_especial(String indicador_stock_especial) {
        this.indicador_stock_especial = indicador_stock_especial;
    }

    public String getNum_deudor() {
        return num_deudor;
    }

    public void setNum_deudor(String num_deudor) {
        this.num_deudor = num_deudor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha_ulti_movimerca() {
        return fecha_ulti_movimerca;
    }

    public void setFecha_ulti_movimerca(String fecha_ulti_movimerca) {
        this.fecha_ulti_movimerca = fecha_ulti_movimerca;
    }

    public String getPrimera_entrada() {
        return primera_entrada;
    }

    public void setPrimera_entrada(String primera_entrada) {
        this.primera_entrada = primera_entrada;
    }

    public String getPunto_medida() {
        return punto_medida;
    }

    public void setPunto_medida(String punto_medida) {
        this.punto_medida = punto_medida;
    }

    public String getUnidad_medida_punto() {
        return unidad_medida_punto;
    }

    public void setUnidad_medida_punto(String unidad_medida_punto) {
        this.unidad_medida_punto = unidad_medida_punto;
    }
    
    
    
}
