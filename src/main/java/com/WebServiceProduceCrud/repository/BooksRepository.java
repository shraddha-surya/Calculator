package com.WebServiceProduceCrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WebServiceProduceCrud.model.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer> {

	Iterable<Books> findByBookidAndBookname(int bookid,String bookname);

	public Books findByBookid(int bookid);
	
}
