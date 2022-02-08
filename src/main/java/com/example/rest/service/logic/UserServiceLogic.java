package com.example.rest.service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.entity.User;
import com.example.rest.store.UserStore;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceLogic implements com.example.rest.service.UserService {

	private final UserStore userStore;
	
	@Override
	public String register(User newUser) {
		return this.userStore.create(newUser);
	}

	@Override
	public void modify(User newUser) {
		this.userStore.update(newUser);

	}

	@Override
	public void remove(String id) {
		this.userStore.delete(id);

	}

	@Override
	public User find(String id) {
//        User userOptional = userRepository.findById(id)
//                .orElseThrow(RuntimeException::new);
//
//        // Rest Template or Feign Client 작업 처리
//
//        return UserResponseData.builder()
//                .userId(userOptional.getId())
//                .username(userOptional.getUsername())
//                .team(null)
//                .build();
		
		return this.userStore.retrieve(id);
	}

	@Override
	public List<User> findAll() {
		return this.userStore.retrieveAll();
	}

}
