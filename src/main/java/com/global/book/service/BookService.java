package com.global.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.book.entity.Book;
import com.global.book.repository.BookRepo;

@Service
public class BookService {
	BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	public Book findById(Long id) {
		return bookRepo.findById(id).orElseThrow();
	}

	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	public Book insert(Book book) {
		if (book.getId() != null)
			throw new RuntimeException("book already exsit");

		return bookRepo.save(book);
	}

	public Book update(Book book) {
		// check id in db
		if (book.getId() != null)
			throw new IllegalArgumentException("ID must not be null for update");

		Book existed = findById(book.getId());
		existed.setAuther(book.getAuther());
		existed.setPrice(book.getPrice());
		return bookRepo.save(existed);
	}

	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
