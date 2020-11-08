package com.fullmicro.microservices.usecase.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fullmicro.microservices.usecase.model.DynamicFilter;
import com.fullmicro.microservices.usecase.model.SomeBean;

@RestController
public class FilteringController {
	
	@GetMapping("/filterBean")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("Field1", "Field2","Field3");
	}
	
	@GetMapping("/filterBeans")
	public List<SomeBean> getAllSomeBeans(){
		return Arrays.asList(new SomeBean("Field11", "Field12","Field13"),new SomeBean("Field21", "Field22","Field23"));
	}
	
	@GetMapping("/filterDyFields")
	public MappingJacksonValue getFilteredBean() {
		DynamicFilter bean = new DynamicFilter("Value1","Value2","Value");
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filters =SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filter = new SimpleFilterProvider().addFilter("filterBeans", filters);
		mapping.setFilters(filter);
		return mapping;
	}
	
	@GetMapping("/filterDyField/{id}")
	public MappingJacksonValue getFilteredBeans(@PathVariable int id) {
		DynamicFilter bean = new DynamicFilter("Value1","Value2","Value3");
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		FilterProvider filter=getFilter(id);
		mapping.setFilters(filter);
		return mapping;
	}
	
	private FilterProvider getFilter(int i) {
		System.out.println("--------------------------------"+i);
		SimpleBeanPropertyFilter filters = null;
		if(i==1) {
			filters =SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		} else if(i==2) {
			filters =SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		} else if(i==3) {
			filters =SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2", "field3");
		} else {
			filters =SimpleBeanPropertyFilter.filterOutAllExcept();
		}
		FilterProvider filter = new SimpleFilterProvider().addFilter("filterBeans", filters);
		return filter;
	}

}
