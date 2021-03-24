package com.example.donutondemand.converter;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeJpaConverter implements AttributeConverter<LocalTime, Integer>{

    @Override
    public Integer convertToDatabaseColumn(LocalTime localTime) {
        return (localTime == null ? null :  localTime.toSecondOfDay());
    }

    @Override
    public LocalTime convertToEntityAttribute(Integer secondOfDay) {
        return (secondOfDay == null ? null : LocalTime.ofSecondOfDay(secondOfDay)); 
    }

}