package com.fullmicro.microservices.usecase.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor@JsonFilter("filterBeans")
public class DynamicFilter {
	
	private String field1;
	private String field2;
	private String field3;

}
