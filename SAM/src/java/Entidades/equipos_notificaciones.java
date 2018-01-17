/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Erick_Jimenez
 */
public class equipos_notificaciones {
int     id_en;
String	num_equipo = "";
String	material = "";
String	serie = "";
String	centro = "";
String	almacen = "";
String	num_orden = "";
String	equipo_superior;
String	lote = ""; 
String  montado = "";

    public int getId_en() {
        return id_en;
    }

    public String getNum_equipo() {
        return num_equipo;
    }

    public String getMaterial() {
        return material;
    }

    public String getSerie() {
        return serie;
    }

    public String getCentro() {
        return centro;
    }

    public String getAlmacen() {
        return almacen;
    }

    public String getNum_orden() {
        return num_orden;
    }

    public String getEquipo_superior() {
        return equipo_superior;
    }

    public String getLote() {
        return lote;
    }

    public void setId_en(int id_en) {
        this.id_en = id_en;
    }

    public void setNum_equipo(String num_equipo) {
        this.num_equipo = num_equipo;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public void setNum_orden(String num_orden) {
        this.num_orden = num_orden;
    }

    public void setEquipo_superior(String equipo_superior) {
        this.equipo_superior = equipo_superior;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getMontado(){
        return montado;
    }
    public void setMontado(String montado){
        this.montado = montado;
    }
    

}
