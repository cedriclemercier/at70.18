package com.example.donutondemand.model;

import java.time.LocalTime;
import java.util.Set;

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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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
    private Set<Employee> employees;
    
    @OneToMany(mappedBy = "shopO", fetch=FetchType.LAZY)
    private Set<Order> purchasedOrders;
	
}
