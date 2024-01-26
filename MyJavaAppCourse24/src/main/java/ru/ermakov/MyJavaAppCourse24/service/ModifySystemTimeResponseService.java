package ru.ermakov.MyJavaAppCourse24.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse24.model.Response;
import ru.ermakov.MyJavaAppCourse24.util.DateTimeUtil;

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
