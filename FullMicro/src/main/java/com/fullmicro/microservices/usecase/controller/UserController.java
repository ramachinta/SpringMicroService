package com.fullmicro.microservices.usecase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullmicro.microservices.usecase.daoservice.UserDao;
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
	public User findUser(@PathVariable int id) {
		return dao.findUser(id);
	}

}
