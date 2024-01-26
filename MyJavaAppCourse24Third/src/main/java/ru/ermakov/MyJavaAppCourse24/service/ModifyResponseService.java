package ru.ermakov.MyJavaAppCourse24.service;

import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse24.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
