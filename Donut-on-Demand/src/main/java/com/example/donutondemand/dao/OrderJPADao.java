package com.example.donutondemand.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.donutondemand.model.Order;

public interface OrderJPADao extends JpaRepository<Order, Integer> {

}
