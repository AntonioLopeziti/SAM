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
public class usuario_grupo_materiales {
    int id_guma;
    String num_personal ="";
    String grupo_usuario_lista_material = "";

    public int getId_guma() {
        return id_guma;
    }

    public void setId_guma(int id_guma) {
        this.id_guma = id_guma;
    }

    public String getNum_personal() {
        return num_personal;
    }

    public void setNum_personal(String num_personal) {
        this.num_personal = num_personal;
    }

    public String getGrupo_usuario_lista_material() {
        return grupo_usuario_lista_material;
    }

    public void setGrupo_usuario_lista_material(String grupo_usuario_lista_material) {
        this.grupo_usuario_lista_material = grupo_usuario_lista_material;
    }
    
    
    
}
