package com.yates.common;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

public class DateConverter implements Converter<String, LocalDateTime> {
    public DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public LocalDateTime convert(String s) {
        try{
            return LocalDateTime.parse(s, dateTimeFormatter);
        }catch(UnsupportedTemporalTypeException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String date2String(LocalDateTime localDateTime){
        try{
            return localDateTime.format(dateTimeFormatter);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
