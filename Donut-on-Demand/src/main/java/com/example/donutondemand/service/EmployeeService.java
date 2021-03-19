package com.example.donutondemand.service;

import com.example.donutondemand.model.Employee;

public interface EmployeeService {
	void save(Employee employee);
	Employee findByUsername(String username);
}
