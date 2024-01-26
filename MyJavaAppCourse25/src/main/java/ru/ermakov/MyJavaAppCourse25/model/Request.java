package ru.ermakov.MyJavaAppCourse25.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import ru.ermakov.MyJavaAppCourse25.model.enums.Positions;
import ru.ermakov.MyJavaAppCourse25.model.enums.Systems;


import javax.validation.constraints.NotBlank;


@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Request {
    /***
     * Запрос Сообщения
     */

    @NotBlank(message = "Не заполнено поле UID")
    private String uid;
    /***
     * Уникальный идентификатор сообщения
     */
    private String operationUid;
    /***
     *Уникальный идентификатор операции
     */
    private Systems systemName;
    /***
     *Имя системы отправителя
     */
    private String systemTime;
    /***
     *Время создания сообщения
     */
    private String source;
    /***
     *Наименование ресурса
     */

    private Positions position;
    /***
     *Позиция работника в штате
     */
    private Double salary;
    /***
     * заработная плата работника
     */
    private Double bonus;
    /***
     * надбавка к зарплате
     */
    private Integer workDays;
    /***
     * кол-во отработанных дней
     */

    private Integer communicationId;
    /***
     * уникальный идентификатор коммуникации
     */
    private Integer templateId;
    /***
     * уникальный идентификатор шаблона
     */
    private Integer productCode;
    /***
     * код продукта
     */
    private Integer smsCode;
    /***
     * смс код
     */

    @Override
    public String toString(){
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", positions='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", workDays='" + workDays + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", smsCode='" + smsCode +
                '}';

    }

}
