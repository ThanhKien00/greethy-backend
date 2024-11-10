package com.greethy.account.config.component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebInputException;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ObjectValidator {

    private final Validator validator;

    public <T> void validate(final T object) {
        var errors = validator.validate(object);
        if (!errors.isEmpty()) {
            String errorDetails = errors.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(", "));
            throw new ServerWebInputException(errorDetails);
        }
    }

}
