package com.project.system;

public interface ServiceInventory {
    public String getBookDetails(String bookName, String authorName);
    public void remove(int isbn); 
}
