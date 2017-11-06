/**
 * 
 */
package com.practice.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.domain.Post;

/**
 * @author Anand
 *
 */
public interface PostRepository extends CrudRepository<Post, BigInteger> {

	// find the lates post
	Post findFirstByOrderByPostedOnDesc();

	List<Post> findAllByOrderByPostedOnDesc();
	
	List<Post> findAllByAuthorFirstName(String firstName);
	List<Post> findAllByAuthorFirstNameIgnoreCase(String firstName);
	
}
