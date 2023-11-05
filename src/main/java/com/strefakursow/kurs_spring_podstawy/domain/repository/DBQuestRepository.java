package com.strefakursow.kurs_spring_podstawy.domain.repository;

import com.strefakursow.kurs_spring_podstawy.domain.Quest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DBQuestRepository implements QuestRepository{

    @PersistenceContext
    private EntityManager entityManager;

    Random random = new Random();

    @Transactional
    public void createQuest(String description) {
        Quest quest = new Quest(description);

        entityManager.persist(quest);
    }

    @Transactional
    public void deleteQuest(Quest quest) {
        entityManager.remove(quest);
    }

    public List<Quest> getAll() {
        return entityManager.createQuery("from Quest", Quest.class).getResultList();
    }


    @Transactional
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


    @Transactional
    public void update(Quest quest) {
        entityManager.merge(quest);
    }

    public Quest getQuest(Integer id) {
        return entityManager.find(Quest.class, id);
    }
}
