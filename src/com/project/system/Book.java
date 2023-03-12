package com.project.system;
import java.security.SecureRandom;
import java.util.*;
public class Book extends InventoryItem<Book> implements Product{
    private String author;
    private String publisher;
    private int isbn;
    private InventoryWareHouse inventoryWareHouse;
    public Book(String name, double price, int quantity,int specId, String author, String publisher
            ,int isbn, InventoryWareHouse inventoryWareHouse){
        super(name,price,quantity, specId);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.inventoryWareHouse = inventoryWareHouse;
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
      this.inventoryWareHouse.removeBook(isbn);
    }
    public String getBookDetails(String bookName, String authorName) {
        List<InventoryItem> listOfBooks = inventoryWareHouse.getBookList();
        for(InventoryItem theBook: listOfBooks){
            if(theBook instanceof  Book){
                Book theBook2 = (Book) theBook;
                if(theBook2.getName().equals(bookName) && theBook2.getAuthor().equals(authorName)){
                    System.out.println("Found the details");
                    System.out.println("--------------------------------");
                    return "Book{" + "Name: " + this.getName() + "\n" +
                            "price: " + this.getPrice() + "\n" +
                            "author='" + this.author + "\n" +
                            ", publisher='" + publisher + '\'' +
                            ", isbn='" + isbn + '\'' +
                            '}';
                }
            }
        }
        return "found nothing";
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
