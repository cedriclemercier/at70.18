package com.example.donutondemand.validation;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.donutondemand.model.Employee;
import com.example.donutondemand.service.EmployeeService;

@Component
public class EmployeeValidator implements Validator {

	@Autowired
	private EmployeeService employeeService;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (employee.getUsername().length() < 6 || employee.getUsername().length() > 32) {
			errors.rejectValue("username", "size.user.username");
        }
        if (employeeService.findByUsername(employee.getUsername()) != null) {
            errors.rejectValue("username", "duplicate.user.username");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (employee.getPassword().length() < 8 || employee.getPassword().length() > 32) {
            errors.rejectValue("password", "size.user.password");
        }

        if (!employee.getPasswordConfirm().equals(employee.getPassword())) {
            errors.rejectValue("passwordConfirm", "diff.user.passwordConfirm");
        }		
	}

}
