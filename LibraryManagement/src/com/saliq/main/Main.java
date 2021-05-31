package com.saliq.main;

import java.util.HashMap;

import com.saliq.library.Book;
import com.saliq.library.Person;

public class Main {

	public static void main(String[] args) {
		Book book = new Book();
		Person admin = new Person("Navin","Admin123","Admin");
		Person client1 = new Person("Anuj","Anuj123","Customer");
		Person client2 = new Person("Rakesh","Anuj123","Customer");
		
		
		
		if(admin.getType().equals("Admin")) {
			book.addBook("Flipkart", "Saliq","Admin");
			book.addBook("Flipkart", "Saliq","Admin");
			book.addBook("Amazon","Shadab","Admin");
			book.addBook("SnapDeal", "Sohail","Admin");
			book.addBook("Myntra", "Sanjeev","Admin");
		}
		
		
		book.showAvailableBooks();
		client1.borrow("Anuj","Flipkart","Saliq");	
		
		client2.borrow("Rakesh","Amazon","Shadab");
		
		System.out.println("\n------------------------ \n Available Books are below :-\n");
		book.showAvailableBooks();
		
		client1.returnedBook("Anuj","Flipkart","Shadab");
		client2.borrow("Rakesh","Amazon","Shadab");
		
		
		book.showAvailableBooks();
	
	}

}
