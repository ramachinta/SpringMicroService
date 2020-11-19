package com.fullmicro.microservices.usecase.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jpauser {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment
	//@GeneratedValue(generator = "sequence-generator")
   /* @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "user_sequence"),
        @Parameter(name = "initial_value", value = "6"),
        @Parameter(name = "increment_size", value = "1")
        }
    )*/
	@GeneratedValue
	private Integer id;
	@Size(min = 2, max = 100, message = "Name should have 2 characters.")
	private String name;
	@Past
	private Date dob;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
}
