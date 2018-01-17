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
public class ordenes_pm_notificaciones {
    int id_opmn;
    String clase_orden = "" ;
    String sociedad_co = "" ;
    String num_orden = "" ;
    String status = "" ;
    String texto_breve = "" ;  
    String tipo_orden = "";
    String centro = "";

    public String getTipo_orden() {
        return tipo_orden;
    }

    public void setTipo_orden(String tipo_orden) {
        this.tipo_orden = tipo_orden;
    }
    
    
     public int getId_opmn() {
        return id_opmn;
    }
      public void setId_opmn(int id_opmn) {
        this.id_opmn = id_opmn;
    }
      
      
    public String getClase_orden() {
        return clase_orden;
    }

    public void setClase_orden(String clase_orden) {
        this.clase_orden = clase_orden;
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
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTexto_breve() {
        return texto_breve;
    }

    public void setTexto_breve(String texto_breve) {
        this.texto_breve = texto_breve;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }
    
}
