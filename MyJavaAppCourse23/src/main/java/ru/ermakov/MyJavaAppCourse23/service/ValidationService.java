package ru.ermakov.MyJavaAppCourse23.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.ermakov.MyJavaAppCourse23.exception.UnsupportedCodeException;
import ru.ermakov.MyJavaAppCourse23.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;
}
