package com.bookStore;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	public List<Book>getAllBooks(){
		return new ArrayList<>();
		
	}
	public boolean addBook(Book book) {
		return true;
	}
	
	 public boolean deleteBookById(int id) {
	        
	        return true;
	    }

	   
	    public final String getDatabaseInfo() {
	        return "Connected to DB";
	    }
	    
	    public void logAction(String action) {
	        
	    }


}
