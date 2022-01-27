package com.api.testes.services;

import java.util.List;

import com.api.testes.domain.User;
import com.api.testes.domain.dto.UserDTO;

public interface UserService {
	
	User findyById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User uptade(UserDTO obj);
		

}
