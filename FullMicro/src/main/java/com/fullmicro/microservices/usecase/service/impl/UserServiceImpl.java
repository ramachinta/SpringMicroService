package com.fullmicro.microservices.usecase.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fullmicro.microservices.usecase.daoservice.UserRepository;
import com.fullmicro.microservices.usecase.model.Jpauser;
import com.fullmicro.microservices.usecase.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<Jpauser> getAllJpaUser() {
		return repository.findAll();
	}

	@Override
	public Optional<Jpauser> getJpaUser(int id) {
		return repository.findById(id);
	}

}
