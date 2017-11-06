/**
 * 
 */
package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.domain.Author;
import com.practice.repository.AuthorRepository;

/**
 * @author Anand
 *
 */
@Service
public class AuthorService {

	private AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public List<Author> findAll() {
		return this.authorRepository.findAllByOrderByFirstNameDesc();
	}

}
