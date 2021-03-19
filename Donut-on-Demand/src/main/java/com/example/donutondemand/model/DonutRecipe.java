package com.example.donutondemand.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.donutondemand.converter.CookingJpaConverter;
import com.example.donutondemand.converter.DoughJpaConverter;
import com.example.donutondemand.converter.FlavorJpaConverter;
import com.example.donutondemand.converter.MixJpaConverter;
import com.example.donutondemand.converter.ToppingJpaConverter;

import lombok.Data;

@Entity
@Data
public class DonutRecipe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Convert(converter = DoughJpaConverter.class)
    private Dough dough; 
    
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Convert(converter = FlavorJpaConverter.class)
    private Flavor flavor; 
    
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Convert(converter = ToppingJpaConverter.class)
    private Topping topping;
    
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Convert(converter = MixJpaConverter.class)
    private Mix mix;
    
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Convert(converter = CookingJpaConverter.class)
    private Cooking cooking;
    
	@Column(nullable = false)
    private double price;
	
	
}