package com.example.donutondemand.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.donutondemand.model.Cooking;

@Converter(autoApply=true)

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
