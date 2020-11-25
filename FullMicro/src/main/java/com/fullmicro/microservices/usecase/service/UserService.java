package com.fullmicro.microservices.usecase.service;

import java.util.List;
import java.util.Optional;

import com.fullmicro.microservices.usecase.model.Jpauser;

public interface UserService {
	
	public List<Jpauser> getAllJpaUser();
	
	public Optional<Jpauser> getJpaUser(int id);

}
