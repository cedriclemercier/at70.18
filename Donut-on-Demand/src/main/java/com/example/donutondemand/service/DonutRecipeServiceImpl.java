package com.example.donutondemand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.donutondemand.dao.DonutRecipeJPADao;
import com.example.donutondemand.model.DonutRecipe;

@Service
public class DonutRecipeServiceImpl implements DonutRecipeService{

	@Autowired
	DonutRecipeJPADao donutDao;
	
	@Override
	public List<DonutRecipe> findAllDonuts() {
		return donutDao.findAll();
	}

}
