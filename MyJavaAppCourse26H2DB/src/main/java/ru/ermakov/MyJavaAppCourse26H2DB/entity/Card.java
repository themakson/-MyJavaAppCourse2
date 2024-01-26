package ru.ermakov.MyJavaAppCourse26H2DB.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "CARDS")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "race")
    private String race;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "cost")
    private int cost;

    public Card(){

    }

    public Card(String name, String race, String cardtype, String rarity, int cost){
        this.name = name;
        this.race = race;
        this.rarity = rarity;
        this.cost = cost;
    }
}