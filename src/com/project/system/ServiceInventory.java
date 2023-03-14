package com.project.system;

public interface ServiceInventory {
    public String getBookDetails(String bookName, String authorName);
    //search book by it's isbn
    public String getBookDetails2(String bookName);
}
