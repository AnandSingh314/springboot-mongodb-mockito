/**
 * 
 */
package com.practice.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.domain.Author;
import com.practice.domain.Post;
import com.practice.service.AuthorService;
import com.practice.service.PostService;

/**
 * @author Anand
 *
 */
@RestController
public class HomeController {

	private PostService postService;
	private AuthorService authorService;

	/**
	 * @param postService
	 */
	@Autowired
	public HomeController(PostService postService, AuthorService authorService) {
		this.postService = postService;
		this.authorService = authorService;
	}

	@RequestMapping("/latestPost")
	@ResponseBody
	public Post latestPost() {
		return this.postService.getLatestPost();
	}

	@RequestMapping("/posts")
	@ResponseBody
	public List<Post> allPosts() {
		return this.postService.list();
	}

	@RequestMapping("/posts/byAuthor/{firstName}")
	public List<Post> postBy(@PathVariable("firstName") String firstName) {
		return this.postService.byAuthor(firstName);
	}

	@RequestMapping("/authors")
	public List<Author> authors() {
		return this.authorService.findAll();
	}

	@RequestMapping("/willItError")
	public String excptionStatus() throws Exception{
		if(new Random().nextBoolean()) throw new Exception("runtime error");
		return "{\"status\":\"error\", \"desc\":\"runtime error occured\"}";
	}

}
