/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Panda
 */
public class InventoryUpdate {
    String ProductId;
    int InQuantity;
    double OutQuantity;
    String WarehouseCode;
    String BranchCode;
    String Location;
    String batch;

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public int getInQuantity() {
        return InQuantity;
    }

    public void setInQuantity(int InQuantity) {
        this.InQuantity = InQuantity;
    }

    public double getOutQuantity() {
        return OutQuantity;
    }

    public void setOutQuantity(double OutQuantity) {
        this.OutQuantity = OutQuantity;
    }

    public String getWarehouseCode() {
        return WarehouseCode;
    }

    public void setWarehouseCode(String WarehouseCode) {
        this.WarehouseCode = WarehouseCode;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String BranchCode) {
        this.BranchCode = BranchCode;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
    
}
