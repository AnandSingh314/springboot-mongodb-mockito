/**
 * 
 */
package com.practice.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.domain.Author;
import com.practice.domain.Post;
import com.practice.repository.AuthorRepository;
import com.practice.repository.PostRepository;

/**
 * @author Anand
 *
 */
@Service
public class DataLoader {

	private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	private PostRepository postRepository;
	private AuthorRepository authorRepository;
	
	/**
	 * @param postRepository
	 * @param authorRepository
	 */
	@Autowired
	public DataLoader(PostRepository postRepository, AuthorRepository authorRepository) {
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}
	
	@PostConstruct
	private void loadData(){
		logger.info("loaging data to the database.");
		
		authorRepository.deleteAll();
		postRepository.deleteAll();
		
		Author author = new Author("Anand", "Vijay");
		authorRepository.save(author);
		Post post = new Post("Spring Boot is awesome", "Blog post body content....!!");
		post.setPostedOn(new Date());
		post.setAuthor(author);
		postRepository.save(post);
		
		author = new Author("Dan", "Vijay");
		authorRepository.save(author);
		post = new Post("Docker is cool", "Docker and docker composse is cool container technology....!!");
		post.setPostedOn(new Date());
		post.setAuthor(author);
		postRepository.save(post);
		
		
		author = new Author("Anand", "deo");
		authorRepository.save(author);
		post = new Post("Mongo DB rocks", "the best no sql database is mongodb....!!");
		post.setPostedOn(new Date());
		post.setAuthor(author);
		postRepository.save(post);
		
		
		

		
	}
	
	
}
