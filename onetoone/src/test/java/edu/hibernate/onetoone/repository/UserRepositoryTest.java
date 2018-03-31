package edu.hibernate.onetoone.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hibernate.onetoone.model.Name;
import edu.hibernate.onetoone.model.User;
import edu.hibernate.onetoone.model.UserProfile;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void createUser() {
		User user = new User();
		Name n = new Name("Anand","S", "Nair");
		user.setName(n);
		user.setUsername("anandsnair");
		user.setPassword("DP123");
		UserProfile profile = new UserProfile();
		profile.setUser(user);
		profile.setEmailId("anandsnair@gmail.com");
		profile.setDateOfBirth(new Date(1986, 12, 13));
		user.setUserProfile(profile);
		User createdUser = entityManager.persistAndFlush(user);
		//assert(true);
		User fetchedUser = entityManager.find(User.class, createdUser.getId());
		System.out.println(fetchedUser.getName().getFullName());
		System.out.println(fetchedUser.getUserProfile().getEmailId());
		assertEquals(user.getId(), fetchedUser.getId());
	}
}
