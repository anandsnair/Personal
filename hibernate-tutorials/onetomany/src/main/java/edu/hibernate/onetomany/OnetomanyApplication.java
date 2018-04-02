package edu.hibernate.onetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan
@EnableJpaAuditing
public class OnetomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetomanyApplication.class, args);
	}
}
