package com.fullmicro.microservices.usecase.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class ExceptionDetails {
	
	private Date timeStamp;
	private String message;
	private String details;

}
