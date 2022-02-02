package com.api.testes.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.testes.domain.User;
import com.api.testes.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository repository;
	
	@Bean
	public void startDB() {
		User u1 = new User(null, "José", "Jose@email.com", "123");
		User u2 = new User(null, "Filho", "Filho@email.com", "123");
		
		repository.saveAll(List.of(u1, u2));
	}

}
