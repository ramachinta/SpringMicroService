package com.springdata.demo.data;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends JpaRepository<PersonModel, Long>{
										  //Repository<PersonModel, Long>{

	Iterable<PersonModel> findBylastName(String string);
	
/*	Page<PersonModel> findBylastName(String lastName, Pageable pageable);

	Slice<PersonModel> findBylastName(String lastName, Pageable pageable);

	List<PersonModel> findBylastName(String lastName, Sort sort);

	List<PersonModel> findBylastName(String lastName, Pageable pageable);*/
	
	

	  // Enables the distinct flag for the query
	 /* List<PersonModel> findDistinctPeopleBylastNameOrfirstName(String lastName, String firstName);
	  List<PersonModel> findPeopleDistinctBylastNameOrfirstName(String lastName, String firstName);

	  // Enabling ignoring case for an individual property
	  List<PersonModel> findBylastNameIgnoreCase(String lastName);
	  // Enabling ignoring case for all suitable properties
	  //List<PersonModel> findByastNameAndfirstNameAllIgnoreCase(String lastName, String firstName);

	  // Enabling static ORDER BY for a query
	  List<PersonModel> findBylastNameOrderByFirstNameAsc(String lastName);
	  List<PersonModel> findBylastNameOrderByFirstNameDesc(String lastName);*/

}
