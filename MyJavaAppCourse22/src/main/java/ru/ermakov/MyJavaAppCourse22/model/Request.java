package ru.ermakov.MyJavaAppCourse22.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank(message = "Не заполнено поле UID")
    @Size(min = 1, max = 32, message = "Поле расчитано от 1 символа до 32")
    private String uid;

    @NotBlank(message = "Не заполнено поле operationUID")
    @Size(min = 1, max = 32, message = "Поле расчитано от 1 символа до 32")
    private String operationUid;

    private String systemName;

    @NotBlank(message = "Не заполнено поле systemTime")
    private String systemTime;

    private String source;

    @Min(value = 1, message = "Минимальное значение поля равно 1")
    @Max(value = 100000, message = "Максимальное значение поля равно 100000")
    private int communicationId;

    private int templateId;
    private int productCode;
    private int smsCode;

}
