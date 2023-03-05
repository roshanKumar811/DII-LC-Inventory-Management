package com.project.system;
import java.util.List;

public interface Product{
    String getName();
    double getPrice();
    int getQuantity();
    String getDescription();

    String getCategory();

    int updatePrice(int thePrice);

    int updateQuantity(int newQuantity);

    int getSpecId();

    void updateNumberOfProductsInInventory();



}
