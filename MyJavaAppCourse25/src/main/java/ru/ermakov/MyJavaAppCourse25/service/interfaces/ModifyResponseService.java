package ru.ermakov.MyJavaAppCourse25.service.interfaces;

import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse25.model.Response;

import javax.validation.Valid;

@Service
public interface ModifyResponseService {

    Response modify(@Valid Response response);
}
