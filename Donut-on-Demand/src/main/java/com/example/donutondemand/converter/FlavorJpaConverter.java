package com.example.donutondemand.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.donutondemand.model.Flavor;

@Converter(autoApply=true)
public class FlavorJpaConverter implements AttributeConverter<Flavor, String> {
	
	   @Override
	   public String convertToDatabaseColumn(Flavor flavor) {
	       if (flavor == null) {
	           return null;
	       }
	       return flavor.toString();
	   }
	 
	   @Override
	   public Flavor convertToEntityAttribute(String string) {
	       if (string == null) {
	           return null;
	       }
	       try {
	           return Flavor.valueOf(string);
	       } catch (IllegalArgumentException e) {
	           return null;
	       }
	   }
}
