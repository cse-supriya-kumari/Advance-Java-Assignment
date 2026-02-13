package com.libraryBook.libraryBook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_books")
public class Book {
	@Id
	@Column(name = "book_id")
	private int bookId ;
	@Column(nullable = false)
	private String title ;
	@Column(name = "author_name", nullable = false )
	private String authorName ;
	private String genre; 
	private double price; 
	private String availability_status ;
	private int publishedYear;
	
	
	public Book() {
		super();
	}


	public Book(int book_id, String title, String author_name, String genre, double price, String availability_status,
			int publishedYear) {
		super();
		this.bookId = book_id;
		this.title = title;
		this.authorName = author_name;
		this.genre = genre;
		this.price = price;
		this.availability_status = availability_status;
		this.publishedYear = publishedYear;
	}


	/**
	 * @return the book_id
	 */
	public int getBookId() {
		return bookId;
	}


	/**
	 * @param book_id the book_id to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the author_name
	 */
	public String getAuthorName() {
		return authorName;
	}


	/**
	 * @param author_name the author_name to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}


	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * @return the availability_status
	 */
	public String getAvailability_status() {
		return availability_status;
	}


	/**
	 * @param availability_status the availability_status to set
	 */
	public void setAvailability_status(String availability_status) {
		this.availability_status = availability_status;
	}


	/**
	 * @return the publishedYear
	 */
	public int getPublishedYear() {
		return publishedYear;
	}


	/**
	 * @param publishedYear the publishedYear to set
	 */
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}


	@Override
	public String toString() {
		return "Book [book_id=" + bookId + ", title=" + title + ", author_name=" + authorName + ", genre=" + genre
				+ ", price=" + price + ", availability_status=" + availability_status + ", publishedYear="
				+ publishedYear + "]";
	}
	
	
	

}
