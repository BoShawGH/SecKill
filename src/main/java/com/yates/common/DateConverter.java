package com.yates.common;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

public class DateConverter{
    public static LocalDateTime convert(String s, String formatter) {
        LocalDateTime result = null;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        try {
            result = LocalDateTime.parse(s, dateTimeFormatter);
        } catch (UnsupportedTemporalTypeException ex) {
            ex.printStackTrace();
        }
        return result;
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
