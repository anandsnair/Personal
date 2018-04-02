package edu.hibernate.onetomany.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

public class AddressRepositoryTest {
	@Autowired
	TestEntityManager entityManager;
	
	
	@Test
	public void addAddressToExistingUser() {
		User user = new User();
		Name n = new Name("Anand","S", "Nair");
		user.setName(n);
		user.setUsername("anandsnair");
		user.setPassword("DP123");
		User createdUser = entityManager.persistAndFlush(user);
		
		Address homeAddr = new Address();
		homeAddr.setCity("Fremont");
		homeAddr.setCountry("USA");
		homeAddr.setFirstLine("33331, Fremont Road");
		homeAddr.setState("CA");
		homeAddr.setZipCode("33333");
		homeAddr.setUser(createdUser);
		
		Address homeAddrFetched = entityManager.persistAndFlush(homeAddr);
				
		User fetchedUser = entityManager.find(User.class, createdUser.getId());
		System.out.println(fetchedUser.getName().getFullName());
		System.out.println("Created on"+fetchedUser.getCreatedTime());
		System.out.println("Home Address City = "+fetchedUser.getAddress().size());
		assertEquals(user.getId(), fetchedUser.getId());

	}

}
