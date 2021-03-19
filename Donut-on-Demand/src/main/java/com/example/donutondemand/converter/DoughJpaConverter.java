package com.example.donutondemand.converter;

import javax.persistence.AttributeConverter;

import com.example.donutondemand.model.Dough;

public class DoughJpaConverter implements AttributeConverter<Dough, String> {
	
   @Override
   public String convertToDatabaseColumn(Dough dough) {
       if (dough == null) {
           return null;
       }
       return dough.toString();
   }
 
   @Override
   public Dough convertToEntityAttribute(String string) {
       if (string == null) {
           return null;
       }
       try {
           return Dough.valueOf(string);
       } catch (IllegalArgumentException e) {
           return null;
       }
   }
	 
}
