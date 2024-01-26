package ru.ermakov.MyJavaAppCourse25.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse25.model.Response;
import ru.ermakov.MyJavaAppCourse25.service.interfaces.ModifyResponseService;
import ru.ermakov.MyJavaAppCourse25.util.DateTimeUtil;

import javax.validation.Valid;
import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public Response modify(@Valid Response response) {

        response.setSystemTime(DateTimeUtil.getCustomFormat()
                .format(new Date()));

        return response;
    }
}
