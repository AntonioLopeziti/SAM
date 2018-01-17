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
public class Relacion {
   String jerarquia;
   int nivel;
   String id_ubitec = "";
   String num_equipo = "";
   String equipo1 = "";
   String equipo2 = "";
   String equipo3 = "";
   String equipo4 = "";
   String equipo5 = "";
   String equipo6 = "";
   String centro = "";
   String descripcion_equipo = "";
   String sociedad = "";
   
   
   public String getjerarquia(){
       return jerarquia;
   }
   
   public void setjerarquia(String jerarquia){
     this.jerarquia = jerarquia;  
   }
   
   
   public int getnivel(){
       return nivel;
   }
   
   public void setnivel(int nivel){
       this.nivel = nivel;
   }
   
   public String getid_ubitec(){
       return id_ubitec;
   }
   
   public void setid_ubitec(String id_ubitec){
       this.id_ubitec = id_ubitec;
   }
   
   public String getnum_equipo(){
       return num_equipo;
   }
   
   public void setnum_equipo(String num_equipo){
       this.num_equipo = num_equipo;
   }
   
   public String getequipo1(){
       return equipo1;
   }
   
   public void setequipo1(String equipo1){
       this.equipo1 = equipo1;
   }
   
   public String getequipo2(){
       return equipo2;
   }
   
   public void setequipo2(String equipo2){
       this.equipo2= equipo2;
   }
   public String getequipo3(){
       return equipo3;
   }
   
   public void setequipo3(String equipo3){
       this.equipo3 = equipo3;
   }
   public String getequipo4(){
       return equipo4;
   }
   
   public void setequipo4(String equipo4){
       this.equipo4 = equipo4;
   }
   public String getequipo5(){
       return equipo5;
   }
   
   public void setequipo5(String equipo5){
       this.equipo5 = equipo5;
   }
   public String getequipo6(){
       return equipo6;
   }
   
   public void setequipo6(String equipo6){
       this.equipo6 = equipo6;
   }
   
   public String getcentro(){
       return centro;
   }
   
   public void setcentro(String centro){
       this.centro = centro;
   }
   
   public String getdescripcion_equipo(){
       return descripcion_equipo;
   }
   
   public void setdescripcion_equipo(String descripcion_equipo){
       this.descripcion_equipo = descripcion_equipo;
   }
   
    public String getsociedad(){
       return sociedad;
   }
   
   public void setsociedad(String sociedad){
       this.sociedad = sociedad;
   }
}
