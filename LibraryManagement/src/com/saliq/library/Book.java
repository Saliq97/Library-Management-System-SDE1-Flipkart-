package com.saliq.library;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Book {
	private String name;
	private String author;
	HashMap<String, String> uniqueId = new HashMap<String, String>();
	static int count = 1234;
	private static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public HashMap<String, String> client = new HashMap<String, String>();
	private Queue<String> clientRequest = new PriorityQueue<String>();
	private HashMap<String, String> requests = new HashMap<String, String>();

	public void addBook(String name, String author, String type) {
		if (type.equals("Admin")) {

			// If book is already present
			if (map.containsKey(name)) {
				int fre = map.get(name);
				map.put(name, ++fre);
				System.out.println("----------------------------------\n" + name + " book Added");

				notifyAvailableBook();
			} else {
				// Add the new Book
				this.name = name;
				this.author = author;
				String uniq = author.substring(0, 3) + String.valueOf(count);
				count++;
				uniqueId.put(name, uniq);
				map.put(name, 1);
				System.out.println("--------------------------------------\n" + name + " book Added");
			}
		} else
			System.out.println("Customer can't add the books");
	}

	public Book() {
		// for client
	}

	// For borrow
	public void BorrowedBook(String clientName, String name, String author) {
		int fre = map.get(name);
		if (fre > 0) {
			if (client.containsKey(clientName)) {
				System.out.print("\n------------------------\n" + clientName + " Can't Borrow another book");
				return;
			} else {
				map.put(name, --fre);
				client.put(clientName, name);
				System.out.println("\n-------------------------------------------- \n Book " + name + " is issued by "
						+ clientName + "\n--------------------------------------------");
			}
		} else {
			System.out.println(name + " Book is not Available but request is added for " + clientName + "\n");
			clientRequest.add(clientName);
			requests.put(clientName, name);
		}

	}

	public void returned(String cust, String bookname, String author) {
		int fre = map.get(bookname);
		map.put(bookname, ++fre);
		System.out.println("\n-------------------------------------------- \n Book " + bookname + " is returned by "
				+ cust + "\n--------------------------------------------");
	}

	public void notifyAvailableBook() {
		// if(map.containsKey(author).containsKey()) {

	}

	public void showAvailableBooks() {
		System.out.println("\n------------------------------ \n Available Books are below :-\n --------------------------------");
		for (Entry<String, Integer> entry : map.entrySet())
			System.out.println("Book = " + entry.getKey() + ", Quantity = " + entry.getValue());
		System.out.println("Id  : " + uniqueId);
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

}
