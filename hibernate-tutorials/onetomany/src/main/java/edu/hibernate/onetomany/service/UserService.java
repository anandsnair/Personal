package edu.hibernate.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hibernate.onetomany.model.User;
import edu.hibernate.onetomany.repository.UserRepository;

public interface UserService {
	
	public User createUser(User user);
	public User getUserById(String userId);
	
}
