package com.scheduling.nutritionists.services;

import java.util.List;

import com.scheduling.nutritionist.models.User;

public interface IUserService {
	User addUser(User user);
	List<User> getUsers();
	User updateUser(User user, Long id);
	User getUserById(Long id);
	void deleteUser(Long id);
	
}
