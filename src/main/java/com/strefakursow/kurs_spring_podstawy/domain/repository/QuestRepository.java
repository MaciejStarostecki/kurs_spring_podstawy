package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Quest;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {
    List<Quest> quests = new ArrayList<>();

    Random random = new Random();

    public void createQuest(String description) {
        quests.add(new Quest(description));
    }

    public List<Quest> getAll() {
        return quests;
    }

    @PostConstruct
    public void init() {

    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratować księżniczkę.");
        descriptions.add("Wziąć udział w turnieju.");
        descriptions.add("Pokonać bandę goblinów");
        descriptions.add("Zabić smoka burzy Veldorę.");

        String description = descriptions.get(random.nextInt(descriptions.size()));
        System.out.println("Zlecono zadanie: " + description);
        createQuest(description);
    }


    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
                '}';
    }
}
