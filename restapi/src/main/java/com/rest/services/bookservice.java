
package com.rest.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;

import com.rest.entity.book;

public class bookservice {
	private static List<book> list=new ArrayList<>();
	 static {
		 list.add(new book(12,"java book","prit"));
		 list.add(new book(89,"python book","yash"));
		 list.add(new book(1,"timepass book","jeet"));
	 }
	 
	 //get all books
	 public List<book> getAllBooks(){
		 return list;
	 }
	 
	 //get singel book by id
	 public book getBookById(int id) {
		 book book=null;
		 book =list.stream().filter(e->e.getId()==id).findFirst().get();
		 return book;
		 
	 }
	 
	 //Add the book
	 public book addbook(book b) {
		 list.add(b);
		 return b;
	 }
	 
	 //delete book
	 public void deleteBook(int bid){
		 list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
	 }
	 
	 //update the book details
	 public void updateBook(book book,int bid) {
		 list.stream().map(b->{
			 if(b.getId()==bid) {
				 b.setTitle(book.getTitle());
				 b.setAuthor(book.getAuthor());
			 }
			 return b;
		 }).collect(Collectors.toList());	
		 }

}
