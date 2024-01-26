package ru.ermakov.MyJavaAppCourse25.service.interfaces;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.ermakov.MyJavaAppCourse25.exception.UnsupportedCodeException;
import ru.ermakov.MyJavaAppCourse25.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;
}
