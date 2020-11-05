package com.fullmicro.microservices.usecase.daoservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fullmicro.microservices.usecase.model.User;

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
		
System.out.println("testing the component scan22222222222");
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
		List<User> usr = users.stream().filter(usrId->usrId.getId()==id).collect(Collectors.toList());
		if(null!=usr && usr.size()>0)
			return usr.get(0);
		else
			return null;
	}
	
	public boolean deleteUserById(int id) {
		int size= users.size();
		List<User> usr = users.stream().filter(usrId->usrId.getId()!=id).collect(Collectors.toList());
		if(size!=usr.size()) {
			this.users = usr;
			return true;
		} else
			return false;
	}
}
