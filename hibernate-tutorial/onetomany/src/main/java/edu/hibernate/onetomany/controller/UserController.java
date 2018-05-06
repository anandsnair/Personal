package edu.hibernate.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hibernate.onetomany.model.User;
import edu.hibernate.onetomany.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable String userId) {
		User user = userService.getUserById(userId);
		return user;
	}
}
