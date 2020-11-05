package com.fullmicro.microservices.usecase.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullmicro.microservices.usecase.daoservice.UserDao;
import com.fullmicro.microservices.usecase.miscellaneous.UserNotFoundException;
import com.fullmicro.microservices.usecase.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/getAllUsers")
	public List<User> findAllUsers(){
		return dao.findAll();
	}
	
	@RequestMapping("/findUser/{id}")
	public User findUser(@PathVariable int id) throws Exception {
		User usr= dao.findUser(id);
		if(null==usr) {
			throw new UserNotFoundException("User not found");
		}
		return dao.findUser(id);
	}
	
	//@RequestMapping("/saveUser")
	@PostMapping(path="/saveUser")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		user= dao.saveUser(user);
		ResponseEntity<User> ret = ResponseEntity.status(HttpStatus.CREATED).body(user);
		//ResponseEntity<User> re = ResponseEntity.status(HttpStatus.OK).body(user);
		return ret;
	}
	
	@RequestMapping("/deleteUser/{id}")
	public String deleteUserById(@PathVariable int id) throws Exception {
		boolean usr= dao.deleteUserById(id);
		System.out.println(usr);
		if(!usr) {
			throw new UserNotFoundException("User not found");
		} else {
			return "User "+id+" deleted";
		}
	}

}
