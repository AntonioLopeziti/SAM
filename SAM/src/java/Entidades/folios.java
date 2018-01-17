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
public class folios {
    String id_folio;
    int folio_inicial;
    int folio_final;
    int folio_actual;

//    public String getId_folio() {
//        return id_folio;
//    }
//
//    public void setId_folio(String id_folio) {
//        this.id_folio = id_folio;
//    }
//
//    public int getFolio_inicial() {
//        return folio_inicial;
//    }
//
//    public void setFolio_inicial(int folio_inicial) {
//        this.folio_inicial = folio_inicial;
//    }
//
//    public int getFolio_final() {
//        return folio_final;
//    }
//
//    public void setFolio_final(int folio_final) {
//        this.folio_final = folio_final;
//    }
//
//    public int getFolio_actual() {
//        return folio_actual;
//    }
//
//    public void setFolio_actual(int folio_actual) {
//        this.folio_actual = folio_actual;
//    }
 public folios() {
    }
    public folios(String id_folio, int folio_inicial, int folio_final, int folio_actual) {
        this.id_folio = id_folio;
        this.folio_inicial = folio_inicial;
        this.folio_final = folio_final;
        this.folio_actual = folio_actual;
    }
    public String getIdFolios() {
        return id_folio;
    }

    public void setIdFolios(String id_folio) {
        this.id_folio = id_folio;
    }

    public int getFolioInicial() {
        return folio_inicial;
    }

    public void setFolioInicial(int folio_inicial) {
        this.folio_inicial = folio_inicial;
    }

    public int getFolioFinal() {
        return folio_final;
    }

    public void setFolioFinal(int folio_final) {
        this.folio_final = folio_final;
    }

    public int getFolioActual() {
        return folio_actual;
    }

    public void setFolioActual(int folio_actual) {
        this.folio_actual = folio_actual;
    }

    
    
    
}
