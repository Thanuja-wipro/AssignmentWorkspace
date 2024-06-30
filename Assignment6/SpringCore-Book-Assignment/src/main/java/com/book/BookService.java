package com.book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
	List<Book> bookList = new ArrayList<>();
	
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public Book getBookByTitle(String title) {
		for (Book book : bookList) {
			if(book.getTitle() == title) {
				return book;
			}
		}
		return null;
	}
	
	public List<Book> getAllBooks(){
		return new ArrayList<>(bookList);
	}
}
