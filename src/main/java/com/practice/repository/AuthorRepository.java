package com.practice.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.domain.Author;

/**
 * @author Anand
 *
 */
public interface AuthorRepository extends CrudRepository<Author, BigInteger>{
	
	public List<Author> findAllByOrderByFirstNameDesc();

}
