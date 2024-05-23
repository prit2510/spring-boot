package com.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.book;
import com.rest.services.bookservice;

@RestController
public class bookcontroller {
    bookservice bookService=new bookservice(); 
	
	@GetMapping("/book")
	public List<book> bookbay() {
//		book book=new book();
//		book.setId(12);
//		book.setTitle("the secrate");
//		book.setAuthor("prit");
		return this.bookService.getAllBooks();
	}
	
	@GetMapping("/book/{bookId}")
	public book getbook(@PathVariable("bookId") int id) {
		return bookService.getBookById(id);
		
	}
	
	@PostMapping("/book")
	public book addbook(@RequestBody book book)
	{
		this.bookService.addbook(book);
		return book;
	}
	
	@DeleteMapping("/book/{bookid}")
	public void deletebook(@PathVariable("bookid") int id){
		this.bookService.deleteBook(id);
	}
	
	@PutMapping("/book/{bookid}")
	public book updatebook(@RequestBody book book,@PathVariable("bookid") int id) {
		this.bookService.updateBook(book, id);
		return book;
	}
}
