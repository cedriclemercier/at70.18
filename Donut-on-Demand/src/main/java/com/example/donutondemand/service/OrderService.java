package com.example.donutondemand.service;

import java.util.List;

import com.example.donutondemand.model.CartInfo;
import com.example.donutondemand.model.Order;

public interface OrderService {
	void save(CartInfo cart);
	List<Order> findOrdersToPrepare(int shopId);
	List<Order> findOrdersReady();
	void changeOrderStatus(int id);
	List<Order> findOrdersReady(int shopId);
	void changeOrderStatus2(int id);
}
