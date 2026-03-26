package com.global.book.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Book;
import com.global.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.findById(id));
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(bookService.findAll());
	}

	@PostMapping("/add")
	public ResponseEntity<Book> insert(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.insert(book));
	}

	@PutMapping("/update")
	public ResponseEntity<Book> update(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.update(book));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(Long id) {
		try {
			bookService.delete(id);
			return ResponseEntity.noContent().build();
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("book not found");
		}
		
		
	}
}
