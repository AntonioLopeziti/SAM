package Entidades;

public class ordenes_control {

    String id_oc;
    String num_orden;
    String folio_sam_orden;
    String nombre_autor;
    String fecha_entrada;
    String modificado_por;
    String fecha_modificacion;

    public String getId_oc() {
        return id_oc;
    }

    public void setId_oc(String id_oc) {
        this.id_oc = id_oc;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public String getFolio_sam_orden() {
        return folio_sam_orden;
    }

    public void setFolio_sam_orden(String folio_sam_orden) {
        this.folio_sam_orden = folio_sam_orden;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getModificado_por() {
        return modificado_por;
    }

    public void setModificado_por(String modificado_por) {
        this.modificado_por = modificado_por;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

}
