/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author krasa
 */
public class Sneaker {
    private String sneakerFirm;
    private String sneakerModel;
    private double sneakerSize;
    private double sneakerPrice;
    private int sneakerQuantity;


    public String getSneakerFirm() {
        return sneakerFirm;
    }

    public void setSneakerFirm(String sneakerFirm) {
        this.sneakerFirm = sneakerFirm;
    }

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
        return " кроссовок: " + sneakerFirm +" "+ sneakerModel + ", размер: " + sneakerSize + ", цена: " + sneakerPrice + " евро, " + sneakerQuantity + " шт." + ' ';
    }
}
