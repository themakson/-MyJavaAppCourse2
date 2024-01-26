package ru.ermakov.MyJavaAppCourse25.service.interfaces;

import org.springframework.stereotype.Service;
import ru.ermakov.MyJavaAppCourse25.model.enums.Positions;

@Service
public interface AnnualBonusService {

    double calculate(Positions positions, double salary, double bonus, int workDays);


}
