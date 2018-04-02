package edu.hibernate.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hibernate.onetomany.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
