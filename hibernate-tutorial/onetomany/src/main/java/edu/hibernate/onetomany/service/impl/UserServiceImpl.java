package edu.hibernate.onetomany.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hibernate.onetomany.model.User;
import edu.hibernate.onetomany.repository.UserRepository;
import edu.hibernate.onetomany.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(String userId) {
		Optional<User> user = userRepo.findById(userId);
		return user.get();
	}
	
}
