package com.example.donutondemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="donut_recipe_id", nullable=false)
	private DonutRecipe donut;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="order_id", nullable=false)
	private Order order;
	
	@Column(nullable = false)
    private int quantity;
    
	@Column(nullable = false)
    private double price;
    
}
