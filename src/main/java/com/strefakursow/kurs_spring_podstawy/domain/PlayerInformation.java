package com.strefakursow.kurs_spring_podstawy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class PlayerInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int gold = 0;

    public PlayerInformation() {
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
