package ru.ermakov.MyJavaAppCourse25.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ermakov.MyJavaAppCourse25.exception.UnsupportedCodeException;
import ru.ermakov.MyJavaAppCourse25.exception.ValidationFailedException;
import ru.ermakov.MyJavaAppCourse25.model.*;
import ru.ermakov.MyJavaAppCourse25.model.enums.Codes;
import ru.ermakov.MyJavaAppCourse25.model.enums.ErrorCodes;
import ru.ermakov.MyJavaAppCourse25.model.enums.ErrorMessages;
import ru.ermakov.MyJavaAppCourse25.service.interfaces.AnnualBonusService;
import ru.ermakov.MyJavaAppCourse25.service.interfaces.ModifyRequestService;
import ru.ermakov.MyJavaAppCourse25.service.interfaces.ModifyResponseService;
import ru.ermakov.MyJavaAppCourse25.service.interfaces.ValidationService;
import ru.ermakov.MyJavaAppCourse25.util.DateTimeUtil;


import javax.validation.Valid;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final AnnualBonusService annualBonusService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        ModifyRequestService modifyRequestService,
                        AnnualBonusService annualBonusService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.annualBonusService = annualBonusService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .annualBonus(annualBonusService.calculate(request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays()))
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATON_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("Вышло Validaton ислкючение: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (UnsupportedCodeException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.error("Вышло Unsupported ислкючение: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("Вышло неизвестное ислкючение: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);


        }
        modifyResponseService.modify(response);



        log.info("response: {}", response);
        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}

