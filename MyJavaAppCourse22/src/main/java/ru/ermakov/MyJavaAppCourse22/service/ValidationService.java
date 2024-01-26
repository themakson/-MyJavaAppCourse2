package ru.ermakov.MyJavaAppCourse22.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.ermakov.MyJavaAppCourse22.exception.UnsupportedCodeException;
import ru.ermakov.MyJavaAppCourse22.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;
}
