package com.esteban.questionaryservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.questionaryservice.entity.User;
import com.esteban.questionaryservice.repository.UserRepository;
import com.esteban.questionaryservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();

		return users;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(int id) {
		return userRepository.findById(id).orElse(null);
	}
}
