package com.example.donutondemand.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.donutondemand.model.Order;

public interface OrderJPADao extends JpaRepository<Order, Integer> {

	//@Query("from Order where status = 'PROCESSING' AND shopo_id = ?1 order by pick_up_date ")
	//List<Order> findOrdersToPrepare(int shopo_id);
}
