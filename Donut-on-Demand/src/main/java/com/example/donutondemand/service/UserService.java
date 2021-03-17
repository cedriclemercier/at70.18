package com.example.donutondemand.service;

import com.example.donutondemand.model.User;

public interface UserService {
	void save(User user);
	User findByUsername(String username);
}
