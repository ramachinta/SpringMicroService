package com.fullmicro.microservices.usecase.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.fullmicro.microservices.usecase.daoservice.PostRepository;
import com.fullmicro.microservices.usecase.daoservice.UserRepository;
import com.fullmicro.microservices.usecase.miscellaneous.UserNotFoundException;
import com.fullmicro.microservices.usecase.model.Jpauser;
import com.fullmicro.microservices.usecase.model.Post;

@RestController
@RequestMapping("/Jpausers")
public class UserJpaController {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepo;
	
	@RequestMapping("/getAllJpaUsers")
	public List<Jpauser> findAllUsers(){
		return repository.findAll();
	}
	
	@RequestMapping("/findJpaUser/{id}")
	public Optional<Jpauser> findUser(@PathVariable int id) throws Exception {
		Optional<Jpauser> usr= repository.findById(id);
		if(usr.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		return usr;
	}
	
	//@RequestMapping("/saveUser")
	@PostMapping(path="/saveJpaUser")
	public ResponseEntity<Jpauser> saveUser(@Valid @RequestBody Jpauser user){
		user= repository.save(user);
		ResponseEntity<Jpauser> ret = ResponseEntity.status(HttpStatus.CREATED).body(user);
		//ResponseEntity<User> re = ResponseEntity.status(HttpStatus.OK).body(user);
		return ret;
	}
	
	@RequestMapping("/deleteJpaUser/{id}")
	public void deleteUserById(@PathVariable int id) throws Exception {
		repository.deleteById(id);
		
	}
	
	@RequestMapping("{id}/findJpaAllPost")
	public List<Post> findAllPostsByUserId(@PathVariable int id) throws Exception {
		Optional<Jpauser> usr= repository.findById(id);
		if(!usr.isPresent()) {
			System.out.println("User not found missing id "+id);
			throw new UserNotFoundException("User not found missing id "+id);
		}
		return usr.get().getPosts();
	}
	
		@PostMapping(path="{id}/saveJpaUserPost")
		public ResponseEntity<Post> savePost(@PathVariable int id, @Valid @RequestBody Post post){
			Optional<Jpauser> usr = repository.findById(id);
			if(!usr.isPresent()) {
				throw new UserNotFoundException("User id doewn't exist");
			}
			
			Jpauser user = usr.get();
			post.setUser(user);
			postRepo.save(post);
			ResponseEntity<@Valid Post> ret = ResponseEntity.status(HttpStatus.CREATED).body(post);
			//ResponseEntity<User> re = ResponseEntity.status(HttpStatus.OK).body(user);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getPostId()).toUri();
			return ResponseEntity.created(location).build();
		}
	
}
