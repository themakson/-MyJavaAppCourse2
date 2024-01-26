package ru.ermakov.MyJavaAppCourse25.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.ermakov.MyJavaAppCourse25.exception.UnsupportedCodeException;
import ru.ermakov.MyJavaAppCourse25.exception.ValidationFailedException;
import ru.ermakov.MyJavaAppCourse25.service.interfaces.ValidationService;

@Slf4j
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

