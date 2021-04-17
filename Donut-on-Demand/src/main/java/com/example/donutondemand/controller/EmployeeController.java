package com.example.donutondemand.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.donutondemand.model.Employee;
import com.example.donutondemand.model.Order;
import com.example.donutondemand.service.EmployeeService;
import com.example.donutondemand.service.OrderService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OrderService orderService;
	
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
	
	
	@RequestMapping(path = "/manageOrdersPicking", method = RequestMethod.GET)
	public ModelAndView manageOrdersPicking(Principal principal) {
		ModelAndView mv = new ModelAndView("manageOrdersPicking.jsp");
		
		Employee e = employeeService.findByUsername(principal.getName());
		
		List<Order> orders = orderService.findOrdersToPrepare(e.getShopE().getId());
		mv.addObject("orders",orders);
		
		return mv;
	}
	
	@RequestMapping({ "/changeOrderStatus" })
	public String changeOrderStatus( @RequestParam(value = "id", defaultValue = "") int id) {
		orderService.changeOrderStatus(id);
		
		return "redirect:/manageOrdersPicking";
	}
	
	@RequestMapping(path = "/manageOrdersWithdrawn", method=RequestMethod.GET)
	public ModelAndView manageOrdersWithdrawn() {
		ModelAndView mv = new ModelAndView("manageOrdersWithdrawn.jsp");
		
		return mv;
	}
	
	
}
