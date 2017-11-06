/**
 * 
 */
package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.domain.Post;
import com.practice.repository.PostRepository;

/**
 * @author Anand
 *
 */
@Service
public class PostService {

	private PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post getLatestPost(){
		return this.postRepository.findFirstByOrderByPostedOnDesc();
	}
	
	public List<Post> list(){
		return this.postRepository.findAllByOrderByPostedOnDesc();
	}
	
	public List<Post> byAuthor(String firstName){
		return this.postRepository.findAllByAuthorFirstNameIgnoreCase(firstName);
	}

}
