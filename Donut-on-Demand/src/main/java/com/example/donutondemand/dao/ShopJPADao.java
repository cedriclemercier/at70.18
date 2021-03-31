package com.example.donutondemand.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.donutondemand.model.Shop;

public interface ShopJPADao extends JpaRepository<Shop, Integer>  {

}
