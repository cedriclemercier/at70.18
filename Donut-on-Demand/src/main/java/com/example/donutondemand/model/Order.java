package com.example.donutondemand.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.donutondemand.converter.LocalDateJpaConverter;
import com.example.donutondemand.converter.LocalTimeJpaConverter;
import com.example.donutondemand.converter.StatusJpaConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	//@JoinColumn(name="shop_id", nullable=false)
	@JsonBackReference 
	private Shop shopO;
	
	@Column(nullable = false)
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "firstname", column = @Column(name = "customer_first_name")),
		  @AttributeOverride( name = "lastname", column = @Column(name = "customer_last_name")),
		  @AttributeOverride( name = "email", column = @Column(name = "customer_email")),
		  @AttributeOverride( name = "phone", column = @Column(name = "customer_phone"))
		})
	private Customer customer;

	@OneToMany(mappedBy = "order",  cascade = {CascadeType.ALL })
	@JsonManagedReference
	private Set<OrderLine> orderlines;
		
	@Column(nullable = false)
	@Convert(converter = LocalTimeJpaConverter.class)
    private LocalTime pickUpTime;
    
	
	@Column(nullable = false)
	@Convert(converter = LocalDateJpaConverter.class)
    private LocalDate pickUpDate;
	
    @Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Convert(converter = StatusJpaConverter.class)
    private Status status;
    
}
