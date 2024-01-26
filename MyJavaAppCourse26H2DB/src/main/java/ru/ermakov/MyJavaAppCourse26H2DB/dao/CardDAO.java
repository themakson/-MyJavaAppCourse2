package ru.ermakov.MyJavaAppCourse26H2DB.dao;

import org.springframework.stereotype.Repository;
import ru.ermakov.MyJavaAppCourse26H2DB.entity.Card;
import ru.ermakov.MyJavaAppCourse26H2DB.entity.Student;

import java.util.List;


@Repository
public interface CardDAO {



    List<Card> getAllCards();
    Card saveCard(Card card);
    Card getCard(int id);
    void deleteCard(int id);

}