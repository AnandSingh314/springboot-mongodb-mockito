package com.practice.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.practice.repository.AuthorRepository;
import com.practice.repository.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;
		
	@Before
	public void setup() throws Exception {

	}

	@Test
	public void authors() throws Exception {
		this.mockMvc.perform(get("/authors")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void unknowRequest() throws Exception{
		this.mockMvc.perform(get("/random"))
					.andDo(print())
					.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void willItError() throws Exception{
		this.mockMvc.perform(get("/willItError"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().json("{\"status\":\"error\", \"desc\":\"runtime error occured\"}"));
	}
	
	

}
