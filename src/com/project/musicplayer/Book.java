package com.project.inventory;

import java.security.SecureRandom;
import java.util.*;

public class Book extends InventoryItem<Book> implements Product{
    private String author;
    private String publisher;
    private String isbn;

    private InventoryWareHouse inventoryWareHouse = new InventoryWareHouse();
    public Book(String name, double price, int quantity,int specId, String author, String publisher, String isbn){
        super(name,price,quantity, specId);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
 /*   public Book(String name, double price, int quantity, int specId, String author, String publisher, int isbn){
        super(name,price,quantity,specId);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }*/
    public String getAuthor(){
        return this.author;
    }
    public String getPublisher(){
        return publisher;
    }
    public String getIsbn(){
        return isbn;
    }
    @Override
    public void removeProduct(int specId) {
        List<InventoryItem> listOfBooks = inventoryWareHouse.getListOfClothes();

        for(InventoryItem theBooks: listOfBooks){
            if(theBooks.getSpecId() == specId){
                //delete that product from the list


            }
        }
    }
    @Override
    public String getDetails(){
        return null;
    }
    public String getBookDetails(String bookName, String authorName) throws Exception {
        List<InventoryItem> listOfBooks = inventoryWareHouse.getListOfClothes();
        for(InventoryItem theBook: listOfBooks){
            if(theBook instanceof  Book){
                Book theBook2 = (Book) theBook;
                if(theBook.getName().equals(bookName) && ((Book) theBook).getAuthor().equals(authorName)){
                    System.out.println("Found the details");
                    return "Book: " + getName() + "\nAuthor: " + "\nPublisher: " + publisher + "\nISBN: " + isbn;
                }
            }

        }
        return "found nothing";
    }
    @Override
    public void addProduct(Book theBook) {
        System.out.println("Adding books to the warehouse");
        //Only add the book to the warehouse if there is not any duplicate spec Id and the ISBN
        //if there is some duplicate specID and isbn immediately return false or print message
        if(theBook.detectDuplicateSpecId(theBook.getSpecId()) && checkIfISBNExist(theBook.getIsbn())){
            inventoryWareHouse.addClothesToWareHouse(theBook);
        }
        System.out.println("Sorry there is already a duplicate value, your id and isbn should be unique");
    }
    public String generateISBN() throws Exception {
        String isbn = "";
        Random random = new Random();
        int length = 10;
        do{
            for(int i = 0; i<length; i++){
                isbn = "ISBN" + ((Integer)random.nextInt(length)).toString();
            }
        }while(checkIfISBNExist(isbn));

        return isbn;
    }
    /**
     * this method checks whether the isbn already exist in the booksItems list
     * @param isbn
     * @return
     */
    public boolean checkIfISBNExist(String isbn) {
        boolean found = false;
        List<InventoryItem> listOfBooks = inventoryWareHouse.getListOfClothes();
        for (InventoryItem theBooks : listOfBooks) {

            if (theBooks instanceof Book) {
                Book theBook = (Book) theBooks;
                if (theBook.getIsbn().equals(isbn)) {
                    found = true;
                }
            }

        }
        return found;
    }
    public void testing(Object o){
        if(o instanceof Electronics){
            System.out.println("yes it is!");
        }else{
            System.out.println("it is not");
        }
    }
    public void addBooks2(Book theBook){
        System.out.println("Adding book " + getName() + " to specific shelf");
        inventoryWareHouse.addBooksToWareHouse(theBook);
        System.out.println("Adding books in the Book Class dsa");

    }

   /* public void addBooks2(Book theBook){
        booksItems.add(theBook);
    }*/
    @Override
    public String getDescription() {
        return null;
    }
    @Override
    public String getCategory() {
        return null;
    }
    @Override
    public int updatePrice(int thePrice){
        return 0;
    }
    @Override
    public int updateQuantity(int newQuantity) {
        return 0;
    }
    @Override
    public int getSpecId() {
        return 0;
    }
    public String searchByAuthorName(String name){
       /* for(Book theBooks: this.booksItems){
            if(name.equals(theBooks.getName())){
                System.out.println("Founded");
                return "The Author name is: " + theBooks.getAuthor();
            }
        }
        return "Didn't found the author name";*/
        return null;
    }
    public String searchByPublisher(String name){
        return null;
    }
    public String toString() {
        return "Book{" + "Name: " + this.getName() + "\n" +
                "price: " + this.getPrice() + "\n" +
                "author='" + this.author + "\n" +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +

                ", inventoryWareHouse=" + inventoryWareHouse.toString()+
                '}';
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
