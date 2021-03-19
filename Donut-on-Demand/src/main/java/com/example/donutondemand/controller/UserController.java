package com.example.donutondemand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.donutondemand.model.DonutRecipe;
import com.example.donutondemand.service.DonutRecipeService;


@Controller
public class UserController {
	
	
	@Autowired
	private DonutRecipeService donutService;
	
	@RequestMapping(path = "/home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping(path = "/order")
	public ModelAndView order() {
		
		ModelAndView mv = new ModelAndView("orderPage.jsp");
		List<DonutRecipe> donuts = donutService.findAllDonuts();
		mv.addObject("donuts" , donuts);
	
		return mv;
	}
}
