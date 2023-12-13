package com.scheduling.nutritionists.exceptions;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
