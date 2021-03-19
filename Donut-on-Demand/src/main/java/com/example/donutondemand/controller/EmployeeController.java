package com.example.donutondemand.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.donutondemand.model.Employee;
import com.example.donutondemand.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(path = "/homeEmployee")
	public ModelAndView employeeDashboard(Principal principal) {
		
		ModelAndView mv = new ModelAndView("homeEmployee.jsp");
		List<Employee> employees = employeeService.findAllEmployees();
		mv.addObject("employees" , employees);
		
		Employee e = employeeService.findByUsername(principal.getName());
		mv.addObject("employee", e);

			if( e.getRole().getName().equalsIgnoreCase("ROLE_MANAGER")){
				System.out.println("I'm a manager !");
			}
			if( e.getRole().getName().equalsIgnoreCase("ROLE_CASHIER")){
				System.out.println("I'm a cashier !");
			}
			if( e.getRole().getName().equalsIgnoreCase("ROLE_ORDER_SUPERVISOR")){
				System.out.println("I'm an order supervisor !");
			}
		
		return mv;
	}
	
	
	@RequestMapping(path = "/login")
	public String login() {
		return "loginEmployee.jsp";
	}
	
	@RequestMapping(path = "/logout-success")
	public String logout() {
		return "logout.jsp";
	}
}
