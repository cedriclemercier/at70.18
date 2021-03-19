package com.example.donutondemand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
	
	@RequestMapping(path = "/home")
	public String home() {
		return "home.jsp";
	}
	
}
