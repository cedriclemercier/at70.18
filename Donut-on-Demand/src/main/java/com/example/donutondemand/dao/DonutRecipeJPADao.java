package com.example.donutondemand.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.donutondemand.model.DonutRecipe;
import com.example.donutondemand.model.Employee;

@RepositoryRestResource(collectionResourceRel = "donuts" , path="donuts")
public interface DonutRecipeJPADao extends JpaRepository<DonutRecipe, Integer> {

}
