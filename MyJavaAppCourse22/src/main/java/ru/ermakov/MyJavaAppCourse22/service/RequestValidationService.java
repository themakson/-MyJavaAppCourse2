package ru.ermakov.MyJavaAppCourse22.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.ermakov.MyJavaAppCourse22.exception.UnsupportedCodeException;
import ru.ermakov.MyJavaAppCourse22.exception.ValidationFailedException;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
        if (bindingResult.getFieldValue("uid").equals("123")){
            throw new UnsupportedCodeException("UnsupportedCodeException");
        }
    }
}
