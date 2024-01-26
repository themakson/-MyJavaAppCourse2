package ru.ermakov.MyJavaAppCourse26H2DB.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ermakov.MyJavaAppCourse26H2DB.entity.Card;


import java.util.List;

@Service
public interface CardService {
    List<Card> getAllCards();
    Card getCard (int id);

    @Transactional
    Card getStudent(int id);

    Card saveCard(Card card);
    void deleteCard(int id);
}