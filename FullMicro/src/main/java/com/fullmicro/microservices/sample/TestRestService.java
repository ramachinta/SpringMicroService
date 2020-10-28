package com.fullmicro.microservices.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloRest")
public class TestRestService {
	
	@RequestMapping("/sayHello")
	public String helloRest() {
		return "Hello There from Restful service";
	}
	
	@GetMapping("/sayBean")
	public HelloBean helloRestBean() {
		
		return new HelloBean("Hello There from Restful service");
	}
	
	@RequestMapping("/sayHello/{name}")
	public String helloRestPath(@PathVariable String name) {
		return "Hello "+name+"! from Restful service";
	}

}
