package com.api.testes.services;

import java.util.List;

import com.api.testes.domain.User;

public interface UserService {
	
	User findyById(Integer id);
    List<User> findAll();
		

}
