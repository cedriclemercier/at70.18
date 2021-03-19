package com.example.donutondemand.controller;

import java.time.LocalDate;

import javax.validation.Valid;

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
		System.out.println("YESSSS");
		return "createEmployee.jsp";
	}
	
	@RequestMapping(path = "/createEmployee", method=RequestMethod.POST)
	public String createEmployee( @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult) {
		employeeValidator.validate(employee, bindingResult);
		
		if (bindingResult.hasErrors()) {
            return "createEmployee.jsp";
        }
		
		employeeService.save(employee);
		
		return "createEmployee.jsp";
	}
	
}
