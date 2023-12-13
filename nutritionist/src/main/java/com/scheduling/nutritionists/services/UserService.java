package com.scheduling.nutritionists.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduling.nutritionist.models.User;
import com.scheduling.nutritionist.repositories.UserRepository;
import com.scheduling.nutritionists.exceptions.UserAlreadyExistsException;
import com.scheduling.nutritionists.exceptions.UserNotFoundException;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		if (userAlreadyExists(user.getEmail())) {
			throw new UserAlreadyExistsException(user.getEmail() + " already exists!");
		}

		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {

		return userRepository.findById(id).map(us -> {
			us.setFirstName(user.getFirstName());
			us.setLastName(user.getLastName());
			us.setEmail(user.getEmail());
			us.setDepartment(user.getDepartment());
			return userRepository.save(us);
		}).orElseThrow(() -> new UserNotFoundException("Sorry, this user could not be found"));
	}

	@Override
	public User getUserById(Long id) {

		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Sorry, no user found with the ID:" + id));
	}

	@Override
	public void deleteUser(Long id) {
	    if (!userRepository.existsById(id)) {
	        throw new UserNotFoundException("Sorry, user not found");
	    }

	    userRepository.deleteById(id);
	}
	
	private boolean userAlreadyExists(String email) {
		return userRepository.findByEmail(email).isPresent();
	}
}
