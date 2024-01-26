package ru.ermakov.MyJavaAppCourse24.service;

import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse24.model.Response;

import javax.validation.Valid;

@Service
public interface ModifyResponseService {

    Response modify(@Valid Response response);
}
