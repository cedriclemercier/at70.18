package com.example.donutondemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@NotBlank(message="This field is required.")
	private String username;
	
	@NotBlank(message="This field is required.")
	@Column(nullable = false)
	private String password;
	
	@NotBlank(message="This field is required.")
	@Transient
	private String passwordConfirm;
	
	@NotBlank(message="This field is required.")
	@Email(message="Email should be valid")
	private String email;
	
	private boolean active;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference 
	private Role role;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference 
	private Shop shopE;
	

}
