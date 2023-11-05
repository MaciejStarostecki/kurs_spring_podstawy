package com.strefakursow.kurs_spring_podstawy.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

@Entity
public class Knight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Range(min = 18, max = 60)
    private int age;
    private int level = 1;

    @OneToOne
    private Quest quest;


    public Knight() {
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Knight(String name, int age, Quest quest) {
        this.name = name;
        this.age = age;
        this.quest = quest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {

        if (quest!=null) {
            quest.setStarted(true);
        }

        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Rycerz " + name + ", liczy " + age + " wiosen. Ma za zadanie: " + quest + ".";
    }
}
