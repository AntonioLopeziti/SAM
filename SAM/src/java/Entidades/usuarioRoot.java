/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;

/**
 *
 * @author Developer-Antonio
 */
public class usuarioRoot implements Serializable {

    String UsuarioSAM = "";
    String PasswordSAM = "";
    String ServidorSAM = "";
    String PuertoSAM = "";
    String BaseDatosSAM = "";
    String WebService = "";

    String SystemNumberSAP = "";
    String AppServerSAP = "";
    String ClientSAP = "";
    String UserSAP = "";
    String PWDSAP = "";
    String LanguajeSAP = "";
    String SAPRouterSAP = "";

    public String getWebService() {
        return WebService;
    }

    public void setWebService(String WebService) {
        this.WebService = WebService;
    }
    
    public String getUsuarioSAM() {
        return UsuarioSAM;
    }

    public void setUsuarioSAM(String UsuarioSAM) {
        this.UsuarioSAM = UsuarioSAM;
    }

    public String getPasswordSAM() {
        return PasswordSAM;
    }

    public void setPasswordSAM(String PasswordSAM) {
        this.PasswordSAM = PasswordSAM;
    }

    public String getServidorSAM() {
        return ServidorSAM;
    }

    public void setServidorSAM(String ServidorSAM) {
        this.ServidorSAM = ServidorSAM;
    }

    public String getPuertoSAM() {
        return PuertoSAM;
    }

    public void setPuertoSAM(String PuertoSAM) {
        this.PuertoSAM = PuertoSAM;
    }

    public String getBaseDatosSAM() {
        return BaseDatosSAM;
    }

    public void setBaseDatosSAM(String BaseDatosSAM) {
        this.BaseDatosSAM = BaseDatosSAM;
    }

    public String getSystemNumberSAP() {
        return SystemNumberSAP;
    }

    public void setSystemNumberSAP(String SystemNumberSAP) {
        this.SystemNumberSAP = SystemNumberSAP;
    }

    public String getAppServerSAP() {
        return AppServerSAP;
    }

    public void setAppServerSAP(String AppServerSAP) {
        this.AppServerSAP = AppServerSAP;
    }

    public String getClientSAP() {
        return ClientSAP;
    }

    public void setClientSAP(String ClientSAP) {
        this.ClientSAP = ClientSAP;
    }

    public String getUserSAP() {
        return UserSAP;
    }

    public void setUserSAP(String UserSAP) {
        this.UserSAP = UserSAP;
    }

    public String getPWDSAP() {
        return PWDSAP;
    }

    public void setPWDSAP(String PWDSAP) {
        this.PWDSAP = PWDSAP;
    }

    public String getLanguajeSAP() {
        return LanguajeSAP;
    }

    public void setLanguajeSAP(String LanguajeSAP) {
        this.LanguajeSAP = LanguajeSAP;
    }

    public String getSAPRouterSAP() {
        return SAPRouterSAP;
    }

    public void setSAPRouterSAP(String SAPRouterSAP) {
        this.SAPRouterSAP = SAPRouterSAP;
    }

}
