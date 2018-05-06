package edu.hibernate.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import edu.hibernate.onetomany.model.User;
import edu.hibernate.onetomany.service.UserService;

@SpringBootApplication
@ComponentScan
@EnableJpaAuditing
public class OnetomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetomanyApplication.class, args);
		
	}
}
