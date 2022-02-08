package com.example.rest.service.logic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rest.entity.User;
import com.example.rest.service.UserService;

@SpringBootTest
class UserServiceLogicTest {

	@Autowired
	private UserService userService;
	
	private User kim;
	private User lee;
	
	@BeforeEach
	void setUp() throws Exception {
		this.kim = new User("kim", "kim@aaa.com");
		this.lee = new User("lee", "lee@aaa.com");
		this.userService.register(kim);
		this.userService.register(lee);
	}


	@Test
	void register() {
		User sample = User.sample();
		assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
		assertThat(this.userService.findAll().size()).isEqualTo(3);
		this.userService.remove(sample.getId());
	}

	@Test
	void find() {
		assertThat(this.userService.find(lee.getId())).isNotNull();
		assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());
	}

	@AfterEach
	void cleanUp() throws Exception {
		this.userService.remove(kim.getId());
		this.userService.remove(lee.getId());

	}	

}
