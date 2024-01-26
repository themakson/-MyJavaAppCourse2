package ru.ermakov.MyJavaAppCourse26H2DB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ermakov.MyJavaAppCourse26H2DB.entity.Card;
import ru.ermakov.MyJavaAppCourse26H2DB.entity.Student;
import ru.ermakov.MyJavaAppCourse26H2DB.service.CardService;
import ru.ermakov.MyJavaAppCourse26H2DB.service.StudentService;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MyControllerCards {

    @Autowired
    private CardService cardService;

    @GetMapping("/cards")
    public List<Card> showAllCards(){
        List<Card> allCards = cardService.getAllCards();
        return allCards;
    }
    @GetMapping("/cards/{id}")
    public Card getCard(@PathVariable("id") int id){
        return cardService.getCard(id);
    }
    @PostMapping("/cards")
    public Card saveCard(@RequestBody Card card){
        return cardService.saveCard(card);
    }
    @PutMapping("/cards")
    public Card updateCard(@RequestBody Card card){
        cardService.saveCard(card);
        return card;
    }

    @DeleteMapping ("/cards/{id}")
    public void updateCard(@PathVariable("id") int id){
        cardService.deleteCard(id);
    }

}