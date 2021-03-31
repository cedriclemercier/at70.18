package com.example.donutondemand.service;

import java.util.List;

import com.example.donutondemand.model.Shop;

public interface ShopService {
	List<Shop> findAllShops();
	Shop findById(int id);
}
