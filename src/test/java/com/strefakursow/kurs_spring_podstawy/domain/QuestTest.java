package com.strefakursow.kurs_spring_podstawy.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestTest {


    @Test
    public void settingStartedFlagToFalseShouldSetStartDate() {
        Quest quest = new Quest(1, "Testowe zadanie");

        quest.setStarted(true);

        Assertions.assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompleted() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        quest.lengthInSeconds = -60;
        Assertions.assertTrue(quest.isFinnished());
        Assertions.assertTrue(quest.isFinnished());
    }


    @Test
    public void questShouldNotBeCompleted() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        quest.lengthInSeconds = 20000;
        Assertions.assertFalse(quest.isFinnished());
        Assertions.assertFalse(quest.isFinnished());
    }
}
