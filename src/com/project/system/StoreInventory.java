package com.project.system;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class StoreInventory {
    private static InventoryWareHouse inventoryWareHouse = new InventoryWareHouse();

    public static void main(String[] args) {

        //it will have different copy
        InventoryWareHouse warehouse = new InventoryWareHouse();


        Book book1 = new Book("Book 122", 10.99, 5, 121223, "author1", "Publisher 1", 1234);
        Book book2 = new Book("Java-Book232", 10.99, 1, 12233, "james gosling" ,"Roshan Shoti", 111);
        warehouse.addProductsToWareHouse(book1);
        book1.addProduct(book1);
        System.out.println("From the book1 addProduct method: " + warehouse.getBookList());
        System.out.println(warehouse.getInventoryItemList());
        printMenu(book1);
        System.out.println(warehouse.getInventoryItemList());
    }

    public static void printMenu(InventoryItem inventoryItem){
        //init
        int choice;

        //User menu
        Scanner sc = new Scanner(System.in);
        do{
            //when purchasing the product the person should get the entire product details
            System.out.println("Welcome to the Roshan's Store");
            System.out.println("1. Purchase the product");
            System.out.println("2. Return the Product");
            System.out.println("3. Get Product Details");
            System.out.println("4. Make Changes in the WareHouse"); 
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

        }while(choice<0);
        switch(choice){
            case 1:
                inventoryWareHouse.purchaseTheProduct(inventoryItem);
            case 2:
//                inventoryWareHouse.addNewBookToWareHouse((Book) inventoryItem,sc);
            case 3:

            case 4: 
                //make changes the product information in ware-house
                inventoryWareHouse.makeAnyChangesInWareHouse(inventoryItem);
        }
        //redisplay this menu unless the user wants to quit
        if(choice!=8){ //1:10:16
//            StoreInventory.printUserMenu(currentUser, sc);
        }
    }

    public static void checkOut(int productId){

    }

}
