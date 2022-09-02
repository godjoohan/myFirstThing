package com.example.myfirstthing.validation;

import com.example.myfirstthing.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    private String pattern;


    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            Pattern pattern = Pattern.compile(this.pattern);
           //request body data User.phoneNumber = value
            Matcher matcher = pattern.matcher(value);
            if(matcher.matches()) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
