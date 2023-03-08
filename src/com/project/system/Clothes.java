package com.project.system;

import java.util.List;

public class Clothes extends InventoryItem<Clothes> implements Product{
    private String color;
    private String size;
    private InventoryWareHouse inventoryWareHouse;

    public Clothes(String name, double price, int quantity, int specId, String color, String size){
        super(name, price, quantity,specId);
        this.color = color;
        this.size = size;
    }
    public void createClothesObject(String name, double price, int quantity, int specId, String color, String size){
        Clothes clothes = new Clothes(name, price, quantity,specId,color, size);
        System.out.println("Adding clothes to the warehouse list");
        inventoryWareHouse.addClothesToWareHouse(clothes);
    }
    @Override
    public String getDetails() {
        return null;
    }
    @Override
    public void addProduct(Clothes theClothes) {
        System.out.println("Adding clothes to the warehouse");
        inventoryWareHouse.addProductsToWareHouse(theClothes);
    }
    public void addClothes(Clothes theClothes){
        System.out.println("Adding clothes to this list of CLothes");
        inventoryWareHouse.addClothesToWareHouse(theClothes);
    }
    @Override
    public void removeProduct(int specId) {
        List<InventoryItem> listOfClothes =  inventoryWareHouse.getListOfClothes();

        for(InventoryItem clothes: listOfClothes){
            if(clothes.getSpecId() == specId){
                //remove that product from the list

            }

        }


    }

   /* @Override
    public void updatePrice(double price){
        this.price = price;
    }*/
    @Override
    public int updateQuantity(int newQuantity) {
        return 0;
    }



    @Override
    public int getQuantity() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getCategory() {
        return null;
    }
    public void updateNumberOfClothes(){

    }

}
