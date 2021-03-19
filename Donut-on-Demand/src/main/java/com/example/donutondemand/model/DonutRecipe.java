package com.example.donutondemand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DonutRecipe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
}
