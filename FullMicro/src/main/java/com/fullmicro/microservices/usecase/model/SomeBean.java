package com.fullmicro.microservices.usecase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class SomeBean {
	
	private String field1;
	private String field2;
	@JsonIgnore
	private String field3;
	

}
