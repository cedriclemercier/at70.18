package com.example.donutondemand.model;

import java.util.Date;

import lombok.Data;

@Data
public class OrderInfo {
	
	private String firstname;

	
	private String lastname;
	
	
	private String email;
	
	
	private String phone;
	
	private Shop shop;
	
	private String pickUpTime;
	
	private String pickUpDate;
	
	private boolean valid;
	
	
	
	
	
}
