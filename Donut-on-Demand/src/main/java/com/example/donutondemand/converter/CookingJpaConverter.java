package com.example.donutondemand.converter;

import javax.persistence.AttributeConverter;

import com.example.donutondemand.model.Cooking;

public class CookingJpaConverter implements AttributeConverter<Cooking, String> {
	
	   @Override
	   public String convertToDatabaseColumn(Cooking cooking) {
	       if (cooking == null) {
	           return null;
	       }
	       return cooking.toString();
	   }
	 
	   @Override
	   public Cooking convertToEntityAttribute(String string) {
	       if (string == null) {
	           return null;
	       }
	       try {
	           return Cooking.valueOf(string);
	       } catch (IllegalArgumentException e) {
	           return null;
	       }
	   }
}
