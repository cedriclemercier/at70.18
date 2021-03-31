package com.example.donutondemand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.donutondemand.dao.ShopJPADao;
import com.example.donutondemand.model.Shop;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	ShopJPADao shopDao;

	@Override
	public List<Shop> findAllShops() {
		return shopDao.findAll();
	}

	@Override
	public Shop findById(int id) {
		return shopDao.findById(id).orElse(new Shop());
	}

}
