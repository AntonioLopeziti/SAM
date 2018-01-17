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
public class textos_cabecera_solped {
   
    int id_tcs =0;
    String folio_sam=""; 
    String indice="";
    String columna_formato="";
    String linea_texto="";
    String SolicitanteTemp = "";

    public String getSolicitanteTemp() {
        return SolicitanteTemp;
    }

    public void setSolicitanteTemp(String SolicitanteTemp) {
        this.SolicitanteTemp = SolicitanteTemp;
    }
    

    public int getId_tcs() {
        return id_tcs;
    }

    public void setId_tcs(int id_tcs) {
        this.id_tcs = id_tcs;
    }

    public String getFolio_sam() {
        return folio_sam;
    }

    public void setFolio_sam(String folio_sam) {
        this.folio_sam = folio_sam;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getColumna_formato() {
        return columna_formato;
    }

    public void setColumna_formato(String columna_formato) {
        this.columna_formato = columna_formato;
    }

    public String getLinea_texto() {
        return linea_texto;
    }

    public void setLinea_texto(String linea_texto) {
        this.linea_texto = linea_texto;
    }
    
    
    
}
