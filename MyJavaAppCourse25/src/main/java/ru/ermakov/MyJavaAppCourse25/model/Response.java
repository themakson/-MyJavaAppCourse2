package ru.ermakov.MyJavaAppCourse25.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.ermakov.MyJavaAppCourse25.model.enums.Codes;
import ru.ermakov.MyJavaAppCourse25.model.enums.ErrorCodes;
import ru.ermakov.MyJavaAppCourse25.model.enums.ErrorMessages;

@Data
@Builder
@Slf4j
public class Response {
    /***
     * Ответ Сообщения
     */

    private String uid;
    /***
     * Уникальный идентификатор сообщения
     */
    private String operationUid;
    /***
     * Уникальный идентификатор операции
     */
    private String systemTime;
    /***
     * Время создания сообщения
     */
    private Codes code;
    /***
     * Код выполнения
     */
    private Double annualBonus;
    /***
     * Расчет годовой премии работника
     */
    private ErrorCodes errorCode;
    /***
     * Код ошибки
     */
    private ErrorMessages errorMessage;
    /***
     * Сообщение ошибки
     */





}
