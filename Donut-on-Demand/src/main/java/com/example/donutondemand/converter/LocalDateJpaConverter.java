package com.example.donutondemand.converter;

import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateJpaConverter implements AttributeConverter<LocalDate, String>{
	@Override
    public String convertToDatabaseColumn(LocalDate date) {
        return date == null ? null : String.valueOf(date);
    }
 
    @Override
    public LocalDate convertToEntityAttribute(String sqlSring) {
        return sqlSring == null ? null : LocalDate.parse(sqlSring);
    }
}
