package com.project.system;import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryWareHouse{
    private int numberOfProduct=0;
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
        addBooksToWareHouse(theBook);
        addProductsToWareHouse(theBook);

    }
    public List<InventoryItem> getBookList(){
        return this.bookList;
    }
    public int calculateTotalNumberOfBooks(){
        return 0;
    }
    public void updateNumberOfBooks(){

    }
    public int calculateTotalNumberOfProduct() {
        return 0;

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

    public void addBookToWareHouse(){

    }

    public static void removeBookFromWareHouse(InventoryItem theInventory){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the isbn number you want to delete: ");
        int isbnNumber = scan.nextInt();

        theInventory.removeProduct(isbnNumber);
        System.out.println("Successfully deleted");

    }

    public static void purchaseTheProduct(){



    }
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
                
            }
        }

    }
}
