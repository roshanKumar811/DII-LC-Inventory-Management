package com.project.system;import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class InventoryWareHouse{
    private static int numberOfProduct=0;
    private static int totalNumberOfClothes = 0;
    private static int totalNumberOfBooks = 0;
    private static List<InventoryItem> inventoryItemList = new ArrayList<>();
    private static List<InventoryItem> bookList = new ArrayList<>();
    private static List<InventoryItem> clothesList = new ArrayList<>();
    public void addProductsToWareHouse(InventoryItem product) {
        this.inventoryItemList.add(product);
        numberOfProduct++;
    }
    public void addBooksToWareHouse(InventoryItem product){
        this.bookList.add(product);
    }
    public List<InventoryItem> getInventoryItemList() {
        return inventoryItemList;
    }
    public void addClothesToWareHouse(InventoryItem product){
        this.clothesList.add(product);
    }
    public void addNewBookToWareHouse(Book theBooks, Scanner sc){
        System.out.println("Enter your Full Name: ");
        String name = sc.next();
        System.out.println("Enter the Book price: ");
        double price = sc.nextDouble();
        System.out.println("Enter the quantity: ");
        int quantity = sc.nextInt();
        System.out.println("Enter the specId: ");
        int specId = sc.nextInt();
        System.out.println("Enter the author name: ");
        String authorName = sc.next();
        System.out.println("Enter publisher: ");
        String publisher = sc.next();
        System.out.println("Enter the book isbn number: ");
        int isbn = sc.nextInt();
        Book theBook = new Book(name, price, quantity, specId,authorName,publisher,isbn);
        theBook.addBooks2(theBook);
    }
    public List<InventoryItem> getBookList(){
        return this.bookList;
    }
    /**calculate total number of books in the the ware house.
     * return the number of books
     * */
    public int calculateTotalNumberOfBooks(){
        int totalNumberOfBooks = 0;
        for(InventoryItem inventoryItem : bookList){
            totalNumberOfBooks++;
        }
        return totalNumberOfBooks;
    }
    public void updateNumberOfBooks(){

    }
    public int calculateTotalNumberOfProduct() {
        return 0;
    }
    public static void updateNumberOfProductsInInventory(){

    }
    public static void main(String[] args) {
        InventoryWareHouse warehouse = new InventoryWareHouse();
        Book book1 = new Book("Book 122", 10.99, 5, 121223, "author1", "Publisher 1", 12334);
        Book book2 = new Book("Java-Book232", 10.99, 1, 12233, "james gosling" ,"Roshan Shoti", 12312);
        book1.addBooks2(book1);
//        book1.addProduct(book1);
//        warehouse.addProductsToWareHouse(book1);
//        warehouse.inventoryItemList.add(book1);

        System.out.println(warehouse.getInventoryItemList());
        System.out.println(warehouse.getBookList());
//
////        System.out.println(inven toryItemList.toString());
//
//        System.out.println("Book list: " + book1.getBooksItems().toString());
//
////        System.out.println("Book list: " + warehouse.getBookList());
//
////        System.out.println("Getting the book list from the book class ");
////        book1.getBooksItems();
        System.out.println("done");
        removeBookFromWareHouse(book1);
    }
    public List<InventoryItem> getListOfClothes(){
        return this.clothesList;
    }
    //get the author name by searching the name
    public static void searchTheAuthor(String name, Book theBook){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the author Name: ");
        String names = scan.nextLine();
        System.out.println("The author of the book is: " + theBook.searchByAuthorName(names));
    }
    public static void getBookDetails(String bookName, String authorName, Book theBook) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the book name: ");
        String bookNames = scan.next();
        System.out.println("Enter the author name: ");
        String author = scan.next();
        System.out.println(theBook.getBookDetails(bookName, authorName));
    }
    public static void removeBookFromWareHouse(InventoryItem theInventory){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the isbn number you want to delete: ");
        int isbnNumber = scan.nextInt();
        theInventory.removeProduct(isbnNumber);
        System.out.println("Successfully deleted");
    }
    public void purchaseTheProduct(InventoryItem product){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What product you want to buy?");
        String productName = scanner.next();
        lookingForProduct(productName, product, scanner);
        System.out.println("it reaches the looking for product method in purchaseTheProduct");
        if (inventoryItemList.contains(product)) {
            System.out.println("it contains there");
            if (product.getQuantity() > 0) {
                //reduce the quantity by 1
                product.setQuantity(product.getQuantity() - 1);
                //decrease the number of product by 1;
                numberOfProduct--;
                System.out.println(numberOfProduct);
                System.out.println("You have purchased: " + product.getName());
            } else {
                System.out.println("Sorry, this product is out of stock!");
            }
        } else {
            System.out.println("Sorry this product is not available in the inventory");
        }
    }
    //make a method that will display the number of quantity left in the ware house
    //after someone purchase the product
    //if purchase remove that product from the inventorywarehouse
    public static void deleteProductFromWareHouse(InventoryItem inventoryItem){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name you want to delete: ");
        String productName = scanner.next();
        if(productName.equals("Book")){
            int isbn = scanner.nextInt();
            Book theBook = (Book)inventoryItem;
            //test if you will get the book information without reaching to the book list.
            //if(theBook.equals("Book122")), should return true, if the book is there, since i am not using for loop for that
            //prolly will return false, since I am not using for loop for that
            theBook.removeProduct(isbn);
        }else if(productName.equals("Clothes")){
                //coming up

            }
        }
    public static void lookingForProduct(String product, InventoryItem inventoryItem, Scanner scanner){
        if(product.equals("Book")) {
            System.out.println("Enter the book name: ");
            String bookName = scanner.next();
            System.out.println("Enter the author name: ");
            String authorName = scanner.next();
            for(InventoryItem item : inventoryItemList) {
                Book theBook = (Book) item;
                if (theBook.getName().equals(bookName) && theBook.getAuthor().equals(authorName)) {
                    theBook.getBookDetails(bookName,authorName);
                    System.out.println("yes the book is there in the list from looking for product");
                }else{
                    System.out.println("The book is not here. Please retype your book name or author last name");
                }
            }
        }else if (product == "Clothes") {
            inventoryItem.getDetails();
        }
    }
    /*   public static void lookingForProduct(String product, InventoryItem inventoryItem, Scanner scanner){
           if(product == "Book") {
               System.out.println("Enter the book name: ");
               String bookName = scanner.next();
               System.out.println("Enter the author name: ");
               String authorName = scanner.next();
               for (InventoryItem item : inventoryItemList) {
                   Book theBook = (Book) item;
                   if (theBook.getName().equals(bookName) && theBook.getAuthor().equals(authorName)) {
                       theBook.getBookDetails(bookName,authorName);
                       System.out.println("Yes the book is in the list");
                   }
                   }
               }else if (product == "Clothes") {
                   inventoryItem.getDetails();
           }
       }*/
    //gives the information on the product they choose
    public void getSpecificProductDetails(InventoryItem inventoryItem) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the product you want to get information: ");
        String productName = scan.next();
        while (true) {
            if (productName == "Book") {
                System.out.println("Enter the Author name: ");
                String authorName = scan.next();
                System.out.println("Enter the isbn number: ");
                Book theBook = (Book) inventoryItem;
                int isbnNumber = scan.nextInt();
                if(authorName.equals(theBook.getName()) && isbnNumber == ((Book) theBook).getIsbn()){
                    theBook.getDetails();
                }
            }else if(productName == "Clothes"){
                System.out.println("Enter the clothes size you want: ");
                String size = scan.next();
                System.out.println("Enter the company brand: ");
                String brand = scan.next();
            }
        }
    }
    public static boolean checkProductType2(String product){
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        String productName = scan.next();
        if(productName.equals("Book")){
            for(InventoryItem inventory: inventoryItemList){
                Book theBook = (Book) inventory;
                System.out.println("Enter the Book name: ");
                String bookName = scan.next();
                System.out.println("Enter the Author name: ");
                String authorName = scan.next();
                //get book details
                theBook.getBookDetails(bookName,authorName);
                found = true;
            }
        }else if(productName.equals("CLothes")){
//            theBook.getClothesDetails();
            //display the clothes details
        }
        System.out.println("the value from checkProduct Type is: " + found);
        return found;
    }
    public void makeAnyChangesInWareHouse(InventoryItem inventoryItem){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Choose the product list you want to update in the Ware House");
            System.out.println("1). Update the price of the product");
            System.out.println("2). Remove the specific Product from the Ware-House");
            System.out.println("0). Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    InventoryWareHouse.updatePriceOfTheProduct(inventoryItem);
                    break;
                case 2:
                    InventoryWareHouse.removeTheSpecificProductFromWareHouse(inventoryItem);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
                    break;
            }
        } while (choice != 0);
    }
    //update the price of the product
    public static void updatePriceOfTheProduct(InventoryItem inventoryItem){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name you want to update: ");
        String productName = scanner.next();
        if(productName.equals("Book")){
            System.out.println("IT doesnttt");
            for(InventoryItem item: bookList){
                System.out.println(inventoryItemList.toString());
                System.out.println("Enter the author name: ");
                String authorName = scanner.next();
                System.out.println("Enter the book name: ");
                String bookName = scanner.next();
                Book theBook = (Book)item;
                System.out.println("HI");
                if(theBook.getName().equals(authorName) && theBook.getAuthor().equals(bookName)){
                    //first get the book details
                    System.out.println("Hi2");
                    theBook.getBookDetails(bookName,authorName);
                    //update the price of the product
                    System.out.println("Enter the price you want to change: ");
                    double price = scanner.nextDouble();
                    theBook.updatePrice(price);
                    System.out.println("Now the price of this product is: ");
                    theBook.getPrice();
                    System.out.println(theBook.getPrice());
                }
            }
        }else if(productName.equals("Cothes")){
            System.out.println("COMING UP--->HOLD UP");
        }
       /* if(checkProductType(productName)){
            Book theBook = (Book)inventoryItem;
            if(theBook.getName().equals())
        }*/
        System.out.println("Yo");
    }
    //removes the specific product from the ware-house
    public static void removeTheSpecificProductFromWareHouse(InventoryItem inventoryItem){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name you want to remove: ");
        String productName = scanner.next();
        if(productName.equals("Book")){
            for(InventoryItem item: inventoryItemList){
                Book theBook = (Book)item;
                System.out.println("Enter the book name: ");
                String bookName = scanner.next();
                System.out.println("Enter the author name: ");
                String authorName = scanner.next();
                System.out.println("Enter the book isbn number: ");
                int isbn = scanner.nextInt();
                if(theBook.getName().equals(productName) && theBook.getIsbn() == isbn) {
                    theBook.removeProduct(isbn);
                    System.out.println("The product is removed from warehouse");
                    System.out.println("After removing the product: " + bookList.toString());
                    System.out.println("After removing the product in the inventory list: " + inventoryItemList.toString());
                }else{
                    System.out.println("Sorry couldn't find the book name or author name. Please try again!");
                }
            }
        }else if(productName.equals("Clothes")){
            System.out.println("FOR CLOTHES COMING UP --->HOLD UP");
        }
    }
}
