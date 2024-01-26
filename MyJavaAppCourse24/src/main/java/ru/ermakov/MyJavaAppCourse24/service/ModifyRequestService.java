package ru.ermakov.MyJavaAppCourse24.service;

import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse24.model.Request;

@Service
public interface ModifyRequestService {

    void modify(Request request);
}
