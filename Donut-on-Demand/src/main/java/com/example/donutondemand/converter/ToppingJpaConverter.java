package com.example.donutondemand.converter;

import javax.persistence.AttributeConverter;

import com.example.donutondemand.model.Topping;

public class ToppingJpaConverter implements AttributeConverter<Topping, String> {
	
	   @Override
	   public String convertToDatabaseColumn(Topping topping) {
	       if (topping == null) {
	           return null;
	       }
	       return topping.toString();
	   }
	 
	   @Override
	   public Topping convertToEntityAttribute(String string) {
	       if (string == null) {
	           return null;
	       }
	       try {
	           return Topping.valueOf(string);
	       } catch (IllegalArgumentException e) {
	           return null;
	       }
	   }
}
