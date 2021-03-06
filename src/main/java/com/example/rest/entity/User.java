package com.example.rest.entity;

import java.util.UUID;

import com.example.rest.dto.ResponseInfo;
import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "users")
public class User {
	private String id;
	private String name;
	private String email;
	private ResponseInfo teamInfo;
	
	public User() {
		this.id=UUID.randomUUID().toString();
	}
	
	public User(String name, String email) {
		this();
		this.name = name;
		this.email = email;
	}
	
	public static User sample() {
		return new User("kim", "kim@aaa.com");
	}
	public static void main(String[] args) {
		User user = new User();
		System.out.println(new Gson().toJson(user));
	}
}
