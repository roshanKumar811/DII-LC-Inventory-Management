package com.project.system;
import java.security.SecureRandom;
import java.util.*;
public class Book extends InventoryItem<Book> implements Product{
    private String author;
    private String publisher;
    private int isbn;
    private InventoryWareHouse inventoryWareHouse;
    private ServiceInventory inventoryService;
    //injecting the dependencies
    public Book(String name, double price, int quantity,int specId, String author, String publisher
            ,int isbn, ServiceInventory inventoryService){
        super(name,price,quantity, specId);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.inventoryService = inventoryService;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getPublisher(){
        return publisher;
    }
    public int getIsbn(){
        return isbn;
    }
    @Override
    public void removeProduct(int isbn) {
        System.out.println("removing the book class-->using dependency injection");
      this.inventoryService.removeBook(isbn);
    }
    //calling this method through help of dependencies
    public void getBookDetails(String bookName, String authorName) {
        inventoryService.getBookDetails(bookName,authorName);
    }
    @Override
    public void addProduct(Book theBook) {
        System.out.println("Adding books to the warehouse");
        inventoryWareHouse.addBookProduct(theBook);
    }
    /*public void addBooks2(Book theBook){
        System.out.println("Adding book " + getName() + " to specific shelf");
        //if the specId and isbn number doesn't match then there is no duplicate there so accept it.
        if(checkIfISBNExist(theBook.getIsbn())){
            inventoryWareHouse.addBooksToWareHouse(theBook);
            inventoryWareHouse.addProductsToWareHouse(theBook);
        }else{
            System.out.println("Sorry there is already a duplicate value, your id and isbn should be unique");
        }
        System.out.println("Adding books in the Book Class dsa");
    }*/
    @Override
    public int updateQuantity(int newQuantity) {
        return 0;
    }
   public void searchBookByAuthorName(String name){
        this.inventoryWareHouse.searchByAuthorName(name);
   }
    public String toString() {
        return "Book{" + "Name: " + this.getName() + "\n" +
                "price: " + this.getPrice() + "\n" +
                "author='" + this.author + "\n" +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
    //get total number of books from the inventory warehouse
    public void getTotalNumberOfBooks(){
        this.inventoryWareHouse.calculateTotalNumberOfBooks();
    }
    public List<Book> getBooksItems(){
        return null;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void totalNumberOfBooks(){

    }
}
