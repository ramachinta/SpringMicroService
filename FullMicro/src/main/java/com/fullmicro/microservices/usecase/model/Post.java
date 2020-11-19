package com.fullmicro.microservices.usecase.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter@Getter@ToString

public class Post {
	
	@Id
	@GeneratedValue
	private Integer postId;
	private String message;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Jpauser user;

}
