package com.project.system;import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
   /* public void addNewBookToWareHouse(Book theBooks, Scanner sc){
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
        *//*Book theBook = new Book(name, price, quantity, specId,authorName,publisher,isbn);
        theBook.addBooks2(theBook);*//*
    }*/
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
    public int calculateTotalNumberOfProduct() {
        return numberOfProduct;
    }
    public static void updateNumberOfProductsInInventory(){
    }
    public void removeBook(int isbn) {
        List<InventoryItem> listOfBooks = bookList;
        ListIterator<InventoryItem> bookIterator = (ListIterator<InventoryItem>) listOfBooks.listIterator();
        while(bookIterator.hasNext()){
            InventoryItem book = bookIterator.next();
            if(book instanceof Book){
                Book theBook = (Book)book;
                if(theBook.getIsbn() == isbn){
                    bookIterator.remove();
                    break;
                }else{
                    System.out.println("Sorry couldn't find the book isbn number: ");
                }
            }
        }
        List<InventoryItem> listOfInventoryList = inventoryItemList;
        ListIterator<InventoryItem> inventoryIterator = (ListIterator<InventoryItem>) listOfInventoryList.listIterator();
        while(inventoryIterator.hasNext()){
            InventoryItem item = inventoryIterator.next();
            if(item.getSpecId() == isbn){
                inventoryIterator.remove();
                break;
            }else{
                System.out.println("Sorry couldn't find the book isbn number: ");
            }
        }
        System.out.println("After deleting: " + bookList.toString());
    }
    public List<InventoryItem> getListOfClothes(){
        return this.clothesList;
    }
    public void purchaseTheProduct(InventoryItem product){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What product you want to buy?");
        String productName = scanner.nextLine();
        System.out.println(inventoryItemList.toString());
        if(productName.equals("Book")) {
            for(InventoryItem item : inventoryItemList) {
                System.out.println("Enter the book name: ");
                String bookName = scanner.nextLine();
                System.out.println("Enter the author name: ");
                String authorName = scanner.nextLine();
                Book theBook = (Book) item;
                System.out.println("it reaches the looking for product method in purchaseTheProduct");
                if (theBook.getName().equals(bookName) && theBook.getAuthor().equals(authorName)){
                    System.out.println("it contains there");
                   System.out.println("the details: " + theBook.getBookDetails(bookName,authorName));
                    System.out.println("the book name is: " + theBook.getName());
                    if (product.getQuantity() > 0) {
                        //reduce the quantity by 1
                        product.setQuantity(product.getQuantity() - 1);
                        //decrease the number of product by 1;
                        numberOfProduct--;
                        System.out.println(numberOfProduct);
                        System.out.println("--------------------------------");
                        System.out.println("You have purchased: " + theBook.getName());
                        System.out.println("The isbn number of the book: " + theBook.getIsbn());
//                    System.out.println(theBook.getBookDetails(theBook.getBookDetails(theBook.getName(), )));
                    } else {
                        System.out.println("Sorry, this product is out of stock!");
                    }
                } else {
                    System.out.println("Sorry this product is not available in the inventory");
                }
            }
        }
    }
    //gives the information on the product they choose
    public void getSpecificProductDetails2(InventoryItem inventoryItem) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the product you want to get information: ");
        String productName = scan.next();
        if (productName.equals("Book")) {
            System.out.println("Enter the Author name: ");
            String authorName = scan.next();
            System.out.println("Enter the isbn number: ");
            Book theBook = (Book) inventoryItem;
            int isbnNumber = scan.nextInt();
            if (authorName.equals(theBook.getName()) && isbnNumber == ((Book) theBook).getIsbn()) {

            }
        } else if (productName == "Clothes") {
            System.out.println("Enter the clothes size you want: ");
            String size = scan.next();
            System.out.println("Enter the company brand: ");
            String brand = scan.next();
        }
    }
    public void addBookProduct(Book theBook) {
        System.out.println("Adding books to the warehouse");
        //Only add the book to the warehouse if there is not any duplicate spec Id and the ISBN
        //if there is some duplicate specID and isbn immediately return false or print message
        if(checkIfBookISBNExist(theBook.getIsbn())){
            bookList.add(theBook);
            System.out.println("it touched in this line");
        }else{
            System.out.println("Sorry there is already a duplicate value, your id and isbn should be unique");
        }
    }
    /**
     * this method checks whether the isbn already exist in the booksItems list
     * @param isbn
     * @return
     */
    public static boolean checkIfBookISBNExist(int isbn) {
        boolean found = true;
        List<InventoryItem> listOfBooks = bookList;
        for (InventoryItem theBooks : listOfBooks) {
            if (theBooks instanceof Book) {
                Book theBook = (Book) theBooks;
                if (theBook.getIsbn() == isbn) {
                    System.out.println("it returned false");
                    return false;
                }
            }
        }
        System.out.println("it is: " + found);
        return found;
    }
    public String searchByAuthorName(String name){
        List<InventoryItem> listOfBooks = bookList;
        for(InventoryItem theBooks: listOfBooks) {
            if (theBooks instanceof Book) {
                Book theBook = (Book)theBooks;
                if (name.equals(theBooks.getName())) {
                    System.out.println("Founded");
                    return "The Author name is: " + theBook.getName();
                }
            }
        }
        return "Didn't found the author name";
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
    public static void updatePriceOfTheProduct(InventoryItem inventoryItem) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name you want to update: ");
        String productName = scanner.nextLine().trim();
        if (productName.equalsIgnoreCase("Book")) {
            for (InventoryItem item : bookList) {
                System.out.println(inventoryItemList.toString());
                System.out.println("Enter the author name: ");
                String authorName = scanner.nextLine().trim();
                System.out.println("Enter the book name: ");
                String bookName = scanner.nextLine().trim();
                Book theBook = (Book) item;
                System.out.println("HI");
                if (true) {
                    // first get the book details
                    System.out.println("Hi2");
                    theBook.getBookDetails(bookName, authorName);
                    // update the price of the product
                    System.out.println("Enter the price you want to change: ");
                    double price = Double.parseDouble(scanner.nextLine().trim());
                    theBook.updatePrice(price);
                    System.out.println("Now the price of this product is: " + theBook.getPrice());
                }
            }
        } else if (productName.equalsIgnoreCase("Clothes")) {
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
                System.out.print("Enter the book isbn number: ");
                int isbn = scanner.nextInt();
                if(theBook.getIsbn() == isbn) {
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
