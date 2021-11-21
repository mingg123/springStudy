package com.example.springvalidate.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.example.springvalidate.annotation.YearMonth;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("isValid message");
        // yyyyMM
        try {
            LocalDate localDate = LocalDate.parse(value + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
