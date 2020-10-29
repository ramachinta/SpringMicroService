package com.fullmicro.microservices.userUsecase.daoservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fullmicro.microservices.userUsecase.model.User;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter@Getter
public class UserDao {
	
	private static int userCountid=0;

	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1,"Rama",new Date()));
		users.add(new User(2,"Kama",new Date()));
		users.add(new User(3,"Lama",new Date()));
		users.add(new User(4,"Sama",new Date()));
		userCountid=users.size()+1;
	}
	
	public List<User> findAll(){
		return users;
	}
	public User saveUser(User user) {
		user.setId(userCountid++);
		users.add(user);
		return user;
	}
	
	public User findUser(int id) {
		User usr = (User) users.stream().filter(usrId->usrId.getId()==id);
		return usr;
	}
}
