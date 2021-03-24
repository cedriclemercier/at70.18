package com.example.donutondemand.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.donutondemand.model.Status;

@Converter(autoApply=true)
public class StatusJpaConverter implements AttributeConverter<Status, String> {

	@Override
	public String convertToDatabaseColumn(Status status) {
		if (status == null) {
	         return null;
	    }
		return status.toString();
	}
	

	@Override
	public Status convertToEntityAttribute(String dbData) {
		if (dbData == null) {
	        return null;
	    }
	    try {
	        return Status.valueOf(dbData);
	    } catch (IllegalArgumentException e) {
	        return null;
	    }
	}
}

