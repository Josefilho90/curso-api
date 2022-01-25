package com.api.testes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.testes.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	

}
