package com.global.book.controller;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Auther;
import com.global.book.repository.AutherRepo;
import com.global.book.service.AutherService;

@RestController
@RequestMapping("/auther")
public class AutherController {
	AutherService autherService;

	public AutherController(AutherService autherService) {
		super();
		this.autherService = autherService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Auther> findById(@PathVariable Long id) {
		return ResponseEntity.ok(autherService.findById(id));
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(autherService.findAll());
	}

	@PostMapping("/insert")
	public ResponseEntity<Auther> insert(@RequestBody Auther auther) {
		if (auther.getId() != null) {
			throw new RuntimeException("Author already has ID");
		}
		return ResponseEntity.ok(autherService.insert(auther));
	}

	@PutMapping("/update")
	public ResponseEntity<Auther> update(@RequestBody Auther auther) {

		return ResponseEntity.ok(autherService.update(auther));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			autherService.delete(id); // deleteById() in service
			return ResponseEntity.noContent().build(); // 204 No Content
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
		}
	}

}
