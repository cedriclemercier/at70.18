package com.example.donutondemand.service;

import java.util.List;

import com.example.donutondemand.model.OrderLine;

public interface OrderLineService {
	List<OrderLine> findOrderlinesByDonutRecipeId(int donut_recipe_id);
}
