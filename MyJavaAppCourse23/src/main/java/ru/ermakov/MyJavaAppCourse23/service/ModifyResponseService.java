package ru.ermakov.MyJavaAppCourse23.service;

import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse23.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
