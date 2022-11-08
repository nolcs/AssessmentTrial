package com.esteban.assestmentprojectquestionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.assestmentprojectquestionary.entity.User;
import com.esteban.assestmentprojectquestionary.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3001")
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
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User newUser = userServiceImpl.createUser(user);

		return ResponseEntity.ok(newUser);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> findUser(@PathVariable("userId") int userId) {

		User user = userServiceImpl.getUser(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);

	}

	/*
	 * @GetMapping("/userid/{email}") public ResponseEntity<Integer> getUserId
	 * (@PathVariable("email") String email ){
	 * 
	 * int id = userServiceImpl.getUserId(email); return ResponseEntity.ok(id);
	 * 
	 * }
	 */

}