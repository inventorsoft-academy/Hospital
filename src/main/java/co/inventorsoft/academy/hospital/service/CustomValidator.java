package co.inventorsoft.academy.hospital.service;

import co.inventorsoft.academy.hospital.ui.ConsoleUserInterface;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class CustomValidator<T> {

    public boolean validate(T object, Validator validator) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        StringBuilder builder = new StringBuilder();
        for (ConstraintViolation<T> violation : constraintViolations) {
            builder.append("You enter in correct data in field: ")
                    .append(violation.getPropertyPath())
                    .append(" value:")
                    .append(violation.getInvalidValue())
                    .append(" message: ")
                    .append(violation.getMessage());
        }
        if (builder.length() <= 0) {
            ConsoleUserInterface.log.info("Validation OK");
            return true;
        } else {
            ConsoleUserInterface.log.info("Validation failed " + builder);
            return false;
        }
    }
}