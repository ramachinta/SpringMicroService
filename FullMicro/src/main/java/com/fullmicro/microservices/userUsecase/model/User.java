package com.fullmicro.microservices.userUsecase.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString@AllArgsConstructor@NoArgsConstructor
public class User {
	
	private Integer id;
	private String name;
	private Date dob;
}
