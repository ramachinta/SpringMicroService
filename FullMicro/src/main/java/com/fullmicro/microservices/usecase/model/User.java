package com.fullmicro.microservices.usecase.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString@NoArgsConstructor@AllArgsConstructor
public class User {
	
	private Integer id;
	@Size(min=2, max=100, message="Name should have 2 characters.")
	private String name;
	@Past
	private Date dob;
}
