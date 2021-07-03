package com.example.validation.validatior;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.validation.annotation.YearMonth;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String>{

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try{
			LocalDate localData = LocalDate.parse(value + "01", DateTimeFormatter.ofPattern(this.pattern));
		}catch(Exception e) {
			return false;
		}
		
		return true;
     
    }
    
}
