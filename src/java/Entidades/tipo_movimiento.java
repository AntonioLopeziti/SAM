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
public class tipo_movimiento {
    
 String id_tipo_mov;
 String descripcion_mov;
    
 public String getid_tipo_mov(){
    return id_tipo_mov;
 }
 
 public void setid_tipo_mov(String id_tipo_mov){
     this.id_tipo_mov =id_tipo_mov;
 }
 
 public String getdescripcion_mov(){
     return descripcion_mov;
 }
 
 public void setdescripcion_mov(String descripcion_mov){
     this.descripcion_mov = descripcion_mov;
 }
}
