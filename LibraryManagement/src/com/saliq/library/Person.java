package com.saliq.library;

import java.util.Date;

public class Person{
	String name;
	String pass;
	String type;
	Date issueDate ;
	Date returnedDate;
	public Person(String name, String pass,String type) {
		this.name = name;
		this.pass = pass;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}

	public void borrow(String name,String Bookname, String author) {
		Book book = new Book();
		book.BorrowedBook(name, Bookname, author);
		Date date = new Date();
		this.issueDate = date;
		}
	
	public void returnedBook(String name,String Bookname, String author) {
		Book book = new Book();
		book.returned(name, Bookname, author);
		Bill bill =  new Bill();
		Date date = new Date();
		this.returnedDate = date;
		//	bill.billing(issueDate , returnedDate,name);
		bill.billing(20, name);
	}
	
}
