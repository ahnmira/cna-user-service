package com.example.rest.dto;

import com.example.rest.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseInfo {
	private User user;
	private String teamId;
	private String teamName;
}
