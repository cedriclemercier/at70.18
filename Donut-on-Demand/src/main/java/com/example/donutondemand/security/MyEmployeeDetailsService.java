package com.example.donutondemand.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.donutondemand.dao.EmployeeJPADao;
import com.example.donutondemand.model.Employee;

@Service
public class MyEmployeeDetailsService implements UserDetailsService{

	@Autowired
	EmployeeJPADao employeeDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee employee = employeeDao.findByUsername(username);
		
		if(employee==null) {
			throw new UsernameNotFoundException("Employee 404");
		}
		
		return new EmployeeDetailsImpl(employee);
	}

}
