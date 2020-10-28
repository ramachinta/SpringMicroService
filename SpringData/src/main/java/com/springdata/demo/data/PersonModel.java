package com.springdata.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter@Setter@ToString
public class PersonModel {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  private String firstName;
	  private String lastName;
	  private String lastname_1;

	  protected PersonModel() {}

	  public PersonModel(String firstName, String lastName, String lastname) {
	    this.firstName = firstName;
	    this.lastname_1=lastname;
	    this.lastName = lastName;
	  }

}
