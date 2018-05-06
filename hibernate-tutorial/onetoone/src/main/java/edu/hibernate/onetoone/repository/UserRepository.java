package edu.hibernate.onetoone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.hibernate.onetoone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public Optional<User> findById(String userId);
}
