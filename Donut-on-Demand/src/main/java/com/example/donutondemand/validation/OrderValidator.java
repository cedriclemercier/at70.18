package com.example.donutondemand.validation;

import java.time.LocalTime;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.donutondemand.model.Customer;
import com.example.donutondemand.model.OrderInfo;

@Component
public class OrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderInfo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderInfo orderInfo = (OrderInfo) target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
		if (orderInfo.getFirstname().length() < 2 || orderInfo.getFirstname().length() > 32) {
			errors.rejectValue("firstname", "size.customer.name");
        }
	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
        if (orderInfo.getLastname().length() < 2 || orderInfo.getLastname().length() > 32) {
			errors.rejectValue("lastname", "size.customer.name");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shop", "NotEmpty");
        
        if ( LocalTime.parse(orderInfo.getPickUpTime()).toSecondOfDay() < orderInfo.getShop().getOpeningTime().toSecondOfDay() 
        		||  LocalTime.parse(orderInfo.getPickUpTime()).toSecondOfDay() > orderInfo.getShop().getClosingTime().toSecondOfDay()) {
        	errors.rejectValue("shop", "shop.schedule");
        }
	}
	
	

}
