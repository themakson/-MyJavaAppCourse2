package ru.ermakov.MyJavaAppCourse25.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse25.model.Response;
import ru.ermakov.MyJavaAppCourse25.service.interfaces.ModifyResponseService;

import javax.validation.Valid;
import java.util.UUID;

@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService implements ModifyResponseService {

    @Override
    public Response modify(@Valid Response response) {

        UUID uuid = UUID.randomUUID();

        response.setOperationUid(uuid.toString());

        return response;
    }

}
