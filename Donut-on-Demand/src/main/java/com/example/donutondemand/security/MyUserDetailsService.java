package com.example.donutondemand.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.donutondemand.dao.UserJPADao;
import com.example.donutondemand.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserJPADao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User 404");
		}
		
		return new UserDetailsImpl(user);
	}

}
