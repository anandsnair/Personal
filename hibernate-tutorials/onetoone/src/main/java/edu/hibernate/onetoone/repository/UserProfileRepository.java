package edu.hibernate.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.hibernate.onetoone.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

}
