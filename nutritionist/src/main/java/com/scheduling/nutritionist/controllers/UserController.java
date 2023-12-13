package com.scheduling.nutritionist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduling.nutritionist.models.User;
import com.scheduling.nutritionists.services.IUserService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.updateUser(user, id);

	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
