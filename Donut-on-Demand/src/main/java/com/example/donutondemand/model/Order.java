package com.example.donutondemand.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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

import com.example.donutondemand.converter.LocalDateTimeJpaConverter;
import com.example.donutondemand.converter.StatusJpaConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id", nullable=false)
	@JsonBackReference 
	private Shop shopO;
	
	@Column(nullable = false)
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "firstName", column = @Column(name = "customer_first_name")),
		  @AttributeOverride( name = "lastName", column = @Column(name = "customer_last_name")),
		  @AttributeOverride( name = "email", column = @Column(name = "customer_email")),
		  @AttributeOverride( name = "phone", column = @Column(name = "customer_phone"))
		})
	private Customer customer;

	@OneToMany(mappedBy = "order")
	private Set<OrderLine> orderLines;
		
	@Column(nullable = false)
	@Convert(converter = LocalDateTimeJpaConverter.class)
    private LocalDateTime pickUpDateTime;
    
    @Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Convert(converter = StatusJpaConverter.class)
    private Status status;
	
}
