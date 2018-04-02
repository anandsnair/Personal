package edu.hibernate.onetomany.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hibernate.onetomany.model.Address;
import edu.hibernate.onetomany.model.Name;
import edu.hibernate.onetomany.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	public void createUser() {
		User user = new User();
		Name n = new Name("Anand","S", "Nair");
		user.setName(n);
		user.setUsername("anandsnair");
		user.setPassword("DP123");
		Set<Address> address = new HashSet<>();
		Address homeAddr = new Address();
		homeAddr.setCity("Fremont");
		homeAddr.setCountry("USA");
		homeAddr.setFirstLine("33331, Fremont Road");
		homeAddr.setState("CA");
		homeAddr.setZipCode("33333");
		homeAddr.setUser(user);
		address.add(homeAddr);
		
		Address workAddr = new Address();
		workAddr.setCity("Redwoodcity");
		workAddr.setCountry("USA");
		workAddr.setFirstLine("22, seaport");
		workAddr.setState("CA");
		workAddr.setZipCode("22232");
		workAddr.setUser(user);
		address.add(workAddr);
		
		
		user.setAddress(address);
		User createdUser = entityManager.persistAndFlush(user);
		//assert(true);
		User fetchedUser = entityManager.find(User.class, createdUser.getId());
		System.out.println(fetchedUser.getName().getFullName());
		System.out.println("Created on"+fetchedUser.getCreatedTime());
		System.out.println("Home Address City = "+fetchedUser.getAddress().size());
		assertEquals(user.getId(), fetchedUser.getId());

	}
	
	@Test
	public void create50Users() {
		
		for(int i = 0 ; i < 50 ; i++) {
			User user = new User();
			Name n = new Name("first"+i,"m"+i, "last"+1);
			user.setUsername("user "+i);
			user.setPassword("password"+i);
			user.setName(n);
			user.setAge(i);
			entityManager.persistAndFlush(user);
		}

		List<User> users = userRepo.findByAgeLessThan(25);
		System.out.println(users.size());
		
		User user = userRepo.customQuery("user 22");
		System.out.println(user.getPassword());
	}
}
