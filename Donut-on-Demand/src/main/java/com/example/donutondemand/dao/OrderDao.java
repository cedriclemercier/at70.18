package com.example.donutondemand.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.donutondemand.model.Order;

public interface OrderDao extends CrudRepository<Order, Integer>{

	@Query("from Order where shopo_id = ?1 AND status = 'PROCESSING' order by pick_up_date, pick_up_time")
	List<Order> findOrdersToPrepare(int shopo_id);
}
