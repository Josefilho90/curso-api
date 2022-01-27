package com.api.testes.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.testes.domain.User;
import com.api.testes.domain.dto.UserDTO;
import com.api.testes.repositories.UserRepository;
import com.api.testes.services.UserService;
import com.api.testes.services.exceptions.DataIntegratyViolationExcepition;
import com.api.testes.services.exceptions.ObjectNotFoundExcepiton;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper mapper;
	
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

	@Override
	public User create(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}
	
	public void findByEmail(UserDTO obj) {
		Optional<User> user = repository.findByEmail(obj.getEmail());
		if(user.isPresent() && ! user.get().getId().equals(obj.getId())) {
			throw new DataIntegratyViolationExcepition("E-mail já cadastrado no sistema");
		}
	}

	@Override
	public User uptade(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}

	@Override
	public void delete(Integer id) {
		findyById(id);
	 repository.deleteById(id);
		
	}

}
