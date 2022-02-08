package com.example.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.User;
import com.example.rest.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping("/users")
	public String register(@RequestBody User newUser) {
		return userService.register(newUser);
	}
	
	@GetMapping("/users/{id}")
	public User find(@PathVariable String id) {
		return userService.find(id);
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}	

	@PutMapping("/users")
	public void modify(@RequestBody User newUser) {
		userService.modify(newUser);
	}	
	
	@DeleteMapping("/users/{id}")
	public void modify(@PathVariable String id) {
		userService.remove(id);
	}	
}
