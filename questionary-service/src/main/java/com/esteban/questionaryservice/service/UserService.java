package com.esteban.questionaryservice.service;

import java.util.List;

import com.esteban.questionaryservice.entity.User;

public interface UserService {

	List<User> getAllUsers();

	User createUser(User user);

	User getUser(int id);

}
