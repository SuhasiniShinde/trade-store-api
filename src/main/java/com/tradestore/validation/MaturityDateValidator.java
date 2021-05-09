package com.tradestore.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by ssg228 on 9/5/21.
 */
public class MaturityDateValidator implements ConstraintValidator<ValidMaturityDate, Date> {
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null || date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(LocalDate.now())) {
            return false;
        } else {
            return true;
        }
    }
}
