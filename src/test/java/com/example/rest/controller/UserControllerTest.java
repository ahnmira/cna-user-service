package com.example.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.rest.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRegister() throws Exception {
		User sample = User.sample();
		String content = objectMapper.writeValueAsString(sample);
		mockMvc.perform(post("/users")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.content().string(sample.getId()))
		        .andDo(print());
	}

	@Test
	void testFind() {
	}

	@Test
	void testFindAll() {
	}

	@Test
	void testModify() {
	}

	@Test
	void testDelete() {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
