package com.strefakursow.kurs_spring_podstawy.domain;

public class Knight {

    private String name = "Lancelot";
    private int age = 29;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Rycerz " + name + ", liczy " + age + " wiosen. Ma za zadanie: " + quest + ".";
    }
}
