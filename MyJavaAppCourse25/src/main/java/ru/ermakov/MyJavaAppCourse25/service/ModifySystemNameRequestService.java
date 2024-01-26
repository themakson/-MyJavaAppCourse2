package ru.ermakov.MyJavaAppCourse25.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ermakov.MyJavaAppCourse25.model.Request;
import ru.ermakov.MyJavaAppCourse25.model.enums.Systems;
import ru.ermakov.MyJavaAppCourse25.service.interfaces.ModifyRequestService;

@Service
public class ModifySystemNameRequestService  implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSystemName(Systems.valueOf("Service 1"));

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });


    }
}
