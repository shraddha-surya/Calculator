package com.WebServiceProduceCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebServiceProduceCrud.model.Books;
import com.WebServiceProduceCrud.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	BooksRepository br;
	
	public void saveOrUpdate(Books books) {
		br.save(books);
	}

	public List<Books> getAllBooks() {
		return (List<Books>) br.findAll();
	}

	public List<Books> loginCheck(int bookid,String bookname) {

		if ((bookid == 5555) && bookname.equalsIgnoreCase("admin")) {
			return getAllBooks();
		} else {
			List<Books> list = (List<Books>) br.findByBookidAndBookname(bookid,bookname);
			return list;
		}

	}

	public Books getBooksById(int bookid) {
		return br.findById(bookid).get();
	}

	public void delete(int bookid) {
		br.deleteById(bookid);
		
	}

	public Books editBooksById(int bookid) {
		Books books = br.findByBookid(bookid);
		return books;
	}

	

}
