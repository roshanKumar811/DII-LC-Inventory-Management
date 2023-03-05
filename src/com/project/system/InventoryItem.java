package com.project.system;
import java.util.Random;

public abstract class InventoryItem<T>{
    private String name;
    private double price;
    private int quantity;
    private int specId;
    public InventoryItem(String name, double price, int quantity, int specId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.specId = specId;
    }
    public InventoryItem(){

    }
    public int getQuantity() {
        return quantity;
    }
    public int getSpecId() {
        return this.specId;
    }
    public void setSpecId(int specId) {
        this.specId = specId;
    }
    public double getPrice() {
        return price;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void updatePrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void checkNull(){
    }
    public abstract String getDetails();
    public abstract void addProduct(T objects);
    public abstract void removeProduct(int specId);
    /*@Override
    public String toString() {
        return "InventoryItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }*/
    //generate a specific random digits for each Product and clothes;
    public String generateRandomNumberForProduct(){
        String uuid = "";
        Random random = new Random();
        int length = 5;
        boolean isUnique;
        for(int i = 0; i<length; i++){
            uuid+=((Integer)random.nextInt(length)).toString();
        }
        return uuid;
    }

}
