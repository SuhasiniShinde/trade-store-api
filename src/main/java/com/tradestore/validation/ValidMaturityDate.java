package com.tradestore.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ssg228 on 9/5/21.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = MaturityDateValidator.class)
public @interface ValidMaturityDate {
    String message() default "{MaturityDate should not be less than todays date}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
