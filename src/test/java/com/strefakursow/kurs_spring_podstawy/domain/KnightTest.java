package com.strefakursow.kurs_spring_podstawy.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightTest {


    @Test
    public void testIfQuestMarkedAsStarted() {

        Knight knight = new Knight("Percival", 25);
        Quest quest = new Quest(1,"Testowe zdanie");

        knight.setQuest(quest);

        Assertions.assertTrue(knight.getQuest().isStarted());

    }
}
