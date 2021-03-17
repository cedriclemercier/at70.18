package com.example.donutondemand.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.donutondemand.dao.UserJPADao;
import com.example.donutondemand.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserJPADao userDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	EmailService emailService;
	
	
	@Override
	public void save(User user) {
		String hashedPassword = bCryptEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setActive(true);
		userDao.save(user);

		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setTo(user.getEmail());
		emailMsg.setText("You are registered!");
		emailMsg.setSubject("Registration successful!");
		emailMsg.setFrom("admin@random.asia");

		try {
			emailService.sendEmail(emailMsg);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
