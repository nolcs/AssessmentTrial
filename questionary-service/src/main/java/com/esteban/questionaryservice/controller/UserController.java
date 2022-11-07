package com.esteban.questionaryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.questionaryservice.entity.User;
import com.esteban.questionaryservice.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/listUsers")
	public ResponseEntity<List<User>> listAllUsers() {

		List<User> users = userServiceImpl.getAllUsers();

		if (users.isEmpty()) {

			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User newUser = userServiceImpl.createUser(user);
		return ResponseEntity.ok(newUser);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> findUser(@PathVariable("userId") int userId){
		
		User user = userServiceImpl.getUser(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
		
	}

}
