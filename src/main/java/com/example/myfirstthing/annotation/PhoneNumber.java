package com.example.myfirstthing.annotation;

import com.example.myfirstthing.validation.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {PhoneNumberValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface PhoneNumber {

    String message() default "핸드폰번호를 다시 입력하세염";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String pattern() default "^(\\d{3}[- .]?){2}\\d{4}$";
}