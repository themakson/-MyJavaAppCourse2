package ru.ermakov.MyJavaAppCourse26H2DB.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ermakov.MyJavaAppCourse26H2DB.entity.Card;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Slf4j
@Repository
public class CardDAOImpl implements CardDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Card> getAllCards() {

        Query query = entityManager.createQuery("from Card");
        List<Card> allCards = query.getResultList();
        log.info("getAllCards" + allCards);
        return allCards;
    }


    @Override
    public Card saveCard (Card card) {
        return entityManager.merge(card);
    }

    @Override
    public Card getCard(int id) {
        return entityManager.find(Card.class, id);
    }

    @Override
    public void deleteCard (int id) {
        Query query = entityManager.createQuery("delete from Card" + " where id =:cardId");
        query.setParameter("cardId", id);
        query.executeUpdate();
    }
}