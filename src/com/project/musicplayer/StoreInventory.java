package com.project.inventory;

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

            choice = sc.nextInt();
            // if(choice<1 || choice>5){
            //    System.out.println("Invalid choice. Please choose 1-5");
            // }
        }while(choice<0); //1:08:15
        switch(choice){
            case 1:
                theWareHouse.createBookObject((Book) theInventory,sc);

            case 2:


        }
        //redisplay this menu unless the user wants to quit
        if(choice!=8){ //1:10:16
//            StoreInventory.printUserMenu(currentUser, sc);
        }
    }

}
