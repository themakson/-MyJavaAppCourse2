package ru.ermakov.MyJavaAppCourse25.service.interfaces;

import ru.ermakov.MyJavaAppCourse25.model.Request;
import ru.ermakov.MyJavaAppCourse25.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface ResponseException {
    ResponseEntity<Response> ResponseExceptions(Request request, BindingResult bindingResult);
}