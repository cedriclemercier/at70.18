package com.example.donutondemand.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;

@Embeddable
@Data
public class Address {
	
	@Column(nullable = false)
	private String houseNo;
	
	@Column(nullable = false)
	private String streetAddress;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String zipcode;

}
