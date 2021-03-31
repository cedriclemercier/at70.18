package com.example.donutondemand.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.donutondemand.model.Employee;

@RepositoryRestResource(collectionResourceRel = "employees" , path="employees")
public interface EmployeeJPADao extends JpaRepository<Employee, Integer> {
	Employee findByUsername(String username);
}
