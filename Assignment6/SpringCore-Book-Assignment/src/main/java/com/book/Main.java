package com.book;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BookService bookService = (BookService) context.getBean("bookService");
		
		Book book1 = new Book("Bhagwat Geetha", "Veda Vyas", true);
		Book book2 = new Book("Wings of Fire", "Abdul Kalam", false);
		
		bookService.addBook(book1);
		bookService.addBook(book2);
		
		Book retrievedBook = bookService.getBookByTitle("Bhagwat Geetha");
		if (retrievedBook != null) {
            System.out.println("Retrieved Book: " + retrievedBook.getTitle() + " (" + retrievedBook.isIsbn() + ")");
        } else {
            System.out.println("Book not found");
        }
		
		List<Book> allBooks = bookService.getAllBooks();
		System.out.println("All Books:");
		for (Book book : allBooks) {
            System.out.println(book);
        }
		
	}
}
