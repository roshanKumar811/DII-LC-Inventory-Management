package com.project.inventory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryWareHouse{
    private static List<InventoryItem> inventoryItemList = new ArrayList<>();
    private List<InventoryItem> bookList = new ArrayList<>();
    private List<InventoryItem> clothesList = new ArrayList<>();
    public void addProductsToWareHouse(InventoryItem product) {
       this.inventoryItemList.add(product);
    }
    public void addBooksToWareHouse(InventoryItem product){
        this.bookList.add(product);
    }
    public void addClothesToWareHouse(InventoryItem product){
        this.clothesList.add(product);
    }
    public void createBookObject(Book theBooks, Scanner sc){
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
        String isbn = sc.next();

        Book theBook = new Book(name, price, quantity, specId,authorName,publisher,isbn);
        bookList.add(theBook);

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
        Book book1 = new Book("Book 1", 10.99, 5, 121, "author1", "Publisher 1", "ISBN 1");
        Book book2 = new Book("Java-Book", 10.99, 1, 123, "james gosling" ,"Roshan Shoti", "ISBN 1");
        book1.addProduct(book1);
        book1.addBooks2(book1);
//        warehouse.inventoryItemList.add(book1);
        book1.testing(book1);
        System.out.println(book1.getBooksItems());
//
////        System.out.println(inventoryItemList.toString());
//
//        System.out.println("Book list: " + book1.getBooksItems().toString());
//
////        System.out.println("Book list: " + warehouse.getBookList());
//
////        System.out.println("Getting the book list from the book class ");
////        book1.getBooksItems();
        System.out.println(book2.searchByPublisher("Roshan Shoti"));
        System.out.println("done");
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
}
