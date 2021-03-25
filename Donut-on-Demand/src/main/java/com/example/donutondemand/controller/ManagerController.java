package com.example.donutondemand.controller;

import java.security.Principal;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.donutondemand.model.Employee;
import com.example.donutondemand.service.EmployeeService;
import com.example.donutondemand.validation.EmployeeValidator;


@Controller
//@RequestMapping("/manager")
public class ManagerController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	@RequestMapping(path = "/createEmployee", method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("employee", new Employee());
		return "createEmployee.jsp";
	}
	
	@RequestMapping(path = "/createEmployee", method=RequestMethod.POST)
	public String createEmployee( @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Principal principal) {
		employeeValidator.validate(employee, bindingResult);
		
		if (bindingResult.hasErrors()) {
            return "createEmployee.jsp";
        }
		
		Employee manager = employeeService.findByUsername(principal.getName());
		employee.setShopE(manager.getShopE());
		employeeService.save(employee);
		
		return "redirect:/homeEmployee";
	}
	
}
