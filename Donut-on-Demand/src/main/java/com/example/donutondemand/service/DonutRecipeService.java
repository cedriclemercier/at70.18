package com.example.donutondemand.service;

import java.util.List;

import com.example.donutondemand.model.DonutRecipe;

public interface DonutRecipeService {
	List<DonutRecipe> findAllDonuts();
}
