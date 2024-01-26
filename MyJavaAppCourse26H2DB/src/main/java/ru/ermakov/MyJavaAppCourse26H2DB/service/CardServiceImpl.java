package ru.ermakov.MyJavaAppCourse26H2DB.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ermakov.MyJavaAppCourse26H2DB.dao.CardDAO;
import ru.ermakov.MyJavaAppCourse26H2DB.entity.Card;

import java.util.List;


@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Override
    @Transactional
    public List<Card> getAllCards( ){
        return cardDAO.getAllCards();
    }

    @Override
    public Card getCard(int id) {
        return null;
    }

    @Override
    @Transactional
    public Card getStudent(int id){
        return cardDAO.getCard(id);
    }

    @Override
    @Transactional
    public Card saveCard(Card card) {
        return cardDAO.saveCard(card);
    }

    @Override
    @Transactional
    public void deleteCard(int id) {
        cardDAO.deleteCard(id);

    }

}