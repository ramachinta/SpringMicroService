package com.fullmicro.microservices.usecase.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullmicro.microservices.usecase.daoservice.UserRepository;
import com.fullmicro.microservices.usecase.miscellaneous.UserNotFoundException;
import com.fullmicro.microservices.usecase.model.User;

@RestController
@RequestMapping("/users")
public class UserJpaController {
	@Autowired
	private UserRepository repository;
	
	
	@RequestMapping("/getAllUsers")
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	
	@RequestMapping("/findUser/{id}")
	public Optional<User> findUser(@PathVariable int id) throws Exception {
		Optional<User> usr= repository.findById(id);
		if(null==usr) {
			throw new UserNotFoundException("User not found");
		}
		return usr;
	}
	
	@PostMapping(path="/saveUser")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		user= repository.save(user);
		ResponseEntity<User> ret = ResponseEntity.status(HttpStatus.CREATED).body(user);
		//ResponseEntity<User> re = ResponseEntity.status(HttpStatus.OK).body(user);
		return ret;
	}
	
	@RequestMapping("/deleteUser/{id}")
	public void deleteUserById(@PathVariable int id) throws Exception {
		repository.deleteById(id);
		
	}

}
