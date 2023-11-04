package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Quest;
import com.strefakursow.kurs_spring_podstawy.utils.Id;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestRepository {

    Map<Integer, Quest> quests = new HashMap<>();

    Random random = new Random();

    public void createQuest(String description) {
        int newId = Id.getNewId(quests.keySet());
        quests.put(newId, new Quest(newId, description));
    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest.getId());
    }

    public List<Quest> getAll() {
        return new ArrayList<>(quests.values());
    }


    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratować księżniczkę.");
        descriptions.add("Wziąć udział w turnieju.");
        descriptions.add("Pokonać bandę goblinów");
        descriptions.add("Zabić smoka burzy Veldorę.");

        String description = descriptions.get(random.nextInt(descriptions.size()));
        createQuest(description);
    }


    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
                '}';
    }

    public void update(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }
}
