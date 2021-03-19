package com.example.donutondemand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.donutondemand.dao.EmployeeJPADao;
import com.example.donutondemand.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeJPADao employeeDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	EmailService emailService;
	
	
	@Override
	public void save(Employee employee) {
		String hashedPassword = bCryptEncoder.encode(employee.getPassword());
		employee.setPassword(hashedPassword);
		employee.setActive(true);
		employeeDao.save(employee);

		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setTo(employee.getEmail());
		emailMsg.setText("Employee created!");
		emailMsg.setSubject("Creation successful!");
		emailMsg.setFrom("manager@donuttc.asia");

		try {
			emailService.sendEmail(emailMsg);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

	@Override
	public Employee findByUsername(String username) {
		return employeeDao.findByUsername(username);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAll();
	}

}
