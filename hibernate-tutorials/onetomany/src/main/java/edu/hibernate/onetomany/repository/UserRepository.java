package edu.hibernate.onetomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.hibernate.onetomany.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	public List<User> findByAgeLessThan(int age);
	
	@Query("select u from User u where u.username = ?1")
	public User customQuery(String userName);
}
