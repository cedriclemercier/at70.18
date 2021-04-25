package com.example.donutondemand.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.donutondemand.model.OrderLine;

public interface OrderLineDao extends CrudRepository<OrderLine, Integer>{

	@Query("from OrderLine where donut_id = ?1")
	List<OrderLine> findOrderLinesByDonutRecipe(int donut_id);
}
