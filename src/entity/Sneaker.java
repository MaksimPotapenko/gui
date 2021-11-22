/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author krasa
 */
public class Sneaker implements Serializable {
    private Brand sneakerFirm;
    private String sneakerModel;
    private double sneakerSize;
    private double sneakerPrice;
    private int sneakerQuantity;


    public String getSneakerModel() {
        return sneakerModel;
    }

    public void setSneakerModel(String sneakerModel) {
        this.sneakerModel = sneakerModel;
    }

    public double getSneakerSize() {
        return sneakerSize;
    }

    public void setSneakerSize(double sneakerSize) {
        this.sneakerSize = sneakerSize;
    }

    public double getSneakerPrice() {
        return sneakerPrice;
    }

    public void setSneakerPrice(double sneakerPrice) {
        this.sneakerPrice = sneakerPrice;
    }

    public int getSneakerQuantity() {
        return sneakerQuantity;
    }

    public void setSneakerQuantity(int quantity) {
        this.sneakerQuantity = quantity;
    }
    @Override
    public String toString() {
        return " кроссовок: " + sneakerFirm.getBrand() +" "+ sneakerModel + ", размер: " + sneakerSize + ", цена: " + sneakerPrice + " евро, " + sneakerQuantity + " шт." + ' ';
    }

    public Brand getSneakerFirm() {
        return sneakerFirm;
    }

    public void setSneakerFirm(Brand sneakerFirm) {
        this.sneakerFirm = sneakerFirm;
    }
}
