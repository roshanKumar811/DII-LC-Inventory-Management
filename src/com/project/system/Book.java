package com.project.system;
import java.security.SecureRandom;
import java.util.*;
public class Book extends InventoryItem<Book> implements Product{
    private String author;
    private String publisher;
    private int isbn;

    private InventoryWareHouse inventoryWareHouse = new InventoryWareHouse();
    public Book(String name, double price, int quantity,int specId, String author, String publisher, int isbn){
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
    public int getIsbn(){
        return isbn;
    }
    @Override
    public void removeProduct(int isbn) {
        List<InventoryItem> listOfBooks = inventoryWareHouse.getBookList();
        ListIterator<InventoryItem> iterator = (ListIterator<InventoryItem>) listOfBooks.listIterator();
        /*for(InventoryItem theBooks: listOfBooks){
            if(theBooks.getSpecId() == isbn){
                //delete that product from the list
                //how to remove the specific the book from data structure.
            }
        }*/
        while(iterator.hasNext()){
            InventoryItem book = iterator.next();
            if(book instanceof Book){
                Book theBook = (Book)book;
                if(theBook.getIsbn() == isbn){
                    System.out.println("After deleting: " + inventoryWareHouse.getBookList().toString());
                    iterator.remove();
                    System.out.println("it reaches here");
                    break;
                }else {
                    System.out.println("Sorry couldn't find the isbn number: ");
                }
            }
        }

        System.out.println("After deleting: " + inventoryWareHouse.getBookList().toString());

    }
    @Override
    public String getDetails(){
        return null;
    }
    public String getBookDetails(String bookName, String authorName) {
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
        if(checkIfISBNExist(theBook.getIsbn())) {

            inventoryWareHouse.addBooksToWareHouse(theBook);
            System.out.println("it touched in this line");
        }else{
            System.out.println("Sorry there is already a duplicate value, your id and isbn should be unique");
        }
    }
   /* public String generateISBN() throws Exception {
        String isbn = "";
        Random random = new Random();
        int length = 10;
        do{
            for(int i = 0; i<length; i++){
                isbn = "ISBN" + ((Integer)random.nextInt(length)).toString();
            }
        }while(checkIfISBNExist(isbn));
        return isbn;
    }*/
    /**
     * this method checks whether the isbn already exist in the booksItems list
     * @param isbn
     * @return
     */
    public boolean checkIfISBNExist(int isbn) {
        boolean found = true;
        List<InventoryItem> listOfBooks = inventoryWareHouse.getListOfClothes();
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
    public void addBooks2(Book theBook){
        System.out.println("Adding book " + getName() + " to specific shelf");
        //if the specId and isbn number doesn't match then there is no duplicate there so accept it.
        if(checkIfISBNExist(theBook.getIsbn())){
            inventoryWareHouse.addBooksToWareHouse(theBook);
            inventoryWareHouse.addProductsToWareHouse(theBook);
        }else{
            System.out.println("Sorry there is already a duplicate value, your id and isbn should be unique");
        }
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
   /* @Override
    public void updatePrice(){
        return 0;
    }*/
    @Override
    public int updateQuantity(int newQuantity) {
        return 0;
    }
    @Override
    public int getSpecId() {
        return 121223;
    }



    public String searchByAuthorName(String name){
        List<InventoryItem> listOfBooks = inventoryWareHouse.getListOfClothes();
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

    public String toString() {
        return "Book{" + "Name: " + this.getName() + "\n" +
                "price: " + this.getPrice() + "\n" +
                "author='" + this.author + "\n" +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
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
