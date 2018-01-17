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
public class CuentaMayor {
    int id_cm;
    String num_cuenta_mayor;
    String plan_cuentas;
    String descripcion;

    public int getId_cm() {
        return id_cm;
    }

    public void setId_cm(int id_cm) {
        this.id_cm = id_cm;
    }

    public String getNum_cuenta_mayor() {
        return num_cuenta_mayor;
    }

    public void setNum_cuenta_mayor(String num_cuenta_mayor) {
        this.num_cuenta_mayor = num_cuenta_mayor;
    }

    public String getPlan_cuentas() {
        return plan_cuentas;
    }

    public void setPlan_cuentas(String plan_cuentas) {
        this.plan_cuentas = plan_cuentas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
