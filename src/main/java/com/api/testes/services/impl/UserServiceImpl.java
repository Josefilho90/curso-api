package com.api.testes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.testes.domain.User;
import com.api.testes.repositories.UserRepository;
import com.api.testes.services.UserService;
import com.api.testes.services.exceptions.ObjectNotFoundExcepiton;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public User findyById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExcepiton("Objeto não encontrado"));
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}

}
