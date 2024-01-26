package ru.ermakov.MyJavaAppCourse25.service.interfaces;

import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse25.model.Request;

@Service
public interface ModifyRequestService {

    void modify(Request request);
}
