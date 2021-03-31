package com.example.donutondemand.model;

import java.time.LocalTime;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.donutondemand.converter.LocalTimeJpaConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Embedded
	private Address address;
	
	@Column(nullable = false)
	@Convert(converter = LocalTimeJpaConverter.class)
	private LocalTime openingTime;
	
	@Column(nullable = false)
	@Convert(converter = LocalTimeJpaConverter.class)
    private LocalTime closingTime;
       
    @OneToMany(mappedBy = "shopE", fetch=FetchType.LAZY)
    @JsonManagedReference
    private Set<Employee> employees;
    
    @OneToMany(mappedBy = "shopO",  fetch=FetchType.LAZY)
    @JsonManagedReference
    private Set<Order> purchasedOrders;
    
    
	
}
