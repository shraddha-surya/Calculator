package com.WebServiceProduceCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WebServiceProduceCrud.model.Books;
import com.WebServiceProduceCrud.service.BooksService;

@RestController
public class HomeController {
	@Autowired
	BooksService bs; 

	@PostMapping("/books")
	private String saveBook(@RequestBody Books books) {
		bs.saveOrUpdate(books);
		return "Record inserted successfully";
	}
	
	@GetMapping("/getAllBooks")
	private List<Books> getBooks()
	{
		return bs.getAllBooks();
	}

	@GetMapping("/login/{bookid}/{bookname}")
	public List<Books> login(@PathVariable("bookid") int bookid, @PathVariable("bookname") String bookname) {

		return bs.loginCheck(bookid, bookname);
		
	}
	
	@RequestMapping(value="/edit/{bookid}", method= RequestMethod.PUT)
	private Books editBooks(@PathVariable("bookid") int bookid) {
		return bs.editBooksById(bookid);
	}

	
	@GetMapping("/book/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return bs.getBooksById(bookid);
	}

	@PutMapping("/books/")
	private String update(@RequestBody Books books) {
		
		bs.saveOrUpdate(books);
		
		return "Record updated succesffully";
	}

	@DeleteMapping("/book/{bookid}")
	private String deleteBook(@PathVariable("bookid") int bookid) {
		bs.delete(bookid);
		return "Record deleted successfully";
	}

	
}
