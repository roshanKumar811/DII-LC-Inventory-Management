package com.project.system;
import java.util.Scanner;

public class StoreInventory {
    private InventoryWareHouse inventoryWareHouse = new InventoryWareHouse();

    public static void main(String[] args) {

    }

    public static void printMenu(InventoryItem theInventory,InventoryWareHouse theWareHouse, Scanner sc){
        //init
        int choice;

        //User menu

        do{
            //when purchasing the product the person should get the entire product details
            System.out.println("Welcome to the Roshan's Store");
            System.out.println("1. Purchase the product");
            System.out.println("2. Return the Product");
            System.out.println("3. Get Product Details");
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

        }while(choice<0);
        switch(choice){
            case 1:
                theWareHouse.purchaseTheProduct();
            case 2:
                theWareHouse.addNewBookToWareHouse((Book) theInventory,sc);
            case 3:
                theWareHouse.getSpecificProductDetails();


        }
        //redisplay this menu unless the user wants to quit
        if(choice!=8){ //1:10:16
//            StoreInventory.printUserMenu(currentUser, sc);
        }
    }

    public static void checkOut(int productId){

    }

}
