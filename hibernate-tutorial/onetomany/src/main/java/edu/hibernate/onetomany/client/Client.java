package edu.hibernate.onetomany.client;

import org.springframework.beans.factory.annotation.Autowired;

import edu.hibernate.onetomany.model.User;
import edu.hibernate.onetomany.service.UserService;
import edu.hibernate.onetomany.service.impl.UserServiceImpl;

public class Client {

	@Autowired
	UserService userService = new UserServiceImpl();
	public static void main(String[] args) {
		Client inst = new Client();
		//Create 50 users
		for(int i = 0 ; i < 50 ; i++) {
			User user = new User();
			user.setUsername("user "+i);
			user.setPassword("password"+i);
			inst.userService.createUser(user);
		}
	}
}
