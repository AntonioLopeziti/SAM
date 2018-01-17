package Entidades;

public class inspeccion_codigos {
    int id_ipc;
    String conjunto_seleccion;
    String grupo_codigos;
    String codigo;
    String descripcion;
    String valoracion_codigo = "";

    public String getValoracion_codigo() {
        return valoracion_codigo;
    }

    public void setValoracion_codigo(String valoracion_codigo) {
        this.valoracion_codigo = valoracion_codigo;
    }

    public int getId_ipc() {
        return id_ipc;
    }

    public void setId_ipc(int id_ipc) {
        this.id_ipc = id_ipc;
    }

    public String getConjunto_seleccion() {
        return conjunto_seleccion;
    }

    public void setConjunto_seleccion(String conjunto_seleccion) {
        this.conjunto_seleccion = conjunto_seleccion;
    }

    public String getGrupo_codigos() {
        return grupo_codigos;
    }

    public void setGrupo_codigos(String grupo_codigos) {
        this.grupo_codigos = grupo_codigos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
