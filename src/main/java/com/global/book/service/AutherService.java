package com.global.book.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.global.book.entity.Auther;
import com.global.book.repository.AutherRepo;

@Service
public class AutherService {

	AutherRepo autherRepo;

	public AutherService(AutherRepo autherRepo) {
		super();
		this.autherRepo = autherRepo;
	}

	// business Logic
	public Auther findById(Long id) {
		return autherRepo.findById(id).orElseThrow();
	}

	public List<Auther> findAll() {
		return autherRepo.findAll();
	}

	public Auther insert(Auther auther) {
		if (auther.getId() != null) {
			throw new RuntimeException("Author already has ID");
		}
		return autherRepo.save(auther);

	}

	public Auther update(Auther auther) {

		// ID MUST EXSIT NOT NULL
		if (auther.getId() == null)
			throw new IllegalArgumentException("Author ID must not be null for update");
		// CHECK IF EXISTS IN DB
		Auther existing = findById(auther.getId());
		existing.setName(auther.getName());
		return autherRepo.save(existing);
	}

	public void delete(Long id) {
		autherRepo.deleteById(id);
	}

}
