package com.yates.common;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

public class DateConverter{
    public static LocalDateTime convert(String s, String formatter) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        try{
            return LocalDateTime.parse(s, dateTimeFormatter);
        }catch(UnsupportedTemporalTypeException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static String date2String(LocalDateTime localDateTime, String formatter){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        try{
            return localDateTime.format(dateTimeFormatter);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
