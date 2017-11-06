/**
 * 
 */
package com.practice.domain;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Anand
 *
 */
@Document
public class Post {

	@Id
	private BigInteger id;
	private String title;
	private String body;
	private Date postedOn;

	@JsonManagedReference
	private Author author;	

	public Post() {
	}

	/**
	 * @param title
	 * @param body
	 */
	public Post(String title, String body) {
		this.title = title;
		this.body = body;
	}



	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}



	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}



	/**
	 * @return the postedOn
	 */
	public Date getPostedOn() {
		return postedOn;
	}



	/**
	 * @param postedOn the postedOn to set
	 */
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}



	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}



	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Post: [id="+this.id+", title="+this.title+", body="+this.body+"]";
	}
}
