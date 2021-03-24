package com.example.donutondemand.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.donutondemand.model.Mix;

@Converter(autoApply=true)
public class MixJpaConverter implements AttributeConverter<Mix, String> {
	
	   @Override
	   public String convertToDatabaseColumn(Mix mix) {
	       if (mix == null) {
	           return null;
	       }
	       return mix.toString();
	   }
	 
	   @Override
	   public Mix convertToEntityAttribute(String string) {
	       if (string == null) {
	           return null;
	       }
	       try {
	           return Mix.valueOf(string);
	       } catch (IllegalArgumentException e) {
	           return null;
	       }
	   }
}
