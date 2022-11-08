package com.esteban.assestmentprojectquestionary.service;

import java.util.List;

import com.esteban.assestmentprojectquestionary.entity.User;

public interface UserService {

	List<User> getAllUsers();

	User createUser(User user);

	User getUser(int id);

	User getUserByEmail(String email);
}
