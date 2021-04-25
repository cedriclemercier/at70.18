package com.example.donutondemand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.donutondemand.dao.OrderLineDao;
import com.example.donutondemand.model.OrderLine;

@Service
public class OrderLineServiceImpl implements OrderLineService{

	@Autowired
	OrderLineDao orderlineDao;
	
	@Override
	public List<OrderLine> findOrderlinesByDonutRecipeId(int donut_recipe_id) {
		return orderlineDao.findOrderLinesByDonutRecipe(donut_recipe_id);
	}
	

}
